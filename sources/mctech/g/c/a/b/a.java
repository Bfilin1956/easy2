package mctech.g.c.a.b;

import java.util.Map;
import mctech.g.a.m;
import net.neoforged.fml.ModLoader;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/a/b/a.class */
public class a {
    private static Map<m<?>, mctech.g.a.j.c<?>> a;

    public static void a() {
        mctech.g.a.j.e eVar = new mctech.g.a.j.e();
        ModLoader.postEvent(eVar);
        a = Map.copyOf(eVar.a());
    }

    @Nullable
    public static <T extends mctech.g.a.a<T, U>, U extends mctech.g.a.c.c> mctech.g.a.j.c<U> a(m<T> mVar) {
        return (mctech.g.a.j.c) a.get(mVar);
    }
}
