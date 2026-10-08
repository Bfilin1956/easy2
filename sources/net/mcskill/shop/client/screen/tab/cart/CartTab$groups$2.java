package net.mcskill.shop.client.screen.tab.cart;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import net.mcskill.shop.common.response.shop.GroupData;

/* JADX INFO: compiled from: CartTab.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/tab/cart/CartTab$groups$2.class */
@Metadata(mv = {2, 0, 0}, k = 3, xi = 48)
/* synthetic */ class CartTab$groups$2 extends FunctionReferenceImpl implements Function1<GroupData, CartGroupEntry> {
    public static final CartTab$groups$2 INSTANCE = new CartTab$groups$2();

    CartTab$groups$2() {
        super(1, CartGroupEntry.class, "<init>", "<init>(Lnet/mcskill/shop/common/response/shop/GroupData;)V", 0);
    }

    public final CartGroupEntry invoke(GroupData p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CartGroupEntry(p0);
    }
}
