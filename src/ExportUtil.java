
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

// ---- OpenPDF (explicit, no wildcards) ----
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

// ---- Apache POI (explicit, no wildcards) ----
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.scene.Parent;
import javafx.scene.layout.Region;
import org.apache.pdfbox.pdmodel.common.PDRectangle;


public final class ExportUtil {
    private ExportUtil(){}

    /* ---------- SNAPSHOT ---------- */
    public static WritableImage snapshotHiDpi(Node node, double scale) {
        SnapshotParameters sp = new SnapshotParameters();
        sp.setFill(Color.WHITE);
        node.setScaleX(scale); node.setScaleY(scale);
        WritableImage wi = node.snapshot(sp, null);
        node.setScaleX(1); node.setScaleY(1);
        return wi;
    }

    private static File choose(Window owner, String title, String ext, String desc) {
        FileChooser fc = new FileChooser();
        fc.setTitle(title);
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter(desc, "*."+ext));
        return fc.showSaveDialog(owner);
    }

    /* ---------- PDF (snapshot) ---------- */
    public static void exportNodeToPdf(Window owner, Node node) {
        try {
            FileChooser fc = new FileChooser();
            fc.setTitle("Save Report as PDF");
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
            File file = fc.showSaveDialog(owner);
            if (file == null) return;

            // ---- Make a full-content image (handles ScrollPane) ----
            WritableImage fxImage;
            if (node instanceof ScrollPane sp) {
                Node content = sp.getContent();

                // Allow CSS/layout to settle when possible
                if (content instanceof Parent p) {
                    p.applyCss();
                    p.layout();
                }

                // Ensure we snapshot the whole virtual size for Regions
                if (content instanceof Region r) {
                    double w = r.prefWidth(-1);
                    double h = r.prefHeight(-1);
                    if (Double.isNaN(w) || w <= 0) w = Math.max(r.getWidth(), 1024);
                    if (Double.isNaN(h) || h <= 0) h = Math.max(r.getHeight(), 768);
                    // lock to pref size so snapshot contains everything
                    r.setMinSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);
                    r.resize(w, h);
                }

                SnapshotParameters params = new SnapshotParameters();
                params.setFill(Color.WHITE);
                fxImage = content.snapshot(params, null);
            } else {
                SnapshotParameters params = new SnapshotParameters();
                params.setFill(Color.WHITE);
                fxImage = node.snapshot(params, null);
            }

            BufferedImage img = SwingFXUtils.fromFXImage(fxImage, null);

            // ---- Build an A4 PDF, fit-to-width and paginate vertically ----
            try (PDDocument doc = new PDDocument()) {
//                PDRectangle pageSize = PDRectangle.A4;
                PDRectangle pageSize =
                     new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth());
                float pageW = pageSize.getWidth();
                float pageH = pageSize.getHeight();
                float margin = 36f;               // 0.5"
                float innerW = pageW - margin * 2;
                float innerH = pageH - margin * 2;

                // Scale to fit width, keep aspect
                float scale = innerW / img.getWidth();
                float scaledW = img.getWidth() * scale;
                float scaledPageSliceH = innerH;             // points
                int slicePxH = Math.max(1, Math.round(scaledPageSliceH / scale));  // pixels of source per page

                for (int y = 0; y < img.getHeight(); y += slicePxH) {
                    int h = Math.min(slicePxH, img.getHeight() - y);
                    BufferedImage slice = img.getSubimage(0, y, img.getWidth(), h);

                    PDPage page = new PDPage(pageSize);
                    doc.addPage(page);

                    PDImageXObject ximg = LosslessFactory.createFromImage(doc, slice);
                    try (PDPageContentStream cs = new PDPageContentStream(doc, page)) {
                        float drawW = scaledW;
                        float drawH = h * scale;
                        float x = (pageW - drawW) / 2f;
                        float yPt = pageH - margin - drawH; // top-aligned content
                        cs.drawImage(ximg, x, yPt, drawW, drawH);
                    }
                }

                doc.save(file);
            }

            showInfo("PDF Exported", "Saved:\n" + file.getAbsolutePath());
        } catch (Exception ex) {
            ex.printStackTrace();
            showError("Failed to export PDF: " + ex.getMessage());
        }
    }




    /* ---------- Excel (Hybrid: real table + chart images) ---------- */
    public static <T> void exportTableAndChartsToExcel(Window owner,
                                                       TableView<T> table,
                                                       java.util.List<Node> chartsToSnap,
                                                       String sheetName) {
        try {
            File out = choose(owner, "Save Excel", "xlsx", "Excel Workbook");
            if (out == null) return;

            try (XSSFWorkbook wb = new XSSFWorkbook();
                 FileOutputStream fos = new FileOutputStream(out)) {

                XSSFSheet sheet = wb.createSheet(sheetName != null ? sheetName : "Export");

                // Header style
                XSSFCellStyle header = wb.createCellStyle();
                Font hf = wb.createFont();
                hf.setBold(true);                   // <-- org.apache.poi.ss.usermodel.Font
                header.setFont(hf);

                int rowIdx = 0;

                // 1) Headers
                Row r0 = sheet.createRow(rowIdx++);
                for (int c = 0; c < table.getColumns().size(); c++) {
                    Cell cell = r0.createCell(c);
                    cell.setCellValue(table.getColumns().get(c).getText());
                    cell.setCellStyle(header);
                }

                // 2) Rows
                for (T item : table.getItems()) {
                    Row r = sheet.createRow(rowIdx++);
                    for (int c = 0; c < table.getColumns().size(); c++) {
                        @SuppressWarnings("unchecked")
                        TableColumn<T, ?> col = (TableColumn<T, ?>) table.getColumns().get(c);
                        Object v = col.getCellObservableValue(item) != null
                                ? col.getCellObservableValue(item).getValue()
                                : null;
                        Cell cell = r.createCell(c);
                        if (v instanceof Number n) {
                            cell.setCellValue(n.doubleValue());
                        } else {
                            cell.setCellValue(v != null ? v.toString() : "");
                        }
                    }
                }

                // Autosize
                for (int c = 0; c < table.getColumns().size(); c++) sheet.autoSizeColumn(c);

                // 3) Chart snapshots
                int chartStartRow = rowIdx + 2;
                for (Node node : chartsToSnap) {
                    addNodeImage(wb, sheet, node, 0, chartStartRow);
                    chartStartRow += 28; // spacing
                }

                wb.write(fos);
                ExportUtil.showInfo("Excel Exported", "Saved:\n" + out.getAbsolutePath());

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            showError("Failed to export Excel: " + ex.getMessage());
        }
    }

    private static void addNodeImage(XSSFWorkbook wb, XSSFSheet sheet, Node node, int col, int row) throws IOException {
        WritableImage wi = snapshotHiDpi(node, 2.0);
        BufferedImage bi = SwingFXUtils.fromFXImage(wi, null);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bi, "png", bos);

        int idx = wb.addPicture(bos.toByteArray(), Workbook.PICTURE_TYPE_PNG);
        Drawing<?> drawing = sheet.createDrawingPatriarch();
        CreationHelper helper = wb.getCreationHelper();
        ClientAnchor anchor = helper.createClientAnchor();
        anchor.setCol1(col);
        anchor.setRow1(row);
        XSSFPicture pict = (XSSFPicture) drawing.createPicture(anchor, idx);
        pict.resize();
    }
    
    public static void showInfo(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Export Failed");
        alert.setContentText(msg);
        alert.showAndWait();
    }

    // Charts-only Excel export (no table sheet content)
    public static void exportChartsToExcel(Window owner,
                                           java.util.List<Node> charts,
                                           String sheetName) {
        exportTableAndChartsToExcel(owner, new javafx.scene.control.TableView<>(), charts, sheetName);
    }

}
