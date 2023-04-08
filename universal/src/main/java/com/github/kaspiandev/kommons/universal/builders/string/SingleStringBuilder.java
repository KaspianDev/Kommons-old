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

import com.github.kaspiandev.kommons.universal.pairs.StringPair;
import com.github.kaspiandev.kommons.universal.string.Replacer;

public class SingleStringBuilder implements StringBuilder<String> {

    protected String message;

    /**
     * A message builder that uses just a single {@link String} unlike {@link MultiStringBuilder}.
     *
     * @param message Message to initiate the object with.
     * @see MultiStringBuilder {@code MessageBuilder} using a {@code List} instead.
     */
    public SingleStringBuilder(String message) {
        this.message = message;
    }

    /**
     * Replace {@code String} from the message with something else using {@link Replacer#replace(String, String)}.
     *
     * @param from {@link String} that will be replaced.
     * @param to {@link String} that replaces parameter {@code from}.
     * @return Original {@link SingleStringBuilder}.
     */
    public SingleStringBuilder replace(String from, String to) {
        message = new Replacer(message).replace(from, to).build();
        return this;
    }

    /**
     * Replace {@code String} from the message with something else using {@link Replacer#replace(StringPair)}.
     *
     * @param pair {@link StringPair} of two elements.
     * @return Original {@link SingleStringBuilder}.
     */
    public SingleStringBuilder replace(StringPair pair) {
        message = new Replacer(message).replace(pair).build();
        return this;
    }

    /**
     * Finalize the {@link SingleStringBuilder}.
     *
     * @return {@link String} with all changes applied.
     */
    public String build() {
        return message;
    }
}
