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

package com.github.kaspiandev.kommons.universal.pairs;

@SuppressWarnings("unused")
public class StringPair extends Pair<String, String> {

    /**
     * Create a {@link Pair} of two elements with the
     * same type.
     *
     * @param left  Left part of the {@link Pair}
     * @param right Right part of the {@link Pair}
     */
    public StringPair(String left, String right) {
        super(left, right);
    }

    /**
     * Replace content of {@link String} using the {@link StringPair}.
     *
     * @param string {@link String} to work on.
     * @return {@link String} with replaced content.
     */
    public String replace(String string) {
        return string.replace(getLeft(), getRight());
    }

}
