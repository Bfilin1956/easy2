package mctech.p.a;

import mctech.MCTech;
import mctech.init.MCTechBlocks;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.registries.DeferredBlock;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/a/c.class */
@EventBusSubscriber(modid = MCTech.MODID)
public class c {
    @SubscribeEvent
    public static void a(RegisterCapabilitiesEvent registerCapabilitiesEvent) {
        mctech.p.b.a.a(registerCapabilitiesEvent, Capabilities.ItemHandler.BLOCK, (v0, v1) -> {
            return v0.a(v1);
        }, (DeferredBlock<? extends Block>) MCTechBlocks.MOLECULAR_CONVERTER);
    }
}
