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
        this.level = Level.ALL;
    }

    public KLogger(Logger logger) {
        this.logger = logger;
        this.level = Level.ALL;
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
        this.log(Level.ALL, message);
    }

    public void log(Level level, String message) {
        switch (this.level) {
            case ALL -> {
                if (level == Level.ALL || level == Level.STARTUP || level == Level.MINIMAL)
                    logger.info(message);
            }
            case MINIMAL -> {
                if (level == Level.STARTUP || level == Level.MINIMAL)
                    logger.info(message);
            }
            case STARTUP -> {
                if (level == Level.STARTUP)
                    logger.info(message);
            }
        }
    }
}
