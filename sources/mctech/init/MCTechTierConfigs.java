package mctech.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import java.util.function.Function;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.items.EnumC0125a;
import mctech.items.f;
import mctech.modules.config.BasicModularItemTierConfig;
import mctech.modules.config.ModularItemTierConfig;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegistryBuilder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechTierConfigs.class */
public class MCTechTierConfigs {
    private static final ResourceKey<Registry<MapCodec<? extends ModularItemTierConfig>>> REGISTRY_KEY = ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "tier_configs"));
    public static final Registry<MapCodec<? extends ModularItemTierConfig>> CONFIGS = new RegistryBuilder(REGISTRY_KEY).sync(true).maxId(255).defaultKey(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "config_empty")).create();
    private static final DeferredRegister<MapCodec<? extends ModularItemTierConfig>> REGISTRY = DeferredRegister.create(CONFIGS, MCTech.MODID);
    public static final Supplier<MapCodec<BasicModularItemTierConfig>> BASIC = register("basic", BasicModularItemTierConfig.CODEC);
    public static final Supplier<MapCodec<EnumC0125a.C0021a>> ARMOR = register("armor", EnumC0125a.f);
    public static final Supplier<MapCodec<f.a>> DIGGER = register("digger", f.f);
    public static final Codec<ModularItemTierConfig> POLYMORPH_CODEC = CONFIGS.byNameCodec().dispatch((v0) -> {
        return v0.codec();
    }, Function.identity());

    public static void register(IEventBus iEventBus) {
        REGISTRY.register(iEventBus);
    }

    private static <T extends ModularItemTierConfig> Supplier<MapCodec<T>> register(String str, MapCodec<T> mapCodec) {
        return REGISTRY.register(str, () -> {
            return mapCodec;
        });
    }
}
