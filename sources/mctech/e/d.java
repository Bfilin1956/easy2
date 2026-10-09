package mctech.e;

import appeng.items.tools.powered.PortableCellItem;
import javax.annotation.Nonnull;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechItems;
import mctech.items.g;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/e/d.class */
public class d {
    public static final int a = 5;
    public static final int b = 2;
    public static final int c = 1;

    @Nonnull
    private final ItemStack d;

    @Nonnull
    private final g e;

    @Nonnull
    private final g f;

    @Nonnull
    private final g g;

    public d(@NotNull ItemStack itemStack) {
        this.d = itemStack;
        this.e = new g(itemStack, MCTechDataComponent.SINGULAR_CELLS.get(), 5);
        this.e.a((num, itemStack2) -> {
            return itemStack2.isEmpty() || (itemStack2.getItem() instanceof PortableCellItem);
        });
        this.f = new g(itemStack, MCTechDataComponent.SINGULAR_ENERGY_PACKS.get(), 2);
        this.f.a((num2, itemStack3) -> {
            return itemStack3.isEmpty() || a(itemStack3);
        });
        this.g = new g(itemStack, MCTechDataComponent.SINGULAR_EU_READER.get(), 1);
        this.g.a((num3, itemStack4) -> {
            return itemStack4.isEmpty() || itemStack4.getItem() == MCTechItems.EU_READER.get();
        });
    }

    private static boolean a(@NotNull ItemStack itemStack) {
        return itemStack.getItem() instanceof mctech.items.g.a.a.b;
    }

    @Nonnull
    public ItemStack a() {
        return this.d;
    }

    @Nonnull
    public g b() {
        return this.e;
    }

    @Nonnull
    public g c() {
        return this.f;
    }

    @Nonnull
    public g d() {
        return this.g;
    }
}
