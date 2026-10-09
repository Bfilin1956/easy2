package mctech.j;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RecipesUpdatedEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/j/c.class */
public class c {
    public static final c a = new c();

    @SubscribeEvent
    public void a(RecipesUpdatedEvent recipesUpdatedEvent) {
        mctech.u.b.b.b.a();
    }
}
