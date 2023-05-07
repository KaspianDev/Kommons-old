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

package com.github.kaspiandev.kommons.universal.builders.string;

import com.github.kaspiandev.kommons.universal.placeholders.Placeholder;
import com.github.kaspiandev.kommons.universal.string.Replacer;

@SuppressWarnings("unused")
public class SingleStringBuilder implements StringBuilder<String> {

    protected String message;

    public SingleStringBuilder(String message) {
        this.message = message;
    }

    public SingleStringBuilder replace(String from, String to) {
        message = new Replacer(message).replace(from, to).build();
        return this;
    }

    public SingleStringBuilder apply(Placeholder placeholder) {
        message = placeholder.apply(message);
        return this;
    }

    public String build() {
        return message;
    }

}
