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
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javafx.animation.PauseTransition;
import javafx.css.PseudoClass;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;





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
    private TableColumn<Student, Integer> id_col;
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
    private TextField gender_tf;
    @FXML
    private TextField birthday_tf;
    @FXML
    private TextField birthplace_tf;
    @FXML
    private TextField course_tf;
    @FXML
    private TextField yearLevel_tf;
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
    private TextField status_tf;
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
    private FilteredList<Student> filtered;
    
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
    private ComboBox<StudentOption> consultationName_cb;
    
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
    private ComboBox<StudentOption> visitName_cb;
    
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
    private ListView<CalendarItem> remindersList;
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
     
     private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    //for adding new consultation
    //for adding history during adding a new student
    //1. currentStudentId - already in controller
    //2. 
        private enum HistoryMode { EDIT_EXISTING, ADD_FOR_NEW_STUDENT }
        private HistoryMode historyMode = HistoryMode.EDIT_EXISTING;

        // Hold staged history while adding a brand-new student (no student_id yet)
        private StudentHistory draftHistoryForNewStudent = null;
    
    private final ObservableList<Student> students = FXCollections.observableArrayList();
    // state for current view/edit
    private Integer currentStudentId = null;
    private byte[] pendingPhotoBytes = null; // set by upload; saved on Save
    
    private final StudentHistoryDAO historyDAO = new StudentHistoryDAO();
    
    int addStudent_sideNav = 0;
    
    // ===== Controller state ===== FOR CONSULTATION
    private final ObservableList<Consultation> consultations = FXCollections.observableArrayList();
    private Integer currentConsultationId = null;   // null = adding; non-null = editing existing
    private Consultation currentSelected = null;    // convenience
        
    // ==== fields in controller ====
    private final ObservableList<StudentOption> studentOptionsMaster = FXCollections.observableArrayList();
    private final FilteredList<StudentOption> studentOptionsFiltered =
    new FilteredList<>(studentOptionsMaster, p -> true); // start: show all
   
    //inventory
    private ObservableList<Inventory> data; 
        // internal state
    private boolean isEditMode = false;
    private Inventory editing = null;
     
    
    // --- keep these fields ---
    private final ObservableList<Inventory> inventoryMaster = FXCollections.observableArrayList();
    private FilteredList<Inventory> inventoryFiltered;
    private SortedList<Inventory> inventorySorted;
    
    //visit log
    private ObservableList<VisitLogRow> rows;
   
    private javafx.collections.ObservableList<StudentOption> studentOptions;
    private FilteredList<StudentOption> studentFiltered;
    private boolean suppressEditorEvents = false;
    
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
    // ------- internal state -------
//    private YearMonth visibleMonth = YearMonth.now();
    private final List<DayCell> cells = new ArrayList<>(42);
    private CalendarDao dao;
    // overlay for hover cards
    private final Pane peekOverlay = new Pane();
    private final VBox peekCard = new VBox(8);

    private final PauseTransition hideDelay = new PauseTransition(Duration.millis(120));
    
    //for adding WEEK
    // which main view is active
    private enum ViewMode { MONTH, WEEK, LIST }
    private ViewMode viewMode = ViewMode.MONTH;
    // existing:
    private YearMonth visibleMonth = YearMonth.now();
    // anchor date that determines which week to show
    private LocalDate anchorDate = LocalDate.now();

  


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
        
        Dashboard_pane.setVisible(true);
    }
    
    @FXML
    private void AddStudent_sideNav(ActionEvent event) {
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
        
        medicalCertificate_pane.setVisible(true);
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
        Dashboard_pane.setDisable(true);
        Notification_pane.setVisible(true);
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
    
     // hide the details pane initially
        if (viewStudent_pane != null) viewStudent_pane.setVisible(false);

     // table columns
        id_col.setCellValueFactory(c -> new javafx.beans.property.SimpleIntegerProperty(c.getValue().getId()).asObject());
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
        loadStudents();
        
                // 2.1 Year-level options 
        yearLevel_cb.setItems(FXCollections.observableArrayList(
                "All", "1st Year", "2nd Year", "3rd Year", "4th Year", "Irregular"
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
        btnBIT.setUserData("BIT");

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

        // Run once initially
        refreshStudentPredicate();
        
        //for adding a student
        addStudent_course_cb.getItems().setAll("BSIT", "BIT", "BSFAS");
        addStudent_year_cb.getItems().setAll("1st Year","2nd Year","3rd Year","4th Year","Irregular");
        addStudent_gender_cb.getItems().setAll("Male","Female","Other");


       // Bind columns to Consultation model
    consultationName_col.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getStudentName()));
    consultationDate_col.setCellValueFactory(cd -> new SimpleStringProperty(
            cd.getValue().getConsultationDate() != null ? cd.getValue().getConsultationDate().toString() : ""
    ));
    consultationReason_col.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getReasonForVisit()));

    // Action column (button)
    consultationAction_col.setCellFactory(col -> new TableCell<>() {
        private final Button viewBtn = new Button("View");
        {
            viewBtn.getStyleClass().add("table-action-view"); // optional CSS
            viewBtn.setOnAction(e -> {
                Consultation rowItem = getTableView().getItems().get(getIndex());
                onViewRow(rowItem);
            });
        }
        @Override
        protected void updateItem(Void item, boolean empty) {   // <-- correct override signature
            super.updateItem(item, empty);
            setGraphic(empty ? null : viewBtn);
            setText(null);
        }
    });

    // Load data
    refreshTable();

    // Real-time status logic for vitals
    attachVitalsStatusListeners();
        
        //for BP
        consultationBP_tf.focusedProperty().addListener((obs, oldVal, newVal) -> {
    if (!newVal) { // lost focus
        String bp = consultationBP_tf.getText();
        if (bp.contains("/")) {
            try {
                int sys = Integer.parseInt(bp.split("/")[0]);
                int dia = Integer.parseInt(bp.split("/")[1]);
                if (sys >= 130 || dia >= 90) BPstatus_label.setText("Hypertension");
                else if (sys <= 90 || dia <= 60) BPstatus_label.setText("Hypotension");
                else BPstatus_label.setText("Normal");
            } catch (Exception ignored) {}
        }
    }
});
            //FOR PULSE RATE
        consultationPR_tf.focusedProperty().addListener((obs, oldVal, newVal) -> {
    if (!newVal) {
        try {
            int pr = Integer.parseInt(consultationPR_tf.getText());
            PRstatus_label.setText((pr >= 80 && pr <= 100) ? "Normal" : "Abnormal");
        } catch (Exception ignored) {}
    }
});
        //FOR RESPIRATORY RATE
        consultationRR_tf.focusedProperty().addListener((obs, oldVal, newVal) -> {
    if (!newVal) {
        try {
            int rr = Integer.parseInt(consultationRR_tf.getText());
            RRstatus_label.setText((rr >= 16 && rr <= 20) ? "Normal" : "Abnormal");
        } catch (Exception ignored) {}
    }
});
        
        consultationName_cb.setEditable(true);
        consultationName_cb.setItems(FXCollections.observableArrayList(StudentDAO.findAllStudentOptions()));
        enableComboBoxSearch(consultationName_cb); // attach a simple search filter (function below)
        
         setupStudentNameCombo();
         
        // INVENTORY
        setupColumns();
        loadData();
