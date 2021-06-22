package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class InventoryPage implements Initializable {




    @FXML
    private ImageView item1;
    @FXML
    private ImageView item2;
    @FXML
    private ImageView item3;
    @FXML
    private ImageView item4;
    @FXML
    private ImageView item5;
    @FXML
    private ImageView item6;
    @FXML
    private ImageView item7;
    @FXML
    private ImageView item8;
    @FXML
    private ImageView item9;
    @FXML
    private ImageView item10;
    @FXML
    private Button backButton;

    private Image apple = new Image(String.valueOf(getClass().getResource("../images/items/apple.png")));
    private Image axe = new Image(String.valueOf(getClass().getResource("../images/items/axe.png")));
    private Image emptyBottle = new Image(String.valueOf(getClass().getResource("../images/items/emptyBottle.png")));
    private Image knife = new Image(String.valueOf(getClass().getResource("../images/items/knife.png")));
    private Image leaf = new Image(String.valueOf(getClass().getResource("../images/items/leaf.png")));
    private Image rope = new Image(String.valueOf(getClass().getResource("../images/items/rope.png")));
    private Image stick = new Image(String.valueOf(getClass().getResource("../images/items/stick.png")));
    private Image stone = new Image(String.valueOf(getClass().getResource("../images/items/stone.png")));
    private Image waterBottle = new Image(String.valueOf(getClass().getResource("../images/items/waterBottle.png")));
    private Image wood = new Image(String.valueOf(getClass().getResource("../images/items/wood.png")));


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            Statement st = Main.db.createStatement();
            String query = "Select name, item_name, count(item_name)\n" +
                    "From characters\n" +
                    "inner join characters_has_items\n" +
                    "on characters.character_id = characters_has_items.character_id\n" +
                    "inner join items\n" +
                    "on items.item_id = characters_has_items.item_id\n" +
                    "where name = \""+ LoginPage.passedUsername+"\"\n" +
                    "group by item_name;";
            ResultSet result = st.executeQuery(query);
            while(result.next()){
                System.out.println(result.getString("name") + result.getString("item_name") + result.getInt("count(item_name)"));
                if(result.getString("item_name").equals("Apple")){
                    item1.setImage(apple);
                    item1.toBack();
                } else if(result.getString("item_name").equals("Axe")){
                    item2.setImage(axe);
                    item2.toBack();
                } else if(result.getString("item_name").equals("Empty Bottle")){
                    item3.setImage(emptyBottle);
                    item3.toBack();
                } else if(result.getString("item_name").equals("Knife")){
                    item4.setImage(knife);
                    item4.toBack();
                } else if(result.getString("item_name").equals("Leaf")){
                    item5.setImage(leaf);
                    item5.toBack();
                } else if(result.getString("item_name").equals("Rope")){
                    item6.setImage(rope);
                    item6.toBack();
                } else if(result.getString("item_name").equals("Stick")){
                    item7.setImage(stick);
                    item7.toBack();
                } else if(result.getString("item_name").equals("Stone")){
                    item8.setImage(stone);
                    item8.toBack();
                } else if(result.getString("item_name").equals("Bottle Water")){
                    item9.setImage(waterBottle);
                    item9.toBack();
                } else if(result.getString("item_name").equals("Wood")){
                    item10.setImage(wood);
                    item10.toBack();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void backButton(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homePage.fxml")));
            Main.primaryStage.setTitle("Home");
            Main.primaryStage.setScene(new Scene(root, 560, 400));
            Main.primaryStage.setResizable(false);
            Main.primaryStage.show();
        } catch (Exception e ){
            System.out.println("e");

        }
    }
}
