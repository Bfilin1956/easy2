package mctech.blockentities.d;

import java.util.EnumSet;
import mctech.api.items.IUpgradeItem;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/d/g.class */
public class g extends mctech.blockentities.c {
    static final EnumSet<IUpgradeItem.UpgradeType> p = EnumSet.of(IUpgradeItem.UpgradeType.EXPAND_MOD, IUpgradeItem.UpgradeType.CHARGEPAD_MOD, IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT);

    public g(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 5, mctech.h.a.b.e.get(MachineTier.T6));
    }

    @Override // mctech.blockentities.c
    public float a() {
        return 0.5f;
    }

    @Override // mctech.blockentities.c
    @OnlyIn(Dist.CLIENT)
    protected int b() {
        return 14;
    }

    @Override // mctech.blockentities.c
    @OnlyIn(Dist.CLIENT)
    protected float[] a(RandomSource randomSource) {
        return new float[]{0.0f, (0.6f * 0.4f) + (randomSource.nextFloat() * 0.4f), 0.0f};
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

    @Override // mctech.blockentities.c, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return p;
    }
}
