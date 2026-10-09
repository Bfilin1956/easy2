package mctech.m.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mctech.MCTech;
import mctech.components.a.C0101n;
import mctech.init.MCTechDataComponent;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.network.PacketDistributor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/aq.class */
public class aq extends P<mctech.m.f.o> implements mctech.o.g {
    private static final C0101n b = new C0101n(MCTech.loc("textures/gui/container/gui_enhanced_singular_staff.png"), mctech.q.c.c, mctech.utils.c.h.i);
    private static final int[][] c = {new int[]{11, 118}, new int[]{35, 118}, new int[]{59, 118}, new int[]{83, 118}, new int[]{107, 118}};
    private final List<mctech.components.a.P<?>> d;
    private final List<mctech.components.a.P<?>> e;
    private final List<mctech.components.a.P<?>> f;
    private final List<mctech.components.a.P<?>> g;
    private final int h;
    private mctech.items.e.c.e i;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/aq$a.class */
    private enum a {
        AREA,
        DEPTH,
        SPEED,
        RANGE
    }

    public aq(mctech.m.f.o oVar, Player player, int i, int i2) {
        super(oVar, player, i, i2);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = i2;
        this.i = (mctech.items.e.c.e) player.getMainHandItem().getOrDefault(MCTechDataComponent.SINGULAR_STAFF_SETTINGS, mctech.items.e.c.e.a);
        for (int i3 = 0; i3 < c.length; i3++) {
            int[] iArr = c[i3];
            addSlot(new mctech.m.g.g(oVar, i3, iArr[0], iArr[1], mctech.m.f.o::d));
        }
        addPlayerInventoryAt(player.getInventory(), 48, 157);
        this.d.add(a(11, 36, 0, a.AREA).a((mctech.components.a.P.a) this::b));
        this.d.add(a(39, 36, 1, a.AREA).a((mctech.components.a.P.a) this::b));
        this.d.add(a(67, 36, 2, a.AREA).a((mctech.components.a.P.a) this::b));
        this.d.add(a(11, 49, 3, a.AREA).a((mctech.components.a.P.a) this::b));
        this.d.add(a(39, 49, 4, a.AREA).a((mctech.components.a.P.a) this::b));
        this.d.add(a(67, 49, 5, a.AREA).a((mctech.components.a.P.a) this::b));
        this.d.add(c(95, 36, 6, a.AREA).a((mctech.components.a.P.a) this::b));
        this.d.forEach((v1) -> {
            addComponent(v1);
        });
        this.f.add(c(132, 36, 0, a.SPEED).a((mctech.components.a.P.a) this::d));
        this.f.add(b(160, 36, 1, a.SPEED).a((mctech.components.a.P.a) this::d));
        this.f.add(a(160, 49, 2, a.SPEED).a((mctech.components.a.P.a) this::d));
        this.f.add(a(188, 49, 3, a.SPEED).a((mctech.components.a.P.a) this::d));
        this.f.add(c(216, 36, 4, a.SPEED).a((mctech.components.a.P.a) this::d));
        this.f.forEach((v1) -> {
            addComponent(v1);
        });
        this.e.add(c(11, 82, 0, a.DEPTH).a((mctech.components.a.P.a) this::c));
        this.e.add(a(39, 82, 1, a.DEPTH).a((mctech.components.a.P.a) this::c));
        this.e.add(a(67, 82, 2, a.DEPTH).a((mctech.components.a.P.a) this::c));
        this.e.add(a(39, 95, 3, a.DEPTH).a((mctech.components.a.P.a) this::c));
        this.e.add(a(67, 95, 4, a.DEPTH).a((mctech.components.a.P.a) this::c));
        this.e.add(c(95, 82, 5, a.DEPTH).a((mctech.components.a.P.a) this::c));
        this.e.forEach((v1) -> {
            addComponent(v1);
        });
        this.g.add(c(132, 82, 0, a.RANGE).a((mctech.components.a.P.a) this::e));
        this.g.add(b(160, 82, 1, a.RANGE).a((mctech.components.a.P.a) this::e));
        this.g.add(b(160, 95, 2, a.RANGE).a((mctech.components.a.P.a) this::e));
        this.g.add(c(216, 82, 3, a.RANGE).a((mctech.components.a.P.a) this::e));
        this.g.forEach((v1) -> {
            addComponent(v1);
        });
        addComponent(c());
    }

    private mctech.components.a.P<?> a(int i, int i2, int i3, a aVar) {
        return a(i, i2, 29, 14, new Vec2i(427, 54), new Vec2i(427, 13), i3, aVar);
    }

    private mctech.components.a.P<?> b(int i, int i2, int i3, a aVar) {
        return a(i, i2, 57, 14, new Vec2i(427, 41), new Vec2i(427, 0), i3, aVar);
    }

    private mctech.components.a.P<?> c(int i, int i2, int i3, a aVar) {
        return a(i, i2, 29, 27, new Vec2i(483, 41), new Vec2i(483, 0), i3, aVar);
    }

    private mctech.components.a.P<?> a(int i, int i2, int i3, int i4, Vec2i vec2i, Vec2i vec2i2, int i5, a aVar) {
        return (mctech.components.a.P) new mctech.components.a.P(b, i, i2, i3, i4, vec2i, new Vec2i(300, 0), new Vec2i(300, 0), () -> {
            switch (aVar) {
                case AREA:
                    return this.i.e() == i5;
                case DEPTH:
                    return this.i.f() == i5;
                case SPEED:
                    return this.i.g() == i5;
                case RANGE:
                    return this.i.h() == i5;
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
        }).c(false).b(vec2i2);
    }

    private mctech.components.a.P<?> c() {
        return new mctech.components.a.P(b, 129, 118, 119, 14, new Vec2i(393, mctech.g.c.a.d.d), new Vec2i(393, 242), this.i.i() ? new Vec2i(393, mctech.g.c.a.d.d) : new Vec2i(393, 242), () -> {
            return this.i.i();
        }).b(new Vec2i(393, 26)).c(false).a(this::a);
    }

    private void a(mctech.components.a.P<?> p) {
        this.i = this.i.a(p.k());
        d();
    }

    private void b(mctech.components.a.P<?> p) {
        Iterator<mctech.components.a.P<?>> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a(false);
        }
        p.a(true);
        this.i = this.i.a(this.d.indexOf(p));
        d();
    }

    private void c(mctech.components.a.P<?> p) {
        Iterator<mctech.components.a.P<?>> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a(false);
        }
        p.a(true);
        this.i = this.i.b(this.e.indexOf(p));
        d();
    }

    private void d(mctech.components.a.P<?> p) {
        Iterator<mctech.components.a.P<?>> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().a(false);
        }
        p.a(true);
        this.i = this.i.c(this.f.indexOf(p));
        d();
    }

    private void e(mctech.components.a.P<?> p) {
        Iterator<mctech.components.a.P<?>> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().a(false);
        }
        p.a(true);
        this.i = this.i.d(this.g.indexOf(p));
        d();
    }

    private void d() {
        if (FMLEnvironment.dist.isClient()) {
            PacketDistributor.sendToServer(new mctech.q.d.k(getPlayer().getUUID(), this.h, this.i), new CustomPacketPayload[0]);
        }
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return b.a();
    }

    @Override // mctech.o.g
    public int a() {
        return b.b();
    }

    @Override // mctech.o.g
    public int b() {
        return b.c();
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(mctech.utils.c.h.i, 238);
    }
}
