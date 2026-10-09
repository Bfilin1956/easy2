package mctech.mixin.client.audio;

import net.minecraft.client.sounds.ChannelAccess;
import net.minecraft.client.sounds.SoundBufferLibrary;
import net.minecraft.client.sounds.SoundEngine;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/audio/SoundEngineMixin.class */
@Mixin(value = {SoundEngine.class}, remap = false)
@OnlyIn(Dist.CLIENT)
public interface SoundEngineMixin {
    @Accessor("channelAccess")
    ChannelAccess getChannels();

    @Accessor("soundBuffers")
    SoundBufferLibrary getAudioBuffers();
}
