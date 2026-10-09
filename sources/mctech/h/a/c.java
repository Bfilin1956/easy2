package mctech.h.a;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import mctech.blockentities.c.C0074u;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c.class */
@mctech.h.b.a.d(a = "machines")
public class c {

    @mctech.h.b.a.a(a = "waterGenerators")
    public static Map<MachineTier, g> a = Map.of(MachineTier.T1, new g(mctech.i.c.WATER, 1000, 50, 1, 1, 1, 4000, 0), MachineTier.T2, new g(mctech.i.c.WATER, 1000, 1200, 8, 10, 1000, 8000, 0), MachineTier.T3, new g(mctech.i.c.WATER, 1000, 1200, 8, 32, 3200, 8000, 4), MachineTier.T4, new g(mctech.i.c.WATER, 1000, 800, 64, 2048, 204900, 16000, 4), MachineTier.T5, new g(mctech.i.c.WATER, 1000, 600, 128, 4096, 409600, 32000, 4));

    @mctech.h.b.a.a(a = "lavaGenerators")
    public static Map<MachineTier, g> b = Map.of(MachineTier.T1, new g(mctech.i.c.LAVA, 1000, 50, 1, 1, 1, 4000, 0), MachineTier.T2, new g(mctech.i.c.LAVA, 1000, 1200, 8, 10, 1000, 8000, 0), MachineTier.T3, new g(mctech.i.c.LAVA, 1000, 1200, 8, 32, 3200, 8000, 4), MachineTier.T4, new g(mctech.i.c.LAVA, 1000, 800, 64, 2048, 204900, 16000, 4), MachineTier.T5, new g(mctech.i.c.LAVA, 1000, 600, 128, 4096, 409600, 32000, 4));

    @mctech.h.b.a.a(a = "cobblestoneGenerators")
    public static Map<MachineTier, C0020c> c = Map.of(MachineTier.T1, new C0020c(1000, 1000, 4000, 4000, 50, 1, 1, 1, 1, 0, 1), MachineTier.T2, new C0020c(1000, 1000, 8000, 8000, 1200, 1, 8, 10, 1000, 0, 1), MachineTier.T3, new C0020c(1000, 1000, 8000, 8000, 1200, 2, 8, 32, 3200, 4, 4), MachineTier.T4, new C0020c(1000, 1000, 16000, 16000, 800, 3, 64, 2048, 204800, 4, 8), MachineTier.T5, new C0020c(1000, 1000, 32000, 32000, 600, 4, 128, 4096, 409600, 4, 12));

    @mctech.h.b.a.a(a = "plasmaGenerators")
    public static Map<MachineTier, o> d = Map.of(MachineTier.T4, new o(16000, 2048, 204800, 4, 1), MachineTier.T6, new o(32000, mctech.q.c.a, 819200, 4, 2), MachineTier.T8, new o(64000, C0074u.o, 3276800, 4, 3));

    @mctech.h.b.a.a(a = "fluidTanks")
    public static Map<MachineTier, h> e = Map.of(MachineTier.T1, new h(4000), MachineTier.T4, new h(32000), MachineTier.T5, new h(64000), MachineTier.T6, new h(128000), MachineTier.T7, new h(256000));

    @mctech.h.b.a.a(a = "assemblyStation")
    public static a f = new a(32000, 32000, 131072, 128, 13107200);

    @mctech.h.b.a.a(a = "quantumComposter")
    public static p g = new p(32000, mctech.q.c.a, 128, 819200);

    @mctech.h.b.a.a(a = "atomicSmelter")
    public static b h = new b(32000, 32000, 1000, 32);

    @mctech.h.b.a.a(a = "genetics")
    public static i i = new i();

