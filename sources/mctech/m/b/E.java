package mctech.m.b;

import java.util.EnumSet;
import java.util.Objects;
import java.util.function.Supplier;
import mctech.api.tiles.ICustomContainer;
import mctech.blockentities.c.C0070q;
import mctech.components.AbstractC0115i;
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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/E.class */
public class E extends AbstractC0115i<C0070q> implements ICustomContainer {
    public static final int a = 0;
    public static final int b = 1;
    public Vec2i c;

    public E(C0070q c0070q, Player player, int i) {
        super(c0070q, player, i);
        this.c = new Vec2i(238, 186);
        MachineTier machineTier = c0070q.machineTier();
        Vec2i vec2i = new Vec2i(138, 27);
        Vec2i vec2i2 = new Vec2i(138, 71);
        addSlot(new mctech.m.g.g((mctech.m.a.g) this.gui, 0, vec2i.getX(), vec2i.getY(), new mctech.utils.o(c0070q.f)));
        addSlot(new mctech.m.g.g((mctech.m.a.g) this.gui, 1, vec2i2.getX(), vec2i2.getY(), mctech.m.c.r.c));
        addPlayerInventoryWithOffset(player.getInventory(), 27, 20);
        getComponents().clear();
        addComponent(new C0099l(c0070q, 76, 27, 0, c0070q.f, () -> {
            return c0070q.machineTier().ordinal();
        }).a());
        Objects.requireNonNull(machineTier);
        addComponent(new C0097j(this, machineTier::ordinal));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.H(c0070q, machineTier::ordinal).d("gui.mctech.inventory.button"));
        Objects.requireNonNull(machineTier);
        addComponent(new mctech.components.a.u(c0070q, machineTier::ordinal).a(EnumSet.noneOf(mctech.components.a.u.a.class)).b((Component) MCTechLang.TOOLTIP_INFO_BUTTON));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((C0070q) getHolder()).machineTier(), (Supplier<String>) () -> {
            return "fluid_tank";
        });
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(this.c.getX());
        bVar.f(this.c.getY());
    }

    @Override // mctech.api.tiles.ICustomContainer
    public Vec2i getFilterButtonCords() {
        return new Vec2i(-4, 28);
    }
}
