package net.mcskill.shop.client.screen.modal.cases.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.ItemStackComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.image.ImageView;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.CramSiblingConstraint;
import gg.essential.elementa.constraints.HeightConstraint;
import gg.essential.elementa.constraints.WidthConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.state.ExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.core.client.screen.component.MSRoundedRectangle;
import net.mcskill.shop.client.screen.RarityColor;
import net.mcskill.shop.client.screen.component.EntryComponent;
import net.mcskill.shop.common.response.shop.CaseItemData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CaseItemContent.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/cases/component/CaseItemContent.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/cases/component/CaseItemContent;", "Lnet/mcskill/shop/client/screen/component/EntryComponent;", "itemData", "Lnet/mcskill/shop/common/response/shop/CaseItemData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/CaseItemData;)V", "_windowItem", "Lnet/mcskill/core/client/screen/component/MSRoundedRectangle;", "get_windowItem", "()Lnet/mcskill/core/client/screen/component/MSRoundedRectangle;", "_windowItem$delegate", "Lkotlin/properties/ReadWriteProperty;", "_textContainer", "Lgg/essential/elementa/components/UIContainer;", "get_textContainer", "()Lgg/essential/elementa/components/UIContainer;", "_textContainer$delegate", "createLogo", "", "item", "MSShop"})
@SourceDebugExtension({"SMAP\nCaseItemContent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CaseItemContent.kt\nnet/mcskill/shop/client/screen/modal/cases/component/CaseItemContent\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,63:1\n10#2,3:64\n10#2,3:67\n10#2,3:70\n10#2,3:73\n10#2,3:76\n*S KotlinDebug\n*F\n+ 1 CaseItemContent.kt\nnet/mcskill/shop/client/screen/modal/cases/component/CaseItemContent\n*L\n17#1:64,3\n26#1:67,3\n34#1:70,3\n48#1:73,3\n55#1:76,3\n*E\n"})
public final class CaseItemContent extends EntryComponent {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CaseItemContent.class, "_windowItem", "get_windowItem()Lnet/mcskill/core/client/screen/component/MSRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(CaseItemContent.class, "_textContainer", "get_textContainer()Lgg/essential/elementa/components/UIContainer;", 0))};

    /* JADX INFO: renamed from: _windowItem$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _windowItem;

    /* JADX INFO: renamed from: _textContainer$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _textContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaseItemContent(@NotNull CaseItemData itemData) {
        super("§l" + itemData.getName(), 116, 9.0f, 146, 14);
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        UIComponent $this$constrain$iv = new MSRoundedRectangle(false, false, 3, (DefaultConstructorMarker) null);
        UIConstraints $this$_windowItem_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_windowItem_delegate_u24lambda_u240.setX(new CenterConstraint());
        $this$_windowItem_delegate_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 3));
        $this$_windowItem_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp((Number) 146));
        $this$_windowItem_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 110));
        $this$_windowItem_delegate_u24lambda_u240.setRadius(UtilitiesKt.getDp((Number) 9));
        $this$_windowItem_delegate_u24lambda_u240.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getBackgroundModal()));
        this._windowItem = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new UIContainer();
        UIConstraints $this$_textContainer_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_textContainer_delegate_u24lambda_u241.setX(new CenterConstraint());
        $this$_textContainer_delegate_u24lambda_u241.setY(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 6, true, true), get_windowItem()));
        $this$_textContainer_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 146));
        $this$_textContainer_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 40));
        this._textContainer = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
        UIConstraints $this$_init__u24lambda_u242 = ((UIComponent) this).getConstraints();
        $this$_init__u24lambda_u242.setX(new CramSiblingConstraint(12.0f));
        $this$_init__u24lambda_u242.setY(new CramSiblingConstraint(12.0f));
        $this$_init__u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 152));
        $this$_init__u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 164));
        $this$_init__u24lambda_u242.setColor(UtilitiesKt.toConstraint(RarityColor.INSTANCE.findBy(itemData.getRarity() - 1).getColor()));
        createLogo(itemData);
        getTitle().setY(ConstraintsKt.boundTo(new CenterConstraint(), get_textContainer()));
    }

    private final MSRoundedRectangle get_windowItem() {
        return (MSRoundedRectangle) this._windowItem.getValue(this, $$delegatedProperties[0]);
    }

    private final UIContainer get_textContainer() {
        return (UIContainer) this._textContainer.getValue(this, $$delegatedProperties[1]);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x003d  */
    private final void createLogo(CaseItemData item) {
        UIComponent uIComponent;
        UIComponent uIComponentOf$default = ItemStackComponent.Companion.of$default(ItemStackComponent.Companion, item.getRegistryName(), 0, 0, (String) null, 14, (Object) null);
        if (!uIComponentOf$default.getStack().isEmpty()) {
            if ((item.getImage().length() > 0) || item.getType().getCode() != 1) {
                UIComponent $this$constrain$iv = new ImageView(item.getImage(), 0.7f, 0.7f, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, (WidthConstraint) null, (HeightConstraint) null, DustInfoBlock.DELIMITER, (DefaultConstructorMarker) null);
                UIConstraints $this$createLogo_u24lambda_u243 = $this$constrain$iv.getConstraints();
                $this$createLogo_u24lambda_u243.setX(new CenterConstraint());
                $this$createLogo_u24lambda_u243.setY(new CenterConstraint());
                $this$createLogo_u24lambda_u243.setWidth(UtilitiesKt.getDp((Number) 140));
                $this$createLogo_u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 108));
                uIComponent = $this$constrain$iv;
            } else {
                UIComponent $this$constrain$iv2 = uIComponentOf$default;
                UIConstraints $this$createLogo_u24lambda_u244 = $this$constrain$iv2.getConstraints();
                $this$createLogo_u24lambda_u244.setX(new CenterConstraint());
                $this$createLogo_u24lambda_u244.setY(new CenterConstraint());
                $this$createLogo_u24lambda_u244.setWidth(UtilitiesKt.getDp((Number) 86));
                $this$createLogo_u24lambda_u244.setHeight(UtilitiesKt.getDp((Number) 86));
                uIComponent = $this$constrain$iv2;
            }
        } else {
            UIComponent $this$constrain$iv3 = new ImageView(item.getImage(), 0.7f, 0.7f, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, (WidthConstraint) null, (HeightConstraint) null, DustInfoBlock.DELIMITER, (DefaultConstructorMarker) null);
            UIConstraints $this$createLogo_u24lambda_u245 = $this$constrain$iv3.getConstraints();
            $this$createLogo_u24lambda_u245.setX(new CenterConstraint());
            $this$createLogo_u24lambda_u245.setY(new CenterConstraint());
            $this$createLogo_u24lambda_u245.setWidth(UtilitiesKt.getDp((Number) 140));
            $this$createLogo_u24lambda_u245.setHeight(UtilitiesKt.getDp((Number) 108));
            uIComponent = $this$constrain$iv3;
        }
        ComponentsKt.childOf(uIComponent, get_windowItem());
    }
}
