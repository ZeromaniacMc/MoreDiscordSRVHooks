package me.zeromaniac.listener.enums;

public enum PlayerWarpsEventType {

    warpCreated("NewWarpCreated"),
    warpDeleted("WarpRemoved"),
    onTeleport("Teleport");

    final String value;

    private PlayerWarpsEventType(String value) {
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
