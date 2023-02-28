package me.krob.tracker;

import lombok.Getter;
import me.krob.frame.LogHistoryForm;
import me.krob.storage.DatabaseManager;

@Getter
public class Tracker {
    private final DatabaseManager databaseManager;

    public Tracker() {
        databaseManager = new DatabaseManager();
        databaseManager.loadDriver();

        new LogHistoryForm().setVisible(true);
    }
}
