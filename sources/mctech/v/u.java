package mctech.v;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Transformation;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.renderer.FaceInfo;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.BlockElement;
import net.minecraft.client.renderer.block.model.BlockElementFace;
import net.minecraft.client.renderer.block.model.BlockElementRotation;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.client.renderer.block.model.ItemModelGenerator;
import net.minecraft.client.renderer.block.model.ItemTransform;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BlockModelRotation;
import net.minecraft.core.Direction;
import net.minecraft.util.Tuple;
import net.minecraft.world.phys.AABB;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.model.QuadTransformers;
import net.neoforged.neoforge.client.model.pipeline.QuadBakingVertexConsumer;
import org.joml.Vector3f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/u.class */
@OnlyIn(Dist.CLIENT)
public class u {
    public static final FaceBakery a = new FaceBakery();
    public static final ItemModelGenerator b = new ItemModelGenerator();
    static final a[][] c = {new a[]{new a(false, false, false), new a(true, false, true)}, new a[]{new a(false, true, false), new a(true, true, true)}, new a[]{new a(false, false, false), new a(true, true, false)}, new a[]{new a(false, false, true), new a(true, true, true)}, new a[]{new a(false, false, false), new a(true, true, true)}, new a[]{new a(false, false, false), new a(true, true, true)}};

    public static BakedQuad a(BakedQuad bakedQuad, int i) {
        return new BakedQuad(bakedQuad.getVertices(), i, bakedQuad.getDirection(), bakedQuad.getSprite(), bakedQuad.isShade());
    }

    public static List<BakedQuad> a(int i, TextureAtlasSprite textureAtlasSprite, ItemTransform itemTransform) {
        List<BlockElement> listProcessFrames = b.processFrames(i, "test", textureAtlasSprite.contents());
        if (listProcessFrames == null || listProcessFrames.isEmpty()) {
            return Collections.emptyList();
        }
        ObjectList objectListI = mctech.utils.a.b.i();
        for (BlockElement blockElement : listProcessFrames) {
            for (Direction direction : blockElement.faces.keySet()) {
                objectListI.add(a.bakeQuad(blockElement.from, blockElement.to, (BlockElementFace) blockElement.faces.get(direction), textureAtlasSprite, direction, BlockModelRotation.X0_Y0, blockElement.rotation, false));
            }
        }
        return objectListI;
    }

    public static BakedQuad a(AABB aabb, Direction direction, BlockElementFace blockElementFace, TextureAtlasSprite textureAtlasSprite, BlockModelRotation blockModelRotation, BlockElementRotation blockElementRotation, boolean z) {
        return a.bakeQuad(a(direction, aabb), b(direction, aabb), blockElementFace, textureAtlasSprite, direction, blockModelRotation, blockElementRotation, z);
    }

    public static BakedQuad b(AABB aabb, Direction direction, BlockElementFace blockElementFace, TextureAtlasSprite textureAtlasSprite, BlockModelRotation blockModelRotation, BlockElementRotation blockElementRotation, boolean z) {
        return a.bakeQuad(a(direction, aabb), b(direction, aabb), blockElementFace, textureAtlasSprite, direction, new mctech.v.e.b(blockModelRotation, true), blockElementRotation, z);
    }

    public static float[] a(AABB aabb, Direction direction) {
        return a(a(direction, aabb), b(direction, aabb));
    }

    public static float[] a(Vector3f vector3f, Vector3f vector3f2) {
        float[] fArr = new float[6];
        fArr[FaceInfo.Constants.MIN_X] = vector3f.x();
        fArr[FaceInfo.Constants.MIN_Y] = vector3f.y();
        fArr[FaceInfo.Constants.MIN_Z] = vector3f.z();
        fArr[FaceInfo.Constants.MAX_X] = vector3f2.x();
        fArr[FaceInfo.Constants.MAX_Y] = vector3f2.y();
        fArr[FaceInfo.Constants.MAX_Z] = vector3f2.z();
        return fArr;
    }

    public static Vector3f a(Direction direction, Vector3f vector3f, Vector3f vector3f2) {
        return c[direction.get3DDataValue()][0].a(vector3f, vector3f2);
    }

