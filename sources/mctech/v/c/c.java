package mctech.v.c;

import java.util.Objects;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c/c.class */
public interface c extends d {
    @Override // mctech.v.c.d
    @OnlyIn(Dist.CLIENT)
    default RenderType a() {
        return null;
    }

    @Override // mctech.v.c.d
    @OnlyIn(Dist.CLIENT)
    default boolean a(BlockState blockState, RenderType renderType) {
        return Objects.equals(renderType, RenderType.cutout()) || Objects.equals(renderType, RenderType.translucent());
    }
}
