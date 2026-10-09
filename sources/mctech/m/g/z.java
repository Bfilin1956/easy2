package mctech.m.g;

import mctech.MCTech;
import mctech.api.items.IUpgradeItem;
import mctech.api.tiles.IMachine;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/z.class */
public class z extends x implements n {
    IMachine a;

    public z(IMachine iMachine, mctech.m.a.g gVar, int i, int i2, int i3) {
        super(gVar, i, i2, i3);
        this.a = iMachine;
        a(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "gui/components/slot/upgrade"));
    }

    public <T extends mctech.m.a.g & IMachine> z(T t, int i, int i2, int i3) {
        super(t, i, i2, i3);
        this.a = t;
        a(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "gui/components/slot/upgrade"));
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
}
