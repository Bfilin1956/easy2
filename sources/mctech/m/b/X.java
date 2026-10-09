package mctech.m.b;

import java.util.EnumSet;
import mctech.MCTech;
import mctech.api.tiles.ICustomContainer;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0096i;
import mctech.components.a.C0097j;
import mctech.components.a.C0098k;
import mctech.components.a.C0107t;
import mctech.components.a.InterfaceC0102o;
import mctech.init.MCTechLang;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/X.class */
public class X extends AbstractC0115i<mctech.blockentities.c.E> implements ICustomContainer {
    public X(mctech.blockentities.c.E e, Player player, int i) {
        super(e, player, i);
        InterfaceC0102o interfaceC0102o = () -> {
            return e.machineTier().ordinal();
        };
        addSlot(new mctech.m.g.g(e, 0, 38, 31, new mctech.m.c.m(e)));
        addSlot(new mctech.m.g.g(e, 1, 38, 68, mctech.m.c.r.c));
        getComponents().clear();
        addPlayerInventoryAt(player.getInventory(), 42, 110);
        addComponent(new C0098k(MCTech.loc("textures/gui/components/molecular_converter_animation.png"), 190, 82, 24, 24.0f, true, C0098k.a.VERTICAL, 25, 17, 190, 82));
        addComponent(new C0107t(115, 57, 16, 16, () -> {
            return e.B() ? e.d() : ItemStack.EMPTY;
        }));
        addComponent(new mctech.components.a.A(e, 65, 25, 160, 10));
        addComponent(new mctech.components.a.N(39, 49, e, interfaceC0102o));
        addComponent(new C0093f(85, 78, e, interfaceC0102o));
        addComponent(new C0095h(119, 86, e, interfaceC0102o));
        addComponent(new C0096i(39, 49, () -> {
            EmiMachineRegistry.displayRecipes((mctech.blockentities.c.E) getHolder());
        }).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES));
        addComponent(new C0097j(this, interfaceC0102o));
        addComponent(new mctech.components.a.H(e, interfaceC0102o).d("gui.mctech.inventory.button"));
        addComponent(new mctech.components.a.u(e, interfaceC0102o).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((mctech.blockentities.c.E) getHolder()).machineTier());
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
