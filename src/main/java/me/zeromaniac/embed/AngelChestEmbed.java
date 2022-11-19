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
import me.zeromaniac.listener.enums.*;
import me.zeromaniac.handlers.ConfigHandler;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import static me.zeromaniac.common.StringHelper.mapContainsValue;
import static me.zeromaniac.common.ImageHelper.getPlayerInventory;
import static me.zeromaniac.common.ImageHelper.getItemImage;
import static me.zeromaniac.common.ImageHelper.getLoreImage;
import static me.zeromaniac.common.ImageHelper.getImage;

public class AngelChestEmbed extends AbstractEmbed {

    public AngelChestEmbed(AngelChestEventType type, OfflinePlayer player, Inventory angelChestContents,
            int chestPositionX,
            int chestPositionY, int chestPositionZ,
            int experience, String world,
            String unlockIn, boolean isProtected, ItemStack mainHandItem, ItemStack offHandItem, String timeLeft,
            String itemCount, int deathPositionX, int deathPositionY, int deathPositionZ, String playerDeathWorld) {
        super();
        messageType = type.getValue();

        if (!isEnabled(messageType)) {
            return;
        }
        this.player = (Player) player;

        replacer.put(PlaceholdersEnum.PLAYER.getValue(), player.getName());
        replacer.put(PlaceholdersEnum.XP.getValue(), String.valueOf(experience));
        replacer.put(PlaceholdersEnum.CHEST_LOC_X.getValue(), String.valueOf(chestPositionX));
        replacer.put(PlaceholdersEnum.CHEST_LOC_Y.getValue(), String.valueOf(chestPositionY));
        replacer.put(PlaceholdersEnum.CHEST_LOC_Z.getValue(), String.valueOf(chestPositionZ));
        replacer.put(PlaceholdersEnum.DEATH_LOC_X.getValue(), String.valueOf(deathPositionX));
        replacer.put(PlaceholdersEnum.DEATH_LOC_Y.getValue(), String.valueOf(deathPositionY));
        replacer.put(PlaceholdersEnum.DEATH_LOC_Z.getValue(), String.valueOf(deathPositionZ));
        replacer.put(PlaceholdersEnum.UNLOCK_TIME.getValue(), String.valueOf(unlockIn));
        replacer.put(PlaceholdersEnum.IS_PROTECTED.getValue(), String.valueOf(isProtected));
        replacer.put(PlaceholdersEnum.CHEST_WORLD.getValue(), String.valueOf(world));
        replacer.put(PlaceholdersEnum.PLAYER_WORLD.getValue(), String.valueOf(world));
        replacer.put(PlaceholdersEnum.EXPIRY.getValue(), String.valueOf(timeLeft));
        replacer.put(PlaceholdersEnum.ITEM_COUNT.getValue(), String.valueOf(itemCount));

        replacer.put(PlaceholdersEnum.OFFHAND_ITEM_URL.getValue(), 
                attachmentType + ImageNames.ITEM_IMAGE.getValue());

        replacer.put(PlaceholdersEnum.OFFHAND_ITEM_LORE_URL.getValue(),
                attachmentType + ImageNames.LORE_IMAGE.getValue());

        replacer.put(PlaceholdersEnum.INVENTORY_IMAGE_URL.getValue(),
                attachmentType + ImageNames.INVENTORY_IMAGE.getValue());

        for (AvatarImages avatar : Avatars.PLAYER.getAvatarImages()) {
            replacer.put(avatar.getValue(),
                    ImageHelper.constructAvatarUrl(player.getName(), 
                        player.getUniqueId(), avatar.getType()));
        }

        replacer.put(PlaceholdersEnum.BOT_AVATAR_URL.getValue(),
                DiscordUtil.getJda().getSelfUser().getEffectiveAvatarUrl());

        setConfigValues(messageType);

        if (mapContainsValue(textFieldsMap, ImageNames.INVENTORY_IMAGE.getValue())) {
            try {
                attachmentImages.add(getImage(ImageNames.INVENTORY_IMAGE.getValue(),
                        getPlayerInventory(angelChestContents, player, mainHandItem, offHandItem)));
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

        if (mapContainsValue(textFieldsMap, ImageNames.ITEM_IMAGE.getValue()) && offHandItem != null) {
            try {
                OfflineICPlayer imagePlayer = ICPlayerFactory.getOfflineICPlayer(player.getUniqueId());
                attachmentImages
                        .add(getImage(ImageNames.ITEM_IMAGE.getValue(), getItemImage(offHandItem, imagePlayer)));
            } catch (Throwable e) {
                // empty
            }
        }

        if (mapContainsValue(textFieldsMap, ImageNames.LORE_IMAGE.getValue()) && offHandItem != null) {
            attachmentImages.add(getImage(ImageNames.LORE_IMAGE.getValue(), getLoreImage(offHandItem)));
        }
    }

    @Override
    protected void initConfig() {
        config = ConfigHandler.getAngelChestConfig().getConfig();
    }

    @Override
    protected void initDebug() {
        debug = ConfigHandler.getMainConfig().getConfig().getBoolean(MainConfigDefaults.IS_ANGEL_CHEST_DEBUG.getPath());
    }

    @Override
    protected boolean isEnabled(String type) {
        enabled = config.getBoolean(type + ".Embed.Enabled") && ConfigHandler.getMainConfig().getIsAngleChestEnabled();

        return enabled;
    }
}
