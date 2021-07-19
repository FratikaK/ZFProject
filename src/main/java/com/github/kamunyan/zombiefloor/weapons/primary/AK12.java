package com.github.kamunyan.zombiefloor.weapons.primary;

import org.bukkit.Material;

public class AK12 implements PrimaryWeapon{

    @Override
    public String getWeaponTitle() {
        return "AK12";
    }

    @Override
    public Material getMaterialType() {
        return Material.WOODEN_HOE;
    }

    @Override
    public boolean isFullyAutomatic() {
        return true;
    }

    @Override
    public double getDamage() {
        return 0;
    }

    @Override
    public void setEffects() {

    }
}
