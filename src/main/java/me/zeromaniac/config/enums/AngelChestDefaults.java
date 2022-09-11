package me.zeromaniac.config.enums;

public enum AngelChestDefaults implements EnumGeneral{

    /*
     * NEW ANGEL CHEST SPAWNED
     */

    IS_ANGEL_CHEST_SPAWNED_EMBED_ENABLED("AngelChestSpawned.Embed.Enabled", true),

    // Main embed settings
    ANGEL_CHEST_SPAWNED_EMBED_CHANNEL_ID("AngelChestSpawned.Embed.ChannelID", "0000000000"),
    ANGEL_CHEST_SPAWNED_EMBED_COLOR("AngelChestSpawned.Embed.Color","#fcba03"),

    // Embed author settings
    ANGEL_CHEST_SPAWNED_EMBED_AUTHOR_IMAGEURL("AngelChestSpawned.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    ANGEL_CHEST_SPAWNED_EMBED_AUTHOR_NAME("AngelChestSpawned.Embed.Author.Name","**Oops, looks like someone died!**"),
    ANGEL_CHEST_SPAWNED_EMBED_AUTHOR_URL("AngelChestSpawned.Embed.Author.Url",""),

    // Embed thumbnail settings
    ANGEL_CHEST_SPAWNED_EMBED_THUMBNAIL("AngelChestSpawned.Embed.ThumbnailUrl",""),
    ANGEL_CHEST_SPAWNED_EMBED_TITLE_TEXT("AngelChestSpawned.Embed.Title.Text",""),
    NEW_AUCTION_EMBED_TITLE_URL("AngelChestSpawned.Embed.Title.Url",""),

    // Embed description
    ANGEL_CHEST_SPAWNED_EMBED_DESCRIPTION("AngelChestSpawned.Embed.Description","{player}'s Angel Chest spawned!"),
    ANGEL_CHEST_SPAWNED_EMBED_FIELDS("AngelChestSpawned.Embed.Fields","[]"),
    ANGEL_CHEST_SPAWNED_EMBED_IMAGEURL("AngelChestSpawned.Embed.ImageUrl","{inventoryImageUrl}"),

    // Footer settings
    ANGEL_CHEST_SPAWNED_EMBED_FOOTER_TEXT("AngelChestSpawned.Embed.Footer.Text",""),
    ANGEL_CHEST_SPAWNED_EMBED_FOOTER_ICONURL("AngelChestSpawned.Embed.Footer.IconUrl",""),
    ANGEL_CHEST_SPAWNED_EMBED_TIMESTAMP("AngelChestSpawned.Embed.Timestamp",true);



    public String path;
    public Object value;

    AngelChestDefaults(String path, Object value) {
        this.path = path;
        this.value = value;
    }

    public String getPath(){
        return path;
    }
    public Object getValue(){
        return value;
    }
}
