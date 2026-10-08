package net.mcskill.shop.client.screen.modal.cases.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIBlock;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.components.WrappedText;
import gg.essential.elementa.components.image.ImageComponent;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedMaxSizeConstraint;
import gg.essential.elementa.constraints.ColorConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.constraints.SuperConstraint;
import gg.essential.elementa.dsl.BasicConstraintsKt;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.RoundOutlineEffect;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.state.MappedState;
import gg.essential.elementa.state.State;
import gg.essential.elementa.state.StateKt;
import gg.essential.elementa.utils.ResourcesKt;
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
import net.mcskill.shop.client.MSShopClient;
import net.mcskill.shop.common.response.shop.CaseData;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GuarantInfoBlock.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/cases/component/GuarantInfoBlock.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010,\u001a\u00020-H\u0016J\u0016\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200J\u0016\u00102\u001a\u00020-2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0019\u0010\u000bR\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b!\u0010\u001eR\u001b\u0010#\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\r\u001a\u0004\b)\u0010*¨\u00064"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/cases/component/GuarantInfoBlock;", "Lgg/essential/elementa/components/UIRoundedRectangle;", "_case", "Lnet/mcskill/shop/common/response/shop/CaseData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/CaseData;)V", "get_case", "()Lnet/mcskill/shop/common/response/shop/CaseData;", "_item", "Lgg/essential/elementa/components/image/ImageComponent;", "get_item", "()Lgg/essential/elementa/components/image/ImageComponent;", "_item$delegate", "Lkotlin/properties/ReadWriteProperty;", "_divider", "Lgg/essential/elementa/components/UIBlock;", "get_divider", "()Lgg/essential/elementa/components/UIBlock;", "_divider$delegate", "_guarantLabel", "Lgg/essential/elementa/components/LabelComponent;", "get_guarantLabel", "()Lgg/essential/elementa/components/LabelComponent;", "_guarantLabel$delegate", "_guarantInfo", "get_guarantInfo", "_guarantInfo$delegate", "_guarantFirstProgress", "Lnet/mcskill/shop/client/screen/modal/cases/component/GuarantInfoBlock$GuarantProgressBar;", "get_guarantFirstProgress", "()Lnet/mcskill/shop/client/screen/modal/cases/component/GuarantInfoBlock$GuarantProgressBar;", "_guarantFirstProgress$delegate", "_guarantSecondProgress", "get_guarantSecondProgress", "_guarantSecondProgress$delegate", "_guarantTooltip", "get_guarantTooltip", "()Lgg/essential/elementa/components/UIRoundedRectangle;", "_guarantTooltip$delegate", "_guarantTextTooltip", "Lgg/essential/elementa/components/WrappedText;", "get_guarantTextTooltip", "()Lgg/essential/elementa/components/WrappedText;", "_guarantTextTooltip$delegate", "afterInitialization", "", "updateFirstGuarantProgress", "value", "", "max", "updateSecondGuarantProgress", "GuarantProgressBar", "MSShop"})
@SourceDebugExtension({"SMAP\nGuarantInfoBlock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GuarantInfoBlock.kt\nnet/mcskill/shop/client/screen/modal/cases/component/GuarantInfoBlock\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,196:1\n10#2,3:197\n10#2,3:200\n10#2,3:203\n10#2,3:206\n10#2,3:209\n10#2,3:212\n10#2,3:215\n10#2,3:218\n10#2,3:221\n10#2,3:224\n10#2,3:227\n*S KotlinDebug\n*F\n+ 1 GuarantInfoBlock.kt\nnet/mcskill/shop/client/screen/modal/cases/component/GuarantInfoBlock\n*L\n28#1:197,3\n35#1:200,3\n42#1:203,3\n48#1:206,3\n57#1:209,3\n66#1:212,3\n73#1:215,3\n84#1:218,3\n93#1:221,3\n115#1:224,3\n121#1:227,3\n*E\n"})
public final class GuarantInfoBlock extends UIRoundedRectangle {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(GuarantInfoBlock.class, "_item", "get_item()Lgg/essential/elementa/components/image/ImageComponent;", 0)), Reflection.property1(new PropertyReference1Impl(GuarantInfoBlock.class, "_divider", "get_divider()Lgg/essential/elementa/components/UIBlock;", 0)), Reflection.property1(new PropertyReference1Impl(GuarantInfoBlock.class, "_guarantLabel", "get_guarantLabel()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(GuarantInfoBlock.class, "_guarantInfo", "get_guarantInfo()Lgg/essential/elementa/components/image/ImageComponent;", 0)), Reflection.property1(new PropertyReference1Impl(GuarantInfoBlock.class, "_guarantFirstProgress", "get_guarantFirstProgress()Lnet/mcskill/shop/client/screen/modal/cases/component/GuarantInfoBlock$GuarantProgressBar;", 0)), Reflection.property1(new PropertyReference1Impl(GuarantInfoBlock.class, "_guarantSecondProgress", "get_guarantSecondProgress()Lnet/mcskill/shop/client/screen/modal/cases/component/GuarantInfoBlock$GuarantProgressBar;", 0)), Reflection.property1(new PropertyReference1Impl(GuarantInfoBlock.class, "_guarantTooltip", "get_guarantTooltip()Lgg/essential/elementa/components/UIRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(GuarantInfoBlock.class, "_guarantTextTooltip", "get_guarantTextTooltip()Lgg/essential/elementa/components/WrappedText;", 0))};

    @NotNull
    private final CaseData _case;

    /* JADX INFO: renamed from: _item$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _item;

    /* JADX INFO: renamed from: _divider$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _divider;

    /* JADX INFO: renamed from: _guarantLabel$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _guarantLabel;

    /* JADX INFO: renamed from: _guarantInfo$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _guarantInfo;

    /* JADX INFO: renamed from: _guarantFirstProgress$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _guarantFirstProgress;

    /* JADX INFO: renamed from: _guarantSecondProgress$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _guarantSecondProgress;

    /* JADX INFO: renamed from: _guarantTooltip$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _guarantTooltip;

    /* JADX INFO: renamed from: _guarantTextTooltip$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _guarantTextTooltip;

    @NotNull
    public final CaseData get_case() {
        return this._case;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuarantInfoBlock(@NotNull CaseData _case) {
        super(4.0f, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(_case, "_case");
        this._case = _case;
        ResourceLocation resourceLocationAsResource = ResourcesKt.asResource("textures/ui/guarant_item.png", "msshop");
        Intrinsics.checkNotNullExpressionValue(resourceLocationAsResource, "asResource(...)");
        UIComponent $this$constrain$iv = new ImageComponent(resourceLocationAsResource, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_item_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_item_delegate_u24lambda_u240.setX(UtilitiesKt.getDp((Number) 16));
        $this$_item_delegate_u24lambda_u240.setY(new CenterConstraint());
        $this$_item_delegate_u24lambda_u240.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$_item_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 48));
        this._item = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new UIBlock(MSPalette.INSTANCE.getWhiteA2());
        UIConstraints $this$_divider_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_divider_delegate_u24lambda_u241.setX(new SiblingConstraint(8.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_divider_delegate_u24lambda_u241.setY(new CenterConstraint());
        $this$_divider_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 1));
        $this$_divider_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 57));
        this._divider = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = new LabelComponent("&lПрогресс гаранта", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_guarantLabel_delegate_u24lambda_u242 = $this$constrain$iv3.getConstraints();
        $this$_guarantLabel_delegate_u24lambda_u242.setX(new SiblingConstraint(16.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_guarantLabel_delegate_u24lambda_u242.setY(UtilitiesKt.getDp((Number) 8));
        $this$_guarantLabel_delegate_u24lambda_u242.setTextScale(UtilitiesKt.getDp((Number) 16));
        this._guarantLabel = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, (UIComponent) this), this, $$delegatedProperties[2]);
        ResourceLocation resourceLocationAsResource2 = ResourcesKt.asResource("textures/ui/info.png", "msshop");
        Intrinsics.checkNotNullExpressionValue(resourceLocationAsResource2, "asResource(...)");
        UIComponent $this$constrain$iv4 = new ImageComponent(resourceLocationAsResource2, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_guarantInfo_delegate_u24lambda_u243 = $this$constrain$iv4.getConstraints();
        $this$_guarantInfo_delegate_u24lambda_u243.setX(UtilitiesKt.dp((Number) 7, true, true));
        $this$_guarantInfo_delegate_u24lambda_u243.setY(new CenterConstraint());
        $this$_guarantInfo_delegate_u24lambda_u243.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$_guarantInfo_delegate_u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 16));
        this._guarantInfo = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, get_guarantLabel()), this, $$delegatedProperties[3]);
        UIComponent $this$constrain$iv5 = new GuarantProgressBar(StateKt.state(Integer.valueOf(this._case.getGuarantyFirstProgress())), StateKt.state(Integer.valueOf(this._case.getGuarantyFirstLimit())), true);
        UIConstraints $this$_guarantFirstProgress_delegate_u24lambda_u244 = $this$constrain$iv5.getConstraints();
        $this$_guarantFirstProgress_delegate_u24lambda_u244.setX(ConstraintsKt.boundTo(UtilitiesKt.getDp(Float.valueOf(16.0f)), get_divider()));
        $this$_guarantFirstProgress_delegate_u24lambda_u244.setY(ConstraintsKt.boundTo(UtilitiesKt.dp(Float.valueOf(4.0f), true, true), get_guarantLabel()));
        $this$_guarantFirstProgress_delegate_u24lambda_u244.setWidth(UtilitiesKt.getDp((Number) 622));
        $this$_guarantFirstProgress_delegate_u24lambda_u244.setHeight(UtilitiesKt.getDp((Number) 14));
        this._guarantFirstProgress = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv5, (UIComponent) this), this, $$delegatedProperties[4]);
        UIComponent $this$constrain$iv6 = new GuarantProgressBar(StateKt.state(Integer.valueOf(this._case.getGuarantySecondProgress())), StateKt.state(Integer.valueOf(this._case.getGuarantySecondLimit())), false, 4, null);
        UIConstraints $this$_guarantSecondProgress_delegate_u24lambda_u245 = $this$constrain$iv6.getConstraints();
        $this$_guarantSecondProgress_delegate_u24lambda_u245.setX(ConstraintsKt.boundTo(UtilitiesKt.getDp(Float.valueOf(16.0f)), get_divider()));
        $this$_guarantSecondProgress_delegate_u24lambda_u245.setY(ConstraintsKt.boundTo(UtilitiesKt.dp(Float.valueOf(4.0f), true, true), get_guarantFirstProgress()));
        $this$_guarantSecondProgress_delegate_u24lambda_u245.setWidth(UtilitiesKt.getDp((Number) 622));
        $this$_guarantSecondProgress_delegate_u24lambda_u245.setHeight(UtilitiesKt.getDp((Number) 14));
        this._guarantSecondProgress = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv6, (UIComponent) this), this, $$delegatedProperties[5]);
        UIComponent $this$constrain$iv7 = new UIRoundedRectangle(13.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$_guarantTooltip_delegate_u24lambda_u246 = $this$constrain$iv7.getConstraints();
        $this$_guarantTooltip_delegate_u24lambda_u246.setX(UtilitiesKt.dp((Number) 12, true, true));
        $this$_guarantTooltip_delegate_u24lambda_u246.setY(UtilitiesKt.dp$default((Number) 12, false, true, 1, (Object) null));
        $this$_guarantTooltip_delegate_u24lambda_u246.setWidth(ConstraintsKt.plus(new ChildBasedMaxSizeConstraint(), UtilitiesKt.getDp((Number) 18)));
        $this$_guarantTooltip_delegate_u24lambda_u246.setHeight(ConstraintsKt.plus(new ChildBasedMaxSizeConstraint(), UtilitiesKt.getDp((Number) 28)));
        $this$_guarantTooltip_delegate_u24lambda_u246.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getBackgroundModal()));
        this._guarantTooltip = ComponentsKt.provideDelegate(ComponentsKt.childOf(ComponentsKt.effect($this$constrain$iv7, new RoundOutlineEffect((Color) MSPalette.INSTANCE.getModal().get(), 10.0f, 2.5f, 1.0f, false, 16, (DefaultConstructorMarker) null)), get_guarantInfo()), this, $$delegatedProperties[6]);
        UIComponent $this$constrain$iv8 = new WrappedText(StringsKt.replace$default(StringsKt.replace$default(MSShopClient.INSTANCE.getGuarantInfo$MSShop(), "%g_first%", String.valueOf(this._case.getGuarantyFirstLimit()), false, 4, (Object) null), "%g_second%", String.valueOf(this._case.getGuarantySecondLimit()), false, 4, (Object) null), false, (Color) null, false, false, 0.0f, (String) null, 126, (DefaultConstructorMarker) null);
        UIConstraints $this$_guarantTextTooltip_delegate_u24lambda_u247 = $this$constrain$iv8.getConstraints();
        $this$_guarantTextTooltip_delegate_u24lambda_u247.setX(UtilitiesKt.getDp((Number) 16));
        $this$_guarantTextTooltip_delegate_u24lambda_u247.setY(UtilitiesKt.getDp((Number) 14));
        $this$_guarantTextTooltip_delegate_u24lambda_u247.setWidth(UtilitiesKt.getDp((Number) 357));
        $this$_guarantTextTooltip_delegate_u24lambda_u247.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_guarantTextTooltip_delegate_u24lambda_u247.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._guarantTextTooltip = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv8, get_guarantTooltip()), this, $$delegatedProperties[7]);
        UIConstraints $this$_init__u24lambda_u248 = ((UIComponent) this).getConstraints();
        $this$_init__u24lambda_u248.setX(new CenterConstraint());
        $this$_init__u24lambda_u248.setY(UtilitiesKt.dp$default((Number) 32, true, false, 2, (Object) null));
        $this$_init__u24lambda_u248.setWidth(UtilitiesKt.getDp((Number) 772));
        $this$_init__u24lambda_u248.setHeight(UtilitiesKt.getDp((Number) 68));
        $this$_init__u24lambda_u248.setColor(UtilitiesKt.toConstraint(new Color(0, 0, 0, 0)));
        get_guarantInfo().onMouseEnter((v1) -> {
            return _init_$lambda$9(r1, v1);
        }).onMouseLeave((v1) -> {
            return _init_$lambda$10(r1, v1);
        });
        ComponentsKt.effect((UIComponent) this, new RoundOutlineEffect((Color) MSPalette.INSTANCE.getWhiteA2().get(), 4.0f, 1.5f, 0.7f, false, 16, (DefaultConstructorMarker) null));
    }

    private final ImageComponent get_item() {
        return (ImageComponent) this._item.getValue(this, $$delegatedProperties[0]);
    }

    private final UIBlock get_divider() {
        return (UIBlock) this._divider.getValue(this, $$delegatedProperties[1]);
    }

    private final LabelComponent get_guarantLabel() {
        return (LabelComponent) this._guarantLabel.getValue(this, $$delegatedProperties[2]);
    }

    private final ImageComponent get_guarantInfo() {
        return (ImageComponent) this._guarantInfo.getValue(this, $$delegatedProperties[3]);
    }

    private final GuarantProgressBar get_guarantFirstProgress() {
        return (GuarantProgressBar) this._guarantFirstProgress.getValue(this, $$delegatedProperties[4]);
    }

    private final GuarantProgressBar get_guarantSecondProgress() {
        return (GuarantProgressBar) this._guarantSecondProgress.getValue(this, $$delegatedProperties[5]);
    }

    private final UIRoundedRectangle get_guarantTooltip() {
        return (UIRoundedRectangle) this._guarantTooltip.getValue(this, $$delegatedProperties[6]);
    }

    private final WrappedText get_guarantTextTooltip() {
        return (WrappedText) this._guarantTextTooltip.getValue(this, $$delegatedProperties[7]);
    }

    private static final Unit _init_$lambda$9(GuarantInfoBlock this$0, UIComponent $this$onMouseEnter) {
        Intrinsics.checkNotNullParameter($this$onMouseEnter, "$this$onMouseEnter");
        UIComponent.unhide$default(this$0.get_guarantTooltip(), false, 1, (Object) null);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$10(GuarantInfoBlock this$0, UIComponent $this$onMouseLeave) {
        Intrinsics.checkNotNullParameter($this$onMouseLeave, "$this$onMouseLeave");
        UIComponent.hide$default(this$0.get_guarantTooltip(), false, 1, (Object) null);
        return Unit.INSTANCE;
    }

    public void afterInitialization() {
        super.afterInitialization();
        get_guarantTooltip().hide(true);
        if (!this._case.isGuarantFirstActive()) {
            get_guarantFirstProgress().hide(true);
            UIComponent $this$constrain$iv = get_guarantSecondProgress();
            UIConstraints $this$afterInitialization_u24lambda_u2411 = $this$constrain$iv.getConstraints();
            $this$afterInitialization_u24lambda_u2411.setY(ConstraintsKt.boundTo(new CenterConstraint(), get_divider()));
        }
        if (!this._case.isGuarantSecondActive()) {
            get_guarantSecondProgress().hide(true);
            UIComponent $this$constrain$iv2 = get_guarantFirstProgress();
            UIConstraints $this$afterInitialization_u24lambda_u2412 = $this$constrain$iv2.getConstraints();
            $this$afterInitialization_u24lambda_u2412.setY(ConstraintsKt.boundTo(new CenterConstraint(), get_divider()));
        }
    }

    public final void updateFirstGuarantProgress(int value, int max) {
        get_guarantFirstProgress().getValue().set(Integer.valueOf(value));
        get_guarantFirstProgress().getMax().set(Integer.valueOf(max));
    }

    public final void updateSecondGuarantProgress(int value, int max) {
        get_guarantSecondProgress().getValue().set(Integer.valueOf(value));
        get_guarantSecondProgress().getMax().set(Integer.valueOf(max));
    }

    /* JADX INFO: compiled from: GuarantInfoBlock.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/cases/component/GuarantInfoBlock$GuarantProgressBar.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR&\u0010\r\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/cases/component/GuarantInfoBlock$GuarantProgressBar;", "Lgg/essential/elementa/components/UIRoundedRectangle;", "value", "Lgg/essential/elementa/state/BasicState;", "", "max", "isSegmented", "", "<init>", "(Lgg/essential/elementa/state/BasicState;Lgg/essential/elementa/state/BasicState;Z)V", "getValue", "()Lgg/essential/elementa/state/BasicState;", "getMax", "_currentProgress", "Lgg/essential/elementa/state/MappedState;", "Lkotlin/Pair;", "", "prepareSegmentedProgress", "", "prepareStandardProgress", "MSShop"})
    @SourceDebugExtension({"SMAP\nGuarantInfoBlock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GuarantInfoBlock.kt\nnet/mcskill/shop/client/screen/modal/cases/component/GuarantInfoBlock$GuarantProgressBar\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,196:1\n10#2,3:197\n10#2,3:200\n10#2,3:203\n*S KotlinDebug\n*F\n+ 1 GuarantInfoBlock.kt\nnet/mcskill/shop/client/screen/modal/cases/component/GuarantInfoBlock$GuarantProgressBar\n*L\n154#1:197,3\n164#1:200,3\n184#1:203,3\n*E\n"})
    public static final class GuarantProgressBar extends UIRoundedRectangle {

        @NotNull
        private final BasicState<Integer> value;

        @NotNull
        private final BasicState<Integer> max;

        @NotNull
        private final MappedState<Pair<Integer, Integer>, Float> _currentProgress;

        public /* synthetic */ GuarantProgressBar(BasicState basicState, BasicState basicState2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(basicState, basicState2, (i & 4) != 0 ? false : z);
        }

        @NotNull
        public final BasicState<Integer> getValue() {
            return this.value;
        }

        @NotNull
        public final BasicState<Integer> getMax() {
            return this.max;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuarantProgressBar(@NotNull BasicState<Integer> basicState, @NotNull BasicState<Integer> basicState2, boolean isSegmented) {
            super(4.0f, false, 2, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(basicState, "value");
            Intrinsics.checkNotNullParameter(basicState2, "max");
            this.value = basicState;
            this.max = basicState2;
            this._currentProgress = this.value.zip(this.max).map(GuarantProgressBar::_currentProgress$lambda$0);
            setColor((ColorConstraint) ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA1()));
            if (isSegmented) {
                prepareSegmentedProgress();
            } else {
                prepareStandardProgress();
            }
            UIComponent $this$constrain$iv = new LabelComponent(this.value.zip(this.max).map(GuarantProgressBar::_init_$lambda$1), (State) null, (State) null, 6, (DefaultConstructorMarker) null);
            UIConstraints $this$_init__u24lambda_u242 = $this$constrain$iv.getConstraints();
            $this$_init__u24lambda_u242.setX(UtilitiesKt.dp((Number) 14, true, true));
            $this$_init__u24lambda_u242.setY(ConstraintsKt.plus(new CenterConstraint(), UtilitiesKt.getDp((Number) 1)));
            $this$_init__u24lambda_u242.setTextScale(UtilitiesKt.getDp((Number) 12));
            ComponentsKt.childOf($this$constrain$iv, (UIComponent) this);
        }

        private static final float _currentProgress$lambda$0(Pair pair) {
            Intrinsics.checkNotNullParameter(pair, "<destruct>");
            int v = ((Number) pair.component1()).intValue();
            int m = ((Number) pair.component2()).intValue();
            return v / m;
        }

        private static final String _init_$lambda$1(Pair it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return "&l" + Math.min(((Number) it.getFirst()).intValue(), ((Number) it.getSecond()).intValue()) + "/" + it.getSecond();
        }

        private final void prepareSegmentedProgress() {
            int count = 0;
            int iIntValue = ((Number) this.max.get()).intValue();
            while (count < iIntValue) {
                boolean first = count == 0;
                UIComponent $this$constrain$iv = new UIRoundedRectangle(4.0f, false, 2, (DefaultConstructorMarker) null);
                UIConstraints $this$prepareSegmentedProgress_u24lambda_u245 = $this$constrain$iv.getConstraints();
                $this$prepareSegmentedProgress_u24lambda_u245.setX(ConstraintsKt.plus((SuperConstraint) (first ? UtilitiesKt.getDp(Double.valueOf(2.5d)) : UtilitiesKt.getDp((Number) 0)), new SiblingConstraint(2.0f, false, false, 6, (DefaultConstructorMarker) null)));
                $this$prepareSegmentedProgress_u24lambda_u245.setY(UtilitiesKt.getDp(Double.valueOf(2.5d)));
                $this$prepareSegmentedProgress_u24lambda_u245.setWidth(ConstraintsKt.minus(ConstraintsKt.minus(BasicConstraintsKt.basicWidthConstraint((v1) -> {
                    return prepareSegmentedProgress$lambda$5$lambda$3(r1, v1);
                }), UtilitiesKt.getDp((Number) 2)), (SuperConstraint) (count + 1 == ((Number) this.max.get()).intValue() ? UtilitiesKt.getDp((Number) 5) : UtilitiesKt.getDp((Number) 0))));
                $this$prepareSegmentedProgress_u24lambda_u245.setHeight(UtilitiesKt.getDp((Number) 8));
                int i = count;
                $this$prepareSegmentedProgress_u24lambda_u245.setColor(BasicConstraintsKt.basicColorConstraint((v2) -> {
                    return prepareSegmentedProgress$lambda$5$lambda$4(r1, r2, v2);
                }));
                ComponentsKt.childOf($this$constrain$iv, (UIComponent) this);
                count++;
            }
        }

        private static final float prepareSegmentedProgress$lambda$5$lambda$3(GuarantProgressBar this$0, UIComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            UIComponent parent = component.getParent();
            return (parent.getRight() - parent.getLeft()) / ((Number) this$0.max.get()).floatValue();
        }

        private static final Color prepareSegmentedProgress$lambda$5$lambda$4(int $count, GuarantProgressBar this$0, UIComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            if ($count < ((Number) this$0.value.get()).intValue()) {
                return (Color) MSPalette.INSTANCE.getGuarantSegmentActive().get();
            }
            return (Color) MSPalette.INSTANCE.getGuarantSegmentInactive().get();
        }

        private final void prepareStandardProgress() {
            UIComponent $this$constrain$iv = new UIRoundedRectangle(3.0f, false, 2, (DefaultConstructorMarker) null);
            UIConstraints $this$prepareStandardProgress_u24lambda_u247 = $this$constrain$iv.getConstraints();
            $this$prepareStandardProgress_u24lambda_u247.setX(UtilitiesKt.getDp(Double.valueOf(2.5d)));
            $this$prepareStandardProgress_u24lambda_u247.setY(UtilitiesKt.getDp(Double.valueOf(2.5d)));
            $this$prepareStandardProgress_u24lambda_u247.setWidth(BasicConstraintsKt.basicWidthConstraint((v1) -> {
                return prepareStandardProgress$lambda$7$lambda$6(r1, v1);
            }));
            $this$prepareStandardProgress_u24lambda_u247.setHeight(UtilitiesKt.getDp((Number) 8));
            $this$prepareStandardProgress_u24lambda_u247.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getGuarantSecondProgress()));
            ComponentsKt.childOf($this$constrain$iv, (UIComponent) this);
        }

        private static final float prepareStandardProgress$lambda$7$lambda$6(GuarantProgressBar this$0, UIComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
            UIComponent target = component.getParent();
            return ((target.getRight() - component.getLeft()) - 2) * ((Number) this$0._currentProgress.get()).floatValue();
        }
    }
}
