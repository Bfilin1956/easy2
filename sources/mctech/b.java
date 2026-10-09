package mctech;

import javax.annotation.Nonnull;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/b.class */
@EventBusSubscriber(modid = MCTech.MODID)
public class b {
    @SubscribeEvent
    public static void a(@Nonnull LivingFallEvent livingFallEvent) {
        Player entity = livingFallEvent.getEntity();
        if (entity instanceof Player) {
            Player player = entity;
            ItemStack itemBySlot = player.getItemBySlot(EquipmentSlot.CHEST);
            mctech.items.e.b item = itemBySlot.getItem();
            if (item instanceof mctech.items.e.b) {
                mctech.items.e.b bVar = item;
                if (bVar.a(player, itemBySlot) && bVar.getManager(itemBySlot).getCharge(itemBySlot) > 1000) {
                    livingFallEvent.setCanceled(true);
                }
            }
        }
    }
}
