package mctech.v.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.mixin.client.GeoModelAccessor;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.GeckoLibConstants;
import software.bernie.geckolib.cache.GeckoLibCache;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/d/b.class */
@OnlyIn(Dist.CLIENT)
public class b extends GeoArmorRenderer<mctech.items.e.a> {
    protected GeoBone a;

    public b() {
        super(new a());
    }

    protected void applyBoneVisibilityBySlot(@NotNull EquipmentSlot equipmentSlot) {
        if (equipmentSlot.isArmor()) {
            super.applyBoneVisibilityBySlot(equipmentSlot);
            if (equipmentSlot != EquipmentSlot.LEGS && this.a != null) {
                this.a.setHidden(true);
                return;
            }
            return;
        }
        setAllVisible(false);
        switch (AnonymousClass1.a[equipmentSlot.ordinal()]) {
            case 1:
                setBoneVisible(this.rightArm, true);
                break;
            case 2:
                setBoneVisible(this.leftArm, true);
                break;
        }
    }

    /* JADX INFO: renamed from: mctech.v.d.b$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/d/b$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[EquipmentSlot.values().length];

        static {
            try {
                a[EquipmentSlot.MAINHAND.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[EquipmentSlot.OFFHAND.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    protected void grabRelevantBones(BakedGeoModel bakedGeoModel) {
        if (this.lastModel == bakedGeoModel) {
            return;
        }
        super.grabRelevantBones(bakedGeoModel);
        this.a = (GeoBone) bakedGeoModel.getBone("armorHip").orElse(null);
    }

    protected void applyBaseTransformations(HumanoidModel<?> humanoidModel) {
        if (this.head != null) {
            ModelPart modelPart = this.baseModel.head;
            RenderUtil.matchModelPartRot(modelPart, this.head);
            this.head.updatePosition(modelPart.x, -modelPart.y, modelPart.z);
        }
        if (this.body != null) {
            ModelPart modelPart2 = this.baseModel.body;
            RenderUtil.matchModelPartRot(modelPart2, this.body);
            this.body.updatePosition(modelPart2.x, -modelPart2.y, modelPart2.z);
        }
        if (this.rightArm != null) {
            ModelPart modelPart3 = this.baseModel.rightArm;
            RenderUtil.matchModelPartRot(modelPart3, this.rightArm);
            this.rightArm.updatePosition(modelPart3.x + 5.0f, 2.0f - modelPart3.y, modelPart3.z);
        }
        if (this.leftArm != null) {
            ModelPart modelPart4 = this.baseModel.leftArm;
            RenderUtil.matchModelPartRot(modelPart4, this.leftArm);
            this.leftArm.updatePosition(modelPart4.x - 5.0f, 2.0f - modelPart4.y, modelPart4.z);
        }
        if (this.a != null) {
            ModelPart modelPart5 = this.baseModel.body;
            if (this.baseModel.crouching) {
                RenderUtil.matchModelPartRot(modelPart5, this.a);
                this.a.updatePosition(modelPart5.x, -modelPart5.y, modelPart5.z + 6.25f);
            }
            if (this.rightLeg != null) {
                ModelPart modelPart6 = this.baseModel.rightLeg;
                if (this.baseModel.crouching) {
                    this.rightLeg.updatePosition(modelPart6.x + 2.0f, 15.0f - modelPart6.y, modelPart6.z - 4.65f);
                    this.rightLeg.updateRotation((-modelPart6.xRot) + modelPart5.xRot, -modelPart6.yRot, modelPart6.zRot);
                } else {
                    RenderUtil.matchModelPartRot(modelPart6, this.rightLeg);
                    this.rightLeg.updatePosition(modelPart6.x + 2.0f, 12.0f - modelPart6.y, modelPart6.z);
                }
                if (this.rightBoot != null) {
                    RenderUtil.matchModelPartRot(modelPart6, this.rightBoot);
                    this.rightBoot.updatePosition(modelPart6.x + 2.0f, 12.0f - modelPart6.y, modelPart6.z);
                }
            }
            if (this.leftLeg != null) {
                ModelPart modelPart7 = this.baseModel.leftLeg;
                if (this.baseModel.crouching) {
                    this.leftLeg.updatePosition(modelPart7.x - 2.0f, 15.0f - modelPart7.y, modelPart7.z - 4.65f);
                    this.leftLeg.updateRotation((-modelPart7.xRot) + modelPart5.xRot, -modelPart7.yRot, modelPart7.zRot);
                } else {
                    RenderUtil.matchModelPartRot(modelPart7, this.leftLeg);
                    this.leftLeg.updatePosition(modelPart7.x - 2.0f, 12.0f - modelPart7.y, modelPart7.z);
                }
                if (this.leftBoot != null) {
                    RenderUtil.matchModelPartRot(modelPart7, this.leftBoot);
                    this.leftBoot.updatePosition(modelPart7.x - 2.0f, 12.0f - modelPart7.y, modelPart7.z);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RenderType getRenderType(mctech.items.e.a aVar, ResourceLocation resourceLocation, @Nullable MultiBufferSource multiBufferSource, float f) {
        return RenderType.entityTranslucent(resourceLocation);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/d/b$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a extends GeoModel<mctech.items.e.a> {
        private BakedGeoModel a;

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
                Iterator it = bakedGeoModel.topLevelBones().iterator();
                while (it.hasNext()) {
                    arrayList.add(a((GeoBone) it.next(), null));
                }
                this.a = new BakedGeoModel(arrayList, bakedGeoModel.properties());
                getAnimationProcessor().setActiveModel(this.a);
            }
            return this.a;
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
    }
}
