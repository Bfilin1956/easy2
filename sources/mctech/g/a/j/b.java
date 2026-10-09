package mctech.g.a.j;

import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/j/b.class */
public interface b {
    mctech.g.b.b.d a(int i, int i2, Supplier<Boolean> supplier, Consumer<Boolean> consumer);

    mctech.g.c.a.c.b a(int i, int i2, Component component, Supplier<DyeColor> supplier, Consumer<DyeColor> consumer);

    mctech.g.c.a.c.c b(int i, int i2, Component component, Supplier<mctech.g.a.f.a> supplier, Consumer<mctech.g.a.f.a> consumer);

    mctech.g.b.b.c a(int i, int i2, int i3, int i4, Component component, ResourceLocation resourceLocation, Runnable runnable);

    mctech.g.b.b.d a(int i, int i2, int i3, int i4, Component component, Component component2, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, Supplier<Boolean> supplier, Consumer<Boolean> consumer);

    AbstractWidget a(int i, int i2, int i3);

    void a(Runnable runnable);

    <W extends GuiEventListener & Renderable & NarratableEntry> W a(W w);

    <W extends Renderable> W a(W w);

    <W extends GuiEventListener & NarratableEntry> W b(W w);

    void c(GuiEventListener guiEventListener);
}
