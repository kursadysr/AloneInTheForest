package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayerData {
    public static String username = LoginPage.passedUsername;
    public static ResultSet result;

    public static int id;
    public static int health;
    public static int energy;
    public static int food;
    public static int water;
    public static int gameDay;
    public static String location;


    public static void getInfo() throws SQLException {

        Statement st = Main.db.createStatement();
        String query = "SELECT * FROM characters Where name = '" + username + "';";
        result = st.executeQuery(query);
        result.next();
        id = result.getInt("character_id");
        health = result.getInt("health");
        energy = result.getInt("energy");
        food = result.getInt("hunger");
        water = result.getInt("thirst");
        gameDay = result.getInt("game_day");
        location = result.getString("location_id");
    }

    public static void setInfo() throws SQLException {
        if (energy > 100) {
            energy = 100;
        } if (health > 100) {
            health = 100;
        } if (food > 100) {
            food = 100;
        } if (water > 100) {
            water = 100;
        }

        Statement st = Main.db.createStatement();
        String query = "UPDATE characters  SET" +
                " health = '"+health+"'," +
                " energy = '"+energy+"'," +
                " hunger = '"+food+"'," +
                " thirst = '"+water+"'," +
                " game_day = '"+gameDay+"'," +
                " location_id = '"+location+"'" +
                " where name = '"+username+"' ";
        st.executeUpdate(query);
        st.close();
    }


}
