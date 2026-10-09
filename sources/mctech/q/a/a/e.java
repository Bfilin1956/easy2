package mctech.q.a.a;

import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.network.RegistryFriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/a/a/e.class */
public class e implements INetworkDataBuffer {
    int a;
    String b;

    public e() {
    }

    public e(int i, String str) {
        this.a = i;
        this.b = str;
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeVarInt(this.a);
        registryFriendlyByteBuf.writeUtf(this.b);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.a = registryFriendlyByteBuf.readVarInt();
        this.b = registryFriendlyByteBuf.readUtf();
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }
}
