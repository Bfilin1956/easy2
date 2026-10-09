package mctech.g.d.a.d.e;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import mctech.init.MCTechConduitTypes;
import net.minecraft.core.Direction;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/e/c.class */
public final class c implements mctech.g.a.h.c {
    public static final MapCodec<c> b = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.unboundedMap(Direction.CODEC, Codec.INT).fieldOf("round_robin_indexes").forGetter(cVar -> {
            return cVar.d;
        })).apply(instance, c::new);
    });
    public static final mctech.g.a.h.d<c> c = new mctech.g.a.h.d<>(b, c::new);
    private final Map<Direction, Integer> d;

    public c() {
        this(Map.of());
    }

    public c(Map<Direction, Integer> map) {
        this.d = new HashMap(map);
    }

    @Override // mctech.g.a.h.c
    public mctech.g.a.h.d<?> a() {
        return MCTechConduitTypes.NodeData.ITEM.get();
    }

    public int a(Direction direction) {
        return this.d.getOrDefault(direction, 0).intValue();
    }

    public void a(Direction direction, int i) {
        this.d.put(direction, Integer.valueOf(i));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        return Objects.equals(this.d, ((c) obj).d);
    }

    public int hashCode() {
        return Objects.hashCode(this.d);
    }
}
