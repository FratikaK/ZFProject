package com.github.kamunyan.zombiefloor.weapons.primary;

import com.github.kamunyan.zombiefloor.weapons.WeaponType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class AK12 implements PrimaryWeapon {

    @Override
    public String getWeaponTitle() {
        return "AK12";
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.ASSAULT_RIFLE;
    }

    @Override
    public Material getMaterialType() {
        return Material.WOODEN_HOE;
    }

    @Override
    public Double getDamage() {
        return 8.0;
    }

    @Override
    public Double getHeadShotDamage() {
        return 2.0;
    }

    @Override
    public ItemStack getWeaponItem() {
        return new ItemStack(getMaterialType());
    }

    @Override
    public void setSpecialEffects() {

    }

    @Override
    public Boolean isFullyAutomatic() {
        return true;
    }

    @Override
    public Boolean isBurstShot() {
        return false;
    }
}
