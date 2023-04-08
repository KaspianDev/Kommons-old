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

import java.util.Collections;
import java.util.List;

public class MultiStringBuilder implements StringBuilder<List<String>> {

    protected List<String> messages;

    /**
     * Create a {@link MultiStringBuilder} using a single message.
     * Usually not recommended, use {@link SingleStringBuilder} instead.
     *
     * @param message Message to initiate the list with.
     * @see SingleStringBuilder
     */
    public MultiStringBuilder(String message) {
        this.messages = Collections.singletonList(message);
    }

    /**
     * Create a {@link MultiStringBuilder} using a list of messages.
     *
     * @param messages Messages to initiate the list with.
     */
    public MultiStringBuilder(List<String> messages) {
        this.messages = messages;
    }

    /**
     * Replace all Strings from messages with something else using {@link Replacer#replace(String, String)}.
     *
     * @param from {@link String} that will be replaced.
     * @param to   {@link String} that replaces parameter {@code from}.
     * @return Original {@link MultiStringBuilder}.
     */
    public MultiStringBuilder replace(String from, String to) {
        messages = messages.stream()
                .map((message) -> new Replacer(message).replace(from, to).build())
                .toList();
        return this;
    }

    /**
     * Replace all Strings from messages with something else using {@link Replacer#replace(StringPair)}.
     *
     * @param pair {@link StringPair} of two elements.
     * @return Original {@link MultiStringBuilder}.
     */
    public MultiStringBuilder replace(StringPair pair) {
        messages = messages.stream()
                .map((message) -> new Replacer(message).replace(pair).build())
                .toList();
        return this;
    }

    /**
     * Finalize the {@link MultiStringBuilder}.
     *
     * @return {@link List<String>} with all changes applied.
     */
    public List<String> build() {
        return messages;
    }

}
