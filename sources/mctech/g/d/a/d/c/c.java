package mctech.g.d.a.d.c;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Set;
import mctech.g.a.i;
import mctech.g.a.j;
import mctech.g.a.k;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/c/c.class */
public class c implements j<c> {
    public static final MapCodec<c> b = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(BuiltInRegistries.FLUID.byNameCodec().optionalFieldOf("locked_fluid", Fluids.EMPTY).forGetter((v0) -> {
            return v0.b();
        })).apply(instance, c::new);
    });
    public static final k<c> c = new k<>(b, c::new);
    private Fluid d;
    private Fluid e;

    public c() {
        this(Fluids.EMPTY);
    }

    public c(Fluid fluid) {
        this.e = Fluids.EMPTY;
        this.d = fluid;
    }

    public c(Fluid fluid, Fluid fluid2) {
        this.e = Fluids.EMPTY;
        this.d = fluid;
        this.e = fluid2;
    }

    public Fluid b() {
        return this.d;
    }

    public Fluid c() {
        return this.e;
    }

    public void d() {
        this.e = this.d;
    }

    public void a(Fluid fluid) {
        this.e = this.d;
        this.d = fluid;
    }

    @Override // mctech.g.a.j
    public c a(c cVar) {
        if (this.d.equals(Fluids.EMPTY)) {
            return new c(cVar.d, Fluids.EMPTY);
        }
        return new c(this.d, Fluids.EMPTY);
    }

    @Override // mctech.g.a.j
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c a(i iVar, Set<? extends i> set) {
        return new c(this.d);
    }

    @Override // mctech.g.a.j
    public k<c> a() {
        return c;
    }
}
