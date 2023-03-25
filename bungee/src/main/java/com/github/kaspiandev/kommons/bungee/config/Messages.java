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

package com.github.kaspiandev.kommons.bungee.config;

import com.github.kaspiandev.chat.builders.SingleMessageBuilder;
import com.github.kaspiandev.kommons.universal.pairs.StringPair;
import dev.dejvokep.boostedyaml.YamlDocument;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class Messages {

    private final YamlDocument config;

    public Messages(YamlDocument config) {
        this.config = config;
    }

    public void send(String message, @NotNull CommandSender receiver) {
        receiver.sendMessage(TextComponent.fromLegacyText(message));
    }

    public void sendActionBar(String message, ProxiedPlayer receiver) {
        receiver.sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
    }

    public void announceMsg(String message) {
        ProxyServer.getInstance().broadcast(TextComponent.fromLegacyText(message));
    }

    public String getConfigMsg(String configValue) {
        if (config.getString(configValue) == null) {
            return configValue;
        }
        if (!config.getString(configValue).equals("")) {
            return config.getString(configValue);
        }
        return configValue;
    }

    /**
     * @deprecated
     */
    @Deprecated(forRemoval = true)
    public final String replace(String message, @NotNull StringPair... replacePair) {
        SingleMessageBuilder singleMessageBuilder = new SingleMessageBuilder(message);
        for (StringPair pair : replacePair) {
            singleMessageBuilder.replace(pair);
        }
        return message;
    }
}
