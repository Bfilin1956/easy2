package mctech.g.d.a.d.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.neoforged.neoforge.energy.IEnergyStorage;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/d/a/d.class */
public final class d extends Record implements IEnergyStorage {
    private final boolean a;
    private final int b;

    @Nullable
    private final mctech.g.a.h.a c;
    private static final long d = 4;

    public d(boolean z, int i, @Nullable mctech.g.a.h.a aVar) {
        this.a = z;
        this.b = i;
        this.c = aVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, d.class), d.class, "isMutable;transferRate;node", "FIELD:Lmctech/g/d/a/d/a/d;->a:Z", "FIELD:Lmctech/g/d/a/d/a/d;->b:I", "FIELD:Lmctech/g/d/a/d/a/d;->c:Lmctech/g/a/h/a;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, d.class), d.class, "isMutable;transferRate;node", "FIELD:Lmctech/g/d/a/d/a/d;->a:Z", "FIELD:Lmctech/g/d/a/d/a/d;->b:I", "FIELD:Lmctech/g/d/a/d/a/d;->c:Lmctech/g/a/h/a;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, d.class, Object.class), d.class, "isMutable;transferRate;node", "FIELD:Lmctech/g/d/a/d/a/d;->a:Z", "FIELD:Lmctech/g/d/a/d/a/d;->b:I", "FIELD:Lmctech/g/d/a/d/a/d;->c:Lmctech/g/a/h/a;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public boolean c() {
        return this.a;
    }

    public int d() {
        return this.b;
    }

    @Nullable
    public mctech.g.a.h.a e() {
        return this.c;
    }

    public long a() {
        if (this.c == null || !this.c.b()) {
            return 0L;
        }
        int iA = this.c.e().a();
        if (iA >= (Long.MAX_VALUE / (((long) d()) / d)) - d) {
            return Long.MAX_VALUE;
        }
        return ((long) d()) + (((long) iA) * (((long) d()) / d));
    }

    public long b() {
        c cVar;
        if (this.c == null || !this.c.b() || (cVar = (c) this.c.e().b(c.c)) == null) {
            return 0L;
        }
        return Math.max(Math.min(a(), cVar.b()), 0L);
    }

    public int receiveEnergy(int i, boolean z) {
        if (this.c == null || !this.c.b() || !this.a) {
            return 0;
        }
        c cVar = (c) this.c.e().c(c.c);
        int iMin = (int) Math.min(Math.min(a() - b(), Math.min(d(), i)), 2147483647L);
        if (!z) {
            cVar.a(b() + ((long) iMin));
        }
        return iMin;
    }

    public int extractEnergy(int i, boolean z) {
        return 0;
    }

    public int getEnergyStored() {
        return (int) Math.min(b(), 2147483647L);
    }

    public int getMaxEnergyStored() {
        return (int) Math.min(a(), 2147483647L);
    }

    public boolean canExtract() {
        return false;
    }

    public boolean canReceive() {
        return true;
    }
}
