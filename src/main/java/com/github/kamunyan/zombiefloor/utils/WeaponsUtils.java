package com.github.kamunyan.zombiefloor.utils;

import com.github.kamunyan.zombiefloor.weapons.primary.AK12;
import com.github.kamunyan.zombiefloor.weapons.primary.PrimaryWeapon;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class WeaponsUtils {

    private ArrayList<PrimaryWeapon> primaryWeaponsList = new ArrayList<>(Arrays.asList());

    /**
     * 所持しているプレイヤーの武器のマテリアルから
     * PrimaryWeaponを取得する
     *
     * @param player 調べたいプレイヤー
     * @return  PrimaryWeapon
     */
    public PrimaryWeapon getPrimaryWeapon(Player player) {
        if (player.getInventory().getItem(0) == null) {
            return new AK12();
        }
        Material material = Objects.requireNonNull(player.getInventory().getItem(0)).getType();
        //TODO 武器リストから調べる処理
        return null;
    }
}
