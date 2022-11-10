package me.zeromaniac.embed;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.dependencies.jda.api.EmbedBuilder;
import github.scarsz.discordsrv.dependencies.jda.api.entities.MessageEmbed;
import github.scarsz.discordsrv.dependencies.jda.api.entities.TextChannel;
import github.scarsz.discordsrv.dependencies.jda.api.requests.restaction.MessageAction;
import me.zeromaniac.common.Debug;
import me.zeromaniac.embed.enums.ConfigFields;
import me.zeromaniac.types.Author;
import me.zeromaniac.types.Footer;
import me.zeromaniac.types.Image;
import me.zeromaniac.types.Title;
import org.bukkit.configuration.file.FileConfiguration;
import java.awt.Color;
import java.lang.reflect.Array;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static me.zeromaniac.common.StringHelper.validateString;
import static me.zeromaniac.common.StringHelper.validateUrlOrAttachment;
import static me.zeromaniac.common.StringHelper.parsePlaceholders;

public abstract class AbstractEmbed {
    protected static String attachmentType = "attachment://";
    protected FileConfiguration config;
    protected Map<String, String> replacer = new HashMap<>();
    protected boolean enabled;
    protected boolean debug;
    // protected String channelID;
    protected String color;
    protected Author author;
    protected String thumbnail;
    protected Title title;
    protected String description;
    protected ArrayList<MessageEmbed.Field> additionalFields = new ArrayList<>();
    protected String imageUrl;
    protected Footer footer;
    protected boolean timestamp = true;

    protected ArrayList<Image> attachmentImages = new ArrayList<>();
    protected Map<String, String> textFieldsMap = new HashMap<>();
    protected List<String> channelIDs = new ArrayList<>();

    protected AbstractEmbed() {
        initConfig();
        initDebug();
    }

    public void sendEmbed() {
        if (!enabled) {
            Debug.log("Embed status enabled: false. Not sending an embed.", debug);
            Debug.log("If this is a mistake please check the appropriate config for 'Enabled: true/false'.", debug);
            return;
        }

        try {
            Debug.log("Embed status enabled: true", debug);
            Debug.log("Building the embed... Please review messages below.", debug);

            EmbedBuilder myEmbed = new EmbedBuilder();
            myEmbed.setColor(Color.decode(color));

            if (author.isValid()) {
                myEmbed.setAuthor(author.getName(), author.getUrl(), author.getIcon());
                Debug.log("Validating Author... OK!", debug);
            } else {
                Debug.log("Author failed validation!", debug);
            }

            myEmbed.setThumbnail(validateUrlOrAttachment(thumbnail));
            if (title.isValid()) {
                myEmbed.setTitle(title.getText(), title.getUrl());
                Debug.log("Validating Thumbnail... OK!", debug);
            } else {
                Debug.log("Thumbnail failed validation! This could be caused by the thumbnail being empty.", debug);
                Debug.log("If that is the case, this is safe to ignore.", debug);
            }

            myEmbed.setDescription(description);
            for (MessageEmbed.Field field : additionalFields) {
                if (!validateString(field.getName()) || !validateString(field.getValue())) {
                    myEmbed.addBlankField(field.isInline());
                }
                myEmbed.addField(field);
            }

            myEmbed.setImage(validateUrlOrAttachment(imageUrl));
            if (footer.isValid()) {
                myEmbed.setFooter(footer.getText(), footer.getIcon());
                Debug.log("Validating footer... OK!", debug);
            } else {
                Debug.log("Footer failed validation! This could be caused by the footer being empty.", debug);
                Debug.log("If that is the case, this is safe to ignore.", debug);
            }

            if (timestamp) {
                myEmbed.setTimestamp(OffsetDateTime.now());
                Debug.log("Setting time stamp... OK!", debug);
            } else {
                Debug.log("Time stamp appears to be disabled.", debug);
            }

            for (String channelID : channelIDs) {
                TextChannel myChannel = DiscordSRV.getPlugin().getMainGuild().getTextChannelById(channelID);
                if (myChannel == null) {
                    Debug.log("Channel ID could not be verified. Please check your config.", debug);
                    return;
                }

                MessageAction myMessage = myChannel.sendMessageEmbeds(myEmbed.build());
                for (Image img : attachmentImages) {
                    if (!img.isValid()) {
                        Debug.log("Invalid image - could not complete embed with image: " + img.getImageName(), debug);
                        continue;
                    }
                    // noinspection ResultOfMethodCallIgnored
                    myMessage.addFile(img.getImage(), img.getImageName());
                }
                myMessage.queue();
            }

        } catch (Exception e) {
            Debug.log("Error, embed could not be completed!", debug);
            Debug.log(e.getMessage(), debug);
        }
    }

    protected void setConfigValues(String type) {
        type = type + ".";

        parseSettings(type);

        String embedAuthorName = textFieldsMap.get(ConfigFields.AUTHOR_NAME.getValue());
        String embedAuthorUrl = config.getString(type + ConfigFields.AUTHOR_URL.getValue());
        String embedAuthorImageUrl = textFieldsMap.get(ConfigFields.AUTHOR_IMAGE_URL.getValue());
        String titleUrl = config.getString(type + ConfigFields.TITLE_URL);
        String titleText = textFieldsMap.get(ConfigFields.TITLE_TEXT.getValue());
        String footerText = textFieldsMap.get(ConfigFields.FOOTER_TEXT.getValue());
        String footerIconUrl = textFieldsMap.get(ConfigFields.FOOTER_ICON_URL.getValue());

        channelIDs = config.getStringList(type + ConfigFields.CHANNEL_ID.getValue());
        color = config.getString(type + ConfigFields.COLOR.getValue());
        thumbnail = textFieldsMap.get(ConfigFields.THUMBNAIL_URL.getValue());
        description = textFieldsMap.get(ConfigFields.DESCRIPTION.getValue());
        imageUrl = textFieldsMap.get(ConfigFields.IMAGE_URL.getValue());

        author = new Author(embedAuthorName, embedAuthorUrl, embedAuthorImageUrl);
        title = new Title(titleText, titleUrl);
        footer = new Footer(footerText, footerIconUrl);
    }

    protected void parseSettings(String type) {
        for (String text : ConfigFields.getReplacerValues()) {
            textFieldsMap.put(text, config.getString(type + text));
        }

        for (Map.Entry<String, String> entry : replacer.entrySet()) {
            if (entry.getValue() == null) {
                entry.setValue("");
            }
        }

        for (String text : config.getStringList(type + ConfigFields.FIELDS.getValue())) {
            String[] textLine = text.split(";");

            if (textLine.length > 2) {
                additionalFields.add(new MessageEmbed.Field(parsePlaceholders(textLine[0], replacer),
                        parsePlaceholders(textLine[1], replacer), textLine[2].equals("true")));
            } else {
                additionalFields.add(new MessageEmbed.Field("", "", true));
            }
        }
        for (Map.Entry<String, String> entry : textFieldsMap.entrySet()) {
            entry.setValue(parsePlaceholders(entry.getValue(), replacer));
        }
    }

    protected abstract boolean isEnabled(String type);

    protected abstract void initConfig();

    protected abstract void initDebug();
}
