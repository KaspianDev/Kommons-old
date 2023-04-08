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

package com.github.kaspiandev.kommons.spigot.particles;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class BoxParticle implements ParticleObject {

    private final Location corner1;
    private final Location corner2;

    public BoxParticle(Location corner1, Location corner2) {
        this.corner1 = corner1;
        this.corner2 = corner2;
    }

    @NotNull
    @SuppressWarnings("java:S3776")
    private List<Location> getLocations(double distance) {
        World world = corner1.getWorld();
        List<Location> locations = new ArrayList<>();

        double[] xArr = {
                Math.min(corner1.getX(), corner2.getX() + 1), Math.max(corner1.getX(), corner2.getX() + 1)
        };
        double[] yArr = {
                Math.min(corner1.getY(), corner2.getY()), Math.max(corner1.getY(), corner2.getY())}
                ;
        double[] zArr = {
                Math.min(corner1.getZ(), corner2.getZ() + 1), Math.max(corner1.getZ(), corner2.getZ() + 1)
        };

        for (double x = xArr[0]; x < xArr[1]; x += distance)
            for (double y : yArr)
                for (double z : zArr) locations.add(new Location(world, x, y, z));
        for (double y = yArr[0]; y < yArr[1]; y += distance)
            for (double x : xArr)
                for (double z : zArr) locations.add(new Location(world, x, y, z));
        for (double z = zArr[0]; z < zArr[1]; z += distance)
            for (double y : yArr)
                for (double x : xArr) locations.add(new Location(world, x, y, z));


        return locations;
    }

    public BukkitTask start(Plugin plugin, Particle particle, int amount, int delay,
                            double distance, boolean isStatic) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                for (Location location : getLocations(distance)) {
                    if (location.getWorld() == null) return;
                    if (isStatic) {
                        location.getWorld().spawnParticle(particle, location,
                                amount, 0, 0, 0, 0);
                    } else {
                        location.getWorld().spawnParticle(particle, location, amount);
                    }
                }
            }
        }.runTaskTimerAsynchronously(plugin, 0, delay);
    }

    public void spawn(Plugin plugin, Particle particle, int amount,
                      double distance, boolean isStatic) {
        for (Location location : getLocations(distance)) {
            if (location.getWorld() == null) return;
            if (isStatic) {
                location.getWorld().spawnParticle(particle, location,
                        amount, 0, 0, 0, 0);
            } else {
                location.getWorld().spawnParticle(particle, location, amount);
            }
        }
    }

}
