package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginPage implements Initializable {
    public static String passedUsername;

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void loginHandler(){
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            Statement st = Main.db.createStatement();
            String query = "SELECT name, password  FROM characters Where name = '" + username + "' AND password = '" + password + "';";
            ResultSet result = st.executeQuery(query);
            result.next();
            if (username.equals(result.getString("name")) && password.equals(result.getString("password"))) {
                passedUsername = result.getString("name");
                homePage();
                String toastMsg = "Successfully logged in";
                int toastMsgTime = 3500; //3.5 seconds
                int fadeInTime = 500; //0.5 seconds
                int fadeOutTime= 500; //0.5 seconds
                Toast.makeText(null, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
            }
            else {
                String toastMsg = "You entered invalid username or password. Please try again";
                int toastMsgTime = 3500; //3.5 seconds
                int fadeInTime = 500; //0.5 seconds
                int fadeOutTime= 500; //0.5 seconds
                Toast.makeText(null, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
            }

            st.close();
        } catch (SQLDataException sql) {
            String toastMsg = "You entered invalid username or password. Please try again";
            int toastMsgTime = 3500; //3.5 seconds
            int fadeInTime = 500; //0.5 seconds
            int fadeOutTime= 500; //0.5 seconds
            Toast.makeText(null, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
        } catch (Exception e) {
            System.out.println("e");
        }
    }

    public void login(ActionEvent actionEvent) {
        loginHandler();
    }

    public void loginPage(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("loginPage.fxml")));
            Main.primaryStage.setTitle("Log In");
            Main.primaryStage.setScene(new Scene(root, 560, 400));
            Main.primaryStage.setResizable(false);
            Main.primaryStage.show();
        } catch (Exception e){
            System.out.println("e");
        }
    }

    public void homePage() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("homePage.fxml")));
            Main.primaryStage.setTitle("Alone In The Forest");
            Main.primaryStage.setScene(new Scene(root, 560, 400));
            Main.primaryStage.setResizable(false);
            Main.primaryStage.show();
        } catch (Exception e){
            System.out.println("e");
        }
    }

    public void signup(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registerPage.fxml")));
            Main.primaryStage.setTitle("Register");
            Main.primaryStage.setScene(new Scene(root, 560, 400));
            Main.primaryStage.setResizable(false);
            Main.primaryStage.show();
        } catch (Exception e ){
            System.out.println("e");
        }

    }

    public void register(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        try {
            Statement st = Main.db.createStatement();
            String query = "INSERT INTO characters  (name, password) VALUES ('"+username+"', '"+password+"')";
            st.executeUpdate(query);
            st.close();
            Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("loginPage.fxml")));
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
            System.out.println("e");
        }

    }

    public void keyPressed(KeyEvent keyEvent) {

        switch (keyEvent.getCode()) {
            case ENTER:
                loginHandler();
        }
    }
}
