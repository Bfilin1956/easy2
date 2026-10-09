package mctech.mixin.client.shaders;

import mctech.x.b;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/shaders/GameRendererMixin.class */
@Mixin({GameRenderer.class})
public class GameRendererMixin {
    @Inject(method = {"resize"}, at = {@At("RETURN")}, remap = false)
    private void resize(int i, int i2, CallbackInfo callbackInfo) {
        b.a(Math.max(1, i), Math.max(1, i2));
    }
}
