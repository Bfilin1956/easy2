package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.ScrollComponent;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.constraints.ColorConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.constraints.animation.AnimatingConstraints;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.state.ExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSPalette;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ScrollBar.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/ScrollBar.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lnet/mcskill/shop/client/screen/component/ScrollBar;", "Lgg/essential/elementa/components/UIRoundedRectangle;", "radius", "", "isVertical", "", "<init>", "(FZ)V", "()Z", "button", "Lgg/essential/elementa/UIComponent;", "getButton", "()Lgg/essential/elementa/UIComponent;", "button$delegate", "Lkotlin/properties/ReadWriteProperty;", "attachTo", "", "scrollComponent", "Lgg/essential/elementa/components/ScrollComponent;", "MSShop"})
@SourceDebugExtension({"SMAP\nScrollBar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScrollBar.kt\nnet/mcskill/shop/client/screen/component/ScrollBar\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,35:1\n10#2,3:36\n*S KotlinDebug\n*F\n+ 1 ScrollBar.kt\nnet/mcskill/shop/client/screen/component/ScrollBar\n*L\n17#1:36,3\n*E\n"})
public final class ScrollBar extends UIRoundedRectangle {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ScrollBar.class, "button", "getButton()Lgg/essential/elementa/UIComponent;", 0))};
    private final boolean isVertical;

    /* JADX INFO: renamed from: button$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty button;

    public /* synthetic */ ScrollBar(float f, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, (i & 2) != 0 ? true : z);
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public ScrollBar(float radius, boolean isVertical) {
        super(radius, false, 2, (DefaultConstructorMarker) null);
        this.isVertical = isVertical;
        UIRoundedRectangle uIRoundedRectangle = (UIComponent) new UIRoundedRectangle(radius, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$button_delegate_u24lambda_u240 = uIRoundedRectangle.getConstraints();
        $this$button_delegate_u24lambda_u240.setX(new SiblingConstraint(0.0f, false, false, 7, (DefaultConstructorMarker) null));
        $this$button_delegate_u24lambda_u240.setWidth(UtilitiesKt.getPercent((Number) 100));
        $this$button_delegate_u24lambda_u240.setHeight(UtilitiesKt.getPercent((Number) 100));
        $this$button_delegate_u24lambda_u240.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this.button = ComponentsKt.provideDelegate(ComponentsKt.childOf(uIRoundedRectangle.animateBeforeHide((v1) -> {
            return button_delegate$lambda$1(r2, v1);
        }).animateAfterUnhide((v1) -> {
            return button_delegate$lambda$2(r2, v1);
        }), (UIComponent) this), this, $$delegatedProperties[0]);
    }

    private final UIComponent getButton() {
        return (UIComponent) this.button.getValue(this, $$delegatedProperties[0]);
    }

    private static final Unit button_delegate$lambda$1(ScrollBar this$0, AnimatingConstraints $this$animateBeforeHide) {
        Intrinsics.checkNotNullParameter($this$animateBeforeHide, "$this$animateBeforeHide");
        this$0.setColor((ColorConstraint) ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        return Unit.INSTANCE;
    }

    private static final Unit button_delegate$lambda$2(ScrollBar this$0, AnimatingConstraints $this$animateAfterUnhide) {
        Intrinsics.checkNotNullParameter($this$animateAfterUnhide, "$this$animateAfterUnhide");
        this$0.setColor((ColorConstraint) ExtensionsKt.toConstraint(MSPalette.INSTANCE.getSidebar()));
        return Unit.INSTANCE;
    }

    public final void attachTo(@NotNull ScrollComponent scrollComponent) {
        Intrinsics.checkNotNullParameter(scrollComponent, "scrollComponent");
        if (this.isVertical) {
            scrollComponent.setVerticalScrollBarComponent(getButton(), true);
        } else {
            scrollComponent.setHorizontalScrollBarComponent(getButton(), true);
        }
    }
}
