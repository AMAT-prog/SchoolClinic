/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Login1Controller implements Initializable {

    @FXML
    private StackPane root;
    @FXML
    private ImageView bgImage;
    @FXML
    private Label titleLabel;
    @FXML
    private TextField username_tf;
    @FXML
    private PasswordField password_pf;
    @FXML
    private TextField password_tf;
    @FXML
    private ImageView eye_iv;
    @FXML
    private Button login_btn;
    @FXML
    private Hyperlink forgot_link;

    /**
     * Initializes the controller class.
     */
    private boolean showingPassword = false;

    // TODO: Inject your DAO / Auth service
    private final AuthService auth = new AuthService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // Bind plain text & password fields to stay in sync
        password_tf.textProperty().bindBidirectional(password_pf.textProperty());

        // Optional: dynamic title
//        titleLabel.setText("Sign in to School Clinic");
    }    

    @FXML
    private void toggleShowPassword() {
        showingPassword = !showingPassword;
        password_tf.setVisible(showingPassword);
        password_tf.setManaged(showingPassword);
        password_pf.setVisible(!showingPassword);
        password_pf.setManaged(!showingPassword);

//        String icon = showingPassword ? "/icons/eye-open.png" : "/icons/eye-closed.png";
//        eye_iv.setImage(new Image(getClass().getResourceAsStream(icon)));
    }

    @FXML
    private void onLogin() {
        String u = username_tf.getText().trim();
        String p = (showingPassword ? password_tf.getText() : password_pf.getText()).trim();
        User user = auth.login(u, p);
        if (user != null) {
            Session.userId = user.getUserId();
            Session.fullName = user.getFirstName() + " " + user.getLastName();
            showSplashThenDashboard();
         
        } else {
            alert(Alert.AlertType.ERROR, "Invalid credentials.");
        }
    }

    @FXML
    private void onForgotPassword() {
        // 1) Ask for recovery key
         TextInputDialog keyDlg = new TextInputDialog();
            keyDlg.setTitle("Account Recovery");
            keyDlg.setHeaderText("Enter your recovery key");
            keyDlg.setContentText("Recovery key:");
            keyDlg.getEditor().setPromptText("••••-••••-••••");
            var keyOpt = keyDlg.showAndWait();
            if (keyOpt.isEmpty()) return;

            Integer uid = auth.getSingleUserId();
            if (uid == null) { alert(Alert.AlertType.ERROR, "No user found."); return; }

            if (!auth.isRecoveryKeyValid(uid,keyOpt.get().trim())) {   // <-- pass uid AND key
                alert(Alert.AlertType.ERROR, "Invalid recovery key.");
                return;
            }

        // 2) Prompt for new username/password (simple dialog)
        Dialog<Creds> changeDlg = new Dialog<>();
        changeDlg.setTitle("Set new credentials");
        changeDlg.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);

        // Content
        TextField newUser = new TextField(); newUser.setPromptText("New username");
        PasswordField newPass = new PasswordField(); newPass.setPromptText("New password");
        PasswordField confirm  = new PasswordField(); confirm.setPromptText("Confirm password");

        VBox box = new VBox(10, new Label("Enter new username and password"), newUser, newPass, confirm);
        changeDlg.getDialogPane().setContent(box);

        // Validate before OK
        var okBtn = changeDlg.getDialogPane().lookupButton(ButtonType.OK);
        okBtn.addEventFilter(javafx.event.ActionEvent.ACTION, ev -> {
            String a = newPass.getText();
            String b = confirm.getText();
            if (a == null || a.isBlank() || !a.equals(b)) {
                ev.consume();
                alert(Alert.AlertType.WARNING, "Passwords do not match.");
            }
        });

        changeDlg.setResultConverter(btn -> (btn == ButtonType.OK)
                ? new Creds(newUser.getText().trim(), newPass.getText())
                : null);

        var res = changeDlg.showAndWait();
        if (res.isEmpty()) return;

        Creds c = res.get();
        if (c.username().isBlank()) {
            alert(Alert.AlertType.WARNING, "Username cannot be blank.");
            return;
        }

        if (auth.updateCredentialsWithRecovery(c.username(), c.password())) {
            alert(Alert.AlertType.INFORMATION, "Credentials updated. You can now log in.");
        } else {
            alert(Alert.AlertType.ERROR, "Update failed. Please try again.");
        }
    }

    // ======= SPLASH / LOADING then DASHBOARD =======
    private void showSplashThenDashboard() {
    Stage loginStage = (Stage) root.getScene().getWindow();
    loginStage.hide();

    Splash.showUntilReady(
        "Welcome to School Clinic System",
        Duration.seconds(3.0),                         // minimum splash time
        DashboardLoadTask::new,                        // background loader
        dashRoot -> {                                  // UI callback when ready
            try {
                Stage dash = new Stage();
                dash.setTitle("School Clinic System — Dashboard");
                dash.setScene(new Scene(dashRoot));
                dash.show();
                loginStage.close();                    // close for good
            } catch (Exception ex) {
                ex.printStackTrace();
                loginStage.show();                     // fallback
            }
        }
    );
}




    // ======= helpers =======
    private void alert(Alert.AlertType type, String msg) {
        var a = new Alert(type);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    /* ----- tiny DTO ------ */
    record Creds(String username, String password) {}
}

