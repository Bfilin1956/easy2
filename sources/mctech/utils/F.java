package mctech.utils;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/F.class */
public final class F {
    @NotNull
    public static Component a(@NotNull String str) {
        return Component.literal(str.replace('&', (char) 167));
    }
}
