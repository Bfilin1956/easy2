package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.UICircle;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.RelativeConstraint;
import gg.essential.elementa.dsl.BasicConstraintsKt;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.ExtensionsKt;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.core.client.screen.constraint.SizeRadiusConstraint;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/Slider.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001b\u001a\u00020\u0003J\u0018\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u000bJ\u001a\u0010\u0007\u001a\u00020\t2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0014\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019¨\u0006 "}, d2 = {"Lnet/mcskill/shop/client/screen/component/Slider;", "Lgg/essential/elementa/components/UIContainer;", "initialValue", "", "<init>", "(F)V", "percentage", "onValueChange", "Lkotlin/Function1;", "", "dragging", "", "grabOffset", "outerBox", "Lgg/essential/elementa/components/UIRoundedRectangle;", "getOuterBox", "()Lgg/essential/elementa/components/UIRoundedRectangle;", "outerBox$delegate", "Lkotlin/properties/ReadWriteProperty;", "completionBox", "getCompletionBox", "completionBox$delegate", "grabBox", "Lgg/essential/elementa/components/UICircle;", "getGrabBox", "()Lgg/essential/elementa/components/UICircle;", "grabBox$delegate", "getCurrentPercentage", "setCurrentPercentage", "newPercentage", "callListener", "listener", "MSShop"})
@SourceDebugExtension({"SMAP\nSlider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Slider.kt\nnet/mcskill/shop/client/screen/component/Slider\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,91:1\n10#2,3:92\n10#2,3:95\n10#2,3:98\n*S KotlinDebug\n*F\n+ 1 Slider.kt\nnet/mcskill/shop/client/screen/component/Slider\n*L\n19#1:92,3\n31#1:95,3\n37#1:98,3\n*E\n"})
public final class Slider extends UIContainer {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Slider.class, "outerBox", "getOuterBox()Lgg/essential/elementa/components/UIRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(Slider.class, "completionBox", "getCompletionBox()Lgg/essential/elementa/components/UIRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(Slider.class, "grabBox", "getGrabBox()Lgg/essential/elementa/components/UICircle;", 0))};
    private float percentage;

    @NotNull
    private Function1<? super Float, Unit> onValueChange = (v0) -> {
        return onValueChange$lambda$0(v0);
    };
    private boolean dragging;
    private float grabOffset;

    /* JADX INFO: renamed from: outerBox$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty outerBox;

    /* JADX INFO: renamed from: completionBox$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty completionBox;

    /* JADX INFO: renamed from: grabBox$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty grabBox;

    public Slider(float initialValue) {
        this.percentage = initialValue;
        UIComponent $this$constrain$iv = new UIRoundedRectangle(4.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$outerBox_delegate_u24lambda_u243 = $this$constrain$iv.getConstraints();
        $this$outerBox_delegate_u24lambda_u243.setX(BasicConstraintsKt.basicXConstraint((v1) -> {
            return outerBox_delegate$lambda$3$lambda$1(r1, v1);
        }));
        $this$outerBox_delegate_u24lambda_u243.setY(new CenterConstraint());
        $this$outerBox_delegate_u24lambda_u243.setWidth(BasicConstraintsKt.basicWidthConstraint((v1) -> {
            return outerBox_delegate$lambda$3$lambda$2(r1, v1);
        }));
        $this$outerBox_delegate_u24lambda_u243.setHeight(UtilitiesKt.getPercent((Number) 50));
        $this$outerBox_delegate_u24lambda_u243.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA1()));
        this.outerBox = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new UIRoundedRectangle(4.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$completionBox_delegate_u24lambda_u244 = $this$constrain$iv2.getConstraints();
        $this$completionBox_delegate_u24lambda_u244.setWidth(new RelativeConstraint(this.percentage));
        $this$completionBox_delegate_u24lambda_u244.setHeight(UtilitiesKt.getPercent((Number) 100));
        $this$completionBox_delegate_u24lambda_u244.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this.completionBox = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, getOuterBox()), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = new UICircle(6.0f, (Color) null, 0, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$grabBox_delegate_u24lambda_u246 = $this$constrain$iv3.getConstraints();
        $this$grabBox_delegate_u24lambda_u246.setX(ConstraintsKt.plus(BasicConstraintsKt.basicXConstraint((v1) -> {
            return grabBox_delegate$lambda$6$lambda$5(r1, v1);
        }), new SizeRadiusConstraint(SizeRadiusConstraint.Type.HEIGHT)));
        $this$grabBox_delegate_u24lambda_u246.setY(ConstraintsKt.boundTo(new CenterConstraint(), getOuterBox()));
        $this$grabBox_delegate_u24lambda_u246.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this.grabBox = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, (UIComponent) this), this, $$delegatedProperties[2]);
        getGrabBox().onMouseClick((v1, v2) -> {
            return _init_$lambda$7(r1, v1, v2);
        }).onMouseRelease((v1) -> {
            return _init_$lambda$8(r1, v1);
        }).onMouseDrag((v1, v2, v3, v4) -> {
            return _init_$lambda$9(r1, v1, v2, v3, v4);
        });
        getOuterBox().onMouseClick((v1, v2) -> {
            return _init_$lambda$10(r1, v1, v2);
        });
    }

    private static final Unit onValueChange$lambda$0(float it) {
        return Unit.INSTANCE;
    }

    private final UIRoundedRectangle getOuterBox() {
        return (UIRoundedRectangle) this.outerBox.getValue(this, $$delegatedProperties[0]);
    }

    private static final float outerBox_delegate$lambda$3$lambda$1(Slider this$0, UIComponent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.getLeft() + 1.0f + (this$0.getHeight() * 0.75f);
    }

    private static final float outerBox_delegate$lambda$3$lambda$2(Slider this$0, UIComponent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (this$0.getWidth() - 2.0f) - (this$0.getHeight() * 1.5f);
    }

    private final UIRoundedRectangle getCompletionBox() {
        return (UIRoundedRectangle) this.completionBox.getValue(this, $$delegatedProperties[1]);
    }

    @NotNull
    public final UICircle getGrabBox() {
        return (UICircle) this.grabBox.getValue(this, $$delegatedProperties[2]);
    }

    private static final float grabBox_delegate$lambda$6$lambda$5(Slider this$0, UIComponent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.getCompletionBox().getRight() - (it.getWidth() / 2.0f);
    }

    private static final Unit _init_$lambda$7(Slider this$0, UIComponent $this$onMouseClick, UIClickEvent event) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getMouseButton() != 0) {
            return Unit.INSTANCE;
        }
        this$0.dragging = true;
        this$0.grabOffset = event.getRelativeX() - (this$0.getGrabBox().getWidth() / 2);
        event.stopPropagation();
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$8(Slider this$0, UIComponent $this$onMouseRelease) {
        Intrinsics.checkNotNullParameter($this$onMouseRelease, "$this$onMouseRelease");
        this$0.dragging = false;
        this$0.grabOffset = 0.0f;
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$9(Slider this$0, UIComponent $this$onMouseDrag, float mouseX, float f, int i) {
        Intrinsics.checkNotNullParameter($this$onMouseDrag, "$this$onMouseDrag");
        if (!this$0.dragging) {
            return Unit.INSTANCE;
        }
        float clamped = ((Number) RangesKt.coerceIn(Float.valueOf((mouseX + this$0.getGrabBox().getLeft()) - this$0.grabOffset), RangesKt.rangeTo(this$0.getOuterBox().getLeft(), this$0.getOuterBox().getRight()))).floatValue();
        float percentage = (clamped - this$0.getOuterBox().getLeft()) / this$0.getOuterBox().getWidth();
        setCurrentPercentage$default(this$0, percentage, false, 2, null);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$10(Slider this$0, UIComponent $this$onMouseClick, UIClickEvent event) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getMouseButton() != 0) {
            return Unit.INSTANCE;
        }
        float percentage = event.getRelativeX() / this$0.getOuterBox().getWidth();
        setCurrentPercentage$default(this$0, percentage, false, 2, null);
        this$0.dragging = true;
        return Unit.INSTANCE;
    }

    public final float getCurrentPercentage() {
        return this.percentage;
    }

    public static /* synthetic */ void setCurrentPercentage$default(Slider slider, float f, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        slider.setCurrentPercentage(f, z);
    }

    public final void setCurrentPercentage(float newPercentage, boolean callListener) {
        this.percentage = ((Number) RangesKt.coerceIn(Float.valueOf(newPercentage), RangesKt.rangeTo(0.0f, 1.0f))).floatValue();
        getCompletionBox().setWidth(new RelativeConstraint(this.percentage));
        if (callListener) {
            this.onValueChange.invoke(Float.valueOf(this.percentage));
        }
    }

    public final void onValueChange(@NotNull Function1<? super Float, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onValueChange = listener;
    }
}
