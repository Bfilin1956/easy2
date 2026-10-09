package mctech.q.a.a;

import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/a/a/b.class */
public class b implements INetworkDataBuffer {
    CompoundTag a;

    public b() {
    }

    public b(String str, Tag tag) {
        CompoundTag compoundTag = new CompoundTag();
        this.a = compoundTag;
        compoundTag.put(str, tag);
    }

    public b(CompoundTag compoundTag) {
        this.a = compoundTag;
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeNbt(this.a);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.a = registryFriendlyByteBuf.readNbt();
    }

    public CompoundTag a() {
        return this.a;
    }
}
