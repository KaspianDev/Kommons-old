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

package com.github.kaspiandev.kommons.console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CommandLineParser sorts arguments as other command line tools do.
 */
@SuppressWarnings("unused")
public class CommandLineParser {

    private final Map<String, String> options = new HashMap<>();
    private final List<String> booleans = new ArrayList<>();

    /**
     * Instantiates a new Command line parser.
     *
     * @param args the args
     */
    public CommandLineParser(String[] args) {
        parse(args);
    }

    /**
     * Gets option.
     *
     * @param name the name
     * @return the option
     */
    public String getOption(String name) {
        return options.get(name);
    }

    /**
     * Gets option.
     *
     * @param shortName the short name
     * @param longName  the long name
     * @return the option
     */
    public String getOption(String shortName, String longName) {
        if (options.containsKey(shortName)) {
            return options.get(shortName);
        } else return options.getOrDefault(longName, null);
    }

    /**
     * Gets boolean option.
     *
     * @param name the name
     * @return the boolean option
     */
    public boolean getBooleanOption(String name) {
        return options.containsKey(name);
    }

    /**
     * Gets boolean option.
     *
     * @param shortName the short name
     * @param longName  the long name
     * @return the boolean option
     */
    public boolean getBooleanOption(String shortName, String longName) {
        return booleans.contains(shortName) || booleans.contains(longName);
    }

    /*
     * For every argument check if it starts with
     * two dashes, if it does execute parseOption.
     * If it doesn't, check if it starts with one dash
     * and do the same. That's in simple words.
     */
    private void parse(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.startsWith("--")) {
                String option = arg.substring(2);
                parseOption(option, i, args);
            } else if (arg.startsWith("-")) {
                String option = arg.substring(1);
                for (int j = 0; j < option.length(); j++) {
                    String shortOption = String.valueOf(option.charAt(j));
                    parseOption(shortOption, i, args);
                }
                if (i + 1 < args.length && !args[i + 1].startsWith("-")) {
                    options.put(String.valueOf(option.charAt(0)), args[i + 1]);
                    // i++;
                }
            }
        }
    }

    /*
     * If argument at index doesn't end with ! and argument length
     * is equal to one or next argument starts with - add to booleans.
     *
     * Otherwise check if next argument doesn't start with - and then add the item.
     */
    private void parseOption(String option, int index, String[] args) {
        if (!args[index].endsWith("!") && (args.length == 1 || args[index + 1].startsWith("-"))) {
            booleans.add(option);
        } else if (index + 1 < args.length && !args[index + 1].startsWith("-")) {
            options.put(option, args[index + 1]);
        }
    }

}