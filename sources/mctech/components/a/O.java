package mctech.components.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/O.class */
public class O extends mctech.m.d.a.a {
    private final C0101n a;
    private final InterfaceC0102o b;
    private final Supplier<Integer> c;
    private final Supplier<Integer> d;
    private final List<Supplier<Component>> e;

    @Nullable
    private Supplier<Vec2i> f;
    private boolean g;

    public O(int i, int i2, Supplier<Integer> supplier, Supplier<Integer> supplier2, InterfaceC0102o interfaceC0102o) {
        this(i, i2, supplier, supplier2, interfaceC0102o, C0101n.a);
    }

    public O(int i, int i2, Supplier<Integer> supplier, Supplier<Integer> supplier2, InterfaceC0102o interfaceC0102o, C0101n c0101n) {
        super(new mctech.utils.math.geometry.b(i, i2, C0101n.m.getX(), C0101n.m.getY()));
        this.a = c0101n;
        this.b = interfaceC0102o;
        this.c = supplier;
        this.d = supplier2;
        this.e = new ArrayList();
    }

    public O a(@NotNull Supplier<Component> supplier) {
        this.e.add(supplier);
        return this;
    }

    public O b(@Nullable Supplier<Vec2i> supplier) {
        this.f = supplier;
        return this;
    }

    public O a(boolean z) {
        this.g = z;
        return this;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
    }

    @OnlyIn(Dist.CLIENT)
    private boolean a() {
        return this.c.get().intValue() <= 0;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        guiGraphics.pose().pushPose();
        this.q.c(this.a.a());
        float fClamp = Mth.clamp(this.c.get().intValue() / this.d.get().intValue(), 0.0f, 1.0f);
        float fD = this.f == null ? this.o.d() : this.f.get().getX();
        float fC = this.f == null ? this.o.c() : this.f.get().getY();
        mctech.m.d.a.b bVar = new mctech.m.d.a.b(new mctech.utils.math.geometry.b(this.q.getGuiLeft() + this.o.a(), this.q.getGuiTop() + this.o.b(), (int) fD, (int) fC), new mctech.m.d.a.b.a(2, 1, new Vec2i(0, 108)), this.a);
        if (this.g) {
            bVar.a(guiGraphics);
        }
        bVar.a(guiGraphics, new mctech.utils.math.geometry.b((int) (fD * fClamp), (int) fC, 1, 5), new Vec2i((5 + this.b.tierIndex()) - 1, 108));
        this.q.c();
        guiGraphics.pose().popPose();
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (a(i, i2)) {
            Iterator<Supplier<Component>> it = this.e.iterator();
            while (it.hasNext()) {
                Component component = it.next().get();
                if (component != null) {
                    consumer.accept(component);
                }
            }
        }
    }

    @Override // mctech.m.d.a.a
    public boolean a(int i, int i2) {
        if (this.o != mctech.utils.math.geometry.b.a) {
            if (!this.o.b(this.f == null ? 0 : this.f.get().getX(), this.f == null ? 0 : this.f.get().getY()).a(i, i2)) {
                return false;
            }
        }
        return true;
    }
}
