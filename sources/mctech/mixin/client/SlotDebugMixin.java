package mctech.mixin.client;

import java.util.ArrayList;
import java.util.Optional;
import mctech.m.a.g;
import mctech.m.e.a;
import mctech.m.e.e;
import mctech.m.e.i;
import mctech.m.e.k;
import mctech.m.g.x;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.Slot;
import net.neoforged.fml.loading.FMLEnvironment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/SlotDebugMixin.class */
@Mixin({AbstractContainerScreen.class})
public abstract class SlotDebugMixin {
    @Inject(method = {"renderSlotHighlight(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/world/inventory/Slot;IIF)V"}, at = {@At("HEAD")}, remap = false)
    public void renderSlotHighlight(GuiGraphics guiGraphics, Slot slot, int i, int i2, float f, CallbackInfo callbackInfo) {
        if (!FMLEnvironment.production) {
            debugSlot(guiGraphics, slot, i, i2, f);
        }
    }

    @Unique
    private static void debugSlot(GuiGraphics guiGraphics, Slot slot, int i, int i2, float f) {
        i inventoryHandler;
        k kVarD;
        ArrayList arrayList = new ArrayList();
        if (slot instanceof x) {
            g gVarF = ((x) slot).f();
            arrayList.add(Component.literal(String.format("Слот %s/%s", Integer.valueOf(slot.index + 1), Integer.valueOf(gVarF.getSlotCount()))).withStyle(ChatFormatting.GRAY));
            arrayList.add(Component.literal(String.format("Индекс %s", Integer.valueOf(slot.index))).withStyle(ChatFormatting.GRAY));
            if ((gVarF instanceof e) && (kVarD = (inventoryHandler = ((e) gVarF).getInventoryHandler()).d(slot.index)) != null) {
                arrayList.add(Component.literal(String.format("Тип: %s", kVarD.a())).withStyle(ChatFormatting.GRAY));
                for (Direction direction : Direction.values()) {
                    a aVarA = inventoryHandler.a(slot.index, direction);
                    ChatFormatting chatFormatting = ChatFormatting.GRAY;
                    if (aVarA == a.IMPORT) {
                        chatFormatting = ChatFormatting.GREEN;
                    }
                    if (aVarA == a.EXPORT) {
                        chatFormatting = ChatFormatting.RED;
                    }
                    if (aVarA == a.BOTH) {
                        chatFormatting = ChatFormatting.BLUE;
                    }
                    arrayList.add(Component.literal(direction.getName().toUpperCase() + ": ").withStyle(ChatFormatting.DARK_GRAY).append(Component.literal(aVarA.name()).withStyle(chatFormatting)));
                }
            }
        }
        guiGraphics.renderTooltip(Minecraft.getInstance().font, arrayList, Optional.empty(), i - (guiGraphics.guiWidth() / 2), i2 - (guiGraphics.guiHeight() / 2));
    }
}
