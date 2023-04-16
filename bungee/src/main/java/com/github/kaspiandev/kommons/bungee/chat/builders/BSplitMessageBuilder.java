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

package com.github.kaspiandev.kommons.bungee.chat.builders;

import com.github.kaspiandev.kommons.chat.builders.SplitMessageBuilder;
import com.github.kaspiandev.kommons.universal.pairs.StringPair;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;

@SuppressWarnings("unused")
public class BSplitMessageBuilder extends SplitMessageBuilder {

    public BSplitMessageBuilder(String message) {
        super(message);
    }

    public void send(CommandSender receiver) {
        receiver.sendMessage(TextComponent.fromLegacyText(super.message.toString()));
    }

    @Override
    public BSplitMessageBuilder colorize() {
        super.colorize();
        return this;
    }

    @Override
    public BSplitMessageBuilder replace(String from, String to) {
        super.replace(from, to);
        return this;
    }

    @Override
    public BSplitMessageBuilder replace(StringPair pair) {
        super.replace(pair);
        return this;
    }

}
