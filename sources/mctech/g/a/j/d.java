package mctech.g.a.j;

import java.util.function.Function;
import mctech.g.a.c.g;
import mctech.utils.math.geometry.Vec2i;
import mctech.v.l;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/j/d.class */
public abstract class d<U extends g> extends c<U> {
    private static final Component l = Component.literal("Импорт");
    private static final Component m = Component.literal("Экспорт");
    protected static final int e = 92;
    protected static final int f = 90;
    protected static final int g = 105;
    protected Component h = l;
    protected Component i = m;
    protected Function<Boolean, Component> j = bool -> {
        return a("вкл", "выкл", bool.booleanValue());
    };
    protected Function<Boolean, Component> k = bool -> {
        return a("да", "нет", bool.booleanValue());
    };

    protected abstract U a(U u, boolean z);

    protected abstract U b(U u, boolean z);

    @Override // mctech.g.a.j.c
    protected void b(b bVar, int i, int i2, a<U> aVar) {
        c(bVar, i, i2, aVar);
        d(bVar, i + g, i2, aVar);
    }

    public void c(b bVar, int i, int i2, a<U> aVar) {
        bVar.a(mctech.g.b.b.d.a((i + 46) - 26, i2 + 11, 53, 9, mctech.g.c.a.d.c, () -> {
            return Boolean.valueOf(a((g) aVar.c()));
        }, bool -> {
            aVar.a(gVar -> {
                return a(gVar, bool.booleanValue());
            });
        }).a(bool2 -> {
            return new Vec2i(0, bool2.booleanValue() ? 221 : 230);
        })).b(bool3 -> {
            return Component.literal("").append(a("Импорт включен", "Импорт выключен", bool3.booleanValue())).append(", нажмите чтобы ").append(a("включить", "выключить", !bool3.booleanValue()));
        });
    }

    public void d(b bVar, int i, int i2, a<U> aVar) {
        bVar.a(mctech.g.b.b.d.a((i + 46) - 26, i2 + 11, 53, 9, mctech.g.c.a.d.c, () -> {
            return Boolean.valueOf(b((g) aVar.c()));
        }, bool -> {
            aVar.a(gVar -> {
                return b(gVar, bool.booleanValue());
            });
        }).a(bool2 -> {
            return new Vec2i(0, bool2.booleanValue() ? 221 : 230);
        })).b(bool3 -> {
            return Component.literal("").append(a("Экспорт включен", "Экспорт выключен", bool3.booleanValue())).append(", нажмите чтобы ").append(a("включить", "выключить", !bool3.booleanValue()));
        });
    }

    public boolean a(U u) {
        return u.e();
    }

    public boolean b(U u) {
        return u.f();
    }

    @Override // mctech.g.a.j.c
    public void a(a<U> aVar, GuiGraphics guiGraphics, int i, int i2, Font font, int i3, int i4, int i5, int i6) {
        super.a(aVar, guiGraphics, i, i2, font, i3, i4, i5, i6);
        int iWidth = font.width(this.h);
        int i7 = (i + 46) - (iWidth / 2);
        int iWidth2 = ((i + g) + 46) - (font.width(this.i) / 2);
        l.c(guiGraphics, font, this.h, i5, i6, i7, i2, mctech.g.c.a.d.b);
        l.c(guiGraphics, font, this.i, i5, i6, iWidth2, i2, mctech.g.c.a.d.b);
    }

    protected Component a(String str, String str2, boolean z) {
        return z ? Component.literal(str).withStyle(ChatFormatting.DARK_GREEN) : Component.literal(str2).withStyle(ChatFormatting.DARK_RED);
    }
}
