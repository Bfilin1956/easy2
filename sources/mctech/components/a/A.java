package mctech.components.a;

import java.util.Set;
import java.util.function.Consumer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/A.class */
public class A extends mctech.m.d.a.a {
    private final mctech.blockentities.c.E a;

    public A(mctech.blockentities.c.E e, int i, int i2, int i3, int i4) {
        super(new mctech.utils.math.geometry.b(i, i2, i3, i4));
        this.a = e;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        String str = a(this.a.B() ? (long) this.a.c() : 0L) + " EU";
        double dB = this.a.b() / this.a.c();
        if (Double.isNaN(dB)) {
            dB = 0.0d;
        }
        this.q.a(guiGraphics, (Component) Component.literal(String.format("%.3f", Double.valueOf(dB * 100.0d)) + "%"), v().a() + 44, v().b(), -23717);
        this.q.a(guiGraphics, (Component) Component.literal(str), v().a() + 38, v().b() + 18, -23717);
        this.q.a(guiGraphics, (Component) Component.literal(a(this.a.B() ? (long) this.a.b() : 0L) + " EU"), v().a() + 70, v().b() + 9, -23717);
    }

    @Override // mctech.m.d.a.a
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
    }

    private static String a(long j) {
        return a(j, false);
    }

    private static String a(long j, boolean z) {
        String strReplace;
        if (j < 1000) {
            return String.valueOf(j);
        }
        String[] strArr = {"", "т", "млн", "млрд", "трлн", "кврд", "квинт", "секст", "септ"};
        String[] strArr2 = {"", "тысяч", "миллионов", "миллиардов", "триллионов", "квадриллионов", "квинтиллионов", "секстиллионов", "септиллионов"};
        int i = 0;
        double d = j;
        while (d >= 1000.0d && i < strArr.length - 1) {
            d /= 1000.0d;
            i++;
        }
        if (i == 0) {
            strReplace = "";
        } else if (z) {
            int i2 = (int) (d % 10.0d);
            int i3 = (int) (d % 100.0d);
            if (i3 >= 11 && i3 <= 14) {
                strReplace = strArr2[i];
            } else if (i2 == 1) {
                strReplace = i == 1 ? "тысяча" : strArr2[i].replace("ов", "").replace("иллиард", "иллиард");
            } else if (i2 >= 2 && i2 <= 4) {
                strReplace = i == 1 ? "тысячи" : strArr2[i].replace("ов", "а");
            } else {
                strReplace = strArr2[i];
            }
        } else {
            strReplace = strArr[i];
        }
        return String.format("%.1f %s", Double.valueOf(d), strReplace).trim();
    }
}
