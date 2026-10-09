package mctech.blockentities.f;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Objects;
import java.util.UUID;
import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.init.MCTechCodecs;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/f/e.class */
public final class e implements INetworkDataBuffer, INBTSerializable<CompoundTag> {
    public static final Codec<e> a = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.STRING.fieldOf("networkName").forGetter((v0) -> {
            return v0.d();
        }), Codec.STRING.fieldOf("teleportName").forGetter((v0) -> {
            return v0.e();
        }), ResourceKey.codec(Registries.DIMENSION).fieldOf("dimension").forGetter((v0) -> {
            return v0.b();
        }), BlockPos.CODEC.fieldOf("position").forGetter((v0) -> {
            return v0.c();
        }), MCTechCodecs.UUID_CODEC.fieldOf("creator").forGetter((v0) -> {
            return v0.f();
        })).apply(instance, e::new);
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, e> b = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.d();
    }, ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.e();
    }, ResourceKey.streamCodec(Registries.DIMENSION), (v0) -> {
        return v0.b();
    }, BlockPos.STREAM_CODEC, (v0) -> {
        return v0.c();
    }, mctech.f.d.a, (v0) -> {
        return v0.f();
    }, e::new);
    private String c;
    private String d;
    private ResourceKey<Level> e;
    private BlockPos f;
    private UUID g;

    public e(@Nullable HolderLookup.Provider provider, @NotNull CompoundTag compoundTag) {
        deserializeNBT(provider, compoundTag);
    }

    public e(@NotNull String str, String str2, @NotNull ResourceKey<Level> resourceKey, @NotNull BlockPos blockPos, @NotNull UUID uuid) {
        this.c = str;
        this.d = str2;
        this.e = resourceKey;
        this.f = blockPos;
        this.g = uuid;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("networkName", this.c);
        compoundTag.putString("teleportName", this.d);
        compoundTag.putString("dimension", this.e.location().toString());
        compoundTag.putLong("position", this.f.asLong());
        compoundTag.putString("creator", this.g.toString());
        return compoundTag;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void deserializeNBT(@Nullable HolderLookup.Provider provider, @NotNull CompoundTag compoundTag) {
        this.c = compoundTag.getString("networkName");
        this.d = compoundTag.getString("teleportName");
        this.e = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse(compoundTag.getString("dimension")));
        this.f = BlockPos.of(compoundTag.getLong("position"));
        this.g = UUID.fromString(compoundTag.getString("creator"));
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeUtf(this.c);
        registryFriendlyByteBuf.writeUtf(this.d);
        registryFriendlyByteBuf.writeUtf(this.e.location().toString());
        registryFriendlyByteBuf.writeLong(this.f.asLong());
        registryFriendlyByteBuf.writeUUID(this.g);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.c = registryFriendlyByteBuf.readUtf();
        this.d = registryFriendlyByteBuf.readUtf();
        this.e = ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse(registryFriendlyByteBuf.readUtf()));
        this.f = BlockPos.of(registryFriendlyByteBuf.readLong());
        this.g = registryFriendlyByteBuf.readUUID();
    }

    public String a() {
        return String.format("%s_%s", this.g, Long.valueOf(this.f.asLong()));
    }

    public ResourceKey<Level> b() {
        return this.e;
    }

    public BlockPos c() {
        return this.f;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.d;
    }

    public UUID f() {
        return this.g;
    }

    public boolean a(Player player) {
        Level level = player.level();
        if (level.isEmptyBlock(c())) {
            return true;
        }
        return level.isEmptyBlock(c().above()) && level.isEmptyBlock(c().above(2));
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return Objects.equals(this.c, eVar.c) && Objects.equals(this.d, eVar.d) && Objects.equals(this.e, eVar.e) && Objects.equals(this.f, eVar.f) && Objects.equals(this.g, eVar.g);
    }

    public int hashCode() {
        return Objects.hash(this.c, this.d, this.e, this.f, this.g);
    }
}
