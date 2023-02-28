package me.krob.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String DRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
    private static final String CONNECTION = "jdbc:ucanaccess://data/tracker.accdb";

    public void loadDriver() {
        try {
            Class.forName(DRIVER);
            System.out.println("Successfully loaded UCanAccess Driver.");
        } catch (Throwable throwable) {
            System.out.println("Failed to load UCanAccess Driver.");
            System.exit(0);
        }
    }

    public Connection newConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION);
    }

}
