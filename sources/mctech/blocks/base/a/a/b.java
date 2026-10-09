package mctech.blocks.base.a.a;

import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/b.class */
public class b {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 4;
    a d;
    int e;
    int f;
    int g;
    Direction h;

    public b(a aVar) {
        this.d = aVar;
    }

    public void a() {
        this.d.a(this);
        c();
    }

    public void b() {
        this.d.b(this);
    }

    public void c() {
        int iA = this.d.a(this.h);
        this.f = iA;
        this.e = iA;
        if ((this.g & 1) != 0) {
            this.f = 15 - this.f;
        }
        if ((this.g & 2) != 0) {
            this.f = this.f > 0 ? 15 : 0;
        }
        if ((this.g & 4) != 0) {
            this.f = 15 - this.f;
        }
    }

    public Component d() {
        return this.d.c();
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.e;
    }
}
