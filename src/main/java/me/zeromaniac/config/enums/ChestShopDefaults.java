package me.zeromaniac.config.enums;

public enum ChestShopDefaults implements EnumGeneral{

    /*
     * NEW CHEST SHOP MADE
     */

    IS_NEW_CHEST_SHOP_EMBED_ENABLED("NewChestShop.Embed.Enabled", true),

    // Main embed settings
    NEW_CHEST_SHOP_EMBED_CHANNEL_ID("NewChestShop.Embed.ChannelID", "0000000000"),
    NEW_CHEST_SHOP_EMBED_COLOR("NewChestShop.Embed.Color","#fcba03"),

    // Embed author settings
    NEW_CHEST_SHOP_EMBED_AUTHOR_IMAGEURL("NewChestShop.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    NEW_CHEST_SHOP_EMBED_AUTHOR_NAME("NewChestShop.Embed.Author.Name","**Oops, looks like someone died!**"),
    NEW_CHEST_SHOP_EMBED_AUTHOR_URL("NewChestShop.Embed.Author.Url",""),

    // Embed thumbnail settings
    NEW_CHEST_SHOP_EMBED_THUMBNAIL("NewChestShop.Embed.ThumbnailUrl",""),
    NEW_CHEST_SHOP_EMBED_TITLE_TEXT("NewChestShop.Embed.Title.Text",""),
    NEW_CHEST_SHOP_TITLE_URL("NewChestShop.Embed.Title.Url",""),

    // Embed description
    NEW_CHEST_SHOP_EMBED_DESCRIPTION("NewChestShop.Embed.Description","{player}'s Angel Chest spawned!"),
    NEW_CHEST_SHOP_EMBED_FIELDS("NewChestShop.Embed.Fields","[]"),
    NEW_CHEST_SHOP_EMBED_IMAGEURL("NewChestShop.Embed.ImageUrl","{inventoryImageUrl}"),

    // Footer settings
    NEW_CHEST_SHOP_EMBED_FOOTER_TEXT("NewChestShop.Embed.Footer.Text",""),
    NEW_CHEST_SHOP_EMBED_FOOTER_ICONURL("NewChestShop.Embed.Footer.IconUrl",""),
    NEW_CHEST_SHOP_EMBED_TIMESTAMP("NewChestShop.Embed.Timestamp",true);



    public String path;
    public Object value;

    ChestShopDefaults(String path, Object value) {
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
