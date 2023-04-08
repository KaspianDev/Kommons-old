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

package com.github.kaspiandev.kommons.spigot.item.rarities;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class RarityManager {

    private RarityManager() {}

    public static boolean hasRarity(@NotNull ItemStack item) {
        return (ItemRarities.valueOf(item.getType().name()).getMaterial() == item.getType());
    }

    public static Rarity getRarity(@NotNull ItemStack item) {
        if (!item.getEnchantments().isEmpty()) return Rarity.RARE;
        if (hasRarity(item)) return ItemRarities.valueOf(item.getType().name()).getRarity();
        return Rarity.COMMON;
    }

}
