package mctech.q.d.c;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import mctech.MCTech;
import mctech.items.b.c;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/c/a.class */
public final class a extends Record implements CustomPacketPayload {
    private final String c;
    private final List<String> d;
    public static final CustomPacketPayload.Type<a> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "scp"));
    public static final StreamCodec<RegistryFriendlyByteBuf, a> b = StreamCodec.composite(ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.STRING_UTF8.apply(ByteBufCodecs.list()), (v0) -> {
        return v0.b();
    }, a::new);

    public a(String str, List<String> list) {
        this.c = str;
        this.d = list;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "name;items", "FIELD:Lmctech/q/d/c/a;->c:Ljava/lang/String;", "FIELD:Lmctech/q/d/c/a;->d:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "name;items", "FIELD:Lmctech/q/d/c/a;->c:Ljava/lang/String;", "FIELD:Lmctech/q/d/c/a;->d:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "name;items", "FIELD:Lmctech/q/d/c/a;->c:Ljava/lang/String;", "FIELD:Lmctech/q/d/c/a;->d:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public String a() {
        return this.c;
    }

    public List<String> b() {
        return this.d;
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }

    public static void a(@NotNull a aVar, IPayloadContext iPayloadContext) {
        c.a().a(aVar);
    }

    public static void b(a aVar, IPayloadContext iPayloadContext) {
    }
}
