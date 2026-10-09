package mctech.g.c.a.b;

import mctech.utils.math.geometry.Vec2i;
import mctech.v.l;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/b/e.class */
public class e extends mctech.g.a.j.d<mctech.g.d.a.d.g.b> {
    public e() {
        this.h = Component.literal("Экспорт");
        this.i = Component.literal("Импорт");
    }

    @Override // mctech.g.a.j.d, mctech.g.a.j.c
    public void a(mctech.g.a.j.a<mctech.g.d.a.d.g.b> aVar, GuiGraphics guiGraphics, int i, int i2, Font font, int i3, int i4, int i5, int i6) {
        super.a(aVar, guiGraphics, i, i2, font, i3, i4, i5, i6);
        l.a(guiGraphics, font, (Component) Component.literal("Сигнал:"), i5, i6, i + 62, i2 + 24, mctech.g.c.a.d.b);
    }

    @Override // mctech.g.a.j.d
    public void c(mctech.g.a.j.b bVar, int i, int i2, mctech.g.a.j.a<mctech.g.d.a.d.g.b> aVar) {
        bVar.a(mctech.g.b.b.d.a((i + 46) - 26, i2 + 11, 53, 9, mctech.g.c.a.d.c, () -> {
            return Boolean.valueOf(a((mctech.g.d.a.d.g.b) aVar.c()));
        }, bool -> {
            aVar.a(bVar2 -> {
                return a(bVar2, bool.booleanValue());
            });
        }).a(bool2 -> {
            return new Vec2i(0, bool2.booleanValue() ? 221 : 230);
        })).b(bool3 -> {
            return Component.literal("").append(a("Экспорт включен", "Экспорт выключен", bool3.booleanValue())).append(", нажмите чтобы ").append(a("включить", "выключить", !bool3.booleanValue()));
        });
        bVar.a(i + 2, i2 + 9, Component.literal("Канал экспорта"), () -> {
            return ((mctech.g.d.a.d.g.b) aVar.c()).h();
        }, dyeColor -> {
            aVar.a(bVar2 -> {
                return bVar2.b(dyeColor);
            });
        });
        bVar.a(mctech.g.b.b.d.a((i + 92) - 28, i2 + 25, 26, 7, mctech.g.c.a.d.c, () -> {
            return Boolean.valueOf(((mctech.g.d.a.d.g.b) aVar.c()).i());
        }, bool4 -> {
            aVar.a(bVar2 -> {
                return bVar2.c(bool4.booleanValue());
            });
        }).a(bool5 -> {
            return new Vec2i(53, bool5.booleanValue() ? 221 : mctech.g.c.a.d.d);
        }).b(bool6 -> {
            return Component.literal("Излучает полный сигнал: ").append(this.k.apply(bool6));
        }));
    }

    @Override // mctech.g.a.j.d
    public void d(mctech.g.a.j.b bVar, int i, int i2, mctech.g.a.j.a<mctech.g.d.a.d.g.b> aVar) {
        bVar.a(mctech.g.b.b.d.a((i + 46) - 26, i2 + 11, 53, 9, mctech.g.c.a.d.c, () -> {
            return Boolean.valueOf(b((mctech.g.d.a.d.g.b) aVar.c()));
        }, bool -> {
            aVar.a(bVar2 -> {
                return b(bVar2, bool.booleanValue());
            });
        }).a(bool2 -> {
            return new Vec2i(0, bool2.booleanValue() ? 221 : 230);
        })).b(bool3 -> {
            return Component.literal("").append(a("Импорт включен", "Импорт выключен", bool3.booleanValue())).append(", нажмите чтобы ").append(a("включить", "выключить", !bool3.booleanValue()));
        });
        bVar.a((i + 92) - 15, i2 + 9, Component.literal("Канал импорта"), () -> {
            return ((mctech.g.d.a.d.g.b) aVar.c()).g();
        }, dyeColor -> {
            aVar.a(bVar2 -> {
                return bVar2.a(dyeColor);
            });
        });
    }

    @Override // mctech.g.a.j.d
    public boolean a(mctech.g.d.a.d.g.b bVar) {
        return bVar.f();
    }

    @Override // mctech.g.a.j.d
    public boolean b(mctech.g.d.a.d.g.b bVar) {
        return bVar.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.g.a.j.d
    public mctech.g.d.a.d.g.b a(mctech.g.d.a.d.g.b bVar, boolean z) {
        return bVar.b(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.g.a.j.d
    public mctech.g.d.a.d.g.b b(mctech.g.d.a.d.g.b bVar, boolean z) {
        return bVar.a(z);
    }
}
