package mctech.a.b.d;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b/d/c.class */
public final class c extends mctech.a.b.b.a {
    public static final Codec<c> a = RecordCodecBuilder.create(instance -> {
        return instance.group(mctech.a.b.e.d.a.listOf().fieldOf("craftingMatrix").forGetter((v0) -> {
            return v0.g();
        }), mctech.a.b.e.d.a.listOf().fieldOf("consumables").forGetter((v0) -> {
            return v0.h();
        }), mctech.a.b.e.b.a.listOf().fieldOf("linkedFluids").forGetter((v0) -> {
            return v0.c();
        }), ItemStack.OPTIONAL_CODEC.fieldOf("result").forGetter((v0) -> {
            return v0.d();
        }), Codec.BOOL.optionalFieldOf("ignoreDataComponents", true).forGetter((v0) -> {
            return v0.e();
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new c(v1, v2, v3, v4, v5);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, c> b = StreamCodec.composite(mctech.a.b.e.d.b.apply(ByteBufCodecs.list()), (v0) -> {
        return v0.g();
    }, mctech.a.b.e.d.b.apply(ByteBufCodecs.list()), (v0) -> {
        return v0.h();
    }, mctech.a.b.e.b.b.apply(ByteBufCodecs.list()), (v0) -> {
        return v0.c();
    }, ItemStack.OPTIONAL_STREAM_CODEC, (v0) -> {
        return v0.d();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.e();
    }, (v1, v2, v3, v4, v5) -> {
        return new c(v1, v2, v3, v4, v5);
    });
    private final List<mctech.a.b.e.d> c;
    private final List<mctech.a.b.e.d> d;
    private final List<mctech.a.b.e.b> e;
    private final ItemStack f;
    private final boolean g;

    public c(List<mctech.a.b.e.d> list, List<mctech.a.b.e.d> list2, List<mctech.a.b.e.b> list3, ItemStack itemStack, boolean z) {
        this.c = list;
        this.d = list2;
        this.e = list3;
        this.f = itemStack;
        this.g = z;
    }

    @Override // mctech.a.b.b.a
    public List<mctech.a.b.e.d> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.c);
        arrayList.addAll(this.d);
        return arrayList;
    }

    @Override // mctech.a.b.b.a
    public List<mctech.a.b.e.d> b() {
        return this.d;
    }

    @Override // mctech.a.b.b.a
    public List<mctech.a.b.e.b> c() {
        return this.e;
    }

    @Override // mctech.a.b.b.a
    public ItemStack d() {
        return this.f;
    }

    @Override // mctech.a.b.b.a
    public boolean e() {
        return this.g;
    }

    public List<mctech.a.b.e.d> g() {
        return this.c;
    }

    public List<mctech.a.b.e.d> h() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return Objects.equals(this.c, cVar.c) && Objects.equals(this.d, cVar.d) && Objects.equals(this.e, cVar.e) && Objects.equals(this.f, cVar.f);
    }

    public int hashCode() {
        return Objects.hash(this.c, this.d, this.e, this.f);
    }
}
