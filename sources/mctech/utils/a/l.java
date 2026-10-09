package mctech.utils.a;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.function.BiConsumer;
import java.util.function.Function;
import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.network.RegistryFriendlyByteBuf;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a/l.class */
public class l<K> extends ObjectArrayList<K> implements INetworkDataBuffer {
    private static final long d = 1;
    BiConsumer<K, RegistryFriendlyByteBuf> b;
    Function<RegistryFriendlyByteBuf, K> c;

    public l(BiConsumer<K, RegistryFriendlyByteBuf> biConsumer, Function<RegistryFriendlyByteBuf, K> function) {
        this.b = biConsumer;
        this.c = function;
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeVarInt(this.size);
        for (int i = 0; i < this.size; i++) {
            this.b.accept((K) get(i), registryFriendlyByteBuf);
        }
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        clear();
        int varInt = registryFriendlyByteBuf.readVarInt();
        for (int i = 0; i < varInt; i++) {
            add(this.c.apply(registryFriendlyByteBuf));
        }
    }
}
