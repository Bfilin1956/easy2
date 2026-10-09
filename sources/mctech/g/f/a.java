package mctech.g.f;

import com.mojang.serialization.Codec;
import mctech.g.f.a;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/f/a.class */
@Deprecated(since = "8.0.0")
public interface a<T extends a<T>> {
    public static final Codec<a<?>> c = mctech.g.a.l.b.byNameCodec().dispatch((v0) -> {
        return v0.b();
    }, (v0) -> {
        return v0.a();
    });

    T h();

    d<T> b();

    @Nullable
    mctech.g.a.h.c g();

    default T a(T t) {
        return this;
    }
}
