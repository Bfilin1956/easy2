package net.mcskill.shop.client.screen;

import gg.essential.elementa.ElementaVersion;
import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.components.Window;
import gg.essential.elementa.components.image.ImageComponent;
import gg.essential.elementa.components.inspector.Inspector;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedMaxSizeConstraint;
import gg.essential.elementa.constraints.ChildBasedRangeConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.constraints.HeightConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.constraints.animation.AnimatingConstraints;
import gg.essential.elementa.constraints.animation.AnimationStrategy;
import gg.essential.elementa.constraints.animation.Animations;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.ScissorEffect;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.utils.ObservableList;
import gg.essential.universal.UScreen;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.core.client.screen.ScaledScreen;
import net.mcskill.core.client.screen.component.MSRoundedRectangle;
import net.mcskill.core.common.util.DevUtils;
import net.mcskill.shop.client.screen.component.Context;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.component.TabGroup;
import net.mcskill.shop.client.screen.component.Updatable;
import net.mcskill.shop.client.screen.modal.cases.component.GuarantInfoBlock;
import net.mcskill.shop.client.screen.modal.cases.impl.PreviewCaseModal;
import net.mcskill.shop.client.screen.modal.money.BalanceModal;
import net.mcskill.shop.client.screen.modal.money.ReplenishModal;
import net.mcskill.shop.client.screen.notification.Notifications;
import net.mcskill.shop.client.screen.notification.ShopNotification;
import net.mcskill.shop.client.screen.section.AccountSection;
import net.mcskill.shop.client.screen.section.LogoSection;
import net.mcskill.shop.client.screen.tab.TabContainer;
import net.mcskill.shop.client.screen.tab.cart.CartTab;
import net.mcskill.shop.client.screen.tab.cases.CasesTab;
import net.mcskill.shop.client.screen.tab.groups.GroupsTab;
import net.mcskill.shop.client.screen.tab.items.ItemsTab;
import net.mcskill.shop.common.network.ChannelHandler;
import net.mcskill.shop.common.network.ListType;
import net.mcskill.shop.common.network.PacketHandleable;
import net.mcskill.shop.common.network.packet.RequestShopDataPacket;
import net.mcskill.shop.common.network.packet.sync.ResponseBalancePacket;
import net.mcskill.shop.common.network.packet.sync.ResponseCategoriesPacket;
import net.mcskill.shop.common.response.Notifiable;
import net.mcskill.shop.common.response.shop.CaseData;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ShopScreen.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/ShopScreen.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 X2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001XB\u0013\b\u0007\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u0003H\u0016J&\u0010G\u001a\b\u0012\u0004\u0012\u0002HI0H\"\u0004\b\u0000\u0010I*\u00020)2\f\u0010J\u001a\b\u0012\u0004\u0012\u0002HI0KH\u0002J\u001e\u0010L\u001a\u00020E2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020N0H2\u0006\u0010O\u001a\u00020PH\u0016J \u0010Q\u001a\u00020E2\b\u0010R\u001a\u0004\u0018\u00010)2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020T0HH\u0002J\b\u0010U\u001a\u00020EH\u0016J&\u0010V\u001a\u00020E\"\u0004\b\u0000\u0010I*\b\u0012\u0004\u0012\u0002HI0W2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HI0HH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u000e\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000e\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u000e\u001a\u0004\b.\u0010+R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u000e\u001a\u0004\b2\u00103R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u000e\u001a\u0004\b7\u00108R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u000e\u001a\u0004\b<\u0010=R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u000e\u001a\u0004\bA\u0010B¨\u0006Y"}, d2 = {"Lnet/mcskill/shop/client/screen/ShopScreen;", "Lnet/mcskill/core/client/screen/ScaledScreen;", "Lnet/mcskill/shop/common/network/PacketHandleable;", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "Lnet/mcskill/shop/common/response/Notifiable;", "selection", "Lnet/mcskill/shop/client/screen/SelectionType;", "<init>", "(Lnet/mcskill/shop/client/screen/SelectionType;)V", "_background", "Lgg/essential/elementa/components/UIRoundedRectangle;", "get_background", "()Lgg/essential/elementa/components/UIRoundedRectangle;", "_background$delegate", "Lkotlin/properties/ReadWriteProperty;", "notificationSection", "Lgg/essential/elementa/components/UIContainer;", "getNotificationSection", "()Lgg/essential/elementa/components/UIContainer;", "notificationSection$delegate", "_header", "Lnet/mcskill/core/client/screen/component/MSRoundedRectangle;", "get_header", "()Lnet/mcskill/core/client/screen/component/MSRoundedRectangle;", "_header$delegate", "_logoContainer", "Lnet/mcskill/shop/client/screen/section/LogoSection;", "get_logoContainer", "()Lnet/mcskill/shop/client/screen/section/LogoSection;", "_logoContainer$delegate", "_navigation", "Lnet/mcskill/shop/client/screen/component/TabGroup;", "get_navigation", "()Lnet/mcskill/shop/client/screen/component/TabGroup;", "_navigation$delegate", "_account", "Lnet/mcskill/shop/client/screen/section/AccountSection;", "get_account", "()Lnet/mcskill/shop/client/screen/section/AccountSection;", "_account$delegate", "_exchangeButton", "Lgg/essential/elementa/UIComponent;", "get_exchangeButton", "()Lgg/essential/elementa/UIComponent;", "_exchangeButton$delegate", "_closeButton", "get_closeButton", "_closeButton$delegate", "_groupsTab", "Lnet/mcskill/shop/client/screen/tab/groups/GroupsTab;", "get_groupsTab", "()Lnet/mcskill/shop/client/screen/tab/groups/GroupsTab;", "_groupsTab$delegate", "_casesTab", "Lnet/mcskill/shop/client/screen/tab/cases/CasesTab;", "get_casesTab", "()Lnet/mcskill/shop/client/screen/tab/cases/CasesTab;", "_casesTab$delegate", "_itemsTab", "Lnet/mcskill/shop/client/screen/tab/items/ItemsTab;", "get_itemsTab", "()Lnet/mcskill/shop/client/screen/tab/items/ItemsTab;", "_itemsTab$delegate", "_cartTab", "Lnet/mcskill/shop/client/screen/tab/cart/CartTab;", "get_cartTab", "()Lnet/mcskill/shop/client/screen/tab/cart/CartTab;", "_cartTab$delegate", "handlePacket", "", "packet", "children", "", "T", "clazz", "Ljava/lang/Class;", "updateList", "list", "", "type", "Lnet/mcskill/shop/common/network/ListType;", "updateGuarantData", "casePreview", "caseData", "Lnet/mcskill/shop/common/response/shop/CaseData;", "onScreenClose", "fillOf", "Lnet/mcskill/shop/client/screen/component/Updatable;", "Companion", "MSShop"})
@SourceDebugExtension({"SMAP\nShopScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShopScreen.kt\nnet/mcskill/shop/client/screen/ShopScreen\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 animations.kt\ngg/essential/elementa/dsl/AnimationsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 UIComponent.kt\ngg/essential/elementa/UIComponent\n*L\n1#1,264:1\n10#2,3:265\n10#2,3:273\n10#2,3:276\n10#2,3:279\n10#2,3:282\n10#2,3:285\n10#2,3:288\n10#2,3:291\n10#2,3:295\n10#2,3:299\n10#3,5:268\n10#3,5:313\n10#3,5:318\n13409#4:294\n13410#4:298\n1557#5:302\n1628#5,3:303\n295#5,2:306\n295#5,2:308\n295#5,2:310\n263#6:312\n*S KotlinDebug\n*F\n+ 1 ShopScreen.kt\nnet/mcskill/shop/client/screen/ShopScreen\n*L\n78#1:265,3\n88#1:273,3\n96#1:276,3\n103#1:279,3\n111#1:282,3\n119#1:285,3\n127#1:288,3\n141#1:291,3\n178#1:295,3\n191#1:299,3\n84#1:268,5\n168#1:313,5\n172#1:318,5\n177#1:294\n177#1:298\n211#1:302\n211#1:303,3\n212#1:306,2\n237#1:308,2\n248#1:310,2\n134#1:312\n*E\n"})
public final class ShopScreen extends ScaledScreen implements PacketHandleable<CustomPacketPayload>, Notifiable {

