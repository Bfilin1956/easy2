package mctech.v.c.b;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c/b/g.class */
public interface g extends mctech.utils.d.b {
    @OnlyIn(Dist.CLIENT)
    TextureAtlasSprite a();

    default boolean c() {
        return true;
    }
}
