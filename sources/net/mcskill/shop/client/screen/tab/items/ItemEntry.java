package net.mcskill.shop.client.screen.tab.items;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.ItemStackComponent;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.components.Window;
import gg.essential.elementa.components.image.ImageView;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedMaxSizeConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.CramSiblingConstraint;
import gg.essential.elementa.constraints.HeightConstraint;
import gg.essential.elementa.constraints.WidthConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.RoundOutlineEffect;
import gg.essential.elementa.effects.StencilEffect;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.state.State;
import java.awt.Color;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.shop.client.screen.component.EntryComponent;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.component.PriceGroup;
import net.mcskill.shop.client.screen.component.TriangleBlock;
import net.mcskill.shop.client.screen.modal.item.BuyItemModal;
import net.mcskill.shop.client.screen.modal.item.BuyKitModal;
import net.mcskill.shop.common.CurrencyType;
import net.mcskill.shop.common.response.shop.ItemData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ItemEntry.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/tab/items/ItemEntry.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010\u001b\u001a\u00020\u001cX\u008a\u0084\u0002"}, d2 = {"Lnet/mcskill/shop/client/screen/tab/items/ItemEntry;", "Lnet/mcskill/shop/client/screen/component/EntryComponent;", "item", "Lnet/mcskill/shop/common/response/shop/ItemData;", "currency", "Lgg/essential/elementa/state/State;", "Lnet/mcskill/shop/common/CurrencyType;", "<init>", "(Lnet/mcskill/shop/common/response/shop/ItemData;Lgg/essential/elementa/state/State;)V", "getItem", "()Lnet/mcskill/shop/common/response/shop/ItemData;", "_priceState", "", "_price", "Lnet/mcskill/shop/client/screen/component/PriceGroup;", "get_price", "()Lnet/mcskill/shop/client/screen/component/PriceGroup;", "_price$delegate", "Lkotlin/properties/ReadWriteProperty;", "_actionButton", "Lgg/essential/elementa/UIComponent;", "get_actionButton", "()Lgg/essential/elementa/UIComponent;", "_actionButton$delegate", "MSShop", "discountPlate", "Lnet/mcskill/shop/client/screen/component/TriangleBlock;", "plate", "Lgg/essential/elementa/components/UIRoundedRectangle;"})
@SourceDebugExtension({"SMAP\nItemEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemEntry.kt\nnet/mcskill/shop/client/screen/tab/items/ItemEntry\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,124:1\n10#2,3:125\n10#2,3:128\n10#2,3:131\n10#2,3:134\n10#2,3:137\n10#2,3:140\n10#2,3:143\n10#2,3:146\n*S KotlinDebug\n*F\n+ 1 ItemEntry.kt\nnet/mcskill/shop/client/screen/tab/items/ItemEntry\n*L\n37#1:125,3\n44#1:128,3\n58#1:131,3\n80#1:134,3\n93#1:137,3\n99#1:140,3\n108#1:143,3\n116#1:146,3\n*E\n"})
public final class ItemEntry extends EntryComponent {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ItemEntry.class, "_price", "get_price()Lnet/mcskill/shop/client/screen/component/PriceGroup;", 0)), Reflection.property1(new PropertyReference1Impl(ItemEntry.class, "_actionButton", "get_actionButton()Lgg/essential/elementa/UIComponent;", 0)), Reflection.property0(new PropertyReference0Impl(ItemEntry.class, "discountPlate", "<v#0>", 0)), Reflection.property0(new PropertyReference0Impl(ItemEntry.class, "plate", "<v#1>", 0))};

    @NotNull
    private final ItemData item;

    @NotNull
    private final State<Number> _priceState;

    /* JADX INFO: renamed from: _price$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _price;

    /* JADX INFO: renamed from: _actionButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _actionButton;

    @NotNull
    public final ItemData getItem() {
        return this.item;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemEntry(@NotNull ItemData item, @NotNull State<CurrencyType> state) {
        UIComponent imageView;
        super(item.getName(), 0, 0.0f, 180, 18, 6, null);
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(state, "currency");
        this.item = item;
        this._priceState = state.map((v1) -> {
            return _priceState$lambda$0(r2, v1);
        });
        UIComponent $this$constrain$iv = new PriceGroup(this._priceState, (State<String>) state.map(ItemEntry::_price_delegate$lambda$1), (State<Number>) new BasicState(Integer.valueOf(this.item.getDiscount())));
        UIConstraints $this$_price_delegate_u24lambda_u242 = $this$constrain$iv.getConstraints();
        $this$_price_delegate_u24lambda_u242.setX(new CenterConstraint());
        $this$_price_delegate_u24lambda_u242.setY(UtilitiesKt.getDp((Number) 151));
        $this$_price_delegate_u24lambda_u242.setWidth(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null));
        $this$_price_delegate_u24lambda_u242.setHeight(new ChildBasedMaxSizeConstraint());
        this._price = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        LabelButton labelButton = (UIComponent) new LabelButton(Intrinsics.areEqual(this.item.getType(), "kit") ? "Подробнее" : "Купить", 18, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$_actionButton_delegate_u24lambda_u243 = labelButton.getConstraints();
        $this$_actionButton_delegate_u24lambda_u243.setX(new CenterConstraint());
        $this$_actionButton_delegate_u24lambda_u243.setY(UtilitiesKt.getDp((Number) 175));
        $this$_actionButton_delegate_u24lambda_u243.setWidth(UtilitiesKt.getDp((Number) 148));
        $this$_actionButton_delegate_u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 31));
        $this$_actionButton_delegate_u24lambda_u243.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this._actionButton = ComponentsKt.provideDelegate(ComponentsKt.childOf(labelButton.onMouseClick((v2, v3) -> {
            return _actionButton_delegate$lambda$4(r2, r3, v2, v3);
        }), (UIComponent) this), this, $$delegatedProperties[1]);
        UIConstraints $this$_init__u24lambda_u245 = ((UIComponent) this).getConstraints();
        $this$_init__u24lambda_u245.setX(new CramSiblingConstraint(18.0f));
        $this$_init__u24lambda_u245.setY(new CramSiblingConstraint(17.0f));
        $this$_init__u24lambda_u245.setWidth(UtilitiesKt.getDp((Number) 196));
        $this$_init__u24lambda_u245.setHeight(UtilitiesKt.getDp((Number) 220));
        if (Intrinsics.areEqual(this.item.getType(), "command")) {
            imageView = (UIComponent) new ImageView(this.item.getImg(), 0.75f, 0.75f, UIImage.TextureScalingMode.NEAREST, UIImage.TextureScalingMode.NEAREST, (WidthConstraint) null, (HeightConstraint) null, 96, (DefaultConstructorMarker) null);
        } else {
            UIComponent uIComponentOf$default = ItemStackComponent.Companion.of$default(ItemStackComponent.Companion, this.item.getItemName(), 0, 0, (String) null, 14, (Object) null);
            if (Intrinsics.areEqual(this.item.getType(), "kit") || uIComponentOf$default.getStack().isEmpty()) {
                imageView = new ImageView(this.item.getImg(), 0.75f, 0.75f, UIImage.TextureScalingMode.NEAREST, UIImage.TextureScalingMode.NEAREST, (WidthConstraint) null, (HeightConstraint) null, 96, (DefaultConstructorMarker) null);
            } else {
                imageView = uIComponentOf$default;
            }
        }
        UIComponent $this$constrain$iv2 = imageView;
        UIConstraints $this$_init__u24lambda_u246 = $this$constrain$iv2.getConstraints();
        $this$_init__u24lambda_u246.setX(new CenterConstraint());
        $this$_init__u24lambda_u246.setY(UtilitiesKt.getDp((Number) 62));
        $this$_init__u24lambda_u246.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u246.setHeight(UtilitiesKt.getDp((Number) 84));
        UIComponent logo = ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this);
        int discount = this.item.getDiscount();
        if (discount > 0) {
            State stateFetchColorBy = fetchColorBy(discount);
            ComponentsKt.effect((UIComponent) this, new RoundOutlineEffect((Color) stateFetchColorBy.get(), 10.0f, 1.5f, 0.7f, false, 16, (DefaultConstructorMarker) null));
            ComponentsKt.effect((UIComponent) this, new StencilEffect());
            UIComponent $this$constrain$iv3 = new TriangleBlock((State<Color>) stateFetchColorBy);
            UIConstraints $this$_init__u24lambda_u247 = $this$constrain$iv3.getConstraints();
            $this$_init__u24lambda_u247.setX(UtilitiesKt.dp$default((Number) 3, true, false, 2, (Object) null));
            $this$_init__u24lambda_u247.setY(UtilitiesKt.getDp((Number) 3));
            $this$_init__u24lambda_u247.setWidth(UtilitiesKt.getDp((Number) 62));
            $this$_init__u24lambda_u247.setHeight(UtilitiesKt.getDp((Number) 62));
            ReadWriteProperty discountPlate$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, (UIComponent) this), (Object) null, $$delegatedProperties[2]);
            UIComponent $this$constrain$iv4 = new LabelComponent("§l-" + discount + "%", false, (Color) null, 6, (DefaultConstructorMarker) null);
            UIConstraints $this$_init__u24lambda_u249 = $this$constrain$iv4.getConstraints();
            $this$_init__u24lambda_u249.setX(UtilitiesKt.dp$default((Number) 5, true, false, 2, (Object) null));
            $this$_init__u24lambda_u249.setY(UtilitiesKt.getDp((Number) 16));
            $this$_init__u24lambda_u249.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
            $this$_init__u24lambda_u249.setTextScale(UtilitiesKt.getDp((Number) 14));
            ComponentsKt.childOf($this$constrain$iv4, _init_$lambda$8(discountPlate$delegate));
        }
        if (this.item.getAmount() <= 1) {
            return;
        }
        UIComponent $this$constrain$iv5 = new UIRoundedRectangle(12.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$_init__u24lambda_u2410 = $this$constrain$iv5.getConstraints();
        $this$_init__u24lambda_u2410.setX(UtilitiesKt.dp$default((Number) 0, true, false, 2, (Object) null));
        $this$_init__u24lambda_u2410.setY(UtilitiesKt.dp$default((Number) 0, true, false, 2, (Object) null));
        $this$_init__u24lambda_u2410.setWidth(ConstraintsKt.plus(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null), UtilitiesKt.getDp((Number) 10)));
        $this$_init__u24lambda_u2410.setHeight(ConstraintsKt.plus(new ChildBasedMaxSizeConstraint(), UtilitiesKt.getDp((Number) 6)));
        $this$_init__u24lambda_u2410.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getBlue()));
        ReadWriteProperty plate$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv5, logo), (Object) null, $$delegatedProperties[3]);
        UIComponent $this$constrain$iv6 = new LabelComponent("§lx" + this.item.getAmount(), false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_init__u24lambda_u2412 = $this$constrain$iv6.getConstraints();
        $this$_init__u24lambda_u2412.setX(new CenterConstraint());
        $this$_init__u24lambda_u2412.setY(new CenterConstraint());
        $this$_init__u24lambda_u2412.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_init__u24lambda_u2412.setTextScale(UtilitiesKt.getDp((Number) 18));
        ComponentsKt.childOf($this$constrain$iv6, _init_$lambda$11(plate$delegate));
    }

    private static final Number _priceState$lambda$0(ItemEntry this$0, CurrencyType it) {
        double priceEm;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it == CurrencyType.RUBLE) {
            priceEm = this$0.item.getPriceRub();
        } else {
            priceEm = this$0.item.getPriceEm();
        }
        return Double.valueOf(priceEm);
    }

    private final PriceGroup get_price() {
        return (PriceGroup) this._price.getValue(this, $$delegatedProperties[0]);
    }

    private static final String _price_delegate$lambda$1(CurrencyType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String lowerCase = it.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final UIComponent get_actionButton() {
        return (UIComponent) this._actionButton.getValue(this, $$delegatedProperties[1]);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0064  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static final Unit _actionButton_delegate$lambda$4(ItemEntry this$0, State $currency, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        String type = this$0.item.getType();
        switch (type.hashCode()) {
            case 106198:
                if (type.equals("kit")) {
                    ComponentsKt.childOf(new BuyKitModal(this$0.item, this$0._priceState, $currency), Window.Companion.of($this$onMouseClick));
                }
                break;
            case 3242771:
                if (type.equals("item")) {
                    ComponentsKt.childOf(new BuyItemModal(this$0.item, this$0._priceState, $currency), Window.Companion.of($this$onMouseClick));
                }
                break;
            case 950394699:
                if (type.equals("command")) {
                    ComponentsKt.childOf(new BuyItemModal(this$0.item, this$0._priceState, $currency), Window.Companion.of($this$onMouseClick));
                }
                break;
        }
        return Unit.INSTANCE;
    }

    private static final TriangleBlock _init_$lambda$8(ReadWriteProperty<Object, TriangleBlock> readWriteProperty) {
        return (TriangleBlock) readWriteProperty.getValue((Object) null, $$delegatedProperties[2]);
    }

    private static final UIRoundedRectangle _init_$lambda$11(ReadWriteProperty<Object, UIRoundedRectangle> readWriteProperty) {
        return (UIRoundedRectangle) readWriteProperty.getValue((Object) null, $$delegatedProperties[3]);
    }
}
