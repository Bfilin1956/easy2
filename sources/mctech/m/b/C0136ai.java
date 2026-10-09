package mctech.m.b;

import java.util.Objects;
import java.util.function.Supplier;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0097j;
import mctech.components.a.C0101n;
import mctech.components.a.InterfaceC0102o;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.ai, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/ai.class */
public class C0136ai extends AbstractC0115i<mctech.blockentities.c.N> {
    public static final mctech.utils.math.geometry.b a = new mctech.utils.math.geometry.b(7, 12, 162, 2);
    public static final Vec2i b = new Vec2i(7, 168);
    public static final Vec2i c = new Vec2i(0, 11);
    public static final Vec2i d = new Vec2i(11, 0);
    public static final Vec2i e = new Vec2i(11, 11);

    public C0136ai(mctech.blockentities.c.N n, Player player, int i) {
        super(n, player, i);
        InterfaceC0102o interfaceC0102o = () -> {
            return 2;
        };
        addSlot(new mctech.m.g.g(n, 1, 92, 45, n.i));
        addSlot(mctech.m.g.g.d(n, 2, 136, 45));
        addSlot(new mctech.m.g.z(n, 3, 234, 19));
        addSlot(new mctech.m.g.z(n, 4, 234, 38));
        addPlayerInventoryAt(player.getInventory(), 42, 110);
        getComponents().clear();
        addComponent(new C0093f(85, 78, n, interfaceC0102o));
        addComponent(new C0095h(119, 86, n, interfaceC0102o));
        addComponent(new C0097j(this, interfaceC0102o));
        addComponent(new mctech.components.a.H(n, interfaceC0102o).d("gui.mctech.inventory.button"));
        addComponent(new mctech.components.a.u(n, interfaceC0102o).a(mctech.components.a.u.a));
        addComponent(new mctech.components.b.o(113, 47, 18, 13, n, 0, 122, false).a(C0101n.b.a()).a(true));
        mctech.components.b.o oVarA = new mctech.components.b.o(46, 34, 162, 2, n, 0, 254, false).a(C0101n.b.a());
        Objects.requireNonNull(n);
        Supplier<Float> supplier = n::getSubProgress;
        Objects.requireNonNull(n);
        addComponent(oVarA.a(supplier, n::getMaxSubProgress).a(true));
        addComponent(new mctech.components.b.t(n, n.a(), new Vec2i(32, 60)));
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, MachineTier.T3, "rare_earth_centrifuge");
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(mctech.utils.c.h.i);
        bVar.f(222);
    }

    @Override // mctech.components.AbstractC0115i, mctech.components.ContainerComponent
    public Vec2i getFilterGuiSize() {
        return new Vec2i(122, 132);
    }

    @Override // mctech.components.AbstractC0115i, mctech.components.ContainerComponent
    public Vec2i getFilterScrollOffset() {
        return new Vec2i(-2, -2);
    }

    @Override // mctech.components.AbstractC0115i, mctech.components.ContainerComponent
    public Vec2i getFilterItemsOffset() {
        return new Vec2i(3, -2);
    }

    @Override // mctech.components.AbstractC0115i, mctech.components.ContainerComponent
    public Vec2i getInfoGuiSize() {
        return new Vec2i(198, 51);
    }
}
