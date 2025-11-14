/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
import com.itextpdf.text.Chunk;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.*;
import javafx.scene.image.Image;


import javafx.stage.FileChooser;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;
import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import javafx.beans.value.ChangeListener;
import javafx.embed.swing.SwingFXUtils;
import javafx.util.StringConverter;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// iText 5
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

// PDFBox
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.rendering.ImageType;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.file.StandardCopyOption;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ListChangeListener;
import javafx.css.PseudoClass;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseButton;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import org.mindrot.jbcrypt.BCrypt;

//campusNurse_fullName

/**
 * FXML Controller class
 *
 * @author User
 */
public class DASHBOARDController implements Initializable {

    @FXML
    private HBox filterField;
    @FXML
    private TextField filterField1;
    @FXML
    private Pane Dashboard_pane;
    @FXML
    private Pane StudentRecord_pane;
    @FXML
    private Pane StudentRecord_pane1;
    @FXML
    private Pane Consultations_pane;
    @FXML
    private BarChart<Number, String> barChart;
    @FXML
    private Pane Reports_pane;
    @FXML
    private Pane Inventory_pane;
    @FXML
    private HBox filterField_hbox;
    @FXML
    private TextField filterField_inventory; 
    @FXML 
    private Pane Notification_pane;
    @FXML
    private Pane VisitLog_pane;
    @FXML
    private Pane VisitLog_addpane;
    @FXML
    private TableView<Student> student_tv;
    @FXML
    private TableColumn<Student, String> id_col;
    @FXML
    private TableColumn<Student, String> lastName_col;
    @FXML
    private TableColumn<Student, String> firstName_col;
    @FXML
    private TableColumn<Student, String> middleName_col;
    @FXML
    private TableColumn<Student, String> course_col;
    @FXML
    private TableColumn<Student, String> yearLevel_col;
    @FXML
    private TableColumn<Student, String> gender_col;
    @FXML
    private TableColumn<Student, Integer> age_col;
    @FXML
    private TableColumn<Student, String> contact_col;
    @FXML
    private TableColumn<Student, Void> action_col;
    @FXML
    private Pane viewStudent_pane;
    @FXML
    private Label fullName_label;
    @FXML
    private Label idNumber_label;
    @FXML
    private ImageView image_imageView;
    @FXML
    private TextArea history_textArea;
    @FXML
    private TextField age_tf;
   
    @FXML
    private TextField birthplace_tf;
    
    @FXML
    private TextField civilStatus_tf;
    @FXML
    private TextField religion_tf;
    @FXML
    private TextField height_tf;
    @FXML
    private TextField weight_tf;
    @FXML
    private TextField contactNo_tf;
    @FXML
    private TextField email_tf;
    
    @FXML
    private TextField address_tf;
    @FXML
    private ToggleButton btnALL;
    @FXML
    private ToggleGroup courseFilter;
    @FXML
    private ToggleButton btnBSIT;
    @FXML
    private ToggleButton btn_BSFAS;
    @FXML
    private ToggleButton btnBIT;
    @FXML
    private ToggleGroup sideNav;
    @FXML
    private ComboBox<String> yearLevel_cb;
    
    
    @FXML
    private Pane HistoryForm_pane;
    @FXML
    private TextArea pastIllnesses_ta;
    @FXML
    private TextArea allergies_ta;
    @FXML
    private TextArea medications_ta;
    @FXML
    private TextArea immunizations_ta;
    @FXML
    private TextArea familyHistory_ta;
    
    @FXML
    private ToggleButton sidebtn_dashboard;
    @FXML
    private ToggleButton sidebtn_addStudent;
    @FXML
    private ToggleButton sidebtn_calendar;
    @FXML
    private ToggleButton sidebtn_settings;
    
    @FXML
    private Pane AddStudent_pane;
    @FXML
    private TextField addStudent_idNum_tf;
    @FXML
    private TextField addStudent_lastName_tf;
    @FXML
    private TextField addStudent_firstName_tf;
    @FXML
    private TextField addStudent_middleName_tf;
    @FXML
    private TextField addStudent_age_tf;
    @FXML
    private TextField addStudent_address_tf;
    @FXML
    private TextField addStudent_contact_tf;
    @FXML
    private TextField addStudent_civil_tf;
    @FXML
    private TextField addStudent_email_tf;
    @FXML
    private ComboBox<String> addStudent_course_cb;
    @FXML
    private ComboBox<String> addStudent_year_cb;
    @FXML
    private ComboBox<String> addStudent_gender_cb;
    @FXML
    private DatePicker addStudent_birthday_dp;
    @FXML
    private TextField addStudent_birthplace_tf;
    @FXML
    private TextField addStudent_height_tf;
    @FXML
    private TextField addStudent_weight_tf;
    @FXML
    private TextField addStudent_religion_tf;
    @FXML
    private ImageView addStudent_imageview;
    @FXML
    private TableView<Consultation> consultation_tv;
    @FXML
    private TableColumn<Consultation, String> consultationName_col;
    @FXML
    private TableColumn<Consultation, String> consultationDate_col;
    @FXML
    private TableColumn<Consultation, String> consultationReason_col;
    @FXML
    private TableColumn<Consultation, Void> consultationAction_col;
    @FXML
    private Pane AddEditConsultation_pane;
    @FXML
    private TextField consultationReason_tf;
    @FXML
    private TextField consultationTemperature_tf;
    @FXML
    private TextField consultationDiagnosis_tf;
    @FXML
    private TextField consultationBP_tf;
    @FXML
    private Label BPstatus_label;
    @FXML
    private TextField consultationPR_tf;
    @FXML
    private Label PRstatus_label;
    @FXML
    private TextField consultationRR_tf;
    @FXML
    private Label RRstatus_label;
    @FXML
    private TextField consultationTreatment_tf;
    @FXML
    private TextField consultationReferral_tf;
    @FXML
    private TextField consultationDate_tf;
    @FXML
    private Button saveBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button deleteBtn;
    
    @FXML
    private TableView<Inventory> inventory_tv;
    @FXML
    private TableColumn<Inventory, Number> inventoryCode_col; 
    @FXML
    private TableColumn<Inventory, String> inventoryName_col;
    @FXML
    private TableColumn<Inventory, String> inventoryType_col;
    @FXML
    private TableColumn<Inventory, Number> inventoryQuantity_col;
    @FXML
    private TableColumn<Inventory, String> inventoryUnit_col;
    @FXML
    private TableColumn<Inventory, LocalDate> inventoryExpiry_col;
    @FXML
    private TableColumn<Inventory, String> inventoryStatus_col;
    @FXML
    private TableColumn<Inventory, Void> inventoryAction_col;
    @FXML
    private TableColumn<Inventory, Number> inventoryUsed_col;
    @FXML
    private TableColumn<Inventory, Number> inventoryBalance_col;

    
    @FXML
    private Pane AddEdit_InventoryPane;
    @FXML
    private TextField inventoryItem_tf;
    @FXML
    private TextField inventoryType_tf;
    @FXML
    private TextField inventoryExpiry_tf;
    @FXML
    private TextField inventoryQuantity_tf;
    @FXML
    private TextField inventoryUnit_tf;
    
    @FXML
    private TableView<VisitLogRow> visitLog_tv;
    @FXML
    private TableColumn<VisitLogRow, LocalDate> visitDate_col;
    @FXML
    private TableColumn<VisitLogRow, String> visitName_col;
    @FXML
    private TableColumn<VisitLogRow, String> visitReason_col;
    @FXML
    private TextField visitDate_tf;
//    private TextField visitName_tf;
    @FXML
    private TextField visitReason_tf;
    
    @FXML
    private Label TotalStudents_label;
    @FXML
    private Label TodayVisit_label;
    @FXML
    private Label TotalMedSupplies_label;
    
    // ====================== FXML FIELDS (MED CERTIFICATE) =================
    @FXML private BorderPane medicalCertificate_pane;  // form + records (main pane)
    @FXML private BorderPane medicalCertPreview;       // preview pane

    // Left side (records)
    @FXML private TextField search_tf;
    @FXML private TableView<CertRow> certificates_tv;
    @FXML private TableColumn<CertRow, String> colStudent;
    @FXML private TableColumn<CertRow, String> colDate;
    @FXML private TableColumn<CertRow, String> colCode;
    @FXML private TableColumn<CertRow, String> colStatus;
    @FXML private TableColumn<CertRow, HBox>   colAction;

    // Right side (form)
private TextField student_tf;
    @FXML private DatePicker date_dp;
    @FXML private TextField activity_tf;
    @FXML private ComboBox<String> status_cb;
    @FXML private TextArea remarks_ta;
    @FXML private TextField bp_tf;
    @FXML private TextField temp_tf;
    @FXML private TextField pulse_tf;
    @FXML private TextField resp_tf;

    // Preview area (inside medicalCertPreview)
    @FXML private ImageView imageView;
    @FXML private Spinner<Integer> pageSpinner;
    @FXML private ScrollPane scroll;

    @FXML
    private ToggleButton sidebtn_MedicalCertificate;
    
    @FXML
    private Label student_lbl;
    @FXML
    private Label studentID_lbl;
    @FXML
    private Label vitalsSource_lbl;
    

    
    @FXML
    private BorderPane rootBorder;
    @FXML
    private VBox leftBar;
    @FXML
    private DatePicker miniDatePicker;
    @FXML
    private Button btnAdd;
    @FXML
    private ListView<CalendarItem> upcomingList;
    @FXML
    private HBox topBar;
    @FXML
    private Button btnPrev;
    @FXML
    private Label lblMonthYear;
    @FXML
    private Button btnNext;
    @FXML
    private Button btnToday;
    @FXML
    private ToggleButton tglMonth;
    @FXML
    private ToggleGroup viewToggleGroup;
    @FXML
    private ToggleButton tglWeek;
    @FXML
    private ToggleButton tglList;
    @FXML
    private ToggleButton fltAll;
    @FXML
    private ToggleGroup filterToggleGroup;
    @FXML
    private ToggleButton fltNotes;
    @FXML
    private ToggleButton fltTasks;
    @FXML
    private ToggleButton fltEvents;
    @FXML
    private ToggleButton fltInventory;
    @FXML
    private GridPane weekdayHeader;
    @FXML
    private AnchorPane calendar_pane;
    @FXML
    private GridPane monthGrid;
    @FXML
    private ScrollPane listViewWrapper;
    @FXML
    private VBox listViewVBox;
    
    @FXML
    private StackPane calendarStack;
     
    @FXML
    private GridPane weekHeader;
    @FXML
    private GridPane weekGrid;
    
    @FXML
    private VBox legendBox;
    
    
    @FXML
    private ImageView AdminPhoto;
    @FXML
    private Label campusNurse_fullName;
    @FXML
    private ImageView AdminPhoto_edit;
    @FXML
    private TextField ADMINfirstName_tf;
    @FXML
    private TextField ADMINlastName_tf;
    @FXML
    private TextField ADMINusername_tf;
    @FXML
    private PasswordField current_pw;
    @FXML
    private PasswordField new_pw;
    @FXML
    private PasswordField confirm_pw;
    @FXML
    private TextField current_pw_tf;
    @FXML
    private TextField new_pw_tf;
    @FXML
    private TextField confirm_pw_tf;
    @FXML
    private ImageView currentPass_show;
    @FXML
    private ImageView newPass_show;
    @FXML
    private ImageView confirmPass_show;
    @FXML
    private GridPane Password_gridpane;
    @FXML
    private GridPane Profile_gridpane;

    @FXML
    private ToggleButton toggleProfile;
    @FXML
    private ToggleButton togglePassword;
    @FXML
    private TextField ADMINcontactNumber_tf;
    @FXML
    private AnchorPane settings_pane;
    
    @FXML
    private DatePicker birthday_dp;
    @FXML
    private ComboBox<String> course_cb;
    @FXML
    private ComboBox<String> gender_cb;
    @FXML
    private ComboBox<String> DETAILSyearLevel_cb;
    @FXML
    private ComboBox<String> DETAILSstatus_cb;
    @FXML
    private Button saveStudent_btn_id;
    @FXML
    private Button cancelStudent_btn_id;

    @FXML
    private TextField consultationName_tf;
    @FXML
    private Hyperlink pickStudent_hl;

    @FXML
    private TableView<RxRow> rxTable;
    @FXML
    private TableColumn<RxRow, String> rxColMed;
    @FXML
    private TableColumn<RxRow, Integer> rxColQty;
    @FXML
    private TableColumn<RxRow, String> rxColUnit;
    @FXML
    private TableColumn<RxRow, Void> rxColAction;
    @FXML
    private Button rxAdd_btn;
    @FXML
    private Button rxClear_btn;
    @FXML
    private Label rxHint_lbl;
    
    @FXML
    private TextField visitName_tf;
    @FXML
    private Hyperlink visitLog_searchStudent_hl;
    
    @FXML
    private TabPane invTabPane;
    @FXML
    private TextField toolSearch_tf;
    @FXML
    private Button addTool_btn;
    @FXML
    private TableView<InventoryTool> tools_tv;
    @FXML
    private TableColumn<InventoryTool, String> inventoryTools_code; // for id = change to Number
    @FXML
    private TableColumn<InventoryTool, String> inventoryTools_name;
    @FXML
    private TableColumn<InventoryTool, String> inventoryTools_category;
    @FXML
    private TableColumn<InventoryTool, Number> inventoryTools_quantity;
    @FXML
    private TableColumn<InventoryTool, String> inventoryTools_unit;
    @FXML
    private TableColumn<InventoryTool, String> inventoryTools_location;
    @FXML
    private TableColumn<InventoryTool, String> inventoryTools_status;
    @FXML
    private TableColumn<InventoryTool, String> inventoryTools_remarks;
    @FXML
    private TableColumn<InventoryTool, Void> inventoryTools_action;
    @FXML
    private StackPane AddEdit_ToolPane;
    @FXML
    private TextField toolCode_tf;
    @FXML
    private TextField toolName_tf;
    @FXML
    private ComboBox<String> toolCategory_cb;
    @FXML
    private ComboBox<String> toolLocation_cb;
    @FXML
    private TextField toolQty_tf;
    @FXML
    private TextField toolUnit_tf;
    @FXML
    private ComboBox<String> toolStatus_cb;
    @FXML
    private DatePicker toolAcquired_dp;
    @FXML
    private TextField toolCost_tf;
    @FXML
    private TextArea toolRemarks_ta;
    @FXML
    private Label toolFormHint_lbl;
    @FXML
    private Button toolSave_btn;
    @FXML
    private Label toolFormTitle_lbl;
    
    @FXML
    private ToggleButton all_tb;
    @FXML
    private ToggleButton unread_tb;
    @FXML
    private ToggleButton inv_tb;
    @FXML
    private ToggleButton cal_tb;
    @FXML
    private Button markAllRead_btn;
    @FXML
    private Button clearRead_btn;
    @FXML
    private ListView<Notification> notif_lv;
    @FXML
    private ToggleGroup notifTOGGLE;
    @FXML
    private VBox SIDENAV_VBOX;
    @FXML
    private StackPane notifBellStack;
    @FXML
    private ImageView notifBellImage;
    @FXML
    private StackPane notifBadgePane;
    @FXML
    private Circle notifBadgeCircle;
    @FXML
    private Label notifBadgeLabel;
    
    
    @FXML
    private TabPane reportsTabPane;
    @FXML
    private BorderPane overviewRoot;
    @FXML
    private Button ovwExportExcelBtn;
    @FXML
    private Button ovwExportPdfBtn;
    @FXML
    private Label kpiConsultationsToday;
    @FXML
    private Label kpiConsultationsMonth;
    @FXML
    private Label kpiActiveStudents;
    @FXML
    private Label kpiMedsUsed;
    @FXML
    private BarChart<?, ?> overviewConsultationsPerMonthChart;
    @FXML
    private PieChart overviewTopComplaintsPie;
    @FXML
    private PieChart overviewBpStatusPie;
    @FXML
    private LineChart<?, ?> overviewMedsUsageTrend;
    @FXML
    private DatePicker consFromDate;
    @FXML
    private DatePicker consToDate;
    @FXML
    private Button consApplyFilterBtn;
//    private TextField consSearchField;
//    private Button consClearBtn;
    @FXML
    private Button consExportPdfBtn;
    @FXML
    private Button consExportExcelBtn;
//    private TableView<?> dailyConsultationsTable;
//    private TableColumn<?, ?> colConsDate;
//    private TableColumn<?, ?> colConsStudent;
//    private TableColumn<?, ?> colConsReason;
//    private TableColumn<?, ?> colConsDiagnosis;
//    private TableColumn<?, ?> colConsBP;
//    private TableColumn<?, ?> colConsTemp;
    @FXML
    private BarChart<?, ?> monthlyConsultationsBar;
    @FXML
    private PieChart topComplaintsPie;
    @FXML
    private PieChart bpStatusPie;
    @FXML
    private DatePicker visFromDate;
    @FXML
    private DatePicker visToDate;
    @FXML
    private Button visApplyFilterBtn;
    @FXML
    private ComboBox<?> visGroupByBox;
    @FXML
    private Button visExportPdfBtn;
    @FXML
    private Button visExportExcelBtn;
    @FXML
    private TableView<?> visitsByDateTable;
    @FXML
    private TableColumn<?, ?> colVisitDate;
    @FXML
    private TableColumn<?, ?> colVisitStudent;
    @FXML
    private TableColumn<?, ?> colVisitReason;
    @FXML
    private BarChart<?, ?> visitsByYearLevelBar;
    @FXML
    private BarChart<?, ?> visitsByCourseBar;
    @FXML
    private TextField invSearchField;
    @FXML
    private Button invShowLowStockBtn;
    @FXML
    private Button invShowExpiringBtn;
    @FXML
    private Button invExportPdfBtn;
    @FXML
    private Button invExportExcelBtn;
    @FXML
    private TableView<?> medicineUsageTable;
    @FXML
    private TableColumn<?, ?> colInvItem;
    @FXML
    private TableColumn<?, ?> colInvUsed;
    @FXML
    private TableColumn<?, ?> colInvBalance;
    @FXML
    private TableColumn<?, ?> colInvExpiry;
    @FXML
    private LineChart<?, ?> itemUsageTrendChart;
    @FXML
    private TableView<?> lowStockTable;
    @FXML
    private TableColumn<?, ?> colLowItem;
    @FXML
    private TableColumn<?, ?> colLowQty;
    @FXML
    private TableColumn<?, ?> colLowStatus;
    @FXML
    private TableColumn<?, ?> colLowExpiry;
    @FXML
    private BorderPane consultationsRoot;
    @FXML
    private BorderPane visitsRoot;
    @FXML
    private BorderPane inventoryRoot;
    @FXML
    private ScrollPane consultationsScrollPane;
    @FXML
    private ScrollPane visitsScrollPane;
    @FXML
    private ScrollPane inventoryScrollPane;
    @FXML
    private AnchorPane consTODAYkpi;
    @FXML
    private AnchorPane consMONTHkpi;
    @FXML
    private AnchorPane consSTUDENTSkpi;
    @FXML
    private AnchorPane consMEDICINESkpi;

    
    @FXML
    private void logOut_btn(ActionEvent event) {
        // 1) Confirm
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Log out");
        a.setHeaderText("Sign out of School Clinic?");
        a.setContentText("You will be returned to the login screen.");
        ButtonType logout = new ButtonType("Log out", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        a.getButtonTypes().setAll(cancel, logout);

        Optional<ButtonType> res = a.showAndWait();
        if (res.isEmpty() || res.get() != logout) return;

        // 2) (Optional) stop background tasks / schedulers here
        // notifScheduler.shutdownNow();
        // anyTimeline.stop(); etc.
        notifExec.shutdownNow();

        // 3) Clear session
        Session.userId = 0;
        Session.fullName = null;

        // 4) Load login scene and swap it into this same Stage
        try {
            // Adjust path if needed (use absolute like "/clinic/ui/login1.fxml" if in resources root)
            Parent loginRoot = FXMLLoader.load(getClass().getResource("login1.fxml"));
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.getScene().getStylesheets().add(getClass().getResource("login.css").toExternalForm());
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/image/stethoscope.png")));
            stage.setScene(new Scene(loginRoot));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
            // Fallback: close stage if loading fails
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }
    }

    


    //for adding new consultation
    //for adding history during adding a new student
    //1. currentStudentId - already in controller
    //2. 
        private enum HistoryMode { EDIT_EXISTING, ADD_FOR_NEW_STUDENT }
        private HistoryMode historyMode = HistoryMode.EDIT_EXISTING;

        // Hold staged history while adding a brand-new student (no student_id yet)
        private StudentHistory draftHistoryForNewStudent = null;
    
    private final ObservableList<Student> students = FXCollections.observableArrayList();
    
    private FilteredList<Student> filtered;
    
    // state for current view/edit (STUDENT RECORD)
    private Integer currentStudentId = null;
    private String  pendingPhotoPath = null; //  store a path (varchar)

    
    private final StudentHistoryDAO historyDAO = new StudentHistoryDAO();
    
    int addStudent_sideNav = 0;
    
    // --- Add Student (photo staging) ---
    private String pendingStudentPhotoPath = null;   // absolute path of chosen file (not yet copied)
    private static final String STUDENT_IMG_DIR = System.getProperty("user.home")
            + File.separator + "AppData" + File.separator + "Roaming"
            + File.separator + "SchoolClinic" + File.separator + "students";
    
    // ============================== CONSULTATION: Controller State ==============================
    // Table backing list
    private final ObservableList<Consultation> consultations = FXCollections.observableArrayList();

    // If null → adding, otherwise editing an existing consultation
    private Integer currentConsultationId = null;

    // Convenience: the currently selected Consultation in the table (when viewing/editing)
    private Consultation currentSelected = null;

    // The student chosen via the picker for the consultation form.
    // We keep both id and display name so the TextField is read-only but we still have the id.
    private Integer currentConsultationStudentId = null;
    private String  currentConsultationStudentName = null;

    // Date format used by the date TextField
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        //private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    // ======================= MEDICINES DISPENSED (Consultation form) =======================
    // Backing list for the Rx table
    private final ObservableList<RxRow> rxItems = FXCollections.observableArrayList();
    // Read-only student identity for the current form (set by StudentPicker dialog)
//    private Integer currentConsultationStudentId = null;
//    private String  currentConsultationStudentName = null;
    private String  currentConsultationStudentIdNumber = null; // NEW: school-issued id_number

    
    ////////////////////////////////////////////////////////////////////////////inventory
    private ObservableList<Inventory> data; 
        // internal state
    private boolean isEditMode = false;
    private Inventory editing = null;
     
    // --- keep these fields ---
    private final ObservableList<Inventory> inventoryMaster = FXCollections.observableArrayList();
    private FilteredList<Inventory> inventoryFiltered;
    private SortedList<Inventory> inventorySorted;
    
    //////////////////// TOOLS INVENTORY //////////////////////////////
    private javafx.collections.ObservableList<InventoryTool> toolData;
    private javafx.collections.transformation.FilteredList<InventoryTool> toolFiltered;
    private javafx.collections.transformation.SortedList<InventoryTool> toolSorted;

    // Backing lists / state
    private final ObservableList<InventoryTool> toolsMaster = FXCollections.observableArrayList();
    private FilteredList<InventoryTool> toolsFiltered;
    private SortedList<InventoryTool>   toolsSorted;

    // Preset options — tweak to taste
    private final ObservableList<String> CATEGORY_OPTIONS = FXCollections.observableArrayList(
            "Diagnostics", "Treatment Equipment", "Emergency Supply", "Mobility Aid",
            "Measurement", "Furniture", "PPE", "Miscellaneous"
    );
    private final ObservableList<String> LOCATION_OPTIONS = FXCollections.observableArrayList(
            "Clinic Room", "Treatment Room", "Storage Room", "Front Desk",
            "Nurse Station Drawer", "Equipment Cabinet", "Clinic Corner Shelf"
    );
    private final ObservableList<String> CONDITION_OPTIONS = FXCollections.observableArrayList(
            "good", "needs repair", "under repair", "decommissioned", "missing"
    );

    // Track whether we’re adding or editing
    private InventoryTool editingTool = null;   // null = Add, non-null = Edit

//    //visit log
//    private javafx.collections.ObservableList<StudentOption> studentOptions;
//    private FilteredList<StudentOption> studentFiltered;
//    private boolean suppressEditorEvents = false;
    // ====================== VISIT LOG: controller state ======================
    private ObservableList<VisitLogRow> rows;

    // The picked student for the “Add Visit” form (TextField + hyperlink)
    private Integer visitAdd_studentId = null;     // students.student_id (DB key)
    private String  visitAdd_fullName  = null;     // for table display
    private String  visitAdd_idNumber  = null;     // students.id_number (school-issued)

    
    // ============================ STATE / PREVIEW (MED CERT) ==============================
    private int currentStudentIdMEDCERT = -1;    // currently selected student
    private File lastGeneratedPdf = null;        // last generated PDF path

    // Single set of PDFBox preview objects (NO duplicates)
    private PDDocument doc = null;
    private PDFRenderer renderer = null;
    private int pageCount = 1;
    private float zoom = 1.25f; // 1.0 ~ 96 dpi baseline
    
    // Track which student's vitals are currently shown
    private Integer lastVitalsStudentId = null;
    // Track if the nurse has typed in any vitals for the current student
    private boolean vitalsUserEdited = false;
    
    // ============================== UTILITIES (MED CERT) ==================================
    private boolean isEmpty(String s){ return s==null || s.trim().isEmpty(); }
    private String emptyToNull(String s){ return isEmpty(s) ? null : s.trim(); }
    private String emptyToNA(String s){ return isEmpty(s) ? "N/A" : s.trim(); }
    private void alertInfo(String m){ new Alert(Alert.AlertType.INFORMATION,m).showAndWait(); }
    private void alertError(String m){ new Alert(Alert.AlertType.ERROR,m).showAndWait(); }

    private void showFormPane(){
        medicalCertificate_pane.setVisible(true);
        medicalCertificate_pane.setManaged(true);
        medicalCertPreview.setVisible(false);
        medicalCertPreview.setManaged(false);
    }
    private void showPreviewPane(){
        medicalCertificate_pane.setVisible(false);
        medicalCertificate_pane.setManaged(false);
        medicalCertPreview.setVisible(true);
        medicalCertPreview.setManaged(true);
    }
    
    // wrap the ImageView so ScrollPane doesn't resize it
    private Group imageGroup;
    private boolean fitMode = false; // when true, re-fit on viewport resize

    //CALENDAR
    // ========= CALENDAR STATE (keep only these) =========
    private final List<DayCell> cells = new ArrayList<>(42);
    private CalendarDao dao;

    private enum ViewMode { MONTH, WEEK, LIST }
    private ViewMode viewMode = ViewMode.MONTH;          // which main view is shown

    private YearMonth visibleMonth = YearMonth.now();    // month anchor for MONTH view
    private LocalDate weekStart = LocalDate.now()
            .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)); // week anchor for WEEK view

    // Hover “peek” overlay (shared for all day cells)
    private final Pane peekOverlay = new Pane();
    private final VBox peekCard = new VBox(8);
    private final PauseTransition hideDelay = new PauseTransition(Duration.millis(120));
    
    //SETTINGS
    private int currentUserId = 1;            // set this at login
    private String origFirst, origLast, origUser, origPhotoPath, origContact;
    private File stagedPhoto = null;          // photo chosen but not saved
    private final String APP_IMG_DIR = System.getProperty("user.home") + File.separator
            + "AppData" + File.separator + "Roaming" + File.separator
            + "SchoolClinic" + File.separator + "profiles";

    private final UserDAO userDao = new UserDAO();
    
    // keep the currentUserId, orig* vars, etc.
    private String adminImagePath = null;   // holds the current admin photo path from DB

    //NOTIFICATIONS ON DASHBOARD
     // --- backing lists ---
    private final ObservableList<Notification> notifMaster   = FXCollections.observableArrayList();
    private FilteredList<Notification>          notifFiltered;
    private SortedList<Notification>            notifSorted;
    
    // CSS pseudo-class for unread cells (used by notifications.css)
    private static final PseudoClass PC_UNREAD = PseudoClass.getPseudoClass("unread");

    // helper internal property
    private final IntegerProperty unreadCount = new SimpleIntegerProperty(0);
    
    // add:
    private FilteredList<Notification> unreadFiltered;
    private ScheduledExecutorService notifScheduler;   // optional periodic refresh
    
    // --- Notifications instant refresh support ---
    private final java.util.concurrent.ExecutorService notifExec =
            java.util.concurrent.Executors.newSingleThreadExecutor(r -> {
                Thread t = new Thread(r, "notif-now");
                t.setDaemon(true);
                return t;
            });

    private final java.util.concurrent.atomic.AtomicBoolean notifRefreshInFlight =
        new java.util.concurrent.atomic.AtomicBoolean(false);

    // date creation format in each notification
    private static final DateTimeFormatter DISPLAY_FMT =
        DateTimeFormatter.ofPattern("MMM dd, yyyy • hh:mm a");
    
    //REPORTS
     // Data stores (typed)
    private final ObservableList<ConsRow> consRows = FXCollections.observableArrayList();
    private final ObservableList<VisitRow> visitRows = FXCollections.observableArrayList();
    private final ObservableList<MedUsageRow> usageRows = FXCollections.observableArrayList();
    private final ObservableList<MedUsageRow> lowRows   = FXCollections.observableArrayList();

