package mctech.m.c.a;

import mctech.api.tiles.IInputMachine;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/a/g.class */
public class g implements mctech.m.c.g {
    private final IInputMachine a;

    public g(IInputMachine iInputMachine) {
        this.a = iInputMachine;
    }

    @Override // mctech.m.c.g
    public boolean matches(ItemStack itemStack) {
        return this.a.getValidRoom(itemStack) > 0;
    }
}
