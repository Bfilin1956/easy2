package mctech.components.a;

import mctech.utils.math.geometry.Vec2i;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/I.class */
public class I<T> extends P<I<T>> {
    private int a;

    public I(@NotNull C0101n c0101n, int i, int i2, int i3, int i4, @NotNull Vec2i vec2i, @NotNull Vec2i vec2i2, @NotNull Vec2i vec2i3, P.b bVar) {
        super(c0101n, i, i2, i3, i4, vec2i, vec2i2, vec2i3, bVar);
    }

    public I<T> a(int i) {
        this.a = i;
        return this;
    }

    public int f() {
        return this.a;
    }
}
