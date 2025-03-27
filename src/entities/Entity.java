package entities;

import java.util.UUID;

public abstract class Entity {
    private UUID uuid;

    public Entity() {
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }
}