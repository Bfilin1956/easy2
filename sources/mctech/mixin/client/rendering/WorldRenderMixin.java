package mctech.mixin.client.rendering;

import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderBuffers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/rendering/WorldRenderMixin.class */
@Mixin(value = {LevelRenderer.class}, remap = false)
@OnlyIn(Dist.CLIENT)
public interface WorldRenderMixin {
    @Accessor("renderBuffers")
    RenderBuffers getBuffers();
}
