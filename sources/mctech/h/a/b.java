package mctech.h.a;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import mctech.MCTech;
import mctech.blockentities.c.C0074u;
import net.mcskill.msregistry.core.MachineTier;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/b.class */
@mctech.h.b.a.d(a = MCTech.MODID)
public class b {

    @mctech.h.b.a.a(a = "crystal")
    public static Map<MachineTier, a> a = Map.of(MachineTier.T2, new a(100000, 250), MachineTier.T3, new a(250000, 625), MachineTier.T4, new a(625000, 1550), MachineTier.T5, new a(1500000, 37500), MachineTier.T6, new a(4000000, C0074u.e), MachineTier.T7, new a(10000000, 250000), MachineTier.T8, new a(25500000, 637500));

    @mctech.h.b.a.a(a = "lapPack")
    public static Map<MachineTier, a> b = Map.of(MachineTier.T2, new a(400000, 1000), MachineTier.T3, new a(1500000, 3750), MachineTier.T4, new a(2500000, 6250), MachineTier.T5, new a(6000000, 15000), MachineTier.T6, new a(13500000, 33750), MachineTier.T7, new a(35000000, 87500), MachineTier.T8, new a(85000000, 212500));

    @mctech.h.b.a.a(a = "energyStorage")
    public static Map<MachineTier, a> c = Map.of(MachineTier.T1, new a(60000, 32), MachineTier.T2, new a(650000, 128), MachineTier.T3, new a(2250000, mctech.q.c.c), MachineTier.T4, new a(4000000, 2048), MachineTier.T5, new a(13000000, 4096), MachineTier.T6, new a(37000000, mctech.q.c.a), MachineTier.T7, new a(97000000, C0074u.o), MachineTier.T8, new a(250000000, 32768), MachineTier.T9, new a(2000000000, 65536), MachineTier.T10, new a(16000000000L, 131072));

    @mctech.h.b.a.a(a = "chargingBench")
    public static Map<MachineTier, a> d = Map.of(MachineTier.T1, new a(60000, 32), MachineTier.T2, new a(650000, 128), MachineTier.T3, new a(2250000, mctech.q.c.c), MachineTier.T4, new a(4000000, 2048), MachineTier.T5, new a(13000000, 4096), MachineTier.T6, new a(37000000, mctech.q.c.a), MachineTier.T7, new a(97000000, C0074u.o), MachineTier.T8, new a(250000000, 32768), MachineTier.T9, new a(2000000000, 65536), MachineTier.T10, new a(16000000000L, 131072));

    @mctech.h.b.a.a(a = "chargePad")
    public static Map<MachineTier, a> e = Map.of(MachineTier.T1, new a(60000, 32), MachineTier.T2, new a(650000, 128), MachineTier.T3, new a(2250000, mctech.q.c.c), MachineTier.T4, new a(4000000, 2048), MachineTier.T5, new a(13000000, 4096), MachineTier.T6, new a(37000000, mctech.q.c.a), MachineTier.T7, new a(97000000, C0074u.o), MachineTier.T8, new a(250000000, 32768), MachineTier.T9, new a(2000000000, 65536), MachineTier.T10, new a(16000000000L, 131072));

    @mctech.h.b.a.a(a = "transformator")
    public static Map<MachineTier, c> f = Map.of(MachineTier.NONE, new c(16, 32), MachineTier.T1, new c(32, 128), MachineTier.T2, new c(128, mctech.q.c.c), MachineTier.T3, new c(mctech.q.c.c, 2048), MachineTier.T4, new c(2048, 4096), MachineTier.T5, new c(4096, mctech.q.c.a), MachineTier.T6, new c(mctech.q.c.a, C0074u.o), MachineTier.T7, new c(C0074u.o, 32768), MachineTier.T8, new c(32768, 65536), MachineTier.T9, new c(65536, 131072));

    @mctech.h.b.a.a(a = "adjustableTransformator")
    public static c g = new c(32, 32768);

