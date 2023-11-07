package dev.maxprime.maxwars.customitems;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class maxCrack {

    public static ItemStack getMaxCrack() {
        ItemStack maxCrackPotion = new ItemStack(Material.POTION, 1);
        PotionMeta maxCrackPotionMeta = (PotionMeta) maxCrackPotion.getItemMeta();

        maxCrackPotionMeta.setDisplayName("§r§fmax's \"good stuff\"");
        List<String> lore = new ArrayList<String>();
        lore.add("§fTrust me, it's not crack cocaine. defo...");

        maxCrackPotionMeta.setLore(lore);
        maxCrackPotionMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 248, 1), true);
        maxCrackPotionMeta.addCustomEffect(new PotionEffect(PotionEffectType.JUMP, 173, 4), true);

        maxCrackPotion.setItemMeta(maxCrackPotionMeta);
        Potion po = new Potion((byte) 8258).splash();
        po.apply(maxCrackPotion);

        return maxCrackPotion;
    }

}
