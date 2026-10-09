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
import mctech.blockentities.c.I;
import mctech.i.i;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import mctech.integration.emi.plugin.core.recipe.EmiQuantumWorkbenchRecipe;
import mctech.m.b.C0130ac;
import mctech.m.g.g;
import mctech.q.d.f;
import mctech.u.Q;
import mctech.u.c.b;
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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/recipehandler/PatternQuantumWorkbenchRecipeHandler.class */
public class PatternQuantumWorkbenchRecipeHandler implements StandardRecipeHandler<C0130ac> {
    private final EmiRecipeCategory category = EmiMachineRegistry.getCategory(i.QUANTUM_WORKBENCH.getSerializedName()).orElse(null);

    public void render(EmiRecipe emiRecipe, EmiCraftContext<C0130ac> emiCraftContext, List<Widget> list, GuiGraphics guiGraphics) {
    }

    public List<Slot> getInputSources(C0130ac c0130ac) {
        ArrayList arrayList = new ArrayList();
        for (Slot slot : c0130ac.slots) {
            if (!(slot instanceof a) && !(slot instanceof g)) {
                arrayList.add(slot);
            }
        }
        return arrayList;
    }

    public List<Slot> getCraftingSlots(C0130ac c0130ac) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 49; i++) {
            arrayList.add((Slot) c0130ac.slots.get(i));
        }
        return arrayList;
    }

    @Nullable
    public Slot getOutputSlot(C0130ac c0130ac) {
        return c0130ac.getSlot(49);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean fillRecipe(C0130ac c0130ac, EmiRecipe emiRecipe) {
        if (emiRecipe instanceof EmiQuantumWorkbenchRecipe) {
            Q recipe = ((EmiQuantumWorkbenchRecipe) emiRecipe).getRecipe();
            Map<Character, b> mapC = recipe.c();
            List<String> listB = recipe.b();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 7; i++) {
                for (int i2 = 0; i2 < 7; i2++) {
                    ItemStack itemStackCopyWithCount = ItemStack.EMPTY;
                    if (i2 < listB.size()) {
                        String str = listB.get(i2);
                        if (i < str.length()) {
                            char cCharAt = str.charAt(i);
                            if (mapC.containsKey(Character.valueOf(cCharAt))) {
                                itemStackCopyWithCount = mapC.get(Character.valueOf(cCharAt)).b().copyWithCount(mapC.get(Character.valueOf(cCharAt)).d());
                            }
                        }
                    }
                    arrayList.add(new f(((I) c0130ac.getHolder()).getPosition(), (i * 7) + i2, itemStackCopyWithCount, FluidStack.EMPTY, true));
                }
            }
            arrayList.add(new f(((I) c0130ac.getHolder()).getPosition(), 49, recipe.d(), FluidStack.EMPTY, true));
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

    public boolean craft(EmiRecipe emiRecipe, EmiCraftContext<C0130ac> emiCraftContext) {
        Minecraft.getInstance().setScreen(emiCraftContext.getScreen());
        C0130ac c0130ac = (C0130ac) emiCraftContext.getScreenHandler();
        if (emiCraftContext.getType() != EmiCraftContext.Type.FILL_BUTTON) {
            return false;
        }
        return fillRecipe(c0130ac, emiRecipe);
    }

    public boolean supportsRecipe(EmiRecipe emiRecipe) {
        return this.category != null && emiRecipe.getCategory() == this.category;
    }

    public boolean canCraft(EmiRecipe emiRecipe, EmiCraftContext emiCraftContext) {
        AbstractContainerScreen screen = emiCraftContext.getScreen();
        return screen != null && (screen.getMenu() instanceof C0130ac) && this.category != null && emiRecipe.getCategory() == this.category;
    }
}
