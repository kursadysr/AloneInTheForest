package main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {

    @FXML
    private ProgressBar healthProgressBar;
    @FXML
    private ProgressBar energyProgressBar;
    @FXML
    private ProgressBar foodProgressBar;
    @FXML
    private ProgressBar waterProgressBar;
    @FXML
    private ImageView hearthIcon;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        waterProgressBar.setStyle("-fx-accent: #0D9EFF;");
        foodProgressBar.setStyle("-fx-accent: #FFC500;");
        energyProgressBar.setStyle("-fx-accent: #CEFA05;");
        healthProgressBar.setStyle("-fx-accent: #B7101D;");
        hearthIcon.setStyle("-fx-background-color: #B7101D;");
    }
}
