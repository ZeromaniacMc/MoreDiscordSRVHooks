package me.zeromaniac.config.enums;

public enum AuctionHouseDefaults implements EnumGeneral {
    SHORTEN_PRICES("ShortenPrices" ,"false"),

    /*
     * NEW SALE
     */

    IS_NEW_SALE_EMBED_ENABLED("NewAuction.Embed.Enabled", true),

    // Main embed settings
    NEW_SALE_EMBED_CHANNEL_ID("NewAuction.Embed.ChannelID","[]"),
    NEW_SALE_EMBED_COLOR("NewAuction.Embed.Color","#fcba03"),

    // Embed author settings
    NEW_SALE_EMBED_AUTHOR_IMAGEURL("NewAuction.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    NEW_SALE_EMBED_AUTHOR_NAME("NewAuction.Embed.Author.Name","**[ New Sale! ]**"),
    NEW_SALE_EMBED_AUTHOR_URL("NewAuction.Embed.Author.Url",""),

    // Embed thumbnail settings
    NEW_SALE_EMBED_THUMBNAIL("NewAuction.Embed.ThumbnailUrl","{itemImageUrl}"),
    NEW_SALE_EMBED_TITLE_TEXT("NewAuction.Embed.Title.Text",""),
    NEW_SALE_EMBED_TITLE_URL("NewAuction.Embed.Title.Url",""),

    // Embed description
    NEW_SALE_EMBED_DESCRIPTION("NewAuction.Embed.Description","{player} put up {quantity} x {item} for an auction!"),
    NEW_SALE_EMBED_FIELDS("NewAuction.Embed.Fields","[]"),
    NEW_SALE_EMBED_IMAGEURL("NewAuction.Embed.ImageUrl","{loreImageUrl}"),

    // Footer settings
    NEW_SALE_EMBED_FOOTER_TEXT("NewAuction.Embed.Footer.Text",""),
    NEW_SALE_EMBED_FOOTER_ICONURL("NewAuction.Embed.Footer.IconUrl",""),
    NEW_SALE_EMBED_TIMESTAMP("NewAuction.Embed.Timestamp",true),

    /*
     * AUCTION SOLD
     */

    SALE_END_EXPIRED_EMBED_ENABLED("AuctionSold.Embed.Enabled", true),

    // Main embed settings
    SALE_END_EXPIRED_EMBED_CHANNEL_ID("AuctionSold.Embed.ChannelID","[]"),
    SALE_END_EXPIRED_EMBED_COLOR("AuctionSold.Embed.Color","#fcba03"),

    // Embed author settings
    SALE_END_EXPIRED_EMBED_AUTHOR_IMAGEURL("AuctionSold.Embed.Author.ImageUrl","{buyerAvatarUrl}"),
    SALE_END_EXPIRED_EMBED_AUTHOR_NAME("AuctionSold.Embed.Author.Name","**[ Sale ended! ]**"),
    SALE_END_EXPIRED_EMBED_AUTHOR_URL("AuctionSold.Embed.Author.Url",""),

    // Embed thumbnail settings
    SALE_END_EXPIRED_EMBED_THUMBNAIL("AuctionSold.Embed.ThumbnailUrl","{itemImageUrl}"),
    SALE_END_EXPIRED_EMBED_TITLE_TEXT("AuctionSold.Embed.Title.Text",""),
    SALE_END_EXPIRED_EMBED_TITLE_URL("AuctionSold.Embed.Title.Url",""),

    // Embed description
    SALE_END_EXPIRED_EMBED_DESCRIPTION("AuctionSold.Embed.Description","{buyer} bought {quantity} x {item} for ${price}."),
    SALE_END_EXPIRED_EMBED_FIELDS("AuctionSold.Embed.Fields","[]"),
    SALE_END_EXPIRED_EMBED_IMAGEURL("AuctionSold.Embed.ImageUrl","{loreImageUrl}"),

    // Footer settings
    SALE_END_EXPIRED_EMBED_FOOTER_TEXT("AuctionSold.Embed.Footer.Text",""),
    SALE_END_EXPIRED_EMBED_FOOTER_ICONURL("AuctionSold.Embed.Footer.IconUrl",""),
    SALE_END_EXPIRED_EMBED_TIMESTAMP("AuctionSold.Embed.Timestamp",true),

    /*
     * SALE EXPIRED
     */

    SALE_END_BOUGHT_EMBED_ENABLED("AuctionExpired.Embed.Enabled", true),

    // Main embed settings
    SALE_END_BOUGHT_EMBED_CHANNEL_ID("AuctionExpired.Embed.ChannelID","[]"),
    SALE_END_BOUGHT_EMBED_COLOR("AuctionExpired.Embed.Color","#fcba03"),

    // Embed author settings
    SALE_END_BOUGHT_EMBED_AUTHOR_IMAGEURL("AuctionExpired.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    SALE_END_BOUGHT_EMBED_AUTHOR_NAME("AuctionExpired.Embed.Author.Name","**[ Sale Expired! ]**"),
    SALE_END_BOUGHT_EMBED_AUTHOR_URL("AuctionExpired.Embed.Author.Url",""),

    // Embed thumbnail settings
    SALE_END_BOUGHT_EMBED_THUMBNAIL("AuctionExpired.Embed.ThumbnailUrl","{itemImageUrl}"),
    SALE_END_BOUGHT_EMBED_TITLE_TEXT("AuctionExpired.Embed.Title.Text",""),
    SALE_END_BOUGHT_EMBED_TITLE_URL("AuctionExpired.Embed.Title.Url",""),

    // Embed description
    SALE_END_BOUGHT_EMBED_DESCRIPTION("AuctionExpired.Embed.Description","{player}'s auction of {quantity} x {item} expired."),
    SALE_END_BOUGHT_EMBED_FIELDS("AuctionExpired.Embed.Fields","[]"),
    SALE_END_BOUGHT_EMBED_IMAGEURL("AuctionExpired.Embed.ImageUrl","{loreImageUrl}"),

    // Footer settings
    SALE_END_BOUGHT_EMBED_FOOTER_TEXT("AuctionExpired.Embed.Footer.Text",""),
    SALE_END_BOUGHT_EMBED_FOOTER_ICONURL("AuctionExpired.Embed.Footer.IconUrl",""),
    SALE_END_BOUGHT_EMBED_TIMESTAMP("AuctionExpired.Embed.Timestamp",true);

    public String path;
    public Object value;

    AuctionHouseDefaults(String path, Object value) {
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
