package mctech.g.a.h;

import com.mojang.serialization.Codec;
import mctech.g.a.l;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/h/c.class */
public interface c {
    public static final Codec<c> a = l.e.byNameCodec().dispatch((v0) -> {
        return v0.a();
    }, (v0) -> {
        return v0.b();
    });

    d<?> a();
}
