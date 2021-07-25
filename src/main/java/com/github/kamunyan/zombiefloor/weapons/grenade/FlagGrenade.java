package com.github.kamunyan.zombiefloor.weapons.grenade;

import com.github.kamunyan.zombiefloor.weapons.WeaponType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class FlagGrenade implements Grenade{
    @Override
    public String getWeaponTitle() {
        return "フラググレネード";
    }

    @Override
    public WeaponType getWeaponType() {
        return WeaponType.GRENADE;
    }

    @Override
    public Material getMaterialType() {
        return Material.FIREWORK_STAR;
    }

    @Override
    public Double getDamage() {
        return 20.0;
    }

    @Override
    public ItemStack getWeaponItem() {
        return new ItemStack(getMaterialType());
    }

    @Override
    public void setSpecialEffects() {

    }

    @Override
    public Double getRadius() {
        return 8.0;
    }

    @Override
    public Double getDecay() {
        return 1.5;
    }
}
