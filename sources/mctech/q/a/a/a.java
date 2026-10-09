package mctech.q.a.a;

import it.unimi.dsi.fastutil.longs.LongArrayList;
import it.unimi.dsi.fastutil.longs.LongList;
import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.network.RegistryFriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/a/a/a.class */
public class a implements INetworkDataBuffer {
    LongList a;
    int b;

    public a() {
        this.a = new LongArrayList();
    }

    public a(LongList longList, int i) {
        this.a = new LongArrayList();
        this.a = longList;
        this.b = i;
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeInt(this.a.size());
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            registryFriendlyByteBuf.writeLong(this.a.getLong(i));
        }
        registryFriendlyByteBuf.writeInt(this.b);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        int i = registryFriendlyByteBuf.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.a.add(registryFriendlyByteBuf.readLong());
        }
        this.b = registryFriendlyByteBuf.readInt();
    }

    public int a() {
        return this.b;
    }

    public LongList b() {
        return this.a;
    }
}
