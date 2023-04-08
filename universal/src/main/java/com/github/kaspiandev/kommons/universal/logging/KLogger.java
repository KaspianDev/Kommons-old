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

package com.github.kaspiandev.kommons.universal.logging;

import java.util.logging.Logger;

@SuppressWarnings("unused")
public class KLogger {

    private final Logger logger;
    private final Level level;

    public KLogger(String name) {
        logger = Logger.getLogger(name);
        this.level = Level.MEDIUM;
    }

    public KLogger(Logger logger) {
        this.logger = logger;
        this.level = Level.MEDIUM;
    }

    public KLogger(Level level, String name) {
        logger = Logger.getLogger(name);
        this.level = level;
    }

    public KLogger(Level level, Logger logger) {
        this.logger = logger;
        this.level = level;
    }

    public void log(String message) {
        this.log(Level.MEDIUM, message);
    }

    public void log(Level level, String message) {
        switch (this.level) {
            case HIGH -> logger.info(message);
            case MEDIUM -> {
                if (level == Level.MEDIUM || level == Level.LOW)
                    logger.info(message);
            }
            case LOW -> {
                if (level == Level.LOW)
                    logger.info(message);
            }
        }
    }
}
