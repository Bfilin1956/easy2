package mctech.v.c.a;

import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c/a/i.class */
public interface i extends d {
    @Override // mctech.v.c.a.d
    @OnlyIn(Dist.CLIENT)
    default mctech.v.f.a a(BlockState blockState) {
        return new mctech.v.f.a.b(blockState);
    }
}
