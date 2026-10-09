package mctech.g.a;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/i.class */
public interface i {
    int a();

    boolean b();

    boolean a(mctech.g.a.h.a aVar);

    Set<? extends mctech.g.a.h.a> c();

    Set<? extends mctech.g.a.h.a> b(mctech.g.a.h.a aVar);

    Collection<? extends mctech.g.a.h.a> d();

    Collection<? extends mctech.g.a.h.a> e();

    Collection<mctech.g.a.c.a> f();

    List<mctech.g.a.c.a> a(mctech.g.a.c.a aVar);

    Set<DyeColor> g();

    List<mctech.g.a.c.a> h();

    List<mctech.g.a.c.a> a(DyeColor dyeColor);

    List<mctech.g.a.c.a> b(mctech.g.a.c.a aVar);

    List<mctech.g.a.c.a> i();

    List<mctech.g.a.c.a> b(DyeColor dyeColor);

    List<mctech.g.a.c.a> c(mctech.g.a.c.a aVar);

    boolean a(k<?> kVar);

    @Nullable
    <T extends j<T>> T b(k<T> kVar);

    <T extends j<T>> T c(k<T> kVar);
}
