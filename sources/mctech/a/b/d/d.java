package mctech.a.b.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import java.util.Objects;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b/d/d.class */
public final class d extends mctech.a.b.b.a {
    public static final Codec<d> a = RecordCodecBuilder.create(instance -> {
        return instance.group(mctech.a.b.e.d.a.listOf().fieldOf("matrix").forGetter((v0) -> {
            return v0.a();
        }), ItemStack.OPTIONAL_CODEC.fieldOf("result").forGetter((v0) -> {
            return v0.d();
        }), Codec.BOOL.optionalFieldOf("ignoreDataComponents", true).forGetter((v0) -> {
            return v0.e();
        })).apply(instance, (v1, v2, v3) -> {
            return new d(v1, v2, v3);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, d> b = StreamCodec.composite(mctech.a.b.e.d.b.apply(ByteBufCodecs.list()), (v0) -> {
        return v0.a();
    }, ItemStack.OPTIONAL_STREAM_CODEC, (v0) -> {
        return v0.d();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.e();
    }, (v1, v2, v3) -> {
        return new d(v1, v2, v3);
    });
    private final List<mctech.a.b.e.d> c;
    private final ItemStack d;
    private final boolean e;

    public d(List<mctech.a.b.e.d> list, ItemStack itemStack, boolean z) {
        this.c = list;
        this.d = itemStack;
        this.e = z;
    }

    @Override // mctech.a.b.b.a
    public List<mctech.a.b.e.d> a() {
        return this.c;
    }

    @Override // mctech.a.b.b.a
    public List<mctech.a.b.e.d> b() {
        return List.of();
    }

    @Override // mctech.a.b.b.a
    public List<mctech.a.b.e.b> c() {
        return List.of();
    }

    @Override // mctech.a.b.b.a
    public ItemStack d() {
        return this.d;
    }

    @Override // mctech.a.b.b.a
    public boolean e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.e == dVar.e && Objects.equals(this.c, dVar.c) && Objects.equals(this.d, dVar.d);
    }

    public int hashCode() {
        return Objects.hash(this.c, this.d, Boolean.valueOf(this.e));
    }
}
