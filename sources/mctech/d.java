package mctech;

import mctech.init.MCTechTiles;
import mctech.v.p;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/d.class */
@OnlyIn(Dist.CLIENT)
public class d {
    public d(@NotNull IEventBus iEventBus) {
        iEventBus.addListener(this::a);
    }

    private void a(EntityRenderersEvent.RegisterRenderers registerRenderers) {
        registerRenderers.registerBlockEntityRenderer((BlockEntityType) MCTechTiles.INDUSTRIAL_FORGE.get(), p::new);
    }
}
