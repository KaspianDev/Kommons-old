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

package com.github.kaspiandev.kommons.spigot.builders;

import com.github.kaspiandev.kommons.spigot.exceptions.NullLocationWorldException;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Set;

@SuppressWarnings("unused")
public class SoundBuilder {

    private final Sound sound;
    private float pitch = 1;
    private float volume = 1;

    public SoundBuilder(Sound sound) {
        this.sound = sound;
    }

    public SoundBuilder setPitch(float pitch) {
        this.pitch = pitch;
        return this;
    }

    public SoundBuilder setVolume(float volume) {
        this.volume = volume;
        return this;
    }

    public void send(Player player) {
        player.playSound(player, sound, volume, pitch);
    }

    public void send(Set<Player> players) {
        players.forEach(this::send);
    }

    public void send(Location location) {
        World world = location.getWorld();
        if (world == null) throw new NullLocationWorldException(location);
        world.playSound(location, sound, volume, pitch);
    }

}
