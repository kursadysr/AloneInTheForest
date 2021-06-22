package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class InventoryTest implements Initializable {
    static FileInputStream knifepath;
    static FileInputStream applepath;

    static {
        try {
            applepath = new FileInputStream("/Users/kursad/GitHub/AloneInTheForest/src/images/items/apple.png");
            knifepath = new FileInputStream("/Users/kursad/GitHub/AloneInTheForest/src/images/items/knife.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static Image apple = new Image(applepath);
    static Image knife = new Image(knifepath);

    @FXML
    private static ImageView item00 = new ImageView();




    public void getItems(MouseEvent mouseEvent){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void initialize() {
    }


}
