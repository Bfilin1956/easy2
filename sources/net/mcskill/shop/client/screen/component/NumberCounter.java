package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.RoundOutlineEffect;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.State;
import gg.essential.elementa.state.StateKt;
import gg.essential.universal.UMath;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NumberCounter.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/NumberCounter.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bB'\b\u0017\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\fJ4\u0010<\u001a\u00020\u00002,\u0010=\u001a(\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016J\u0014\u0010@\u001a\u00020\u0015*\u00020\u001a2\u0006\u0010A\u001a\u00020\u0014H\u0002R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR+\u0010\u0011\u001a\u001f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u00160\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001b\u0010&\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010%\u001a\u0004\b,\u0010)R\u001b\u0010.\u001a\u00020/8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010%\u001a\u0004\b0\u00101R\u001b\u00103\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010%\u001a\u0004\b4\u0010#R\u001b\u00106\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010%\u001a\u0004\b7\u0010)R\u001b\u00109\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010%\u001a\u0004\b:\u0010)¨\u0006B"}, d2 = {"Lnet/mcskill/shop/client/screen/component/NumberCounter;", "Lgg/essential/elementa/components/UIContainer;", "valueState", "Lgg/essential/elementa/state/State;", "", "minValue", "maxValue", "<init>", "(Lgg/essential/elementa/state/State;Lgg/essential/elementa/state/State;Lgg/essential/elementa/state/State;)V", "default", "min", "max", "(III)V", "getValueState", "()Lgg/essential/elementa/state/State;", "getMinValue", "getMaxValue", "changeListener", "", "Lkotlin/Function2;", "Lgg/essential/elementa/UIComponent;", "", "Lkotlin/ExtensionFunctionType;", "baseColor", "Ljava/awt/Color;", "minusEffect", "Lgg/essential/elementa/effects/RoundOutlineEffect;", "plusEffect", "value", "getValue", "()I", "setValue", "(I)V", "minusButton", "getMinusButton", "()Lgg/essential/elementa/UIComponent;", "minusButton$delegate", "Lkotlin/properties/ReadWriteProperty;", "minus", "Lgg/essential/elementa/components/UIRoundedRectangle;", "getMinus", "()Lgg/essential/elementa/components/UIRoundedRectangle;", "minus$delegate", "base", "getBase", "base$delegate", "valueLabel", "Lgg/essential/elementa/components/LabelComponent;", "getValueLabel", "()Lgg/essential/elementa/components/LabelComponent;", "valueLabel$delegate", "plusButton", "getPlusButton", "plusButton$delegate", "plusHor", "getPlusHor", "plusHor$delegate", "plusVert", "getPlusVert", "plusVert$delegate", "onChange", "method", "Lkotlin/ParameterName;", "name", "onHover", "component", "MSShop"})
@SourceDebugExtension({"SMAP\nNumberCounter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NumberCounter.kt\nnet/mcskill/shop/client/screen/component/NumberCounter\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,121:1\n10#2,3:122\n10#2,3:125\n10#2,3:128\n10#2,3:131\n10#2,3:134\n10#2,3:137\n10#2,3:140\n*S KotlinDebug\n*F\n+ 1 NumberCounter.kt\nnet/mcskill/shop/client/screen/component/NumberCounter\n*L\n48#1:122,3\n56#1:125,3\n63#1:128,3\n72#1:131,3\n79#1:134,3\n88#1:137,3\n95#1:140,3\n*E\n"})
public final class NumberCounter extends UIContainer {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(NumberCounter.class, "minusButton", "getMinusButton()Lgg/essential/elementa/UIComponent;", 0)), Reflection.property1(new PropertyReference1Impl(NumberCounter.class, "minus", "getMinus()Lgg/essential/elementa/components/UIRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(NumberCounter.class, "base", "getBase()Lgg/essential/elementa/components/UIRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(NumberCounter.class, "valueLabel", "getValueLabel()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(NumberCounter.class, "plusButton", "getPlusButton()Lgg/essential/elementa/UIComponent;", 0)), Reflection.property1(new PropertyReference1Impl(NumberCounter.class, "plusHor", "getPlusHor()Lgg/essential/elementa/components/UIRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(NumberCounter.class, "plusVert", "getPlusVert()Lgg/essential/elementa/components/UIRoundedRectangle;", 0))};

    @NotNull
    private final State<Integer> valueState;

    @NotNull
    private final State<Integer> minValue;

    @NotNull
    private final State<Integer> maxValue;

    @NotNull
    private final List<Function2<UIComponent, Integer, Unit>> changeListener;

    @NotNull
    private final Color baseColor;

    @NotNull
    private final RoundOutlineEffect minusEffect;

    @NotNull
    private final RoundOutlineEffect plusEffect;

    /* JADX INFO: renamed from: minusButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty minusButton;

    /* JADX INFO: renamed from: minus$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty minus;

    /* JADX INFO: renamed from: base$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty base;

    /* JADX INFO: renamed from: valueLabel$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty valueLabel;

    /* JADX INFO: renamed from: plusButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty plusButton;

    /* JADX INFO: renamed from: plusHor$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty plusHor;

    /* JADX INFO: renamed from: plusVert$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty plusVert;

    public /* synthetic */ NumberCounter(State state, State state2, State state3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((State<Integer>) state, (State<Integer>) ((i & 2) != 0 ? (State) new BasicState(0) : state2), (State<Integer>) ((i & 4) != 0 ? (State) new BasicState(2147483646) : state3));
    }

    @NotNull
    public final State<Integer> getValueState() {
        return this.valueState;
    }

    @NotNull
    public final State<Integer> getMinValue() {
        return this.minValue;
    }

    @NotNull
    public final State<Integer> getMaxValue() {
        return this.maxValue;
    }

    @JvmOverloads
    public NumberCounter(@NotNull State<Integer> state, @NotNull State<Integer> state2, @NotNull State<Integer> state3) {
        Intrinsics.checkNotNullParameter(state, "valueState");
        Intrinsics.checkNotNullParameter(state2, "minValue");
        Intrinsics.checkNotNullParameter(state3, "maxValue");
        this.valueState = state;
        this.minValue = state2;
        this.maxValue = state3;
        this.changeListener = new ArrayList();
        this.baseColor = new Color(0, 0, 0, 0);
        this.minusEffect = new RoundOutlineEffect((Color) MSPalette.INSTANCE.getWhiteA2().get(), 8.0f, 2.0f, 1.0f, false, 16, (DefaultConstructorMarker) null);
        this.plusEffect = new RoundOutlineEffect((Color) MSPalette.INSTANCE.getWhiteA2().get(), 8.0f, 2.0f, 1.0f, false, 16, (DefaultConstructorMarker) null);
        UIRoundedRectangle uIRoundedRectangle = (UIComponent) new UIRoundedRectangle(8.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$minusButton_delegate_u24lambda_u240 = uIRoundedRectangle.getConstraints();
        $this$minusButton_delegate_u24lambda_u240.setWidth(UtilitiesKt.getPercent(Double.valueOf(15.9d)));
        $this$minusButton_delegate_u24lambda_u240.setHeight(new FillConstraint(false));
        $this$minusButton_delegate_u24lambda_u240.setColor(UtilitiesKt.toConstraint(this.baseColor));
        this.minusButton = ComponentsKt.provideDelegate(ComponentsKt.childOf(ComponentsKt.effect(uIRoundedRectangle.onMouseClick((v1, v2) -> {
            return minusButton_delegate$lambda$1(r2, v1, v2);
        }), this.minusEffect), (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv = new UIRoundedRectangle(5.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$minus_delegate_u24lambda_u242 = $this$constrain$iv.getConstraints();
        $this$minus_delegate_u24lambda_u242.setX(new CenterConstraint());
        $this$minus_delegate_u24lambda_u242.setY(new CenterConstraint());
        $this$minus_delegate_u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 14));
        $this$minus_delegate_u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 2));
        this.minus = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, getMinusButton()), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv2 = new UIRoundedRectangle(8.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$base_delegate_u24lambda_u243 = $this$constrain$iv2.getConstraints();
        $this$base_delegate_u24lambda_u243.setX(new SiblingConstraint(8.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$base_delegate_u24lambda_u243.setWidth(UtilitiesKt.getPercent((Number) 60));
        $this$base_delegate_u24lambda_u243.setHeight(new FillConstraint(false));
        $this$base_delegate_u24lambda_u243.setColor(UtilitiesKt.toConstraint(this.baseColor));
        this.base = ComponentsKt.provideDelegate(ComponentsKt.childOf(ComponentsKt.effect($this$constrain$iv2, new RoundOutlineEffect((Color) MSPalette.INSTANCE.getWhiteA2().get(), 8.0f, 2.0f, 1.0f, false, 16, (DefaultConstructorMarker) null)), (UIComponent) this), this, $$delegatedProperties[2]);
        UIComponent $this$constrain$iv3 = new LabelComponent((String) null, false, (Color) null, 7, (DefaultConstructorMarker) null).bindText(this.valueState.map((v0) -> {
            return valueLabel_delegate$lambda$4(v0);
        }));
        UIConstraints $this$valueLabel_delegate_u24lambda_u245 = $this$constrain$iv3.getConstraints();
        $this$valueLabel_delegate_u24lambda_u245.setX(new CenterConstraint());
        $this$valueLabel_delegate_u24lambda_u245.setY(new CenterConstraint());
        $this$valueLabel_delegate_u24lambda_u245.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$valueLabel_delegate_u24lambda_u245.setTextScale(UtilitiesKt.getDp((Number) 18));
        this.valueLabel = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, getBase()), this, $$delegatedProperties[3]);
        UIRoundedRectangle uIRoundedRectangle2 = (UIComponent) new UIRoundedRectangle(8.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$plusButton_delegate_u24lambda_u246 = uIRoundedRectangle2.getConstraints();
        $this$plusButton_delegate_u24lambda_u246.setX(new SiblingConstraint(8.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$plusButton_delegate_u24lambda_u246.setWidth(UtilitiesKt.getPercent(Double.valueOf(15.9d)));
        $this$plusButton_delegate_u24lambda_u246.setHeight(new FillConstraint(false));
        $this$plusButton_delegate_u24lambda_u246.setColor(UtilitiesKt.toConstraint(this.baseColor));
        this.plusButton = ComponentsKt.provideDelegate(ComponentsKt.childOf(ComponentsKt.effect(uIRoundedRectangle2.onMouseClick((v1, v2) -> {
            return plusButton_delegate$lambda$7(r2, v1, v2);
        }), this.plusEffect), (UIComponent) this), this, $$delegatedProperties[4]);
        UIComponent $this$constrain$iv4 = new UIRoundedRectangle(5.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$plusHor_delegate_u24lambda_u248 = $this$constrain$iv4.getConstraints();
        $this$plusHor_delegate_u24lambda_u248.setX(new CenterConstraint());
        $this$plusHor_delegate_u24lambda_u248.setY(new CenterConstraint());
        $this$plusHor_delegate_u24lambda_u248.setWidth(UtilitiesKt.getDp((Number) 14));
        $this$plusHor_delegate_u24lambda_u248.setHeight(UtilitiesKt.getDp((Number) 2));
        this.plusHor = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, getPlusButton()), this, $$delegatedProperties[5]);
        UIComponent $this$constrain$iv5 = new UIRoundedRectangle(5.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$plusVert_delegate_u24lambda_u249 = $this$constrain$iv5.getConstraints();
        $this$plusVert_delegate_u24lambda_u249.setX(new CenterConstraint());
        $this$plusVert_delegate_u24lambda_u249.setY(new CenterConstraint());
        $this$plusVert_delegate_u24lambda_u249.setWidth(UtilitiesKt.getDp((Number) 2));
        $this$plusVert_delegate_u24lambda_u249.setHeight(UtilitiesKt.getDp((Number) 14));
        this.plusVert = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv5, getPlusButton()), this, $$delegatedProperties[6]);
        onHover(this.minusEffect, getMinusButton());
        onHover(this.plusEffect, getPlusButton());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NumberCounter(@NotNull State<Integer> state, @NotNull State<Integer> state2) {
        this(state, state2, (State) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(state, "valueState");
        Intrinsics.checkNotNullParameter(state2, "minValue");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NumberCounter(@NotNull State<Integer> state) {
        this(state, (State) null, (State) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(state, "valueState");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ NumberCounter(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        i = (i4 & 1) != 0 ? 0 : i;
        this(i, (i4 & 2) != 0 ? i : i2, (i4 & 4) != 0 ? 2147483646 : i3);
    }

    @JvmOverloads
    public NumberCounter(int i, int min, int max) {
        this((State<Integer>) new BasicState(Integer.valueOf(i)), (State<Integer>) new BasicState(Integer.valueOf(min)), (State<Integer>) new BasicState(Integer.valueOf(max)));
    }

    @JvmOverloads
    public NumberCounter(int i, int min) {
        this(i, min, 0, 4, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public NumberCounter(int i) {
        this(i, 0, 0, 6, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public NumberCounter() {
        this(0, 0, 0, 7, (DefaultConstructorMarker) null);
    }

    public final void setValue(int value) {
        this.valueState.set(Integer.valueOf(UMath.clampInt(value, ((Number) this.minValue.get()).intValue(), ((Number) this.maxValue.get()).intValue())));
        Iterator<Function2<UIComponent, Integer, Unit>> it = this.changeListener.iterator();
        while (it.hasNext()) {
            it.next().invoke(this, this.valueState.get());
        }
    }

    public final int getValue() {
        return ((Number) this.valueState.get()).intValue();
    }

    @NotNull
    public final UIComponent getMinusButton() {
        return (UIComponent) this.minusButton.getValue(this, $$delegatedProperties[0]);
    }

    private static final Unit minusButton_delegate$lambda$1(NumberCounter this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.setValue(this$0.getValue() - 1);
        this$0.getValue();
        return Unit.INSTANCE;
    }

    @NotNull
    public final UIRoundedRectangle getMinus() {
        return (UIRoundedRectangle) this.minus.getValue(this, $$delegatedProperties[1]);
    }

    @NotNull
    public final UIRoundedRectangle getBase() {
        return (UIRoundedRectangle) this.base.getValue(this, $$delegatedProperties[2]);
    }

    @NotNull
    public final LabelComponent getValueLabel() {
        return (LabelComponent) this.valueLabel.getValue(this, $$delegatedProperties[3]);
    }

    private static final String valueLabel_delegate$lambda$4(int it) {
        return "§l" + it;
    }

    @NotNull
    public final UIComponent getPlusButton() {
        return (UIComponent) this.plusButton.getValue(this, $$delegatedProperties[4]);
    }

    private static final Unit plusButton_delegate$lambda$7(NumberCounter this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.setValue(this$0.getValue() + 1);
        this$0.getValue();
        return Unit.INSTANCE;
    }

    @NotNull
    public final UIRoundedRectangle getPlusHor() {
        return (UIRoundedRectangle) this.plusHor.getValue(this, $$delegatedProperties[5]);
    }

    @NotNull
    public final UIRoundedRectangle getPlusVert() {
        return (UIRoundedRectangle) this.plusVert.getValue(this, $$delegatedProperties[6]);
    }

    @NotNull
    public final NumberCounter onChange(@NotNull Function2<? super UIComponent, ? super Integer, Unit> method) {
        Intrinsics.checkNotNullParameter(method, "method");
        NumberCounter $this$onChange_u24lambda_u2410 = this;
        $this$onChange_u24lambda_u2410.changeListener.add(method);
        return this;
    }

    private final void onHover(RoundOutlineEffect $this$onHover, UIComponent component) {
        State minusHovered = StateKt.hoveredState$default(component, false, false, 3, (Object) null);
        $this$onHover.setColor(minusHovered.map((v0) -> {
            return onHover$lambda$11(v0);
        }));
    }

    private static final Color onHover$lambda$11(boolean isHovered) {
        if (isHovered) {
            return (Color) MSPalette.INSTANCE.getOrange().get();
        }
        return (Color) MSPalette.INSTANCE.getWhiteA2().get();
    }
}
