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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        waterProgressBar.setStyle("-fx-accent: #0D9EFF;");
        foodProgressBar.setStyle("-fx-accent: #FFC500;");
        healthProgressBar.setStyle("-fx-accent: #B7101D;");
        hearthIcon.setStyle("-fx-background-color: #B7101D;");
        usernameLabel.setText(LoginPage.passedUsername);
        dayLabel.setText("Day "+PlayerData.gameDay);
        locationLabel.setText(""+PlayerData.location);
        try {
            PlayerData.getInfo();
        } catch (Exception e) {
            System.out.println(e);
        }
        updateIndicators();
    }

    public void updateIndicators(){
        healthProgressBar.setProgress((double) PlayerData.health / 100);
        energyProgressBar.setProgress((double) PlayerData.energy / 100);
        foodProgressBar.setProgress((double) PlayerData.food / 100);
        waterProgressBar.setProgress((double) PlayerData.water / 100);
        locationLabel.setText(PlayerData.location);
        dayLabel.setText("Day "+PlayerData.gameDay);
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

    public void clicked(MouseEvent mouseEvent) throws SQLException {
        ImageView clickedImage =(ImageView) mouseEvent.getPickResult().getIntersectedNode();

        if (clickedImage.getImage().equals(apple)) {
            PlayerData.getInfo();
            PlayerData.food = PlayerData.food + 5;
            PlayerData.setInfo();
            updateIndicators();
        }
        if (clickedImage.getImage().equals(waterBottle)) {
            PlayerData.getInfo();
            PlayerData.water = PlayerData.water + 5;
            PlayerData.setInfo();
            updateIndicators();
        }


    }
}
