package mctech.m.e;

import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/e/a.class */
public enum a implements mctech.utils.a.b.InterfaceC0041b {
    DISABLED(0, "disabled"),
    IMPORT(1, "import"),
    EXPORT(2, "export"),
    BOTH(3, "both");

    private static final a[] e = (a[]) mctech.utils.a.b.a((mctech.utils.a.b.InterfaceC0041b[]) values());
    private int f;
    private String g;

    a(int i, String str) {
        this.f = i;
        this.g = "misc.mctech.access." + str;
    }

    @Override // mctech.utils.a.b.InterfaceC0041b
    public int a() {
        return this.f;
    }

    public Component b() {
        return Component.translatable(this.g);
    }

    public boolean c() {
        return this == IMPORT || this == BOTH;
    }

    public boolean d() {
        return this == EXPORT || this == BOTH;
    }

    public static a a(int i) {
        return e[i % e.length];
    }

    public a e() {
        int iOrdinal = ordinal() + 1;
        if (iOrdinal > 3) {
            iOrdinal = 0;
        }
        return e[iOrdinal];
    }

    public a f() {
        int iOrdinal = ordinal() - 1;
        if (iOrdinal < 0) {
            iOrdinal = 3;
        }
        return e[iOrdinal];
    }

    public a a(a aVar) {
        if (aVar == DISABLED) {
            return DISABLED;
        }
        if (aVar == BOTH) {
            if (this == BOTH) {
                return DISABLED;
            }
            if (this == DISABLED) {
                return EXPORT;
            }
            if (this == EXPORT) {
                return IMPORT;
            }
            return BOTH;
        }
        if (this == aVar) {
            return DISABLED;
        }
        return aVar;
    }
}
