package me.zeromaniac.config.enums;

public enum VanillaDefaults implements EnumGeneral {
    /*
     * REGULAR JOIN
     */

    IS_PLAYER_JOIN_EMBED_ENABLED("Player_Join.Embed.Enabled", true),

    // Main embed settings
    PLAYER_JOIN_EMBED_CHANNEL_ID("Player_Join.Embed.ChannelID", "[]"),
    PLAYER_JOIN_EMBED_COLOR("Player_Join.Embed.Color","#00e64e"),

    // Embed author settings
    PLAYER_JOIN_EMBED_AUTHOR_IMAGEURL("Player_Join.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    PLAYER_JOIN_EMBED_AUTHOR_NAME("Player_Join.Embed.Author.Name","{player} came back!"),
    PLAYER_JOIN_EMBED_AUTHOR_URL("Player_Join.Embed.Author.Url",""),

    // Embed thumbnail settings
    PLAYER_JOIN_EMBED_THUMBNAIL("Player_Join.Embed.ThumbnailUrl","{playerBodyUrl}"),
    PLAYER_JOIN_EMBED_TITLE_TEXT("Player_Join.Embed.Title.Text",""),
    PLAYER_JOIN_TITLE_URL("Player_Join.Embed.Title.Url",""),

    // Embed description
    PLAYER_JOIN_EMBED_DESCRIPTION("Player_Join.Embed.Description",""),
    PLAYER_JOIN_EMBED_FIELDS("Player_Join.Embed.Fields","[]"),
    PLAYER_JOIN_EMBED_IMAGEURL("Player_Join.Embed.ImageUrl",""),

    // Footer settings
    PLAYER_JOIN_EMBED_FOOTER_TEXT("Player_Join.Embed.Footer.Text",""),
    PLAYER_JOIN_EMBED_FOOTER_ICONURL("Player_Join.Embed.Footer.IconUrl",""),
    PLAYER_JOIN_EMBED_TIMESTAMP("Player_Join.Embed.Timestamp",true),


    /*
     * FIRST JOIN
     */

    IS_PLAYER_FIRST_JOIN_EMBED_ENABLED("Player_Join.Embed.Enabled", true),

    // Main embed settings
    PLAYER_FIRST_JOIN_EMBED_CHANNEL_ID("Player_Join.Embed.ChannelID", "[]"),
    PLAYER_FIRST_JOIN_EMBED_COLOR("Player_Join.Embed.Color","#00e64e"),

    // Embed author settings
    PLAYER_FIRST_JOIN_EMBED_AUTHOR_IMAGEURL("Player_Join.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    PLAYER_FIRST_JOIN_EMBED_AUTHOR_NAME("Player_Join.Embed.Author.Name","{player} joined for the first time!"),
    PLAYER_FIRST_JOIN_EMBED_AUTHOR_URL("Player_Join.Embed.Author.Url",""),

    // Embed thumbnail settings
    PLAYER_FIRST_JOIN_EMBED_THUMBNAIL("Player_Join.Embed.ThumbnailUrl",""),
    PLAYER_FIRST_JOIN_EMBED_TITLE_TEXT("Player_Join.Embed.Title.Text",""),
    PLAYER_FIRST_JOIN_TITLE_URL("Player_Join.Embed.Title.Url",""),

    // Embed description
    PLAYER_FIRST_JOIN_EMBED_DESCRIPTION("Player_Join.Embed.Description",""),
    PLAYER_FIRST_JOIN_EMBED_FIELDS("Player_Join.Embed.Fields","[]"),
    PLAYER_FIRST_JOIN_EMBED_IMAGEURL("Player_Join.Embed.ImageUrl","{playerBodyUrl}"),

    // Footer settings
    PLAYER_FIRST_JOIN_EMBED_FOOTER_TEXT("Player_Join.Embed.Footer.Text",""),
    PLAYER_FIRST_JOIN_EMBED_FOOTER_ICONURL("Player_Join.Embed.Footer.IconUrl",""),
    PLAYER_FIRST_JOIN_EMBED_TIMESTAMP("Player_Join.Embed.Timestamp",true);



    public String path;
    public Object value;

    VanillaDefaults(String path, Object value) {
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
