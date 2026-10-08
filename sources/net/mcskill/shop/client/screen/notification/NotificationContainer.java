package net.mcskill.shop.client.screen.notification;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.components.UIBlock;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.constraints.ChildBasedMaxSizeConstraint;
import gg.essential.elementa.constraints.HeightConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.constraints.WidthConstraint;
import gg.essential.elementa.constraints.XConstraint;
import gg.essential.elementa.constraints.YConstraint;
import gg.essential.elementa.constraints.animation.AnimatingConstraints;
import gg.essential.elementa.constraints.animation.Animations;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSPalette;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NotificationContainer.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/notification/NotificationContainer.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0018\u001a\u00020\nJ\b\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lnet/mcskill/shop/client/screen/notification/NotificationContainer;", "Lgg/essential/elementa/components/UIContainer;", "_text", "", "status", "Lnet/mcskill/shop/client/screen/notification/ShopNotification$Status;", "_duration", "", "_onClose", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Lnet/mcskill/shop/client/screen/notification/ShopNotification$Status;FLkotlin/jvm/functions/Function0;)V", "_timer", "Lgg/essential/elementa/components/UIBlock;", "get_timer", "()Lgg/essential/elementa/components/UIBlock;", "_timer$delegate", "Lkotlin/properties/ReadWriteProperty;", "_content", "Lnet/mcskill/shop/client/screen/notification/ShopNotification;", "get_content", "()Lnet/mcskill/shop/client/screen/notification/ShopNotification;", "_content$delegate", "animateIn", "animateTimer", "animateOut", "dismissInstantly", "MSShop"})
@SourceDebugExtension({"SMAP\nNotificationContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotificationContainer.kt\nnet/mcskill/shop/client/screen/notification/NotificationContainer\n+ 2 animations.kt\ngg/essential/elementa/dsl/AnimationsKt\n*L\n1#1,61:1\n10#2,5:62\n10#2,5:67\n10#2,5:72\n10#2,5:77\n*S KotlinDebug\n*F\n+ 1 NotificationContainer.kt\nnet/mcskill/shop/client/screen/notification/NotificationContainer\n*L\n31#1:62,5\n40#1:67,5\n46#1:72,5\n49#1:77,5\n*E\n"})
public final class NotificationContainer extends UIContainer {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(NotificationContainer.class, "_timer", "get_timer()Lgg/essential/elementa/components/UIBlock;", 0)), Reflection.property1(new PropertyReference1Impl(NotificationContainer.class, "_content", "get_content()Lnet/mcskill/shop/client/screen/notification/ShopNotification;", 0))};

    @NotNull
    private final String _text;
    private final float _duration;

    @NotNull
    private final Function0<Unit> _onClose;

    /* JADX INFO: renamed from: _timer$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _timer;

    /* JADX INFO: renamed from: _content$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _content;

    public /* synthetic */ NotificationContainer(String str, ShopNotification.Status status, float f, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, status, f, (i & 8) != 0 ? NotificationContainer::_init_$lambda$0 : function0);
    }

    private static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }

    public NotificationContainer(@NotNull String _text, @NotNull ShopNotification.Status status, float _duration, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(_text, "_text");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(function0, "_onClose");
        this._text = _text;
        this._duration = _duration;
        this._onClose = function0;
        this._timer = ComponentsKt.provideDelegate(ComponentsKt.childOf(new UIBlock(MSPalette.INSTANCE.getBlue()), (UIComponent) this), this, $$delegatedProperties[0]);
        this._content = ComponentsKt.provideDelegate(ComponentsKt.childOf(new ShopNotification(this._text, status), (UIComponent) this), this, $$delegatedProperties[1]);
        setX((XConstraint) UtilitiesKt.dp((Number) 0, true, true));
        setY((YConstraint) new SiblingConstraint(0.0f, false, false, 7, (DefaultConstructorMarker) null));
        setWidth((WidthConstraint) new ChildBasedMaxSizeConstraint());
        setHeight((HeightConstraint) new ChildBasedMaxSizeConstraint());
    }

    private final UIBlock get_timer() {
        return (UIBlock) this._timer.getValue(this, $$delegatedProperties[0]);
    }

    private final ShopNotification get_content() {
        return (ShopNotification) this._content.getValue(this, $$delegatedProperties[1]);
    }

    public final void animateIn() {
        UIComponent $this$animate$iv = (UIComponent) this;
        AnimatingConstraints anim$iv = $this$animate$iv.makeAnimation();
        AnimatingConstraints.setXAnimation$default(anim$iv, Animations.OUT_EXP, 0.5f, UtilitiesKt.dp$default((Number) 0, true, false, 2, (Object) null), 0.0f, 8, (Object) null);
        anim$iv.onComplete(() -> {
            return animateIn$lambda$2$lambda$1(r1);
        });
        $this$animate$iv.animateTo(anim$iv);
    }

    private static final Unit animateIn$lambda$2$lambda$1(NotificationContainer this$0) {
        this$0.animateTimer();
        return Unit.INSTANCE;
    }

    private final void animateTimer() {
        UIComponent $this$animate$iv = get_timer();
        AnimatingConstraints anim$iv = $this$animate$iv.makeAnimation();
        AnimatingConstraints.setWidthAnimation$default(anim$iv, Animations.LINEAR, this._duration, UtilitiesKt.dp$default((Number) 0, true, false, 2, (Object) null), 0.0f, 8, (Object) null).begin().onComplete(new NotificationContainer$animateTimer$1$1(this));
        $this$animate$iv.animateTo(anim$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateOut() {
        UIComponent $this$animate$iv = (UIComponent) this;
        AnimatingConstraints anim$iv = $this$animate$iv.makeAnimation();
        anim$iv.setXAnimation(Animations.IN_EXP, 0.5f, UtilitiesKt.dp((Number) 0, true, true), 0.5f);
        anim$iv.onComplete(() -> {
            return animateOut$lambda$6$lambda$5(r1);
        });
        $this$animate$iv.animateTo(anim$iv);
    }

    private static final Unit animateOut$lambda$6$lambda$5(NotificationContainer this$0) {
        UIComponent $this$animate$iv = (UIComponent) this$0;
        AnimatingConstraints anim$iv = $this$animate$iv.makeAnimation();
        AnimatingConstraints.setHeightAnimation$default(anim$iv, Animations.OUT_EXP, 0.25f, UtilitiesKt.getDp((Number) 0), 0.0f, 8, (Object) null);
        anim$iv.onComplete(new NotificationContainer$animateOut$1$1$1$1(this$0));
        $this$animate$iv.animateTo(anim$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissInstantly() {
        getParent().removeChild((UIComponent) this);
        this._onClose.invoke();
    }
}
