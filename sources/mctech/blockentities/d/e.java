package mctech.blockentities.d;

import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/d/e.class */
public class e extends mctech.blockentities.c {
    public e(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 0, mctech.h.a.b.e.get(MachineTier.T1));
    }

    @Override // mctech.blockentities.c
    public float a() {
        return 0.5f;
    }

    @Override // mctech.blockentities.c
    @OnlyIn(Dist.CLIENT)
    protected int b() {
        return 5;
    }

    @Override // mctech.blockentities.c
    @OnlyIn(Dist.CLIENT)
    protected float[] a(RandomSource randomSource) {
        return new float[]{0.0f, 0.6f + (randomSource.nextFloat() * 0.4f), 0.0f};
    }

    @Override // mctech.blockentities.c
    @OnlyIn(Dist.CLIENT)
    protected double[] b(RandomSource randomSource) {
        return new double[]{0.0d, 3.0d, 0.0d};
    }

    @Override // mctech.blockentities.c
    @OnlyIn(Dist.CLIENT)
    protected int c(RandomSource randomSource) {
        return 6;
    }
}
