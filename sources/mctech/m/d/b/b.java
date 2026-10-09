package mctech.m.d.b;

import java.util.function.Consumer;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/d/b/b.class */
public interface b {
    @OnlyIn(Dist.CLIENT)
    void a(mctech.m.d.b bVar, int i, int i2, Consumer<Component> consumer);
}
