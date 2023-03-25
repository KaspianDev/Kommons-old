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

import java.util.List;

@SuppressWarnings("unused")
public class MultiReplacer {

    private List<String> list;

    /**
     * Constructor of the {@link MultiReplacer}.
     *
     * @param list {@link List} to work on.
     */
    public MultiReplacer(List<String> list) {
        this.list = list;
    }

    /**
     * Replace String.
     *
     * @param from {@link String} that will be replaced.
     * @param to   {@link String} that replaces parameter {@code from}.
     * @return Original {@link MultiReplacer} to continue working on.
     */
    public MultiReplacer replace(String from, String to) {
        list = list.stream()
                .map((string) -> string.replace(from, to))
                .toList();
        return this;
    }

    /**
     * Replace String but using {@link Pair}.
     *
     * @param replacingPair {@link Pair} Object to replace Left with Right.
     * @return Original {@link MultiReplacer} to continue working on.
     * @see Pair
     */
    public MultiReplacer replace(StringPair replacingPair) {
        list = list.stream()
                .map((string) -> string.replace(replacingPair.getLeft(), replacingPair.getRight()))
                .toList();
        return this;
    }

    /**
     * Build the {@link MultiReplacer} to get the resulting {@link List}.
     *
     * @return {@link List} with all previously done modifications.
     */
    public List<String> build() {
        return this.list;
    }

}
