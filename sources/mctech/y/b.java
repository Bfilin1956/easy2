package mctech.y;

import it.unimi.dsi.fastutil.longs.Long2ObjectArrayMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LevelLightEngine;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/y/b.class */
public class b implements BlockAndTintGetter {
    private final Level a;
    private final Long2ObjectMap<BlockState> b = new Long2ObjectArrayMap();

    public b(Level level, Set<BlockPos> set) {
        this.a = level;
        set.forEach(blockPos -> {
            this.b.put(blockPos.asLong(), level.getBlockState(blockPos));
        });
    }

    public float getShade(@NotNull Direction direction, boolean z) {
        return this.a.getShade(direction, z);
    }

    @NotNull
    public LevelLightEngine getLightEngine() {
        return this.a.getLightEngine();
    }

    public int getBrightness(@NotNull LightLayer lightLayer, @NotNull BlockPos blockPos) {
        return 15;
    }

    public int getBlockTint(BlockPos blockPos, @NotNull ColorResolver colorResolver) {
        long jAsLong = blockPos.asLong();
        if (this.b.containsKey(jAsLong)) {
            return IClientFluidTypeExtensions.of(((BlockState) this.b.get(jAsLong)).getFluidState()).getTintColor();
        }
        return -1;
    }

    public BlockEntity getBlockEntity(@NotNull BlockPos blockPos) {
        return null;
    }

    @NotNull
    public BlockState getBlockState(BlockPos blockPos) {
        return (BlockState) this.b.getOrDefault(blockPos.asLong(), Blocks.AIR.defaultBlockState());
    }

    @NotNull
    public FluidState getFluidState(BlockPos blockPos) {
        return ((BlockState) this.b.getOrDefault(blockPos.asLong(), Blocks.AIR.defaultBlockState())).getFluidState();
    }

    public int getHeight() {
        return this.a.getHeight();
    }

    public int getMinBuildHeight() {
        return this.a.getMinBuildHeight();
    }
}
