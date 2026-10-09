package mctech.mixin.client;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/ScreenMixin.class */
@Mixin(value = {AbstractContainerScreen.class}, remap = false)
@OnlyIn(Dist.CLIENT)
public interface ScreenMixin {
    @Accessor("lastClickButton")
    void setLastClickButton(int i);
}
