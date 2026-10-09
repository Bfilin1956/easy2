package mctech.utils;

import java.util.Set;
import mctech.init.MCTechBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: renamed from: mctech.utils.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/g.class */
public class C0205g extends mctech.m.g.g {
    private static final Set<Item> b = Set.of(MCTechBlocks.STANDARD_SOLAR_PANEL.asItem(), MCTechBlocks.SIMPLE_SOLAR_PANEL.asItem(), MCTechBlocks.ADVANCED_SOLAR_PANEL.asItem(), MCTechBlocks.HYBRID_SOLAR_PANEL.asItem(), MCTechBlocks.PROTON_SOLAR_PANEL.asItem(), MCTechBlocks.COMPOSITE_SOLAR_PANEL.asItem(), MCTechBlocks.NANO_SOLAR_PANEL.asItem(), MCTechBlocks.QUANT_SOLAR_PANEL.asItem(), MCTechBlocks.SINGULAR_SOLAR_PANEL.asItem(), MCTechBlocks.ADMIN_SOLAR_PANEL.asItem());
    public static final mctech.m.c.g a = itemStack -> {
        return b.contains(itemStack.getItem());
    };

    public C0205g(mctech.blockentities.b.a aVar, int i, int i2, int i3, mctech.m.c.g gVar) {
        super(aVar, i, i2, i3, gVar);
    }

    @Override // mctech.m.g.g
    public boolean mayPlace(ItemStack itemStack) {
        if (itemStack.getItem() instanceof mctech.items.base.m) {
            return false;
        }
        if (b.contains(itemStack.getItem())) {
            return true;
        }
        return super.mayPlace(itemStack);
    }

    @Override // mctech.m.g.g, mctech.m.g.n
    public boolean b(ItemStack itemStack) {
        return super.b(itemStack);
    }
}
