package dev.maxprime.maxwars;

import dev.maxprime.maxwars.commands.GUICommand;
import dev.maxprime.maxwars.event.EventHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class MaxWars extends JavaPlugin {


    private static MaxWars instance;

    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new EventHandler(), this);

        getCommand("gui").setExecutor(new GUICommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
