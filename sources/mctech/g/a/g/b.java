package mctech.g.a.g;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mctech.g.a.m;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/g/b.class */
public class b extends Event implements IModBusEvent {
    private final Map<m<?>, a> a = new ConcurrentHashMap();

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/g/b$a.class */
    public interface a {
        mctech.g.a.g.a createModifier();
    }

    public void a(m<? extends mctech.g.a.a<?, ?>> mVar, a aVar) {
        this.a.put(mVar, aVar);
    }

    public Map<m<?>, a> a() {
        return Map.copyOf(this.a);
    }
}
