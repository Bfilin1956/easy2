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
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.MappedState;
import gg.essential.elementa.state.State;
import gg.essential.elementa.state.StateKt;
import gg.essential.elementa.utils.ResourcesKt;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.shop.client.screen.tab.groups.GroupEntry;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NewPriceGroup.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/NewPriceGroup.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001/B?\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u000eJ\u0006\u0010-\u001a\u00020.R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R$\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R$\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR%\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n !*\u0004\u0018\u00010 0 0\u001f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001f\u0010$\u001a\u00060%R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u001f\u0010*\u001a\u00060%R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b+\u0010'¨\u00060"}, d2 = {"Lnet/mcskill/shop/client/screen/component/NewPriceGroup;", "Lgg/essential/elementa/components/UIContainer;", "priceState", "Lgg/essential/elementa/state/BasicState;", "", "discountState", "priceWithDiscState", "currencyState", "", "<init>", "(Lgg/essential/elementa/state/BasicState;Lgg/essential/elementa/state/BasicState;Lgg/essential/elementa/state/BasicState;Lgg/essential/elementa/state/BasicState;)V", "price", "Lnet/mcskill/shop/client/screen/tab/groups/GroupEntry$PriceData;", "currency", "(Lnet/mcskill/shop/client/screen/tab/groups/GroupEntry$PriceData;Ljava/lang/String;)V", "value", "getPrice", "()I", "setPrice", "(I)V", "discount", "getDiscount", "setDiscount", "priceWithDisc", "getPriceWithDisc", "setPriceWithDisc", "getCurrency", "()Ljava/lang/String;", "setCurrency", "(Ljava/lang/String;)V", "iconState", "Lgg/essential/elementa/state/MappedState;", "Lnet/minecraft/resources/ResourceLocation;", "kotlin.jvm.PlatformType", "getIconState", "()Lgg/essential/elementa/state/MappedState;", "oldPrice", "Lnet/mcskill/shop/client/screen/component/NewPriceGroup$LabeledIcon;", "getOldPrice", "()Lnet/mcskill/shop/client/screen/component/NewPriceGroup$LabeledIcon;", "oldPrice$delegate", "Lkotlin/properties/ReadWriteProperty;", "newPrice", "getNewPrice", "newPrice$delegate", "updatePosition", "", "LabeledIcon", "MSShop"})
@SourceDebugExtension({"SMAP\nNewPriceGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NewPriceGroup.kt\nnet/mcskill/shop/client/screen/component/NewPriceGroup\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,108:1\n10#2,3:109\n10#2,3:112\n*S KotlinDebug\n*F\n+ 1 NewPriceGroup.kt\nnet/mcskill/shop/client/screen/component/NewPriceGroup\n*L\n68#1:109,3\n75#1:112,3\n*E\n"})
public final class NewPriceGroup extends UIContainer {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(NewPriceGroup.class, "oldPrice", "getOldPrice()Lnet/mcskill/shop/client/screen/component/NewPriceGroup$LabeledIcon;", 0)), Reflection.property1(new PropertyReference1Impl(NewPriceGroup.class, "newPrice", "getNewPrice()Lnet/mcskill/shop/client/screen/component/NewPriceGroup$LabeledIcon;", 0))};

    @NotNull
    private final BasicState<Integer> priceState;

    @NotNull
    private final BasicState<Integer> discountState;

    @NotNull
    private final BasicState<Integer> priceWithDiscState;

    @NotNull
    private final BasicState<String> currencyState;

    @NotNull
    private final MappedState<String, ResourceLocation> iconState;

    /* JADX INFO: renamed from: oldPrice$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty oldPrice;

    /* JADX INFO: renamed from: newPrice$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty newPrice;

    public NewPriceGroup(@NotNull BasicState<Integer> basicState, @NotNull BasicState<Integer> basicState2, @NotNull BasicState<Integer> basicState3, @NotNull BasicState<String> basicState4) {
        Intrinsics.checkNotNullParameter(basicState, "priceState");
        Intrinsics.checkNotNullParameter(basicState2, "discountState");
        Intrinsics.checkNotNullParameter(basicState3, "priceWithDiscState");
        Intrinsics.checkNotNullParameter(basicState4, "currencyState");
        this.priceState = basicState;
        this.discountState = basicState2;
        this.priceWithDiscState = basicState3;
        this.currencyState = basicState4;
        this.iconState = this.currencyState.map(NewPriceGroup::iconState$lambda$0);
        State map = this.priceState.map((v0) -> {
            return oldPrice_delegate$lambda$1(v0);
        });
        State map2 = this.currencyState.map(NewPriceGroup::oldPrice_delegate$lambda$2);
        Color color = Color.GRAY;
        Intrinsics.checkNotNullExpressionValue(color, "GRAY");
        this.oldPrice = ComponentsKt.provideDelegate(ComponentsKt.childOf(new LabeledIcon(this, map, map2, color), (UIComponent) this), this, $$delegatedProperties[0]);
        this.newPrice = ComponentsKt.provideDelegate(ComponentsKt.childOf(new LabeledIcon(this, this.priceWithDiscState.map((v0) -> {
            return newPrice_delegate$lambda$3(v0);
        }), this.iconState, null, 4, null), (UIComponent) this), this, $$delegatedProperties[1]);
        updatePosition();
        this.discountState.onSetValue((v1) -> {
            return _init_$lambda$4(r1, v1);
        });
    }

    public final int getPrice() {
        return ((Number) this.priceState.get()).intValue();
    }

    public final void setPrice(int value) {
        this.priceState.set(Integer.valueOf(value));
    }

    public final int getDiscount() {
        return ((Number) this.discountState.get()).intValue();
    }

    public final void setDiscount(int value) {
        this.discountState.set(Integer.valueOf(value));
    }

    public final int getPriceWithDisc() {
        return ((Number) this.priceWithDiscState.get()).intValue();
    }

    public final void setPriceWithDisc(int value) {
        this.priceWithDiscState.set(Integer.valueOf(value));
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
    public final MappedState<String, ResourceLocation> getIconState() {
        return this.iconState;
    }

    private static final ResourceLocation iconState$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ResourcesKt.asResource$default("textures/" + it + "_20x20.png", (String) null, 1, (Object) null);
    }

    private final LabeledIcon getOldPrice() {
        return (LabeledIcon) this.oldPrice.getValue(this, $$delegatedProperties[0]);
    }

    private static final String oldPrice_delegate$lambda$1(int it) {
        return "&m" + it;
    }

    private static final ResourceLocation oldPrice_delegate$lambda$2(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ResourceLocation resourceLocationAsResource$default = ResourcesKt.asResource$default("textures/" + it + "_gray_20x20.png", (String) null, 1, (Object) null);
        Intrinsics.checkNotNullExpressionValue(resourceLocationAsResource$default, "asResource$default(...)");
        return resourceLocationAsResource$default;
    }

    private final LabeledIcon getNewPrice() {
        return (LabeledIcon) this.newPrice.getValue(this, $$delegatedProperties[1]);
    }

    private static final String newPrice_delegate$lambda$3(int it) {
        return String.valueOf(it);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewPriceGroup(@NotNull GroupEntry.PriceData price, @NotNull String currency) {
        this(StateKt.state(Integer.valueOf(price.getValue())), StateKt.state(Integer.valueOf(price.getDiscount())), StateKt.state(Integer.valueOf(price.getPriceDiscount())), StateKt.state(currency));
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(currency, "currency");
    }

    private static final Unit _init_$lambda$4(NewPriceGroup this$0, int it) {
        this$0.updatePosition();
        return Unit.INSTANCE;
    }

    public final void updatePosition() {
        if (getPriceWithDisc() > 0 && getDiscount() > 0) {
            getOldPrice().unhide(true);
            UIComponent $this$constrain$iv = getNewPrice();
            UIConstraints $this$updatePosition_u24lambda_u245 = $this$constrain$iv.getConstraints();
            $this$updatePosition_u24lambda_u245.setX(ConstraintsKt.boundTo(UtilitiesKt.dp(Float.valueOf(8.0f), true, true), getOldPrice()));
            $this$updatePosition_u24lambda_u245.setY(ConstraintsKt.boundTo(new CenterConstraint(), getOldPrice()));
            getNewPrice().getLabel().setText(String.valueOf(getPriceWithDisc()));
            return;
        }
        getOldPrice().hide(true);
        UIComponent $this$constrain$iv2 = getNewPrice();
        UIConstraints $this$updatePosition_u24lambda_u246 = $this$constrain$iv2.getConstraints();
        $this$updatePosition_u24lambda_u246.setX(UtilitiesKt.getDp((Number) 0));
        $this$updatePosition_u24lambda_u246.setY(UtilitiesKt.getDp((Number) 0));
        getNewPrice().getLabel().setText(String.valueOf(getPrice()));
    }

    /* JADX INFO: compiled from: NewPriceGroup.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/NewPriceGroup$LabeledIcon.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lnet/mcskill/shop/client/screen/component/NewPriceGroup$LabeledIcon;", "Lgg/essential/elementa/components/UIContainer;", "text", "Lgg/essential/elementa/state/State;", "", "iconPath", "Lnet/minecraft/resources/ResourceLocation;", "textColor", "Ljava/awt/Color;", "<init>", "(Lnet/mcskill/shop/client/screen/component/NewPriceGroup;Lgg/essential/elementa/state/State;Lgg/essential/elementa/state/State;Ljava/awt/Color;)V", "label", "Lgg/essential/elementa/components/LabelComponent;", "getLabel", "()Lgg/essential/elementa/components/LabelComponent;", "label$delegate", "Lkotlin/properties/ReadWriteProperty;", "icon", "Lgg/essential/elementa/components/image/ImageComponent;", "getIcon", "()Lgg/essential/elementa/components/image/ImageComponent;", "icon$delegate", "MSShop"})
    @SourceDebugExtension({"SMAP\nNewPriceGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NewPriceGroup.kt\nnet/mcskill/shop/client/screen/component/NewPriceGroup$LabeledIcon\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,108:1\n10#2,3:109\n10#2,3:112\n10#2,3:115\n*S KotlinDebug\n*F\n+ 1 NewPriceGroup.kt\nnet/mcskill/shop/client/screen/component/NewPriceGroup$LabeledIcon\n*L\n88#1:109,3\n94#1:112,3\n102#1:115,3\n*E\n"})
    public final class LabeledIcon extends UIContainer {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(LabeledIcon.class, "label", "getLabel()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(LabeledIcon.class, "icon", "getIcon()Lgg/essential/elementa/components/image/ImageComponent;", 0))};

        /* JADX INFO: renamed from: label$delegate, reason: from kotlin metadata */
        @NotNull
        private final ReadWriteProperty label;

        /* JADX INFO: renamed from: icon$delegate, reason: from kotlin metadata */
        @NotNull
        private final ReadWriteProperty icon;
        final /* synthetic */ NewPriceGroup this$0;

        public LabeledIcon(@NotNull NewPriceGroup this$0, @NotNull State<String> state, @NotNull State<ResourceLocation> state2, Color textColor) {
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

        public /* synthetic */ LabeledIcon(NewPriceGroup newPriceGroup, State state, State state2, Color color, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(newPriceGroup, state, state2, (i & 4) != 0 ? Color.WHITE : color);
        }

        @NotNull
        public final LabelComponent getLabel() {
            return (LabelComponent) this.label.getValue(this, $$delegatedProperties[0]);
        }

        private final ImageComponent getIcon() {
            return (ImageComponent) this.icon.getValue(this, $$delegatedProperties[1]);
        }
    }
}
