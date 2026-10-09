package mctech.m.b;

import mctech.components.ContainerComponent;
import mctech.components.a.C0097j;
import mctech.components.a.C0101n;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/aL.class */
public class aL extends ContainerComponent<mctech.blockentities.b.k> {
    public static mctech.utils.math.geometry.b a = new mctech.utils.math.geometry.b(80, 36, 14, 14);
    public static Vec2i b = new Vec2i(176, 0);

    public aL(mctech.blockentities.b.k kVar, Player player, int i) {
        super(kVar, player, i);
        addSlot(mctech.m.g.g.a(kVar, kVar.e, 0, 120, 40));
        addSlot(mctech.m.g.g.a(kVar, 1, 82, 40, Fluids.WATER));
        addSlot(mctech.m.g.g.e(kVar, 2, 146, 40));
        addPlayerInventoryAt(player.getInventory(), 42, 110);
        getComponents().clear();
        addComponent(new mctech.components.b.o(new mctech.utils.math.geometry.b(103, 41, 12, 13), null, new Vec2i(kVar.j().tierIndex() * 12, 73), true).a(C0101n.b.a()).a(() -> {
            return Float.valueOf(kVar.getFuel());
        }, () -> {
            return Float.valueOf(kVar.getMaxFuel());
        }).b(() -> {
            return "gui.mctech.fuel";
        }));
        addComponent(new C0097j(this, kVar.j()));
        addComponent(new mctech.components.a.u(kVar, kVar.j()).a(mctech.components.a.u.c));
        addComponent(new mctech.components.b.a(kVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, MachineTier.values()[((mctech.blockentities.b.k) getHolder()).j().tierIndex()]);
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
