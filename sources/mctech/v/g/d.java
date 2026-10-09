package mctech.v.g;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/g/d.class */
public class d extends ParticleType<c> {
    public d() {
        super(false);
    }

    @NotNull
    public MapCodec<c> codec() {
        return c.a;
    }

    @NotNull
    public StreamCodec<? super RegistryFriendlyByteBuf, c> streamCodec() {
        return c.b;
    }
}
