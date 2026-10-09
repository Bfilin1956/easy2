package mctech.g.f;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Objects;
import mctech.init.MCTechConduitTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/f/h.class */
@Deprecated(since = "8.0.0")
public class h implements a<h> {
    public static final MapCodec<h> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.BOOL.fieldOf("should_reset").forGetter(hVar -> {
            return Boolean.valueOf(hVar.e);
        }), BuiltInRegistries.FLUID.byNameCodec().optionalFieldOf("locked_fluid", Fluids.EMPTY).forGetter(hVar2 -> {
            return hVar2.d;
        })).apply(instance, (v1, v2) -> {
            return new h(v1, v2);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, h> b = StreamCodec.composite(ByteBufCodecs.BOOL, hVar -> {
        return Boolean.valueOf(hVar.e);
    }, ByteBufCodecs.registry(Registries.FLUID), hVar2 -> {
        return hVar2.d;
    }, (v1, v2) -> {
        return new h(v1, v2);
    });
    private Fluid d;
    private boolean e;

    public h() {
        this.d = Fluids.EMPTY;
        this.e = false;
    }

    public h(boolean z, Fluid fluid) {
        this.d = Fluids.EMPTY;
        this.e = false;
        this.e = z;
        this.d = fluid;
    }

    public Fluid a() {
        return this.d;
    }

    public void a(Fluid fluid) {
        this.d = fluid;
    }

    public boolean c() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }

    @Override // mctech.g.f.a
    public h a(h hVar) {
        this.e = hVar.e;
        return this;
    }

    @Override // mctech.g.f.a
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public h h() {
        return new h(this.e, this.d);
    }

    @Override // mctech.g.f.a
    public d<h> b() {
        return MCTechConduitTypes.Data.FLUID.get();
    }

    @Override // mctech.g.f.a
    @Nullable
    public mctech.g.a.h.c g() {
        return null;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.e), this.d);
    }
}
