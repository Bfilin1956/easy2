package mctech;

import mctech.init.MCTechBlocks;
import mctech.v.o;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a.class */
@EventBusSubscriber(modid = MCTech.MODID)
public class a {
    @SubscribeEvent
    public static void a(RegisterClientExtensionsEvent registerClientExtensionsEvent) {
        registerClientExtensionsEvent.registerItem(new IClientItemExtensions() { // from class: mctech.a.1
            private BlockEntityWithoutLevelRenderer a;

            @NotNull
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (this.a == null) {
                    this.a = new o();
                }
                return this.a;
            }
        }, new Item[]{MCTechBlocks.INDUSTRIAL_FORGE.asItem()});
    }
}
