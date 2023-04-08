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

package com.github.kaspiandev.kommons.spigot.pdc;

import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;

@SuppressWarnings("unused")
public class PDCWrapper {

    private final PersistentDataContainer pdc;
    private final NamespacedKey key;

    public PDCWrapper(PersistentDataContainer pdc, NamespacedKey key) {
        this.pdc = pdc;
        this.key = key;
    }

    public PersistentDataContainer getPdc() {
        return pdc;
    }

    public NamespacedKey getKey() {
        return key;
    }

    public boolean hasString() {
        return PDCUtils.hasString(pdc, key);
    }

    public boolean hasInteger() {
        return PDCUtils.hasInteger(pdc, key);
    }

    public boolean hasDouble() {
        return PDCUtils.hasDouble(pdc, key);
    }

    public void setString(String value) {
        PDCUtils.setString(pdc, key, value);
    }

    public void setInteger(Integer value) {
        PDCUtils.setInteger(pdc, key, value);
    }

    public void setDouble(Double value) {
        PDCUtils.setDouble(pdc, key, value);
    }

    public String getString() {
        return PDCUtils.getString(pdc, key);
    }

    public Integer getInteger() {
        return PDCUtils.getInteger(pdc, key);
    }

    public Double getDouble() {
        return PDCUtils.getDouble(pdc, key);
    }
}
