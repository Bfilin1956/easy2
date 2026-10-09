package mctech.m.g;

import mctech.api.features.IXPMachine;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/g/B.class */
public class B extends x {
    public <T extends IXPMachine & mctech.m.a.g> B(T t, int i, int i2, int i3) {
        super(t, i, i2, i3);
    }

    public boolean mayPlace(ItemStack itemStack) {
        return false;
    }
}
