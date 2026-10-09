package mctech.g.a.c;

import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/c/g.class */
@ApiStatus.Experimental
public interface g extends c {
    boolean e();

    boolean f();

    DyeColor g();

    DyeColor h();

    default boolean a(b bVar) {
        return e();
    }

    default boolean b(b bVar) {
        return f();
    }

    @Override // mctech.g.a.c.c
    default boolean ac_() {
        return e() || f();
    }
}
