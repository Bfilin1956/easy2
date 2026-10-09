package mctech.items.e.c;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.Mth;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/c/e.class */
public final class e extends Record {
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final boolean h;
    public static final e a = new e(6, 5, 4, 3, true);
    public static final Codec<e> b = RecordCodecBuilder.create(instance -> {
        return instance.group(Codec.INT.fieldOf("miningArea").forGetter((v0) -> {
            return v0.e();
        }), Codec.INT.fieldOf("miningDepth").forGetter((v0) -> {
            return v0.f();
        }), Codec.INT.fieldOf("miningSpeed").forGetter((v0) -> {
            return v0.g();
        }), Codec.INT.fieldOf("splashDamageRadius").forGetter((v0) -> {
            return v0.h();
        }), Codec.BOOL.optionalFieldOf("silkTouch", true).forGetter((v0) -> {
            return v0.i();
        })).apply(instance, (v1, v2, v3, v4, v5) -> {
            return new e(v1, v2, v3, v4, v5);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, e> c = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
        return v0.e();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.f();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.g();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.h();
    }, ByteBufCodecs.BOOL, (v0) -> {
        return v0.i();
    }, (v1, v2, v3, v4, v5) -> {
        return new e(v1, v2, v3, v4, v5);
    });

    public e(int i, int i2, int i3, int i4, boolean z) {
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = z;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, e.class), e.class, "miningArea;miningDepth;miningSpeed;splashDamageRadius;silkTouch", "FIELD:Lmctech/items/e/c/e;->d:I", "FIELD:Lmctech/items/e/c/e;->e:I", "FIELD:Lmctech/items/e/c/e;->f:I", "FIELD:Lmctech/items/e/c/e;->g:I", "FIELD:Lmctech/items/e/c/e;->h:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, e.class), e.class, "miningArea;miningDepth;miningSpeed;splashDamageRadius;silkTouch", "FIELD:Lmctech/items/e/c/e;->d:I", "FIELD:Lmctech/items/e/c/e;->e:I", "FIELD:Lmctech/items/e/c/e;->f:I", "FIELD:Lmctech/items/e/c/e;->g:I", "FIELD:Lmctech/items/e/c/e;->h:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, e.class, Object.class), e.class, "miningArea;miningDepth;miningSpeed;splashDamageRadius;silkTouch", "FIELD:Lmctech/items/e/c/e;->d:I", "FIELD:Lmctech/items/e/c/e;->e:I", "FIELD:Lmctech/items/e/c/e;->f:I", "FIELD:Lmctech/items/e/c/e;->g:I", "FIELD:Lmctech/items/e/c/e;->h:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.e;
    }

    public int g() {
        return this.f;
    }

    public int h() {
        return this.g;
    }

    public boolean i() {
        return this.h;
    }

    public e a(int i) {
        return new e(i, this.e, this.f, this.g, this.h);
    }

    public e b(int i) {
        return new e(this.d, i, this.f, this.g, this.h);
    }

    public e c(int i) {
        return new e(this.d, this.e, i, this.g, this.h);
    }

    public e d(int i) {
        return new e(this.d, this.e, this.f, i, this.h);
    }

    public e a(boolean z) {
        return new e(this.d, this.e, this.f, this.g, z);
    }

    public int a() {
        return Mth.clamp(this.d, 0, 6);
    }

    public int b() {
        return Mth.clamp(this.e, 0, 5);
    }

    public int c() {
        switch (Math.clamp(this.f, 0, 4)) {
            case 1:
                return 5;
            case 2:
                return 15;
            case 3:
                return 20;
            case 4:
                return 150;
            default:
                return 1;
        }
    }

    public int d() {
        return (int) Mth.map(Mth.clamp(this.g, 0, 3), 0.0f, 3.0f, 1.0f, 7.0f);
    }
}
