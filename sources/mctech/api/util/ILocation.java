package mctech.api.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/util/ILocation.class */
public interface ILocation {
    default Level getLevel() {
        if (this instanceof BlockEntity) {
            return ((BlockEntity) this).getLevel();
        }
        throw new RuntimeException("ILocation needs to be implemented explicitly");
    }

    default BlockPos getPosition() {
        if (this instanceof BlockEntity) {
            return ((BlockEntity) this).getBlockPos();
        }
        throw new RuntimeException("ILocation needs to be implemented explicitly");
    }
}
