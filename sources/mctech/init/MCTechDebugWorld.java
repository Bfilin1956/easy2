package mctech.init;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalLong;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import mctech.MCTech;
import mctech.blocks.b.i;
import mctech.p.b.a;
import net.minecraft.core.BlockPos;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.SectionPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterLists;
import net.minecraft.world.level.biome.TheEndBiomeSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechDebugWorld.class */
public class MCTechDebugWorld {
    private static final String KEY_DEBUG = "debug";
    private static final DeferredRegister<MapCodec<? extends ChunkGenerator>> CHUNK_GENERATORS = DeferredRegister.create(Registries.CHUNK_GENERATOR, MCTech.MODID);
    private static final String KEY_DEBUG_WORLD_TYPE = "debug_world_type";
    public static final ResourceKey<DimensionType> DEBUG_WORLD_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, MCTech.loc(KEY_DEBUG_WORLD_TYPE));
    private static final String KEY_DEBUG_WORLD = "debug_world";
    public static final ResourceKey<LevelStem> DEBUG_WORLD = ResourceKey.create(Registries.LEVEL_STEM, MCTech.loc(KEY_DEBUG_WORLD));
    public static final ResourceKey<Level> DEBUG_WORLD_LEVEL = ResourceKey.create(Registries.DIMENSION, MCTech.loc(KEY_DEBUG_WORLD));
    public static final ResourceKey<WorldPreset> DEBUG_PRESET = ResourceKey.create(Registries.WORLD_PRESET, MCTech.loc(KEY_DEBUG_WORLD));
    public static final String KEY_DEBUG_WORLD_GENERATOR = "debug_world_generator";
    public static DeferredHolder<MapCodec<? extends ChunkGenerator>, MapCodec<MCTechDebugLevelSource>> DEBUG_GENERATOR = CHUNK_GENERATORS.register(KEY_DEBUG_WORLD_GENERATOR, () -> {
        return MCTechDebugLevelSource.CODEC;
    });

    public static void register(IEventBus iEventBus) {
        CHUNK_GENERATORS.register(iEventBus);
    }

    public static void bootstrapDimensionTypes(BootstrapContext<DimensionType> bootstrapContext) {
        bootstrapContext.register(DEBUG_WORLD_TYPE, new DimensionType(OptionalLong.empty(), true, false, false, true, 1.0d, true, false, -64, 384, 384, BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 0.0f, new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0)));
    }

    public static void bootstrapLevelStem(BootstrapContext<LevelStem> bootstrapContext) {
        HolderGetter holderGetterLookup = bootstrapContext.lookup(Registries.BIOME);
        bootstrapContext.register(DEBUG_WORLD, new LevelStem(bootstrapContext.lookup(Registries.DIMENSION_TYPE).getOrThrow(DEBUG_WORLD_TYPE), new MCTechDebugLevelSource(holderGetterLookup.getOrThrow(Biomes.PLAINS))));
    }

    public static void bootstrapWorldPresets(BootstrapContext<WorldPreset> bootstrapContext) {
        HolderGetter holderGetterLookup = bootstrapContext.lookup(Registries.BIOME);
        HolderGetter holderGetterLookup2 = bootstrapContext.lookup(Registries.DIMENSION_TYPE);
        HolderGetter holderGetterLookup3 = bootstrapContext.lookup(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST);
        HolderGetter holderGetterLookup4 = bootstrapContext.lookup(Registries.NOISE_SETTINGS);
        bootstrapContext.register(DEBUG_PRESET, new WorldPreset(Map.of(LevelStem.OVERWORLD, new LevelStem(holderGetterLookup2.getOrThrow(DEBUG_WORLD_TYPE), new MCTechDebugLevelSource(holderGetterLookup.getOrThrow(Biomes.PLAINS))), LevelStem.NETHER, new LevelStem(holderGetterLookup2.getOrThrow(BuiltinDimensionTypes.NETHER), new NoiseBasedChunkGenerator(MultiNoiseBiomeSource.createFromPreset(holderGetterLookup3.getOrThrow(MultiNoiseBiomeSourceParameterLists.NETHER)), holderGetterLookup4.getOrThrow(NoiseGeneratorSettings.NETHER))), LevelStem.END, new LevelStem(holderGetterLookup2.getOrThrow(BuiltinDimensionTypes.END), new NoiseBasedChunkGenerator(TheEndBiomeSource.create(holderGetterLookup), holderGetterLookup4.getOrThrow(NoiseGeneratorSettings.END))))));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechDebugWorld$MCTechDebugLevelSource.class */
    public static class MCTechDebugLevelSource extends ChunkGenerator {
        private static final int BLOCK_MARGIN = 2;
        private static final int HEIGHT = 70;
        private static final int SURFACE_HEIGHT = 60;
        public static final MapCodec<MCTechDebugLevelSource> CODEC = RecordCodecBuilder.mapCodec(instance -> {
            return instance.group(RegistryOps.retrieveElement(Biomes.PLAINS)).apply(instance, MCTechDebugLevelSource::new);
        });
        private static List<BlockState> ALL_BLOCKS = new ArrayList();
        private static int GRID_WIDTH = 0;
        private static int GRID_HEIGHT = 0;
        private static final BlockState AIR = Blocks.AIR.defaultBlockState();
        private static final BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.defaultBlockState();

        public MCTechDebugLevelSource(Holder.Reference<Biome> reference) {
            super(new FixedBiomeSource(reference));
        }

        public static void updateBlocks() {
            DefaultedRegistry defaultedRegistry = BuiltInRegistries.BLOCK;
            ALL_BLOCKS = (List) StreamSupport.stream(defaultedRegistry.spliterator(), false).filter(block -> {
                return defaultedRegistry.getKey(block).getNamespace().equals(MCTech.MODID);
            }).flatMap(block2 -> {
                return collectStates(block2).stream();
            }).sorted((blockState, blockState2) -> {
                if (blockState.getBlockHolder().getKey() == null || blockState2.getBlockHolder().getKey() == null) {
                    return 0;
                }
                return blockState.getBlockHolder().getKey().location().getPath().compareTo(blockState2.getBlockHolder().getKey().location().getPath());
            }).collect(Collectors.toList());
            GRID_WIDTH = Mth.ceil(Mth.sqrt(ALL_BLOCKS.size()));
            GRID_HEIGHT = Mth.ceil(ALL_BLOCKS.size() / GRID_WIDTH);
        }

        private static <T extends Comparable<T>> List<BlockState> collectStates(Block block) {
            if (block instanceof a) {
                return new ArrayList();
            }
            if (block instanceof i) {
                return new ArrayList();
            }
            Set setOf = Set.of("machine_tier", "machine_type", "fluid_type", "is_master", "master_position");
            ArrayList arrayList = new ArrayList();
            BlockState blockStateDefaultBlockState = block.defaultBlockState();
            for (Property property : blockStateDefaultBlockState.getProperties()) {
                for (Comparable comparable : property.getPossibleValues()) {
                    if (setOf.contains(property.getName())) {
                        if (!arrayList.contains(blockStateDefaultBlockState)) {
                            arrayList.add(blockStateDefaultBlockState);
                        }
                    } else {
                        arrayList.add((BlockState) blockStateDefaultBlockState.setValue(property, comparable));
                    }
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.add(blockStateDefaultBlockState);
            }
            return arrayList;
        }

        private static <T extends Comparable<T>> BlockState copyProperty(BlockState blockState, BlockState blockState2, Property<T> property) {
            return (BlockState) blockState2.setValue(property, blockState.getValue(property));
        }

        @NotNull
        protected MapCodec<? extends ChunkGenerator> codec() {
            return CODEC;
        }

        public void buildSurface(@NotNull WorldGenRegion worldGenRegion, @NotNull StructureManager structureManager, @NotNull RandomState randomState, @NotNull ChunkAccess chunkAccess) {
        }

        public void applyBiomeDecoration(@NotNull WorldGenLevel worldGenLevel, ChunkAccess chunkAccess, @NotNull StructureManager structureManager) {
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
            ChunkPos pos = chunkAccess.getPos();
            int i = pos.x;
            int i2 = pos.z;
            for (int i3 = 0; i3 < 16; i3++) {
                for (int i4 = 0; i4 < 16; i4++) {
                    int iSectionToBlockCoord = SectionPos.sectionToBlockCoord(i, i3);
                    int iSectionToBlockCoord2 = SectionPos.sectionToBlockCoord(i2, i4);
                    worldGenLevel.setBlock(mutableBlockPos.set(iSectionToBlockCoord, SURFACE_HEIGHT, iSectionToBlockCoord2), GRASS_BLOCK, 2);
                    worldGenLevel.setBlock(mutableBlockPos.set(iSectionToBlockCoord, HEIGHT, iSectionToBlockCoord2), getBlockStateFor(iSectionToBlockCoord, iSectionToBlockCoord2), 2);
                }
            }
        }

        @NotNull
        public CompletableFuture<ChunkAccess> fillFromNoise(@NotNull Blender blender, @NotNull RandomState randomState, @NotNull StructureManager structureManager, @NotNull ChunkAccess chunkAccess) {
            return CompletableFuture.completedFuture(chunkAccess);
        }

        public int getBaseHeight(int i, int i2, Heightmap.Types types, @NotNull LevelHeightAccessor levelHeightAccessor, @NotNull RandomState randomState) {
            return 0;
        }

        @NotNull
        public NoiseColumn getBaseColumn(int i, int i2, @NotNull LevelHeightAccessor levelHeightAccessor, @NotNull RandomState randomState) {
            return new NoiseColumn(0, new BlockState[0]);
        }

        public void addDebugScreenInfo(@NotNull List<String> list, @NotNull RandomState randomState, @NotNull BlockPos blockPos) {
        }

        public static BlockState getBlockStateFor(int i, int i2) {
            int iAbs;
            BlockState blockState = AIR;
            if (i > 0 && i2 > 0 && i % 2 != 0 && i2 % 2 != 0) {
                int i3 = i / 2;
                int i4 = i2 / 2;
                if (i3 <= GRID_WIDTH && i4 <= GRID_HEIGHT && (iAbs = Mth.abs((i3 * GRID_WIDTH) + i4)) < ALL_BLOCKS.size()) {
                    blockState = ALL_BLOCKS.get(iAbs);
                }
            }
            return blockState;
        }

        public void applyCarvers(@NotNull WorldGenRegion worldGenRegion, long j, @NotNull RandomState randomState, @NotNull BiomeManager biomeManager, @NotNull StructureManager structureManager, @NotNull ChunkAccess chunkAccess, GenerationStep.Carving carving) {
        }

        public void spawnOriginalMobs(@NotNull WorldGenRegion worldGenRegion) {
        }

        public int getMinY() {
            return 0;
        }

        public int getGenDepth() {
            return 384;
        }

        public int getSeaLevel() {
            return 63;
        }
    }
}
