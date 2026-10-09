package mctech.v.f;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.util.HashSet;
import java.util.Set;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/i.class */
@OnlyIn(Dist.CLIENT)
public final class i {
    public static final Set<g> a = new HashSet();
    private static final Int2ObjectMap<g> b;

    static {
        Int2ObjectOpenHashMap int2ObjectOpenHashMap = new Int2ObjectOpenHashMap();
        for (int i = 0; i < 13; i++) {
            int2ObjectOpenHashMap.put(i + 1, a("item/blade_overlay_" + (i + 1)));
        }
        b = Int2ObjectMaps.unmodifiable(int2ObjectOpenHashMap);
    }

    @NotNull
    private static g a(String str) {
        g gVar = new g(str);
        a.add(gVar);
        return gVar;
    }

    public static g a(@NotNull mctech.items.e.d dVar) {
        return (g) b.get(dVar.a());
    }
}
