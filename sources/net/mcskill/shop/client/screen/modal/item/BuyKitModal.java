package net.mcskill.shop.client.screen.modal.item;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.ItemStackComponent;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.components.WrappedText;
import gg.essential.elementa.components.image.ImageView;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedMaxSizeConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.CramSiblingConstraint;
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
import net.mcskill.core.client.screen.component.MSRoundedRectangle;
import net.mcskill.shop.client.screen.component.ContentView;
import net.mcskill.shop.client.screen.component.EntryComponent;
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

/* JADX INFO: compiled from: BuyKitModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/item/BuyKitModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001:\u0001%B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010 \u001a\u00020!*\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u001c\u0010\"\u001a\u00020!*\u00020\u00032\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\rH\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001e¨\u0006&²\u0006\n\u0010'\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020\u0017X\u008a\u0084\u0002²\u0006\n\u0010(\u001a\u00020\u0017X\u008a\u0084\u0002²\u0006\n\u0010)\u001a\u00020\u0017X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020\u0017X\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010,\u001a\u00020\u0017X\u008a\u0084\u0002²\u0006\n\u0010-\u001a\u00020.X\u008a\u0084\u0002"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/item/BuyKitModal;", "Lnet/mcskill/shop/client/screen/modal/Modal;", "kit", "Lnet/mcskill/shop/common/response/shop/ItemData;", "price", "Lgg/essential/elementa/state/State;", "", "currency", "Lnet/mcskill/shop/common/CurrencyType;", "<init>", "(Lnet/mcskill/shop/common/response/shop/ItemData;Lgg/essential/elementa/state/State;Lgg/essential/elementa/state/State;)V", "totalAmount", "Lgg/essential/elementa/state/BasicState;", "", "priceState", "", "_divider", "Lgg/essential/elementa/components/UIRoundedRectangle;", "get_divider", "()Lgg/essential/elementa/components/UIRoundedRectangle;", "_divider$delegate", "Lkotlin/properties/ReadWriteProperty;", "_listItems", "Lgg/essential/elementa/components/LabelComponent;", "get_listItems", "()Lgg/essential/elementa/components/LabelComponent;", "_listItems$delegate", "_kitContent", "Lnet/mcskill/shop/client/screen/component/ContentView;", "get_kitContent", "()Lnet/mcskill/shop/client/screen/component/ContentView;", "_kitContent$delegate", "description", "", "calculatePrice", "discountLabel", "count", "KitItem", "MSShop", "plate", "totalCountLabel", "totalCount", "totalPriceLabel", "background", "label", "text", "Lgg/essential/elementa/components/WrappedText;"})
@SourceDebugExtension({"SMAP\nBuyKitModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuyKitModal.kt\nnet/mcskill/shop/client/screen/modal/item/BuyKitModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,262:1\n10#2,3:263\n10#2,3:266\n10#2,3:269\n10#2,3:272\n10#2,3:275\n10#2,3:278\n10#2,3:281\n10#2,3:284\n10#2,3:287\n10#2,3:290\n10#2,3:293\n10#2,3:296\n10#2,3:299\n10#2,3:302\n10#2,3:305\n10#2,3:308\n10#2,3:311\n10#2,3:314\n10#2,3:317\n*S KotlinDebug\n*F\n+ 1 BuyKitModal.kt\nnet/mcskill/shop/client/screen/modal/item/BuyKitModal\n*L\n30#1:263,3\n38#1:266,3\n45#1:269,3\n58#1:272,3\n66#1:275,3\n74#1:278,3\n82#1:281,3\n90#1:284,3\n97#1:287,3\n104#1:290,3\n116#1:293,3\n122#1:296,3\n131#1:299,3\n138#1:302,3\n147#1:305,3\n151#1:308,3\n170#1:311,3\n176#1:314,3\n183#1:317,3\n*E\n"})
public final class BuyKitModal extends Modal {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(BuyKitModal.class, "_divider", "get_divider()Lgg/essential/elementa/components/UIRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(BuyKitModal.class, "_listItems", "get_listItems()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(BuyKitModal.class, "_kitContent", "get_kitContent()Lnet/mcskill/shop/client/screen/component/ContentView;", 0)), Reflection.property0(new PropertyReference0Impl(BuyKitModal.class, "plate", "<v#0>", 0)), Reflection.property0(new PropertyReference0Impl(BuyKitModal.class, "discountLabel", "<v#1>", 0)), Reflection.property0(new PropertyReference0Impl(BuyKitModal.class, "totalCountLabel", "<v#2>", 0)), Reflection.property0(new PropertyReference0Impl(BuyKitModal.class, "totalCount", "<v#3>", 0)), Reflection.property0(new PropertyReference0Impl(BuyKitModal.class, "totalPriceLabel", "<v#4>", 0)), Reflection.property0(new PropertyReference0Impl(BuyKitModal.class, "background", "<v#5>", 0)), Reflection.property0(new PropertyReference0Impl(BuyKitModal.class, "label", "<v#6>", 0)), Reflection.property0(new PropertyReference0Impl(BuyKitModal.class, "text", "<v#7>", 0))};

    @NotNull
    private final BasicState<Integer> totalAmount;

    @NotNull
    private final BasicState<String> priceState;

    /* JADX INFO: renamed from: _divider$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _divider;

    /* JADX INFO: renamed from: _listItems$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _listItems;

    /* JADX INFO: renamed from: _kitContent$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _kitContent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuyKitModal(@NotNull ItemData kit, @NotNull State<Number> state, @NotNull State<CurrencyType> state2) {
        UIComponent imageView;
        super("Покупка набора", 883.0f, 558.0f);
        Intrinsics.checkNotNullParameter(kit, "kit");
        Intrinsics.checkNotNullParameter(state, "price");
        Intrinsics.checkNotNullParameter(state2, "currency");
        this.totalAmount = new BasicState<>(Integer.valueOf(kit.getAmount()));
        this.priceState = new BasicState<>(String.valueOf((int) kit.getPriceRub()));
        UIComponent $this$constrain$iv = new UIRoundedRectangle(5.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$_divider_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_divider_delegate_u24lambda_u240.setX(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp((Number) 103)));
        $this$_divider_delegate_u24lambda_u240.setY(ConstraintsKt.plus(new CenterConstraint(), UtilitiesKt.getDp(Double.valueOf(31.5d))));
        $this$_divider_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp((Number) 4));
        $this$_divider_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 431));
        $this$_divider_delegate_u24lambda_u240.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA1()));
        this._divider = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, getContent()), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new LabelComponent("§lСписок предметов", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_listItems_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_listItems_delegate_u24lambda_u241.setX(ConstraintsKt.plus(new CenterConstraint(), UtilitiesKt.getDp(Double.valueOf(170.5d))));
        $this$_listItems_delegate_u24lambda_u241.setY(UtilitiesKt.getDp((Number) 95));
        $this$_listItems_delegate_u24lambda_u241.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_listItems_delegate_u24lambda_u241.setTextScale(UtilitiesKt.getDp((Number) 24));
        this._listItems = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, getContent()), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = new ContentView();
        UIConstraints $this$_kitContent_delegate_u24lambda_u242 = $this$constrain$iv3.getConstraints();
        $this$_kitContent_delegate_u24lambda_u242.setX(ConstraintsKt.boundTo(new SiblingConstraint(20.0f, false, false, 6, (DefaultConstructorMarker) null), get_divider()));
        $this$_kitContent_delegate_u24lambda_u242.setY(UtilitiesKt.getDp((Number) 144));
        $this$_kitContent_delegate_u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 508));
        $this$_kitContent_delegate_u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 382));
        this._kitContent = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, getContent()), this, $$delegatedProperties[2]);
        UIComponent uIComponentOf$default = ItemStackComponent.Companion.of$default(ItemStackComponent.Companion, kit.getItemName(), 0, 0, (String) null, 14, (Object) null);
        if (Intrinsics.areEqual(kit.getType(), "kit") || uIComponentOf$default.getStack().isEmpty()) {
            imageView = new ImageView(kit.getImg(), 1.0f, 1.0f, UIImage.TextureScalingMode.NEAREST, UIImage.TextureScalingMode.NEAREST, (WidthConstraint) null, (HeightConstraint) null, 96, (DefaultConstructorMarker) null);
        } else {
            imageView = uIComponentOf$default;
        }
        UIComponent $this$constrain$iv4 = imageView;
        UIConstraints $this$_init__u24lambda_u243 = $this$constrain$iv4.getConstraints();
        $this$_init__u24lambda_u243.setX(UtilitiesKt.getDp((Number) 106));
        $this$_init__u24lambda_u243.setY(UtilitiesKt.getDp((Number) 132));
        $this$_init__u24lambda_u243.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 128));
        UIComponent logo = ComponentsKt.childOf($this$constrain$iv4, getContent());
        if (kit.getAmount() > 1) {
            UIComponent $this$constrain$iv5 = new UIRoundedRectangle(12.0f, false, 2, (DefaultConstructorMarker) null);
            UIConstraints $this$_init__u24lambda_u244 = $this$constrain$iv5.getConstraints();
            $this$_init__u24lambda_u244.setX(UtilitiesKt.dp$default((Number) 0, true, false, 2, (Object) null));
            $this$_init__u24lambda_u244.setY(UtilitiesKt.dp$default((Number) 0, true, false, 2, (Object) null));
            $this$_init__u24lambda_u244.setWidth(ConstraintsKt.plus(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null), UtilitiesKt.getDp((Number) 10)));
            $this$_init__u24lambda_u244.setHeight(ConstraintsKt.plus(new ChildBasedMaxSizeConstraint(), UtilitiesKt.getDp((Number) 6)));
            $this$_init__u24lambda_u244.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getBlue()));
            ReadWriteProperty plate$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv5, logo), (Object) null, $$delegatedProperties[3]);
            UIComponent $this$constrain$iv6 = new LabelComponent("§lx" + kit.getAmount(), false, (Color) null, 6, (DefaultConstructorMarker) null);
            UIConstraints $this$_init__u24lambda_u246 = $this$constrain$iv6.getConstraints();
            $this$_init__u24lambda_u246.setX(new CenterConstraint());
            $this$_init__u24lambda_u246.setY(new CenterConstraint());
            $this$_init__u24lambda_u246.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
            $this$_init__u24lambda_u246.setTextScale(UtilitiesKt.getDp((Number) 18));
            ComponentsKt.childOf($this$constrain$iv6, _init_$lambda$5(plate$delegate));
        }
        UIComponent $this$constrain$iv7 = new WrappedText("§l" + kit.getName(), false, (Color) null, true, false, 0.0f, (String) null, 118, (DefaultConstructorMarker) null);
        UIConstraints $this$_init__u24lambda_u247 = $this$constrain$iv7.getConstraints();
        $this$_init__u24lambda_u247.setX(ConstraintsKt.boundTo(new CenterConstraint(), logo));
        $this$_init__u24lambda_u247.setY(new SiblingConstraint(21.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u247.setWidth(UtilitiesKt.getDp((Number) 250));
        $this$_init__u24lambda_u247.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_init__u24lambda_u247.setTextScale(UtilitiesKt.getDp((Number) 24));
        ComponentsKt.childOf($this$constrain$iv7, getContent());
        UIComponent $this$constrain$iv8 = new LabelComponent("§lКоличество:", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_init__u24lambda_u248 = $this$constrain$iv8.getConstraints();
        $this$_init__u24lambda_u248.setX(UtilitiesKt.getDp((Number) 70));
        $this$_init__u24lambda_u248.setY(new SiblingConstraint(24.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u248.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_init__u24lambda_u248.setTextScale(UtilitiesKt.getDp((Number) 18));
        ComponentsKt.childOf($this$constrain$iv8, getContent());
        UIComponent $this$constrain$iv9 = new NumberCounter(1, 0, 0, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_init__u24lambda_u249 = $this$constrain$iv9.getConstraints();
        $this$_init__u24lambda_u249.setX(UtilitiesKt.getDp((Number) 70));
        $this$_init__u24lambda_u249.setY(new SiblingConstraint(8.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u249.setWidth(UtilitiesKt.getDp((Number) 201));
        $this$_init__u24lambda_u249.setHeight(UtilitiesKt.getDp((Number) 32));
        NumberCounter counter = ComponentsKt.childOf($this$constrain$iv9, getContent());
        UIComponent $this$constrain$iv10 = new LabelComponent("§lСкидка:", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_init__u24lambda_u2410 = $this$constrain$iv10.getConstraints();
        $this$_init__u24lambda_u2410.setX(UtilitiesKt.getDp((Number) 70));
        $this$_init__u24lambda_u2410.setY(new SiblingConstraint(16.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u2410.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_init__u24lambda_u2410.setTextScale(UtilitiesKt.getDp((Number) 20));
        ReadWriteProperty discountLabel$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv10, getContent()), (Object) null, $$delegatedProperties[4]);
        _init_$lambda$11(discountLabel$delegate).hide(true);
        counter.onChange((v3, v4) -> {
            return _init_$lambda$12(r1, r2, r3, v3, v4);
        });
        UIComponent $this$constrain$iv11 = new LabelComponent((String) null, false, (Color) null, 7, (DefaultConstructorMarker) null);
        UIConstraints $this$_init__u24lambda_u2413 = $this$constrain$iv11.getConstraints();
        $this$_init__u24lambda_u2413.setX(UtilitiesKt.dp((Number) 6, true, true));
        $this$_init__u24lambda_u2413.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_init__u24lambda_u2413.setTextScale(UtilitiesKt.getDp((Number) 20));
        ComponentsKt.childOf($this$constrain$iv11, _init_$lambda$11(discountLabel$delegate));
        UIComponent $this$constrain$iv12 = new LabelComponent("§lНаборов:", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_init__u24lambda_u2414 = $this$constrain$iv12.getConstraints();
        $this$_init__u24lambda_u2414.setX(UtilitiesKt.getDp((Number) 70));
        $this$_init__u24lambda_u2414.setY(new SiblingConstraint(12.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u2414.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_init__u24lambda_u2414.setTextScale(UtilitiesKt.getDp((Number) 20));
        ReadWriteProperty totalCountLabel$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv12, getContent()), (Object) null, $$delegatedProperties[5]);
        UIComponent $this$constrain$iv13 = new LabelComponent(counter.getValueState().zip(this.totalAmount).map(BuyKitModal::_init_$lambda$16), (State) null, (State) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_init__u24lambda_u2417 = $this$constrain$iv13.getConstraints();
        $this$_init__u24lambda_u2417.setX(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 8, true, true), _init_$lambda$15(totalCountLabel$delegate)));
        $this$_init__u24lambda_u2417.setY(ConstraintsKt.boundTo(UtilitiesKt.dp$default((Number) 0, false, false, 3, (Object) null), _init_$lambda$15(totalCountLabel$delegate)));
        $this$_init__u24lambda_u2417.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_init__u24lambda_u2417.setTextScale(UtilitiesKt.getDp((Number) 20));
        ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv13, getContent()), (Object) null, $$delegatedProperties[6]);
        UIComponent $this$constrain$iv14 = new LabelComponent("§lИтого к оплате:", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_init__u24lambda_u2419 = $this$constrain$iv14.getConstraints();
        $this$_init__u24lambda_u2419.setX(UtilitiesKt.getDp((Number) 70));
        $this$_init__u24lambda_u2419.setY(ConstraintsKt.boundTo(new SiblingConstraint(16.0f, false, false, 6, (DefaultConstructorMarker) null), _init_$lambda$15(totalCountLabel$delegate)));
        $this$_init__u24lambda_u2419.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_init__u24lambda_u2419.setTextScale(UtilitiesKt.getDp((Number) 20));
        ReadWriteProperty totalPriceLabel$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv14, getContent()), (Object) null, $$delegatedProperties[7]);
        UIComponent $this$constrain$iv15 = new PriceGroup((State<Number>) counter.getValueState().zip(state).map(BuyKitModal::_init_$lambda$21), (State<String>) state2.map(BuyKitModal::_init_$lambda$22), (State<Number>) new BasicState(Integer.valueOf(kit.getDiscount())));
        UIConstraints $this$_init__u24lambda_u2423 = $this$constrain$iv15.getConstraints();
        $this$_init__u24lambda_u2423.setX(UtilitiesKt.dp((Number) 6, true, true));
        ComponentsKt.childOf($this$constrain$iv15, _init_$lambda$20(totalPriceLabel$delegate));
        LabelButton labelButton = (UIComponent) new LabelButton("Купить", 24, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$_init__u24lambda_u2424 = labelButton.getConstraints();
        $this$_init__u24lambda_u2424.setX(UtilitiesKt.getDp((Number) 70));
        $this$_init__u24lambda_u2424.setY(new SiblingConstraint(24.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u2424.setWidth(UtilitiesKt.getDp((Number) 201));
        $this$_init__u24lambda_u2424.setHeight(UtilitiesKt.getDp((Number) 48));
        $this$_init__u24lambda_u2424.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        ComponentsKt.childOf(labelButton.onMouseClick((v2, v3) -> {
            return _init_$lambda$25(r1, r2, v2, v3);
        }), getContent());
        if (kit.getDescription().length() > 0) {
            description(get_kitContent(), kit);
        }
        for (ItemData item : kit.getItems()) {
            get_kitContent().fillEntryView(new KitItem(item));
        }
    }

    private final UIRoundedRectangle get_divider() {
        return (UIRoundedRectangle) this._divider.getValue(this, $$delegatedProperties[0]);
    }

    private final LabelComponent get_listItems() {
        return (LabelComponent) this._listItems.getValue(this, $$delegatedProperties[1]);
    }

    private final ContentView get_kitContent() {
        return (ContentView) this._kitContent.getValue(this, $$delegatedProperties[2]);
    }

    private static final UIRoundedRectangle _init_$lambda$5(ReadWriteProperty<Object, UIRoundedRectangle> readWriteProperty) {
        return (UIRoundedRectangle) readWriteProperty.getValue((Object) null, $$delegatedProperties[3]);
    }

    private static final LabelComponent _init_$lambda$11(ReadWriteProperty<Object, LabelComponent> readWriteProperty) {
        return (LabelComponent) readWriteProperty.getValue((Object) null, $$delegatedProperties[4]);
    }

    private static final Unit _init_$lambda$12(BuyKitModal this$0, ItemData $kit, ReadWriteProperty $discountLabel$delegate, UIComponent $this$onChange, int value) {
        Intrinsics.checkNotNullParameter($this$onChange, "$this$onChange");
        this$0.calculatePrice($kit, _init_$lambda$11($discountLabel$delegate), value);
        return Unit.INSTANCE;
    }

    private static final LabelComponent _init_$lambda$15(ReadWriteProperty<Object, LabelComponent> readWriteProperty) {
        return (LabelComponent) readWriteProperty.getValue((Object) null, $$delegatedProperties[5]);
    }

    private static final LabelComponent _init_$lambda$18(ReadWriteProperty<Object, LabelComponent> readWriteProperty) {
        return (LabelComponent) readWriteProperty.getValue((Object) null, $$delegatedProperties[6]);
    }

    private static final String _init_$lambda$16(Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (((Number) it.getFirst()).intValue() * ((Number) it.getSecond()).intValue()) + " шт.";
    }

    private static final LabelComponent _init_$lambda$20(ReadWriteProperty<Object, LabelComponent> readWriteProperty) {
        return (LabelComponent) readWriteProperty.getValue((Object) null, $$delegatedProperties[7]);
    }

    private static final Number _init_$lambda$21(Pair value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return Integer.valueOf(((Number) value.getFirst()).intValue() * ((Number) value.getSecond()).intValue());
    }

    private static final String _init_$lambda$22(CurrencyType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String lowerCase = it.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private static final Unit _init_$lambda$25(ItemData $kit, NumberCounter $counter, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ChannelHandler.INSTANCE.sendToServer(new RequestBuyItemPacket($kit.getId(), $counter.getValue(), $kit.getCatId(), $kit.getType()));
        return Unit.INSTANCE;
    }

    private final void description(ContentView $this$description, ItemData kit) {
        UIComponent $this$constrain$iv = new UIRoundedRectangle(9.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$description_u24lambda_u2426 = $this$constrain$iv.getConstraints();
        $this$description_u24lambda_u2426.setWidth(ConstraintsKt.minus(new FillConstraint(false), UtilitiesKt.getDp((Number) 12)));
        $this$description_u24lambda_u2426.setHeight(ConstraintsKt.plus(new ChildBasedMaxSizeConstraint(), UtilitiesKt.getDp((Number) 56)));
        $this$description_u24lambda_u2426.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getContentEntry()));
        ReadWriteProperty background$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, $this$description.getScrollView()), (Object) null, $$delegatedProperties[8]);
        UIComponent $this$constrain$iv2 = new LabelComponent("&lОписание:", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$description_u24lambda_u2428 = $this$constrain$iv2.getConstraints();
        $this$description_u24lambda_u2428.setX(UtilitiesKt.getDp((Number) 16));
        $this$description_u24lambda_u2428.setY(UtilitiesKt.getDp((Number) 14));
        $this$description_u24lambda_u2428.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$description_u24lambda_u2428.setTextScale(UtilitiesKt.getDp((Number) 18));
        ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, description$lambda$27(background$delegate)), (Object) null, $$delegatedProperties[9]);
        UIComponent $this$constrain$iv3 = new WrappedText(kit.getDescription(), false, (Color) null, false, false, 0.0f, (String) null, 126, (DefaultConstructorMarker) null);
        UIConstraints $this$description_u24lambda_u2430 = $this$constrain$iv3.getConstraints();
        $this$description_u24lambda_u2430.setX(UtilitiesKt.getDp((Number) 16));
        $this$description_u24lambda_u2430.setY(new SiblingConstraint(12.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$description_u24lambda_u2430.setWidth(ConstraintsKt.minus(new FillConstraint(false), UtilitiesKt.getDp((Number) 16)));
        $this$description_u24lambda_u2430.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$description_u24lambda_u2430.setTextScale(UtilitiesKt.getDp((Number) 17));
        ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, description$lambda$27(background$delegate)), (Object) null, $$delegatedProperties[10]);
    }

    private static final UIRoundedRectangle description$lambda$27(ReadWriteProperty<Object, UIRoundedRectangle> readWriteProperty) {
        return (UIRoundedRectangle) readWriteProperty.getValue((Object) null, $$delegatedProperties[8]);
    }

    private static final LabelComponent description$lambda$29(ReadWriteProperty<Object, LabelComponent> readWriteProperty) {
        return (LabelComponent) readWriteProperty.getValue((Object) null, $$delegatedProperties[9]);
    }

    private static final WrappedText description$lambda$31(ReadWriteProperty<Object, WrappedText> readWriteProperty) {
        return (WrappedText) readWriteProperty.getValue((Object) null, $$delegatedProperties[10]);
    }

    private final void calculatePrice(ItemData $this$calculatePrice, LabelComponent discountLabel, int count) {
        int discountPercent = $this$calculatePrice.getDiscount();
        if ($this$calculatePrice.getDiscount() > 0.0d) {
            discountLabel.setText($this$calculatePrice.getDiscount() + "%");
            UIComponent.unhide$default((UIComponent) discountLabel, false, 1, (Object) null);
        } else {
            UIComponent.hide$default((UIComponent) discountLabel, false, 1, (Object) null);
        }
        double total = $this$calculatePrice.getPriceRub() * ((double) count);
        int discount = (int) Math.floor(total * ((double) discountPercent));
        this.priceState.set(String.valueOf((int) (total - ((double) discount))));
    }

    /* JADX INFO: compiled from: BuyKitModal.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/item/BuyKitModal$KitItem.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/item/BuyKitModal$KitItem;", "Lnet/mcskill/shop/client/screen/component/EntryComponent;", "itemData", "Lnet/mcskill/shop/common/response/shop/ItemData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/ItemData;)V", "viewItem", "Lnet/mcskill/core/client/screen/component/MSRoundedRectangle;", "getViewItem", "()Lnet/mcskill/core/client/screen/component/MSRoundedRectangle;", "viewItem$delegate", "Lkotlin/properties/ReadWriteProperty;", "textContainer", "Lgg/essential/elementa/components/UIContainer;", "getTextContainer", "()Lgg/essential/elementa/components/UIContainer;", "textContainer$delegate", "MSShop", "plate", "Lgg/essential/elementa/components/UIRoundedRectangle;"})
    @SourceDebugExtension({"SMAP\nBuyKitModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuyKitModal.kt\nnet/mcskill/shop/client/screen/modal/item/BuyKitModal$KitItem\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,262:1\n10#2,3:263\n10#2,3:266\n10#2,3:269\n10#2,3:272\n10#2,3:275\n10#2,3:278\n*S KotlinDebug\n*F\n+ 1 BuyKitModal.kt\nnet/mcskill/shop/client/screen/modal/item/BuyKitModal$KitItem\n*L\n206#1:263,3\n215#1:266,3\n223#1:269,3\n235#1:272,3\n243#1:275,3\n251#1:278,3\n*E\n"})
    public static final class KitItem extends EntryComponent {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(KitItem.class, "viewItem", "getViewItem()Lnet/mcskill/core/client/screen/component/MSRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(KitItem.class, "textContainer", "getTextContainer()Lgg/essential/elementa/components/UIContainer;", 0)), Reflection.property0(new PropertyReference0Impl(KitItem.class, "plate", "<v#0>", 0))};

        /* JADX INFO: renamed from: viewItem$delegate, reason: from kotlin metadata */
        @NotNull
        private final ReadWriteProperty viewItem;

        /* JADX INFO: renamed from: textContainer$delegate, reason: from kotlin metadata */
        @NotNull
        private final ReadWriteProperty textContainer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KitItem(@NotNull ItemData itemData) {
            UIComponent uIComponent;
            super("§l" + itemData.getName(), 116, 9.0f, 146, 14);
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            UIComponent $this$constrain$iv = new MSRoundedRectangle(false, false, 3, (DefaultConstructorMarker) null);
            UIConstraints $this$viewItem_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
            $this$viewItem_delegate_u24lambda_u240.setX(new CenterConstraint());
            $this$viewItem_delegate_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 3));
            $this$viewItem_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp((Number) 146));
            $this$viewItem_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 110));
            $this$viewItem_delegate_u24lambda_u240.setRadius(UtilitiesKt.getDp((Number) 9));
            $this$viewItem_delegate_u24lambda_u240.setColor(UtilitiesKt.toConstraint(new Color(17, 15, 18)));
            this.viewItem = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
            UIComponent $this$constrain$iv2 = new UIContainer();
            UIConstraints $this$textContainer_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
            $this$textContainer_delegate_u24lambda_u241.setX(new CenterConstraint());
            $this$textContainer_delegate_u24lambda_u241.setY(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 6, true, true), getViewItem()));
            $this$textContainer_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 146));
            $this$textContainer_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 40));
            this.textContainer = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
            UIConstraints $this$_init__u24lambda_u242 = ((UIComponent) this).getConstraints();
            $this$_init__u24lambda_u242.setX(new CramSiblingConstraint(12.0f));
            $this$_init__u24lambda_u242.setY(new CramSiblingConstraint(12.0f));
            $this$_init__u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 152));
            $this$_init__u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 164));
            $this$_init__u24lambda_u242.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getContentEntry()));
            UIComponent uIComponentOf$default = ItemStackComponent.Companion.of$default(ItemStackComponent.Companion, itemData.getItemName(), 0, 0, (String) null, 14, (Object) null);
            if (uIComponentOf$default.getStack().isEmpty()) {
                uIComponent = (UIComponent) new ImageView(itemData.getImg(), 1.0f, 1.0f, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, (WidthConstraint) null, (HeightConstraint) null, DustInfoBlock.DELIMITER, (DefaultConstructorMarker) null);
            } else {
                uIComponent = uIComponentOf$default;
            }
            UIComponent $this$constrain$iv3 = uIComponent;
            UIConstraints $this$_init__u24lambda_u243 = $this$constrain$iv3.getConstraints();
            $this$_init__u24lambda_u243.setX(new CenterConstraint());
            $this$_init__u24lambda_u243.setY(new CenterConstraint());
            $this$_init__u24lambda_u243.setWidth(UtilitiesKt.getDp((Number) 86));
            $this$_init__u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 86));
            UIComponent logo = ComponentsKt.childOf($this$constrain$iv3, getViewItem());
            if (itemData.getAmount() > 1) {
                UIComponent $this$constrain$iv4 = new UIRoundedRectangle(12.0f, false, 2, (DefaultConstructorMarker) null);
                UIConstraints $this$_init__u24lambda_u244 = $this$constrain$iv4.getConstraints();
                $this$_init__u24lambda_u244.setX(UtilitiesKt.dp$default((Number) 0, true, false, 2, (Object) null));
                $this$_init__u24lambda_u244.setY(UtilitiesKt.dp$default((Number) 0, true, false, 2, (Object) null));
                $this$_init__u24lambda_u244.setWidth(ConstraintsKt.plus(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null), UtilitiesKt.getDp((Number) 10)));
                $this$_init__u24lambda_u244.setHeight(ConstraintsKt.plus(new ChildBasedMaxSizeConstraint(), UtilitiesKt.getDp((Number) 6)));
                $this$_init__u24lambda_u244.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getBlue()));
                ReadWriteProperty plate$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, logo), (Object) null, $$delegatedProperties[2]);
                UIComponent $this$constrain$iv5 = new LabelComponent("§lx" + itemData.getAmount(), false, (Color) null, 6, (DefaultConstructorMarker) null);
                UIConstraints $this$_init__u24lambda_u246 = $this$constrain$iv5.getConstraints();
                $this$_init__u24lambda_u246.setX(new CenterConstraint());
                $this$_init__u24lambda_u246.setY(new CenterConstraint());
                $this$_init__u24lambda_u246.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
                $this$_init__u24lambda_u246.setTextScale(UtilitiesKt.getDp((Number) 18));
                ComponentsKt.childOf($this$constrain$iv5, _init_$lambda$5(plate$delegate));
            }
            getTitle().setY(ConstraintsKt.boundTo(new CenterConstraint(), getTextContainer()));
        }

        private final MSRoundedRectangle getViewItem() {
            return (MSRoundedRectangle) this.viewItem.getValue(this, $$delegatedProperties[0]);
        }

        private final UIContainer getTextContainer() {
            return (UIContainer) this.textContainer.getValue(this, $$delegatedProperties[1]);
        }

        private static final UIRoundedRectangle _init_$lambda$5(ReadWriteProperty<Object, UIRoundedRectangle> readWriteProperty) {
            return (UIRoundedRectangle) readWriteProperty.getValue((Object) null, $$delegatedProperties[2]);
        }
    }
}
