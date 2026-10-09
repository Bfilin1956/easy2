package mctech.v.b;

import java.util.function.Consumer;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.Event;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/b/b.class */
@OnlyIn(Dist.CLIENT)
public class b extends Event {
    Consumer<RenderType> a;

    public b(Consumer<RenderType> consumer) {
        this.a = consumer;
    }

    public void a(RenderType renderType) {
        this.a.accept(renderType);
    }
}
