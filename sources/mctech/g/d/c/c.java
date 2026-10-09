package mctech.g.d.c;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.init.MCTechDataComponent;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/c/c.class */
public class c implements mctech.g.a.e.e {
    public static final a a = new a(DyeColor.GREEN, 8, 0, false);
    private final ItemStack b;

    public c(ItemStack itemStack) {
        this.b = itemStack;
    }

    @Override // mctech.g.a.e.e
    public int a(mctech.g.a.e.f fVar, DyeColor dyeColor) {
        DyeColor dyeColorA = a();
        int iB = b();
        boolean zD = d();
        int iC = c();
        if (fVar.a(dyeColorA) && zD) {
            iC++;
            zD = false;
        }
        if (!fVar.a(dyeColorA)) {
            zD = true;
        }
        if (iC > iB) {
            iC = 1;
        }
        b(iC);
        a(zD);
        return iC == iB ? 15 : 0;
    }

    public DyeColor a() {
        return ((a) this.b.get(MCTechDataComponent.REDSTONE_COUNT_FILTER)).a();
    }

    public int b() {
        return ((a) this.b.get(MCTechDataComponent.REDSTONE_COUNT_FILTER)).b();
    }

    public void a(int i) {
        a aVar = (a) this.b.get(MCTechDataComponent.REDSTONE_COUNT_FILTER);
        this.b.set(MCTechDataComponent.REDSTONE_COUNT_FILTER, new a(aVar.c, i, aVar.e, aVar.f));
    }

    public int c() {
        return ((a) this.b.get(MCTechDataComponent.REDSTONE_COUNT_FILTER)).c();
    }

    public void b(int i) {
        a aVar = (a) this.b.get(MCTechDataComponent.REDSTONE_COUNT_FILTER);
        this.b.set(MCTechDataComponent.REDSTONE_COUNT_FILTER, new a(aVar.c, aVar.d, i, aVar.f));
    }

    public boolean d() {
        return ((a) this.b.get(MCTechDataComponent.REDSTONE_COUNT_FILTER)).d();
    }

    public void a(boolean z) {
        a aVar = (a) this.b.get(MCTechDataComponent.REDSTONE_COUNT_FILTER);
        this.b.set(MCTechDataComponent.REDSTONE_COUNT_FILTER, new a(aVar.c, aVar.d, aVar.e, z));
    }

    public void a(mctech.g.b.a.p pVar) {
        this.b.set(MCTechDataComponent.REDSTONE_COUNT_FILTER, new a(pVar.a(), pVar.b(), pVar.c(), pVar.d()));
    }

    public void a(DyeColor dyeColor) {
        a aVar = (a) this.b.get(MCTechDataComponent.REDSTONE_COUNT_FILTER);
        this.b.set(MCTechDataComponent.REDSTONE_COUNT_FILTER, new a(dyeColor, aVar.d, aVar.e, aVar.f));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/c/c$a.class */
    public static final class a extends Record {
        private final DyeColor c;
        private final int d;
        private final int e;
        private final boolean f;
        public static final Codec<a> a = RecordCodecBuilder.create(instance -> {
            return instance.group(DyeColor.CODEC.fieldOf("channel1").forGetter((v0) -> {
                return v0.a();
            }), ExtraCodecs.NON_NEGATIVE_INT.fieldOf("maxCount").forGetter((v0) -> {
                return v0.b();
            }), ExtraCodecs.NON_NEGATIVE_INT.fieldOf("ticks").forGetter((v0) -> {
                return v0.c();
            }), Codec.BOOL.fieldOf("deactivated").forGetter((v0) -> {
                return v0.d();
            })).apply(instance, (v1, v2, v3, v4) -> {
                return new a(v1, v2, v3, v4);
            });
        });
        public static final StreamCodec<ByteBuf, a> b = StreamCodec.composite(DyeColor.STREAM_CODEC, (v0) -> {
            return v0.a();
        }, ByteBufCodecs.VAR_INT, (v0) -> {
            return v0.b();
        }, ByteBufCodecs.VAR_INT, (v0) -> {
            return v0.c();
        }, ByteBufCodecs.BOOL, (v0) -> {
            return v0.d();
        }, (v1, v2, v3, v4) -> {
            return new a(v1, v2, v3, v4);
        });

        public a(DyeColor dyeColor, int i, int i2, boolean z) {
            this.c = dyeColor;
            this.d = i;
            this.e = i2;
            this.f = z;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "channel1;maxCount;count;deactivated", "FIELD:Lmctech/g/d/c/c$a;->c:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/c/c$a;->d:I", "FIELD:Lmctech/g/d/c/c$a;->e:I", "FIELD:Lmctech/g/d/c/c$a;->f:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "channel1;maxCount;count;deactivated", "FIELD:Lmctech/g/d/c/c$a;->c:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/c/c$a;->d:I", "FIELD:Lmctech/g/d/c/c$a;->e:I", "FIELD:Lmctech/g/d/c/c$a;->f:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "channel1;maxCount;count;deactivated", "FIELD:Lmctech/g/d/c/c$a;->c:Lnet/minecraft/world/item/DyeColor;", "FIELD:Lmctech/g/d/c/c$a;->d:I", "FIELD:Lmctech/g/d/c/c$a;->e:I", "FIELD:Lmctech/g/d/c/c$a;->f:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public DyeColor a() {
            return this.c;
        }

        public int b() {
            return this.d;
        }

        public int c() {
            return this.e;
        }

        public boolean d() {
            return this.f;
        }
    }
}
