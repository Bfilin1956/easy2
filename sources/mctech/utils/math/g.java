package mctech.utils.math;

import it.unimi.dsi.fastutil.longs.Long2ObjectFunction;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import mctech.init.MCTechProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/math/g.class */
public class g {
    LongSet a;
    Level b;
    BlockPos c;
    BlockPos.MutableBlockPos d;
    Direction e;
    Long2ObjectMap<LevelChunk> f;
    Long2ObjectFunction<LevelChunk> g;

    public g(Level level, BlockPos blockPos, Direction direction) {
        this.a = new LongLinkedOpenHashSet();
        this.c = BlockPos.ZERO;
        this.d = new BlockPos.MutableBlockPos();
        this.f = new Long2ObjectOpenHashMap();
        this.g = j -> {
            return this.b.getChunk(ChunkPos.getX(j), ChunkPos.getZ(j));
        };
        this.b = level;
        this.d.set(blockPos);
        this.c = BlockPos.of(blockPos.asLong());
        this.e = direction;
    }

    public g(Level level, int i, int i2, int i3, Direction direction) {
        this.a = new LongLinkedOpenHashSet();
        this.c = BlockPos.ZERO;
        this.d = new BlockPos.MutableBlockPos();
        this.f = new Long2ObjectOpenHashMap();
        this.g = j -> {
            return this.b.getChunk(ChunkPos.getX(j), ChunkPos.getZ(j));
        };
        this.b = level;
        this.d.set(i, i2, i3);
        this.c = new BlockPos(i, i2, i3);
        this.e = direction;
    }

    public long[] a() {
        return this.a.toLongArray();
    }

    public Direction b() {
        return this.e;
    }

    private BlockPos c(BlockPos blockPos) {
        this.a.add(blockPos.asLong());
        return blockPos;
    }

    public g c() {
        this.a.add(this.d.asLong());
        return this;
    }

    public g d() {
        this.a.remove(this.d.asLong());
        return this;
    }

    public g e() {
        this.d.set(this.c);
        return this;
    }

    public boolean f() {
        return this.d.equals(this.c);
    }

    public g g() {
        return a(this.e.getCounterClockWise());
    }

    public g a(int i) {
        return a(this.e.getCounterClockWise(), i);
    }

    public g h() {
        return a(this.e.getClockWise());
    }

    public g b(int i) {
        return a(this.e.getClockWise(), i);
    }

    public g i() {
        return a(this.e);
    }

    public g c(int i) {
        return a(this.e, i);
    }

    public g j() {
        return a(this.e.getOpposite());
    }

    public g d(int i) {
        return a(this.e.getOpposite(), i);
    }

    public g k() {
        return a(Direction.UP);
    }

    public g e(int i) {
        return a(Direction.UP, i);
    }

    public g l() {
        return a(Direction.DOWN);
    }

    public g f(int i) {
        return a(Direction.DOWN, i);
    }

    public g a(Rotation rotation) {
        return a(rotation, 1);
    }

    public g a(Rotation rotation, int i) {
        return a(rotation.rotate(this.e), i);
    }

    public g a(BlockPos blockPos) {
        this.d.set(blockPos);
        return this;
    }

    public g b(BlockPos blockPos) {
        this.d.set(this.c.getX() + blockPos.getX(), this.c.getY() + blockPos.getY(), this.c.getZ() + blockPos.getZ());
        return this;
    }

    public g a(Direction direction) {
        return a(direction, 1);
    }

    public g a(Direction direction, int i) {
        if (i != 0 && direction != null) {
            this.d.move(direction, i);
        }
        return this;
    }

    public boolean a(Block block) {
        return s().getBlockState(c((BlockPos) this.d)).is(block);
    }

    public boolean a(BlockState blockState) {
        return a(blockState.getBlock());
    }

    public boolean a(Predicate<Block> predicate) {
        return predicate.test(s().getBlockState(c((BlockPos) this.d)).getBlock());
    }

    public boolean a(TagKey<Block> tagKey) {
        return s().getBlockState(c((BlockPos) this.d)).is(tagKey);
    }

    public boolean b(BlockState blockState) {
        return s().getBlockState(c((BlockPos) this.d)) == blockState;
    }

    public boolean b(Predicate<BlockState> predicate) {
        return predicate.test(s().getBlockState(c((BlockPos) this.d)));
    }

