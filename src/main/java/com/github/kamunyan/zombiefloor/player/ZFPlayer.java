package com.github.kamunyan.zombiefloor.player;

import com.github.kamunyan.zombiefloor.ZombieFloor;
import com.github.kamunyan.zombiefloor.player.runnable.StaminaDecreaseRunnable;
import com.github.kamunyan.zombiefloor.player.runnable.StaminaRecoveryRunnable;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * ZombieFloorにおけるプレイヤーを表現するクラス
 */
public class ZFPlayer {
    private final ZombieFloor plugin = ZombieFloor.getInstance();
    //プレイヤーのPlayer型
    private final Player player;
    //プレイヤーのUUID
    private final UUID uuid;
    //マッチプレイヤーか
    private Boolean matchPlayer = false;
    //スタミナ減少速度
    private int staminaDecreaseSpeed = 8;
    //スタミナ回復速度
    private int staminaRecoverySpeed = 12;
    //スタミナが回復し始めるまでの遅延時間
    private int delayStaminaRestoreTime = 60;

    public ZFPlayer(UUID uuid) {
        player = plugin.getServer().getPlayer(uuid);
        this.uuid = uuid;
    }

    public void runStaminaDecreaseRunnable() {
        new StaminaDecreaseRunnable(player).runTaskTimerAsynchronously(
                plugin,
                0,
                staminaDecreaseSpeed);
    }

    public void runStaminaRecoveryRunnable() {
        new StaminaRecoveryRunnable(player).runTaskTimerAsynchronously(
                plugin,
                delayStaminaRestoreTime,
                staminaRecoverySpeed);
    }

    @Override
    public String toString() {
        return "ZFPlayer{" +
                ", player=" + player +
                ", uuid=" + uuid +
                ", matchPlayer=" + matchPlayer +
                '}';
    }

    public Player getPlayer() {
        return player;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Boolean isMatchPlayer() {
        return matchPlayer;
    }

    public void setMatchPlayer(Boolean matchPlayer) {
        this.matchPlayer = matchPlayer;
    }

    public void setStaminaDecreaseSpeed(int staminaDecreaseSpeed) {
        this.staminaDecreaseSpeed = staminaDecreaseSpeed;
    }

    public void setStaminaRecoverySpeed(int staminaRecoverySpeed) {
        this.staminaRecoverySpeed = staminaRecoverySpeed;
    }

    public void setDelayStaminaRestoreTime(int delayStaminaRestoreTime) {
        this.delayStaminaRestoreTime = delayStaminaRestoreTime;
    }
}
