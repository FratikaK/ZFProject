package com.github.kamunyan.zombiefloor.weapons.primary;

import com.github.kamunyan.zombiefloor.weapons.Weapon;
import org.bukkit.Material;

/**
 * プライマリ武器を表現するinterface
 */
public interface PrimaryWeapon extends Weapon {

    /**
     * 連射可能武器かのbool値を返す
     */
    Boolean isFullyAutomatic();

    /**
     * バースト射撃可能かのbool値を返す
     */
    Boolean isBurstShot();

    /**
     * ヘッドショットした時の追加のダメージを返す
     *
     * @return HeadShotダメージ
     */
    Double getHeadShotDamage();
}
