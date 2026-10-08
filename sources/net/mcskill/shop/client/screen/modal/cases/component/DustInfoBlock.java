package net.mcskill.shop.client.screen.modal.cases.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.ItemStackComponent;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIBlock;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.components.WrappedText;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedMaxSizeConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.RoundOutlineEffect;
import gg.essential.elementa.state.ExtensionsKt;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
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
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DustInfoBlock.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/cases/component/DustInfoBlock.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001c\u0010\u001d¨\u0006\"²\u0006\n\u0010#\u001a\u00020\u0001X\u008a\u0084\u0002"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/cases/component/DustInfoBlock;", "Lgg/essential/elementa/components/UIRoundedRectangle;", "case", "Lnet/mcskill/shop/common/response/shop/CaseData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/CaseData;)V", "_dustName", "", "_dustCount", "", "_item", "Lgg/essential/elementa/components/ItemStackComponent;", "get_item", "()Lgg/essential/elementa/components/ItemStackComponent;", "_item$delegate", "Lkotlin/properties/ReadWriteProperty;", "_divider", "Lgg/essential/elementa/components/UIBlock;", "get_divider", "()Lgg/essential/elementa/components/UIBlock;", "_divider$delegate", "_textContainer", "Lgg/essential/elementa/components/UIContainer;", "get_textContainer", "()Lgg/essential/elementa/components/UIContainer;", "_textContainer$delegate", "_text", "Lgg/essential/elementa/components/WrappedText;", "get_text", "()Lgg/essential/elementa/components/WrappedText;", "_text$delegate", "dustAmountBadge", "", "Companion", "MSShop", "background"})
@SourceDebugExtension({"SMAP\nDustInfoBlock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DustInfoBlock.kt\nnet/mcskill/shop/client/screen/modal/cases/component/DustInfoBlock\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,89:1\n10#2,3:90\n10#2,3:93\n10#2,3:96\n10#2,3:99\n10#2,3:102\n10#2,3:105\n10#2,3:108\n*S KotlinDebug\n*F\n+ 1 DustInfoBlock.kt\nnet/mcskill/shop/client/screen/modal/cases/component/DustInfoBlock\n*L\n22#1:90,3\n29#1:93,3\n36#1:96,3\n50#1:99,3\n58#1:102,3\n74#1:105,3\n82#1:108,3\n*E\n"})
public final class DustInfoBlock extends UIRoundedRectangle {

    @NotNull
    private final String _dustName;
    private final int _dustCount;

