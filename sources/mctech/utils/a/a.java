package mctech.utils.a;

import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.network.RegistryFriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a/a.class */
public class a implements INetworkDataBuffer {
    int[] a = new int[100];
    long b = 0;
    int c;
    int d;
    int e;

    public void a(int i) {
        this.e += i;
    }

    public boolean a() {
        return (this.b == 0 && this.e == 0) ? false : true;
    }

    public void b() {
        int i = this.d + 1;
        this.d = i;
        this.d = i % 100;
        if (this.c < 100) {
            this.c++;
        } else {
            this.b -= (long) this.a[this.d];
        }
        this.a[this.d] = this.e;
        this.b += (long) this.e;
        this.e = 0;
    }

    public int c() {
        if (this.c == 0 || this.b == 0) {
            return 0;
        }
        return (int) (this.b / ((long) this.c));
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeByte((byte) this.c);
        registryFriendlyByteBuf.writeLong(this.b);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.c = registryFriendlyByteBuf.readByte();
        this.b = registryFriendlyByteBuf.readLong();
    }
}
