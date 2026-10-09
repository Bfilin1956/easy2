package mctech.g.b.a.a.a;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/a/l.class */
public interface l {
    public static final StreamCodec<RegistryFriendlyByteBuf, l> b = m.n.cast().dispatch((v0) -> {
        return v0.a();
    }, (v0) -> {
        return v0.a();
    });

    m a();
}
