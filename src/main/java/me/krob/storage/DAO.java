package me.krob.storage;

import java.util.Collection;

public interface DAO<V> {
    void load();
    void load(V value);
    void insert(V value);
    void delete(V value);
    void update(V value);

    V getById(int id);
    V getByName(String name);
    Collection<V> getAll();
}
