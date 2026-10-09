package mctech.v;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import mctech.utils.C0201c;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/k.class */
@OnlyIn(Dist.CLIENT)
public class k<Animatable extends GeoAnimatable> extends GeoRenderLayer<Animatable> {
    private final List<c<Animatable, a>> a;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/k$c.class */
    public interface c<BE, R> {
        R get(BE be);
    }

    public k(GeoRenderer<Animatable> geoRenderer) {
        super(geoRenderer);
        this.a = new ArrayList();
    }

    public k<Animatable> a(c<Animatable, a> cVar) {
        this.a.add(cVar);
        return this;
    }

    public void render(PoseStack poseStack, Animatable animatable, BakedGeoModel bakedGeoModel, @Nullable RenderType renderType, MultiBufferSource multiBufferSource, @Nullable VertexConsumer vertexConsumer, float f, int i, int i2) {
        VertexConsumer buffer = multiBufferSource.getBuffer(RenderType.cutout());
        this.a.forEach(cVar -> {
            ((a) cVar.get(animatable)).a(poseStack, buffer, i);
        });
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/k$b.class */
    public static final class b {
        private final int a;
        private final int b;
        private final float c;
        private final boolean d;
        private final boolean e;
        private final boolean f;
        private final mctech.utils.math.geometry.e g;

        public b(int i, int i2, float f, boolean z, boolean z2, mctech.utils.math.geometry.e eVar, boolean z3) {
            this.a = i;
            this.b = i2;
            this.c = f;
            this.d = z;
            this.e = z2;
            this.f = z3;
            this.g = eVar;
        }

        public b(int i, int i2, float f, boolean z, boolean z2, mctech.utils.math.geometry.e eVar) {
            this.a = i;
            this.b = i2;
            this.c = f;
            this.d = z;
            this.e = z2;
            this.f = false;
            this.g = eVar;
        }

        public b(int i, int i2, float f, boolean z, boolean z2) {
            this(i, i2, f, z, z2, new mctech.utils.math.geometry.e(0.0f, 0.0f, 0.0f), false);
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public float c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.e;
        }

        public boolean f() {
            return this.f;
        }

        public mctech.utils.math.geometry.e g() {
            return this.g;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b == bVar.b && Float.floatToIntBits(this.c) == Float.floatToIntBits(bVar.c) && this.d == bVar.d && this.e == bVar.e && Objects.equals(this.g, bVar.g);
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.a), Integer.valueOf(this.b), Float.valueOf(this.c), Boolean.valueOf(this.d), Boolean.valueOf(this.e), this.g);
        }

        public String toString() {
            return "Parameters[amount=" + this.a + ", capacity=" + this.b + ", minHeight=" + this.c + ", alwaysFilled=" + this.d + ", showEmpty=" + this.e + ", translation=" + String.valueOf(this.g) + "]";
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/k$a.class */
    public static final class a extends Record {
        private final mctech.utils.math.geometry.e a;
        private final mctech.utils.math.geometry.e b;
        private final Fluid c;
        private final b d;

        public a(mctech.utils.math.geometry.e eVar, mctech.utils.math.geometry.e eVar2, Fluid fluid, b bVar) {
            this.a = eVar;
            this.b = eVar2;
            this.c = fluid;
            this.d = bVar;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "position;size;fluid;parameters", "FIELD:Lmctech/v/k$a;->a:Lmctech/utils/math/geometry/e;", "FIELD:Lmctech/v/k$a;->b:Lmctech/utils/math/geometry/e;", "FIELD:Lmctech/v/k$a;->c:Lnet/minecraft/world/level/material/Fluid;", "FIELD:Lmctech/v/k$a;->d:Lmctech/v/k$b;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "position;size;fluid;parameters", "FIELD:Lmctech/v/k$a;->a:Lmctech/utils/math/geometry/e;", "FIELD:Lmctech/v/k$a;->b:Lmctech/utils/math/geometry/e;", "FIELD:Lmctech/v/k$a;->c:Lnet/minecraft/world/level/material/Fluid;", "FIELD:Lmctech/v/k$a;->d:Lmctech/v/k$b;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "position;size;fluid;parameters", "FIELD:Lmctech/v/k$a;->a:Lmctech/utils/math/geometry/e;", "FIELD:Lmctech/v/k$a;->b:Lmctech/utils/math/geometry/e;", "FIELD:Lmctech/v/k$a;->c:Lnet/minecraft/world/level/material/Fluid;", "FIELD:Lmctech/v/k$a;->d:Lmctech/v/k$b;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public mctech.utils.math.geometry.e a() {
            return this.a;
        }

        public mctech.utils.math.geometry.e b() {
            return this.b;
        }

        public Fluid c() {
            return this.c;
        }

        public b d() {
            return this.d;
        }

        public void a(PoseStack poseStack, VertexConsumer vertexConsumer, int i) {
            if (!d().e() && d().a() <= 0) {
                return;
            }
            poseStack.pushPose();
            poseStack.translate(this.d.g().a, d().g().b, d().g().c);
            new mctech.utils.z(this.a.a, this.a.b, this.a.c, this.b.a, this.b.b * (d().d() ? 1.0f : Math.max(d().c(), d().a() / d().b())), this.b.c).a(poseStack, vertexConsumer, b(c()), a(c()), d().f() ? 15728880 : i);
            poseStack.popPose();
        }

        private int a(Fluid fluid) {
            return IClientFluidTypeExtensions.of(fluid).getTintColor();
        }

        private TextureAtlasSprite b(Fluid fluid) {
            IClientFluidTypeExtensions iClientFluidTypeExtensionsOf = IClientFluidTypeExtensions.of(fluid);
            ResourceLocation stillTexture = iClientFluidTypeExtensionsOf.getStillTexture();
            ResourceLocation location = (ResourceLocation) C0201c.a(stillTexture).b(iClientFluidTypeExtensionsOf.getFlowingTexture());
            if (location == null) {
                location = MissingTextureAtlasSprite.getLocation();
            }
            return (TextureAtlasSprite) Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(location);
        }
    }
}
