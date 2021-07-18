package com.github.kamunyan.zombiefloor;

import com.github.kamunyan.zombiefloor.player.ZFPlayer;
import org.bukkit.Bukkit;
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
        if (gamePlayers.containsKey(player.getUniqueId())) {
            return;
        }
        gamePlayers.put(player.getUniqueId(), new ZFPlayer(player.getUniqueId()));
        Bukkit.getLogger().info(player.getDisplayName() + "のZFPlayerを作成しました");
        Bukkit.getLogger().info(gamePlayers.get(player.getUniqueId()).toString());
    }

    /**
     * ZFPlayerを取得する
     * なければZFPlayerを作成してreturn
     *
     * @param target 対象のプレイヤー
     * @return ZFPlayer
     */
    public ZFPlayer getZFPlayer(Player target) {
        if (!gamePlayers.containsKey(target.getUniqueId())) {
            addGamePlayer(target);
        }
        return gamePlayers.get(target.getUniqueId());
    }

    public ArrayList<ZFPlayer> getMatchPlayers() {
        return matchPlayers;
    }
}
