package me.zeromaniac.embed.enums;

import java.util.ArrayList;

public enum ConfigFields {
    AUTHOR_NAME("Embed.Author.Name", true),
    TITLE_TEXT("Embed.Title.Text", true),
    DESCRIPTION("Embed.Description", true),
    FOOTER_TEXT("Embed.Footer.Text", true),
    AUTHOR_IMAGE_URL("Embed.Author.ImageUrl", true),
    THUMBNAIL_URL("Embed.ThumbnailUrl", true),
    IMAGE_URL("Embed.ImageUrl", true),
    FOOTER_ICON_URL("Embed.Footer.IconUrl", true),

    AUTHOR_URL("Embed.Author.Url", false),
    TITLE_URL("Embed.Title.Url", false),
    CHANNEL_ID("Embed.ChannelID", false),
    COLOR("Embed.Color", false),

    FIELDS("Embed.Fields", false);

    final String value;
    final boolean replaceOn;

    private ConfigFields(String value, boolean replaceOn) {
        this.value = value;
        this.replaceOn = replaceOn;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

    public boolean isReplaceOn() {
        return replaceOn;
    }

    public static String[] getReplacerValues() {
        ArrayList<String> replacerList = new ArrayList<>();

        for (ConfigFields field : ConfigFields.values()) {
            if (field.replaceOn) {
                replacerList.add(field.value);
            }
        }

        return replacerList.toArray(new String[0]);
    }
}