//        setupInventoryTable();
        setupActionColumnINVENTORY();   // the "⋮" per row
        setupInventorySearchFilter();
        
        //VISIT LOGS
        setupColumnsVISITLOG();
        loadVisitLogs();
        VisitLog_addpane.setVisible(false);
        visitLog_tv.setPlaceholder(new Label("No visit logs"));
        
        // load ComboBox options
//        studentOptions = StudentDAO.getStudentOptions();
//        visitName_cb.setItems(studentOptions);
        
        //searchable in combo box (visit log)
        studentOptions  = StudentDAO.getStudentOptions();
        studentFiltered = new FilteredList<>(studentOptions, s -> true);

        setupStudentCombo();
        

        visitName_cb.setEditable(true); // if want type-to-filter inside the ComboBox
        visitName_cb.setConverter(new javafx.util.StringConverter<StudentOption>() {
            @Override
            public String toString(StudentOption so) {
                return (so == null) ? "" : so.getDisplay();
            }
            @Override
            public StudentOption fromString(String s) {
                // IMPORTANT: never return null here — it clears the selection.
                if (s == null) return visitName_cb.getValue();
                String typed = s.trim();
                if (typed.isEmpty()) return visitName_cb.getValue();
                // Try exact match; if not found, keep current selection
                for (StudentOption o : visitName_cb.getItems()) {
                    if (o.getDisplay().equalsIgnoreCase(typed)) return o;
                }
                return visitName_cb.getValue();
            }
        });
        
        loadDashboardStats();  // call once on load (and after any CRUD for live)

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
        // 1) DB
        Connection conn = MySQL.connect(); 
        dao = new CalendarDao(conn);

        // 2) Build weekday header (Mon..Sun)
        buildWeekdayHeader();

        // 3) Build static 7x6 grid once
        rebuildGridForView();
        initPeekOverlay();
        // 4) Hook up controls
        btnPrev.setOnAction(e -> {
            if (viewMode == ViewMode.WEEK) {
                anchorDate = anchorDate.minusWeeks(1);
                visibleMonth = YearMonth.from(anchorDate);
            } else {
                visibleMonth = visibleMonth.minusMonths(1);
                // keep anchor roughly within this month so week title makes sense if user flips to week later
                anchorDate = visibleMonth.atDay(1);
            }
            refresh();
            applySizingForView();
        });

        btnNext.setOnAction(e -> {
            if (viewMode == ViewMode.WEEK) {
                anchorDate = anchorDate.plusWeeks(1);
                visibleMonth = YearMonth.from(anchorDate);
            } else {
                visibleMonth = visibleMonth.plusMonths(1);
                anchorDate = visibleMonth.atDay(1);
            }
            refresh();
            applySizingForView();
        });

        btnToday.setOnAction(e -> {
            anchorDate = LocalDate.now();
            visibleMonth = YearMonth.from(anchorDate);
            refresh();
            applySizingForView();
        });

        miniDatePicker.setValue(LocalDate.now());
        miniDatePicker.valueProperty().addListener((obs, old, d) -> {
            if (d != null) {
                anchorDate = d;
                visibleMonth = YearMonth.from(d);
                refresh();
            }
        });


        // View toggles
        viewToggleGroup.selectedToggleProperty().addListener((obs, o, n) -> {
            if (n == tglList) {
                viewMode = ViewMode.LIST;
            } else if (n == tglWeek) {
                viewMode = ViewMode.WEEK;
            } else { // tglMonth (default)
                viewMode = ViewMode.MONTH;
            }
            applyViewToggleState();   // show/hide list vs grid
            rebuildGridForView();     // 6x7 for month, 1x7 for week
            refresh();
            applySizingForView();
            
        });


        // Filters
        fltAll.setOnAction(e -> {
            if (fltAll.isSelected()) {
                fltNotes.setSelected(false); fltTasks.setSelected(false);
                fltEvents.setSelected(false); fltInventory.setSelected(false);
            }
            refresh();
        });
        fltNotes.setOnAction(e -> { fltAll.setSelected(false); refresh(); });
        fltTasks.setOnAction(e -> { fltAll.setSelected(false); refresh(); });
        fltEvents.setOnAction(e -> { fltAll.setSelected(false); refresh(); });
        fltInventory.setOnAction(e -> { fltAll.setSelected(false); refresh(); });

        // Add button (quick add)
        btnAdd.setOnAction(e -> quickAdd(LocalDate.now()));

        // First paint
        refresh();
        
        setupLists();//upcoming listview
        
        // after buildMonthGrid(), before refresh()
        applyViewToggleState();   // <-- set initial visible/managed correctly

        viewToggleGroup.selectedToggleProperty().addListener((obs, o, n) -> {
            applyViewToggleState();
            refresh();
            applySizingForView();
        });
        

    }  
    ////////////////////////////////////////////////////////////////////////////end initialization
    
    ////////////////////////////////////////////////////////////////////////////CONSULTATION
    @FXML
    private void AddNewConsultation(ActionEvent event) {
        studentOptionsMaster.setAll(StudentDAO.findAllStudentOptions());

        AddEditConsultation_pane.setVisible(true);
        clearFields();
        
        // Prepare name picker
        consultationName_cb.setItems(FXCollections.observableArrayList(StudentDAO.findAllStudentOptions()));
        consultationName_cb.getSelectionModel().clearSelection();
        consultationName_cb.getEditor().clear();

        // today’s date auto-fill
        consultationDate_tf.setText(LocalDate.now().format(DATE_FMT));
        setModeAdd();
    }

    @FXML
    private void cancelConsultation_btn(ActionEvent event) {
        AddEditConsultation_pane.setVisible(false);
        clearFields();
        
    }
    
    @FXML
    private void saveConsultation_btn(ActionEvent event) {
        
        
    // 1) Commit editor text -> value (StudentOption)
    String typed = consultationName_cb.getEditor().getText();
    StudentOption value = consultationName_cb.getValue(); // may be null
    if (value == null && typed != null) {
        // try converter first
        if (consultationName_cb.getConverter() != null) {
            value = consultationName_cb.getConverter().fromString(typed.trim());
        }
        // as a fallback, search master list (case-insensitive)
        if (value == null) {
            value = studentOptionsMaster.stream()
                    .filter(o -> o.toString().equalsIgnoreCase(typed.trim()))
                    .findFirst()
                    .orElse(null);
        }
        consultationName_cb.setValue(value); // keep ComboBox consistent
    }
    // 2) Resolve studentId safely
    Integer studentId = (currentConsultationId == null)
            ? (value != null ? value.getId() : null)
            : (currentSelected != null ? currentSelected.getStudentId() : null);

    if (studentId == null) {
        showWarn("Please select a valid student from the list.");
        return;
    }
    
    // Date
    String dateStr = consultationDate_tf.getText();
    LocalDate cdate = (dateStr == null || dateStr.isBlank()) ? LocalDate.now() : LocalDate.parse(dateStr, DATE_FMT);

    // Gather other values
    String reason = consultationReason_tf.getText();
    String bp = consultationBP_tf.getText();
    String tempStr = consultationTemperature_tf.getText();
//    Double temp = parseDoubleOrNull(consultationTemperature_tf.getText());
    String diagnosis = consultationDiagnosis_tf.getText();
    String treatment = consultationTreatment_tf.getText();
    String referral = consultationReferral_tf.getText();
    String prStr = consultationPR_tf.getText();
    String rrStr = consultationRR_tf.getText();
//    Integer pr = parseIntOrNull(consultationPR_tf.getText());
//    Integer rr = parseIntOrNull(consultationRR_tf.getText());
    
    // Convert
    Double temp = (tempStr == null || tempStr.isBlank()) ? null : Double.valueOf(tempStr);
    Integer pr = (prStr == null || prStr.isBlank()) ? null : Integer.valueOf(prStr);
    Integer rr = (rrStr == null || rrStr.isBlank()) ? null : Integer.valueOf(rrStr);

   
    if (currentConsultationId == null) {
        // INSERT
        ConsultationDAO.insert(studentId, cdate, reason, bp, temp, diagnosis, treatment, referral, pr, rr);
    } else {
        // UPDATE
        ConsultationDAO.update(currentConsultationId, studentId, cdate, reason, bp, temp, diagnosis, treatment, referral, pr, rr);
    }

    refreshTable();
    AddEditConsultation_pane.setVisible(false);
    }

    @FXML
    private void editConsultation_btn(ActionEvent event) {
        if (currentConsultationId == null) return; // safety
        setModeEdit(); // fields editable; name combo remains disabled because not adding

    }

    @FXML
    private void deleteConsultation_btn(ActionEvent event) {
        if (currentConsultationId != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Delete");
            alert.setHeaderText("Are you sure you want to delete this consultation?");
            alert.setContentText("This action cannot be undone.");

            ButtonType yesBtn = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType noBtn = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(yesBtn, noBtn);

            alert.showAndWait().ifPresent(response -> {
                if (response == yesBtn) {
                    ConsultationDAO.delete(currentConsultationId);
                    refreshTable();
                    AddEditConsultation_pane.setVisible(false);
                }
            });
        }
    }

    @FXML
    private void consultationDate_auto(MouseEvent event) {
         if (consultationDate_tf.getText() == null || consultationDate_tf.getText().isBlank()) {
        consultationDate_tf.setText(LocalDate.now().format(DATE_FMT));
    }
    }
    
    // ===== Methods & Helpers =====
        private void onViewRow(Consultation c) {
        currentConsultationId = c.getConsultationId();
    currentSelected = c;
    AddEditConsultation_pane.setVisible(true);

    // Name combo shows the selected student
    var options = FXCollections.observableArrayList(StudentDAO.findAllStudentOptions());
    consultationName_cb.setItems(options);
    // find matching option by id
    options.stream().filter(o -> o.getId() == c.getStudentId()).findFirst()
           .ifPresent(opt -> consultationName_cb.getSelectionModel().select(opt));

    consultationDate_tf.setText(c.getConsultationDate() == null ? "" : c.getConsultationDate().format(DATE_FMT));
    // ... set other fields ...
    consultationReason_tf.setText(c.getReasonForVisit());
    consultationBP_tf.setText(c.getBloodPressure());
    consultationTemperature_tf.setText(c.getTemperature() != null ? c.getTemperature().toString() : "");
    consultationDiagnosis_tf.setText(c.getDiagnosis());
    consultationTreatment_tf.setText(c.getTreatment());
    consultationReferral_tf.setText(c.getReferral());
    consultationPR_tf.setText(c.getPulseRate() != null ? c.getPulseRate().toString() : "");
    consultationRR_tf.setText(c.getRespiratoryRate() != null ? c.getRespiratoryRate().toString() : "");

    BPstatus_label.setText(nullToEmpty(c.getBpStatus()));
    PRstatus_label.setText(nullToEmpty(c.getPulseStatus()));
    RRstatus_label.setText(nullToEmpty(c.getRespiratoryStatus()));
    
    // buttons: when viewing, only Edit/Delete/Cancel enabled; Save disabled
    saveBtn.setDisable(true);
    editBtn.setDisable(false);
    deleteBtn.setDisable(false);
    cancelBtn.setDisable(false);

    setFieldsEditable(false); // locks name combo for existing records
//    consultationDate_tf.setEditable(false);
}

        private void loadConsultationDetails(Consultation c) {
    AddEditConsultation_pane.setVisible(true);
    currentConsultationId = c.getConsultationId();
    currentSelected = c;
    // --- Student ComboBox ---
    // Reload all student options (so combo is filled)
    ObservableList<StudentOption> options = FXCollections.observableArrayList(StudentDAO.findAllStudentOptions());
    consultationName_cb.setItems(options);

    // Find and select the matching student
    options.stream()
           .filter(opt -> opt.getId() == c.getStudentId())
           .findFirst()
           .ifPresent(opt -> consultationName_cb.getSelectionModel().select(opt));

    // fill fields
    consultationDate_tf.setText(
        (c.getConsultationDate() != null) ? c.getConsultationDate().toString() : ""
    );
//    consultationDate_tf.setText(c.getConsultationDate().toString());
    consultationReason_tf.setText(c.getReasonForVisit());
    consultationBP_tf.setText(c.getBloodPressure());
    consultationTemperature_tf.setText(
        (c.getTemperature() != null) ? String.valueOf(c.getTemperature()) : ""
    );
//    consultationTemperature_tf.setText(String.valueOf(c.getTemperature()));
    consultationDiagnosis_tf.setText(c.getDiagnosis());
    consultationTreatment_tf.setText(c.getTreatment());
    consultationReferral_tf.setText(c.getReferral());
//    consultationPR_tf.setText(String.valueOf(c.getPulseRate()));
    consultationPR_tf.setText(
        (c.getPulseRate() != null) ? String.valueOf(c.getPulseRate()) : ""
    );
    consultationRR_tf.setText(
        (c.getRespiratoryRate() != null) ? String.valueOf(c.getRespiratoryRate()) : ""
    );
//    consultationRR_tf.setText(String.valueOf(c.getRespiratoryRate()));

    // status labels
    BPstatus_label.setText(c.getBpStatus());
    PRstatus_label.setText(c.getPulseStatus());
    RRstatus_label.setText(c.getRespiratoryStatus());
    

    // enable/disable buttons
    saveBtn.setDisable(true);
    editBtn.setDisable(false);
    deleteBtn.setDisable(false);
    cancelBtn.setDisable(false);

    // lock fields
//    setFieldsEditable(false); //already defined in setModeView();
    setModeView();
}

        private void attachVitalsStatusListeners() {
    // BP: expects "SYS/DIA"
    consultationBP_tf.focusedProperty().addListener((obs, was, isNow) -> {
        if (!isNow) updateBpStatusLabel();
    });
    consultationBP_tf.setOnKeyReleased(e -> updateBpStatusLabel()); // instant feedback while typing

    // Pulse
    consultationPR_tf.focusedProperty().addListener((obs, was, isNow) -> {
        if (!isNow) updatePulseStatusLabel();
    });
    consultationPR_tf.setOnKeyReleased(e -> updatePulseStatusLabel());

    // Respiratory
    consultationRR_tf.focusedProperty().addListener((obs, was, isNow) -> {
        if (!isNow) updateRespStatusLabel();
    });
    consultationRR_tf.setOnKeyReleased(e -> updateRespStatusLabel());
}
        
        private void updateBpStatusLabel() {
    String bp = consultationBP_tf.getText();
    if (bp != null && bp.contains("/")) {
        try {
            String[] parts = bp.split("/");
            int sys = Integer.parseInt(parts[0].trim());
            int dia = Integer.parseInt(parts[1].trim());
            String status = (sys >= 130 || dia >= 90) ? "Hypertension"
                           : (sys <= 90 || dia <= 60) ? "Hypotension"
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
    
    setupStudentNameCombo(); //for adding new consultation (student name)
}

        private void setupStudentNameCombo() {
    // Load once (or reload when open the Add pane if prefer)
    studentOptionsMaster.setAll(StudentDAO.findAllStudentOptions());

    consultationName_cb.setEditable(true);
    consultationName_cb.setItems(studentOptionsFiltered);

     // StringConverter to map between StudentOption <-> String
    consultationName_cb.setConverter(new StringConverter<StudentOption>() {
        @Override
        public String toString(StudentOption opt) {
            return (opt == null) ? "" : opt.toString();
        }
        @Override
        public StudentOption fromString(String text) {
            if (text == null || text.isBlank()) return null;
            String t = text.trim().toLowerCase();
            return studentOptionsMaster.stream()
                    .filter(o -> o.toString().toLowerCase().equals(t))
                    .findFirst()
                    .orElse(null);
        }
    });
    
    // Filter as the user types
    consultationName_cb.getEditor().textProperty().addListener((obs, oldText, newText) -> {
        final String typed = (newText == null) ? "" : newText.toLowerCase();

        // Don't filter when the change came from selecting an item
        // If user picks from dropdown, editor text becomes item's toString(); keep it visible:
        studentOptionsFiltered.setPredicate(opt -> {
            if (typed.isBlank()) return true; // show all if nothing typed
            return opt != null && opt.toString().toLowerCase().contains(typed);
        });

        // Re-open popup so results update immediately
        if (!consultationName_cb.isShowing()) {
            consultationName_cb.show();
        }
    });

    // When an item is selected from the list, keep editor text in sync
    consultationName_cb.valueProperty().addListener((obs, oldVal, newVal) -> {
        if (newVal != null) {
            consultationName_cb.getEditor().setText(newVal.toString());
            // After a selection, reset filter so entire list is available for next search
            studentOptionsFiltered.setPredicate(p -> true);
        }
    });

    // On focus lost, reset filter (do NOT replace items or reload DAO)
    consultationName_cb.focusedProperty().addListener((obs, was, isNow) -> {
        if (!isNow) studentOptionsFiltered.setPredicate(p -> true);
    });
}

        private <T> void enableComboBoxSearch(ComboBox<T> combo) {
    combo.setOnKeyReleased(e -> {
        if (!combo.isEditable()) return;
        String typed = combo.getEditor().getText();
        if (typed == null) typed = "";
        final String lower = typed.toLowerCase();

        // assuming original items are in a master list
        ObservableList<T> all = combo.getItems();
        FilteredList<T> filtered = new FilteredList<>(all, item ->
            item != null && item.toString().toLowerCase().contains(lower)
        );
        combo.hide();
        combo.setItems(filtered);
        combo.getEditor().setText(typed);
        combo.show();

        // Move caret to end
        combo.getEditor().positionCaret(typed.length());
    });

    // When focus lost, restore full list
    combo.focusedProperty().addListener((obs, was, isNow) -> {
        if (!isNow) {
            // Reload full list from DAO or cache:
            combo.setItems((ObservableList<T>) FXCollections.observableArrayList(StudentDAO.findAllStudentOptions()));
        }
    });
}
        
        private void setFieldsEditable(boolean editable) {
            // Name (ComboBox): only enabled when ADDING a new consultation.
            boolean adding = (currentConsultationId == null);
            consultationName_cb.setDisable(!adding);       // disable in view/edit
            consultationName_cb.setEditable(adding);       // allow typing/search only in add mode
            
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
            consultationName_cb.getSelectionModel().clearSelection();  // clear selected student
            consultationName_cb.getEditor().clear();                   // also clear typed text if editable
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
            currentConsultationId = null;
            currentSelected = null;
        }
        
        private void setModeAdd() {
            currentConsultationId = null;
            saveBtn.setDisable(false);
            editBtn.setDisable(true);
            deleteBtn.setDisable(true);
            cancelBtn.setDisable(false);
            setFieldsEditable(true);  // enables all inputs except those you keep locked by design
        }

        private void setModeView() {
            saveBtn.setDisable(true);
            editBtn.setDisable(false);
            deleteBtn.setDisable(false);
            cancelBtn.setDisable(false);
            setFieldsEditable(false); // lock fields; name combo disabled (not adding)
        }

        private void setModeEdit() {
            // Editing an existing record: fields editable, but name combo stays disabled
            saveBtn.setDisable(false);
            editBtn.setDisable(true);
            deleteBtn.setDisable(false);
            cancelBtn.setDisable(false);
            setFieldsEditable(true);  // because currentConsultationId != null, name combo remains disabled
        }

        private void refreshTable() {
        consultations.setAll(ConsultationDAO.findAllWithStudentName()); // implement DAO method
        consultation_tv.setItems(consultations);
    }
    
    ////////////////////////////////////////////////////////////////////////////end consultation
       
    ////////////////////////////////////////////////////////////////////////////STUDENT RECORD/DETAILS
    @FXML
    private void uploadPhoto_btn(ActionEvent event) {
         FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp")
        );
        File f = fc.showOpenDialog(viewStudent_pane.getScene().getWindow());
        if (f != null) {
            try {
                pendingPhotoBytes = Files.readAllBytes(f.toPath());
                showImage(pendingPhotoBytes);
            } catch (Exception ex) {
                ex.printStackTrace();
                alert(Alert.AlertType.ERROR, "Upload Photo", ex.getMessage());
            }
        }
    }
    
    @FXML
    private void editStudent_btn(ActionEvent event) {
        setEditable(true);
    }

    @FXML
    private void saveStudent_btn(ActionEvent event) {
         if (currentStudentId == null) return;
        String sql = """
            UPDATE students
            SET age = ?, gender = ?, birthday = ?, birthplace = ?, course = ?, year_level = ?,
                civil_status = ?, religion = ?, height = ?, weight = ?, contact_number = ?,
                email = ?, status = ?, address = ?, image = COALESCE(?, image)
            WHERE student_id = ?
            """;
        try (Connection c = MySQL.connect();
             PreparedStatement ps = c.prepareStatement(sql)) {

            // map fields (parse with care)
            setNullableInt(ps, 1, age_tf.getText());
            ps.setString(2, emptyToNull(gender_tf.getText()));
            setNullableDate(ps, 3, birthday_tf.getText());      // expects yyyy-MM-dd
            ps.setString(4, emptyToNull(birthplace_tf.getText()));
            ps.setString(5, emptyToNull(course_tf.getText()));
            ps.setString(6, emptyToNull(yearLevel_tf.getText()));
            ps.setString(7, emptyToNull(civilStatus_tf.getText()));
            ps.setString(8, emptyToNull(religion_tf.getText()));
            setNullableBigDecimal(ps, 9,  height_tf.getText());
            setNullableBigDecimal(ps, 10, weight_tf.getText());
            ps.setString(11, emptyToNull(contactNo_tf.getText()));
            ps.setString(12, emptyToNull(email_tf.getText()));
            ps.setString(13, emptyToNull(status_tf.getText()));
            ps.setString(14, emptyToNull(address_tf.getText()));
            if (pendingPhotoBytes != null) {
                ps.setBytes(15, pendingPhotoBytes);
            } else {
                ps.setNull(15, Types.BLOB);
            }
            ps.setInt(16, currentStudentId);

            ps.executeUpdate();
            alert(Alert.AlertType.INFORMATION, "Save", "Student updated.");
            setEditable(false);
            // also refresh the row in the table (course/year/age/gender/contact might change)
            loadStudents();
        } catch (Exception e) {
            e.printStackTrace();
            alert(Alert.AlertType.ERROR, "Save", e.getMessage());
        }
        loadDashboardStats();
    }

    @FXML
    private void cancelStudent_btn(ActionEvent event) {
    viewStudent_pane.setVisible(false);
    StudentRecord_pane1.setVisible(false); // optional
    StudentRecord_pane.setVisible(true);
    StudentRecord_pane.toFront();
        setEditable(false);
        pendingPhotoBytes = null;
        currentStudentId = null;
        // hide details, show the list again
    
    }

    @FXML
    private void backButton_STUDENTLIST(MouseEvent event) {
        StudentRecord_pane1.setVisible(false);
        StudentRecord_pane.setVisible(true);
    }

    //FILTER STUDENT RECORDS
    private void refreshStudentPredicate() {
    final String q = safeLower(filterField1.getText()); // search text
    final Toggle selected = courseFilter.getSelectedToggle();
    final String courseFilterVal = (selected == null || selected.getUserData() == null)
            ? "ALL"
            : selected.getUserData().toString();

    final String yearSel = yearLevel_cb.getValue() == null ? "All" : yearLevel_cb.getValue();

    filtered.setPredicate(s -> {
        if (s == null) return false;

        // 3.1 Search filter (name or student_id)
        if (!q.isEmpty()) {
            String fullName = (nz(s.getLastName()) + " " + nz(s.getFirstName()) + " " + nz(s.getMiddleName())).toLowerCase();
            String first = nz(s.getFirstName()).toLowerCase();
            String last  = nz(s.getLastName()).toLowerCase();
            String mid   = nz(s.getMiddleName()).toLowerCase();
            String idStr = String.valueOf(s.getId()); // uses student_id from your model

            boolean matches = fullName.contains(q) || first.contains(q) || last.contains(q) || mid.contains(q) || idStr.contains(q);
            if (!matches) return false;
        }

        // 3.2 Course toggle filter
        if (!"ALL".equalsIgnoreCase(courseFilterVal)) {
            String course = nz(s.getCourse());
            if (!course.equalsIgnoreCase(courseFilterVal)) return false;
        }

        // 3.3 Year level ComboBox filter
        if (!"All".equalsIgnoreCase(yearSel)) {
            String yl = nz(s.getYearLevel());
            if (!yl.equalsIgnoreCase(yearSel)) return false;
        }

        return true;
    });
}

        // ====== Load minimal rows for the table ======
        private void loadStudents() {
                students.clear();
                String sql = """
                    SELECT student_id, last_name, first_name, middle_name, course, year_level,
                           gender, age, contact_number
                    FROM students
                    WHERE is_active IS NULL OR is_active = 1
                    ORDER BY created_at DESC, last_name ASC
                    """;
                try (Connection c = MySQL.connect();
                     PreparedStatement ps = c.prepareStatement(sql);
                     ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        students.add(new Student(
                            rs.getInt("student_id"),
                            rs.getString("last_name"),
                            rs.getString("first_name"),
                            rs.getString("middle_name"),
                            rs.getString("course"),
                            rs.getString("year_level"),
                            rs.getString("gender"),
                            (Integer) rs.getObject("age"),
                            rs.getString("contact_number")
                        ));
                    }
//                    student_tv.setItems(students);    ---- already bind student_tv to sorted in initialize(...)
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
        // join history (0..n). We'll aggregate into one text.
        String sqlStudent = "SELECT * FROM students WHERE student_id = ?";
        String sqlHistory = """
            SELECT past_illnesses, allergies, medications, immunizations, family_history, created_at
            FROM student_history
            WHERE student_id = ?
            ORDER BY created_at DESC
            """;
        try (Connection c = MySQL.connect()) {
            // --- student main ---
            try (PreparedStatement ps = c.prepareStatement(sqlStudent)) {
                ps.setInt(1, studentId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (!rs.next()) return;

                    currentStudentId = studentId;
                    pendingPhotoBytes = null; // reset

                    String last = nz(rs.getString("last_name"));
                    String first = nz(rs.getString("first_name"));
                    String mid = nz(rs.getString("middle_name"));
                    String idNum = nz(rs.getString("id_number"));

                    fullName_label.setText(last + ", " + first + (mid.isBlank() ? "" : " " + mid));
                    idNumber_label.setText(idNum);

                    setText(age_tf,       obj(rs.getObject("age")));
                    setText(gender_tf,    nz(rs.getString("gender")));
                    setText(birthday_tf,  obj(rs.getObject("birthday"))); // yyyy-MM-dd
                    setText(birthplace_tf,nz(rs.getString("birthplace")));
                    setText(course_tf,    nz(rs.getString("course")));
                    setText(yearLevel_tf, nz(rs.getString("year_level")));
                    setText(civilStatus_tf,nz(rs.getString("civil_status")));
                    setText(religion_tf,  nz(rs.getString("religion")));
                    setText(height_tf,    obj(rs.getObject("height")));
                    setText(weight_tf,    obj(rs.getObject("weight")));
                    setText(contactNo_tf, nz(rs.getString("contact_number")));
                    setText(email_tf,     nz(rs.getString("email")));
                    setText(status_tf,    nz(rs.getString("status")));
                    setText(address_tf,   nz(rs.getString("address")));

                    byte[] img = rs.getBytes("image");
                    showImage(img);
                }
            }
            // --- history (build pretty text) ---
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

//            viewStudent_pane.setVisible(true);
//            viewStudent_pane.toFront();

             // show the details pane & bring its parent to front
                viewStudent_pane.setVisible(true);
                StudentRecord_pane1.setVisible(true);
                StudentRecord_pane1.toFront();

    // optionally hide the list pane so there’s no overlap
    StudentRecord_pane.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
            alert(Alert.AlertType.ERROR, "View Student", e.getMessage());
        }
    }
        // ====== Delete (soft delete recommended) ======
        private void deleteStudent(int id) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Delete this student?", ButtonType.OK, ButtonType.CANCEL);
        a.setHeaderText(null);
        a.showAndWait().ifPresent(b -> {
            if (b == ButtonType.OK) {
                String sql = "UPDATE students SET is_active = 0 WHERE student_id = ?";
                try (Connection c = MySQL.connect();
                     PreparedStatement ps = c.prepareStatement(sql)) {
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    students.removeIf(s -> s.getId() == id);
                    if (currentStudentId != null && currentStudentId == id) viewStudent_pane.setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                    alert(Alert.AlertType.ERROR, "Delete", e.getMessage());
                }
            }
        });
        loadDashboardStats();
    }
        // ====== helpers ======
        private void setEditable(boolean b) {
        age_tf.setEditable(b);
        gender_tf.setEditable(b);
        birthday_tf.setEditable(b);
        birthplace_tf.setEditable(b);
        course_tf.setEditable(b);
        yearLevel_tf.setEditable(b);
        civilStatus_tf.setEditable(b);
        religion_tf.setEditable(b);
        height_tf.setEditable(b);
        weight_tf.setEditable(b);
        contactNo_tf.setEditable(b);
        email_tf.setEditable(b);
        status_tf.setEditable(b);
        address_tf.setEditable(b);
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
       if (file != null) {
           try {
               // preview
               addStudent_imageview.setImage(new Image(file.toURI().toString()));
               // store as bytes for DB (LONGBLOB)
               pendingPhotoBytes = java.nio.file.Files.readAllBytes(file.toPath());
           } catch (Exception ex) {
               ex.printStackTrace();
               showError("Failed to load image: " + ex.getMessage());
           }
       }
    }

    @FXML
    private void addStudent_cancel(ActionEvent event) {
        clearAddStudentForm();
        draftHistoryForNewStudent = null; //ir there is any saved draft history
        AddStudent_pane.setVisible(false);
        StudentRecord_pane.setVisible(true);
    }

    @FXML
    private void addStudent_save(ActionEvent event) {
        // 1) Basic required fields
        String idNumber   = trimOrNull(addStudent_idNum_tf.getText());
        String lastName   = trimOrNull(addStudent_lastName_tf.getText());
        String firstName  = trimOrNull(addStudent_firstName_tf.getText());
        String course     = addStudent_course_cb.getValue();
        String yearLevel  = addStudent_year_cb.getValue();
        String gender     = addStudent_gender_cb.getValue(); // must be 'Male','Female','Other' (per schema)

        if (idNumber == null || lastName == null || firstName == null ||
            course == null || yearLevel == null || gender == null || addStudent_birthday_dp.getValue() == null) {
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

        Integer age       = parseIntOrNull(addStudent_age_tf.getText());
        java.sql.Date birthday = java.sql.Date.valueOf(addStudent_birthday_dp.getValue());
        Double height     = parseDoubleOrNull(addStudent_height_tf.getText());
        Double weight     = parseDoubleOrNull(addStudent_weight_tf.getText());

        // 3) Insert into DB
        try {
            int newId = insertStudent(
                idNumber, lastName, firstName, middleName,
                course, yearLevel, gender, age, contact,
                address, birthday, birthplace, civil, religion,
                height, weight, email,
                /* status */ "active",
                /* image */ pendingPhotoBytes,
                /* is_active */ true
            );
       //////////ADDED FOR HISTORY//////////////////////////////
            // If user added history during the Add flow, persist it now
        if (draftHistoryForNewStudent != null) {
            draftHistoryForNewStudent.setStudentId(newId);
            historyDAO.upsert(draftHistoryForNewStudent);
            // clear the draft once persisted
            draftHistoryForNewStudent = null;
        }
        //////////////////////////////////////////////////////////
            showInfo("Student added (ID: " + newId + ").");
            clearAddStudentForm();
            AddStudent_pane.setVisible(false);
            //refresh table
            setupActionColumn();
            loadStudents(); 
            
        StudentRecord_pane.setVisible(true);
     
        } catch (java.sql.SQLIntegrityConstraintViolationException dupe) {
            showError("ID Number already exists. Please use a unique ID.");
        } catch (Exception ex) {
            ex.printStackTrace();
            showError("Failed to save student.\n" + ex.getMessage());
        }
        
        loadDashboardStats();
}
    
    private int insertStudent(
    String idNumber, String lastName, String firstName, String middleName,
    String course, String yearLevel, String gender, Integer age, String contact,
    String address, java.sql.Date birthday, String birthplace, String civil, String religion,
    Double height, Double weight, String email,
    String status, byte[] image, boolean isActive
    ) throws Exception {

    // 20 columns -> 20 placeholders
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
        ps.setString(i++, idNumber);           // 1
        ps.setString(i++, lastName);           // 2
        ps.setString(i++, firstName);          // 3
        setNullable(ps, i++, middleName);      // 4
        ps.setString(i++, course);             // 5
        ps.setString(i++, yearLevel);          // 6
        ps.setString(i++, gender);             // 7  (must match ENUM in DB)
        setNullable(ps, i++, age);             // 8
        setNullable(ps, i++, contact);         // 9
        setNullable(ps, i++, address);         // 10
        ps.setDate(i++, birthday);             // 11 (validated non-null)
        setNullable(ps, i++, birthplace);      // 12
        setNullable(ps, i++, civil);           // 13
        setNullable(ps, i++, religion);        // 14
        setNullable(ps, i++, height);          // 15
        setNullable(ps, i++, weight);          // 16
        setNullable(ps, i++, email);           // 17
        ps.setString(i++, status);             // 18
        if (image != null && image.length > 0) {
            ps.setBytes(i++, image);           // 19
        } else {
            ps.setNull(i++, java.sql.Types.BLOB);
        }
        ps.setBoolean(i++, isActive);          // 20

        // Safety check (remove in production)
        // System.out.println("Last parameter index set: " + (i - 1)); // should print 20

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
        addStudent_imageview.setImage(null);
        pendingPhotoBytes = null;
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
    private void setupStudentCombo() {
        studentOptions  = StudentDAO.getStudentOptions();
        studentFiltered = new FilteredList<>(studentOptions, x -> true);
        visitName_cb.setItems(studentFiltered);

        TextField editor = visitName_cb.getEditor();

        // Filter on typing — only change the predicate
        editor.textProperty().addListener((obs, old, txt) -> {
            if (suppressEditorEvents) return;
            String q = (txt == null) ? "" : txt.trim().toLowerCase();
            studentFiltered.setPredicate(o -> q.isEmpty() || o.getDisplay().toLowerCase().contains(q));
        });

        // Keep editor text in sync when a value is chosen
        visitName_cb.valueProperty().addListener((obs, old, val) -> {
            suppressEditorEvents = true;
            editor.setText(val == null ? "" : val.getDisplay());
            editor.positionCaret(editor.getText().length());
            suppressEditorEvents = false;
        });

        // When popup closes, reset filter AFTER selection has been committed
        visitName_cb.setOnHidden(e ->
            javafx.application.Platform.runLater(() -> studentFiltered.setPredicate(s -> true))
        );
    }
    
    @FXML
    private void VisitLog_AddNew(ActionEvent event) {
        VisitLog_pane.setDisable(true);
        VisitLog_addpane.setVisible(true);
        
        // default date = today
        visitDate_tf.setText(LocalDate.now().toString()); // yyyy-MM-dd
        suppressEditorEvents = true;
        visitName_cb.getSelectionModel().clearSelection();
        visitName_cb.getEditor().clear();
        studentFiltered.setPredicate(s -> true);
        suppressEditorEvents = false;
        visitReason_tf.clear();
        visitName_cb.requestFocus();
    }
    
    @FXML
    private void VisitLog_Delete(ActionEvent event) {
        VisitLogRow sel = visitLog_tv.getSelectionModel().getSelectedItem();
        if (sel == null) {
            warn("Please select a visit log to delete.");
            return;
        }
        Alert a = new Alert(Alert.AlertType.CONFIRMATION,
                "Delete visit log dated " + sel.getVisitDate() + " for " + sel.getStudentName() + "?",
                ButtonType.OK, ButtonType.CANCEL);
        a.setHeaderText(null);
        a.showAndWait().ifPresent(bt -> {
            if (bt == ButtonType.OK) {
                boolean ok = VisitLogDAO.deleteById(sel.getVisitId());
                if (ok) rows.remove(sel);
                else error("Delete failed.");
            }
        });
        loadDashboardStats();
    }
    
    @FXML
    private void addVL_cancel(ActionEvent event) {
        VisitLog_pane.setDisable(false);
        VisitLog_addpane.setVisible(false);
        
        
        suppressEditorEvents = true;
        clearAddForm();
        studentFiltered.setPredicate(s -> true);
        suppressEditorEvents = false;

        visitName_cb.hide(); // close popup window if it’s open
        // Platform.runLater(visitName_cb::hide); // optional
  
    }

    @FXML
    private void addVL_add(ActionEvent event) {
        // validate date
    java.time.LocalDate date;
    try {
        date = java.time.LocalDate.parse(visitDate_tf.getText().trim(),
                java.time.format.DateTimeFormatter.ISO_LOCAL_DATE);
    } catch (java.time.format.DateTimeParseException e) {
        warn("Date must be in yyyy-MM-dd format.");
        return;
    }

    StudentOption sel = visitName_cb.getValue(); // may be null
    Integer studentId = (sel != null) ? sel.getId() : null;

    String reason = (visitReason_tf.getText() == null) ? null : visitReason_tf.getText().trim();

    int newId = VisitLogDAO.insert(date, studentId, reason);
    if (newId <= 0) { error("Insert failed."); return; }

    // for the table: use selected label (if any) or lookup
    String studentName = (sel != null) ? sel.getDisplay() : StudentDAO.getDisplayName(null);
    VisitLogRow row = new VisitLogRow(newId, date, studentId, studentName, reason);
    rows.add(0, row);

    visitName_cb.hide();
    clearAddForm();
    VisitLog_pane.setDisable(false);
    VisitLog_addpane.setVisible(false);
    
    // (Optional extra safety if seen stubborn popups)
    // Platform.runLater(visitName_cb::hide);

    loadDashboardStats();
    }

    private void clearAddForm() {
        visitDate_tf.clear();
        visitName_cb.getSelectionModel().clearSelection();
        visitName_cb.getEditor().clear();
        visitReason_tf.clear();
    }
    
     private void setupColumnsVISITLOG() {
        visitDate_col.setCellValueFactory(new PropertyValueFactory<>("visitDate"));
        visitName_col.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        visitReason_col.setCellValueFactory(new PropertyValueFactory<>("reason"));

        // nicer date text (optional)
        visitDate_col.setCellFactory(col -> new TableCell<>() {
            @Override protected void updateItem(LocalDate d, boolean empty) {
                super.updateItem(d, empty);
                setText(empty || d == null ? "" : d.toString());
            }
        });
    }

    private void loadVisitLogs() {
        rows = VisitLogDAO.findAll();
        visitLog_tv.setItems(rows);
    }
    
    // dialogs
    private void warn(String msg) { new Alert(Alert.AlertType.WARNING, msg, ButtonType.OK).showAndWait(); }
    private void error(String msg) { new Alert(Alert.AlertType.ERROR, msg, ButtonType.OK).showAndWait(); }
    
    ////////////////////////////////////////////////////////////////////////////end visit log
    
    ////////////////////////////////////////////////////////////////////////////INVENTORY
    private void setupColumns() {
        // You can also use lambdas: col.setCellValueFactory(cell -> cell.getValue().itemIdProperty());
        inventoryCode_col.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        inventoryName_col.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        inventoryType_col.setCellValueFactory(new PropertyValueFactory<>("type"));
        inventoryQuantity_col.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        inventoryUnit_col.setCellValueFactory(new PropertyValueFactory<>("unit"));
        inventoryExpiry_col.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
        inventoryStatus_col.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Optional: pretty date format
        inventoryExpiry_col.setCellFactory(col -> new TableCell<>() {
            @Override protected void updateItem(java.time.LocalDate d, boolean empty) {
                super.updateItem(d, empty);
                setText(empty || d == null ? "" : d.toString()); // format 
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
        } else {
            Inventory inv = new Inventory(0, name, type, qty, unit, expiry, status);
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
        if (qty == 0) return "out of stock";
        if (expiry != null) {
            long days = ChronoUnit.DAYS.between(LocalDate.now(), expiry);
            if (days >= 0 && days <= 30) return "expiring soon";
        }
        else if (qty <= 10) return "low stock"; 
        return "in stock";
        
    }
    
    ////////////////////////////////////////////////////////////////////////////end inventory
    
    
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
    private void showImage(byte[] bytes) {
        if (image_imageView == null) return;
        if (bytes == null || bytes.length == 0) { image_imageView.setImage(null); return; }
        image_imageView.setImage(new Image(new ByteArrayInputStream(bytes)));
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

    d.add(new Paragraph("REPUBLIC OF THE PHILIPPINES", FontFactory.getFont(FontFactory.HELVETICA, 12)));
    d.add(new Paragraph("SOUTHERN LUZON STATE UNIVERSITY", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
    d.add(new Paragraph("Health Services\n\n", FontFactory.getFont(FontFactory.HELVETICA, 12)));

    Paragraph title = new Paragraph("MEDICAL CERTIFICATE", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
    title.setAlignment(Element.ALIGN_CENTER);
    d.add(title);
    d.add(new Paragraph("\nDate: " + dateText + "\n\n"));

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
    remarksPara.add(new Chunk("Remarks: ", bold));
    remarksPara.add(new Chunk(isEmpty(remarks) ? "N/A" : remarks, normal));
    remarksPara.add(new Chunk("\n\n", normal));
    d.add(remarksPara);

    d.add(new Paragraph("Vital Signs: BP: " + bp + "   Temp: " + temp + " °C   Pulse: " + pulse + " bpm   Resp: " + resp + " cpm\n\n"));

    Paragraph sig = new Paragraph("______________________________\n" + nurseName + "\nUniversity Health Services");
    sig.setAlignment(Element.ALIGN_RIGHT);
    d.add(sig);

    Paragraph footer = new Paragraph("\n*Generated by School Clinic System | Certificate ID: " + certCode + "*",
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
    
    @FXML
    private void onPickStudent() {
        StudentPickerDialog dlg = new StudentPickerDialog();
        // If this line NPEs, it means the label is not in a showing scene yet;
        // you can omit initOwner() safely.
        if (student_lbl != null && student_lbl.getScene() != null) {
            dlg.initOwner(student_lbl.getScene().getWindow());
        }
        dlg.showAndWait().ifPresent(s -> {
            currentStudentIdMEDCERT = s.studentId;
            student_lbl.setText(s.fullName());
            studentID_lbl.setText("   •   ID: " + s.studentId);
            date_dp.setValue(LocalDate.now());
            
            // If switching to a different student, clear previous vitals
            if (lastVitalsStudentId == null || !lastVitalsStudentId.equals(s.studentId)) {
                clearVitalsFields();
                vitalsUserEdited = false; // new student — reset edit flag
            }
            // Force overwrite when changing student (so new vitals always appear)
            applyLatestVitals(s.studentId, /*forceOverwrite=*/ true);
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
    // ===== UI builders =====
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

    private void rebuildGridForView() {
        monthGrid.getChildren().clear();
        cells.clear();

        int rows = (viewMode == ViewMode.MONTH ? 6 : 1);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < 7; c++) {
                DayCell cell = new DayCell();
                bindCellSize(cell, rows); // NOTE: rows param
                GridPane.setRowIndex(cell, r);
                GridPane.setColumnIndex(cell, c);
                monthGrid.getChildren().add(cell);
                cells.add(cell);
            }
        }
        applySizingForView();
    }

    // same method name, but now it accepts the row count
    private void bindCellSize(Region cell, int rows) {
        // width: 7 columns
        cell.prefWidthProperty().bind(
            monthGrid.widthProperty().subtract((7 - 1) * monthGrid.getHgap()).divide(7)
        );
        // height: rows = 6 for month, 1 for week
        cell.prefHeightProperty().bind(
            monthGrid.heightProperty().subtract((rows - 1) * monthGrid.getVgap()).divide(rows)
        );
        cell.minWidthProperty().bind(cell.prefWidthProperty());
        cell.maxWidthProperty().bind(cell.prefWidthProperty());
        cell.minHeightProperty().bind(cell.prefHeightProperty());
        cell.maxHeightProperty().bind(cell.prefHeightProperty());
    }
    // ===== refresh data + paint =====
    private void refresh() {
        // ---- 1) title ----
        if (viewMode == ViewMode.WEEK) {
            LocalDate ws = anchorDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            LocalDate we = ws.plusDays(6);
            lblMonthYear.setText(weekTitle(ws, we));
        } else {
            String m = visibleMonth.getMonth().getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault());
            m = Character.toUpperCase(m.charAt(0)) + m.substring(1);
            lblMonthYear.setText(m + " " + visibleMonth.getYear());
        }

        // ---- 2) compute range ----
        LocalDate start;
        LocalDate end; // inclusive for your DAO

        if (viewMode == ViewMode.WEEK) {
            start = anchorDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            end   = start.plusDays(6);
        } else {
            LocalDate firstOfMonth = visibleMonth.atDay(1);
            start = firstOfMonth.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            end   = start.plusDays(41); // 6 rows * 7 days - 1
        }

        // ---- 3) load items & group ----
        EnumSet<CalendarItem.Kind> kinds = activeKinds();
        List<CalendarItem> items;
        try {
            items = dao.findBetween(start, end, kinds);
        } catch (Exception ex) {
            ex.printStackTrace();
            items = List.of();
        }
        Map<LocalDate, List<CalendarItem>> byDay =
            items.stream().collect(Collectors.groupingBy(CalendarItem::getStartDate));

        // ---- 4) paint cells ----
        LocalDate d = start;
        for (DayCell cell : cells) {
            // In week view we don't gray “other month” days,
            // so pass YearMonth.from(d) to avoid the pseudo-class.
            YearMonth ym = (viewMode == ViewMode.MONTH) ? visibleMonth : YearMonth.from(d);
            cell.setDate(d, ym);
            cell.render(byDay.getOrDefault(d, List.of()));
            d = d.plusDays(1);
        }

        // ---- 5) sidebars ----
        try {
            upcomingList.getItems().setAll(dao.findUpcoming(6));
            remindersList.getItems().setAll(dao.remindersDueToday());
        } catch (Exception ex) { ex.printStackTrace(); }

        // ---- 6) list mode ----
        if (viewMode == ViewMode.LIST) renderListMode(byDay);
    }

    private String weekTitle(LocalDate start, LocalDate end) {
        var stMonth = start.getMonth().getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault());
        var enMonth = end.getMonth().getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault());
        stMonth = Character.toUpperCase(stMonth.charAt(0)) + stMonth.substring(1);
        enMonth = Character.toUpperCase(enMonth.charAt(0)) + enMonth.substring(1);

        if (start.getMonth() == end.getMonth()) {
            return String.format("%s %d–%d %d", stMonth, start.getDayOfMonth(), end.getDayOfMonth(), start.getYear());
        } else {
            return String.format("%s %d – %s %d %d",
                    stMonth, start.getDayOfMonth(),
                    enMonth, end.getDayOfMonth(),
                    end.getYear());
        }
    }

    
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
                if (now) title.getStyleClass().add("done");
                else     title.getStyleClass().remove("done");
                try { dao.markDone(it.getCalendarId(), now); } catch (Exception ex) { ex.printStackTrace(); }
                refresh();  // keeps calendar grid + Upcoming sidebar consistent
            });

            row.getChildren().addAll(cb, title, new Text(timeText(it)));
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
        remindersList.setFixedCellSize(28);
        
        
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
        remindersList.setCellFactory(factory);
    }

    
    private void applyViewToggleState() {
        boolean listMode = (viewMode == ViewMode.LIST);
        monthGrid.setVisible(!listMode);
        monthGrid.setManaged(!listMode);
        listViewWrapper.setVisible(listMode);
        listViewWrapper.setManaged(listMode);
    }

    //overlay (when hovering on the calendar days)
    private void initPeekOverlay() {
        peekOverlay.setPickOnBounds(false);    // empty overlay doesn't eat input
        peekOverlay.setMouseTransparent(true); // hover only; make false if you want it clickable
        peekOverlay.setVisible(false);

        peekCard.getStyleClass().add("peek-card");
        peekOverlay.getChildren().add(peekCard);

        calendarStack.getChildren().add(peekOverlay); // on top of the grid
        StackPane.setAlignment(peekOverlay, Pos.TOP_LEFT);

        hideDelay.setOnFinished(e -> peekOverlay.setVisible(false));
    }

    
    private void showPeek(DayCell cell) {
        hideDelay.stop();

        List<CalendarItem> items = cell.lastItems;
        if (items == null || items.isEmpty()) { hidePeek(); return; }

        // Build the card content
        peekCard.getChildren().clear();
        Label title = new Label(cell.date.toString());
        title.getStyleClass().add("peek-title");
        peekCard.getChildren().add(title);

        for (CalendarItem it : items) {
            Label pill = cell.buildCardPill(it);          // no width binding
            HBox row = new HBox(8, pill, new Text(" " + timeText(it)));
            row.getStyleClass().add("peek-row");
            row.setAlignment(Pos.CENTER_LEFT);
            peekCard.getChildren().add(row);
        }

        // Position near the cell but keep inside the calendar
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

    private void hidePeek() {
        hideDelay.playFromStart(); // short delay avoids flicker when moving between cells
    }
    //for week or month size of columns/grid
    private void applySizingForView() {
        if (viewMode == ViewMode.WEEK) {
            // --- the grid (1 row x 7 cols) ---
            StackPane.setAlignment(monthGrid, Pos.CENTER);


            monthGrid.setPrefHeight(300);                    // your week strip height
            monthGrid.setMinHeight(Region.USE_PREF_SIZE);
            monthGrid.setMaxHeight(Region.USE_PREF_SIZE);    // <— prevents stretching

            monthGrid.setHgap(16);
            monthGrid.setVgap(12);

            // --- the container (StackPane with overlay) ---
            VBox.setVgrow(calendarStack, Priority.NEVER);    // <— DO NOT grow inside the VBox
            calendarStack.setPrefHeight(Region.USE_COMPUTED_SIZE);
            calendarStack.setMinHeight(Region.USE_PREF_SIZE);
            calendarStack.setMaxHeight(Region.USE_PREF_SIZE); // <— clamp so VBox won't give it extra space

            // (optional) small margins so it sits nicely under the header
            StackPane.setMargin(monthGrid, new Insets(4, 0, 8, 0));
        } else {
            // MONTH (and LIST doesn’t show the grid)
            StackPane.setAlignment(monthGrid, Pos.CENTER);


            monthGrid.setPrefHeight(Region.USE_COMPUTED_SIZE);
            monthGrid.setMinHeight(Region.USE_COMPUTED_SIZE);
            monthGrid.setMaxHeight(Double.MAX_VALUE);

            monthGrid.setHgap(14);
            monthGrid.setVgap(14);

            // Let the calendar area fill the remaining window height again
            VBox.setVgrow(calendarStack, Priority.ALWAYS);
            calendarStack.setPrefHeight(Region.USE_COMPUTED_SIZE);
            calendarStack.setMinHeight(Region.USE_COMPUTED_SIZE);
            calendarStack.setMaxHeight(Double.MAX_VALUE);

            StackPane.setMargin(monthGrid, Insets.EMPTY);
        }
    }



}