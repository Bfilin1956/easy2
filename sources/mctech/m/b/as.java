package mctech.m.b;

import mctech.components.ContainerComponent;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0097j;
import mctech.components.a.C0100m;
import mctech.components.a.InterfaceC0102o;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/as.class */
public class as extends ContainerComponent<mctech.blockentities.b.h> {
    public as(mctech.blockentities.b.h hVar, Player player, int i) {
        super(hVar, player, i);
        addSlot(mctech.m.g.g.a(hVar, hVar.e, 0, 102, 29));
        addSlot(mctech.m.g.g.a((mctech.m.a.g) hVar, 1, 114, 66, false));
        addSlot(mctech.m.g.g.d(hVar, 2, 126, 29));
        addPlayerInventoryAt(player.getInventory(), 42, 122);
        getComponents().clear();
        InterfaceC0102o interfaceC0102o = () -> {
            return 1;
        };
        addComponent(new C0100m(115, 49, hVar).a(true).b(true));
        addComponent(new C0093f(85, 90, hVar, interfaceC0102o));
        addComponent(new C0095h(119, 98, hVar, interfaceC0102o));
        addComponent(new C0097j(this, interfaceC0102o));
        addComponent(new mctech.components.a.u(hVar, interfaceC0102o).a(mctech.components.a.u.c));
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, MachineTier.T2);
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(mctech.utils.c.h.i);
        bVar.f(222);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterGuiSize() {
        return new Vec2i(122, 132);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterScrollOffset() {
        return new Vec2i(-2, -2);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterItemsOffset() {
        return new Vec2i(3, -2);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getInfoGuiSize() {
        return new Vec2i(198, 51);
    }
}
