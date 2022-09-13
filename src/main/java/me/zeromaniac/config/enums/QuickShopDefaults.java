package me.zeromaniac.config.enums;

public enum QuickShopDefaults implements EnumGeneral{


    SHORTEN_PRICES("ShortenPrices" ,"false"),
    
    /*
     * NEW SHOP CREATED
     */

    IS_NEW_SHOP_CREATED_EMBED_ENABLED("NewShopCreated.Embed.Enabled", true),

    // Main embed settings
    NEW_SHOP_CREATED_EMBED_CHANNEL_ID("NewShopCreated.Embed.ChannelID", "0000000000"),
    NEW_SHOP_CREATED_EMBED_COLOR("NewShopCreated.Embed.Color","#fcba03"),

    // Embed author settings
    NEW_SHOP_CREATED_EMBED_AUTHOR_IMAGEURL("NewShopCreated.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    NEW_SHOP_CREATED_EMBED_AUTHOR_NAME("NewShopCreated.Embed.Author.Name","**Oops, looks like someone died!**"),
    NEW_SHOP_CREATED_EMBED_AUTHOR_URL("NewShopCreated.Embed.Author.Url",""),

    // Embed thumbnail settings
    NEW_SHOP_CREATED_EMBED_THUMBNAIL("NewShopCreated.Embed.ThumbnailUrl",""),
    NEW_SHOP_CREATED_EMBED_TITLE_TEXT("NewShopCreated.Embed.Title.Text",""),
    NEW_SHOP_CREATED_EMBED_TITLE_URL("NewShopCreated.Embed.Title.Url",""),

    // Embed description
    NEW_SHOP_CREATED_EMBED_DESCRIPTION("NewShopCreated.Embed.Description","{player}'s Angel Chest spawned!"),
    NEW_SHOP_CREATED_EMBED_FIELDS("NewShopCreated.Embed.Fields","[]"),
    NEW_SHOP_CREATED_EMBED_IMAGEURL("NewShopCreated.Embed.ImageUrl","{inventoryImageUrl}"),

    // Footer settings
    NEW_SHOP_CREATED_EMBED_FOOTER_TEXT("NewShopCreated.Embed.Footer.Text",""),
    NEW_SHOP_CREATED_EMBED_FOOTER_ICONURL("NewShopCreated.Embed.Footer.IconUrl",""),
    NEW_SHOP_CREATED_EMBED_TIMESTAMP("NewShopCreated.Embed.Timestamp",true);



    public String path;
    public Object value;

    QuickShopDefaults(String path, Object value) {
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
