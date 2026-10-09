package mctech.g.c.a.b;

import mctech.init.MCTechLang;
import mctech.v.l;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/b/b.class */
public class b extends mctech.g.a.j.d<mctech.g.d.a.d.a.b> {
    @Override // mctech.g.a.j.d, mctech.g.a.j.c
    public void a(mctech.g.a.j.a<mctech.g.d.a.d.a.b> aVar, GuiGraphics guiGraphics, int i, int i2, Font font, int i3, int i4, int i5, int i6) {
        super.a(aVar, guiGraphics, i, i2, font, i3, i4, i5, i6);
        l.a(guiGraphics, font, (Component) Component.literal(String.format("Приоритет: %s", Integer.valueOf(((mctech.g.d.a.d.a.b) aVar.c()).k()))), i5, i6, i + 80, i2 + 77, mctech.g.c.a.d.b);
    }

    @Override // mctech.g.a.j.d
    public void c(mctech.g.a.j.b bVar, int i, int i2, mctech.g.a.j.a<mctech.g.d.a.d.a.b> aVar) {
        super.c(bVar, i, i2, aVar);
        bVar.a(i + 83, i2 + 71, 9, 9, Component.empty(), mctech.g.c.a.d.c, () -> {
            aVar.a(bVar2 -> {
                return bVar2.a(bVar2.k() + a());
            });
        }).a(67, 247).setTooltip(Tooltip.create(Component.literal("Нажмите вместе с\n").append(Component.literal("Ctrl").withStyle(ChatFormatting.GREEN)).append(" - чтобы x100\n").append(Component.literal("Shift").withStyle(ChatFormatting.AQUA)).append(" - чтобы x10")));
        bVar.a(i + 83, i2 + 80, 9, 9, Component.empty(), mctech.g.c.a.d.c, () -> {
            aVar.a(bVar2 -> {
                return bVar2.a(bVar2.k() - a());
            });
        }).a(76, 247).setTooltip(Tooltip.create(Component.literal("Нажмите вместе с\n").append(Component.literal("Ctrl").withStyle(ChatFormatting.GREEN)).append(" - чтобы x100\n").append(Component.literal("Shift").withStyle(ChatFormatting.AQUA)).append(" - чтобы x10")));
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
    public void d(mctech.g.a.j.b bVar, int i, int i2, mctech.g.a.j.a<mctech.g.d.a.d.a.b> aVar) {
        super.d(bVar, i, i2, aVar);
        mctech.g.c.a.c.b bVarA = bVar.a((i + 92) - 11, (i2 + 75) - 11, MCTechLang.GUI_REDSTONE_CHANNEL, () -> {
            return ((mctech.g.d.a.d.a.b) aVar.c()).j();
        }, dyeColor -> {
            aVar.a(bVar2 -> {
                return bVar2.a(dyeColor);
            });
        }).a(9, 9);
        bVar.a(() -> {
            bVarA.visible = ((mctech.g.d.a.d.a.b) aVar.c()).i().a();
        });
        bVar.b((i + 92) - 13, i2 + 75, MCTechLang.GUI_REDSTONE_MODE, () -> {
            return ((mctech.g.d.a.d.a.b) aVar.c()).i();
        }, aVar2 -> {
            aVar.a(bVar2 -> {
                return bVar2.a(aVar2);
            });
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.g.a.j.d
    public mctech.g.d.a.d.a.b a(mctech.g.d.a.d.a.b bVar, boolean z) {
        return bVar.a(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mctech.g.a.j.d
    public mctech.g.d.a.d.a.b b(mctech.g.d.a.d.a.b bVar, boolean z) {
        return bVar.b(z);
    }
}
