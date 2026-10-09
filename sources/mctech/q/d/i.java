package mctech.q.d;

import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.annotation.Nonnull;
import mctech.MCTech;
import mctech.init.MCTechTierConfigs;
import mctech.modules.config.ModularItemTierConfig;
import mctech.modules.config.ModuleConfig;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/i.class */
public final class i extends Record implements CustomPacketPayload {

    @Nonnull
    private final Set<mctech.modules.g<? extends ModuleConfig>> c;

    @Nonnull
    private final Map<mctech.items.base.l, ModularItemTierConfig> d;

    @Nonnull
    private final Optional<ResourceLocation> e;
    public static final CustomPacketPayload.Type<i> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "sync_data"));
    public static final StreamCodec<ByteBuf, i> b = StreamCodec.composite(ByteBufCodecs.collection(HashSet::new, mctech.modules.g.b, Integer.MAX_VALUE), (v0) -> {
        return v0.a();
    }, ByteBufCodecs.map(HashMap::new, mctech.items.base.l.j, ByteBufCodecs.fromCodec(MCTechTierConfigs.POLYMORPH_CODEC)), (v0) -> {
        return v0.b();
    }, ByteBufCodecs.optional(ResourceLocation.STREAM_CODEC), (v0) -> {
        return v0.c();
    }, i::new);

    public i(@Nonnull Set<mctech.modules.g<? extends ModuleConfig>> set, @Nonnull Map<mctech.items.base.l, ModularItemTierConfig> map, @Nonnull Optional<ResourceLocation> optional) {
        this.c = set;
        this.d = map;
        this.e = optional;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, i.class), i.class, "moduleConfigs;modularItemTierConfigs;location", "FIELD:Lmctech/q/d/i;->c:Ljava/util/Set;", "FIELD:Lmctech/q/d/i;->d:Ljava/util/Map;", "FIELD:Lmctech/q/d/i;->e:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, i.class), i.class, "moduleConfigs;modularItemTierConfigs;location", "FIELD:Lmctech/q/d/i;->c:Ljava/util/Set;", "FIELD:Lmctech/q/d/i;->d:Ljava/util/Map;", "FIELD:Lmctech/q/d/i;->e:Ljava/util/Optional;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, i.class, Object.class), i.class, "moduleConfigs;modularItemTierConfigs;location", "FIELD:Lmctech/q/d/i;->c:Ljava/util/Set;", "FIELD:Lmctech/q/d/i;->d:Ljava/util/Map;", "FIELD:Lmctech/q/d/i;->e:Ljava/util/Optional;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Nonnull
    public Set<mctech.modules.g<? extends ModuleConfig>> a() {
        return this.c;
    }

    @Nonnull
    public Map<mctech.items.base.l, ModularItemTierConfig> b() {
        return this.d;
    }

    @Nonnull
    public Optional<ResourceLocation> c() {
        return this.e;
    }

    public static void a(i iVar, IPayloadContext iPayloadContext) {
        mctech.modules.h.a().a(iVar);
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
