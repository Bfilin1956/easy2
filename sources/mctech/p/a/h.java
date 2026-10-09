package mctech.p.a;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Objects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/a/h.class */
public final class h implements INBTSerializable<CompoundTag> {
    public static final Codec<h> a = RecordCodecBuilder.create(instance -> {
        return instance.group(BlockPos.CODEC.fieldOf("p").forGetter((v0) -> {
            return v0.a();
        }), BlockState.CODEC.fieldOf("s").forGetter((v0) -> {
            return v0.b();
        })).apply(instance, h::new);
    });
    private BlockPos b;
    private BlockState c;

    public h(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        this.b = blockPos;
        this.c = blockState;
    }

    public h(HolderLookup.Provider provider, @NotNull CompoundTag compoundTag) {
        deserializeNBT(provider, compoundTag);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CompoundTag serializeNBT(HolderLookup.Provider provider) {
        return (CompoundTag) a.encodeStart(provider.createSerializationContext(NbtOps.INSTANCE), this).getOrThrow();
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void deserializeNBT(HolderLookup.Provider provider, @NotNull CompoundTag compoundTag) {
        h hVar = (h) a.parse(provider.createSerializationContext(NbtOps.INSTANCE), compoundTag).getOrThrow();
        this.b = hVar.b;
        this.c = hVar.c;
    }

    public BlockPos a() {
        return this.b;
    }

    public BlockState b() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return Objects.equals(this.b, hVar.b) && Objects.equals(this.c, hVar.c);
    }

    public int hashCode() {
        return Objects.hash(this.b, this.c);
    }

    public String toString() {
        return "SavedBlockInWorld[position=" + String.valueOf(this.b) + ", blockState=" + String.valueOf(this.c) + "]";
    }
}
