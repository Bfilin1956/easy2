package mctech.g.c.a;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import mctech.MCTech;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/e.class */
public class e extends AbstractButton {
    private final int a;
    private final Supplier<Holder<mctech.g.a.a<?, ?>>> b;
    private final Supplier<List<Holder<mctech.g.a.a<?, ?>>>> c;
    private final Consumer<Integer> d;

    public e(int i, int i2, int i3, Supplier<Holder<mctech.g.a.a<?, ?>>> supplier, Supplier<List<Holder<mctech.g.a.a<?, ?>>>> supplier2, Consumer<Integer> consumer) {
        super(i, i2, 20, 20, Component.empty());
        this.a = i3;
        this.b = supplier;
        this.c = supplier2;
        this.d = consumer;
    }

    @Nullable
    private Holder<mctech.g.a.a<?, ?>> a() {
        List<Holder<mctech.g.a.a<?, ?>>> list = this.c.get();
        if (this.a >= 0 && this.a < list.size()) {
            return list.get(this.a);
        }
        return null;
    }

    protected boolean isValidClickButton(int i) {
        Holder<mctech.g.a.a<?, ?>> holderA = a();
        return (!super.isValidClickButton(i) || holderA == null || holderA == this.b.get()) ? false : true;
    }

    public void onPress() {
        this.d.accept(Integer.valueOf(this.a));
    }

    public void renderWidget(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        Holder<mctech.g.a.a<?, ?>> holderA = a();
        if (holderA == null) {
            return;
        }
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        boolean z = this.b.get() == holderA;
        if (z) {
            guiGraphics.blit(d.c, getX(), getY(), 215, 236, this.width, this.height);
        } else {
            guiGraphics.blit(d.c, getX(), getY(), 236, 236, this.width, this.height);
        }
        ResourceLocation location = MissingTextureAtlasSprite.getLocation();
        if (holderA.value() instanceof mctech.g.d.a.d.e.a) {
            location = MCTech.loc("textures/conduit/conduit_icon/item.png");
        }
        if (holderA.value() instanceof mctech.g.d.a.d.c.a) {
            location = MCTech.loc("textures/conduit/conduit_icon/fluid.png");
        }
        if (holderA.value() instanceof mctech.g.d.a.d.g.a) {
            location = MCTech.loc("textures/conduit/conduit_icon/redstone.png");
        }
        if (holderA.value() instanceof mctech.g.d.a.d.a.a) {
            location = MCTech.loc("textures/conduit/conduit_icon/energy.png");
        }
        if (holderA.value() instanceof mctech.g.d.a.d.f.d) {
            location = MCTech.loc("textures/conduit/conduit_icon/me.png");
        }
        if (holderA.value() instanceof mctech.g.d.a.d.d.a) {
            location = MCTech.loc("textures/conduit/conduit_icon/heat.png");
        }
        guiGraphics.blit(location, getX() + 5, getY() + 5, 10, 10, 10.0f, 10.0f, 10, 10, 10, 10);
        RenderSystem.disableDepthTest();
        RenderSystem.disableBlend();
        if (!z) {
            a(guiGraphics, i, i2);
        }
    }

    protected void a(GuiGraphics guiGraphics, int i, int i2) {
        if (isMouseOver(i, i2)) {
            guiGraphics.pose().pushPose();
            guiGraphics.pose().translate(0.0f, 0.0f, 399.0f);
            guiGraphics.fill(getX() + 2, getY() + 2, getX() + 2 + 1, (getY() + getHeight()) - 2, -1);
            guiGraphics.fill((getX() + getWidth()) - 2, getY() + 2, ((getX() + getWidth()) - 2) - 1, (getY() + getHeight()) - 2, -1);
            guiGraphics.fill(getX() + 2, getY() + 2, (getX() + getWidth()) - 2, getY() + 2 + 1, -1);
            guiGraphics.fill(getX() + 2, ((getY() + getHeight()) - 2) - 1, (getX() + getWidth()) - 2, (getY() + getHeight()) - 2, -1);
            guiGraphics.pose().popPose();
        }
    }

    protected void updateWidgetNarration(@NotNull NarrationElementOutput narrationElementOutput) {
    }
}
