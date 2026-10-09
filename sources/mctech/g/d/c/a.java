package mctech.g.d.c;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/c/a.class */
public class a {
    public static final C0015a a = new C0015a(DyeColor.GREEN, DyeColor.BROWN);
    private final DataComponentType<C0015a> b;
    private final ItemStack c;

    public a(ItemStack itemStack, DataComponentType<C0015a> dataComponentType) {
        this.c = itemStack;
        this.b = dataComponentType;
    }

    public DyeColor a() {
        return ((C0015a) this.c.get(this.b)).a();
    }

    public DyeColor b() {
        return ((C0015a) this.c.get(this.b)).b();
    }

    public void a(DyeColor dyeColor) {
        this.c.set(this.b, new C0015a(dyeColor, b()));
    }

    public void b(DyeColor dyeColor) {
        this.c.set(this.b, new C0015a(a(), dyeColor));
    }

    public void a(DyeColor dyeColor, DyeColor dyeColor2) {
        this.c.set(this.b, new C0015a(dyeColor, dyeColor2));
    }

    /* JADX INFO: renamed from: mctech.g.d.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/c/a$a.class */
    public static final class C0015a extends Record {
        private final DyeColor c;
        private final DyeColor d;
        public static final Codec<C0015a> a = RecordCodecBuilder.create(instance -> {
            return instance.group(DyeColor.CODEC.fieldOf("channel1").forGetter((v0) -> {
                return v0.a();
            }), DyeColor.CODEC.fieldOf("channel2").forGetter((v0) -> {
                return v0.b();
            })).apply(instance, C0015a::new);
        });
        public static final StreamCodec<ByteBuf, C0015a> b = StreamCodec.composite(DyeColor.STREAM_CODEC, (v0) -> {
            return v0.a();
        }, DyeColor.STREAM_CODEC, (v0) -> {
            return v0.b();
        }, C0015a::new);

        public C0015a(DyeColor dyeColor, DyeColor dyeColor2) {
            this.c = dyeColor;
            this.d = dyeColor2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0015a.class), C0015a.class, "channel1;channel2", "FIELD:Lmctech/g/d/c/a$a;->c:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/c/a$a;->d:Lnet/minecraft/world/item/DyeColor;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0015a.class), C0015a.class, "channel1;channel2", "FIELD:Lmctech/g/d/c/a$a;->c:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/c/a$a;->d:Lnet/minecraft/world/item/DyeColor;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0015a.class, Object.class), C0015a.class, "channel1;channel2", "FIELD:Lmctech/g/d/c/a$a;->c:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/c/a$a;->d:Lnet/minecraft/world/item/DyeColor;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public DyeColor a() {
            return this.c;
        }

        public DyeColor b() {
            return this.d;
        }
    }
}
