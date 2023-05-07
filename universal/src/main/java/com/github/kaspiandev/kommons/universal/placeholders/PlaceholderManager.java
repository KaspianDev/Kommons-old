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

package com.github.kaspiandev.kommons.universal.placeholders;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@SuppressWarnings("unused")
public class PlaceholderManager {

    private String message;

    public PlaceholderManager(String message) {
        this.message = message;
    }

    public PlaceholderManager add(Placeholder placeholder) {
        this.message = placeholder.apply(message);
        return this;
    }

    public PlaceholderManager add(List<Placeholder> placeholders) {
        for (Placeholder placeholder : placeholders) {
            this.message = placeholder.apply(message);
        }
        return this;
    }

    @NotNull
    public String build() {
        return this.message;
    }

    @Nullable
    public <T> T buildAs(Class<T> clazz) {
        return clazz.isInstance(this.message) ? clazz.cast(this.message) : null;
    }

    @NotNull
    public <T> T buildAs(Class<T> clazz, T def) {
        return clazz.isInstance(this.message) ? clazz.cast(this.message) : def;
    }

}
