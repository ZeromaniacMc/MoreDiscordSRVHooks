package me.zeromaniac.config.enums;

public enum PlayerShopGUIPlusDefaults implements EnumGeneral {

    
    SHORTEN_PRICES("ShortenPrices" ,"false"),

    /*
     * NEW SALE
     */

    IS_NEW_SALE_EMBED_ENABLED("NewSale.Embed.Enabled", true),

    // Main embed settings
    NEW_SALE_EMBED_CHANNEL_ID("NewSale.Embed.ChannelID","0000000000"),
    NEW_SALE_EMBED_COLOR("NewSale.Embed.Color","#fcba03"),

    // Embed author settings
    NEW_SALE_EMBED_AUTHOR_IMAGEURL("NewSale.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    NEW_SALE_EMBED_AUTHOR_NAME("NewSale.Embed.Author.Name","**[ New Sale! ]**"),
    NEW_SALE_EMBED_AUTHOR_URL("NewSale.Embed.Author.Url",""),

    // Embed thumbnail settings
    NEW_SALE_EMBED_THUMBNAIL("NewSale.Embed.ThumbnailUrl","{itemImageUrl}"),
    NEW_SALE_EMBED_TITLE_TEXT("NewSale.Embed.Title.Text",""),
    NEW_SALE_EMBED_TITLE_URL("NewSale.Embed.Title.Url",""),

    // Embed description
    NEW_SALE_EMBED_DESCRIPTION("NewSale.Embed.Description","{player} put up {quantity} x {item} for sale for {price}!"),
    NEW_SALE_EMBED_FIELDS("NewSale.Embed.Fields","[]"),
    NEW_SALE_EMBED_IMAGEURL("NewSale.Embed.ImageUrl","{loreImageUrl}"),

    // Footer settings
    NEW_SALE_EMBED_FOOTER_TEXT("NewSale.Embed.Footer.Text",""),
    NEW_SALE_EMBED_FOOTER_ICONURL("NewSale.Embed.Footer.IconUrl",""),
    NEW_SALE_EMBED_TIMESTAMP("NewSale.Embed.Timestamp",true),

    /*
     * SALE END EXPIRED
     */

    SALE_END_EXPIRED_EMBED_ENABLED("SaleEndExpired.Embed.Enabled", true),

    // Main embed settings
    SALE_END_EXPIRED_EMBED_CHANNEL_ID("SaleEndExpired.Embed.ChannelID","0000000000"),
    SALE_END_EXPIRED_EMBED_COLOR("SaleEndExpired.Embed.Color","#fcba03"),

    // Embed author settings
    SALE_END_EXPIRED_EMBED_AUTHOR_IMAGEURL("SaleEndExpired.Embed.Author.ImageUrl","{buyerAvatarUrl}"),
    SALE_END_EXPIRED_EMBED_AUTHOR_NAME("SaleEndExpired.Embed.Author.Name","**[ Sale Expired! ]**"),
    SALE_END_EXPIRED_EMBED_AUTHOR_URL("SaleEndExpired.Embed.Author.Url",""),

    // Embed thumbnail settings
    SALE_END_EXPIRED_EMBED_THUMBNAIL("SaleEndExpired.Embed.ThumbnailUrl","{itemImageUrl}"),
    SALE_END_EXPIRED_EMBED_TITLE_TEXT("SaleEndExpired.Embed.Title.Text",""),
    SALE_END_EXPIRED_EMBED_TITLE_URL("SaleEndExpired.Embed.Title.Url",""),

    // Embed description
    SALE_END_EXPIRED_EMBED_DESCRIPTION("SaleEndExpired.Embed.Description","{owner}'s sale offer (%quantity% x %item%) has expired."),
    SALE_END_EXPIRED_EMBED_FIELDS("SaleEndExpired.Embed.Fields","[]"),
    SALE_END_EXPIRED_EMBED_IMAGEURL("SaleEndExpired.Embed.ImageUrl","{loreImageUrl}"),

    // Footer settings
    SALE_END_EXPIRED_EMBED_FOOTER_TEXT("SaleEndExpired.Embed.Footer.Text",""),
    SALE_END_EXPIRED_EMBED_FOOTER_ICONURL("SaleEndExpired.Embed.Footer.IconUrl",""),
    SALE_END_EXPIRED_EMBED_TIMESTAMP("SaleEndExpired.Embed.Timestamp",true),

    /*
     * SALE END BOUGHT
     */

    SALE_END_BOUGHT_EMBED_ENABLED("SaleEndBought.Embed.Enabled", true),

    // Main embed settings
    SALE_END_BOUGHT_EMBED_CHANNEL_ID("SaleEndBought.Embed.ChannelID","0000000000"),
    SALE_END_BOUGHT_EMBED_COLOR("SaleEndBought.Embed.Color","#fcba03"),

    // Embed author settings
    SALE_END_BOUGHT_EMBED_AUTHOR_IMAGEURL("SaleEndBought.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    SALE_END_BOUGHT_EMBED_AUTHOR_NAME("SaleEndBought.Embed.Author.Name","**[ Sale Ended! ]**"),
    SALE_END_BOUGHT_EMBED_AUTHOR_URL("SaleEndBought.Embed.Author.Url",""),

    // Embed thumbnail settings
    SALE_END_BOUGHT_EMBED_THUMBNAIL("SaleEndBought.Embed.ThumbnailUrl","{itemImageUrl}"),
    SALE_END_BOUGHT_EMBED_TITLE_TEXT("SaleEndBought.Embed.Title.Text",""),
    SALE_END_BOUGHT_EMBED_TITLE_URL("SaleEndBought.Embed.Title.Url",""),

    // Embed description
    SALE_END_BOUGHT_EMBED_DESCRIPTION("SaleEndBought.Embed.Description","{buyer} bought {quantity} x {item} from {owner} for {price}."),
    SALE_END_BOUGHT_EMBED_FIELDS("SaleEndBought.Embed.Fields","[]"),
    SALE_END_BOUGHT_EMBED_IMAGEURL("SaleEndBought.Embed.ImageUrl","{loreImageUrl}"),

    // Footer settings
    SALE_END_BOUGHT_EMBED_FOOTER_TEXT("SaleEndBought.Embed.Footer.Text",""),
    SALE_END_BOUGHT_EMBED_FOOTER_ICONURL("SaleEndBought.Embed.Footer.IconUrl",""),
    SALE_END_BOUGHT_EMBED_TIMESTAMP("SaleEndBought.Embed.Timestamp",true);

    public String path;
    public Object value;

    PlayerShopGUIPlusDefaults(String path, Object value) {
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
