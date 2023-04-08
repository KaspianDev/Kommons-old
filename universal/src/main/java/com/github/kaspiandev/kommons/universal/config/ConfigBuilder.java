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

package com.github.kaspiandev.kommons.universal.config;

import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning;
import dev.dejvokep.boostedyaml.libs.org.snakeyaml.engine.v2.common.ScalarStyle;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;

import java.io.*;

@SuppressWarnings("unused")
public class ConfigBuilder {

    private GeneralSettings generalSettings;
    private UpdaterSettings updaterSettings;
    private DumperSettings dumperSettings;
    private LoaderSettings loaderSettings;
    private File file;
    private InputStream inputStream;

    public ConfigBuilder generalSettings(GeneralSettings generalSettings) {
        this.generalSettings = generalSettings;
        return this;
    }

    public ConfigBuilder updaterSettings(UpdaterSettings updaterSettings) {
        this.updaterSettings = updaterSettings;
        return this;
    }

    public ConfigBuilder updaterSettings(String route) {
        this.updaterSettings = UpdaterSettings.builder()
                .setVersioning(new BasicVersioning(route))
                .build();
        return this;
    }

    public ConfigBuilder dumperSettings(DumperSettings dumperSettings) {
        this.dumperSettings = dumperSettings;
        return this;
    }

    public ConfigBuilder dumperSettings(ScalarStyle scalarStyle) {
        this.dumperSettings = DumperSettings.builder().setScalarStyle(scalarStyle).build();
        return this;
    }

    public ConfigBuilder loaderSettings(LoaderSettings loaderSettings) {
        this.loaderSettings = loaderSettings;
        return this;
    }

    public ConfigBuilder loaderSettings(boolean autoUpdate) {
        this.loaderSettings = LoaderSettings.builder().setAutoUpdate(autoUpdate).build();
        return this;
    }

    public ConfigBuilder setFile(File file) {
        this.file = file;
        try {
            this.inputStream = new FileInputStream(file);
        } catch (FileNotFoundException ignored) {}
        return this;
    }

    public ConfigBuilder setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        return this;
    }

    public ConfigBuilder setFile(String parent, String name) {
        this.file = new File(parent, name);
        try {
            this.inputStream = new FileInputStream(file);
        } catch (FileNotFoundException ignored) {}
        return this;
    }

    public YamlDocument build() {
        if (this.loaderSettings == null) this.loaderSettings = LoaderSettings.DEFAULT;
        if (this.dumperSettings == null) this.dumperSettings = DumperSettings.DEFAULT;
        if (this.updaterSettings == null) this.updaterSettings = UpdaterSettings.DEFAULT;
        if (this.generalSettings == null) this.generalSettings = GeneralSettings.DEFAULT;

        try {
            return YamlDocument.create(file, inputStream, generalSettings,
                    loaderSettings, dumperSettings, updaterSettings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
