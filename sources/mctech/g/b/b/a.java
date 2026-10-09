package mctech.g.b.b;

import com.mojang.blaze3d.systems.RenderSystem;
import java.lang.Enum;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2i;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/b/a.class */
public abstract class a<T extends Enum<T>> extends mctech.g.b.b.b {
    private final Class<T> a;
    private final Supplier<T> b;
    private final Consumer<T> c;
    private final boolean d;
    private T e;
    private final Map<T, a<T>.b> f;
    private final Vector2i g;
    private final Vector2i h;
    private static final int i = 5;
    private static final int j = 4;
    private int k;
    private final C0008a l;
    private final Component m;

    @Nullable
    public abstract Component a(T t);

    public abstract ResourceLocation b(T t);

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public a(int i2, int i3, int i4, int i5, Class<T> cls, Supplier<T> supplier, Consumer<T> consumer, boolean z, Component component) {
        super(i2, i3, i4, i5, Component.empty());
        this.f = new HashMap();
        this.k = 0;
        this.a = cls;
        this.b = supplier;
        this.c = consumer;
        this.d = z;
        this.m = component;
        Enum[] enumArrA = a();
        Vector2i vector2iA = a(enumArrA[0], enumArrA.length);
        Vector2i vector2iAdd = new Vector2i(i4, i5).add(4, 4);
        for (int i6 = 0; i6 < enumArrA.length; i6++) {
            Enum r0 = enumArrA[i6];
            a<T>.b bVar = new b(new Vector2i(vector2iA.x() + (a(i6) * vector2iAdd.x()) + i2, vector2iA.y() + (b(i6) * vector2iAdd.y()) + i3), i4 + 2, i5 + 2, r0);
            Component componentA = a(r0);
            if (componentA != null) {
                bVar.setTooltip(Tooltip.create(componentA));
            }
            this.f.put((T) r0, bVar);
        }
        Vector2i vector2i = new Vector2i(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Vector2i vector2i2 = new Vector2i(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (a<T>.b bVar2 : this.f.values()) {
            Vector2i vector2i3 = new Vector2i(Math.min(vector2i.x(), bVar2.getX()), vector2i.y());
            vector2i = new Vector2i(vector2i3.x(), Math.min(vector2i3.y(), bVar2.getY()));
            Vector2i vector2i4 = new Vector2i(Math.max(vector2i2.x(), bVar2.getX() + bVar2.getWidth()), vector2i2.y());
            vector2i2 = new Vector2i(vector2i4.x(), Math.max(vector2i4.y(), bVar2.getY() + bVar2.getHeight()));
        }
        this.g = vector2i.sub(4, 4);
        this.h = vector2i2.add(4, 4);
        this.l = new C0008a(this);
        e(d());
    }

    public T[] a() {
        return this.a.getEnumConstants();
    }

    public int c(T t) {
        int i2 = 0;
        for (Enum r0 : a()) {
            if (r0 == t) {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    private T d() {
        return this.b.get();
    }

    private void d(T t) {
        this.c.accept(t);
        e(d());
    }

    private Vector2i a(T t, int i2) {
        return new Vector2i((-((Math.min(i2, 5) - 1) * (getWidth() + 4))) / 2, 8 + getHeight());
    }

    public boolean mouseClicked(double d, double d2, int i2) {
        this.k = i2;
        return super.mouseClicked(d, d2, i2);
    }

    protected boolean isValidClickButton(int i2) {
        return i2 == 0 || i2 == 1;
    }

    @Override // mctech.g.b.b.b
    public void b() {
        if (c()) {
            a(this.k != 1);
            return;
        }
        if (this.d) {
            a(this.k != 1);
        }
        Minecraft.getInstance().pushGuiLayer(this.l);
    }

    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        if (d4 > 0.0d) {
            a(false);
            return true;
        }
        if (d4 < 0.0d) {
            a(true);
            return true;
        }
        return super.mouseScrolled(d, d2, d3, d4);
    }

    private void a(boolean z) {
        Enum[] enumArrA = a();
        d(enumArrA[((c(d()) + (z ? 1 : -1)) + enumArrA.length) % enumArrA.length]);
        playDownSound(Minecraft.getInstance().getSoundManager());
    }

    private static int a(int i2) {
        return i2 % 5;
    }

    private static int b(int i2) {
        return i2 / 5;
    }

    @Override // mctech.g.b.b.b
    public void a(GuiGraphics guiGraphics, int i2, int i3, float f) {
        T t = (T) d();
        guiGraphics.blit(b(t), getX(), getY(), getWidth(), getHeight(), 0.0f, 0.0f, getWidth(), getHeight(), getWidth(), getHeight());
        if (this.e != t) {
            this.e = t;
            e(t);
        }
    }

    private void e(T t) {
        MutableComponent mutableComponentAppend;
        Component componentA = a(t);
        if (componentA != null) {
            mutableComponentAppend = this.m.copy().append("\n").append(componentA.copy().withStyle(ChatFormatting.GRAY));
        } else {
            mutableComponentAppend = this.m;
        }
        setTooltip(Tooltip.create(mutableComponentAppend));
    }

    public void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
    }

    public boolean c() {
        return Minecraft.getInstance().screen instanceof C0008a;
    }

    /* JADX INFO: renamed from: mctech.g.b.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/b/a$a.class */
    private static class C0008a extends Screen {
        private final a<?> a;

        protected C0008a(a<?> aVar) {
            super(Component.empty());
            this.a = aVar;
        }

        protected void init() {
            addWidget(this.a);
            ((a) this.a).f.values().forEach(guiEventListener -> {
                this.addRenderableWidget(guiEventListener);
            });
        }

        public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
            RenderSystem.disableDepthTest();
            super.render(guiGraphics, i, i2, f);
            RenderSystem.enableDepthTest();
        }

        public void renderBackground(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
            Vector2i vector2i = ((a) this.a).g;
            Vector2i vector2i2 = ((a) this.a).h;
            guiGraphics.fill(vector2i.x(), vector2i.y(), vector2i2.x(), vector2i2.y(), -11184811);
            guiGraphics.fill(vector2i.x(), vector2i.y(), vector2i2.x() - 1, vector2i2.y() - 1, -11184811);
            guiGraphics.fill(vector2i.x() + 1, vector2i.y() + 1, vector2i2.x(), vector2i2.y(), -8816263);
            guiGraphics.fill(vector2i.x() + 1, vector2i.y() + 1, vector2i2.x() - 1, vector2i2.y() - 1, -15000805);
        }

        public void renderTransparentBackground(@NotNull GuiGraphics guiGraphics) {
        }

        public boolean mouseClicked(double d, double d2, int i) {
            if ((((a) this.a).g.x() > d || ((a) this.a).h.x() < d || ((a) this.a).g.y() > d2 || ((a) this.a).h.y() < d2) && !this.a.isMouseOver(d, d2)) {
                Minecraft.getInstance().popGuiLayer();
            }
            return super.mouseClicked(d, d2, i);
        }

        public boolean isPauseScreen() {
            return false;
        }

        public void onClose() {
            super.onClose();
            if (this.minecraft != null) {
                this.minecraft.popGuiLayer();
            }
        }

        public void resize(Minecraft minecraft, int i, int i2) {
            minecraft.popGuiLayer();
            if (minecraft.screen != null) {
                minecraft.screen.resize(minecraft, i, i2);
            }
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/b/a$b.class */
    private class b extends mctech.g.b.b.b {
        private final T b;
        private final int c;
        private final int d;

        b(Vector2i vector2i, int i, int i2, T t) {
            super(vector2i.x(), vector2i.y(), i, i2, Component.empty());
            this.b = t;
            this.c = i;
            this.d = i2;
        }

        @Override // mctech.g.b.b.b
        public void b() {
            a.this.d(this.b);
        }

        public void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
        }

        @Override // mctech.g.b.b.b
        public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
            guiGraphics.blit(a.this.b(this.b), getX(), getY(), this.c, this.d, 0.0f, 0.0f, this.c, this.d, this.c, this.d);
        }
    }
}
