package com.github.kamunyan.zombiefloor.player.runnable;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class StaminaRecoveryRunnable extends BukkitRunnable {
    private final Player player;

    public StaminaRecoveryRunnable(Player target){
        this.player = target;
    }

    @Override
    public void run() {
        if (player.isSprinting() || player.getFoodLevel() == 20){
            this.cancel();
            return;
        }

        if (!player.isOnline()){
            this.cancel();
            return;
        }
        player.setFoodLevel(player.getFoodLevel() + 1);
    }
}
