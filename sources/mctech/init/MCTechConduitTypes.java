package mctech.init;

import appeng.api.AECapabilities;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.g.a.c.e;
import mctech.g.a.k;
import mctech.g.a.l;
import mctech.g.a.m;
import mctech.g.d.a.d.a.a;
import mctech.g.d.a.d.a.c;
import mctech.g.d.a.d.e.b;
import mctech.g.d.a.d.f.d;
import mctech.g.d.a.d.f.f;
import mctech.g.f.h;
import mctech.g.f.i;
import mctech.g.f.j;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.registries.DeferredRegister;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechConduitTypes.class */
public class MCTechConduitTypes {
    public static final DeferredRegister<m<?>> CONDUIT_TYPES = DeferredRegister.create(l.a, MCTech.MODID);
    public static final Supplier<m<a>> ENERGY = CONDUIT_TYPES.register("energy", () -> {
        return m.b(a.f).a(Capabilities.EnergyStorage.BLOCK).a();
    });
    public static final Supplier<m<mctech.g.d.a.d.g.a>> REDSTONE = CONDUIT_TYPES.register("redstone", () -> {
        return m.a(mctech.g.d.a.d.g.a.f);
    });
    public static final Supplier<m<mctech.g.d.a.d.c.a>> FLUID = CONDUIT_TYPES.register("fluid", () -> {
        return m.a(mctech.g.d.a.d.c.a.f);
    });
    public static final Supplier<m<mctech.g.d.a.d.e.a>> ITEM = CONDUIT_TYPES.register("item", () -> {
        return m.a(mctech.g.d.a.d.e.a.f);
    });
    public static final Supplier<m<mctech.g.d.a.d.b.a>> EU_CONDUIT = CONDUIT_TYPES.register("eu_conduit", () -> {
        return m.b(mctech.g.d.a.d.b.a.f).a();
    });
    public static final Supplier<m<d>> AE2_CONDUIT = CONDUIT_TYPES.register("me", () -> {
        return m.b(d.f).a(AECapabilities.IN_WORLD_GRID_NODE_HOST).a();
    });

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechConduitTypes$ConnectionTypes.class */
    public static class ConnectionTypes {
        private static final DeferredRegister<e<?>> CONNECTION_TYPES = DeferredRegister.create(l.d, MCTech.MODID);
        public static final Supplier<e<b>> ITEM = CONNECTION_TYPES.register("item", () -> {
            return b.f;
        });
        public static final Supplier<e<mctech.g.d.a.d.a.b>> ENERGY = CONNECTION_TYPES.register("energy", () -> {
            return mctech.g.d.a.d.a.b.f;
        });
        public static final Supplier<e<mctech.g.d.a.d.g.b>> REDSTONE = CONNECTION_TYPES.register("redstone", () -> {
            return mctech.g.d.a.d.g.b.f;
        });
        public static final Supplier<e<mctech.g.d.a.d.c.b>> FLUID = CONNECTION_TYPES.register("fluid", () -> {
            return mctech.g.d.a.d.c.b.f;
        });
        public static final Supplier<e<mctech.g.d.a.d.f.e>> ME = CONNECTION_TYPES.register("me", () -> {
            return mctech.g.d.a.d.f.e.f;
        });
        public static final Supplier<e<mctech.g.d.a.d.d.b>> HEAT = CONNECTION_TYPES.register("heat", () -> {
            return mctech.g.d.a.d.d.b.f;
        });
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechConduitTypes$ContextTypes.class */
    public static class ContextTypes {
        public static final DeferredRegister<k<?>> CONDUIT_NETWORK_CONTEXT_TYPES = DeferredRegister.create(l.c, MCTech.MODID);
        public static final Supplier<k<c>> ENERGY = CONDUIT_NETWORK_CONTEXT_TYPES.register("energy", () -> {
            return c.c;
        });
        public static final Supplier<k<mctech.g.d.a.d.g.c>> REDSTONE = CONDUIT_NETWORK_CONTEXT_TYPES.register("redstone", () -> {
            return mctech.g.d.a.d.g.c.b;
        });
        public static final Supplier<k<mctech.g.d.a.d.c.c>> FLUID = CONDUIT_NETWORK_CONTEXT_TYPES.register("fluid", () -> {
            return mctech.g.d.a.d.c.c.c;
        });
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechConduitTypes$Data.class */
    public static class Data {
        private static final DeferredRegister<mctech.g.f.d<?>> CONDUIT_DATA_TYPES = DeferredRegister.create(l.b, MCTech.MODID);
        public static final Supplier<mctech.g.f.d<i>> ITEM = CONDUIT_DATA_TYPES.register("item", () -> {
            return new mctech.g.f.d(i.a, i.b, i::new);
        });
        public static final Supplier<mctech.g.f.d<h>> FLUID = CONDUIT_DATA_TYPES.register("fluid", () -> {
            return new mctech.g.f.d(h.a, h.b, h::new);
        });
        public static final Supplier<mctech.g.f.d<j>> REDSTONE = CONDUIT_DATA_TYPES.register("redstone", () -> {
            return new mctech.g.f.d(j.a, j.b, j::new);
        });
        public static final Supplier<mctech.g.f.d<mctech.g.d.a.d.f.b>> ME = CONDUIT_DATA_TYPES.register("me", () -> {
            return new mctech.g.f.d(mctech.g.d.a.d.f.b.a, mctech.g.d.a.d.f.b.b, mctech.g.d.a.d.f.b::new);
        });
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechConduitTypes$NodeData.class */
    public static class NodeData {
        private static final DeferredRegister<mctech.g.a.h.d<?>> NODE_DATA_TYPES = DeferredRegister.create(l.e, MCTech.MODID);
        public static final Supplier<mctech.g.a.h.d<mctech.g.d.a.d.e.c>> ITEM = NODE_DATA_TYPES.register("item", () -> {
            return mctech.g.d.a.d.e.c.c;
        });
        public static final Supplier<mctech.g.a.h.d<f>> ME = NODE_DATA_TYPES.register("me", () -> {
            return f.c;
        });
    }

    static {
        CONDUIT_TYPES.addAlias(MCTech.loc("ae2"), MCTech.loc("me"));
        if (MCTech.isFrozen()) {
            MCTechConduitTypesEx.init();
        }
    }

    public static void register(IEventBus iEventBus) {
        CONDUIT_TYPES.register(iEventBus);
        Data.CONDUIT_DATA_TYPES.register(iEventBus);
        ConnectionTypes.CONNECTION_TYPES.register(iEventBus);
        NodeData.NODE_DATA_TYPES.register(iEventBus);
        ContextTypes.CONDUIT_NETWORK_CONTEXT_TYPES.register(iEventBus);
    }
}
