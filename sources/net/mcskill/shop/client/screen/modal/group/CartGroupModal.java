package net.mcskill.shop.client.screen.modal.group;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.Window;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.ExtensionsKt;
import java.awt.Color;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.core.common.util.TextFormatterKt;
import net.mcskill.core.common.util.TimeUtil;
import net.mcskill.shop.client.screen.component.IconButton;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.common.response.shop.GroupData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CartGroupModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/group/CartGroupModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0003H\u0002¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/group/CartGroupModal;", "Lnet/mcskill/shop/client/screen/modal/group/BaseGroupModal;", "group", "Lnet/mcskill/shop/common/response/shop/GroupData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/GroupData;)V", "initAvailable", "", "MSShop", "activateButton", "Lgg/essential/elementa/UIComponent;"})
@SourceDebugExtension({"SMAP\nCartGroupModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CartGroupModal.kt\nnet/mcskill/shop/client/screen/modal/group/CartGroupModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,65:1\n10#2,3:66\n10#2,3:69\n10#2,3:72\n10#2,3:75\n*S KotlinDebug\n*F\n+ 1 CartGroupModal.kt\nnet/mcskill/shop/client/screen/modal/group/CartGroupModal\n*L\n22#1:66,3\n26#1:69,3\n45#1:72,3\n55#1:75,3\n*E\n"})
public final class CartGroupModal extends BaseGroupModal {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(CartGroupModal.class, "activateButton", "<v#0>", 0))};

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CartGroupModal(@NotNull GroupData group) {
        super("Активация группы", group);
        Intrinsics.checkNotNullParameter(group, "group");
        UIConstraints $this$_init__u24lambda_u240 = get_serverTitle().getConstraints();
        $this$_init__u24lambda_u240.setY(UtilitiesKt.getDp((Number) 185));
        UIComponent $this$constrain$iv = new LabelComponent((String) null, false, (Color) null, 7, (DefaultConstructorMarker) null);
        UIConstraints $this$_init__u24lambda_u241 = $this$constrain$iv.getConstraints();
        $this$_init__u24lambda_u241.setX(ConstraintsKt.boundTo(new CenterConstraint(), get_logo()));
        $this$_init__u24lambda_u241.setY(ConstraintsKt.boundTo(new SiblingConstraint(16.0f, false, false, 6, (DefaultConstructorMarker) null), get_groupNameLabel()));
        $this$_init__u24lambda_u241.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_init__u24lambda_u241.setTextScale(UtilitiesKt.getDp((Number) 16));
        $this$_init__u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA5()));
        LabelComponent info = ComponentsKt.childOf($this$constrain$iv, getContent());
        if (group.getTime() == 0) {
            info.setText("§lНавсегда");
        } else {
            long days = ChronoUnit.DAYS.between(Instant.EPOCH, Instant.ofEpochSecond(group.getTime()));
            info.setText("§lНа " + TextFormatterKt.declension(days, TimeUtil.INSTANCE.getDayWords()));
            info.setColor((Color) MSPalette.INSTANCE.getOrange().get());
        }
        initAvailable(group);
    }

    private final void initAvailable(GroupData $this$initAvailable) {
        LabelButton labelButton = (UIComponent) new LabelButton("Активировать", 24, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$initAvailable_u24lambda_u242 = labelButton.getConstraints();
        $this$initAvailable_u24lambda_u242.setX(UtilitiesKt.getDp((Number) 70));
        $this$initAvailable_u24lambda_u242.setY(UtilitiesKt.dp$default((Number) 32, true, false, 2, (Object) null));
        $this$initAvailable_u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 193));
        $this$initAvailable_u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 48));
        $this$initAvailable_u24lambda_u242.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        ReadWriteProperty activateButton$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf(labelButton.onMouseClick((v1, v2) -> {
            return initAvailable$lambda$3(r1, v1, v2);
        }), getContent()), (Object) null, $$delegatedProperties[0]);
        IconButton iconButton = (UIComponent) new IconButton("textures/gift.png", 0.0f, 0.0f, 0.0f, null, null, 0.0f, 0.0f, false, 510, null);
        UIConstraints $this$initAvailable_u24lambda_u245 = iconButton.getConstraints();
        $this$initAvailable_u24lambda_u245.setX(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 8, true, true), initAvailable$lambda$4(activateButton$delegate)));
        $this$initAvailable_u24lambda_u245.setY(UtilitiesKt.dp$default((Number) 32, true, false, 2, (Object) null));
        $this$initAvailable_u24lambda_u245.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$initAvailable_u24lambda_u245.setHeight(UtilitiesKt.getDp((Number) 48));
        $this$initAvailable_u24lambda_u245.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getBlue()));
        ComponentsKt.childOf(iconButton.onMouseClick((v1, v2) -> {
            return initAvailable$lambda$6(r1, v1, v2);
        }), getContent());
    }

    private static final UIComponent initAvailable$lambda$4(ReadWriteProperty<Object, UIComponent> readWriteProperty) {
        return (UIComponent) readWriteProperty.getValue((Object) null, $$delegatedProperties[0]);
    }

    private static final Unit initAvailable$lambda$3(GroupData $this_initAvailable, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ComponentsKt.childOf(new ActivateGroupModal($this_initAvailable), Window.Companion.of($this$onMouseClick));
        return Unit.INSTANCE;
    }

    private static final Unit initAvailable$lambda$6(GroupData $this_initAvailable, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ComponentsKt.childOf(new GiftGroupModal($this_initAvailable, $this_initAvailable.getTime(), true), Window.Companion.of($this$onMouseClick));
        return Unit.INSTANCE;
    }
}