    @mctech.h.b.a.a(a = "adjustableTransformator2")
    public static c h = new c(32, 131072);

    @mctech.h.b.a.a(a = "alloySmelter")
    public static Map<MachineTier, C0019b> i = Map.of(MachineTier.T2, new C0019b(8, 1000, 10), MachineTier.T3, new C0019b(16, 3200, 32), MachineTier.T4, new C0019b(64, 204800, 2048), MachineTier.T5, new C0019b(128, 409600, 4096), MachineTier.T6, new C0019b(1024, 819200, mctech.q.c.a), MachineTier.T7, new C0019b(1024, C0074u.n, C0074u.o));

    @mctech.h.b.a.a(a = "dustFactory")
    public static C0019b j = new C0019b(1024, 819200, mctech.q.c.a);

    @mctech.h.b.a.a(a = "greenHouse")
    public static C0019b k = new C0019b(16, 12800, 128);

    @mctech.h.b.a.a(a = "hydraulicWasher")
    public static Map<MachineTier, C0019b> l = Map.of(MachineTier.T5, new C0019b(mctech.q.c.c, 409600, 4096), MachineTier.T6, new C0019b(1024, 819200, mctech.q.c.a), MachineTier.T7, new C0019b(2048, C0074u.n, C0074u.o));

    @mctech.h.b.a.a(a = "oreMacerator")
    public static Map<MachineTier, C0019b> m = Map.of(MachineTier.T5, new C0019b(mctech.q.c.c, 409600, 4096), MachineTier.T6, new C0019b(1024, 819200, mctech.q.c.a), MachineTier.T7, new C0019b(2048, C0074u.n, C0074u.o));

    @mctech.h.b.a.a(a = "ingotFoundry")
    public static Map<MachineTier, C0019b> n = Map.of(MachineTier.T5, new C0019b(mctech.q.c.c, 409600, 4096), MachineTier.T6, new C0019b(1024, 819200, mctech.q.c.a), MachineTier.T7, new C0019b(2048, C0074u.n, C0074u.o));

    @mctech.h.b.a.a(a = "chemicalPurification")
    public static Map<MachineTier, C0019b> o = Map.of(MachineTier.T5, new C0019b(mctech.q.c.c, 409600, 4096), MachineTier.T6, new C0019b(1024, 819200, mctech.q.c.a), MachineTier.T7, new C0019b(2048, C0074u.n, C0074u.o));

    @mctech.h.b.a.a(a = "oreCombine")
    public static Map<MachineTier, C0019b> p = Map.of(MachineTier.T5, new C0019b(mctech.q.c.c, 409600, 4096), MachineTier.T6, new C0019b(1024, 819200, mctech.q.c.a), MachineTier.T7, new C0019b(2048, C0074u.n, C0074u.o));

    @mctech.h.b.a.a(a = "concentrator")
    public static Map<MachineTier, C0019b> q = Map.of(MachineTier.T5, new C0019b(mctech.q.c.c, 409600, 4096), MachineTier.T6, new C0019b(1024, 819200, mctech.q.c.a), MachineTier.T7, new C0019b(2048, C0074u.n, C0074u.o));

    /* JADX INFO: renamed from: mctech.h.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/b$b.class */
    public static class C0019b {

        @SerializedName("energyConsumption")
        public int a;

        @SerializedName("energyCapacity")
        public int b;

        @SerializedName("energyInput")
        public int c;

        @SerializedName("speedMultiplier")
        public int d;

        public C0019b(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public C0019b(int i, int i2, int i3) {
            this(i, i2, i3, 1);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/b$a.class */
    public static class a {

        @SerializedName("capacity")
        public long a;

        @SerializedName("transferRate")
        public int b;

        public a(long j, int i) {
            this.a = j;
            this.b = i;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/b$c.class */
    public static class c {

        @SerializedName("minEU")
        public int a;

        @SerializedName("maxEU")
        public int b;

        public c(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }
}
