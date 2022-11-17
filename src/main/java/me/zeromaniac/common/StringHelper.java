package me.zeromaniac.common;

import me.clip.placeholderapi.PlaceholderAPI;
import me.zeromaniac.handlers.ConfigHandler;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

public class StringHelper {
    protected static boolean isPlaceholderAPIInstalled = ThirdPartyChecker.isPluginInstalled("PlaceholderAPI");

    public static boolean validateString(String val) {
        return val != null && !val.isEmpty() && !val.equalsIgnoreCase("console");
    }

    public static boolean stringEmpty(String val) {
        return val != null && !val.isEmpty();
    }

    public static String validateUrlOrAttachment(String val) {
        return isUrlOrAttachment(val) ? val : null;
    }

    public static boolean isUrlOrAttachment(String value) {
        return value != null && (value.contains("http") || value.contains("attachment"));
    }

    public static boolean mapContainsValue(Map<String, String> myMap, String contains) {
        for (Map.Entry<String, String> entry : myMap.entrySet()) {
            if (entry.getValue().contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public static String parsePlaceholders(String text, Map<String, String> replacer) {
        if (text == null) {
            return "";
        }
        for (Map.Entry<String, String> entry : replacer.entrySet()) {
            text = text.replace(entry.getKey(), entry.getValue());
        }
        if (isPlaceholderAPIInstalled) {
            return PlaceholderAPI.setPlaceholders(null, text);
        }
        return text;
    }

    public static boolean validateUUID(String uuid) {
        Pattern pattern = Pattern
                .compile("[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}");
        return pattern.matcher(uuid).matches();
    }

    public static String boolToString(boolean val) {
        return val ? "Yes" : "No";
    }

    public static String formatTime(long time, String stringInCaseTimeZero) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
        return time != 0
                ? new Date(time).toInstant().atZone(ZoneId.of(ConfigHandler.getMainConfig().getTimezone()))
                        .format(formatter)
                : stringInCaseTimeZero;
    }
}
