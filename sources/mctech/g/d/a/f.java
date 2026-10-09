package mctech.g.d.a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import mctech.g.a.l;
import mctech.g.a.m;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/f.class */
@EventBusSubscriber
public class f {
    private static final List<Holder<mctech.g.a.a<?, ?>>> a = new ArrayList();

    @SubscribeEvent
    public static void a(ServerStartedEvent serverStartedEvent) {
        a((Registry<mctech.g.a.a<?, ?>>) serverStartedEvent.getServer().registryAccess().registryOrThrow(l.a.f));
    }

    @SubscribeEvent
    public static void a(ClientPlayerNetworkEvent.LoggingIn loggingIn) {
        a((Registry<mctech.g.a.a<?, ?>>) loggingIn.getPlayer().registryAccess().registryOrThrow(l.a.f));
    }

    private static void a(Registry<mctech.g.a.a<?, ?>> registry) {
        a.clear();
        List list = l.a.stream().sorted(Comparator.comparing(mVar -> {
            return ((ResourceLocation) Objects.requireNonNull(l.a.getKey(mVar))).toString();
        })).toList();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(a(registry, (m) it.next()));
        }
        a.addAll(arrayList);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [mctech.g.d.a.f$1] */
    private static <T extends mctech.g.a.a<T, ?>> List<Holder<mctech.g.a.a<?, ?>>> a(Registry<mctech.g.a.a<?, ?>> registry, m<T> mVar) {
        return registry.holders().filter(reference -> {
            return ((mctech.g.a.a) reference.value()).d() == mVar;
        }).sorted(new Comparator<Holder<mctech.g.a.a<?, ?>>>() { // from class: mctech.g.d.a.f.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Holder<mctech.g.a.a<?, ?>> holder, Holder<mctech.g.a.a<?, ?>> holder2) {
                return ((mctech.g.a.a) holder.value()).compareTo((mctech.g.a.a) holder2.value());
            }
        }.thenComparing((v0) -> {
            return v0.getRegisteredName();
        })).map(reference2 -> {
            return reference2;
        }).toList();
    }

    public static int a(Holder<mctech.g.a.a<?, ?>> holder) {
        return a.indexOf(holder);
    }
}
