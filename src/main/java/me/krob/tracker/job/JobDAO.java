package me.krob.tracker.job;

import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import me.krob.storage.DAO;
import me.krob.tracker.Tracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Map;

@RequiredArgsConstructor
public class JobDAO implements DAO<Job> {
    private final Map<Integer, Job> jobById = Maps.newHashMap();
    private final Map<String, Job> jobByName = Maps.newHashMap();

    private final Tracker tracker;

    public void load() {
        try (Connection connection = tracker.getDatabaseManager().newConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Jobs")) {
            try (ResultSet resultSet = statement.getResultSet()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int target = resultSet.getInt("target");

                load(new Job(id, name, target));
            }
        } catch (Throwable throwable) {
            System.out.println("Error loading JobDAO.");
        }
    }

    public void load(Job value) {
        jobById.put(value.getId(), value);
        jobByName.put(value.getName(), value);
    }

    public void insert(Job value) {

    }

    public void delete(Job value) {

    }

    public void update(Job value) {

    }

    public Job getById(int id) {
        return jobById.get(id);
    }

    public Job getByName(String name) {
        return jobByName.get(name);
    }

    public Collection<Job> getAll() {
        return jobById.values();
    }
}
