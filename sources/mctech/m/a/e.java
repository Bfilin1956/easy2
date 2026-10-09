package mctech.m.a;

import mctech.init.MCTechDataComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/a/e.class */
public interface e {
    i a(Player player, InteractionHand interactionHand, ItemStack itemStack);

    default int b_(ItemStack itemStack) {
        return ((Integer) itemStack.getOrDefault(MCTechDataComponent.GUI_ID, 0)).intValue();
    }

    default void a_(ItemStack itemStack, int i) {
        if (i == -1) {
            itemStack.remove(MCTechDataComponent.GUI_ID);
        } else {
            itemStack.set(MCTechDataComponent.GUI_ID, Integer.valueOf(i));
        }
    }
}
