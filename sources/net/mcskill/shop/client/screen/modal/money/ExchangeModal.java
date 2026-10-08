package net.mcskill.shop.client.screen.modal.money;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.components.image.ImageComponent;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.state.MappedState;
import gg.essential.elementa.state.State;
import gg.essential.elementa.state.StateKt;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.component.Slider;
import net.mcskill.shop.client.screen.component.input.TextField;
import net.mcskill.shop.client.screen.modal.Modal;
import net.mcskill.shop.client.screen.modal.cases.component.DustInfoBlock;
import net.mcskill.shop.common.network.ChannelHandler;
import net.mcskill.shop.common.network.packet.buy.RequestExchangePacket;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ExchangeModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/money/ExchangeModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0014H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0015\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140\u0017\u0012\u0004\u0012\u00020\u00060\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140\u0017\u0012\u0004\u0012\u00020\u00060\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001e\u001a\u0004\b%\u0010\"R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001e\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001e\u001a\u0004\b-\u0010\"R\u001b\u0010/\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u001e\u001a\u0004\b0\u0010\"R\u001b\u00102\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u001e\u001a\u0004\b3\u0010*R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u001e\u001a\u0004\b7\u00108R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u001e\u001a\u0004\b<\u0010=R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u001e\u001a\u0004\bA\u0010B¨\u0006G"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/money/ExchangeModal;", "Lnet/mcskill/shop/client/screen/modal/Modal;", "Lnet/mcskill/shop/client/screen/modal/money/BalanceModal;", "type", "", "title", "", "leftImage", "Lnet/minecraft/resources/ResourceLocation;", "rightImage", "siteAmount", "Lgg/essential/elementa/state/State;", "gameAmount", "course", "<init>", "(ILjava/lang/String;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lgg/essential/elementa/state/State;Lgg/essential/elementa/state/State;I)V", "getType", "()I", "_sliderState", "Lgg/essential/elementa/state/BasicState;", "", "_siteAmountState", "Lgg/essential/elementa/state/MappedState;", "Lkotlin/Pair;", "_gameAmountState", "_divider", "Lgg/essential/elementa/components/UIRoundedRectangle;", "get_divider", "()Lgg/essential/elementa/components/UIRoundedRectangle;", "_divider$delegate", "Lkotlin/properties/ReadWriteProperty;", "_siteLabel", "Lgg/essential/elementa/components/LabelComponent;", "get_siteLabel", "()Lgg/essential/elementa/components/LabelComponent;", "_siteLabel$delegate", "_siteCurrencyAmount", "get_siteCurrencyAmount", "_siteCurrencyAmount$delegate", "_siteCurrencyLogo", "Lgg/essential/elementa/components/image/ImageComponent;", "get_siteCurrencyLogo", "()Lgg/essential/elementa/components/image/ImageComponent;", "_siteCurrencyLogo$delegate", "_gameLabel", "get_gameLabel", "_gameLabel$delegate", "_gameCurrencyAmount", "get_gameCurrencyAmount", "_gameCurrencyAmount$delegate", "_gameCurrencyLogo", "get_gameCurrencyLogo", "_gameCurrencyLogo$delegate", "_amountInput", "Lnet/mcskill/shop/client/screen/component/input/TextField;", "get_amountInput", "()Lnet/mcskill/shop/client/screen/component/input/TextField;", "_amountInput$delegate", "_sliderComponent", "Lnet/mcskill/shop/client/screen/component/Slider;", "get_sliderComponent", "()Lnet/mcskill/shop/client/screen/component/Slider;", "_sliderComponent$delegate", "_exchangeButton", "Lgg/essential/elementa/UIComponent;", "get_exchangeButton", "()Lgg/essential/elementa/UIComponent;", "_exchangeButton$delegate", "updateComponents", "", "percent", "MSShop"})
@SourceDebugExtension({"SMAP\nExchangeModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExchangeModal.kt\nnet/mcskill/shop/client/screen/modal/money/ExchangeModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,149:1\n10#2,3:150\n10#2,3:153\n10#2,3:156\n10#2,3:159\n10#2,3:162\n10#2,3:165\n10#2,3:168\n10#2,3:171\n10#2,3:174\n10#2,3:177\n*S KotlinDebug\n*F\n+ 1 ExchangeModal.kt\nnet/mcskill/shop/client/screen/modal/money/ExchangeModal\n*L\n45#1:150,3\n53#1:153,3\n60#1:156,3\n67#1:159,3\n74#1:162,3\n81#1:165,3\n88#1:168,3\n95#1:171,3\n102#1:174,3\n109#1:177,3\n*E\n"})
public final class ExchangeModal extends Modal implements BalanceModal {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ExchangeModal.class, "_divider", "get_divider()Lgg/essential/elementa/components/UIRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(ExchangeModal.class, "_siteLabel", "get_siteLabel()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(ExchangeModal.class, "_siteCurrencyAmount", "get_siteCurrencyAmount()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(ExchangeModal.class, "_siteCurrencyLogo", "get_siteCurrencyLogo()Lgg/essential/elementa/components/image/ImageComponent;", 0)), Reflection.property1(new PropertyReference1Impl(ExchangeModal.class, "_gameLabel", "get_gameLabel()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(ExchangeModal.class, "_gameCurrencyAmount", "get_gameCurrencyAmount()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(ExchangeModal.class, "_gameCurrencyLogo", "get_gameCurrencyLogo()Lgg/essential/elementa/components/image/ImageComponent;", 0)), Reflection.property1(new PropertyReference1Impl(ExchangeModal.class, "_amountInput", "get_amountInput()Lnet/mcskill/shop/client/screen/component/input/TextField;", 0)), Reflection.property1(new PropertyReference1Impl(ExchangeModal.class, "_sliderComponent", "get_sliderComponent()Lnet/mcskill/shop/client/screen/component/Slider;", 0)), Reflection.property1(new PropertyReference1Impl(ExchangeModal.class, "_exchangeButton", "get_exchangeButton()Lgg/essential/elementa/UIComponent;", 0))};
    private final int type;

    @NotNull
    private final BasicState<Float> _sliderState;

    @NotNull
    private final MappedState<Pair<Integer, Float>, String> _siteAmountState;

    @NotNull
    private final MappedState<Pair<Integer, Float>, String> _gameAmountState;

    /* JADX INFO: renamed from: _divider$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _divider;

    /* JADX INFO: renamed from: _siteLabel$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _siteLabel;

    /* JADX INFO: renamed from: _siteCurrencyAmount$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _siteCurrencyAmount;

    /* JADX INFO: renamed from: _siteCurrencyLogo$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _siteCurrencyLogo;

    /* JADX INFO: renamed from: _gameLabel$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _gameLabel;

    /* JADX INFO: renamed from: _gameCurrencyAmount$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _gameCurrencyAmount;

    /* JADX INFO: renamed from: _gameCurrencyLogo$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _gameCurrencyLogo;

    /* JADX INFO: renamed from: _amountInput$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _amountInput;

    /* JADX INFO: renamed from: _sliderComponent$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _sliderComponent;

    /* JADX INFO: renamed from: _exchangeButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _exchangeButton;

    public /* synthetic */ ExchangeModal(int i, String str, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, State state, State state2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, resourceLocation, resourceLocation2, (i3 & 16) != 0 ? (State) StateKt.state(0) : state, (i3 & 32) != 0 ? (State) StateKt.state(0) : state2, (i3 & 64) != 0 ? 1 : i2);
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExchangeModal(int type, @NotNull String title, @NotNull ResourceLocation leftImage, @NotNull ResourceLocation rightImage, @NotNull State<Integer> state, @NotNull State<Integer> state2, int course) {
        super(title, 500.0f, 367.0f);
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(leftImage, "leftImage");
        Intrinsics.checkNotNullParameter(rightImage, "rightImage");
        Intrinsics.checkNotNullParameter(state, "siteAmount");
        Intrinsics.checkNotNullParameter(state2, "gameAmount");
        this.type = type;
        this._sliderState = StateKt.state(Float.valueOf(0.0f));
        this._siteAmountState = state.zip(this._sliderState).map(ExchangeModal::_siteAmountState$lambda$0);
        this._gameAmountState = state2.zip(this._sliderState).map((v2) -> {
            return _gameAmountState$lambda$1(r2, r3, v2);
        });
        UIComponent $this$constrain$iv = new UIRoundedRectangle(4.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$_divider_delegate_u24lambda_u242 = $this$constrain$iv.getConstraints();
        $this$_divider_delegate_u24lambda_u242.setX(new CenterConstraint());
        $this$_divider_delegate_u24lambda_u242.setY(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp((Number) 45)));
        $this$_divider_delegate_u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 4));
        $this$_divider_delegate_u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 110));
        $this$_divider_delegate_u24lambda_u242.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA1()));
        this._divider = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, getContent()), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new LabelComponent("&lНа сайте", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_siteLabel_delegate_u24lambda_u243 = $this$constrain$iv2.getConstraints();
        $this$_siteLabel_delegate_u24lambda_u243.setX(UtilitiesKt.getDp((Number) 93));
        $this$_siteLabel_delegate_u24lambda_u243.setY(UtilitiesKt.getDp((Number) 85));
        $this$_siteLabel_delegate_u24lambda_u243.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_siteLabel_delegate_u24lambda_u243.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._siteLabel = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, getContent()), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = new LabelComponent(this._siteAmountState, (State) null, (State) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_siteCurrencyAmount_delegate_u24lambda_u244 = $this$constrain$iv3.getConstraints();
        $this$_siteCurrencyAmount_delegate_u24lambda_u244.setX(ConstraintsKt.boundTo(new CenterConstraint(), get_siteLabel()));
        $this$_siteCurrencyAmount_delegate_u24lambda_u244.setY(ConstraintsKt.plus(new CenterConstraint(), UtilitiesKt.getDp((Number) 5)));
        $this$_siteCurrencyAmount_delegate_u24lambda_u244.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_siteCurrencyAmount_delegate_u24lambda_u244.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._siteCurrencyAmount = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, getContent()), this, $$delegatedProperties[2]);
        UIComponent $this$constrain$iv4 = new ImageComponent(leftImage, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_siteCurrencyLogo_delegate_u24lambda_u245 = $this$constrain$iv4.getConstraints();
        $this$_siteCurrencyLogo_delegate_u24lambda_u245.setX(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp(Integer.valueOf(DustInfoBlock.DELIMITER))));
        $this$_siteCurrencyLogo_delegate_u24lambda_u245.setY(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp((Number) 40)));
        $this$_siteCurrencyLogo_delegate_u24lambda_u245.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$_siteCurrencyLogo_delegate_u24lambda_u245.setHeight(UtilitiesKt.getDp((Number) 54));
        this._siteCurrencyLogo = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, getContent()), this, $$delegatedProperties[3]);
        UIComponent $this$constrain$iv5 = new LabelComponent("&lНа сервере", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_gameLabel_delegate_u24lambda_u246 = $this$constrain$iv5.getConstraints();
        $this$_gameLabel_delegate_u24lambda_u246.setX(UtilitiesKt.dp$default((Number) 80, true, false, 2, (Object) null));
        $this$_gameLabel_delegate_u24lambda_u246.setY(UtilitiesKt.getDp((Number) 85));
        $this$_gameLabel_delegate_u24lambda_u246.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_gameLabel_delegate_u24lambda_u246.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._gameLabel = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv5, getContent()), this, $$delegatedProperties[4]);
        UIComponent $this$constrain$iv6 = new LabelComponent(this._gameAmountState, (State) null, (State) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_gameCurrencyAmount_delegate_u24lambda_u247 = $this$constrain$iv6.getConstraints();
        $this$_gameCurrencyAmount_delegate_u24lambda_u247.setX(ConstraintsKt.boundTo(new CenterConstraint(), get_gameLabel()));
        $this$_gameCurrencyAmount_delegate_u24lambda_u247.setY(ConstraintsKt.plus(new CenterConstraint(), UtilitiesKt.getDp((Number) 5)));
        $this$_gameCurrencyAmount_delegate_u24lambda_u247.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_gameCurrencyAmount_delegate_u24lambda_u247.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._gameCurrencyAmount = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv6, getContent()), this, $$delegatedProperties[5]);
        UIComponent $this$constrain$iv7 = new ImageComponent(rightImage, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_gameCurrencyLogo_delegate_u24lambda_u248 = $this$constrain$iv7.getConstraints();
        $this$_gameCurrencyLogo_delegate_u24lambda_u248.setX(ConstraintsKt.plus(new CenterConstraint(), UtilitiesKt.getDp(Integer.valueOf(DustInfoBlock.DELIMITER))));
        $this$_gameCurrencyLogo_delegate_u24lambda_u248.setY(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp((Number) 40)));
        $this$_gameCurrencyLogo_delegate_u24lambda_u248.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$_gameCurrencyLogo_delegate_u24lambda_u248.setHeight(UtilitiesKt.getDp((Number) 10));
        this._gameCurrencyLogo = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv7, getContent()), this, $$delegatedProperties[6]);
        UIComponent $this$constrain$iv8 = new TextField("Введите кол-во", (Number) 18);
        UIConstraints $this$_amountInput_delegate_u24lambda_u249 = $this$constrain$iv8.getConstraints();
        $this$_amountInput_delegate_u24lambda_u249.setX(new CenterConstraint());
        $this$_amountInput_delegate_u24lambda_u249.setY(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 16, true, true), get_divider()));
        $this$_amountInput_delegate_u24lambda_u249.setWidth(UtilitiesKt.getDp((Number) 208));
        $this$_amountInput_delegate_u24lambda_u249.setHeight(UtilitiesKt.getDp((Number) 31));
        this._amountInput = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv8, getContent()), this, $$delegatedProperties[7]);
        UIComponent $this$constrain$iv9 = new Slider(0.0f);
        UIConstraints $this$_sliderComponent_delegate_u24lambda_u2410 = $this$constrain$iv9.getConstraints();
        $this$_sliderComponent_delegate_u24lambda_u2410.setX(new CenterConstraint());
        $this$_sliderComponent_delegate_u24lambda_u2410.setY(new SiblingConstraint(20.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_sliderComponent_delegate_u24lambda_u2410.setWidth(UtilitiesKt.getDp((Number) 434));
        $this$_sliderComponent_delegate_u24lambda_u2410.setHeight(UtilitiesKt.getDp((Number) 16));
        this._sliderComponent = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv9, getContent()), this, $$delegatedProperties[8]);
        LabelButton labelButton = (UIComponent) new LabelButton("&lОбменять", 20, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$_exchangeButton_delegate_u24lambda_u2411 = labelButton.getConstraints();
        $this$_exchangeButton_delegate_u24lambda_u2411.setX(new CenterConstraint());
        $this$_exchangeButton_delegate_u24lambda_u2411.setY(new SiblingConstraint(20.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_exchangeButton_delegate_u24lambda_u2411.setWidth(UtilitiesKt.getDp((Number) 208));
        $this$_exchangeButton_delegate_u24lambda_u2411.setHeight(UtilitiesKt.getDp((Number) 43));
        $this$_exchangeButton_delegate_u24lambda_u2411.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this._exchangeButton = ComponentsKt.provideDelegate(ComponentsKt.childOf(labelButton.onMouseClick((v1, v2) -> {
            return _exchangeButton_delegate$lambda$12(r2, v1, v2);
        }), getContent()), this, $$delegatedProperties[9]);
        get_amountInput().getInput().setValidator("^\\d*");
        get_sliderComponent().onValueChange((v3) -> {
            return _init_$lambda$13(r1, r2, r3, v3);
        });
        get_amountInput().onUpdateTextInput((v3) -> {
            return _init_$lambda$14(r1, r2, r3, v3);
        });
    }

    private static final String _siteAmountState$lambda$0(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        int amount = ((Number) pair.component1()).intValue();
        float percent = ((Number) pair.component2()).floatValue();
        return "&l" + ((int) Math.floor(amount - (amount * percent)));
    }

    private static final String _gameAmountState$lambda$1(State $siteAmount, int $course, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        int amount = ((Number) pair.component1()).intValue();
        float percent = ((Number) pair.component2()).floatValue();
        return "&l" + ((int) Math.ceil(amount + (((Number) $siteAmount.get()).intValue() * $course * percent)));
    }

    private final UIRoundedRectangle get_divider() {
        return (UIRoundedRectangle) this._divider.getValue(this, $$delegatedProperties[0]);
    }

    private final LabelComponent get_siteLabel() {
        return (LabelComponent) this._siteLabel.getValue(this, $$delegatedProperties[1]);
    }

    private final LabelComponent get_siteCurrencyAmount() {
        return (LabelComponent) this._siteCurrencyAmount.getValue(this, $$delegatedProperties[2]);
    }

    private final ImageComponent get_siteCurrencyLogo() {
        return (ImageComponent) this._siteCurrencyLogo.getValue(this, $$delegatedProperties[3]);
    }

    private final LabelComponent get_gameLabel() {
        return (LabelComponent) this._gameLabel.getValue(this, $$delegatedProperties[4]);
    }

    private final LabelComponent get_gameCurrencyAmount() {
        return (LabelComponent) this._gameCurrencyAmount.getValue(this, $$delegatedProperties[5]);
    }

    private final ImageComponent get_gameCurrencyLogo() {
        return (ImageComponent) this._gameCurrencyLogo.getValue(this, $$delegatedProperties[6]);
    }

    private final TextField get_amountInput() {
        return (TextField) this._amountInput.getValue(this, $$delegatedProperties[7]);
    }

    private final Slider get_sliderComponent() {
        return (Slider) this._sliderComponent.getValue(this, $$delegatedProperties[8]);
    }

    private final UIComponent get_exchangeButton() {
        return (UIComponent) this._exchangeButton.getValue(this, $$delegatedProperties[9]);
    }

    private static final Unit _exchangeButton_delegate$lambda$12(ExchangeModal this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        Integer intOrNull = StringsKt.toIntOrNull(this$0.get_amountInput().getInput().getText());
        int amount = intOrNull != null ? intOrNull.intValue() : 0;
        this$0.close();
        ChannelHandler.INSTANCE.sendToServer(new RequestExchangePacket(this$0.type, amount));
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$13(ExchangeModal this$0, State $siteAmount, int $course, float percent) {
        this$0.updateComponents(percent);
        this$0.get_amountInput().getInput().setText(percent <= 0.0f ? "" : String.valueOf((int) Math.ceil(((Number) $siteAmount.get()).intValue() * $course * percent)));
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$14(State $siteAmount, int $course, ExchangeModal this$0, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Float floatOrNull = StringsKt.toFloatOrNull(text);
        float amount = floatOrNull != null ? floatOrNull.floatValue() : 0.0f;
        int site = ((Number) $siteAmount.get()).intValue() * $course;
        if (this$0.get_amountInput().getInput().hasFocus() && ((int) amount) != site) {
            if (amount > site) {
                this$0.get_amountInput().getInput().setText(String.valueOf(site));
            }
            float percent = site > 0 ? Math.min(amount, site) / site : 0.0f;
            this$0.get_sliderComponent().setCurrentPercentage(percent, false);
            this$0.updateComponents(percent);
        }
        return Unit.INSTANCE;
    }

    private final void updateComponents(float percent) {
        this._sliderState.set(Float.valueOf(percent));
        get_siteCurrencyLogo().setHeight(UtilitiesKt.getDp(Float.valueOf(56.0f - (46.0f * percent))));
        get_gameCurrencyLogo().setHeight(ConstraintsKt.plus(UtilitiesKt.getDp((Number) 10), UtilitiesKt.getDp(Float.valueOf(46.0f * percent))));
    }
}
