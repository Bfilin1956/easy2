package mctech.m.b;

import mctech.api.tiles.ICustomContainer;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0097j;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/R.class */
public class R extends AbstractC0115i<mctech.blockentities.c.A> implements ICustomContainer {
    public Vec2i a;

    public R(mctech.blockentities.c.A a, Player player, int i) {
        super(a, player, i);
        this.a = new Vec2i(238, 196);
        addSlot(new mctech.m.g.g((mctech.m.a.g) this.gui, 0, 87, 40, mctech.m.c.r.d));
        addSlot(mctech.m.g.g.d(a, 1, 140, 40));
        addPlayerInventoryAt(player.getInventory(), 42, 110);
        getComponents().clear();
        addComponent(new C0097j(this, () -> {
            return 3;
        }));
        addComponent(new mctech.components.a.H(a, () -> {
            return 3;
        }).d("gui.mctech.inventory.button"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return ((mctech.blockentities.c.A) getHolder()).d();
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
