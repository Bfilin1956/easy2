package mctech;

import javax.annotation.Nonnull;
import mctech.components.x;
import mctech.components.y;
import mctech.init.MCTechMenus;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.RegisterClientTooltipComponentFactoriesEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/e.class */
@OnlyIn(Dist.CLIENT)
public class e {
    public e(@Nonnull IEventBus iEventBus) {
        iEventBus.addListener(this::a);
        iEventBus.addListener(this::a);
    }

    private void a(RegisterMenuScreensEvent registerMenuScreensEvent) {
        registerMenuScreensEvent.register((MenuType) MCTechMenus.DIGGER_EQUIPMENT_MENU.get(), mctech.w.e::new);
    }

    private void a(@Nonnull RegisterClientTooltipComponentFactoriesEvent registerClientTooltipComponentFactoriesEvent) {
        registerClientTooltipComponentFactoriesEvent.register(y.class, x::new);
    }
}
