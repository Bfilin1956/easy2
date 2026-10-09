package mctech.v;

import mctech.MCTech;
import mctech.api.items.armor.MultiTexturedGeoItem;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoItemRenderer;

/* JADX INFO: renamed from: mctech.v.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/d.class */
public class C0210d<T extends Item & MultiTexturedGeoItem> extends GeoItemRenderer<T> {
    private mctech.v.a.a.EnumC0045a a;

    public C0210d(mctech.v.a.a.EnumC0045a enumC0045a) {
        super(new mctech.v.a.a(enumC0045a));
        this.a = enumC0045a;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RenderType getRenderType(T t, ResourceLocation resourceLocation, @Nullable MultiBufferSource multiBufferSource, float f) {
        return RenderType.entityTranslucent(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, this.a.a(t.getTextureId())));
    }
}
