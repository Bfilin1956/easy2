package mctech.g.a.h;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.MapLike;
import com.mojang.serialization.RecordBuilder;
import java.util.function.Supplier;
import java.util.stream.Stream;
import mctech.g.a.h.c;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/h/d.class */
public final class d<T extends c> {
    private final boolean a;
    private final MapCodec<T> b;
    private final Supplier<T> c;

    public d(@Nullable MapCodec<T> mapCodec, Supplier<T> supplier) {
        if (mapCodec != null) {
            this.b = mapCodec;
            this.a = true;
        } else {
            this.b = (MapCodec<T>) new MapCodec<T>() { // from class: mctech.g.a.h.d.1
                public <T1> Stream<T1> keys(DynamicOps<T1> dynamicOps) {
                    return Stream.empty();
                }

                public <T1> DataResult<T> decode(DynamicOps<T1> dynamicOps, MapLike<T1> mapLike) {
                    return DataResult.success(d.this.c());
                }

                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public <T1> RecordBuilder<T1> encode(T t, DynamicOps<T1> dynamicOps, RecordBuilder<T1> recordBuilder) {
                    throw new UnsupportedOperationException("Node data cannot be saved - not persistent.");
                }
            };
            this.a = false;
        }
        this.c = supplier;
    }

    public boolean a() {
        return this.a;
    }

    public MapCodec<T> b() {
        return this.b;
    }

    public T c() {
        return this.c.get();
    }
}
