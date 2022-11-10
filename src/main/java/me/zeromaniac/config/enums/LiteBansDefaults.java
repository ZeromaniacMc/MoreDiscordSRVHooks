package me.zeromaniac.config.enums;

public enum LiteBansDefaults implements EnumGeneral {
    /*
     * Permanent Ban
     */
    // todo: finish defaults for litebans :D
    LITE_BANS_PERMANENT_BAN_EMBED_ENABLED("PermanentBan.Embed.Enabled", true),

    // Main embed settings
    LITE_BANS_PERMANENT_BAN_EMBED_CHANNEL_ID("PermanentBan.Embed.ChannelID", "[]"),
    LITE_BANS_PERMANENT_BAN_EMBED_COLOR("PermanentBan.Embed.Color", "#fcba03"),

    // Embed author settings
    LITE_BANS_PERMANENT_BAN_EMBED_AUTHOR_IMAGEURL("PermanentBan.Embed.Author.ImageUrl", "{executorAvatarUrl}"),
    LITE_BANS_PERMANENT_BAN_EMBED_AUTHOR_NAME("PermanentBan.Embed.Author.Name", "Permanent ban issued!"),
    LITE_BANS_PERMANENT_BAN_EMBED_AUTHOR_URL("PermanentBan.Embed.Author.Url", ""),

    // Embed thumbnail settings
    LITE_BANS_PERMANENT_BAN_EMBED_THUMBNAIL("PermanentBan.Embed.ThumbnailUrl", ""),
    LITE_BANS_PERMANENT_BAN_EMBED_TITLE_TEXT("PermanentBan.Embed.Title.Text", ""),
    LITE_BANS_PERMANENT_BAN_TITLE_URL("PermanentBan.Embed.Title.Url", ""),

    // Embed description
    LITE_BANS_PERMANENT_BAN_EMBED_DESCRIPTION("PermanentBan.Embed.Description", ""),
    LITE_BANS_PERMANENT_BAN_EMBED_FIELDS("PermanentBan.Embed.Fields", "[]"),
    LITE_BANS_PERMANENT_BAN_EMBED_IMAGEURL("PermanentBan.Embed.ImageUrl", ""),

    // Footer settings
    LITE_BANS_PERMANENT_BAN_EMBED_FOOTER_TEXT("PermanentBan.Embed.Footer.Text", ""),
    LITE_BANS_PERMANENT_BAN_EMBED_FOOTER_ICONURL("PermanentBan.Embed.Footer.IconUrl", ""),
    LITE_BANS_PERMANENT_BAN_EMBED_TIMESTAMP("PermanentBan.Embed.Timestamp", true),

    /*
     * Temporary Ban
     */
    LITE_BANS_TEMPORARY_BAN_EMBED_ENABLED("TemporaryBan.Embed.Enabled", true),

    // Main embed settings
    LITE_BANS_TEMPORARY_BAN_EMBED_CHANNEL_ID("TemporaryBan.Embed.ChannelID", "[]"),
    LITE_BANS_TEMPORARY_BAN_EMBED_COLOR("TemporaryBan.Embed.Color", "#fcba03"),

    // Embed author settings
    LITE_BANS_TEMPORARY_BAN_EMBED_AUTHOR_IMAGEURL("TemporaryBan.Embed.Author.ImageUrl", "{executorAvatarUrl}"),
    LITE_BANS_TEMPORARY_BAN_EMBED_AUTHOR_NAME("TemporaryBan.Embed.Author.Name", "Temporary ban issued!"),
    LITE_BANS_TEMPORARY_BAN_EMBED_AUTHOR_URL("TemporaryBan.Embed.Author.Url", ""),

    // Embed thumbnail settings
    LITE_BANS_TEMPORARY_BAN_EMBED_THUMBNAIL("TemporaryBan.Embed.ThumbnailUrl", ""),
    LITE_BANS_TEMPORARY_BAN_EMBED_TITLE_TEXT("TemporaryBan.Embed.Title.Text", ""),
    LITE_BANS_TEMPORARY_BAN_TITLE_URL("TemporaryBan.Embed.Title.Url", ""),