    @mctech.h.b.a.a(a = "jetpacks")
    public static Map<String, e> j = Map.of("jetpack", new e().a(mctech.items.g.b.h.a.NONE, 7).a(mctech.items.g.b.h.a.BASIC, 4).a(mctech.items.g.b.h.a.ADV, 4).a(mctech.items.g.b.h.a.NONE, 0.65f).a(mctech.items.g.b.h.a.BASIC, 0.3f).a(mctech.items.g.b.h.a.ADV, 5.0f), "basic", new e().a(mctech.items.g.b.h.a.NONE, 7).a(mctech.items.g.b.h.a.BASIC, 4).a(mctech.items.g.b.h.a.ADV, 4).a(mctech.items.g.b.h.a.NONE, 0.65f).a(mctech.items.g.b.h.a.BASIC, 0.3f).a(mctech.items.g.b.h.a.ADV, 5.0f), "advanced", new e().a(mctech.items.g.b.h.a.NONE, 7).a(mctech.items.g.b.h.a.BASIC, 4).a(mctech.items.g.b.h.a.ADV, 4).a(mctech.items.g.b.h.a.NONE, 0.65f).a(mctech.items.g.b.h.a.BASIC, 0.3f).a(mctech.items.g.b.h.a.ADV, 5.0f), "gravitation", new e().a(mctech.items.g.b.h.a.NONE, 7).a(mctech.items.g.b.h.a.BASIC, 4).a(mctech.items.g.b.h.a.ADV, 4).a(mctech.items.g.b.h.a.NONE, 0.65f).a(mctech.items.g.b.h.a.BASIC, 0.3f).a(mctech.items.g.b.h.a.ADV, 5.0f), "rocket_gravitation", new e().a(mctech.items.g.b.h.a.NONE, 7).a(mctech.items.g.b.h.a.BASIC, 4).a(mctech.items.g.b.h.a.ADV, 4).a(mctech.items.g.b.h.a.NONE, 0.65f).a(mctech.items.g.b.h.a.BASIC, 0.3f).a(mctech.items.g.b.h.a.ADV, 5.0f));

    @mctech.h.b.a.a(a = "massFabricators")
    public static Map<MachineTier, l> k = Map.of(MachineTier.T5, new l(4096, 25000000, 0), MachineTier.T6, new l(C0074u.o, 50000000, 0, 2), MachineTier.T7, new l(131072, 100000000, 256000, 4));

    @mctech.h.b.a.a(a = "advancedMachines")
    public static Map<String, k> l = Map.ofEntries(Map.entry("nano_macerator", new k(mctech.q.c.a, 81920, 4, 400)), Map.entry("quantum_macerator", new k(C0074u.o, 163840, 8, 400)), Map.entry("singular_macerator", new k(32768, 327680, 12, 200)), Map.entry("nano_electric_furnace", new k(mctech.q.c.a, 81920, 6, 130)), Map.entry("quantum_electric_furnace", new k(C0074u.o, 163840, 12, 130)), Map.entry("singular_electric_furnace", new k(32768, 327680, 18, 60)), Map.entry("nano_compressor", new k(mctech.q.c.a, 81920, 4, 400)), Map.entry("quantum_compressor", new k(C0074u.o, 163840, 8, 400)), Map.entry("singular_compressor", new k(32768, 327680, 12, 200)), Map.entry("nano_recycler", new k(mctech.q.c.a, 81920, 2, 45)), Map.entry("quantum_recycler", new k(C0074u.o, 163840, 3, 45)), Map.entry("singular_recycler", new k(32768, 327680, 4, 30)), Map.entry("nano_extractor", new k(mctech.q.c.a, 81920, 4, 400)), Map.entry("quantum_extractor", new k(C0074u.o, 163840, 8, 400)), Map.entry("singular_extractor", new k(32768, 327680, 12, 200)), Map.entry("crystal_growth_chamber", new k(128, 1600, 80, 10)), Map.entry("industrial_forge", new k(128, 1600, 80, 10)));

    @mctech.h.b.a.a(a = "refineries")
    public static Map<String, s> m = Map.of("nano_refinery", new s(mctech.q.c.a, 81920, 2, 45, 16000, 16000, 64000), "quantum_refinery", new s(C0074u.o, 163840, 3, 45, 16000, 16000, 64000), "singular_refinery", new s(32768, 327680, 4, 30, 16000, 16000, 64000));

    @mctech.h.b.a.a(a = "quantumMassFabricator")
    public static q n = new q(C0074u.o, 700000000);

