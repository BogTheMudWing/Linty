package org.macver.linty.data.types.area;

import org.bukkit.Location;
import org.bukkit.World;
import org.macver.linty.data.types.math.BlockCoordinate2d;

import javax.annotation.Nonnull;
import java.util.Objects;

public class RectangularArea extends Area {

    // Should always be the most negative corner. Block coordinates.
    BlockCoordinate2d origin;

    // Extends in the positive direction.
    BlockCoordinate2d size;

    /**
     * Create a {@link RectangularArea}.
     *
     * @param world the {@link World} this area is in.
     * @param x     the block coordinate of the west side (lowest number)
     * @param z     the block coordinate of the north side (lowest number)
     * @param sizeX the length of the x-axis
     * @param sizeZ the length of the z-axis
     */
    public RectangularArea(@Nonnull World world, int x, int z, int sizeX, int sizeZ) {
        super(world);
        origin = new BlockCoordinate2d(x, z);
        size = new BlockCoordinate2d(sizeX, sizeZ);
    }

    /**
     * Create a {@link RectangularArea}.
     *
     * @param world  the {@link World} this area is in.
     * @param origin the coordinate of the northwest corner (most negative)
     * @param size   the size of the area
     */
    public RectangularArea(@Nonnull World world, BlockCoordinate2d origin, BlockCoordinate2d size) {
        super(world);
        this.origin = origin;
        this.size = size;
    }

    public BlockCoordinate2d getOrigin() {
        return origin;
    }

    public BlockCoordinate2d getOpposite() {
        return new BlockCoordinate2d(
                origin.x + size.x,
                origin.z + size.z
        );
    }

    public BlockCoordinate2d getSize() {
        return size;
    }

    public int getArea() {
        return size.x * size.z;
    }

    public int getClaimBlockCount() {
        return getArea();
    }

    @Override
    public boolean contains(@Nonnull Location location) {
        // Return false if worlds do not match
        if (!Objects.equals(location.getWorld(), world)) return false;
        // Convert to BlockCoordinate2d
        BlockCoordinate2d locationCoordinate = new BlockCoordinate2d(location.getBlockX(), location.getBlockZ());
        // Check if coordinate is within area
        return contains(locationCoordinate);
    }

    public boolean contains(@Nonnull BlockCoordinate2d coordinate) {
        // Check if coordinate is within area
        return (
                coordinate.x >= origin.x &&
                        coordinate.z >= origin.z &&
                        coordinate.x <= getOpposite().x &&
                        coordinate.z <= getOpposite().z
        );
    }
}
