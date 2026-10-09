package mctech.o;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/o/f.class */
public interface f {
    @NotNull
    mctech.i.a b();

    @OnlyIn(Dist.CLIENT)
    default int c() {
        return mctech.utils.c.h.i;
    }

    @OnlyIn(Dist.CLIENT)
    default int d() {
        return mctech.utils.c.h.i;
    }
}
