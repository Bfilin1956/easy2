package net.mcskill.shop.client.screen.tab.cart;

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
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.ExtensionsKt;
import java.awt.Color;
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
import net.mcskill.shop.client.screen.modal.cases.component.DustInfoBlock;
import net.mcskill.shop.client.screen.modal.item.TakeItemModal;
import net.mcskill.shop.common.response.shop.ItemData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CartItemEntry.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/tab/cart/CartItemEntry.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\f²\u0006\n\u0010\r\u001a\u00020\u000eX\u008a\u0084\u0002"}, d2 = {"Lnet/mcskill/shop/client/screen/tab/cart/CartItemEntry;", "Lnet/mcskill/shop/client/screen/component/EntryComponent;", "item", "Lnet/mcskill/shop/common/response/shop/ItemData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/ItemData;)V", "_takeButton", "Lgg/essential/elementa/UIComponent;", "get_takeButton", "()Lgg/essential/elementa/UIComponent;", "_takeButton$delegate", "Lkotlin/properties/ReadWriteProperty;", "MSShop", "plate", "Lgg/essential/elementa/components/UIRoundedRectangle;"})
@SourceDebugExtension({"SMAP\nCartItemEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CartItemEntry.kt\nnet/mcskill/shop/client/screen/tab/cart/CartItemEntry\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,70:1\n10#2,3:71\n10#2,3:74\n10#2,3:77\n10#2,3:80\n10#2,3:83\n*S KotlinDebug\n*F\n+ 1 CartItemEntry.kt\nnet/mcskill/shop/client/screen/tab/cart/CartItemEntry\n*L\n19#1:71,3\n30#1:74,3\n46#1:77,3\n54#1:80,3\n62#1:83,3\n*E\n"})
public final class CartItemEntry extends EntryComponent {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CartItemEntry.class, "_takeButton", "get_takeButton()Lgg/essential/elementa/UIComponent;", 0)), Reflection.property0(new PropertyReference0Impl(CartItemEntry.class, "plate", "<v#0>", 0))};

    /* JADX INFO: renamed from: _takeButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _takeButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CartItemEntry(@NotNull ItemData item) {
        UIComponent uIComponent;
        super(item.getName(), 0, 0.0f, 180, 18, 6, null);
        Intrinsics.checkNotNullParameter(item, "item");
        LabelButton labelButton = (UIComponent) new LabelButton("Забрать", 18, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$_takeButton_delegate_u24lambda_u240 = labelButton.getConstraints();
        $this$_takeButton_delegate_u24lambda_u240.setX(new CenterConstraint());
        $this$_takeButton_delegate_u24lambda_u240.setY(UtilitiesKt.dp$default((Number) 14, true, false, 2, (Object) null));
        $this$_takeButton_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp((Number) 148));
        $this$_takeButton_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 31));
        $this$_takeButton_delegate_u24lambda_u240.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this._takeButton = ComponentsKt.provideDelegate(ComponentsKt.childOf(labelButton.onMouseClick((v1, v2) -> {
            return _takeButton_delegate$lambda$1(r2, v1, v2);
        }), (UIComponent) this), this, $$delegatedProperties[0]);
        UIConstraints $this$_init__u24lambda_u242 = ((UIComponent) this).getConstraints();
        $this$_init__u24lambda_u242.setX(new CramSiblingConstraint(8.0f));
        $this$_init__u24lambda_u242.setY(new CramSiblingConstraint(8.0f));
        $this$_init__u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 196));
        $this$_init__u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 220));
        if (Intrinsics.areEqual(item.getType(), "command")) {
            uIComponent = (UIComponent) new ImageView(item.getImage(), 1.0f, 1.0f, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, (WidthConstraint) null, (HeightConstraint) null, DustInfoBlock.DELIMITER, (DefaultConstructorMarker) null);
        } else {
            UIComponent uIComponentOf$default = ItemStackComponent.Companion.of$default(ItemStackComponent.Companion, item.getItemName(), 0, 0, (String) null, 14, (Object) null);
            if (uIComponentOf$default.getStack().isEmpty()) {
                uIComponent = (UIComponent) new ImageView(item.getImage(), 1.0f, 1.0f, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, (WidthConstraint) null, (HeightConstraint) null, DustInfoBlock.DELIMITER, (DefaultConstructorMarker) null);
            } else {
                uIComponent = uIComponentOf$default;
            }
        }
        UIComponent $this$constrain$iv = uIComponent;
        UIConstraints $this$_init__u24lambda_u243 = $this$constrain$iv.getConstraints();
        $this$_init__u24lambda_u243.setX(new CenterConstraint());
        $this$_init__u24lambda_u243.setY(ConstraintsKt.plus(new CenterConstraint(), UtilitiesKt.getDp(Float.valueOf(4.0f))));
        $this$_init__u24lambda_u243.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 85));
        UIComponent logo = ComponentsKt.childOf($this$constrain$iv, (UIComponent) this);
        if (item.getAmount() <= 1) {
            return;
        }
        UIComponent $this$constrain$iv2 = new UIRoundedRectangle(12.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$_init__u24lambda_u244 = $this$constrain$iv2.getConstraints();
        $this$_init__u24lambda_u244.setX(UtilitiesKt.dp$default((Number) 0, true, false, 2, (Object) null));
        $this$_init__u24lambda_u244.setY(UtilitiesKt.dp$default((Number) 0, true, false, 2, (Object) null));
        $this$_init__u24lambda_u244.setWidth(ConstraintsKt.plus(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null), UtilitiesKt.getDp((Number) 10)));
        $this$_init__u24lambda_u244.setHeight(ConstraintsKt.plus(new ChildBasedMaxSizeConstraint(), UtilitiesKt.getDp((Number) 6)));
        $this$_init__u24lambda_u244.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getBlue()));
        ReadWriteProperty plate$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, logo), (Object) null, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = new LabelComponent("§lx" + item.getAmount(), false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_init__u24lambda_u246 = $this$constrain$iv3.getConstraints();
        $this$_init__u24lambda_u246.setX(new CenterConstraint());
        $this$_init__u24lambda_u246.setY(new CenterConstraint());
        $this$_init__u24lambda_u246.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_init__u24lambda_u246.setTextScale(UtilitiesKt.getDp((Number) 18));
        ComponentsKt.childOf($this$constrain$iv3, _init_$lambda$5(plate$delegate));
    }

    private final UIComponent get_takeButton() {
        return (UIComponent) this._takeButton.getValue(this, $$delegatedProperties[0]);
    }

    private static final Unit _takeButton_delegate$lambda$1(ItemData $item, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ComponentsKt.childOf(new TakeItemModal($item, 0.0f, 0.0f, 6, null), Window.Companion.of($this$onMouseClick));
        return Unit.INSTANCE;
    }

    private static final UIRoundedRectangle _init_$lambda$5(ReadWriteProperty<Object, UIRoundedRectangle> readWriteProperty) {
        return (UIRoundedRectangle) readWriteProperty.getValue((Object) null, $$delegatedProperties[1]);
    }
}
