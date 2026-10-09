package mctech.init;

import java.util.function.Supplier;
import mctech.g.a.m;
import mctech.g.d.a.d.d.a;
import net.mcskill.msweather.init.MSCapabilities;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechConduitTypesEx.class */
public class MCTechConduitTypesEx {
    public static final Supplier<m<a>> HEAT = MCTechConduitTypes.CONDUIT_TYPES.register("heat", () -> {
        return m.b(a.f).a(MSCapabilities.HeatStorage.BLOCK).a();
    });

    public static void init() {
    }
}
