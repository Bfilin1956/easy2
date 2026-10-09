package mctech.items.misc;

import mctech.init.MCTechItems;
import mctech.items.base.i;
import mctech.items.base.o;
import mctech.utils.c.h;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/misc/b.class */
public class b extends i {
    public b() {
        super(new o().d().a(1));
    }

    public int a(ItemStack itemStack, LivingEntity livingEntity) {
        return 0;
    }

    public Component getName(ItemStack itemStack) {
        Fluid fluidA = a(itemStack);
        return fluidA == Fluids.EMPTY ? super.getName(itemStack) : fluidA.getFluidType().getDescription(new FluidStack(fluidA, 1000));
    }

    public static ItemStack a(Fluid fluid) {
        ItemStack itemStack = new ItemStack((ItemLike) MCTechItems.FLUID_DISPLAY.get());
        a(itemStack, fluid);
        return itemStack;
    }

    public static Fluid a(ItemStack itemStack) {
        return (Fluid) BuiltInRegistries.FLUID.get(ResourceLocation.parse(h.a(itemStack).getString("fluid")));
    }

    public static void a(ItemStack itemStack, Fluid fluid) {
        if (fluid == Fluids.EMPTY || !fluid.defaultFluidState().isSource()) {
            return;
        }
        h.a(itemStack).putString("fluid", BuiltInRegistries.FLUID.getKey(fluid).toString());
    }
}
