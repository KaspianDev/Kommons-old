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

package com.github.kaspiandev.kommons.universal.builders;

import com.github.kaspiandev.kommons.universal.pairs.StringPair;
import com.github.kaspiandev.kommons.universal.string.Replacer;

import java.util.List;

@SuppressWarnings("unused")
public class SplitStringBuilder implements StringBuilder<String> {

    protected java.lang.StringBuilder message;

    public SplitStringBuilder(String message) {
        this.message = new java.lang.StringBuilder(message).append("\n");
    }

    public SplitStringBuilder(List<String> messages) {
        messages.forEach((line) -> message.append(line).append("\n"));
    }

    public SplitStringBuilder replace(String from, String to) {
        message = new java.lang.StringBuilder(new Replacer(message.toString()).replace(from, to).build());
        return this;
    }

    public SplitStringBuilder replace(StringPair pair) {
        message = new java.lang.StringBuilder(new Replacer(message.toString()).replace(pair).build());
        return this;
    }

    public String build() {
        return message.toString();
    }

}
