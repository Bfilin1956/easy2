package mctech.m.b;

import java.util.EnumSet;
import java.util.Objects;
import java.util.function.Supplier;
import mctech.api.tiles.ICustomContainer;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
import mctech.components.a.C0100m;
import mctech.init.MCTechLang;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/ax.class */
public class ax extends AbstractC0115i<mctech.blockentities.c.X> implements ICustomContainer {
    public Vec2i a;

    public ax(mctech.blockentities.c.X x, Player player, int i) {
        super(x, player, i);
        this.a = new Vec2i(238, 186);
        MachineTier machineTier = x.machineTier();
        addSlot(mctech.m.g.g.a((mctech.m.a.g) x, 0, 107, 67, false));
        addSlot(mctech.m.g.g.d(x, 1, 107, 32));
        addPlayerInventoryWithOffset(player.getInventory(), 27, 20);
        getComponents().clear();
        mctech.fluid.h<?> hVar = x.f;
        Objects.requireNonNull(machineTier);
        addComponent(new C0099l(x, 30, 23, 0, hVar, machineTier::ordinal).a((Component) MCTechLang.GUI_FLUID_WATER));
        mctech.fluid.h<?> hVar2 = x.g;
        Objects.requireNonNull(machineTier);
        addComponent(new C0099l(x, 182, 23, 1, hVar2, machineTier::ordinal).a((Component) MCTechLang.GUI_FLUID_LAVA));
        addComponent(new C0100m(108, 51, x));
        Objects.requireNonNull(machineTier);
        addComponent(new C0097j(this, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(x, machineTier::ordinal).d("gui.mctech.inventory.button"));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.u(x, machineTier::ordinal).a(EnumSet.noneOf(mctech.components.a.u.a.class)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((mctech.blockentities.c.X) getHolder()).machineTier(), (Supplier<String>) () -> {
            return "cobblestone_generator";
        });
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(this.a.getX());
        bVar.f(this.a.getY());
    }
}
