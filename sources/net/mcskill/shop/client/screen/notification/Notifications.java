package net.mcskill.shop.client.screen.notification;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.universal.UScreen;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.mcskill.shop.common.response.Notifiable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Notifications.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/notification/Notifications.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0010\u001a\u00020\bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lnet/mcskill/shop/client/screen/notification/Notifications;", "", "<init>", "()V", "_notificationsQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lnet/mcskill/shop/client/screen/notification/NotificationContainer;", "push", "", "text", "", "status", "Lnet/mcskill/shop/client/screen/notification/ShopNotification$Status;", "duration", "", "clear", "takeFromQueue", "MSShop"})
public final class Notifications {

    @NotNull
    public static final Notifications INSTANCE = new Notifications();

    @NotNull
    private static final ConcurrentLinkedQueue<NotificationContainer> _notificationsQueue = new ConcurrentLinkedQueue<>();

    private Notifications() {
    }

    public static /* synthetic */ void push$default(Notifications notifications, String str, ShopNotification.Status status, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = 5.0f;
        }
        notifications.push(str, status, f);
    }

    public final void push(@NotNull String text, @NotNull ShopNotification.Status status, float duration) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(status, "status");
        Notifiable currentScreen = UScreen.Companion.getCurrentScreen();
        Notifiable notifiable = currentScreen instanceof Notifiable ? currentScreen : null;
        if (notifiable == null) {
            return;
        }
        Notifiable screen = notifiable;
        UIComponent notificationContainer = new NotificationContainer(text, status, duration, new Notifications$push$notify$1(this));
        if (screen.mo10getNotificationSection().getChildren().size() < 5) {
            ComponentsKt.childOf(notificationContainer, screen.mo10getNotificationSection());
            notificationContainer.animateIn();
        } else {
            _notificationsQueue.add(notificationContainer);
        }
    }

    public final void clear() {
        _notificationsQueue.clear();
        Notifiable currentScreen = UScreen.Companion.getCurrentScreen();
        Notifiable notifiable = currentScreen instanceof Notifiable ? currentScreen : null;
        if (notifiable == null) {
            return;
        }
        Notifiable screen = notifiable;
        screen.mo10getNotificationSection().getChildren().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void takeFromQueue() {
        Notifiable currentScreen = UScreen.Companion.getCurrentScreen();
        Notifiable notifiable = currentScreen instanceof Notifiable ? currentScreen : null;
        if (notifiable == null) {
            return;
        }
        Notifiable screen = notifiable;
        UIComponent uIComponent = (NotificationContainer) _notificationsQueue.poll();
        if (uIComponent == null) {
            return;
        }
        ComponentsKt.childOf(uIComponent, screen.mo10getNotificationSection());
        uIComponent.animateIn();
    }
}
