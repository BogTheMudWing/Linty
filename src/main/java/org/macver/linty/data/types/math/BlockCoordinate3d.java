package org.macver.linty.data.types.math;

import javax.annotation.Nonnull;

public class BlockCoordinate3d {

    public int x;
    public int y;
    public int z;

    public BlockCoordinate3d(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Add another {@link BlockCoordinate3d} to this. This method changes this instance. To create a new instance, use plus().
     * @param coordinate the {@link BlockCoordinate3d} to add.
     */
    public void add(@Nonnull BlockCoordinate3d coordinate) {
        this.x += coordinate.x;
        this.y += coordinate.y;
        this.z += coordinate.z;
    }

    /**
     * Subtract another {@link BlockCoordinate3d} from this. This method changes this instance. To create a new instance, use minus().
     * @param coordinate the {@link BlockCoordinate3d} to subtract.
     */
    public void subtract(@Nonnull BlockCoordinate3d coordinate) {
        this.x -= coordinate.x;
        this.y -= coordinate.y;
        this.z -= coordinate.z;
    }

    @Nonnull
    public BlockCoordinate3d plus(@Nonnull BlockCoordinate3d coordinate) {
        return new BlockCoordinate3d(
                this.x + coordinate.x,
                this.y + coordinate.y,
                this.z + coordinate.z
        );
    }

    @Nonnull
    public BlockCoordinate3d minus(@Nonnull BlockCoordinate3d coordinate) {
        return new BlockCoordinate3d(
                this.x - coordinate.x,
                this.y - coordinate.y,
                this.z - coordinate.z
        );
    }

}
