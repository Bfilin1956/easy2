package mctech.v;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Optional;
import mctech.MCTech;
import mctech.init.MCTechRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.dataticket.DataTicket;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/g.class */
public class g<I extends Item & GeoItem> extends BlockAndItemGeoLayer<I> {
    public static DataTicket<Boolean> a = new DataTicket<>("render_laser", Boolean.class);
    public static DataTicket<Integer> b = new DataTicket<>("render_laser_ticks", Integer.class);
    public static DataTicket<Integer> c = new DataTicket<>("laser_color", Integer.class);
    private static Field d;

    static {
        try {
            d = GeoItemRenderer.class.getDeclaredField("renderPerspective");
            d.setAccessible(true);
        } catch (NoSuchFieldException e) {
            d = null;
        }
    }

    public g(GeoItemRenderer<I> geoItemRenderer) {
        super(geoItemRenderer);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void render(PoseStack poseStack, I i, BakedGeoModel bakedGeoModel, @Nullable RenderType renderType, MultiBufferSource multiBufferSource, @Nullable VertexConsumer vertexConsumer, float f, int i2, int i3) {
        GeoRenderer renderer = getRenderer();
        if (renderer instanceof GeoItemRenderer) {
            GeoItemRenderer<I> geoItemRenderer = (GeoItemRenderer) renderer;
            AnimatableManager<GeoAnimatable> managerForId = ((GeoAnimatable) i).getAnimatableInstanceCache().getManagerForId(geoItemRenderer.getInstanceId(i));
            if (((Boolean) a(managerForId, a).orElse(false)).booleanValue() && ((Integer) a(managerForId, b).orElse(0)).intValue() > 0) {
                ItemDisplayContext itemDisplayContextA = a(geoItemRenderer);
                if (a(itemDisplayContextA)) {
                    bakedGeoModel.getBone("laser").ifPresent(geoBone -> {
                        a(poseStack, geoBone, multiBufferSource, itemDisplayContextA, ((Integer) a((AnimatableManager<GeoAnimatable>) managerForId, c).orElse(16711935)).intValue());
                    });
                }
            }
        }
    }

    private boolean a(ItemDisplayContext itemDisplayContext) {
        return itemDisplayContext == ItemDisplayContext.FIRST_PERSON_RIGHT_HAND || itemDisplayContext == ItemDisplayContext.FIRST_PERSON_LEFT_HAND || itemDisplayContext == ItemDisplayContext.THIRD_PERSON_RIGHT_HAND || itemDisplayContext == ItemDisplayContext.THIRD_PERSON_LEFT_HAND;
    }

    private <D> Optional<D> a(AnimatableManager<GeoAnimatable> animatableManager, DataTicket<D> dataTicket) {
        return Optional.ofNullable(animatableManager.getData(dataTicket));
    }

    private ItemDisplayContext a(GeoItemRenderer<I> geoItemRenderer) {
        if (d != null) {
            try {
                return (ItemDisplayContext) d.get(geoItemRenderer);
            } catch (IllegalAccessException e) {
                MCTech.LOGGER.error(e);
            }
        }
        return ItemDisplayContext.NONE;
    }

    private void a(PoseStack poseStack, GeoBone geoBone, MultiBufferSource multiBufferSource, ItemDisplayContext itemDisplayContext, int i) {
        poseStack.pushPose();
        a(poseStack, geoBone);
        Vector4f vector4f = new Vector4f(0.0f, 0.0f, 0.0f, 1.0f);
        vector4f.mul(poseStack.last().pose());
        Vec3 vec3 = new Vec3(vector4f.x(), vector4f.y(), vector4f.z());
        Vector3f vector3fA = a(poseStack);
        a(multiBufferSource, vec3, vec3.add(((double) vector3fA.x()) * 24.0d, ((double) vector3fA.y()) * 24.0d, ((double) vector3fA.z()) * 24.0d), itemDisplayContext.firstPerson() ? 0.1f : 0.15f, i);
        poseStack.popPose();
    }

    private void a(MultiBufferSource multiBufferSource, Vec3 vec3, Vec3 vec4, float f, int i) {
        Vec3 vec3Normalize = vec4.subtract(vec3).normalize();
        Vec3 vec3A = a(vec3Normalize);
        Vec3 vec3Normalize2 = vec3Normalize.cross(vec3A).normalize();
        double dDistanceTo = vec3.distanceTo(vec4);
        VertexConsumer buffer = multiBufferSource.getBuffer(MCTechRenderTypes.LASER_MAIN_BEAM);
        a(buffer, vec3, vec4, vec3A, f, dDistanceTo, mctech.utils.math.a.f(i), mctech.utils.math.a.g(i), mctech.utils.math.a.h(i), 1.0f);
        a(buffer, vec3, vec4, vec3Normalize2, f, dDistanceTo, mctech.utils.math.a.f(i), mctech.utils.math.a.g(i), mctech.utils.math.a.h(i), 1.0f);
        VertexConsumer buffer2 = multiBufferSource.getBuffer(MCTechRenderTypes.LASER_MAIN_ADDITIVE);
        a(buffer2, vec3, vec4, vec3A, f * 2.0f, dDistanceTo, mctech.utils.math.a.f(i), mctech.utils.math.a.g(i), mctech.utils.math.a.h(i), 0.3f);
        a(buffer2, vec3, vec4, vec3Normalize2, f * 2.0f, dDistanceTo, mctech.utils.math.a.f(i), mctech.utils.math.a.g(i), mctech.utils.math.a.h(i), 0.3f);
        VertexConsumer buffer3 = multiBufferSource.getBuffer(MCTechRenderTypes.LASER_MAIN_CORE);
        a(buffer3, vec3, vec4, vec3A, f * 0.5f, dDistanceTo, 1.0f, 1.0f, 1.0f, 0.8f);
        a(buffer3, vec3, vec4, vec3Normalize2, f * 0.5f, dDistanceTo, 1.0f, 1.0f, 1.0f, 0.8f);
    }

    private void a(VertexConsumer vertexConsumer, Vec3 vec3, Vec3 vec4, Vec3 vec5, float f, double d2, float f2, float f3, float f4, float f5) {
        Vec3 vec3Scale = vec5.scale(f);
        Vec3 vec3Add = vec3.add(vec3Scale);
        Vec3 vec3Add2 = vec4.add(vec3Scale);
        Vec3 vec3Subtract = vec4.subtract(vec3Scale);
        Vec3 vec3Subtract2 = vec3.subtract(vec3Scale);
        a(vertexConsumer, vec5, (float) d2, f2, f3, f4, f5, vec3Add, vec3Add2, vec3Subtract, vec3Subtract2, 0.0f, 1.0f, 0.0f);
        a(vertexConsumer, vec5.scale(-1.0d), (float) d2, f2, f3, f4, f5, vec3Subtract2, vec3Subtract, vec3Add2, vec3Add, 0.0f, 1.0f, 0.0f);
    }

    private void a(VertexConsumer vertexConsumer, Vec3 vec3, float f, float f2, float f3, float f4, float f5, Vec3 vec4, Vec3 vec5, Vec3 vec6, Vec3 vec7, float f6, float f7, float f8) {
        a(vertexConsumer, vec4, f6, f8, vec3, f2, f3, f4, f5);
        a(vertexConsumer, vec5, f7, f, vec3, f2, f3, f4, f5);
        a(vertexConsumer, vec6, f7, f, vec3, f2, f3, f4, f5);
        a(vertexConsumer, vec7, f6, f8, vec3, f2, f3, f4, f5);
    }

    private void a(VertexConsumer vertexConsumer, Vec3 vec3, float f, float f2, Vec3 vec4, float f3, float f4, float f5, float f6) {
        vertexConsumer.addVertex((float) vec3.x, (float) vec3.y, (float) vec3.z).setColor(f3, f4, f5, f6).setUv(f, f2).setOverlay(OverlayTexture.NO_OVERLAY).setLight(15728880).setNormal((float) vec4.x, (float) vec4.y, (float) vec4.z);
    }

    private Vector3f a(PoseStack poseStack) {
        Matrix4f matrix4fPose = poseStack.last().pose();
        Vector3f vector3f = new Vector3f(0.0f, 0.0f, 1.0f);
        Vector4f vector4f = new Vector4f(vector3f.x, vector3f.y, vector3f.z, 0.0f);
        vector4f.mul(matrix4fPose);
        return new Vector3f(vector4f.x(), vector4f.y(), vector4f.z()).normalize();
    }

    private Vec3 a(Vec3 vec3) {
        Vec3 vec4 = new Vec3(0.0d, 1.0d, 0.0d);
        if (Math.abs(vec3.dot(vec4)) > 0.95d) {
            vec4 = new Vec3(1.0d, 0.0d, 0.0d);
        }
        return vec3.cross(vec4).normalize();
    }

    private void a(PoseStack poseStack, GeoBone geoBone) {
        ArrayList<GeoBone> arrayList = new ArrayList();
        GeoBone parent = geoBone;
        while (true) {
            GeoBone geoBone2 = parent;
            if (geoBone2 == null) {
                break;
            }
            arrayList.addFirst(geoBone2);
            parent = geoBone2.getParent();
        }
        for (GeoBone geoBone3 : arrayList) {
            poseStack.translate(geoBone3.getPosX() / 16.0f, geoBone3.getPosY() / 16.0f, geoBone3.getPosZ() / 16.0f);
            poseStack.translate(geoBone3.getPivotX() / 16.0f, geoBone3.getPivotY() / 16.0f, geoBone3.getPivotZ() / 16.0f);
            poseStack.mulPose(Axis.ZP.rotationDegrees(geoBone3.getRotZ()));
            poseStack.mulPose(Axis.YP.rotationDegrees(geoBone3.getRotY()));
            poseStack.mulPose(Axis.XP.rotationDegrees(geoBone3.getRotX()));
            poseStack.scale(geoBone3.getScaleX(), geoBone3.getScaleY(), geoBone3.getScaleZ());
            poseStack.translate((-geoBone3.getPivotX()) / 16.0f, (-geoBone3.getPivotY()) / 16.0f, (-geoBone3.getPivotZ()) / 16.0f);
        }
    }
}
