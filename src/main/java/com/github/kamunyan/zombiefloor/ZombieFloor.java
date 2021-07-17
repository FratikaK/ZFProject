package com.github.kamunyan.zombiefloor;

import com.github.kamunyan.zombiefloor.listeners.JoinQuitListener;
import com.github.kamunyan.zombiefloor.listeners.PlayerControlListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class ZombieFloor extends JavaPlugin {

    private static ZombieFloor instance;
    private final MatchManager manager = new MatchManager();

    @Override
    public void onEnable() {
        instance = this;

        registerEvents(new JoinQuitListener());
        registerEvents(new PlayerControlListener());
    }

    @Override
    public void onDisable() {
    }

    /**
     * 通常のlogを出力する
     *
     * @param log 出力したいログ
     */
    public void sendLog(@NotNull String log) {
        Bukkit.getLogger().info(ChatColor.AQUA + log);
    }

    /**
     * 警告を意味するlogを出力する
     *
     * @param warnLog 出力したい警告のlog
     */
    public void sendWarnLog(@NotNull String warnLog) {
        Bukkit.getLogger().info(ChatColor.RED + warnLog);
    }

    /**
     * onEnableでリスナを登録する
     *
     * @param listener 登録したいリスナ
     */
    private void registerEvents(Listener listener) {
        this.getServer().getPluginManager().registerEvents(listener, this);
    }

    public static ZombieFloor getInstance() {
        return instance;
    }

    public MatchManager getManager() {
        return manager;
    }
}
