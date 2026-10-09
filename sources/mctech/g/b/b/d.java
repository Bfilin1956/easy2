package mctech.g.b.b;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import mctech.utils.c.h;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/b/d.class */
public class d extends b {
    private final Supplier<Boolean> a;
    private final Consumer<Boolean> b;
    private boolean c;

    @Nullable
    private Function<Boolean, Component> d;
    private final Function<Boolean, ResourceLocation> e;

    @Nullable
    private Function<Boolean, Vec2i> f;
    private Vec2i g;

    public d(int i, int i2, int i3, int i4, Function<Boolean, ResourceLocation> function, @Nullable Function<Boolean, Component> function2, Supplier<Boolean> supplier, Consumer<Boolean> consumer) {
        super(i, i2, i3, i4, Component.empty());
        this.g = new Vec2i(h.i, h.i);
        this.e = function;
        this.d = function2;
        this.a = supplier;
        this.b = consumer;
        if (function2 != null) {
            setTooltip(Tooltip.create(function2.apply(supplier.get())));
        }
    }

    public d a(Function<Boolean, Vec2i> function) {
        return a(function, new Vec2i(h.i, h.i));
    }

    public d a(Function<Boolean, Vec2i> function, Vec2i vec2i) {
        this.f = function;
        this.g = vec2i;
        return this;
    }

    public d b(Function<Boolean, Component> function) {
        this.d = function;
        setTooltip(Tooltip.create(function.apply(this.a.get())));
        return this;
    }

    public static d a(int i, int i2, int i3, int i4, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, Component component, Component component2, Supplier<Boolean> supplier, Consumer<Boolean> consumer) {
        return new d(i, i2, i3, i4, bool -> {
            return bool.booleanValue() ? resourceLocation : resourceLocation2;
        }, bool2 -> {
            return bool2.booleanValue() ? component : component2;
        }, supplier, consumer);
    }

    public static d a(int i, int i2, int i3, int i4, ResourceLocation resourceLocation, Supplier<Boolean> supplier, Consumer<Boolean> consumer) {
        return new d(i, i2, i3, i4, bool -> {
            return resourceLocation;
        }, null, supplier, consumer);
    }

    public static d a(int i, int i2, Supplier<Boolean> supplier, Consumer<Boolean> consumer) {
        return new d(i, i2, 16, 16, bool -> {
            return null;
        }, null, supplier, consumer);
    }

    @Override // mctech.g.b.b.b
    public void b() {
        this.b.accept(Boolean.valueOf(!this.a.get().booleanValue()));
        if (this.d != null) {
            setTooltip(Tooltip.create(this.d.apply(this.a.get())));
        }
    }

    @Override // mctech.g.b.b.b
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        boolean zBooleanValue = this.a.get().booleanValue();
        ResourceLocation resourceLocationApply = this.e.apply(this.a.get());
        if (resourceLocationApply != null) {
            if (this.f != null) {
                Vec2i vec2iApply = this.f.apply(this.a.get());
                guiGraphics.blit(resourceLocationApply, getX(), getY(), this.width, this.height, vec2iApply.getX(), vec2iApply.getY(), this.width, this.height, this.g.getX(), this.g.getY());
            } else {
                guiGraphics.blit(resourceLocationApply, getX(), getY(), this.width, this.height, 0.0f, 0.0f, this.width, this.height, this.width, this.height);
            }
        } else {
            guiGraphics.blit(MissingTextureAtlasSprite.getLocation(), getX(), getY(), this.width, this.height, 0.0f, 0.0f, this.width, this.height, this.width, this.height);
        }
        if (this.d != null && this.c != zBooleanValue) {
            this.c = zBooleanValue;
            setTooltip(Tooltip.create(this.d.apply(this.a.get())));
        }
    }

    @Override // mctech.g.b.b.b
    protected void renderWidget(GuiGraphics guiGraphics, int i, int i2, float f) {
        guiGraphics.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        a(guiGraphics, i, i2, f);
        a(guiGraphics, i, i2);
    }

    protected void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
    }
}