    @NotNull
    private SelectionType selection;

    /* JADX INFO: renamed from: _background$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _background;

    /* JADX INFO: renamed from: notificationSection$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty notificationSection;

    /* JADX INFO: renamed from: _header$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _header;

    /* JADX INFO: renamed from: _logoContainer$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _logoContainer;

    /* JADX INFO: renamed from: _navigation$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _navigation;

    /* JADX INFO: renamed from: _account$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _account;

    /* JADX INFO: renamed from: _exchangeButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _exchangeButton;

    /* JADX INFO: renamed from: _closeButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _closeButton;

    /* JADX INFO: renamed from: _groupsTab$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _groupsTab;

    /* JADX INFO: renamed from: _casesTab$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _casesTab;

    /* JADX INFO: renamed from: _itemsTab$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _itemsTab;

    /* JADX INFO: renamed from: _cartTab$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _cartTab;
    public static final float LAYOUT_WIDTH = 1420.0f;
    public static final float LAYOUT_HEIGHT = 800.0f;

    @NotNull
    public static final String MC_SKILL = "§lMcSkill";

    @NotNull
    public static final String MC_SKILL_LINK = "https://mcskill.net/";

    @NotNull
    public static final String PAY_LINK = "https://mcskill.net/pay";

    @NotNull
    public static final String GROUP_IMG_DIR = "https://assets.mcskill.net/groups/%s.png";

    @NotNull
    public static final String MC_SKILL_LOGO = "textures/mcskill-logo.png";
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ShopScreen.class, "_background", "get_background()Lgg/essential/elementa/components/UIRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(ShopScreen.class, "notificationSection", "getNotificationSection()Lgg/essential/elementa/components/UIContainer;", 0)), Reflection.property1(new PropertyReference1Impl(ShopScreen.class, "_header", "get_header()Lnet/mcskill/core/client/screen/component/MSRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(ShopScreen.class, "_logoContainer", "get_logoContainer()Lnet/mcskill/shop/client/screen/section/LogoSection;", 0)), Reflection.property1(new PropertyReference1Impl(ShopScreen.class, "_navigation", "get_navigation()Lnet/mcskill/shop/client/screen/component/TabGroup;", 0)), Reflection.property1(new PropertyReference1Impl(ShopScreen.class, "_account", "get_account()Lnet/mcskill/shop/client/screen/section/AccountSection;", 0)), Reflection.property1(new PropertyReference1Impl(ShopScreen.class, "_exchangeButton", "get_exchangeButton()Lgg/essential/elementa/UIComponent;", 0)), Reflection.property1(new PropertyReference1Impl(ShopScreen.class, "_closeButton", "get_closeButton()Lgg/essential/elementa/UIComponent;", 0)), Reflection.property1(new PropertyReference1Impl(ShopScreen.class, "_groupsTab", "get_groupsTab()Lnet/mcskill/shop/client/screen/tab/groups/GroupsTab;", 0)), Reflection.property1(new PropertyReference1Impl(ShopScreen.class, "_casesTab", "get_casesTab()Lnet/mcskill/shop/client/screen/tab/cases/CasesTab;", 0)), Reflection.property1(new PropertyReference1Impl(ShopScreen.class, "_itemsTab", "get_itemsTab()Lnet/mcskill/shop/client/screen/tab/items/ItemsTab;", 0)), Reflection.property1(new PropertyReference1Impl(ShopScreen.class, "_cartTab", "get_cartTab()Lnet/mcskill/shop/client/screen/tab/cart/CartTab;", 0))};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: ShopScreen.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/ShopScreen$WhenMappings.class */
    @Metadata(mv = {2, 0, 0}, k = 3, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ListType.values().length];
            try {
                iArr[ListType.CASE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ListType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ListType.ITEM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ListType.CART_CASE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ListType.CART_GROUP.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[ListType.CART_ITEM.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ ShopScreen(SelectionType selectionType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SelectionType.ITEMS : selectionType);
    }

    /* JADX INFO: compiled from: ShopScreen.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/ShopScreen$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lnet/mcskill/shop/client/screen/ShopScreen$Companion;", "", "<init>", "()V", "LAYOUT_WIDTH", "", "LAYOUT_HEIGHT", "MC_SKILL", "", "MC_SKILL_LINK", "PAY_LINK", "GROUP_IMG_DIR", "MC_SKILL_LOGO", "openWith", "", "type", "Lnet/mcskill/shop/client/screen/SelectionType;", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void openWith$default(Companion companion, SelectionType selectionType, int i, Object obj) {
            if ((i & 1) != 0) {
                selectionType = SelectionType.ITEMS;
            }
            companion.openWith(selectionType);
        }

        @JvmStatic
        @JvmOverloads
        public final void openWith(@NotNull SelectionType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            UScreen.Companion.displayScreen(new ShopScreen(type));
        }

        @JvmStatic
        @JvmOverloads
        public final void openWith() {
            openWith$default(this, null, 1, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShopScreen(@NotNull SelectionType selection) {
        super(0.0f, (ElementaVersion) null, false, false, false, 0, 63, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(selection, "selection");
        this.selection = selection;
        UIComponent $this$constrain$iv = new UIRoundedRectangle(16.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$_background_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_background_delegate_u24lambda_u240.setX(new CenterConstraint());
        $this$_background_delegate_u24lambda_u240.setY(UtilitiesKt.getDp(Float.valueOf(-800.0f)));
        $this$_background_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp(Float.valueOf(1420.0f)));
        $this$_background_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp(Float.valueOf(800.0f)));
        $this$_background_delegate_u24lambda_u240.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getBackground()));
        UIComponent $this$animate$iv = ComponentsKt.childOf($this$constrain$iv, getWindow());
        AnimatingConstraints anim$iv = $this$animate$iv.makeAnimation();
        AnimatingConstraints.setYAnimation$default(anim$iv, Animations.OUT_EXP, 0.25f, new CenterConstraint(), 0.0f, 8, (Object) null);
        $this$animate$iv.animateTo(anim$iv);
        this._background = ComponentsKt.provideDelegate($this$animate$iv, this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new UIContainer();
        UIConstraints $this$notificationSection_delegate_u24lambda_u242 = $this$constrain$iv2.getConstraints();
        $this$notificationSection_delegate_u24lambda_u242.setX(ConstraintsKt.boundTo(UtilitiesKt.dp$default((Number) 0, true, false, 2, (Object) null), get_background()));
        $this$notificationSection_delegate_u24lambda_u242.setY(ConstraintsKt.boundTo(UtilitiesKt.getDp((Number) 100), get_background()));
        $this$notificationSection_delegate_u24lambda_u242.setWidth(new ChildBasedMaxSizeConstraint());
        $this$notificationSection_delegate_u24lambda_u242.setHeight(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null));
        this.notificationSection = ComponentsKt.provideDelegate(ComponentsKt.childOf(ComponentsKt.effect($this$constrain$iv2, new ScissorEffect((UIComponent) null, false, 3, (DefaultConstructorMarker) null)), getWindow()), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = new MSRoundedRectangle(false, false, 3, (DefaultConstructorMarker) null);
        UIConstraints $this$_header_delegate_u24lambda_u243 = $this$constrain$iv3.getConstraints();
        $this$_header_delegate_u24lambda_u243.setWidth(new FillConstraint(false));
        $this$_header_delegate_u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 100));
        $this$_header_delegate_u24lambda_u243.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getTitleBar()));
        $this$_header_delegate_u24lambda_u243.setRadius(UtilitiesKt.getDp((Number) 22));
        this._header = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, get_background()), this, $$delegatedProperties[2]);
        UIComponent $this$constrain$iv4 = new LogoSection(MC_SKILL_LOGO, MC_SKILL, MC_SKILL_LINK);
        UIConstraints $this$_logoContainer_delegate_u24lambda_u244 = $this$constrain$iv4.getConstraints();
        $this$_logoContainer_delegate_u24lambda_u244.setX(UtilitiesKt.getDp((Number) 36));
        $this$_logoContainer_delegate_u24lambda_u244.setY(new CenterConstraint());
        $this$_logoContainer_delegate_u24lambda_u244.setWidth(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null));
        $this$_logoContainer_delegate_u24lambda_u244.setHeight(UtilitiesKt.getDp((Number) 52));
        this._logoContainer = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, get_header()), this, $$delegatedProperties[3]);
        UIComponent $this$constrain$iv5 = new TabGroup();
        UIConstraints $this$_navigation_delegate_u24lambda_u245 = $this$constrain$iv5.getConstraints();
        $this$_navigation_delegate_u24lambda_u245.setX(UtilitiesKt.getDp((Number) 256));
        $this$_navigation_delegate_u24lambda_u245.setY(new CenterConstraint());
        $this$_navigation_delegate_u24lambda_u245.setWidth(new ChildBasedSizeConstraint(1.0f, false, 2, (DefaultConstructorMarker) null));
        $this$_navigation_delegate_u24lambda_u245.setHeight(UtilitiesKt.getDp((Number) 43));
        this._navigation = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv5, get_header()), this, $$delegatedProperties[4]);
        UIComponent $this$constrain$iv6 = new AccountSection();
        UIConstraints $this$_account_delegate_u24lambda_u246 = $this$constrain$iv6.getConstraints();
        $this$_account_delegate_u24lambda_u246.setX(UtilitiesKt.getDp((Number) 936));
        $this$_account_delegate_u24lambda_u246.setY(new CenterConstraint());
        $this$_account_delegate_u24lambda_u246.setWidth(new ChildBasedRangeConstraint());
        $this$_account_delegate_u24lambda_u246.setHeight(UtilitiesKt.getDp((Number) 52));
        this._account = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv6, get_header()), this, $$delegatedProperties[5]);
        LabelButton labelButton = (UIComponent) new LabelButton("§lПополнить", 24, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$_exchangeButton_delegate_u24lambda_u247 = labelButton.getConstraints();
        $this$_exchangeButton_delegate_u24lambda_u247.setX(UtilitiesKt.getDp((Number) 1168));
        $this$_exchangeButton_delegate_u24lambda_u247.setY(new CenterConstraint());
        $this$_exchangeButton_delegate_u24lambda_u247.setWidth(UtilitiesKt.getDp((Number) 176));
        $this$_exchangeButton_delegate_u24lambda_u247.setHeight(UtilitiesKt.getDp((Number) 48));
        $this$_exchangeButton_delegate_u24lambda_u247.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this._exchangeButton = ComponentsKt.provideDelegate(ComponentsKt.childOf(labelButton.onMouseClick((v1, v2) -> {
            return _exchangeButton_delegate$lambda$8(r2, v1, v2);
        }), get_header()), this, $$delegatedProperties[6]);
        ImageComponent imageComponent = (UIComponent) new ImageComponent(States.INSTANCE.getCloseIcon(), (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_closeButton_delegate_u24lambda_u249 = imageComponent.getConstraints();
        $this$_closeButton_delegate_u24lambda_u249.setX(UtilitiesKt.getDp(Double.valueOf(1375.22d)));
        $this$_closeButton_delegate_u24lambda_u249.setY(UtilitiesKt.getDp(Double.valueOf(23.21d)));
        $this$_closeButton_delegate_u24lambda_u249.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$_closeButton_delegate_u24lambda_u249.setHeight(UtilitiesKt.getDp(Double.valueOf(17.58d)));
        this._closeButton = ComponentsKt.provideDelegate(ComponentsKt.childOf(imageComponent.onMouseClick(ShopScreen::_closeButton_delegate$lambda$10), get_header()), this, $$delegatedProperties[7]);
        this._groupsTab = ComponentsKt.provideDelegate(new GroupsTab(), this, $$delegatedProperties[8]);
        this._casesTab = ComponentsKt.provideDelegate(new CasesTab(), this, $$delegatedProperties[9]);
        this._itemsTab = ComponentsKt.provideDelegate(new ItemsTab(), this, $$delegatedProperties[10]);
        this._cartTab = ComponentsKt.provideDelegate(new CartTab(), this, $$delegatedProperties[11]);
        if (this.selection == SelectionType.NONE) {
            throw new IllegalArgumentException("Тип выбора вкладки не может быть NONE!");
        }
        mo10getNotificationSection().setFloating(true);
        ChannelHandler.INSTANCE.sendToServer(RequestShopDataPacket.INSTANCE);
        getWindow().onMouseClick((v1, v2) -> {
            return _init_$lambda$11(r1, v1, v2);
        });
        get_closeButton().onMouseEnter(ShopScreen::_init_$lambda$13).onMouseLeave(ShopScreen::_init_$lambda$15);
        for (UIComponent uIComponent : new TabContainer[]{get_groupsTab(), get_casesTab(), get_itemsTab(), get_cartTab()}) {
            UIComponent $this$constrain$iv7 = uIComponent;
            UIConstraints $this$lambda_u2417_u24lambda_u2416 = $this$constrain$iv7.getConstraints();
            $this$lambda_u2417_u24lambda_u2416.setY(ConstraintsKt.boundTo(new SiblingConstraint(0.0f, false, false, 7, (DefaultConstructorMarker) null), get_header()));
            $this$lambda_u2417_u24lambda_u2416.setWidth(new FillConstraint(false));
            $this$lambda_u2417_u24lambda_u2416.setHeight(new FillConstraint(false));
            ComponentsKt.childOf($this$constrain$iv7, get_background());
            if (Intrinsics.areEqual(this.selection.getTab(), uIComponent.getName())) {
                get_navigation().attachCurrent(uIComponent);
            } else {
                get_navigation().attachTab(uIComponent);
            }
        }
        if (!DevUtils.INSTANCE.isDevEnvironment()) {
            return;
        }
        UIComponent $this$constrain$iv8 = new Inspector(getWindow(), (Color) null, (Color) null, 0.0f, (HeightConstraint) null, 30, (DefaultConstructorMarker) null);
        UIConstraints $this$_init__u24lambda_u2418 = $this$constrain$iv8.getConstraints();
        $this$_init__u24lambda_u2418.setX(UtilitiesKt.pixels$default((Number) 10, true, false, 2, (Object) null));
        $this$_init__u24lambda_u2418.setY(UtilitiesKt.pixels$default((Number) 10, true, false, 2, (Object) null));
        ComponentsKt.childOf($this$constrain$iv8, getWindow());
    }

    @JvmOverloads
    public ShopScreen() {
        this(null, 1, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void openWith(@NotNull SelectionType type) {
        INSTANCE.openWith(type);
    }

    @JvmStatic
    @JvmOverloads
    public static final void openWith() {
        INSTANCE.openWith();
    }

    private final UIRoundedRectangle get_background() {
        return (UIRoundedRectangle) this._background.getValue(this, $$delegatedProperties[0]);
    }

    @Override // net.mcskill.shop.common.response.Notifiable
    @NotNull
    /* JADX INFO: renamed from: getNotificationSection, reason: merged with bridge method [inline-methods] */
    public UIContainer mo10getNotificationSection() {
        return (UIContainer) this.notificationSection.getValue(this, $$delegatedProperties[1]);
    }

    private final MSRoundedRectangle get_header() {
        return (MSRoundedRectangle) this._header.getValue(this, $$delegatedProperties[2]);
    }

    private final LogoSection get_logoContainer() {
        return (LogoSection) this._logoContainer.getValue(this, $$delegatedProperties[3]);
    }

    private final TabGroup get_navigation() {
        return (TabGroup) this._navigation.getValue(this, $$delegatedProperties[4]);
    }

    private final AccountSection get_account() {
        return (AccountSection) this._account.getValue(this, $$delegatedProperties[5]);
    }

    private final UIComponent get_exchangeButton() {
        return (UIComponent) this._exchangeButton.getValue(this, $$delegatedProperties[6]);
    }

    private static final Unit _exchangeButton_delegate$lambda$8(ShopScreen this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        UIComponent this_$iv = this$0.getWindow();
        if (this_$iv.childrenOfType(BalanceModal.class).isEmpty()) {
            ComponentsKt.childOf(new ReplenishModal(), this$0.getWindow());
        } else {
            Notifications.push$default(Notifications.INSTANCE, "Слишком много окон пополнения, зачем Вам столько?", ShopNotification.Status.ERROR, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }

    private final UIComponent get_closeButton() {
        return (UIComponent) this._closeButton.getValue(this, $$delegatedProperties[7]);
    }

    private static final Unit _closeButton_delegate$lambda$10(UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        UScreen.Companion.displayScreen((Screen) null);
        return Unit.INSTANCE;
    }

    private final GroupsTab get_groupsTab() {
        return (GroupsTab) this._groupsTab.getValue(this, $$delegatedProperties[8]);
    }

    private final CasesTab get_casesTab() {
        return (CasesTab) this._casesTab.getValue(this, $$delegatedProperties[9]);
    }

    private final ItemsTab get_itemsTab() {
        return (ItemsTab) this._itemsTab.getValue(this, $$delegatedProperties[10]);
    }

    private final CartTab get_cartTab() {
        return (CartTab) this._cartTab.getValue(this, $$delegatedProperties[11]);
    }

    private static final Unit _init_$lambda$11(ShopScreen this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        Context.closeContext$default(this$0.get_navigation(), false, 1, null);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$13(UIComponent $this$onMouseEnter) {
        Intrinsics.checkNotNullParameter($this$onMouseEnter, "$this$onMouseEnter");
        AnimatingConstraints anim$iv = $this$onMouseEnter.makeAnimation();
        AnimatingConstraints.setColorAnimation$default(anim$iv, Animations.OUT_EXP, 0.5f, ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()), 0.0f, 8, (Object) null);
        $this$onMouseEnter.animateTo(anim$iv);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$15(UIComponent $this$onMouseLeave) {
        Intrinsics.checkNotNullParameter($this$onMouseLeave, "$this$onMouseLeave");
        AnimatingConstraints anim$iv = $this$onMouseLeave.makeAnimation();
        AnimationStrategy animationStrategy = Animations.OUT_EXP;
        Color color = Color.WHITE;
        Intrinsics.checkNotNullExpressionValue(color, "WHITE");
        AnimatingConstraints.setColorAnimation$default(anim$iv, animationStrategy, 0.5f, UtilitiesKt.toConstraint(color), 0.0f, 8, (Object) null);
        $this$onMouseLeave.animateTo(anim$iv);
        return Unit.INSTANCE;
    }

    @Override // net.mcskill.shop.common.network.PacketHandleable
    public void handlePacket(@NotNull CustomPacketPayload packet) {
        Intrinsics.checkNotNullParameter(packet, "packet");
        if (packet instanceof ResponseCategoriesPacket) {
            get_itemsTab().addAll(((ResponseCategoriesPacket) packet).getCategories());
        } else if (packet instanceof ResponseBalancePacket) {
            get_account().getSkillCoinsState().set(Integer.valueOf(((ResponseBalancePacket) packet).getSkillCoins()));
            get_account().getEmeraldsState().set(Integer.valueOf(((ResponseBalancePacket) packet).getEmeralds()));
        }
    }

    private final <T> List<T> children(UIComponent $this$children, Class<T> cls) {
        Object obj;
        List<T> listChildrenOfType = $this$children.childrenOfType(cls);
        if (listChildrenOfType.isEmpty()) {
            Iterable $this$map$iv = $this$children.getChildren();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                UIComponent it = (UIComponent) item$iv$iv;
                Intrinsics.checkNotNull(it);
                destination$iv$iv.add(children(it, cls));
            }
            Iterable $this$firstOrNull$iv = (List) destination$iv$iv;
            Iterator<T> it2 = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it2.hasNext()) {
                    Object element$iv = it2.next();
                    if (!((List) element$iv).isEmpty()) {
                        obj = element$iv;
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            List<T> list = (List) obj;
            if (list != null) {
                return list;
            }
            return CollectionsKt.emptyList();
        }
        return listChildrenOfType;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    @Override // net.mcskill.shop.common.network.PacketHandleable
    public void updateList(@NotNull List<? extends Object> list, @NotNull ListType type) throws NoWhenBranchMatchedException {
        UIComponent uIComponent;
        Iterable children;
        Object obj;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(type, "type");
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                fillOf(get_casesTab(), list);
                return;
            case 2:
                fillOf(get_groupsTab(), list);
                return;
            case 3:
                fillOf(get_itemsTab(), list);
                return;
            case 4:
                if (this.selection == SelectionType.CASES) {
                    if (!list.isEmpty()) {
                        String name = get_cartTab().getName();
                        TabContainer currentTab = get_navigation().getCurrentTab();
                        if (!Intrinsics.areEqual(name, currentTab != null ? currentTab.getName() : null)) {
                            get_cartTab().select();
                            get_navigation().selectTab(get_cartTab().getName());
                        }
                        this.selection = SelectionType.NONE;
                    }
                }
                fillOf(get_cartTab().getCases(), list);
                Window windowOfOrNull = Window.Companion.ofOrNull(get_cartTab());
                if (windowOfOrNull == null || (children = windowOfOrNull.getChildren()) == null) {
                    uIComponent = null;
                } else {
                    Iterable $this$firstOrNull$iv = children;
                    Iterator it = $this$firstOrNull$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv = it.next();
                            UIComponent it2 = (UIComponent) element$iv;
                            if (it2 instanceof PreviewCaseModal) {
                                obj = element$iv;
                            }
                        } else {
                            obj = null;
                        }
                    }
                    uIComponent = (UIComponent) obj;
                }
                UIComponent casePreview = uIComponent;
                updateGuarantData(casePreview, list);
                return;
            case 5:
                fillOf(get_cartTab().getGroups(), list);
                return;
            case 6:
                fillOf(get_cartTab().getItems(), list);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002a  */
    private final void updateGuarantData(UIComponent casePreview, List<CaseData> caseData) {
        GuarantInfoBlock guarantInfoBlock;
        Object obj;
        if (casePreview != null) {
            ObservableList children = casePreview.getChildren();
            if (children != null) {
                UIComponent uIComponent = (UIComponent) children.get(1);
                if (uIComponent != null) {
                    List listChildrenOfType = uIComponent.childrenOfType(GuarantInfoBlock.class);
                    if (listChildrenOfType != null) {
                        guarantInfoBlock = (GuarantInfoBlock) CollectionsKt.firstOrNull(listChildrenOfType);
                    } else {
                        guarantInfoBlock = null;
                    }
                } else {
                    guarantInfoBlock = null;
                }
            } else {
                guarantInfoBlock = null;
            }
        } else {
            guarantInfoBlock = null;
        }
        GuarantInfoBlock guarantInfoBlock2 = guarantInfoBlock;
        if (guarantInfoBlock2 != null) {
            List<CaseData> $this$firstOrNull$iv = caseData;
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                Object element$iv = it.next();
                if (((CaseData) element$iv).getId() == guarantInfoBlock2.get_case().getId()) {
                    obj = element$iv;
                    break;
                }
            }
            CaseData it2 = (CaseData) obj;
            if (it2 != null) {
                guarantInfoBlock2.updateFirstGuarantProgress(it2.getGuarantyFirstProgress(), it2.getGuarantyFirstLimit());
                guarantInfoBlock2.updateSecondGuarantProgress(it2.getGuarantySecondProgress(), it2.getGuarantySecondLimit());
            }
        }
    }

    public void onScreenClose() {
        super.onScreenClose();
        Notifications.INSTANCE.clear();
    }

    private final <T> void fillOf(Updatable<T> updatable, List<? extends T> list) {
        updatable.clear();
        updatable.addAll(list);
    }
}
