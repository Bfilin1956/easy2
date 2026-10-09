package mctech.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import dev.emi.emi.api.widget.Bounds;
import dev.emi.emi.api.widget.Widget;
import dev.emi.emi.screen.RecipeScreen;
import dev.emi.emi.screen.WidgetGroup;
import java.util.List;
import mctech.integration.emi.plugin.base.IEmiWidgetEventListener;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/EmiRecipeScreenMixin.class */
@Mixin({RecipeScreen.class})
public class EmiRecipeScreenMixin {

    @Shadow(remap = false)
    private List<WidgetGroup> currentPage;

    @Inject(method = {"render"}, at = {@At(value = "INVOKE", target = "Ldev/emi/emi/api/widget/Widget;render(Lnet/minecraft/client/gui/GuiGraphics;IIF)V", shift = At.Shift.AFTER)}, remap = false)
    public void render(GuiGraphics guiGraphics, int i, int i2, float f, CallbackInfo callbackInfo, @Local(name = {"group"}) WidgetGroup widgetGroup, @Local(name = {"widget"}) Widget widget) {
        int iX = i - widgetGroup.x();
        int iY = i2 - widgetGroup.y();
        if (widget instanceof IEmiWidgetEventListener) {
            ((IEmiWidgetEventListener) widget).render(guiGraphics, iX, iY, f, widgetGroup);
        }
    }

    @Inject(method = {"mouseClicked"}, at = {@At("HEAD")}, remap = false, cancellable = true)
    public void mouseClicked(double d, double d2, int i, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        for (WidgetGroup widgetGroup : this.currentPage) {
            double dX = d - ((double) widgetGroup.x());
            double dY = d2 - ((double) widgetGroup.y());
            Bounds bounds = new Bounds(widgetGroup.x(), widgetGroup.y(), widgetGroup.getWidth(), widgetGroup.getHeight());
            for (IEmiWidgetEventListener iEmiWidgetEventListener : widgetGroup.widgets) {
                if ((iEmiWidgetEventListener instanceof IEmiWidgetEventListener) && iEmiWidgetEventListener.mouseClicked(dX, dY, i, bounds)) {
                    callbackInfoReturnable.setReturnValue(true);
                }
            }
        }
    }

    @Inject(method = {"mouseReleased"}, at = {@At("HEAD")}, remap = false, cancellable = true)
    public void mouseReleased(double d, double d2, int i, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        for (WidgetGroup widgetGroup : this.currentPage) {
            double dX = d - ((double) widgetGroup.x());
            double dY = d2 - ((double) widgetGroup.y());
            Bounds bounds = new Bounds(widgetGroup.x(), widgetGroup.y(), widgetGroup.getWidth(), widgetGroup.getHeight());
            for (IEmiWidgetEventListener iEmiWidgetEventListener : widgetGroup.widgets) {
                if ((iEmiWidgetEventListener instanceof IEmiWidgetEventListener) && iEmiWidgetEventListener.mouseReleased(dX, dY, i, bounds)) {
                    callbackInfoReturnable.setReturnValue(true);
                }
            }
        }
    }

    @Inject(method = {"mouseDragged"}, at = {@At("HEAD")}, remap = false, cancellable = true)
    public void mouseDragged(double d, double d2, int i, double d3, double d4, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        for (WidgetGroup widgetGroup : this.currentPage) {
            double dX = d - ((double) widgetGroup.x());
            double dY = d2 - ((double) widgetGroup.y());
            Bounds bounds = new Bounds(widgetGroup.x(), widgetGroup.y(), widgetGroup.getWidth(), widgetGroup.getHeight());
            for (IEmiWidgetEventListener iEmiWidgetEventListener : widgetGroup.widgets) {
                if ((iEmiWidgetEventListener instanceof IEmiWidgetEventListener) && iEmiWidgetEventListener.mouseDragged(dX, dY, i, d3, d4, bounds)) {
                    callbackInfoReturnable.setReturnValue(true);
                }
            }
        }
    }

    @Inject(method = {"mouseScrolled"}, at = {@At("HEAD")}, remap = false, cancellable = true)
    public void mouseScrolled(double d, double d2, double d3, double d4, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        for (WidgetGroup widgetGroup : this.currentPage) {
            double dX = d - ((double) widgetGroup.x());
            double dY = d2 - ((double) widgetGroup.y());
            Bounds bounds = new Bounds(widgetGroup.x(), widgetGroup.y(), widgetGroup.getWidth(), widgetGroup.getHeight());
            for (IEmiWidgetEventListener iEmiWidgetEventListener : widgetGroup.widgets) {
                if ((iEmiWidgetEventListener instanceof IEmiWidgetEventListener) && iEmiWidgetEventListener.mouseScrolled(dX, dY, d3, d4, bounds)) {
                    callbackInfoReturnable.setReturnValue(true);
                }
            }
        }
    }

    @Inject(method = {"charTyped"}, at = {@At("HEAD")}, remap = false, cancellable = true)
    public void charTyped(char c, int i, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        for (WidgetGroup widgetGroup : this.currentPage) {
            Bounds bounds = new Bounds(widgetGroup.x(), widgetGroup.y(), widgetGroup.getWidth(), widgetGroup.getHeight());
            for (IEmiWidgetEventListener iEmiWidgetEventListener : widgetGroup.widgets) {
                if ((iEmiWidgetEventListener instanceof IEmiWidgetEventListener) && iEmiWidgetEventListener.charTyped(c, i, bounds)) {
                    callbackInfoReturnable.setReturnValue(true);
                }
            }
        }
    }

    @Inject(method = {"keyPressed"}, at = {@At("HEAD")}, remap = false, cancellable = true)
    public void keyPressed(int i, int i2, int i3, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        for (WidgetGroup widgetGroup : this.currentPage) {
            Bounds bounds = new Bounds(widgetGroup.x(), widgetGroup.y(), widgetGroup.getWidth(), widgetGroup.getHeight());
            for (IEmiWidgetEventListener iEmiWidgetEventListener : widgetGroup.widgets) {
                if ((iEmiWidgetEventListener instanceof IEmiWidgetEventListener) && iEmiWidgetEventListener.keyPressed(i, i2, i3, bounds)) {
                    callbackInfoReturnable.setReturnValue(true);
                }
            }
        }
    }
}
