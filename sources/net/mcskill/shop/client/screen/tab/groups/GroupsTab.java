package net.mcskill.shop.client.screen.tab.groups;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.ScrollComponent;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.ColorConstraint;
import gg.essential.elementa.constraints.DynamicPixelConstraint;
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
import net.mcskill.shop.client.screen.component.LabelAlign;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.component.ScrollBar;
import net.mcskill.shop.client.screen.component.Updatable;
import net.mcskill.shop.client.screen.section.SortSection;
import net.mcskill.shop.client.screen.tab.TabContainer;
import net.mcskill.shop.common.response.shop.GroupData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GroupsTab.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/tab/groups/GroupsTab.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 .2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001.B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020 H\u0016J\b\u0010$\u001a\u00020 H\u0016J\b\u0010%\u001a\u00020 H\u0016J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0003H\u0016J \u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001c\u0010\u001d¨\u0006/"}, d2 = {"Lnet/mcskill/shop/client/screen/tab/groups/GroupsTab;", "Lnet/mcskill/shop/client/screen/tab/TabContainer;", "Lnet/mcskill/shop/client/screen/component/Updatable;", "Lnet/mcskill/shop/common/response/shop/GroupData;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "buttonTab", "Lnet/mcskill/shop/client/screen/component/LabelButton;", "getButtonTab", "()Lnet/mcskill/shop/client/screen/component/LabelButton;", "buttonTab$delegate", "Lkotlin/properties/ReadWriteProperty;", "_sortSection", "Lnet/mcskill/shop/client/screen/section/SortSection;", "get_sortSection", "()Lnet/mcskill/shop/client/screen/section/SortSection;", "_sortSection$delegate", "_contentView", "Lgg/essential/elementa/components/ScrollComponent;", "get_contentView", "()Lgg/essential/elementa/components/ScrollComponent;", "_contentView$delegate", "_verticalScrollBar", "Lnet/mcskill/shop/client/screen/component/ScrollBar;", "get_verticalScrollBar", "()Lnet/mcskill/shop/client/screen/component/ScrollBar;", "_verticalScrollBar$delegate", "closeContext", "", "instantly", "", "select", "deselect", "clear", "add", "data", "sortComponents", "", "id", "first", "Lnet/mcskill/shop/client/screen/tab/groups/GroupEntry;", "second", "Companion", "MSShop"})
@SourceDebugExtension({"SMAP\nGroupsTab.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GroupsTab.kt\nnet/mcskill/shop/client/screen/tab/groups/GroupsTab\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 animations.kt\ngg/essential/elementa/dsl/AnimationsKt\n*L\n1#1,130:1\n10#2,3:131\n10#2,3:134\n10#2,3:137\n10#2,3:140\n10#3,3:143\n10#3,5:146\n13#3,2:151\n10#3,3:153\n10#3,5:156\n13#3,2:161\n*S KotlinDebug\n*F\n+ 1 GroupsTab.kt\nnet/mcskill/shop/client/screen/tab/groups/GroupsTab\n*L\n31#1:131,3\n38#1:134,3\n50#1:137,3\n57#1:140,3\n73#1:143,3\n75#1:146,5\n73#1:151,2\n82#1:153,3\n84#1:156,5\n82#1:161,2\n*E\n"})
public final class GroupsTab extends TabContainer implements Updatable<GroupData> {

    @NotNull
    private final String name = UNIQUE_NAME;

