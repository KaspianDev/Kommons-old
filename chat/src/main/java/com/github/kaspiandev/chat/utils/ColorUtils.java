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

package com.github.kaspiandev.chat.utils;

import de.themoep.minedown.MineDown;
import net.md_5.bungee.api.chat.BaseComponent;

import java.util.List;

@SuppressWarnings("unused")
public class ColorUtils {

    private ColorUtils() {}

    /**
     * Colorize and format a {@link String} using MineDown.
     *
     * @param msg {@link String} to colorize.
     * @return Colored {@link String}
     */
    public static String string(String msg) {
        return BaseComponent.toLegacyText(new MineDown(msg).toComponent());
    }

    /**
     * Colorize and format a {@link List<String>} using MineDown.
     *
     * @param strings {@link List<String>} to colorize.
     * @return Colored {@link List<String>}
     */
    public static List<String> string(List<String> strings) {
        return strings.stream()
                .map(ColorUtils::string)
                .toList();
    }

    /**
     * Colorize and format a {@link String} using MineDown.
     *
     * @param msg {@link String} to colorize.
     * @return Colored {@link String}
     */
    public static BaseComponent[] component(String msg) {
        return new MineDown(msg).toComponent();
    }

    /**
     * Colorize and format a {@link List<String>} using MineDown.
     *
     * @param strings {@link List<String>} to colorize.
     * @return Colored {@link List<String>}
     */
    public static List<BaseComponent[]> component(List<String> strings) {
        return strings.stream()
                .map(ColorUtils::component)
                .toList();
    }

}