    // Embed description
    LITE_BANS_TEMPORARY_BAN_EMBED_DESCRIPTION("TemporaryBan.Embed.Description", ""),
    LITE_BANS_TEMPORARY_BAN_EMBED_FIELDS("TemporaryBan.Embed.Fields", "[]"),
    LITE_BANS_TEMPORARY_BAN_EMBED_IMAGEURL("TemporaryBan.Embed.ImageUrl", ""),

    // Footer settings
    LITE_BANS_TEMPORARY_BAN_EMBED_FOOTER_TEXT("TemporaryBan.Embed.Footer.Text", ""),
    LITE_BANS_TEMPORARY_BAN_EMBED_FOOTER_ICONURL("TemporaryBan.Embed.Footer.IconUrl", ""),
    LITE_BANS_TEMPORARY_BAN_EMBED_TIMESTAMP("TemporaryBan.Embed.Timestamp", true),

    /*
     * Permanent IP Ban
     */
    LITE_BANS_PERMANENT_IP_BAN_EMBED_ENABLED("PermanentIPBan.Embed.Enabled", true),

    // Main embed settings
    LITE_BANS_PERMANENT_IP_BAN_EMBED_CHANNEL_ID("PermanentIPBan.Embed.ChannelID", "[]"),
    LITE_BANS_PERMANENT_IP_BAN_EMBED_COLOR("PermanentIPBan.Embed.Color", "#fcba03"),

    // Embed author settings
    LITE_BANS_PERMANENT_IP_BAN_EMBED_AUTHOR_IMAGEURL("PermanentIPBan.Embed.Author.ImageUrl", "{executorAvatarUrl}"),
    LITE_BANS_PERMANENT_IP_BAN_EMBED_AUTHOR_NAME("PermanentIPBan.Embed.Author.Name", "Permanent IP ban issued!"),
    LITE_BANS_PERMANENT_IP_BAN_EMBED_AUTHOR_URL("PermanentIPBan.Embed.Author.Url", ""),

    // Embed thumbnail settings
    LITE_BANS_PERMANENT_IP_BAN_EMBED_THUMBNAIL("PermanentIPBan.Embed.ThumbnailUrl", ""),
    LITE_BANS_PERMANENT_IP_BAN_EMBED_TITLE_TEXT("PermanentIPBan.Embed.Title.Text", ""),
    LITE_BANS_PERMANENT_IP_BAN_TITLE_URL("PermanentIPBan.Embed.Title.Url", ""),

    // Embed description
    LITE_BANS_PERMANENT_IP_BAN_EMBED_DESCRIPTION("PermanentIPBan.Embed.Description", ""),
    LITE_BANS_PERMANENT_IP_BAN_EMBED_FIELDS("PermanentIPBan.Embed.Fields", "[]"),
    LITE_BANS_PERMANENT_IP_BAN_EMBED_IMAGEURL("PermanentIPBan.Embed.ImageUrl", ""),

    // Footer settings
    LITE_BANS_PERMANENT_IP_BAN_EMBED_FOOTER_TEXT("PermanentIPBan.Embed.Footer.Text", ""),
    LITE_BANS_PERMANENT_IP_BAN_EMBED_FOOTER_ICONURL("PermanentIPBan.Embed.Footer.IconUrl", ""),
    LITE_BANS_PERMANENT_IP_BAN_EMBED_TIMESTAMP("PermanentIPBan.Embed.Timestamp", true),

    /*
     * Temporary IP Ban
     */
    LITE_BANS_TEMPORARY_IP_BAN_EMBED_ENABLED("TemporaryIPBan.Embed.Enabled", true),

    // Main embed settings
    LITE_BANS_TEMPORARY_IP_BAN_EMBED_CHANNEL_ID("TemporaryIPBan.Embed.ChannelID", "[]"),
    LITE_BANS_TEMPORARY_IP_BAN_EMBED_COLOR("TemporaryIPBan.Embed.Color", "#fcba03"),

    // Embed author settings
    LITE_BANS_TEMPORARY_IP_BAN_EMBED_AUTHOR_IMAGEURL("TemporaryIPBan.Embed.Author.ImageUrl", "{executorAvatarUrl}"),
    LITE_BANS_TEMPORARY_IP_BAN_EMBED_AUTHOR_NAME("TemporaryIPBan.Embed.Author.Name", "Temporary IP ban issued!"),
    LITE_BANS_TEMPORARY_IP_BAN_EMBED_AUTHOR_URL("TemporaryIPBan.Embed.Author.Url", ""),

