package mctech.api.tiles;

import mctech.api.util.ILocation;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/ITileSound.class */
public interface ITileSound extends ILocation {
    default float getInitialVolume() {
        return 1.0f;
    }

    default float getVolume() {
        return 1.0f;
    }

    default SoundSource getSoundCategory() {
        return SoundSource.BLOCKS;
    }

    default BlockPos getSoundPosition() {
        return getPosition();
    }
}
