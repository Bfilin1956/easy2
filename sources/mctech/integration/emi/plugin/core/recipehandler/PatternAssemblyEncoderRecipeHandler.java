package mctech.integration.emi.plugin.core.recipehandler;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.recipe.handler.EmiCraftContext;
import dev.emi.emi.api.recipe.handler.StandardRecipeHandler;
import dev.emi.emi.api.widget.Widget;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mctech.a.b.e.a;
import mctech.blockentities.c.G;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import mctech.integration.emi.plugin.core.recipe.EMIAssemblyStationRecipe;
import mctech.m.b.C0128aa;
import mctech.m.g.g;
import mctech.q.d.f;
import mctech.u.C0172d;
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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipehandler/PatternAssemblyEncoderRecipeHandler.class */
public class PatternAssemblyEncoderRecipeHandler implements StandardRecipeHandler<C0128aa> {
    private final EmiRecipeCategory assemblyCategory = EmiMachineRegistry.getCategory("assembly_station").orElse(null);

    public void render(EmiRecipe emiRecipe, EmiCraftContext<C0128aa> emiCraftContext, List<Widget> list, GuiGraphics guiGraphics) {
    }

    public List<Slot> getInputSources(C0128aa c0128aa) {
        ArrayList arrayList = new ArrayList();
        for (Slot slot : c0128aa.slots) {
            if (!(slot instanceof a) && !(slot instanceof g)) {
                arrayList.add(slot);
            }
        }
        return arrayList;
    }

    public List<Slot> getCraftingSlots(C0128aa c0128aa) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 21; i++) {
            arrayList.add((Slot) c0128aa.slots.get(i));
        }
        return arrayList;
    }

    @Nullable
    public Slot getOutputSlot(C0128aa c0128aa) {
        return c0128aa.getSlot(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean fillAssembly(C0128aa c0128aa, EmiRecipe emiRecipe) {
        if (emiRecipe instanceof EMIAssemblyStationRecipe) {
            ArrayList arrayList = new ArrayList();
            C0172d recipe = ((EMIAssemblyStationRecipe) emiRecipe).getRecipe();
            Map<String, ItemStack> mapA = recipe.a();
            List<String> listB = recipe.b();
            for (int i = 0; i < recipe.j(); i++) {
                for (int i2 = 0; i2 < recipe.k(); i2++) {
                    int iJ = i + (i2 * recipe.j());
                    char cCharAt = listB.get(i2).charAt(i);
                    arrayList.add(new f(((G) c0128aa.getHolder()).getPosition(), iJ + 1, cCharAt == ' ' ? ItemStack.EMPTY : mapA.get(String.valueOf(cCharAt)), FluidStack.EMPTY, true));
                }
            }
            arrayList.add(new f(((G) c0128aa.getHolder()).getPosition(), 0, ItemStack.EMPTY, ((FluidStack) recipe.d().getFirst()).copyWithAmount(((FluidStack) recipe.d().getFirst()).getAmount()), false));
            arrayList.add(new f(((G) c0128aa.getHolder()).getPosition(), 1, ItemStack.EMPTY, ((FluidStack) recipe.d().getLast()).copyWithAmount(((FluidStack) recipe.d().getLast()).getAmount()), false));
            arrayList.add(new f(((G) c0128aa.getHolder()).getPosition(), 0, recipe.n(), FluidStack.EMPTY, true));
            send(arrayList);
            ((G) c0128aa.getHolder()).d.setFluid((FluidStack) recipe.d().getFirst());
            ((G) c0128aa.getHolder()).e.setFluid((FluidStack) recipe.d().getLast());
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

    public boolean craft(EmiRecipe emiRecipe, EmiCraftContext<C0128aa> emiCraftContext) {
        Minecraft.getInstance().setScreen(emiCraftContext.getScreen());
        C0128aa c0128aa = (C0128aa) emiCraftContext.getScreenHandler();
        if (emiCraftContext.getType() != EmiCraftContext.Type.FILL_BUTTON) {
            return false;
        }
        return fillAssembly(c0128aa, emiRecipe);
    }

    public boolean supportsRecipe(EmiRecipe emiRecipe) {
        return this.assemblyCategory != null && emiRecipe.getCategory() == this.assemblyCategory;
    }

    public boolean canCraft(EmiRecipe emiRecipe, EmiCraftContext emiCraftContext) {
        AbstractContainerScreen screen = emiCraftContext.getScreen();
        return screen != null && (screen.getMenu() instanceof C0128aa) && this.assemblyCategory != null && emiRecipe.getCategory() == this.assemblyCategory;
    }
}
