package mctech.m.b;

import mctech.components.ContainerComponent;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.world.entity.player.Player;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/au.class */
public class au extends ContainerComponent<mctech.blockentities.b.i> {
    public static final mctech.utils.math.geometry.b a = new mctech.utils.math.geometry.b(80, 45, 14, 14);
    public static final Vec2i b = new Vec2i(176, 0);

    public au(mctech.blockentities.b.i iVar, Player player, int i) {
        super(iVar, player, i);
        addSlot(mctech.m.g.g.a(iVar, iVar.d, 0, 80, 26));
        addPlayerInventory(player.getInventory());
        addComponent(mctech.components.b.h.a(a, iVar, b));
    }
}
