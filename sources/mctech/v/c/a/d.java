package mctech.v.c.a;

import java.util.List;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c/a/d.class */
public interface d {
    @OnlyIn(Dist.CLIENT)
    mctech.v.f.a a(BlockState blockState);

    default List<BlockState> a() {
        return ((Block) this).getStateDefinition().getPossibleStates();
    }
}
