package main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Home implements Initializable {

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
    private Button exploreButton;

    public void exploreButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("explore.fxml")));
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
        username = Controller.passedUsername;
        usernameLabel.setText(username);
        getInfo();
    }

    public void getInfo() {
        try {
            Statement st = Main.db.createStatement();
            String query = "SELECT * FROM characters Where name = '" + username + "';";
            ResultSet result = st.executeQuery(query);
            result.next();
            healthProgressBar.setProgress((double) result.getInt("health")/100);
            energyProgressBar.setProgress((double) result.getInt("energy")/100);
            foodProgressBar.setProgress((double) result.getInt("hunger")/100);
            waterProgressBar.setProgress((double) result.getInt("thirst")/100);
        } catch (Exception e) {
            System.out.println("r");
        }
    }

    public void inventoryPage(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("inventoryPage.fxml"));
        Stage stage = (Stage) usernameLabel.getScene().getWindow();
        stage.setTitle("Home");
        stage.setScene(new Scene(root, 560, 400));
        stage.show();
    }
}
