package me.zeromaniac.listener.enums;

public enum VanillaEventType {
    JOIN("PlayerJoin"),
    FIRST_JOIN("PlayerFirstJoin"),
    LEAVE("PlayerQuit"),
    DEATH("PlayerDeathByEntity"),
    DEATH_ENV("PlayerDeathByEnvironment"),
    COMMAND("PlayerCommand"),
    LEVELUP("LevelUp"),
    WORLD_CHANGE("WorldChange");

    final String value;

    private VanillaEventType(String value) {
            this.value = value;
    }

    public String getValue() { 
            return value;
    }

    @Override
    public String toString() {
            return value;
    }
    
}