    @mctech.h.b.a.a(a = "crystalSynths")
    public static Map<MachineTier, d> o = Map.of(MachineTier.T2, new d(1, 10, 1000, 400, 4, 0), MachineTier.T3, new d(1, 32, 3200, 400, 16, 4), MachineTier.T4, new d(2, 2048, 204800, 600, 64, 4), MachineTier.T5, new d(3, 4096, 409600, 800, 128, 4), MachineTier.T6, new d(5, mctech.q.c.a, 819200, 1000, 1024, 4), MachineTier.T7, new d(9, C0074u.o, C0074u.n, 1200, 1024, 4));

    @mctech.h.b.a.a(a = "metalFormers")
    public static Map<MachineTier, m> p = Map.of(MachineTier.T2, new m(1, 10, 1000, 400, 4, 0), MachineTier.T3, new m(1, 32, 3200, 400, 16, 4), MachineTier.T4, new m(2, 2048, 204800, 600, 64, 4), MachineTier.T5, new m(3, 4096, 409600, 800, 128, 4), MachineTier.T6, new m(5, mctech.q.c.a, 819200, 1000, 1024, 4), MachineTier.T7, new m(9, C0074u.o, C0074u.n, 1200, 1024, 4));

    @mctech.h.b.a.a(a = "rareExtractors")
    public static Map<MachineTier, r> q = Map.of(MachineTier.T2, new r(1, 10, 1000, 0), MachineTier.T3, new r(1, 32, 3200, 4), MachineTier.T4, new r(2, 2048, 204800, 4), MachineTier.T5, new r(3, 4096, 409600, 4), MachineTier.T6, new r(5, mctech.q.c.a, 819200, 4), MachineTier.T7, new r(9, C0074u.o, C0074u.n, 4));

    @mctech.h.b.a.a(a = "baseTeleporter")
    public static f r = new f(10000, 1000, 32);

    @mctech.h.b.a.a(a = "elevatorTeleporter")
    public static f s = new f(10000, 1000, 32);

    @mctech.h.b.a.a(a = "electronicPlants")
    public static Map<MachineTier, n> t = Map.of(MachineTier.T2, new n(1, 10, 1000, 4, 400, 0), MachineTier.T3, new n(1, 32, 3200, 16, 400, 4), MachineTier.T4, new n(2, 2048, 204800, 64, 600, 4), MachineTier.T5, new n(3, 4096, 409600, 128, 800, 4), MachineTier.T6, new n(5, mctech.q.c.a, 819200, 1024, 1000, 4), MachineTier.T7, new n(9, C0074u.o, C0074u.n, 1024, 1200, 4));

    @mctech.h.b.a.a(a = "compressors")
    public static Map<MachineTier, n> u = Map.of(MachineTier.T2, new n(1, 10, 1000, 4, 400, 0), MachineTier.T3, new n(1, 32, 3200, 16, 400, 4), MachineTier.T4, new n(2, 2048, 204800, 64, 600, 4), MachineTier.T5, new n(3, 4096, 409600, 128, 800, 4), MachineTier.T6, new n(5, mctech.q.c.a, 819200, 1024, 1000, 4), MachineTier.T7, new n(9, C0074u.o, C0074u.n, 1024, 1200, 4));

    @mctech.h.b.a.a(a = "furnaces")
    public static Map<MachineTier, n> v = Map.of(MachineTier.T2, new n(1, 10, 1000, 4, 400, 0), MachineTier.T3, new n(1, 32, 3200, 16, 400, 4), MachineTier.T4, new n(2, 2048, 204800, 64, 600, 4), MachineTier.T5, new n(3, 4096, 409600, 128, 800, 4), MachineTier.T6, new n(5, mctech.q.c.a, 819200, 1024, 1000, 4), MachineTier.T7, new n(9, C0074u.o, C0074u.n, 1024, 1200, 4));

    @mctech.h.b.a.a(a = "macerators")
    public static Map<MachineTier, n> w = Map.of(MachineTier.T2, new n(1, 10, 1000, 4, 400, 0), MachineTier.T3, new n(1, 32, 3200, 16, 400, 4), MachineTier.T4, new n(2, 2048, 204800, 64, 600, 4), MachineTier.T5, new n(3, 4096, 409600, 128, 800, 4), MachineTier.T6, new n(5, mctech.q.c.a, 819200, 1024, 1000, 4), MachineTier.T7, new n(9, C0074u.o, C0074u.n, 1024, 1200, 4));

