package mctech.m.b;

import mctech.components.ContainerComponent;
import mctech.m.a.i;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/P.class */
public abstract class P<T extends mctech.m.a.i> extends ContainerComponent<T> {
    int a;

    public P(T t, Player player, int i, int i2) {
        super(t, player, i2);
        this.a = i;
    }

    @Override // mctech.components.ContainerComponent
    public Component getName() {
        return getHolder().a().getHoverName();
    }

    @Override // mctech.components.ContainerComponent, mctech.m.b.S
    public int getInventorySize() {
        return getHolder().getSlotCount();
    }
}
