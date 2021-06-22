package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayerData {
    public static String username = LoginPage.passedUsername;
    public static ResultSet result;
    public static int health;
    public static int energy;
    public static int food;
    public static int water;
    public static int gameDay;


    public static void getInfo() throws SQLException {

        Statement st = Main.db.createStatement();
        String query = "SELECT * FROM characters Where name = '" + username + "';";
        result = st.executeQuery(query);
        result.next();
        health = result.getInt("health");
        energy = result.getInt("energy");
        food = result.getInt("hunger");
        water = result.getInt("thirst");
        gameDay = result.getInt("game_day");
    }

//    public static void setInfo() throws SQLException {
//        Statement st = Main.db.createStatement();
//        String query = "UPDATE characters  (energy, game_day) VALUES ('"+energy+"','"+gameDay+"') where name = "+username+" ";
//        System.out.println("--------------------------");
//        st.executeUpdate(query);
//        System.out.println(energy + gameDay);
//        st.close();
//    }


}
