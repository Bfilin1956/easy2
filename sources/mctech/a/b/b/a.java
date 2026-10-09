package mctech.a.b.b;

import appeng.api.ids.AEComponents;
import appeng.api.stacks.AEFluidKey;
import appeng.api.stacks.AEItemKey;
import appeng.api.stacks.AEKey;
import appeng.api.stacks.GenericStack;
import appeng.core.definitions.AEItems;
import appeng.core.definitions.ItemDefinition;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.fluids.FluidStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b/b/a.class */
public abstract class a {
    public abstract List<mctech.a.b.e.d> a();

    public abstract List<mctech.a.b.e.d> b();

    public abstract List<mctech.a.b.e.b> c();

    public abstract ItemStack d();

    public abstract boolean e();

    public boolean f() {
        DefaultedRegistry defaultedRegistry = BuiltInRegistries.FLUID;
        boolean zIs = AEItems.MISSING_CONTENT.is(d());
        Stream<R> map = a().stream().map((v0) -> {
            return v0.c();
        });
        ItemDefinition itemDefinition = AEItems.MISSING_CONTENT;
        Objects.requireNonNull(itemDefinition);
        return zIs || map.anyMatch(itemDefinition::is) || c().stream().map((v0) -> {
            return v0.c();
        }).anyMatch(fluidStack -> {
            return defaultedRegistry.getOptional(defaultedRegistry.getKey(fluidStack.getFluid())).isEmpty();
        });
    }

    public static GenericStack a(ItemStack itemStack) {
        AEItemKey aEItemKeyOf = AEItemKey.of(itemStack);
        if (aEItemKeyOf == null) {
            ItemStack itemStackStack = AEItems.MISSING_CONTENT.stack();
            itemStackStack.set(AEComponents.MISSING_CONTENT_ERROR, String.format("Item %s not found", itemStack));
            return new GenericStack((AEKey) Objects.requireNonNull(AEItemKey.of(itemStackStack)), 1L);
        }
        return new GenericStack(aEItemKeyOf, itemStack.getCount());
    }

    public static GenericStack a(FluidStack fluidStack) {
        AEFluidKey aEFluidKeyOf = AEFluidKey.of(fluidStack);
        if (aEFluidKeyOf == null) {
            ItemStack itemStackStack = AEItems.MISSING_CONTENT.stack();
            itemStackStack.set(AEComponents.MISSING_CONTENT_ERROR, String.format("Fluid %s not found", fluidStack));
            return new GenericStack((AEKey) Objects.requireNonNull(AEItemKey.of(itemStackStack)), 1L);
        }
        return new GenericStack(aEFluidKeyOf, fluidStack.getAmount());
    }
}
