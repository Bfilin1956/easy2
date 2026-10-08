package net.mcskill.shop.client.screen.component;

import kotlin.Metadata;

/* JADX INFO: compiled from: Context.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/Context.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lnet/mcskill/shop/client/screen/component/Context;", "", "closeContext", "", "instantly", "", "MSShop"})
public interface Context {
    void closeContext(boolean instantly);

    static /* synthetic */ void closeContext$default(Context context, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closeContext");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        context.closeContext(z);
    }
}
