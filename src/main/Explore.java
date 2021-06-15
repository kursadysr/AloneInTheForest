package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Explore implements Initializable {

    @FXML
    private Button cutTreeButton;
    @FXML
    private Button getWaterButton;
    @FXML
    private Button miningButton;
    @FXML
    private Button homeButton;
    @FXML
    private Button exploreButton;
    @FXML
    private Label actionsLabel;
    @FXML
    private Label itemsLabel;
    @FXML
    private ImageView itemImage1;
    @FXML
    private ImageView itemImage2;
    @FXML
    private ImageView itemImage3;

    public void homeButton(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Home.fxml")));
            Main.primaryStage.setTitle("Home");
            Main.primaryStage.setScene(new Scene(root, 560, 400));
            Main.primaryStage.setResizable(false);
            Main.primaryStage.show();
        } catch (Exception e ){
            System.out.println("e");

    }

}

        public void exploreButton(ActionEvent event){
            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("explore.fxml")));
                Main.primaryStage.setTitle("Explore");
                Main.primaryStage.setScene(new Scene(root, 560, 400));
                Main.primaryStage.setResizable(false);
                Main.primaryStage.show();
            } catch (Exception e ){
                System.out.println("e");

            }

        }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }}
