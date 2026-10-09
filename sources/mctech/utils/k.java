package mctech.utils;

import java.util.function.Supplier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/k.class */
public class k {

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/k$a.class */
    @FunctionalInterface
    public interface a {
        Object a();
    }

    /* JADX INFO: renamed from: mctech.utils.k$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/k$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Dist.values().length];

        static {
            try {
                a[Dist.CLIENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Dist.DEDICATED_SERVER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static <T> T a(Supplier<Supplier<T>> supplier, Supplier<Supplier<T>> supplier2) {
        switch (AnonymousClass1.a[FMLEnvironment.dist.ordinal()]) {
            case 1:
                return supplier.get().get();
            case 2:
                return supplier2.get().get();
            default:
                throw new IllegalArgumentException("UNSIDED?");
        }
    }
}
