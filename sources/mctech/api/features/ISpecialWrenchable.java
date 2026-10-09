package mctech.api.features;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/features/ISpecialWrenchable.class */
public interface ISpecialWrenchable extends IWrenchableTile {
    @Override // mctech.api.features.IWrenchableTile
    boolean doSpecialAction(Direction direction, Vec3 vec3, Player player);

    @Override // mctech.api.features.IWrenchableTile
    AABB hasSpecialAction(Direction direction, Vec3 vec3, Player player);

    @Override // mctech.api.features.IWrenchableTile
    default boolean canSetFacing(Direction direction) {
        return false;
    }

    @Override // mctech.api.features.IWrenchableTile
    default void setFacing(Direction direction) {
    }

    @Override // mctech.api.features.IWrenchableTile
    default boolean canRemoveBlock(Player player) {
        return false;
    }

    @Override // mctech.api.features.IWrenchableTile
    default double getDropRate(Player player) {
        return 0.0d;
    }
}
