package mctech.blockentities.f;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Objects;
import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/f/c.class */
public final class c implements INetworkDataBuffer, INBTSerializable<CompoundTag> {
    public static final Codec<c> a = RecordCodecBuilder.create(instance -> {
        return instance.group(BlockPos.CODEC.fieldOf("fromPosition").forGetter((v0) -> {
            return v0.a();
        }), ResourceKey.codec(Registries.DIMENSION).fieldOf("fromDimension").forGetter((v0) -> {
            return v0.b();
        }), Direction.CODEC.fieldOf("fromDirection").forGetter((v0) -> {
            return v0.c();
        }), BlockPos.CODEC.fieldOf("toPosition").forGetter((v0) -> {
            return v0.d();
        }), ResourceKey.codec(Registries.DIMENSION).fieldOf("toDimension").forGetter((v0) -> {
            return v0.e();
        }), Direction.CODEC.fieldOf("toDirection").forGetter((v0) -> {
            return v0.f();
        })).apply(instance, c::new);
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, c> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, ResourceKey.streamCodec(Registries.DIMENSION), (v0) -> {
        return v0.b();
    }, Direction.STREAM_CODEC, (v0) -> {
        return v0.c();
    }, BlockPos.STREAM_CODEC, (v0) -> {
        return v0.d();
    }, ResourceKey.streamCodec(Registries.DIMENSION), (v0) -> {
        return v0.e();
    }, Direction.STREAM_CODEC, (v0) -> {
        return v0.f();
    }, c::new);
    private BlockPos c;
    private ResourceKey<Level> d;
    private Direction e;
    private BlockPos f;
    private ResourceKey<Level> g;
    private Direction h;

    public c() {
        this(null, null, null);
    }

    public c(BlockPos blockPos, ResourceKey<Level> resourceKey, Direction direction) {
        this(blockPos, resourceKey, direction, blockPos, resourceKey, direction);
    }

    public c(BlockPos blockPos, ResourceKey<Level> resourceKey, Direction direction, BlockPos blockPos2, ResourceKey<Level> resourceKey2, Direction direction2) {
        this.c = blockPos;
        this.d = resourceKey;
        this.e = direction;
        this.f = blockPos2;
        this.g = resourceKey2;
        this.h = direction2;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putLong("fromPosition", this.c.asLong());
        compoundTag.putString("fromDimension", this.d.location().toString());
        compoundTag.putInt("fromDirection", this.e.ordinal());
        compoundTag.putLong("toPosition", this.f.asLong());
        compoundTag.putString("toDimension", this.g.location().toString());
        compoundTag.putInt("toDirection", this.h.ordinal());
        return compoundTag;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void deserializeNBT(@Nullable HolderLookup.Provider provider, @NotNull CompoundTag compoundTag) {
        this.c = BlockPos.of(compoundTag.getLong("fromPosition"));
        this.d = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse(compoundTag.getString("fromDimension")));
        this.e = Direction.values()[compoundTag.getInt("fromDirection")];
        this.f = BlockPos.of(compoundTag.getLong("toPosition"));
        this.g = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse(compoundTag.getString("toDimension")));
        this.h = Direction.values()[compoundTag.getInt("toDirection")];
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeLong(this.c.asLong());
        registryFriendlyByteBuf.writeUtf(this.d.location().toString());
        registryFriendlyByteBuf.writeInt(this.e.ordinal());
        registryFriendlyByteBuf.writeLong(this.f.asLong());
        registryFriendlyByteBuf.writeUtf(this.g.location().toString());
        registryFriendlyByteBuf.writeInt(this.h.ordinal());
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.c = BlockPos.of(registryFriendlyByteBuf.readLong());
        this.d = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse(registryFriendlyByteBuf.readUtf()));
        this.e = Direction.values()[registryFriendlyByteBuf.readInt()];
        this.f = BlockPos.of(registryFriendlyByteBuf.readLong());
        this.g = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse(registryFriendlyByteBuf.readUtf()));
        this.h = Direction.values()[registryFriendlyByteBuf.readInt()];
    }

    public BlockPos a() {
        return this.c;
    }

    public ResourceKey<Level> b() {
        return this.d;
    }

    public Direction c() {
        return this.e;
    }

    public BlockPos d() {
        return this.f;
    }

    public ResourceKey<Level> e() {
        return this.g;
    }

    public Direction f() {
        return this.h;
    }

    public BlockPos g() {
        return this.c.relative(this.e);
    }

    public BlockPos h() {
        return this.f.relative(this.h);
    }

    public c i() {
        return new c(this.f, this.g, this.h, this.c, this.d, this.e);
    }

    @Nullable
    public d a(MinecraftServer minecraftServer) {
        ServerLevel level;
        if (minecraftServer == null || (level = minecraftServer.getLevel(b())) == null) {
            return null;
        }
        BlockEntity blockEntity = level.getBlockEntity(g());
        if (blockEntity instanceof d) {
            return (d) blockEntity;
        }
        return null;
    }

    @Nullable
    public d b(MinecraftServer minecraftServer) {
        ServerLevel level;
        if (minecraftServer == null || (level = minecraftServer.getLevel(e())) == null) {
            return null;
        }
        BlockEntity blockEntity = level.getBlockEntity(h());
        if (blockEntity instanceof d) {
            return (d) blockEntity;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return Objects.equals(this.c, cVar.c) && Objects.equals(this.d, cVar.d) && this.e == cVar.e && Objects.equals(this.f, cVar.f) && Objects.equals(this.g, cVar.g) && this.h == cVar.h;
    }

    public int hashCode() {
        return Objects.hash(this.c, this.d, this.e, this.f, this.g, this.h);
    }
}
