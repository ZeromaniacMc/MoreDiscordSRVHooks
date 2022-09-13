package me.zeromaniac.Adapters;

import org.bukkit.inventory.EntityEquipment;

import com.loohp.interactivechat.objectholders.OfflineICPlayer;

public class OfflineICPlayerAdapter extends OfflineICPlayer {

    private OfflineICPlayer player;

    public OfflineICPlayerAdapter(OfflineICPlayer player) {
        super(player.getUniqueId(), player.getName(), player.getSelectedSlot(), player.isRightHanded(), player.getExperienceLevel(), player.getInventory(), player.getEnderChest());
        this.player = player;
    }

    @Override
    public void setEquipment(EntityEquipment remoteEquipment) {
        this.remoteEquipment = remoteEquipment;
    }
}
