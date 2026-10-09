package mctech.q;

import mctech.MCTech;
import net.minecraft.network.RegistryFriendlyByteBuf;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/a.class */
public class a {
    public static void a(RegistryFriendlyByteBuf registryFriendlyByteBuf, d.a aVar) {
        Object obj = aVar.d;
        if (obj == null) {
            mctech.q.b.b.a(registryFriendlyByteBuf, null, aVar.e, aVar.f);
            return;
        }
        mctech.q.b.a<?> aVarA = aVar.f != null ? aVar.f : mctech.q.b.b.a(obj.getClass());
        if (aVarA == null) {
            MCTech.LOGGER.warn("Failed to encode {}, cause {} is unknown type", aVar.c, obj.getClass().getName());
            mctech.q.b.b.a(registryFriendlyByteBuf, null, aVar.e, null);
        } else {
            mctech.q.b.b.a(registryFriendlyByteBuf, obj, aVar.e, aVarA);
        }
    }

    public static Object a(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        return mctech.q.b.b.a(registryFriendlyByteBuf);
    }
}
