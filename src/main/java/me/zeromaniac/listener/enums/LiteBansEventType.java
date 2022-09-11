package me.zeromaniac.listener.enums;


public enum LiteBansEventType {
    PERMANENT_BAN("PermanentBan"),
    TEMPORARY_BAN("TemporaryBan"),
    PERMANENT_IP_BAN("PermanentIPBan"),
    TEMPORARY_IP_BAN("TemporaryIPBan"),
    PERMANENT_MUTE("PermanentMute"),
    TEMPORARY_MUTE("TemporaryMute"),
    PERMANENT_IP_MUTE("PermanentIPMute"),
    TEMPORARY_IP_MUTE("TemporaryIPMute"),
    KICK("Kick"),
    WARN("Warn"),
    UNBAN("Unban"),
    UNMUTE("Unmute"),
    UNWARN("Unwarn");

    final String value;

    private LiteBansEventType(String value) {
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
