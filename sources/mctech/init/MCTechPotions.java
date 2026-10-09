package mctech.init;

import java.util.function.Supplier;
import mctech.MCTech;
import mctech.t.b;
import mctech.t.c;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechPotions.class */
public class MCTechPotions {
    private static final DeferredRegister<MobEffect> MOB_EFFECT = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, MCTech.MODID);
    public static final DeferredHolder<MobEffect, b> RADIATION = register("radiation", () -> {
        return new b();
    });
    public static final DeferredHolder<MobEffect, c> SHAKY = register("shaky", () -> {
        return new c(MobEffectCategory.NEUTRAL, 5578058);
    });

    public static void register(IEventBus iEventBus) {
        MOB_EFFECT.register(iEventBus);
    }

    public static <I extends MobEffect> DeferredHolder<MobEffect, I> register(String str, Supplier<? extends I> supplier) {
        return MOB_EFFECT.register(str, supplier);
    }
}
