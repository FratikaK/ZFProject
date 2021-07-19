package com.github.kamunyan.zombiefloor.weapons.primary;

import org.bukkit.Material;

/**
 * プライマリ武器を表現するクラス
 */
interface PrimaryWeapon {

    String getWeaponTitle();

    /**
     * 武器のマテリアルのタイプを取得する
     *
     * @return アイテムのマテリアル
     */
    Material getMaterialType();

    /**
     * 連射可能武器かのboolean
     *
     * @return 連射武器である
     */
    boolean isFullyAutomatic();

    /**
     * 武器の基礎ダメージを取得する
     *
     * @return 基礎ダメージ
     */
    double getDamage();

    /**
     * 攻撃が命中した時に特別な効果を発生させる
     */
    void setEffects();
}
