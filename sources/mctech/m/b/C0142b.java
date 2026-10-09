package mctech.m.b;

import mctech.components.ContainerComponent;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: renamed from: mctech.m.b.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/b.class */
public class C0142b extends ContainerComponent<mctech.blockentities.a> {
    public static final Vec2i a = new Vec2i(176, 0);
    public static final Vec2i b = new Vec2i(176, 14);

    public C0142b(mctech.blockentities.a aVar, Player player, int i) {
        super(aVar, player, i);
        for (Slot slot : aVar.a(player)) {
            addSlot(slot);
        }
        for (int i2 = 0; i2 < aVar.upgradeSlots; i2++) {
            addSlot(new mctech.m.g.z(aVar, (i2 + aVar.inventory.size()) - aVar.upgradeSlots, 152, 8 + (i2 * 18)));
        }
        addPlayerInventory(player.getInventory());
        addComponent(new mctech.components.b.e(aVar, aVar.b()));
        addComponent(new mctech.components.b.c(aVar.c(), aVar, a, true));
        addComponent(new mctech.components.b.o(aVar.b(), aVar, b, false));
        addComponent(new mctech.components.b.t(aVar, aVar.d(), new Vec2i(8, 36)));
        aVar.a(this);
    }

    @Override // mctech.m.b.S
    protected boolean moveItemStackTo(ItemStack itemStack, int i, int i2, boolean z) {
        return super.moveItemStackTo(itemStack, i, i2, z);
    }
}
