package mctech.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import mctech.api.items.ITooltipStackRenderer;
import mctech.m.a.j;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/AbstractContainerScreenMixin.class */
@Mixin(value = {AbstractContainerScreen.class}, remap = false)
public abstract class AbstractContainerScreenMixin<T extends AbstractContainerMenu> {
    @Shadow
    public abstract int getGuiLeft();

    @Shadow
    public abstract int getGuiTop();

    @Shadow
    public abstract T getMenu();

    @Shadow
    protected abstract boolean isHovering(int i, int i2, int i3, int i4, double d, double d2);

    @Inject(method = {"isHovering(Lnet/minecraft/world/inventory/Slot;DD)Z"}, at = {@At("HEAD")}, cancellable = true)
    private void isHovering(Slot slot, double d, double d2, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        int iO = ((j) slot).o();
        callbackInfoReturnable.setReturnValue(Boolean.valueOf(isHovering(slot.x, slot.y, iO, iO, d, d2)));
    }

    @Inject(method = {"renderSlot(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/world/inventory/Slot;)V"}, at = {@At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;pushPose()V", shift = At.Shift.AFTER)})
    private void renderSlot(GuiGraphics guiGraphics, Slot slot, CallbackInfo callbackInfo) {
        float fO = ((j) slot).o() / 16.0f;
        guiGraphics.pose().translate(slot.x, slot.y, 0.0f);
        guiGraphics.pose().scale(fO, fO, 1.0f);
        guiGraphics.pose().translate(-slot.x, -slot.y, 0.0f);
    }

    @Inject(method = {"renderSlotHighlight(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/world/inventory/Slot;IIF)V"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;renderSlotHighlight(Lnet/minecraft/client/gui/GuiGraphics;IIII)V")})
    private void renderSlotHighlightPre(GuiGraphics guiGraphics, Slot slot, int i, int i2, float f, CallbackInfo callbackInfo) {
        float fO = ((j) slot).o() / 16.0f;
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(slot.x, slot.y, 0.0d);
        poseStackPose.scale(fO, fO, 1.0f);
        poseStackPose.translate(-slot.x, -slot.y, 0.0d);
    }

    @Inject(method = {"renderSlotHighlight(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/world/inventory/Slot;IIF)V"}, at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;renderSlotHighlight(Lnet/minecraft/client/gui/GuiGraphics;IIII)V", shift = At.Shift.AFTER)})
    private void renderSlotHighlightPost(GuiGraphics guiGraphics, Slot slot, int i, int i2, float f, CallbackInfo callbackInfo) {
        guiGraphics.pose().popPose();
    }

    @Inject(method = {"renderSlotHighlight(Lnet/minecraft/client/gui/GuiGraphics;Lnet/minecraft/world/inventory/Slot;IIF)V"}, at = {@At("HEAD")}, remap = false)
    public void renderSlotHighlight(GuiGraphics guiGraphics, Slot slot, int i, int i2, float f, CallbackInfo callbackInfo) {
        if (slot instanceof ITooltipStackRenderer) {
            ITooltipStackRenderer iTooltipStackRenderer = (ITooltipStackRenderer) slot;
            if (getMenu().getCarried().isEmpty()) {
                iTooltipStackRenderer.renderTooltipItemStacks(guiGraphics, slot, i - getGuiLeft(), i2 - getGuiTop(), f);
            }
        }
    }
}