    /* JADX INFO: renamed from: buttonTab$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty buttonTab;

    /* JADX INFO: renamed from: _sortSection$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _sortSection;

    /* JADX INFO: renamed from: _contentView$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _contentView;

    /* JADX INFO: renamed from: _verticalScrollBar$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _verticalScrollBar;

    @NotNull
    public static final String UNIQUE_NAME = "Привилегии";
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(GroupsTab.class, "buttonTab", "getButtonTab()Lnet/mcskill/shop/client/screen/component/LabelButton;", 0)), Reflection.property1(new PropertyReference1Impl(GroupsTab.class, "_sortSection", "get_sortSection()Lnet/mcskill/shop/client/screen/section/SortSection;", 0)), Reflection.property1(new PropertyReference1Impl(GroupsTab.class, "_contentView", "get_contentView()Lgg/essential/elementa/components/ScrollComponent;", 0)), Reflection.property1(new PropertyReference1Impl(GroupsTab.class, "_verticalScrollBar", "get_verticalScrollBar()Lnet/mcskill/shop/client/screen/component/ScrollBar;", 0))};

    public GroupsTab() {
        UIComponent $this$constrain$iv = new LabelButton("§l" + getName(), 24, 8.0f, 26.0f, 0.0f, LabelAlign.CENTER_Y, null, false, 80, null);
        UIConstraints $this$buttonTab_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$buttonTab_delegate_u24lambda_u240.setWidth(new ChildBasedSizeConstraint(1.0f, false, 2, (DefaultConstructorMarker) null));
        $this$buttonTab_delegate_u24lambda_u240.setHeight(new FillConstraint(false));
        $this$buttonTab_delegate_u24lambda_u240.setColor(UtilitiesKt.toConstraint(new Color(1.0f, 1.0f, 1.0f, 0.0f)));
        this.buttonTab = ComponentsKt.provideDelegate($this$constrain$iv, this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new SortSection(10.0f);
        UIConstraints $this$_sortSection_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_sortSection_delegate_u24lambda_u241.setX(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp((Number) 1)));
        $this$_sortSection_delegate_u24lambda_u241.setY(UtilitiesKt.getDp((Number) 36));
        $this$_sortSection_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 1216));
        $this$_sortSection_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 48));
        $this$_sortSection_delegate_u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getSidebar()));
        this._sortSection = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = new ScrollComponent("Список привилегий пуст", 30.0f, 0.0f, (Color) null, false, false, false, false, 25.0f, 0.0f, (UIComponent) null, 1788, (DefaultConstructorMarker) null);
        UIConstraints $this$_contentView_delegate_u24lambda_u242 = $this$constrain$iv3.getConstraints();
        $this$_contentView_delegate_u24lambda_u242.setX(ConstraintsKt.boundTo(new DynamicPixelConstraint(0.0f, false, false, 6, (DefaultConstructorMarker) null), get_sortSection()));
        $this$_contentView_delegate_u24lambda_u242.setY(new SiblingConstraint(8.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_contentView_delegate_u24lambda_u242.setWidth(ConstraintsKt.plus(ConstraintsKt.boundTo(new FillConstraint(false), get_sortSection()), UtilitiesKt.getDp((Number) 27)));
        $this$_contentView_delegate_u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 575));
        this._contentView = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, (UIComponent) this), this, $$delegatedProperties[2]);
        UIComponent $this$constrain$iv4 = new ScrollBar(4.0f, false, 2, null);
        UIConstraints $this$_verticalScrollBar_delegate_u24lambda_u243 = $this$constrain$iv4.getConstraints();
        $this$_verticalScrollBar_delegate_u24lambda_u243.setX(ConstraintsKt.boundTo(new DynamicPixelConstraint(28.0f, true, true), get_sortSection()));
        $this$_verticalScrollBar_delegate_u24lambda_u243.setY(UtilitiesKt.getDp((Number) 36));
        $this$_verticalScrollBar_delegate_u24lambda_u243.setWidth(UtilitiesKt.getDp((Number) 16));
        $this$_verticalScrollBar_delegate_u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 632));
        $this$_verticalScrollBar_delegate_u24lambda_u243.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getSidebar()));
        this._verticalScrollBar = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, (UIComponent) this), this, $$delegatedProperties[3]);
        get_verticalScrollBar().attachTo(get_contentView());
        mo90getButtonTab().onMouseClick((v1, v2) -> {
            return _init_$lambda$4(r1, v1, v2);
        }).onMouseEnter((v1) -> {
            return _init_$lambda$7(r1, v1);
        }).onMouseLeave((v1) -> {
            return _init_$lambda$10(r1, v1);
        });
        get_sortSection().getSortSelect().onSelection((v1, v2, v3) -> {
            return _init_$lambda$12(r1, v1, v2, v3);
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
    public LabelButton mo90getButtonTab() {
        return (LabelButton) this.buttonTab.getValue(this, $$delegatedProperties[0]);
    }

    private final SortSection get_sortSection() {
        return (SortSection) this._sortSection.getValue(this, $$delegatedProperties[1]);
    }

    private final ScrollComponent get_contentView() {
        return (ScrollComponent) this._contentView.getValue(this, $$delegatedProperties[2]);
    }

    private final ScrollBar get_verticalScrollBar() {
        return (ScrollBar) this._verticalScrollBar.getValue(this, $$delegatedProperties[3]);
    }

    private static final Unit _init_$lambda$4(GroupsTab this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        if (!this$0.isCurrent()) {
            this$0.select();
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$7(GroupsTab this$0, UIComponent $this$onMouseEnter) {
        Intrinsics.checkNotNullParameter($this$onMouseEnter, "$this$onMouseEnter");
        if (!this$0.isCurrent()) {
            AnimatingConstraints anim$iv = $this$onMouseEnter.makeAnimation();
            AnimatingConstraints.setColorAnimation$default(anim$iv, Animations.OUT_EXP, 0.5f, ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA1()), 0.0f, 8, (Object) null);
            UIComponent $this$animate$iv = this$0.mo90getButtonTab().getLabel();
            AnimatingConstraints anim$iv2 = $this$animate$iv.makeAnimation();
            AnimatingConstraints.setColorAnimation$default(anim$iv2, Animations.OUT_EXP, 0.5f, ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()), 0.0f, 8, (Object) null);
            $this$animate$iv.animateTo(anim$iv2);
            $this$onMouseEnter.animateTo(anim$iv);
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$10(GroupsTab this$0, UIComponent $this$onMouseLeave) {
        Intrinsics.checkNotNullParameter($this$onMouseLeave, "$this$onMouseLeave");
        if (!this$0.isCurrent()) {
            AnimatingConstraints anim$iv = $this$onMouseLeave.makeAnimation();
            AnimatingConstraints.setColorAnimation$default(anim$iv, Animations.OUT_EXP, 0.5f, UtilitiesKt.toConstraint(new Color(255, 255, 255, 0)), 0.0f, 8, (Object) null);
            UIComponent $this$animate$iv = this$0.mo90getButtonTab().getLabel();
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

    private static final Unit _init_$lambda$12(GroupsTab this$0, UIComponent $this$onSelection, int index, String str) {
        Intrinsics.checkNotNullParameter($this$onSelection, "$this$onSelection");
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        this$0.get_contentView().sortChildren((v2, v3) -> {
            return lambda$12$lambda$11(r1, r2, v2, v3);
        });
        return Unit.INSTANCE;
    }

    private static final int lambda$12$lambda$11(GroupsTab this$0, int $index, UIComponent first, UIComponent second) {
        Intrinsics.checkNotNull(first, "null cannot be cast to non-null type net.mcskill.shop.client.screen.tab.groups.GroupEntry");
        Intrinsics.checkNotNull(second, "null cannot be cast to non-null type net.mcskill.shop.client.screen.tab.groups.GroupEntry");
        return this$0.sortComponents($index, (GroupEntry) first, (GroupEntry) second);
    }

    @Override // net.mcskill.shop.client.screen.tab.TabContainer, net.mcskill.shop.client.screen.component.Context
    public void closeContext(boolean instantly) {
        super.closeContext(instantly);
        get_sortSection().getSortSelect().collapse(instantly);
    }

    @Override // net.mcskill.shop.client.screen.tab.TabContainer, net.mcskill.shop.client.screen.component.RadioGroup
    public void select() {
        super.select();
        mo90getButtonTab().setColor((ColorConstraint) ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA1()));
        mo90getButtonTab().getLabel().setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
    }

    @Override // net.mcskill.shop.client.screen.tab.TabContainer, net.mcskill.shop.client.screen.component.RadioGroup
    public void deselect() {
        super.deselect();
        mo90getButtonTab().setColor((ColorConstraint) UtilitiesKt.toConstraint(new Color(255, 255, 255, 0)));
        LabelComponent label = mo90getButtonTab().getLabel();
        Color color = Color.WHITE;
        Intrinsics.checkNotNullExpressionValue(color, "WHITE");
        label.setColor(UtilitiesKt.toConstraint(color));
    }

    @Override // net.mcskill.shop.client.screen.component.Updatable
    public void clear() {
        get_contentView().clearChildren();
    }

    @Override // net.mcskill.shop.client.screen.component.Updatable
    public void add(@NotNull GroupData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ComponentsKt.childOf(new GroupEntry(data), get_contentView());
    }

    private final int sortComponents(int id, GroupEntry first, GroupEntry second) {
        switch (id) {
            case 0:
                return Intrinsics.compare(first.getGroup().getSort(), second.getGroup().getSort());
            case 1:
                return first.getGroup().getName().compareTo(second.getGroup().getName());
            case 2:
                return Intrinsics.compare(first.getGroup().getPricePerm(), second.getGroup().getPricePerm());
            case 3:
                return Intrinsics.compare(second.getGroup().getPricePerm(), first.getGroup().getPricePerm());
            default:
                return -1;
        }
    }
}
