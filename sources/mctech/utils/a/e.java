package mctech.utils.a;

import java.util.Map;
import java.util.function.Function;
import mctech.MCTech;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a/e.class */
public class e<K, P, V extends Function<P, K>> extends j<V> {
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

    public boolean b(Class<?> cls) {
        return this.a.containsKey(cls);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a/e$a.class */
    public static class a<K, P, J, V extends Function<P, K>, M extends Function<J, K>> extends e<K, P, Function<P, K>> {
        Map<ResourceLocation, M> b = b.f();

        public void a(ResourceLocation resourceLocation, V v, M m, Class<? extends K> cls) {
            super.a(resourceLocation, v, cls);
            this.b.put(resourceLocation, m);
        }

        @Override // mctech.utils.a.e
        @Deprecated
        public void a(ResourceLocation resourceLocation, Function<P, K> function, Class<? extends K> cls) {
            MCTech.LOGGER.info("Invalid Function Please use the other function");
        }

        @Override // mctech.utils.a.e, mctech.utils.a.j
        @Deprecated
        public void a(ResourceLocation resourceLocation, Function<P, K> function) {
            MCTech.LOGGER.info("Invalid Function Please use the other function");
        }

        public M a(ResourceLocation resourceLocation) {
            return this.b.get(resourceLocation);
        }
    }
}
