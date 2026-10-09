package mctech.h.b.d;

import com.google.gson.TypeAdapter;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/b/d/b.class */
public class b {
    private static final Map<ResourceLocation, TypeAdapter<?>> a = new HashMap();

    public static void a(ResourceLocation resourceLocation, TypeAdapter<?> typeAdapter) {
        a.put(resourceLocation, typeAdapter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> TypeAdapter<T> a(ResourceLocation resourceLocation) {
        return a.get(resourceLocation);
    }

    public static boolean b(ResourceLocation resourceLocation) {
        return a.containsKey(resourceLocation);
    }
}
