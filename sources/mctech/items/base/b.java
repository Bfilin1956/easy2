package mctech.items.base;

import javax.annotation.Nonnull;
import mctech.init.MCTechDataComponent;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/b.class */
public abstract class b {

    @Nonnull
    protected final ItemStack a;

    @Nonnull
    protected final mctech.items.g b;

    @Nonnull
    protected final mctech.items.g c;

    @Nonnull
    public abstract l e();

    public b(@Nonnull ItemStack itemStack, @Nonnull l lVar) {
        this.a = itemStack;
        this.b = new mctech.items.g(itemStack, MCTechDataComponent.MODULES.get(), mctech.modules.h.a().a(lVar).getMaxModuleCount());
        this.c = new mctech.items.g(itemStack, MCTechDataComponent.BATTERIES.get(), mctech.modules.h.a().a(lVar).getMaxBatteryCount());
    }

    @Nonnull
    public ItemStack f() {
        return this.a;
    }

    @Nonnull
    public mctech.items.g g() {
        return this.b;
    }

    @Nonnull
    public mctech.items.g h() {
        return this.c;
    }

    @OnlyIn(Dist.CLIENT)
    public static int c(@Nonnull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(MCTechDataComponent.CHARGE, 0)).intValue();
    }

    @OnlyIn(Dist.CLIENT)
    public static int d(@Nonnull ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(MCTechDataComponent.CAPACITY, 0)).intValue();
    }
}
