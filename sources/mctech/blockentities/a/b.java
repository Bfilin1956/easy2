package mctech.blockentities.a;

import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/a/b.class */
public class b extends mctech.blockentities.d {
    public b(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 4, mctech.h.a.b.d.get(MachineTier.T5), 8);
    }

    @Override // mctech.blockentities.j, mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 0.6d;
    }
}
