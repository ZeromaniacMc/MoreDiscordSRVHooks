package me.zeromaniac.embed;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.dependencies.jda.api.EmbedBuilder;
import github.scarsz.discordsrv.dependencies.jda.api.entities.MessageEmbed;
import github.scarsz.discordsrv.dependencies.jda.api.entities.TextChannel;
import github.scarsz.discordsrv.dependencies.jda.api.requests.restaction.MessageAction;
import me.zeromaniac.common.ConditionHelper;
import me.zeromaniac.common.Debug;
import me.zeromaniac.common.StringHelper;
import me.zeromaniac.embed.enums.ConfigFields;
import me.zeromaniac.types.Author;
import me.zeromaniac.types.Footer;
import me.zeromaniac.types.Image;
import me.zeromaniac.types.Title;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import java.awt.Color;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static me.zeromaniac.common.StringHelper.validateString;
import static me.zeromaniac.common.StringHelper.validateUrlOrAttachment;

public abstract class AbstractEmbed {
    protected String messageType;
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
    protected Player player;
    protected ArrayList<Image> attachmentImages = new ArrayList<>();
    protected Map<String, String> textFieldsMap = new HashMap<>();
    protected List<String> channelIDs = new ArrayList<>();

    protected AbstractEmbed() {
        initConfig();
        initDebug();
    }

    public boolean comparator(String type) {
        Debug.log("Comparator start.", debug);
        ConfigurationSection conditions = config.getConfigurationSection(type + ".Embed.Conditions");

        if (conditions == null) {
            return true;
        }

        Set<String> conditionKeys = conditions.getKeys(false); // ["condition1", "condition2", "condition3"]

        Debug.log("List of condition names found:" + conditionKeys.toString(), debug);

        if (conditionKeys.size() == 0) {
            return true;
        }

        ConditionHelper conditionHandler = new ConditionHelper();

        boolean result = true;

        for (String condition : conditionKeys) {

            String compareType = config.getString(type + ".Embed.Conditions." + condition + ".Type");
            Object compareInput = config.get(type + ".Embed.Conditions." + condition + ".Input");
            String compareOperator = config.getString(type + ".Embed.Conditions." + condition + ".Operator");
            Object compareCompare = config.get(type + ".Embed.Conditions." + condition + ".Compare");

            Debug.log("Got conditions:", debug);
            Debug.log("Compare type: " + compareType.toString(), debug);
            Debug.log("Input given: " + compareInput.toString(), debug);
            Debug.log("Operator used: " + compareOperator.toString(), debug);
            Debug.log("Comparing to: " + compareCompare.toString(), debug);

            if (compareType.equalsIgnoreCase("string")) {
                result = conditionHandler.stringComparator(
                        StringHelper.parsePlaceholders((String) compareInput, replacer),
                        (String) compareOperator, StringHelper.parsePlaceholders((String) compareCompare, replacer));
            }

            if (compareType.equalsIgnoreCase("hasPermission")) {
                List<String> permissions = (List<String>) compareInput;

                if (player == null) {
                    return true;
                }

                for (int i = 0; i < permissions.size(); i++) {
                    permissions.set(i, StringHelper.parsePlaceholders(permissions.get(i), replacer));
                }

                result = conditionHandler.permissionComparator(player,
                        permissions.toArray(new String[permissions.size()]),
                        (String) compareOperator, (Boolean) compareCompare);
            }

            if (compareType.equalsIgnoreCase("number")) {
                Double value = Double
                        .parseDouble(StringHelper.parsePlaceholders(compareCompare.toString(), replacer, player));

                result = conditionHandler.numericalComparator(
                        StringHelper.parsePlaceholders((String) compareInput, replacer, player),
                        (String) compareOperator, value);
            }

            Debug.log("Result of the comparison: ", debug);
            Debug.log(result ? "True, now building and sending the requested embed!\n"
                    : "False, conditions were not met. Aborting.\n", debug);

            if (!result) {
                return result;
            }

        }

        return true;
    }

    public void sendEmbed() {
        try {
            if (enabled) {
                enabled = comparator(messageType);
            }
        } catch (Exception e) {
            Debug.log("Error in parsing comparator", true);
            e.printStackTrace();
        }

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
                additionalFields.add(new MessageEmbed.Field(StringHelper.parsePlaceholders(textLine[0], replacer),
                        StringHelper.parsePlaceholders(textLine[1], replacer), textLine[2].equals("true")));
            } else {
                additionalFields.add(new MessageEmbed.Field("", "", true));
            }
        }
        for (Map.Entry<String, String> entry : textFieldsMap.entrySet()) {
            entry.setValue(StringHelper.parsePlaceholders(entry.getValue(), replacer));
        }
    }

    protected abstract boolean isEnabled(String type);
    protected abstract void initConfig();
    protected abstract void initDebug();

    protected abstract void handleImages();

    protected  void afterConstructor() {
        setConfigValues(messageType);
        handleImages();
    }
}
