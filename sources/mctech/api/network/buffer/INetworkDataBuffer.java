package mctech.api.network.buffer;

import net.minecraft.network.RegistryFriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/network/buffer/INetworkDataBuffer.class */
public interface INetworkDataBuffer {
    void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf);

    void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf);
}
