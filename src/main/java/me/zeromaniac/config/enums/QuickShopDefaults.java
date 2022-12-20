package me.zeromaniac.config.enums;

public enum QuickShopDefaults implements EnumGeneral{


    SHORTEN_PRICES("ShortenPrices" ,"false"),
    TYPE_BUYING("Type.Buying","Buying"),
    TYPE_SELLING("Type.Selling","Selling"),
    ACTION_BOUGHT("Action.Bought","bough"),
    ACTION_SOLD("Action.Sold","sold"),
    DIRECTION_TO("Direction.To","to"),
    DIRECTION_FROM("Direction.From","from"),
    
    /*
     * NEW SHOP CREATED
     */

    IS_NEW_SHOP_CREATED_EMBED_ENABLED("NewShopCreated.Embed.Enabled", true),

    // Main embed settings
    NEW_SHOP_CREATED_EMBED_CHANNEL_ID("NewShopCreated.Embed.ChannelID", "[]"),
    NEW_SHOP_CREATED_EMBED_COLOR("NewShopCreated.Embed.Color","#fcba03"),

    // Embed author settings
    NEW_SHOP_CREATED_EMBED_AUTHOR_IMAGEURL("NewShopCreated.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    NEW_SHOP_CREATED_EMBED_AUTHOR_NAME("NewShopCreated.Embed.Author.Name","{player} 𝖈𝖗𝖊𝖆𝖙𝖊𝖉 𝖆 𝖈𝖍𝖊𝖘𝖙 𝖘𝖍𝖔𝖕"),
    NEW_SHOP_CREATED_EMBED_AUTHOR_URL("NewShopCreated.Embed.Author.Url",""),

    // Embed thumbnail settings
    NEW_SHOP_CREATED_EMBED_THUMBNAIL("NewShopCreated.Embed.ThumbnailUrl","{itemImageUrl}"),
    NEW_SHOP_CREATED_EMBED_TITLE_TEXT("NewShopCreated.Embed.Title.Text","{type}: {item} for {singleItemPriceBeforeTax}€ in {chestWorld}"),
    NEW_SHOP_CREATED_EMBED_TITLE_URL("NewShopCreated.Embed.Title.Url",""),

    // Embed description
    NEW_SHOP_CREATED_EMBED_DESCRIPTION("NewShopCreated.Embed.Description",""),
    NEW_SHOP_CREATED_EMBED_FIELDS("NewShopCreated.Embed.Fields","[]"),
    NEW_SHOP_CREATED_EMBED_IMAGEURL("NewShopCreated.Embed.ImageUrl",""),

    // Footer settings
    NEW_SHOP_CREATED_EMBED_FOOTER_TEXT("NewShopCreated.Embed.Footer.Text",""),
    NEW_SHOP_CREATED_EMBED_FOOTER_ICONURL("NewShopCreated.Embed.Footer.IconUrl",""),
    NEW_SHOP_CREATED_EMBED_TIMESTAMP("NewShopCreated.Embed.Timestamp",true),

    /*
     * PURCHASE FROM SHOP
     */

    IS_PURCHASE_EMBED_ENABLED("Purchase.Embed.Enabled", true),

    // Main embed settings
    PURCHASE_EMBED_CHANNEL_ID("Purchase.Embed.ChannelID", "[]"),
    PURCHASE_EMBED_COLOR("Purchase.Embed.Color","#fcba03"),

    // Embed author settings
    PURCHASE_EMBED_AUTHOR_IMAGEURL("Purchase.Embed.Author.ImageUrl","{buyerAvatarUrl}"),
    PURCHASE_EMBED_AUTHOR_NAME("Purchase.Embed.Author.Name","𝕾𝖍𝖔𝖕 𝖙𝖗𝖆𝖓𝖘𝖆𝖈𝖙𝖎𝖔𝖓"),
    PURCHASE_EMBED_AUTHOR_URL("Purchase.Embed.Author.Url",""),

    // Embed thumbnail settings
    PURCHASE_EMBED_THUMBNAIL("Purchase.Embed.ThumbnailUrl","{itemImageUrl}"),
    PURCHASE_EMBED_TITLE_TEXT("Purchase.Embed.Title.Text","{buyer} {action} {amount} {item} {fromto} {player}''s shop"),
    PURCHASE_EMBED_TITLE_URL("Purchase.Embed.Title.Url",""),

    // Embed description
    PURCHASE_EMBED_DESCRIPTION("Purchase.Embed.Description",""),
    PURCHASE_EMBED_FIELDS("Purchase.Embed.Fields","[]"),
    PURCHASE_EMBED_IMAGEURL("Purchase.Embed.ImageUrl","{loreImageUrl}"),

    // Footer settings
    PURCHASE_EMBED_FOOTER_TEXT("Purchase.Embed.Footer.Text",""),
    PURCHASE_EMBED_FOOTER_ICONURL("Purchase.Embed.Footer.IconUrl",""),
    PURCHASE_EMBED_TIMESTAMP("Purchase.Embed.Timestamp",true);



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
