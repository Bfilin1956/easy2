package mctech.g.d.a.b.a;

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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/a/b.class */
public class b extends mctech.g.d.b.a<mctech.g.d.a.b.a.a> {
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.e.b> a = (itemStack, r5) -> {
        return (mctech.g.a.e.b) itemStack.getOrDefault(MCTechDataComponent.FLUID_FILTER, mctech.g.d.a.b.a.a.a);
    };
    private final a c;

    public b(Item.Properties properties, a aVar) {
        super(properties);
        this.c = aVar;
    }

    @Override // mctech.g.d.b.a
    protected DataComponentType<mctech.g.d.a.b.a.a> a() {
        return MCTechDataComponent.FLUID_FILTER;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.g.d.b.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public mctech.g.d.a.b.a.a c() {
        return mctech.g.d.a.b.a.a.a;
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

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/a/b$a.class */
    public enum a {
        BASIC(() -> {
            return MCTechMenus.BASIC_FLUID_FILTER;
        }, 1, true);

        private final Supplier<Supplier<MenuType<c>>> b;
        private final int c;
        private final boolean d;

        a(Supplier supplier, int i, boolean z) {
            this.b = supplier;
            this.c = i;
            this.d = z;
        }

        public int a() {
            return this.c;
        }

        public int b() {
            return this.c * 9;
        }

        public boolean c() {
            return this.d;
        }

        public c a(int i, Inventory inventory, mctech.g.d.a.b.a.InterfaceC0013a interfaceC0013a) {
            return new c(this.b.get().get(), this, i, inventory, interfaceC0013a);
        }

        public c a(int i, Inventory inventory, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            return new c(this.b.get().get(), this, i, inventory);
        }
    }
}
