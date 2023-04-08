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

package com.github.kaspiandev.kommons.spigot.utils;

import com.github.kaspiandev.kommons.spigot.item.rarities.RarityManager;
import com.github.kaspiandev.kommons.universal.utils.StringUtils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class ItemUtils {

    private ItemUtils() {}

    public static void removeOne(@NotNull ItemStack item) {
        item.setAmount(item.getAmount() - 1);
    }

    @NotNull
    public static String normalizeName(ItemStack item, boolean enchantColor) {
        StringBuilder builder = new StringBuilder();
        if (enchantColor) {
            switch (RarityManager.getRarity(item)) {
                case UNCOMMON -> builder.append(ChatColor.YELLOW);
                case RARE -> builder.append(ChatColor.AQUA);
                case EPIC -> builder.append(ChatColor.LIGHT_PURPLE);
                case COMMON -> builder.append(ChatColor.WHITE);
            }
        } else {
            builder.append(ChatColor.WHITE);
        }
        return builder.append(StringUtils.capitalizeEach(
                StringUtils.clearUnderscore(item.getType().name()))).toString();
    }
}
