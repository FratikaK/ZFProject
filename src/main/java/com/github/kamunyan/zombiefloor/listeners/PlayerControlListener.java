package com.github.kamunyan.zombiefloor.listeners;

import com.github.kamunyan.zombiefloor.ZombieFloor;
import com.github.kamunyan.zombiefloor.player.runnable.StaminaDecreaseRunnable;
import com.github.kamunyan.zombiefloor.player.runnable.StaminaRecoveryRunnable;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;


/**
 * プレイヤーが関わるリスナを処理するクラス
 */
public class PlayerControlListener implements Listener {
    private final ZombieFloor plugin = ZombieFloor.getInstance();

    /**
     * プレイヤーのブロック設置を制限する
     */
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (!e.getPlayer().isOp()) {
            e.setCancelled(true);
        }
    }

    /**
     * プレイヤーのブロック破壊を制限する
     */
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (!e.getPlayer().isOp()) {
            e.setCancelled(true);
        }
    }

    /**
     * スプリントと歩行の切り替えによって、プレイヤーのスタミナを増減する
     */
    @EventHandler
    public void onToggleSplint(PlayerToggleSprintEvent e) {
        if (e.getPlayer().getGameMode() == GameMode.CREATIVE) return;
        var zfPlayer = plugin.getManager().getZFPlayer(e.getPlayer());
        if (e.isSprinting()) {
            new StaminaDecreaseRunnable(e.getPlayer()).runTaskTimerAsynchronously(
                    plugin,
                    0,
                    zfPlayer.getStaminaDecreaseSpeed()
            );
        } else {
            new StaminaRecoveryRunnable(e.getPlayer()).runTaskTimerAsynchronously(
                    plugin,
                    zfPlayer.getDelayStaminaRestoreTime(),
                    zfPlayer.getStaminaRecoverySpeed()
            );
        }
    }

    /**
     * 通常の空腹ゲージ増減を制限する
     */
    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }
}
