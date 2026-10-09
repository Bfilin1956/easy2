package mctech.d;

import java.util.Iterator;
import mctech.api.util.DirectionList;
import net.minecraft.core.Direction;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/d/d.class */
public interface d<T> extends Iterable<Direction> {
    void a();

    void b();

    void a(Runnable runnable);

    void d();

    T b(Direction direction);

    DirectionList c();

    default boolean e() {
        return c().isEmpty();
    }

    default boolean d(Direction direction) {
        return c().contains(direction);
    }

    @Override // java.lang.Iterable
    default Iterator<Direction> iterator() {
        return c().iterator();
    }
}
