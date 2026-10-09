package mctech.q.a.a;

import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.network.RegistryFriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/a/a/c.class */
public class c implements INetworkDataBuffer {
    int[] a;

    public c() {
        this.a = new int[6];
    }

    public c(int[] iArr) {
        this.a = new int[6];
        this.a = iArr;
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        for (int i = 0; i < 6; i++) {
            registryFriendlyByteBuf.writeByte((byte) this.a[i]);
        }
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        for (int i = 0; i < 6; i++) {
            this.a[i] = registryFriendlyByteBuf.readByte();
        }
    }

    public int[] a() {
        return this.a;
    }
}
