package com.github.kamunyan.zombiefloor;

import com.github.kamunyan.zombiefloor.player.ZFPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class MatchManager {
    private final ZombieFloor plugin = ZombieFloor.getInstance();
    //サーバー上のプレイヤーHashMap
    private final HashMap<UUID, ZFPlayer> gamePlayers;
    //マッチプレイヤーのリスト
    private final ArrayList<ZFPlayer> matchPlayers;

    protected MatchManager() {
        gamePlayers = new HashMap<>();
        matchPlayers = new ArrayList<>();
    }

    /**
     * サーバー上のプレイヤーとしてZFプレイヤーを作成する
     *
     * @param player 格納したいプレイヤー
     */
    public synchronized void addGamePlayer(Player player) {
        if (gamePlayers.containsKey(player.getUniqueId())) {return;}
        gamePlayers.put(player.getUniqueId(),new ZFPlayer(player.getUniqueId()));
        plugin.sendLog(player.getDisplayName()+"のZFPlayerを作成しました");
        plugin.sendLog(gamePlayers.get(player.getUniqueId()).toString());
    }

    public ArrayList<ZFPlayer> getMatchPlayers() {
        return matchPlayers;
    }
}
