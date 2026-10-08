package net.mcskill.shop.client.screen.component.input;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractTextInput.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/input/AbstractTextInput$getNearestWordBoundary$nextChar$2.class */
@Metadata(mv = {2, 0, 0}, k = 3, xi = 48)
/* synthetic */ class AbstractTextInput$getNearestWordBoundary$nextChar$2 extends FunctionReferenceImpl implements Function1<AbstractTextInput.LinePosition, Character> {
    AbstractTextInput$getNearestWordBoundary$nextChar$2(Object receiver) {
        super(1, receiver, AbstractTextInput.class, "charAfter", "charAfter(Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$LinePosition;)Ljava/lang/Character;", 0);
    }

    public final Character invoke(AbstractTextInput.LinePosition p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((AbstractTextInput) this.receiver).charAfter(p0);
    }
}
