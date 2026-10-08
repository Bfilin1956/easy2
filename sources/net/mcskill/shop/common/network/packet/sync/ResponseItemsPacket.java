package net.mcskill.shop.common.network.packet.sync;

import gg.essential.universal.UScreen;
import java.util.List;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;
import net.mcskill.shop.common.network.ListType;
import net.mcskill.shop.common.network.PacketHandleable;
import net.mcskill.shop.common.response.shop.ItemData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ResponseItemsPacket.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/sync/ResponseItemsPacket.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\rH\u0016J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000b¨\u0006\u0019"}, d2 = {"Lnet/mcskill/shop/common/network/packet/sync/ResponseItemsPacket;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "items", "", "Lnet/mcskill/shop/common/response/shop/ItemData;", "isCart", "", "<init>", "(Ljava/util/List;Z)V", "getItems", "()Ljava/util/List;", "()Z", "type", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "MSShop"})
public final /* data */ class ResponseItemsPacket implements CustomPacketPayload {

    @NotNull
    private final List<ItemData> items;
    private final boolean isCart;
    private static final StreamCodec<FriendlyByteBuf, ResponseItemsPacket> CODEC;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final CustomPacketPayload.Type<ResponseItemsPacket> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("msshop", "items"));

    @NotNull
    public final List<ItemData> component1() {
        return this.items;
    }

    public final boolean component2() {
        return this.isCart;
    }

    @NotNull
    public final ResponseItemsPacket copy(@NotNull List<ItemData> items, boolean isCart) {
        Intrinsics.checkNotNullParameter(items, "items");
        return new ResponseItemsPacket(items, isCart);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResponseItemsPacket copy$default(ResponseItemsPacket responseItemsPacket, List list, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = responseItemsPacket.items;
        }
        if ((i & 2) != 0) {
            z = responseItemsPacket.isCart;
        }
        return responseItemsPacket.copy(list, z);
    }

    @NotNull
    public String toString() {
        return "ResponseItemsPacket(items=" + this.items + ", isCart=" + this.isCart + ")";
    }

    public int hashCode() {
        int result = this.items.hashCode();
        return (result * 31) + Boolean.hashCode(this.isCart);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponseItemsPacket)) {
            return false;
        }
        ResponseItemsPacket responseItemsPacket = (ResponseItemsPacket) other;
        return Intrinsics.areEqual(this.items, responseItemsPacket.items) && this.isCart == responseItemsPacket.isCart;
    }

    public ResponseItemsPacket() {
        this(null, false, 3, null);
    }

    public ResponseItemsPacket(@NotNull List<ItemData> list, boolean isCart) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.items = list;
        this.isCart = isCart;
    }

    public /* synthetic */ ResponseItemsPacket(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? false : z);
    }

    @NotNull
    public final List<ItemData> getItems() {
        return this.items;
    }

    public final boolean isCart() {
        return this.isCart;
    }

    /* JADX INFO: compiled from: ResponseItemsPacket.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/packet/sync/ResponseItemsPacket$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bRS\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006 \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\n0\n¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/network/packet/sync/ResponseItemsPacket$Companion;", "", "<init>", "()V", "TYPE", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "Lnet/mcskill/shop/common/network/packet/sync/ResponseItemsPacket;", "getTYPE", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "CODEC", "Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/FriendlyByteBuf;", "kotlin.jvm.PlatformType", "getCODEC", "()Lnet/minecraft/network/codec/StreamCodec;", "Lnet/minecraft/network/codec/StreamCodec;", "handle", "", "packet", "context", "Lnet/neoforged/neoforge/network/handling/IPayloadContext;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CustomPacketPayload.Type<ResponseItemsPacket> getTYPE() {
            return ResponseItemsPacket.TYPE;
        }

        public final StreamCodec<FriendlyByteBuf, ResponseItemsPacket> getCODEC() {
            return ResponseItemsPacket.CODEC;
        }

        public final void handle(@NotNull ResponseItemsPacket packet, @NotNull IPayloadContext context) {
            Intrinsics.checkNotNullParameter(packet, "packet");
            Intrinsics.checkNotNullParameter(context, "context");
            ListType type = packet.isCart() ? ListType.CART_ITEM : ListType.ITEM;
            PacketHandleable currentScreen = UScreen.Companion.getCurrentScreen();
            PacketHandleable packetHandleable = currentScreen instanceof PacketHandleable ? currentScreen : null;
            if (packetHandleable != null) {
                packetHandleable.updateList(packet.getItems(), type);
            }
        }
    }

    static {
        StreamCodec streamCodecApply = ItemData.INSTANCE.getCODEC().apply(ByteBufCodecs.list());
        KProperty1 kProperty1 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseItemsPacket$Companion$CODEC$1
            public Object get(Object receiver0) {
                return ((ResponseItemsPacket) receiver0).getItems();
            }
        };
        Function function = (v1) -> {
            return CODEC$lambda$0(r1, v1);
        };
        StreamCodec streamCodec = ByteBufCodecs.BOOL;
        KProperty1 kProperty2 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.packet.sync.ResponseItemsPacket$Companion$CODEC$2
            public Object get(Object receiver0) {
                return Boolean.valueOf(((ResponseItemsPacket) receiver0).isCart());
            }
        };
        CODEC = StreamCodec.composite(streamCodecApply, function, streamCodec, (v1) -> {
            return CODEC$lambda$1(r3, v1);
        }, (v1, v2) -> {
            return new ResponseItemsPacket(v1, v2);
        });
    }

    private static final List CODEC$lambda$0(KProperty1 $tmp0, ResponseItemsPacket p0) {
        return (List) ((Function1) $tmp0).invoke(p0);
    }

    private static final Boolean CODEC$lambda$1(KProperty1 $tmp0, ResponseItemsPacket p0) {
        return (Boolean) ((Function1) $tmp0).invoke(p0);
    }

    @NotNull
    public CustomPacketPayload.Type<ResponseItemsPacket> type() {
        return TYPE;
    }
}
