package mctech.g.a.b;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.Holder;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/b/a.class */
@ApiStatus.Experimental
public interface a {

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/b/a$c.class */
    public static final class c extends Record implements a {
        private final Holder<mctech.g.a.a<?, ?>> a;

        public c(Holder<mctech.g.a.a<?, ?>> holder) {
            this.a = holder;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "replacedConduit", "FIELD:Lmctech/g/a/b/a$c;->a:Lnet/minecraft/core/Holder;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "replacedConduit", "FIELD:Lmctech/g/a/b/a$c;->a:Lnet/minecraft/core/Holder;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public Holder<mctech.g.a.a<?, ?>> b() {
            return this.a;
        }

        @Override // java.lang.Record
        public String toString() {
            return "Upgrade[" + this.a.getRegisteredName() + "]";
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/b/a$b.class */
    public static final class b implements a {
        public String toString() {
            return "Insert";
        }
    }

    /* JADX INFO: renamed from: mctech.g.a.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/b/a$a.class */
    public static final class C0006a implements a {
        public String toString() {
            return "Blocked";
        }
    }

    default boolean a() {
        return !(this instanceof C0006a);
    }
}
