package mctech.api.features;

import net.minecraft.util.RandomSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/features/IParticleSpawner.class */
public interface IParticleSpawner {
    @OnlyIn(Dist.CLIENT)
    void animationTick(RandomSource randomSource);
}
