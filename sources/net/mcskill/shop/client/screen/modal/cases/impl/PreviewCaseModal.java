package net.mcskill.shop.client.screen.modal.cases.impl;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.constraints.YConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.state.State;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.core.common.coroutine.IoScope;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.modal.cases.BaseCaseModal;
import net.mcskill.shop.client.screen.notification.Notifications;
import net.mcskill.shop.client.screen.notification.ShopNotification;
import net.mcskill.shop.common.network.CartAction;
import net.mcskill.shop.common.network.ChannelHandler;
import net.mcskill.shop.common.network.packet.take.CheckCanOpenCasePacket;
import net.mcskill.shop.common.network.packet.take.RequestCartActionPacket;
import net.mcskill.shop.common.response.shop.CaseData;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PreviewCaseModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/cases/impl/PreviewCaseModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/cases/impl/PreviewCaseModal;", "Lnet/mcskill/shop/client/screen/modal/cases/BaseCaseModal;", "case", "Lnet/mcskill/shop/common/response/shop/CaseData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/CaseData;)V", "_stockLabel", "Lgg/essential/elementa/components/LabelComponent;", "get_stockLabel", "()Lgg/essential/elementa/components/LabelComponent;", "_stockLabel$delegate", "Lkotlin/properties/ReadWriteProperty;", "_stockAmount", "get_stockAmount", "_stockAmount$delegate", "actionButtonX5", "Lnet/mcskill/shop/client/screen/component/LabelButton;", "getActionButtonX5", "()Lnet/mcskill/shop/client/screen/component/LabelButton;", "actionButtonX5$delegate", "MSShop"})
@SourceDebugExtension({"SMAP\nPreviewCaseModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PreviewCaseModal.kt\nnet/mcskill/shop/client/screen/modal/cases/impl/PreviewCaseModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,74:1\n10#2,3:75\n10#2,3:78\n10#2,3:81\n*S KotlinDebug\n*F\n+ 1 PreviewCaseModal.kt\nnet/mcskill/shop/client/screen/modal/cases/impl/PreviewCaseModal\n*L\n26#1:75,3\n33#1:78,3\n39#1:81,3\n*E\n"})
public final class PreviewCaseModal extends BaseCaseModal {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(PreviewCaseModal.class, "_stockLabel", "get_stockLabel()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(PreviewCaseModal.class, "_stockAmount", "get_stockAmount()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(PreviewCaseModal.class, "actionButtonX5", "getActionButtonX5()Lnet/mcskill/shop/client/screen/component/LabelButton;", 0))};

    /* JADX INFO: renamed from: _stockLabel$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _stockLabel;

    /* JADX INFO: renamed from: _stockAmount$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _stockAmount;

    /* JADX INFO: renamed from: actionButtonX5$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty actionButtonX5;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewCaseModal(@NotNull CaseData caseData) {
        super(caseData, "Информация о кейсе", 883.0f, 638.0f, false, 16, null);
        Intrinsics.checkNotNullParameter(caseData, "case");
        UIComponent $this$constrain$iv = new LabelComponent("§lВ наличии:", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_stockLabel_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_stockLabel_delegate_u24lambda_u240.setX(UtilitiesKt.getDp((Number) 70));
        $this$_stockLabel_delegate_u24lambda_u240.setY(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 20, true, true), getName()));
        $this$_stockLabel_delegate_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_stockLabel_delegate_u24lambda_u240.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._stockLabel = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, getContent()), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new LabelComponent(getCasesAmount().map((v0) -> {
            return _stockAmount_delegate$lambda$1(v0);
        }), (State) null, (State) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_stockAmount_delegate_u24lambda_u242 = $this$constrain$iv2.getConstraints();
        $this$_stockAmount_delegate_u24lambda_u242.setX(UtilitiesKt.dp((Number) 3, true, true));
        $this$_stockAmount_delegate_u24lambda_u242.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_stockAmount_delegate_u24lambda_u242.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._stockAmount = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, get_stockLabel()), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = new LabelButton("Открыть x5", 24, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$actionButtonX5_delegate_u24lambda_u243 = $this$constrain$iv3.getConstraints();
        $this$actionButtonX5_delegate_u24lambda_u243.setX(UtilitiesKt.getDp((Number) 70));
        $this$actionButtonX5_delegate_u24lambda_u243.setWidth(UtilitiesKt.getDp((Number) 201));
        $this$actionButtonX5_delegate_u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 48));
        $this$actionButtonX5_delegate_u24lambda_u243.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this.actionButtonX5 = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, getContent()), this, $$delegatedProperties[2]);
        getActionButton().getLabel().setText("Открыть");
        getActionButton().setY((YConstraint) ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 21, true, true), get_stockAmount()));
        getActionButtonX5().setY((YConstraint) ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 21, true, true), getActionButton()));
        getActionButton().onMouseClick((v2, v3) -> {
            return _init_$lambda$4(r1, r2, v2, v3);
        });
        getActionButtonX5().onMouseClick((v2, v3) -> {
            return _init_$lambda$5(r1, r2, v2, v3);
        });
    }

    private final LabelComponent get_stockLabel() {
        return (LabelComponent) this._stockLabel.getValue(this, $$delegatedProperties[0]);
    }

    private final LabelComponent get_stockAmount() {
        return (LabelComponent) this._stockAmount.getValue(this, $$delegatedProperties[1]);
    }

    private static final String _stockAmount_delegate$lambda$1(int it) {
        return Math.max(0, it) + " шт.";
    }

    @NotNull
    public final LabelButton getActionButtonX5() {
        return (LabelButton) this.actionButtonX5.getValue(this, $$delegatedProperties[2]);
    }

    private static final Unit _init_$lambda$4(PreviewCaseModal this$0, CaseData $case, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.getActionButton().isEnabled()) {
            ChannelHandler.INSTANCE.sendToServer(new RequestCartActionPacket(CartAction.OPEN_CASE, $case.getId(), 1));
            Notifications.INSTANCE.push("Кейс открывается подождите пожалуйста", ShopNotification.Status.SUCCESS, 1.0f);
            this$0.getActionButton().setEnabled(false);
            this$0.getActionButtonX5().setEnabled(false);
        } else {
            BuildersKt.launch$default(IoScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new PreviewCaseModal$1$1($case, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$5(PreviewCaseModal this$0, CaseData $case, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.getActionButtonX5().isEnabled()) {
            ChannelHandler.INSTANCE.sendToServer(new RequestCartActionPacket(CartAction.OPEN_CASE, $case.getId(), 5));
            Notifications.INSTANCE.push("Кейс открывается подождите пожалуйста", ShopNotification.Status.SUCCESS, 1.0f);
            this$0.getActionButton().setEnabled(false);
            this$0.getActionButtonX5().setEnabled(false);
        } else {
            PacketDistributor.sendToServer(new CheckCanOpenCasePacket($case.getId(), 5), new CustomPacketPayload[0]);
        }
        return Unit.INSTANCE;
    }
}
