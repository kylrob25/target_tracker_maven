package me.krob.tracker.history;

import lombok.RequiredArgsConstructor;
import me.krob.storage.DAO;
import me.krob.storage.DatabaseManager;
import me.krob.tracker.Tracker;

import java.util.Collection;

@RequiredArgsConstructor
public class HistoryDAO implements DAO<HistoryData> {
    private final DatabaseManager databaseManager;

    public void load() {

    }

    public void load(HistoryData value) {

    }

    public void insert(HistoryData value) {

    }

    public void delete(HistoryData value) {

    }

    public void update(HistoryData value) {

    }

    public HistoryData getById(int id) {
        return null;
    }

    public HistoryData getByName(String name) {
        return null;
    }

    public Collection<HistoryData> getAll() {
        return null;
    }
}
