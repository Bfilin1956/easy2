package net.mcskill.shop.client.screen.tab.cart;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.Window;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedMaxSizeConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.CramSiblingConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.constraints.image.ImageSourceConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.ScissorEffect;
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
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.core.common.util.TextFormatterKt;
import net.mcskill.core.common.util.TimeUtil;
import net.mcskill.shop.client.screen.component.EntryComponent;
import net.mcskill.shop.client.screen.component.IconButton;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.modal.group.ActivateGroupModal;
import net.mcskill.shop.client.screen.modal.group.CartGroupModal;
import net.mcskill.shop.client.screen.modal.group.GiftGroupModal;
import net.mcskill.shop.common.response.shop.GroupData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CartGroupEntry.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/tab/cart/CartGroupEntry.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0007X\u008a\u0084\u0002"}, d2 = {"Lnet/mcskill/shop/client/screen/tab/cart/CartGroupEntry;", "Lnet/mcskill/shop/client/screen/component/EntryComponent;", "group", "Lnet/mcskill/shop/common/response/shop/GroupData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/GroupData;)V", "_logoSection", "Lgg/essential/elementa/components/UIContainer;", "get_logoSection", "()Lgg/essential/elementa/components/UIContainer;", "_logoSection$delegate", "Lkotlin/properties/ReadWriteProperty;", "_logo", "Lgg/essential/elementa/components/UIImage;", "get_logo", "()Lgg/essential/elementa/components/UIImage;", "_logo$delegate", "Companion", "MSShop", "info", "Lgg/essential/elementa/components/LabelComponent;", "buttonGroup"})
@SourceDebugExtension({"SMAP\nCartGroupEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CartGroupEntry.kt\nnet/mcskill/shop/client/screen/tab/cart/CartGroupEntry\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,103:1\n10#2,3:104\n10#2,3:107\n10#2,3:110\n10#2,3:113\n10#2,3:116\n10#2,3:119\n10#2,3:122\n10#2,3:125\n*S KotlinDebug\n*F\n+ 1 CartGroupEntry.kt\nnet/mcskill/shop/client/screen/tab/cart/CartGroupEntry\n*L\n32#1:104,3\n39#1:107,3\n47#1:110,3\n54#1:113,3\n69#1:116,3\n76#1:119,3\n84#1:122,3\n93#1:125,3\n*E\n"})
public final class CartGroupEntry extends EntryComponent {

