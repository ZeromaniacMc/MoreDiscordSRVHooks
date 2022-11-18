package me.zeromaniac.config.enums;

public enum PlayerWarpsDefaults implements EnumGeneral {

    SHORTEN_PRICES("ShortenPrices", "false"),

    /*
     * NEW WARP CREATED
     */

    NEW_WARP_CREATED_EMBED_ENABLED("NewWarpCreated.Embed.Enabled", true),

    // Main embed settings
    NEW_WARP_CREATED_EMBED_CHANNEL_ID("NewWarpCreated.Embed.ChannelID", "[]"),
    NEW_WARP_CREATED_EMBED_COLOR("NewWarpCreated.Embed.Color", "#fcba03"),

    // Embed author settings
    NEW_WARP_CREATED_EMBED_AUTHOR_IMAGEURL("NewWarpCreated.Embed.Author.ImageUrl", "{playerAvatarUrl}"),
    NEW_WARP_CREATED_EMBED_AUTHOR_NAME("NewWarpCreated.Embed.Author.Name",
            "{player} created a new warp called {warpname} for {price}€!"),
    NEW_WARP_CREATED_EMBED_AUTHOR_URL("NewWarpCreated.Embed.Author.Url", ""),

    // Embed thumbnail settings
    NEW_WARP_CREATED_EMBED_THUMBNAIL("NewWarpCreated.Embed.ThumbnailUrl", "{warpImageUrl}"),
    NEW_WARP_CREATED_EMBED_TITLE_TEXT("NewWarpCreated.Embed.Title.Text", ""),
    NEW_WARP_CREATED_TITLE_URL("NewWarpCreated.Embed.Title.Url", ""),

    // Embed description
    NEW_WARP_CREATED_EMBED_DESCRIPTION("NewWarpCreated.Embed.Description", ""),
    NEW_WARP_CREATED_EMBED_FIELDS("NewWarpCreated.Embed.Fields", "[]"),
    NEW_WARP_CREATED_EMBED_IMAGEURL("NewWarpCreated.Embed.ImageUrl", "{categoryImageUrl}"),

    // Footer settings
    NEW_WARP_CREATED_EMBED_FOOTER_TEXT("NewWarpCreated.Embed.Footer.Text", ""),
    NEW_WARP_CREATED_EMBED_FOOTER_ICONURL("NewWarpCreated.Embed.Footer.IconUrl", ""),
    NEW_WARP_CREATED_EMBED_TIMESTAMP("NewWarpCreated.Embed.Timestamp", true),

    /*
     * TELEPORT
     */

    TELEPORT_EMBED_ENABLED("Teleport.Embed.Enabled", true),

    // Main embed settings
    TELEPORT_EMBED_CHANNEL_ID("Teleport.Embed.ChannelID", "[]"),
    TELEPORT_EMBED_COLOR("Teleport.Embed.Color", "#fcba03"),

    // Embed author settings
    TELEPORT_EMBED_AUTHOR_IMAGEURL("Teleport.Embed.Author.ImageUrl", "{visitorAvatarUrl}"),
    TELEPORT_EMBED_AUTHOR_NAME("Teleport.Embed.Author.Name", "{visitorName} is visiting {player}'s warp {warpname}!"),
    TELEPORT_EMBED_AUTHOR_URL("Teleport.Embed.Author.Url", ""),

    // Embed thumbnail settings
    TELEPORT_EMBED_THUMBNAIL("Teleport.Embed.ThumbnailUrl", "{warpImageUrl}"),
    TELEPORT_EMBED_TITLE_TEXT("Teleport.Embed.Title.Text", ""),
    TELEPORT_TITLE_URL("Teleport.Embed.Title.Url", ""),

    // Embed description
    TELEPORT_EMBED_DESCRIPTION("Teleport.Embed.Description", ""),
    TELEPORT_EMBED_FIELDS("Teleport.Embed.Fields", "[]"),
    TELEPORT_EMBED_IMAGEURL("Teleport.Embed.ImageUrl", "{categoryImageUrl}"),

    // Footer settings
    TELEPORT_EMBED_FOOTER_TEXT("Teleport.Embed.Footer.Text", ""),
    TELEPORT_EMBED_FOOTER_ICONURL("Teleport.Embed.Footer.IconUrl", ""),
    TELEPORT_EMBED_TIMESTAMP("Teleport.Embed.Timestamp", true),

    /*
     * WARP REMOVED
     */

    WARP_REMOVED_EMBED_ENABLED("WarpRemoved.Embed.Enabled", true),

    // Main embed settings
    WARP_REMOVED_EMBED_CHANNEL_ID("WarpRemoved.Embed.ChannelID", "[]"),
    WARP_REMOVED_EMBED_COLOR("WarpRemoved.Embed.Color", "#fcba03"),

    // Embed author settings
    WARP_REMOVED_EMBED_AUTHOR_IMAGEURL("WarpRemoved.Embed.Author.ImageUrl", "{playerAvatarUrl}"),
    WARP_REMOVED_EMBED_AUTHOR_NAME("WarpRemoved.Embed.Author.Name", "{player} deleted their warp called {warpname}!"),
    WARP_REMOVED_EMBED_AUTHOR_URL("WarpRemoved.Embed.Author.Url", ""),

    // Embed thumbnail settings
    WARP_REMOVED_EMBED_THUMBNAIL("WarpRemoved.Embed.ThumbnailUrl", "{warpImageUrl}"),
    WARP_REMOVED_EMBED_TITLE_TEXT("WarpRemoved.Embed.Title.Text", ""),
    WARP_REMOVED_TITLE_URL("WarpRemoved.Embed.Title.Url", ""),

    // Embed description
    WARP_REMOVED_EMBED_DESCRIPTION("WarpRemoved.Embed.Description", ""),
    WARP_REMOVED_EMBED_FIELDS("WarpRemoved.Embed.Fields", "[]"),
    WARP_REMOVED_EMBED_IMAGEURL("WarpRemoved.Embed.ImageUrl", "{categoryImageUrl}"),

    // Footer settings
    WARP_REMOVED_EMBED_FOOTER_TEXT("WarpRemoved.Embed.Footer.Text", ""),
    WARP_REMOVED_EMBED_FOOTER_ICONURL("WarpRemoved.Embed.Footer.IconUrl", ""),
    WARP_REMOVED_EMBED_TIMESTAMP("WarpRemoved.Embed.Timestamp", true);

    public String path;
    public Object value;

    PlayerWarpsDefaults(String path, Object value) {
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
