package net.mcskill.shop.client.screen.modal.item;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.ItemStackComponent;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.components.WrappedText;
import gg.essential.elementa.components.image.ImageView;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedMaxSizeConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.constraints.HeightConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.constraints.WidthConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.state.State;
import java.awt.Color;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
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
import net.mcskill.shop.client.screen.component.ContentView;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.component.NumberCounter;
import net.mcskill.shop.client.screen.component.PriceGroup;
import net.mcskill.shop.client.screen.modal.Modal;
import net.mcskill.shop.client.screen.modal.cases.component.DustInfoBlock;
import net.mcskill.shop.common.CurrencyType;
import net.mcskill.shop.common.network.ChannelHandler;
import net.mcskill.shop.common.network.packet.buy.RequestBuyItemPacket;
import net.mcskill.shop.common.response.shop.ItemData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BuyItemModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/item/BuyItemModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u0018\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020-H\u0002J\u0018\u00105\u001a\u0002022\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00104\u001a\u00020-H\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b\u001f\u0010\u0017R\u001b\u0010!\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b\"\u0010\u0017R\u001b\u0010$\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0013\u001a\u0004\b%\u0010\u0017R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0013\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0013\u001a\u0004\b.\u0010/¨\u00066²\u0006\n\u00107\u001a\u00020\u000fX\u008a\u0084\u0002²\u0006\n\u00108\u001a\u000209X\u008a\u0084\u0002"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/item/BuyItemModal;", "Lnet/mcskill/shop/client/screen/modal/Modal;", "item", "Lnet/mcskill/shop/common/response/shop/ItemData;", "price", "Lgg/essential/elementa/state/State;", "", "currency", "Lnet/mcskill/shop/common/CurrencyType;", "<init>", "(Lnet/mcskill/shop/common/response/shop/ItemData;Lgg/essential/elementa/state/State;Lgg/essential/elementa/state/State;)V", "_totalAmount", "Lgg/essential/elementa/state/BasicState;", "", "_divider", "Lgg/essential/elementa/components/UIRoundedRectangle;", "get_divider", "()Lgg/essential/elementa/components/UIRoundedRectangle;", "_divider$delegate", "Lkotlin/properties/ReadWriteProperty;", "_amountLabel", "Lgg/essential/elementa/components/LabelComponent;", "get_amountLabel", "()Lgg/essential/elementa/components/LabelComponent;", "_amountLabel$delegate", "_counter", "Lnet/mcskill/shop/client/screen/component/NumberCounter;", "get_counter", "()Lnet/mcskill/shop/client/screen/component/NumberCounter;", "_counter$delegate", "_totalCountLabel", "get_totalCountLabel", "_totalCountLabel$delegate", "_totalCount", "get_totalCount", "_totalCount$delegate", "_totalLabel", "get_totalLabel", "_totalLabel$delegate", "_totalPrice", "Lnet/mcskill/shop/client/screen/component/PriceGroup;", "get_totalPrice", "()Lnet/mcskill/shop/client/screen/component/PriceGroup;", "_totalPrice$delegate", "_buyButton", "Lgg/essential/elementa/UIComponent;", "get_buyButton", "()Lgg/essential/elementa/UIComponent;", "_buyButton$delegate", "amountBadge", "", "amount", "attachTo", "description", "MSShop", "plate", "descriptionView", "Lnet/mcskill/shop/client/screen/component/ContentView;"})
@SourceDebugExtension({"SMAP\nBuyItemModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuyItemModal.kt\nnet/mcskill/shop/client/screen/modal/item/BuyItemModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,164:1\n10#2,3:165\n10#2,3:168\n10#2,3:171\n10#2,3:174\n10#2,3:177\n10#2,3:180\n10#2,3:183\n10#2,3:186\n10#2,3:189\n10#2,3:192\n10#2,3:195\n10#2,3:198\n10#2,3:201\n10#2,3:204\n*S KotlinDebug\n*F\n+ 1 BuyItemModal.kt\nnet/mcskill/shop/client/screen/modal/item/BuyItemModal\n*L\n37#1:165,3\n45#1:168,3\n52#1:171,3\n59#1:174,3\n68#1:177,3\n75#1:180,3\n84#1:183,3\n89#1:186,3\n109#1:189,3\n124#1:192,3\n132#1:195,3\n144#1:198,3\n151#1:201,3\n158#1:204,3\n*E\n"})
public final class BuyItemModal extends Modal {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(BuyItemModal.class, "_divider", "get_divider()Lgg/essential/elementa/components/UIRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(BuyItemModal.class, "_amountLabel", "get_amountLabel()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(BuyItemModal.class, "_counter", "get_counter()Lnet/mcskill/shop/client/screen/component/NumberCounter;", 0)), Reflection.property1(new PropertyReference1Impl(BuyItemModal.class, "_totalCountLabel", "get_totalCountLabel()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(BuyItemModal.class, "_totalCount", "get_totalCount()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(BuyItemModal.class, "_totalLabel", "get_totalLabel()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(BuyItemModal.class, "_totalPrice", "get_totalPrice()Lnet/mcskill/shop/client/screen/component/PriceGroup;", 0)), Reflection.property1(new PropertyReference1Impl(BuyItemModal.class, "_buyButton", "get_buyButton()Lgg/essential/elementa/UIComponent;", 0)), Reflection.property0(new PropertyReference0Impl(BuyItemModal.class, "plate", "<v#0>", 0)), Reflection.property0(new PropertyReference0Impl(BuyItemModal.class, "descriptionView", "<v#1>", 0))};

    @NotNull
    private final BasicState<Integer> _totalAmount;

    /* JADX INFO: renamed from: _divider$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _divider;

    /* JADX INFO: renamed from: _amountLabel$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _amountLabel;

    /* JADX INFO: renamed from: _counter$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _counter;

    /* JADX INFO: renamed from: _totalCountLabel$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _totalCountLabel;

    /* JADX INFO: renamed from: _totalCount$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _totalCount;

    /* JADX INFO: renamed from: _totalLabel$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _totalLabel;

    /* JADX INFO: renamed from: _totalPrice$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _totalPrice;

    /* JADX INFO: renamed from: _buyButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _buyButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuyItemModal(@NotNull ItemData item, @NotNull State<Number> state, @NotNull State<CurrencyType> state2) {
        UIComponent uIComponent;
        super(Intrinsics.areEqual(item.getType(), "command") ? "Купить команду" : "Купить предмет", 524.0f, item.getDescription().length() == 0 ? 260.0f : 428.0f);
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(state, "price");
        Intrinsics.checkNotNullParameter(state2, "currency");
        this._totalAmount = new BasicState<>(Integer.valueOf(item.getAmount()));
        UIComponent $this$constrain$iv = new UIRoundedRectangle(5.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$_divider_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_divider_delegate_u24lambda_u240.setX(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp((Number) 50)));
        $this$_divider_delegate_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 81));
        $this$_divider_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp((Number) 4));
        $this$_divider_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 152));
        $this$_divider_delegate_u24lambda_u240.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA1()));
        this._divider = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, getContent()), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new LabelComponent("Кол-во:", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_amountLabel_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_amountLabel_delegate_u24lambda_u241.setX(ConstraintsKt.boundTo(UtilitiesKt.getDp((Number) 32), get_divider()));
        $this$_amountLabel_delegate_u24lambda_u241.setY(UtilitiesKt.getDp((Number) 93));
        $this$_amountLabel_delegate_u24lambda_u241.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_amountLabel_delegate_u24lambda_u241.setTextScale(UtilitiesKt.getDp((Number) 20));
        this._amountLabel = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, getContent()), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = new NumberCounter(1, 0, 0, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_counter_delegate_u24lambda_u242 = $this$constrain$iv3.getConstraints();
        $this$_counter_delegate_u24lambda_u242.setX(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 4, true, true), get_amountLabel()));
        $this$_counter_delegate_u24lambda_u242.setY(ConstraintsKt.boundTo(new CenterConstraint(), get_amountLabel()));
        $this$_counter_delegate_u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 140));
        $this$_counter_delegate_u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 24));
        this._counter = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, getContent()), this, $$delegatedProperties[2]);
        UIComponent $this$constrain$iv4 = new LabelComponent(Intrinsics.areEqual(item.getType(), "command") ? "&lВсего:" : "§lПредметов:", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_totalCountLabel_delegate_u24lambda_u243 = $this$constrain$iv4.getConstraints();
        $this$_totalCountLabel_delegate_u24lambda_u243.setX(ConstraintsKt.boundTo(UtilitiesKt.getDp((Number) 32), get_divider()));
        $this$_totalCountLabel_delegate_u24lambda_u243.setY(new SiblingConstraint(12.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_totalCountLabel_delegate_u24lambda_u243.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_totalCountLabel_delegate_u24lambda_u243.setTextScale(UtilitiesKt.getDp((Number) 20));
        this._totalCountLabel = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, getContent()), this, $$delegatedProperties[3]);
        UIComponent $this$constrain$iv5 = new LabelComponent(get_counter().getValueState().zip(this._totalAmount).map(BuyItemModal::_totalCount_delegate$lambda$4), (State) null, (State) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_totalCount_delegate_u24lambda_u245 = $this$constrain$iv5.getConstraints();
        $this$_totalCount_delegate_u24lambda_u245.setX(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 8, true, true), get_totalCountLabel()));
        $this$_totalCount_delegate_u24lambda_u245.setY(ConstraintsKt.boundTo(UtilitiesKt.dp$default((Number) 0, false, false, 3, (Object) null), get_totalCountLabel()));
        $this$_totalCount_delegate_u24lambda_u245.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_totalCount_delegate_u24lambda_u245.setTextScale(UtilitiesKt.getDp((Number) 20));
        this._totalCount = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv5, getContent()), this, $$delegatedProperties[4]);
        UIComponent $this$constrain$iv6 = new LabelComponent("§lИтого к оплате:", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_totalLabel_delegate_u24lambda_u246 = $this$constrain$iv6.getConstraints();
        $this$_totalLabel_delegate_u24lambda_u246.setX(ConstraintsKt.boundTo(UtilitiesKt.getDp((Number) 32), get_divider()));
        $this$_totalLabel_delegate_u24lambda_u246.setY(ConstraintsKt.boundTo(new SiblingConstraint(12.0f, false, false, 6, (DefaultConstructorMarker) null), get_totalCountLabel()));
        $this$_totalLabel_delegate_u24lambda_u246.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_totalLabel_delegate_u24lambda_u246.setTextScale(UtilitiesKt.getDp((Number) 20));
        this._totalLabel = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv6, getContent()), this, $$delegatedProperties[5]);
        UIComponent $this$constrain$iv7 = new PriceGroup((State<Number>) get_counter().getValueState().zip(state).map(BuyItemModal::_totalPrice_delegate$lambda$7), (State<String>) state2.map(BuyItemModal::_totalPrice_delegate$lambda$8), (State<Number>) new BasicState(Integer.valueOf(item.getDiscount())));
        UIConstraints $this$_totalPrice_delegate_u24lambda_u249 = $this$constrain$iv7.getConstraints();
        $this$_totalPrice_delegate_u24lambda_u249.setX(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 8, true, true), get_totalLabel()));
        $this$_totalPrice_delegate_u24lambda_u249.setY(ConstraintsKt.boundTo(UtilitiesKt.dp$default((Number) 0, false, false, 3, (Object) null), get_totalLabel()));
        this._totalPrice = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv7, getContent()), this, $$delegatedProperties[6]);
        LabelButton labelButton = (UIComponent) new LabelButton("Купить", 18, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$_buyButton_delegate_u24lambda_u2410 = labelButton.getConstraints();
        $this$_buyButton_delegate_u24lambda_u2410.setX(ConstraintsKt.boundTo(UtilitiesKt.getDp((Number) 32), get_divider()));
        $this$_buyButton_delegate_u24lambda_u2410.setY(new SiblingConstraint(16.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_buyButton_delegate_u24lambda_u2410.setWidth(UtilitiesKt.getDp((Number) 115));
        $this$_buyButton_delegate_u24lambda_u2410.setHeight(UtilitiesKt.getDp((Number) 31));
        $this$_buyButton_delegate_u24lambda_u2410.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this._buyButton = ComponentsKt.provideDelegate(ComponentsKt.childOf(labelButton.onMouseClick((v2, v3) -> {
            return _buyButton_delegate$lambda$11(r2, r3, v2, v3);
        }), getContent()), this, $$delegatedProperties[7]);
        if (Intrinsics.areEqual(item.getType(), "command")) {
            uIComponent = (UIComponent) new ImageView(item.getImg(), 1.0f, 1.0f, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, (WidthConstraint) null, (HeightConstraint) null, DustInfoBlock.DELIMITER, (DefaultConstructorMarker) null);
        } else {
            UIComponent uIComponentOf$default = ItemStackComponent.Companion.of$default(ItemStackComponent.Companion, item.getItemName(), 0, 0, (String) null, 14, (Object) null);
            if (uIComponentOf$default.getStack().isEmpty()) {
                uIComponent = (UIComponent) new ImageView(item.getImg(), 1.0f, 1.0f, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, (WidthConstraint) null, (HeightConstraint) null, DustInfoBlock.DELIMITER, (DefaultConstructorMarker) null);
            } else {
                uIComponent = uIComponentOf$default;
            }
        }
        UIComponent $this$constrain$iv8 = uIComponent;
        UIConstraints $this$_init__u24lambda_u2412 = $this$constrain$iv8.getConstraints();
        $this$_init__u24lambda_u2412.setX(UtilitiesKt.getDp((Number) 42));
        $this$_init__u24lambda_u2412.setY(UtilitiesKt.getDp((Number) 101));
        $this$_init__u24lambda_u2412.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u2412.setHeight(UtilitiesKt.getDp((Number) 124));
        UIComponent logo = ComponentsKt.childOf($this$constrain$iv8, getContent());
        amountBadge(item.getAmount(), logo);
        description(item, logo);
    }

    private final UIRoundedRectangle get_divider() {
        return (UIRoundedRectangle) this._divider.getValue(this, $$delegatedProperties[0]);
    }

    private final LabelComponent get_amountLabel() {
        return (LabelComponent) this._amountLabel.getValue(this, $$delegatedProperties[1]);
    }

    private final NumberCounter get_counter() {
        return (NumberCounter) this._counter.getValue(this, $$delegatedProperties[2]);
    }

    private final LabelComponent get_totalCountLabel() {
        return (LabelComponent) this._totalCountLabel.getValue(this, $$delegatedProperties[3]);
    }

    private final LabelComponent get_totalCount() {
        return (LabelComponent) this._totalCount.getValue(this, $$delegatedProperties[4]);
    }

    private static final String _totalCount_delegate$lambda$4(Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (((Number) it.getFirst()).intValue() * ((Number) it.getSecond()).intValue()) + " шт.";
    }

    private final LabelComponent get_totalLabel() {
        return (LabelComponent) this._totalLabel.getValue(this, $$delegatedProperties[5]);
    }

    private final PriceGroup get_totalPrice() {
        return (PriceGroup) this._totalPrice.getValue(this, $$delegatedProperties[6]);
    }

    private static final Number _totalPrice_delegate$lambda$7(Pair value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return Integer.valueOf(((Number) value.getFirst()).intValue() * ((Number) value.getSecond()).intValue());
    }

    private static final String _totalPrice_delegate$lambda$8(CurrencyType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String lowerCase = it.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final UIComponent get_buyButton() {
        return (UIComponent) this._buyButton.getValue(this, $$delegatedProperties[7]);
    }

    private static final Unit _buyButton_delegate$lambda$11(ItemData $item, BuyItemModal this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ChannelHandler.INSTANCE.sendToServer(new RequestBuyItemPacket($item.getId(), this$0.get_counter().getValue(), $item.getCatId(), $item.getType()));
        return Unit.INSTANCE;
    }

    private final void amountBadge(int amount, UIComponent attachTo) {
        if (amount <= 1) {
            return;
        }
        UIComponent $this$constrain$iv = new UIRoundedRectangle(12.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$amountBadge_u24lambda_u2413 = $this$constrain$iv.getConstraints();
        $this$amountBadge_u24lambda_u2413.setX(UtilitiesKt.dp$default((Number) 0, true, false, 2, (Object) null));
        $this$amountBadge_u24lambda_u2413.setY(UtilitiesKt.dp$default((Number) 0, true, false, 2, (Object) null));
        $this$amountBadge_u24lambda_u2413.setWidth(ConstraintsKt.plus(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null), UtilitiesKt.getDp((Number) 10)));
        $this$amountBadge_u24lambda_u2413.setHeight(ConstraintsKt.plus(new ChildBasedMaxSizeConstraint(), UtilitiesKt.getDp((Number) 6)));
        $this$amountBadge_u24lambda_u2413.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getBlue()));
        ReadWriteProperty plate$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, attachTo), (Object) null, $$delegatedProperties[8]);
        UIComponent $this$constrain$iv2 = new LabelComponent("§lx" + amount, false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$amountBadge_u24lambda_u2415 = $this$constrain$iv2.getConstraints();
        $this$amountBadge_u24lambda_u2415.setX(new CenterConstraint());
        $this$amountBadge_u24lambda_u2415.setY(new CenterConstraint());
        $this$amountBadge_u24lambda_u2415.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$amountBadge_u24lambda_u2415.setTextScale(UtilitiesKt.getDp((Number) 18));
        ComponentsKt.childOf($this$constrain$iv2, amountBadge$lambda$14(plate$delegate));
    }

    private static final UIRoundedRectangle amountBadge$lambda$14(ReadWriteProperty<Object, UIRoundedRectangle> readWriteProperty) {
        return (UIRoundedRectangle) readWriteProperty.getValue((Object) null, $$delegatedProperties[8]);
    }

    private final void description(ItemData item, UIComponent attachTo) {
        if (item.getDescription().length() == 0) {
            return;
        }
        UIComponent $this$constrain$iv = new LabelComponent("&lОписание:", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$description_u24lambda_u2416 = $this$constrain$iv.getConstraints();
        $this$description_u24lambda_u2416.setX(UtilitiesKt.getDp((Number) 42));
        $this$description_u24lambda_u2416.setY(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 20, true, true), attachTo));
        $this$description_u24lambda_u2416.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$description_u24lambda_u2416.setTextScale(UtilitiesKt.getDp((Number) 18));
        ComponentsKt.childOf($this$constrain$iv, getContent());
        UIComponent $this$constrain$iv2 = new ContentView();
        UIConstraints $this$description_u24lambda_u2417 = $this$constrain$iv2.getConstraints();
        $this$description_u24lambda_u2417.setX(UtilitiesKt.getDp((Number) 42));
        $this$description_u24lambda_u2417.setY(new SiblingConstraint(12.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$description_u24lambda_u2417.setWidth(UtilitiesKt.getDp((Number) 440));
        $this$description_u24lambda_u2417.setHeight(UtilitiesKt.getDp((Number) 130));
        ReadWriteProperty descriptionView$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, getContent()), (Object) null, $$delegatedProperties[9]);
        UIComponent $this$constrain$iv3 = new WrappedText(item.getDescription(), false, (Color) null, false, false, 0.0f, (String) null, 126, (DefaultConstructorMarker) null);
        UIConstraints $this$description_u24lambda_u2419 = $this$constrain$iv3.getConstraints();
        $this$description_u24lambda_u2419.setWidth(new FillConstraint(false));
        $this$description_u24lambda_u2419.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$description_u24lambda_u2419.setTextScale(UtilitiesKt.getDp((Number) 18));
        ComponentsKt.childOf($this$constrain$iv3, description$lambda$18(descriptionView$delegate).getScrollView());
    }

    private static final ContentView description$lambda$18(ReadWriteProperty<Object, ContentView> readWriteProperty) {
        return (ContentView) readWriteProperty.getValue((Object) null, $$delegatedProperties[9]);
    }
}
