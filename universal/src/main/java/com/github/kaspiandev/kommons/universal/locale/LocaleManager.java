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

import dev.dejvokep.boostedyaml.YamlDocument;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

@SuppressWarnings("unused")
public class LocaleManager {

    private final List<Locale> locales;

    // Cache
    private final WeakHashMap<CountryCode, Locale> cache;

    public LocaleManager() {
        this.locales = new ArrayList<>();
        this.cache = new WeakHashMap<>();
    }

    public LocaleManager addLocale(Locale locale) {
        this.locales.add(locale);
        return this;
    }

    public LocaleManager addLocales(List<Locale> locales) {
        this.locales.addAll(locales);
        return this;
    }

    public List<Locale> getLocales() {
        return locales;
    }

    public Locale findLocale(CountryCode code) {
        return this.locales.stream()
                .filter(localeCode -> localeCode.getCode() == code)
                .findFirst()
                .orElse(locales.get(0));
    }

    public Locale findLocaleOrDefault(CountryCode code, Locale def) {
        if (isCached(code)) return getCached(code);
        Locale locale = this.locales.stream()
                .filter(localeCode -> localeCode.getCode() == code)
                .findFirst()
                .orElse(def);
        this.cache.put(code, locale);
        return locale;
    }

    public YamlDocument getDocument(CountryCode code) {
        return this.findLocale(code).getDocument();
    }

    public String getMessage(CountryCode code, String route) {
        return getDocument(code).getString(route);
    }

    private Locale getCached(CountryCode code) {
        return this.cache.get(code);
    }

    private boolean isCached(CountryCode code) {
        return this.cache.containsKey(code);
    }

}
