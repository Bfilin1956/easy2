package mctech.v.c.b;

import java.util.List;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/c/b/b.class */
public interface b extends f {
    List<ItemStack> a();

    @OnlyIn(Dist.CLIENT)
    mctech.v.f.a a(ItemStack itemStack);
}
