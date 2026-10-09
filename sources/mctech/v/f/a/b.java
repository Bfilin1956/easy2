package mctech.v.f.a;

import mctech.v.c.a.j;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/a/b.class */
public class b extends mctech.v.f.a {
    BlockState f;

    public b(BlockState blockState) {
        this.f = blockState;
    }

    @Override // mctech.v.f.a
    public void a() {
        j block = this.f.getBlock();
        if (block instanceof j) {
            a(block.a(this.f));
            return;
        }
        mctech.v.c.a.a block2 = this.f.getBlock();
        if (block2 instanceof mctech.v.c.a.a) {
            a(block2.a(this.f));
        } else {
            a((TextureAtlasSprite) null);
        }
    }

    @Override // mctech.v.f.a
    public boolean isCustomRenderer() {
        return true;
    }

    @Override // mctech.v.f.a
    public boolean usesBlockLight() {
        return true;
    }
}
