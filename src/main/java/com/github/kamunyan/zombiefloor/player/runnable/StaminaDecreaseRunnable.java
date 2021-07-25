package com.github.kamunyan.zombiefloor.player.runnable;

import com.github.kamunyan.zombiefloor.ZombieFloor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class StaminaDecreaseRunnable extends BukkitRunnable {
    private final Player player;

    public StaminaDecreaseRunnable(Player target){
        this.player = target;
    }

    @Override
    public void run() {
        if (!player.isSprinting()||player.getFoodLevel() == 0){
            this.cancel();
            return;
        }

        if (!player.isOnline()){
            this.cancel();
            return;
        }
        player.setFoodLevel(player.getFoodLevel() - 1);
    }
}
