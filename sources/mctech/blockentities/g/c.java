package mctech.blockentities.g;

import mctech.MCTech;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/g/c.class */
public class c extends b {
    private static final ResourceLocation g = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/block/transformator/transformator_t9_config.png");

    public c(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, mctech.h.a.b.h);
    }

    @Override // mctech.blockentities.g.b, mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 0.6d;
    }

    @Override // mctech.v.f.b
    public ResourceLocation a(BlockState blockState) {
        return g;
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T9;
    }
}
