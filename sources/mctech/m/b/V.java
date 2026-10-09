package mctech.m.b;

import java.util.EnumSet;
import java.util.Objects;
import mctech.MCTech;
import mctech.api.tiles.ICustomContainer;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0096i;
import mctech.components.a.C0097j;
import mctech.components.a.C0101n;
import mctech.init.MCTechLang;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/V.class */
public class V extends AbstractC0115i<mctech.blockentities.c.C> implements ICustomContainer {
    private static final C0101n a = new C0101n(MCTech.loc("textures/gui/container/t6/gui_matrix_converter_t6.png"), mctech.utils.c.h.i, mctech.utils.c.h.i);

    public V(mctech.blockentities.c.C c, Player player, int i) {
        super(c, player, i);
        MachineTier machineTier = c.machineTier();
        addSlot(new mctech.m.g.g(c, 0, 84, 63, new mctech.m.c.m(c)));
        addSlot(mctech.m.g.g.d(c, 1, 127, 63));
        addPlayerInventoryAt(player.getInventory(), 35, 112);
        getComponents().clear();
        addComponent(new mctech.components.a.z(c, 32, 24, mctech.o.i.e, 32));
        addComponent(new mctech.components.a.R(a, 156, 48, 43, 9, new Vec2i(0, 238), new Vec2i(0, 238), new Vec2i(0, 229)).c(false).b((Component) MCTechLang.GUI_MATRIX_CONVERTER_RESET.get()).a(r -> {
            c.sendToServer(0, 0);
        }));
        addComponent(new C0096i(107, 63, () -> {
            EmiMachineRegistry.displayRecipes((mctech.blockentities.c.C) getHolder());
        }).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES).a(-90.0f));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.N(106, 63, c, machineTier::ordinal).a(-90.0f));
        Objects.requireNonNull(machineTier);
        addComponent(new C0093f(78, 84, c, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new C0095h(112, 92, c, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new C0097j(this, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(c, machineTier::ordinal).d("gui.mctech.inventory.button"));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.u(c, machineTier::ordinal).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return a.a();
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
