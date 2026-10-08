package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.state.State;
import java.lang.Number;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContentEntry.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/DiscountableEntry.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00028\u0000X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lnet/mcskill/shop/client/screen/component/DiscountableEntry;", "T", "", "", "discountState", "Lgg/essential/elementa/state/State;", "getDiscountState", "()Lgg/essential/elementa/state/State;", "discount", "getDiscount", "()Ljava/lang/Number;", "setDiscount", "(Ljava/lang/Number;)V", "MSShop"})
public interface DiscountableEntry<T extends Number> {
    @NotNull
    State<T> getDiscountState();

    @NotNull
    T getDiscount();

    void setDiscount(@NotNull T t);
}
