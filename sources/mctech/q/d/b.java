package mctech.q.d;

import io.netty.buffer.ByteBuf;
import javax.annotation.Nonnull;
import mctech.MCTech;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/b.class */
public final class b implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<b> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "open_equipment"));
    public static final b b = new b();
    public static final StreamCodec<ByteBuf, b> c = StreamCodec.unit(b);

    private b() {
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }

    public static void a(@Nonnull b bVar, @Nonnull IPayloadContext iPayloadContext) {
    }
}
