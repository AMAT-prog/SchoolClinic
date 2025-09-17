/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class LOGINController implements Initializable {

    @FXML
    private Pane create_pane;
    @FXML
    private Pane login_pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login_btn(ActionEvent event) {
    }

    @FXML
    private void goToCreate_pane(ActionEvent event) {
        login_pane.setVisible(false);
        create_pane.setVisible(true);
    }

    @FXML
    private void goToLog_pane(MouseEvent event) {
        login_pane.setVisible(true);
        create_pane.setVisible(false);
    }
    
}
