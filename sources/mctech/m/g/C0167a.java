package mctech.m.g;

import mctech.MCTech;
import mctech.api.items.IUpgradeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.m.g.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/a.class */
public class C0167a extends z {
    private final mctech.blockentities.s b;

    public <T extends mctech.m.a.g & mctech.blockentities.s> C0167a(T t, int i, int i2, int i3) {
        super(t, i, i2, i3);
        this.b = t;
    }

    @Override // mctech.m.g.z
    public boolean mayPlace(@NotNull ItemStack itemStack) {
        IUpgradeItem item = itemStack.getItem();
        if (item instanceof IUpgradeItem) {
            if (this.b.getSupportedUpgradeTypes().contains(item.getType(itemStack))) {
                return true;
            }
        }
        return false;
    }

    @Override // mctech.m.g.z
    public boolean mayPickup(@NotNull Player player) {
        ItemStack item = getItem();
        return (!(item.getItem() instanceof IUpgradeItem) || item.getItem().getExtraTier(item, this.b) <= 0) ? super.mayPickup(player) : MCTech.KEYBOARD.a(player);
    }
}
