package org.macver.linty.data.types.math;

import javax.annotation.Nonnull;

public class BlockCoordinate2d {

    public int x;
    public int z;

    public BlockCoordinate2d(int x, int z) {
        this.x = x;
        this.z = z;
    }

    /**
     * Add another {@link BlockCoordinate2d} to this. This method changes this instance. To create a new instance, use plus().
     * @param coordinate the {@link BlockCoordinate2d} to add.
     */
    public void add(@Nonnull BlockCoordinate2d coordinate) {
        this.x += coordinate.x;
        this.z += coordinate.z;
    }

    /**
     * Subtract another {@link BlockCoordinate2d} from this. This method changes this instance. To create a new instance, use minus().
     * @param coordinate the {@link BlockCoordinate2d} to subtract.
     */
    public void subtract(@Nonnull BlockCoordinate2d coordinate) {
        this.x -= coordinate.x;
        this.z -= coordinate.z;
    }

    @Nonnull
    public BlockCoordinate2d plus(@Nonnull BlockCoordinate2d coordinate) {
        return new BlockCoordinate2d(
                this.x + coordinate.x,
                this.z + coordinate.z
        );
    }

    @Nonnull
    public BlockCoordinate2d minus(@Nonnull BlockCoordinate2d coordinate) {
        return new BlockCoordinate2d(
                this.x - coordinate.x,
                this.z - coordinate.z
        );
    }

}
