package mctech.blocks.base.a;

import mctech.blockentities.i;
import mctech.blockentities.q;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a.class */
public class a {
    mctech.m.a.g a;
    q b;
    int c;
    int d;
    IFluidHandler e;
    int f = 20;
    int g = 2;
    boolean h = false;

    public a(i iVar, IFluidHandler iFluidHandler, int i, int i2) {
        this.b = iVar;
        this.a = iVar;
        this.c = i;
        this.d = i2;
        this.e = iFluidHandler;
    }

    public a(mctech.m.a.g gVar, q qVar, IFluidHandler iFluidHandler, int i, int i2) {
        this.a = gVar;
        this.b = qVar;
        this.c = i;
        this.d = i2;
        this.e = iFluidHandler;
    }

    public a a(int i) {
        this.g = i;
        return this;
    }

    public a b(int i) {
        this.f = i;
        return this;
    }

    public void a() {
        if (this.b.clock(this.h ? this.g : this.f)) {
            if (this.a.getStackInSlot(this.c).isEmpty()) {
                this.h = false;
            } else {
                this.h = mctech.utils.c.b.b(this.a, this.c, this.d, this.e);
            }
        }
    }

    public void b() {
        if (this.b.clock(this.h ? this.g : this.f)) {
            if (this.a.getStackInSlot(this.c).isEmpty()) {
                this.h = false;
            } else {
                this.h = mctech.utils.c.b.a(this.a, this.c, this.d, this.e);
            }
        }
    }
}
