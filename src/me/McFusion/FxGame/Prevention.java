package me.McFusion.FxGame;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.*;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class Prevention implements Listener {

    private boolean blockBreak;

    public boolean setBlockBreak(boolean b) {
        return blockBreak = b;
    }


    @EventHandler
    public void blockBreakEvent(BlockBreakEvent e) {
        if (!blockBreak) {
            e.setCancelled(true);
            Player p = e.getPlayer();
            p.sendMessage("Block Breaking is disabled!");
        }
    }

    private boolean blockPlace;

    public boolean setBlockPlace(boolean b) {
        return blockPlace = b;
    }

    @EventHandler
    public void blockPlaceEvent(BlockPlaceEvent e) {
        if (!blockPlace) {
            e.setCancelled(true);
            Player p = e.getPlayer();
            p.sendMessage("Block Placing is disabled!");
        }
    }

    private boolean dropItem;

    public boolean setDropItem(boolean b) {
        return dropItem = b;
    }

    @EventHandler
    public void dropItemEvent(PlayerDropItemEvent e) {
        if (!dropItem) {
            e.setCancelled(true);
            Player p = e.getPlayer();
            p.sendMessage("You cannot drop that here!");
        }
    }

    private boolean pickupItem;

    public boolean setPickupItem(boolean b) {
        return pickupItem = b;
    }

    @EventHandler
    public void pickupItemEvent(PlayerPickupItemEvent e) {
        if (!pickupItem) {
            e.setCancelled(true);
            Player p = e.getPlayer();
            p.sendMessage("You cannot pick that up here!");
        }
    }

    private boolean entityDamagePlayer;

    public boolean setEntityDamagePlayer(boolean b) {
        return entityDamagePlayer = b;
    }

    @EventHandler
    public void entityDamagePlayerEvent(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && !(e.getDamager() instanceof Player)) {
            if (!entityDamagePlayer) e.setCancelled(true);
        }
    }
}