    /* JADX INFO: renamed from: _logoSection$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _logoSection;

    /* JADX INFO: renamed from: _logo$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _logo;

    @NotNull
    public static final String GROUPS_LINK = "https://mcskill.net/templates/shop/assets/images/groups/";
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CartGroupEntry.class, "_logoSection", "get_logoSection()Lgg/essential/elementa/components/UIContainer;", 0)), Reflection.property1(new PropertyReference1Impl(CartGroupEntry.class, "_logo", "get_logo()Lgg/essential/elementa/components/UIImage;", 0)), Reflection.property0(new PropertyReference0Impl(CartGroupEntry.class, "info", "<v#0>", 0)), Reflection.property0(new PropertyReference0Impl(CartGroupEntry.class, "buttonGroup", "<v#1>", 0))};

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CartGroupEntry(@NotNull GroupData group) {
        super(group.getPrettyName(), 0, 0.0f, 180, 18, 6, null);
        Intrinsics.checkNotNullParameter(group, "group");
        UIComponent $this$constrain$iv = new UIContainer();
        UIConstraints $this$_logoSection_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_logoSection_delegate_u24lambda_u240.setX(new CenterConstraint());
        $this$_logoSection_delegate_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 50));
        $this$_logoSection_delegate_u24lambda_u240.setWidth(UtilitiesKt.getPercent((Number) 96));
        $this$_logoSection_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 196));
        this._logoSection = ComponentsKt.provideDelegate(ComponentsKt.childOf(ComponentsKt.effect($this$constrain$iv, new ScissorEffect((UIComponent) null, false, 3, (DefaultConstructorMarker) null)), (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = UIImage.Companion.ofString("https://mcskill.net/templates/shop/assets/images/groups/" + group.getImage());
        UIConstraints $this$_logo_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_logo_delegate_u24lambda_u241.setX(new CenterConstraint());
        $this$_logo_delegate_u24lambda_u241.setY(new CenterConstraint());
        $this$_logo_delegate_u24lambda_u241.setWidth(new ImageSourceConstraint(1.0f));
        $this$_logo_delegate_u24lambda_u241.setHeight(new ImageSourceConstraint(1.0f));
        this._logo = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, get_logoSection()), this, $$delegatedProperties[1]);
        UIConstraints $this$_init__u24lambda_u242 = ((UIComponent) this).getConstraints();
        $this$_init__u24lambda_u242.setX(new CramSiblingConstraint(14.0f));
        $this$_init__u24lambda_u242.setY(new CramSiblingConstraint(14.0f));
        $this$_init__u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 228));
        $this$_init__u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 362));
        UIComponent $this$constrain$iv3 = new LabelComponent((String) null, false, (Color) null, 7, (DefaultConstructorMarker) null);
        UIConstraints $this$_init__u24lambda_u243 = $this$constrain$iv3.getConstraints();
        $this$_init__u24lambda_u243.setX(ConstraintsKt.boundTo(new CenterConstraint(), get_logo()));
        $this$_init__u24lambda_u243.setY(new SiblingConstraint(16.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u243.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_init__u24lambda_u243.setTextScale(UtilitiesKt.getDp((Number) 16));
        $this$_init__u24lambda_u243.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA5()));
        ReadWriteProperty info$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, (UIComponent) this), (Object) null, $$delegatedProperties[2]);
        if (group.getTime() == 0) {
            _init_$lambda$4(info$delegate).setText("§lНавсегда");
        } else {
            long days = ChronoUnit.DAYS.between(Instant.EPOCH, Instant.ofEpochSecond(group.getTime()));
            _init_$lambda$4(info$delegate).setText("§lНа " + TextFormatterKt.declension(days, TimeUtil.INSTANCE.getDayWords()));
            _init_$lambda$4(info$delegate).setColor((Color) MSPalette.INSTANCE.getOrange().get());
        }
        UIComponent $this$constrain$iv4 = new UIContainer();
        UIConstraints $this$_init__u24lambda_u245 = $this$constrain$iv4.getConstraints();
        $this$_init__u24lambda_u245.setX(new CenterConstraint());
        $this$_init__u24lambda_u245.setY(new SiblingConstraint(16.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u245.setWidth(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u245.setHeight(new ChildBasedMaxSizeConstraint());
        ReadWriteProperty buttonGroup$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, (UIComponent) this), (Object) null, $$delegatedProperties[3]);
        LabelButton labelButton = (UIComponent) new LabelButton("Активировать", 18, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$_init__u24lambda_u247 = labelButton.getConstraints();
        $this$_init__u24lambda_u247.setWidth(UtilitiesKt.getDp((Number) 148));
        $this$_init__u24lambda_u247.setHeight(UtilitiesKt.getDp((Number) 31));
        $this$_init__u24lambda_u247.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        ComponentsKt.childOf(labelButton.onMouseClick((v1, v2) -> {
            return _init_$lambda$8(r1, v1, v2);
        }), _init_$lambda$6(buttonGroup$delegate));
        IconButton iconButton = (UIComponent) new IconButton("textures/gift.png", 0.0f, 0.0f, 0.0f, null, null, 20.0f, 20.0f, false, 318, null);
        UIConstraints $this$_init__u24lambda_u249 = iconButton.getConstraints();
        $this$_init__u24lambda_u249.setX(new SiblingConstraint(4.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u249.setWidth(UtilitiesKt.getDp((Number) 31));
        $this$_init__u24lambda_u249.setHeight(UtilitiesKt.getDp((Number) 31));
        $this$_init__u24lambda_u249.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getBlue()));
        ComponentsKt.childOf(iconButton.onMouseClick((v1, v2) -> {
            return _init_$lambda$10(r1, v1, v2);
        }), _init_$lambda$6(buttonGroup$delegate));
        LabelComponent labelComponent = (UIComponent) new LabelComponent("§nПодробнее", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_init__u24lambda_u2411 = labelComponent.getConstraints();
        $this$_init__u24lambda_u2411.setX(new CenterConstraint());
        $this$_init__u24lambda_u2411.setY(new SiblingConstraint(10.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u2411.setColor(UtilitiesKt.toConstraint(new Color(255, 255, 255, 128)));
        $this$_init__u24lambda_u2411.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_init__u24lambda_u2411.setTextScale(UtilitiesKt.getDp((Number) 18));
        ComponentsKt.childOf(labelComponent.onMouseClick((v1, v2) -> {
            return _init_$lambda$12(r1, v1, v2);
        }), (UIComponent) this);
    }

    private final UIContainer get_logoSection() {
        return (UIContainer) this._logoSection.getValue(this, $$delegatedProperties[0]);
    }

    private final UIImage get_logo() {
        return (UIImage) this._logo.getValue(this, $$delegatedProperties[1]);
    }

    private static final LabelComponent _init_$lambda$4(ReadWriteProperty<Object, LabelComponent> readWriteProperty) {
        return (LabelComponent) readWriteProperty.getValue((Object) null, $$delegatedProperties[2]);
    }

    private static final UIContainer _init_$lambda$6(ReadWriteProperty<Object, UIContainer> readWriteProperty) {
        return (UIContainer) readWriteProperty.getValue((Object) null, $$delegatedProperties[3]);
    }

    private static final Unit _init_$lambda$8(GroupData $group, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ComponentsKt.childOf(new ActivateGroupModal($group), Window.Companion.of($this$onMouseClick));
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$10(GroupData $group, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ComponentsKt.childOf(new GiftGroupModal($group, $group.getTime(), true), Window.Companion.of($this$onMouseClick));
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$12(GroupData $group, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ComponentsKt.childOf(new CartGroupModal($group), Window.Companion.of($this$onMouseClick));
        return Unit.INSTANCE;
    }
}