    @mctech.h.b.a.a(a = "extractors")
    public static Map<MachineTier, n> x = Map.of(MachineTier.T2, new n(1, 10, 1000, 4, 400, 0), MachineTier.T3, new n(1, 32, 3200, 16, 400, 4), MachineTier.T4, new n(2, 2048, 204800, 64, 600, 4), MachineTier.T5, new n(3, 4096, 409600, 128, 800, 4), MachineTier.T6, new n(5, mctech.q.c.a, 819200, 1024, 1000, 4), MachineTier.T7, new n(9, C0074u.o, C0074u.n, 1024, 1200, 4));

    @mctech.h.b.a.a(a = "quantumWorkbench")
    public static f y = new f(C0074u.n, 0, C0074u.o);

    @mctech.h.b.a.a(a = "molecularConverter")
    public static f z = new f(Integer.MAX_VALUE, 0, 131072);

    @mctech.h.b.a.a(a = "matrixConverter")
    public static f A = new f(819200, 0, mctech.q.c.a);

    @mctech.h.b.a.a(a = "linkedTeleporter")
    public static j B = new j(512000, 128, 1000, 25000, mctech.utils.c.h.i, mctech.utils.c.h.i, 128, true, true, true, true, true, 10.0f);

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$i.class */
    public static class i {

        @SerializedName("materialDropChance")
        public float a = 0.2f;

        @SerializedName("geneticExtractorDamageMultiplier")
        public float b = 0.5f;

        @SerializedName("sequencerSuccessChance")
        public float c = 0.02f;

        @SerializedName("sequencerDurationTicks")
        public int d = 200;

        @SerializedName("sequencerEnergyPerTick")
        public int e = mctech.q.c.a;

        @SerializedName("sequencerMaxInput")
        public int f = mctech.q.c.a;

        @SerializedName("sequencerMaxEnergy")
        public int g = 327680;

        @SerializedName("baseChanceMin")
        public int h = 1;

        @SerializedName("baseChanceMax")
        public int i = 50;

        @SerializedName("stabilizerEnergyPerTick")
        public int j = mctech.q.c.a;

        @SerializedName("stabilizerMaxInput")
        public int k = mctech.q.c.a;

        @SerializedName("stabilizerDurationTicks")
        public int l = 600;

        @SerializedName("stabilizerMaxEnergy")
        public int m = 327680;

        @SerializedName("stabilizerTankCapacity")
        public int n = 16000;

        @SerializedName("maxBonusChance")
        public float o = 50.0f;

        @SerializedName("maxLuckLevel")
        public int p = 100;

        @SerializedName("printerDurationTicks")
        public int q = 600;

        @SerializedName("printerEnergyPerTick")
        public int r = C0074u.o;

        @SerializedName("printerMaxInput")
        public int s = C0074u.o;

        @SerializedName("printerMaxEnergy")
        public int t = 655360;

        @SerializedName("printerMultiplierScale")
        public float u = 50.0f;

        @SerializedName("printerLuckOffset")
        public float v = 10.0f;

        @SerializedName("printerMultiplierBias")
        public float w = 0.5f;

        @SerializedName("extractorDurationTicks")
        public int x = 100;

        @SerializedName("extractorEnergyPerTick")
        public int y = mctech.q.c.a;

        @SerializedName("extractorMaxInput")
        public int z = mctech.q.c.a;

        @SerializedName("extractorMaxEnergy")
        public int A = 327680;

        @SerializedName("extractorTankCapacity")
        public int B = 16000;

        @SerializedName("extractorDnaBaseXp")
        public int C = 50;

        @SerializedName("extractorDnaQualityBonus")
        public int D = 200;
    }

    public static k a(Block block) {
        k kVar = l.get(BuiltInRegistries.BLOCK.getKey(block).getPath());
        return kVar != null ? kVar : k.a;
    }

