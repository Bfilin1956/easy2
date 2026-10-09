package mctech.api.network.tile;

import java.util.Set;
import mctech.api.network.IPlayerPacket;
import net.minecraft.world.entity.player.Player;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/network/tile/INetworkFieldNotifier.class */
public interface INetworkFieldNotifier extends IPlayerPacket {
    void onNetworkFieldChanged(Set<String> set, Player player);

    void onGuiFieldChanged(Set<String> set, Player player);
}
