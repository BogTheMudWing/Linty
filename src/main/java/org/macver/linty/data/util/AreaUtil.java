package org.macver.linty.data.util;

import org.bukkit.World;
import org.macver.linty.data.types.area.Area;
import org.macver.linty.data.types.area.Rectangular3dArea;
import org.macver.linty.data.types.area.RectangularArea;
import org.macver.linty.data.types.math.BlockCoordinate2d;
import org.macver.linty.data.types.math.BlockCoordinate3d;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

public class AreaUtil {

    @Nullable
    public static Area getOverlap(@Nonnull Area area1, @Nonnull Area area2) {
        Area area = null;
        if (!Objects.equals(area1.getWorld(), area2.getWorld())) throw new UnsupportedOperationException("Areas to check overlap of do not share the same world.");
        if (area1 instanceof RectangularArea rArea1) {
            if (area2 instanceof RectangularArea rArea2) {
                area = overlapRectRect(rArea1, rArea2);
            } else if (area2 instanceof Rectangular3dArea r3dArea2) {
                area = overlapRect3dRect3d(rect2dTo3d(rArea1), r3dArea2);
            }
        } else if (area1 instanceof Rectangular3dArea r3dArea1) {
            if (area2 instanceof Rectangular3dArea r3dArea2) {
                area = overlapRect3dRect3d(r3dArea1, r3dArea2);
            }
        }
        return area;
    }

    /**
     * Convert a {@link RectangularArea} to a {@link Rectangular3dArea} that spans the entire world height.
     * @param area the area to convert.
     * @return the converted area.
     */
    @Nonnull
    public static Rectangular3dArea rect2dTo3d(@Nonnull RectangularArea area) {
        // Get variables of 2D area
        World world = area.getWorld();
        BlockCoordinate2d origin = area.getOrigin();
        BlockCoordinate2d size = area.getSize();
        // Get world min and max
        int minHeight = world.getMinHeight();
        int maxHeight = world.getMaxHeight();
        // Create 3D variables
        BlockCoordinate3d origin3d = new BlockCoordinate3d(origin.x, minHeight, origin.z);
        BlockCoordinate3d size3d = new BlockCoordinate3d(size.x, maxHeight, size.z);
        return new Rectangular3dArea(world, origin3d, size3d);
    }

    // Private methods below here

    @Nullable
    private static Area overlapRect3dRect3d(@Nonnull Rectangular3dArea area1, @Nonnull Rectangular3dArea area2) {
        // This shouldn't happen.
        if (!Objects.equals(area1.getWorld(), area2.getWorld())) throw new UnsupportedOperationException("Areas to check overlap of do not share the same world.");

        BlockCoordinate3d origin1 = area1.getOrigin();
        BlockCoordinate3d size1 = area1.getSize();

        BlockCoordinate3d origin2 = area2.getOrigin();
        BlockCoordinate3d size2 = area2.getSize();

        // Set the overall origin to the most negative corner
        int overallOriginX = Math.min(origin1.x, origin2.x);
        int overallOriginY = Math.min(origin1.y, origin2.y);
        int overallOriginZ = Math.min(origin1.z, origin2.z);

        // Find the opposite corner by the max of the opposite points
        int overallOppositeX = Math.max(origin1.x + size1.x, origin2.x + size2.x);
        int overallOppositeY = Math.max(origin1.y + size1.y, origin2.y + size2.y);
        int overallOppositeZ = Math.max(origin1.z + size1.z, origin2.z + size2.z);

        // Create list of overlapping coordinates
        BlockCoordinate3d overlappingCoordsOrigin = null;
        BlockCoordinate3d overlappingCoordsOpposite = null;

        // For each coordinate in the overall area, check if it overlaps both area1 and area2.
        // It checks from most negative to most positive, so we can set the first one to the origin and set each overlap to the opposite, and we'll get a valid area
        for (int x = overallOriginX; x < overallOppositeX; x++) {
            for (int y = overallOriginY; y < overallOppositeY; y++) {
                for (int z = overallOriginZ; z < overallOppositeZ; z++) {
                    // Create BlockCoordinate2d
                    BlockCoordinate3d coordinate = new BlockCoordinate3d(x, y, z);
                    // If no origin, check for overlap and set
                    if (overlappingCoordsOrigin == null) {
                        // Add if overlap on both areas
                        if (area1.contains(coordinate) && area2.contains(coordinate)) overlappingCoordsOrigin = coordinate;
                    }
                    // Check for overlap and set
                    if (area1.contains(coordinate) && area2.contains(coordinate)) overlappingCoordsOpposite = coordinate;
                }
            }
        }

        // If no overlap, return null
        if (overlappingCoordsOrigin == null) return null;
        assert overlappingCoordsOpposite != null;

        // Create the overlapping area
        return new Rectangular3dArea(
                area1.getWorld(),
                overlappingCoordsOrigin,
                overlappingCoordsOpposite.minus(overlappingCoordsOrigin)
        );
    }

    @Nullable
    private static Area overlapRectRect(@Nonnull RectangularArea area1, @Nonnull RectangularArea area2) {
        // This shouldn't happen.
        if (!Objects.equals(area1.getWorld(), area2.getWorld())) throw new UnsupportedOperationException("Areas to check overlap of do not share the same world.");

        BlockCoordinate2d origin1 = area1.getOrigin();
        BlockCoordinate2d size1 = area1.getSize();

        BlockCoordinate2d origin2 = area2.getOrigin();
        BlockCoordinate2d size2 = area2.getSize();

        // Set the overall origin to the most negative corner
        int overallOriginX = Math.min(origin1.x, origin2.x);
        int overallOriginZ = Math.min(origin1.z, origin2.z);

        // Find the opposite corner by the max of the opposite points
        int overallOppositeX = Math.max(origin1.x + size1.x, origin2.x + size2.x);
        int overallOppositeZ = Math.max(origin1.z + size1.z, origin2.z + size2.z);

        // Create list of overlapping coordinates
        BlockCoordinate2d overlappingCoordsOrigin = null;
        BlockCoordinate2d overlappingCoordsOpposite = null;

        // For each coordinate in the overall area, check if it overlaps both area1 and area2.
        // It checks from most negative to most positive, so we can set the first one to the origin and set each overlap to the opposite, and we'll get a valid area
        for (int x = overallOriginX; x < overallOppositeX; x++) {
            for (int z = overallOriginZ; z < overallOppositeZ; z++) {
                // Create BlockCoordinate2d
                BlockCoordinate2d coordinate = new BlockCoordinate2d(x, z);
                // If no origin, check for overlap and set
                if (overlappingCoordsOrigin == null) {
                    // Add if overlap on both areas
                    if (area1.contains(coordinate) && area2.contains(coordinate)) overlappingCoordsOrigin = coordinate;
                }
                // Check for overlap and set
                if (area1.contains(coordinate) && area2.contains(coordinate)) overlappingCoordsOpposite = coordinate;
            }
        }

        // If no overlap, return null
        if (overlappingCoordsOrigin == null) return null;
        assert overlappingCoordsOpposite != null;

        // Create the overlapping area
        return new RectangularArea(
                area1.getWorld(),
                overlappingCoordsOrigin,
                overlappingCoordsOpposite.minus(overlappingCoordsOrigin)
        );
    }

}
