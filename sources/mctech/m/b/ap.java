package mctech.m.b;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mctech.MCTech;
import mctech.components.C0123q;
import mctech.components.a.C0101n;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/ap.class */
public class ap extends P<mctech.m.f.l> {
    public static final ResourceLocation b = MCTech.loc("textures/gui/container/gui_schem_installer.png");
    public static final C0101n c = new C0101n(b, mctech.utils.c.h.i, mctech.utils.c.h.i);
    private List<mctech.components.a.P<?>> i;
    private List<mctech.components.a.P<?>> j;
    private List<C0123q> k;
    private mctech.components.a.P<?> l;
    private boolean m;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;

    public ap(mctech.m.f.l lVar, Player player, int i, int i2, ItemStack itemStack) {
        super(lVar, player, i, i2);
        this.i = mctech.utils.a.b.i();
        this.j = mctech.utils.a.b.i();
        this.k = mctech.utils.a.b.i();
        addHiddenPlayerInventory(player.getInventory());
        List<mctech.items.e.i.b> listB = lVar.a.b();
        this.d = lVar.a.a();
        this.e = lVar.a.d();
        this.f = lVar.a.c();
        this.g = lVar.a.e();
        int i3 = 0;
        while (i3 < 6) {
            mctech.components.a.P<?> pA = new mctech.components.a.P(c, 11 + (24 * i3), 13, 18, 18, new Vec2i(0, 197), new Vec2i(0, 179), new Vec2i(0, 179), () -> {
                return false;
            }).b(new Vec2i(0, 215)).a((mctech.components.a.P.a<mctech.components.a.P<?>>) p -> {
                this.d = this.i.indexOf(p);
                mctech.items.e.i.b bVar = (mctech.items.e.i.b) listB.get(this.d);
                if (bVar.d() != 0 && bVar.e() != 0) {
                    this.h = bVar.h();
                } else {
                    this.h = false;
                }
                a((mctech.components.a.P<?>) p);
            });
            pA.a(lVar.a.a() == i3);
            this.i.add(pA);
            addComponent(pA);
            mctech.items.e.i.b bVar = listB.get(i3);
            mctech.components.a.P pA2 = new mctech.components.a.I<Object>(this, c, 24 + (24 * i3), 25, 9, 9, new Vec2i(0, 233), new Vec2i(0, 233), new Vec2i(0, 233), () -> {
                return false;
            }) { // from class: mctech.m.b.ap.1
                @Override // mctech.components.a.R, mctech.m.d.a.a
                public void a(GuiGraphics guiGraphics, int i4, int i5, float f) {
                    PoseStack poseStackPose = guiGraphics.pose();
                    poseStackPose.pushPose();
                    poseStackPose.translate(0.0d, 0.0d, 250.0d);
                    super.a(guiGraphics, i4, i5, f);
                    poseStackPose.popPose();
                }
            }.a(i3).b(new Vec2i(18, 233)).a((mctech.components.a.R.d<mctech.components.a.P>) p2 -> {
                int iF = ((mctech.components.a.I) p2).f();
                lVar.a.b().set(iF, new mctech.items.e.i.b(iF, 0, 0, 0, (Map<ItemStack, List<Integer>>) Collections.emptyMap(), false));
                this.m = true;
                MCTech.NETWORKING.sendClientItemEvent(itemStack, 4, iF);
                p2.a_(false);
            });
            pA2.a_((bVar.b() || bVar.h()) ? false : true);
            this.j.add(pA2);
            addComponent(pA2);
            C0123q c0123q = new C0123q(this, b, new mctech.utils.math.geometry.b(24 + (24 * i3), 25, 9, 233), Vec2i.EMPTY, Vec2i.EMPTY) { // from class: mctech.m.b.ap.2
                @Override // mctech.components.C0123q, mctech.m.d.a.a
                public void a(GuiGraphics guiGraphics, int i4, int i5, float f) {
                    PoseStack poseStackPose = guiGraphics.pose();
                    poseStackPose.pushPose();
                    poseStackPose.translate(0.0d, 0.0d, 250.0d);
                    guiGraphics.blit(ap.b, this.q.getGuiLeft() + this.o.a(), this.q.getGuiTop() + this.o.b(), this.o.d(), this.o.c(), 9, 9);
                    poseStackPose.popPose();
                    this.q.c();
                }

                @Override // mctech.components.C0123q, mctech.m.d.a.a
                protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
                    set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
                }
            };
            c0123q.a_(bVar.h());
            this.k.add(c0123q);
            addComponent(c0123q);
            if (this.d == i3) {
                this.h = bVar.h();
            }
            i3++;
        }
        this.l = new mctech.components.a.P(c, 119, 67, 29, 7, new Vec2i(0, 242), new Vec2i(0, 249), new Vec2i(0, 249), () -> {
            return this.h;
        }).b(new Vec2i(200, 200)).a(p3 -> {
            mctech.items.e.i.b bVar2 = (mctech.items.e.i.b) listB.get(this.d);
            if (bVar2.d() != 0 && bVar2.e() != 0) {
                this.h = !this.h;
                listB.set(this.d, new mctech.items.e.i.b(bVar2.c(), bVar2.d(), bVar2.e(), bVar2.f(), bVar2.g(), this.h));
                this.k.get(this.d).a_(this.h);
                this.j.get(this.d).a_(!this.h);
                MCTech.NETWORKING.sendClientItemEvent(itemStack, 5, (this.d * 10) + (this.h ? 1 : 0));
            }
            p3.a(this.h);
        });
        addComponent(new mctech.components.a.F(this));
        addComponent(this.l);
        addComponent(new mctech.components.a.P(c, 119, 81, 29, 7, new Vec2i(0, 242), new Vec2i(0, 249), new Vec2i(0, 249), () -> {
            return this.g;
        }).b(new Vec2i(200, 200)).a(p4 -> {
            this.g = !this.g;
            MCTech.NETWORKING.sendClientItemEvent(itemStack, 3, this.g ? 1 : 0);
        }));
        addComponent(new mctech.components.a.P(c, 119, 95, 29, 7, new Vec2i(0, 242), new Vec2i(0, 249), new Vec2i(0, 249), () -> {
            return this.e;
        }).b(new Vec2i(200, 200)).a(p5 -> {
            this.e = !this.e;
            MCTech.NETWORKING.sendClientItemEvent(itemStack, 2, this.e ? 1 : 0);
        }));
        addComponent(new mctech.components.a.P(c, 119, 109, 29, 7, new Vec2i(0, 242), new Vec2i(0, 249), new Vec2i(0, 249), () -> {
            return this.f;
        }).b(new Vec2i(200, 200)).a(p6 -> {
            this.f = !this.f;
            MCTech.NETWORKING.sendClientItemEvent(itemStack, 1, this.f ? 1 : 0);
        }));
    }

    public void a(mctech.components.a.P<?> p) {
        this.i.forEach(p2 -> {
            p2.a(p2 == p);
        });
        MCTech.NETWORKING.sendClientItemEvent(((mctech.m.f.l) this.gui).a(), 0, this.i.indexOf(p));
    }

    public boolean a() {
        return this.m;
    }

    public void a(boolean z) {
        this.m = z;
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        super.onGuiLoaded(bVar);
        bVar.e(160, 144);
        bVar.c(1);
        bVar.c(2);
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return b;
    }

    @Override // mctech.m.b.P, mctech.components.ContainerComponent, mctech.m.b.S
    public int getInventorySize() {
        return 0;
    }
}
