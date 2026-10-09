package mctech.blockentities.a;

import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/a/i.class */
public class i extends mctech.blockentities.d {
    public i(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 2, mctech.h.a.b.d.get(MachineTier.T3), 4);
    }

    @Override // mctech.blockentities.j, mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 0.7d;
    }
}
