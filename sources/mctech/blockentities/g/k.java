package mctech.blockentities.g;

import mctech.MCTech;
import mctech.blockentities.r;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/g/k.class */
public class k extends r {
    private static final ResourceLocation e = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/block/transformator/transformator_t3.png");

    public k(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, mctech.h.a.b.f.get(MachineTier.T3));
    }

    @Override // mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 0.8d;
    }

    @Override // mctech.v.f.b
    public ResourceLocation a(BlockState blockState) {
        return e;
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T3;
    }
}
