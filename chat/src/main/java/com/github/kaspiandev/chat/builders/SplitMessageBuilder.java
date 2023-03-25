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

package com.github.kaspiandev.chat.builders;

import com.github.kaspiandev.chat.format.ColorFormatter;
import com.github.kaspiandev.kommons.universal.builders.MultiStringBuilder;
import com.github.kaspiandev.kommons.universal.builders.SingleStringBuilder;
import com.github.kaspiandev.kommons.universal.builders.SplitStringBuilder;
import com.github.kaspiandev.kommons.universal.builders.StringBuilder;
import com.github.kaspiandev.kommons.universal.pairs.StringPair;

@SuppressWarnings("unused")
public class SplitMessageBuilder extends SplitStringBuilder implements StringBuilder<String> {

    /**
     * A message builder that uses just a single {@link String} unlike {@link MultiStringBuilder}.
     *
     * @param message Message to initiate the object with.
     * @see MultiStringBuilder {@code MessageBuilder} using a {@code List} instead.
     */
    public SplitMessageBuilder(String message) {
        super(message);
    }

    public SplitMessageBuilder colorize() {
        message = new java.lang.StringBuilder(ColorFormatter.legacy(message.toString()));
        return this;
    }

    @Override
    public SplitMessageBuilder replace(String from, String to) {
        super.replace(from, to);
        return this;
    }

    @Override
    public SplitMessageBuilder replace(StringPair pair) {
        super.replace(pair);
        return this;
    }

}
