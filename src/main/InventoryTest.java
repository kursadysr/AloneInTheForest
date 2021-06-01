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
        try {
            Statement st = Main.db.createStatement();
            String query = "Select name, item_name, count(item_name)\n" +
                    "From characters\n" +
                    "inner join characters_has_items\n" +
                    "on characters.character_id = characters_has_items.character_id\n" +
                    "inner join items\n" +
                    "on items.item_id = characters_has_items.item_id\n" +
                    "where name = \"Kursad\"\n" +
                    "group by item_name;";
            ResultSet result = st.executeQuery(query);
            while(result.next()){
                System.out.println(result.getString("name") + result.getString("item_name") + result.getInt("count(item_name)"));
                if(result.getString("item_name").equals("Knife")){
                    item00.setImage(knife);
                    System.out.println("SET!!!");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void initialize() {
    }


}
