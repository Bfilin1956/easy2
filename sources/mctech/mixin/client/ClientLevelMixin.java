package mctech.mixin.client;

import mctech.p.a.g;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/ClientLevelMixin.class */
@Mixin(value = {ClientLevel.class}, remap = false)
public class ClientLevelMixin {

    @Shadow
    @Final
    private LevelRenderer levelRenderer;

    @Inject(method = {"destroyBlockProgress"}, at = {@At("HEAD")}, remap = false)
    private void destroyBlockProgress(int i, BlockPos blockPos, int i2, CallbackInfo callbackInfo) {
        g.a((ClientLevel) this, i, blockPos, i2, this.levelRenderer);
    }
}
