package mctech.m.b;

import java.util.Objects;
import mctech.MCTech;
import mctech.api.tiles.ICustomContainer;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0093f;
import mctech.components.a.C0097j;
import mctech.components.a.InterfaceC0102o;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/aM.class */
public class aM extends AbstractC0115i<mctech.blockentities.b.l> implements ICustomContainer {
    public aM(mctech.blockentities.b.l lVar, Player player, int i) {
        super(lVar, player, i);
        MachineTier machineTier = MachineTier.T1;
        Objects.requireNonNull(machineTier);
        InterfaceC0102o interfaceC0102o = machineTier::ordinal;
        addSlot(new mctech.m.g.g(lVar, 0, 47, 52, mctech.m.c.r.r));
        getComponents().clear();
        addPlayerInventoryAt(player.getInventory(), 35, 111);
        addComponent(new C0097j(this, interfaceC0102o));
        addComponent(new mctech.components.R(lVar));
        addComponent(new C0093f(113, 80, lVar, interfaceC0102o));
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return MCTech.loc("textures/gui/container/gui_windmill.png");
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(aI.f);
        bVar.f(193);
    }
}
