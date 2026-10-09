package mctech.g.a.c;

import com.mojang.serialization.Codec;
import mctech.g.a.l;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/c/c.class */
@ApiStatus.Experimental
public interface c {
    public static final Codec<c> a = l.d.byNameCodec().dispatch((v0) -> {
        return v0.a();
    }, (v0) -> {
        return v0.b();
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, c> b = ByteBufCodecs.registry(l.a.e).dispatch((v0) -> {
        return v0.a();
    }, (v0) -> {
        return v0.c();
    });

    e<?> a();

    boolean ac_();

    c c();

    c d();
}
