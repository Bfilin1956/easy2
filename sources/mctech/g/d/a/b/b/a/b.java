package mctech.g.d.a.b.b.a;

import mctech.init.MCTechDataComponent;
import mctech.init.MCTechMenus;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/b/a/b.class */
public class b extends mctech.g.d.b.a<a> {
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.e.c> a = (itemStack, r5) -> {
        return (mctech.g.a.e.c) itemStack.getOrDefault(MCTechDataComponent.LIMITED_ITEM_FILTER, a.b);
    };

    public b(Item.Properties properties) {
        super(properties);
    }

    @Override // mctech.g.d.b.a
    protected DataComponentType<a> a() {
        return MCTechDataComponent.LIMITED_ITEM_FILTER;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.g.d.b.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a c() {
        return a.b;
    }

    @Override // mctech.g.d.b.a
    protected AbstractContainerMenu a(int i, Inventory inventory, mctech.g.d.a.b.a.InterfaceC0013a interfaceC0013a) {
        return new c((MenuType) MCTechMenus.LIMITED_ITEM_FILTER.get(), i, inventory, interfaceC0013a);
    }

    public static c a(int i, Inventory inventory, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        return new c((MenuType) MCTechMenus.LIMITED_ITEM_FILTER.get(), i, inventory);
    }
}
