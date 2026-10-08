package net.mcskill.shop.client.screen.modal.group;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.WrappedText;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.ExtensionsKt;
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
import net.mcskill.core.client.MSCoreClient;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.modal.Modal;
import net.mcskill.shop.common.network.CartAction;
import net.mcskill.shop.common.network.ChannelHandler;
import net.mcskill.shop.common.network.packet.take.RequestCartActionPacket;
import net.mcskill.shop.common.response.shop.GroupData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ActivateGroupModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/group/ActivateGroupModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/group/ActivateGroupModal;", "Lnet/mcskill/shop/client/screen/modal/Modal;", "group", "Lnet/mcskill/shop/common/response/shop/GroupData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/GroupData;)V", "_questionBlock", "Lgg/essential/elementa/components/WrappedText;", "get_questionBlock", "()Lgg/essential/elementa/components/WrappedText;", "_questionBlock$delegate", "Lkotlin/properties/ReadWriteProperty;", "_activateButton", "Lgg/essential/elementa/UIComponent;", "get_activateButton", "()Lgg/essential/elementa/UIComponent;", "_activateButton$delegate", "MSShop"})
@SourceDebugExtension({"SMAP\nActivateGroupModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivateGroupModal.kt\nnet/mcskill/shop/client/screen/modal/group/ActivateGroupModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,42:1\n10#2,3:43\n10#2,3:46\n*S KotlinDebug\n*F\n+ 1 ActivateGroupModal.kt\nnet/mcskill/shop/client/screen/modal/group/ActivateGroupModal\n*L\n24#1:43,3\n32#1:46,3\n*E\n"})
public final class ActivateGroupModal extends Modal {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ActivateGroupModal.class, "_questionBlock", "get_questionBlock()Lgg/essential/elementa/components/WrappedText;", 0)), Reflection.property1(new PropertyReference1Impl(ActivateGroupModal.class, "_activateButton", "get_activateButton()Lgg/essential/elementa/UIComponent;", 0))};

    /* JADX INFO: renamed from: _questionBlock$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _questionBlock;

    /* JADX INFO: renamed from: _activateButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _activateButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivateGroupModal(@NotNull GroupData group) {
        super("Активация привилегии", 524.0f, 228.0f);
        Intrinsics.checkNotNullParameter(group, "group");
        UIComponent $this$constrain$iv = new WrappedText("Вы уверены что хотите активировать " + group.getName() + " на сервере " + MSCoreClient.Companion.getCurrentServer().getTitle() + "?", false, (Color) null, true, false, 0.0f, (String) null, 118, (DefaultConstructorMarker) null);
        UIConstraints $this$_questionBlock_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_questionBlock_delegate_u24lambda_u240.setX(new CenterConstraint());
        $this$_questionBlock_delegate_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 87));
        $this$_questionBlock_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp((Number) 518));
        $this$_questionBlock_delegate_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_questionBlock_delegate_u24lambda_u240.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._questionBlock = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, getContent()), this, $$delegatedProperties[0]);
        LabelButton labelButton = (UIComponent) new LabelButton("Активировать", 18, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$_activateButton_delegate_u24lambda_u241 = labelButton.getConstraints();
        $this$_activateButton_delegate_u24lambda_u241.setX(new CenterConstraint());
        $this$_activateButton_delegate_u24lambda_u241.setY(UtilitiesKt.dp$default((Number) 32, true, false, 2, (Object) null));
        $this$_activateButton_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 208));
        $this$_activateButton_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 31));
        $this$_activateButton_delegate_u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this._activateButton = ComponentsKt.provideDelegate(ComponentsKt.childOf(labelButton.onMouseClick((v2, v3) -> {
            return _activateButton_delegate$lambda$2(r2, r3, v2, v3);
        }), getContent()), this, $$delegatedProperties[1]);
    }

    private final WrappedText get_questionBlock() {
        return (WrappedText) this._questionBlock.getValue(this, $$delegatedProperties[0]);
    }

    private final UIComponent get_activateButton() {
        return (UIComponent) this._activateButton.getValue(this, $$delegatedProperties[1]);
    }

    private static final Unit _activateButton_delegate$lambda$2(GroupData $group, ActivateGroupModal this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ChannelHandler.INSTANCE.sendToServer(new RequestCartActionPacket(CartAction.ACTIVATE_GROUP, $group.getOrder(), 0, 4, null));
        this$0.close();
        return Unit.INSTANCE;
    }
}
