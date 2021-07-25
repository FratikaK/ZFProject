package com.github.kamunyan.zombiefloor.utils;

import com.github.kamunyan.zombiefloor.player.ZFPlayer;
import com.github.kamunyan.zombiefloor.weapons.grenade.FlagGrenade;
import com.github.kamunyan.zombiefloor.weapons.grenade.Grenade;
import com.github.kamunyan.zombiefloor.weapons.primary.AK12;
import com.github.kamunyan.zombiefloor.weapons.primary.PrimaryWeapon;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class WeaponsUtils {

    private final static HashMap<Material, PrimaryWeapon> primaryMap = new HashMap<>() {
        {
            put(Material.WOODEN_HOE, new AK12());
        }
    };

    private final static HashMap<Material, Grenade> grenadeMap = new HashMap<>(){
        {
            put(Material.FIREWORK_STAR, new FlagGrenade());
        }
    };

    /**
     * 所持しているプレイヤーの武器のマテリアルから
     * PrimaryWeaponを取得する
     *
     * @param player 調べたいプレイヤー
     * @return PrimaryWeapon
     */
    public synchronized static PrimaryWeapon getPrimaryWeapon(Player player) {
        if (player.getInventory().getItem(0) == null) {
            return new AK12();
        }
        Material material = Objects.requireNonNull(player.getInventory().getItem(0)).getType();
        if (primaryMap.containsKey(material)) {
            return primaryMap.get(material);
        }
        return new AK12();
    }

    /**
     * ZFPlayerのプライマリ武器をインベントリにセットする
     *
     * @param target 対象のZFPlayer
     */
    public synchronized static void sendPrimaryWeapon(ZFPlayer target) {
        var inventory = target.getPlayer().getInventory();
        inventory.setItem(0, getPrimaryWeapon(target.getPlayer()).getWeaponItem());
    }

    public static void sendGrenade(ZFPlayer target,int quantity){
        var inventory = target.getPlayer().getInventory();
        inventory.setItem(2, target.getGrenade().getWeaponItem().add(quantity));
    }
}
