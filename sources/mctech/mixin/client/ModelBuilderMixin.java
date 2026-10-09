package mctech.mixin.client;

import com.google.common.base.Preconditions;
import java.util.Map;
import mctech.MCTech;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/ModelBuilderMixin.class */
@Mixin({ModelBuilder.class})
public abstract class ModelBuilderMixin<T extends ModelBuilder<T>> {

    @Shadow(remap = false)
    @Final
    protected ExistingFileHelper existingFileHelper;

    @Shadow(remap = false)
    @Final
    protected Map<String, String> textures;

    @Shadow(remap = false)
    protected abstract T self();

    @Inject(method = {"texture(Ljava/lang/String;Lnet/minecraft/resources/ResourceLocation;)Lnet/neoforged/neoforge/client/model/generators/ModelBuilder;"}, at = {@At("HEAD")}, cancellable = true, remap = false)
    private void texture(String str, ResourceLocation resourceLocation, CallbackInfoReturnable<T> callbackInfoReturnable) {
        Preconditions.checkNotNull(str, "Key must not be null");
        Preconditions.checkNotNull(resourceLocation, "Texture must not be null");
        if (!this.existingFileHelper.exists(resourceLocation, ModelProvider.TEXTURE) && resourceLocation.getNamespace().equals(MCTech.MODID)) {
            MCTech.LOGGER.warn("Texture '{}' does not exist, replacing with placeholder", str);
            this.textures.put(str, "minecraft:item/barrier");
            callbackInfoReturnable.setReturnValue(self());
        }
    }
}
