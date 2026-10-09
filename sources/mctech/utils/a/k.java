package mctech.utils.a;

import java.util.Map;
import java.util.function.Supplier;
import mctech.MCTech;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a/k.class */
public class k<K, V extends Supplier<K>> extends j<V> {
    Map<Class<?>, ResourceLocation> a = b.f();

    public void a(ResourceLocation resourceLocation, V v, Class<? extends K> cls) {
        super.a(resourceLocation, v);
        this.a.put(cls, resourceLocation);
    }

    @Override // mctech.utils.a.j
    @Deprecated
    public void a(ResourceLocation resourceLocation, V v) {
        MCTech.LOGGER.info("Invalid Function Please use the other function");
    }

    public ResourceLocation a(K k) {
        return a(k.getClass());
    }

    public ResourceLocation a(Class<?> cls) {
        return this.a.get(cls);
    }

    public boolean b(K k) {
        return this.a.containsKey(k.getClass());
    }
}
