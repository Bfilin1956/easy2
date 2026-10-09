package mctech.x.a;

import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.MeshData;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.ArrayList;
import java.util.Iterator;
import mctech.MCTech;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.cache.object.GeoCube;
import software.bernie.geckolib.cache.object.GeoQuad;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.util.RenderUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/x/a/e.class */
@OnlyIn(Dist.CLIENT)
public final class e {
    private static final RandomSource e = RandomSource.create(42);
    public static final ModelResourceLocation a = a("quad");
    public static final ModelResourceLocation b = a("cube");
    public static final ModelResourceLocation c = a("body");
    public static final ModelResourceLocation d = a("head");

    private e() {
    }

    public static void a() {
        PoseStack poseStack = new PoseStack();
        BufferBuilder bufferBuilderB = b();
        bufferBuilderB.addVertex(-0.5f, -0.5f, 0.0f).setColor(-1).setUv(0.0f, 1.0f).setNormal(0.0f, 0.0f, 1.0f);
        bufferBuilderB.addVertex(-0.5f, 0.5f, 0.0f).setColor(-1).setUv(0.0f, 0.0f).setNormal(0.0f, 0.0f, 1.0f);
        bufferBuilderB.addVertex(0.5f, 0.5f, 0.0f).setColor(-1).setUv(1.0f, 0.0f).setNormal(0.0f, 0.0f, 1.0f);
        bufferBuilderB.addVertex(0.5f, -0.5f, 0.0f).setColor(-1).setUv(1.0f, 1.0f).setNormal(0.0f, 0.0f, 1.0f);
        i.a.b(a, bufferBuilderB.buildOrThrow());
        ModelPart.Cube cubeBake = ((CubeDefinition) CubeListBuilder.create().addBox(4.0f, 4.0f, 4.0f, 8.0f, 8.0f, 8.0f).getCubes().getFirst()).bake(64, 64);
        BufferBuilder bufferBuilderB2 = b();
        cubeBake.compile(poseStack.last(), bufferBuilderB2, 15728880, OverlayTexture.NO_OVERLAY, -1);
        i.a.b(b, bufferBuilderB2.buildOrThrow());
        i.a.b(c, a(b()).buildOrThrow());
        i.a.b(d, b(b()).buildOrThrow());
    }

