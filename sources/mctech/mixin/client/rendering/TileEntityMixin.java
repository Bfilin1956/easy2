package mctech.mixin.client.rendering;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/rendering/TileEntityMixin.class */
@Mixin(value = {BlockEntity.class}, remap = false)
public interface TileEntityMixin {
    @Accessor("blockState")
    void setBlockState(BlockState blockState);
}
