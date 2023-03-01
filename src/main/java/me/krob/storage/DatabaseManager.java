package me.krob.storage;

import lombok.Getter;
import me.krob.tracker.Tracker;
import me.krob.tracker.history.HistoryDAO;
import me.krob.tracker.history.HistoryData;
import me.krob.tracker.job.JobDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class DatabaseManager {

    private static final String DRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";
    private static final String CONNECTION = "jdbc:ucanaccess://data/tracker.accdb";

    private final Tracker tracker;

    private JobDAO jobDAO;
    private HistoryDAO historyDAO;

    public DatabaseManager(Tracker tracker) {
        this.tracker = tracker;
    }

    public void load() {
        loadDriver();

        jobDAO = new JobDAO(this);
        historyDAO = new HistoryDAO(this);
    }

    private void loadDriver() {
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
