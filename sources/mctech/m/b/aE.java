package mctech.m.b;

import mctech.api.tiles.readers.IWorkProvider;
import mctech.components.ContainerComponent;
import mctech.components.a.C0093f;
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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/aE.class */
public class aE extends ContainerComponent<mctech.blockentities.b.j> {
    public static final mctech.utils.math.geometry.b a = new mctech.utils.math.geometry.b(104, 43, 10, 10);
    public static final Vec2i b = new Vec2i(0, 246);
    public static final Vec2i c = new Vec2i(10, 246);

    public aE(mctech.blockentities.b.j jVar, Player player, int i) {
        super(jVar, player, i);
        addSlot(mctech.m.g.g.a(jVar, jVar.e, 0, 149, 40));
        addSlot(mctech.m.g.g.a(jVar, 1, 79, 40, Fluids.LAVA, (Fluid) MCTechFluids.BLAZING_LAVA.get()));
        addSlot(mctech.m.g.g.e(jVar, 2, 123, 40));
        addPlayerInventoryAt(player.getInventory(), 42, 110);
        getComponents().clear();
        InterfaceC0102o interfaceC0102o = () -> {
            return 1;
        };
        addComponent(new mctech.components.N(jVar));
        addComponent(new mctech.components.b.i(a, jVar, b, true));
        addComponent(mctech.components.b.h.a(a, (IWorkProvider) jVar, c));
        addComponent(new C0093f(85, 78, jVar, interfaceC0102o));
        addComponent(new C0097j(this, interfaceC0102o));
        addComponent(new mctech.components.a.u(jVar, interfaceC0102o).a(mctech.components.a.u.c));
        addComponent(new mctech.components.b.a(jVar, 97, 67));
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, MachineTier.T3);
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
