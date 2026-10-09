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
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/c/l.class */
public class l implements mctech.g.a.e.e {
    public static final a a = new a(false, true);
    private final ItemStack b;

    public l(ItemStack itemStack) {
        this.b = itemStack;
    }

    @Override // mctech.g.a.e.e
    public int a(mctech.g.a.e.f fVar, DyeColor dyeColor) {
        boolean zA = a();
        if (fVar.a(dyeColor) && b()) {
            zA = !zA;
            a(zA, false);
        }
        if (!fVar.a(dyeColor) && !b()) {
            a(zA, true);
        }
        return zA ? 15 : 0;
    }

    public boolean a() {
        return ((a) this.b.get(MCTechDataComponent.REDSTONE_TLATCH_FILTER)).a();
    }

    public boolean b() {
        return ((a) this.b.get(MCTechDataComponent.REDSTONE_TLATCH_FILTER)).b();
    }

    public void a(boolean z, boolean z2) {
        this.b.set(MCTechDataComponent.REDSTONE_TLATCH_FILTER, new a(z, z2));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/c/l$a.class */
    public static final class a extends Record {
        private final boolean c;
        private final boolean d;
        public static final Codec<a> a = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.BOOL.fieldOf("deactivated").forGetter((v0) -> {
                return v0.a();
            }), Codec.BOOL.fieldOf("deactivated").forGetter((v0) -> {
                return v0.b();
            })).apply(instance, (v1, v2) -> {
                return new a(v1, v2);
            });
        });
        public static final StreamCodec<ByteBuf, a> b = StreamCodec.composite(ByteBufCodecs.BOOL, (v0) -> {
            return v0.a();
        }, ByteBufCodecs.BOOL, (v0) -> {
            return v0.b();
        }, (v1, v2) -> {
            return new a(v1, v2);
        });

        public a(boolean z, boolean z2) {
            this.c = z;
            this.d = z2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "active;deactivated", "FIELD:Lmctech/g/d/c/l$a;->c:Z", "FIELD:Lmctech/g/d/c/l$a;->d:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "active;deactivated", "FIELD:Lmctech/g/d/c/l$a;->c:Z", "FIELD:Lmctech/g/d/c/l$a;->d:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "active;deactivated", "FIELD:Lmctech/g/d/c/l$a;->c:Z", "FIELD:Lmctech/g/d/c/l$a;->d:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public boolean a() {
            return this.c;
        }

        public boolean b() {
            return this.d;
        }
    }
}
