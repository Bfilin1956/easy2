package mctech.m.b;

import mctech.components.ContainerComponent;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0097j;
import mctech.components.a.InterfaceC0102o;
import mctech.init.MCTechFluids;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/K.class */
public class K extends ContainerComponent<mctech.blockentities.b.c> {
    public K(mctech.blockentities.b.c cVar, Player player, int i) {
        super(cVar, player, i);
        addSlot(mctech.m.g.g.a(cVar, cVar.e, 0, 149, 40));
        addSlot(mctech.m.g.g.a(cVar, 1, 79, 40, Fluids.LAVA, (Fluid) MCTechFluids.BLAZING_LAVA.get()));
        addSlot(mctech.m.g.g.e(cVar, 2, 123, 40));
        addPlayerInventoryAt(player.getInventory(), 42, 110);
        getComponents().clear();
        InterfaceC0102o interfaceC0102o = () -> {
            return 1;
        };
        addComponent(new C0093f(85, 78, cVar, interfaceC0102o));
        addComponent(new C0095h(119, 86, cVar, interfaceC0102o));
        addComponent(new mctech.components.b.i(new mctech.utils.math.geometry.b(104, 43, 10, 10), cVar, new Vec2i(0, 246), true));
        addComponent(new C0097j(this, interfaceC0102o));
        addComponent(new mctech.components.a.u(cVar, interfaceC0102o).a(mctech.components.a.u.c));
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
