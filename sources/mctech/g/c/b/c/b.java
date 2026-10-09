package mctech.g.c.b.c;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import mctech.MCTech;
import mctech.g.c.g;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.model.IQuadTransformer;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/c/b.class */
public class b implements mctech.g.a.g.a {
    private static final ModelResourceLocation a = ModelResourceLocation.standalone(MCTech.loc("block/extra/fluids"));

    @Override // mctech.g.a.g.a
    public List<BakedQuad> a(Holder<mctech.g.a.a<?, ?>> holder, @Nullable CompoundTag compoundTag, @Nullable Direction direction, Direction direction2, RandomSource randomSource, @Nullable RenderType renderType) {
        Object objValue = holder.value();
        if (!(objValue instanceof mctech.g.d.a.d.c.a)) {
            return List.of();
        }
        if (((mctech.g.d.a.d.c.a) objValue).p()) {
            return List.of();
        }
        if (compoundTag == null || !compoundTag.contains("LockedFluid")) {
            return List.of();
        }
        Fluid fluid = (Fluid) BuiltInRegistries.FLUID.get(ResourceLocation.parse(compoundTag.getString("LockedFluid")));
        if (!fluid.isSame(Fluids.EMPTY)) {
            return new a(fluid).process(Minecraft.getInstance().getModelManager().getModel(a).getQuads(Blocks.COBBLESTONE.defaultBlockState(), direction, randomSource, ModelData.EMPTY, renderType));
        }
        return List.of();
    }

    @Override // mctech.g.a.g.a
    public List<ModelResourceLocation> a() {
        return List.of(a);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/c/b$a.class */
    private static final class a extends Record implements IQuadTransformer {
        private final Fluid a;

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "fluid", "FIELD:Lmctech/g/c/b/c/b$a;->a:Lnet/minecraft/world/level/material/Fluid;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "fluid", "FIELD:Lmctech/g/c/b/c/b$a;->a:Lnet/minecraft/world/level/material/Fluid;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "fluid", "FIELD:Lmctech/g/c/b/c/b$a;->a:Lnet/minecraft/world/level/material/Fluid;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public Fluid a() {
            return this.a;
        }

        private a(Fluid fluid) {
            this.a = fluid;
        }

        public void processInPlace(@NotNull BakedQuad bakedQuad) {
            IClientFluidTypeExtensions iClientFluidTypeExtensionsOf = IClientFluidTypeExtensions.of(this.a);
            TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite) Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(iClientFluidTypeExtensionsOf.getStillTexture());
            for (int i = 0; i < 4; i++) {
                float[] fArrA = g.a(bakedQuad.getVertices(), i, IQuadTransformer.UV0, 2);
                fArrA[0] = (((fArrA[0] - bakedQuad.getSprite().getU0()) * textureAtlasSprite.contents().width()) / bakedQuad.getSprite().contents().height()) + textureAtlasSprite.getU0();
                fArrA[1] = (((fArrA[1] - bakedQuad.getSprite().getV0()) * textureAtlasSprite.contents().width()) / bakedQuad.getSprite().contents().height()) + textureAtlasSprite.getV0();
                int[] iArrA = g.a(fArrA[0], fArrA[1]);
                bakedQuad.getVertices()[IQuadTransformer.UV0 + (i * IQuadTransformer.STRIDE)] = iArrA[0];
                bakedQuad.getVertices()[IQuadTransformer.UV0 + 1 + (i * IQuadTransformer.STRIDE)] = iArrA[1];
                g.b(bakedQuad.getVertices(), i, iClientFluidTypeExtensionsOf.getTintColor());
            }
            bakedQuad.sprite = textureAtlasSprite;
        }
    }
}
