package mctech.modules.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.mojang.serialization.MapCodec;
import io.netty.buffer.ByteBuf;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import javax.annotation.Nonnull;
import mctech.init.MCTechModules;
import mctech.items.base.l;
import mctech.modules.h;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/Tier.class */
public final class Tier extends Record implements ModuleConfig {

    @Nonnull
    private final l tier;
    public static final MapCodec<Tier> CODEC = l.i.xmap(Tier::new, (v0) -> {
        return v0.tier();
    });
    public static final StreamCodec<ByteBuf, Tier> STREAM_CODEC = l.j.map(Tier::new, (v0) -> {
        return v0.tier();
    });
    public static final JsonSerializer JSON_SERIALIZER = new JsonSerializer();

    public Tier(@Nonnull l lVar) {
        this.tier = lVar;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, Tier.class), Tier.class, "tier", "FIELD:Lmctech/modules/config/Tier;->tier:Lmctech/items/base/l;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, Tier.class), Tier.class, "tier", "FIELD:Lmctech/modules/config/Tier;->tier:Lmctech/items/base/l;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, Tier.class, Object.class), Tier.class, "tier", "FIELD:Lmctech/modules/config/Tier;->tier:Lmctech/items/base/l;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    @Override // mctech.modules.config.ModuleConfig
    @Nonnull
    public l tier() {
        return this.tier;
    }

    @Override // mctech.modules.config.ModuleConfig
    @NotNull
    public ModuleConfigJsonSerializer<?> getJsonSerializer() {
        return JSON_SERIALIZER;
    }

    @Override // mctech.modules.config.ModuleConfig
    @NotNull
    public MapCodec<? extends ModuleConfig> codec() {
        return MCTechModules.TIER.get();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/modules/config/Tier$JsonSerializer.class */
    public static class JsonSerializer implements ModuleConfigJsonSerializer<Tier> {
        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public Tier fromJson(@Nonnull JsonElement jsonElement) {
            return new Tier(h.a().a(ResourceLocation.parse(jsonElement.getAsString())));
        }

        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public JsonElement toJson(@Nonnull Tier tier) {
            return new JsonPrimitive(tier.tier().d().toString());
        }

        @Override // mctech.modules.config.ModuleConfigJsonSerializer
        @Nonnull
        public Class<Tier> getTypeClass() {
            return Tier.class;
        }
    }
}
