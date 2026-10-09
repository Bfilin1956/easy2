package mctech.integration.emi.plugin.core.recipehandler;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.recipe.handler.EmiCraftContext;
import dev.emi.emi.api.recipe.handler.StandardRecipeHandler;
import dev.emi.emi.api.widget.Widget;
import java.util.ArrayList;
import java.util.List;
import mctech.a.b.e.a;
import mctech.blockentities.c.H;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import mctech.integration.emi.plugin.core.recipe.IndustrialForgeEmiRecipe;
import mctech.m.b.C0129ab;
import mctech.m.g.g;
import mctech.q.d.f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipehandler/PatternForgeEncoderRecipeHandler.class */
public class PatternForgeEncoderRecipeHandler implements StandardRecipeHandler<C0129ab> {
    private final EmiRecipeCategory industrialCategory = EmiMachineRegistry.getCategory("industrial_forge").orElse(null);

    public void render(EmiRecipe emiRecipe, EmiCraftContext<C0129ab> emiCraftContext, List<Widget> list, GuiGraphics guiGraphics) {
    }

    public List<Slot> getInputSources(C0129ab c0129ab) {
        ArrayList arrayList = new ArrayList();
        for (Slot slot : c0129ab.slots) {
            if (!(slot instanceof a) && !(slot instanceof g)) {
                arrayList.add(slot);
            }
        }
        return arrayList;
    }

    public List<Slot> getCraftingSlots(C0129ab c0129ab) {
        ArrayList arrayList = new ArrayList();
        for (Slot slot : c0129ab.slots) {
            if (slot instanceof a) {
                arrayList.add(slot);
            }
        }
        return arrayList;
    }

    @Nullable
    public Slot getOutputSlot(C0129ab c0129ab) {
        return c0129ab.getSlot(7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean fillIndustrial(C0129ab c0129ab, EmiRecipe emiRecipe) {
        if (emiRecipe instanceof IndustrialForgeEmiRecipe) {
            IndustrialForgeEmiRecipe industrialForgeEmiRecipe = (IndustrialForgeEmiRecipe) emiRecipe;
            List list = industrialForgeEmiRecipe.getRecipe().a().stream().map(bVar -> {
                return bVar.a() ? ItemStack.EMPTY : bVar.b().copyWithCount(bVar.d());
            }).toList();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(new f(((H) c0129ab.getHolder()).getPosition(), i, (ItemStack) list.get(i), FluidStack.EMPTY, true));
            }
            arrayList.add(new f(((H) c0129ab.getHolder()).getPosition(), 7, industrialForgeEmiRecipe.getRecipe().b(), FluidStack.EMPTY, true));
            send(arrayList);
            return true;
        }
        return false;
    }

    private <P extends CustomPacketPayload> void send(List<P> list) {
        if (FMLEnvironment.dist.isClient()) {
            PacketDistributor.sendToServer((CustomPacketPayload) list.getFirst(), (CustomPacketPayload[]) list.stream().skip(1L).toArray(i -> {
                return new CustomPacketPayload[i];
            }));
        }
    }

    public boolean craft(EmiRecipe emiRecipe, EmiCraftContext<C0129ab> emiCraftContext) {
        Minecraft.getInstance().setScreen(emiCraftContext.getScreen());
        C0129ab c0129ab = (C0129ab) emiCraftContext.getScreenHandler();
        if (emiCraftContext.getType() != EmiCraftContext.Type.FILL_BUTTON) {
            return false;
        }
        return fillIndustrial(c0129ab, emiRecipe);
    }

    public boolean supportsRecipe(EmiRecipe emiRecipe) {
        return this.industrialCategory != null && emiRecipe.getCategory() == this.industrialCategory;
    }

    public boolean canCraft(EmiRecipe emiRecipe, EmiCraftContext emiCraftContext) {
        AbstractContainerScreen screen = emiCraftContext.getScreen();
        return screen != null && (screen.getMenu() instanceof C0129ab) && this.industrialCategory != null && emiRecipe.getCategory() == this.industrialCategory;
    }
}
