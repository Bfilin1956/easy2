package mctech.q.a.a;

import java.util.UUID;
import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.network.RegistryFriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/a/a/f.class */
public class f implements INetworkDataBuffer {
    UUID a;
    int b;
    boolean c;

    public f() {
    }

    public f(UUID uuid, int i, boolean z) {
        this.a = uuid;
        this.b = i;
        this.c = z;
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeUUID(this.a);
        registryFriendlyByteBuf.writeVarInt(this.b);
        registryFriendlyByteBuf.writeBoolean(this.c);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.a = registryFriendlyByteBuf.readUUID();
        this.b = registryFriendlyByteBuf.readVarInt();
        this.c = registryFriendlyByteBuf.readBoolean();
    }

    public UUID a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }
}
