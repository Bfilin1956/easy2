package mctech.m.b;

import mctech.api.tiles.ICustomContainer;
import mctech.blockentities.c.C0079z;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0097j;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/Q.class */
public class Q extends AbstractC0115i<C0079z> implements ICustomContainer {
    public Vec2i a;

    public Q(C0079z c0079z, Player player, int i) {
        super(c0079z, player, i);
        this.a = new Vec2i(238, 196);
        addSlot(new mctech.m.g.g((mctech.m.a.g) this.gui, 0, 27, 39, mctech.m.c.r.d));
        addSlot(new mctech.m.g.g((mctech.m.a.g) this.gui, 1, 52, 39, mctech.m.c.r.d));
        addSlot(new mctech.m.g.g((mctech.m.a.g) this.gui, 2, 77, 39, mctech.m.c.r.d));
        addSlot(new mctech.m.g.g((mctech.m.a.g) this.gui, 3, 102, 39, mctech.m.c.r.d));
        addSlot(new mctech.m.g.g((mctech.m.a.g) this.gui, 4, 127, 39, mctech.m.c.r.d));
        addSlot(new mctech.m.g.g((mctech.m.a.g) this.gui, 5, 152, 39, mctech.m.c.r.d));
        addSlot(new mctech.m.g.g((mctech.m.a.g) this.gui, 6, 177, 39, mctech.m.c.r.d));
        addSlot(new mctech.m.g.g((mctech.m.a.g) this.gui, 7, 202, 39, mctech.m.c.r.d));
        addPlayerInventoryAt(player.getInventory(), 42, 110);
        getComponents().clear();
        addComponent(new C0097j(this, () -> {
            return 3;
        }));
        addComponent(new mctech.components.a.H(c0079z, () -> {
            return 3;
        }).d("gui.mctech.inventory.button"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return ((C0079z) getHolder()).d();
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(this.a.getX());
        bVar.f(this.a.getY());
    }

    @Override // mctech.api.tiles.ICustomContainer
    public Vec2i getFilterButtonCords() {
        return new Vec2i(-4, 28);
    }
}