//    private final ReportsDAO dao = new ReportsDAO();
    private final ReportsDAO reportsDAO = new ReportsDAO();

    private Window getWindow() { return reportsTabPane.getScene().getWindow(); }



    ////////////////////////////////////////////////////////////////////////////SIDE NAVIGATION
    @FXML
    private void dashboard_sideNav(ActionEvent event) {
        StudentRecord_pane.setVisible(false);
        StudentRecord_pane1.setVisible(false);
        Consultations_pane.setVisible(false);
        Reports_pane.setVisible(false);
        Inventory_pane.setVisible(false);
        VisitLog_pane.setVisible(false);
        Notification_pane.setVisible(false);
        AddStudent_pane.setVisible(false);
        medicalCertificate_pane.setVisible(false);
        calendar_pane.setVisible(false);
        settings_pane.setVisible(false);
        
        Dashboard_pane.setVisible(true);
    }
    
    @FXML
    private void AddStudent_sideNav(ActionEvent event) {
        setCircularImage(addStudent_imageview, defaultStudentImage(), 80);
        addStudent_sideNav = 1;
        
        Dashboard_pane.setVisible(false);
        StudentRecord_pane.setVisible(false);
        StudentRecord_pane1.setVisible(false);
        Consultations_pane.setVisible(false);
        Reports_pane.setVisible(false);
        Inventory_pane.setVisible(false);
        VisitLog_pane.setVisible(false);
        Notification_pane.setVisible(false);
        medicalCertificate_pane.setVisible(false);
        calendar_pane.setVisible(false);
        settings_pane.setVisible(false);
        
        AddStudent_pane.setVisible(true);
        AddStudent_pane.toFront();
    }
    
     @FXML
    private void MedicalCertificate_sideNav(ActionEvent event) {
        StudentRecord_pane.setVisible(false);
        StudentRecord_pane1.setVisible(false);
        Consultations_pane.setVisible(false);
        Reports_pane.setVisible(false);
        Inventory_pane.setVisible(false);
        VisitLog_pane.setVisible(false);
        Notification_pane.setVisible(false);
        AddStudent_pane.setVisible(false);
        Dashboard_pane.setVisible(false);
        calendar_pane.setVisible(false);
        settings_pane.setVisible(false);
        
        medicalCertificate_pane.setVisible(true);
    }
    
    @FXML
    private void calendar_sideNav(ActionEvent event) {
        Dashboard_pane.setVisible(false);
        StudentRecord_pane.setVisible(false);
        StudentRecord_pane1.setVisible(false);
        Consultations_pane.setVisible(false);
        Reports_pane.setVisible(false);
        Inventory_pane.setVisible(false);
        VisitLog_pane.setVisible(false);
        Notification_pane.setVisible(false);
        AddStudent_pane.setVisible(false);
        medicalCertificate_pane.setVisible(false);
        settings_pane.setVisible(false);
        
        calendar_pane.setVisible(true);
        
    }
    
    @FXML
    private void settings_sideNav(ActionEvent event) {
        Dashboard_pane.setVisible(false);
        StudentRecord_pane.setVisible(false);
        StudentRecord_pane1.setVisible(false);
        Consultations_pane.setVisible(false);
        Reports_pane.setVisible(false);
        Inventory_pane.setVisible(false);
        VisitLog_pane.setVisible(false);
        Notification_pane.setVisible(false);
        AddStudent_pane.setVisible(false);
        medicalCertificate_pane.setVisible(false);
        calendar_pane.setVisible(false);
        
        settings_pane.setVisible(true);
    }
    
    @FXML
    private void backButton(MouseEvent event) {
        Dashboard_pane.setVisible(true);
        
         Dashboard_pane.setDisable(false);
        StudentRecord_pane.setVisible(false);
        StudentRecord_pane1.setVisible(false);
        Consultations_pane.setVisible(false);
        Reports_pane.setVisible(false);
        Inventory_pane.setVisible(false);
        VisitLog_pane.setVisible(false);
        Notification_pane.setVisible(false);
        medicalCertificate_pane.setVisible(false);
        calendar_pane.setVisible(false);
        settings_pane.setVisible(false);
        
        SIDENAV_VBOX.setDisable(false);
    }

    ////////////////////////////////////////////////////////////////////////////end side navigation
    
    ////////////////////////////////////////////////////////////////////////////DASHBOARD ACTIONS
    @FXML
    private void StudentRecord_action(MouseEvent event) {
        Dashboard_pane.setVisible(false);
        StudentRecord_pane.setVisible(true);
    }

    @FXML
    private void Consultation_action(MouseEvent event) {
        Dashboard_pane.setVisible(false);
        Consultations_pane.setVisible(true);
    }

    @FXML
    private void Reports_action(MouseEvent event) {
        Dashboard_pane.setVisible(false);
        Reports_pane.setVisible(true);
    }

    @FXML
    private void Inventory_action(MouseEvent event) {
        Dashboard_pane.setVisible(false);
        Inventory_pane.setVisible(true);
    }

    @FXML
    private void VisitLog_action(MouseEvent event) {
        Dashboard_pane.setVisible(false);
        VisitLog_pane.setVisible(true);
    }

    @FXML
    private void Notification_action(MouseEvent event) {
        SIDENAV_VBOX.setDisable(true);
        Dashboard_pane.setDisable(true);
        Notification_pane.setVisible(true);

//        // 1) Refresh the DB (this updates notifications server-side)
//        NotificationDAO.refreshFromDB();
//
//        // 2) Refresh the same master list (without breaking binding)
//        notifMaster.setAll(NotificationDAO.findAll());
//
//        // 3) Optional: Reapply filters
//        refreshPredicate();
    }


    private void loadDashboardStats() {
        int students    = StudentDAO.countActive(); 
        int todayVisits= VisitLogDAO.countToday();
        int items      = InventoryDAO.countItems(); // or InventoryDAO.sumQuantity() if you chose that

        // Simple formatting; change to NumberFormat for commas
        TotalStudents_label.setText(String.valueOf(students));
        TodayVisit_label.setText(String.valueOf(todayVisits));
        TotalMedSupplies_label.setText(String.valueOf(items));
    }
    ////////////////////////////////////////////////////////////////////////////end dashboard actions
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Dashboard_pane.setVisible(true);
        
        StudentRecord_pane.setVisible(false);
        StudentRecord_pane1.setVisible(false);
        Consultations_pane.setVisible(false);
        Reports_pane.setVisible(false);
        Inventory_pane.setVisible(false);
        VisitLog_pane.setVisible(false);
        Notification_pane.setVisible(false);
        AddStudent_pane.setVisible(false);
        medicalCertificate_pane.setVisible(false);
        calendar_pane.setVisible(false);
        settings_pane.setVisible(false);
      // Series 1
    XYChart.Series<Number, String> series1 = new XYChart.Series<>();
    series1.setName("BSFAS");
    series1.getData().add(new XYChart.Data<>(30, "BSFAS 4"));
    series1.getData().add(new XYChart.Data<>(50, "BSFAS 3"));
    series1.getData().add(new XYChart.Data<>(44, "BSFAS 2"));
    series1.getData().add(new XYChart.Data<>(55, "BSFAS 1"));

    // Series 2
    XYChart.Series<Number, String> series2 = new XYChart.Series<>();
    series2.setName("BSIT");
    series2.getData().add(new XYChart.Data<>(100, "BSIT 4"));
    series2.getData().add(new XYChart.Data<>(40, "BSIT 3"));
    series2.getData().add(new XYChart.Data<>(33, "BSIT 2"));
    series2.getData().add(new XYChart.Data<>(66, "BSIT 1"));
    
    // Add to chart
    barChart.getData().addAll(series1, series2); 
    ///////////////////////////////////////////////////////////////////////////////
     // hide the details pane initially
        if (viewStudent_pane != null) viewStudent_pane.setVisible(false);

     // table columns
        // show school ID number in id_col (not student_id)
        id_col.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getIdNumber()));
        lastName_col.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getLastName()));
        firstName_col.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getFirstName()));
        middleName_col.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getMiddleName()));
        course_col.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getCourse()));
        yearLevel_col.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getYearLevel()));
        gender_col.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getGender()));
        age_col.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(
                c.getValue().getAge() == null ? 0 : c.getValue().getAge()).asObject());
        contact_col.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getContactNumber()));

        setupActionColumn();
        refreshAgesOnStartup();
        loadStudents();
        
        // 2.1 Year-level options 
        yearLevel_cb.setItems(FXCollections.observableArrayList(
            "All", "1st Year", "2nd Year", "3rd Year", "4th Year", "Irregular", "Inactive", "Graduated"
        ));
        yearLevel_cb.getSelectionModel().select("All");

        // 2.2 Toggle group 
        btnALL.setToggleGroup(courseFilter);
        btnBSIT.setToggleGroup(courseFilter);
        btn_BSFAS.setToggleGroup(courseFilter);
        btnBIT.setToggleGroup(courseFilter);

        // 2.3 Give stable userData to each button (safer than relying on getText())
        btnALL.setUserData("ALL");
        btnBSIT.setUserData("BSIT");
        btn_BSFAS.setUserData("BSFAS");
        btnBIT.setUserData("BINDTECH");

        // Default: show all
        courseFilter.selectToggle(btnALL);

        // 2.4 Build filtered + sorted pipeline
        filtered = new FilteredList<>(students, s -> true);
        SortedList<Student> sorted = new SortedList<>(filtered);
        sorted.comparatorProperty().bind(student_tv.comparatorProperty());
        student_tv.setItems(sorted);

        // 2.5 Hook listeners so any change re-applies the combined filter
        filterField1.textProperty().addListener((obs, o, n) -> refreshStudentPredicate());
        courseFilter.selectedToggleProperty().addListener((obs, o, n) -> refreshStudentPredicate());
        yearLevel_cb.valueProperty().addListener((obs, o, n) -> refreshStudentPredicate());

        //2.6 Added for replaced textfields to combo box
        // DETAILS combo options (edit pane)
        course_cb.setItems(FXCollections.observableArrayList("BSIT", "BINDTECH", "BSFAS"));
        gender_cb.setItems(FXCollections.observableArrayList("Male", "Female", "Other"));
        DETAILSyearLevel_cb.setItems(FXCollections.observableArrayList(
            "1st Year","2nd Year","3rd Year","4th Year","Irregular"
        ));
        DETAILSstatus_cb.setItems(FXCollections.observableArrayList("active","inactive","graduated"));
        
        // Run once initially
        refreshStudentPredicate();
        ///////////////////////////////////////////////////////////////////////////////////////////////
        //for adding a student
        addStudent_course_cb.getItems().setAll("BSIT", "BINDTECH", "BSFAS");
        addStudent_year_cb.getItems().setAll("1st Year","2nd Year","3rd Year","4th Year","Irregular");
        addStudent_gender_cb.getItems().setAll("Male","Female","Other");
        
        setCircularImage(addStudent_imageview, defaultStudentImage(), 80);

    // ============================== CONSULTATION: initialize() setup ==============================
    // Bind columns to Consultation model
    consultationName_col.setCellValueFactory(cd ->
            new SimpleStringProperty(cd.getValue().getStudentName()));

    consultationDate_col.setCellValueFactory(cd ->
            new SimpleStringProperty(
                    cd.getValue().getConsultationDate() != null
                       ? cd.getValue().getConsultationDate().format(DATE_FMT)
                       : ""
            ));

    consultationReason_col.setCellValueFactory(cd ->
            new SimpleStringProperty(cd.getValue().getReasonForVisit()));

    // Action column with a "View" button
    consultationAction_col.setCellFactory(col -> new TableCell<>() {
        private final Button viewBtn = new Button("View");
        {
            viewBtn.getStyleClass().add("table-action-view");
            viewBtn.setOnAction(e -> {
                Consultation row = getTableView().getItems().get(getIndex());
                onViewRow(row);
            });
        }
        @Override
        protected void updateItem(Void item, boolean empty) {
            super.updateItem(item, empty);
            setGraphic(empty ? null : viewBtn);
            setText(null);
        }
    });
    
    // Initial load of the table
    refreshTable();

    // Vitals listeners (instant feedback)
    attachVitalsStatusListeners();

    // Default date auto-fill when the pane is first shown
    consultationDate_tf.setText(LocalDate.now().format(DATE_FMT));
  
    // ======================= Rx table: columns & behavior =======================
    rxTable.setItems(rxItems);

    // Medicine name column (read-only text)
    rxColMed.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getItemName()));
    rxColMed.setPrefWidth(260);

    // Unit column (read-only)
    rxColUnit.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getUnit()));
    rxColUnit.setPrefWidth(90);

    // Qty column with Spinner (1..999), red cell if exceeds stock
    rxColQty.setCellValueFactory(cd -> new ReadOnlyObjectWrapper<>(cd.getValue().getQty()));
    rxColQty.setCellFactory(col -> new TableCell<>() {
        private final Spinner<Integer> spinner = new Spinner<>(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 999, 1));
        {
            spinner.setEditable(true);
            spinner.valueProperty().addListener((obs,o,n)-> {
                RxRow row = getTableView().getItems().get(getIndex());
                if (row != null) {
                    row.setQty(n);
                    validateQtyAgainstStock(row, this);
                }
            });
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            setAlignment(Pos.CENTER);
            setPadding(new Insets(2,4,2,4));
        }
        @Override protected void updateItem(Integer qty, boolean empty) {
            super.updateItem(qty, empty);
            if (empty) { setGraphic(null); return; }
            spinner.getValueFactory().setValue(qty==null?1:qty);
            setGraphic(spinner);

            RxRow row = getTableView().getItems().get(getIndex());
            validateQtyAgainstStock(row, this);
        }
    });

    // Action column: Remove button
    rxColAction.setCellFactory(col -> new TableCell<>() {
        final Button btn = new Button("Remove");
        {
            btn.getStyleClass().add("danger-small");
            btn.setOnAction(e -> {
                RxRow row = getTableView().getItems().get(getIndex());
                rxItems.remove(row);
            });
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        }
        @Override protected void updateItem(Void v, boolean empty) {
            super.updateItem(v, empty);
            setGraphic(empty ? null : btn);
        }
    });

    if (rxHint_lbl != null) {
        rxHint_lbl.setText("Tip: quantities will be deducted from Inventory on Save.");
    }

    //=======================================================================================================
        // INVENTORY in initialize
        setupColumns();
        loadData();
        setupActionColumnINVENTORY();   // the "⋮" per row
        setupInventorySearchFilter();
        
        // …inside setupColumns(), after set cell value factories:
        final PseudoClass PC_EXPIRED  = PseudoClass.getPseudoClass("expired");
        final PseudoClass PC_EXPIRING = PseudoClass.getPseudoClass("expiring");
        final PseudoClass PC_OUT      = PseudoClass.getPseudoClass("out");

        inventory_tv.setRowFactory(tv -> new TableRow<Inventory>() {
            @Override
            protected void updateItem(Inventory inv, boolean empty) {
                super.updateItem(inv, empty);

                // clear all flags by default
                pseudoClassStateChanged(PC_EXPIRED,  false);
                pseudoClassStateChanged(PC_EXPIRING, false);
                pseudoClassStateChanged(PC_OUT,      false);

                if (empty || inv == null) return;

                String s = (inv.getStatus() == null) ? "" : inv.getStatus().toLowerCase();
                switch (s) {
                    case "expired"        -> pseudoClassStateChanged(PC_EXPIRED,  true);
                    case "expiring soon"  -> pseudoClassStateChanged(PC_EXPIRING, true);
                    case "out of stock"   -> pseudoClassStateChanged(PC_OUT,      true);
                    default -> { /* leave normal */ }
                }
            }
        });
        //======================= TOOLS INVENTORY ============================
        invTabPane.getStyleClass().add("underline-tabs");

        // add tool pane
        setupToolForm();
        tools_tv.setItems(toolsMaster);
        
        // Table
        setupToolsColumns();
        setupToolsActionColumn();

        // Load data
        toolsMaster.setAll(InventoryToolsDAO.findAll());
        setupToolsSearchFilter();

        // Combo boxes
        toolCategory_cb.setItems(CATEGORY_OPTIONS);
        toolLocation_cb.setItems(LOCATION_OPTIONS);
        toolStatus_cb.setItems(CONDITION_OPTIONS);

        // Let user type new values if needed (optional)
        toolCategory_cb.setEditable(true);
        toolLocation_cb.setEditable(true);
        toolStatus_cb.setEditable(true);

        // Hide the form initially
        if (AddEdit_ToolPane != null) AddEdit_ToolPane.setVisible(false);

        
        // === TOOL STATUS ROW COLORS ===
        final PseudoClass PC_REPAIR   = PseudoClass.getPseudoClass("needsrepair");
        final PseudoClass PC_UNDERREP = PseudoClass.getPseudoClass("underrepair");
        final PseudoClass PC_DECOMM   = PseudoClass.getPseudoClass("decommissioned");

        // Apply pseudo-class per row based on status
        tools_tv.setRowFactory(tv -> new TableRow<InventoryTool>() {
            @Override
            protected void updateItem(InventoryTool item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    pseudoClassStateChanged(PC_REPAIR, false);
                    pseudoClassStateChanged(PC_UNDERREP, false);
                    pseudoClassStateChanged(PC_DECOMM, false);
                    setStyle("");
                    return;
                }

                String s = item.getStatus() == null ? "" : item.getStatus().toLowerCase();
                pseudoClassStateChanged(PC_REPAIR,   s.contains("needs repair"));
                pseudoClassStateChanged(PC_UNDERREP, s.contains("under repair"));
                pseudoClassStateChanged(PC_DECOMM,   s.contains("decommissioned"));
            }
        });

        // ====================== VISIT LOG: initialize ======================
        setupColumnsVISITLOG();
        loadVisitLogs();

        VisitLog_addpane.setVisible(false);
        visitLog_tv.setPlaceholder(new Label("No visit logs"));

        loadDashboardStats();  // call once on load (and after any CRUD for live)
        //====================================================================
        
        // defaults (MED CERTIFICATE)
        date_dp.setValue(LocalDate.now());
        status_cb.setItems(FXCollections.observableArrayList("Fit","Not Fit"));
        status_cb.getSelectionModel().selectFirst();

        // table columns
        colStudent.setCellValueFactory(d -> d.getValue().studentNameProp());
        colDate.setCellValueFactory(d -> d.getValue().dateProp());
        colCode.setCellValueFactory(d -> d.getValue().codeProp());
        colStatus.setCellValueFactory(d -> d.getValue().statusProp());
        colAction.setCellValueFactory(d -> d.getValue().actionProp());

        // first load
        loadCertificates(null);

        // Any manual change marks vitals as user-edited (creating Med Certificate)
        bp_tf.textProperty().addListener((o,a,b)    -> vitalsUserEdited = true);
        temp_tf.textProperty().addListener((o,a,b)  -> vitalsUserEdited = true);
        pulse_tf.textProperty().addListener((o,a,b) -> vitalsUserEdited = true);
        resp_tf.textProperty().addListener((o,a,b)  -> vitalsUserEdited = true);
        
        //delete records in recycle bin which is 90 days old
        purgeOldDeleted();
        
        // ImageView defaults for pixel-true zooming
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);

        // IMPORTANT: disable any "fit to width/height" scaling from ImageView itself
        imageView.setFitWidth(0);   // 0 = do not scale via fitWidth
        imageView.setFitHeight(0);  // 0 = do not scale via fitHeight

        // Put ImageView inside a Group so ScrollPane uses image's actual pixel size
        imageGroup = new Group(imageView);
        scroll.setContent(imageGroup);

        // Let the user pan around when zoomed in
        scroll.setPannable(true);

        // IMPORTANT: don't force content to the viewport size
        scroll.setFitToWidth(false);
        scroll.setFitToHeight(false);

        // If user pressed "Fit", re-fit when the pane is resized
        scroll.viewportBoundsProperty().addListener((obs, o, n) -> {
            if (fitMode && doc != null) renderPreviewPage(currentPageIndex());
        });

        ////////////////////////////// CALENDAR on initialize ////////////////////////////////
        // ========= INITIALIZE (wiring) =========

        // 1) DB
        Connection conn = MySQL.connect();
        dao = new CalendarDao(conn);

        // 2) Static header (Mon..Sun)
        buildWeekdayHeader();

        // 3) Build the grid for the current mode (MONTH -> 6x7)
        rebuildGridForView();

        // 4) Peek overlay (always on top of the stack; never replaces nodes)
        initPeekOverlay();

        // 5) Navigation
        btnPrev.setOnAction(e -> {
            if (viewMode == ViewMode.WEEK) {
                weekStart = weekStart.minusWeeks(1);
            } else {
                visibleMonth = visibleMonth.minusMonths(1);
            }
            refresh();
        });
        btnNext.setOnAction(e -> {
            if (viewMode == ViewMode.WEEK) {
                weekStart = weekStart.plusWeeks(1);
            } else {
                visibleMonth = visibleMonth.plusMonths(1);
            }
            refresh();
        });
        btnToday.setOnAction(e -> {
            if (viewMode == ViewMode.WEEK) {
                weekStart = LocalDate.now()
                        .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            } else {
                visibleMonth = YearMonth.now();
            }
            refresh();
        });
        miniDatePicker.valueProperty().addListener((obs, oldV, d) -> {
            if (d == null) return;
            if (viewMode == ViewMode.WEEK) {
                weekStart = d.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            } else {
                visibleMonth = YearMonth.from(d);
            }
            refresh();
        });

        // 6) View toggles — use one source of truth
        tglMonth.setOnAction(e -> setMode(ViewMode.MONTH));
        tglWeek.setOnAction(e  -> setMode(ViewMode.WEEK));
        tglList.setOnAction(e  -> setMode(ViewMode.LIST));
        setMode(ViewMode.MONTH);      // pick initial

        // 7) Filters
        fltAll.setOnAction(e -> {
            if (fltAll.isSelected()) {
                fltNotes.setSelected(false);
                fltTasks.setSelected(false);
                fltEvents.setSelected(false);
                fltInventory.setSelected(false);
            }
            refresh();
        });
        fltNotes.setOnAction(e -> { fltAll.setSelected(false); refresh(); });
        fltTasks.setOnAction(e -> { fltAll.setSelected(false); refresh(); });
        fltEvents.setOnAction(e -> { fltAll.setSelected(false); refresh(); });
        fltInventory.setOnAction(e -> { fltAll.setSelected(false); refresh(); });

        // 8) Quick add
        btnAdd.setOnAction(e -> quickAdd(LocalDate.now()));

        // 9) First paint + sidebar lists
        setupLists();
        refresh();


        // Make sure both nodes are positioned from the same corner.
        StackPane.setAlignment(weekdayHeader, Pos.TOP_LEFT);
        StackPane.setAlignment(monthGrid,     Pos.TOP_LEFT);

        // Good default: leave room for the weekday header in MONTH by default
        StackPane.setMargin(monthGrid, new Insets(28, 0, 0, 0));

        // Let the calendar area actually expand inside the VBox
        VBox.setVgrow(calendarStack, Priority.ALWAYS);
        
        buildLegend(); //for color/legend
        
        //SETTINGS in initialize
        // 1) wire eyes (show/hide password)
        wireEye(currentPass_show, current_pw, current_pw_tf);
        wireEye(newPass_show, new_pw, new_pw_tf);
        wireEye(confirmPass_show, confirm_pw, confirm_pw_tf);

        // 2) circular photos
//        AdminPhoto.setFitWidth(70); AdminPhoto.setFitHeight(70);
//        AdminPhoto_edit.setFitWidth(120); AdminPhoto_edit.setFitHeight(120);
//        makeCircular(AdminPhoto);
//        makeCircular(AdminPhoto_edit);

        // 2) define avatar sizes; set once (crop+clip will be called in loadUserFromDB)
        AdminPhoto.setFitWidth(70);    AdminPhoto.setFitHeight(70);
        AdminPhoto_edit.setFitWidth(120); AdminPhoto_edit.setFitHeight(120);

        
        image_imageView.setFitWidth(STUDENT_AVATAR_SIZE);
        image_imageView.setFitHeight(STUDENT_AVATAR_SIZE);
        
        // 3) load user (name + photo + fields)
        loadUserFromDB();

        // 4) ensure text-fields and password text-fields share managed/visible
        current_pw_tf.managedProperty().bind(current_pw_tf.visibleProperty());
        new_pw_tf.managedProperty().bind(new_pw_tf.visibleProperty());
        confirm_pw_tf.managedProperty().bind(confirm_pw_tf.visibleProperty());
        current_pw.managedProperty().bind(current_pw.visibleProperty());
        new_pw.managedProperty().bind(new_pw.visibleProperty());
        confirm_pw.managedProperty().bind(confirm_pw.visibleProperty());
        
//        animateThumb(toggleProfile); 
//        animateThumb(togglePassword);
        
        wireSwitch(toggleProfile);
        wireSwitch(togglePassword);
        
        //////////NOTIFICATIONS IN INITIALIZE///////////////
        
        // 1) Cell factory + placeholder
        setupNotificationCellFactory();
        notif_lv.setPlaceholder(new Label("No notifications"));

        // 2) Pipeline for the ListView (master -> filtered -> sorted)
        notifFiltered = new FilteredList<>(notifMaster, n -> true);
        notifSorted   = new SortedList<>(notifFiltered);
        // Newest first
        notifSorted.setComparator(Comparator.comparing(Notification::getCreatedAt).reversed());
        // Attach to ListView
        notif_lv.setItems(notifSorted);
        
        // 3) Search + toggle filters
        search_tf.textProperty().addListener((o, ov, nv) -> refreshPredicate());

        all_tb.selectedProperty().addListener((o,ov,nv)-> { if (nv) { unread_tb.setSelected(false); inv_tb.setSelected(false); cal_tb.setSelected(false); } refreshPredicate(); });
        unread_tb.selectedProperty().addListener((o,ov,nv)-> { if (nv) { all_tb.setSelected(false); } refreshPredicate(); });
        inv_tb.selectedProperty().addListener((o,ov,nv)-> { if (nv) { all_tb.setSelected(false); } refreshPredicate(); });
        cal_tb.selectedProperty().addListener((o,ov,nv)-> { if (nv) { all_tb.setSelected(false); } refreshPredicate(); });
        all_tb.setSelected(true);
        refreshPredicate();
        
        // 4) Badge: unread = items in master where isRead == false
        unreadFiltered = new FilteredList<>(notifMaster, n -> n != null && !n.isRead());
        setupNotificationBadge();  // binds badge to unreadFiltered size
        
        // when items are added, watch their readProperty to refresh the unread filter
        notifMaster.addListener((ListChangeListener<Notification>) ch -> {
            while (ch.next()) {
                if (ch.wasAdded()) {
                    for (Notification n : ch.getAddedSubList()) {
                        n.readProperty().addListener((o, ov, nv) -> refreshUnreadFilter());
                    }
                }
            }
        });


        // 5) First refresh (runs SP + loads list)
        runNotifRefreshOnce();

        // 6) Optional periodic refresh (daemon thread)
        notifScheduler = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread t = new Thread(r, "notif-refresh");
            t.setDaemon(true);
            return t;
        });
