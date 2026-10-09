package mctech.utils.c;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/c/b.class */
public class b {
    public static FluidStack a(FluidStack fluidStack, TagKey<Fluid> tagKey, Fluid fluid) {
        if (fluidStack.getFluid() == fluid) {
            return fluidStack;
        }
        if (fluidStack.getFluid().is(tagKey)) {
            return new FluidStack(fluid, fluidStack.getAmount());
        }
        return FluidStack.EMPTY;
    }

    public static int a(FluidStack fluidStack) {
        return IClientFluidTypeExtensions.of(fluidStack.getFluid()).getTintColor(fluidStack);
    }

    @OnlyIn(Dist.CLIENT)
    public static TextureAtlasSprite a(FluidStack fluidStack, boolean z) {
        return (TextureAtlasSprite) Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(b(fluidStack, z));
    }

    public static ResourceLocation b(FluidStack fluidStack, boolean z) {
        IClientFluidTypeExtensions iClientFluidTypeExtensionsOf = IClientFluidTypeExtensions.of(fluidStack.getFluid());
        return z ? iClientFluidTypeExtensionsOf.getFlowingTexture(fluidStack) : iClientFluidTypeExtensionsOf.getStillTexture(fluidStack);
    }

    public static Fluid a(ItemStack itemStack) {
        return ((FluidStack) FluidUtil.getFluidContained(itemStack).orElse(FluidStack.EMPTY)).getFluid();
    }

    public static boolean a(ItemStack itemStack, Player player, IFluidHandler iFluidHandler) {
        return true;
    }

    public static boolean a(mctech.m.a.g gVar, int i, int i2, IFluidHandler iFluidHandler) {
        return true;
    }

    public static boolean b(mctech.m.a.g gVar, int i, int i2, IFluidHandler iFluidHandler) {
        return true;
    }

    public static boolean a(mctech.m.a.g gVar, int i, mctech.m.a.g gVar2, IFluidHandler iFluidHandler, boolean z) {
        return true;
    }

    public static boolean b(ItemStack itemStack, Player player, IFluidHandler iFluidHandler) {
        return true;
    }

    static boolean a(mctech.m.a.g gVar, ItemStack itemStack, boolean z) {
        if (!itemStack.isEmpty()) {
            if (mctech.m.h.b.a(gVar).a(itemStack, null, !z) >= itemStack.getCount()) {
                return true;
            }
        }
        return false;
    }

    static boolean a(mctech.m.a.g gVar, int i, ItemStack itemStack, boolean z) {
        if (itemStack.isEmpty()) {
            return false;
        }
        ItemStack stackInSlot = gVar.getStackInSlot(i);
        if (stackInSlot.isEmpty()) {
            if (z) {
                gVar.setStackInSlot(i, itemStack);
                return true;
            }
            return true;
        }
        if (h.d(stackInSlot, itemStack) && stackInSlot.getCount() + itemStack.getCount() <= Math.min(gVar.getMaxStackSize(i), itemStack.getMaxStackSize())) {
            if (z) {
                stackInSlot.grow(itemStack.getCount());
                itemStack.setCount(0);
                gVar.setStackInSlot(i, stackInSlot);
                return true;
            }
            return true;
        }
        return false;
    }
}