    public boolean m() {
        return s().getBlockState(this.d).isAir();
    }

    public boolean n() {
        BlockState blockState = s().getBlockState(this.d);
        if (blockState.hasProperty(BlockStateProperties.WATERLOGGED) && ((Boolean) blockState.getValue(BlockStateProperties.WATERLOGGED)).booleanValue()) {
            return true;
        }
        FluidState fluidState = blockState.getFluidState();
        return fluidState.isSource() && fluidState.getType() == Fluids.WATER;
    }

    public boolean o() {
        BlockState blockState = s().getBlockState(this.d);
        if (blockState.hasProperty(MCTechProperties.LAVA_LOGGED) && ((Boolean) blockState.getValue(MCTechProperties.LAVA_LOGGED)).booleanValue()) {
            return true;
        }
        FluidState fluidState = blockState.getFluidState();
        return fluidState.isSource() && fluidState.getType() == Fluids.LAVA;
    }

    public long p() {
        return c((BlockPos) this.d).asLong();
    }

    public BlockState q() {
        return s().getBlockState(c((BlockPos) this.d));
    }

    public BlockEntity r() {
        return s().getBlockEntity(c((BlockPos) this.d));
    }

    public <T> T a(Class<T> cls) {
        BlockEntity blockEntityR = r();
        if (cls.isInstance(blockEntityR)) {
            return cls.cast(blockEntityR);
        }
        return null;
    }

    public boolean a(int i, int i2, int i3, BooleanSupplier booleanSupplier) {
        int i4 = i * i2 * i3;
        int i5 = i * i3;
        for (int i6 = 1; i6 < i4; i6++) {
            e().b(i6 % i).c((i6 / i) % i3).f(i6 / i5);
            if (!booleanSupplier.getAsBoolean()) {
                return false;
            }
        }
        return true;
    }

    public boolean a(int i, int i2, BooleanSupplier booleanSupplier) {
        for (int i3 = 0; i3 < i; i3++) {
            if (!booleanSupplier.getAsBoolean()) {
                return false;
            }
            h();
        }
        g();
        for (int i4 = 0; i4 < i2; i4++) {
            if (!booleanSupplier.getAsBoolean()) {
                return false;
            }
            j();
        }
        i();
        for (int i5 = 0; i5 < i; i5++) {
            if (!booleanSupplier.getAsBoolean()) {
                return false;
            }
            g();
        }
        h();
        for (int i6 = 0; i6 < i2; i6++) {
            if (!booleanSupplier.getAsBoolean()) {
                return false;
            }
            i();
        }
        j();
        return true;
    }

    public boolean a(int i, int i2, int i3, int i4) {
        e().b(i % i2).c((i / i2) % i4).f(i / (i2 * i4));
        return i < (i2 * i3) * i4;
    }

    public boolean a(int i, int i2, int i3, int i4, BlockPos.MutableBlockPos mutableBlockPos) {
        int i5 = i % i2;
        int i6 = i / (i2 * i4);
        int i7 = (i / i2) % i4;
        e().b(i5).c(i7).f(i6);
        mutableBlockPos.set(i5, i6, i7);
        return i < (i2 * i3) * i4;
    }

    public int a(int i, boolean z, Direction direction, Predicate<g> predicate) {
        e();
        int i2 = 0;
        while (predicate.test(a(direction)) && i2 < i) {
            i2++;
        }
        e();
        if (z) {
            this.a.clear();
        }
        return i2;
    }

    public int a(int i, boolean z, Predicate<g> predicate) {
        e();
        int i2 = 0;
        while (predicate.test(h()) && i2 < i) {
            i2++;
        }
        int iMin = Math.min(i2, Integer.MAX_VALUE);
        e();
        int i3 = 0;
        while (predicate.test(i()) && i3 < i) {
            i3++;
        }
        int iMin2 = Math.min(i3, iMin);
        e();
        int i4 = 0;
        while (predicate.test(l()) && i4 < i) {
            i4++;
        }
        int iMin3 = Math.min(i4, iMin2);
        e();
        if (z) {
            this.a.clear();
        }
        return iMin3;
    }

    private LevelChunk s() {
        return (LevelChunk) this.f.computeIfAbsent(ChunkPos.asLong(this.d.getX() >> 4, this.d.getZ() >> 4), this.g);
    }
}
