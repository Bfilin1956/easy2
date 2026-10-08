package net.mcskill.shop.client.screen.modal.group;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.universal.UMinecraft;
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
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.component.input.TextField;
import net.mcskill.shop.client.screen.modal.Modal;
import net.mcskill.shop.client.screen.notification.Notifications;
import net.mcskill.shop.client.screen.notification.ShopNotification;
import net.mcskill.shop.common.network.ChannelHandler;
import net.mcskill.shop.common.network.packet.buy.RequestBuyGroupPacket;
import net.mcskill.shop.common.network.packet.take.RequestGiftGroup;
import net.mcskill.shop.common.response.shop.GroupData;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GiftGroupModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/group/GiftGroupModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/group/GiftGroupModal;", "Lnet/mcskill/shop/client/screen/modal/Modal;", "_group", "Lnet/mcskill/shop/common/response/shop/GroupData;", "_time", "", "_isCart", "", "<init>", "(Lnet/mcskill/shop/common/response/shop/GroupData;IZ)V", "_groupName", "Lgg/essential/elementa/components/LabelComponent;", "get_groupName", "()Lgg/essential/elementa/components/LabelComponent;", "_groupName$delegate", "Lkotlin/properties/ReadWriteProperty;", "_receiverField", "Lnet/mcskill/shop/client/screen/component/input/TextField;", "get_receiverField", "()Lnet/mcskill/shop/client/screen/component/input/TextField;", "_receiverField$delegate", "_gift", "Lgg/essential/elementa/UIComponent;", "get_gift", "()Lgg/essential/elementa/UIComponent;", "_gift$delegate", "giftBtnAction", "", "MSShop"})
@SourceDebugExtension({"SMAP\nGiftGroupModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GiftGroupModal.kt\nnet/mcskill/shop/client/screen/modal/group/GiftGroupModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,70:1\n10#2,3:71\n10#2,3:74\n10#2,3:77\n*S KotlinDebug\n*F\n+ 1 GiftGroupModal.kt\nnet/mcskill/shop/client/screen/modal/group/GiftGroupModal\n*L\n25#1:71,3\n32#1:74,3\n39#1:77,3\n*E\n"})
public final class GiftGroupModal extends Modal {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(GiftGroupModal.class, "_groupName", "get_groupName()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(GiftGroupModal.class, "_receiverField", "get_receiverField()Lnet/mcskill/shop/client/screen/component/input/TextField;", 0)), Reflection.property1(new PropertyReference1Impl(GiftGroupModal.class, "_gift", "get_gift()Lgg/essential/elementa/UIComponent;", 0))};

    @NotNull
    private final GroupData _group;
    private final int _time;
    private final boolean _isCart;

    /* JADX INFO: renamed from: _groupName$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _groupName;

    /* JADX INFO: renamed from: _receiverField$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _receiverField;

    /* JADX INFO: renamed from: _gift$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _gift;

    public /* synthetic */ GiftGroupModal(GroupData groupData, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(groupData, i, (i2 & 4) != 0 ? false : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftGroupModal(@NotNull GroupData _group, int _time, boolean _isCart) {
        super("Подарить привилегию", 524.0f, 230.0f);
        Intrinsics.checkNotNullParameter(_group, "_group");
        this._group = _group;
        this._time = _time;
        this._isCart = _isCart;
        UIComponent $this$constrain$iv = new LabelComponent(this._group.getName(), false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_groupName_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_groupName_delegate_u24lambda_u240.setX(new CenterConstraint());
        $this$_groupName_delegate_u24lambda_u240.setY(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp((Number) 12)));
        $this$_groupName_delegate_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_groupName_delegate_u24lambda_u240.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._groupName = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, getContent()), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new TextField("Ник получателя", null, 2, null);
        UIConstraints $this$_receiverField_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_receiverField_delegate_u24lambda_u241.setX(new CenterConstraint());
        $this$_receiverField_delegate_u24lambda_u241.setY(ConstraintsKt.plus(new CenterConstraint(), UtilitiesKt.getDp((Number) 20)));
        $this$_receiverField_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 208));
        $this$_receiverField_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 32));
        this._receiverField = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, getContent()), this, $$delegatedProperties[1]);
        LabelButton labelButton = (UIComponent) new LabelButton("Подарить", 18, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$_gift_delegate_u24lambda_u242 = labelButton.getConstraints();
        $this$_gift_delegate_u24lambda_u242.setX(new CenterConstraint());
        $this$_gift_delegate_u24lambda_u242.setY(UtilitiesKt.dp$default((Number) 32, true, false, 2, (Object) null));
        $this$_gift_delegate_u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 208));
        $this$_gift_delegate_u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 31));
        $this$_gift_delegate_u24lambda_u242.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this._gift = ComponentsKt.provideDelegate(ComponentsKt.childOf(labelButton.onMouseClick((v1, v2) -> {
            return _gift_delegate$lambda$3(r2, v1, v2);
        }), getContent()), this, $$delegatedProperties[2]);
    }

    private final LabelComponent get_groupName() {
        return (LabelComponent) this._groupName.getValue(this, $$delegatedProperties[0]);
    }

    private final TextField get_receiverField() {
        return (TextField) this._receiverField.getValue(this, $$delegatedProperties[1]);
    }

    private final UIComponent get_gift() {
        return (UIComponent) this._gift.getValue(this, $$delegatedProperties[2]);
    }

    private static final Unit _gift_delegate$lambda$3(GiftGroupModal this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.giftBtnAction();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0046  */
    private final void giftBtnAction() {
        String string;
        String receiverName = get_receiverField().getInput().getText();
        if (receiverName.length() == 0) {
            Notifications.INSTANCE.push("Поле получателя не может быть пустым!", ShopNotification.Status.ERROR, 10.0f);
            return;
        }
        LocalPlayer player = UMinecraft.getPlayer();
        if (player != null) {
            Component name = player.getName();
            if (name != null) {
                string = name.getString();
            } else {
                string = null;
            }
        } else {
            string = null;
        }
        if (Intrinsics.areEqual(receiverName, string)) {
            Notifications.INSTANCE.push("Вы не можете подарить группу самому себе.", ShopNotification.Status.ERROR, 10.0f);
        } else {
            ChannelHandler.INSTANCE.sendToServer(this._isCart ? new RequestGiftGroup(this._group.getId(), this._group.getOrder(), receiverName) : new RequestBuyGroupPacket(this._group.getGroupId(), this._time, receiverName));
            close();
        }
    }
}