    // Embed thumbnail settings
    LITE_BANS_TEMPORARY_IP_BAN_EMBED_THUMBNAIL("TemporaryIPBan.Embed.ThumbnailUrl", ""),
    LITE_BANS_TEMPORARY_IP_BAN_EMBED_TITLE_TEXT("TemporaryIPBan.Embed.Title.Text", ""),
    LITE_BANS_TEMPORARY_IP_BAN_TITLE_URL("TemporaryIPBan.Embed.Title.Url", ""),

    // Embed description
    LITE_BANS_TEMPORARY_IP_BAN_EMBED_DESCRIPTION("TemporaryIPBan.Embed.Description", ""),
    LITE_BANS_TEMPORARY_IP_BAN_EMBED_FIELDS("TemporaryIPBan.Embed.Fields", "[]"),
    LITE_BANS_TEMPORARY_IP_BAN_EMBED_IMAGEURL("TemporaryIPBan.Embed.ImageUrl", ""),

    // Footer settings
    LITE_BANS_TEMPORARY_IP_BAN_EMBED_FOOTER_TEXT("TemporaryIPBan.Embed.Footer.Text", ""),
    LITE_BANS_TEMPORARY_IP_BAN_EMBED_FOOTER_ICONURL("TemporaryIPBan.Embed.Footer.IconUrl", ""),
    LITE_BANS_TEMPORARY_IP_BAN_EMBED_TIMESTAMP("TemporaryIPBan.Embed.Timestamp", true),

    /*
     * Unban
     */
    LITE_BANS_UNBAN_EMBED_ENABLED("Unban.Embed.Enabled", true),

    // Main embed settings
    LITE_BANS_UNBAN_EMBED_CHANNEL_ID("Unban.Embed.ChannelID", "[]"),
    LITE_BANS_UNBAN_EMBED_COLOR("Unban.Embed.Color", "#fcba03"),

    // Embed author settings
    LITE_BANS_UNBAN_EMBED_AUTHOR_IMAGEURL("Unban.Embed.Author.ImageUrl", "{executorAvatarUrl}"),
    LITE_BANS_UNBAN_EMBED_AUTHOR_NAME("Unban.Embed.Author.Name", "Unban issued!"),
    LITE_BANS_UNBAN_EMBED_AUTHOR_URL("Unban.Embed.Author.Url", ""),

    // Embed thumbnail settings
    LITE_BANS_UNBAN_EMBED_THUMBNAIL("Unban.Embed.ThumbnailUrl", ""),
    LITE_BANS_UNBAN_EMBED_TITLE_TEXT("Unban.Embed.Title.Text", ""),
    LITE_BANS_UNBAN_TITLE_URL("Unban.Embed.Title.Url", ""),

    // Embed description
    LITE_BANS_UNBAN_EMBED_DESCRIPTION("Unban.Embed.Description", ""),
    LITE_BANS_UNBAN_EMBED_FIELDS("Unban.Embed.Fields", "[]"),
    LITE_BANS_UNBAN_EMBED_IMAGEURL("Unban.Embed.ImageUrl", ""),

    // Footer settings
    LITE_BANS_UNBAN_EMBED_FOOTER_TEXT("Unban.Embed.Footer.Text", ""),
    LITE_BANS_UNBAN_EMBED_FOOTER_ICONURL("Unban.Embed.Footer.IconUrl", ""),
    LITE_BANS_UNBAN_EMBED_TIMESTAMP("Unban.Embed.Timestamp", true),

    /*
     * Permanent Mute
     */
    LITE_BANS_PERMANENT_MUTE_EMBED_ENABLED("PermanentMute.Embed.Enabled", true),

    // Main embed settings
    LITE_BANS_PERMANENT_MUTE_EMBED_CHANNEL_ID("PermanentMute.Embed.ChannelID", "[]"),
    LITE_BANS_PERMANENT_MUTE_EMBED_COLOR("PermanentMute.Embed.Color", "#fcba03"),

    // Embed author settings
    LITE_BANS_PERMANENT_MUTE_EMBED_AUTHOR_IMAGEURL("PermanentMute.Embed.Author.ImageUrl", "{executorAvatarUrl}"),
    LITE_BANS_PERMANENT_MUTE_EMBED_AUTHOR_NAME("PermanentMute.Embed.Author.Name", "Permanent mute issued!"),
    LITE_BANS_PERMANENT_MUTE_EMBED_AUTHOR_URL("PermanentMute.Embed.Author.Url", ""),

