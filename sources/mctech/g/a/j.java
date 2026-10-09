package mctech.g.a;

import com.mojang.serialization.Codec;
import java.util.Set;
import mctech.g.a.j;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/j.class */
public interface j<T extends j<T>> {
    public static final Codec<j<?>> a = l.c.byNameCodec().dispatch((v0) -> {
        return v0.a();
    }, (v0) -> {
        return v0.b();
    });

    T a(T t);

    T a(i iVar, Set<? extends i> set);

    k<T> a();
}
