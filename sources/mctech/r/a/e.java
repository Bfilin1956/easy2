package mctech.r.a;

import mctech.MCTech;
import mctech.api.items.IUpgradeItem;
import mctech.api.tiles.IMachine;
import mctech.m.a.g;
import mctech.m.a.j;
import mctech.m.g.n;
import mctech.m.g.x;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/r/a/e.class */
public class e extends x implements j, n {
    IMachine a;

    public <T extends g & IMachine> e(T t, int i, int i2, int i3) {
        super(t, i, i2, i3);
        this.a = t;
    }

    public boolean mayPlace(ItemStack itemStack) {
        IUpgradeItem item = itemStack.getItem();
        if (item instanceof IUpgradeItem) {
            if (this.a.getSupportedUpgradeTypes().contains(item.getType(itemStack))) {
                return true;
            }
        }
        return false;
    }

    public boolean mayPickup(Player player) {
        ItemStack item = getItem();
        IUpgradeItem item2 = item.getItem();
        if ((item2 instanceof IUpgradeItem) && item2.getExtraTier(item, this.a) > 0) {
            return MCTech.KEYBOARD.a(player);
        }
        return super.mayPickup(player);
    }

    public IMachine e() {
        return this.a;
    }

    @Override // mctech.m.g.n
    public int ad_() {
        return this.index;
    }

    @Override // mctech.m.g.n
    public int b() {
        return this.x;
    }

    @Override // mctech.m.g.n
    public int c() {
        return this.y;
    }

    @Override // mctech.m.g.n
    public boolean b(ItemStack itemStack) {
        return mayPlace(itemStack);
    }

    @Override // mctech.m.g.n
    public void a(ItemStack itemStack) {
    }

    public int o() {
        return 10;
    }
}
