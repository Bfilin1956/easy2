package mctech.blocks.e.a;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.j.h;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/e/a/a.class */
public class a extends FoliagePlacer {
    public static final MapCodec<a> a = RecordCodecBuilder.mapCodec(instance -> {
        return foliagePlacerParts(instance).apply(instance, a::new);
    });

    public a() {
        super(ConstantInt.of(0), ConstantInt.of(0));
    }

    public a(IntProvider intProvider, IntProvider intProvider2) {
        super(intProvider, intProvider2);
    }

    protected FoliagePlacerType<?> type() {
        return (FoliagePlacerType) h.o.get();
    }

    protected void createFoliage(LevelSimulatedReader levelSimulatedReader, FoliagePlacer.FoliageSetter foliageSetter, RandomSource randomSource, TreeConfiguration treeConfiguration, int i, FoliagePlacer.FoliageAttachment foliageAttachment, int i2, int i3, int i4) {
        BlockPos blockPosPos = foliageAttachment.pos();
        if (TreeFeature.validTreePos(levelSimulatedReader, blockPosPos)) {
            foliageSetter.set(blockPosPos, treeConfiguration.foliageProvider.getState(randomSource, blockPosPos));
        }
    }

    public int foliageHeight(RandomSource randomSource, int i, TreeConfiguration treeConfiguration) {
        int i2 = 8 / 2;
        return i2 + randomSource.nextInt((8 - i2) + 1);
    }

    protected boolean shouldSkipLocation(RandomSource randomSource, int i, int i2, int i3, int i4, boolean z) {
        return false;
    }
}
