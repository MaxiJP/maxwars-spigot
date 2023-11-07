package dev.maxprime.maxwars.commands;

import com.avaje.ebeaninternal.server.text.csv.CsvUtilReader;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GUICommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {

        if (s instanceof Player) {
            Player p = (Player) s;

            Inventory gui = Bukkit.createInventory(p, 45, "MaxWars Shop!");

            ItemStack item1 = new ItemStack(Material.DIAMOND_SWORD, 1);
            ItemStack item2 = new ItemStack(Material.WOOL, 16);
            ItemStack item3 = new ItemStack(Material.SHEARS, 1);
            ItemStack item4 = new ItemStack(Material.POTION, 1);

            ItemMeta item1Meta = item1.getItemMeta();
            item1Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&9Combat"));
            item1.setItemMeta(item1Meta);

            ItemMeta item2Meta = item2.getItemMeta();
            item2Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aBlocks"));
            item2.setItemMeta(item2Meta);

            ItemMeta item3Meta = item3.getItemMeta();
            item3Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fTools"));
            item3.setItemMeta(item3Meta);

            ItemMeta item4Meta = item4.getItemMeta();
            item4Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&bmax's 'good stuff'"));
            item4.setItemMeta(item4Meta);

            ItemStack[] menu_items = {item1, item2, item3, item4};
            gui.setContents(menu_items);

            p.openInventory(gui);
        } else {
            return false;
        }

        return true;
    }

    public static void buyIron(int iron, Player player, ItemStack item) {
        Inventory inv = player.getInventory();
        int i = inv.getContents().length;
        int n = 0;
        int x = 0;
        int stacks = 0;
        int irontotal = 0;

        while (n <= i) {
            if (inv.getContents()[n] == null) break;
            if (inv.getContents()[n].getType() == Material.IRON_INGOT) {
                if (inv.getContents()[n].getAmount() - iron < 0) {
                    irontotal = irontotal + inv.getContents()[n].getAmount();
                    x = n;
                } else {
                    ItemStack[] newinv = inv.getContents();
                    newinv[n].setAmount(newinv[n].getAmount() - iron);
                    inv.setContents(newinv);
                    player.getInventory().addItem(item);
                    return;
                }
                stacks++;
            }
            n++;
        }

        if (irontotal < iron) {
            player.sendMessage(ChatColor.RED + "Not enough Iron! Need " + Integer.toString(iron - irontotal) + " more.");
        } else if (irontotal >= iron) {
            ItemStack[] newinv = inv.getContents();
            newinv[x].setAmount(newinv[x].getAmount() - iron);
            inv.setContents(newinv);
            player.getInventory().addItem(item);
        }

        if (stacks == 0) {
            player.sendMessage(ChatColor.RED + "Not enough Iron! Need " + Integer.toString(iron) + " more.");
        }

    }
}
