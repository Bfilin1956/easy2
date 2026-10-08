package net.mcskill.shop.client.screen.tab.cart;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import net.mcskill.shop.common.response.shop.ItemData;

/* JADX INFO: compiled from: CartTab.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/tab/cart/CartTab$items$2.class */
@Metadata(mv = {2, 0, 0}, k = 3, xi = 48)
/* synthetic */ class CartTab$items$2 extends FunctionReferenceImpl implements Function1<ItemData, CartItemEntry> {
    public static final CartTab$items$2 INSTANCE = new CartTab$items$2();

    CartTab$items$2() {
        super(1, CartItemEntry.class, "<init>", "<init>(Lnet/mcskill/shop/common/response/shop/ItemData;)V", 0);
    }

    public final CartItemEntry invoke(ItemData p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new CartItemEntry(p0);
    }
}
