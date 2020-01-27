package com.example.discoapp.Controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DBConnection {
    private static Connection instance = null;

    public DBConnection() {
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            if (instance == null) {
                Class.forName("com.mysql.jdbc.Driver");
                instance = (Connection) DriverManager.getConnection("jdbc:mysql://halifaxtraining.es:3306/ciberkaos018", "uss018", "leon2019");
                //crearTablas();
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }


        return instance;
    }
}
