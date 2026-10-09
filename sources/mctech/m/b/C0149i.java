package mctech.m.b;

import java.util.EnumSet;
import java.util.Objects;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.api.items.Consumables;
import mctech.api.tiles.ICustomContainer;
import mctech.blockentities.c.C0058e;
import mctech.components.AbstractC0115i;
import mctech.components.C0123q;
import mctech.components.a.C0088a;
import mctech.components.a.C0092e;
import mctech.components.a.C0096i;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
import mctech.init.MCTechLang;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/i.class */
public class C0149i extends AbstractC0115i<C0058e> implements ICustomContainer {
    public C0149i(C0058e c0058e, Player player, int i) {
        super(c0058e, player, i);
        addSlot(new mctech.m.g.g(c0058e, 0, 54, 28, new mctech.m.c.m(c0058e)));
        addSlot(new mctech.m.g.g(c0058e, 1, 54, 74, new mctech.m.c.m(c0058e)));
        new at(this, new mctech.utils.math.geometry.b(90, 97, 66, 16), 3, 2).a(new int[]{3}, 9, (i2, i3, i4) -> {
            return new mctech.m.g.g(c0058e, i2, i3, i4, new C0158r(Consumables.FUEL, Consumables.CATALYST));
        });
        addSlot(new mctech.m.g.g(c0058e, 5, 176, 28, mctech.m.c.f.a));
        addSlot(mctech.m.g.g.e(c0058e, 6, 176, 74));
        addPlayerInventoryWithOffset(player.getInventory(), 35, 73);
        getComponents().clear();
        addComponent(new C0092e(90, 81, c0058e).c(false).b((Component) MCTechLang.TOOLTIP_CLEAR_CONTENT).a(m -> {
            c0058e.f(0);
        }));
        addComponent(new C0092e(160, 81, c0058e).c(false).b((Component) MCTechLang.TOOLTIP_CLEAR_CONTENT).a(m2 -> {
            c0058e.f(1);
        }));
        addComponent(new C0099l(c0058e, 79, 28, 0, c0058e.m, c0058e));
        addComponent(new C0099l(149, 28, c0058e.n, c0058e));
        addComponent(new C0097j(this, c0058e));
        addComponent(new mctech.components.a.H(c0058e, c0058e).d("gui.mctech.inventory.button"));
        addComponent(new mctech.components.a.u(c0058e, c0058e).a(EnumSet.of(mctech.components.a.u.a.HEAT_LEVEL, mctech.components.a.u.a.HEAT_DAMAGE, mctech.components.a.u.a.HEAT_EXPLOSION)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
        Vec2i vec2i = new Vec2i(0, 251);
        Objects.requireNonNull(c0058e);
        addComponent(new C0088a(120, 134, 5, 5, vec2i, c0058e::isHeating, getTexture()));
        Objects.requireNonNull(c0058e);
        Supplier supplier = c0058e::heatLevel;
        Objects.requireNonNull(c0058e);
        addComponent(new mctech.components.a.O(86, 125, supplier, c0058e::explosionLevel, c0058e).a(() -> {
            return mctech.g.d.e.h.a(MCTechLang.TOOLTIP_HEAT_LEVEL, Integer.valueOf(c0058e.heatLevel()), Integer.valueOf(c0058e.explosionLevel()));
        }));
        addComponent(new C0096i(177, 51, () -> {
            EmiMachineRegistry.displayRecipes((C0058e) getHolder());
        }).b((Component) MCTechLang.TOOLTIP_SHOW_RECIPES));
        addComponent(new mctech.components.a.N(177, 51, c0058e, c0058e));
        ResourceLocation resourceLocationLoc = MCTech.loc("textures/gui/components/overheat_notification.png");
        mctech.utils.math.geometry.b bVar = new mctech.utils.math.geometry.b(35, -56, 176, 92);
        Vec2i vec2i2 = new Vec2i(176, 92);
        Vec2i vec2i3 = Vec2i.ZERO;
        Objects.requireNonNull(c0058e);
        addComponent(new C0123q(resourceLocationLoc, bVar, vec2i2, vec2i3, c0058e::isOverheating));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((C0058e) getHolder()).machineTier());
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(236);
        bVar.f(239);
    }
}
