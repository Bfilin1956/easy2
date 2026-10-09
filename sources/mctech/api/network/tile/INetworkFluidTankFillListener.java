package mctech.api.network.tile;

import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/network/tile/INetworkFluidTankFillListener.class */
public interface INetworkFluidTankFillListener {
    @Nullable
    IFluidHandler getFluidHandler(int i);
}
