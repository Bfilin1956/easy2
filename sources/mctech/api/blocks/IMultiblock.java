package mctech.api.blocks;

import java.util.function.Consumer;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/IMultiblock.class */
public interface IMultiblock {
    void forStructureBlocks(@NotNull Consumer<BlockPos> consumer);

    BlockPos getMasterPosition();
}
