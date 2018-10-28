package org.codespeak.windowshopping;

import java.util.ArrayList;
import java.util.List;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;
import org.codespeak.windowshopping.listeners.BukkitInventoryListener;

/**
 *
 * @author Vector
 */
public class WindowShopping extends JavaPlugin {

    private List<Listener> listeners;
    private Economy economy;

    @Override
    public void onEnable() {
        listeners = new ArrayList<Listener>();
        listeners.add(new BukkitInventoryListener(this));

        PluginManager manager = super.getServer().getPluginManager();

        for (Listener listener : listeners) {
            manager.registerEvents(listener, this);
        }

        RegisteredServiceProvider<Economy> econProvider = super.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        economy = econProvider.getProvider();
    }

    @Override
    public void onDisable() {

    }

}
