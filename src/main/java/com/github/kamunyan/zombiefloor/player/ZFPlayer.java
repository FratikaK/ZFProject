package com.github.kamunyan.zombiefloor.player;

import com.github.kamunyan.zombiefloor.ZombieFloor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ZFPlayer {
    private final ZombieFloor plugin = ZombieFloor.getInstance();
    //プレイヤーのPlayer型
    private Player player;
    //プレイヤーのUUID
    private UUID uuid;
    //マッチプレイヤーか
    private Boolean matchPlayer = false;

    public ZFPlayer(UUID uuid){
        player = plugin.getServer().getPlayer(uuid);
        uuid = this.uuid;
    }

    @Override
    public String toString() {
        return "ZFPlayer{" +
                ", player=" + player +
                ", uuid=" + uuid +
                ", matchPlayer=" + matchPlayer +
                '}';
    }

    public Player getPlayer() {
        return player;
    }

    public Boolean isMatchPlayer() {
        return matchPlayer;
    }

    public void setMatchPlayer(Boolean matchPlayer) {
        this.matchPlayer = matchPlayer;
    }

}
