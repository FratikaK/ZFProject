package com.github.kamunyan.zombiefloor.listeners;

import com.github.kamunyan.zombiefloor.ZombieFloor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;


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
}
