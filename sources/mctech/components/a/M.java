package mctech.components.a;

import mctech.components.a.M;
import mctech.utils.math.geometry.Vec2i;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/M.class */
public class M<TRB extends M<TRB>> extends R<M<TRB>> {

    @NotNull
    private final InterfaceC0102o a;

    public M(int i, int i2, @NotNull Vec2i vec2i, @NotNull Vec2i vec2i2, @NotNull InterfaceC0102o interfaceC0102o) {
        super(i, i2, vec2i, vec2i2);
        this.a = interfaceC0102o;
    }

    public M(int i, int i2, int i3, int i4, @NotNull Vec2i vec2i, @NotNull Vec2i vec2i2, @NotNull InterfaceC0102o interfaceC0102o) {
        super(C0101n.a, i, i2, i3, i4, vec2i, vec2i2);
        this.a = interfaceC0102o;
    }

    public M(@NotNull C0101n c0101n, int i, int i2, int i3, int i4, @NotNull Vec2i vec2i, @NotNull Vec2i vec2i2, @NotNull InterfaceC0102o interfaceC0102o) {
        super(c0101n, i, i2, i3, i4, vec2i, vec2i2);
        this.a = interfaceC0102o;
    }

    @Override // mctech.components.a.R
    public Vec2i d() {
        return new Vec2i(this.o.d() * this.a.tierIndex(), super.d().getY());
    }
}
