package me.zeromaniac.common;

import java.util.logging.Level;
import org.bukkit.Bukkit;

public class Debug {
    public static void log(Level level, String message) {
        Bukkit.getLogger().log(level, message);
    }

    public static void log(String message) {
        Bukkit.getLogger().log(Level.INFO, message);
    }

    public static void log(String message, boolean debug) {
        if (!debug) {
            return;
        }

        log(Level.SEVERE, message);
    }
}