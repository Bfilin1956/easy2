package mctech.g.d.c;

import mctech.init.MCTechDataComponent;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/c/g.class */
public class g extends a implements mctech.g.a.e.e {
    public g(ItemStack itemStack) {
        super(itemStack, MCTechDataComponent.REDSTONE_FILTER_DOUBLE_CHANNEL);
    }

    @Override // mctech.g.a.e.e
    public int a(mctech.g.a.e.f fVar, DyeColor dyeColor) {
        return fVar.a(a()) && fVar.a(b()) ? 0 : 15;
    }
}
