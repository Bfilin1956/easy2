package mctech.g.a.j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mctech.g.a.m;
import net.neoforged.bus.api.Event;
import net.neoforged.fml.event.IModBusEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/j/e.class */
public class e extends Event implements IModBusEvent {
    private final Map<m<?>, c<?>> a = new ConcurrentHashMap();

    public <T extends mctech.g.a.c.c> void a(m<? extends mctech.g.a.a<?, T>> mVar, c<T> cVar) {
        this.a.put(mVar, cVar);
    }

    public Map<m<?>, c<?>> a() {
        return Map.copyOf(this.a);
    }
}
