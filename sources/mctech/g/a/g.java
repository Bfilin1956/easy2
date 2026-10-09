package mctech.g.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/g.class */
public interface g {
    boolean a();

    boolean b();

    boolean c();

    boolean f();

    boolean g();

    boolean h();

    default boolean d() {
        return true;
    }

    default boolean e() {
        return true;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/g$a.class */
    public static final class a extends Record implements g {
        private final boolean a;
        private final boolean b;
        private final boolean c;
        private final boolean d;
        private final boolean e;
        private final boolean f;

        public a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            this.a = z;
            this.b = z2;
            this.c = z3;
            this.d = z4;
            this.e = z5;
            this.f = z6;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "hasFilterInsert;hasFilterExtract;hasUpgrade;showColorInsert;showColorExtract;showRedstoneExtract", "FIELD:Lmctech/g/a/g$a;->a:Z", "FIELD:Lmctech/g/a/g$a;->b:Z", "FIELD:Lmctech/g/a/g$a;->c:Z", "FIELD:Lmctech/g/a/g$a;->d:Z", "FIELD:Lmctech/g/a/g$a;->e:Z", "FIELD:Lmctech/g/a/g$a;->f:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "hasFilterInsert;hasFilterExtract;hasUpgrade;showColorInsert;showColorExtract;showRedstoneExtract", "FIELD:Lmctech/g/a/g$a;->a:Z", "FIELD:Lmctech/g/a/g$a;->b:Z", "FIELD:Lmctech/g/a/g$a;->c:Z", "FIELD:Lmctech/g/a/g$a;->d:Z", "FIELD:Lmctech/g/a/g$a;->e:Z", "FIELD:Lmctech/g/a/g$a;->f:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "hasFilterInsert;hasFilterExtract;hasUpgrade;showColorInsert;showColorExtract;showRedstoneExtract", "FIELD:Lmctech/g/a/g$a;->a:Z", "FIELD:Lmctech/g/a/g$a;->b:Z", "FIELD:Lmctech/g/a/g$a;->c:Z", "FIELD:Lmctech/g/a/g$a;->d:Z", "FIELD:Lmctech/g/a/g$a;->e:Z", "FIELD:Lmctech/g/a/g$a;->f:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        @Override // mctech.g.a.g
        public boolean a() {
            return this.a;
        }

        @Override // mctech.g.a.g
        public boolean b() {
            return this.b;
        }

        @Override // mctech.g.a.g
        public boolean c() {
            return this.c;
        }

        @Override // mctech.g.a.g
        public boolean f() {
            return this.d;
        }

        @Override // mctech.g.a.g
        public boolean g() {
            return this.e;
        }

        @Override // mctech.g.a.g
        public boolean h() {
            return this.f;
        }
    }
}
