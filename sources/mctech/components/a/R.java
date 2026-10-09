package mctech.components.a;

import com.mojang.blaze3d.vertex.PoseStack;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import mctech.components.a.R;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/R.class */
public class R<B extends R<B>> extends mctech.m.d.a.a {
    private final C0101n a;
    private Component b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private Vec2i h;
    private Vec2i i;
    private Vec2i j;
    private b<B> k;
    private d<B> l;
    private c<B> m;
    private float n;
    private final List<a> s;
    private long t;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/R$b.class */
    public interface b<B extends R<B>> {
        boolean onPressed(B b);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/R$c.class */
    public interface c<B extends R<B>> {
        void a(B b);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/R$d.class */
    public interface d<B extends R<B>> {
        void onPressed(B b);
    }

    public R(@NotNull C0101n c0101n, int i, int i2, int i3, int i4, @NotNull Vec2i vec2i, @NotNull Vec2i vec2i2, @NotNull Vec2i vec2i3) {
        super(new mctech.utils.math.geometry.b(i, i2, i3, i4));
        this.s = new ArrayList();
        this.t = 0L;
        this.a = c0101n;
        this.h = vec2i;
        this.i = vec2i3;
        this.j = vec2i2;
        this.g = true;
        this.e = true;
        this.c = false;
        this.f = false;
        this.d = false;
        this.n = 0.0f;
    }

    public R(@NotNull C0101n c0101n, int i, int i2, int i3, int i4, @NotNull Vec2i vec2i, @NotNull Vec2i vec2i2) {
        this(c0101n, i, i2, i3, i4, vec2i, vec2i2, C0101n.a.m);
    }

    public R(int i, int i2, @NotNull Vec2i vec2i, @NotNull Vec2i vec2i2) {
        this(C0101n.a, i, i2, C0101n.j.getX(), C0101n.j.getY(), vec2i, vec2i2);
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_TICK);
    }

