package org.macver.linty.data.types.area;

import org.bukkit.Location;
import org.bukkit.World;

import javax.annotation.Nonnull;

public abstract class Area {

    @Nonnull World world;

    protected Area(@Nonnull World world) {
        this.world = world;
    }

    /**
     * The {@link World} that this area is in.
     * @return the world. Not null.
     */
    @Nonnull
    public World getWorld() {
        return world;
    }

    abstract public boolean contains(Location location);
}
