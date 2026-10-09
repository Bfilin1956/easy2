package mctech.p.c;

import it.unimi.dsi.fastutil.longs.Long2ObjectArrayMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.LongIterator;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ColorResolver;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LevelLightEngine;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/c/f.class */
public class f implements BlockAndTintGetter {
    private boolean f;
    private final Long2ObjectMap<BlockState> b = new Long2ObjectArrayMap();
    private final Vector3f c = new Vector3f(2.1474836E9f, 2.1474836E9f, 2.1474836E9f);
    private final Vector3f d = new Vector3f(-2.1474836E9f, -2.1474836E9f, -2.1474836E9f);
    private final Vector3f e = new Vector3f();
    private final Level a = Minecraft.getInstance().level;

    public f() {
        if (this.a == null) {
            throw new IllegalStateException("Client level is null, constructor of VirtualLevel called before actual client level was created");
        }
    }

    public Long2ObjectMap<BlockState> a() {
        return this.b;
    }

    public void a(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        this.b.put(blockPos.asLong(), blockState);
        this.f = true;
        this.c.set(2.1474836E9f, 2.1474836E9f, 2.1474836E9f);
        this.d.set(-2.1474836E9f, -2.1474836E9f, -2.1474836E9f);
        LongIterator it = this.b.keySet().iterator();
        while (it.hasNext()) {
            BlockPos blockPosOf = BlockPos.of(((Long) it.next()).longValue());
            int x = blockPosOf.getX();
            int y = blockPosOf.getY();
            int z = blockPosOf.getZ();
            this.c.x = Math.min(this.c.x, x);
            this.c.y = Math.min(this.c.y, y);
            this.c.z = Math.min(this.c.z, z);
            this.d.x = Math.max(this.d.x, x);
            this.d.y = Math.max(this.d.y, y);
            this.d.z = Math.max(this.d.z, z);
        }
    }

    public Vector3f b() {
        return this.e.set((this.d.x - this.c.x) + 1.0f, (this.d.y - this.c.y) + 1.0f, (this.d.z - this.c.z) + 1.0f);
    }

    public Vector3f c() {
        return this.c;
    }

    public Vector3f d() {
        return this.d;
    }

    public boolean e() {
        boolean z = this.f;
        this.f = false;
        return z;
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

    public int getBlockTint(@NotNull BlockPos blockPos, @NotNull ColorResolver colorResolver) {
        long jAsLong = blockPos.asLong();
        if (this.b.containsKey(jAsLong)) {
            FluidState fluidState = ((BlockState) this.b.get(jAsLong)).getFluidState();
            if (!fluidState.isEmpty()) {
                return IClientFluidTypeExtensions.of(fluidState).getTintColor(fluidState, this, blockPos);
            }
            return -1;
        }
        return -1;
    }

    public BlockEntity getBlockEntity(@NotNull BlockPos blockPos) {
        return null;
    }

    @NotNull
    public BlockState getBlockState(@NotNull BlockPos blockPos) {
        return (BlockState) this.b.getOrDefault(blockPos.asLong(), Blocks.AIR.defaultBlockState());
    }

    @NotNull
    public FluidState getFluidState(@NotNull BlockPos blockPos) {
        return ((BlockState) this.b.getOrDefault(blockPos.asLong(), Blocks.AIR.defaultBlockState())).getFluidState();
    }

    public int getHeight() {
        return this.a.getHeight();
    }

    public int getMinBuildHeight() {
        return this.a.getMinBuildHeight();
    }

    public boolean isOutsideBuildHeight(int i) {
        return false;
    }

    public boolean isOutsideBuildHeight(BlockPos blockPos) {
        return false;
    }

    @NotNull
    public BlockHitResult clip(@NotNull ClipContext clipContext) {
        return super.clip(clipContext);
    }
}
