package mctech.components.b;

import java.util.Set;
import mctech.components.a.C0101n;
import mctech.components.a.K;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.network.PacketDistributor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/x.class */
public class x extends mctech.m.d.a.a implements mctech.m.d.b.a {
    private static final int a = 6000;
    private static final int b = 6001;
    private static final int c = 6002;
    private final mctech.blockentities.p d;
    private final Vec2i e;

    public x(mctech.blockentities.p pVar, Vec2i vec2i) {
        super(new mctech.utils.math.geometry.b((-143) + vec2i.getX(), vec2i.getY(), 143, 67));
        this.d = pVar;
        this.e = vec2i;
        a_(false);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        int guiLeft = bVar.getGuiLeft() + this.o.a() + this.e.getX();
        int guiTop = bVar.getGuiTop() + this.o.b() + this.e.getY();
        bVar.a(c, a(guiLeft + 61, guiTop + 49, 0, 196, button -> {
            a();
        }));
        EditBox editBoxA = bVar.a(a, new EditBox(bVar.j(), guiLeft + 29, guiTop + 14, 105, 16, Component.empty()));
        editBoxA.setBordered(false);
        editBoxA.setCanLoseFocus(true);
        editBoxA.setVisible(false);
        editBoxA.setResponder(str -> {
            EditBox editBoxG = bVar.g(a);
            if (editBoxG instanceof EditBox) {
                editBoxG.setTextColor(!str.isBlank() ? 16777215 : 16733525);
            }
        });
        EditBox editBoxA2 = bVar.a(b, new EditBox(bVar.j(), guiLeft + 29, guiTop + 34, 105, 16, Component.empty()));
        editBoxA2.setBordered(false);
        editBoxA2.setCanLoseFocus(true);
        editBoxA2.setVisible(false);
        editBoxA2.setResponder(str2 -> {
            EditBox editBoxG = bVar.g(b);
            if (editBoxG instanceof EditBox) {
                editBoxG.setTextColor(!str2.isBlank() ? 16777215 : 16733525);
            }
        });
        b(bVar);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void b(mctech.m.d.b bVar) {
        bVar.m().values().stream().filter(abstractWidget -> {
            return !(abstractWidget instanceof w);
        }).forEach(abstractWidget2 -> {
            abstractWidget2.active = w();
            abstractWidget2.visible = w();
        });
    }

    private void a() {
        EditBox editBoxA = this.q.a(a, (Class<EditBox>) EditBox.class);
        EditBox editBoxA2 = this.q.a(b, (Class<EditBox>) EditBox.class);
        String strTrim = editBoxA.getValue().trim();
        String strTrim2 = editBoxA2.getValue().trim();
        if (strTrim.isEmpty() || strTrim2.isEmpty()) {
            return;
        }
        if (FMLEnvironment.dist.isClient()) {
            PacketDistributor.sendToServer(new mctech.q.d.m(this.d.getPosition(), strTrim, strTrim2), new CustomPacketPayload[0]);
        }
        b(this.q);
        this.d.c();
    }

    @Override // mctech.m.d.b.a
    @OnlyIn(Dist.CLIENT)
    public void c(mctech.m.d.b bVar) {
        a_(false);
        b(bVar);
        if (this.q != null) {
            this.q.a(a, EditBox.class).setValue("");
            this.q.a(b, EditBox.class).setValue("");
        }
        this.d.c();
    }

    @Override // mctech.m.d.a.a
    public void a_(boolean z) {
        super.a_(z);
        if (this.q != null) {
            this.q.a(a, EditBox.class).setValue(this.d.a());
            this.q.a(b, EditBox.class).setValue(this.d.b());
        }
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_TICK);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_SCROLL);
        set.add(mctech.m.d.a.a.EnumC0027a.KEY_INPUT);
    }

    @Override // mctech.m.d.a.a
    public boolean a(int i, int i2) {
        return true;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (!w()) {
            return;
        }
        int guiLeft = this.q.getGuiLeft() + this.o.a() + this.e.getX();
        int guiTop = this.q.getGuiTop() + this.o.b() + this.e.getY();
        this.q.c(C0101n.h.a());
        this.q.b(guiGraphics, guiLeft, guiTop, 0.0f, 0.0f, 153.0f, 67.0f);
        this.q.c(C0101n.a.a());
    }

    private K a(int i, int i2, int i3, int i4, Button.OnPress onPress) {
        return new K(i, i2, 49, 9, C0101n.h.a(), new mctech.utils.math.geometry.b(i3, i4, 49, 9), onPress).b(false).a(C0101n.h.b(), C0101n.h.c());
    }
}