    @Override // mctech.m.d.a.a
    public void b(mctech.m.d.b bVar) {
        super.b(bVar);
        this.t++;
        if (!this.s.isEmpty()) {
            for (a aVar : new ArrayList(this.s)) {
                if (this.t >= aVar.a) {
                    aVar.b().accept(this);
                    this.s.remove(aVar);
                }
            }
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(this.q.getGuiLeft() + this.o.a() + (this.o.d() / 2.0f), this.q.getGuiTop() + this.o.b() + (this.o.c() / 2.0f), 0.0f);
        poseStackPose.mulPose(new Matrix4f().rotationZ((float) Math.toRadians(this.n)));
        poseStackPose.translate(-(this.q.getGuiLeft() + this.o.a() + (this.o.d() / 2.0f)), -(this.q.getGuiTop() + this.o.b() + (this.o.c() / 2.0f)), 0.0f);
        if (a(i, i2)) {
            this.d = true;
            l();
        } else {
            this.d = false;
        }
        this.q.c(this.a.a());
        if (t()) {
            this.q.b(guiGraphics, (this.q.getGuiLeft() + this.o.a()) - 1, (this.q.getGuiTop() + this.o.b()) - 1, C0101n.a.a.getX(), C0101n.a.a.getY(), C0101n.k.getX(), C0101n.k.getY());
        }
        a(guiGraphics, this.o.a(), this.o.b(), (!p() || e().isEmpty()) ? d().getX() : e().getX(), (!p() || e().isEmpty()) ? d().getY() : e().getY());
        if (q() && !p()) {
            poseStackPose.pushPose();
            poseStackPose.translate(0.0f, 0.0f, 999.0f);
            a(guiGraphics, this.o.a(), this.o.b(), aa_().getX(), aa_().getY());
            poseStackPose.popPose();
        }
        poseStackPose.popPose();
        this.q.c();
    }

    @OnlyIn(Dist.CLIENT)
    private void a(GuiGraphics guiGraphics, int i, int i2, int i3, int i4) {
        this.q.a(guiGraphics, this.q.getGuiLeft() + i, this.q.getGuiTop() + i2, i3, i4, this.o.d(), this.o.c(), this.o.d(), this.o.c(), this.a.b(), this.a.c());
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (a(i, i2) && ab_() != null) {
            consumer.accept(ab_());
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean a(int i, int i2, int i3) {
        if (a(i, i2)) {
            this.c = i3 == 0;
            if (!this.f && this.c) {
                this.f = true;
            }
        }
        return super.a(i, i2, i3);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean d(int i, int i2, int i3) {
        this.c = false;
        if (this.f) {
            Z_();
            this.f = false;
        }
        return super.d(i, i2, i3);
    }

    @OnlyIn(Dist.CLIENT)
    public void Z_() {
        if (this.l != null) {
            this.l.onPressed(this);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void l() {
        if (this.m != null) {
            this.m.a(this);
        }
    }

    public B a(float f) {
        this.n = f;
        return this;
    }

    public B a(@NotNull Vec2i vec2i) {
        this.h = vec2i;
        return this;
    }

    public B b(@NotNull Vec2i vec2i) {
        this.i = vec2i;
        return this;
    }

    public B c(@NotNull Vec2i vec2i) {
        this.j = vec2i;
        return this;
    }

    public B c(@NotNull String str) {
        this.b = Component.literal(str);
        return this;
    }

    public B b(@NotNull String str, ChatFormatting... chatFormattingArr) {
        this.b = Component.literal(str).withStyle(chatFormattingArr);
        return this;
    }

    public B d(@NotNull String str) {
        this.b = f(str);
        return this;
    }

    public B b(@NotNull String str, Object... objArr) {
        this.b = Component.translatable(str, Arrays.stream(objArr).filter(obj -> {
            return !(obj instanceof ChatFormatting);
        }).toArray()).withStyle((ChatFormatting[]) Arrays.stream(objArr).filter(obj2 -> {
            return obj2 instanceof ChatFormatting;
        }).map(obj3 -> {
            return (ChatFormatting) obj3;
        }).toList().toArray(new ChatFormatting[0]));
        return this;
    }

    public B b(Component component) {
        this.b = component;
        return this;
    }

    public B b(boolean z) {
        this.e = z;
        return this;
    }

    public B c(boolean z) {
        this.g = z;
        return this;
    }

    public B a(b<B> bVar) {
        this.k = bVar;
        return this;
    }

    public B a(d<B> dVar) {
        this.l = dVar;
        return this;
    }

    public B a(c<B> cVar) {
        this.m = cVar;
        return this;
    }

    public B a(long j, Consumer<R> consumer) {
        this.s.add(new a(this.t + j, consumer));
        return this;
    }

    public B b(long j, Consumer<R> consumer) {
        m();
        return (B) a(j, consumer);
    }

    public B m() {
        this.s.clear();
        return this;
    }

    public long n() {
        return this.t;
    }

    public boolean o() {
        return !this.s.isEmpty();
    }

    public Component ab_() {
        return this.b;
    }

    public boolean p() {
        return this.k == null ? this.c : this.k.onPressed(this);
    }

    public boolean q() {
        return this.d;
    }

    @Override // mctech.m.d.a.a
    public boolean r() {
        return this.e;
    }

    public boolean s() {
        return this.f;
    }

    public boolean t() {
        return this.g;
    }

    public Vec2i d() {
        return this.h;
    }

    public Vec2i aa_() {
        return this.i;
    }

    public Vec2i e() {
        return this.j;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/R$a.class */
    public static final class a extends Record {
        private final long a;
        private final Consumer<R> b;

        public a(long j, Consumer<R> consumer) {
            this.a = j;
            this.b = consumer;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "time;action", "FIELD:Lmctech/components/a/R$a;->a:J", "FIELD:Lmctech/components/a/R$a;->b:Ljava/util/function/Consumer;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "time;action", "FIELD:Lmctech/components/a/R$a;->a:J", "FIELD:Lmctech/components/a/R$a;->b:Ljava/util/function/Consumer;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "time;action", "FIELD:Lmctech/components/a/R$a;->a:J", "FIELD:Lmctech/components/a/R$a;->b:Ljava/util/function/Consumer;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public long a() {
            return this.a;
        }

        public Consumer<R> b() {
            return this.b;
        }
    }
}