    public static Vector3f b(Direction direction, Vector3f vector3f, Vector3f vector3f2) {
        return c[direction.get3DDataValue()][1].a(vector3f, vector3f2);
    }

    public static Vector3f a(Direction direction, AABB aabb) {
        return c[direction.get3DDataValue()][0].a(aabb);
    }

    public static Vector3f b(Direction direction, AABB aabb) {
        return c[direction.get3DDataValue()][1].a(aabb);
    }

    public static Tuple<Integer, Integer> a(Direction direction) {
        if (direction.getAxis().isHorizontal()) {
            return new Tuple<>(0, Integer.valueOf(direction.get2DDataValue() * 90));
        }
        return new Tuple<>(Integer.valueOf(direction == Direction.DOWN ? 270 : 90), 0);
    }

    public static BakedQuad a(Transformation transformation, float f, float f2, float f3, float f4, float f5, TextureAtlasSprite textureAtlasSprite, Direction direction, int i, int i2) {
        return a(transformation, direction, textureAtlasSprite, i, i2, f / 16.0f, 1.0f - (f4 / 16.0f), f3 / 16.0f, 1.0f - (f2 / 16.0f), f5, textureAtlasSprite.getU0(), textureAtlasSprite.getV0(), textureAtlasSprite.getU1(), textureAtlasSprite.getV1(), 0);
    }

    private static BakedQuad a(Transformation transformation, Direction direction, TextureAtlasSprite textureAtlasSprite, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i3) {
        QuadBakingVertexConsumer quadBakingVertexConsumer = new QuadBakingVertexConsumer();
        quadBakingVertexConsumer.setTintIndex(i2);
        quadBakingVertexConsumer.setDirection(direction);
        quadBakingVertexConsumer.setShade(i3 == 0);
        quadBakingVertexConsumer.setSprite(textureAtlasSprite);
        if (direction == Direction.SOUTH) {
            a(quadBakingVertexConsumer, direction, f, f2, f5, f6, f9, i, i3);
            a(quadBakingVertexConsumer, direction, f3, f2, f5, f8, f9, i, i3);
            a(quadBakingVertexConsumer, direction, f3, f4, f5, f8, f7, i, i3);
            a(quadBakingVertexConsumer, direction, f, f4, f5, f6, f7, i, i3);
        } else {
            a(quadBakingVertexConsumer, direction, f, f2, f5, f6, f9, i, i3);
            a(quadBakingVertexConsumer, direction, f, f4, f5, f6, f7, i, i3);
            a(quadBakingVertexConsumer, direction, f3, f4, f5, f8, f7, i, i3);
            a(quadBakingVertexConsumer, direction, f3, f2, f5, f8, f9, i, i3);
        }
        BakedQuad bakedQuadBakeQuad = quadBakingVertexConsumer.bakeQuad();
        if (!transformation.isIdentity()) {
            QuadTransformers.applying(transformation).processInPlace(bakedQuadBakeQuad);
        }
        return bakedQuadBakeQuad;
    }

    private static void a(VertexConsumer vertexConsumer, Direction direction, float f, float f2, float f3, float f4, float f5, int i, int i2) {
        vertexConsumer.addVertex(f, f2, f3).setColor(i).setUv(f4, f5).setNormal(direction.getStepX(), direction.getStepY(), direction.getStepZ());
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/u$a.class */
    public static class a {
        boolean a;
        boolean b;
        boolean c;

        public a(boolean z, boolean z2, boolean z3) {
            this.a = z;
            this.b = z2;
            this.c = z3;
        }

        public Vector3f a(Vector3f vector3f, Vector3f vector3f2) {
            return new Vector3f(this.a ? vector3f2.x() : vector3f.x(), this.b ? vector3f2.y() : vector3f.y(), this.c ? vector3f2.z() : vector3f.z());
        }

        public Vector3f a(AABB aabb) {
            return new Vector3f((float) (this.a ? aabb.maxX : aabb.minX), (float) (this.b ? aabb.maxY : aabb.minY), (float) (this.c ? aabb.maxZ : aabb.minZ));
        }
    }
}
