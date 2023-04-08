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

package com.github.kaspiandev.kommons.spigot.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.Bukkit;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.profile.PlayerTextures;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.UUID;

@SuppressWarnings("unused")
public class SkullUtils {

    private SkullUtils() {}

    @NotNull
    public static PlayerProfile getProfileBase64(String base64) {
        return getProfileBase64(base64, null);
    }

    @NotNull
    public static PlayerProfile getProfileBase64(String base64, @Nullable UUID uuid) {
        byte[] decodedBytes = Base64.getDecoder().decode(base64);
        String decodedJson = new String(decodedBytes);
        JsonObject jsonObject = JsonParser.parseString(decodedJson).getAsJsonObject();
        String url = jsonObject.get("textures.SKIN.url").getAsString();
        return getProfile(url, uuid);
    }

    @NotNull
    public static PlayerProfile getProfile(String url) {
        return getProfile(url, UUID.randomUUID());
    }

    @NotNull
    public static PlayerProfile getProfile(String url, @Nullable UUID uuid) {
        UUID profileUUID = (uuid == null) ? UUID.randomUUID() : uuid;
        PlayerProfile profile = Bukkit.createPlayerProfile(profileUUID);
        PlayerTextures textures = profile.getTextures();
        URL urlObject = getTexture(url);
        textures.setSkin(urlObject);
        return profile;
    }

    private static URL getTexture(String url) {
        URL urlObject;
        try {
            urlObject = new URL(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return urlObject;
    }

}
