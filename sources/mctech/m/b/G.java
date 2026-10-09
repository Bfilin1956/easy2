package mctech.m.b;

import java.util.EnumSet;
import mctech.components.ContainerComponent;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0097j;
import mctech.components.a.C0100m;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/G.class */
public class G extends ContainerComponent<mctech.blockentities.b.b> {
    public G(mctech.blockentities.b.b bVar, Player player, int i) {
        super(bVar, player, i);
        addSlot(mctech.m.g.g.a(bVar, bVar.e, 0, 114, 29));
        addSlot(mctech.m.g.g.a((mctech.m.a.g) bVar, 1, 114, 66, false));
        addPlayerInventoryAt(player.getInventory(), 42, 122);
        getComponents().clear();
        addComponent(new C0100m(115, 49, bVar).a(true).b(true));
        addComponent(new C0093f(85, 90, bVar, () -> {
            return 0;
        }));
        addComponent(new C0095h(119, 98, bVar, () -> {
            return 0;
        }));
        addComponent(new C0097j(this, () -> {
            return 0;
        }));
        addComponent(new mctech.components.a.H(bVar, () -> {
            return 0;
        }).d("gui.mctech.inventory.button"));
        addComponent(new mctech.components.a.u(bVar, () -> {
            return 0;
        }).a(EnumSet.of(mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.ENERGY_OUTPUT, mctech.components.a.u.a.FUEL_STORAGE)));
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, MachineTier.T1);
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