    // Embed thumbnail settings
    LITE_BANS_PERMANENT_MUTE_EMBED_THUMBNAIL("PermanentMute.Embed.ThumbnailUrl", ""),
    LITE_BANS_PERMANENT_MUTE_EMBED_TITLE_TEXT("PermanentMute.Embed.Title.Text", ""),
    LITE_BANS_PERMANENT_MUTE_TITLE_URL("PermanentMute.Embed.Title.Url", ""),

    // Embed description
    LITE_BANS_PERMANENT_MUTE_EMBED_DESCRIPTION("PermanentMute.Embed.Description", ""),
    LITE_BANS_PERMANENT_MUTE_EMBED_FIELDS("PermanentMute.Embed.Fields", "[]"),
    LITE_BANS_PERMANENT_MUTE_EMBED_IMAGEURL("PermanentMute.Embed.ImageUrl", ""),

    // Footer settings
    LITE_BANS_PERMANENT_MUTE_EMBED_FOOTER_TEXT("PermanentMute.Embed.Footer.Text", ""),
    LITE_BANS_PERMANENT_MUTE_EMBED_FOOTER_ICONURL("PermanentMute.Embed.Footer.IconUrl", ""),
    LITE_BANS_PERMANENT_MUTE_EMBED_TIMESTAMP("PermanentMute.Embed.Timestamp", true),

    /*
     * Temporary Mute
     */
    LITE_BANS_TEMPORARY_MUTE_EMBED_ENABLED("TemporaryMute.Embed.Enabled", true),

    // Main embed settings
    LITE_BANS_TEMPORARY_MUTE_EMBED_CHANNEL_ID("TemporaryMute.Embed.ChannelID", "[]"),
    LITE_BANS_TEMPORARY_MUTE_EMBED_COLOR("TemporaryMute.Embed.Color", "#fcba03"),

    // Embed author settings
    LITE_BANS_TEMPORARY_MUTE_EMBED_AUTHOR_IMAGEURL("TemporaryMute.Embed.Author.ImageUrl", "{executorAvatarUrl}"),
    LITE_BANS_TEMPORARY_MUTE_EMBED_AUTHOR_NAME("TemporaryMute.Embed.Author.Name", "Temporary mute issued!"),
    LITE_BANS_TEMPORARY_MUTE_EMBED_AUTHOR_URL("TemporaryMute.Embed.Author.Url", ""),

    // Embed thumbnail settings
    LITE_BANS_TEMPORARY_MUTE_EMBED_THUMBNAIL("TemporaryMute.Embed.ThumbnailUrl", ""),
    LITE_BANS_TEMPORARY_MUTE_EMBED_TITLE_TEXT("TemporaryMute.Embed.Title.Text", ""),
    LITE_BANS_TEMPORARY_MUTE_TITLE_URL("TemporaryMute.Embed.Title.Url", ""),

    // Embed description
    LITE_BANS_TEMPORARY_MUTE_EMBED_DESCRIPTION("TemporaryMute.Embed.Description", ""),
    LITE_BANS_TEMPORARY_MUTE_EMBED_FIELDS("TemporaryMute.Embed.Fields", "[]"),
    LITE_BANS_TEMPORARY_MUTE_EMBED_IMAGEURL("TemporaryMute.Embed.ImageUrl", ""),

    // Footer settings
    LITE_BANS_TEMPORARY_MUTE_EMBED_FOOTER_TEXT("TemporaryMute.Embed.Footer.Text", ""),
    LITE_BANS_TEMPORARY_MUTE_EMBED_FOOTER_ICONURL("TemporaryMute.Embed.Footer.IconUrl", ""),
    LITE_BANS_TEMPORARY_MUTE_EMBED_TIMESTAMP("TemporaryMute.Embed.Timestamp", true),

    /*
     * Permanent IP Mute
     */
    LITE_BANS_PERMANENT_IP_MUTE_EMBED_ENABLED("PermanentIPMute.Embed.Enabled", true),

    // Main embed settings
    LITE_BANS_PERMANENT_IP_MUTE_EMBED_CHANNEL_ID("PermanentIPMute.Embed.ChannelID", "[]"),
    LITE_BANS_PERMANENT_IP_MUTE_EMBED_COLOR("PermanentIPMute.Embed.Color", "#fcba03"),

