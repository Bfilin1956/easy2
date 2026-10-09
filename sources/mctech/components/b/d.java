package mctech.components.b;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntListIterator;
import java.util.List;
import java.util.Set;
import mctech.MCTech;
import mctech.api.features.redstone.IComparable;
import mctech.api.util.DirectionList;
import mctech.blockentities.q;
import mctech.components.a.C;
import mctech.components.a.Q;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/d.class */
public class d<T extends mctech.blockentities.q & IComparable> extends mctech.m.d.a.a implements mctech.m.d.b.a {
    public static final ResourceLocation a = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/components/comparator_helper.png");
    public static final Component[] b = {Component.translatable("gui.mctech.comparator.evaluator.min"), Component.translatable("gui.mctech.comparator.evaluator.max"), Component.translatable("gui.mctech.comparator.evaluator.average")};
    public static final mctech.utils.math.geometry.b c = new mctech.utils.math.geometry.b(-117, 31, 52, 15);
    public static final mctech.utils.math.geometry.b d = new mctech.utils.math.geometry.b(-117, 87, 90, 15);
    public static final mctech.utils.math.geometry.b e = new mctech.utils.math.geometry.b(-18, 31, 11, 30);
    public static final mctech.utils.math.geometry.b f = new mctech.utils.math.geometry.b(-18, 87, 11, 45);
    mctech.blockentities.q g;
    mctech.blocks.base.a.a.c h;
    int i;
    q j;
    q k;
    Vec2i l;
    Vec2i m;
    IntList n;

