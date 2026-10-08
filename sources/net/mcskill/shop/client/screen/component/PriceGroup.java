package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.image.ImageComponent;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedMaxSizeConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.State;
import gg.essential.elementa.utils.ResourcesKt;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSFonts;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PriceGroup.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/PriceGroup.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u0001\u0019B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\b\u0010\tB#\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\rR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u001a"}, d2 = {"Lnet/mcskill/shop/client/screen/component/PriceGroup;", "Lgg/essential/elementa/components/UIContainer;", "priceState", "Lgg/essential/elementa/state/State;", "", "currencyState", "", "discountState", "<init>", "(Lgg/essential/elementa/state/State;Lgg/essential/elementa/state/State;Lgg/essential/elementa/state/State;)V", "price", "currency", "discount", "(Ljava/lang/Number;Ljava/lang/String;Ljava/lang/Number;)V", "value", "getPrice", "()Ljava/lang/Number;", "setPrice", "(Ljava/lang/Number;)V", "getCurrency", "()Ljava/lang/String;", "setCurrency", "(Ljava/lang/String;)V", "getDiscount", "setDiscount", "LabeledIcon", "MSShop"})
@SourceDebugExtension({"SMAP\nPriceGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PriceGroup.kt\nnet/mcskill/shop/client/screen/component/PriceGroup\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,83:1\n10#2,3:84\n*S KotlinDebug\n*F\n+ 1 PriceGroup.kt\nnet/mcskill/shop/client/screen/component/PriceGroup\n*L\n49#1:84,3\n*E\n"})
public final class PriceGroup extends UIContainer {

    @NotNull
    private final State<Number> priceState;

    @NotNull
    private final State<String> currencyState;

    @NotNull
    private final State<Number> discountState;

    public /* synthetic */ PriceGroup(State state, State state2, State state3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((State<Number>) state, (State<String>) state2, (State<Number>) ((i & 4) != 0 ? (State) new BasicState(-1) : state3));
    }

