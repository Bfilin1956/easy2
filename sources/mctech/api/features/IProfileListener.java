package mctech.api.features;

import net.minecraft.network.chat.MutableComponent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/features/IProfileListener.class */
public interface IProfileListener {
    void onProfile(long j);

    long getLag();

    MutableComponent showResults();
}
