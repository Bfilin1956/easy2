package net.mcskill.shop.common.response;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Discount.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/response/Discount.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lnet/mcskill/shop/common/response/Discount;", "", "minOrderAmount", "", "percentage", "", "<init>", "(ID)V", "getMinOrderAmount", "()I", "getPercentage", "()D", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "MSShop"})
public final /* data */ class Discount {
    private final int minOrderAmount;
    private final double percentage;

    public final int component1() {
        return this.minOrderAmount;
    }

    public final double component2() {
        return this.percentage;
    }

    @NotNull
    public final Discount copy(int minOrderAmount, double percentage) {
        return new Discount(minOrderAmount, percentage);
    }

    public static /* synthetic */ Discount copy$default(Discount discount, int i, double d, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = discount.minOrderAmount;
        }
        if ((i2 & 2) != 0) {
            d = discount.percentage;
        }
        return discount.copy(i, d);
    }

    @NotNull
    public String toString() {
        return "Discount(minOrderAmount=" + this.minOrderAmount + ", percentage=" + this.percentage + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.minOrderAmount);
        return (result * 31) + Double.hashCode(this.percentage);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Discount)) {
            return false;
        }
        Discount discount = (Discount) other;
        return this.minOrderAmount == discount.minOrderAmount && Double.compare(this.percentage, discount.percentage) == 0;
    }

    public Discount(int minOrderAmount, double percentage) {
        this.minOrderAmount = minOrderAmount;
        this.percentage = percentage;
    }

    public final int getMinOrderAmount() {
        return this.minOrderAmount;
    }

    public final double getPercentage() {
        return this.percentage;
    }
}
