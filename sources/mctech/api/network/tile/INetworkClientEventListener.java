package mctech.api.network.tile;

import mctech.api.network.IPlayerPacket;
import net.minecraft.world.entity.player.Player;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/network/tile/INetworkClientEventListener.class */
public interface INetworkClientEventListener extends IPlayerPacket {
    void onClientDataReceived(Player player, int i, int i2);
}
