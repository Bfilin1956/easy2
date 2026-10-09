package mctech.m.f;

import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/f/p.class */
public class p extends m implements INetworkDataBuffer {
    private BlockEntity d;

    public p(int i, BlockEntity blockEntity) {
        super(i);
        this.d = blockEntity;
    }

    @Override // mctech.m.f.m, mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        super.setStackInSlot(i, itemStack);
        this.d.setChanged();
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        for (int i = 0; i < this.b; i++) {
            ItemStack stackInSlot = getStackInSlot(i);
            if (!stackInSlot.isEmpty()) {
                registryFriendlyByteBuf.writeBoolean(true);
                ItemStack.STREAM_CODEC.encode(registryFriendlyByteBuf, stackInSlot);
            } else {
                registryFriendlyByteBuf.writeBoolean(false);
            }
        }
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        for (int i = 0; i < this.b; i++) {
            if (registryFriendlyByteBuf.readBoolean()) {
                setStackInSlot(i, (ItemStack) ItemStack.STREAM_CODEC.decode(registryFriendlyByteBuf));
            } else {
                setStackInSlot(i, ItemStack.EMPTY);
            }
        }
    }
}
