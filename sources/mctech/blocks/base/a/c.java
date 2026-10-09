package mctech.blocks.base.a;

import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/c.class */
public interface c {
    @OnlyIn(Dist.CLIENT)
    ResourceLocation a();

    @OnlyIn(Dist.CLIENT)
    ResourceLocation b();

    @OnlyIn(Dist.CLIENT)
    default Material c() {
        return new Material(a(), b());
    }
}
