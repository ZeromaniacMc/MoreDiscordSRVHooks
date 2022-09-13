package me.zeromaniac.Adapters;

import java.util.Map;

import org.bukkit.inventory.EntityEquipment;

import com.loohp.interactivechat.objectholders.OfflineICPlayer;


public class OfflineICPlayerAdapter extends OfflineICPlayer {

    private OfflineICPlayer player;
    private Map<String, Object> properties;

    public OfflineICPlayerAdapter(OfflineICPlayer player) {
        super(player.getUniqueId(), player.getName(), player.getSelectedSlot(), player.isRightHanded(), player.getExperienceLevel(), player.getInventory(), player.getEnderChest());

        properties = player.getProperties();

        this.player = player;
    }

    @Override
    public void setEquipment(EntityEquipment remoteEquipment) {
        this.remoteEquipment = remoteEquipment;
    }
}