    public PriceGroup(@NotNull State<Number> state, @NotNull State<String> state2, @NotNull State<Number> state3) {
        Intrinsics.checkNotNullParameter(state, "priceState");
        Intrinsics.checkNotNullParameter(state2, "currencyState");
        Intrinsics.checkNotNullParameter(state3, "discountState");
        this.priceState = state;
        this.currencyState = state2;
        this.discountState = state3;
        State map = this.currencyState.map(PriceGroup::_init_$lambda$0);
        if (getDiscount().intValue() > 0) {
            State map2 = this.priceState.map(PriceGroup::_init_$lambda$1);
            State map3 = this.currencyState.map(PriceGroup::_init_$lambda$2);
            Color color = Color.GRAY;
            Intrinsics.checkNotNullExpressionValue(color, "GRAY");
            UIComponent uIComponent = (LabeledIcon) ComponentsKt.childOf(new LabeledIcon(this, map2, map3, color), (UIComponent) this);
            UIComponent $this$constrain$iv = new LabeledIcon(this, this.priceState.zip(this.discountState).map(PriceGroup::_init_$lambda$3), map, null, 4, null);
            UIConstraints $this$_init__u24lambda_u244 = $this$constrain$iv.getConstraints();
            $this$_init__u24lambda_u244.setX(new SiblingConstraint(7.0f, false, false, 6, (DefaultConstructorMarker) null));
            $this$_init__u24lambda_u244.setY(ConstraintsKt.boundTo(new CenterConstraint(), uIComponent));
            ComponentsKt.childOf($this$constrain$iv, (UIComponent) this);
            return;
        }
        ComponentsKt.childOf(new LabeledIcon(this, this.priceState.map(PriceGroup::_init_$lambda$5), map, null, 4, null), (UIComponent) this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PriceGroup(@NotNull Number price, @NotNull String currency, @NotNull Number discount) {
        this((State<Number>) new BasicState(price), (State<String>) new BasicState(currency), (State<Number>) new BasicState(discount));
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(discount, "discount");
    }

    public /* synthetic */ PriceGroup(Number number, String str, Number number2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(number, str, (i & 4) != 0 ? (Number) (-1) : number2);
    }

    @NotNull
    public final Number getPrice() {
        return (Number) this.priceState.get();
    }

    public final void setPrice(@NotNull Number value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.priceState.set(value);
    }

    @NotNull
    public final String getCurrency() {
        return (String) this.currencyState.get();
    }

    public final void setCurrency(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.currencyState.set(value);
    }

    @NotNull
    public final Number getDiscount() {
        return (Number) this.discountState.get();
    }

    public final void setDiscount(@NotNull Number value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.discountState.set(value);
    }

    private static final ResourceLocation _init_$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ResourcesKt.asResource$default("textures/" + it + "_20x20.png", (String) null, 1, (Object) null);
    }

    private static final String _init_$lambda$1(Number it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return "§m" + it.intValue();
    }

    private static final ResourceLocation _init_$lambda$2(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ResourceLocation resourceLocationAsResource$default = ResourcesKt.asResource$default("textures/" + it + "_gray_20x20.png", (String) null, 1, (Object) null);
        Intrinsics.checkNotNullExpressionValue(resourceLocationAsResource$default, "asResource$default(...)");
        return resourceLocationAsResource$default;
    }

    private static final String _init_$lambda$3(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        Number price = (Number) pair.component1();
        Number discount = (Number) pair.component2();
        return String.valueOf(price.intValue() - ((price.intValue() * discount.intValue()) / 100));
    }

    private static final String _init_$lambda$5(Number it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return String.valueOf(it.intValue());
    }

    /* JADX INFO: compiled from: PriceGroup.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/PriceGroup$LabeledIcon.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lnet/mcskill/shop/client/screen/component/PriceGroup$LabeledIcon;", "Lgg/essential/elementa/components/UIContainer;", "text", "Lgg/essential/elementa/state/State;", "", "iconPath", "Lnet/minecraft/resources/ResourceLocation;", "textColor", "Ljava/awt/Color;", "<init>", "(Lnet/mcskill/shop/client/screen/component/PriceGroup;Lgg/essential/elementa/state/State;Lgg/essential/elementa/state/State;Ljava/awt/Color;)V", "label", "Lgg/essential/elementa/components/LabelComponent;", "getLabel", "()Lgg/essential/elementa/components/LabelComponent;", "label$delegate", "Lkotlin/properties/ReadWriteProperty;", "icon", "Lgg/essential/elementa/components/image/ImageComponent;", "getIcon", "()Lgg/essential/elementa/components/image/ImageComponent;", "icon$delegate", "MSShop"})
    @SourceDebugExtension({"SMAP\nPriceGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PriceGroup.kt\nnet/mcskill/shop/client/screen/component/PriceGroup$LabeledIcon\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,83:1\n10#2,3:84\n10#2,3:87\n10#2,3:90\n*S KotlinDebug\n*F\n+ 1 PriceGroup.kt\nnet/mcskill/shop/client/screen/component/PriceGroup$LabeledIcon\n*L\n63#1:84,3\n69#1:87,3\n77#1:90,3\n*E\n"})
    private final class LabeledIcon extends UIContainer {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(LabeledIcon.class, "label", "getLabel()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(LabeledIcon.class, "icon", "getIcon()Lgg/essential/elementa/components/image/ImageComponent;", 0))};

        /* JADX INFO: renamed from: label$delegate, reason: from kotlin metadata */
        @NotNull
        private final ReadWriteProperty label;

        /* JADX INFO: renamed from: icon$delegate, reason: from kotlin metadata */
        @NotNull
        private final ReadWriteProperty icon;
        final /* synthetic */ PriceGroup this$0;

        public LabeledIcon(@NotNull PriceGroup this$0, @NotNull State<String> state, @NotNull State<ResourceLocation> state2, Color textColor) {
            Intrinsics.checkNotNullParameter(state, "text");
            Intrinsics.checkNotNullParameter(state2, "iconPath");
            Intrinsics.checkNotNullParameter(textColor, "textColor");
            this.this$0 = this$0;
            UIComponent $this$constrain$iv = new LabelComponent(state, (State) null, (State) null, 6, (DefaultConstructorMarker) null);
            UIConstraints $this$label_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
            $this$label_delegate_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
            $this$label_delegate_u24lambda_u240.setTextScale(UtilitiesKt.getDp((Number) 20));
            $this$label_delegate_u24lambda_u240.setColor(UtilitiesKt.toConstraint(textColor));
            this.label = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
            UIComponent $this$constrain$iv2 = new ImageComponent(state2, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
            UIConstraints $this$icon_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
            $this$icon_delegate_u24lambda_u241.setX(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 4, true, true), getLabel()));
            $this$icon_delegate_u24lambda_u241.setY(ConstraintsKt.boundTo(new CenterConstraint(), getLabel()));
            $this$icon_delegate_u24lambda_u241.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
            $this$icon_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 20));
            this.icon = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
            UIConstraints $this$_init__u24lambda_u242 = ((UIComponent) this).getConstraints();
            $this$_init__u24lambda_u242.setWidth(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null));
            $this$_init__u24lambda_u242.setHeight(new ChildBasedMaxSizeConstraint());
        }

        public /* synthetic */ LabeledIcon(PriceGroup priceGroup, State state, State state2, Color color, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(priceGroup, state, state2, (i & 4) != 0 ? Color.WHITE : color);
        }

        private final LabelComponent getLabel() {
            return (LabelComponent) this.label.getValue(this, $$delegatedProperties[0]);
        }

        private final ImageComponent getIcon() {
            return (ImageComponent) this.icon.getValue(this, $$delegatedProperties[1]);
        }
    }
}
