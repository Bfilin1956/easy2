package mctech.h.a;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import mctech.blockentities.b.k;
import net.minecraft.world.item.ArmorItem;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/a.class */
@mctech.h.b.a.d(a = "armor")
public class a {

    @mctech.h.b.a.a(a = "quantum_armor")
    public static Map<ArmorItem.Type, C0017a> a = Map.of(ArmorItem.Type.HELMET, C0017a.C().a(), ArmorItem.Type.CHESTPLATE, C0017a.C().a(), ArmorItem.Type.LEGGINGS, C0017a.C().a(), ArmorItem.Type.BOOTS, C0017a.C().a());

    /* JADX INFO: renamed from: mctech.h.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/a$a.class */
    public static class C0017a {

        @SerializedName("energyTransferLimit")
        private int a = 1024;

        @SerializedName("energyCapacity")
        private int b = 125000000;

        @SerializedName("energyArmorUsage")
        private int c = mctech.q.c.c;

        @SerializedName("energyFoodRestoreUsage")
        private int d = mctech.q.c.c;

        @SerializedName("energyXrayUsage")
        private int e = mctech.q.c.c;

        @SerializedName("energyFlyUsage")
        private int f = mctech.q.c.c;

        @SerializedName("energyFallDamageUsage")
        private int g = mctech.q.c.c;

        @SerializedName("energyFlyBoostUsageMultiplier")
        private int h = 3;

        @SerializedName("energySprintingUsage")
        private int i = mctech.q.c.c;

        @SerializedName("energyWalkingProduction")
        private int j = mctech.q.c.c;

        @SerializedName("xrayRadius")
        private int k = 24;

        @SerializedName("flyBoostMultiplier")
        private float l = 3.0f;

        @SerializedName("walkingSprintMultiplier")
        private float m = 1.8f;

        @SerializedName("nightVisionDuration")
        private int n = 200;

        @SerializedName("damageAbsorbMultiplier")
        private float o = 0.2f;

        @SerializedName("damageAbsorbEnergyCost")
        private int p = k.i;

        @SerializedName("thornsMultiplier")
        private float q = 0.15f;

        @SerializedName("jumpBoostAmplifier")
        private float r = 3.0f;

        @SerializedName("movementSpeedMultiplier")
        private float s = 1.6f;

        @SerializedName("healthBoostAmplifier")
        private float t = 20.0f;

        @SerializedName("healthBoostEnergyCost")
        private int u = 5000;

        @SerializedName("regenerationAmplifier")
        private int v = 0;

        @SerializedName("regenerationEnergyCost")
        private int w = 1000;

        @SerializedName("radiationResistanceEnergyCost")
        private int x = 500;

        @SerializedName("waterBreathingEnergyCost")
        private int y = 100;

        @SerializedName("energyPackChargePerTick")
        private int z = 2048;

        @SerializedName("portableCellSlots")
        private int A = 5;

        @SerializedName("energyPackSlots")
        private int B = 2;

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
            return this.g;
        }

        public int h() {
            return this.i;
        }

        public int i() {
            return this.h;
        }

        public int j() {
            return this.j;
        }

        public int k() {
            return this.k;
        }

        public float l() {
            return this.l;
        }

        public float m() {
            return this.m;
        }

        public int n() {
            return this.n;
        }

        public float o() {
            return this.o;
        }

        public int p() {
            return this.p;
        }

        public float q() {
            return this.q;
        }

        public float r() {
            return this.r;
        }

        public float s() {
            return this.s;
        }

        public float t() {
            return this.t;
        }

        public int u() {
            return this.u;
        }

        public int v() {
            return this.v;
        }

        public int w() {
            return this.w;
        }

        public int x() {
            return this.x;
        }

        public int y() {
            return this.y;
        }

        public int z() {
            return this.z;
        }

        public int A() {
            return this.A;
        }

        public int B() {
            return this.B;
        }

        public static C0018a C() {
            return new C0018a();
        }

        /* JADX INFO: renamed from: mctech.h.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/a$a$a.class */
        public static class C0018a {
            private final C0017a a = new C0017a();

            public C0018a a(int i) {
                this.a.a = i;
                return this;
            }

            public C0018a b(int i) {
                this.a.b = i;
                return this;
            }

            public C0018a c(int i) {
                this.a.c = i;
                return this;
            }

            public C0018a d(int i) {
                this.a.d = i;
                return this;
            }

            public C0018a e(int i) {
                this.a.e = i;
                return this;
            }

            public C0018a f(int i) {
                this.a.f = i;
                return this;
            }

            public C0018a g(int i) {
                this.a.g = i;
                return this;
            }

            public C0018a h(int i) {
                this.a.i = i;
                return this;
            }

            public C0018a i(int i) {
                this.a.h = i;
                return this;
            }

            public C0018a j(int i) {
                this.a.j = i;
                return this;
            }

            public C0018a k(int i) {
                this.a.k = i;
                return this;
            }

            public C0018a a(float f) {
                this.a.l = f;
                return this;
            }

            public C0018a b(float f) {
                this.a.m = f;
                return this;
            }

            public C0018a l(int i) {
                this.a.n = i;
                return this;
            }

            public C0017a a() {
                return this.a;
            }
        }
    }
}
