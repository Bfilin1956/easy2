package mctech.blocks.d;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/d/c.class */
public class c extends TransparentBlock {
    private static final BlockBehaviour.StatePredicate a = (blockState, blockGetter, blockPos) -> {
        return false;
    };

    public c(BlockBehaviour.Properties properties) {
        super(properties.sound(SoundType.GLASS).noOcclusion().isValidSpawn(Blocks::never).isRedstoneConductor(a).isSuffocating(a).isViewBlocking(a));
    }
}
