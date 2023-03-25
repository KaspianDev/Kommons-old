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

package com.github.kaspiandev.kommons.spigot.chat.builders;

import com.github.kaspiandev.chat.builders.SingleMessageBuilder;
import com.github.kaspiandev.kommons.universal.builders.StringBuilder;
import com.github.kaspiandev.kommons.universal.pairs.StringPair;
import org.bukkit.command.CommandSender;

@SuppressWarnings("unused")
public class SSingleMessageBuilder extends SingleMessageBuilder implements StringBuilder<String> {

    public SSingleMessageBuilder(String message) {
        super(message);
    }

    public void send(CommandSender receiver) {
        receiver.sendMessage(super.message);
    }

    @Override
    public SSingleMessageBuilder colorize() {
        super.colorize();
        return this;
    }

    @Override
    public SSingleMessageBuilder replace(String from, String to) {
        super.replace(from, to);
        return this;
    }

    @Override
    public SSingleMessageBuilder replace(StringPair pair) {
        super.replace(pair);
        return this;
    }

}
