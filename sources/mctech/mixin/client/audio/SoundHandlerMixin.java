package mctech.mixin.client.audio;

import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.client.sounds.SoundManager;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/audio/SoundHandlerMixin.class */
@Mixin(value = {SoundManager.class}, remap = false)
@OnlyIn(Dist.CLIENT)
public interface SoundHandlerMixin {
    @Accessor("soundEngine")
    SoundEngine getSoundEngine();
}
