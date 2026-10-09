package mctech.g.a.c;

import net.minecraft.core.Direction;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/c/d.class */
public interface d {
    boolean a(Direction direction);

    boolean b(Direction direction);

    c c(Direction direction);

    <T extends c> T a(Direction direction, e<T> eVar);

    void a(Direction direction, c cVar);
}
