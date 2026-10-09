package mctech.m.f;

import mctech.m.b.S;
import mctech.m.b.aN;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/r.class */
public class r extends j {
    public r(Player player, mctech.m.a.e eVar, ItemStack itemStack, Slot slot) {
        super(player, eVar, itemStack, slot);
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new aN(this, player, b(), i);
    }

    @Override // mctech.m.f.j, mctech.m.a.g
    public int getSlotCount() {
        return 12;
    }
}
