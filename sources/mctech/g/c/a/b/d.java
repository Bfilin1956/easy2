package mctech.g.c.a.b;

import mctech.init.MCTechLang;
import mctech.utils.math.geometry.Vec2i;
import mctech.v.l;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/b/d.class */
public class d extends mctech.g.a.j.d<mctech.g.d.a.d.e.b> {
    @Override // mctech.g.a.j.d, mctech.g.a.j.c
    public void a(mctech.g.a.j.a<mctech.g.d.a.d.e.b> aVar, GuiGraphics guiGraphics, int i, int i2, Font font, int i3, int i4, int i5, int i6) {
        super.a(aVar, guiGraphics, i, i2, font, i3, i4, i5, i6);
        l.a(guiGraphics, font, (Component) Component.literal(String.format("Приоритет: %s", Integer.valueOf(((mctech.g.d.a.d.e.b) aVar.c()).m()))), i5, i6, i + 80, i2 + 77, mctech.g.c.a.d.b);
        l.a(guiGraphics, font, (Component) Component.literal("Распр.:"), i5, i6, i + 105 + 62, i2 + 24, mctech.g.c.a.d.b);
        l.a(guiGraphics, font, (Component) Component.literal("Ре-импорт:"), i5, i6, i + 105 + 62, i2 + 35, mctech.g.c.a.d.b);
        l.a(guiGraphics, font, (Component) Component.literal("Режим работы:"), i5, i6, i + 105 + 75, i2 + 77, mctech.g.c.a.d.b);
    }

    private int a() {
        if (Screen.hasControlDown()) {
            return 100;
        }
        if (Screen.hasShiftDown()) {
            return 10;
        }
        return 1;
    }

    @Override // mctech.g.a.j.d
    public void c(mctech.g.a.j.b bVar, int i, int i2, mctech.g.a.j.a<mctech.g.d.a.d.e.b> aVar) {
        super.c(bVar, i, i2, aVar);
        bVar.a(i + 2, i2 + 9, Component.literal("Канал импорта"), () -> {
            return ((mctech.g.d.a.d.e.b) aVar.c()).g();
        }, dyeColor -> {
            aVar.a(bVar2 -> {
                return bVar2.a(dyeColor);
            });
        });
        bVar.a(i + 83, i2 + 71, 9, 9, Component.empty(), mctech.g.c.a.d.c, () -> {
            aVar.a(bVar2 -> {
                return bVar2.a(bVar2.m() + a());
            });
        }).a(67, 247).setTooltip(Tooltip.create(Component.literal("Нажмите вместе с\n").append(Component.literal("Ctrl").withStyle(ChatFormatting.GREEN)).append(" - чтобы x100\n").append(Component.literal("Shift").withStyle(ChatFormatting.AQUA)).append(" - чтобы x10")));
        bVar.a(i + 83, i2 + 80, 9, 9, Component.empty(), mctech.g.c.a.d.c, () -> {
            aVar.a(bVar2 -> {
                return bVar2.a(bVar2.m() - a());
            });
        }).a(76, 247).setTooltip(Tooltip.create(Component.literal("Нажмите вместе с\n").append(Component.literal("Ctrl").withStyle(ChatFormatting.GREEN)).append(" - чтобы x100\n").append(Component.literal("Shift").withStyle(ChatFormatting.AQUA)).append(" - чтобы x10")));
        bVar.a(i + 80, i2 + 22, 1);
    }

    @Override // mctech.g.a.j.d
    public void d(mctech.g.a.j.b bVar, int i, int i2, mctech.g.a.j.a<mctech.g.d.a.d.e.b> aVar) {
        super.d(bVar, i, i2, aVar);
        bVar.a((i + 92) - 15, i2 + 9, Component.literal("Канал экспорта"), () -> {
            return ((mctech.g.d.a.d.e.b) aVar.c()).h();
        }, dyeColor -> {
            aVar.a(bVar2 -> {
                return bVar2.b(dyeColor);
            });
        });
        bVar.a(mctech.g.b.b.d.a((i + 92) - 28, i2 + 25, 26, 7, mctech.g.c.a.d.c, () -> {
            return Boolean.valueOf(((mctech.g.d.a.d.e.b) aVar.c()).k());
        }, bool -> {
            aVar.a(bVar2 -> {
                return bVar2.c(bool.booleanValue());
            });
        }).a(bool2 -> {
            return new Vec2i(53, bool2.booleanValue() ? 221 : mctech.g.c.a.d.d);
        }).b(bool3 -> {
            return Component.literal("Равномерное распределение: ").append(this.j.apply(bool3));
        }));
        bVar.a(mctech.g.b.b.d.a((i + 92) - 28, i2 + 36, 26, 7, mctech.g.c.a.d.c, () -> {
            return Boolean.valueOf(((mctech.g.d.a.d.e.b) aVar.c()).l());
        }, bool4 -> {
            aVar.a(bVar2 -> {
                return bVar2.d(bool4.booleanValue());
            });
        }).a(bool5 -> {
            return new Vec2i(53, bool5.booleanValue() ? 221 : mctech.g.c.a.d.d);
        }).b(bool6 -> {
            return Component.literal("Ре-импорт: ").append(this.j.apply(bool6));
        }));
        mctech.g.c.a.c.b bVarA = bVar.a((i + 92) - 11, (i2 + 75) - 11, MCTechLang.GUI_REDSTONE_CHANNEL, () -> {
            return ((mctech.g.d.a.d.e.b) aVar.c()).j();
        }, dyeColor2 -> {
            aVar.a(bVar2 -> {
                return bVar2.c(dyeColor2);
            });
        }).a(9, 9);
        bVar.a(() -> {
            bVarA.visible = ((mctech.g.d.a.d.e.b) aVar.c()).i().a();
        });
        bVar.b((i + 92) - 13, i2 + 75, MCTechLang.GUI_REDSTONE_MODE, () -> {
            return ((mctech.g.d.a.d.e.b) aVar.c()).i();
        }, aVar2 -> {
            aVar.a(bVar2 -> {
                return bVar2.a(aVar2);
            });
        });
        bVar.a(i + 2, i2 + 22, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.g.a.j.d
    public mctech.g.d.a.d.e.b a(mctech.g.d.a.d.e.b bVar, boolean z) {
        return bVar.a(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.g.a.j.d
    public mctech.g.d.a.d.e.b b(mctech.g.d.a.d.e.b bVar, boolean z) {
        return bVar.b(z);
    }
}
