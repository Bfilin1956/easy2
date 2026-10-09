package mctech.modules;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.Objects;
import javax.annotation.Nonnull;
import mctech.init.MCTechModules;
import mctech.modules.config.ModuleConfig;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/g.class */
public final class g<C extends ModuleConfig> extends Record {

    @Nonnull
    private final e<C> c;

    @Nonnull
    private final C d;
    private final int e;
    public static final MapCodec<g<? extends ModuleConfig>> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(e.a.fieldOf("module").forGetter((v0) -> {
            return v0.a();
        }), MCTechModules.POLYMORPH_CODEC.fieldOf("config").forGetter((v0) -> {
            return v0.b();
        }), Codec.INT.fieldOf("level").forGetter((v0) -> {
            return v0.c();
        })).apply(instance, (v0, v1, v2) -> {
            return a(v0, v1, v2);
        });
    });
    public static final StreamCodec<ByteBuf, g<? extends ModuleConfig>> b = StreamCodec.composite(e.b, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.fromCodec(MCTechModules.POLYMORPH_CODEC), (v0) -> {
        return v0.b();
    }, ByteBufCodecs.INT, (v0) -> {
        return v0.c();
    }, (v0, v1, v2) -> {
        return a(v0, v1, v2);
    });

    public g(@Nonnull e<C> eVar, @Nonnull C c, int i) {
        this.c = eVar;
        this.d = c;
        this.e = i;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, g.class), g.class, "module;config;level", "FIELD:Lmctech/modules/g;->c:Lmctech/modules/e;", "FIELD:Lmctech/modules/g;->d:Lmctech/modules/config/ModuleConfig;", "FIELD:Lmctech/modules/g;->e:I").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Nonnull
    public e<C> a() {
        return this.c;
    }

    @Nonnull
    public C b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    @Override // java.lang.Record
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.e == gVar.e && Objects.equals(this.c, gVar.c);
    }

    @Override // java.lang.Record
    public int hashCode() {
        return Objects.hash(this.c, Integer.valueOf(this.e));
    }

    private static <C extends ModuleConfig> g<C> a(e<?> eVar, ModuleConfig moduleConfig, int i) {
        return new g<>(eVar, moduleConfig, i);
    }
}
