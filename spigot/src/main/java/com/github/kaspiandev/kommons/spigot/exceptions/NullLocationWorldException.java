package com.github.kaspiandev.kommons.spigot.exceptions;

import org.bukkit.Location;

import java.text.MessageFormat;

public class NullLocationWorldException extends RuntimeException {

    public NullLocationWorldException(Location location) {
        super(MessageFormat.format("World of location at coordinates {0} {1} {2} is null!",
                location.getBlockX(), location.getBlockY(), location.getBlockZ()));
    }

}
