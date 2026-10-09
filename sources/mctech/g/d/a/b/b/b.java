package mctech.g.d.a.b.b;

import java.util.List;
import java.util.function.Supplier;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechMenus;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/b/b.class */
public class b extends mctech.g.d.b.a<mctech.g.d.a.b.b.a> {
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.e.c> a = (itemStack, r5) -> {
        return (mctech.g.a.e.c) itemStack.getOrDefault(MCTechDataComponent.ITEM_FILTER, mctech.g.d.a.b.b.a.a);
    };
    private final a c;

    public b(Item.Properties properties, a aVar) {
        super(properties);
        this.c = aVar;
    }

    @Override // mctech.g.d.b.a
    protected DataComponentType<mctech.g.d.a.b.b.a> a() {
        return MCTechDataComponent.ITEM_FILTER;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.g.d.b.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public mctech.g.d.a.b.b.a c() {
        return mctech.g.d.a.b.b.a.a;
    }

    @Override // mctech.g.d.b.a
    protected AbstractContainerMenu a(int i, Inventory inventory, mctech.g.d.a.b.a.InterfaceC0013a interfaceC0013a) {
        return this.c.a(i, inventory, interfaceC0013a);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // mctech.g.d.b.a
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) throws MatchException {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        if (a(itemStack).c() && !this.c.c()) {
            list.add(Component.literal("This filter uses component matching which is no longer available to this item. Clear this filter using the crafting grid to remove this warning."));
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/b/b$a.class */
    public enum a {
        BASIC(() -> {
            return MCTechMenus.BASIC_ITEM_FILTER;
        }, 1, false, false),
        ADVANCED(() -> {
            return MCTechMenus.ADVANCED_ITEM_FILTER;
        }, 2, true, true),
        BIG(() -> {
            return MCTechMenus.BIG_ITEM_FILTER;
        }, 4, false, false),
        BIG_ADVANCED(() -> {
            return MCTechMenus.BIG_ADVANCED_ITEM_FILTER;
        }, 4, true, true);

        private final Supplier<Supplier<MenuType<c>>> e;
        private final int f;
        private final boolean g;
        private final boolean h;

        a(Supplier supplier, int i2, boolean z, boolean z2) {
            this.e = supplier;
            this.f = i2;
            this.g = z;
            this.h = z2;
        }

        public int a() {
            return this.f;
        }

        public int b() {
            return this.f * 9;
        }

        public boolean c() {
            return this.g;
        }

        public boolean d() {
            return this.h;
        }

        public c a(int i2, Inventory inventory, mctech.g.d.a.b.a.InterfaceC0013a interfaceC0013a) {
            return new c(this.e.get().get(), this, i2, inventory, interfaceC0013a);
        }

        public c a(int i2, Inventory inventory, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return new c(this.e.get().get(), this, i2, inventory);
        }
    }
}
