package mctech;

import javax.annotation.Nonnull;
import mctech.components.x;
import mctech.components.y;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.RegisterClientTooltipComponentFactoriesEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/f.class */
@OnlyIn(Dist.CLIENT)
public final class f {
    public f(@Nonnull IEventBus iEventBus) {
        iEventBus.addListener(this::a);
    }

    private void a(@Nonnull RegisterClientTooltipComponentFactoriesEvent registerClientTooltipComponentFactoriesEvent) {
        registerClientTooltipComponentFactoriesEvent.register(y.class, x::new);
    }
}
