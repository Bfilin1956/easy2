package mctech.g.c.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.v.l;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.items.IItemHandler;
import org.apache.commons.lang3.NotImplementedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2i;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/d.class */
public class d extends mctech.g.b.a<mctech.g.d.a.c.a> {
    public static final int[] b = {-5505147, -12982403, -15429238};
    public static final ResourceLocation c = MCTech.loc("textures/conduit/conduit.png");
    public static final int d = 228;
    public static final int e = 209;
    private final b f;
    private final a<?> g;
    private final List<Runnable> h;

    public d(mctech.g.d.a.c.a aVar, Inventory inventory, Component component) {
        super(aVar, inventory, component);
        this.f = new b();
        this.h = new ArrayList();
        this.a = false;
        this.imageWidth = d;
        this.imageHeight = e;
        this.g = new a<>((mctech.g.a.a) ((mctech.g.d.a.c.a) this.menu).d().value());
    }

    protected void init() {
        super.init();
        this.h.clear();
        if (this.g.a()) {
            this.g.a(this.f);
        }
        for (int i = 0; i < 9; i++) {
            mctech.g.d.a.c.a aVar = (mctech.g.d.a.c.a) this.menu;
            Objects.requireNonNull(aVar);
            Supplier supplier = aVar::d;
            mctech.g.d.a.c.a aVar2 = (mctech.g.d.a.c.a) this.menu;
            Objects.requireNonNull(aVar2);
            addRenderableWidget(new e(getGuiLeft() + 224, getGuiTop() + 16 + (19 * i), i, supplier, aVar2::e, num -> {
                a(0 + num.intValue());
            }));
        }
    }

    @Override // mctech.g.b.a
    public void render(@NotNull GuiGraphics guiGraphics, int i, int i2, float f) {
        this.h.forEach((v0) -> {
            v0.run();
        });
        super.render(guiGraphics, i, i2, f);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.commons.lang3.NotImplementedException */
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int i2) throws NotImplementedException {
        guiGraphics.blit(c, getGuiLeft(), getGuiTop(), 0, 0, this.imageWidth, this.imageHeight);
        Holder<mctech.g.a.a<?, ?>> holderD = ((mctech.g.d.a.c.a) this.menu).d();
        int i3 = 0;
        while (i3 < ((mctech.g.a.a) holderD.value()).k()) {
            Vector2i vector2iA = ((mctech.g.a.a) holderD.value()).a(i3);
            boolean z = i3 == 1;
            if (holderD.value() instanceof mctech.g.d.a.d.g.a) {
                z = !z;
            }
            guiGraphics.blit(c, (getGuiLeft() + vector2iA.x()) - 1, (getGuiTop() + vector2iA.y()) - 1, z ? 85 : 103, 229, 18, 18);
            i3++;
        }
    }

    @Override // mctech.g.b.a
    protected void renderLabels(@NotNull GuiGraphics guiGraphics, int i, int i2) {
        super.renderLabels(guiGraphics, i, i2);
        if (this.g.a()) {
            a(guiGraphics);
            this.g.a(guiGraphics, i, i2, getGuiLeft(), getGuiTop());
        } else {
            guiGraphics.drawString(this.font, "Error: No screen type defined", 22, 11, -43213, false);
        }
    }