    // Embed author settings
    LITE_BANS_PERMANENT_IP_MUTE_EMBED_AUTHOR_IMAGEURL("PermanentIPMute.Embed.Author.ImageUrl", "{executorAvatarUrl}"),
    LITE_BANS_PERMANENT_IP_MUTE_EMBED_AUTHOR_NAME("PermanentIPMute.Embed.Author.Name", "Permanent IP mute issued!"),
    LITE_BANS_PERMANENT_IP_MUTE_EMBED_AUTHOR_URL("PermanentIPMute.Embed.Author.Url", ""),

    // Embed thumbnail settings
    LITE_BANS_PERMANENT_IP_MUTE_EMBED_THUMBNAIL("PermanentIPMute.Embed.ThumbnailUrl", ""),
    LITE_BANS_PERMANENT_IP_MUTE_EMBED_TITLE_TEXT("PermanentIPMute.Embed.Title.Text", ""),
    LITE_BANS_PERMANENT_IP_MUTE_TITLE_URL("PermanentIPMute.Embed.Title.Url", ""),

    // Embed description
    LITE_BANS_PERMANENT_IP_MUTE_EMBED_DESCRIPTION("PermanentIPMute.Embed.Description", ""),
    LITE_BANS_PERMANENT_IP_MUTE_EMBED_FIELDS("PermanentIPMute.Embed.Fields", "[]"),
    LITE_BANS_PERMANENT_IP_MUTE_EMBED_IMAGEURL("PermanentIPMute.Embed.ImageUrl", ""),

    // Footer settings
    LITE_BANS_PERMANENT_IP_MUTE_EMBED_FOOTER_TEXT("PermanentIPMute.Embed.Footer.Text", ""),
    LITE_BANS_PERMANENT_IP_MUTE_EMBED_FOOTER_ICONURL("PermanentIPMute.Embed.Footer.IconUrl", ""),
    LITE_BANS_PERMANENT_IP_MUTE_EMBED_TIMESTAMP("PermanentIPMute.Embed.Timestamp", true),

    /*
     * Temporary IP Mute
     */
    LITE_BANS_TEMPORARY_IP_MUTE_EMBED_ENABLED("TemporaryIPMute.Embed.Enabled", true),

    // Main embed settings
    LITE_BANS_TEMPORARY_IP_MUTE_EMBED_CHANNEL_ID("TemporaryIPMute.Embed.ChannelID", "[]"),
    LITE_BANS_TEMPORARY_IP_MUTE_EMBED_COLOR("TemporaryIPMute.Embed.Color", "#fcba03"),

    // Embed author settings
    LITE_BANS_TEMPORARY_IP_MUTE_EMBED_AUTHOR_IMAGEURL("TemporaryIPMute.Embed.Author.ImageUrl", "{executorAvatarUrl}"),
    LITE_BANS_TEMPORARY_IP_MUTE_EMBED_AUTHOR_NAME("TemporaryIPMute.Embed.Author.Name", "Temporary IP mute issued!"),
    LITE_BANS_TEMPORARY_IP_MUTE_EMBED_AUTHOR_URL("TemporaryIPMute.Embed.Author.Url", ""),

    // Embed thumbnail settings
    LITE_BANS_TEMPORARY_IP_MUTE_EMBED_THUMBNAIL("TemporaryIPMute.Embed.ThumbnailUrl", ""),
    LITE_BANS_TEMPORARY_IP_MUTE_EMBED_TITLE_TEXT("TemporaryIPMute.Embed.Title.Text", ""),
    LITE_BANS_TEMPORARY_IP_MUTE_TITLE_URL("TemporaryIPMute.Embed.Title.Url", ""),

    // Embed description
    LITE_BANS_TEMPORARY_IP_MUTE_EMBED_DESCRIPTION("TemporaryIPMute.Embed.Description", ""),
    LITE_BANS_TEMPORARY_IP_MUTE_EMBED_FIELDS("TemporaryIPMute.Embed.Fields", "[]"),
    LITE_BANS_TEMPORARY_IP_MUTE_EMBED_IMAGEURL("TemporaryIPMute.Embed.ImageUrl", ""),

