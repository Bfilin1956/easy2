package net.mcskill.shop.common.network.packet.sync;

import gg.essential.universal.UScreen;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import net.mcskill.shop.common.network.PacketHandleable;
import net.mcskill.shop.common.response.shop.CategoryData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ResponseCategoriesPacket.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/sync/ResponseCategoriesPacket.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\nH\u0016J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lnet/mcskill/shop/common/network/packet/sync/ResponseCategoriesPacket;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "categories", "", "Lnet/mcskill/shop/common/response/shop/CategoryData;", "<init>", "(Ljava/util/List;)V", "getCategories", "()Ljava/util/List;", "type", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "MSShop"})
public final /* data */ class ResponseCategoriesPacket implements CustomPacketPayload {

    @NotNull
    private final List<CategoryData> categories;
    private static final StreamCodec<FriendlyByteBuf, ResponseCategoriesPacket> CODEC;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CustomPacketPayload.Type<ResponseCategoriesPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("msshop", "categories"));

    @NotNull
    public final List<CategoryData> component1() {
        return this.categories;
    }

    @NotNull
    public final ResponseCategoriesPacket copy(@NotNull List<CategoryData> categories) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        return new ResponseCategoriesPacket(categories);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResponseCategoriesPacket copy$default(ResponseCategoriesPacket responseCategoriesPacket, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = responseCategoriesPacket.categories;
        }
        return responseCategoriesPacket.copy(list);
    }

    @NotNull
    public String toString() {
        return "ResponseCategoriesPacket(categories=" + this.categories + ")";
    }

    public int hashCode() {
        return this.categories.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ResponseCategoriesPacket) && Intrinsics.areEqual(this.categories, ((ResponseCategoriesPacket) other).categories);
    }

    public ResponseCategoriesPacket() {
        this(null, 1, null);
    }

    public ResponseCategoriesPacket(@NotNull List<CategoryData> list) {
        Intrinsics.checkNotNullParameter(list, "categories");
        this.categories = list;
    }

    public /* synthetic */ ResponseCategoriesPacket(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    @NotNull
    public final List<CategoryData> getCategories() {
        return this.categories;
    }

    /* JADX INFO: compiled from: ResponseCategoriesPacket.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/sync/ResponseCategoriesPacket$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRS\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006 \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\n0\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/network/packet/sync/ResponseCategoriesPacket$Companion;", "", "<init>", "()V", "TYPE", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "Lnet/mcskill/shop/common/network/packet/sync/ResponseCategoriesPacket;", "getTYPE", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/FriendlyByteBuf;", "kotlin.jvm.PlatformType", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "handle", "", "packet", "context", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CustomPacketPayload.Type<ResponseCategoriesPacket> getTYPE() {
            return ResponseCategoriesPacket.TYPE;
        }

        public final StreamCodec<FriendlyByteBuf, ResponseCategoriesPacket> getCODEC() {
            return ResponseCategoriesPacket.CODEC;
        }

        public final void handle(@NotNull ResponseCategoriesPacket packet, @NotNull IPayloadContext context) {
            Intrinsics.checkNotNullParameter(packet, "packet");
            Intrinsics.checkNotNullParameter(context, "context");
            PacketHandleable currentScreen = UScreen.Companion.getCurrentScreen();
            PacketHandleable packetHandleable = currentScreen instanceof PacketHandleable ? currentScreen : null;
            if (packetHandleable != null) {
                packetHandleable.handlePacket(packet);
            }
        }
    }

    static {
        StreamCodec streamCodecApply = CategoryData.INSTANCE.getCODEC().apply(ByteBufCodecs.list());
        KProperty1 kProperty1 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseCategoriesPacket$Companion$CODEC$1
            public Object get(Object receiver0) {
                return ((ResponseCategoriesPacket) receiver0).getCategories();
            }
        };
        CODEC = StreamCodec.composite(streamCodecApply, (v1) -> {
            return CODEC$lambda$0(r1, v1);
        }, ResponseCategoriesPacket::new);
    }

    private static final List CODEC$lambda$0(KProperty1 $tmp0, ResponseCategoriesPacket p0) {
        return (List) ((Function1) $tmp0).invoke(p0);
    }

    @NotNull
    public CustomPacketPayload.Type<ResponseCategoriesPacket> type() {
        return TYPE;
    }
}