    /* JADX INFO: renamed from: _item$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _item;

    /* JADX INFO: renamed from: _divider$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _divider;

    /* JADX INFO: renamed from: _textContainer$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _textContainer;

    /* JADX INFO: renamed from: _text$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _text;
    public static final char DELIMITER = 'x';
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DustInfoBlock.class, "_item", "get_item()Lgg/essential/elementa/components/ItemStackComponent;", 0)), Reflection.property1(new PropertyReference1Impl(DustInfoBlock.class, "_divider", "get_divider()Lgg/essential/elementa/components/UIBlock;", 0)), Reflection.property1(new PropertyReference1Impl(DustInfoBlock.class, "_textContainer", "get_textContainer()Lgg/essential/elementa/components/UIContainer;", 0)), Reflection.property1(new PropertyReference1Impl(DustInfoBlock.class, "_text", "get_text()Lgg/essential/elementa/components/WrappedText;", 0)), Reflection.property0(new PropertyReference0Impl(DustInfoBlock.class, "background", "<v#0>", 0))};

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DustInfoBlock(@NotNull CaseData caseData) {
        super(4.0f, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(caseData, "case");
        this._dustName = StringsKt.substringBefore$default(caseData.getDustItem(), 'x', (String) null, 2, (Object) null);
        Integer intOrNull = StringsKt.toIntOrNull(StringsKt.substringAfter$default(caseData.getDustItem(), 'x', (String) null, 2, (Object) null));
        this._dustCount = intOrNull != null ? intOrNull.intValue() : 0;
        UIComponent $this$constrain$iv = ItemStackComponent.Companion.of$default(ItemStackComponent.Companion, this._dustName, 0, 0, (String) null, 14, (Object) null);
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
        UIComponent $this$constrain$iv3 = new UIContainer();
        UIConstraints $this$_textContainer_delegate_u24lambda_u242 = $this$constrain$iv3.getConstraints();
        $this$_textContainer_delegate_u24lambda_u242.setX(new SiblingConstraint(16.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_textContainer_delegate_u24lambda_u242.setY(new CenterConstraint());
        $this$_textContainer_delegate_u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 667));
        $this$_textContainer_delegate_u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 62));
        this._textContainer = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, (UIComponent) this), this, $$delegatedProperties[2]);
        String dustInfo$MSShop = MSShopClient.INSTANCE.getDustInfo$MSShop();
        String string = get_item().getStack().getDisplayName().getString();
        UIComponent $this$constrain$iv4 = new WrappedText("&lДополнительно: " + StringsKt.replace$default(dustInfo$MSShop, "%dust%", string == null ? "<empty>" : string, false, 4, (Object) null), false, (Color) null, false, false, 0.0f, (String) null, 126, (DefaultConstructorMarker) null);
        UIConstraints $this$_text_delegate_u24lambda_u243 = $this$constrain$iv4.getConstraints();
        $this$_text_delegate_u24lambda_u243.setY(new CenterConstraint());
        $this$_text_delegate_u24lambda_u243.setWidth(new FillConstraint(false));
        $this$_text_delegate_u24lambda_u243.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_text_delegate_u24lambda_u243.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._text = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, get_textContainer()), this, $$delegatedProperties[3]);
        UIConstraints $this$_init__u24lambda_u244 = ((UIComponent) this).getConstraints();
        $this$_init__u24lambda_u244.setX(ConstraintsKt.plus(new CenterConstraint(), UtilitiesKt.getDp(Double.valueOf(13.5d))));
        $this$_init__u24lambda_u244.setY(UtilitiesKt.dp$default((Number) 24, true, false, 2, (Object) null));
        $this$_init__u24lambda_u244.setWidth(UtilitiesKt.getDp((Number) 772));
        $this$_init__u24lambda_u244.setHeight(UtilitiesKt.getDp((Number) 64));
        $this$_init__u24lambda_u244.setColor(UtilitiesKt.toConstraint(new Color(0, 0, 0, 0)));
        ComponentsKt.effect((UIComponent) this, new RoundOutlineEffect((Color) MSPalette.INSTANCE.getWhiteA2().get(), 4.0f, 1.5f, 0.7f, false, 16, (DefaultConstructorMarker) null));
        dustAmountBadge();
    }

    private final ItemStackComponent get_item() {
        return (ItemStackComponent) this._item.getValue(this, $$delegatedProperties[0]);
    }

    private final UIBlock get_divider() {
        return (UIBlock) this._divider.getValue(this, $$delegatedProperties[1]);
    }

    private final UIContainer get_textContainer() {
        return (UIContainer) this._textContainer.getValue(this, $$delegatedProperties[2]);
    }

    private final WrappedText get_text() {
        return (WrappedText) this._text.getValue(this, $$delegatedProperties[3]);
    }

    private final void dustAmountBadge() {
        if (this._dustCount <= 1) {
            return;
        }
        UIComponent $this$constrain$iv = new UIRoundedRectangle(12.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$dustAmountBadge_u24lambda_u245 = $this$constrain$iv.getConstraints();
        $this$dustAmountBadge_u24lambda_u245.setX(UtilitiesKt.dp$default((Number) 0, true, false, 2, (Object) null));
        $this$dustAmountBadge_u24lambda_u245.setY(UtilitiesKt.dp$default((Number) 0, true, false, 2, (Object) null));
        $this$dustAmountBadge_u24lambda_u245.setWidth(ConstraintsKt.plus(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null), UtilitiesKt.getDp((Number) 10)));
        $this$dustAmountBadge_u24lambda_u245.setHeight(ConstraintsKt.plus(new ChildBasedMaxSizeConstraint(), UtilitiesKt.getDp((Number) 6)));
        $this$dustAmountBadge_u24lambda_u245.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getSidebar()));
        ReadWriteProperty background$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, get_item()), (Object) null, $$delegatedProperties[4]);
        UIComponent $this$constrain$iv2 = new LabelComponent("&lx" + this._dustCount, false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$dustAmountBadge_u24lambda_u247 = $this$constrain$iv2.getConstraints();
        $this$dustAmountBadge_u24lambda_u247.setX(new CenterConstraint());
        $this$dustAmountBadge_u24lambda_u247.setY(new CenterConstraint());
        $this$dustAmountBadge_u24lambda_u247.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$dustAmountBadge_u24lambda_u247.setTextScale(UtilitiesKt.getDp((Number) 14));
        ComponentsKt.childOf($this$constrain$iv2, dustAmountBadge$lambda$6(background$delegate));
    }

    private static final UIRoundedRectangle dustAmountBadge$lambda$6(ReadWriteProperty<Object, UIRoundedRectangle> readWriteProperty) {
        return (UIRoundedRectangle) readWriteProperty.getValue((Object) null, $$delegatedProperties[4]);
    }
}
