package org.macver.linty.data.types;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.macver.linty.data.types.area.Area;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Instant;
import java.util.UUID;

public class Claim {

    /**
     * Whether the claim is expired and everyone is allowed to access it.
     */
    private boolean expired = false;
    /**
     * Whether the claim is frozen and cannot expire.
     */
    private boolean frozen = false;
    /**
     * The {@link Instant} to unfreeze this claim or null if never;.
     */
    @Nullable
    private Instant unfreezeInstant = null;
    /**
     * The {@link UUID} of the owner of the claim.
     */
    @Nullable
    private UUID owner = null;
    /**
     * The {@link Instant} this claim was last marked active.
     */
    @Nonnull
    private Instant lastActive = Instant.now();
    /**
     * The physical area of this claim.
     */
    @Nonnull
    private Area area;

    /**
     * Create a claim.
     * @param area the {@link Area} of the claim.
     */
    public Claim(@Nonnull Area area) {
        this.area = area;
    }

    /**
     * Transfer this claim to a different owner.
     * @param newOwner the UUID of the new owner or null to become a meta claim.
     */
    public void transfer(@Nullable UUID newOwner) {
        owner = newOwner;
    }

    /**
     * The {@link UUID} of the player who owns this area.
     * @return the owner. If there is no owner (in the case of a meta claim), null.
     */
    @Nullable
    UUID getOwnerUUID() {
        return owner;
    }

    /**
     * Get the {@link Player} who owns this area.
     * @return the player. If the player is not online, null.
     * @throws NullPointerException if the area has no owner.
     */
    @Nullable
    Player getOwnerPlayer() {
        if (owner == null) throw new NullPointerException("This area has no owner.");
        return Bukkit.getPlayer(owner);
    }

    /**
     * Check if this claim is a meta claim.
     * @return true if a meta claim, false if not a meta claim.
     */
    boolean isMeta() {
        return owner == null;
    }

    /**
     * Get the {@link Instant} that this claim was last active. The definition of active is dependent on Claims > Expiry > Reset Mode in the config.
     * @return the instant last active.
     */
    Instant lastActive() {
        return lastActive;
    }

    /**
     * Mark this claim active.
     */
    void updateLastActive() {
        lastActive = Instant.now();
    }

    /**
     * Whether the claim is expired and can be accessed by everyone.
     * @return whether the claim is expired.
     */
    boolean isExpired() {
        return expired;
    }

    /**
     * Mark the claim as expired or not expired.
     * @param expired whether the claim should be marked as expired.
     */
    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    /**
     * Whether the claim is frozen and protected from expiration.
     * @return Whether the claim is frozen.
     */
    public boolean isFrozen() {
        return frozen;
    }

    /**
     * Mark this claim as frozen or unfrozen.
     * @param frozen whether the claim should be marked as frozen.
     */
    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    /**
     * Get the moment that this claim will be unfrozen, if set.
     * @return The {@link Instant} the claim is unfrozen or null if no date is set.
     */
    @Nullable
    public Instant getUnfreezeInstant() {
        return unfreezeInstant;
    }

    /**
     * Set the moment that this claim will be unfrozen.
     * @param unfreezeInstant An {@link Instant} to unfreeze the claim or null to never unfreeze.
     */
    public void setUnfreezeInstant(@Nullable Instant unfreezeInstant) {
        this.unfreezeInstant = unfreezeInstant;
    }

    /**
     * Get the area of this claim.
     * @return the {@link Area} of this claim.
     */
    @Nonnull
    public Area getArea() {
        return area;
    }

    /**
    * Set the area of this claim.
    * @param area the {@link Area} of this claim.
    */
    public void setArea(@Nonnull Area area) {
        this.area = area;
    }
}
