package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button loginButton;
    @FXML
    private Button signupButton;
    @FXML
    private Button registerButton;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void login(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            Statement st = Main.db.createStatement();
            String query = "SELECT name, password  FROM characters Where name = '" + username + "' AND password = '" + password + "';";
            ResultSet result = st.executeQuery(query);
            result.next();
            if (username.equals(result.getString("name")) && password.equals(result.getString("password"))) {
                String toastMsg = "Successfully logged in";
                int toastMsgTime = 3500; //3.5 seconds
                int fadeInTime = 500; //0.5 seconds
                int fadeOutTime= 500; //0.5 seconds
                Toast.makeText(null, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
            }
            else {
                System.out.println("Error");
            }

            st.close();
        } catch (SQLDataException sql) {
            String toastMsg = "You entered invalid username or password. Please try again";
            int toastMsgTime = 3500; //3.5 seconds
            int fadeInTime = 500; //0.5 seconds
            int fadeOutTime= 500; //0.5 seconds
            Toast.makeText(null, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void loginPage(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(main.Main.class.getResource("login.fxml"));
            Main.primaryStage.setTitle("Log In");
            Main.primaryStage.setScene(new Scene(root, 560, 400));
            Main.primaryStage.setResizable(false);
            Main.primaryStage.show();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void signup(ActionEvent actionEvent) {
        try {
            System.out.println(getClass().toString());
            Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
            Main.primaryStage.setTitle("Register");
            Main.primaryStage.setScene(new Scene(root, 560, 400));
            Main.primaryStage.setResizable(false);
            Main.primaryStage.show();
        } catch (Exception e ){
            System.out.println(e);
        }

    }

    public void register(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            Statement st = Main.db.createStatement();
            String query = "INSERT INTO characters  (name, password) VALUES ('"+username+"', '"+password+"')";
            System.out.println(""+st.executeUpdate(query));
            System.out.println(username);
            st.close();
            Parent root = FXMLLoader.load(main.Main.class.getResource("login.fxml"));
            Main.primaryStage.setTitle("Log In");
            Main.primaryStage.setScene(new Scene(root, 560, 400));
            Main.primaryStage.setResizable(false);
            Main.primaryStage.show();
            String toastMsg = "Hi "+username+". Successfully registered.";
            int toastMsgTime = 3500; //3.5 seconds
            int fadeInTime = 500; //0.5 seconds
            int fadeOutTime= 500; //0.5 seconds
            Toast.makeText(null, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
