package net.mcskill.shop.client.screen.component;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Updatable.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/Updatable.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\b\u0010\t\u001a\u00020\u0004H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lnet/mcskill/shop/client/screen/component/Updatable;", "T", "", "add", "", "data", "(Ljava/lang/Object;)V", "addAll", "", "clear", "MSShop"})
@SourceDebugExtension({"SMAP\nUpdatable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Updatable.kt\nnet/mcskill/shop/client/screen/component/Updatable\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,9:1\n1863#2,2:10\n*S KotlinDebug\n*F\n+ 1 Updatable.kt\nnet/mcskill/shop/client/screen/component/Updatable\n*L\n6#1:10,2\n*E\n"})
public interface Updatable<T> {
    void add(T data);

    void clear();

    default void addAll(@NotNull List<? extends T> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        List<? extends T> $this$forEach$iv = data;
        Iterator<T> it = $this$forEach$iv.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }
}
