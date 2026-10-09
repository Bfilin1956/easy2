package mctech.v.d;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.mixin.client.GeoModelAccessor;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.cache.GeckoLibCache;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/d/a.class */
public class a extends GeoItemRenderer<mctech.items.e.a> {
    private final ItemStack a;

    public a(@Nonnull ArmorItem.Type type, ItemStack itemStack) {
        super(new C0047a(type));
        this.a = itemStack;
    }

    public void renderByItem(ItemStack itemStack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i2) {
        super.renderByItem(this.a, itemDisplayContext, poseStack, multiBufferSource, i, i2);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RenderType getRenderType(mctech.items.e.a aVar, ResourceLocation resourceLocation, @Nullable MultiBufferSource multiBufferSource, float f) {
        return RenderType.entityTranslucent(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/item/" + aVar.b().name().toLowerCase(Locale.ROOT).substring(6) + "_armor.png"));
    }

    /* JADX INFO: renamed from: mctech.v.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/d/a$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class C0047a extends GeoModel<mctech.items.e.a> {

        @Nonnull
        private final ArmorItem.Type a;
        private BakedGeoModel b;

        public C0047a(@Nonnull ArmorItem.Type type) {
            this.a = type;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResourceLocation getAnimationResource(@Nonnull mctech.items.e.a aVar) {
            return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "animations/item/" + aVar.b().name().toLowerCase(Locale.ROOT).substring(6) + "_armor.animation.json");
        }

        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResourceLocation getModelResource(@Nonnull mctech.items.e.a aVar) {
            return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "geo/item/" + aVar.b().name().toLowerCase(Locale.ROOT).substring(6) + "_armor.geo.json");
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ResourceLocation getTextureResource(@Nonnull mctech.items.e.a aVar) {
            return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/item/" + aVar.b().name().toLowerCase(Locale.ROOT).substring(6) + "_armor.png");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public BakedGeoModel getBakedModel(ResourceLocation resourceLocation) {
            BakedGeoModel bakedGeoModel = (BakedGeoModel) GeckoLibCache.getBakedModels().get(resourceLocation);
            if (bakedGeoModel == null) {
                if (!resourceLocation.getPath().contains("geo/")) {
                    throw GeckoLibConstants.exception(resourceLocation, "Invalid model resource path provided - GeckoLib models must be placed in assets/<modid>/geo/");
                }
                throw GeckoLibConstants.exception(resourceLocation, "Unable to find model");
            }
            GeoModelAccessor geoModelAccessor = (GeoModelAccessor) this;
            if (bakedGeoModel != geoModelAccessor.getCurrentModel()) {
                geoModelAccessor.setCurrentModel(bakedGeoModel);
                ArrayList arrayList = new ArrayList();
                for (GeoBone geoBone : bakedGeoModel.topLevelBones()) {
                    if (a(geoBone)) {
                        arrayList.add(a(geoBone, null));
                    } else {
                        for (GeoBone geoBone2 : geoBone.getChildBones()) {
                            if (a(geoBone2)) {
                                arrayList.add(a(geoBone2, geoBone));
                            }
                        }
                    }
                }
                this.b = new BakedGeoModel(arrayList, bakedGeoModel.properties());
                getAnimationProcessor().setActiveModel(this.b);
            }
            return this.b;
        }

        @Nonnull
        private GeoBone a(@Nonnull GeoBone geoBone, @Nullable GeoBone geoBone2) {
            GeoBone geoBone3 = new GeoBone(geoBone2, geoBone.getName(), geoBone.getMirror(), geoBone.getInflate(), geoBone.shouldNeverRender(), geoBone.getReset());
            geoBone3.getCubes().addAll(geoBone.getCubes());
            geoBone3.setHidden(geoBone.isHidden());
            geoBone3.setChildrenHidden(geoBone.isHidingChildren());
            geoBone3.setScaleX(geoBone.getScaleX());
            geoBone3.setScaleY(geoBone.getScaleY());
            geoBone3.setScaleZ(geoBone.getScaleZ());
            geoBone3.setPosX(geoBone.getPosX());
            geoBone3.setPosY(geoBone.getPosY());
            geoBone3.setPosZ(geoBone.getPosZ());
            geoBone3.setRotX(geoBone.getRotX());
            geoBone3.setRotY(geoBone.getRotY());
            geoBone3.setRotZ(geoBone.getRotZ());
            geoBone3.setPivotX(geoBone.getPivotX());
            geoBone3.setPivotY(geoBone.getPivotY());
            geoBone3.setPivotZ(geoBone.getPivotZ());
            geoBone3.setTrackingMatrices(geoBone.isTrackingMatrices());
            geoBone3.resetStateChanges();
            Iterator it = geoBone.getChildBones().iterator();
            while (it.hasNext()) {
                geoBone3.getChildBones().add(a((GeoBone) it.next(), geoBone3));
            }
            return geoBone3;
        }

        private boolean a(@Nonnull GeoBone geoBone) {
            switch (geoBone.getName()) {
                case "armorHead":
                    return this.a == ArmorItem.Type.HELMET;
                case "armorBody":
                case "armorRightArm":
                case "armorLeftArm":
                    return this.a == ArmorItem.Type.CHESTPLATE;
                case "armorRightLeg":
                case "armorLeftLeg":
                case "armorHip":
                    return this.a == ArmorItem.Type.LEGGINGS;
                case "armorRightBoot":
                case "armorLeftBoot":
                    return this.a == ArmorItem.Type.BOOTS;
                default:
                    return false;
            }
        }
    }
}
