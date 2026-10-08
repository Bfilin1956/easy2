package net.mcskill.shop.client.screen.tab.cart;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.Window;
import gg.essential.elementa.components.image.ImageView;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.CramSiblingConstraint;
import gg.essential.elementa.constraints.HeightConstraint;
import gg.essential.elementa.constraints.WidthConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.ExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.shop.client.screen.component.EntryComponent;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.modal.cases.impl.PreviewCaseModal;
import net.mcskill.shop.common.response.shop.CaseData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CartCaseEntry.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/tab/cart/CartCaseEntry.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lnet/mcskill/shop/client/screen/tab/cart/CartCaseEntry;", "Lnet/mcskill/shop/client/screen/component/EntryComponent;", "case", "Lnet/mcskill/shop/common/response/shop/CaseData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/CaseData;)V", "_logo", "Lgg/essential/elementa/components/image/ImageView;", "get_logo", "()Lgg/essential/elementa/components/image/ImageView;", "_logo$delegate", "Lkotlin/properties/ReadWriteProperty;", "_openButton", "Lgg/essential/elementa/UIComponent;", "get_openButton", "()Lgg/essential/elementa/UIComponent;", "_openButton$delegate", "MSShop"})
@SourceDebugExtension({"SMAP\nCartCaseEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CartCaseEntry.kt\nnet/mcskill/shop/client/screen/tab/cart/CartCaseEntry\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,52:1\n10#2,3:53\n10#2,3:56\n10#2,3:59\n*S KotlinDebug\n*F\n+ 1 CartCaseEntry.kt\nnet/mcskill/shop/client/screen/tab/cart/CartCaseEntry\n*L\n27#1:53,3\n34#1:56,3\n45#1:59,3\n*E\n"})
public final class CartCaseEntry extends EntryComponent {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CartCaseEntry.class, "_logo", "get_logo()Lgg/essential/elementa/components/image/ImageView;", 0)), Reflection.property1(new PropertyReference1Impl(CartCaseEntry.class, "_openButton", "get_openButton()Lgg/essential/elementa/UIComponent;", 0))};

    /* JADX INFO: renamed from: _logo$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _logo;

    /* JADX INFO: renamed from: _openButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _openButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CartCaseEntry(@NotNull CaseData caseData) {
        super(caseData.getName() + " x" + Math.max(0, caseData.getAmount()), 0, 0.0f, 220, 18, 6, null);
        Intrinsics.checkNotNullParameter(caseData, "case");
        UIComponent $this$constrain$iv = new ImageView(caseData.getImage(), 0.0f, 0.0f, UIImage.TextureScalingMode.NEAREST, UIImage.TextureScalingMode.NEAREST, (WidthConstraint) null, (HeightConstraint) null, 102, (DefaultConstructorMarker) null);
        UIConstraints $this$_logo_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_logo_delegate_u24lambda_u240.setX(new CenterConstraint());
        $this$_logo_delegate_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 72));
        $this$_logo_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp((Number) 174));
        $this$_logo_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 124));
        this._logo = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        LabelButton labelButton = (UIComponent) new LabelButton("Открыть", 18, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$_openButton_delegate_u24lambda_u241 = labelButton.getConstraints();
        $this$_openButton_delegate_u24lambda_u241.setX(new CenterConstraint());
        $this$_openButton_delegate_u24lambda_u241.setY(UtilitiesKt.dp$default((Number) 14, true, false, 2, (Object) null));
        $this$_openButton_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 172));
        $this$_openButton_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 40));
        $this$_openButton_delegate_u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this._openButton = ComponentsKt.provideDelegate(ComponentsKt.childOf(labelButton.onMouseClick((v1, v2) -> {
            return _openButton_delegate$lambda$2(r2, v1, v2);
        }), (UIComponent) this), this, $$delegatedProperties[1]);
        UIConstraints $this$_init__u24lambda_u243 = ((UIComponent) this).getConstraints();
        $this$_init__u24lambda_u243.setX(new CramSiblingConstraint(14.0f));
        $this$_init__u24lambda_u243.setY(new CramSiblingConstraint(14.0f));
        $this$_init__u24lambda_u243.setWidth(UtilitiesKt.getDp((Number) 232));
        $this$_init__u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 266));
    }

    private final ImageView get_logo() {
        return (ImageView) this._logo.getValue(this, $$delegatedProperties[0]);
    }

    private final UIComponent get_openButton() {
        return (UIComponent) this._openButton.getValue(this, $$delegatedProperties[1]);
    }

    private static final Unit _openButton_delegate$lambda$2(CaseData $case, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ComponentsKt.childOf(new PreviewCaseModal($case), Window.Companion.of($this$onMouseClick));
        return Unit.INSTANCE;
    }
}
