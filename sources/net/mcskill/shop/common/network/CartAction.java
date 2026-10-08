package net.mcskill.shop.common.network;

import java.util.Collection;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty1;
import net.minecraft.util.ByIdMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CartAction.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/CartAction.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lnet/mcskill/shop/common/network/CartAction;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "ACTIVATE_GROUP", "OPEN_CASE", "OPEN_BUY_CASE", "OPEN_DUST_CASE", "TAKE_ITEM", "Companion", "MSShop"})
@SourceDebugExtension({"SMAP\nCartAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CartAction.kt\nnet/mcskill/shop/common/network/CartAction\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,22:1\n37#2,2:23\n*S KotlinDebug\n*F\n+ 1 CartAction.kt\nnet/mcskill/shop/common/network/CartAction\n*L\n16#1:23,2\n*E\n"})
public enum CartAction {
    NONE,
    ACTIVATE_GROUP,
    OPEN_CASE,
    OPEN_BUY_CASE,
    OPEN_DUST_CASE,
    TAKE_ITEM;

    private static final IntFunction<CartAction> BY_ID;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    static {
        KProperty1 kProperty1 = new PropertyReference1Impl() { // from class: net.mcskill.shop.common.network.CartAction$Companion$BY_ID$1
            public Object get(Object receiver0) {
                return Integer.valueOf(((CartAction) receiver0).ordinal());
            }
        };
        ToIntFunction toIntFunction = (v1) -> {
            return BY_ID$lambda$0(r0, v1);
        };
        Collection $this$toTypedArray$iv = getEntries();
        BY_ID = ByIdMap.continuous(toIntFunction, $this$toTypedArray$iv.toArray(new CartAction[0]), ByIdMap.OutOfBoundsStrategy.ZERO);
    }

    /* JADX INFO: compiled from: CartAction.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/common/network/CartAction$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rR7\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lnet/mcskill/shop/common/network/CartAction$Companion;", "", "<init>", "()V", "BY_ID", "Ljava/util/function/IntFunction;", "Lnet/mcskill/shop/common/network/CartAction;", "kotlin.jvm.PlatformType", "getBY_ID", "()Ljava/util/function/IntFunction;", "Ljava/util/function/IntFunction;", "fetchBy", "index", "", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        public final IntFunction<CartAction> getBY_ID() {
            return CartAction.BY_ID;
        }

        @NotNull
        public final CartAction fetchBy(int index) {
            return (CartAction) CartAction.getEntries().get(index % CartAction.getEntries().size());
        }
    }

    private static final int BY_ID$lambda$0(KProperty1 $tmp0, CartAction p0) {
        return ((Number) ((Function1) $tmp0).invoke(p0)).intValue();
    }

    @NotNull
    public static EnumEntries<CartAction> getEntries() {
        return $ENTRIES;
    }
}
