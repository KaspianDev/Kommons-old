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
public class Pair<L, R> {

    private L left;
    private R right;

    /**
     * Create a {@link Pair} of two elements with the
     * same type.
     *
     * @param left  Left part of the {@link Pair}
     * @param right Right part of the {@link Pair}
     */
    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Get left side of the {@link Pair}.
     *
     * @return Left side of the {@link Pair}
     */
    public L getLeft() {
        return left;
    }

    /**
     * Get right side of the {@link Pair}.
     *
     * @return Right side of the {@link Pair}
     */
    public R getRight() {
        return right;
    }

    /**
     * Set left side of the {@link Pair}.
     */
    public void setLeft(L value) {
        this.left = value;
    }

    /**
     * Set right side of the {@link Pair}.
     */
    public void setRight(R value) {
        this.right = value;
    }

}
