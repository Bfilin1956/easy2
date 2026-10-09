package mctech.g.d.a.d.a;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Set;
import mctech.g.a.i;
import mctech.g.a.j;
import mctech.g.a.k;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/a/c.class */
public class c implements j<c> {
    public static final MapCodec<c> b = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.LONG.fieldOf("energy_stored").forGetter(cVar -> {
            return Long.valueOf(cVar.d);
        })).apply(instance, (v1) -> {
            return new c(v1);
        });
    });
    public static final k<c> c = new k<>(b, c::new);
    private long d;

    public c() {
        this.d = 0L;
    }

    public c(long j) {
        this.d = 0L;
        this.d = j;
    }

    public long b() {
        return this.d;
    }

    public void a(long j) {
        this.d = j;
    }

    @Override // mctech.g.a.j
    public c a(c cVar) {
        return new c(this.d + cVar.d);
    }

    @Override // mctech.g.a.j
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c a(i iVar, Set<? extends i> set) {
        int iIntValue = ((Integer) set.stream().map((v0) -> {
            return v0.a();
        }).reduce(0, (v0, v1) -> {
            return Integer.sum(v0, v1);
        })).intValue();
        if (iIntValue == 0) {
            return new c(0L);
        }
        return new c((long) Math.floor((iVar.a() / iIntValue) * this.d));
    }

    @Override // mctech.g.a.j
    public k<c> a() {
        return c;
    }
}
