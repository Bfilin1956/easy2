package mctech.components;

import com.mojang.blaze3d.platform.Lighting;
import it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import mctech.MCTech;
import mctech.components.a.C0104q;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.components.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/j.class */
public class C0116j extends mctech.m.d.a.a {
    public static final int a = 0;
    public static final int b = mctech.utils.math.a.e;
    public static final int c = mctech.utils.math.a.n;
    public static final int d = mctech.utils.math.a.n(-1);
    public static final mctech.utils.math.geometry.b e = new mctech.utils.math.geometry.b(104, 32, 12, 156);
    public static final mctech.utils.math.geometry.b f = new mctech.utils.math.geometry.b(225, 32, 12, 156);
    public static final mctech.utils.math.geometry.b g = new mctech.utils.math.geometry.b(0, 241, 12, 15);
    boolean h;
    boolean i;
    mctech.m.f.b j;
    mctech.components.b.q k;
    mctech.components.b.q l;

    public C0116j(mctech.m.f.b bVar) {
        super(mctech.utils.math.geometry.b.a);
        this.h = false;
        this.i = false;
        this.k = ((mctech.components.b.q) a(new mctech.components.b.q(e, g).a(5))).a(MCTech.loc("textures/gui/container/gui_electric_reader.png"));
        this.l = ((mctech.components.b.q) a(new mctech.components.b.q(f, g).a(5))).a(MCTech.loc("textures/gui/container/gui_electric_reader.png"));
        this.j = bVar;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_SCROLL);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
    }

    @Override // mctech.m.d.a.a
    public boolean a(int i, int i2) {
        return true;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        int guiLeft = bVar.getGuiLeft();
        int guiTop = bVar.getGuiTop();
        bVar.addRenderableWidget(new C0104q(guiLeft + 5, guiTop + 190, 14, 14, A(), this.h).a("Merge Sources").a(button -> {
            this.h = !this.h;
        }));
        bVar.addRenderableWidget(new C0104q(guiLeft + 126, guiTop + 190, 14, 14, A(), this.i).a("Merge Sinks").a(button2 -> {
            this.i = !this.i;
        }));
    }

    protected List<mctech.m.f.b.C0028b> a() {
        if (!this.h) {
            return this.j.d;
        }
        Object2ObjectSortedMap object2ObjectSortedMapF = mctech.utils.a.b.f();
        int size = this.j.d.size();
        for (int i = 0; i < size; i++) {
            mctech.m.f.b.C0028b c0028b = this.j.d.get(i);
            ObjectArrayList objectArrayList = (List) object2ObjectSortedMapF.get(c0028b.a.getItem());
            if (objectArrayList == null) {
                objectArrayList = new ObjectArrayList();
                object2ObjectSortedMapF.put(c0028b.a.getItem(), objectArrayList);
            }
            objectArrayList.add(c0028b);
        }
        ObjectList objectListI = mctech.utils.a.b.i();
        Iterator it = object2ObjectSortedMapF.values().iterator();
        while (it.hasNext()) {
            objectListI.add(new mctech.m.f.b.C0028b((List) it.next()));
        }
        return objectListI;
    }

    protected List<mctech.m.f.b.a> b() {
        if (!this.i) {
            return this.j.c;
        }
        Object2ObjectSortedMap object2ObjectSortedMapF = mctech.utils.a.b.f();
        int size = this.j.c.size();
        for (int i = 0; i < size; i++) {
            mctech.m.f.b.a aVar = this.j.c.get(i);
            ObjectArrayList objectArrayList = (List) object2ObjectSortedMapF.get(aVar.a.getItem());
            if (objectArrayList == null) {
                objectArrayList = new ObjectArrayList();
                object2ObjectSortedMapF.put(aVar.a.getItem(), objectArrayList);
            }
            objectArrayList.add(aVar);
        }
        ObjectList objectListI = mctech.utils.a.b.i();
        Iterator it = object2ObjectSortedMapF.values().iterator();
        while (it.hasNext()) {
            objectListI.add(new mctech.m.f.b.a((List) it.next()));
        }
        return objectListI;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f2) {
        Lighting.setupForFlatItems();
        List<mctech.m.f.b.C0028b> listA = a();
        List<mctech.m.f.b.a> listB = b();
        this.k.c(listA.size());
        this.l.c(listB.size());
        int iB = this.k.b();
        Lighting.setupFor3DItems();
        for (int i3 = 0; i3 < 5 && i3 + iB < listA.size(); i3++) {
            int i4 = (31 * i3) + 10;
            mctech.m.f.b.C0028b c0028b = listA.get(i3 + iB);
            double dMin = Math.min(1.0d, c0028b.a() / ((double) c0028b.f));
            this.q.a(guiGraphics, this.q.getGuiLeft() + 8, this.q.getGuiTop() + 30 + i4, c0028b.a);
            this.q.a(guiGraphics, this.q.getGuiLeft() + 30, this.q.getGuiTop() + 44 + i4, 60.0f, 9.0f, 0);
            this.q.a(guiGraphics, this.q.getGuiLeft() + 31, this.q.getGuiTop() + 45 + i4, 58.0f, 7.0f, b);
            this.q.a(guiGraphics, this.q.getGuiLeft() + 31, this.q.getGuiTop() + 45 + i4, (int) (58.0d * dMin), 7.0f, c);
            double dMin2 = c0028b.l == 0 ? 0.0d : Math.min(1.0d, ((double) c0028b.k) / ((double) c0028b.l));
            this.q.a(guiGraphics, this.q.getGuiLeft() + 30, this.q.getGuiTop() + 34 + i4, 60.0f, 9.0f, 0);
            this.q.a(guiGraphics, this.q.getGuiLeft() + 31, this.q.getGuiTop() + 35 + i4, 58.0f, 7.0f, b);
            this.q.a(guiGraphics, this.q.getGuiLeft() + 31, this.q.getGuiTop() + 35 + i4, (int) (58.0d * dMin2), 7.0f, c);
            if (i3 != 4) {
                this.q.a(guiGraphics, this.q.getGuiLeft() + 5, this.q.getGuiTop() + 54 + i4, 96.0f, 1.0f, -13158601);
            }
        }
        int iB2 = this.l.b();
        for (int i5 = 0; i5 < 5 && i5 + iB2 < listB.size(); i5++) {
            int i6 = (31 * i5) + 10;
            mctech.m.f.b.a aVar = listB.get(i5 + iB2);
            double dClamp = Mth.clamp(aVar.a() / (((long) aVar.g) * aVar.b()), 0.0d, 1.0d);
            this.q.a(guiGraphics, this.q.getGuiLeft() + 129, this.q.getGuiTop() + 30 + i6, aVar.a);
            this.q.a(guiGraphics, this.q.getGuiLeft() + 148, this.q.getGuiTop() + 44 + i6, 65.0f, 9.0f, 0);
            this.q.a(guiGraphics, this.q.getGuiLeft() + 149, this.q.getGuiTop() + 45 + i6, 63.0f, 7.0f, b);
            this.q.a(guiGraphics, this.q.getGuiLeft() + 149, this.q.getGuiTop() + 45 + i6, (int) (63.0d * dClamp), 7.0f, c);
            double dMin3 = aVar.k == 0 ? 0.0d : Math.min(1.0d, ((double) aVar.j) / ((double) aVar.k));
            this.q.a(guiGraphics, this.q.getGuiLeft() + 148, this.q.getGuiTop() + 34 + i6, 65.0f, 9.0f, 0);
            this.q.a(guiGraphics, this.q.getGuiLeft() + 149, this.q.getGuiTop() + 35 + i6, 63.0f, 7.0f, b);
            this.q.a(guiGraphics, this.q.getGuiLeft() + 149, this.q.getGuiTop() + 35 + i6, (int) (63.0d * dMin3), 7.0f, c);
            if (i5 != 4) {
                this.q.a(guiGraphics, this.q.getGuiLeft() + 127, this.q.getGuiTop() + 54 + i6, 95.0f, 1.0f, -13158601);
            }
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        DecimalFormat decimalFormat = mctech.utils.D.a;
        List<mctech.m.f.b.C0028b> listA = a();
        this.q.c(guiGraphics, (Component) e(this.k.b() + "/" + Math.max(0, listA.size() - 5)), 117, 22, mctech.utils.math.a.c);
        this.q.a(guiGraphics, (Component) f("gui.mctech.eu_reader.emitter"), 5, 22, mctech.utils.math.a.c);
        int iB = this.k.b();
        for (int i3 = 0; i3 < 5 && i3 + iB < listA.size(); i3++) {
            mctech.m.f.b.C0028b c0028b = listA.get(i3 + iB);
            int i4 = (31 * i3) + 10;
            this.q.b(guiGraphics, (Component) c("misc.mctech.eu", decimalFormat.format(c0028b.f)), 62, 25 + i4, mctech.utils.math.a.c);
            this.q.b(guiGraphics, (Component) c("misc.mctech.eu", decimalFormat.format(c0028b.k)), 62, 35 + i4, mctech.utils.math.a.c);
            this.q.b(guiGraphics, (Component) c("misc.mctech.eu", decimalFormat.format(c0028b.a())), 62, 45 + i4, mctech.utils.math.a.c);
        }
        List<mctech.m.f.b.a> listB = b();
        this.q.c(guiGraphics, (Component) e(this.l.b() + "/" + Math.max(0, listB.size() - 5)), 237, 22, mctech.utils.math.a.c);
        this.q.a(guiGraphics, (Component) f("gui.mctech.eu_reader.receiver"), 126, 22, mctech.utils.math.a.c);
        int iB2 = this.l.b();
        for (int i5 = 0; i5 < 5 && i5 + iB2 < listB.size(); i5++) {
            mctech.m.f.b.a aVar = listB.get(i5 + iB2);
            int i6 = (31 * i5) + 10;
            this.q.b(guiGraphics, (Component) c("misc.mctech.eu", decimalFormat.format(aVar.g)), 180, 25 + i6, mctech.utils.math.a.c);
            this.q.b(guiGraphics, (Component) c("misc.mctech.eu", decimalFormat.format(aVar.j)), 180, 35 + i6, mctech.utils.math.a.c);
            this.q.b(guiGraphics, (Component) c("misc.mctech.eu", decimalFormat.format(aVar.a())), 181, 45 + i6, mctech.utils.math.a.c);
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        DecimalFormat decimalFormat = mctech.utils.D.a;
        List<mctech.m.f.b.C0028b> listA = a();
        int iB = this.k.b();
        for (int i3 = 0; i3 < 5 && i3 + iB < listA.size(); i3++) {
            mctech.m.f.b.C0028b c0028b = listA.get(i3 + iB);
            int i4 = 30 + (31 * i3) + 10;
            if (i >= 8 && i <= 8 + 16 && i2 >= i4 && i2 <= i4 + 16) {
                consumer.accept(c0028b.c);
                if (!this.h) {
                    consumer.accept(c("gui.mctech.eu_reader.position", Integer.valueOf(c0028b.b.getX()), Integer.valueOf(c0028b.b.getY()), Integer.valueOf(c0028b.b.getZ())));
                }
                consumer.accept(c("gui.mctech.eu_reader.power.out", decimalFormat.format(c0028b.a()), Integer.valueOf(c0028b.f)));
                consumer.accept(c("gui.mctech.eu_reader.power.stored", decimalFormat.format(c0028b.k), decimalFormat.format(c0028b.l)));
                consumer.accept(c("gui.mctech.eu_reader.tier", Integer.valueOf(c0028b.g), Integer.valueOf(c0028b.h)));
                consumer.accept(c("gui.mctech.eu_reader.packets.send", Long.valueOf(c0028b.b())));
                if (!this.h) {
                    consumer.accept(f("gui.mctech.eu_reader.highlight"));
                }
            }
        }
        int iB2 = this.l.b();
        List<mctech.m.f.b.a> listB = b();
        for (int i5 = 0; i5 < 5 && i5 + iB2 < listB.size(); i5++) {
            mctech.m.f.b.a aVar = listB.get(i5 + iB2);
            int i6 = 30 + (31 * i5) + 10;
            if (i >= 129 && i <= 129 + 16 && i2 >= i6 && i2 <= i6 + 16) {
                consumer.accept(aVar.c);
                if (!this.i) {
                    consumer.accept(c("gui.mctech.eu_reader.position", Integer.valueOf(aVar.b.getX()), Integer.valueOf(aVar.b.getY()), Integer.valueOf(aVar.b.getZ())));
                }
                consumer.accept(c("gui.mctech.eu_reader.power.in", decimalFormat.format(aVar.a())));
                consumer.accept(c("gui.mctech.eu_reader.power.stored", decimalFormat.format(aVar.j), decimalFormat.format(aVar.k)));
                consumer.accept(c("gui.mctech.eu_reader.tier", Integer.valueOf(aVar.f), Integer.valueOf(aVar.g)));
                consumer.accept(c("gui.mctech.eu_reader.packets.received", Long.valueOf(aVar.b())));
                if (!this.i) {
                    consumer.accept(f("gui.mctech.eu_reader.highlight"));
                }
            }
        }
    }

    @Override // mctech.m.d.a.a
    public boolean a(int i, int i2, int i3) {
        if (!this.h) {
            List<mctech.m.f.b.C0028b> list = this.j.d;
            int iB = this.k.b();
            for (int i4 = 0; i4 < 5 && i4 + iB < list.size(); i4++) {
                int i5 = 40 + (31 * i4);
                if (i >= 8 && i <= 8 + 16 && i2 >= i5 && i2 <= i5 + 16) {
                    mctech.v.j.a.a.a.a(list.get(i4 + iB).b);
                    this.q.getMinecraft().player.closeContainer();
                    return true;
                }
            }
        }
        if (!this.i) {
            List<mctech.m.f.b.a> list2 = this.j.c;
            int iB2 = this.l.b();
            for (int i6 = 0; i6 < 5 && i6 + iB2 < list2.size(); i6++) {
                int i7 = 40 + (31 * i6);
                if (i >= 129 && i <= 129 + 16 && i2 >= i7 && i2 <= i7 + 16) {
                    mctech.v.j.a.a.a.a(list2.get(i6 + iB2).b);
                    this.q.getMinecraft().player.closeContainer();
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
