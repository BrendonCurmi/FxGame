package me.McFusion.FxGame.APIs;

import me.McFusion.FxGame.FxGame;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class BungeeAPI {

    public static void sendToServer(Player p, String targetServer) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(targetServer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        p.sendPluginMessage(FxGame.plugin, "BungeeCord", b.toByteArray());
    }

    public static void disconnectTo(Player player, String server, String reason) {
        sendToServer(player, server);

        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(FxGame.plugin, () -> {
            player.sendMessage("§c§lYou were disconnected from that server");
            player.sendMessage(reason.replace("&", "§"));
        }, 10L);
    }
}
