package mctech.m.e;

import net.minecraft.core.Direction;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/e/d.class */
public interface d {
    @NotNull
    a getAccess(@NotNull Direction direction);

    boolean renderAccessRules();

    void renderAccessRules(boolean z);
}
