package mctech.blocks.e.a;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectList;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import mctech.api.util.DirectionList;
import mctech.blocks.base.d;
import mctech.init.MCTechBlocks;
import mctech.j.h;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.CommonLevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.neoforge.common.Tags;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/e/a/b.class */
public class b extends TrunkPlacer {
    public static Predicate<BlockState> a = blockState -> {
        return blockState.getBlock() == MCTechBlocks.RUBBER_SAPLING.get();
    };
    public static final MapCodec<b> b = RecordCodecBuilder.mapCodec(instance -> {
        return trunkPlacerParts(instance).apply(instance, (v1, v2, v3) -> {
            return new b(v1, v2, v3);
        });
    });

    public b(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    protected TrunkPlacerType<?> type() {
        return (TrunkPlacerType) h.n.get();
    }

    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader levelSimulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource randomSource, int i, BlockPos blockPos, TreeConfiguration treeConfiguration) {
        int i2 = 0;
        if (levelSimulatedReader instanceof CommonLevelAccessor) {
            Holder biome = ((CommonLevelAccessor) levelSimulatedReader).getBiome(blockPos);
            if (biome.is(BiomeTags.IS_FOREST) || biome.is(BiomeTags.IS_JUNGLE)) {
                i2 = 0 + 6;
            }
            if (biome.is(Tags.Biomes.IS_SWAMP)) {
                i2 += 15;
            }
            if (!treeConfiguration.forceDirt && (i2 <= 0 || randomSource.nextInt(100) <= 100 - (i2 * 2))) {
                return ObjectLists.emptyList();
            }
        } else if (!treeConfiguration.forceDirt) {
            return ObjectLists.emptyList();
        }
        setDirtAt(levelSimulatedReader, biConsumer, randomSource, blockPos.below(), treeConfiguration);
        int i3 = 25;
        ObjectList objectListI = mctech.utils.a.b.i();
        for (int i4 = 0; i4 < i; i4++) {
            BlockState blockStateDefaultBlockState = ((d) MCTechBlocks.RUBBERWOOD_LOG.get()).defaultBlockState();
            if (randomSource.nextInt(100) <= i3) {
                i3 -= 10;
                blockStateDefaultBlockState = (BlockState) ((BlockState) ((BlockState) blockStateDefaultBlockState.setValue(mctech.blocks.e.h.d, true)).setValue(mctech.blocks.e.h.e, true)).setValue(mctech.blocks.e.h.a, DirectionList.HORIZONTAL.getRandomFacing());
            }
            a(levelSimulatedReader, randomSource, blockPos.above(i4), biConsumer, blockStateDefaultBlockState);
            if (i < 4 || ((i < 7 && i4 > 1) || i4 > 2)) {
                int x = blockPos.getX();
                int z = blockPos.getZ();
                int i5 = x - 2;
                while (i5 <= x + 2) {
                    int i6 = z - 2;
                    while (i6 <= z + 2) {
                        int i7 = (i4 + 4) - i;
                        if (i7 < 1) {
                            i7 = 1;
                        }
                        boolean z2 = (i5 > x - 2 && i5 < x + 2 && i6 > z - 2 && i6 < z + 2) || (i5 > x - 2 && i5 < x + 2 && randomSource.nextInt(i7) == 0) || (i6 > z - 2 && i6 < z + 2 && randomSource.nextInt(i7) == 0);
                        BlockPos blockPos2 = new BlockPos(i5, blockPos.getY() + i4, i6);
                        if (z2 && TreeFeature.isAirOrLeaves(levelSimulatedReader, blockPos2)) {
                            objectListI.add(new FoliagePlacer.FoliageAttachment(blockPos2, 0, true));
                        }
                        i6++;
                    }
                    i5++;
                }
            }
        }
        for (int i8 = 0; i8 <= 2; i8++) {
            BlockPos blockPos3 = new BlockPos(blockPos.getX(), blockPos.getY() + i + i8, blockPos.getZ());
            if (TreeFeature.isAirOrLeaves(levelSimulatedReader, blockPos3)) {
                objectListI.add(new FoliagePlacer.FoliageAttachment(blockPos3, 0, true));
            }
        }
        return ImmutableList.copyOf(objectListI);
    }

    protected static boolean a(LevelSimulatedReader levelSimulatedReader, RandomSource randomSource, BlockPos blockPos, BiConsumer<BlockPos, BlockState> biConsumer, BlockState blockState) {
        if (TreeFeature.validTreePos(levelSimulatedReader, blockPos)) {
            biConsumer.accept(blockPos, blockState);
            return true;
        }
        return false;
    }
}
