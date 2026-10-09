package mctech.v.a;

import mctech.MCTech;
import mctech.api.items.armor.MultiTexturedGeoItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import software.bernie.geckolib.model.GeoModel;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/a/a.class */
public class a<T extends Item & MultiTexturedGeoItem> extends GeoModel<T> {
    private final EnumC0045a a;
    private ResourceLocation b;

    public a(EnumC0045a enumC0045a) {
        this.a = enumC0045a;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getAnimationResource(T t) {
        return this.a.d;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getModelResource(T t) {
        return this.a.c;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ResourceLocation getTextureResource(T t) {
        if (this.b == null) {
            this.b = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, this.a.a(t.getTextureId()));
        }
        return this.b;
    }

    /* JADX INFO: renamed from: mctech.v.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/a/a$a.class */
    public enum EnumC0045a {
        ENERGYPACK("geo/energypack.geo.json", "animations/energypack.animation.json", "textures/models/armor/armor_energypack_t"),
        JETPACK("geo/jetpack.geo.json", "animations/jetpack.animation.json", "textures/models/armor/armor_jetpack_t");

        private ResourceLocation c;
        private ResourceLocation d;
        private String e;

        EnumC0045a(String str, String str2, String str3) {
            this.c = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str);
            this.d = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str2);
            this.e = str3;
        }

        public String a(int i) {
            return this.e + i + ".png";
        }
    }
}
