package mctech.v.c.a;

import java.util.List;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c/a/a.class */
public interface a extends mctech.utils.d.b {
    public static final AABB a = new AABB(0.0d, 0.0d, 0.0d, 16.0d, 16.0d, 16.0d);

    @OnlyIn(Dist.CLIENT)
    TextureAtlasSprite a(BlockState blockState, Direction direction);

    default List<BlockState> a() {
        return ((Block) this).getStateDefinition().getPossibleStates();
    }

    @OnlyIn(Dist.CLIENT)
    default TextureAtlasSprite a(BlockState blockState) {
        return a(blockState, Direction.NORTH);
    }

    default AABB b(BlockState blockState) {
        return a;
    }

    default boolean c(BlockState blockState) {
        return true;
    }
}