    public static s b(Block block) {
        s sVar = m.get(BuiltInRegistries.BLOCK.getKey(block).getPath());
        return sVar != null ? sVar : s.a;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$n.class */
    public static class n {
        public int a;

        @SerializedName("energyInput")
        public int b;

        @SerializedName("energyCapacity")
        public int c;

        @SerializedName("energyConsumption")
        public int d;

        @SerializedName("operationTime")
        public int e;
        public int f;

        public n(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }

        public n() {
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$j.class */
    public static class j {

        @SerializedName("energyCapacity")
        public int a;

        @SerializedName("maxEnergyInput")
        public int b;

        @SerializedName("entityTeleportCost")
        public int c;

        @SerializedName("spawnerTeleportCost")
        public int d;

        @SerializedName("itemTeleportCost")
        public int e;

        @SerializedName("fluidTeleportCost")
        public int f;

        @SerializedName("energyTeleportCost")
        public int g;

        @SerializedName("canTeleportEntity")
        public boolean h;

        @SerializedName("canTeleportSpawner")
        public boolean i;

        @SerializedName("canTeleportItem")
        public boolean j;

        @SerializedName("canTeleportFluid")
        public boolean k;

        @SerializedName("canTeleportEnergy")
        public boolean l;

        @SerializedName("differentDimensionEnergyMultiplier")
        public float m;

        public j(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, float f) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = z;
            this.i = z2;
            this.j = z3;
            this.k = z4;
            this.l = z5;
            this.m = f;
        }

        public j() {
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$f.class */
    public static class f {

        @SerializedName("energyCapacity")
        public int a;

        @SerializedName("energyConsumption")
        public int b;

        @SerializedName("maxEnergyInput")
        public int c;

        public f(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public f() {
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$r.class */
    public static class r {
        public int a;

        @SerializedName("energyInput")
        public int b;

        @SerializedName("energyCapacity")
        public int c;
        public int d;

        public r(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public r() {
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$m.class */
    public static class m {
        public int a;

        @SerializedName("energyInput")
        public int b;

        @SerializedName("energyCapacity")
        public int c;

        @SerializedName("operationTime")
        public int d;

        @SerializedName("energyConsumption")
        public int e;
        public int f;

        public m(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }

        public m() {
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$d.class */
    public static class d {
        public int a;

        @SerializedName("energyInput")
        public int b;

        @SerializedName("energyCapacity")
        public int c;

        @SerializedName("operationTime")
        public int d;

        @SerializedName("energyConsumption")
        public int e;
        public int f;

        public d(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }

        public d() {
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$l.class */
    public static class l {

        @SerializedName("energyInput")
        public int a;

        @SerializedName("energyCapacity")
        public int b;

        @SerializedName("fluidCapacity")
        public int c;
        public int d;

        public l(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.d = i4;
            this.c = i3;
        }

        public l(int i, int i2, int i3) {
            this(i, i2, i3, 0);
        }

        public l() {
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$h.class */
    public static class h {

        @SerializedName("fluidCapacity")
        public int a;

        public h(int i) {
            this.a = i;
        }

        public h() {
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$b.class */
    public static class b {

        @SerializedName("inputTankCapacity")
        public int a;

        @SerializedName("outputTankCapacity")
        public int b;

        @SerializedName("heatCapacity")
        public int c;

        @SerializedName("operationTime")
        public int d;

        public b(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public b() {
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$p.class */
    public static class p {

        @SerializedName("fluidTankCapacity")
        public int a;

        @SerializedName("energyInput")
        public int b;

        @SerializedName("energyConsumption")
        public int c;

        @SerializedName("energyCapacity")
        public int d;

        public p(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public p() {
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$a.class */
    public static class a {

        @SerializedName("firstFluidTankCapacity")
        public int a;

        @SerializedName("secondFluidTankCapacity")
        public int b;

        @SerializedName("energyInput")
        public int c;

        @SerializedName("baseEnergyConsumption")
        public int d;

        @SerializedName("energyCapacity")
        public int e;

        public a(int i, int i2, int i3, int i4, int i5) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }

        public a() {
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$o.class */
    public static class o {

        @SerializedName("fluidTankCapacity")
        public int a;

        @SerializedName("energyInput")
        public int b;

        @SerializedName("energyCapacity")
        public int c;
        public transient int d;
        public transient int e;

        public o(int i, int i2, int i3, int i4, int i5) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
        }

        public o() {
        }
    }

    /* JADX INFO: renamed from: mctech.h.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$c.class */
    public static class C0020c {

        @SerializedName("waterConsumption")
        public int a;

        @SerializedName("lavaConsumption")
        public int b;

        @SerializedName("waterCapacity")
        public int c;

        @SerializedName("lavaCapacity")
        public int d;

        @SerializedName("generationTime")
        public int e;

        @SerializedName("generationAmount")
        public int f;

        @SerializedName("energyConsumption")
        public int g;

        @SerializedName("energyInput")
        public int h;

        @SerializedName("energyCapacity")
        public int i;
        public transient int j;
        public transient int k;

        public C0020c(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = i9;
            this.j = i10;
            this.k = i11;
        }

        public C0020c() {
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$g.class */
    public static class g {

        @SerializedName("fluidType")
        @mctech.h.b.a.c
        public mctech.i.c a;

        @SerializedName("generationAmount")
        public int b;

        @SerializedName("generationTime")
        public int c;

        @SerializedName("energyConsumption")
        public int d;

        @SerializedName("energyInput")
        public int e;

        @SerializedName("energyCapacity")
        public int f;

        @SerializedName("fluidCapacity")
        public int g;
        public transient int h;

        public g(mctech.i.c cVar, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.a = cVar;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.h = i7;
        }

        public g() {
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
        public static int a(BlockState blockState) throws MatchException {
            MachineTier value = blockState.getValue(MachineTier.PROPERTY);
            switch ((mctech.i.c) blockState.getValue(mctech.i.c.d)) {
                case WATER:
                    return value == MachineTier.T1 ? 3 : 2;
                case LAVA:
                    switch (AnonymousClass1.a[value.ordinal()]) {
                        case 1:
                            return 4;
                        case 2:
                        case 3:
                            return 3;
                        case 4:
                            return 5;
                        case 5:
                            return 8;
                        default:
                            return 0;
                    }
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
        }
    }

    /* JADX INFO: renamed from: mctech.h.a.c$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            try {
                b[mctech.i.c.WATER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[mctech.i.c.LAVA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            a = new int[MachineTier.values().length];
            try {
                a[MachineTier.T1.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[MachineTier.T2.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[MachineTier.T3.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[MachineTier.T4.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[MachineTier.T5.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$e.class */
    public static class e {

        @SerializedName("energyConsumption")
        public HashMap<mctech.items.g.b.h.a, Integer> a = new HashMap<>();

        @SerializedName("thrustAmount")
        public HashMap<mctech.items.g.b.h.a, Float> b = new HashMap<>();

        private e() {
        }

        public e a(mctech.items.g.b.h.a aVar, int i) {
            this.a.put(aVar, Integer.valueOf(i));
            return this;
        }

        public e a(mctech.items.g.b.h.a aVar, float f) {
            this.b.put(aVar, Float.valueOf(f));
            return this;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$k.class */
    public static class k {
        public static final k a = new k(300, 32, 2, 400);

        @SerializedName("maxInput")
        public int b;

        @SerializedName("maxEnergy")
        public int c;

        @SerializedName("energyPerTick")
        public int d;

        @SerializedName("maxProgress")
        public int e;

        public k(int i, int i2, int i3, int i4) {
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        public k() {
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$s.class */
    public static class s {
        public static final s a = new s(300, 32, 2, 400, 16000, 16000, 64000);

        @SerializedName("maxInput")
        public int b;

        @SerializedName("maxEnergy")
        public int c;

        @SerializedName("energyPerTick")
        public int d;

        @SerializedName("maxProgress")
        public int e;

        @SerializedName("firstTank")
        public int f;

        @SerializedName("secondTank")
        public int g;

        @SerializedName("outputTank")
        public int h;

        public s(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.h = i7;
        }

        public s() {
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/a/c$q.class */
    public static class q {

        @SerializedName("maxInput")
        public int a;

        @SerializedName("maxEnergy")
        public int b;

        public q(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public q() {
        }
    }
}