    public d(T t, Vec2i vec2i, Vec2i vec2i2) {
        super(new mctech.utils.math.geometry.b((-122) + vec2i2.getX(), vec2i2.getY(), 122, 139));
        this.i = 6;
        this.n = new IntArrayList();
        this.h = t.getManager();
        this.g = t;
        this.l = vec2i;
        this.m = vec2i2;
        this.j = ((q) a(new q(new mctech.utils.math.geometry.b((-19) + vec2i2.getX(), 31 + vec2i2.getY(), 12, 30), new mctech.utils.math.geometry.b(139, 0, 12, 11)).a(1))).a(a);
        this.k = ((q) a(new q(new mctech.utils.math.geometry.b((-19) + vec2i2.getX(), 87 + vec2i2.getY(), 12, 45), new mctech.utils.math.geometry.b(151, 0, 12, 15)).a(2))).a(a);
        a_(false);
        this.j.a_(false);
        this.k.a_(false);
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_TICK);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
    }

    @Override // mctech.m.d.b.a
    @OnlyIn(Dist.CLIENT)
    public void c(mctech.m.d.b bVar) {
        if (w()) {
            a_(false);
            a(bVar, false);
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void a(mctech.m.d.b bVar, boolean z) {
        bVar.b();
        a_(z);
        this.j.a_(z);
        this.k.a_(z);
        this.g.sendToServer(65534, w() ? 1 : 0);
        b(bVar);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        this.n.clear();
        int guiLeft = (bVar.getGuiLeft() - 122) + this.m.getX();
        int guiTop = bVar.getGuiTop() + this.m.getY();
        this.j.c(a().c());
        int i = 0;
        while (i < 4) {
            boolean z = i < this.j.a() && w();
            int i2 = i;
            int iE = z ? a().b(i).e() : 0;
            a(bVar.a(200 + (i * 3), new mctech.components.a.v(guiLeft + 56, guiTop + 31 + (i * 15), 15, 15, button -> {
                b(i2, 0);
            }, new ItemStack(Items.REDSTONE_TORCH), (iE & 1) != 0).a("gui.mctech.comparator.invert"))).visible = z;
            a(bVar.a(200 + (i * 3) + 1, new mctech.components.a.v(guiLeft + 70, guiTop + 31 + (i * 15), 15, 15, button2 -> {
                b(i2, 1);
            }, new ItemStack(Items.REPEATER), (iE & 2) != 0).a("gui.mctech.comparator.sign"))).visible = z;
            a(bVar.a(200 + (i * 3) + 2, new mctech.components.a.v(guiLeft + 84, guiTop + 31 + (i * 15), 15, 15, button3 -> {
                b(i2, 2);
            }, new ItemStack(Items.REDSTONE_TORCH), (iE & 4) != 0).a("gui.mctech.comparator.post_invert"))).visible = z;
            this.n.add(200 + (i * 3));
            this.n.add(200 + (i * 3) + 1);
            this.n.add(200 + (i * 3) + 2);
            i++;
        }
        int[] iArr = {1, 0, 2, 5, 3, 4, 6};
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            a(bVar.a(250 + i4, new Q(guiLeft + 15 + (i4 * 13), guiTop + 17, 12, 12, e(Character.toString("DUNSWEV".charAt(i4))), button4 -> {
                c(i4);
            })).a((Component) (i4 == 6 ? Blocks.COMPARATOR.getName() : DirectionList.getName(Direction.from3DDataValue(i4)).append(Character.toString('\n'))))).active = i4 != 6;
            this.n.add(250 + i4);
        }
        this.n.add(260);
        a(bVar.a(260, new Q(guiLeft + 48, guiTop + 62, 52, 12, b[a().d()], button5 -> {
            d();
        }).a("gui.mctech.comparator.evaluator")));
        bVar.a(261, new C(bVar.getGuiLeft() + 16 + this.l.getX(), bVar.getGuiTop() + 5 + this.l.getY(), 10, 10, e("C"), button6 -> {
            a(bVar, !w());
        }).a("gui.mctech.comparator.settings"));
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void b(mctech.m.d.b bVar) {
        this.j.c(a().c());
        this.k.c(b().size());
        int iB = this.j.b();
        boolean z = a().c() > 0;
        for (int i = 0; i < 2; i++) {
            boolean zE = this.j.e(i);
            int iE = zE ? a().b(i + iB).e() : 0;
            mctech.components.a.v vVarA = a(bVar.a(200 + (i * 3), mctech.components.a.v.class).a((iE & 1) != 0));
            vVarA.visible = zE && w();
            vVarA.active = z;
            mctech.components.a.v vVarA2 = a(bVar.a(200 + (i * 3) + 1, mctech.components.a.v.class).a((iE & 2) != 0));
            vVarA2.visible = zE && w();
            vVarA2.active = z;
            mctech.components.a.v vVarA3 = a(bVar.a(200 + (i * 3) + 2, mctech.components.a.v.class).a((iE & 4) != 0));
            vVarA3.visible = zE && w();
            vVarA3.active = z;
        }
        int i2 = 0;
        while (i2 < 7) {
            a(bVar.g(250 + i2)).active = i2 != this.i && w();
            i2++;
        }
        a(bVar.g(260)).setMessage(b[a().d()]);
    }

    @OnlyIn(Dist.CLIENT)
    private <K extends AbstractWidget> K a(K k) {
        ((AbstractWidget) k).visible = w();
        ((AbstractWidget) k).active = w();
        return k;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f2) {
        this.j.c(a().c());
        this.k.c(b().size());
        this.q.c(a);
        int guiLeft = (this.q.getGuiLeft() - 122) + this.m.getX();
        int guiTop = this.q.getGuiTop() + this.m.getY();
        this.q.b(guiGraphics, guiLeft, guiTop, 0.0f, 0.0f, 122.0f, 139.0f);
        for (int i3 = 0; i3 < 2 && this.j.e(i3); i3++) {
            this.q.b(guiGraphics, guiLeft + 5, guiTop + 31 + (i3 * 15), 163.0f, c.a(i - this.m.getX(), (i2 - (15 * i3)) - this.m.getY()) ? 15.0f : 0.0f, 52.0f, 15.0f);
        }
        for (int i4 = 0; i4 < 3 && this.k.e(i4); i4++) {
            this.q.b(guiGraphics, guiLeft + 5, guiTop + 87 + (i4 * 15), 163.0f, d.a(i - this.m.getX(), (i2 - (15 * i4)) - this.m.getY()) ? 45.0f : 30.0f, 90.0f, 15.0f);
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        mctech.blocks.base.a.a.a aVar;
        this.q.b(guiGraphics, (Component) f("gui.mctech.comparator.settings"), (-62) + this.m.getX(), 5 + this.m.getY(), mctech.m.d.b.a);
        float f2 = 1.0f / 0.5f;
        this.q.a(guiGraphics, (Component) c("gui.mctech.comparator.out", Integer.valueOf(a().b())), (-117) + this.m.getX(), 63 + this.m.getY(), mctech.m.d.b.a);
        this.q.b(guiGraphics, (Component) f("gui.mctech.comparator.sources"), (-65) + this.m.getX(), 76 + this.m.getY(), mctech.m.d.b.a);
        guiGraphics.pose().scale(0.5f, 0.5f, 0.5f);
        for (int i3 = 0; i3 < 2 && this.j.e(i3); i3++) {
            mctech.blocks.base.a.a.b bVarB = a().b(i3 + this.j.b());
            this.q.a(guiGraphics, bVarB.d(), (int) (((-114) - this.m.getX()) * f2), (int) ((34 + this.m.getY() + (15 * i3)) * f2), -1);
            this.q.a(guiGraphics, (Component) c("gui.mctech.comparator.output.dual", Integer.valueOf(bVarB.g()), Integer.valueOf(bVarB.f())), (int) (((-114) - this.m.getX()) * f2), (int) ((39 + this.m.getY() + (15 * i3)) * f2), -1);
        }
        List<mctech.blocks.base.a.a.a> listB = b();
        Direction directionFrom3DDataValue = this.i == 6 ? null : Direction.from3DDataValue(this.i);
        for (int i4 = 0; i4 < 3 && this.k.e(i4); i4++) {
            int iB = i4 + this.k.b();
            if (iB < listB.size() && (aVar = listB.get(iB)) != null) {
                this.q.a(guiGraphics, aVar.c(), (int) (((-114) - this.m.getX()) * f2), (int) ((90 + this.m.getY() + (15 * i4)) * f2), -1);
                this.q.a(guiGraphics, (Component) c("gui.mctech.comparator.output.single", Integer.valueOf(aVar.a(directionFrom3DDataValue))), (int) (((-114) - this.m.getX()) * f2), (int) ((95 + this.m.getY() + (15 * i4)) * f2), -1);
            }
        }
        guiGraphics.pose().scale(1.0f / 0.5f, 1.0f / 0.5f, 1.0f / 0.5f);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean a(int i, int i2, int i3) {
        if (!w()) {
            return false;
        }
        IntListIterator it = this.n.iterator();
        while (it.hasNext()) {
            AbstractWidget abstractWidgetG = this.q.g(((Integer) it.next()).intValue());
            if (abstractWidgetG != null && abstractWidgetG.isHoveredOrFocused()) {
                return false;
            }
        }
        for (int i4 = 0; i4 < 2 && this.j.e(i4); i4++) {
            if (c.a(i - this.m.getX(), (i2 - (15 * i4)) - this.m.getY())) {
                this.g.sendToServer(65536, ((i4 + this.j.b()) << 3) | this.i);
                return true;
            }
        }
        for (int i5 = 0; i5 < 3 && this.k.e(i5); i5++) {
            if (d.a(i - this.m.getX(), (i2 - (15 * i5)) - this.m.getY())) {
                this.g.sendToServer(65535, (a(i5 + this.k.b()) << 3) | this.i);
                return true;
            }
        }
        return false;
    }

    public mctech.blocks.base.a.a.e a() {
        return this.h.b(this.i);
    }

    public int a(int i) {
        List<mctech.blocks.base.a.a.a> listB = b();
        if (i >= listB.size()) {
            return i;
        }
        return this.h.b(listB.get(i));
    }

    public List<mctech.blocks.base.a.a.a> b() {
        return this.h.c();
    }

    public void d() {
        this.g.sendToServer(65538, this.i);
    }

    public void c(int i) {
        this.i = i;
        this.j.d(0);
    }

    public void b(int i, int i2) {
        this.g.sendToServer(65537, ((i + this.j.b()) << 5) | ((i2 & 3) << 3) | this.i);
    }
}
