package mctech.components.a;

import java.util.Arrays;
import java.util.Objects;
import mctech.components.a.P;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/P.class */
public class P<TB extends P<TB>> extends R<P<TB>> {

    @Nullable
    private a<TB> a;
    private Component b;
    private final Vec2i c;
    private final b d;
    private boolean e;
    private boolean f;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/P$a.class */
    public interface a<TB extends P<TB>> {
        void onStateChanged(TB tb);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/P$b.class */
    public interface b {
        boolean isActive();
    }

    public P(@NotNull C0101n c0101n, int i, int i2, int i3, int i4, @NotNull Vec2i vec2i, @NotNull Vec2i vec2i2, @NotNull Vec2i vec2i3, b bVar) {
        super(c0101n, i, i2, i3, i4, vec2i, vec2i3);
        this.c = vec2i2;
        this.d = bVar;
        this.e = bVar.isActive();
        this.f = this.e;
    }

    public P(int i, int i2, @NotNull Vec2i vec2i, @NotNull Vec2i vec2i2, @NotNull Vec2i vec2i3, b bVar) {
        super(i, i2, vec2i, vec2i3);
        this.c = vec2i2;
        this.d = bVar;
        this.e = bVar.isActive();
        this.f = this.e;
    }

    @Override // mctech.components.a.R
    @OnlyIn(Dist.CLIENT)
    public void Z_() {
        super.Z_();
        this.e = !this.e;
        if (this.e != this.f) {
            this.f = this.e;
            if (this.a != null) {
                this.a.onStateChanged(this);
            }
        }
    }

    @Override // mctech.components.a.R
    public Vec2i d() {
        return k() ? super.d() : this.c;
    }

    @Override // mctech.components.a.R
    public Component ab_() {
        return k() ? super.ab_() : this.b;
    }

    public TB a(String str) {
        this.b = Component.literal(str);
        return this;
    }

    public TB a(String str, ChatFormatting... chatFormattingArr) {
        this.b = Component.literal(str).withStyle(chatFormattingArr);
        return this;
    }

    public TB b(String str) {
        this.b = f(str);
        return this;
    }

    public TB a(String str, Object... objArr) {
        this.b = Component.translatable(str, Arrays.stream(objArr).filter(obj -> {
            return !(obj instanceof ChatFormatting);
        }).toArray()).withStyle((ChatFormatting[]) Arrays.stream(objArr).filter(obj2 -> {
            return obj2 instanceof ChatFormatting;
        }).map(obj3 -> {
            return (ChatFormatting) obj3;
        }).toList().toArray(new ChatFormatting[0]));
        return this;
    }

    public TB a(Component component) {
        this.b = component;
        return this;
    }

    public TB a(a<TB> aVar) {
        this.a = aVar;
        return this;
    }

    public Component h() {
        return this.b;
    }

    public Vec2i i() {
        return this.c;
    }

    public b j() {
        return this.d;
    }

    public void a(boolean z) {
        this.e = z;
        this.f = z;
    }

    public boolean k() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof P) {
            return ((P) obj).v().equals(v());
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(v());
    }
}
