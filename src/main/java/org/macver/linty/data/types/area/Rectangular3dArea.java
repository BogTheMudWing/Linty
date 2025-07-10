package org.macver.linty.data.types.area;

import org.bukkit.Location;
import org.bukkit.World;
import org.macver.linty.data.types.math.BlockCoordinate2d;
import org.macver.linty.data.types.math.BlockCoordinate3d;

import javax.annotation.Nonnull;
import java.util.Objects;

public class Rectangular3dArea extends Area {

    // Should always be the most negative corner. Block coordinates.
    BlockCoordinate3d origin;

    // Extends in the positive direction.
    BlockCoordinate3d size;

    /**
     * Create a {@link Rectangular3dArea}.
     *
     * @param world the {@link World} this area is in.
     * @param x     the block coordinate of the west side (lowest number)
     * @param z     the block coordinate of the north side (lowest number)
     * @param sizeX the length of the x-axis
     * @param sizeZ the length of the z-axis
     */
    public Rectangular3dArea(@Nonnull World world, int x, int y, int z, int sizeX, int sizeY, int sizeZ) {
        super(world);
        origin = new BlockCoordinate3d(x, y, z);
        size = new BlockCoordinate3d(sizeX, sizeY, sizeZ);
    }

    /**
     * Create a {@link Rectangular3dArea}.
     *
     * @param world  the {@link World} this area is in.
     * @param origin the coordinate of the northwest corner (most negative)
     * @param size   the size of the area
     */
    public Rectangular3dArea(@Nonnull World world, BlockCoordinate3d origin, BlockCoordinate3d size) {
        super(world);
        this.origin = origin;
        this.size = size;
    }

    public BlockCoordinate3d getOrigin() {
        return origin;
    }

    public BlockCoordinate3d getOpposite() {
        return new BlockCoordinate3d(
                origin.x + size.x,
                origin.y + size.y,
                origin.z + size.z
        );
    }

    public BlockCoordinate3d getSize() {
        return size;
    }

    public int getArea() {
        return size.x * size.z;
    }

    public int getVolume() {
        return getArea() * size.y;
    }

    public int getClaimBlockCount() {
        return getArea();
    }

    @Override
    public boolean contains(@Nonnull Location location) {
        // Return false if worlds do not match
        if (!Objects.equals(location.getWorld(), world)) return false;
        // Convert to BlockCoordinate2d
        BlockCoordinate3d locationCoordinate = new BlockCoordinate3d(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        // Check if coordinate is within area
        return contains(locationCoordinate);
    }

    public boolean contains(@Nonnull BlockCoordinate3d coordinate) {
        // Check if coordinate is within area
        return (
                coordinate.x >= origin.x &&
                        coordinate.y >= origin.y &&
                        coordinate.z >= origin.z &&
                        coordinate.x <= getOpposite().x &&
                        coordinate.y <= getOpposite().y &&
                        coordinate.z <= getOpposite().z

        );
    }
}
