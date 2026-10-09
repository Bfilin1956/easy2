package mctech.g.d.a;

import mctech.MCTech;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.UseItemOnBlockEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/h.class */
@EventBusSubscriber(modid = MCTech.MODID)
public class h {
    @SubscribeEvent
    public static void a(UseItemOnBlockEvent useItemOnBlockEvent) {
        ItemInteractionResult itemInteractionResultA;
        Level level = useItemOnBlockEvent.getLevel();
        if (!useItemOnBlockEvent.getItemStack().is(mctech.g.d.d.a.b.b)) {
            return;
        }
        mctech.g.d.c blockEntity = level.getBlockEntity(useItemOnBlockEvent.getPos());
        if ((blockEntity instanceof mctech.g.d.c) && (itemInteractionResultA = blockEntity.a(useItemOnBlockEvent.getUseOnContext())) != ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION) {
            useItemOnBlockEvent.cancelWithResult(itemInteractionResultA);
        }
    }
}
