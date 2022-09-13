package me.zeromaniac.Adapters;

import org.bukkit.inventory.EntityEquipment;

import com.loohp.interactivechat.objectholders.OfflineICPlayer;

import alexh.Fluent.Map;

public class OfflineICPlayerAdapter extends OfflineICPlayer {

    private OfflineICPlayer player;
    private Map<String, Object> properties;

    public OfflineICPlayerAdapter(OfflineICPlayer player) {
        super(player.getUniqueId(), player.getName(), player.getSelectedSlot(), player.isRightHanded(), player.getExperienceLevel(), player.getInventory(), player.getEnderChest());

        this.properties = (Map<String, Object>) player.getProperties();

        this.player = player;
    }

    @Override
    public void setEquipment(EntityEquipment remoteEquipment) {
        this.remoteEquipment = remoteEquipment;
    }
}
