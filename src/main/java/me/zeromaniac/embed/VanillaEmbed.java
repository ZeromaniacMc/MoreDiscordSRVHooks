package me.zeromaniac.embed;

import com.loohp.interactivechat.objectholders.ICPlayerFactory;
import com.loohp.interactivechat.objectholders.OfflineICPlayer;
import github.scarsz.discordsrv.util.DiscordUtil;
import me.zeromaniac.common.ImageHelper;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.enums.AvatarImages;
import me.zeromaniac.embed.enums.Avatars;
import me.zeromaniac.embed.enums.ImageNames;
import me.zeromaniac.embed.enums.PlaceholdersEnum;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.listener.enums.VanillaEventType;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import static me.zeromaniac.common.StringHelper.mapContainsValue;
import static me.zeromaniac.common.ImageHelper.getItemImage;
import static me.zeromaniac.common.ImageHelper.getLoreImage;
import static me.zeromaniac.common.ImageHelper.getImage;
import static me.zeromaniac.common.ImageHelper.getPlayerInventory;

public class VanillaEmbed extends AbstractEmbed {
    ItemStack mainHandItem;
    ItemStack offHandItem;

    public VanillaEmbed(VanillaEventType type, Player player, ItemStack mainHandItem, ItemStack offHandItem,
            boolean hasPlayedBefore,
            GameMode gameMode, boolean isOp, Entity killer, String deathMessage, boolean killerIsPlayer,
            String command, int oldLevel, int newLevel, String worldFrom, String worldTo) {
        super();
        messageType = type.getValue();

        if (!isEnabled(messageType)) {
            return;
        }

        this.mainHandItem = mainHandItem;
        this.offHandItem = offHandItem;
        this.player = player;

        replacer.put(PlaceholdersEnum.PLAYER.getValue(), player.getName());

        replacer.put(PlaceholdersEnum.GAMEMODE.getValue(), String.valueOf(gameMode));

        replacer.put(PlaceholdersEnum.IS_OP.getValue(), String.valueOf(isOp));

        replacer.put(PlaceholdersEnum.DEATHMSG.getValue(), deathMessage);

        replacer.put(PlaceholdersEnum.NEW_LEVEL.getValue(), String.valueOf(newLevel));
        replacer.put(PlaceholdersEnum.OLD_LEVEL.getValue(), String.valueOf(oldLevel));

        replacer.put(PlaceholdersEnum.WORLD_FROM.getValue(), worldFrom);
        replacer.put(PlaceholdersEnum.WORLD_TO.getValue(), worldTo);

        if (command != null) {
            String[] asArray = command.split(" ");

            replacer.put(PlaceholdersEnum.COMMAND.getValue(), command);
            replacer.put(PlaceholdersEnum.COMMAND_ARGS_AMOUNT.getValue(), String.valueOf(asArray.length - 1));
            replacer.put(PlaceholdersEnum.COMMAND_LENGTH.getValue(), String.valueOf(command.length()));

            // todo: assign arguments
            for (int i = 0; i < asArray.length; i++) {
                replacer.put("{arg" + i + "}", asArray[i]);
            }
        }

        if (killer != null) {
            replacer.put(PlaceholdersEnum.KILLER.getValue(), killer.getName());
            replacer.put(PlaceholdersEnum.KILLER_IS_PLAYER.getValue(), String.valueOf(killerIsPlayer));
        }

        replacer.put(PlaceholdersEnum.ITEM_IMAGE_URL.getValue(),
                attachmentType + ImageNames.ITEM_IMAGE.getValue());

        replacer.put(PlaceholdersEnum.LORE_IMAGE_URL.getValue(),
                attachmentType + ImageNames.LORE_IMAGE.getValue());

        replacer.put(PlaceholdersEnum.OFFHAND_ITEM_URL.getValue(),
                attachmentType + ImageNames.OFFHAND_ITEM_IMAGE.getValue());

        replacer.put(PlaceholdersEnum.OFFHAND_ITEM_LORE_URL.getValue(),
                attachmentType + ImageNames.OFFHAND_LORE_IMAGE.getValue());

        replacer.put(PlaceholdersEnum.INVENTORY_IMAGE_URL.getValue(),
                attachmentType + ImageNames.INVENTORY_IMAGE.getValue());

        for (AvatarImages avatar : Avatars.PLAYER.getAvatarImages()) {
            replacer.put(avatar.getValue(),
                    ImageHelper.constructAvatarUrl(player.getName(),
                            player.getUniqueId(), avatar.getType()));
        }

        replacer.put(PlaceholdersEnum.BOT_AVATAR_URL.getValue(),
                DiscordUtil.getJda().getSelfUser().getEffectiveAvatarUrl());

        this.afterConstructor();
    }

    @Override
    protected void handleImages() {

        if (mapContainsValue(textFieldsMap, ImageNames.ITEM_IMAGE.getValue())) {
            try {
                OfflineICPlayer imagePlayer = ICPlayerFactory.getOfflineICPlayer(player.getUniqueId());
                attachmentImages
                        .add(getImage(ImageNames.ITEM_IMAGE.getValue(), getItemImage(mainHandItem, imagePlayer)));
            } catch (Throwable e) {
                // empty
                e.printStackTrace();
            }
        }

        if (mapContainsValue(textFieldsMap, ImageNames.LORE_IMAGE.getValue())) {
            attachmentImages.add(getImage(ImageNames.LORE_IMAGE.getValue(), getLoreImage(mainHandItem)));
        }

        if (mapContainsValue(textFieldsMap, ImageNames.OFFHAND_ITEM_IMAGE.getValue())) {
            try {
                OfflineICPlayer imagePlayer = ICPlayerFactory.getOfflineICPlayer(player.getUniqueId());
                attachmentImages
                        .add(getImage(ImageNames.OFFHAND_ITEM_IMAGE.getValue(),
                                getItemImage(offHandItem, imagePlayer)));
            } catch (Throwable e) {
                // empty
                e.printStackTrace();
            }
        }

        if (mapContainsValue(textFieldsMap, ImageNames.OFFHAND_LORE_IMAGE.getValue())) {
            attachmentImages.add(getImage(ImageNames.OFFHAND_LORE_IMAGE.getValue(), getLoreImage(offHandItem)));
        }

        if (mapContainsValue(textFieldsMap, ImageNames.INVENTORY_IMAGE.getValue())) {
            attachmentImages
                    .add(getImage(ImageNames.INVENTORY_IMAGE.getValue(),
                            getPlayerInventory((Inventory) player.getInventory(), player)));
        }

    }

    @Override
    protected void initConfig() {
        config = ConfigHandler.getVanillaConfig().getConfig();
    }

    @Override
    protected void initDebug() {
        debug = ConfigHandler.getMainConfig().getConfig()
                .getBoolean(MainConfigDefaults.IS_VANILLA_DEBUG.getPath());
    }

    @Override
    protected boolean isEnabled(String type) {
        enabled = config.getBoolean(type + ".Embed.Enabled")
                && ConfigHandler.getMainConfig().getIsVanillaEnabled();

        return enabled;
    }

}
