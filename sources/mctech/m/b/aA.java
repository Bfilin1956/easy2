package mctech.m.b;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.api.tiles.ICustomContainer;
import mctech.api.tiles.readers.IFuelStorage;
import mctech.components.AbstractC0115i;
import mctech.components.C0122p;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
import mctech.init.MCTechLang;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/aA.class */
public class aA extends AbstractC0115i<mctech.blockentities.c.aa> implements ICustomContainer {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public Vec2i d;
    private mctech.utils.math.geometry.b e;
    private final mctech.components.a.u<mctech.blockentities.c.aa> f;

    public aA(mctech.blockentities.c.aa aaVar, Player player, int i) {
        super(aaVar, player, i);
        this.d = new Vec2i(238, 186);
        MachineTier machineTier = aaVar.machineTier();
        mctech.i.c cVarG = aaVar.g();
        this.d = new Vec2i(238, 186);
        Objects.requireNonNull(machineTier);
        this.f = (mctech.components.a.u) new mctech.components.a.u(aaVar, machineTier::ordinal).a(EnumSet.of(mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON);
        switch (aaVar.g()) {
            case WATER:
                this.e = new mctech.utils.math.geometry.b(46, 27, 19, 60);
                break;
            case LAVA:
                this.e = new mctech.utils.math.geometry.b(92, 27, 19, 60);
                break;
        }
        a(aaVar.getInventoryHandler(), cVarG);
        addPlayerInventoryWithOffset(player.getInventory(), 27, 20);
        getComponents().clear();
        addComponent(new C0099l(this.e.a(), this.e.b(), aaVar.f, () -> {
            return aaVar.machineTier().ordinal();
        }));
        addComponent(new mctech.components.b.i(new mctech.utils.math.geometry.b(cVarG == mctech.i.c.LAVA ? 147 : 109, 50, 14, 15), (IFuelStorage) this.gui, new Vec2i(18, 242), true));
        Objects.requireNonNull(machineTier);
        addComponent(new C0097j(this, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(aaVar, machineTier::ordinal).d("gui.mctech.inventory.button"));
        addComponent(new C0122p(MCTech.loc(String.format("textures/gui/components/gui_%s_error_notification.png", cVarG.c)), new mctech.utils.math.geometry.b(0, -16, this.d.getX(), 0), new Vec2i(176, 92), Vec2i.ZERO, () -> {
            return Boolean.valueOf((cVarG != mctech.i.c.WATER || aaVar.d() || this.f.b()) ? false : true);
        }));
        addComponent(this.f);
    }

    private void a(Vec2i vec2i, mctech.m.c.g gVar, int i) {
        addSlot(new mctech.m.g.g((mctech.m.a.g) this.gui, i, vec2i.getX(), vec2i.getY(), gVar));
    }

    private void a(@NotNull mctech.m.e.i iVar, @NotNull mctech.i.c cVar) {
        switch (cVar) {
            case WATER:
                a(new Vec2i(168, 27), mctech.m.c.f.a, 0);
                a(new Vec2i(168, 71), mctech.m.c.r.c, 1);
                a(new Vec2i(108, 71), mctech.m.c.a.f.b, 2);
                break;
            case LAVA:
                a(new Vec2i(50, 27), mctech.m.c.f.a, 0);
                a(new Vec2i(50, 71), mctech.m.c.r.c, 1);
                a(new Vec2i(146, 71), mctech.m.c.a.f.b, 2);
                a(new Vec2i(146, 27), new mctech.utils.E(Set.of(Tags.Items.STONES, Tags.Items.COBBLESTONES)), 3);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((mctech.blockentities.c.aa) getHolder()).machineTier(), (Supplier<String>) () -> {
            return String.format("%s_generator", ((mctech.blockentities.c.aa) getHolder()).g().c);
        });
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(this.d.getX());
        bVar.f(this.d.getY());
    }

    @Override // mctech.api.tiles.ICustomContainer
    public Vec2i getFilterButtonCords() {
        return new Vec2i(-4, 28);
    }
}
