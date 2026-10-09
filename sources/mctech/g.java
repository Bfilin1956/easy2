package mctech;

import java.util.Iterator;
import mctech.init.MCTechMenus;
import mctech.init.MCTechTiles;
import mctech.w.l;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g.class */
public final class g {
    public g(@NotNull IEventBus iEventBus) {
        iEventBus.addListener(this::a);
        iEventBus.addListener(this::a);
        iEventBus.addListener(this::a);
        iEventBus.addListener(this::a);
    }

    private void a(@NotNull RegisterMenuScreensEvent registerMenuScreensEvent) {
        registerMenuScreensEvent.register(MCTechMenus.SABER_EQUIPMENT_MENU.get(), l::new);
    }

    private void a(EntityRenderersEvent.RegisterRenderers registerRenderers) {
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) MCTechTiles.GRINDING_MACHINE.get(), mctech.v.d.f::new);
    }

    private void a(ModelEvent.RegisterAdditional registerAdditional) {
        Iterator<mctech.v.f.g> it = mctech.v.f.i.a.iterator();
        while (it.hasNext()) {
            registerAdditional.register(it.next().c());
        }
    }

    private void a(ModelEvent.BakingCompleted bakingCompleted) {
        for (mctech.v.f.g gVar : mctech.v.f.i.a) {
            gVar.a((BakedModel) bakingCompleted.getModels().get(gVar.c()));
        }
    }
}
