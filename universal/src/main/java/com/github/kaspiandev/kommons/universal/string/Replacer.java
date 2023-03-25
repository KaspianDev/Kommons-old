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

package com.github.kaspiandev.kommons.universal.string;

import com.github.kaspiandev.kommons.universal.pairs.Pair;
import com.github.kaspiandev.kommons.universal.pairs.StringPair;

@SuppressWarnings("unused")
public class Replacer {

    private String string;

    /**
     * Constructor of the {@link Replacer}.
     *
     * @param string {@link String} to work on.
     */
    public Replacer(String string) {
        this.string = string;
    }

    /**
     * Replace String.
     *
     * @param from {@link String} that will be replaced.
     * @param to   {@link String} that replaces parameter {@code from}.
     * @return Original {@link Replacer} to continue working on.
     */
    public Replacer replace(String from, String to) {
        this.string = string.replace(from, to);
        return this;
    }

    /**
     * Replace String but using {@link Pair}.
     *
     * @param replacingPair {@link Pair} Object to replace Left with Right.
     * @return Original {@link Replacer} to continue working on.
     * @see Pair
     */
    public Replacer replace(StringPair replacingPair) {
        this.string = string.replace(replacingPair.getLeft(), replacingPair.getRight());
        return this;
    }

    /**
     * Build the {@link Replacer} to get the resulting {@link String}.
     *
     * @return {@link String} with all previously done modifications.
     */
    public String build() {
        return this.string;
    }

}
