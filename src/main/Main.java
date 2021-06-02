package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

public class Main extends Application {
    public static Connection db;
    public static Parent root;
    public static Stage primaryStage = new Stage();
// This change for test
    @Override
    public void start(Stage primaryStage) throws Exception{
        started();
    }

    public static void started() throws Exception{
        root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("login.fxml")));
        primaryStage.setTitle("Log In");
        primaryStage.setScene(new Scene(root, 560, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        try {
            db =  DriverManager.getConnection("jdbc:mariadb://sql5.freesqldatabase.com:3306/sql5413340?user=sql5413340&password=s6EJsVDr7n");
            System.out.println("Successfully connected!");
        } catch (Exception e) {
            System.out.println("d");
        }


        launch(args);
    }
}
