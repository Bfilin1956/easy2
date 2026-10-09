package mctech.v.f.b;

import mctech.v.f.b;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/b/a.class */
public class a<T extends b> extends GeoModel<T> {
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getModelResource(T t) {
        return t.c();
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureResource(T t) {
        return t.a(null);
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getAnimationResource(T t) {
        return t.s_();
    }
}
