/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

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
import javafx.util.StringConverter;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;






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
    
    
    //for adding new consultation
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
    
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
        
        AddStudent_pane.setVisible(true);
        AddStudent_pane.toFront();
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
    private String emptyToNull(String s) { return (s == null || s.isBlank()) ? null : s; }
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


}
