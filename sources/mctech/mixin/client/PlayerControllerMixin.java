package mctech.mixin.client;

import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/PlayerControllerMixin.class */
@Mixin(value = {MultiPlayerGameMode.class}, remap = false)
@OnlyIn(Dist.CLIENT)
public interface PlayerControllerMixin {
    @Accessor("destroyProgress")
    float getDestroyProgress();
}
