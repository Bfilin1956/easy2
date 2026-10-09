package mctech.g.c.b.c;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import mctech.g.a.m;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.neoforged.fml.ModLoader;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/c/a.class */
public class a {
    private static Map<m<?>, mctech.g.a.g.a> a;

    public static void a() {
        mctech.g.a.g.b bVar = new mctech.g.a.g.b();
        ModLoader.postEvent(bVar);
        Map<m<?>, mctech.g.a.g.b.a> mapA = bVar.a();
        a = new HashMap();
        mapA.forEach((mVar, aVar) -> {
            a.put(mVar, aVar.createModifier());
        });
    }

    @Nullable
    public static mctech.g.a.g.a a(m<?> mVar) {
        return a.get(mVar);
    }

    public static Set<ModelResourceLocation> b() {
        return (Set) a.values().stream().flatMap(aVar -> {
            return aVar.a().stream();
        }).collect(Collectors.toSet());
    }
}
