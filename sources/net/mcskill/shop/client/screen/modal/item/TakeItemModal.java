package net.mcskill.shop.client.screen.modal.item;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
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
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.modal.Modal;
import net.mcskill.shop.common.network.CartAction;
import net.mcskill.shop.common.network.ChannelHandler;
import net.mcskill.shop.common.network.packet.take.RequestCartActionPacket;
import net.mcskill.shop.common.response.shop.ItemData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TakeItemModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/item/TakeItemModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/item/TakeItemModal;", "Lnet/mcskill/shop/client/screen/modal/Modal;", "item", "Lnet/mcskill/shop/common/response/shop/ItemData;", "w", "", "h", "<init>", "(Lnet/mcskill/shop/common/response/shop/ItemData;FF)V", "_question", "Lgg/essential/elementa/components/LabelComponent;", "get_question", "()Lgg/essential/elementa/components/LabelComponent;", "_question$delegate", "Lkotlin/properties/ReadWriteProperty;", "_takeButton", "Lgg/essential/elementa/UIComponent;", "get_takeButton", "()Lgg/essential/elementa/UIComponent;", "_takeButton$delegate", "MSShop"})
@SourceDebugExtension({"SMAP\nTakeItemModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TakeItemModal.kt\nnet/mcskill/shop/client/screen/modal/item/TakeItemModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,39:1\n10#2,3:40\n10#2,3:43\n*S KotlinDebug\n*F\n+ 1 TakeItemModal.kt\nnet/mcskill/shop/client/screen/modal/item/TakeItemModal\n*L\n20#1:40,3\n27#1:43,3\n*E\n"})
public class TakeItemModal extends Modal {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(TakeItemModal.class, "_question", "get_question()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(TakeItemModal.class, "_takeButton", "get_takeButton()Lgg/essential/elementa/UIComponent;", 0))};

    /* JADX INFO: renamed from: _question$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _question;

    /* JADX INFO: renamed from: _takeButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _takeButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TakeItemModal(@NotNull ItemData item, float w, float h) {
        super("Получение предмета", w, h);
        Intrinsics.checkNotNullParameter(item, "item");
        UIComponent $this$constrain$iv = new LabelComponent("Вы уверены что хотите забрать данный предмет?", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_question_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_question_delegate_u24lambda_u240.setX(new CenterConstraint());
        $this$_question_delegate_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 87));
        $this$_question_delegate_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_question_delegate_u24lambda_u240.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._question = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, getContent()), this, $$delegatedProperties[0]);
        LabelButton labelButton = (UIComponent) new LabelButton("Забрать", 18, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$_takeButton_delegate_u24lambda_u241 = labelButton.getConstraints();
        $this$_takeButton_delegate_u24lambda_u241.setX(new CenterConstraint());
        $this$_takeButton_delegate_u24lambda_u241.setY(UtilitiesKt.getDp((Number) 118));
        $this$_takeButton_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 208));
        $this$_takeButton_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 31));
        $this$_takeButton_delegate_u24lambda_u241.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_takeButton_delegate_u24lambda_u241.setTextScale(UtilitiesKt.getDp((Number) 18));
        $this$_takeButton_delegate_u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this._takeButton = ComponentsKt.provideDelegate(ComponentsKt.childOf(labelButton.onMouseClick((v2, v3) -> {
            return _takeButton_delegate$lambda$2(r2, r3, v2, v3);
        }), getContent()), this, $$delegatedProperties[1]);
    }

    public /* synthetic */ TakeItemModal(ItemData itemData, float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(itemData, (i & 2) != 0 ? 524.0f : f, (i & 4) != 0 ? 182.0f : f2);
    }

    private final LabelComponent get_question() {
        return (LabelComponent) this._question.getValue(this, $$delegatedProperties[0]);
    }

    private final UIComponent get_takeButton() {
        return (UIComponent) this._takeButton.getValue(this, $$delegatedProperties[1]);
    }

    private static final Unit _takeButton_delegate$lambda$2(ItemData $item, TakeItemModal this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ChannelHandler.INSTANCE.sendToServer(new RequestCartActionPacket(CartAction.TAKE_ITEM, $item.getId(), 0, 4, null));
        this$0.close();
        return Unit.INSTANCE;
    }
}
