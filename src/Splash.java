// Splash.java
import javafx.animation.*;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Splash {

    public static void showUntilReady(
            String title,
            Duration minDuration,
            Supplier<Task<Parent>> loaderSupplier,
            Consumer<Parent> onReadyUI
    ) {
        try {
            FXMLLoader fx = new FXMLLoader(Splash.class.getResource("Splash.fxml"));
            Parent root = fx.load();
            SplashController c = fx.getController();
            c.setTitle(title);

            Stage st = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Splash.class.getResource("splash.css").toExternalForm());
            st.initStyle(StageStyle.UNDECORATED);
            st.setScene(scene);
            st.centerOnScreen();
            st.show();

            AtomicBoolean timeDone = new AtomicBoolean(false);
            AtomicBoolean taskDone = new AtomicBoolean(false);
            final Parent[] dashboardRoot = new Parent[1];

            // min visible time
            PauseTransition timer = new PauseTransition(minDuration);
            timer.setOnFinished(e -> {
                timeDone.set(true);
                if (taskDone.get()) {
                    st.close();
                    onReadyUI.accept(dashboardRoot[0]); // already loaded Parent
                }
            });
            timer.play();

            // background loader
            Task<Parent> task = loaderSupplier.get();
            c.bindToTaskWithFakeProgress(task, minDuration);  // see controller below
            Thread t = new Thread(task, "dashboard-loader");
            t.setDaemon(true);
            t.start();

            task.setOnSucceeded(e -> {
                dashboardRoot[0] = task.getValue();
                taskDone.set(true);
                if (timeDone.get()) {
                    st.close();
                    onReadyUI.accept(dashboardRoot[0]);
                }
            });

            task.setOnFailed(e -> {
                st.close();
                task.getException().printStackTrace();
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
