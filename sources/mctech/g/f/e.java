package mctech.g.f;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import org.apache.commons.lang3.NotImplementedException;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/f/e.class */
@Deprecated(since = "8.0.0")
public interface e {
    public static final Codec<e> a = Codec.either(l.g, f.c).xmap(either -> {
        return either.left().isPresent() ? (e) either.left().get() : (e) either.right().get();
    }, eVar -> {
        if (eVar instanceof l) {
            return Either.left((l) eVar);
        }
        if (eVar instanceof f) {
            return Either.right((f) eVar);
        }
        throw new NotImplementedException();
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, e> b = ByteBufCodecs.either(l.i, f.d).map(either -> {
        return either.left().isPresent() ? (e) either.left().get() : (e) either.right().get();
    }, eVar -> {
        if (eVar instanceof l) {
            return Either.left((l) eVar);
        }
        if (eVar instanceof f) {
            return Either.right((f) eVar);
        }
        throw new NotImplementedException();
    });

    boolean a();
}
