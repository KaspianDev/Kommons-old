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

package com.github.kaspiandev.kommons.spigot.pdc.objects;

import org.bukkit.NamespacedKey;

public class IntegerPDC extends CommonPDC<Integer> implements PDCObject<Integer> {

    public IntegerPDC(NamespacedKey key, Integer value) {
        super(key, value);
    }

    @Override
    public Integer getValue() {
        return super.value;
    }

    @Override
    public void setValue(Integer value) {
        super.value = value;
    }

}