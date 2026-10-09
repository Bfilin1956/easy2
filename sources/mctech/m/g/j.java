package mctech.m.g;

import mctech.MCTech;
import mctech.api.items.IUpgradeItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/j.class */
public class j extends x implements n {
    private final mctech.blockentities.s a;

    public <T extends mctech.m.a.g & mctech.blockentities.s> j(T t, int i, int i2, int i3) {
        super(t, i, i2, i3);
        this.a = t;
        a(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "misc/gui/upgrade"));
    }

    @Override // mctech.m.g.x
    public void setChanged() {
    }

    public boolean mayPlace(@NotNull ItemStack itemStack) {
        IUpgradeItem item = itemStack.getItem();
        if (item instanceof IUpgradeItem) {
            if (this.a.getSupportedUpgradeTypes().contains(item.getType(itemStack))) {
                return true;
            }
        }
        return false;
    }

    public boolean mayPickup(@NotNull Player player) {
        ItemStack item = getItem();
        return (!(item.getItem() instanceof IUpgradeItem) || item.getItem().getExtraTier(item, this.a) <= 0) ? super.mayPickup(player) : MCTech.KEYBOARD.a(player);
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
