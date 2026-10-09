package mctech.integration.emi.plugin.core;

import dev.emi.emi.api.EmiDragDropHandler;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import mctech.blockentities.c.ag;
import mctech.m.b.aK;
import mctech.m.d.a;
import mctech.m.g.f;
import mctech.q.d.c;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.neoforged.neoforge.network.PacketDistributor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/EMIDropHandler.class */
public class EMIDropHandler implements EmiDragDropHandler<Screen> {
    /* JADX WARN: Multi-variable type inference failed */
    public boolean dropStack(Screen screen, EmiIngredient emiIngredient, int i, int i2) {
        if (!(screen instanceof a)) {
            return false;
        }
        a aVar = (a) screen;
        AbstractContainerMenu menu = aVar.getMenu();
        if (menu instanceof aK) {
            aK aKVar = (aK) menu;
            Slot slotUnderMouse = aVar.getSlotUnderMouse();
            if (slotUnderMouse == null || !(slotUnderMouse instanceof f)) {
                return false;
            }
            f fVar = (f) slotUnderMouse;
            if (!emiIngredient.getEmiStacks().isEmpty()) {
                if (((ag) aKVar.getHolder()).c != 0 || fVar.ad_() != 0) {
                    if (((ag) aKVar.getHolder()).c == 2 && fVar.ad_() == 1) {
                        return false;
                    }
                    PacketDistributor.sendToServer(new c(fVar.ad_(), ((EmiStack) emiIngredient.getEmiStacks().getFirst()).getItemStack()), new CustomPacketPayload[0]);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public void render(Screen screen, EmiIngredient emiIngredient, GuiGraphics guiGraphics, int i, int i2, float f) {
        if (!(screen instanceof a)) {
            return;
        }
        a aVar = (a) screen;
        AbstractContainerMenu menu = aVar.getMenu();
        if (menu instanceof aK) {
            aK aKVar = (aK) menu;
            aKVar.slots.stream().filter(slot -> {
                if (slot instanceof f) {
                    f fVar = (f) slot;
                    if ((((ag) aKVar.getHolder()).c == 0 && fVar.ad_() == 1) || (((ag) aKVar.getHolder()).c == 2 && fVar.ad_() == 0)) {
                        return true;
                    }
                }
                return false;
            }).forEach(slot2 -> {
                int guiLeft = aVar.getGuiLeft() + slot2.x;
                int guiTop = aVar.getGuiTop() + slot2.y;
                guiGraphics.fill(guiLeft, guiTop, guiLeft + 16, guiTop + 16, -2010079184);
            });
        }
    }
}
