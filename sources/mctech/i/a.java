package mctech.i;

import mctech.api.blocks.IBlockDropProvider;
import mctech.components.a.InterfaceC0102o;
import mctech.init.MCTechDropProviders;
import net.mcskill.msregistry.core.MachineTier;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/i/a.class */
public enum a {
    COMPOSITE("composite", 1, MCTechDropProviders.SELF_OR_COMPOSITE_MACHINE),
    NANO("nano", 3, MCTechDropProviders.SELF_OR_NANO_MACHINE),
    QUANTUM("quantum", 5, MCTechDropProviders.SELF_OR_QUANTUM_MACHINE),
    SINGULAR("singular", 9, MCTechDropProviders.SELF_OR_SINGULAR_MACHINE);

    private final String e;
    private final int f;
    private final IBlockDropProvider g;

    a(String str, int i, IBlockDropProvider iBlockDropProvider) {
        this.e = str;
        this.f = i;
        this.g = iBlockDropProvider;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public MachineTier a() throws MatchException {
        switch (this) {
            case COMPOSITE:
                return MachineTier.T4;
            case NANO:
                return MachineTier.T5;
            case QUANTUM:
                return MachineTier.T6;
            case SINGULAR:
                return MachineTier.T7;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    public int b() {
        return this.f;
    }

    public String c() {
        return this.e;
    }

    public IBlockDropProvider d() {
        return this.g;
    }

    public InterfaceC0102o e() {
        return () -> {
            return ordinal() + 3;
        };
    }
}
