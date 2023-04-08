/*
 *     Kommons - Set of common utilities for my projects.
 *     Copyright (C) 2023 Kaspian
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as
 *     published by the Free Software Foundation, either version 3 of the
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.github.kaspiandev.kommons.spigot.serializers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public class LocationSerializer {

    public static String serialize(Location location) {
        if (location == null || location.getWorld() == null) return null;
        return location.getWorld().getName() +
                ":" +
                location.getBlockX() +
                ":" +
                location.getBlockY() +
                ":" +
                location.getBlockZ();
    }

    @Nullable
    public static Location unserialize(@NotNull String location) {
        String[] keys = location.split(":");
        if (keys.length != 4) return null;
        return new Location(Bukkit.getWorld(keys[0]),
                Double.parseDouble(keys[1]),
                Double.parseDouble(keys[2]),
                Double.parseDouble(keys[3]));
    }

    public static boolean validate(@NotNull String location) {
        String[] keys = location.split(":");
        if (keys.length != 4) return false;
        if (Bukkit.getWorld(keys[0]) == null) return false;
        for (String key : keys) {
            if (key.equals(keys[0])) continue;
            try {
                Double.parseDouble(key);
            } catch (NumberFormatException ex) {
                return false;
            }
        }
        return true;
    }

}
