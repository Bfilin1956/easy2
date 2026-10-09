package mctech.api.gui;

import java.util.UUID;
import net.minecraft.network.FriendlyByteBuf;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/IRequestScreen.class */
public interface IRequestScreen {
    void receiveConfigData(UUID uuid, FriendlyByteBuf friendlyByteBuf);
}
