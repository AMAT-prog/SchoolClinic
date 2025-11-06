import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SchoolClinicMain extends Application {

    private static final double BASE_W = 1261;
    private static final double BASE_H = 650;

    @Override
    public void start(Stage stage) throws Exception {
        /////////////////////////////////////////////////////trial//////////////////////////
            if (TrialManager.isTrialExpired()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Session Expired");
            alert.setHeaderText("Your session has ended");
            alert.setContentText("Please contact the developer to activate the full version.");
            alert.showAndWait();
            Platform.exit();
            return;
        } else {
            long daysLeft = TrialManager.getDaysLeft();
//            System.out.println("Trial active. Days left: " + daysLeft);
        }
        /////////////////////////////////////////////////////////////////////////////////////
        Region appSurface = FXMLLoader.load(getClass().getResource("login1.fxml"));

        StackPane wrapper = new StackPane(appSurface);           // only in Java
        Scene scene = new Scene(wrapper, BASE_W, BASE_H);

        stage.setTitle("SLSU Alabat Clinic");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/image/stethoscope.png")));
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

        ScaleSupport.hook(scene, appSurface, BASE_W, BASE_H, 1.6);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
