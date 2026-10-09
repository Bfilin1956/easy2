package mctech.g.d.c;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.init.MCTechDataComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/c/m.class */
public class m implements mctech.g.a.e.d {
    public static final a a = new a(1, 20);
    private final ItemStack b;

    public m(ItemStack itemStack) {
        this.b = itemStack;
    }

    @Override // mctech.g.a.e.d
    public int a(Level level, BlockPos blockPos, Direction direction) {
        int iB = b() + 2;
        int iA = a();
        if (iB >= iA) {
            a(0, iA);
            return 15;
        }
        a(iB, iA);
        return 0;
    }

    public int a() {
        return ((a) this.b.getOrDefault(MCTechDataComponent.REDSTONE_TIMER_FILTER, a)).b();
    }

    public int b() {
        return ((a) this.b.getOrDefault(MCTechDataComponent.REDSTONE_TIMER_FILTER, a)).a();
    }

    public void a(int i, int i2) {
        this.b.set(MCTechDataComponent.REDSTONE_TIMER_FILTER, new a(Math.max(1, i), Math.max(1, i2)));
    }

    public void a(int i) {
        this.b.set(MCTechDataComponent.REDSTONE_TIMER_FILTER, new a(1, Math.max(1, i)));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/c/m$a.class */
    public static final class a extends Record {
        private final int c;
        private final int d;
        public static final Codec<a> a = RecordCodecBuilder.create(instance -> {
            return instance.group(ExtraCodecs.POSITIVE_INT.fieldOf("ticks").forGetter(aVar -> {
                return Integer.valueOf(aVar.d);
            }), ExtraCodecs.POSITIVE_INT.fieldOf("maxTicks").forGetter(aVar2 -> {
                return Integer.valueOf(aVar2.d);
            })).apply(instance, (v1, v2) -> {
                return new a(v1, v2);
            });
        });
        public static final StreamCodec<ByteBuf, a> b = StreamCodec.composite(ByteBufCodecs.VAR_INT, (v0) -> {
            return v0.a();
        }, ByteBufCodecs.VAR_INT, (v0) -> {
            return v0.b();
        }, (v1, v2) -> {
            return new a(v1, v2);
        });

        public a(int i, int i2) {
            this.c = i;
            this.d = i2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "ticks;maxTicks", "FIELD:Lmctech/g/d/c/m$a;->c:I", "FIELD:Lmctech/g/d/c/m$a;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "ticks;maxTicks", "FIELD:Lmctech/g/d/c/m$a;->c:I", "FIELD:Lmctech/g/d/c/m$a;->d:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "ticks;maxTicks", "FIELD:Lmctech/g/d/c/m$a;->c:I", "FIELD:Lmctech/g/d/c/m$a;->d:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public int a() {
            return this.c;
        }

        public int b() {
            return this.d;
        }
    }
}
