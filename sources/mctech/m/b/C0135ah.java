package mctech.m.b;

import java.util.EnumSet;
import mctech.api.tiles.ICustomContainer;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0096i;
import mctech.components.a.C0097j;
import mctech.components.a.InterfaceC0102o;
import mctech.init.MCTechLang;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.ah, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/ah.class */
public class C0135ah extends AbstractC0115i<mctech.blockentities.c.M> implements ICustomContainer {
    public C0135ah(mctech.blockentities.c.M m, Player player, int i) {
        super(m, player, i);
        InterfaceC0102o interfaceC0102o = () -> {
            return 3;
        };
        for (int i2 = 0; i2 < 7; i2++) {
            for (int i3 = 0; i3 < 7; i3++) {
                addSlot(new mctech.m.g.g(m, (i3 * 7) + i2, 58 + (i2 * 18), 24 + (i3 * 18), new mctech.m.c.m(m)));
            }
        }
        addSlot(new mctech.m.g.g(m, 49, 205, 79, mctech.m.c.r.c));
        getComponents().clear();
        addPlayerInventoryAt(player.getInventory(), 42, 174);
        addComponent(new mctech.components.a.N(186, 79, m, interfaceC0102o).a(-90.0f));
        addComponent(new C0093f(83, 150, m, interfaceC0102o));
        addComponent(new C0095h(117, 158, m, interfaceC0102o));
        addComponent(new C0096i(187, 78, () -> {
            EmiMachineRegistry.displayRecipes((mctech.blockentities.c.M) getHolder());
        }).a(-90.0f).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES));
        addComponent(new C0097j(this, interfaceC0102o));
        addComponent(new mctech.components.a.H(m, interfaceC0102o).d("gui.mctech.inventory.button"));
        addComponent(new mctech.components.a.u(m, interfaceC0102o).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((mctech.blockentities.c.M) getHolder()).machineTier());
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(248);
        bVar.f(mctech.utils.c.h.i);
    }
}
