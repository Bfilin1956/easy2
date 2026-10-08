package net.mcskill.shop.common.network;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ListType.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/ListType.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lnet/mcskill/shop/common/network/ListType;", "", "<init>", "(Ljava/lang/String;I)V", "ITEM", "CASE", "GROUP", "CART_GROUP", "CART_CASE", "CART_ITEM", "MSShop"})
public enum ListType {
    ITEM,
    CASE,
    GROUP,
    CART_GROUP,
    CART_CASE,
    CART_ITEM;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    @NotNull
    public static EnumEntries<ListType> getEntries() {
        return $ENTRIES;
    }
}
