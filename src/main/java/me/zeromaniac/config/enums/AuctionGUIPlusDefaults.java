package me.zeromaniac.config.enums;

public enum AuctionGUIPlusDefaults implements EnumGeneral {

    SHORTEN_PRICES("ShortenPrices" ,"false"),
    
    /*
    * NEW AUCTION
    */

    IS_NEW_AUCTION_EMBED_ENABLED("NewAuction.Embed.Enabled", true),

    // Main embed settings
    NEW_AUCTION_EMBED_CHANNEL_ID("NewAuction.Embed.ChannelID", "[]"),
    NEW_AUCTION_EMBED_COLOR("NewAuction.Embed.Color","#fcba03"),

    // Embed author settings
    NEW_AUCTION_EMBED_AUTHOR_IMAGEURL("NewAuction.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    NEW_AUCTION_EMBED_AUTHOR_NAME("NewAuction.Embed.Author.Name","**[ New Auction! ]**"),
    NEW_AUCTION_EMBED_AUTHOR_URL("NewAuction.Embed.Author.Url",""),

    // Embed thumbnail settings
    NEW_AUCTION_EMBED_THUMBNAIL("NewAuction.Embed.ThumbnailUrl","{itemImageUrl}"),
    NEW_AUCTION_EMBED_TITLE_TEXT("NewAuction.Embed.Title.Text",""),
    NEW_AUCTION_EMBED_TITLE_URL("NewAuction.Embed.Title.Url",""),

    // Embed description
    NEW_AUCTION_EMBED_DESCRIPTION("NewAuction.Embed.Description","{player} put up {quantity} x {item} for an auction #{id}! Starting price: ${startingprice}, bid increment: ${increment}, duration: {duration}"),
    NEW_AUCTION_EMBED_FIELDS("NewAuction.Embed.Fields","[]"),
    NEW_AUCTION_EMBED_IMAGEURL("NewAuction.Embed.ImageUrl","{loreImageUrl}"),

    // Footer settings
    NEW_AUCTION_EMBED_FOOTER_TEXT("NewAuction.Embed.Footer.Text",""),
    NEW_AUCTION_EMBED_FOOTER_ICONURL("NewAuction.Embed.Footer.IconUrl",""),
    NEW_AUCTION_EMBED_TIMESTAMP("NewAuction.Embed.Timestamp",true),

    /*
     * AUCTION BID
     */

    IS_AUCTION_BID_EMBED_ENABLED("AuctionBid.Embed.Enabled", true),

    // Main embed settings
    AUCTION_BID_EMBED_CHANNEL_ID("AuctionBid.Embed.ChannelID", "[]"),
    AUCTION_BID_EMBED_COLOR("AuctionBid.Embed.Color","#fcba03"),

    // Embed author settings
    AUCTION_BID_EMBED_AUTHOR_IMAGEURL("AuctionBid.Embed.Author.ImageUrl","{bidderAvatarUrl}"),
    AUCTION_BID_EMBED_AUTHOR_NAME("AuctionBid.Embed.Author.Name","**[ New Bid! ]**"),
    AUCTION_BID_EMBED_AUTHOR_Url("AuctionBid.Embed.Author.Url",""),

    // Embed thumbnail settings
    AUCTION_BID_EMBED_THUMBNAIL("AuctionBid.Embed.ThumbnailUrl","{itemImageUrl}"),
    AUCTION_BID_EMBED_TITLE_TEXT("AuctionBid.Embed.Title.Text",""),
    AUCTION_BID_EMBED_TITLE_URL("AuctionBid.Embed.Title.Url",""),

    // Embed description
    AUCTION_BID_EMBED_DESCRIPTION("AuctionBid.Embed.Description","{bidder} placed bid of ${amount} on auction #{id} ({quantity} x {item})."),
    AUCTION_BID_EMBED_FIELDS("AuctionBid.Embed.Fields","[]"),
    AUCTION_BID_EMBED_IMAGEURL("AuctionBid.Embed.ImageUrl","{loreImageUrl}"),

    // Footer settings
    AUCTION_BID_EMBED_FOOTER_TEXT("AuctionBid.Embed.Footer.Text",""),
    AUCTION_BID_EMBED_FOOTER_ICONURL("AuctionBid.Embed.Footer.IconUrl",""),
    AUCTION_BID_EMBED_TIMESTAMP("AuctionBid.Embed.Timestamp",true),

    /*
     * AUCTION END
     */

    IS_AUCTION_END_EMBED_ENABLED("AuctionEnd.Embed.Enabled", true),

    // Main embed settings
    AUCTION_END_EMBED_CHANNEL_ID("AuctionEnd.Embed.ChannelID", "[]"),
    AUCTION_END_EMBED_COLOR("AuctionEnd.Embed.Color","#fcba03"),

    // Embed author settings
    AUCTION_END_EMBED_AUTHOR_IMAGEURL("AuctionEnd.Embed.Author.ImageUrl","{buyerAvatarUrl}"),
    AUCTION_END_EMBED_AUTHOR_NAME("AuctionEnd.Embed.Author.Name","**[ Auction Ended! ]**"),
    AUCTION_END_EMBED_AUTHOR_Url("AuctionEnd.Embed.Author.Url",""),

    // Embed thumbnail settings
    AUCTION_END_EMBED_THUMBNAIL("AuctionEnd.Embed.ThumbnailUrl","{itemImageUrl}"),
    AUCTION_END_EMBED_TITLE_TEXT("AuctionEnd.Embed.Title.Text",""),
    AUCTION_END_EMBED_TITLE_URL("AuctionEnd.Embed.Title.Url",""),

    // Embed description
    AUCTION_END_EMBED_DESCRIPTION("AuctionEnd.Embed.Description","{buyer} won auction #{id} ({quantity} x {item}) with a bid of ${price}."),
    AUCTION_END_EMBED_FIELDS("AuctionEnd.Embed.Fields","[]"),
    AUCTION_END_EMBED_IMAGEURL("AuctionEnd.Embed.ImageUrl","{loreImageUrl}"),

    // Footer settings
    AUCTION_END_EMBED_FOOTER_TEXT("AuctionEnd.Embed.Footer.Text",""),
    AUCTION_END_EMBED_FOOTER_ICONURL("AuctionEnd.Embed.Footer.IconUrl",""),
    AUCTION_END_EMBED_TIMESTAMP("AuctionEnd.Embed.Timestamp",true),

    /*
     * AUCTION END NO BIDS
     */

    IS_AUCTION_END_NO_BIDS_EMBED_ENABLED("AuctionEndNoBids.Embed.Enabled", true),

    // Main embed settings
    AUCTION_END_NO_BIDS_EMBED_CHANNEL_ID("AuctionEndNoBids.Embed.ChannelID", "[]"),
    AUCTION_END_NO_BIDS_EMBED_COLOR("AuctionEndNoBids.Embed.Color","#fcba03"),

    // Embed author settings
    AUCTION_END_NO_BIDS_EMBED_AUTHOR_IMAGEURL("AuctionEndNoBids.Embed.Author.ImageUrl","{embedavatarurl}"),
    AUCTION_END_NO_BIDS_EMBED_AUTHOR_NAME("AuctionEndNoBids.Embed.Author.Name","**[ Auction Ended without bids! ]**"),
    AUCTION_END_NO_BIDS_EMBED_AUTHOR_Url("AuctionEndNoBids.Embed.Author.Url",""),

    // Embed thumbnail settings
    AUCTION_END_NO_BIDS_EMBED_THUMBNAIL("AuctionEndNoBids.Embed.ThumbnailUrl","{userAvatarUrl}"),
    AUCTION_END_NO_BIDS_EMBED_TITLE_TEXT("AuctionEndNoBids.Embed.Title.Text",""),
    AUCTION_END_NO_BIDS_EMBED_TITLE_URL("AuctionEndNoBids.Embed.Title.Url",""),

    // Embed description
    AUCTION_END_NO_BIDS_EMBED_DESCRIPTION("AuctionEndNoBids.Embed.Description","Auction #{id} ({quantity} x {item}) ended with no bids."),
    AUCTION_END_NO_BIDS_EMBED_FIELDS("AuctionEndNoBids.Embed.Fields","[]"),
    AUCTION_END_NO_BIDS_EMBED_IMAGEURL("AuctionEndNoBids.Embed.ImageUrl",""),

    // Footer settings
    AUCTION_END_NO_BIDS_EMBED_FOOTER_TEXT("AuctionEndNoBids.Embed.Footer.Text",""),
    AUCTION_END_NO_BIDS_EMBED_FOOTER_ICONURL("AuctionEndNoBids.Embed.Footer.IconUrl",""),
    AUCTION_END_NO_BIDS_EMBED_TIMESTAMP("AuctionEndNoBids.Embed.Timestamp",true);


    public String path;
    public Object value;

    AuctionGUIPlusDefaults(String path, Object value) {
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
