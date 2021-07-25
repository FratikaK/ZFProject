package com.github.kamunyan.zombiefloor.weapons;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * 武器の特徴を表すinterface
 * 別プラグインであるCrackShotを使用することを前提としています
 */
public interface Weapon {

    /**
     * 武器の名前を返す
     *
     * @return 武器の名前
     */
    String getWeaponTitle();

    /**
     * 武器のカテゴリを返す
     *
     * @return WeaponType
     */
    WeaponType getWeaponType();

    /**
     * 武器のマテリアルを返す
     *
     * @return Material
     */
    Material getMaterialType();

    /**
     * 武器の基礎ダメージを返す
     *
     * @return 武器ダメージ
     */
    Double getDamage();

    /**
     * 武器で使用されるItemStackを返す
     *
     * @return ItemStack
     */
    ItemStack getWeaponItem();

    /**
     * 銃弾がHitした時や銃を撃つときなど、
     * 特殊な効果を発生させたい時に使用する
     */
    void setSpecialEffects();

}
