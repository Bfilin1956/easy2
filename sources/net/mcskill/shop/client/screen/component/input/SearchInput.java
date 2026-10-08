package net.mcskill.shop.client.screen.component.input;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.image.ImageComponent;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.RoundOutlineEffect;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.utils.ResourcesKt;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SearchInput.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/input/SearchInput.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0011\u001a\u00020\u0003J)\u0010\u0012\u001a\u00020\u00132!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u0015R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lnet/mcskill/shop/client/screen/component/input/SearchInput;", "Lgg/essential/elementa/components/UIContainer;", "placeholder", "", "<init>", "(Ljava/lang/String;)V", "icon", "Lgg/essential/elementa/components/image/ImageComponent;", "getIcon", "()Lgg/essential/elementa/components/image/ImageComponent;", "icon$delegate", "Lkotlin/properties/ReadWriteProperty;", "input", "Lgg/essential/elementa/UIComponent;", "getInput", "()Lgg/essential/elementa/UIComponent;", "input$delegate", "getText", "onUpdateTextInput", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", "", "MSShop"})
@SourceDebugExtension({"SMAP\nSearchInput.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchInput.kt\nnet/mcskill/shop/client/screen/component/input/SearchInput\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,58:1\n10#2,3:59\n10#2,3:62\n*S KotlinDebug\n*F\n+ 1 SearchInput.kt\nnet/mcskill/shop/client/screen/component/input/SearchInput\n*L\n17#1:59,3\n25#1:62,3\n*E\n"})
public final class SearchInput extends UIContainer {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SearchInput.class, "icon", "getIcon()Lgg/essential/elementa/components/image/ImageComponent;", 0)), Reflection.property1(new PropertyReference1Impl(SearchInput.class, "input", "getInput()Lgg/essential/elementa/UIComponent;", 0))};

    /* JADX INFO: renamed from: icon$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty icon;

    /* JADX INFO: renamed from: input$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty input;

    public SearchInput(@NotNull String placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        ResourceLocation resourceLocationAsResource$default = ResourcesKt.asResource$default("textures/search.png", (String) null, 1, (Object) null);
        Intrinsics.checkNotNullExpressionValue(resourceLocationAsResource$default, "asResource$default(...)");
        UIComponent $this$constrain$iv = new ImageComponent(resourceLocationAsResource$default, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$icon_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$icon_delegate_u24lambda_u240.setX(UtilitiesKt.getPercent((Number) 6));
        $this$icon_delegate_u24lambda_u240.setY(new CenterConstraint());
        $this$icon_delegate_u24lambda_u240.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$icon_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 20));
        $this$icon_delegate_u24lambda_u240.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA4()));
        this.icon = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new TextInput(placeholder, null, null, false, null, null, (Color) MSPalette.INSTANCE.getOrange().get(), 0, 190, null);
        UIConstraints $this$input_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$input_delegate_u24lambda_u241.setX(UtilitiesKt.getDp((Number) 44));
        $this$input_delegate_u24lambda_u241.setY(new CenterConstraint());
        $this$input_delegate_u24lambda_u241.setWidth(ConstraintsKt.minus(new FillConstraint(false), UtilitiesKt.getDp((Number) 8)));
        $this$input_delegate_u24lambda_u241.setHeight(new FillConstraint(false, 1, (DefaultConstructorMarker) null));
        $this$input_delegate_u24lambda_u241.setTextScale(UtilitiesKt.getDp((Number) 20));
        $this$input_delegate_u24lambda_u241.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$input_delegate_u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA4()));
        this.input = ComponentsKt.provideDelegate(ComponentsKt.childOf(((TextInput) $this$constrain$iv2).onFocus((v1) -> {
            return input_delegate$lambda$3(r2, v1);
        }).onFocusLost((v1) -> {
            return input_delegate$lambda$5(r2, v1);
        }), (UIComponent) this), this, $$delegatedProperties[1]);
        onMouseClick((v1, v2) -> {
            return _init_$lambda$6(r1, v1, v2);
        });
    }

    private final ImageComponent getIcon() {
        return (ImageComponent) this.icon.getValue(this, $$delegatedProperties[0]);
    }

    private final UIComponent getInput() {
        return (UIComponent) this.input.getValue(this, $$delegatedProperties[1]);
    }

    private static final Unit input_delegate$lambda$3(SearchInput this$0, UIComponent $this$onFocus) {
        Intrinsics.checkNotNullParameter($this$onFocus, "$this$onFocus");
        ImageComponent $this$input_delegate_u24lambda_u243_u24lambda_u242 = this$0.getIcon();
        Color color = Color.WHITE;
        Intrinsics.checkNotNullExpressionValue(color, "WHITE");
        $this$input_delegate_u24lambda_u243_u24lambda_u242.setColor(color);
        $this$input_delegate_u24lambda_u243_u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 18));
        ((RoundOutlineEffect) CollectionsKt.first(CollectionsKt.filterIsInstance(this$0.getEffects(), RoundOutlineEffect.class))).setColor(MSPalette.INSTANCE.getOrange());
        return Unit.INSTANCE;
    }

    private static final Unit input_delegate$lambda$5(SearchInput this$0, UIComponent $this$onFocusLost) {
        Intrinsics.checkNotNullParameter($this$onFocusLost, "$this$onFocusLost");
        ImageComponent $this$input_delegate_u24lambda_u245_u24lambda_u244 = this$0.getIcon();
        $this$input_delegate_u24lambda_u245_u24lambda_u244.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA4()));
        $this$input_delegate_u24lambda_u245_u24lambda_u244.setHeight(UtilitiesKt.getDp((Number) 20));
        ((RoundOutlineEffect) CollectionsKt.first(CollectionsKt.filterIsInstance(this$0.getEffects(), RoundOutlineEffect.class))).setColor(MSPalette.INSTANCE.getWhiteA4());
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$6(SearchInput this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.getInput().grabWindowFocus();
        return Unit.INSTANCE;
    }

    @NotNull
    public final String getText() {
        UIComponent input = getInput();
        Intrinsics.checkNotNull(input, "null cannot be cast to non-null type net.mcskill.shop.client.screen.component.input.TextInput");
        return ((TextInput) input).getText();
    }

    @NotNull
    public final AbstractTextInput onUpdateTextInput(@NotNull Function1<? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        UIComponent input = getInput();
        Intrinsics.checkNotNull(input, "null cannot be cast to non-null type net.mcskill.shop.client.screen.component.input.TextInput");
        return ((TextInput) input).onUpdate(listener);
    }
}
