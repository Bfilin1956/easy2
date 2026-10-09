package mctech.components;

import java.util.Set;
import mctech.components.a.C0101n;
import mctech.m.b.C0140am;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/E.class */
public class E extends mctech.m.d.a.a {
    private mctech.blockentities.b.g a;
    private C0140am b;

    public E(mctech.blockentities.b.g gVar, C0140am c0140am) {
        super(mctech.utils.math.geometry.b.a);
        this.a = gVar;
        this.b = c0140am;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_TICK);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        int guiLeft = bVar.getGuiLeft();
        int guiTop = bVar.getGuiTop();
        bVar.a(0, new mctech.components.a.L(guiLeft + 22, guiTop + 56, 10, 10, C0101n.a.a(), 0, 0, button -> {
            this.a.sendToServer(0, 0);
        }));
        bVar.a(1, new mctech.components.a.L(guiLeft + 22, guiTop + 45, 10, 10, C0101n.a.a(), 0, 0, button2 -> {
            this.a.sendToServer(0, 1);
        }));
        bVar.a(2, new mctech.components.a.L(guiLeft + 40, guiTop + 28, 57, 14, C0140am.a, 455, 0, button3 -> {
            this.a.sendToServer(1, 0);
        }) { // from class: mctech.components.E.1
            @Override // mctech.components.a.L
            public void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f) {
                guiGraphics.blit(C0140am.a, getX(), getY(), 0, 455.0f, E.this.a.c ? 14.0f : 0.0f, getWidth(), getHeight(), mctech.q.c.c, mctech.utils.c.h.i);
                if (isHovered()) {
                    guiGraphics.blit(C0140am.a, getX(), getY(), 0, 455.0f, 42.0f, getWidth(), getHeight(), mctech.q.c.c, mctech.utils.c.h.i);
                }
            }
        });
        bVar.a(3, new mctech.components.a.L(this, guiLeft + 183, guiTop + 28, 57, 14, C0140am.a, 455, 0, button4 -> {
            this.a.sendToServer(2, 0);
        }) { // from class: mctech.components.E.2
            @Override // mctech.components.a.L
            public void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f) {
                guiGraphics.blit(C0140am.a, getX(), getY(), 0, 455.0f, 28.0f, getWidth(), getHeight(), mctech.q.c.c, mctech.utils.c.h.i);
                if (isHovered()) {
                    guiGraphics.blit(C0140am.a, getX(), getY(), 0, 455.0f, 42.0f, getWidth(), getHeight(), mctech.q.c.c, mctech.utils.c.h.i);
                }
            }
        });
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void b(mctech.m.d.b bVar) {
        super.b(bVar);
        this.b.c();
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        MutableComponent mutableComponentLiteral;
        if (this.a.d) {
            mutableComponentLiteral = Component.literal("ВЗРЫВ!").withColor(-65536);
        } else {
            mutableComponentLiteral = Component.literal(String.valueOf((int) this.a.e) + " EU");
        }
        this.q.b(guiGraphics, (Component) mutableComponentLiteral, 140, 31, -1);
    }
}