//        notifScheduler.scheduleAtFixedRate(this::runNotifRefreshOnce, 5, 5, TimeUnit.MINUTES);
        notifScheduler.scheduleAtFixedRate(this::runNotifRefreshOnce, 10, 30, TimeUnit.SECONDS);
//        notifScheduler.scheduleAtFixedRate(() -> {
//            if (Platform.isFxApplicationThread()) return;
//            if (Notification_pane.isVisible()) {
//                runNotifRefreshOnce();
//            }
//        }, 5, 5, TimeUnit.SECONDS);

        

        // 7) Toolbar handlers (inside initialize)
        // mark all read
        markAllRead_btn.setOnAction(e -> {
            boolean ok = NotificationDAO.markAllRead();
            if (!ok) {
                new Alert(Alert.AlertType.ERROR, "Failed to mark all as read in DB.").showAndWait();
                return;
            }
            // update in-memory
            for (Notification n : notifMaster) n.setRead(true);
            refreshUnreadFilter();          // <— updates badge immediately
            triggerNotifRefreshNow(); 

            notif_lv.refresh();
        });

        // clear read (delete read notifications)
        clearRead_btn.setOnAction(e -> {
            // Split read notifications into auto-generated vs manual
            List<Notification> readNow = new ArrayList<>(notifMaster.filtered(Notification::isRead));
            if (readNow.isEmpty()) return;

            // 1) Snooze all AUTO read items (so refresh won’t bring them back today)
            for (Notification n : readNow) {
                if (n.isAutoGenerated()) {
                    NotificationDAO.snoozeAuto(n.getKind(),
                                               n.getRelatedType().name(),
                                               n.getRelatedId(),
                                               1);
                }
            }

            // 2) Delete MANUAL read items from DB
            for (Notification n : readNow) {
                if (!n.isAutoGenerated()) {
                    NotificationDAO.deleteById(n.getId());
                }
            }

            // 3) Update UI
            notifMaster.removeIf(Notification::isRead);
            refreshUnreadFilter();          // <— updates badge immediately
            triggerNotifRefreshNow();
        });

        //////////// REPORTS //////////////
        // ---- default date ranges ----
        LocalDate now = LocalDate.now();
        if (consFromDate != null) consFromDate.setValue(now.minusMonths(3).withDayOfMonth(1));
        if (consToDate   != null) consToDate.setValue(now);
        if (visFromDate  != null) visFromDate.setValue(now.minusMonths(3).withDayOfMonth(1));
        if (visToDate    != null) visToDate.setValue(now);

        // ---- Consultations table columns ----
//        if (dailyConsultationsTable != null) {
//            @SuppressWarnings("unchecked")
//            TableView<ConsRow> tv = (TableView<ConsRow>) (TableView<?>) dailyConsultationsTable;
//            @SuppressWarnings("unchecked") TableColumn<ConsRow, String> cDate = (TableColumn<ConsRow, String>) (TableColumn<?, ?>) colConsDate;
//            @SuppressWarnings("unchecked") TableColumn<ConsRow, String> cStudent = (TableColumn<ConsRow, String>) (TableColumn<?, ?>) colConsStudent;
//            @SuppressWarnings("unchecked") TableColumn<ConsRow, String> cReason = (TableColumn<ConsRow, String>) (TableColumn<?, ?>) colConsReason;
//            @SuppressWarnings("unchecked") TableColumn<ConsRow, String> cDiagnosis = (TableColumn<ConsRow, String>) (TableColumn<?, ?>) colConsDiagnosis;
//            @SuppressWarnings("unchecked") TableColumn<ConsRow, String> cBP = (TableColumn<ConsRow, String>) (TableColumn<?, ?>) colConsBP;
//            @SuppressWarnings("unchecked") TableColumn<ConsRow, Number> cTemp = (TableColumn<ConsRow, Number>) (TableColumn<?, ?>) colConsTemp;

//            cDate.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().date.toString()));
//            cStudent.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().student));
//            cReason.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().reason));
//            cDiagnosis.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().diagnosis));
//            cBP.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().bp));
//            cTemp.setCellValueFactory(cd -> new SimpleDoubleProperty(cd.getValue().temperature!=null?cd.getValue().temperature:0));
//
//            tv.setItems(consRows);
//        }

        // ---- Visits table ----
        if (visitsByDateTable != null) {
            @SuppressWarnings("unchecked")
            TableView<VisitRow> tv = (TableView<VisitRow>) (TableView<?>) visitsByDateTable;
            @SuppressWarnings("unchecked") TableColumn<VisitRow, String> cDate = (TableColumn<VisitRow, String>) (TableColumn<?, ?>) colVisitDate;
            @SuppressWarnings("unchecked") TableColumn<VisitRow, String> cStudent = (TableColumn<VisitRow, String>) (TableColumn<?, ?>) colVisitStudent;
            @SuppressWarnings("unchecked") TableColumn<VisitRow, String> cReason = (TableColumn<VisitRow, String>) (TableColumn<?, ?>) colVisitReason;

            cDate.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getDate().toString()));
            cStudent.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getStudent()));
            cReason.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getReason()));

            tv.setItems(visitRows);
        }

        // ---- Inventory tables ----
        if (medicineUsageTable != null) {
            @SuppressWarnings("unchecked")
            TableView<MedUsageRow> tv = (TableView<MedUsageRow>) (TableView<?>) medicineUsageTable;
            @SuppressWarnings("unchecked") TableColumn<MedUsageRow, String> cItem = (TableColumn<MedUsageRow, String>) (TableColumn<?, ?>) colInvItem;
            @SuppressWarnings("unchecked") TableColumn<MedUsageRow, Number> cUsed = (TableColumn<MedUsageRow, Number>) (TableColumn<?, ?>) colInvUsed;
            @SuppressWarnings("unchecked") TableColumn<MedUsageRow, Number> cBal = (TableColumn<MedUsageRow, Number>) (TableColumn<?, ?>) colInvBalance;
            @SuppressWarnings("unchecked") TableColumn<MedUsageRow, String> cExp = (TableColumn<MedUsageRow, String>) (TableColumn<?, ?>) colInvExpiry;

            cItem.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getItem()));
            cUsed.setCellValueFactory(cd -> new SimpleIntegerProperty(cd.getValue().getTotalUsed()));
            cBal.setCellValueFactory(cd -> new SimpleIntegerProperty(cd.getValue().getBalance()));
            cExp.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getExpiry()!=null?cd.getValue().getExpiry().toString():""));

            tv.setItems(usageRows);
        }
        if (lowStockTable != null) {
            @SuppressWarnings("unchecked")
            TableView<MedUsageRow> tv = (TableView<MedUsageRow>) (TableView<?>) lowStockTable;
            @SuppressWarnings("unchecked") TableColumn<MedUsageRow, String> cItem = (TableColumn<MedUsageRow, String>) (TableColumn<?, ?>) colLowItem;
            @SuppressWarnings("unchecked") TableColumn<MedUsageRow, Number> cQty = (TableColumn<MedUsageRow, Number>) (TableColumn<?, ?>) colLowQty;
            @SuppressWarnings("unchecked") TableColumn<MedUsageRow, String> cStatus = (TableColumn<MedUsageRow, String>) (TableColumn<?, ?>) colLowStatus;
            @SuppressWarnings("unchecked") TableColumn<MedUsageRow, String> cExp = (TableColumn<MedUsageRow, String>) (TableColumn<?, ?>) colLowExpiry;

            cItem.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getItem()));
            cQty.setCellValueFactory(cd -> new SimpleIntegerProperty(cd.getValue().getBalance()));
            cStatus.setCellValueFactory(cd -> new SimpleStringProperty(
                    cd.getValue().getBalance()<=0 ? "Out" : (cd.getValue().getBalance()<=10 ? "Low" : "OK")
            ));
            cExp.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getExpiry()!=null?cd.getValue().getExpiry().toString():""));

            tv.setItems(lowRows);
        }

        // ---- Button actions ----
        if (consApplyFilterBtn != null) consApplyFilterBtn.setOnAction(e -> {
                refreshConsultations();
        });
