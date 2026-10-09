package mctech.items.f.f;

import mctech.api.items.IUpgradeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f/f/b.class */
public class b extends mctech.items.f.b.a {
    private final float b;

    public b(float f) {
        super(new Item.Properties().stacksTo(1));
        this.b = f;
    }

    public float a() {
        return this.b;
    }

    @Override // mctech.api.items.IUpgradeItem
    public IUpgradeItem.UpgradeType getType(ItemStack itemStack) {
        return IUpgradeItem.UpgradeType.MASS_FABRICATOR_MOD;
    }
}
