package main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomePage implements Initializable {

    public static String username;

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
    @FXML
    private Label usernameLabel;

    public void exploreButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("explorePage.fxml")));
        Main.primaryStage.setTitle("Explore");
        Main.primaryStage.setScene(new Scene(root, 560, 400));
        Main.primaryStage.setResizable(false);
        Main.primaryStage.show();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        waterProgressBar.setStyle("-fx-accent: #0D9EFF;");
        foodProgressBar.setStyle("-fx-accent: #FFC500;");
        energyProgressBar.setStyle("-fx-accent: #CEFA05;");
        healthProgressBar.setStyle("-fx-accent: #B7101D;");
        hearthIcon.setStyle("-fx-background-color: #B7101D;");
        username = LoginPage.passedUsername;
        usernameLabel.setText(username);
        try {
            PlayerData.getInfo();
        } catch (Exception e) {
            System.out.println(e);
        }
        healthProgressBar.setProgress((double) PlayerData.health / 100);
        energyProgressBar.setProgress((double) PlayerData.energy / 100);
        foodProgressBar.setProgress((double) PlayerData.food / 100);
        waterProgressBar.setProgress((double) PlayerData.water / 100);
    }

    public void inventoryPage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("inventoryPage.fxml"));
        Stage stage = (Stage) usernameLabel.getScene().getWindow();
        stage.setTitle("Home");
        stage.setScene(new Scene(root, 560, 400));
        stage.show();
    }

    public void logoutButton(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Stage stage = (Stage) usernameLabel.getScene().getWindow();
        stage.setTitle("Home");
        stage.setScene(new Scene(root, 560, 400));
        stage.show();
    }

    public void sleep (ActionEvent actionEvent) throws SQLException {
        PlayerData.energy = PlayerData.energy + 45;
        System.out.println(PlayerData.energy + 45);
        PlayerData.gameDay = PlayerData.gameDay++;
        System.out.println(PlayerData.gameDay++);
//        PlayerData.setInfo();
    }
}