    // Footer settings
    LITE_BANS_TEMPORARY_IP_MUTE_EMBED_FOOTER_TEXT("TemporaryIPMute.Embed.Footer.Text", ""),
    LITE_BANS_TEMPORARY_IP_MUTE_EMBED_FOOTER_ICONURL("TemporaryIPMute.Embed.Footer.IconUrl", ""),
    LITE_BANS_TEMPORARY_IP_MUTE_EMBED_TIMESTAMP("TemporaryIPMute.Embed.Timestamp", true),

    /*
     * Unmute
     */
    LITE_BANS_UNMUTE_EMBED_ENABLED("Unmute.Embed.Enabled", true),

    // Main embed settings
    LITE_BANS_UNMUTE_EMBED_CHANNEL_ID("Unmute.Embed.ChannelID", "[]"),
    LITE_BANS_UNMUTE_EMBED_COLOR("Unmute.Embed.Color", "#fcba03"),

    // Embed author settings
    LITE_BANS_UNMUTE_EMBED_AUTHOR_IMAGEURL("Unmute.Embed.Author.ImageUrl", "{executorAvatarUrl}"),
    LITE_BANS_UNMUTE_EMBED_AUTHOR_NAME("Unmute.Embed.Author.Name", "Unmute issued!"),
    LITE_BANS_UNMUTE_EMBED_AUTHOR_URL("Unmute.Embed.Author.Url", ""),

    // Embed thumbnail settings
    LITE_BANS_UNMUTE_EMBED_THUMBNAIL("Unmute.Embed.ThumbnailUrl", ""),
    LITE_BANS_UNMUTE_EMBED_TITLE_TEXT("Unmute.Embed.Title.Text", ""),
    LITE_BANS_UNMUTE_TITLE_URL("Unmute.Embed.Title.Url", ""),

    // Embed description
    LITE_BANS_UNMUTE_EMBED_DESCRIPTION("Unmute.Embed.Description", ""),
    LITE_BANS_UNMUTE_EMBED_FIELDS("Unmute.Embed.Fields", "[]"),
    LITE_BANS_UNMUTE_EMBED_IMAGEURL("Unmute.Embed.ImageUrl", ""),

    // Footer settings
    LITE_BANS_UNMUTE_EMBED_FOOTER_TEXT("Unmute.Embed.Footer.Text", ""),
    LITE_BANS_UNMUTE_EMBED_FOOTER_ICONURL("Unmute.Embed.Footer.IconUrl", ""),
    LITE_BANS_UNMUTE_EMBED_TIMESTAMP("Unmute.Embed.Timestamp", true),

    /*
     * Kick
     */
    LITE_BANS_KICK_EMBED_ENABLED("Kick.Embed.Enabled", true),

    // Main embed settings
    LITE_BANS_KICK_EMBED_CHANNEL_ID("Kick.Embed.ChannelID", "[]"),
    LITE_BANS_KICK_EMBED_COLOR("Kick.Embed.Color", "#fcba03"),

    // Embed author settings
    LITE_BANS_KICK_EMBED_AUTHOR_IMAGEURL("Kick.Embed.Author.ImageUrl", "{executorAvatarUrl}"),
    LITE_BANS_KICK_EMBED_AUTHOR_NAME("Kick.Embed.Author.Name", "Kick issued!"),
    LITE_BANS_KICK_EMBED_AUTHOR_URL("Kick.Embed.Author.Url", ""),

    // Embed thumbnail settings
    LITE_BANS_KICK_EMBED_THUMBNAIL("Kick.Embed.ThumbnailUrl", ""),
    LITE_BANS_KICK_EMBED_TITLE_TEXT("Kick.Embed.Title.Text", ""),
    LITE_BANS_KICK_TITLE_URL("Kick.Embed.Title.Url", ""),

    // Embed description
    LITE_BANS_KICK_EMBED_DESCRIPTION("Kick.Embed.Description", ""),
    LITE_BANS_KICK_EMBED_FIELDS("Kick.Embed.Fields", "[]"),
    LITE_BANS_KICK_EMBED_IMAGEURL("Kick.Embed.ImageUrl", ""),

    // Footer settings
    LITE_BANS_KICK_EMBED_FOOTER_TEXT("Kick.Embed.Footer.Text", ""),
    LITE_BANS_KICK_EMBED_FOOTER_ICONURL("Kick.Embed.Footer.IconUrl", ""),
    LITE_BANS_KICK_EMBED_TIMESTAMP("Kick.Embed.Timestamp", true),

