package mctech.items.base;

import javax.annotation.Nullable;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/j.class */
public class j extends i {
    private boolean a;

    public j(@Nullable o oVar) {
        super(oVar == null ? new o() : oVar);
        this.a = false;
    }

    public j() {
        this(null);
    }

    public j a() {
        this.a = true;
        return this;
    }

    public boolean isEnchantable(ItemStack itemStack) {
        return super.isEnchantable(itemStack) && !this.a;
    }
}
