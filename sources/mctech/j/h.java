package mctech.j;

import com.mojang.serialization.MapCodec;
import mctech.MCTech;
import mctech.init.MCTechBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeGenerationSettingsBuilder;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/j/h.class */
public class h {
    static ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>> a;
    static ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>> b;
    static ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>> c;
    static ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>> d;
    static ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>> e;
    static ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>> f;
    static Holder<PlacedFeature> g;
    static Holder<PlacedFeature> h;
    static Holder<PlacedFeature> i;
    static Holder<PlacedFeature> j;
    static Holder<PlacedFeature> k;
    static Holder<PlacedFeature> l;
    static Holder<PlacedFeature> m;
    private static final DeferredRegister<FoliagePlacerType<?>> p = DeferredRegister.create(BuiltInRegistries.FOLIAGE_PLACER_TYPE, MCTech.MODID);
    private static final DeferredRegister<TrunkPlacerType<?>> q = DeferredRegister.create(BuiltInRegistries.TRUNK_PLACER_TYPE, MCTech.MODID);
    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<mctech.blocks.e.a.b>> n = q.register("rubber_trunk", () -> {
        return new TrunkPlacerType(mctech.blocks.e.a.b.b);
    });
    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<mctech.blocks.e.a.a>> o = p.register("rubber_leaves", () -> {
        return new FoliagePlacerType(mctech.blocks.e.a.a.a);
    });

    public static void a(IEventBus iEventBus) {
        p.register(iEventBus);
        q.register(iEventBus);
    }

    public static void a() {
    }

    public static void a(Holder<Biome> holder, BiomeGenerationSettingsBuilder biomeGenerationSettingsBuilder) {
        if (MCTech.CONFIG.oreTin.get()) {
            biomeGenerationSettingsBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, g);
        }
        if (MCTech.CONFIG.oreUranium.get()) {
            biomeGenerationSettingsBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, h);
        }
        if (MCTech.CONFIG.oreSilver.get()) {
            biomeGenerationSettingsBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, j);
        }
        if (MCTech.CONFIG.oreUranium.get()) {
            biomeGenerationSettingsBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, i);
        }
        if (holder.is(BiomeTags.IS_NETHER)) {
            if (MCTech.CONFIG.oreNetherAluminium.get()) {
                biomeGenerationSettingsBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, k);
            }
            if (MCTech.CONFIG.oreNetherSilver.get()) {
                biomeGenerationSettingsBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, l);
            }
        }
        if ((holder.is(BiomeTags.IS_JUNGLE) || holder.is(BiomeTags.IS_FOREST) || holder.is(Tags.Biomes.IS_SWAMP)) && MCTech.CONFIG.oreRubberTree.get()) {
            biomeGenerationSettingsBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, m);
        }
    }

    public static ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>> a(boolean z) {
        TreeConfiguration.TreeConfigurationBuilder treeConfigurationBuilderIgnoreVines = new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(((mctech.blocks.base.d) MCTechBlocks.RUBBERWOOD_LOG.get()).defaultBlockState()), new mctech.blocks.e.a.b(5, 2, 0), BlockStateProvider.simple(((mctech.blocks.e.g) MCTechBlocks.RUBBER_LEAVES.get()).defaultBlockState()), new mctech.blocks.e.a.a(), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines();
        return new ConfiguredFeature<>(Feature.TREE, (z ? treeConfigurationBuilderIgnoreVines.forceDirt() : treeConfigurationBuilderIgnoreVines).build());
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/j/h$a.class */
    public static class a implements BiomeModifier {
        public static final MapCodec<a> a = MapCodec.unit(a::new);

        public void modify(Holder<Biome> holder, BiomeModifier.Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
            if (phase == BiomeModifier.Phase.ADD) {
                h.a(holder, builder.getGenerationSettings());
            }
        }

        public MapCodec<? extends BiomeModifier> codec() {
            return a;
        }
    }
}
