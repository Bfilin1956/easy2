package mctech.g.c.b;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.world.item.DyeColor;
import net.neoforged.neoforge.client.model.IQuadTransformer;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/b.class */
public final class b extends Record implements IQuadTransformer {

    @Nullable
    private final DyeColor a;

    @Nullable
    private final DyeColor b;

    public b(@Nullable DyeColor dyeColor, @Nullable DyeColor dyeColor2) {
        this.a = dyeColor;
        this.b = dyeColor2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "insert;extract", "FIELD:Lmctech/g/c/b/b;->a:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/c/b/b;->b:Lnet/minecraft/world/item/DyeColor;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "insert;extract", "FIELD:Lmctech/g/c/b/b;->a:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/c/b/b;->b:Lnet/minecraft/world/item/DyeColor;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "insert;extract", "FIELD:Lmctech/g/c/b/b;->a:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/c/b/b;->b:Lnet/minecraft/world/item/DyeColor;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Nullable
    public DyeColor a() {
        return this.a;
    }

    @Nullable
    public DyeColor b() {
        return this.b;
    }

    public void processInPlace(BakedQuad bakedQuad) {
        if (bakedQuad.isTinted()) {
            if (bakedQuad.getTintIndex() == 0 && this.b != null) {
                bakedQuad.tintIndex = this.b.ordinal();
            } else if (bakedQuad.getTintIndex() == 1 && this.a != null) {
                bakedQuad.tintIndex = this.a.ordinal();
            }
        }
    }

    private int a(BakedQuad bakedQuad) {
        if (bakedQuad.isTinted()) {
            if (bakedQuad.getTintIndex() == 0 && this.b != null) {
                return this.b.getTextureDiffuseColor();
            }
            if (bakedQuad.getTintIndex() == 1 && this.a != null) {
                return this.a.getTextureDiffuseColor();
            }
            return -1;
        }
        return -1;
    }
}
