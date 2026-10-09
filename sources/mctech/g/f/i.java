package mctech.g.f;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import mctech.init.MCTechConduitTypes;
import net.minecraft.core.Direction;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/f/i.class */
@Deprecated(since = "8.0.0")
public class i implements mctech.g.f.a<i> {
    public static final MapCodec<i> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.unboundedMap(Direction.CODEC, a.a).fieldOf("item_sided_data").forGetter(iVar -> {
            return iVar.d;
        })).apply(instance, i::new);
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, i> b = ByteBufCodecs.map(i -> {
        return new HashMap(i);
    }, Direction.STREAM_CODEC, a.b).map(i::new, iVar -> {
        return iVar.d;
    }).cast();
    public final Map<Direction, a> d;

    public i() {
        this.d = new HashMap(Direction.values().length);
    }

    public i(Map<Direction, a> map) {
        this.d = new HashMap(map);
    }

    @Override // mctech.g.f.a
    public i a(i iVar) {
        for (Direction direction : Direction.values()) {
            b(direction).a(iVar.a(direction));
        }
        return this;
    }

    public a a(Direction direction) {
        return (a) Objects.requireNonNull(this.d.getOrDefault(direction, a.c));
    }

    public a b(Direction direction) {
        return this.d.computeIfAbsent(direction, direction2 -> {
            return new a();
        });
    }

    public int hashCode() {
        return this.d.hashCode();
    }

    @Override // mctech.g.f.a
    public d<i> b() {
        return MCTechConduitTypes.Data.ITEM.get();
    }

    @Override // mctech.g.f.a
    @Nullable
    public mctech.g.a.h.c g() {
        HashMap map = new HashMap();
        for (Direction direction : Direction.values()) {
            a aVar = this.d.get(direction);
            if (aVar != null && aVar.d) {
                map.put(direction, Integer.valueOf(aVar.e));
            }
        }
        return new mctech.g.d.a.d.e.c(map);
    }

    @Override // mctech.g.f.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public i h() {
        HashMap map = new HashMap(Direction.values().length);
        for (Direction direction : Direction.values()) {
            if (this.d.containsKey(direction)) {
                map.put(direction, this.d.get(direction).a());
            }
        }
        return new i(map);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/f/i$a.class */
    public static class a {
        public static final Codec<a> a = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.BOOL.fieldOf("is_round_robin").forGetter(aVar -> {
                return Boolean.valueOf(aVar.d);
            }), Codec.INT.fieldOf("rotating_index").forGetter(aVar2 -> {
                return Integer.valueOf(aVar2.e);
            }), Codec.BOOL.fieldOf("is_self_feed").forGetter(aVar3 -> {
                return Boolean.valueOf(aVar3.f);
            }), Codec.INT.fieldOf("priority").forGetter(aVar4 -> {
                return Integer.valueOf(aVar4.g);
            })).apply(instance, (v1, v2, v3, v4) -> {
                return new a(v1, v2, v3, v4);
            });
        });
        public static final StreamCodec<ByteBuf, a> b = StreamCodec.composite(ByteBufCodecs.BOOL, aVar -> {
            return Boolean.valueOf(aVar.d);
        }, ByteBufCodecs.BOOL, aVar2 -> {
            return Boolean.valueOf(aVar2.f);
        }, ByteBufCodecs.INT, aVar3 -> {
            return Integer.valueOf(aVar3.g);
        }, (v1, v2, v3) -> {
            return new a(v1, v2, v3);
        });
        public static final a c = new a(false, 0, false, 0);
        public boolean d;
        public int e;
        public boolean f;
        public int g;

        public a() {
            this.d = false;
            this.e = 0;
            this.f = false;
            this.g = 0;
        }

        public a(boolean z, boolean z2, int i) {
            this.d = false;
            this.e = 0;
            this.f = false;
            this.g = 0;
            this.d = z;
            this.f = z2;
            this.g = i;
        }

        public a(boolean z, int i, boolean z2, int i2) {
            this.d = false;
            this.e = 0;
            this.f = false;
            this.g = 0;
            this.d = z;
            this.e = i;
            this.f = z2;
            this.g = i2;
        }

        private void a(a aVar) {
            this.d = aVar.d;
            this.f = aVar.f;
            this.g = aVar.g;
        }

        public a a() {
            return new a(this.d, this.e, this.f, this.g);
        }

        public int hashCode() {
            return Objects.hash(Boolean.valueOf(this.d), Boolean.valueOf(this.f), Integer.valueOf(this.g));
        }
    }
}
