package mctech.q.d;

import io.netty.buffer.ByteBuf;
import javax.annotation.Nonnull;
import mctech.MCTech;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/g.class */
public class g implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<g> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "sync_config"));
    public static final g b = new g();
    public static final StreamCodec<ByteBuf, g> c = StreamCodec.unit(b);

    private g() {
    }

    public static void a(@Nonnull g gVar, @Nonnull IPayloadContext iPayloadContext) {
        a();
    }

    @OnlyIn(Dist.CLIENT)
    private static void a() {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }
}
