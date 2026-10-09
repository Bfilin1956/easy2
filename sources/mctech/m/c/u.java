package mctech.m.c;

import mctech.api.items.IUpgradeItem;
import mctech.api.tiles.IMachine;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/u.class */
public class u<Machine extends BlockEntity & IMachine> implements g {
    private final Machine a;

    public u(Machine machine) {
        this.a = machine;
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        IUpgradeItem item = itemStack.getItem();
        if (item instanceof IUpgradeItem) {
            return this.a.getSupportedUpgradeTypes().contains(item.getType(itemStack));
        }
        return false;
    }
}
