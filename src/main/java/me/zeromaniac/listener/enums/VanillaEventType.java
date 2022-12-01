package me.zeromaniac.listener.enums;

public enum VanillaEventType {
    JOIN("Player_Join"),
    FIRST_JOIN("Player_First_Join");

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
