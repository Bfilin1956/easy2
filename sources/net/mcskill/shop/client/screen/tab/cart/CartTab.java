package net.mcskill.shop.client.screen.tab.cart;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.ScrollComponent;
import gg.essential.elementa.components.image.ImageComponent;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.ColorConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.constraints.animation.AnimatingConstraints;
import gg.essential.elementa.constraints.animation.AnimationStrategy;
import gg.essential.elementa.constraints.animation.Animations;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
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
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.shop.client.screen.component.IconButton;
import net.mcskill.shop.client.screen.component.LabelAlign;
import net.mcskill.shop.client.screen.component.ScrollBar;
import net.mcskill.shop.client.screen.tab.TabContainer;
import net.mcskill.shop.common.response.shop.CaseData;
import net.mcskill.shop.common.response.shop.GroupData;
import net.mcskill.shop.common.response.shop.ItemData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CartTab.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/tab/cart/CartTab.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020'H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001b\u0010\u001cR!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b \u0010\u001cR!\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00198FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\r\u001a\u0004\b$\u0010\u001c¨\u0006*"}, d2 = {"Lnet/mcskill/shop/client/screen/tab/cart/CartTab;", "Lnet/mcskill/shop/client/screen/tab/TabContainer;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "buttonTab", "Lnet/mcskill/shop/client/screen/component/IconButton;", "getButtonTab", "()Lnet/mcskill/shop/client/screen/component/IconButton;", "buttonTab$delegate", "Lkotlin/properties/ReadWriteProperty;", "_contentView", "Lgg/essential/elementa/components/ScrollComponent;", "get_contentView", "()Lgg/essential/elementa/components/ScrollComponent;", "_contentView$delegate", "_verticalScrollBar", "Lnet/mcskill/shop/client/screen/component/ScrollBar;", "get_verticalScrollBar", "()Lnet/mcskill/shop/client/screen/component/ScrollBar;", "_verticalScrollBar$delegate", "items", "Lnet/mcskill/shop/client/screen/tab/cart/CartEntryContainer;", "Lnet/mcskill/shop/common/response/shop/ItemData;", "getItems", "()Lnet/mcskill/shop/client/screen/tab/cart/CartEntryContainer;", "items$delegate", "cases", "Lnet/mcskill/shop/common/response/shop/CaseData;", "getCases", "cases$delegate", "groups", "Lnet/mcskill/shop/common/response/shop/GroupData;", "getGroups", "groups$delegate", "select", "", "deselect", "Companion", "MSShop"})
@SourceDebugExtension({"SMAP\nCartTab.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CartTab.kt\nnet/mcskill/shop/client/screen/tab/cart/CartTab\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 animations.kt\ngg/essential/elementa/dsl/AnimationsKt\n*L\n1#1,98:1\n10#2,3:99\n10#2,3:102\n10#2,3:105\n10#3,3:108\n10#3,5:111\n13#3,2:116\n10#3,3:118\n10#3,5:121\n13#3,2:126\n*S KotlinDebug\n*F\n+ 1 CartTab.kt\nnet/mcskill/shop/client/screen/tab/cart/CartTab\n*L\n30#1:99,3\n41#1:102,3\n48#1:105,3\n68#1:108,3\n70#1:111,5\n68#1:116,2\n77#1:118,3\n79#1:121,5\n77#1:126,2\n*E\n"})
public final class CartTab extends TabContainer {

    @NotNull
    private final String name = UNIQUE_NAME;

