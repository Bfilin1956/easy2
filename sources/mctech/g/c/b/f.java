package mctech.g.c.b;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.inventory.InventoryMenu;
import net.neoforged.neoforge.client.model.IQuadTransformer;
import net.neoforged.neoforge.client.model.QuadTransformers;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/f.class */
public final class f extends Record implements IQuadTransformer {
    private final TextureAtlasSprite a;
    private final int b;

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, f.class), f.class, "newSprite;lightLevel", "FIELD:Lmctech/g/c/b/f;->a:Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;", "FIELD:Lmctech/g/c/b/f;->b:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, f.class), f.class, "newSprite;lightLevel", "FIELD:Lmctech/g/c/b/f;->a:Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;", "FIELD:Lmctech/g/c/b/f;->b:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, f.class, Object.class), f.class, "newSprite;lightLevel", "FIELD:Lmctech/g/c/b/f;->a:Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;", "FIELD:Lmctech/g/c/b/f;->b:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public TextureAtlasSprite a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public f(TextureAtlasSprite textureAtlasSprite, int i) {
        this.a = textureAtlasSprite;
        this.b = i;
    }

    public void processInPlace(@NotNull BakedQuad bakedQuad) {
        if (this.b != 0) {
            QuadTransformers.settingEmissivity(this.b).processInPlace(bakedQuad);
        }
        for (int i = 0; i < 4; i++) {
            float[] fArrA = mctech.g.c.g.a(bakedQuad.getVertices(), i, IQuadTransformer.UV0, 2);
            fArrA[0] = (((fArrA[0] - bakedQuad.getSprite().getU0()) * this.a.contents().width()) / bakedQuad.getSprite().contents().width()) + this.a.getU0();
            fArrA[1] = (((fArrA[1] - bakedQuad.getSprite().getV0()) * this.a.contents().height()) / bakedQuad.getSprite().contents().height()) + this.a.getV0();
            int[] iArrA = mctech.g.c.g.a(fArrA[0], fArrA[1]);
            bakedQuad.getVertices()[IQuadTransformer.UV0 + (i * IQuadTransformer.STRIDE)] = iArrA[0];
            bakedQuad.getVertices()[IQuadTransformer.UV0 + 1 + (i * IQuadTransformer.STRIDE)] = iArrA[1];
        }
        bakedQuad.sprite = this.a;
    }

    private static TextureAtlas c() {
        return Minecraft.getInstance().getModelManager().getAtlas(InventoryMenu.BLOCK_ATLAS);
    }
}
