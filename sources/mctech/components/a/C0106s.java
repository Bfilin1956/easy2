package mctech.components.a;

import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;

/* JADX INFO: renamed from: mctech.components.a.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/s.class */
public class C0106s extends EditBox implements mctech.m.d.b.b {
    Consumer<String> a;
    boolean b;
    Component c;
    boolean d;

    public C0106s(int i, int i2, int i3, int i4) {
        this(Minecraft.getInstance().font, i, i2, i3, i4, Component.empty());
    }

    public C0106s(int i, int i2, int i3, int i4, Component component) {
        super(Minecraft.getInstance().font, i, i2, i3, i4, component);
        this.a = null;
        this.b = false;
        this.d = false;
    }

    public C0106s(Font font, int i, int i2, int i3, int i4) {
        this(font, i, i2, i3, i4, Component.empty());
    }

    public C0106s(Font font, int i, int i2, int i3, int i4, Component component) {
        super(font, i, i2, i3, i4, component);
        this.a = null;
        this.b = false;
        this.d = false;
        super.setResponder(this::c);
    }

    public C0106s a(Component component) {
        this.c = component;
        return this;
    }

    public C0106s a(String str, Object... objArr) {
        return a((Component) Component.translatable(str, objArr));
    }

    public C0106s a(String str) {
        return a((Component) Component.translatable(str));
    }

    public C0106s a(boolean z) {
        this.b = z;
        return this;
    }

    public void b(String str) {
        this.d = true;
        setValue(str);
        this.d = false;
    }

    public void setResponder(Consumer<String> consumer) {
        this.a = consumer;
    }

    public void setFocused(boolean z) {
        super.setFocused(z);
        if (!z && !this.b) {
            this.a.accept(getValue());
        }
    }

    public boolean keyPressed(int i, int i2, int i3) {
        if (i == 257) {
            if (this.a != null) {
                this.a.accept(getValue());
            }
            setFocused(false);
            return true;
        }
        return super.keyPressed(i, i2, i3);
    }

    private void c(String str) {
        if (!this.d && this.a != null && !this.b) {
            this.a.accept(str);
        }
    }

    public void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f) {
        super.renderWidget(guiGraphics, i, i2, f);
    }

    @Override // mctech.m.d.b.b
    public void a(mctech.m.d.b bVar, int i, int i2, Consumer<Component> consumer) {
        if (isMouseOver(i, i2) && this.c != null) {
            consumer.accept(this.c);
        }
    }
}