    /* JADX INFO: renamed from: buttonTab$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty buttonTab;

    /* JADX INFO: renamed from: _contentView$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _contentView;

    /* JADX INFO: renamed from: _verticalScrollBar$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _verticalScrollBar;

    /* JADX INFO: renamed from: items$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty items;

    /* JADX INFO: renamed from: cases$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty cases;

    /* JADX INFO: renamed from: groups$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty groups;

    @NotNull
    public static final String UNIQUE_NAME = "Корзина";
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CartTab.class, "buttonTab", "getButtonTab()Lnet/mcskill/shop/client/screen/component/IconButton;", 0)), Reflection.property1(new PropertyReference1Impl(CartTab.class, "_contentView", "get_contentView()Lgg/essential/elementa/components/ScrollComponent;", 0)), Reflection.property1(new PropertyReference1Impl(CartTab.class, "_verticalScrollBar", "get_verticalScrollBar()Lnet/mcskill/shop/client/screen/component/ScrollBar;", 0)), Reflection.property1(new PropertyReference1Impl(CartTab.class, "items", "getItems()Lnet/mcskill/shop/client/screen/tab/cart/CartEntryContainer;", 0)), Reflection.property1(new PropertyReference1Impl(CartTab.class, "cases", "getCases()Lnet/mcskill/shop/client/screen/tab/cart/CartEntryContainer;", 0)), Reflection.property1(new PropertyReference1Impl(CartTab.class, "groups", "getGroups()Lnet/mcskill/shop/client/screen/tab/cart/CartEntryContainer;", 0))};

    public CartTab() {
        UIComponent $this$constrain$iv = new IconButton("textures/cart.png", 8.0f, 21.7f, 0.0f, LabelAlign.CENTER_Y, null, 0.0f, 0.0f, false, 232, null);
        UIConstraints $this$buttonTab_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$buttonTab_delegate_u24lambda_u240.setX(new SiblingConstraint(17.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$buttonTab_delegate_u24lambda_u240.setWidth(new ChildBasedSizeConstraint(1.0f, false, 2, (DefaultConstructorMarker) null));
        $this$buttonTab_delegate_u24lambda_u240.setHeight(new FillConstraint(false));
        $this$buttonTab_delegate_u24lambda_u240.setColor(UtilitiesKt.toConstraint(new Color(1.0f, 1.0f, 1.0f, 0.0f)));
        this.buttonTab = ComponentsKt.provideDelegate($this$constrain$iv, this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new ScrollComponent("Корзина пуста", 30.0f, 0.0f, (Color) null, false, false, false, false, 25.0f, 0.0f, (UIComponent) null, 1788, (DefaultConstructorMarker) null);
        UIConstraints $this$_contentView_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_contentView_delegate_u24lambda_u241.setX(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp((Number) 1)));
        $this$_contentView_delegate_u24lambda_u241.setY(UtilitiesKt.getDp((Number) 36));
        $this$_contentView_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 1216));
        $this$_contentView_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 632));
        this._contentView = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = new ScrollBar(4.0f, false, 2, null);
        UIConstraints $this$_verticalScrollBar_delegate_u24lambda_u242 = $this$constrain$iv3.getConstraints();
        $this$_verticalScrollBar_delegate_u24lambda_u242.setX(new SiblingConstraint(28.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_verticalScrollBar_delegate_u24lambda_u242.setY(UtilitiesKt.getDp((Number) 36));
        $this$_verticalScrollBar_delegate_u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 16));
        $this$_verticalScrollBar_delegate_u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 632));
        $this$_verticalScrollBar_delegate_u24lambda_u242.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getSidebar()));
        this._verticalScrollBar = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, (UIComponent) this), this, $$delegatedProperties[2]);
        this.items = ComponentsKt.provideDelegate(new CartEntryContainer(0, "Предметы:", get_contentView(), CartTab$items$2.INSTANCE), this, $$delegatedProperties[3]);
        this.cases = ComponentsKt.provideDelegate(new CartEntryContainer(1, "Кейсы:", get_contentView(), CartTab$cases$2.INSTANCE), this, $$delegatedProperties[4]);
        this.groups = ComponentsKt.provideDelegate(new CartEntryContainer(2, "Группы:", get_contentView(), CartTab$groups$2.INSTANCE), this, $$delegatedProperties[5]);
        get_verticalScrollBar().attachTo(get_contentView());
        mo90getButtonTab().onMouseClick((v1, v2) -> {
            return _init_$lambda$3(r1, v1, v2);
        }).onMouseEnter((v1) -> {
            return _init_$lambda$6(r1, v1);
        }).onMouseLeave((v1) -> {
            return _init_$lambda$9(r1, v1);
        });
    }

    @Override // net.mcskill.shop.client.screen.tab.TabContainer
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // net.mcskill.shop.client.screen.tab.TabContainer
    @NotNull
    /* JADX INFO: renamed from: getButtonTab, reason: merged with bridge method [inline-methods] */
    public IconButton mo90getButtonTab() {
        return (IconButton) this.buttonTab.getValue(this, $$delegatedProperties[0]);
    }

