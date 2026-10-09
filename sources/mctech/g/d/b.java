package mctech.g.d;

import java.util.function.BiPredicate;
import mctech.g.a.m;
import net.minecraft.core.Holder;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/b.class */
@ApiStatus.Experimental
public class b {
    public static boolean a(Holder<mctech.g.a.a<?, ?>> holder, Holder<mctech.g.a.a<?, ?>> holder2) {
        return a(((mctech.g.a.a) holder.value()).d(), holder, holder2, (v0, v1) -> {
            return v0.b(v1);
        });
    }

    public static boolean b(Holder<mctech.g.a.a<?, ?>> holder, Holder<mctech.g.a.a<?, ?>> holder2) {
        return a(((mctech.g.a.a) holder.value()).d(), holder, holder2, (v0, v1) -> {
            return v0.a(v1);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <TConduit extends mctech.g.a.a<TConduit, ?>> boolean a(m<TConduit> mVar, Holder<mctech.g.a.a<?, ?>> holder, Holder<mctech.g.a.a<?, ?>> holder2, BiPredicate<TConduit, TConduit> biPredicate) {
        if (((mctech.g.a.a) holder.value()).d() != ((mctech.g.a.a) holder2.value()).d()) {
            return false;
        }
        return biPredicate.test((mctech.g.a.a) holder.value(), (mctech.g.a.a) holder2.value());
    }
}
