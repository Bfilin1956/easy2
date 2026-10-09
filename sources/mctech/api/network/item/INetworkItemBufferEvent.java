package mctech.api.network.item;

import mctech.api.network.IPlayerPacket;
import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/network/item/INetworkItemBufferEvent.class */
public interface INetworkItemBufferEvent<T extends INetworkDataBuffer> extends IPlayerPacket {
    void onDataBufferReceived(ItemStack itemStack, Player player, String str, T t, Dist dist);
}
