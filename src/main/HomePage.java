package main;
import javafx.animation.FadeTransition;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Random;
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
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label dayLabel;
    @FXML
    private Label locationLabel;

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
        healthProgressBar.setStyle("-fx-accent: #B7101D;");
        hearthIcon.setStyle("-fx-background-color: #B7101D;");
        username = LoginPage.passedUsername;
        usernameLabel.setText(username);
        dayLabel.setText("Day "+PlayerData.gameDay);
        locationLabel.setText(""+PlayerData.location);
        try {
            PlayerData.getInfo();
        } catch (Exception e) {
            System.out.println(e);
        }
        updateIndicators();
    }

    public void updateIndicators() {
        healthProgressBar.setProgress((double) PlayerData.health / 100);
        energyProgressBar.setProgress((double) PlayerData.energy / 100);
        foodProgressBar.setProgress((double) PlayerData.food / 100);
        waterProgressBar.setProgress((double) PlayerData.water / 100);
        locationLabel.setText(PlayerData.location);
        dayLabel.setText("Day "+PlayerData.gameDay);
    }

    public void inventoryPage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("inventoryPage.fxml"));
        Stage stage = (Stage) usernameLabel.getScene().getWindow();
        stage.setTitle("Inventory");
        stage.setScene(new Scene(root, 560, 400));
        stage.show();
    }

    public void logoutButton(ActionEvent actionEvent) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        Stage stage = (Stage) usernameLabel.getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 560, 400));
        stage.show();
    }

    public void sleep (ActionEvent actionEvent) throws SQLException {

        FadeTransition ft = new FadeTransition(Duration.millis(1000), anchorPane);
        ft.setFromValue(1.0);
        ft.setToValue(0.3);
        ft.setCycleCount(2);
        ft.setAutoReverse(true);
        ft.play();

        PlayerData.getInfo();
        PlayerData.energy = PlayerData.energy + 45;
        PlayerData.gameDay = PlayerData.gameDay + 1;
        PlayerData.setInfo();
        updateIndicators();


        String toastMsg = "Day " + PlayerData.gameDay;
        int toastMsgTime = 1500; //1.5 seconds
        int fadeInTime = 500; //0.5 seconds
        int fadeOutTime= 500; //0.5 seconds
        Toast.makeText((Stage) energyProgressBar.getScene().getWindow(), toastMsg, toastMsgTime, fadeInTime, fadeOutTime);


    }


    public void move(ActionEvent actionEvent) throws SQLException {
        PlayerData.getInfo();
        Random random = new Random();
        int x = Integer.parseInt(Character.toString(PlayerData.location.charAt(0)))  ;
        int y = Integer.parseInt(Character.toString(PlayerData.location.charAt(1))) ;
        int[] diff = {-1, 0, 1};
        int rand;

        if (PlayerData.energy < 10) {
            String toastMsg = "You dont have enough energy!!";
            int toastMsgTime = 1500; //1.5 seconds
            int fadeInTime = 500; //0.5 seconds
            int fadeOutTime= 500; //0.5 seconds
            Toast.makeText((Stage) energyProgressBar.getScene().getWindow(), toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
        } else {
            rand = random.nextInt(3) ;
            x = x + diff[rand];
            rand = random.nextInt(3) ;
            y = y + diff[rand];

            if (x < 0 || x > 9 ) {
                System.out.println("Game Over");
            }else if (y < 0 || y > 9 ) {
                System.out.println("Game over");
            } else {
                PlayerData.location = ""+x+""+y;
                PlayerData.energy = PlayerData.energy - 5 - (5 * ((100 - ((PlayerData.food+PlayerData.water)/2)))/100);
                PlayerData.food = PlayerData.food - 5;
                PlayerData.water = PlayerData.water - 5;
                PlayerData.setInfo();
                updateIndicators();
            }
        }


    }
}