    private final ScrollComponent get_contentView() {
        return (ScrollComponent) this._contentView.getValue(this, $$delegatedProperties[1]);
    }

    private final ScrollBar get_verticalScrollBar() {
        return (ScrollBar) this._verticalScrollBar.getValue(this, $$delegatedProperties[2]);
    }

    @NotNull
    public final CartEntryContainer<ItemData> getItems() {
        return (CartEntryContainer) this.items.getValue(this, $$delegatedProperties[3]);
    }

    @NotNull
    public final CartEntryContainer<CaseData> getCases() {
        return (CartEntryContainer) this.cases.getValue(this, $$delegatedProperties[4]);
    }

    @NotNull
    public final CartEntryContainer<GroupData> getGroups() {
        return (CartEntryContainer) this.groups.getValue(this, $$delegatedProperties[5]);
    }

    private static final Unit _init_$lambda$3(CartTab this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        if (!this$0.isCurrent()) {
            this$0.select();
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$6(CartTab this$0, UIComponent $this$onMouseEnter) {
        Intrinsics.checkNotNullParameter($this$onMouseEnter, "$this$onMouseEnter");
        if (!this$0.isCurrent()) {
            AnimatingConstraints anim$iv = $this$onMouseEnter.makeAnimation();
            AnimatingConstraints.setColorAnimation$default(anim$iv, Animations.OUT_EXP, 0.5f, ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA1()), 0.0f, 8, (Object) null);
            UIComponent $this$animate$iv = this$0.mo90getButtonTab().getImage();
            AnimatingConstraints anim$iv2 = $this$animate$iv.makeAnimation();
            AnimatingConstraints.setColorAnimation$default(anim$iv2, Animations.OUT_EXP, 0.5f, ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()), 0.0f, 8, (Object) null);
            $this$animate$iv.animateTo(anim$iv2);
            $this$onMouseEnter.animateTo(anim$iv);
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$9(CartTab this$0, UIComponent $this$onMouseLeave) {
        Intrinsics.checkNotNullParameter($this$onMouseLeave, "$this$onMouseLeave");
        if (!this$0.isCurrent()) {
            AnimatingConstraints anim$iv = $this$onMouseLeave.makeAnimation();
            AnimatingConstraints.setColorAnimation$default(anim$iv, Animations.OUT_EXP, 0.5f, UtilitiesKt.toConstraint(new Color(255, 255, 255, 0)), 0.0f, 8, (Object) null);
            UIComponent $this$animate$iv = this$0.mo90getButtonTab().getImage();
            AnimatingConstraints anim$iv2 = $this$animate$iv.makeAnimation();
            AnimationStrategy animationStrategy = Animations.OUT_EXP;
            Color color = Color.WHITE;
            Intrinsics.checkNotNullExpressionValue(color, "WHITE");
            AnimatingConstraints.setColorAnimation$default(anim$iv2, animationStrategy, 0.5f, UtilitiesKt.toConstraint(color), 0.0f, 8, (Object) null);
            $this$animate$iv.animateTo(anim$iv2);
            $this$onMouseLeave.animateTo(anim$iv);
        }
        return Unit.INSTANCE;
    }

    @Override // net.mcskill.shop.client.screen.tab.TabContainer, net.mcskill.shop.client.screen.component.RadioGroup
    public void select() {
        super.select();
        mo90getButtonTab().setColor((ColorConstraint) ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA1()));
        mo90getButtonTab().getImage().setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
    }

    @Override // net.mcskill.shop.client.screen.tab.TabContainer, net.mcskill.shop.client.screen.component.RadioGroup
    public void deselect() {
        super.deselect();
        mo90getButtonTab().setColor((ColorConstraint) UtilitiesKt.toConstraint(new Color(255, 255, 255, 0)));
        ImageComponent image = mo90getButtonTab().getImage();
        Color color = Color.WHITE;
        Intrinsics.checkNotNullExpressionValue(color, "WHITE");
        image.setColor(UtilitiesKt.toConstraint(color));
    }
}
