package repository;

import entities.Entity;

import java.util.HashMap;
import java.util.UUID;
import java.util.*;

public class HashMapRepository<T extends Entity> implements EntityRepository<T> {
    private HashMap<UUID, T> dataStore = new HashMap<>();

    @Override
    public void save(T entity) {
        this.dataStore.put(entity.getUuid(), entity);
    }

    @Override
    public Optional<T> findById(UUID id) {
        return Optional.of(this.dataStore.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<T>(this.dataStore.values());
    }

    @Override
    public void deleteById(UUID id) {
        this.dataStore.remove(id);
    }
}