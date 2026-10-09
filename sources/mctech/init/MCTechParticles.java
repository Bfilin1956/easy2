package mctech.init;

import mctech.MCTech;
import mctech.v.g.d;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechParticles.class */
public class MCTechParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, MCTech.MODID);
    public static final DeferredHolder<ParticleType<?>, d> DAMAGE_PARTICLE = PARTICLE_TYPES.register("damage_particle", d::new);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPARK_PARTICLE = PARTICLE_TYPES.register("spark_particle", () -> {
        return new SimpleParticleType(false);
    });

    public static void register(IEventBus iEventBus) {
        PARTICLE_TYPES.register(iEventBus);
    }
}
