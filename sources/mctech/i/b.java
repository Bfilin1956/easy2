package mctech.i;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/i/b.class */
public class b {
    public static final Codec<b> a = RecordCodecBuilder.create(instance -> {
        return instance.group(BlockPos.CODEC.fieldOf("position").forGetter((v0) -> {
            return v0.a();
        }), Direction.CODEC.fieldOf("direction").forGetter((v0) -> {
            return v0.b();
        })).apply(instance, b::new);
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, b> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, Direction.STREAM_CODEC, (v0) -> {
        return v0.b();
    }, b::new);
    private BlockPos c;
    private Direction d;

    public b(BlockPos blockPos, Direction direction) {
        this.c = blockPos;
        this.d = direction;
    }

    public b() {
    }

    public BlockPos a() {
        return this.c;
    }

    public Direction b() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            return this.c.equals(bVar.c) && this.d == bVar.d;
        }
        return false;
    }

    public int hashCode() {
        return (31 * this.c.hashCode()) + this.d.hashCode();
    }
}
