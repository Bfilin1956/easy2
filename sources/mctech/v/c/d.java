package mctech.v.c;

import com.google.common.base.Objects;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c/d.class */
public interface d {
    @OnlyIn(Dist.CLIENT)
    RenderType a();

    @OnlyIn(Dist.CLIENT)
    default boolean a(BlockState blockState, RenderType renderType) {
        return Objects.equal(renderType, a());
    }
}