//        if (consClearBtn != null) {
//            consClearBtn.setOnAction(e -> { consSearchField.clear(); refreshConsultations(); });
//        }
        if (visApplyFilterBtn != null) visApplyFilterBtn.setOnAction(e -> refreshVisits());

        // Exports (per-tab)
        if (ovwExportPdfBtn != null)
        ovwExportPdfBtn.setOnAction(e ->
            ExportUtil.exportNodeToPdf(getWindow(), overviewRoot.getCenter()));

        if (ovwExportExcelBtn != null) ovwExportExcelBtn.setOnAction(e ->
                ExportUtil.exportTableAndChartsToExcel(getWindow(),
                        // Overview doesn’t have a single table; write an empty sheet and only images:
                        new TableView<>(), List.of(
                                (Node) overviewConsultationsPerMonthChart,
                                (Node) overviewTopComplaintsPie,
                                (Node) overviewBpStatusPie,
                                (Node) overviewMedsUsageTrend,
                                (Node) consTODAYkpi,
                                (Node) consMONTHkpi,
                                (Node) consSTUDENTSkpi,
                                (Node) consMEDICINESkpi
                        ), "Overview")
        );
        
        topComplaintsPie.setPrefSize(420, 280);
        bpStatusPie.setPrefSize(420, 280);
        topComplaintsPie.setLabelsVisible(false);
        bpStatusPie.setLabelsVisible(false);


        if (consExportPdfBtn != null)
        consExportPdfBtn.setOnAction(e ->
            ExportUtil.exportNodeToPdf(getWindow(), consultationsScrollPane)); // <-- fx:id of that tab’s ScrollPane


        // AFTER (charts only)
        if (consExportExcelBtn != null) consExportExcelBtn.setOnAction(e -> {
            ExportUtil.exportChartsToExcel(getWindow(), List.of(
                    (Node) monthlyConsultationsBar, (Node) topComplaintsPie, (Node) bpStatusPie
            ), "Consultations");
        });

        visitsScrollPane.addEventFilter(ScrollEvent.ANY, Event::consume); //freeze the scrollpane
        if (visExportPdfBtn != null)
        visExportPdfBtn.setOnAction(e ->
            ExportUtil.exportNodeToPdf(getWindow(), visitsScrollPane)); // <-- fx:id

        if (visExportExcelBtn != null) visExportExcelBtn.setOnAction(e -> {
            ExportUtil.exportChartsToExcel(getWindow(), List.of(
                    (Node) visitsByYearLevelBar, (Node) visitsByCourseBar
            ), "Visits");
        });

        inventoryScrollPane.addEventFilter(ScrollEvent.ANY, Event::consume); //freeze the scrollpane
        if (invExportPdfBtn != null)
        invExportPdfBtn.setOnAction(e ->
            ExportUtil.exportNodeToPdf(getWindow(), inventoryScrollPane)); // <-- fx:id

        if (invExportExcelBtn != null) invExportExcelBtn.setOnAction(e -> {
            @SuppressWarnings("unchecked") TableView<MedUsageRow> tv = (TableView<MedUsageRow>) (TableView<?>) lowStockTable;
            ExportUtil.exportTableAndChartsToExcel(getWindow(), tv, List.of(
                    (Node) itemUsageTrendChart
            ), "Inventory");
        });

        if (invShowLowStockBtn != null) invShowLowStockBtn.setOnAction(e -> refreshLowStock());
        if (invShowExpiringBtn != null) invShowExpiringBtn.setOnAction(e -> refreshExpiring());

        // ---- initial load ----
        Platform.runLater(() -> {
            refreshOverview();
            refreshConsultations();
            refreshVisits();
            refreshInventory();
        });
        
    }  
    ////////////////////////////////////////////////////////////////////////////end initialization
    
    // ============================================================================================
    // ============================== CONSULTATION: Event Handlers & Helpers ======================
    // ============================================================================================

    // --- Open the student picker popup and store selection (Consultation) ---
    @FXML
    private void searchStudent_hyperlink(ActionEvent e) {
        StudentPickerDialog dlg = new StudentPickerDialog();

        // center on this pane's window if available.
        if (AddEditConsultation_pane != null &&
            AddEditConsultation_pane.getScene() != null) {
            dlg.initOwner(AddEditConsultation_pane.getScene().getWindow());
        }

        java.util.Optional<StudentPick> res = dlg.showAndWait();
        res.ifPresent(pick -> {
            // Keep both DB key and human ID number
            currentConsultationStudentId        = pick.getStudentId();
            currentConsultationStudentIdNumber  = pick.getIdNumber();
            currentConsultationStudentName      = pick.getFullName();

            // Show "IDNumber – Name" in the (read-only) field
            consultationName_tf.setText(pick.getIdNumber() + " – " + pick.getFullName());

            // separate label for the school ID number:
//            if (studentIdNo_lbl != null) studentIdNo_lbl.setText(pick.getIdNumber());
        });
    }


    // --- Add new consultation ---
    @FXML
    private void AddNewConsultation(ActionEvent e) {
        AddEditConsultation_pane.setVisible(true);
        clearFields();
        rxItems.clear();               // <— reset meds table
        setModeAdd();
        consultationDate_tf.setText(LocalDate.now().format(DATE_FMT));
    }


    // --- Cancel form ---
    @FXML
    private void cancelConsultation_btn(ActionEvent event) {
        AddEditConsultation_pane.setVisible(false);
        clearFields();
    }

    // --- Save (insert or update) ---
    @FXML
    private void saveConsultation_btn(ActionEvent event) {

        // 1) Resolve student id for this form
        Integer studentId = (currentConsultationId == null)
                ? currentConsultationStudentId                     // ADD
                : (currentSelected != null ? currentSelected.getStudentId() : null); // EDIT keeps original

        if (studentId == null) {
            showWarn("Please pick a student.");
            return;
        }

        // 2) Date
        String dateStr = consultationDate_tf.getText();
        LocalDate cdate = (dateStr == null || dateStr.isBlank())
                ? LocalDate.now()
                : LocalDate.parse(dateStr, DATE_FMT);

        // 3) Gather values from fields
        String reason    = consultationReason_tf.getText();
        String bp        = consultationBP_tf.getText();
        String tempStr   = consultationTemperature_tf.getText();
        String diagnosis = consultationDiagnosis_tf.getText();
        String treatment = consultationTreatment_tf.getText();
        String referral  = consultationReferral_tf.getText();
        String prStr     = consultationPR_tf.getText();
        String rrStr     = consultationRR_tf.getText();

        Double  temp = (tempStr == null || tempStr.isBlank()) ? null : Double.valueOf(tempStr);
        Integer pr   = (prStr   == null || prStr.isBlank())   ? null : Integer.valueOf(prStr);
        Integer rr   = (rrStr   == null || rrStr.isBlank())   ? null : Integer.valueOf(rrStr);

        // 4) Persist using DAO (which already handles consultation_meds + inventory in one transaction)
        try {
            if (currentConsultationId == null) {
                int newId = ConsultationDAO.insertWithMeds(
                    studentId, cdate, reason, bp, temp, diagnosis, treatment, referral, pr, rr,
                    new ArrayList<>(rxItems)
                );
                if (newId <= 0) { 
                    alertError("Save failed. Please try again.");
                    return;
                }
                currentConsultationId = newId;
            } else {
                ConsultationDAO.updateWithMeds(
                    currentConsultationId, studentId, cdate, reason, bp, temp, diagnosis, treatment, referral, pr, rr,
                    new ArrayList<>(rxItems)
                );
            }
        } catch (StockException se) {
            // Friendly, specific reason for failure (no stack trace)
            showWarn(se.getMessage());
            return;
        } catch (Exception ex) {
            // Unexpected problem
            // ex.printStackTrace(); // optionally remove to keep console clean
            alertError("Unexpected error while saving. Please contact the administrator.");
            return;
        }

        // 5) Refresh table + close pane
        refreshTable();
        AddEditConsultation_pane.setVisible(false);

        // (optional) clear form state for the next Add
        clearFields();
        rxItems.clear();
        
        //refresh inventory
        setupColumns();
        loadData();
        setupActionColumnINVENTORY();   // the "⋮" per row
        setupInventorySearchFilter();
        
        triggerNotifRefreshNow(); //TO UPDATE LABEL BADGE IN NOTIFICATION (FOR INVENTORY OF MEDICINE - STOCK)
        refreshOverview(); //reports overview
        refreshConsultations();
        refreshInventory();
    }

    // --- Edit button: allow fields to be edited (student change is not allowed here) ---
    @FXML
    private void editConsultation_btn(ActionEvent event) {
        if (currentConsultationId == null) return;
        setModeEdit();
    }

    // --- Delete current consultation ---
    @FXML
    private void deleteConsultation_btn(ActionEvent event) {
        if (currentConsultationId != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Delete");
            alert.setHeaderText("Delete this consultation?");
            alert.setContentText("This action cannot be undone.");
            ButtonType yesBtn = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType noBtn  = new ButtonType("No",  ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(yesBtn, noBtn);

            alert.showAndWait().ifPresent(resp -> {
                if (resp == yesBtn) {
                    ConsultationDAO.deleteWithMeds(currentConsultationId);
                    refreshTable();
                    AddEditConsultation_pane.setVisible(false);
                    clearFields();
                    rxItems.clear();
                }
            });
        } refreshOverview(); //reports overview
          refreshConsultations();
          refreshInventory();
          
          //refresh inventory
        setupColumns();
        loadData();
        setupActionColumnINVENTORY();   // the "⋮" per row
        setupInventorySearchFilter();
    }


    // --- If date is empty, auto-fill with today on click ---
    private void consultationDate_auto(MouseEvent event) {
        if (consultationDate_tf.getText() == null || consultationDate_tf.getText().isBlank()) {
            consultationDate_tf.setText(LocalDate.now().format(DATE_FMT));
        }
    }

    // ============================== Table row → form (View) =====================================
    private void onViewRow(Consultation c) {
        currentConsultationId = c.getConsultationId();
        currentSelected = c;

        AddEditConsultation_pane.setVisible(true);

        // Student (read-only field)
        currentConsultationStudentId   = c.getStudentId();
        currentConsultationStudentName = c.getStudentName(); // ensure model supplies it
        consultationName_tf.setText(currentConsultationStudentName);

        // Fill fields
        consultationDate_tf.setText(c.getConsultationDate() == null ? "" : c.getConsultationDate().format(DATE_FMT));
        consultationReason_tf.setText(c.getReasonForVisit());
        consultationBP_tf.setText(c.getBloodPressure());
        consultationTemperature_tf.setText(c.getTemperature() != null ? c.getTemperature().toString() : "");
        consultationDiagnosis_tf.setText(c.getDiagnosis());
        consultationTreatment_tf.setText(c.getTreatment());
        consultationReferral_tf.setText(c.getReferral());
        consultationPR_tf.setText(c.getPulseRate() != null ? c.getPulseRate().toString() : "");
        consultationRR_tf.setText(c.getRespiratoryRate() != null ? c.getRespiratoryRate().toString() : "");

        // Status labels
        BPstatus_label.setText(nullToEmpty(c.getBpStatus()));
        PRstatus_label.setText(nullToEmpty(c.getPulseStatus()));
        RRstatus_label.setText(nullToEmpty(c.getRespiratoryStatus()));
        
        // ======== NEW: load medicines dispensed for this consultation =========
        rxItems.setAll(ConsultationDAO.findMedsByConsultationId(currentConsultationId));
        rxTable.refresh();
        // =====================================================================

        // View mode
        setModeView();
    }

    // ============================== Vitals listeners & calculators ===============================
    private void attachVitalsStatusListeners() {
        // BP expects "SYS/DIA"
        consultationBP_tf.focusedProperty().addListener((obs, was, isNow) -> { if (!isNow) updateBpStatusLabel(); });
        consultationBP_tf.setOnKeyReleased(e -> updateBpStatusLabel());

        consultationPR_tf.focusedProperty().addListener((obs, was, isNow) -> { if (!isNow) updatePulseStatusLabel(); });
        consultationPR_tf.setOnKeyReleased(e -> updatePulseStatusLabel());

        consultationRR_tf.focusedProperty().addListener((obs, was, isNow) -> { if (!isNow) updateRespStatusLabel(); });
        consultationRR_tf.setOnKeyReleased(e -> updateRespStatusLabel());
    }

    private void updateBpStatusLabel() {
        String bp = consultationBP_tf.getText();
        if (bp != null && bp.contains("/")) {
            try {
                String[] p = bp.split("/");
                int sys = Integer.parseInt(p[0].trim());
                int dia = Integer.parseInt(p[1].trim());
                String status = (sys >= 130 || dia >= 90) ? "Hypertension"
                             : (sys <= 90  || dia <= 60)  ? "Hypotension"
                             : "Normal";
                BPstatus_label.setText(status);
            } catch (Exception ex) {
                BPstatus_label.setText("");
            }
        } else {
            BPstatus_label.setText("");
        }
    }

    private void updatePulseStatusLabel() {
        try {
            int pr = Integer.parseInt(consultationPR_tf.getText().trim());
            PRstatus_label.setText((pr >= 80 && pr <= 100) ? "Normal" : "Abnormal");
        } catch (Exception ex) {
            PRstatus_label.setText("");
        }
    }

    private void updateRespStatusLabel() {
        try {
            int rr = Integer.parseInt(consultationRR_tf.getText().trim());
            RRstatus_label.setText((rr >= 16 && rr <= 20) ? "Normal" : "Abnormal");
        } catch (Exception ex) {
            RRstatus_label.setText("");
        }
    }

    // ============================== Modes & field locking =======================================
    private void setFieldsEditable(boolean editable) {
        // Student name stays read-only; student can only be picked in ADD mode via hyperlink.
        pickStudent_hl.setDisable(currentConsultationId != null); // disabled when editing existing
        consultationName_tf.setEditable(false);

        consultationDate_tf.setEditable(true);
        consultationReason_tf.setEditable(editable);
        consultationBP_tf.setEditable(editable);
        consultationTemperature_tf.setEditable(editable);
        consultationDiagnosis_tf.setEditable(editable);
        consultationTreatment_tf.setEditable(editable);
        consultationReferral_tf.setEditable(editable);
        consultationPR_tf.setEditable(editable);
        consultationRR_tf.setEditable(editable);
    }

    private void clearFields() {
        currentConsultationId = null;
        currentSelected = null;
        currentConsultationStudentId = null;
        currentConsultationStudentName = null;

        consultationName_tf.clear();
        consultationDate_tf.clear();
        consultationReason_tf.clear();
        consultationBP_tf.clear();
        consultationTemperature_tf.clear();
        consultationDiagnosis_tf.clear();
        consultationTreatment_tf.clear();
        consultationReferral_tf.clear();
        consultationPR_tf.clear();
        consultationRR_tf.clear();

        BPstatus_label.setText("");
        PRstatus_label.setText("");
        RRstatus_label.setText("");
    }

    private void setModeAdd() {
        currentConsultationId = null;
        saveBtn.setDisable(false);
        editBtn.setDisable(true);
        deleteBtn.setDisable(true);
        cancelBtn.setDisable(false);
        setFieldsEditable(true);   // name is still via hyperlink; textfield remains read-only
        
        rxClear_btn.setDisable(false);
        rxAdd_btn.setDisable(false);
        rxTable.setDisable(false);
    }

    private void setModeView() {
        saveBtn.setDisable(true);
        editBtn.setDisable(false);
        deleteBtn.setDisable(false);
        cancelBtn.setDisable(false);
        setFieldsEditable(false);
        
        rxClear_btn.setDisable(true);
        rxAdd_btn.setDisable(true);
        rxTable.setDisable(true);
    }

    private void setModeEdit() {
        saveBtn.setDisable(false);
        editBtn.setDisable(true);
        deleteBtn.setDisable(false);
        cancelBtn.setDisable(false);
        setFieldsEditable(true);   // hyperlink disabled because currentConsultationId != null
        
        rxClear_btn.setDisable(false);
        rxAdd_btn.setDisable(false);
        rxTable.setDisable(false);
    }

    // Reload table
    private void refreshTable() {
        consultations.setAll(ConsultationDAO.findAllWithStudentName());
        consultation_tv.setItems(consultations);
    }

    //helper
    // Mark qty cell red if exceeding current balance (queries live balance)
    private void validateQtyAgainstStock(RxRow row, TableCell<?,?> cell) {
        if (row == null) return;
        Integer bal = InventoryDAO.findBalance(row.getItemId());
        boolean over = (bal != null) && (row.getQty() > bal);
        cell.setStyle(over ? "-fx-background-color: rgba(255,0,0,0.12);" : "");
        cell.setTooltip(over ? new Tooltip("Insufficient stock. Available: " + bal) : null);
    }

    
    @FXML
    private void onRxAdd(ActionEvent e) {
        InventoryPickerDialog dlg = new InventoryPickerDialog();
        dlg.showAndWait().ifPresent(inv -> {
            // use RxRow model
            RxRow existing = rxItems.stream()
                    .filter(r -> r.getItemId() == inv.getItemId())
                    .findFirst().orElse(null);
            if (existing != null) {
                existing.setQty(existing.getQty() + 1);
                rxTable.refresh();
            } else {
                rxItems.add(new RxRow(
                    inv.getItemId(),
                    inv.getItemName(),
                    inv.getUnit(),
                    1
                ));
            }
        });
    }


    @FXML
    private void onRxClear(ActionEvent e){ rxItems.clear(); }


    ////////////////////////////////////////////////////////////////////////////end consultation
       
    ////////////////////////////////////////////////////////////////////////////STUDENT RECORD/DETAILS

    @FXML
    private void uploadPhoto_btn(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp")
        );
        File f = fc.showOpenDialog(viewStudent_pane.getScene().getWindow());
        if (f == null) return;

        try {
            // ensure target folder exists
            File dir = new File(STUDENT_IMG_DIR);
            if (!dir.exists()) dir.mkdirs();

            // safe & unique name
            String ext = f.getName().toLowerCase().endsWith(".png") ? ".png" : ".jpg";
            String safeName = "student_" + System.currentTimeMillis() + ext;
            File dest = new File(dir, safeName);

            // copy uploaded file into writable folder
            Files.copy(f.toPath(), dest.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);

            // store absolute path (for DB)
            pendingPhotoPath = dest.getAbsolutePath();

            // update preview
//            Image preview = new Image(dest.toURI().toString(), false);
//            setCircularImage(image_imageView, preview, 120);
            showImage(pendingPhotoPath);
                
        } catch (Exception ex) {
            ex.printStackTrace();
            alert(Alert.AlertType.ERROR, "Upload Photo", "Failed to copy image:\n" + ex.getMessage());
        }
    }

    // -----------------------------------
    // Save new photo path to database
    // -----------------------------------
    @FXML
    private void savePhoto_btn(ActionEvent event) {
        if (currentStudentId == null) {
            alert(Alert.AlertType.WARNING, "No Student Selected", "Please select a student first.");
            return;
        }
        if (pendingPhotoPath == null || pendingPhotoPath.isBlank()) {
            alert(Alert.AlertType.WARNING, "No Photo Selected", "Please upload a photo before saving.");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
                "Save this new photo for the student?",
                ButtonType.OK, ButtonType.CANCEL);
        confirm.setHeaderText(null);

        confirm.showAndWait().ifPresent(btn -> {
            if (btn == ButtonType.OK) {
                String sql = "UPDATE students SET image = ? WHERE student_id = ?";
                try (Connection c = MySQL.connect();
                     PreparedStatement ps = c.prepareStatement(sql)) {

                    ps.setString(1, pendingPhotoPath);
                    ps.setInt(2, currentStudentId);
                    ps.executeUpdate();

                    alert(Alert.AlertType.INFORMATION, "Photo Saved", "Student photo has been updated successfully.");

                    // immediately refresh preview
                    showImage(pendingPhotoPath);
                    pendingPhotoPath = null;
                    loadStudents();

                } catch (Exception e) {
                    e.printStackTrace();
                    alert(Alert.AlertType.ERROR, "Save Photo Error", e.getMessage());
                }
            }
        });
    }

    
    @FXML
    private void editStudent_btn(ActionEvent event) {
        setEditable(true);
        saveStudent_btn_id.setDisable(false);
        cancelStudent_btn_id.setDisable(false);
    }

    @FXML
    private void saveStudent_btn(ActionEvent event) {
        if (currentStudentId == null) return;

        String sql = """
            UPDATE students
            SET age = ?, gender = ?, birthday = ?, birthplace = ?, course = ?, year_level = ?,
                civil_status = ?, religion = ?, height = ?, weight = ?, contact_number = ?,
                email = ?, status = ?, address = ?
            WHERE student_id = ?
            """;


        try (Connection c = MySQL.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {

            // --- 1) Map all fields ---
            setNullableInt(ps, 1, age_tf.getText());
            ps.setString(2, emptyToNull((String) gender_cb.getValue()));
            ps.setDate(3, birthday_dp.getValue() == null ? null : java.sql.Date.valueOf(birthday_dp.getValue()));
            ps.setString(4, emptyToNull(birthplace_tf.getText()));
            ps.setString(5, emptyToNull((String) course_cb.getValue()));
            ps.setString(6, emptyToNull((String) DETAILSyearLevel_cb.getValue()));
            ps.setString(7, emptyToNull(civilStatus_tf.getText()));
            ps.setString(8, emptyToNull(religion_tf.getText()));
            setNullableBigDecimal(ps, 9, height_tf.getText());
            setNullableBigDecimal(ps, 10, weight_tf.getText());
            ps.setString(11, emptyToNull(contactNo_tf.getText()));
            ps.setString(12, emptyToNull(email_tf.getText()));
            ps.setString(13, emptyToNull((String) DETAILSstatus_cb.getValue())); // active/inactive/graduated
            ps.setString(14, emptyToNull(address_tf.getText()));

//            // --- 2) Image path ---
//            if (pendingPhotoPath != null)
//                ps.setString(15, pendingPhotoPath);
//            else
//                ps.setNull(15, Types.VARCHAR);

            ps.setInt(15, currentStudentId);

            // --- 3) Execute update ---
            ps.executeUpdate();

            // --- 4) Auto-update the age column in DB ---
            refreshAgesOnStartup();

            // --- 5) Update the age text field immediately on UI ---
            if (birthday_dp.getValue() != null) {
                int computedAge = java.time.Period.between(birthday_dp.getValue(), java.time.LocalDate.now()).getYears();
                age_tf.setText(String.valueOf(computedAge));
            } else {
                age_tf.clear();
            }

            // --- 6) Final UI cleanup ---
            alert(Alert.AlertType.INFORMATION, "Save", "Student updated.");
            setEditable(false);
            saveStudent_btn_id.setDisable(true);
            cancelStudent_btn_id.setDisable(true);

            // refresh table and dashboard
            loadStudents();
            loadDashboardStats();
            refreshOverview();//report overview (active students)

        } catch (Exception e) {
            e.printStackTrace();
            showExceptionDialog( "Save", e);
        }
    }
    
private void showExceptionDialog(String header, Throwable ex) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText(header);
    alert.setContentText(ex.getMessage());

    StringWriter sw = new StringWriter();
    ex.printStackTrace(new PrintWriter(sw));
    String stack = sw.toString();

    TextArea area = new TextArea(stack);
    area.setEditable(false);
    area.setWrapText(false);
    area.setMaxWidth(Double.MAX_VALUE);
    area.setMaxHeight(Double.MAX_VALUE);
    GridPane.setVgrow(area, Priority.ALWAYS);
    GridPane.setHgrow(area, Priority.ALWAYS);

    GridPane exp = new GridPane();
    exp.setMaxWidth(Double.MAX_VALUE);
    exp.add(new Label("Stacktrace:"), 0, 0);
    exp.add(area, 0, 1);

    alert.getDialogPane().setExpandableContent(exp);
    alert.getDialogPane().setExpanded(false);     // close by default
    alert.getDialogPane().setMinWidth(600);
    alert.showAndWait();
}



    @FXML
    private void cancelStudent_btn(ActionEvent event) {
    viewStudent_pane.setVisible(false);
    StudentRecord_pane1.setVisible(false); // optional
    StudentRecord_pane.setVisible(true);
    StudentRecord_pane.toFront();
    
        setEditable(false);
        saveStudent_btn_id.setDisable(true);
        cancelStudent_btn_id.setDisable(true);
        pendingPhotoPath = null;
        currentStudentId = null;
        // hide details, show the list again
    }

    @FXML
    private void backButton_STUDENTLIST(MouseEvent event) {
        StudentRecord_pane1.setVisible(false);
        StudentRecord_pane.setVisible(true);
        
        saveStudent_btn_id.setDisable(true);
        cancelStudent_btn_id.setDisable(true);
    }

    // FILTER STUDENT RECORDS
    private void refreshStudentPredicate() {
        
    // *ComboBox Selection*           *Shown Students*
    //All                       -   Only Active students
    //Inactive                  -   Only Inactive students
    //Graduated                 -   Only Graduated students
    //1st–4th Year / Irregular  -   Only Active students of that year level

    
        final String q = safeLower(filterField1.getText());
        final Toggle selected = courseFilter.getSelectedToggle();
        final String courseFilterVal = (selected == null || selected.getUserData() == null)
                ? "ALL" : selected.getUserData().toString();

        final String yearSel = yearLevel_cb.getValue() == null ? "All" : yearLevel_cb.getValue();

        filtered.setPredicate(s -> {
            if (s == null) return false;

            // 1) Search (by name or ID number)
            if (!q.isEmpty()) {
                String fullName = (nz(s.getLastName()) + " " + nz(s.getFirstName()) + " " + nz(s.getMiddleName())).toLowerCase();
                String idStr = nz(s.getIdNumber());
                if (!(fullName.contains(q) || idStr.toLowerCase().contains(q))) return false;
            }

            // 2) Course toggle
            if (!"ALL".equalsIgnoreCase(courseFilterVal)) {
                if (!nz(s.getCourse()).equalsIgnoreCase(courseFilterVal)) return false;
            }

            // 3) Year-level / Status filters
            if (!"All".equalsIgnoreCase(yearSel)) {

                if ("Graduated".equalsIgnoreCase(yearSel)) {
                    // show only graduated
                    if (!(s.getIsActive() == 2 || "graduated".equalsIgnoreCase(nz(s.getStatus())))) return false;

                } else if ("Inactive".equalsIgnoreCase(yearSel)) {
                    // show only inactive
                    if (!(s.getIsActive() == 0 || "inactive".equalsIgnoreCase(nz(s.getStatus())))) return false;

                } else {
                    // show specific year level → only active students
                    if (!nz(s.getYearLevel()).equalsIgnoreCase(yearSel)) return false;
                    if (!(s.getIsActive() == 1 || "active".equalsIgnoreCase(nz(s.getStatus())))) return false;
                }

            } else {
                // “All” = show only active
                if (!(s.getIsActive() == 1 || "active".equalsIgnoreCase(nz(s.getStatus())))) return false;
            }

            return true;
        });
    }
    
    private void refreshAgesOnStartup() {
        String sql = "UPDATE students SET age = TIMESTAMPDIFF(YEAR, birthday, CURDATE()) WHERE birthday IS NOT NULL";
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    // ====== Load minimal rows for the table (active + graduated visible, inactive filterable) ======
    private void loadStudents() {
        students.clear();

        String sql = """
            SELECT student_id, id_number, last_name, first_name, middle_name, course, year_level,
                   gender, age, contact_number, status, is_active, image
            FROM students
            WHERE is_active IN (0,1,2)  -- load all states; filters will decide which to show
            ORDER BY created_at DESC, last_name ASC
            """;

        try (Connection c = MySQL.connect();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                students.add(new Student(
                    rs.getInt("student_id"),
                    rs.getString("id_number"),
                    rs.getString("last_name"),
                    rs.getString("first_name"),
                    rs.getString("middle_name"),
                    rs.getString("course"),
                    rs.getString("year_level"),
                    rs.getString("gender"),
                    (Integer) rs.getObject("age"),
                    rs.getString("contact_number"),
                    rs.getString("status"),
                    rs.getInt("is_active"),
                    rs.getString("image") // path
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
            alert(Alert.AlertType.ERROR, "Load Students", e.getMessage());
        }
    }


        // ====== ⋮ column ======
        private void setupActionColumn() {
                action_col.setCellFactory(col -> new TableCell<>() {
                    private final Button btn = new Button("⋮");
                    {
                        btn.getStyleClass().add("action-menu-btn");
                        MenuItem view = new MenuItem("View");
                        MenuItem del  = new MenuItem("Delete");
                        ContextMenu cm = new ContextMenu(view, del);
                        btn.setOnAction(e -> cm.show(btn, javafx.geometry.Side.BOTTOM, 0, 0));

                        view.setOnAction(e -> {
                            Student s = getTableView().getItems().get(getIndex());
                            showStudent(s.getId());
                        });
                        del.setOnAction(e -> {
                            Student s = getTableView().getItems().get(getIndex());
                            deleteStudent(s.getId());
                        });
                    }
                    @Override protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        setGraphic(empty ? null : btn);
                    }
                });
            }

    // ====== View details (fills pane) ======
    private void showStudent(int studentId) {
        course_cb.setDisable(true);
        gender_cb.setDisable(true);
        DETAILSyearLevel_cb.setDisable(true);
        DETAILSstatus_cb.setDisable(true);
        birthday_dp.setDisable(true);
        
        String sqlStudent = "SELECT * FROM students WHERE student_id = ?";
        String sqlHistory = """
            SELECT past_illnesses, allergies, medications, immunizations, family_history, created_at
            FROM student_history
            WHERE student_id = ?
            ORDER BY created_at DESC
            """;

        try (Connection c = MySQL.connect()) {
            // main
            try (PreparedStatement ps = c.prepareStatement(sqlStudent)) {
                ps.setInt(1, studentId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) return;

                    currentStudentId = studentId;
                    pendingPhotoPath = null;

                    // header
                    fullName_label.setText(nz(rs.getString("last_name")) + ", " +
                                           nz(rs.getString("first_name")) +
                                           (nz(rs.getString("middle_name")).isBlank() ? "" : " " + nz(rs.getString("middle_name"))));
                    idNumber_label.setText(nz(rs.getString("id_number")));

                    // basic text fields
                    setText(age_tf,        obj(rs.getObject("age")));
                    setText(birthplace_tf, nz(rs.getString("birthplace")));
                    setText(civilStatus_tf,nz(rs.getString("civil_status")));
                    setText(religion_tf,   nz(rs.getString("religion")));
                    setText(height_tf,     obj(rs.getObject("height")));
                    setText(weight_tf,     obj(rs.getObject("weight")));
                    setText(contactNo_tf,  nz(rs.getString("contact_number")));
                    setText(email_tf,      nz(rs.getString("email")));
                    setText(address_tf,    nz(rs.getString("address")));

                    // combos
                    course_cb.getSelectionModel().select(nz(rs.getString("course")));
                    gender_cb.getSelectionModel().select(nz(rs.getString("gender")));
                    DETAILSyearLevel_cb.getSelectionModel().select(nz(rs.getString("year_level")));
                    DETAILSstatus_cb.getSelectionModel().select(nz(rs.getString("status")));

                    // date
                    java.sql.Date bday = rs.getDate("birthday");
                    birthday_dp.setValue(bday == null ? null : bday.toLocalDate());

                    // image path
                    String path = rs.getString("image");
                    showImage(path); // change showImage to accept path
                }
            }

            // history (unchanged)
            StringBuilder sb = new StringBuilder();
            try (PreparedStatement ps = c.prepareStatement(sqlHistory)) {
                ps.setInt(1, studentId);
                try (ResultSet rs = ps.executeQuery()) {
                    int i = 1;
                    while (rs.next()) {
                        if (i > 1) sb.append("\n\n");
                        sb.append("History #").append(i++).append(" (").append(obj(rs.getObject("created_at"))).append(")\n");
                        appendIf(sb, "Past Illnesses", rs.getString("past_illnesses"));
                        appendIf(sb, "Allergies",      rs.getString("allergies"));
                        appendIf(sb, "Medications",    rs.getString("medications"));
                        appendIf(sb, "Immunizations",  rs.getString("immunizations"));
                        appendIf(sb, "Family History", rs.getString("family_history"));
                    }
                }
            }
            history_textArea.setText(sb.toString());

            viewStudent_pane.setVisible(true);
            StudentRecord_pane1.setVisible(true);
            StudentRecord_pane1.toFront();
            StudentRecord_pane.setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
            alert(Alert.AlertType.ERROR, "View Student", e.getMessage());
        }
    }

    // ====== Delete with dependency check ======
    private void deleteStudent(int id) {
        // count linked data
        String q1 = "SELECT COUNT(*) FROM consultations WHERE student_id = ?";
        String q2 = "SELECT COUNT(*) FROM visit_log     WHERE student_id = ?";

        try (Connection c = MySQL.connect()) {
            int consults = 0, visits = 0;
            try (PreparedStatement ps = c.prepareStatement(q1)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) { if (rs.next()) consults = rs.getInt(1); }
            }
            try (PreparedStatement ps = c.prepareStatement(q2)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) { if (rs.next()) visits = rs.getInt(1); }
            }

            if (consults > 0 || visits > 0) {
                alert(Alert.AlertType.WARNING, "Cannot Delete",
                    "This record has linked data:\n" +
                    "- Consultations: " + consults + "\n" +
                    "- Visit logs: " + visits + "\n\n" +
                    "Tip: Set status to INACTIVE instead.");
                return;
            }

            // Confirm permanent delete
            Alert a = new Alert(Alert.AlertType.CONFIRMATION,
                    "No linked data found. Permanently delete this student (and their histories)?",
                    ButtonType.OK, ButtonType.CANCEL);
            a.setHeaderText(null);
            a.showAndWait().ifPresent(b -> {
                if (b == ButtonType.OK) {
                    // hard delete; student_history should be ON DELETE CASCADE
                    String delHist = "DELETE FROM student_history WHERE student_id = ?";
                    String delStud = "DELETE FROM students WHERE student_id = ?";
                    try (PreparedStatement ps1 = c.prepareStatement(delHist);
                         PreparedStatement ps2 = c.prepareStatement(delStud)) {
                        c.setAutoCommit(false);
                        ps1.setInt(1, id); ps1.executeUpdate();
                        ps2.setInt(1, id); ps2.executeUpdate();
                        c.commit();
                        students.removeIf(s -> s.getId() == id);
                        if (currentStudentId != null && currentStudentId == id) viewStudent_pane.setVisible(false);
                        alert(Alert.AlertType.INFORMATION, "Deleted", "Student permanently deleted.");
                    } catch (Exception ex) {
                        try { c.rollback(); } catch (Exception ignore) {}
                        ex.printStackTrace();
                        alert(Alert.AlertType.ERROR, "Delete", ex.getMessage());
                    } finally {
                        try { c.setAutoCommit(true); } catch (Exception ignore) {}
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            alert(Alert.AlertType.ERROR, "Delete", e.getMessage());
        }
        loadDashboardStats();
        refreshOverview();
    }

    // ====== helpers ======
    private void setEditable(boolean b) {
    // text fields that remain text
//        age_tf.setEditable(b);
        birthplace_tf.setEditable(b);
        civilStatus_tf.setEditable(b);
        religion_tf.setEditable(b);
        height_tf.setEditable(b);
        weight_tf.setEditable(b);
        contactNo_tf.setEditable(b);
        email_tf.setEditable(b);
        address_tf.setEditable(b);

        course_cb.setDisable(!b);
        gender_cb.setDisable(!b);
        DETAILSyearLevel_cb.setDisable(!b);
        DETAILSstatus_cb.setDisable(!b);
        birthday_dp.setDisable(!b);
    }

        
    @FXML
    private void SEARCHBAR_mouseclicked(MouseEvent event) {
    }
    ////////////////////////////////////////////////////////////////////////////end student record
    
    ////////////////////////////////////////////////////////////////////////////ADD NEW STUDENT
    @FXML
    private void backButton_ADDstudentFORM(MouseEvent event) {
        if (addStudent_sideNav==0){
            AddStudent_pane.setVisible(false);
            
            StudentRecord_pane.setVisible(true);
        } else {
             AddStudent_pane.setVisible(false);
             StudentRecord_pane.setVisible(false);
             StudentRecord_pane1.setVisible(false);
             Consultations_pane.setVisible(false);
             Reports_pane.setVisible(false);
             Inventory_pane.setVisible(false);
             VisitLog_pane.setVisible(false);
             Notification_pane.setVisible(false);
             
             Dashboard_pane.setVisible(true);
             //toggle
             sideNav.selectToggle(sidebtn_dashboard);
        }
        addStudent_sideNav = 0;
    }
    
    @FXML
    private void addNewStudent(ActionEvent event) {
        setCircularImage(addStudent_imageview, defaultStudentImage(), 80); 
        
        StudentRecord_pane.setVisible(false);
        AddStudent_pane.setVisible(true);
        AddStudent_pane.toFront();
    }
    
    @FXML
    private void addStudent_upload(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Select Student Photo");
        fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        File file = fc.showOpenDialog(addStudent_imageview.getScene().getWindow());
        if (file == null) return;

        try {
            // stage the selected absolute path (copy will happen on SAVE)
            pendingStudentPhotoPath = file.getAbsolutePath();

            // circular preview (120 is a good size for add form)
            Image preview = new Image(file.toURI().toString(), false);
            setCircularImage(addStudent_imageview, preview, 80);

        } catch (Exception ex) {
            ex.printStackTrace();
            showError("Failed to load image: " + ex.getMessage());
            pendingStudentPhotoPath = null;
            addStudent_imageview.setImage(null);
        }
    }


    @FXML
    private void addStudent_cancel(ActionEvent event) {
        clearAddStudentForm();
        draftHistoryForNewStudent = null; //ir there is any saved draft history
        AddStudent_pane.setVisible(false);
        StudentRecord_pane.setVisible(true);
        
         // clear any staged file and restore default circular avatar
        pendingStudentPhotoPath = null;
        setCircularImage(addStudent_imageview, defaultStudentImage(), 80);
       
    }
    
    private Image defaultStudentImage() {
        URL url = getClass().getResource("/image/default-user.png");
        // If present in your jar, url != null both in IDE and installer
        return (url != null) ? new Image(url.toExternalForm(), true) : null;
    }

    @FXML
    private void addStudent_save(ActionEvent event) {
        // 1) Required fields
        String idNumber   = trimOrNull(addStudent_idNum_tf.getText());
        String lastName   = trimOrNull(addStudent_lastName_tf.getText());
        String firstName  = trimOrNull(addStudent_firstName_tf.getText());
        String course     = addStudent_course_cb.getValue();
        String yearLevel  = addStudent_year_cb.getValue();
        String gender     = addStudent_gender_cb.getValue();
        if (idNumber == null || lastName == null || firstName == null ||
            course == null || yearLevel == null || gender == null ||
            addStudent_birthday_dp.getValue() == null) {
            showError("Please fill in all required fields (ID No., Name, Course, Year, Gender, Birthday).");
            return;
        }

        // 2) Optional fields
        String middleName = trimOrNull(addStudent_middleName_tf.getText());
        String address    = trimOrNull(addStudent_address_tf.getText());
        String contact    = trimOrNull(addStudent_contact_tf.getText());
        String civil      = trimOrNull(addStudent_civil_tf.getText());
        String email      = trimOrNull(addStudent_email_tf.getText());
        String birthplace = trimOrNull(addStudent_birthplace_tf.getText());
        String religion   = trimOrNull(addStudent_religion_tf.getText());

        Integer age             = parseIntOrNull(addStudent_age_tf.getText());  // will be refreshed anyway
        java.sql.Date birthday  = java.sql.Date.valueOf(addStudent_birthday_dp.getValue());
        Double height           = parseDoubleOrNull(addStudent_height_tf.getText());
        Double weight           = parseDoubleOrNull(addStudent_weight_tf.getText());

        // 3) Decide final image path (copy staged file into app folder if any)
        String finalImagePath = null;
        try {
            if (pendingStudentPhotoPath != null) {
                File dir = new File(STUDENT_IMG_DIR);
                if (!dir.exists()) dir.mkdirs();

                // unique & readable file name
                String ext = pendingStudentPhotoPath.toLowerCase().endsWith(".png") ? ".png" : ".jpg";
                String safeId = idNumber.replaceAll("[^A-Za-z0-9_-]", "_");
                File dest = new File(dir, "student_" + safeId + "_" + System.currentTimeMillis() + ext);

                Files.copy(new File(pendingStudentPhotoPath).toPath(), dest.toPath(),
                           java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                finalImagePath = dest.getAbsolutePath();
            }
        } catch (IOException io) {
            io.printStackTrace();
            showError("Unable to save photo file.\n" + io.getMessage());
            return;
        }

        // 4) Insert into DB
        try {
            int newId = insertStudent(
                idNumber, lastName, firstName, middleName,
                course, yearLevel, gender, age, contact,
                address, birthday, birthplace, civil, religion,
                height, weight, email,
                /* status    */ "active",
                /* imagePath */ finalImagePath,
                /* isActive  */ 1   // 1=active; your trigger keeps this in sync with status too
            );

            // Persist drafted history (if any)
            if (draftHistoryForNewStudent != null) {
                draftHistoryForNewStudent.setStudentId(newId);
                historyDAO.upsert(draftHistoryForNewStudent);
                draftHistoryForNewStudent = null;
            }

            showInfo("Student added (ID: " + idNumber + ").");
            clearAddStudentForm();
            AddStudent_pane.setVisible(false);

            refreshAgesOnStartup();  // recompute ages (Option B you chose)
            loadStudents();          // refresh table
            StudentRecord_pane.setVisible(true);

        } catch (java.sql.SQLIntegrityConstraintViolationException dupe) {
            showError("ID Number already exists. Please use a unique ID.");
        } catch (Exception ex) {
            ex.printStackTrace();
            showError("Failed to save student.\n" + ex.getMessage());
        }
        loadDashboardStats();
        refreshOverview();
    }

    
    private int insertStudent(
        String idNumber, String lastName, String firstName, String middleName,
        String course, String yearLevel, String gender, Integer age, String contact,
        String address, java.sql.Date birthday, String birthplace, String civil, String religion,
        Double height, Double weight, String email,
        String status, String imagePath, int isActive
    ) throws Exception {

        String sql = """
            INSERT INTO students
            (id_number, last_name, first_name, middle_name,
             course, year_level, gender, age, contact_number, address,
             birthday, birthplace, civil_status, religion,
             height, weight, email, status, image, is_active)
            VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)
        """;

        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            int i = 1;
            ps.setString(i++, idNumber);                  // 1
            ps.setString(i++, lastName);                  // 2
            ps.setString(i++, firstName);                 // 3
            setNullable(ps, i++, middleName);             // 4
            ps.setString(i++, course);                    // 5
            ps.setString(i++, yearLevel);                 // 6
            ps.setString(i++, gender);                    // 7
            setNullable(ps, i++, age);                    // 8
            setNullable(ps, i++, contact);                // 9
            setNullable(ps, i++, address);                // 10
            ps.setDate(i++, birthday);                    // 11
            setNullable(ps, i++, birthplace);             // 12
            setNullable(ps, i++, civil);                  // 13
            setNullable(ps, i++, religion);               // 14
            setNullable(ps, i++, height);                 // 15
            setNullable(ps, i++, weight);                 // 16
            setNullable(ps, i++, email);                  // 17
            ps.setString(i++, status);                    // 18
            setNullable(ps, i++, imagePath);              // 19  (VARCHAR path)
            ps.setInt(i++, isActive);                     // 20  (0/1/2)

            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1);
            }
        }
        return -1;
    }


    private void clearAddStudentForm() {
        addStudent_idNum_tf.clear();
        addStudent_lastName_tf.clear();
        addStudent_firstName_tf.clear();
        addStudent_middleName_tf.clear();
        addStudent_age_tf.clear();
        addStudent_address_tf.clear();
        addStudent_contact_tf.clear();
        addStudent_civil_tf.clear();
        addStudent_email_tf.clear();
        addStudent_course_cb.getSelectionModel().clearSelection();
        addStudent_year_cb.getSelectionModel().clearSelection();
        addStudent_gender_cb.getSelectionModel().clearSelection();
        addStudent_birthday_dp.setValue(null);
        addStudent_birthplace_tf.clear();
        addStudent_height_tf.clear();
        addStudent_weight_tf.clear();
        addStudent_religion_tf.clear();

        // preview reset (optional: show default avatar circular)
        pendingStudentPhotoPath = null;
        addStudent_imageview.setImage(null); // or: setCircularImage(addStudent_imageview, defaultAvatar(), 120);
    }

    
    ////////////////////////////////////////////////////////////////////////////end add new student
    
    ////////////////////////////////////////////////////////////////////////////HISTORY
    @FXML
    private void addStudent_addHistory(ActionEvent event) {
        historyMode = HistoryMode.ADD_FOR_NEW_STUDENT;

       // If the user previously typed something, show it again; else clear fields
       if (draftHistoryForNewStudent != null) {
           pastIllnesses_ta.setText(draftHistoryForNewStudent.getPastIllnesses());
           allergies_ta.setText(draftHistoryForNewStudent.getAllergies());
           medications_ta.setText(draftHistoryForNewStudent.getMedications());
           immunizations_ta.setText(draftHistoryForNewStudent.getImmunizations());
           familyHistory_ta.setText(draftHistoryForNewStudent.getFamilyHistory());
       } else {
           pastIllnesses_ta.clear();
           allergies_ta.clear();
           medications_ta.clear();
           immunizations_ta.clear();
           familyHistory_ta.clear();
       }

       // Show the same History form
       AddStudent_pane.setDisable(true);
       HistoryForm_pane.setVisible(true);
       HistoryForm_pane.toFront();
       
       SIDENAV_VBOX.setDisable(true);
    }

    @FXML
    private void edit_HISTORY(ActionEvent event) {
        historyMode = HistoryMode.EDIT_EXISTING;
    
        StudentRecord_pane1.setDisable(true);
        HistoryForm_pane.setVisible(true);
        HistoryForm_pane.toFront();
        
    // Load existing history (if any) into the form / for currentStudentId 
    try {
        StudentHistory h = historyDAO.findByStudentId(currentStudentId);
        if (h != null) {
            pastIllnesses_ta.setText(nz(h.getPastIllnesses()));
            allergies_ta.setText(nz(h.getAllergies()));
            medications_ta.setText(nz(h.getMedications()));
            immunizations_ta.setText(nz(h.getImmunizations()));
            familyHistory_ta.setText(nz(h.getFamilyHistory()));
        } else {
            // No record yet: clear all fields
            pastIllnesses_ta.clear();
            allergies_ta.clear();
            medications_ta.clear();
            immunizations_ta.clear();
            familyHistory_ta.clear();
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        // optionally show an alert
        showError("Failed to load history.\n" + ex.getMessage());
    }
    }

    @FXML
    private void cancelHistory(ActionEvent event) {
    if (historyMode == HistoryMode.EDIT_EXISTING) {
        StudentRecord_pane1.setDisable(false);
    } else {
        AddStudent_pane.setDisable(false);
    }
    HistoryForm_pane.setVisible(false);
    SIDENAV_VBOX.setDisable(false);
}

    @FXML
    private void saveHistory(ActionEvent event) {
    // Build from form
    StudentHistory h = new StudentHistory(currentStudentId != null ? currentStudentId : -1);
    h.setPastIllnesses(pastIllnesses_ta.getText());
    h.setAllergies(allergies_ta.getText());
    h.setMedications(medications_ta.getText());
    h.setImmunizations(immunizations_ta.getText());
    h.setFamilyHistory(familyHistory_ta.getText());

    try {
        if (historyMode == HistoryMode.EDIT_EXISTING) {
            // Update DB immediately
            historyDAO.upsert(h);

            // refresh the main view that shows history summary
            refreshHistoryView();

            showInfo("History saved.");
            StudentRecord_pane1.setDisable(false);
        } else {
            // ADD_FOR_NEW_STUDENT: no student_id yet; just stage it in memory
            draftHistoryForNewStudent = h; // keep the values
            showInfo("History saved (will be attached when the student is created).");
            AddStudent_pane.setDisable(false);
        }

        HistoryForm_pane.setVisible(false);
        SIDENAV_VBOX.setDisable(false);
        
    } catch (Exception ex) {
        ex.printStackTrace();
        showError("Failed to save history.\n" + ex.getMessage());
    }
}
    
    private String buildHistorySummary(StudentHistory h) {
    if (h == null) return "No history available.";

    StringBuilder sb = new StringBuilder();
    if (!nz(h.getPastIllnesses()).isEmpty())
        sb.append("Past illnesses: ").append(h.getPastIllnesses()).append("\n");
    if (!nz(h.getAllergies()).isEmpty())
        sb.append("Allergies: ").append(h.getAllergies()).append("\n");
    if (!nz(h.getMedications()).isEmpty())
        sb.append("Medications: ").append(h.getMedications()).append("\n");
    if (!nz(h.getImmunizations()).isEmpty())
        sb.append("Immunizations: ").append(h.getImmunizations()).append("\n");
    if (!nz(h.getFamilyHistory()).isEmpty())
        sb.append("Family history: ").append(h.getFamilyHistory()).append("\n");

    String s = sb.toString().trim();
    return s.isEmpty() ? "No history available." : s;
}
    
    private void refreshHistoryView() {
    try {
        StudentHistory fresh = historyDAO.findByStudentId(currentStudentId);
        history_textArea.setText(buildHistorySummary(fresh));
    } catch (Exception ex) {
        ex.printStackTrace();
        showError("Failed to reload history.\n" + ex.getMessage());
    }
}
    
    ////////////////////////////////////////////////////////////////////////////end history

    
    ////////////////////////////////////////////////////////////////////////////VISIT LOG
    // ====================== VISIT LOG: columns ======================
    private void setupColumnsVISITLOG() {
        visitDate_col.setCellValueFactory(new PropertyValueFactory<>("visitDate"));
        visitName_col.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        visitReason_col.setCellValueFactory(new PropertyValueFactory<>("reason"));

        // optional: nicer date text
        visitDate_col.setCellFactory(col -> new TableCell<>() {
            @Override protected void updateItem(LocalDate d, boolean empty) {
                super.updateItem(d, empty);
                setText(empty || d == null ? "" : d.toString());
            }
        });
    }

    // ====================== VISIT LOG: data ======================
    private void loadVisitLogs() {
        rows = VisitLogDAO.findAll();
        visitLog_tv.setItems(rows);
    }

    // ====================== VISIT LOG: open add form ======================
    @FXML
    private void VisitLog_AddNew(ActionEvent event) {
        VisitLog_pane.setDisable(true);
        VisitLog_addpane.setVisible(true);

        // default date = today
        visitDate_tf.setText(LocalDate.now().toString()); // yyyy-MM-dd

        // clear current selection
        visitAdd_studentId = null;
        visitAdd_fullName  = null;
        visitAdd_idNumber  = null;
        visitName_tf.clear();
        visitReason_tf.clear();
        visitLog_searchStudent_hl.requestFocus();
    }

    // ====================== VISIT LOG: student picker hyperlink ======================
    /** Opens the same StudentPicker dialog use in Consultation/Med Certificate.
     *  The dialog should allow searching by name OR id_number.
     *  It must return student_id, id_number, and display name.
     */
    // (Visit Log / Consultation / Med Cert):
    @FXML
    private void visitLog_searchStudent_hl(ActionEvent e) {
        StudentPickerDialog dlg = new StudentPickerDialog();

        // Optional: set owner (so it centers on window)
        dlg.initOwner(VisitLog_addpane.getScene().getWindow());

        java.util.Optional<StudentPick> res = dlg.showAndWait(); // <-- no arguments

        res.ifPresent(pick -> {
            // keep what you need
            visitAdd_studentId = pick.getStudentId();
            visitAdd_fullName  = pick.getFullName();
            visitAdd_idNumber  = pick.getIdNumber();

            // show “ID – Name” in the read-only field
            visitName_tf.setText(pick.getIdNumber() + " – " + pick.getFullName());
        });
    }


    // ====================== VISIT LOG: save new row ======================
    @FXML
    private void addVL_add(ActionEvent event) {
        // validate date
        final LocalDate date;
        try {
            date = LocalDate.parse(
                    visitDate_tf.getText().trim(),
                    java.time.format.DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (Exception e) {
            warn("Date must be in yyyy-MM-dd format.");
            return;
        }

        if (visitAdd_studentId == null) {
            warn("Please select a student.");
            return;
        }

        final String reason = (visitReason_tf.getText() == null)
                ? null : visitReason_tf.getText().trim();

        int newId = VisitLogDAO.insert(date, visitAdd_studentId, reason);
        if (newId <= 0) { error("Insert failed."); return; }

        // Add to table (show full name; if you need id_number in table, add a column)
        rows.add(0, new VisitLogRow(newId, date, visitAdd_studentId, visitAdd_fullName, reason));

        // close form
        clearAddForm();
        VisitLog_pane.setDisable(false);
        VisitLog_addpane.setVisible(false);

        loadDashboardStats(); // if you show live stats on the dashboard
        refreshVisits();
    }

    // ====================== VISIT LOG: cancel ======================
    @FXML
    private void addVL_cancel(ActionEvent event) {
        clearAddForm();
        VisitLog_pane.setDisable(false);
        VisitLog_addpane.setVisible(false);
    }

    // ====================== VISIT LOG: delete ======================
    @FXML
    private void VisitLog_Delete(ActionEvent event) {
        VisitLogRow sel = visitLog_tv.getSelectionModel().getSelectedItem();
        if (sel == null) { warn("Please select a visit log to delete."); return; }

        Alert a = new Alert(Alert.AlertType.CONFIRMATION,
            "Delete visit log dated " + sel.getVisitDate() + " for " + sel.getStudentName() + "?",
            ButtonType.OK, ButtonType.CANCEL);
        a.setHeaderText(null);
        a.showAndWait().ifPresent(bt -> {
            if (bt == ButtonType.OK) {
                boolean ok = VisitLogDAO.deleteById(sel.getVisitId());
                if (ok) rows.remove(sel); else error("Delete failed.");
            }
        });
        loadDashboardStats();
        refreshVisits();
    }

    // ====================== VISIT LOG: helpers ======================
    private void clearAddForm() {
        visitDate_tf.clear();
        visitReason_tf.clear();
        visitName_tf.clear();
        visitAdd_studentId = null;
        visitAdd_fullName  = null;
        visitAdd_idNumber  = null;
    }

    // simple alerts you already had
    private void warn(String msg){ new Alert(Alert.AlertType.WARNING,msg,ButtonType.OK).showAndWait(); }
    private void error(String msg){ new Alert(Alert.AlertType.ERROR,msg,ButtonType.OK).showAndWait(); }

    ////////////////////////////////////////////////////////////////////////////end visit log
    
    ////////////////////////////////////////////////////////////////////////////INVENTORY
    private void setupColumns() {
     inventoryCode_col.setCellValueFactory(new PropertyValueFactory<>("itemId"));
     inventoryName_col.setCellValueFactory(new PropertyValueFactory<>("itemName"));
     inventoryType_col.setCellValueFactory(new PropertyValueFactory<>("type"));
     inventoryQuantity_col.setCellValueFactory(new PropertyValueFactory<>("quantity"));
     inventoryUsed_col.setCellValueFactory(new PropertyValueFactory<>("totalUsed"));
     inventoryBalance_col.setCellValueFactory(new PropertyValueFactory<>("balanceStock"));
     inventoryUnit_col.setCellValueFactory(new PropertyValueFactory<>("unit"));
     inventoryExpiry_col.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
     inventoryStatus_col.setCellValueFactory(new PropertyValueFactory<>("status"));

     // Pretty date format
     inventoryExpiry_col.setCellFactory(col -> new TableCell<>() {
         @Override protected void updateItem(LocalDate d, boolean empty) {
             super.updateItem(d, empty);
             setText(empty || d == null ? "" : d.toString());
         }
     });

 }

    private void loadData() {
        data = InventoryDAO.findAll();
        inventory_tv.setItems(data);
        
    }
    
    private void setupInventoryTable() {
        inventoryMaster.setAll(InventoryDAO.findAll()); // load from DB once

        inventoryFiltered = new FilteredList<>(inventoryMaster, it -> true);
        inventorySorted   = new SortedList<>(inventoryFiltered);
        inventorySorted.comparatorProperty().bind(inventory_tv.comparatorProperty());
        inventory_tv.setItems(inventorySorted);
    }

    private void setupActionColumnINVENTORY() {
        Callback<TableColumn<Inventory, Void>, TableCell<Inventory, Void>> cellFactory = col -> new TableCell<>() {

            private final Button dots = new Button("⋮"); // vertical three dots
            private final ContextMenu menu = new ContextMenu();
            private final MenuItem edit = new MenuItem("Edit");
            private final MenuItem delete = new MenuItem("Delete");

            {
                dots.getStyleClass().add("action-dots"); // style in CSS 
                dots.setFocusTraversable(false);

                menu.getItems().addAll(edit, delete);

                dots.setOnAction(e -> {
                    // show context menu anchored to button
                    menu.show(dots, javafx.geometry.Side.BOTTOM, 0, 0);
                });
                
                edit.setOnAction(e -> {
                Inventory inv = getTableView().getItems().get(getIndex());
                // open the same pane in edit mode
                openEditPane(inv);
                });


                delete.setOnAction(e -> {
                    Inventory inv = getTableView().getItems().get(getIndex());
                    confirmAndDelete(inv);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : dots);
                setText(null);
            }
        };

        inventoryAction_col.setCellFactory(cellFactory);
    }

    private void confirmAndDelete(Inventory inv) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Delete Inventory Item");
        a.setHeaderText(null);
        a.setContentText("Delete \"" + inv.getItemName() + "\"?");
        a.showAndWait().ifPresent(btn -> {
            if (btn == ButtonType.OK) {
                boolean ok = InventoryDAO.deleteById(inv.getItemId());
                if (ok) {
                    inventory_tv.getItems().remove(inv);
                } else {
                    new Alert(Alert.AlertType.ERROR, "Delete failed.").showAndWait();
                }
            }
        });
        
        loadDashboardStats();
        triggerNotifRefreshNow(); //TO UPDATE LABEL BADGE IN NOTIFICATION (FOR INVENTORY OF MEDICINE - STOCK)
        refreshOverview(); //reports overview
        refreshInventory();
    }

    // Hook your existing edit popup here
    private void openEditDialog(Inventory inv) {
        // TODO: show your edit form (Stage/Dialog), bind fields to `inv`,
        // call InventoryDAO.update(inv) on Save, then refresh the row.
        // For a quick refresh after update:
        // inventory_tv.refresh();
    }
    
    @FXML
    private void AddNewStock(ActionEvent event) {
         startAdd();
    }

    @FXML
    private void InventorySave(ActionEvent event) {
            // 1) Read + validate inputs
        String name = inventoryItem_tf.getText().trim();
        String type = inventoryType_tf.getText().trim();
        String unit = inventoryUnit_tf.getText().trim();

        if (name.isEmpty()) {
            alert("Item name is required.");
            return;
        }

        int qty;
        try {
            qty = Integer.parseInt(inventoryQuantity_tf.getText().trim());
        } catch (NumberFormatException ex) {
            alert("Quantity must be a whole number.");
            return;
        }

        LocalDate expiry = null;
        String expText = inventoryExpiry_tf.getText().trim();
        if (!expText.isEmpty()) {
            try {
                // must be yyyy-MM-dd
                expiry = LocalDate.parse(expText, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException ex) {
                alert("Expiry date must be in yyyy-MM-dd format.");
                return;
            }
        }

        // 2) Auto-compute status per rule
        String status = computeStatus(expiry, qty);

        // 3) Persist (insert or update)

        if (isEditMode && editing != null) {
            editing.setItemName(name);
            editing.setType(type);
            editing.setQuantity(qty);
            editing.setUnit(unit);
            editing.setExpiryDate(expiry);
            editing.setStatus(status);

            boolean ok = InventoryDAO.update(editing);
            if (!ok) { alert("Update failed."); return; }
            inventory_tv.refresh();  // ok for edits
        }  else {
                Inventory inv = new Inventory(
                    0,                // itemId (generated later)
                    name,             // itemName
                    type,             // type
                    qty,              // quantity
                    0,                // total_used (new item)
                    qty,              // balance_stock (initially = quantity)
                    unit,             // unit
                    expiry,           // expiry_date
                    status            // status (computed below)
                );
                int newId = InventoryDAO.insert(inv);
                if (newId <= 0) { alert("Insert failed."); return; }
                inv.setItemId(newId);
                // IMPORTANT: add to the **master** list, not the TableView’s items
                inventoryMaster.add(0, inv);
                // (no need to touch inventory_tv.getItems(); filtered/sorted view updates automatically)
            }
        
        // 4) Done: clear + hide
        clearForm();
        AddEdit_InventoryPane.setVisible(false);
        
        
        setupColumns();
        loadData();
//        setupInventoryTable();
        setupActionColumnINVENTORY();   // the "⋮" per row
        setupInventorySearchFilter();
        loadDashboardStats();
        
        triggerNotifRefreshNow(); //TO UPDATE LABEL BADGE IN NOTIFICATION (FOR INVENTORY OF MEDICINE - STOCK)
        refreshOverview(); //reports overview
        refreshInventory();
    }

    @FXML
    private void inventoryCancel(ActionEvent event) {
        clearForm();
        AddEdit_InventoryPane.setVisible(false);
    } 
    
    private void setupInventorySearchFilter() {
        // 1) Wrap backing list
        inventoryFiltered = new FilteredList<>(data, inv -> true);

        // 2) React to text changes
        filterField_inventory.textProperty().addListener((obs, old, text) -> {
            final String q = text == null ? "" : text.trim().toLowerCase();

            if (q.isEmpty()) {
                inventoryFiltered.setPredicate(inv -> true);
                return;
            }

            // Optional: allow multi-word search; all words must be found (AND)
            final String[] tokens = q.split("\\s+");

            inventoryFiltered.setPredicate(inv -> {
                // Build a single “haystack” string from searchable fields
                String hay = (
                    String.valueOf(inv.getItemId()) + " " +
                    n(inv.getItemName()) + " " +
                    n(inv.getType()) + " " +
                    n(inv.getStatus())
                ).toLowerCase();

                for (String t : tokens) {
                    if (!hay.contains(t)) return false;
                }
                return true;
            });
        });

        // 3) Keep sorting working
        inventorySorted = new SortedList<>(inventoryFiltered);
        inventorySorted.comparatorProperty().bind(inventory_tv.comparatorProperty());
        inventory_tv.setItems(inventorySorted);

        // Optional: nicer no-results message
        inventory_tv.setPlaceholder(new Label("No matching inventory items"));
    }

        // null-safe helper
        private static String n(String s) { return s == null ? "" : s; }
    
    // ---------- helpers ----------

    private void startAdd() {
        isEditMode = false;
        editing = null;
        clearForm();
        AddEdit_InventoryPane.setVisible(true);
        inventoryItem_tf.requestFocus();
    }

    // Call this from the "Edit" menu item in the action column
    public void openEditPane(Inventory inv) {
        if (inv == null) return;
        isEditMode = true;
        editing = inv;
        inventoryItem_tf.setText(inv.getItemName());
        inventoryType_tf.setText(inv.getType());
        inventoryUnit_tf.setText(inv.getUnit());
        inventoryQuantity_tf.setText(String.valueOf(inv.getQuantity()));
        inventoryExpiry_tf.setText(inv.getExpiryDate() != null ? inv.getExpiryDate().toString() : "");
        AddEdit_InventoryPane.setVisible(true);
        inventoryItem_tf.requestFocus();
    }

    private void clearForm() {
        inventoryItem_tf.clear();
        inventoryType_tf.clear();
        inventoryUnit_tf.clear();
        inventoryQuantity_tf.clear();
        inventoryExpiry_tf.clear();
    }

    private void alert(String msg) {
        new Alert(Alert.AlertType.WARNING, msg, ButtonType.OK).showAndWait();
    }

    /** 
     * Inventory rule:
     * - within 30 days of expiry -> "expiring soon"
     * - else if qty <= 10 -> "low stock"
     * - else -> "in stock"
     * (Matches inventory status values in the schema.) 
     */
    private String computeStatus(LocalDate expiry, int qty) {
        // Out of stock first
        if (qty <= 0) return "out of stock";

        // Expired beats any other status
        if (expiry != null && expiry.isBefore(LocalDate.now())) return "expired";

        // Expiring soon within 30 days (including today)
        if (expiry != null) {
            long days = ChronoUnit.DAYS.between(LocalDate.now(), expiry);
            if (days >= 0 && days <= 30) return "expiring soon";
        }

        // Low stock rule
        if (qty <= 10) return "low stock";

        return "in stock";
    }

    
    ////////////////////////////////////////////////////////////////////////////end inventory
    
    //////////////////////////////////////////////////////////////////////////// TOOLS INVENTORY
    private void setupToolsColumns() {
        // If "Code" column should show tool_code, change to getToolCodeProperty and String
        // if "id" - toolIdProperty - then Number column type
        inventoryTools_code.setCellValueFactory(c -> c.getValue().toolCodeProperty());
        inventoryTools_name.setCellValueFactory(c -> c.getValue().itemNameProperty());
        inventoryTools_category.setCellValueFactory(c -> c.getValue().categoryProperty());
        inventoryTools_quantity.setCellValueFactory(c -> c.getValue().quantityProperty());
        inventoryTools_unit.setCellValueFactory(c -> c.getValue().unitProperty());
        inventoryTools_location.setCellValueFactory(c -> c.getValue().locationProperty());
        inventoryTools_status.setCellValueFactory(c -> c.getValue().statusProperty());
        inventoryTools_remarks.setCellValueFactory(c -> c.getValue().remarksProperty());

        // Optional: nicer placeholders
        tools_tv.setPlaceholder(new Label("No tools"));
    }

    private void setupToolsSearchFilter() {
        toolsFiltered = new FilteredList<>(toolsMaster, t -> true);
        toolSearch_tf.textProperty().addListener((o, a, text) -> {
            final String q = (text == null ? "" : text.trim().toLowerCase());
            if (q.isEmpty()) { toolsFiltered.setPredicate(t -> true); return; }
            toolsFiltered.setPredicate(t -> {
                String hay = (safe(t.getToolCode()) + " " + safe(t.getItemName()) + " " + //getCode
                              safe(t.getCategory()) + " " + safe(t.getStatus())).toLowerCase();
                for (String tok : q.split("\\s+")) if (!hay.contains(tok)) return false;
                return true;
            });
        });

        toolsSorted = new SortedList<>(toolsFiltered);
        toolsSorted.comparatorProperty().bind(tools_tv.comparatorProperty());
        tools_tv.setItems(toolsSorted);
    }
    private static String safe(String s) { return s == null ? "" : s; }

    private void setupToolsActionColumn() {
        inventoryTools_action.setCellFactory(col -> new TableCell<>() {
            private final Button dots = new Button("⋮");
            private final MenuItem viewEdit = new MenuItem("Edit / View");
            private final MenuItem del      = new MenuItem("Delete");
            private final ContextMenu menu  = new ContextMenu(viewEdit, del);

            {
                dots.getStyleClass().add("action-dots");
                dots.setFocusTraversable(false);
                dots.setOnAction(e -> menu.show(dots, javafx.geometry.Side.BOTTOM, 0, 0));

                viewEdit.setOnAction(e -> {
                    InventoryTool row = getTableView().getItems().get(getIndex());
                    openEditTool(row);
                });
                del.setOnAction(e -> {
                    InventoryTool row = getTableView().getItems().get(getIndex());
                    confirmAndDeleteTool(row);
                });
            }

            @Override protected void updateItem(Void it, boolean empty) {
                super.updateItem(it, empty);
                setGraphic(empty ? null : dots);
                setText(null);
            }
        });
    }
    
    private void confirmAndDeleteTool(InventoryTool t) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,
                "Delete \"" + t.getItemName() + "\" (" + t.getToolCode() + ")?",
                ButtonType.OK, ButtonType.CANCEL);
        a.setHeaderText(null);
        a.showAndWait().ifPresent(bt -> {
            if (bt == ButtonType.OK) {
                boolean ok = InventoryToolsDAO.deleteById(t.getToolId());
                if (ok) toolsMaster.remove(t);
                else new Alert(Alert.AlertType.ERROR, "Delete failed.", ButtonType.OK).showAndWait();
            }
        });
    }


    private void openToolViewEditDialog(InventoryTool it) {
        // Minimal, non-blocking viewer: show acquired_on and purchase_cost.
        // Replace with a proper dialog when you build the Add/Edit pane.
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Tool Details");
        info.setHeaderText(it.getItemName());
        StringBuilder sb = new StringBuilder();
        sb.append("Code: ").append(safe(it.getToolCode())).append("\n");
        sb.append("Category: ").append(safe(it.getCategory())).append("\n");
        sb.append("Quantity: ").append(it.getQuantity()).append(" ").append(safe(it.getUnit())).append("\n");
        sb.append("Location: ").append(safe(it.getLocation())).append("\n");
        sb.append("Status: ").append(safe(it.getStatus())).append("\n");
        sb.append("Remarks: ").append(safe(it.getRemarks())).append("\n\n");
        sb.append("Acquired On: ").append(it.getAcquiredOn() == null ? "" : it.getAcquiredOn().toString()).append("\n");
        sb.append("Purchase Cost: ").append(it.getPurchaseCost() == null ? "" : it.getPurchaseCost().toPlainString());
        info.setContentText(sb.toString());
        info.showAndWait();
    }
    
    @FXML
    private void onAddTool(ActionEvent event) {
        editingTool = null;          // ADD mode
        clearToolForm();
        AddEdit_ToolPane.setVisible(true);
        Platform.runLater(() -> toolCode_tf.requestFocus());
        // Optional: Set header label 
        toolFormTitle_lbl.setText("Add Tool");
    }


    ///////////////////////////////////////////////////////// add tool pane
    // Call once in initialize()
    private void setupToolForm() {
        toolStatus_cb.getSelectionModel().select("good");
        toolAcquired_dp.setValue(java.time.LocalDate.now());

        // live validation
        ChangeListener<String> v = (obs,o,n) -> validateToolForm();
        toolCode_tf.textProperty().addListener(v);
        toolName_tf.textProperty().addListener(v);
        toolQty_tf.textProperty().addListener(v);
        toolUnit_tf.textProperty().addListener(v);
        toolCategory_cb.valueProperty().addListener((o,a,b)->validateToolForm());
        validateToolForm();
    }

    private void validateToolForm() {
        boolean ok = true;

        ok &= mark(toolCode_tf, !isBlank(toolCode_tf.getText()));
        ok &= mark(toolName_tf, !isBlank(toolName_tf.getText()));
        ok &= mark(toolCategory_cb, toolCategory_cb.getValue()!=null && !toolCategory_cb.getValue().isBlank());
        ok &= mark(toolQty_tf, isInt(toolQty_tf.getText(), 0, Integer.MAX_VALUE));
        ok &= mark(toolUnit_tf, !isBlank(toolUnit_tf.getText()));
        ok &= mark(toolCost_tf, isMoney(toolCost_tf.getText()));

        toolFormHint_lbl.setText(ok ? "" : "Please correct highlighted fields");
        toolSave_btn.setDisable(!ok);
    }
    private boolean isBlank(String s){ return s==null || s.isBlank(); }
    private boolean isInt(String s, int min, int max){
        try { int v = Integer.parseInt(s.trim()); return v>=min && v<=max; } catch(Exception e){ return false; }
    }
    private boolean isMoney(String s){
        if (isBlank(s)) return true; // optional
        try { new java.math.BigDecimal(s.trim()); return true; } catch(Exception e){ return false; }
    }
    private boolean mark(Control c, boolean valid){
        if (valid) c.getStyleClass().remove("invalid");
        else if (!c.getStyleClass().contains("invalid")) c.getStyleClass().add("invalid");
        return valid;
    }

    @FXML private void onCancelTool(ActionEvent e){
        clearToolForm();
        AddEdit_ToolPane.setVisible(false);
    }
    
    private void clearToolForm() {
        toolCode_tf.clear();
        toolName_tf.clear();
        toolCategory_cb.setValue(null);
        toolQty_tf.clear();
        toolUnit_tf.clear();
        toolLocation_cb.setValue(null);
        toolStatus_cb.setValue(null);
        toolRemarks_ta.clear();
        toolAcquired_dp.setValue(null);
        toolCost_tf.clear();
    }

    @FXML
    private void onSaveTool(ActionEvent e) {
        // 1) validate
        String code  = toolCode_tf.getText().trim();
        String name  = toolName_tf.getText().trim();
        if (code.isEmpty() || name.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Code and Item Name are required.", ButtonType.OK).showAndWait();
            return;
        }
        int qty;
        try { qty = Integer.parseInt(toolQty_tf.getText().trim()); }
        catch (Exception ex) { new Alert(Alert.AlertType.WARNING,"Quantity must be a whole number.",ButtonType.OK).showAndWait(); return; }

        String unit      = toolUnit_tf.getText().trim();
        String category  = valueOrNull(toolCategory_cb.getEditor().getText(), toolCategory_cb.getValue());
        String location  = valueOrNull(toolLocation_cb.getEditor().getText(), toolLocation_cb.getValue());
        String condition = valueOrNull(toolStatus_cb.getEditor().getText(), toolStatus_cb.getValue());
        String remarks   = toolRemarks_ta.getText();

        LocalDate acquired = toolAcquired_dp.getValue();
        BigDecimal cost = null;
        String costTxt = toolCost_tf.getText().trim();
        if (!costTxt.isEmpty()) {
            try { cost = new BigDecimal(costTxt); }
            catch (NumberFormatException ex) {
                new Alert(Alert.AlertType.WARNING, "Purchase cost must be a number.", ButtonType.OK).showAndWait();
                return;
            }
        }

        if (editingTool == null) {
            // ADD
            InventoryTool t = new InventoryTool(0, code, name, category, qty, unit, location, condition, remarks, acquired, cost);
            int newId = InventoryToolsDAO.insert(t);
            if (newId <= 0) { new Alert(Alert.AlertType.ERROR, "Insert failed.", ButtonType.OK).showAndWait(); return; }
            t.setToolId(newId);
            toolsMaster.add(0, t);
        } else {
            // EDIT
            editingTool.setToolCode(code);
            editingTool.setItemName(name);
            editingTool.setCategory(category);
            editingTool.setQuantity(qty);
            editingTool.setUnit(unit);
            editingTool.setLocation(location);
            editingTool.setStatus(condition);
            editingTool.setRemarks(remarks);
            editingTool.setAcquiredOn(acquired);
            editingTool.setPurchaseCost(cost);

            boolean ok = InventoryToolsDAO.update(editingTool);
            if (!ok) { new Alert(Alert.AlertType.ERROR, "Update failed.", ButtonType.OK).showAndWait(); return; }
            tools_tv.refresh(); // reflect changes
        }

        clearToolForm();
        AddEdit_ToolPane.setVisible(false);
    }

    private static String valueOrNull(String editorText, String selected) {
        String v = (selected != null ? selected : (editorText == null ? "" : editorText.trim()));
        return v.isEmpty() ? null : v;
    }
    
    private void openEditTool(InventoryTool t) {
        if (t == null) return;
        editingTool = t;

        // populate fields
        toolCode_tf.setText(safe(t.getToolCode()));
        toolName_tf.setText(safe(t.getItemName()));
        toolCategory_cb.setValue(safe(t.getCategory()));
        toolQty_tf.setText(String.valueOf(t.getQuantity()));
        toolUnit_tf.setText(safe(t.getUnit()));
        toolLocation_cb.setValue(safe(t.getLocation()));
        toolStatus_cb.setValue(safe(t.getStatus()));
        toolRemarks_ta.setText(safe(t.getRemarks()));
        toolAcquired_dp.setValue(t.getAcquiredOn());
        toolCost_tf.setText(t.getPurchaseCost() == null ? "" : t.getPurchaseCost().toPlainString());

        AddEdit_ToolPane.setVisible(true);
        Platform.runLater(() -> toolName_tf.requestFocus());
    }


    //////////////////////////////////////////////////////////////////////////// end of tools inventory
    
    
    // small helpers
    private String obj(Object o) { return o == null ? "" : o.toString(); }
    private void appendIf(StringBuilder sb, String label, String val) {
        if (val != null && !val.isBlank()) {
            sb.append("• ").append(label).append(": ").append(val).append('\n');
        }
    }
    private void showInfo(String msg) {
    javafx.scene.control.Alert a = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
    a.setHeaderText(null);
    a.setContentText(msg);
    a.showAndWait();
}
    private void showWarn(String msg) {
        Alert a = new Alert(Alert.AlertType.WARNING, msg, ButtonType.OK);
        a.setHeaderText(null);
        a.setTitle("Warning");
        a.showAndWait();
    }
    private void showError(String msg) {
    javafx.scene.control.Alert a = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
    a.setHeaderText("Error");
    a.setContentText(msg);
    a.showAndWait();
}
    private void setText(TextField tf, String value) { tf.setText(value == null ? "" : value); }

    // =====================================================
    // SHOW IMAGE (supports file path or null placeholder)
    // =====================================================
    // Robust loader: tries absolute/relative disk paths, then packaged fallback.
    // Place default-user.png under resources: /img/default-user.png

    private static final double STUDENT_AVATAR_SIZE = 90.0;

    private void showImage(String imagePath) {
        try {
            Image imgToShow = null;

            // 1) load from file path if present
            if (imagePath != null && !imagePath.isBlank()) {
                File f = new File(imagePath);
                if (f.exists()) {
                    imgToShow = new Image(f.toURI().toString(), false);
                }
            }

            // 2) fallback resource
            if (imgToShow == null) {
                URL url = getClass().getResource("/image/default-user.png"); // <-- match folder
                if (url != null) {
                    imgToShow = new Image(url.toExternalForm(), false);
                }
            }

            // 3) apply center-crop + circle (handles null safely)
            setCircularImage(image_imageView, imgToShow, STUDENT_AVATAR_SIZE);

            if (imgToShow == null) {
                System.err.println("[showImage] Fallback image not found: /image/default-user.png");
            }
        } catch (Exception e) {
            e.printStackTrace();
            setCircularImage(image_imageView, null, STUDENT_AVATAR_SIZE);
        }
    }


    private void alert(Alert.AlertType t, String header, String content) {
        Alert a = new Alert(t);
        a.setHeaderText(header);
        a.setContentText(content);
        a.show();
    }
    private void setNullableInt(PreparedStatement ps, int idx, String s) throws Exception {
        if (s == null || s.isBlank()) ps.setNull(idx, Types.INTEGER);
        else ps.setInt(idx, Integer.parseInt(s.trim()));
    }
    private void setNullableDate(PreparedStatement ps, int idx, String s) throws Exception {
        if (s == null || s.isBlank()) { ps.setNull(idx, Types.DATE); return; }
        ps.setDate(idx, Date.valueOf(LocalDate.parse(s.trim()))); // yyyy-MM-dd
    }
    private void setNullableBigDecimal(PreparedStatement ps, int idx, String s) throws Exception {
        if (s == null || s.isBlank()) { ps.setNull(idx, Types.DECIMAL); return; }
        ps.setBigDecimal(idx, new java.math.BigDecimal(s.trim()));
    }

// small helpers you already have variants of:
private static String nz(String s) { return s == null ? "" : s; }
private static String safeLower(String s) { return s == null ? "" : s.trim().toLowerCase(); }
private static String trimOrNull(String s) {
    if (s == null) return null;
    String t = s.trim();
    return t.isEmpty() ? null : t;
}
private static String nullToEmpty(String s) { return s == null ? "" : s; }
private static Integer parseIntOrNull(String s) {
    try {
        if (s == null || s.trim().isEmpty()) return null;
        return Integer.parseInt(s.trim());
    } catch (NumberFormatException e) {
        return null;
    }
}
private static Double parseDoubleOrNull(String s) {
    try {
        if (s == null || s.trim().isEmpty()) return null;
        return Double.parseDouble(s.trim());
    } catch (NumberFormatException e) {
        return null;
    }
}
private static void setNullable(PreparedStatement ps, int idx, String v) throws SQLException {
    if (v == null) ps.setNull(idx, java.sql.Types.VARCHAR);
    else ps.setString(idx, v);
}
private static void setNullable(PreparedStatement ps, int idx, Integer v) throws SQLException {
    if (v == null) ps.setNull(idx, java.sql.Types.INTEGER);
    else ps.setInt(idx, v);
}
private static void setNullable(PreparedStatement ps, int idx, Double v) throws SQLException {
    if (v == null) ps.setNull(idx, java.sql.Types.DECIMAL);
    else ps.setDouble(idx, v);
}
private void warnLong(String title, String header, String message) {
    Alert alert = new Alert(Alert.AlertType.WARNING);
    alert.setTitle(title);
    alert.setHeaderText(header);

    TextArea area = new TextArea(message);
    area.setWrapText(true);
    area.setEditable(false);
    area.setPrefRowCount(10);
    area.setPrefColumnCount(60);
    area.setMaxWidth(Double.MAX_VALUE);
    area.setMaxHeight(Double.MAX_VALUE);

    alert.getDialogPane().setContent(area);
    // ensure dialog sizes to content
    alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
    alert.getDialogPane().setMinWidth(Region.USE_PREF_SIZE);

    alert.showAndWait();
}

////////////////////////////////////////////////////////////////////////////////MEDICAL CERTIFICATE

    // =================== LEFT PANE: SEARCH + RECORDS TABLE =====================
    @FXML private void onSearch(){ loadCertificates(search_tf.getText()); }

    @FXML private void onCreateNew() {
//        String q = search_tf.getText();
//        List<Student1> choices = MySQL.findStudents(q);
//        if (choices.isEmpty()) {
//            alertInfo("No students found. Type a name or ID in the search box first.");
//            return;
//        }
//        Student1 s = choices.get(0);                 // you can replace with a ChoiceDialog
//        setStudentOnForm(s.studentId, s.fullName()); // sets currentStudentIdMEDCERT
//        applyLatestVitals(s.studentId);              // auto-fill vitals from last consultation
         onPickStudent();
    }

    private void loadCertificates(String query){
        ObservableList<CertRow> rows = FXCollections.observableArrayList();
        String sql =
            "SELECT mc.cert_id, mc.cert_code, mc.issued_date, mc.status, " +
            "CONCAT(st.last_name, ', ', st.first_name, ' ', COALESCE(st.middle_name,'')) fullname " +
            "FROM medical_certificates mc " +
            "JOIN students st ON st.student_id = mc.student_id " +
            "WHERE mc.is_deleted = 0 AND " +
            "      (? IS NULL OR st.id_number LIKE CONCAT('%',?,'%') " +
            "       OR st.first_name LIKE CONCAT('%',?,'%') " +
            "       OR st.last_name LIKE CONCAT('%',?,'%') " +
            "       OR mc.cert_code LIKE CONCAT('%',?,'%')) " +
            "ORDER BY mc.issued_date DESC, mc.cert_id DESC";
        // ... (bind 5 params as before, fill table)
        try (Connection con = MySQL.connect(); PreparedStatement ps = con.prepareStatement(sql)) {
            String k = (query==null || query.trim().isEmpty()) ? null : query.trim();
            for (int i=1;i<=5;i++) ps.setString(i, k);
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    int certId = rs.getInt("cert_id");
                    String code = rs.getString("cert_code");
                    LocalDate date = rs.getDate("issued_date").toLocalDate();
                    String name = rs.getString("fullname");
                    String status = rs.getString("status");
                    rows.add(CertRow.of(certId, code, date, name, status,
                            this::viewExisting, this::printExisting, this::openExisting, this::deleteCertToRecycle));

                }
            }
        } catch (SQLException e){ e.printStackTrace(); alertError("Load failed:\n"+e.getMessage()); }
        certificates_tv.setItems(rows);
    }

    private void viewExisting(int certId){
        File f = fetchPdfPath(certId);
        if (f==null || !f.exists()){ alertError("File not found for this certificate."); return; }
        openPreview(f);
    }
    private void printExisting(int certId){
        File f = fetchPdfPath(certId);
        if (f!=null && f.exists()) try { java.awt.Desktop.getDesktop().print(f); }
        catch(Exception ex){ alertError("Print failed:\n"+ex.getMessage()); }
    }
    private void openExisting(int certId){
        File f = fetchPdfPath(certId);
        if (f!=null && f.exists()) try { java.awt.Desktop.getDesktop().open(f); }
        catch(Exception ex){ alertError("Open failed:\n"+ex.getMessage()); }
    }
    private File fetchPdfPath(int certId){
        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement("SELECT file_path FROM medical_certificates WHERE cert_id=?")){
            ps.setInt(1, certId);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    String p = rs.getString(1);
                    return p==null ? null : new File(p);
                }
            }
        } catch (SQLException e){ e.printStackTrace(); }
        return null;
    }

    // ======================= RIGHT PANE: FORM ACTIONS ==========================
    private void setStudentOnForm(int studentId, String fullName){
        currentStudentIdMEDCERT = studentId;
        student_tf.setText(fullName); //student_lbl.setText("Please pick a student...);
        date_dp.setValue(LocalDate.now());
    }


    private void applyLatestVitals(int studentId, boolean forceOverwrite) {
        String sql =
            "SELECT consultation_date, " +
            "       COALESCE(blood_pressure, CONCAT(COALESCE(systolic,''),'/',COALESCE(diastolic,''))) AS bp, " +
            "       temperature, pulse_rate, respiratory_rate " +
            "FROM consultations " +
            "WHERE student_id=? " +
            "ORDER BY consultation_date DESC, consultation_id DESC " +
            "LIMIT 1";

        try (Connection con = MySQL.connect();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    vitalsSource_lbl.setText("No consultation found.");
                    vitalsSource_lbl.setStyle("-fx-font-size: 11; -fx-text-fill: gray;");
                    lastVitalsStudentId = studentId;  // still track
                    return;
                }

                String bp = rs.getString("bp");

                java.math.BigDecimal tempBD = (java.math.BigDecimal) rs.getObject("temperature");
                String tempStr = (tempBD != null) ? tempBD.stripTrailingZeros().toPlainString() : null;

                Integer pulse = (Integer) rs.getObject("pulse_rate");
                Integer rr    = (Integer) rs.getObject("respiratory_rate");

                // Decide whether to overwrite fields
                boolean overwrite = forceOverwrite || !vitalsUserEdited;

                if (overwrite) {
                    // Overwrite all four (use "N/A" only if you prefer — here we clear if null)
                    bp_tf.setText( bp != null && !bp.isBlank() ? bp : "" );
                    temp_tf.setText( tempStr != null && !tempStr.isBlank() ? tempStr : "" );
                    pulse_tf.setText( pulse != null ? pulse.toString() : "" );
                    resp_tf.setText( rr != null ? rr.toString() : "" );
                } else {
                    // Legacy behavior: only fill empties
                    if (isEmpty(bp_tf.getText())   && bp != null && !bp.isBlank())       bp_tf.setText(bp);
                    if (isEmpty(temp_tf.getText()) && tempStr != null && !tempStr.isBlank()) temp_tf.setText(tempStr);
                    if (isEmpty(pulse_tf.getText())&& pulse != null)                     pulse_tf.setText(pulse.toString());
                    if (isEmpty(resp_tf.getText()) && rr != null)                        resp_tf.setText(rr.toString());
                }

                // Label + stale warning
                LocalDate consultDate = rs.getDate("consultation_date").toLocalDate();
                vitalsSource_lbl.setText("Loaded from consultation on " + consultDate);
                if (consultDate.isBefore(LocalDate.now().minusDays(30))) {
                    vitalsSource_lbl.setStyle("-fx-font-size: 11; -fx-text-fill: red; -fx-font-weight: bold;");
                    vitalsSource_lbl.setText(vitalsSource_lbl.getText() + " ⚠ Outdated");
                } else {
                    vitalsSource_lbl.setStyle("-fx-font-size: 11; -fx-text-fill: gray;");
                }

                // Remember which student's vitals are shown now
                lastVitalsStudentId = studentId;

            }
        } catch (SQLException e) {
            e.printStackTrace();
            alertError("Failed to fetch latest vitals:\n" + e.getMessage());
        }
    }


    private void clearVitalsFields() {
        bp_tf.clear();
        temp_tf.clear();
        pulse_tf.clear();
        resp_tf.clear();
    }


    @FXML private void onCancel(){ clearFormMedCert(); }
    private void clearFormMedCert(){
        currentStudentIdMEDCERT = -1;
        student_lbl.setText("Please pick a student..."); 
        studentID_lbl.setText("");
        vitalsSource_lbl.setText("");
        activity_tf.clear(); remarks_ta.clear();
        bp_tf.clear(); temp_tf.clear(); pulse_tf.clear(); resp_tf.clear();
        date_dp.setValue(LocalDate.now());
        status_cb.getSelectionModel().selectFirst();
        lastGeneratedPdf = null; 
    }

    // ===================== SAVE + GENERATE + PREVIEW ===========================
    @FXML
    private void onSaveGenerate(ActionEvent e){
        if (currentStudentIdMEDCERT <= 0){
            alertInfo("Pick a student or Create New before generating."); return;
        }
        try (Connection con = MySQL.connect()){
            String code = nextCertCode(con);
            File dest = ensureOutputFile(code);

            // 1) Make PDF first
            createPdf(dest,
                    student_lbl.getText(),
                    activity_tf.getText(),
                    status_cb.getValue(),
                    remarks_ta.getText(),
                    emptyToNA(bp_tf.getText()),
                    emptyToNA(temp_tf.getText()),
                    emptyToNA(pulse_tf.getText()),
                    emptyToNA(resp_tf.getText()),
                    code,
                    currentNurseName(con),
                    date_dp.getValue()==null ? LocalDate.now().toString() : date_dp.getValue().toString());

            // 2) Save DB row
            insertCert(con, code, dest.getAbsolutePath());

            // 3) Refresh & Preview
            lastGeneratedPdf = dest;
            loadCertificates(search_tf.getText());
            openPreview(dest);

        } catch (Exception ex){
            ex.printStackTrace();
            alertError("Failed to generate/save:\n"+ex.getMessage());
        }
    }

    @FXML private void onPrint(){
        if (lastGeneratedPdf==null){ alertInfo("Generate a certificate first."); return; }
        try { java.awt.Desktop.getDesktop().print(lastGeneratedPdf); }
        catch(Exception ex){ alertError("Print failed:\n"+ex.getMessage()); }
    }

    // ============================ PREVIEW (PDFBox) =============================

    // === Open PDF in Preview ===
    private void openPreview(File pdfFile) {
        try {
            if (doc != null) doc.close(); // close old one
            doc = PDDocument.load(pdfFile);
            renderer = new PDFRenderer(doc);
            pageCount = doc.getNumberOfPages();

            // Spinner setup 1..pageCount
            SpinnerValueFactory<Integer> vf =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Math.max(1,pageCount), 1);
            pageSpinner.setValueFactory(vf);
            pageSpinner.valueProperty().addListener((obs, oldV, newV) -> renderPreviewPage(newV-1));

            renderPreviewPage(0);   // first page
            showPreviewPane();      // switch panes
        } catch (IOException ex) {
            alertError("Cannot open preview:\n" + ex.getMessage());
        }
    }

    // === Render page with current zoom ===
       
    private void renderPreviewPage(int pageIndex) {
        if (doc == null || renderer == null) return;
        try {
            float dpi = 96f * zoom;                    // 96 dpi base * zoom factor
            BufferedImage bim = renderer.renderImageWithDPI(pageIndex, dpi, ImageType.RGB);
            imageView.setImage(SwingFXUtils.toFXImage(bim, null));
            // NO setFitWidth here — let the pixel size of the rendered image drive the size
             imageView.setPreserveRatio(true);
             imageView.setSmooth(true);   // smoother panning
             imageView.setCache(false);   // avoid caching low-res
            
        } catch (IOException ex) {
            alertError("Render failed:\n" + ex.getMessage());
        }
       

    }

    
