package mctech.components.a;

import java.util.function.Consumer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.components.a.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/q.class */
@OnlyIn(Dist.CLIENT)
public class C0104q extends Button implements mctech.m.d.b.b {
    static final Button.OnPress a = button -> {
    };
    boolean b;
    boolean c;
    boolean d;
    boolean e;
    TextureAtlasSprite[] f;
    Component g;
    Button.OnPress h;

    public C0104q(int i, int i2, int i3, int i4, Component component, boolean z) {
        super(i, i2, i3, i4, component, a, DEFAULT_NARRATION);
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.h = null;
        this.b = z;
    }

    public C0104q a(TextureAtlasSprite[] textureAtlasSpriteArr) {
        if (textureAtlasSpriteArr.length != 2) {
            return this;
        }
        this.f = textureAtlasSpriteArr;
        return this;
    }

    public C0104q a(boolean z) {
        this.c = z;
        return this;
    }

    public C0104q b(boolean z) {
        this.e = z;
        return this;
    }

    public C0104q c(boolean z) {
        this.d = z;
        return this;
    }

    public C0104q a(Component component) {
        this.g = component;
        return this;
    }

    public C0104q a(String str, Object... objArr) {
        return a((Component) Component.translatable(str, objArr));
    }

    public C0104q a(String str) {
        return a((Component) Component.translatable(str));
    }

    public boolean a() {
        return this.b;
    }

    public C0104q d(boolean z) {
        this.b = z;
        return this;
    }

    public C0104q a(Button.OnPress onPress) {
        this.h = onPress;
        return this;
    }

    public void onPress() {
        this.b = !this.b;
        if (this.h != null) {
            this.h.onPress(this);
        }
    }

    public void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.visible) {
        }
    }

    @Override // mctech.m.d.b.b
    public void a(mctech.m.d.b bVar, int i, int i2, Consumer<Component> consumer) {
        if (isHoveredOrFocused() && this.visible && this.g != null) {
            consumer.accept(this.g);
        }
    }
}
