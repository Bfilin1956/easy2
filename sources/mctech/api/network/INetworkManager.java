package mctech.api.network;

import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.api.network.tile.INetworkFieldProvider;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/network/INetworkManager.class */
public interface INetworkManager {
    void startGuiTracking(BlockEntity blockEntity, Player player);

    void sendInitialGuiData(INetworkFieldProvider iNetworkFieldProvider, Player player);

    void updateTileField(BlockEntity blockEntity, String str);

    void updateTileFields(BlockEntity blockEntity, String... strArr);

    void updateGuiField(BlockEntity blockEntity, String str);

    void updateGuiFields(BlockEntity blockEntity, String... strArr);

    void sendInitialData(INetworkFieldProvider iNetworkFieldProvider, CompoundTag compoundTag);

    void handleInitialChange(BlockEntity blockEntity, CompoundTag compoundTag);

    void requestInitialData(INetworkFieldProvider iNetworkFieldProvider);

    void sendClientTileEvent(BlockEntity blockEntity, int i, int i2);

    void sendClientTileDataBufferEvent(BlockEntity blockEntity, String str, INetworkDataBuffer iNetworkDataBuffer);

    void sendClientItemEvent(ItemStack itemStack, int i, int i2);

    void sendClientItemBuffer(ItemStack itemStack, String str, INetworkDataBuffer iNetworkDataBuffer);
}