//    @FXML private void onZoomIn(){  zoom = Math.min(zoom + .25f, 4f);  renderPreviewPage(pageSpinner.getValue()-1); }
//    @FXML private void onZoomOut(){ zoom = Math.max(zoom - .25f, .5f); renderPreviewPage(pageSpinner.getValue()-1); }
//    @FXML private void onFit(){
//        double viewportW = (scroll!=null && scroll.getViewportBounds()!=null) ? scroll.getViewportBounds().getWidth() : 820;
//        // A4 width ≈ 8.27in → target dpi so image width ~ viewport
//        zoom = (float)((viewportW / 8.27) / 96.0);
//        zoom = Math.max(.5f, Math.min(zoom, 4f));
//        renderPreviewPage(pageSpinner.getValue()-1);
//    }
    
    // === Zoom Buttons (connect in FXML onAction) ===
    @FXML private void onZoomIn() {
//        zoom = Math.min(zoom + 0.25f, 4.0f);
//        renderPreviewPage(pageSpinner.getValue()-1);

        // Increase zoom by 0.25 each click, but cap at 4x (prevents memory blowups).
        zoom = Math.min(zoom + 0.25f, 4.0f);

        // We leave "fit mode", because user is manually zooming now.
        fitMode = false;

        // Re-render the current page with the new DPI (96 * zoom).
        renderPreviewPage(currentPageIndex());
    }

    @FXML private void onZoomOut() {
        // Decrease zoom by 0.25 each click, don’t allow smaller than 0.5x (too small to see).
        zoom = Math.max(zoom - 0.25f, 0.5f);

        // Manual zoom → disable fit mode.
        fitMode = false;

        // Re-render the current page at the new lower DPI.
        renderPreviewPage(currentPageIndex());
    }

    @FXML private void onFit() {
        // Get the viewport width (visible area of the ScrollPane, in screen pixels).
        double viewportW = scroll.getViewportBounds().getWidth();
        if (viewportW <= 0) viewportW = 800;  // fallback when not laid out yet

        // Your old code assumed A4 ≈ 8.27in, then estimated zoom from that.
        // That’s okay, but not exact if the PDF isn't A4 or has a different rotation/margins.
        // We replaced it with computeFitZoom() that reads the *actual* PDF page width:

        zoom = computeFitZoom(currentPageIndex());

        // We are now in "fit mode": if the window resizes, we’ll re-fit automatically.
        fitMode = true;

        // Re-render at the fit DPI so the image exactly matches the viewport width.
        renderPreviewPage(currentPageIndex());

    }
    private float computeFitZoom(int pageIndex) {
        // viewport width in screen pixels
        double viewportW = scroll.getViewportBounds().getWidth();
        if (viewportW <= 0) viewportW = scroll.getWidth() - 18; // fallback for early calls

        // PDF page width in points (1/72 inch)
        float pageWidthPts = doc.getPage(pageIndex).getMediaBox().getWidth();
        double pageWidthInches = pageWidthPts / 72.0;

        // we render at (96 * zoom) DPI; to match viewportW pixels:
        double targetDpi = viewportW / pageWidthInches;   // pixels / inches
        double z = targetDpi / 96.0;                      // zoom = dpi / 96

        return (float) Math.max(0.5, Math.min(z, 4.0));   // clamp
    }

    @FXML private void onOpenExternal(){
        if (lastGeneratedPdf==null){ alertInfo("No file."); return; }
        try { java.awt.Desktop.getDesktop().open(lastGeneratedPdf); }
        catch(Exception ex){ alertError("Open failed:\n"+ex.getMessage()); }
    }
    // === Close preview ===
    @FXML private void onClose() {
        try { if (doc != null) doc.close(); clearFormMedCert(); } catch (Exception ignore) {}
        showFormPane();
    }
    private int currentPageIndex() {
        Integer v = (pageSpinner != null ? pageSpinner.getValue() : 1);
        if (v == null) v = 1;
        return Math.max(0, Math.min(pageCount - 1, v - 1)); // convert 1-based spinner to 0-based index
    }

    // ============================== DB HELPERS =================================
    private String nextCertCode(Connection con) throws SQLException {
        String year = String.valueOf(LocalDate.now().getYear());
        try (PreparedStatement ps = con.prepareStatement(
                "SELECT COUNT(*) FROM medical_certificates WHERE YEAR(created_at)=?")){
            ps.setString(1, year);
            try (ResultSet rs = ps.executeQuery()){
                rs.next();
                int next = rs.getInt(1) + 1;
                return String.format("MED-%s-%04d", year, next);
            }
        }
    }

    private int insertCert(Connection con, String code, String filePath) throws SQLException {
        String sql = "INSERT INTO medical_certificates " +
                "(student_id, issued_date, activity, status, remarks, bp, temperature, pulse_rate, respiratory_rate, cert_code, file_path) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1, currentStudentIdMEDCERT);
            ps.setDate(2, Date.valueOf(date_dp.getValue()));
            ps.setString(3, emptyToNull(activity_tf.getText()));
            ps.setString(4, status_cb.getValue());
            ps.setString(5, emptyToNull(remarks_ta.getText()));
            ps.setString(6, emptyToNull(bp_tf.getText()));
            ps.setObject(7, isEmpty(temp_tf.getText())? null : Double.valueOf(temp_tf.getText().trim()));
            ps.setObject(8, isEmpty(pulse_tf.getText())? null : Integer.valueOf(pulse_tf.getText().trim()));
            ps.setObject(9, isEmpty(resp_tf.getText())? null : Integer.valueOf(resp_tf.getText().trim()));
            ps.setString(10, code);
            ps.setString(11, filePath);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()){ rs.next(); return rs.getInt(1); }
        }
    }

    private String currentNurseName(Connection con){
        // TODO: return logged-in user; placeholder for now
        return "University Health Services Nurse";
    }

    // ========================== PDF GENERATION (iText 5) =======================
    private void createPdf(File dest,
                       String studentName, String activity, String status, String remarks,
                       String bp, String temp, String pulse, String resp,
                       String certCode, String nurseName, String dateText) throws Exception {

    dest.getParentFile().mkdirs();
    Document d = new Document();
    PdfWriter.getInstance(d, new FileOutputStream(dest));
    d.open();

//    d.add(new Paragraph("REPUBLIC OF THE PHILIPPINES", FontFactory.getFont(FontFactory.HELVETICA, 12)));
//    d.add(new Paragraph("SOUTHERN LUZON STATE UNIVERSITY", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
//    d.add(new Paragraph("Health Services\n\n", FontFactory.getFont(FontFactory.HELVETICA, 12)));

    Paragraph head = new Paragraph("Republic of the Philippines\nSOUTHERN LUZON STATE UNIVERSITY\n"
                + "Lucban, Quezon\n\nHEALTH SERVICES\n\n\n", FontFactory.getFont(FontFactory.HELVETICA, 12));
        head.setAlignment(Element.ALIGN_CENTER);
        d.add(head);
        
    Paragraph title = new Paragraph("MEDICAL CERTIFICATE\n\n", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
    title.setAlignment(Element.ALIGN_CENTER);
    d.add(title);
    d.add(new Paragraph("\nDate: " + dateText + "\n\n\n"));

    // ---- Body with bold name, status, activity ----
    // ---- Fonts (iText 5) ----
    com.itextpdf.text.Font normal = FontFactory.getFont(FontFactory.HELVETICA, 12, com.itextpdf.text.Font.NORMAL);
    com.itextpdf.text.Font bold   = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, com.itextpdf.text.Font.BOLD);

    // ---- Body with mixed styles ----
    Paragraph bodyPara = new Paragraph();
    bodyPara.setFont(normal);

    bodyPara.add(new Chunk("To Whom It May Concern:\n\nThis is to certify that Mr./Ms. ", normal));
    bodyPara.add(new Chunk(studentName, bold)); // student name bold
    bodyPara.add(new Chunk(" of Southern Luzon State University, Alabat Campus, is Physically and Mentally ", normal));
    bodyPara.add(new Chunk(status.toUpperCase(), bold)); // status bold
    bodyPara.add(new Chunk(" for: ", normal));
    bodyPara.add(new Chunk(activity, bold)); // activity bold
    bodyPara.add(new Chunk(".\n\n", normal));

    d.add(bodyPara);


    Paragraph remarksPara = new Paragraph();
    remarksPara.add(new Chunk("\n\nRemarks: "));
    remarksPara.add(new Chunk(isEmpty(remarks) ? "N/A" : remarks, normal));
    remarksPara.add(new Chunk("\n", normal));
    d.add(remarksPara);

    d.add(new Paragraph("\n\nVital Signs: BP: " + bp + "   Temp: " + temp + " °C   Pulse: " + pulse + " bpm   Resp: " + resp + " cpm\n\n\n\n"));

//    Paragraph sig = new Paragraph("______________________________\n" + nurseName + "\nDirector, University Health Services");
    Paragraph sig = new Paragraph("______________________________\n" + "JERRY M. IMPERIAL, RN" + "\nDirector, University Health Services");
    sig.setAlignment(Element.ALIGN_RIGHT);
    d.add(sig);

    Paragraph footer = new Paragraph("\n\n\n\n\n\n\n\n\n\n*Generated by School Clinic System | Certificate ID: " + certCode + "*",
            FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 9));
    footer.setAlignment(Element.ALIGN_CENTER);
    d.add(footer);

    d.close();
}


    private File ensureOutputFile(String code){
        File dir = new File(System.getProperty("user.home"), "SchoolClinic/Certificates");
        if (!dir.exists()) dir.mkdirs();
        return new File(dir, code + ".pdf");
    }
    
    // --- Open the student picker popup and store selection (Med Certificate) ---
    @FXML
    private void onPickStudent() {
        StudentPickerDialog dlg = new StudentPickerDialog();
        if (student_lbl != null && student_lbl.getScene() != null) {
            dlg.initOwner(student_lbl.getScene().getWindow());
        }

        java.util.Optional<StudentPick> res = dlg.showAndWait();
        res.ifPresent(p -> {
            currentStudentIdMEDCERT = p.getStudentId();           // FK for saves
            student_lbl.setText(p.getFullName());                 // visible name
            studentID_lbl.setText("   •   ID: " + p.getIdNumber()); // show school ID#
            date_dp.setValue(java.time.LocalDate.now());

            // If switching to a different student, clear previous vitals
            if (lastVitalsStudentId == null || !lastVitalsStudentId.equals(p.getStudentId())) {
                clearVitalsFields();
                vitalsUserEdited = false;
            }
            // Always refresh vitals for the chosen student
            applyLatestVitals(p.getStudentId(), /*forceOverwrite=*/ true);
        });
    }

    /////////////////deleting
    private void deleteCertToRecycle(int certId){
        Alert confirm = new Alert(Alert.AlertType.WARNING,
            "This certificate will be moved to the Recycle Bin.\n" +
            "You can restore it within 90 days, otherwise it will be permanently deleted.\n\n" +
            "Proceed?",
            ButtonType.CANCEL, ButtonType.OK);
        confirm.setHeaderText("Delete Certificate");
        confirm.showAndWait().ifPresent(btn -> {
            if (btn != ButtonType.OK) return;
            try (Connection con = MySQL.connect()) {
                con.setAutoCommit(false);

                // 1) Get current file path
                String path=null, code=null;
                try (PreparedStatement ps = con.prepareStatement(
                        "SELECT file_path, cert_code FROM medical_certificates WHERE cert_id=? AND is_deleted=0")) {
                    ps.setInt(1, certId);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) { alertError("Not found or already deleted."); con.rollback(); return; }
                        path = rs.getString("file_path");
                        code = rs.getString("cert_code");
                    }
                }

                // 2) Move file to RecycleBin/
                String newPath = path;
                if (path != null) {
                    File f = new File(path);
                    File recycleDir = new File(f.getParentFile(), "RecycleBin");
                    recycleDir.mkdirs();
                    File target = new File(recycleDir, f.getName());
                    if (f.exists() && f.renameTo(target)) newPath = target.getAbsolutePath();
                }

                // 3) Mark as deleted
                try (PreparedStatement ps = con.prepareStatement(
                        "UPDATE medical_certificates SET is_deleted=1, deleted_at=NOW(), delete_reason=?, original_file_path=?, file_path=? WHERE cert_id=?")) {
                    ps.setString(1, "Admin delete");
                    ps.setString(2, path);
                    ps.setString(3, newPath);
                    ps.setInt(4, certId);
                    ps.executeUpdate();
                }

                // 4) Optional audit
                MySQL.insertAudit(con, certId, "DELETE", "Moved to Recycle Bin");

                con.commit();
                loadCertificates(search_tf.getText());
                alertInfo("Moved to Recycle Bin.");
            } catch (Exception ex){
                ex.printStackTrace();
                alertError("Delete failed:\n" + ex.getMessage());
            }
        });
    }

    
    @FXML
    private void onOpenRecycleBin() {
        if (!checkAdminPasswordLoop()) return;
        // pass a callback that refreshes the main table immediately on any change made in the dialog
        new RecycleBinDialog(() -> loadCertificates(search_tf.getText())).showAndWait();
    }

    // same masked-password loop we did earlier
    private boolean checkAdminPasswordLoop() {
        while (true) {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("Recycle Bin (Admin)");
            dialog.setHeaderText("Enter admin password to continue.");
            ButtonType loginBtn = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(loginBtn, ButtonType.CANCEL);
            PasswordField pf = new PasswordField(); pf.setPromptText("••••••••");
            dialog.getDialogPane().setContent(pf);
            dialog.setResultConverter(btn -> btn == loginBtn ? pf.getText() : null);
            var result = dialog.showAndWait();
            if (result.isEmpty()) return false;                   // cancelled
            if (result.get().equals(adminPassword())) return true; // correct
            new Alert(Alert.AlertType.ERROR, "Incorrect password. Try again.").showAndWait();
        }
    }


    // Simple hardcoded admin password (replace with config/hashed check later)
    private String adminPassword() {
        return "admin123"; // TODO read from config or env
    }
    
    private void purgeOldDeleted(){
        try (Connection con = MySQL.connect()){
            // collect victims first (to delete files)
            List<File> toDelete = new ArrayList<>();
            try (PreparedStatement ps = con.prepareStatement(
                "SELECT file_path FROM medical_certificates WHERE is_deleted=1 AND deleted_at < NOW() - INTERVAL 90 DAY");
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()){
                    String p = rs.getString(1);
                    if (p != null) toDelete.add(new File(p));
                }
            }
            // delete rows
            try (PreparedStatement ps = con.prepareStatement(
                "DELETE FROM medical_certificates WHERE is_deleted=1 AND deleted_at < NOW() - INTERVAL 90 DAY")) {
                ps.executeUpdate();
            }
            // delete files on disk
            for (File f : toDelete) { if (f.exists()) f.delete(); }
        } catch (SQLException e){ e.printStackTrace(); }
    }
    ////////////////////////////////////////////////////////////////////////////end of medical certificate
    ////////////////////////////////////////////////////////////////////////////CALENDAR
  
    private EnumSet<CalendarItem.Kind> activeKinds() {
        if (fltAll.isSelected() || (!fltNotes.isSelected() && !fltTasks.isSelected()
                && !fltEvents.isSelected() && !fltInventory.isSelected())) {
            return EnumSet.allOf(CalendarItem.Kind.class);
        }
        EnumSet<CalendarItem.Kind> set = EnumSet.noneOf(CalendarItem.Kind.class);
        if (fltNotes.isSelected()) set.add(CalendarItem.Kind.Note);
        if (fltTasks.isSelected()) set.add(CalendarItem.Kind.Task);
        if (fltEvents.isSelected()) set.add(CalendarItem.Kind.Event);
        if (fltInventory.isSelected()) set.add(CalendarItem.Kind.Inventory);
        return set;
    }

    // ===== quick add dialog (minimal) =====
    private void quickAdd(LocalDate date) {
        Dialog<CalendarItem> dlg = new Dialog<>();
        dlg.setTitle("Add Calendar Item");

        // Form
        DialogPane pane = dlg.getDialogPane();
        pane.getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);

        TextField tfTitle = new TextField();
        tfTitle.setPromptText("Title");

        ComboBox<CalendarItem.Kind> cbKind = new ComboBox<>();
        cbKind.getItems().setAll(CalendarItem.Kind.values());
        cbKind.getSelectionModel().select(CalendarItem.Kind.Note);

        DatePicker dpDate = new DatePicker(date);
        CheckBox cbAllDay = new CheckBox("All-day");
        cbAllDay.setSelected(true);
        Spinner<Integer> spHour = new Spinner<>(0,23,9);
        Spinner<Integer> spMin  = new Spinner<>(0,59,0);
        spHour.setDisable(true); spMin.setDisable(true);
        cbAllDay.selectedProperty().addListener((o,was,now)->{
            spHour.setDisable(now); spMin.setDisable(now);
        });

        GridPane g = new GridPane();
        g.setHgap(10); g.setVgap(8); g.setPadding(new Insets(10));
        g.addRow(0, new Label("Title"), tfTitle);
        g.addRow(1, new Label("Type"), cbKind);
        g.addRow(2, new Label("Date"), dpDate);
        g.addRow(3, new Label("Time"), new HBox(6, cbAllDay, new Label("Hour"), spHour, new Label("Min"), spMin));
        pane.setContent(g);

        dlg.setResultConverter(bt -> {
            if (bt == ButtonType.OK && !tfTitle.getText().isBlank()) {
                CalendarItem c = new CalendarItem();
                c.setTitle(tfTitle.getText().trim());
                c.setKind(cbKind.getValue());
                c.setStartDate(dpDate.getValue());
                if (!cbAllDay.isSelected()) {
                    c.setAllDay(false);
                    c.setStartTime(LocalTime.of(spHour.getValue(), spMin.getValue()));
                } else c.setAllDay(true);
                return c;
            }
            return null;
        });

        Optional<CalendarItem> res = dlg.showAndWait();
        res.ifPresent(c -> {
            try {
                int id = dao.insert(c);
                c.setCalendarId(id);
                refresh();
            } catch (Exception ex) { ex.printStackTrace(); }
        });
    }

    // ===== list mode renderer =====
    private void renderListMode(Map<LocalDate, List<CalendarItem>> byDay) {
    listViewVBox.getChildren().clear();
    List<LocalDate> days = byDay.keySet().stream().sorted().toList();

    for (LocalDate d : days) {
        Label dateLabel = new Label(d.toString());
        dateLabel.getStyleClass().add("section-title");

        VBox dayBox = new VBox(6);
        dayBox.getChildren().add(dateLabel);

        for (CalendarItem it : byDay.get(d)) {
            HBox row = new HBox(8);
            row.setAlignment(Pos.CENTER_LEFT);

            CheckBox cb = new CheckBox();
            cb.setSelected(it.getStatus() == CalendarItem.Status.done);

            Label title = new Label(it.getTitle());
            title.getStyleClass().setAll("pill", cssByKind(it.getKind()));
            if (it.getStatus() == CalendarItem.Status.done) title.getStyleClass().add("done");

            cb.selectedProperty().addListener((o, was, now) -> {
                it.setStatus(now ? CalendarItem.Status.done : CalendarItem.Status.pending);
                if (now) title.getStyleClass().add("done"); else title.getStyleClass().remove("done");
                try { dao.markDone(it.getCalendarId(), now); } catch (Exception ex) { ex.printStackTrace(); }
                refresh();
            });

            Region spacer = new Region();
//            HBox.setHgrow(spacer, Priority.ALWAYS); //to push it on the right side (but it's too far)

            Button del = new Button("🗑");           // or "×"
            del.getStyleClass().addAll("icon-btn", "danger"); // style as you like
            del.setOnAction(ev -> {
                if (confirmDelete(it)) {
                    try { dao.delete(it.getCalendarId()); } catch (Exception ex) { ex.printStackTrace(); }
                    refresh(); // reloads month/week/list + upcoming
                }
            });

            row.getChildren().addAll(cb, title, new Text(timeText(it)), spacer, del);
            dayBox.getChildren().add(row);
        }

        dayBox.setPadding(new Insets(6, 0, 10, 0));
        listViewVBox.getChildren().add(dayBox);
        listViewVBox.getStyleClass().add("list-panel");
    }
}

    

    private String timeText(CalendarItem it) {
        return it.isAllDay() ? "all-day" :
                it.getStartTime().toString();
    }

    private String cssByKind(CalendarItem.Kind k) {
        return switch (k) {
            case Note -> "note";
            case Task -> "task";
            case Event -> "event";
            case Inventory -> "inventory";
        };
    }

    
    
    private class DayCell extends VBox {
        private final Label dayNumber = new Label();
        private final StackPane badge = new StackPane(dayNumber);
        private final VBox pillColumn = new VBox(4);      // holds our dots row + "more"
        private List<CalendarItem> lastItems = List.of(); // full list for peek
        private LocalDate date;

        private static final PseudoClass OTHER_MONTH = PseudoClass.getPseudoClass("other-month");

        DayCell() {
            getStyleClass().add("daycell");
            setPadding(new Insets(6));
            setSpacing(6);

            dayNumber.getStyleClass().add("day-number");
            badge.getStyleClass().add("day-badge");

            Button addBtn = new Button("+");
            addBtn.getStyleClass().add("icon-btn");
            addBtn.setOnAction(e -> quickAdd(date));

            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);
            getChildren().addAll(new HBox(6, badge, spacer, addBtn), pillColumn);

            // Hover handlers -> show card in the shared overlay
            setOnMouseEntered(e -> showPeek(this));
            setOnMouseExited (e -> hidePeek());

            // Double-click to quick add
            setOnMouseClicked(e -> {
                if (e.getButton() == MouseButton.PRIMARY && e.getClickCount() == 2) quickAdd(date);
            });
//            //Single-clicking a day in week view to move the anchor to that day’s week
//            setOnMouseClicked(e -> {
//                if (e.getButton() == MouseButton.PRIMARY && e.getClickCount() == 1 && viewMode == ViewMode.WEEK) {
//                    anchorDate = date;
//                    refresh();
//                }
//            });
        }

        void setDate(LocalDate d, YearMonth currentMonth) {
            this.date = d;
            dayNumber.setText(Integer.toString(d.getDayOfMonth()));

            boolean otherMonth = !d.getMonth().equals(currentMonth.getMonth());
            pseudoClassStateChanged(OTHER_MONTH, otherMonth);

            // today ring
            if (LocalDate.now().equals(d)) {
                if (!badge.getStyleClass().contains("today-ring")) badge.getStyleClass().add("today-ring");
            } else {
                badge.getStyleClass().remove("today-ring");
            }
        }

        void render(List<CalendarItem> items) {
            lastItems = sortItems(items);
            pillColumn.getChildren().clear();

            // --- compact dots row inside the cell ---
            FlowPane dots = makeDotsPane();
            final int MAX_DOTS = 12;
            int shown = 0;
            for (CalendarItem it : lastItems) {
                if (shown == MAX_DOTS) break;
                dots.getChildren().add(buildDot(it));
                shown++;
            }
            pillColumn.getChildren().add(dots);

            int remaining = lastItems.size() - shown;
            if (remaining > 0) {
                Label more = new Label("+" + remaining);
                more.getStyleClass().add("more-dots");
                pillColumn.getChildren().add(more);
            }
        }

        // ---------- helpers ----------

        private List<CalendarItem> sortItems(List<CalendarItem> items) {
            List<CalendarItem> sorted = new ArrayList<>(items);
            sorted.sort(Comparator
                .comparing(CalendarItem::isAllDay).reversed()
                .thenComparing(it -> Optional.ofNullable(it.getStartTime()).orElse(LocalTime.MAX))
                .thenComparing(it -> switch (it.getKind()) { case Task -> 0; case Event -> 1; case Inventory -> 2; case Note -> 3; })
                .thenComparing(CalendarItem::getTitle, String.CASE_INSENSITIVE_ORDER));
            return sorted;
        }

        private Node buildDot(CalendarItem it) {
            Circle c = new Circle(4.2);
            c.getStyleClass().addAll("dot", cssByKind(it.getKind()));
            if (it.getStatus() == CalendarItem.Status.done) c.setOpacity(0.45);

            Tooltip.install(c, new Tooltip(detailText(it)));

            // quick toggle complete for tasks
            c.setOnMouseClicked(e -> {
                if (it.getKind() == CalendarItem.Kind.Task) {
                    boolean done = it.getStatus() != CalendarItem.Status.done;
                    try { dao.markDone(it.getCalendarId(), done); } catch (Exception ex) { ex.printStackTrace(); }
                    refresh();
                }
            });
            return c;
        }

        private FlowPane makeDotsPane() {
            FlowPane fp = new FlowPane(4, 4);                    // hgap, vgap
            fp.setRowValignment(VPos.CENTER);
            fp.prefWrapLengthProperty().bind(widthProperty().subtract(12));
            return fp;
        }

        // pill used inside the hover card (no width binding!)
        private Label buildCardPill(CalendarItem it) {
            Label chip = new Label(it.getTitle());
            chip.getStyleClass().addAll("pill", cssByKind(it.getKind()));
            chip.setWrapText(false);
            chip.setTextOverrun(OverrunStyle.ELLIPSIS);
            chip.setPrefHeight(20); chip.setMinHeight(20); chip.setMaxHeight(20);
            Tooltip.install(chip, new Tooltip(detailText(it)));

            if (it.getStatus() == CalendarItem.Status.done) chip.getStyleClass().add("done");

            chip.setOnMouseClicked(e -> {
                if (it.getKind() == CalendarItem.Kind.Task) {
                    boolean done = it.getStatus() != CalendarItem.Status.done;
                    try { dao.markDone(it.getCalendarId(), done); } catch (Exception ex) { ex.printStackTrace(); }
                    refresh();
                }
            });
            return chip;
        }

        private String detailText(CalendarItem it) {
            return (it.isAllDay() ? "All-day" : it.getStartTime()+"") +
                    " • " + it.getKind() + (it.getDescription()==null ? "" : " • " + it.getDescription());
        }
        
        
    }


    
    private static String fmt(CalendarItem it) {
        String when = it.isAllDay() ? it.getStartDate().toString()
                                    : it.getStartDate() + " " + it.getStartTime();
        return when + "  •  " + it.getTitle();
    }

    private void setupLists() {
        upcomingList.setFixedCellSize(28);
//        remindersList.setFixedCellSize(28);
        
        
        upcomingList.setPrefHeight(6 * 28 + 2);
        upcomingList.setMinHeight(Region.USE_PREF_SIZE);
        upcomingList.setMaxHeight(Region.USE_PREF_SIZE);

        // Optional: disable horizontal scrollbars via CSS
        upcomingList.setStyle("-fx-padding: 0; -fx-background-insets: 0; ");


        Callback<ListView<CalendarItem>, ListCell<CalendarItem>> factory = lv -> new ListCell<>() {
            @Override protected void updateItem(CalendarItem it, boolean empty) {
                super.updateItem(it, empty);
                if (empty || it == null) { setText(null); }
                else { setText(fmt(it)); }
            }
        };
        upcomingList.setCellFactory(factory);
//        remindersList.setCellFactory(factory);
    }


    
    
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    
    // show/hide logic titles
    // Never let the hover card stay when changing views
    private void forceHidePeek() {
        try { hideDelay.stop(); } catch (Exception ignore) {}
        peekOverlay.setVisible(false);
    }

    // One unified entry point for Month / Week / List switching
    private void setMode(ViewMode m) {
        viewMode = m;
        forceHidePeek();

        boolean month = (m == ViewMode.MONTH);
        boolean week  = (m == ViewMode.WEEK);
        boolean list  = (m == ViewMode.LIST);

        // Header visible in Month and Week (hidden in List)
        weekdayHeader.setVisible(!list);
        weekdayHeader.setManaged(!list);

        // One grid for both Month and Week
        monthGrid.setVisible(!list);
        monthGrid.setManaged(!list);

        // List panel
        listViewWrapper.setVisible(list);
        listViewWrapper.setManaged(list);

        // Size & margin policy per mode
        if (week) clampWeekHeight();
        else      unclampMonthHeight();

        rebuildGridForView();    // 1×7 in week, 6×7 in month
        updateTitleForCurrentMode();
        refresh();
    }



    // Shorter title & smaller font in Week
    private void updateTitleForCurrentMode() {
        if (viewMode == ViewMode.WEEK) {
            LocalDate start = weekStart;
            LocalDate end   = weekStart.plusDays(6);
            String s = start.format(java.time.format.DateTimeFormatter.ofPattern("MMM d"));
            String e = end.format(java.time.format.DateTimeFormatter.ofPattern("MMM d, yyyy"));
            lblMonthYear.setText(s + " – " + e);
            if (!lblMonthYear.getStyleClass().contains("month-title--small")) {
                lblMonthYear.getStyleClass().add("month-title--small");
            }
        } else {
            String mmm = visibleMonth.getMonth()
                    .getDisplayName(java.time.format.TextStyle.SHORT, java.util.Locale.getDefault()); // “Oct”
            lblMonthYear.setText(mmm + " " + visibleMonth.getYear());
            lblMonthYear.getStyleClass().remove("month-title--small");
        }
    }
    
    //building header & grid
    // ---------- UI builders ----------

    private void buildWeekdayHeader() {
        weekdayHeader.getChildren().clear();
        for (int c = 0; c < 7; c++) {
            DayOfWeek dow = DayOfWeek.MONDAY.plus(c);
            Label lbl = new Label(dow.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
            lbl.getStyleClass().add("weekday");
            GridPane.setColumnIndex(lbl, c);
            weekdayHeader.getChildren().add(lbl);
        }
    }

    // Build 6x7 for Month or 1x7 for Week (reuse the same grid)
    private void rebuildGridForView() {
        monthGrid.getChildren().clear();
        cells.clear();

        int rows = (viewMode == ViewMode.WEEK ? 1 : 6);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < 7; c++) {
                DayCell cell = new DayCell();
                bindCellSize(cell, rows);
                GridPane.setRowIndex(cell, r);
                GridPane.setColumnIndex(cell, c);
                monthGrid.getChildren().add(cell);
                cells.add(cell);
            }
        }

        // A little spacing tune
        monthGrid.setHgap(14);
        monthGrid.setVgap(rows == 1 ? 8 : 14);
        monthGrid.setPrefHeight(rows == 1 ? 320 : Region.USE_COMPUTED_SIZE);
    }

    // Bind a cell to the grid width / height based on number of rows
    private void bindCellSize(Region cell, int rows) {
        cell.prefWidthProperty().bind(
                monthGrid.widthProperty().subtract((7 - 1) * monthGrid.getHgap()).divide(7)
        );
        cell.prefHeightProperty().bind(
                monthGrid.heightProperty().subtract((rows - 1) * monthGrid.getVgap()).divide(rows)
        );
        cell.minWidthProperty().bind(cell.prefWidthProperty());
        cell.maxWidthProperty().bind(cell.prefWidthProperty());
        cell.minHeightProperty().bind(cell.prefHeightProperty());
        cell.maxHeightProperty().bind(cell.prefHeightProperty());
    }

    //refresh (renders month/week/list)
    private void refresh() {
        updateTitleForCurrentMode();

        EnumSet<CalendarItem.Kind> kinds = activeKinds();

        // Date range to load
        LocalDate start, end;
        if (viewMode == ViewMode.WEEK) {
            start = weekStart;
            end   = weekStart.plusDays(6);
        } else {
            start = visibleMonth.atDay(1)
                    .with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            end   = start.plusDays(41);
        }

        List<CalendarItem> items;
        try {
            items = dao.findBetween(start, end, kinds);
        } catch (Exception ex) {
            ex.printStackTrace();
            items = List.of();
        }
        Map<LocalDate, List<CalendarItem>> byDay =
                items.stream().collect(Collectors.groupingBy(CalendarItem::getStartDate));

        if (viewMode == ViewMode.LIST) {
            renderListMode(byDay);
        } else {
            LocalDate d = start;
            for (DayCell cell : cells) {
                YearMonth currentYM = YearMonth.from(d);
                // In MONTH view, highlight other-month cells.
                // In WEEK view, every cell belongs to currentYM.
                cell.setDate(d, (viewMode == ViewMode.MONTH) ? visibleMonth : currentYM);
                cell.render(byDay.getOrDefault(d, List.of()));
                d = d.plusDays(1);
            }
        }

        // Sidebar stays in sync
        try {
            upcomingList.getItems().setAll(dao.findUpcoming(6));
//            remindersList.getItems().setAll(dao.remindersDueToday());
        } catch (Exception ex) { ex.printStackTrace(); }
        triggerNotifRefreshNow();
    }

    //peek overlay
    private void initPeekOverlay() {
        peekOverlay.setPickOnBounds(false);
        peekOverlay.setMouseTransparent(true); // hover only
        peekOverlay.setVisible(false);

        peekCard.getStyleClass().add("peek-card");
        peekOverlay.getChildren().add(peekCard);

        // IMPORTANT: add (not setAll) so header/grid/list remain in StackPane
        calendarStack.getChildren().add(peekOverlay);
        StackPane.setAlignment(peekOverlay, Pos.TOP_LEFT);

        hideDelay.setOnFinished(e -> peekOverlay.setVisible(false));
    }

    private void showPeek(DayCell cell) {
        hideDelay.stop();

        List<CalendarItem> items = cell.lastItems;
        if (items == null || items.isEmpty()) { hidePeek(); return; }

        peekCard.getChildren().clear();
        Label title = new Label(cell.date.toString());
        title.getStyleClass().add("peek-title");
        peekCard.getChildren().add(title);

        for (CalendarItem it : items) {
            Label pill = cell.buildCardPill(it);
            HBox row = new HBox(8, pill, new Text(" " + timeText(it)));
            row.getStyleClass().add("peek-row");
            row.setAlignment(Pos.CENTER_LEFT);
            peekCard.getChildren().add(row);
        }

        Bounds b = peekOverlay.sceneToLocal(cell.localToScene(cell.getBoundsInLocal()));
        double prefW = Math.max(260, cell.getWidth() * 1.6);
        peekCard.setPrefWidth(prefW);
        double cardH = peekCard.prefHeight(-1);

        double x = b.getMinX() - 6;
        double y = b.getMinY() - 6;

        double maxX = calendarStack.getWidth()  - 12;
        double maxY = calendarStack.getHeight() - 12;

        if (x + prefW > maxX) x = Math.max(12, maxX - prefW);
        if (y + cardH > maxY) y = Math.max(12, maxY - cardH);

        peekCard.relocate(x, y);
        peekOverlay.setVisible(true);
    }

    private void hidePeek() { hideDelay.playFromStart(); }


    private void clampWeekHeight() {
        // keep WEEK compact and below the top edge
        monthGrid.setPrefHeight(25);                  // choose what looks good on your screen
        monthGrid.setMinHeight(Region.USE_PREF_SIZE);
        monthGrid.setMaxHeight(Region.USE_PREF_SIZE);  // <- critical so it won’t stretch

        // smaller top gap in WEEK (we don’t show a big weekday band)
        StackPane.setMargin(monthGrid, new Insets(160, 0, 0, 0));
    }

    private void unclampMonthHeight() {
        // let MONTH fill the card
        monthGrid.setPrefHeight(Region.USE_COMPUTED_SIZE);
        monthGrid.setMinHeight(Region.USE_COMPUTED_SIZE);
        monthGrid.setMaxHeight(Double.MAX_VALUE);

        // restore larger gap so labels sit above the grid
        StackPane.setMargin(monthGrid, new Insets(28, 0, 0, 0));
    }
    
    //delete a task/note/event, etc. 
    private boolean confirmDelete(CalendarItem it) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Delete item");
        a.setHeaderText("Delete this item?");
        a.setContentText(it.getTitle() + " (" + it.getKind() + ")");
        a.getButtonTypes().setAll(ButtonType.CANCEL, ButtonType.OK);
        return a.showAndWait().filter(bt -> bt == ButtonType.OK).isPresent();
        
    }

    //for legend color
    private void buildLegend() {
        legendBox.getChildren().setAll(
            legendRow("Notes",     "note"),
            legendRow("Tasks",     "task"),
            legendRow("Events",    "event"),
            legendRow("Inventory", "inventory")
        );
    }

    private HBox legendRow(String text, String kindCss) {
        Circle dot = new Circle(6);
        dot.getStyleClass().addAll("dot", kindCss);
        Label lbl = new Label(text);
        HBox row = new HBox(8, dot, lbl);
        row.setAlignment(Pos.CENTER_LEFT);
        return row;
    }

    ////////////////////////////////////////////////////////////////////////////SETTINGS
 
    private void clearPasswordSide() {
        current_pw.clear(); new_pw.clear(); confirm_pw.clear();
        current_pw_tf.clear(); new_pw_tf.clear(); confirm_pw_tf.clear();
        // default to masked
        current_pw.setVisible(true);  current_pw_tf.setVisible(false);
        new_pw.setVisible(true);      new_pw_tf.setVisible(false);
        confirm_pw.setVisible(true);  confirm_pw_tf.setVisible(false);
    }

    // ---- TOGGLE HANDLERS ----
    @FXML private void Edit_AdminProfile(ActionEvent event) {
        ToggleButton tb = (ToggleButton) event.getSource();
        Profile_gridpane.setDisable(!tb.isSelected());
    }

    @FXML private void Edit_AdminPassword(ActionEvent event) {
        ToggleButton tb = (ToggleButton) event.getSource();
        Password_gridpane.setDisable(!tb.isSelected());
    }

    // ---- PHOTO HANDLERS ----
    @FXML private void onChangePhoto(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose Profile Photo");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.png","*.jpg","*.jpeg"));
        File f = fc.showOpenDialog(ADMINusername_tf.getScene().getWindow());
        if (f != null) {
            stagedPhoto = f;
//            AdminPhoto_edit.setImage(new Image(f.toURI().toString(), true)); // preview only
        Image preview = new Image(f.toURI().toString(), false);
        setCircularImage(AdminPhoto_edit, preview, 120);
        setCircularImage(AdminPhoto,      preview, 70);

        }
    }

    private boolean stagedRemove = false;
    @FXML private void onRemovePhoto(ActionEvent e) {
        stagedPhoto = null;
        stagedRemove = true;
        refreshAdminPhotos(null);    // show default avatar (circular) in both views
    }



    @FXML
    private void onSaveProfile(ActionEvent event) {
        String f = ADMINfirstName_tf.getText().trim();
        String l = ADMINlastName_tf.getText().trim();
        String c = ADMINcontactNumber_tf.getText().trim();  // optional

        if (f.isEmpty() || l.isEmpty()) {
            showPopup("First and last name are required.", "warning");
            return;
        }

        // Optional: simple contact validation
        if (!c.isBlank() && !c.matches("[0-9+\\-() ]{7,20}")) {
            showPopup("Contact number looks invalid.", "warning");
            return;
        }

        // Decide final photo
        String newPath = origPhotoPath;
        try {
            if (stagedPhoto != null) {
                File dir = new File(APP_IMG_DIR);
                if (!dir.exists()) dir.mkdirs();
                String name = stagedPhoto.getName().toLowerCase();
                String ext = (name.endsWith(".png")) ? ".png" : ".jpg";
                File dest = new File(dir, "user_" + Session.userId + ext);
                Files.copy(stagedPhoto.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
                newPath = dest.getAbsolutePath();
            } else if (stagedRemove) {
                newPath = null;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            showPopup("Error saving photo.", "error");
            return;
        }

        // DB update (NO username here)
        boolean ok = userDao.updateProfileNoUsername(Session.userId, f, l, c.isBlank()? null : c, newPath);
        if (!ok) {
            showPopup("Failed to update profile.", "error");
            return;
        }

        // Commit originals
        origFirst = f; origLast = l; origContact = c.isBlank()? null : c; origPhotoPath = newPath;
        stagedPhoto = null; stagedRemove = false;

        // ---- REFRESH UI ----
        campusNurse_fullName.setText(f + " " + l);

        // Load updated image and apply circular crop
        Image img = (newPath != null && new File(newPath).exists())
                ? new Image(new File(newPath).toURI().toString(), true)
                : defaultAvatar();

        // NEW: use circular image helper
        adminImagePath = newPath; // update current path reference
//        setCircularImage(AdminPhoto, img, 70);       // sidebar photo
//        setCircularImage(AdminPhoto_edit, img, 120); // settings photo
        refreshAdminPhotos(adminImagePath);


        showPopup("Profile updated.", "success");
        Profile_gridpane.setDisable(true);
        toggleProfile.setSelected(false);   // turn OFF the toggle
    }

    @FXML
    private void onCancelProfile(ActionEvent event) {
        ADMINfirstName_tf.setText(origFirst);
        ADMINlastName_tf.setText(origLast);
        ADMINcontactNumber_tf.setText(origContact == null ? "" : origContact);

        // now:
        stagedPhoto = null;
        stagedRemove = false;
        refreshAdminPhotos(origPhotoPath);   // restores both AdminPhoto & AdminPhoto_edit

        Profile_gridpane.setDisable(true);
        toggleProfile.setSelected(false);
    }
    
    /** Draw admin photos (sidebar=70, settings=120) from a file path or fallback. */
    private void refreshAdminPhotos(String pathOrNull) {
        Image img = null;

        if (pathOrNull != null && !pathOrNull.isBlank()) {
            File f = new File(pathOrNull);
            if (f.exists()) {
                img = new Image(f.toURI().toString(), false);
            }
        }
        if (img == null) {
            // fallback resource you already use
            Image def = defaultAvatar();
            img = def;
        }

        setCircularImage(AdminPhoto,      img, 70);
        setCircularImage(AdminPhoto_edit, img, 120);
    }


    // ---- PASSWORD SIDE ----
    // Eye icon wiring (call once in initialize)
    private void wireEye(ImageView eye, PasswordField pf, TextField tf) {
        tf.managedProperty().bind(tf.visibleProperty());
        pf.managedProperty().bind(pf.visibleProperty());
        eye.setOnMouseClicked(e -> {
            if (pf.isVisible()) { tf.setText(pf.getText()); pf.setVisible(false); tf.setVisible(true); tf.requestFocus(); tf.end(); }
            else { pf.setText(tf.getText()); tf.setVisible(false); pf.setVisible(true); pf.requestFocus(); pf.end(); }
        });
    }


    @FXML
    private void onChangePassword(ActionEvent event) {
        String cur = current_pw.isVisible() ? current_pw.getText() : current_pw_tf.getText();
        String npw = newPassText();     // helper for reading new password
        String cfm = confirmPassText(); // helper for reading confirm password
        String desiredUser = ADMINusername_tf.getText().trim();

        boolean wantUsername = !desiredUser.isBlank();
        boolean wantPassword = !(npw.isBlank() && cfm.isBlank());

        // Require at least one of username/password
        if (!wantUsername && !wantPassword) {
            showPopup("Please enter a new username and/or password.", "warning");
            return;
        }

        // Validate new password if given
        if (wantPassword) {
            if (npw.length() < 8) {
                showPopup("New password must be at least 8 characters.", "warning");
                return;
            }
            if (!npw.equals(cfm)) {
                showPopup("New password and confirm password do not match.", "warning");
                return;
            }
        }

        // Fetch stored password hash
        String storedHash = userDao.getPasswordHash(Session.userId);
        if (storedHash == null) {
            showPopup("Unable to fetch stored password.", "error");
            return;
        }

        // Verify current password (supports plaintext or BCrypt)
        if (!verifyCurrentPassword(cur, storedHash)) {
            showPopup("Current password is incorrect.", "error");
            return;
        }

        // Generate new BCrypt hash if user entered new password
        String newHash = null;
        if (wantPassword) {
            newHash = org.mindrot.jbcrypt.BCrypt.hashpw(npw, org.mindrot.jbcrypt.BCrypt.gensalt());
        }

        // Update username and/or password
        boolean ok = userDao.updateCredentials(
                Session.userId,
                wantUsername ? desiredUser : null,
                newHash // null if password unchanged
        );

        if (!ok) {
            showPopup("Failed to update credentials.", "error");
            return;
        }

        // Success — update local state
        if (wantUsername) {
            origUser = desiredUser;
            ADMINusername_tf.setText(desiredUser);
        }

        showPopup("Credentials updated successfully.", "success");

        // Reset form state
        clearPasswordSide();
        Password_gridpane.setDisable(true);
        togglePassword.setSelected(false);
    }


    private String newPassText() {
        return new_pw.isVisible()? new_pw.getText() : new_pw_tf.getText();
    }
    private String confirmPassText() {
        return confirm_pw.isVisible()? confirm_pw.getText() : confirm_pw_tf.getText();
    }

    @FXML
    private void onCancelPassword(ActionEvent event) {
        clearPasswordSide();
        Password_gridpane.setDisable(true);
        togglePassword.setSelected(false);
    }

    // ---- DAO helpers (implement with DB class) ---- 
    private boolean updateUserProfile(int id, String first, String last, String user, String photoPath) {
        String sql = "UPDATE users SET first_name=?, last_name=?, username=?, photo_path=? WHERE user_id=?";
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, first); ps.setString(2, last); ps.setString(3, user);
            ps.setString(4, photoPath); ps.setInt(5, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    private String getUserPasswordHash(int id) {
        String sql = "SELECT password FROM users WHERE user_id=?";
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) { return rs.next()? rs.getString(1) : ""; }
        } catch (SQLException e) { e.printStackTrace(); return ""; }
    }

    private boolean updateUserPassword(int id, String hash) {
        String sql = "UPDATE users SET password=? WHERE user_id=?";
        try (Connection c = MySQL.connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, hash); ps.setInt(2, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    // ---- tiny toast (optional) ----
    private void showToast(String text) {
        // replace with notifier/snackbar implementation
        System.out.println(text);
    }

    // call this whenever you set/change the student photo
    private void setCircularImage(ImageView iv, Image img, double size) {
        if (img == null || img.getWidth() <= 0 || img.getHeight() <= 0) {
            iv.setImage(img);
            iv.setViewport(null);
            iv.setFitWidth(size);
            iv.setFitHeight(size);
            iv.setPreserveRatio(false);
            makeCircular(iv);
            return;
        }

        double iw = img.getWidth();
        double ih = img.getHeight();
        double side = Math.min(iw, ih);
        double x = (iw - side) / 2.0;
        double y = (ih - side) / 2.0;

        iv.setImage(img);
        iv.setViewport(new Rectangle2D(x, y, side, side)); // center-crop to square
        iv.setFitWidth(size);
        iv.setFitHeight(size);
        iv.setPreserveRatio(false); // square viewport already, so fill
        iv.setSmooth(true);
        makeCircular(iv);
    }

    
    //to load profile, admin photo, and full name when user opens the system
    private void makeCircular(ImageView iv) {
        Circle clip = new Circle();
        clip.centerXProperty().bind(iv.fitWidthProperty().divide(2));
        clip.centerYProperty().bind(iv.fitHeightProperty().divide(2));
        clip.radiusProperty().bind(Bindings.createDoubleBinding(
            () -> Math.min(iv.getFitWidth(), iv.getFitHeight()) / 2, 
            iv.fitWidthProperty(), iv.fitHeightProperty()
        ));
        iv.setClip(clip);
    }

    
    /** Fallback image inside resources (put one): /img/avatar-default.png */
    private Image defaultAvatar() {
        URL u = getClass().getResource("/img/avatar-default.png");
        if (u != null) return new Image(u.toExternalForm(), true);
        // last-ditch fallback: a 1x1 transparent image so we never NPE
        return new Image(new ByteArrayInputStream(new byte[] {
            (byte)0x89,0x50,0x4E,0x47,0x0D,0x0A,0x1A,0x0A,0,0,0,0 // …(omit)…
        }));
    }


    private void loadUserFromDB() {
        int uid = (Session.userId == 0) ? 1 : Session.userId;
        User u = userDao.findById(uid);
        if (u == null) return;

        // originals
        origFirst     = u.getFirstName();
        origLast      = u.getLastName();
        origUser      = u.getUsername();
        origPhotoPath = u.getPhotoPath();
        origContact   = u.getContactNumber();

        // expose current admin image path for reuse
        adminImagePath = origPhotoPath;

        // paint BOTH admin photos (sidebar=70, settings=120) with crop+circle
        refreshAdminPhotos(adminImagePath);

        // fill fields / labels
        ADMINfirstName_tf.setText(origFirst);
        ADMINlastName_tf.setText(origLast);
        ADMINcontactNumber_tf.setText(origContact == null ? "" : origContact);
        ADMINusername_tf.setText(origUser);
        campusNurse_fullName.setText(origFirst + " " + origLast);

        // start disabled
        Profile_gridpane.setDisable(true);
        Password_gridpane.setDisable(true);
        toggleProfile.setSelected(false);
        togglePassword.setSelected(false);
    }

    
    private void animateThumb(ToggleButton tb) {
        StackPane sw = (StackPane) tb.getGraphic();
        Region thumb = (Region) sw.lookup(".thumb");
        double offX = 2, onX = 22;
        tb.selectedProperty().addListener((obs, oldV, sel) -> {
            TranslateTransition t = new TranslateTransition(Duration.millis(120), thumb);
            t.setToX(sel ? onX : offX);
            t.play();
        });
    }

    private void showPopup(String message, String colorOrType) {
    String hex = switch (colorOrType.toLowerCase()) {
        case "success" -> "#18A558";
        case "warning" -> "#F4B400";
        case "error"   -> "#D93025";
        case "info"    -> "#1A73E8";
        default        -> colorOrType; // allow "#RRGGBB"
    };

    Runnable task = () -> {
        if (AdminPhoto == null || AdminPhoto.getScene() == null) {
            Platform.runLater(() -> showPopup(message, colorOrType));
            return;
        }

        Label text = new Label(message);
        text.setTextFill(Color.WHITE);
        text.setStyle("-fx-font-size: 13px; -fx-font-weight: 500;");

        HBox toast = new HBox(text);
        toast.setAlignment(Pos.CENTER);
        toast.setPadding(new Insets(12,20,12,20));
        toast.setBackground(new Background(new BackgroundFill(Color.web(hex), new CornerRadii(10), Insets.EMPTY)));
        toast.setOpacity(0);

        // Layout so we can measure width/height after shown
        toast.applyCss(); toast.layout();

        Popup popup = new Popup();
        popup.setAutoFix(true);
        popup.setAutoHide(false);
        popup.setHideOnEscape(true);
        popup.getContent().add(toast);

        Node rootNode = AdminPhoto.getScene().getRoot();
        Bounds b = rootNode.localToScreen(rootNode.getBoundsInLocal());
        Window owner = AdminPhoto.getScene().getWindow();

        // Show once (anywhere) to get real size
        popup.show(owner, b.getMinX(), b.getMinY());
        double w = toast.getWidth();
        double h = toast.getHeight();

        // Center inside the scene bounds
        double x = b.getMinX() + (b.getWidth() - w) / 2.0;
        double y = b.getMinY() + (b.getHeight() - h) / 2.0;
        popup.setX(x);
        popup.setY(y);

        FadeTransition fi = new FadeTransition(Duration.millis(200), toast);
        fi.setFromValue(0); fi.setToValue(1);

        PauseTransition wait = new PauseTransition(Duration.seconds(2.2));

        FadeTransition fo = new FadeTransition(Duration.millis(350), toast);
        fo.setFromValue(1); fo.setToValue(0);
        fo.setOnFinished(e -> popup.hide());

        new SequentialTransition(fi, wait, fo).play();
    };

    if (Platform.isFxApplicationThread()) task.run();
    else Platform.runLater(task);
}

    private void wireSwitch(ToggleButton tb) {
        // The graphic structure we built above:
        Pane sw = (Pane) tb.getGraphic();                  // .switch
        Region track = (Region) sw.lookup(".track");
        Region thumb = (Region) sw.lookup(".thumb");

        // Constants must match CSS sizes
        double trackW = 44, thumbW = 20, padding = 2;
        double offX = padding;                              // 2
        double onX  = trackW - thumbW - padding;           // 22

        // Set initial position based on selected
        thumb.setTranslateX(tb.isSelected() ? onX - offX : 0);

        // Animate when toggled
        tb.selectedProperty().addListener((obs, oldV, sel) -> {
            double target = sel ? onX - offX : 0;          // we animate the delta from base layoutX=2
            TranslateTransition t = new TranslateTransition(Duration.millis(130), thumb);
            t.setToX(target);
            t.play();
        });
    }

    //password bycripts
    private static boolean looksLikeBcrypt(String s) {
        if (s == null) return false;
        // $2a$ or $2b$ or $2y$ + 2 cost digits + $ + 53 chars = 60 total
        return s.matches("^\\$2[aby]\\$\\d{2}\\$[./A-Za-z0-9]{53}$");
    }

    private boolean verifyCurrentPassword(String inputCurrent, String storedFromDB) {
        if (storedFromDB == null || storedFromDB.isBlank()) return false;
        if (looksLikeBcrypt(storedFromDB)) {
            try {
                return org.mindrot.jbcrypt.BCrypt.checkpw(inputCurrent, storedFromDB);
            } catch (IllegalArgumentException badSalt) {
                // In case something still weird with the hash
                return false;
            }
        } else {
            // Legacy plaintext password support (one-time migration)
            return inputCurrent.equals(storedFromDB);
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////NOTIFICATIONS
    /** Applies the current search + toggle into the FilteredList predicate. */
    private void refreshPredicate() {
        final String q = (search_tf.getText() == null) ? "" : search_tf.getText().trim().toLowerCase();

        // which type (All / Inventory / Events)?
        Notification.Type selectedType = null;
        if (inv_tb.isSelected()) selectedType = Notification.Type.INVENTORY;
        else if (cal_tb.isSelected()) selectedType = Notification.Type.EVENT;

        final Notification.Type filterType = selectedType; // effectively final for lambda
        final boolean onlyUnread = unread_tb.isSelected();

        notifFiltered.setPredicate(n -> {
            if (n == null) return false;

            // unread filter
            if (onlyUnread && n.isRead()) return false;

            // type filter
            if (filterType != null && n.getRelatedType() != filterType) return false;

            // text search (title/body/severity)
            if (!q.isEmpty()) {
                String hay = ( (n.getTitle() == null ? "" : n.getTitle()) + " " +
                               (n.getBody()  == null ? "" : n.getBody())  + " " +
                               (n.getSeverity() == null ? "" : n.getSeverity().name())
                             ).toLowerCase();
                if (!hay.contains(q)) return false;
            }
            return true;
        });
    }


    /** Custom cell with severity color, unread style, and a delete button. */
    private void setupNotificationCellFactory() {
        notif_lv.setCellFactory(lv -> new ListCell<>() {
            private final Label title = new Label();
            private final Label meta  = new Label();
            private final Button del  = new Button("Delete");
            private final VBox   texts = new VBox(2, title, meta);
            private final HBox   root  = new HBox(12, texts, del);

            {
                // styling hooks to match notifications.css
                del.getStyleClass().add("ghost-danger");
                texts.setAlignment(Pos.CENTER_LEFT);
                root.setAlignment(Pos.CENTER_LEFT);
                HBox.setHgrow(texts, Priority.ALWAYS);

                // delete handler (inside setupNotificationCellFactory())
                del.setOnAction(e -> {
                    Notification n = getItem();
                    if (n == null) return;

                    if (n.isAutoGenerated()) {
                        // Snooze for today so it won't re-appear again today
                        boolean ok = NotificationDAO.snoozeAuto(n.getKind(),
                                                                n.getRelatedType().name(),
                                                                n.getRelatedId(),
                                                                1 /* days */);
                        if (ok) notifMaster.remove(n);
                        refreshUnreadFilter();          // <— updates badge immediately
                    } else {
                        if (NotificationDAO.deleteById(n.getId())) {
                            notifMaster.remove(n);
                            refreshUnreadFilter();          // <— updates badge immediately
                        }
                    } triggerNotifRefreshNow();
                });

                // mark read on click
                setOnMouseClicked(e -> {
                    Notification n = getItem();
                    if (n != null && e.getClickCount() == 1) {
                        // Toggle read state (or simply mark read)
                        boolean target = true; // mark read on single click (change if want toggle) = to toggle read/unread on click, use boolean target = !n.isRead(); instead
                        boolean dbOk = NotificationDAO.markRead(n.getId(), target);
                        if (dbOk) {
                            n.setRead(target);      // update in-memory model
                            // keep pseudo-class in sync by forcing style recompute
                            pseudoClassStateChanged(PC_UNREAD, !n.isRead());
                            refreshUnreadFilter();          // <— updates badge immediately
                            notif_lv.refresh();
                        } else {
                            new Alert(Alert.AlertType.ERROR, "Failed to update notification in database.").showAndWait();
                        }
                    } refreshUnreadFilter();          // <— updates badge immediately
                      triggerNotifRefreshNow();
                });
            }

            @Override protected void updateItem(Notification n, boolean empty) {
                super.updateItem(n, empty);
                if (empty || n == null) {
                    setGraphic(null);
                    getStyleClass().removeAll("sev-info","sev-warning","sev-danger");
                    pseudoClassStateChanged(PC_UNREAD, false);
                    return;
                }

                title.setText(n.getTitle());
//                meta.setText(n.getCreatedAt().toString() + "  •  " + n.getBody());
                meta.setText(DISPLAY_FMT.format(n.getCreatedAt()) + "  •  " + n.getBody());

                // severity border color (via CSS classes)
                getStyleClass().removeAll("sev-info","sev-warning","sev-danger");
                switch (n.getSeverity()) {
                    case INFO    -> getStyleClass().add("sev-info");
                    case WARNING -> getStyleClass().add("sev-warning");
                    case DANGER  -> getStyleClass().add("sev-danger");
                }

                // unread tint (via pseudo-class)
                pseudoClassStateChanged(PC_UNREAD, !n.isRead());
                setGraphic(root);
            }
        });
    }
    
    private void setupNotificationBadge() {
        // place badge at the top-right of the bell (tweak offsets for your layout)
        StackPane.setAlignment(notifBadgePane, Pos.TOP_RIGHT);
        notifBadgePane.setTranslateX(8);
        notifBadgePane.setTranslateY(-8);

        // mouse clicks should pass through to the bell/pane
        notifBadgePane.setMouseTransparent(true);

        // bind label text and visibility straight to the unread filtered list
        notifBadgeLabel.textProperty().bind(Bindings.size(unreadFiltered).asString());
        notifBadgePane.visibleProperty().bind(Bindings.size(unreadFiltered).greaterThan(0));
    }
    
    private void runNotifRefreshOnce() {
        try {
            NotificationDAO.refreshFromDB();                 // CALL sp_refresh_notifications()
            ObservableList<Notification> fresh = NotificationDAO.findAll();

            Platform.runLater(() -> {
                notifMaster.setAll(fresh);  // keeps bindings alive
                refreshPredicate();         // if have search/toggle filters on the ListView
                refreshUnreadFilter();          // <— updates badge immediately
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void shutdown() {
        if (notifScheduler != null) notifScheduler.shutdownNow();
    }
    
    /** Force FilteredList to re-evaluate without changing the predicate. */
    private void refreshUnreadFilter() {
        if (unreadFiltered == null) return;
        unreadFiltered.setPredicate(unreadFiltered.getPredicate());
    }

    /** Call this after any action that may change notifications (inventory/consultations/calendar). */
    private void triggerNotifRefreshNow() {
        if (!notifRefreshInFlight.compareAndSet(false, true)) return; // already running

        notifExec.submit(() -> {
            try {
                // 1) Rebuild notifications in DB
                NotificationDAO.refreshFromDB();

                // 2) Pull fresh list
                var fresh = NotificationDAO.findAll();

                // 3) Push into the SAME master list on FX thread (keeps bindings/filters/badge)
                javafx.application.Platform.runLater(() -> {
                    notifMaster.setAll(fresh);
                    refreshPredicate();          // keep current filters/search applied
                    // badge will auto-update because it’s bound to notifMaster via your setup
                });
            } finally {
                notifRefreshInFlight.set(false);
            }
        });
    }
    public void onClose1(){
        notifExec.shutdownNow();
    }
////////////////////////////////////////////////////////////////////////////////end of notification
    
////////////////////////////////////////////////////////////////////////////////REPORTS
 /* ===========================================================
       (C) OUTSIDE INITIALIZATION: loaders & helpers
       =========================================================== */

    // -------- OVERVIEW --------
    private void refreshOverview() {
        try {
            kpiConsultationsToday.setText(String.valueOf(reportsDAO.consultationsToday()));
            kpiConsultationsMonth.setText(String.valueOf(reportsDAO.consultationsThisMonth()));
            kpiActiveStudents.setText(String.valueOf(reportsDAO.activeStudents()));
            kpiMedsUsed.setText(String.valueOf(reportsDAO.totalMedsUsedAllTime()));

            int y = Year.now().getValue();
            ChartUtils.fillBar(castBar(overviewConsultationsPerMonthChart), "Consultations", reportsDAO.consultationsPerMonth(y));
            ChartUtils.fillPie(overviewBpStatusPie, reportsDAO.bpStatusCounts());
            ChartUtils.fillPieFromList(overviewTopComplaintsPie, reportsDAO.topComplaints(3));
            ChartUtils.fillLine(castLine(overviewMedsUsageTrend), "Units Used", reportsDAO.medsUsageTrendByMonth(y));
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    // -------- CONSULTATIONS --------
    // AFTER (charts only)
    private void refreshConsultations() {
        LocalDate from = consFromDate.getValue();
        LocalDate to   = consToDate.getValue();

        try {
            // Bar
            ChartUtils.fillBar(castBar(monthlyConsultationsBar),
                    "Consultations",
                    reportsDAO.consultationsMonthlyInRange(from, to));

            // Top complaints: legend shows "Label — N (p%)"
            topComplaintsPie.setData(
                    ChartUtils.pieDataWithStatsFromList(
                            reportsDAO.topComplaintsInRange(from, to)
                    )
            );
            topComplaintsPie.setLabelsVisible(false);
            topComplaintsPie.setLegendVisible(true);

            // BP status: legend shows "Label — N (p%)"
            bpStatusPie.setData(
                    ChartUtils.pieDataWithStatsFromMap(
                            reportsDAO.bpStatusInRange(from, to)
                    )
            );
            bpStatusPie.setLabelsVisible(false);
            bpStatusPie.setLegendVisible(true);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }




    // -------- VISITS --------
    private void refreshVisits() {
        LocalDate from = visFromDate.getValue();
        LocalDate to   = visToDate.getValue();

        try {
            visitRows.setAll(reportsDAO.visitsRange(from, to));
            ChartUtils.fillBar(castBar(visitsByYearLevelBar), "Visits", reportsDAO.visitsByYearLevel(from, to));
            ChartUtils.fillBar(castBar(visitsByCourseBar), "Visits", reportsDAO.visitsByCourse(from, to));
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    // -------- INVENTORY --------
    private void refreshInventory() {
        try {
            usageRows.setAll(reportsDAO.medicineUsage(invSearchField.getText()));
            // Trend: reuse overview meds trend line for current year (usage across all items)
            ChartUtils.fillLine(castLine(itemUsageTrendChart), "Units Used", reportsDAO.medsUsageTrendByMonth(Year.now().getValue()));
            refreshLowStock(); // preload
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    private void refreshLowStock() {
        try { lowRows.setAll(reportsDAO.lowStock(10)); } catch (Exception ex) { ex.printStackTrace(); }
    }

    private void refreshExpiring() {
        try { lowRows.setAll(reportsDAO.expiringSoon(30)); } catch (Exception ex) { ex.printStackTrace(); }
    }

    // -------- small casting helpers for generic FXML charts --------
    @SuppressWarnings("unchecked")
    private BarChart<String,Number> castBar(BarChart<?,?> b) { return (BarChart<String,Number>) (BarChart<?,?>) b; }
    @SuppressWarnings("unchecked")
    private LineChart<String,Number> castLine(LineChart<?,?> l) { return (LineChart<String,Number>) (LineChart<?,?>) l; }


    // Make sure pie labels render immediately (no need to export first)
    private void forcePieLabels(javafx.scene.chart.PieChart pie) {
        pie.setLabelsVisible(true);
        pie.setLegendVisible(true);
        pie.setAnimated(false);               // avoids re-animation hiding labels

        javafx.application.Platform.runLater(() -> {
            pie.applyCss();                   // compute styles
            pie.layout();                     // force layout pass
            pie.lookupAll(".chart-pie-label").forEach(n -> n.setVisible(true));
        });
    }

    private void stabilizePie(PieChart pie) {
        pie.setAnimated(false);
        pie.setLabelsVisible(true);
        pie.setLegendVisible(true);
        pie.setLabelLineLength(18);         // a bit longer leader lines helps too

        // make sure layout happens after parent finished resizing
        Platform.runLater(() -> {
            pie.applyCss();
            pie.requestLayout();
            pie.layout();                    // force a full pass now
            pie.lookupAll(".chart-pie-label").forEach(n -> n.setVisible(true));
        });
    }
    
    private PieChart rebuildPie(PieChart old, ObservableList<PieChart.Data> data) {
        PieChart fresh = new PieChart(data);
        fresh.setTitle(old.getTitle());
        fresh.setClockwise(true);
        fresh.setLabelsVisible(true);
        fresh.setLegendVisible(true);
        fresh.setAnimated(false);
        fresh.setPrefSize(old.getWidth(), old.getHeight());

        Pane parent = (Pane) old.getParent();
        int idx = parent.getChildren().indexOf(old);
        parent.getChildren().set(idx, fresh);
        return fresh;
    }




}