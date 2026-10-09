package mctech.h.a;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import mctech.blockentities.b.k;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/e.class */
@mctech.h.b.a.d(a = "tools")
public class e {

    @mctech.h.b.a.a(a = "destroyers")
    public static Map<String, b> a = Map.of("destroyer", new b(3000000, 1024, k.i, 200), "advanced_destroyer", new b(10000000, 1024, k.i, 2500, 200));

    @mctech.h.b.a.a(a = "chainsaw")
    public static Map<String, a> b = Map.of("chainsaw", new a(10000, 128, 50, false, 12), "advanced_chainsaw", new a(30000, mctech.q.c.c, 100, true, 24));

    @mctech.h.b.a.a(a = "quantum_axe")
    public static c c = c.j().a(4096).b(125000000).c(1024).a();

    @mctech.h.b.a.a(a = "quantum_pickaxe")
    public static c d = c.j().a(4096).b(125000000).c(1024).a();

    @mctech.h.b.a.a(a = "quantum_shovel")
    public static c e = c.j().a(4096).b(125000000).c(1024).a();

    @mctech.h.b.a.a(a = "quantum_staff")
    public static c f = c.j().a(4096).b(125000000).c(4096).e(1370).a(10, 75000).b(16900, 75000).a();

    @mctech.h.b.a.a(a = "quantum_sword")
    public static c g = c.j().a(4096).b(125000000).c(4096).e(870).a();

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/e$a.class */
    public static final class a {

        @SerializedName("energyCapacity")
        public int a;

        @SerializedName("energyTransferLimit")
        public int b;

        @SerializedName("energyConsumption")
        public int c;

        @SerializedName("canChopWholeTree")
        public boolean d;

        @SerializedName("miningSpeed")
        public int e;

        public a(int i, int i2, int i3, boolean z, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = z;
            this.e = i4;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/e$b.class */
    public static final class b {

        @SerializedName("energyCapacity")
        public int a;

        @SerializedName("energyTransferLimit")
        public int b;

        @SerializedName("primaryActionEnergyConsumption")
        public int c;

        @SerializedName("secondaryActionEnergyConsumption")
        public int d;

        @SerializedName("miningSpeed")
        public int e;

        public b(int i, int i2, int i3, int i4) {
            this(i, i2, i3, i3, i4);
        }

        public b(int i, int i2, int i3, int i4, int i5) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/e$c.class */
    public static class c {

        @SerializedName("energyTransferLimit")
        private int a = 1024;

        @SerializedName("energyCapacity")
        private int b = 125000000;

        @SerializedName("energyUsage")
        private int c = mctech.q.c.c;

        @SerializedName("energyAltUsage")
        private int d = mctech.q.c.c;

        @SerializedName("damage")
        private int e = 0;

        @SerializedName("chargeEveryNHit")
        private int f = 0;

        @SerializedName("chargeAttackAmount")
        private int g = 0;

        @SerializedName("chargeEveryBlockBreak")
        private int h = 0;

        @SerializedName("chargeBreakAmount")
        private int i = 0;

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }

        public int g() {
            return this.h;
        }

        public int h() {
            return this.g;
        }

        public int i() {
            return this.i;
        }

        public static a j() {
            return new a();
        }

        /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/e$c$a.class */
        public static class a {
            private final c a = new c();

            public a a(int i) {
                this.a.a = i;
                return this;
            }

            public a b(int i) {
                this.a.b = i;
                return this;
            }

            public a c(int i) {
                this.a.c = i;
                return this;
            }

            public a d(int i) {
                this.a.d = i;
                return this;
            }

            public a e(int i) {
                this.a.e = i;
                return this;
            }

            public a a(int i, int i2) {
                this.a.f = i;
                this.a.g = i2;
                return this;
            }

            public a b(int i, int i2) {
                this.a.h = i;
                this.a.i = i2;
                return this;
            }

            public c a() {
                return this.a;
            }
        }
    }
}
