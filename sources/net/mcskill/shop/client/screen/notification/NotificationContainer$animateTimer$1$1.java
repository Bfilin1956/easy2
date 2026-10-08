package net.mcskill.shop.client.screen.notification;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: compiled from: NotificationContainer.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/notification/NotificationContainer$animateTimer$1$1.class */
@Metadata(mv = {2, 0, 0}, k = 3, xi = 48)
/* synthetic */ class NotificationContainer$animateTimer$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    NotificationContainer$animateTimer$1$1(Object receiver) {
        super(0, receiver, NotificationContainer.class, "animateOut", "animateOut()V", 0);
    }

    public final void invoke() {
        ((NotificationContainer) this.receiver).animateOut();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m75invoke() {
        invoke();
        return Unit.INSTANCE;
    }
}