    /*
     * Warn
     */
    LITE_BANS_WARN_EMBED_ENABLED("Warn.Embed.Enabled", true),

    // Main embed settings
    LITE_BANS_WARN_EMBED_CHANNEL_ID("Warn.Embed.ChannelID", "[]"),
    LITE_BANS_WARN_EMBED_COLOR("Warn.Embed.Color", "#fcba03"),

    // Embed author settings
    LITE_BANS_WARN_EMBED_AUTHOR_IMAGEURL("Warn.Embed.Author.ImageUrl", "{executorAvatarUrl}"),
    LITE_BANS_WARN_EMBED_AUTHOR_NAME("Warn.Embed.Author.Name", "Warning issued!"),
    LITE_BANS_WARN_EMBED_AUTHOR_URL("Warn.Embed.Author.Url", ""),

    // Embed thumbnail settings
    LITE_BANS_WARN_EMBED_THUMBNAIL("Warn.Embed.ThumbnailUrl", ""),
    LITE_BANS_WARN_EMBED_TITLE_TEXT("Warn.Embed.Title.Text", ""),
    LITE_BANS_WARN_TITLE_URL("Warn.Embed.Title.Url", ""),

    // Embed description
    LITE_BANS_WARN_EMBED_DESCRIPTION("Warn.Embed.Description", ""),
    LITE_BANS_WARN_EMBED_FIELDS("Warn.Embed.Fields", "[]"),
    LITE_BANS_WARN_EMBED_IMAGEURL("Warn.Embed.ImageUrl", ""),

    // Footer settings
    LITE_BANS_WARN_EMBED_FOOTER_TEXT("Warn.Embed.Footer.Text", ""),
    LITE_BANS_WARN_EMBED_FOOTER_ICONURL("Warn.Embed.Footer.IconUrl", ""),
    LITE_BANS_WARN_EMBED_TIMESTAMP("Warn.Embed.Timestamp", true),

    /*
     * Unwarn
     */
    LITE_BANS_UNWARN_EMBED_ENABLED("Unwarn.Embed.Enabled", true),

    // Main embed settings
    LITE_BANS_UNWARN_EMBED_CHANNEL_ID("Unwarn.Embed.ChannelID", "[]"),
    LITE_BANS_UNWARN_EMBED_COLOR("Unwarn.Embed.Color", "#fcba03"),

    // Embed author settings
    LITE_BANS_UNWARN_EMBED_AUTHOR_IMAGEURL("Unwarn.Embed.Author.ImageUrl", "{executorAvatarUrl}"),
    LITE_BANS_UNWARN_EMBED_AUTHOR_NAME("Unwarn.Embed.Author.Name", "Unwarn issued!"),
    LITE_BANS_UNWARN_EMBED_AUTHOR_URL("Unwarn.Embed.Author.Url", ""),

    // Embed thumbnail settings
    LITE_BANS_UNWARN_EMBED_THUMBNAIL("Unwarn.Embed.ThumbnailUrl", ""),
    LITE_BANS_UNWARN_EMBED_TITLE_TEXT("Unwarn.Embed.Title.Text", ""),
    LITE_BANS_UNWARN_TITLE_URL("Unwarn.Embed.Title.Url", ""),

    // Embed description
    LITE_BANS_UNWARN_EMBED_DESCRIPTION("Unwarn.Embed.Description", ""),
    LITE_BANS_UNWARN_EMBED_FIELDS("Unwarn.Embed.Fields", "[]"),
    LITE_BANS_UNWARN_EMBED_IMAGEURL("Unwarn.Embed.ImageUrl", ""),

    // Footer settings
    LITE_BANS_UNWARN_EMBED_FOOTER_TEXT("Unwarn.Embed.Footer.Text", ""),
    LITE_BANS_UNWARN_EMBED_FOOTER_ICONURL("Unwarn.Embed.Footer.IconUrl", ""),
    LITE_BANS_UNWARN_EMBED_TIMESTAMP("Unwarn.Embed.Timestamp", true);

    public String path;
    public Object value;

    LiteBansDefaults(String path, Object value) {
        this.path = path;
        this.value = value;
    }

    public String getPath() {
        return path;
    }

    public Object getValue() {
        return value;
    }
}
