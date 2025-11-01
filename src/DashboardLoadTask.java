// DashboardLoadTask.java
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class DashboardLoadTask extends Task<Parent> {
    @Override protected Parent call() throws Exception {
        // Simulate real milestones (update as you add work):
        updateProgress(0, 100);

        FXMLLoader fx = new FXMLLoader(getClass().getResource("DASHBOARD.fxml"));
        Parent root = fx.load();
        updateProgress(70, 100);              // after FXML load

        // Optional: preload data heavy work here (NO UI calls)
        // DASHBOARDController c = fx.getController();
        // c.preloadData();  // do DB/file I/O here
        updateProgress(100, 100);

        return root;                          // fully ready node
    }
}
