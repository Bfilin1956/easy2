package mctech.init;

import mctech.MCTech;
import mctech.t.a;
import mctech.t.d;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechMobEffects.class */
public class MCTechMobEffects {
    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, MCTech.MODID);
    public static final DeferredHolder<MobEffect, d> XRAY_VISION = REGISTRY.register("xray_vision", d::new);
    public static final DeferredHolder<MobEffect, a> BURNING = REGISTRY.register("burning", a::new);

    public static void register(IEventBus iEventBus) {
        REGISTRY.register(iEventBus);
    }
}
