package mctech.utils.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Supplier;
import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.network.RegistryFriendlyByteBuf;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a/i.class */
public class i<T extends INetworkDataBuffer> implements INetworkDataBuffer {
    Collection<T> a;
    Supplier<T> b;

    public i(Collection<T> collection, Supplier<T> supplier) {
        this.a = collection;
        this.b = supplier;
    }

    public static <T extends INetworkDataBuffer> i<T> a(Supplier<T> supplier) {
        return a((Collection) b.i(), (Supplier) supplier);
    }

    public static <T extends INetworkDataBuffer> i<T> b(Supplier<T> supplier) {
        return a((Collection) b.g(), (Supplier) supplier);
    }

    public static <T extends INetworkDataBuffer> i<T> c(Supplier<T> supplier) {
        return a((Collection) b.h(), (Supplier) supplier);
    }

    public static <T extends INetworkDataBuffer> i<T> a(boolean z, Supplier<T> supplier) {
        return a((Collection) (z ? b.i() : b.h()), (Supplier) supplier);
    }

    public static <T extends INetworkDataBuffer> i<T> a(Collection<T> collection, Supplier<T> supplier) {
        return new i<>(collection, supplier);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeInt(this.a.size());
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().write(registryFriendlyByteBuf);
        }
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.a.clear();
        int i = registryFriendlyByteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            T t = this.b.get();
            t.read(registryFriendlyByteBuf);
            this.a.add(t);
        }
    }

    public boolean a() {
        return this.a.isEmpty();
    }

    public int b() {
        return this.a.size();
    }

    public void c() {
        this.a.clear();
    }

    public boolean a(T t) {
        return this.a.contains(t);
    }

    public boolean b(T t) {
        return this.a.add(t);
    }

    public boolean c(T t) {
        return this.a.remove(t);
    }

    public Collection<T> d() {
        return this.a;
    }

    public <K extends Collection<T>> K e() {
        return this.a;
    }

    public <K extends Collection<T>> K a(Class<K> cls) {
        return this.a;
    }
}
