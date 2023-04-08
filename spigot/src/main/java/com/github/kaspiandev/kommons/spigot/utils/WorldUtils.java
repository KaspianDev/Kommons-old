package com.github.kaspiandev.kommons.spigot.utils;

import org.bukkit.Location;
import org.bukkit.World;

public class WorldUtils {

    private WorldUtils() {}

    public String getSafeWorldName(Location location) {
        World world = location.getWorld();
        return (world == null) ? "unknown" : world.getName();
    }

}
