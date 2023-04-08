package com.github.kaspiandev.kommons.spigot.utils;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.Plugin;

public class EnchantUtils {

    private EnchantUtils() {}

    public static Enchantment getByName(Plugin plugin, String name) {
        return Enchantment.getByKey(new NamespacedKey(plugin, name));
    }

}
