package mctech.blockentities.e;

import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/e/f.class */
public class f extends mctech.blockentities.f {
    public f(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, mctech.h.a.b.c.get(MachineTier.T7));
    }

    @Override // mctech.blockentities.f
    public int b() {
        return 6;
    }

    @Override // mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 0.55d;
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T7;
    }
}
