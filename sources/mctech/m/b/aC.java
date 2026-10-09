package mctech.m.b;

import mctech.MCTech;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0096i;
import mctech.components.a.C0097j;
import mctech.components.a.C0100m;
import mctech.components.a.C0101n;
import mctech.init.MCTechLang;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/aC.class */
public class aC extends AbstractC0115i<mctech.blockentities.c.ac> {
    public aC(mctech.blockentities.c.ac acVar, Player player, int i) {
        super(acVar, player, i);
        addSlot(mctech.m.g.g.a((mctech.m.a.g) acVar, 0, 194, 94, false));
        addSlot(new mctech.m.g.g(acVar, 1, 114, 32, new mctech.m.c.m(acVar)));
        addSlot(new mctech.m.g.B(acVar, 2, 114, 74));
        addPlayerInventoryAt(player.getInventory(), 42, 129);
        addComponent(new C0097j(this, 1, 18, () -> {
            return acVar.machineTier().ordinal();
        }).c(false));
        addComponent(new C0100m(116, 99, acVar));
        addComponent(new mctech.components.b.o(111, 29, 22, 41, acVar, 195, 32, true, true).a(C0101n.a.a()).a(false));
        addComponent(new C0096i(115, 53, () -> {
            EmiMachineRegistry.displayRecipes("rare_extractor");
        }).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES));
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return MCTech.loc("textures/gui/container/t1/gui_rare_extractor_t1.png");
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(234);
        bVar.f(211);
    }
}
