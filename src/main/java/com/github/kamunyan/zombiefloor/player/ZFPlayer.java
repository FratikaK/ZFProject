package com.github.kamunyan.zombiefloor.player;

import com.github.kamunyan.zombiefloor.ZombieFloor;
import com.github.kamunyan.zombiefloor.utils.WeaponsUtils;
import com.github.kamunyan.zombiefloor.weapons.grenade.FlagGrenade;
import com.github.kamunyan.zombiefloor.weapons.grenade.Grenade;
import com.github.kamunyan.zombiefloor.weapons.primary.PrimaryWeapon;
import com.github.kamunyan.zombiefloor.weapons.secondary.SecondaryWeapon;
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
    //プレイヤーが所持するプライマリ武器
    private PrimaryWeapon primaryWeapon;
    //プレイヤーが所持するセカンダリ武器
    private SecondaryWeapon secondaryWeapon;
    //プレイヤーが所持するグレネード
    private Grenade grenade = new FlagGrenade();

    public ZFPlayer(UUID uuid) {
        player = plugin.getServer().getPlayer(uuid);
        this.uuid = uuid;
        assert player != null;
        primaryWeapon = WeaponsUtils.getPrimaryWeapon(player);
        WeaponsUtils.sendPrimaryWeapon(this);
        WeaponsUtils.sendGrenade(this,2);
    }

    @Override
    public String toString() {
        return "ZFPlayer{" +
                ", player=" + player +
                ", uuid=" + uuid.toString() +
                ", matchPlayer=" + matchPlayer +
                ", PrimaryWeapon=" + primaryWeapon.getWeaponTitle() +
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

    public int getStaminaDecreaseSpeed() {
        return staminaDecreaseSpeed;
    }

    public void setStaminaDecreaseSpeed(int staminaDecreaseSpeed) {
        this.staminaDecreaseSpeed = staminaDecreaseSpeed;
    }

    public int getStaminaRecoverySpeed() {
        return staminaRecoverySpeed;
    }

    public void setStaminaRecoverySpeed(int staminaRecoverySpeed) {
        this.staminaRecoverySpeed = staminaRecoverySpeed;
    }

    public int getDelayStaminaRestoreTime() {
        return delayStaminaRestoreTime;
    }

    public void setDelayStaminaRestoreTime(int delayStaminaRestoreTime) {
        this.delayStaminaRestoreTime = delayStaminaRestoreTime;
    }

    public PrimaryWeapon getPrimaryWeapon() {
        return primaryWeapon;
    }

    public Grenade getGrenade() {
        return grenade;
    }
}
