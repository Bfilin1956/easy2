package mctech.v.c.a;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c/a/j.class */
public interface j {
    @OnlyIn(Dist.CLIENT)
    TextureAtlasSprite a(BlockState blockState);
}
