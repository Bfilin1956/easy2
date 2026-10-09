package mctech.components.a;

import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/z.class */
public class z extends mctech.m.d.a.a {
    private final mctech.blockentities.c.C a;

    public z(mctech.blockentities.c.C c, int i, int i2, int i3, int i4) {
        super(new mctech.utils.math.geometry.b(i, i2, i3, i4));
        this.a = c;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        if (this.a.d().isEmpty()) {
            return;
        }
        ItemStack itemStackD = this.a.d();
        int iA = v().a();
        int iB = v().b();
        if (!itemStackD.isEmpty()) {
            guiGraphics.renderItem(itemStackD, iA + 2, iB + 2);
            this.q.a(guiGraphics, (Component) Component.literal("Требуется: " + a(this.a.b())), iA + 20, iB + 2, -16724741);
        }
        this.q.a(guiGraphics, (Component) Component.literal("Осталось: " + a(this.a.e())), iA + 20, iB + 13, -16724741);
        if (this.a.c() > 0) {
            this.q.a(guiGraphics, (Component) Component.literal(a(this.a.c()) + " EU"), iA + 20, iB + 23, -16724741);
        }
        this.q.b(guiGraphics, (Component) Component.literal(String.format(Locale.ROOT, "%.1f%%", Float.valueOf(this.a.f()))), (v().a() + v().d()) - 20, iB + 9, -16724741);
    }

    @Override // mctech.m.d.a.a
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (i >= v().a() && i <= v().a() + 20 && i2 >= v().b() && i2 <= v().b() + 20) {
            if (this.a.b() > 0) {
                consumer.accept(Component.literal("Требуется: " + this.a.b()));
                consumer.accept(Component.literal("Поглощено: " + this.a.a()));
                consumer.accept(Component.literal("Осталось: " + this.a.e()));
            }
            if (this.a.c() > 0) {
                consumer.accept(Component.literal("Энергия: " + this.a.c() + " EU"));
            }
        }
    }

    private static String a(long j) {
        if (j < 1000) {
            return String.valueOf(j);
        }
        String[] strArr = {"", "к", "млн", "млрд", "трлн"};
        int i = 0;
        double d = j;
        while (d >= 1000.0d && i < strArr.length - 1) {
            d /= 1000.0d;
            i++;
        }
        if (d >= 100.0d) {
            return String.format(Locale.ROOT, "%.0f%s", Double.valueOf(d), strArr[i]);
        }
        return d >= 10.0d ? String.format(Locale.ROOT, "%.1f%s", Double.valueOf(d), strArr[i]) : String.format(Locale.ROOT, "%.2f%s", Double.valueOf(d), strArr[i]);
    }
}
