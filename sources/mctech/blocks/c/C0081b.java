package mctech.blocks.c;

import mctech.MCTech;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.blocks.c.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/b.class */
public class C0081b extends s {
    private final String a;

    public C0081b(String str) {
        this.a = str;
    }

    @OnlyIn(Dist.CLIENT)
    public TextureAtlasSprite a(BlockState blockState, Direction direction) {
        return mctech.v.r.c(MCTech.MODID, this.a).get("side");
    }
}