    private void a(GuiGraphics guiGraphics) {
        MutableComponent mutableComponentLiteral = Component.literal(((a) this.g).b.a().b().copy().getString().toUpperCase(Locale.ROOT));
        int iWidth = this.font.width(mutableComponentLiteral);
        l.a(this, guiGraphics, this.font, mutableComponentLiteral, (int) ((26.0f + (174 / 2.0f)) - ((iWidth * Math.min(1.0f, 174 / iWidth)) / 2.0f)), 6, b);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/d$a.class */
    private class a<U extends mctech.g.a.c.c> {
        private final mctech.g.a.j.a<U> b;

        @Nullable
        private final mctech.g.a.j.c<U> c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(mctech.g.a.a<?, U> aVar) {
            this.b = a(((mctech.g.d.a.c.a) d.this.menu).b(), aVar);
            this.c = mctech.g.c.a.b.a.a(aVar.d());
        }

        public boolean a() {
            return this.c != null;
        }

        public void a(b bVar) {
            if (this.c != null) {
                this.c.a(bVar, d.this.getGuiLeft(), d.this.getGuiTop(), this.b);
            }
        }

        public void a(GuiGraphics guiGraphics, int i, int i2, int i3, int i4) {
            if (this.c != null) {
                this.c.a(this.b, guiGraphics, d.this.font, i, i2, i3, i4);
            }
        }

        private <T extends mctech.g.a.a<T, U>, U extends mctech.g.a.c.c> mctech.g.a.j.a<U> a(final BlockPos blockPos, final mctech.g.a.a<T, U> aVar) {
            return (mctech.g.a.j.a<U>) new mctech.g.a.j.a<U>() { // from class: mctech.g.c.a.d.a.1
                @Override // mctech.g.a.j.a
                public mctech.g.a.a<?, U> a() {
                    return aVar;
                }

                @Override // mctech.g.a.j.a
                public BlockPos b() {
                    return blockPos;
                }

                @Override // mctech.g.a.j.a
                public U c() {
                    return (U) ((mctech.g.d.a.c.a) d.this.menu).a(aVar.f());
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // mctech.g.a.j.a
                public void a(Function<U, U> function) {
                    ((mctech.g.d.a.c.a) d.this.menu).a((mctech.g.a.c.c) function.apply(((mctech.g.d.a.c.a) d.this.menu).a(aVar.f())));
                }

                @Override // mctech.g.a.j.a
                public CompoundTag d() {
                    return ((mctech.g.d.a.c.a) d.this.menu).i();
                }
            };
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/d$b.class */
    private class b implements mctech.g.a.j.b {
        private b() {
        }

        @Override // mctech.g.a.j.b
        public mctech.g.b.b.d a(int i, int i2, Supplier<Boolean> supplier, Consumer<Boolean> consumer) {
            mctech.g.b.b.d dVarA = mctech.g.b.b.d.a(i, i2, supplier, consumer);
            a(dVarA);
            return dVarA;
        }

        @Override // mctech.g.a.j.b
        public mctech.g.c.a.c.b a(int i, int i2, Component component, Supplier<DyeColor> supplier, Consumer<DyeColor> consumer) {
            mctech.g.c.a.c.b bVar = new mctech.g.c.a.c.b(i, i2, supplier, consumer, component);
            a(bVar);
            return bVar;
        }

        @Override // mctech.g.a.j.b
        public mctech.g.c.a.c.c b(int i, int i2, Component component, Supplier<mctech.g.a.f.a> supplier, Consumer<mctech.g.a.f.a> consumer) {
            mctech.g.c.a.c.c cVar = new mctech.g.c.a.c.c(i, i2, supplier, consumer, component);
            a(cVar);
            return cVar;
        }

        @Override // mctech.g.a.j.b
        public mctech.g.b.b.c a(int i, int i2, int i3, int i4, Component component, ResourceLocation resourceLocation, Runnable runnable) {
            mctech.g.b.b.c cVar = new mctech.g.b.b.c(i, i2, i3, i4, resourceLocation, component, runnable);
            a(cVar);
            return cVar;
        }

        @Override // mctech.g.a.j.b
        public mctech.g.b.b.d a(int i, int i2, int i3, int i4, Component component, Component component2, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, Supplier<Boolean> supplier, Consumer<Boolean> consumer) {
            mctech.g.b.b.d dVarA = mctech.g.b.b.d.a(i, i2, i3, i4, resourceLocation, resourceLocation2, component, component2, supplier, consumer);
            a(dVarA);
            return dVarA;
        }

        @Override // mctech.g.a.j.b
        public AbstractWidget a(int i, int i2, int i3) {
            mctech.g.b.b.c cVarA = a(i, i2, 10, 10, Component.empty(), d.c, () -> {
                ((mctech.g.d.a.c.a) d.this.menu).a(i3);
            }).a(67, 235);
            cVarA.setTooltip(Tooltip.create(Component.literal("Нажмите чтобы настроить фильтр")));
            a(() -> {
                IItemHandler iItemHandlerF = ((mctech.g.d.a.c.a) d.this.menu).f();
                cVarA.visible = (iItemHandlerF == null || iItemHandlerF.getStackInSlot(i3).getCapability(mctech.g.a.d.f) == null) ? false : true;
            });
            return cVarA;
        }

        @Override // mctech.g.a.j.b
        public void a(Runnable runnable) {
            d.this.h.add(runnable);
        }

        @Override // mctech.g.a.j.b
        public <W extends GuiEventListener & NarratableEntry> W b(W w) {
            return (W) d.this.addWidget(w);
        }

        @Override // mctech.g.a.j.b
        public <W extends Renderable> W a(W w) {
            return (W) d.this.addRenderableOnly(w);
        }

        @Override // mctech.g.a.j.b
        public <W extends GuiEventListener & Renderable & NarratableEntry> W a(W w) {
            return (W) d.this.addRenderableWidget(w);
        }

        @Override // mctech.g.a.j.b
        public void c(GuiEventListener guiEventListener) {
            d.this.removeWidget(guiEventListener);
        }
    }
}
