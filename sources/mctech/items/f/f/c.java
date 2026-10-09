package mctech.items.f.f;

import mctech.api.items.IUpgradeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f/f/c.class */
public class c extends mctech.items.f.b.a {
    private final boolean b;
    private final boolean c;

    public c(boolean z, boolean z2) {
        super(new Item.Properties().stacksTo(1));
        this.b = z;
        this.c = z2;
    }

    public boolean a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    @Override // mctech.api.items.IUpgradeItem
    public IUpgradeItem.UpgradeType getType(ItemStack itemStack) {
        return IUpgradeItem.UpgradeType.MASS_FABRICATOR_MOD;
    }
}
