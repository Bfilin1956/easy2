package net.mcskill.shop.client.screen.component.input;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.RoundOutlineEffect;
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
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextField.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/input/TextField.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u0010\u001a\u00020\u00112!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lnet/mcskill/shop/client/screen/component/input/TextField;", "Lgg/essential/elementa/components/UIContainer;", "placeholder", "", "fontScale", "", "<init>", "(Ljava/lang/String;Ljava/lang/Number;)V", "borderEffect", "Lgg/essential/elementa/effects/RoundOutlineEffect;", "input", "Lnet/mcskill/shop/client/screen/component/input/TextInput;", "getInput", "()Lnet/mcskill/shop/client/screen/component/input/TextInput;", "input$delegate", "Lkotlin/properties/ReadWriteProperty;", "onUpdateTextInput", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", "", "MSShop"})
@SourceDebugExtension({"SMAP\nTextField.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextField.kt\nnet/mcskill/shop/client/screen/component/input/TextField\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,37:1\n10#2,3:38\n*S KotlinDebug\n*F\n+ 1 TextField.kt\nnet/mcskill/shop/client/screen/component/input/TextField\n*L\n15#1:38,3\n*E\n"})
public final class TextField extends UIContainer {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(TextField.class, "input", "getInput()Lnet/mcskill/shop/client/screen/component/input/TextInput;", 0))};

    @NotNull
    private final RoundOutlineEffect borderEffect;

    /* JADX INFO: renamed from: input$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty input;

    public TextField(@NotNull String placeholder, @NotNull Number fontScale) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(fontScale, "fontScale");
        this.borderEffect = new RoundOutlineEffect((Color) MSPalette.INSTANCE.getWhiteA4().get(), 4.0f, 1.0f, 0.7f, false, 16, (DefaultConstructorMarker) null);
        UIComponent $this$constrain$iv = new TextInput(placeholder, null, null, false, null, null, (Color) MSPalette.INSTANCE.getOrange().get(), 0, 190, null);
        UIConstraints $this$input_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$input_delegate_u24lambda_u240.setX(UtilitiesKt.getDp((Number) 8));
        $this$input_delegate_u24lambda_u240.setY(new CenterConstraint());
        $this$input_delegate_u24lambda_u240.setWidth(ConstraintsKt.minus(new FillConstraint(false), UtilitiesKt.getDp((Number) 8)));
        $this$input_delegate_u24lambda_u240.setHeight(ConstraintsKt.minus(new FillConstraint(false, 1, (DefaultConstructorMarker) null), UtilitiesKt.getDp((Number) 10)));
        $this$input_delegate_u24lambda_u240.setTextScale(UtilitiesKt.getDp(fontScale));
        $this$input_delegate_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$input_delegate_u24lambda_u240.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA4()));
        UIComponent uIComponentOnFocusLost = ((TextInput) $this$constrain$iv).onFocus((v1) -> {
            return input_delegate$lambda$1(r2, v1);
        }).onFocusLost((v1) -> {
            return input_delegate$lambda$2(r2, v1);
        });
        Intrinsics.checkNotNull(uIComponentOnFocusLost, "null cannot be cast to non-null type net.mcskill.shop.client.screen.component.input.TextInput");
        this.input = ComponentsKt.provideDelegate(ComponentsKt.childOf((TextInput) uIComponentOnFocusLost, (UIComponent) this), this, $$delegatedProperties[0]);
        onMouseClick((v1, v2) -> {
            return _init_$lambda$3(r1, v1, v2);
        });
        ComponentsKt.effect((UIComponent) this, this.borderEffect);
    }

    public /* synthetic */ TextField(String str, Number number, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? (Number) 18 : number);
    }

    @NotNull
    public final TextInput getInput() {
        return (TextInput) this.input.getValue(this, $$delegatedProperties[0]);
    }

    private static final Unit input_delegate$lambda$1(TextField this$0, UIComponent $this$onFocus) {
        Intrinsics.checkNotNullParameter($this$onFocus, "$this$onFocus");
        this$0.borderEffect.setColor(MSPalette.INSTANCE.getOrange());
        return Unit.INSTANCE;
    }

    private static final Unit input_delegate$lambda$2(TextField this$0, UIComponent $this$onFocusLost) {
        Intrinsics.checkNotNullParameter($this$onFocusLost, "$this$onFocusLost");
        this$0.borderEffect.setColor(MSPalette.INSTANCE.getWhiteA4());
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$3(TextField this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getInput().grabWindowFocus();
        return Unit.INSTANCE;
    }

    @NotNull
    public final AbstractTextInput onUpdateTextInput(@NotNull Function1<? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return getInput().onUpdate(listener);
    }
}
