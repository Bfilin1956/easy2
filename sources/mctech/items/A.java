package mctech.items;

import mctech.blockentities.c.C0074u;
import net.mcskill.msregistry.core.MachineTier;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/A.class */
public enum A {
    T1(MachineTier.T1, 32, 1800, "Stone Rotor", "Каменный ротор"),
    T2(MachineTier.T2, 128, 2700, "Bronze Rotor", "Бронзовый ротор"),
    T3(MachineTier.T3, mctech.q.c.c, 3600, "Steel Rotor", "Стальной ротор"),
    T4(MachineTier.T4, 2048, 5400, "Composite Rotor", "Композитный ротор"),
    T5(MachineTier.T5, 4096, 7200, "Carbon Fiber Rotor", "Углепластиковый ротор"),
    T6(MachineTier.T6, mctech.q.c.a, 10800, "Quantum Rotor", "Квантовый ротор"),
    T7(MachineTier.T7, C0074u.o, 18000, "Titanium Rotor", "Титановый ротор"),
    T8(MachineTier.T8, 32768, 0, "Tungsten Rotor", "Вольфрамовый ротор");

    private final MachineTier i;
    private final int j;
    private final int k;
    private final String l;
    private final String m;

    A(MachineTier machineTier, int i, int i2, String str, String str2) {
        this.i = machineTier;
        this.j = i;
        this.k = i2;
        this.l = str;
        this.m = str2;
    }

    public MachineTier a() {
        return this.i;
    }

    public int b() {
        return this.j;
    }

    public int c() {
        return this.k;
    }

    public boolean d() {
        return this.k <= 0;
    }

    public String e() {
        return this.l;
    }

    public String f() {
        return this.m;
    }

    public String g() {
        return "windmill_rotor_t" + this.i.asIntegerString();
    }

    public String h() {
        return "block/windmill/turbine_t" + this.i.asIntegerString();
    }
}
