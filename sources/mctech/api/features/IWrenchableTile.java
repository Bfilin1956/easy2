package mctech.api.features;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/features/IWrenchableTile.class */
public interface IWrenchableTile {
    boolean canSetFacing(Direction direction);

    void setFacing(Direction direction);

    boolean canRemoveBlock(Player player);

    double getDropRate(Player player);

    default boolean doSpecialAction(Direction direction, Vec3 vec3, Player player) {
        return false;
    }

    default AABB hasSpecialAction(Direction direction, Vec3 vec3, Player player) {
        return null;
    }

    default boolean isHarvestWrenchRequired(Player player) {
        return true;
    }
}
