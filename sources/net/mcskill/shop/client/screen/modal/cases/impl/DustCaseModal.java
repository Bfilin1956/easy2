package net.mcskill.shop.client.screen.modal.cases.impl;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.ItemStackComponent;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.YConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.events.UIClickEvent;
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
import net.mcskill.shop.client.screen.modal.cases.BaseCaseModal;
import net.mcskill.shop.common.network.CartAction;
import net.mcskill.shop.common.network.ChannelHandler;
import net.mcskill.shop.common.network.packet.take.RequestCartActionPacket;
import net.mcskill.shop.common.response.shop.CaseData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DustCaseModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/cases/impl/DustCaseModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/cases/impl/DustCaseModal;", "Lnet/mcskill/shop/client/screen/modal/cases/BaseCaseModal;", "case", "Lnet/mcskill/shop/common/response/shop/CaseData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/CaseData;)V", "_priceLabel", "Lgg/essential/elementa/components/LabelComponent;", "get_priceLabel", "()Lgg/essential/elementa/components/LabelComponent;", "_priceLabel$delegate", "Lkotlin/properties/ReadWriteProperty;", "_price", "get_price", "_price$delegate", "_icon", "Lgg/essential/elementa/components/ItemStackComponent;", "get_icon", "()Lgg/essential/elementa/components/ItemStackComponent;", "_icon$delegate", "MSShop"})
@SourceDebugExtension({"SMAP\nDustCaseModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DustCaseModal.kt\nnet/mcskill/shop/client/screen/modal/cases/impl/DustCaseModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,49:1\n10#2,3:50\n10#2,3:53\n10#2,3:56\n*S KotlinDebug\n*F\n+ 1 DustCaseModal.kt\nnet/mcskill/shop/client/screen/modal/cases/impl/DustCaseModal\n*L\n17#1:50,3\n24#1:53,3\n35#1:56,3\n*E\n"})
public final class DustCaseModal extends BaseCaseModal {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DustCaseModal.class, "_priceLabel", "get_priceLabel()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(DustCaseModal.class, "_price", "get_price()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(DustCaseModal.class, "_icon", "get_icon()Lgg/essential/elementa/components/ItemStackComponent;", 0))};

    /* JADX INFO: renamed from: _priceLabel$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _priceLabel;

    /* JADX INFO: renamed from: _price$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _price;

    /* JADX INFO: renamed from: _icon$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _icon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DustCaseModal(@NotNull CaseData caseData) {
        super(caseData, "Открытие за монеты", 883.0f, 638.0f, false);
        Intrinsics.checkNotNullParameter(caseData, "case");
        UIComponent $this$constrain$iv = new LabelComponent("§lСтоимость: ", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_priceLabel_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_priceLabel_delegate_u24lambda_u240.setX(UtilitiesKt.getDp((Number) 70));
        $this$_priceLabel_delegate_u24lambda_u240.setY(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 20, true, true), getName()));
        $this$_priceLabel_delegate_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_priceLabel_delegate_u24lambda_u240.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._priceLabel = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, getContent()), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new LabelComponent("&l" + caseData.getDustData().getAmount(), false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_price_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_price_delegate_u24lambda_u241.setX(UtilitiesKt.dp((Number) 3, true, true));
        $this$_price_delegate_u24lambda_u241.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_price_delegate_u24lambda_u241.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._price = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, get_priceLabel()), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = ItemStackComponent.Companion.of(caseData.getDustData().getRegistryName(), caseData.getDustData().getAmount(), caseData.getDustData().getMeta(), caseData.getDustData().getNbt());
        UIConstraints $this$_icon_delegate_u24lambda_u242 = $this$constrain$iv3.getConstraints();
        $this$_icon_delegate_u24lambda_u242.setX(UtilitiesKt.dp((Number) 3, true, true));
        $this$_icon_delegate_u24lambda_u242.setY(new CenterConstraint());
        $this$_icon_delegate_u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 35));
        $this$_icon_delegate_u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 35));
        this._icon = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, get_price()), this, $$delegatedProperties[2]);
        getActionButton().getLabel().setText("Открыть");
        getActionButton().setY((YConstraint) ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 21, true, true), get_icon()));
        getActionButton().onMouseClick((v1, v2) -> {
            return _init_$lambda$3(r1, v1, v2);
        });
    }

    private final LabelComponent get_priceLabel() {
        return (LabelComponent) this._priceLabel.getValue(this, $$delegatedProperties[0]);
    }

    private final LabelComponent get_price() {
        return (LabelComponent) this._price.getValue(this, $$delegatedProperties[1]);
    }

    private final ItemStackComponent get_icon() {
        return (ItemStackComponent) this._icon.getValue(this, $$delegatedProperties[2]);
    }

    private static final Unit _init_$lambda$3(CaseData $case, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ChannelHandler.INSTANCE.sendToServer(new RequestCartActionPacket(CartAction.OPEN_DUST_CASE, $case.getId(), 0, 4, null));
        return Unit.INSTANCE;
    }
}
