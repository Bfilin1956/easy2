package mctech.items.d.b;

import mctech.api.reactor.planner.ISimulatedReactor;
import mctech.api.reactor.planner.SimulatedStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/b/b.class */
public class b {
    public SimulatedStack a;
    public int b;
    public int c;

    public b(SimulatedStack simulatedStack, int i, int i2) {
        this.a = simulatedStack;
        this.b = i;
        this.c = i2;
    }

    public int a(ISimulatedReactor iSimulatedReactor, int i) {
        return this.a.storeHeat(iSimulatedReactor, this.b, this.c, i);
    }

    public int a(ISimulatedReactor iSimulatedReactor, double d) {
        return (int) ((d * ((double) this.a.getMaxStoredHeat(iSimulatedReactor, this.b, this.c))) - ((double) this.a.getStoredHeat(iSimulatedReactor, this.b, this.c)));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/d/b/b$a.class */
    public static class a extends b {
        boolean d;

        public a(SimulatedStack simulatedStack, int i, int i2, boolean z) {
            super(simulatedStack, i, i2);
            this.d = z;
        }

        @Override // mctech.items.d.b.b
        public int a(ISimulatedReactor iSimulatedReactor, double d) {
            int iA = super.a(iSimulatedReactor, d);
            if ((iA > 0) != this.d) {
                return iA;
            }
            return 0;
        }
    }
}
