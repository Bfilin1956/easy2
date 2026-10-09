package mctech.m.d.a;

import it.unimi.dsi.fastutil.objects.ObjectSortedSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import javax.annotation.Nullable;
import mctech.components.b.g;
import mctech.components.b.j;
import mctech.m.c.r;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/d/a/a.class */
public abstract class a implements mctech.utils.e.b {
    public mctech.utils.math.geometry.b o;

    @OnlyIn(Dist.CLIENT)
    protected mctech.m.d.b q;
    private boolean a = true;
    private boolean b = true;
    public List<a> p = mctech.utils.a.b.i();
    public int r = 0;

    protected abstract void a(Set<EnumC0027a> set);

    public a(mctech.utils.math.geometry.b bVar) {
        this.o = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends a> T g(int i) {
        this.r = i;
        return this;
    }

    protected <T extends a> T a(T t) {
        this.p.add(t);
        return t;
    }

    @OnlyIn(Dist.CLIENT)
    public final void d(mctech.m.d.b bVar) {
        this.q = bVar;
    }

    @OnlyIn(Dist.CLIENT)
    public mctech.m.d.b u() {
        return this.q;
    }

    public mctech.utils.math.geometry.b v() {
        return this.o;
    }

    public boolean r() {
        return this.a;
    }

    public boolean w() {
        return this.b;
    }

    public void a_(boolean z) {
        this.b = z;
    }

    public void d(boolean z) {
        this.a = z;
    }

    public boolean a(int i, int i2) {
        return this.o == mctech.utils.math.geometry.b.a || this.o.a(i, i2);
    }

    public final Set<EnumC0027a> x() {
        ObjectSortedSet objectSortedSetH = mctech.utils.a.b.h();
        a((Set<EnumC0027a>) objectSortedSetH);
        return objectSortedSetH;
    }

    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
    }

    @OnlyIn(Dist.CLIENT)
    public void b(mctech.m.d.b bVar) {
    }

    @OnlyIn(Dist.CLIENT)
    public void b(GuiGraphics guiGraphics, int i, int i2, float f) {
    }

    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
    }

    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
    }

    @OnlyIn(Dist.CLIENT)
    public void c(GuiGraphics guiGraphics, int i, int i2, float f) {
    }

    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
    }

    @OnlyIn(Dist.CLIENT)
    public boolean a(int i, int i2, int i3) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean c(int i, int i2, int i3) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean d(int i, int i2, int i3) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean b(int i, int i2, int i3) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean b_(int i) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean a(char c, int i) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    public void X_() {
    }

    @OnlyIn(Dist.CLIENT)
    public void a(@Nullable Slot slot, ItemStack itemStack, List<Component> list) {
    }

    @OnlyIn(Dist.CLIENT)
    protected final void a(DyeColor dyeColor, AbstractWidget abstractWidget, boolean z, Consumer<DyeColor> consumer) {
        g gVar = (g) ((mctech.m.d.a) this.q).a(g.class);
        if (gVar == null || gVar.f()) {
            if (Screen.hasControlDown()) {
                consumer.accept(r.b(dyeColor, z));
                return;
            } else {
                consumer.accept(r.a(dyeColor, z));
                return;
            }
        }
        gVar.a(j.b(abstractWidget.getX() - this.q.getGuiLeft(), abstractWidget.getY() - this.q.getGuiTop(), abstractWidget.getWidth(), abstractWidget.getHeight(), z ? r.s : r.t, itemStack -> {
        }));
    }

    protected final boolean y() {
        return mctech.s.d.a().c();
    }

    protected final boolean z() {
        return mctech.s.d.a().d();
    }

    /* JADX INFO: renamed from: mctech.m.d.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/d/a/a$a.class */
    public enum EnumC0027a implements mctech.utils.a.b.InterfaceC0041b {
        GUI_INIT(0),
        GUI_TICK(1),
        GUI_CLOSE(2),
        DRAW_BACKGROUND_PRE(3),
        DRAW_BACKGROUND(4),
        DRAW_FOREGROUND(5),
        DRAW_POST(6),
        TOOLTIP(7),
        MOUSE_INPUT(8),
        MOUSE_SCROLL(9),
        KEY_INPUT(10),
        ITEM_TOOLTIP(11);

        int m;

        EnumC0027a(int i) {
            this.m = i;
        }

        @Override // mctech.utils.a.b.InterfaceC0041b
        public int a() {
            return this.m;
        }
    }
}
