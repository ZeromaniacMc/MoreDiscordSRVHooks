package me.zeromaniac.embed;

import github.scarsz.discordsrv.util.DiscordUtil;
import me.zeromaniac.common.Debug;
import me.zeromaniac.common.ImageHelper;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.enums.AvatarImages;
import me.zeromaniac.embed.enums.Avatars;
import me.zeromaniac.embed.enums.ImageNames;
import me.zeromaniac.embed.enums.PlaceholdersEnum;
import me.zeromaniac.listener.enums.*;
import me.zeromaniac.handlers.ConfigHandler;
import static me.zeromaniac.common.StringHelper.mapContainsValue;
import static me.zeromaniac.common.StringHelper.validateUUID;
import static me.zeromaniac.common.StringHelper.validateString;
import static me.zeromaniac.common.ImageHelper.getPlayerInventory;
import static me.zeromaniac.common.ImageHelper.getImage;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LiteBansEmbed extends AbstractEmbed {
    public LiteBansEmbed(LiteBansEventType type, long punishmentID, String receiverUUID,
            String receiverName, String receiverIP, String punishReason, String executorUUID,
            String executorName, String dateStart, String dateEnd, String duration,
            String silent, String revokerUUID, String revokerName, String revokeReason,
            String originServer, String effectScope) {
        super();

        messageType  = type.getValue();

        if (!isEnabled(messageType)) {
            return;
        }
        
        this.player = Bukkit.getPlayer(executorUUID);

        replacer.put(PlaceholdersEnum.ID.getValue(), String.valueOf(punishmentID));
        replacer.put(PlaceholdersEnum.RECEIVER_UUID.getValue(), receiverUUID);
        replacer.put(PlaceholdersEnum.RECEIVER_NAME.getValue(), receiverName);
        replacer.put(PlaceholdersEnum.RECEIVER_IP.getValue(), receiverIP);
        replacer.put(PlaceholdersEnum.PUNISH_REASON.getValue(), punishReason);
        replacer.put(PlaceholdersEnum.EXECUTOR_UUID.getValue(), executorUUID);
        replacer.put(PlaceholdersEnum.EXECUTOR_NAME.getValue(), executorName);
        replacer.put(PlaceholdersEnum.DATE_START.getValue(), dateStart);
        replacer.put(PlaceholdersEnum.DATE_END.getValue(), dateEnd);
        replacer.put(PlaceholdersEnum.DURATION.getValue(), duration);
        replacer.put(PlaceholdersEnum.SILENT.getValue(), String.valueOf(silent));
        replacer.put(PlaceholdersEnum.REVOKER_UUID.getValue(), revokerUUID);
        replacer.put(PlaceholdersEnum.REVOKER_NAME.getValue(), revokerName);
        replacer.put(PlaceholdersEnum.REVOKE_REASON.getValue(), revokeReason);
        replacer.put(PlaceholdersEnum.ORIGIN_SERVER.getValue(), originServer);
        replacer.put(PlaceholdersEnum.EFFECT_SCOPE.getValue(), effectScope);

        replacer.put(PlaceholdersEnum.INVENTORY_IMAGE_URL.getValue(),
                attachmentType + ImageNames.INVENTORY_IMAGE.getValue());

        if (validateString(receiverName) && validateString(receiverUUID)) {
            for (AvatarImages avatar : Avatars.RECEIVER.getAvatarImages()) {
                replacer.put(avatar.getValue(),
                        ImageHelper.constructAvatarUrl(receiverName, UUID.fromString(receiverUUID), avatar.getType()));
            }
        }

        if (validateString(executorName) && validateString(executorUUID)) {
            for (AvatarImages avatar : Avatars.EXECUTROR.getAvatarImages()) {
                replacer.put(avatar.getValue(),
                        ImageHelper.constructAvatarUrl(executorName, UUID.fromString(executorUUID), avatar.getType()));
            }
        }

        if (validateString(revokerName) && validateString(revokerUUID)) {
            for (AvatarImages avatar : Avatars.REVOKER.getAvatarImages()) {
                replacer.put(avatar.getValue(),
                        ImageHelper.constructAvatarUrl(revokerName, UUID.fromString(revokerUUID), avatar.getType()));
            }
        }

        replacer.put(PlaceholdersEnum.BOT_AVATAR_URL.getValue(),
                DiscordUtil.getJda().getSelfUser().getEffectiveAvatarUrl());

        setConfigValues(messageType);

        
        if (mapContainsValue(textFieldsMap, ImageNames.INVENTORY_IMAGE.getValue()) && validateUUID(receiverUUID)) {
            try {
                try {
                    Class.forName("com.comphenix.protocol.injector.temporary.TemporaryPlayerFactory");
                } catch (Throwable e) {
                    Debug.log("ERROR ", debug);
                    Debug.log(e.getMessage(), debug);
                }

                Player player = Bukkit.getPlayer(UUID.fromString(receiverUUID));

                if (player != null && player.getInventory() != null) {
                    attachmentImages.add(getImage(ImageNames.INVENTORY_IMAGE.getValue(), getPlayerInventory(player.getInventory(), player)));
                }
            } catch (Throwable e) {
                Debug.log("ERROR ", debug);
                Debug.log(e.getMessage(), debug);
            }

        }
    }

    @Override
    protected void initConfig() {
        config = ConfigHandler.getLitebansConfig().getConfig();
    }

    @Override
    protected void initDebug() {
        debug = ConfigHandler.getMainConfig().getConfig().getBoolean(MainConfigDefaults.IS_LITEBANS_DEBUG.getPath());
    }

    @Override
    protected boolean isEnabled(String type) {
        enabled = config.getBoolean(type + ".Embed.Enabled") && ConfigHandler.getMainConfig().getIsLitebansEnabled();

        return enabled;
    }
}