package com.github.kamunyan.zombiefloor.listeners;

import com.github.kamunyan.zombiefloor.ZombieFloor;
import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;
import com.shampaggon.crackshot.events.WeaponExplodeEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EnemyControlListener implements Listener {
    private final ZombieFloor plugin = ZombieFloor.getInstance();

    @EventHandler
    public void onWeaponAttack(WeaponDamageEntityEvent e) {
        e.setDamage(0);
    }

    @EventHandler
    public void onExplode(WeaponExplodeEvent e) {
    }
}
