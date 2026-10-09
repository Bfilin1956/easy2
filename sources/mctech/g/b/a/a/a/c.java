package mctech.g.b.a.a.a;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/a/c.class */
public class c implements l {
    public static final StreamCodec<RegistryFriendlyByteBuf, c> a = ByteBufCodecs.FLOAT.map((v1) -> {
        return new c(v1);
    }, (v0) -> {
        return v0.b();
    }).cast();
    private final float c;

    public c(float f) {
        this.c = f;
    }

    public float b() {
        return this.c;
    }

    @Override // mctech.g.b.a.a.a.l
    public m a() {
        return m.FLOAT;
    }
}
