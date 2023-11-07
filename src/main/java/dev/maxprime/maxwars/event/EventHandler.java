package dev.maxprime.maxwars.event;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import static dev.maxprime.maxwars.commands.GUICommand.buyIron;
import static dev.maxprime.maxwars.customitems.maxCrack.getMaxCrack;
import static java.util.Objects.nonNull;

public class EventHandler implements Listener {

    @org.bukkit.event.EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Block block = e.getBlock();
        if(block.getType() == Material.TNT) {
            Vector vec = new Vector(0.5,0.5,0.5);
            Location loc = block.getLocation().add(vec);

            e.setCancelled(true);

            TNTPrimed tnt = Bukkit.getWorld("world").spawn(loc, TNTPrimed.class);

            tnt.setFuseTicks(40);
        }
    }

    @org.bukkit.event.EventHandler
    public void onWeatherChange(WeatherChangeEvent e) {
        e.setCancelled(true);
    }

    @org.bukkit.event.EventHandler
    public void clickEvent(InventoryClickEvent e) {

        if(nonNull(e.getCurrentItem())) {
            Player p = (Player) e.getWhoClicked();

            if (e.getInventory().getTitle().equals("MaxWars Shop!")) {
                e.setCancelled(true);
                switch(e.getCurrentItem().getType()) {
                    case DIAMOND_SWORD:
                        buyIron(10, p, new ItemStack(Material.DIAMOND_SWORD));
                        return;
                    case WOOL:
                        buyIron(4, p, new ItemStack(Material.WOOL, 16));
                        return;
                    case SHEARS:
                        buyIron(20, p, new ItemStack(Material.SHEARS));
                        return;
                    case POTION:
                        buyIron(30, p, getMaxCrack());
                }
            }
        }
    }


}
