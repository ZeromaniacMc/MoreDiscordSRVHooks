package me.zeromaniac.config.enums;

public enum VanillaDefaults implements EnumGeneral {

    /*
     * REGULAR JOIN
     */

    IS_PLAYER_JOIN_EMBED_ENABLED("PlayerJoin.Embed.Enabled", true),

    // Main embed settings
    PLAYER_JOIN_EMBED_CHANNEL_ID("PlayerJoin.Embed.ChannelID", "[]"),
    PLAYER_JOIN_EMBED_COLOR("PlayerJoin.Embed.Color","#00e64e"),

    // Embed author settings
    PLAYER_JOIN_EMBED_AUTHOR_IMAGEURL("PlayerJoin.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    PLAYER_JOIN_EMBED_AUTHOR_NAME("PlayerJoin.Embed.Author.Name","{player} came back!"),
    PLAYER_JOIN_EMBED_AUTHOR_URL("PlayerJoin.Embed.Author.Url",""),

    // Embed thumbnail settings
    PLAYER_JOIN_EMBED_THUMBNAIL("PlayerJoin.Embed.ThumbnailUrl","{playerBodyUrl}"),
    PLAYER_JOIN_EMBED_TITLE_TEXT("PlayerJoin.Embed.Title.Text",""),
    PLAYER_JOIN_TITLE_URL("PlayerJoin.Embed.Title.Url",""),

    // Embed description
    PLAYER_JOIN_EMBED_DESCRIPTION("PlayerJoin.Embed.Description",""),
    PLAYER_JOIN_EMBED_FIELDS("PlayerJoin.Embed.Fields","[]"),
    PLAYER_JOIN_EMBED_IMAGEURL("PlayerJoin.Embed.ImageUrl",""),

    // Footer settings
    PLAYER_JOIN_EMBED_FOOTER_TEXT("PlayerJoin.Embed.Footer.Text",""),
    PLAYER_JOIN_EMBED_FOOTER_ICONURL("PlayerJoin.Embed.Footer.IconUrl",""),
    PLAYER_JOIN_EMBED_TIMESTAMP("PlayerJoin.Embed.Timestamp",true),


    /*
     * FIRST JOIN
     */

    IS_PLAYER_FIRST_JOIN_EMBED_ENABLED("PlayerFirstJoin.Embed.Enabled", true),

    // Main embed settings
    PLAYER_FIRST_JOIN_EMBED_CHANNEL_ID("PlayerFirstJoin.Embed.ChannelID", "[]"),
    PLAYER_FIRST_JOIN_EMBED_COLOR("PlayerFirstJoin.Embed.Color","#00e64e"),

    // Embed author settings
    PLAYER_FIRST_JOIN_EMBED_AUTHOR_IMAGEURL("PlayerFirstJoin.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    PLAYER_FIRST_JOIN_EMBED_AUTHOR_NAME("PlayerFirstJoin.Embed.Author.Name","{player} joined for the first time!"),
    PLAYER_FIRST_JOIN_EMBED_AUTHOR_URL("PlayerFirstJoin.Embed.Author.Url",""),

    // Embed thumbnail settings
    PLAYER_FIRST_JOIN_EMBED_THUMBNAIL("PlayerFirstJoin.Embed.ThumbnailUrl",""),
    PLAYER_FIRST_JOIN_EMBED_TITLE_TEXT("PlayerFirstJoin.Embed.Title.Text",""),
    PLAYER_FIRST_JOIN_TITLE_URL("PlayerFirstJoin.Embed.Title.Url",""),

    // Embed description
    PLAYER_FIRST_JOIN_EMBED_DESCRIPTION("PlayerFirstJoin.Embed.Description",""),
    PLAYER_FIRST_JOIN_EMBED_FIELDS("PlayerFirstJoin.Embed.Fields","[]"),
    PLAYER_FIRST_JOIN_EMBED_IMAGEURL("PlayerFirstJoin.Embed.ImageUrl","{playerBodyUrl}"),

    // Footer settings
    PLAYER_FIRST_JOIN_EMBED_FOOTER_TEXT("PlayerFirstJoin.Embed.Footer.Text",""),
    PLAYER_FIRST_JOIN_EMBED_FOOTER_ICONURL("PlayerFirstJoin.Embed.Footer.IconUrl",""),
    PLAYER_FIRST_JOIN_EMBED_TIMESTAMP("PlayerFirstJoin.Embed.Timestamp",true),

    /*
     * LEAVE
     */

    IS_PLAYER_LEAVE_EMBED_ENABLED("PlayerQuit.Embed.Enabled", true),

    // Main embed settings
    PLAYER_LEAVE_EMBED_CHANNEL_ID("PlayerQuit.Embed.ChannelID", "[]"),
    PLAYER_LEAVE_EMBED_COLOR("PlayerQuit.Embed.Color","#00e64e"),

    // Embed author settings
    PLAYER_LEAVE_EMBED_AUTHOR_IMAGEURL("PlayerQuit.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    PLAYER_LEAVE_EMBED_AUTHOR_NAME("PlayerQuit.Embed.Author.Name","{player} left."),
    PLAYER_LEAVE_EMBED_AUTHOR_URL("PlayerQuit.Embed.Author.Url",""),

    // Embed thumbnail settings
    PLAYER_LEAVE_EMBED_THUMBNAIL("PlayerQuit.Embed.ThumbnailUrl",""),
    PLAYER_LEAVE_EMBED_TITLE_TEXT("PlayerQuit.Embed.Title.Text",""),
    PLAYER_LEAVE_TITLE_URL("PlayerQuit.Embed.Title.Url",""),

    // Embed description
    PLAYER_LEAVE_EMBED_DESCRIPTION("PlayerQuit.Embed.Description",""),
    PLAYER_LEAVE_EMBED_FIELDS("PlayerQuit.Embed.Fields","[]"),
    PLAYER_LEAVE_EMBED_IMAGEURL("PlayerQuit.Embed.ImageUrl","{playerBodyUrl}"),

    // Footer settings
    PLAYER_LEAVE_EMBED_FOOTER_TEXT("PlayerQuit.Embed.Footer.Text",""),
    PLAYER_LEAVE_EMBED_FOOTER_ICONURL("PlayerQuit.Embed.Footer.IconUrl",""),
    PLAYER_LEAVE_EMBED_TIMESTAMP("PlayerQuit.Embed.Timestamp",true),

    /*
     * DEATH BY PLAYER OR MOB
     */

    IS_PLAYER_DEATH_EMBED_ENABLED("PlayerDeathByEntity.Embed.Enabled", true),

    // Main embed settings
    PLAYER_DEATH_EMBED_CHANNEL_ID("PlayerDeathByEntity.Embed.ChannelID", "[]"),
    PLAYER_DEATH_EMBED_COLOR("PlayerDeathByEntity.Embed.Color","#00e64e"),

    // Embed author settings
    PLAYER_DEATH_EMBED_AUTHOR_IMAGEURL("PlayerDeathByEntity.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    PLAYER_DEATH_EMBED_AUTHOR_NAME("PlayerDeathByEntity.Embed.Author.Name","{player} died."),
    PLAYER_DEATH_EMBED_AUTHOR_URL("PlayerDeathByEntity.Embed.Author.Url",""),

    // Embed thumbnail settings
    PLAYER_DEATH_EMBED_THUMBNAIL("PlayerDeathByEntity.Embed.ThumbnailUrl",""),
    PLAYER_DEATH_EMBED_TITLE_TEXT("PlayerDeathByEntity.Embed.Title.Text",""),
    PLAYER_DEATH_TITLE_URL("PlayerDeathByEntity.Embed.Title.Url",""),

    // Embed description
    PLAYER_DEATH_EMBED_DESCRIPTION("PlayerDeathByEntity.Embed.Description",""),
    PLAYER_DEATH_EMBED_FIELDS("PlayerDeathByEntity.Embed.Fields","[]"),
    PLAYER_DEATH_EMBED_IMAGEURL("PlayerDeathByEntity.Embed.ImageUrl","{playerBodyUrl}"),

    // Footer settings
    PLAYER_DEATH_EMBED_FOOTER_TEXT("PlayerDeathByEntity.Embed.Footer.Text",""),
    PLAYER_DEATH_EMBED_FOOTER_ICONURL("PlayerDeathByEntity.Embed.Footer.IconUrl",""),
    PLAYER_DEATH_EMBED_TIMESTAMP("PlayerDeathByEntity.Embed.Timestamp",true),

    /*
     * DEATH BY ENVIRONMENT
     */

    IS_PLAYER_DEATH_ENV_EMBED_ENABLED("PlayerDeathByEnvironment.Embed.Enabled", true),

    // Main embed settings
    PLAYER_DEATH_ENV_EMBED_CHANNEL_ID("PlayerDeathByEnvironment.Embed.ChannelID", "[]"),
    PLAYER_DEATH_ENV_EMBED_COLOR("PlayerDeathByEnvironment.Embed.Color","#00e64e"),

    // Embed author settings
    PLAYER_DEATH_ENV_EMBED_AUTHOR_IMAGEURL("PlayerDeathByEnvironment.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    PLAYER_DEATH_ENV_EMBED_AUTHOR_NAME("PlayerDeathByEnvironment.Embed.Author.Name","{player} died."),
    PLAYER_DEATH_ENV_EMBED_AUTHOR_URL("PlayerDeathByEnvironment.Embed.Author.Url",""),

    // Embed thumbnail settings
    PLAYER_DEATH_ENV_EMBED_THUMBNAIL("PlayerDeathByEnvironment.Embed.ThumbnailUrl",""),
    PLAYER_DEATH_ENV_EMBED_TITLE_TEXT("PlayerDeathByEnvironment.Embed.Title.Text",""),
    PLAYER_DEATH_ENV_TITLE_URL("PlayerDeathByEnvironment.Embed.Title.Url",""),

    // Embed description
    PLAYER_DEATH_ENV_EMBED_DESCRIPTION("PlayerDeathByEnvironment.Embed.Description",""),
    PLAYER_DEATH_ENV_EMBED_FIELDS("PlayerDeathByEnvironment.Embed.Fields","[]"),
    PLAYER_DEATH_ENV_EMBED_IMAGEURL("PlayerDeathByEnvironment.Embed.ImageUrl","{playerBodyUrl}"),

    // Footer settings
    PLAYER_DEATH_ENV_EMBED_FOOTER_TEXT("PlayerDeathByEnvironment.Embed.Footer.Text",""),
    PLAYER_DEATH_ENV_EMBED_FOOTER_ICONURL("PlayerDeathByEnvironment.Embed.Footer.IconUrl",""),
    PLAYER_DEATH_ENV_EMBED_TIMESTAMP("PlayerDeathByEnvironment.Embed.Timestamp",true),

    /*
     * COMMAND
     */

    IS_PLAYER_COMMAND_EMBED_ENABLED("PlayerCommand.Embed.Enabled", true),

    // Main embed settings
    PLAYER_COMMAND_EMBED_CHANNEL_ID("PlayerCommand.Embed.ChannelID", "[]"),
    PLAYER_COMMAND_EMBED_COLOR("PlayerCommand.Embed.Color","#00e64e"),

    // Embed author settings
    PLAYER_COMMAND_EMBED_AUTHOR_IMAGEURL("PlayerCommand.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    PLAYER_COMMAND_EMBED_AUTHOR_NAME("PlayerCommand.Embed.Author.Name","{player} sent a command."),
    PLAYER_COMMAND_EMBED_AUTHOR_URL("PlayerCommand.Embed.Author.Url",""),

    // Embed thumbnail settings
    PLAYER_COMMAND_EMBED_THUMBNAIL("PlayerCommand.Embed.ThumbnailUrl",""),
    PLAYER_COMMAND_EMBED_TITLE_TEXT("PlayerCommand.Embed.Title.Text",""),
    PLAYER_COMMAND_TITLE_URL("PlayerCommand.Embed.Title.Url",""),

    // Embed description
    PLAYER_COMMAND_EMBED_DESCRIPTION("PlayerCommand.Embed.Description",""),
    PLAYER_COMMAND_EMBED_FIELDS("PlayerCommand.Embed.Fields","[]"),
    PLAYER_COMMAND_EMBED_IMAGEURL("PlayerCommand.Embed.ImageUrl","{playerBodyUrl}"),

    // Footer settings
    PLAYER_COMMAND_EMBED_FOOTER_TEXT("PlayerCommand.Embed.Footer.Text",""),
    PLAYER_COMMAND_EMBED_FOOTER_ICONURL("PlayerCommand.Embed.Footer.IconUrl",""),
    PLAYER_COMMAND_EMBED_TIMESTAMP("PlayerCommand.Embed.Timestamp",true),

    /*
     * LEVEL CHANGE
     */

    IS_PLAYER_LEVEL_CHANGE_EMBED_ENABLED("LevelUp.Embed.Enabled", true),

    // Main embed settings
    PLAYER_LEVEL_CHANGE_EMBED_CHANNEL_ID("LevelUp.Embed.ChannelID", "[]"),
    PLAYER_LEVEL_CHANGE_EMBED_COLOR("LevelUp.Embed.Color","#00e64e"),

    // Embed author settings
    PLAYER_LEVEL_CHANGE_EMBED_AUTHOR_IMAGEURL("LevelUp.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    PLAYER_LEVEL_CHANGE_EMBED_AUTHOR_NAME("LevelUp.Embed.Author.Name","{player} sent a command."),
    PLAYER_LEVEL_CHANGE_EMBED_AUTHOR_URL("LevelUp.Embed.Author.Url",""),

    // Embed thumbnail settings
    PLAYER_LEVEL_CHANGE_EMBED_THUMBNAIL("LevelUp.Embed.ThumbnailUrl",""),
    PLAYER_LEVEL_CHANGE_EMBED_TITLE_TEXT("LevelUp.Embed.Title.Text",""),
    PLAYER_LEVEL_CHANGE_TITLE_URL("LevelUp.Embed.Title.Url",""),

    // Embed description
    PLAYER_LEVEL_CHANGE_EMBED_DESCRIPTION("LevelUp.Embed.Description",""),
    PLAYER_LEVEL_CHANGE_EMBED_FIELDS("LevelUp.Embed.Fields","[]"),
    PLAYER_LEVEL_CHANGE_EMBED_IMAGEURL("LevelUp.Embed.ImageUrl","{playerBodyUrl}"),

    // Footer settings
    PLAYER_LEVEL_CHANGE_EMBED_FOOTER_TEXT("LevelUp.Embed.Footer.Text",""),
    PLAYER_LEVEL_CHANGE_EMBED_FOOTER_ICONURL("LevelUp.Embed.Footer.IconUrl",""),
    PLAYER_LEVEL_CHANGE_EMBED_TIMESTAMP("LevelUp.Embed.Timestamp",true),

    /*
     * WORLD CHANGE
     */

    IS_PLAYER_WORLD_CHANGE_EMBED_ENABLED("WorldChange.Embed.Enabled", true),

    // Main embed settings
    PLAYER_WORLD_CHANGE_EMBED_CHANNEL_ID("WorldChange.Embed.ChannelID", "[]"),
    PLAYER_WORLD_CHANGE_EMBED_COLOR("WorldChange.Embed.Color","#00e64e"),

    // Embed author settings
    PLAYER_WORLD_CHANGE_EMBED_AUTHOR_IMAGEURL("WorldChange.Embed.Author.ImageUrl","{playerAvatarUrl}"),
    PLAYER_WORLD_CHANGE_EMBED_AUTHOR_NAME("WorldChange.Embed.Author.Name","{player} switched worlds!"),
    PLAYER_WORLD_CHANGE_EMBED_AUTHOR_URL("WorldChange.Embed.Author.Url",""),

    // Embed thumbnail settings
    PLAYER_WORLD_CHANGE_EMBED_THUMBNAIL("WorldChange.Embed.ThumbnailUrl",""),
    PLAYER_WORLD_CHANGE_EMBED_TITLE_TEXT("WorldChange.Embed.Title.Text",""),
    PLAYER_WORLD_CHANGE_TITLE_URL("WorldChange.Embed.Title.Url",""),

    // Embed description
    PLAYER_WORLD_CHANGE_EMBED_DESCRIPTION("WorldChange.Embed.Description","From {worldFrom} to {worldTo}"),
    PLAYER_WORLD_CHANGE_EMBED_FIELDS("WorldChange.Embed.Fields","[]"),
    PLAYER_WORLD_CHANGE_EMBED_IMAGEURL("WorldChange.Embed.ImageUrl","{playerBodyUrl}"),

    // Footer settings
    PLAYER_WORLD_CHANGE_EMBED_FOOTER_TEXT("WorldChange.Embed.Footer.Text",""),
    PLAYER_WORLD_CHANGE_EMBED_FOOTER_ICONURL("WorldChange.Embed.Footer.IconUrl",""),
    PLAYER_WORLD_CHANGE_EMBED_TIMESTAMP("WorldChange.Embed.Timestamp",true);



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
