package com.github.kamunyan.zombiefloor.weapons.grenade;

import com.github.kamunyan.zombiefloor.weapons.Weapon;
import org.jetbrains.annotations.NotNull;

public interface Grenade extends Weapon {

    /**
     * 爆発範囲
     *
     * @return
     */
    Double getRadius();

    /**
     * 爆発ダメージの距離減衰値
     *
     * @return ブロック1マス毎のダメージ減衰値
     */
    Double getDecay();
}
