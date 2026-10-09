package mctech.utils;

import java.util.function.Supplier;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.util.thread.EffectiveSide;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/B.class */
public class B<T> {
    private T a;
    private T b;

    public B(Class<? extends T> cls, Class<? extends T> cls2) {
        try {
            if (FMLEnvironment.dist.isClient()) {
                this.a = cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                this.a = null;
            }
            this.b = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public B(Supplier<? extends T> supplier, Supplier<? extends T> supplier2) {
        this.b = supplier.get();
        if (FMLEnvironment.dist.isClient()) {
            this.a = supplier2.get();
        } else {
            this.a = null;
        }
    }

    public B(String str, String str2) {
        try {
            if (FMLEnvironment.dist.isClient()) {
                this.a = (T) Class.forName(str2).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } else {
                this.a = null;
            }
            this.b = (T) Class.forName(str).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public T a() {
        if (EffectiveSide.get().isClient()) {
            return this.a;
        }
        return this.b;
    }

    public T a(boolean z) {
        if (z) {
            return this.b;
        }
        return this.a;
    }
}
