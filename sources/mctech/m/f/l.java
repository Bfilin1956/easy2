package mctech.m.f;

import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import mctech.init.MCTechDataComponent;
import mctech.m.b.S;
import mctech.m.b.ap;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/l.class */
public class l extends j {
    public mctech.items.e.i.a a;

    public l(Player player, mctech.m.a.e eVar, ItemStack itemStack, Slot slot) {
        super(player, eVar, itemStack, slot);
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new ap(this, player, b(), i, player.getItemInHand(interactionHand));
    }

    @Override // mctech.m.f.j, mctech.m.a.i
    public mctech.m.a.i a(ItemStack itemStack) {
        this.a = (mctech.items.e.i.a) itemStack.getOrDefault((DataComponentType) MCTechDataComponent.SCHEME_STORAGE.get(), d());
        return super.a(itemStack);
    }

    private mctech.items.e.i.a d() {
        ObjectList objectListI = mctech.utils.a.b.i();
        for (int i = 0; i < 6; i++) {
            objectListI.add(new mctech.items.e.i.b(i, 0, 0, 0, (Map<ItemStack, List<Integer>>) Collections.emptyMap(), false));
        }
        return new mctech.items.e.i.a(0, objectListI, false, false, false);
    }

    @Override // mctech.m.f.j, mctech.m.a.g
    public int getSlotCount() {
        return 0;
    }
}
