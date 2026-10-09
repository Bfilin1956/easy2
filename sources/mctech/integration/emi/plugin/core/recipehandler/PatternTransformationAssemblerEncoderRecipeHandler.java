package mctech.integration.emi.plugin.core.recipehandler;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.recipe.handler.EmiCraftContext;
import dev.emi.emi.api.recipe.handler.StandardRecipeHandler;
import dev.emi.emi.api.widget.Widget;
import java.util.ArrayList;
import java.util.List;
import mctech.a.b.e.a;
import mctech.blockentities.c.J;
import mctech.i.i;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import mctech.integration.emi.plugin.core.recipe.EmiTransformationAssemblerRecipe;
import mctech.m.b.C0131ad;
import mctech.m.g.g;
import mctech.q.d.f;
import mctech.u.I;
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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipehandler/PatternTransformationAssemblerEncoderRecipeHandler.class */
public class PatternTransformationAssemblerEncoderRecipeHandler implements StandardRecipeHandler<C0131ad> {
    private final EmiRecipeCategory category = EmiMachineRegistry.getCategory(i.TRANSFORMATION_ASSEMBLER.getSerializedName()).orElse(null);
    private final EmiRecipeCategory category2 = EmiMachineRegistry.getCategory(i.MATRIX_CONVERTER.getSerializedName()).orElse(null);

    public void render(EmiRecipe emiRecipe, EmiCraftContext<C0131ad> emiCraftContext, List<Widget> list, GuiGraphics guiGraphics) {
    }

    public List<Slot> getInputSources(C0131ad c0131ad) {
        ArrayList arrayList = new ArrayList();
        for (Slot slot : c0131ad.slots) {
            if (!(slot instanceof a) && !(slot instanceof g)) {
                arrayList.add(slot);
            }
        }
        return arrayList;
    }

    public List<Slot> getCraftingSlots(C0131ad c0131ad) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(c0131ad.getSlot(0));
        arrayList.add(c0131ad.getSlot(1));
        return arrayList;
    }

    @Nullable
    public Slot getOutputSlot(C0131ad c0131ad) {
        return c0131ad.getSlot(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean fillRecipe(C0131ad c0131ad, EmiRecipe emiRecipe) {
        ItemStack itemStackCopyWithCount;
        if (!(emiRecipe instanceof EmiTransformationAssemblerRecipe)) {
            return false;
        }
        I recipe = ((EmiTransformationAssemblerRecipe) emiRecipe).getRecipe();
        ArrayList arrayList = new ArrayList();
        if (recipe.c().a()) {
            itemStackCopyWithCount = ItemStack.EMPTY;
        } else {
            itemStackCopyWithCount = recipe.c().b().copyWithCount(recipe.a());
        }
        arrayList.add(new f(((J) c0131ad.getHolder()).getPosition(), 0, itemStackCopyWithCount, FluidStack.EMPTY, true));
        arrayList.add(new f(((J) c0131ad.getHolder()).getPosition(), 1, recipe.d().copy(), FluidStack.EMPTY, true));
        send(arrayList);
        return true;
    }

    private <P extends CustomPacketPayload> void send(List<P> list) {
        if (FMLEnvironment.dist.isClient()) {
            PacketDistributor.sendToServer((CustomPacketPayload) list.getFirst(), (CustomPacketPayload[]) list.stream().skip(1L).toArray(i -> {
                return new CustomPacketPayload[i];
            }));
        }
    }

    public boolean craft(EmiRecipe emiRecipe, EmiCraftContext<C0131ad> emiCraftContext) {
        Minecraft.getInstance().setScreen(emiCraftContext.getScreen());
        C0131ad c0131ad = (C0131ad) emiCraftContext.getScreenHandler();
        if (emiCraftContext.getType() != EmiCraftContext.Type.FILL_BUTTON) {
            return false;
        }
        return fillRecipe(c0131ad, emiRecipe);
    }

    public boolean supportsRecipe(EmiRecipe emiRecipe) {
        if (this.category == null && this.category2 == null) {
            return false;
        }
        return emiRecipe.getCategory() == this.category || (this.category2 != null && emiRecipe.getCategory() == this.category2);
    }

    public boolean canCraft(EmiRecipe emiRecipe, EmiCraftContext emiCraftContext) {
        AbstractContainerScreen screen = emiCraftContext.getScreen();
        if (screen == null || !(screen.getMenu() instanceof C0131ad)) {
            return false;
        }
        if (this.category == null && this.category2 == null) {
            return false;
        }
        return emiRecipe.getCategory() == this.category || (this.category2 != null && emiRecipe.getCategory() == this.category2);
    }
}
