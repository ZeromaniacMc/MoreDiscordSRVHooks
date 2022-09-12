package me.zeromaniac.embed;

import org.bukkit.OfflinePlayer;
import org.bukkit.block.Container;
import me.zeromaniac.config.enums.MainConfigDefaults;
import me.zeromaniac.embed.enums.PlaceholdersEnum;
import me.zeromaniac.handlers.ConfigHandler;
import me.zeromaniac.listener.enums.ChestShopEventType;

public class ChestShopEmbed extends AbstractEmbed {

    public ChestShopEmbed(ChestShopEventType type, OfflinePlayer player, 
        String signLine1, String signLine2, String signLine3, String signLine4, String world,
        Container container, int containerPositionX, int containerPositionY,int containerPositionZ) {
        // 
            super();
            String messageType = type.getValue();

            if (!isEnabled(messageType)) {
                return;
            }

            replacer.put(PlaceholdersEnum.PLAYER.getValue(), player.getName());
            replacer.put(PlaceholdersEnum.SIGN_LINE_1.getValue(), String.valueOf(signLine1));
            replacer.put(PlaceholdersEnum.SIGN_LINE_2.getValue(), String.valueOf(signLine2));
            replacer.put(PlaceholdersEnum.SIGN_LINE_3.getValue(), String.valueOf(signLine3));
            replacer.put(PlaceholdersEnum.SIGN_LINE_4.getValue(), String.valueOf(signLine4));
            replacer.put(PlaceholdersEnum.CONTAINER_WORLD.getValue(), String.valueOf(world));
            replacer.put(PlaceholdersEnum.CONTAINER_LOC_X.getValue(), String.valueOf(containerPositionX));
            replacer.put(PlaceholdersEnum.CONTAINER_LOC_Y.getValue(), String.valueOf(containerPositionY));
            replacer.put(PlaceholdersEnum.CONTAINER_LOC_Z.getValue(), String.valueOf(containerPositionZ));


            // Memo to myself: You can't set values before getting them... order matters...
            setConfigValues(messageType);


        }

        @Override
        protected void initConfig() {
            config = ConfigHandler.getChestShopConfig().getConfig();
        }

        @Override
        protected void initDebug() {
            debug = ConfigHandler.getMainConfig().getConfig().getBoolean(MainConfigDefaults.IS_CHEST_SHOP_DEBUG_ENABLED.getPath());
        }

        @Override
        protected boolean isEnabled(String type) {
            enabled = config.getBoolean(type + ".Embed.Enabled") && ConfigHandler.getMainConfig().getIsChestShopEnabled();
            return enabled;
        }
    
}
