package net.mcskill.shop.client.screen.modal.cases.impl;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
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
import net.mcskill.core.client.util.UtilsKt;
import net.mcskill.shop.client.screen.modal.cases.BaseCaseModal;
import net.mcskill.shop.common.response.shop.CaseData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VoteCaseModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/cases/impl/VoteCaseModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/cases/impl/VoteCaseModal;", "Lnet/mcskill/shop/client/screen/modal/cases/BaseCaseModal;", "case", "Lnet/mcskill/shop/common/response/shop/CaseData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/CaseData;)V", "_info", "Lgg/essential/elementa/components/LabelComponent;", "get_info", "()Lgg/essential/elementa/components/LabelComponent;", "_info$delegate", "Lkotlin/properties/ReadWriteProperty;", "MSShop"})
@SourceDebugExtension({"SMAP\nVoteCaseModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoteCaseModal.kt\nnet/mcskill/shop/client/screen/modal/cases/impl/VoteCaseModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,28:1\n10#2,3:29\n*S KotlinDebug\n*F\n+ 1 VoteCaseModal.kt\nnet/mcskill/shop/client/screen/modal/cases/impl/VoteCaseModal\n*L\n14#1:29,3\n*E\n"})
public final class VoteCaseModal extends BaseCaseModal {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(VoteCaseModal.class, "_info", "get_info()Lgg/essential/elementa/components/LabelComponent;", 0))};

    /* JADX INFO: renamed from: _info$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _info;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoteCaseModal(@NotNull CaseData caseData) {
        super(caseData, "Информация о кейсе", 883.0f, 638.0f, false, 16, null);
        Intrinsics.checkNotNullParameter(caseData, "case");
        UIComponent $this$constrain$iv = new LabelComponent("&lЗа голосование", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_info_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_info_delegate_u24lambda_u240.setX(ConstraintsKt.boundTo(new CenterConstraint(), getLogo()));
        $this$_info_delegate_u24lambda_u240.setY(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 20, true, true), getName()));
        $this$_info_delegate_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_info_delegate_u24lambda_u240.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._info = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, getContent()), this, $$delegatedProperties[0]);
        getActionButton().getLabel().setText("Получить");
        getActionButton().setY((YConstraint) ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 21, true, true), get_info()));
        getActionButton().onMouseClick((v1, v2) -> {
            return _init_$lambda$1(r1, v1, v2);
        });
    }

    private final LabelComponent get_info() {
        return (LabelComponent) this._info.getValue(this, $$delegatedProperties[0]);
    }

    private static final Unit _init_$lambda$1(CaseData $case, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        UtilsKt.openAsUrl($case.getUrl());
        return Unit.INSTANCE;
    }
}
