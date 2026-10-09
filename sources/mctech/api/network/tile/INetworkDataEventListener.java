package mctech.api.network.tile;

import mctech.api.network.IPlayerPacket;
import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/network/tile/INetworkDataEventListener.class */
public interface INetworkDataEventListener extends IPlayerPacket {
    void onDataBufferReceived(Player player, String str, INetworkDataBuffer iNetworkDataBuffer, Dist dist);
}
