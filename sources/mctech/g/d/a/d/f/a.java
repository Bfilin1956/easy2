package mctech.g.d.a.d.f;

import appeng.api.ids.AEComponents;
import net.minecraft.core.Holder;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/f/a.class */
public class a implements mctech.g.a.d.a {
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.d.a> a = (itemStack, r5) -> {
        return new a(itemStack);
    };
    private final ItemStack b;

    public a(ItemStack itemStack) {
        this.b = itemStack;
    }

    @Override // mctech.g.a.d.a
    public boolean a() {
        Holder holder = (Holder) this.b.get(AEComponents.FACADE_ITEM);
        return holder != null && (holder.value() instanceof BlockItem);
    }

    @Override // mctech.g.a.d.a
    public Block b() {
        Holder holder = (Holder) this.b.get(AEComponents.FACADE_ITEM);
        if (holder != null) {
            Object objValue = holder.value();
            if (objValue instanceof BlockItem) {
                return ((BlockItem) objValue).getBlock();
            }
        }
        return Blocks.AIR;
    }

    @Override // mctech.g.a.d.a
    public mctech.g.a.d.b c() {
        return mctech.g.a.d.b.BASIC;
    }
}
