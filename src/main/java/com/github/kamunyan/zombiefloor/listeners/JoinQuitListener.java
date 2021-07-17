package com.github.kamunyan.zombiefloor.listeners;

import com.github.kamunyan.zombiefloor.ZombieFloor;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class JoinQuitListener implements Listener {
    private final ZombieFloor plugin = ZombieFloor.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        var player = e.getPlayer();

        player.teleport(Objects.requireNonNull(plugin.getServer().getWorld("world")).getSpawnLocation());
        e.setJoinMessage(ChatColor.AQUA + player.getDisplayName() + "がログインしました");

        if (!player.isOp()){
            player.setGameMode(GameMode.ADVENTURE);
        }

        player.setHealth(player.getHealthScale());
        player.setFoodLevel(20);

        plugin.getManager().addGamePlayer(player);
    }
}
