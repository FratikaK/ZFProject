package com.github.kamunyan.zombiefloor;

import com.github.kamunyan.zombiefloor.listeners.JoinQuitListener;
import com.github.kamunyan.zombiefloor.listeners.PlayerControlListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

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
