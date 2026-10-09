package mctech.mixin.client;

import java.util.List;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.client.renderer.PostPass;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/PostChainAccessor.class */
@Mixin({PostChain.class})
public interface PostChainAccessor {
    @Accessor(value = "passes", remap = false)
    List<PostPass> getPasses();
}
