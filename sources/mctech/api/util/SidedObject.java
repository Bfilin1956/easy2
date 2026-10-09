package mctech.api.util;

import net.neoforged.fml.util.thread.EffectiveSide;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/util/SidedObject.class */
public class SidedObject<T> {
    T client;
    T server;

    public void set(T t, boolean z) {
        if (z) {
            this.server = t;
        } else {
            this.client = t;
        }
    }

    public T get() {
        return get(isSimulating());
    }

    public T get(boolean z) {
        return z ? this.server : this.client;
    }

    protected boolean isSimulating() {
        return EffectiveSide.get().isServer();
    }
}
