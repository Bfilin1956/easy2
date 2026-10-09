package mctech.blockentities.e;

import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/e/g.class */
public class g extends mctech.blockentities.f {
    public g(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, mctech.h.a.b.c.get(MachineTier.T6));
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T6;
    }

    @Override // mctech.blockentities.f
    public int b() {
        return 5;
    }

    @Override // mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 0.55d;
    }
}