    private static BufferBuilder b() {
        return Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR_NORMAL);
    }

    public static MeshData a(ModelPart modelPart) {
        PoseStack poseStack = new PoseStack();
        BufferBuilder bufferBuilderB = b();
        modelPart.render(poseStack, bufferBuilderB, 15728880, OverlayTexture.NO_OVERLAY);
        return bufferBuilderB.build();
    }

    public static MeshData a(ModelPart.Cube cube) {
        PoseStack poseStack = new PoseStack();
        BufferBuilder bufferBuilderB = b();
        cube.compile(poseStack.last(), bufferBuilderB, 15728880, OverlayTexture.NO_OVERLAY, -1);
        return bufferBuilderB.build();
    }

    public static MeshData a(BlockState blockState) {
        PoseStack poseStack = new PoseStack();
        BufferBuilder bufferBuilderB = b();
        Iterator it = Minecraft.getInstance().getBlockRenderer().getBlockModel(blockState).getQuads(blockState, (Direction) null, e, ModelData.EMPTY, (RenderType) null).iterator();
        while (it.hasNext()) {
            bufferBuilderB.putBulkData(poseStack.last(), (BakedQuad) it.next(), 1.0f, 1.0f, 1.0f, 1.0f, 15728880, OverlayTexture.NO_OVERLAY);
        }
        return bufferBuilderB.build();
    }

    @Nullable
    private static GeoBone a(BakedGeoModel bakedGeoModel, String str) {
        Iterator it = bakedGeoModel.topLevelBones().iterator();
        while (it.hasNext()) {
            GeoBone geoBoneSearchForChildBone = bakedGeoModel.searchForChildBone((GeoBone) it.next(), str);
            if (geoBoneSearchForChildBone != null) {
                return geoBoneSearchForChildBone;
            }
        }
        return null;
    }

    public static <T extends GeoAnimatable> MeshData a(GeoRenderer<T> geoRenderer, T t) {
        BufferBuilder bufferBuilderB = b();
        BakedGeoModel bakedModel = geoRenderer.getGeoModel().getBakedModel(geoRenderer.getGeoModel().getModelResource(t));
        PoseStack poseStack = new PoseStack();
        Iterator it = bakedModel.topLevelBones().iterator();
        while (it.hasNext()) {
            b(geoRenderer, (GeoBone) it.next(), poseStack, bufferBuilderB);
        }
        return bufferBuilderB.build();
    }

    public static <T extends GeoAnimatable> MeshData a(GeoRenderer<T> geoRenderer, T t, String... strArr) {
        BufferBuilder bufferBuilderB = b();
        BakedGeoModel bakedModel = geoRenderer.getGeoModel().getBakedModel(geoRenderer.getGeoModel().getModelResource(t));
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            GeoBone geoBoneA = a(bakedModel, str);
            if (geoBoneA != null) {
                arrayList.add(geoBoneA);
            }
        }
        if (arrayList.isEmpty()) {
            return bufferBuilderB.build();
        }
        PoseStack poseStack = new PoseStack();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b(geoRenderer, (GeoBone) it.next(), poseStack, bufferBuilderB);
        }
        return bufferBuilderB.build();
    }

    public static <T extends GeoAnimatable> MeshData a(GeoRenderer<T> geoRenderer, T t, GeoBone geoBone, PoseStack poseStack) {
        BufferBuilder bufferBuilderB = b();
        a(geoRenderer, geoBone, poseStack, bufferBuilderB);
        return bufferBuilderB.build();
    }

    private static <T extends GeoAnimatable> void a(GeoRenderer<T> geoRenderer, GeoBone geoBone, PoseStack poseStack, BufferBuilder bufferBuilder) {
        if (geoBone.isHidden()) {
            return;
        }
        PoseStack.Pose poseLast = poseStack.last();
        Matrix3f matrix3fNormal = poseLast.normal();
        Matrix4f matrix4f = new Matrix4f(poseLast.pose());
        for (GeoCube geoCube : geoBone.getCubes()) {
            for (GeoQuad geoQuad : geoCube.quads()) {
                if (geoQuad != null) {
                    Vector3f vector3fTransform = matrix3fNormal.transform(new Vector3f(geoQuad.normal()));
                    RenderUtil.fixInvertedFlatCube(geoCube, vector3fTransform);
                    geoRenderer.createVerticesOfQuad(geoQuad, matrix4f, vector3fTransform, bufferBuilder, 15728880, OverlayTexture.NO_OVERLAY, -1);
                }
            }
        }
    }

    private static <T extends GeoAnimatable> void b(GeoRenderer<T> geoRenderer, GeoBone geoBone, PoseStack poseStack, BufferBuilder bufferBuilder) {
        if (geoBone.isHidden()) {
            return;
        }
        poseStack.pushPose();
        RenderUtil.prepMatrixForBone(poseStack, geoBone);
        for (GeoCube geoCube : geoBone.getCubes()) {
            poseStack.pushPose();
            RenderUtil.translateToPivotPoint(poseStack, geoCube);
            RenderUtil.rotateMatrixAroundCube(poseStack, geoCube);
            RenderUtil.translateAwayFromPivotPoint(poseStack, geoCube);
            Matrix3f matrix3fNormal = poseStack.last().normal();
            Matrix4f matrix4f = new Matrix4f(poseStack.last().pose());
            for (GeoQuad geoQuad : geoCube.quads()) {
                if (geoQuad != null) {
                    Vector3f vector3fTransform = matrix3fNormal.transform(new Vector3f(geoQuad.normal()));
                    RenderUtil.fixInvertedFlatCube(geoCube, vector3fTransform);
                    geoRenderer.createVerticesOfQuad(geoQuad, matrix4f, vector3fTransform, bufferBuilder, 15728880, OverlayTexture.NO_OVERLAY, -1);
                }
            }
            poseStack.popPose();
        }
        Iterator it = geoBone.getChildBones().iterator();
        while (it.hasNext()) {
            b(geoRenderer, (GeoBone) it.next(), poseStack, bufferBuilder);
        }
        poseStack.popPose();
    }

    private static BufferBuilder a(BufferBuilder bufferBuilder) {
        CubeListBuilder cubeListBuilderCreate = CubeListBuilder.create();
        cubeListBuilderCreate.texOffs(16, 16).addBox(-4.0f, 12.0f, -2.0f, 8.0f, 12.0f, 4.0f);
        cubeListBuilderCreate.texOffs(40, 16).addBox(-8.0f, 12.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        cubeListBuilderCreate.texOffs(40, 16).addBox(4.0f, 12.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        cubeListBuilderCreate.texOffs(0, 16).addBox(-4.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        cubeListBuilderCreate.texOffs(0, 16).addBox(0.0f, 0.0f, -2.0f, 4.0f, 12.0f, 4.0f);
        PoseStack poseStack = new PoseStack();
        Iterator it = cubeListBuilderCreate.getCubes().iterator();
        while (it.hasNext()) {
            ((CubeDefinition) it.next()).bake(64, 64).compile(poseStack.last(), bufferBuilder, 15728880, OverlayTexture.NO_OVERLAY, -1);
        }
        return bufferBuilder;
    }

    private static BufferBuilder b(BufferBuilder bufferBuilder) {
        CubeListBuilder cubeListBuilderCreate = CubeListBuilder.create();
        cubeListBuilderCreate.addBox(-4.0f, 0.0f, -4.0f, 8.0f, 8.0f, 8.0f);
        PoseStack poseStack = new PoseStack();
        Iterator it = cubeListBuilderCreate.getCubes().iterator();
        while (it.hasNext()) {
            ((CubeDefinition) it.next()).bake(64, 64).compile(poseStack.last(), bufferBuilder, 15728880, OverlayTexture.NO_OVERLAY, -1);
        }
        return bufferBuilder;
    }

    public static ModelResourceLocation a(String str) {
        return new ModelResourceLocation(MCTech.loc(str), "vbo");
    }
}
