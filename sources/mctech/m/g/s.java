package mctech.m.g;

import mctech.api.items.IUpgradeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/s.class */
public class s extends z {
    public <T extends mctech.m.a.g> s(T t, int i, int i2, int i3) {
        super(null, t, i, i2, i3);
    }

    @Override // mctech.m.g.x
    public void setChanged() {
    }

    @Override // mctech.m.g.z
    public boolean mayPlace(@NotNull ItemStack itemStack) {
        IUpgradeItem item = itemStack.getItem();
        if (item instanceof IUpgradeItem) {
            IUpgradeItem iUpgradeItem = item;
            if (iUpgradeItem.getType(itemStack) == IUpgradeItem.UpgradeType.REACTOR_COOLANT_MOD || iUpgradeItem.getType(itemStack) == IUpgradeItem.UpgradeType.REACTOR_ENRICHMENT_MOD) {
                return true;
            }
        }
        return false;
    }

    @Override // mctech.m.g.z
    public boolean mayPickup(@NotNull Player player) {
        return true;
    }
}
