package mctech.h.b;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import mctech.MCTech;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/h/b/b.class */
public final class b extends Record implements CustomPacketPayload {
    private final String c;
    private final Map<String, JsonElement> d;
    public static final CustomPacketPayload.Type<b> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "config_sync"));
    public static final StreamCodec<RegistryFriendlyByteBuf, b> b = StreamCodec.of((registryFriendlyByteBuf, bVar) -> {
        registryFriendlyByteBuf.writeUtf(bVar.a());
        ByteBufCodecs.writeCount(registryFriendlyByteBuf, bVar.b().size(), Integer.MAX_VALUE);
        bVar.b().forEach((str, jsonElement) -> {
            registryFriendlyByteBuf.writeUtf(str);
            registryFriendlyByteBuf.writeUtf(jsonElement.toString());
        });
    }, registryFriendlyByteBuf2 -> {
        String utf = registryFriendlyByteBuf2.readUtf();
        int count = ByteBufCodecs.readCount(registryFriendlyByteBuf2, Integer.MAX_VALUE);
        HashMap map = new HashMap();
        for (int i = 0; i < count; i++) {
            map.put(registryFriendlyByteBuf2.readUtf(), JsonParser.parseString(registryFriendlyByteBuf2.readUtf()));
        }
        return new b(utf, map);
    });

    public b(String str, Map<String, JsonElement> map) {
        this.c = str;
        this.d = map;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "configEntry;configEntries", "FIELD:Lmctech/h/b/b;->c:Ljava/lang/String;", "FIELD:Lmctech/h/b/b;->d:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "configEntry;configEntries", "FIELD:Lmctech/h/b/b;->c:Ljava/lang/String;", "FIELD:Lmctech/h/b/b;->d:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "configEntry;configEntries", "FIELD:Lmctech/h/b/b;->c:Ljava/lang/String;", "FIELD:Lmctech/h/b/b;->d:Ljava/util/Map;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public String a() {
        return this.c;
    }

    public Map<String, JsonElement> b() {
        return this.d;
    }

    @Nonnull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
