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

package com.github.kaspiandev.kommons.universal.locale;

import com.github.kaspiandev.kommons.universal.config.ConfigBuilder;
import dev.dejvokep.boostedyaml.YamlDocument;
import org.jetbrains.annotations.NotNull;

import java.io.File;

@SuppressWarnings("unused")
public class Locale {

    private final ConfigBuilder configBuilder;
    private final File file;
    private final CountryCode code;
    private final YamlDocument yamlDocument;

    public Locale(String prefix, @NotNull String folder, @NotNull CountryCode code, Class<?> classLoader) {
        this.code = code;
        String resource = prefix + "-" + code.getCode() + ".yml";
        this.file = new File(folder, resource);
        this.configBuilder = new ConfigBuilder()
                .setFile(file)
                .setInputStream(classLoader.getClassLoader().getResourceAsStream(prefix + "/" + resource))
                .loaderSettings(true);
        this.yamlDocument = configBuilder.build();
    }

    public YamlDocument getDocument() {
        return this.yamlDocument;
    }

    public CountryCode getCode() {
        return code;
    }

}
