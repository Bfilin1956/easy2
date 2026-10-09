package mctech.a.b.e;

import appeng.api.stacks.GenericStack;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.init.MCTechCodecs;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b/e/d.class */
public final class d extends Record implements c {
    private final int c;
    private final ItemStack d;
    public static final Codec<d> a = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.INT.fieldOf("index").forGetter((v0) -> {
            return v0.b();
        }), MCTechCodecs.OPTIONAL_UNLIMITED_ITEM_STACK.fieldOf("itemStack").forGetter((v0) -> {
            return v0.c();
        })).apply(instance, (v1, v2) -> {
            return new d(v1, v2);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, d> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
        return v0.b();
    }, ItemStack.OPTIONAL_STREAM_CODEC, (v0) -> {
        return v0.c();
    }, (v1, v2) -> {
        return new d(v1, v2);
    });

    public d(int i, ItemStack itemStack) {
        this.c = i;
        this.d = itemStack;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, d.class), d.class, "index;itemStack", "FIELD:Lmctech/a/b/e/d;->c:I", "FIELD:Lmctech/a/b/e/d;->d:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, d.class), d.class, "index;itemStack", "FIELD:Lmctech/a/b/e/d;->c:I", "FIELD:Lmctech/a/b/e/d;->d:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, d.class, Object.class), d.class, "index;itemStack", "FIELD:Lmctech/a/b/e/d;->c:I", "FIELD:Lmctech/a/b/e/d;->d:Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Override // mctech.a.b.e.c
    public int b() {
        return this.c;
    }

    public ItemStack c() {
        return this.d;
    }

    @Override // mctech.a.b.e.c
    public GenericStack a() {
        if (c().isEmpty()) {
            return null;
        }
        return mctech.a.b.b.a.a(c());
    }
}
