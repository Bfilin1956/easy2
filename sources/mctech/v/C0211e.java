package mctech.v;

import com.mojang.blaze3d.vertex.PoseStack;
import mctech.blockentities.c.C0075v;
import mctech.init.MCTechProperties;
import mctech.v.f.b;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

/* JADX INFO: renamed from: mctech.v.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/e.class */
public class C0211e<T extends BlockEntity & mctech.v.f.b> extends GeoBlockRenderer<T> {
    private final ItemRenderer a;

    public C0211e(BlockEntityRendererProvider.Context context) {
        super(new mctech.v.f.a.a());
        this.a = context.getItemRenderer();
    }

    @Nullable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public RenderType getRenderType(T t, ResourceLocation resourceLocation, @Nullable MultiBufferSource multiBufferSource, float f) {
        return RenderType.entityTranslucent(getTextureLocation(t));
    }

    public void render(T t, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i2) {
        if (t == null) {
            return;
        }
        if (t.getBlockState().hasProperty(MCTechProperties.ALL_FACINGS)) {
            a(t, t.getBlockState().getValue(MCTechProperties.ALL_FACINGS), f, poseStack, multiBufferSource, i, i2);
        } else if (t.getBlockState().hasProperty(MCTechProperties.HORIZONTAL_FACINGS)) {
            a(t, t.getBlockState().getValue(MCTechProperties.HORIZONTAL_FACINGS), f, poseStack, multiBufferSource, i, i2);
        } else {
            super.render(t, f, poseStack, multiBufferSource, i, i2);
        }
    }

    /* JADX INFO: renamed from: mctech.v.e$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/e$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Direction.values().length];

        static {
            try {
                a[Direction.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Direction.EAST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Direction.SOUTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[Direction.UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[Direction.WEST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    private void a(T t, Direction direction, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i2) {
        poseStack.pushPose();
        switch (AnonymousClass1.a[direction.ordinal()]) {
            case 1:
                poseStack.mulPose(new Quaternionf().rotateXYZ(4.712389f, 0.0f, 0.0f));
                poseStack.translate(0.0f, -1.0f, 0.0f);
                break;
            case 2:
                poseStack.mulPose(new Quaternionf().rotateXYZ(0.0f, 4.712389f, 0.0f));
                poseStack.translate(0.0f, 0.0f, -1.0f);
                break;
            case 3:
                poseStack.mulPose(new Quaternionf().rotateXYZ(0.0f, 3.1415927f, 0.0f));
                poseStack.translate(-1.0f, 0.0f, -1.0f);
                break;
            case 4:
                poseStack.mulPose(new Quaternionf().rotateXYZ(1.5707964f, 0.0f, 0.0f));
                poseStack.translate(0.0f, 0.0f, -1.0f);
                break;
            case 5:
                poseStack.mulPose(new Quaternionf().rotateXYZ(0.0f, 1.5707964f, 0.0f));
                poseStack.translate(-1.0f, 0.0f, 0.0f);
                break;
        }
        super.render(t, f, poseStack, multiBufferSource, i, i2);
        if (t instanceof C0075v) {
            C0075v c0075v = (C0075v) t;
            BakedModel model = this.a.getModel(c0075v.a(), (Level) null, (LivingEntity) null, 0);
            poseStack.translate(0.5d, 0.7d, 0.5d);
            poseStack.scale(0.6f, 0.6f, 0.6f);
            this.a.render(c0075v.a(), ItemDisplayContext.GROUND, false, poseStack, multiBufferSource, i, i2, model);
            poseStack.mulPose(new Quaternionf().rotateXYZ(0.0f, 1.5707964f, 0.0f));
            this.a.render(c0075v.a(), ItemDisplayContext.GROUND, false, poseStack, multiBufferSource, i, i2, model);
            if (((Boolean) c0075v.getBlockState().getValue(mctech.blocks.c.m.ACTIVE)).booleanValue()) {
                c0075v.c += f;
                if (c0075v.c >= 2.0f) {
                    c0075v.c = 0.0f;
                    RandomSource random = c0075v.getLevel().getRandom();
                    c0075v.getLevel().addParticle(ParticleTypes.COMPOSTER, ((double) c0075v.getPosition().getX()) + 0.25d + (0.5d * ((double) random.nextFloat())), ((double) c0075v.getPosition().getY()) + (((double) random.nextFloat()) * 0.75d), ((double) c0075v.getPosition().getZ()) + 0.25d + (0.5d * ((double) random.nextFloat())), random.nextGaussian() * 0.02d, random.nextGaussian() * 0.02d, random.nextGaussian() * 0.02d);
                }
            }
        }
        poseStack.popPose();
    }
}
