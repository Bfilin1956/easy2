package mctech.mixin.client;

import javax.annotation.Nonnull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/mixin/client/GeoModelAccessor.class */
@Mixin({GeoModel.class})
public interface GeoModelAccessor {
    @Accessor(remap = false)
    void setCurrentModel(@Nonnull BakedGeoModel bakedGeoModel);

    @Accessor(remap = false)
    BakedGeoModel getCurrentModel();
}
