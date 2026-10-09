package mctech.items.f.a;

import mctech.api.items.IUpgradeItem;
import mctech.api.tiles.IMachine;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/f/a/a.class */
public class a extends mctech.items.f.b.a.AbstractC0023a {
    @Override // mctech.items.f.b.a, mctech.api.items.IUpgradeItem
    public float getSoundMultiplier(ItemStack itemStack, IMachine iMachine) {
        return 0.0f;
    }

    @Override // mctech.api.items.IUpgradeItem
    public IUpgradeItem.UpgradeType getType(ItemStack itemStack) {
        return IUpgradeItem.UpgradeType.AUDIO_MOD;
    }
}
