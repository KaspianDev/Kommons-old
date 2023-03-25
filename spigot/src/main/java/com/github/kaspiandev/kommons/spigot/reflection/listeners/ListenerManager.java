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

package com.github.kaspiandev.kommons.spigot.reflection.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.reflections.Reflections;

import java.util.Set;

@SuppressWarnings("unused")
public class ListenerManager {

    private final Plugin plugin;
    private final Set<Class<? extends Listener>> listenerSet;

    public ListenerManager(@NotNull Plugin plugin, String packageName) {
        this.plugin = plugin;
        this.listenerSet = new Reflections(plugin.getClass()
                .getPackageName() + '.' + packageName + '.').getSubTypesOf(Listener.class);
    }

    public void build() {
        for (Class<? extends Listener> clazz : listenerSet) {
            try {
                Bukkit.getPluginManager().registerEvents(clazz.getDeclaredConstructor().newInstance(), plugin);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
