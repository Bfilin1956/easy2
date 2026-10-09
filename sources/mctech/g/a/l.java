package mctech.g.a;

import mctech.MCTech;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.RegistryBuilder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/l.class */
public class l {
    public static final Registry<m<?>> a = new RegistryBuilder(a.c).sync(true).create();
    public static final Registry<mctech.g.f.d<?>> b = new RegistryBuilder(a.a).sync(true).create();
    public static final Registry<k<?>> c = new RegistryBuilder(a.b).sync(true).create();
    public static final Registry<mctech.g.a.c.e<?>> d = new RegistryBuilder(a.e).sync(true).create();
    public static final Registry<mctech.g.a.h.d<?>> e = new RegistryBuilder(a.d).sync(true).create();

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/l$a.class */
    public static class a {
        public static final ResourceKey<Registry<mctech.g.f.d<?>>> a = a("conduit_data_type");
        public static final ResourceKey<Registry<k<?>>> b = a("conduit_network_context_type");
        public static final ResourceKey<Registry<m<?>>> c = a("conduit_type");
        public static final ResourceKey<Registry<mctech.g.a.h.d<?>>> d = a("conduit_node_data_type");
        public static final ResourceKey<Registry<mctech.g.a.c.e<?>>> e = a("conduit_connection_config_type");
        public static final ResourceKey<Registry<mctech.g.a.a<?, ?>>> f = a("conduit");

        private static <T> ResourceKey<Registry<T>> a(String str) {
            return ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str));
        }
    }
}
