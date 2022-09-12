package me.zeromaniac.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class ItemHelper {

    public static final char BUKKIT_COLOR_CHAR = '\u00a7';

    public static final Pattern BUKKI_HEX_COLOR = Pattern.compile(
            "(?:&|" + BUKKIT_COLOR_CHAR +
                    ")x(?:&|" + BUKKIT_COLOR_CHAR +
                    ")([0-9a-fA-F])(?:&|" + BUKKIT_COLOR_CHAR +
                    ")([0-9a-fA-F])(?:&|" + BUKKIT_COLOR_CHAR +
                    ")([0-9a-fA-F])(?:&|" + BUKKIT_COLOR_CHAR +
                    ")([0-9a-fA-F])(?:&|" + BUKKIT_COLOR_CHAR +
                    ")([0-9a-fA-F])(?:&|" + BUKKIT_COLOR_CHAR +
                    ")([0-9a-fA-F])");

    public static String stripColor(String itemDisplayName) {
        return itemDisplayName.replaceAll("\u00a7[0-9A-Fa-fk-orx]", "");
    }

    public static String stripHex(String itemDisplayName) {
        return itemDisplayName
                .replaceAll("&#([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])", "");
    }

    public static String nameFormatter(ItemStack item) {

        String itemName = item.getType().toString();
        String[] splitName = itemName.split("_");
        String capitalizeWords = "";

        for (String words : splitName) {
            String firstLetter = words.substring(0, 1);
            String tailPart = words.substring(1);
            capitalizeWords += firstLetter.toUpperCase() + tailPart.toLowerCase() + " ";

        }
        return capitalizeWords.trim();
    }

    public static String priceShortener(double price, boolean format) {
        if (!format) {
            return String.valueOf(price);
        }
        String result = "";
        Map<String, Long> prices = new HashMap<>();
        prices.put("k", 1000L);
        prices.put("m", 1000000L);
        prices.put("b", 1000000000L);
        prices.put("t", 1000000000000L);
        prices.put("q", 1000000000000000L);
        prices.put("qu", 1000000000000000000L);

        for (Map.Entry<String, Long> entry : prices.entrySet()) {
            double priceDivision = (price / entry.getValue());
            long myPrice = (long) (priceDivision * 1000D);
            if (myPrice >= 1000L && myPrice < 1000000L) {
                result = (myPrice / 1000D) + entry.getKey();
                break;
            }
        }

        if (result.isEmpty()) {
            result = String.valueOf(price);
        }

        return result;
    }

    public static final List<Pattern> VALID_HEX_PATTERNS = Arrays.asList(
            Pattern.compile("&#([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])"),
            Pattern.compile("#([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])"),
            Pattern.compile("\\{#([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])([0-9a-fA-F])}"));

    public static String convertHexToBukkit(String input) {
        for (Pattern pattern : VALID_HEX_PATTERNS) {
            Matcher matcher = pattern.matcher(input);
            StringBuilder sb = new StringBuilder();
            while (matcher.find()) {
                String bukkitColorCode = "§x§" + matcher.group(1).toUpperCase()
                        + "§" + matcher.group(2).toUpperCase()
                        + "§" + matcher.group(3).toUpperCase()
                        + "§" + matcher.group(4).toUpperCase()
                        + "§" + matcher.group(5).toUpperCase()
                        + "§" + matcher.group(6).toUpperCase();
                matcher.appendReplacement(sb, bukkitColorCode);
            }

            matcher.appendTail(sb);
            input = sb.toString();
        }
        return input;
    }

    public static String bukkitColorYeeter(String input) {
        return ChatColor.stripColor(BUKKI_HEX_COLOR.matcher(input).replaceAll(""));
    }

}