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

import com.github.kaspiandev.kommons.spigot.pdc.objects.IntegerPDC;
import com.github.kaspiandev.kommons.spigot.pdc.objects.PDCObject;
import com.github.kaspiandev.kommons.spigot.pdc.objects.StringPDC;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

@SuppressWarnings("unused")
public class PDCUtils {

    private PDCUtils() {}

    public static boolean hasString(PersistentDataContainer pdc, NamespacedKey key) {
        return pdc.has(key, PersistentDataType.STRING);
    }

    public static boolean hasInteger(PersistentDataContainer pdc, NamespacedKey key) {
        return pdc.has(key, PersistentDataType.INTEGER);
    }

    public static boolean hasDouble(PersistentDataContainer pdc, NamespacedKey key) {
        return pdc.has(key, PersistentDataType.DOUBLE);
    }

    public static void setString(PersistentDataContainer pdc, NamespacedKey key, String value) {
        pdc.set(key, PersistentDataType.STRING, value);
    }

    public static void setInteger(PersistentDataContainer pdc, NamespacedKey key, Integer value) {
        pdc.set(key, PersistentDataType.INTEGER, value);
    }

    public static void setDouble(PersistentDataContainer pdc, NamespacedKey key, Double value) {
        pdc.set(key, PersistentDataType.DOUBLE, value);
    }

    public static String getString(PersistentDataContainer pdc, NamespacedKey key) {
        return pdc.get(key, PersistentDataType.STRING);
    }

    public static Integer getInteger(PersistentDataContainer pdc, NamespacedKey key) {
        return pdc.get(key, PersistentDataType.INTEGER);
    }

    public static Double getDouble(PersistentDataContainer pdc, NamespacedKey key) {
        return pdc.get(key, PersistentDataType.DOUBLE);
    }

    public static void setPDCObject(PersistentDataContainer pdc, PDCObject<?> pdcObject) {
        if (pdcObject instanceof StringPDC stringPDC) {
            setString(pdc, stringPDC.getKey(), stringPDC.getValue());
        } else if (pdcObject instanceof IntegerPDC integerPDC) {
            setInteger(pdc, integerPDC.getKey(), integerPDC.getValue());
        }
    }

}