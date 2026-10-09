package mctech.mixin.client.rendering;

import mctech.a.b.c.a;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/rendering/AbstractContainerScreenMixin.class */
@Mixin({AbstractContainerScreen.class})
public class AbstractContainerScreenMixin {
    @Inject(method = {"renderTooltip"}, at = {@At("HEAD")}, cancellable = true, remap = false)
    private void onRenderTooltip(GuiGraphics guiGraphics, int i, int i2, CallbackInfo callbackInfo) {
        if (((AbstractContainerScreen) this).getSlotUnderMouse() instanceof a) {
            callbackInfo.cancel();
        }
    }
}
