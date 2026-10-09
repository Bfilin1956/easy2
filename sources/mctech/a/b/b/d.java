package mctech.a.b.b;

import dev.emi.emi.api.EmiDragDropHandler;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.stack.FluidEmiStack;
import dev.emi.emi.api.stack.ItemEmiStack;
import mctech.blockentities.c.G;
import mctech.blockentities.c.H;
import mctech.blockentities.c.I;
import mctech.blockentities.c.J;
import mctech.components.a.C0091d;
import mctech.m.b.C0128aa;
import mctech.m.b.C0129ab;
import mctech.m.b.C0130ac;
import mctech.m.b.C0131ad;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.network.PacketDistributor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b/b/d.class */
public class d implements EmiDragDropHandler<Screen> {
    /* JADX WARN: Multi-variable type inference failed */
    public boolean dropStack(Screen screen, EmiIngredient emiIngredient, int i, int i2) {
        if (!(screen instanceof mctech.m.d.a)) {
            return false;
        }
        mctech.m.d.a aVar = (mctech.m.d.a) screen;
        mctech.a.b.e.a slotUnderMouse = aVar.getSlotUnderMouse();
        ItemEmiStack itemEmiStack = (EmiStack) emiIngredient.getEmiStacks().getFirst();
        AbstractContainerMenu menu = aVar.getMenu();
        if (menu instanceof C0129ab) {
            C0129ab c0129ab = (C0129ab) menu;
            if (slotUnderMouse instanceof mctech.a.b.e.a) {
                mctech.a.b.e.a aVar2 = slotUnderMouse;
                if (itemEmiStack instanceof ItemEmiStack) {
                    ItemEmiStack itemEmiStack2 = itemEmiStack;
                    if (!itemEmiStack2.isEmpty()) {
                        PacketDistributor.sendToServer(new mctech.q.d.d(((H) c0129ab.getHolder()).getBlockPos(), aVar2.a(), itemEmiStack2.getItemStack(), FluidStack.EMPTY), new CustomPacketPayload[0]);
                        return true;
                    }
                }
            }
            for (mctech.m.d.a.a aVar3 : c0129ab.getComponents()) {
                if (aVar3 instanceof C0091d) {
                    C0091d c0091d = (C0091d) aVar3;
                    if (itemEmiStack instanceof FluidEmiStack) {
                        Object key = ((FluidEmiStack) itemEmiStack).getKey();
                        if (key instanceof Fluid) {
                            Fluid fluid = (Fluid) key;
                            if (aVar3.a(i - aVar.getGuiLeft(), i2 - aVar.getGuiTop())) {
                                PacketDistributor.sendToServer(new mctech.q.d.d(((H) c0129ab.getHolder()).getBlockPos(), c0091d.a(), ItemStack.EMPTY, new FluidStack(fluid, 1000)), new CustomPacketPayload[0]);
                                return true;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return false;
        }
        AbstractContainerMenu menu2 = aVar.getMenu();
        if (menu2 instanceof C0128aa) {
            C0128aa c0128aa = (C0128aa) menu2;
            if (slotUnderMouse instanceof mctech.a.b.e.a) {
                mctech.a.b.e.a aVar4 = slotUnderMouse;
                if (itemEmiStack instanceof ItemEmiStack) {
                    ItemEmiStack itemEmiStack3 = itemEmiStack;
                    if (!itemEmiStack3.isEmpty()) {
                        PacketDistributor.sendToServer(new mctech.q.d.d(((G) c0128aa.getHolder()).getBlockPos(), aVar4.a(), itemEmiStack3.getItemStack(), FluidStack.EMPTY), new CustomPacketPayload[0]);
                        return true;
                    }
                }
            }
            for (mctech.m.d.a.a aVar5 : c0128aa.getComponents()) {
                if (aVar5 instanceof C0091d) {
                    C0091d c0091d2 = (C0091d) aVar5;
                    if (itemEmiStack instanceof FluidEmiStack) {
                        Object key2 = ((FluidEmiStack) itemEmiStack).getKey();
                        if (key2 instanceof Fluid) {
                            Fluid fluid2 = (Fluid) key2;
                            if (aVar5.a(i - aVar.getGuiLeft(), i2 - aVar.getGuiTop())) {
                                PacketDistributor.sendToServer(new mctech.q.d.d(((G) c0128aa.getHolder()).getBlockPos(), c0091d2.a(), ItemStack.EMPTY, new FluidStack(fluid2, 1000)), new CustomPacketPayload[0]);
                                return true;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return false;
        }
        AbstractContainerMenu menu3 = aVar.getMenu();
        if (menu3 instanceof C0130ac) {
            C0130ac c0130ac = (C0130ac) menu3;
            if (!(slotUnderMouse instanceof mctech.a.b.e.a)) {
                return false;
            }
            mctech.a.b.e.a aVar6 = slotUnderMouse;
            if (!(itemEmiStack instanceof ItemEmiStack)) {
                return false;
            }
            ItemEmiStack itemEmiStack4 = itemEmiStack;
            if (!itemEmiStack4.isEmpty()) {
                PacketDistributor.sendToServer(new mctech.q.d.d(((I) c0130ac.getHolder()).getBlockPos(), aVar6.a(), itemEmiStack4.getItemStack(), FluidStack.EMPTY), new CustomPacketPayload[0]);
                return true;
            }
            return false;
        }
        AbstractContainerMenu menu4 = aVar.getMenu();
        if (menu4 instanceof C0131ad) {
            C0131ad c0131ad = (C0131ad) menu4;
            if (!(slotUnderMouse instanceof mctech.a.b.e.a)) {
                return false;
            }
            mctech.a.b.e.a aVar7 = slotUnderMouse;
            if (!(itemEmiStack instanceof ItemEmiStack)) {
                return false;
            }
            ItemEmiStack itemEmiStack5 = itemEmiStack;
            if (!itemEmiStack5.isEmpty()) {
                PacketDistributor.sendToServer(new mctech.q.d.d(((J) c0131ad.getHolder()).getBlockPos(), aVar7.a(), itemEmiStack5.getItemStack(), FluidStack.EMPTY), new CustomPacketPayload[0]);
                return true;
            }
            return false;
        }
        return false;
    }

    public void render(Screen screen, EmiIngredient emiIngredient, GuiGraphics guiGraphics, int i, int i2, float f) {
        if (!(screen instanceof mctech.m.d.a)) {
            return;
        }
        mctech.m.d.a aVar = (mctech.m.d.a) screen;
        int guiLeft = aVar.getGuiLeft();
        int guiTop = aVar.getGuiTop();
        AbstractContainerMenu menu = aVar.getMenu();
        if (menu instanceof C0129ab) {
            C0129ab c0129ab = (C0129ab) menu;
            EmiStack emiStack = (EmiStack) emiIngredient.getEmiStacks().getFirst();
            if (emiStack instanceof ItemEmiStack) {
                for (mctech.a.b.c.a aVar2 : c0129ab.slots) {
                    if (aVar2.isActive() && (aVar2 instanceof mctech.a.b.c.a)) {
                        mctech.a.b.c.a aVar3 = aVar2;
                        guiGraphics.fill(guiLeft + aVar3.c(), guiTop + aVar3.d(), guiLeft + aVar3.c() + aVar3.e(), guiTop + aVar3.d() + aVar3.f(), -2010079184);
                    }
                }
            }
            if (emiStack instanceof FluidEmiStack) {
                for (mctech.utils.e.b bVar : aVar.a()) {
                    if (bVar instanceof mctech.a.b.c.a) {
                        mctech.a.b.c.a aVar4 = (mctech.a.b.c.a) bVar;
                        guiGraphics.fill(guiLeft + aVar4.c(), guiTop + aVar4.d(), guiLeft + aVar4.c() + aVar4.e(), guiTop + aVar4.d() + aVar4.f(), -2010079184);
                    }
                }
                return;
            }
            return;
        }
        AbstractContainerMenu menu2 = aVar.getMenu();
        if (menu2 instanceof C0128aa) {
            C0128aa c0128aa = (C0128aa) menu2;
            EmiStack emiStack2 = (EmiStack) emiIngredient.getEmiStacks().getFirst();
            if (emiStack2 instanceof ItemEmiStack) {
                for (mctech.a.b.c.a aVar5 : c0128aa.slots) {
                    if (aVar5.isActive() && (aVar5 instanceof mctech.a.b.c.a)) {
                        mctech.a.b.c.a aVar6 = aVar5;
                        guiGraphics.fill(guiLeft + aVar6.c(), guiTop + aVar6.d(), guiLeft + aVar6.c() + aVar6.e(), guiTop + aVar6.d() + aVar6.f(), -2010079184);
                    }
                }
            }
            if (emiStack2 instanceof FluidEmiStack) {
                for (mctech.utils.e.b bVar2 : aVar.a()) {
                    if (bVar2 instanceof mctech.a.b.c.a) {
                        mctech.a.b.c.a aVar7 = (mctech.a.b.c.a) bVar2;
                        guiGraphics.fill(guiLeft + aVar7.c(), guiTop + aVar7.d(), guiLeft + aVar7.c() + aVar7.e(), guiTop + aVar7.d() + aVar7.f(), -2010079184);
                    }
                }
                return;
            }
            return;
        }
        AbstractContainerMenu menu3 = aVar.getMenu();
        if (menu3 instanceof C0130ac) {
            C0130ac c0130ac = (C0130ac) menu3;
            if (((EmiStack) emiIngredient.getEmiStacks().getFirst()) instanceof ItemEmiStack) {
                for (mctech.a.b.c.a aVar8 : c0130ac.slots) {
                    if (aVar8.isActive() && (aVar8 instanceof mctech.a.b.c.a)) {
                        mctech.a.b.c.a aVar9 = aVar8;
                        guiGraphics.fill(guiLeft + aVar9.c(), guiTop + aVar9.d(), guiLeft + aVar9.c() + aVar9.e(), guiTop + aVar9.d() + aVar9.f(), -2010079184);
                    }
                }
                return;
            }
            return;
        }
        AbstractContainerMenu menu4 = aVar.getMenu();
        if (menu4 instanceof C0131ad) {
            C0131ad c0131ad = (C0131ad) menu4;
            if (((EmiStack) emiIngredient.getEmiStacks().getFirst()) instanceof ItemEmiStack) {
                for (mctech.a.b.c.a aVar10 : c0131ad.slots) {
                    if (aVar10.isActive() && (aVar10 instanceof mctech.a.b.c.a)) {
                        mctech.a.b.c.a aVar11 = aVar10;
                        guiGraphics.fill(guiLeft + aVar11.c(), guiTop + aVar11.d(), guiLeft + aVar11.c() + aVar11.e(), guiTop + aVar11.d() + aVar11.f(), -2010079184);
                    }
                }
            }
        }
    }
}
