package net.mcskill.shop.client.screen.tab.items;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.ScrollComponent;
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
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.shop.client.MSShopClient;
import net.mcskill.shop.client.screen.component.LabelAlign;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.component.ScrollBar;
import net.mcskill.shop.client.screen.component.Updatable;
import net.mcskill.shop.client.screen.section.CategorySection;
import net.mcskill.shop.client.screen.section.SortSection;
import net.mcskill.shop.client.screen.tab.TabContainer;
import net.mcskill.shop.common.CurrencyType;
import net.mcskill.shop.common.response.shop.CategoryData;
import net.mcskill.shop.common.response.shop.ItemData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ItemsTab.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/tab/items/ItemsTab.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 @2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001@B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0003H\u0016J\u0016\u0010*\u001a\u00020'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030+H\u0016J\u0010\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020%H\u0016J\b\u0010.\u001a\u00020'H\u0016J\b\u0010/\u001a\u00020'H\u0016J\u0010\u00100\u001a\u0002012\u0006\u0010)\u001a\u000202H\u0002J\u0014\u00103\u001a\u00020%*\u0002042\u0006\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020'H\u0002J\u0010\u00108\u001a\u00020'2\u0006\u00109\u001a\u00020:H\u0002J \u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u000f\u001a\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lnet/mcskill/shop/client/screen/tab/items/ItemsTab;", "Lnet/mcskill/shop/client/screen/tab/TabContainer;", "Lnet/mcskill/shop/client/screen/component/Updatable;", "", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "buttonTab", "Lnet/mcskill/shop/client/screen/component/LabelButton;", "getButtonTab", "()Lnet/mcskill/shop/client/screen/component/LabelButton;", "buttonTab$delegate", "Lkotlin/properties/ReadWriteProperty;", "_categorySection", "Lnet/mcskill/shop/client/screen/section/CategorySection;", "get_categorySection", "()Lnet/mcskill/shop/client/screen/section/CategorySection;", "_categorySection$delegate", "_sortSection", "Lnet/mcskill/shop/client/screen/section/SortSection;", "get_sortSection", "()Lnet/mcskill/shop/client/screen/section/SortSection;", "_sortSection$delegate", "_contentView", "Lgg/essential/elementa/components/ScrollComponent;", "get_contentView", "()Lgg/essential/elementa/components/ScrollComponent;", "_contentView$delegate", "_verticalScrollBar", "Lnet/mcskill/shop/client/screen/component/ScrollBar;", "get_verticalScrollBar", "()Lnet/mcskill/shop/client/screen/component/ScrollBar;", "_verticalScrollBar$delegate", "hasKitCategory", "", "clear", "", "add", "data", "addAll", "", "closeContext", "instantly", "select", "deselect", "categoryOf", "Lgg/essential/elementa/UIComponent;", "Lnet/mcskill/shop/common/response/shop/CategoryData;", "hasPrice", "Lnet/mcskill/shop/common/response/shop/ItemData;", "currency", "Lnet/mcskill/shop/common/CurrencyType;", "filterContent", "sortElements", "index", "", "sortComponents", "id", "first", "Lnet/mcskill/shop/client/screen/tab/items/ItemEntry;", "second", "Companion", "MSShop"})
@SourceDebugExtension({"SMAP\nItemsTab.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ItemsTab.kt\nnet/mcskill/shop/client/screen/tab/items/ItemsTab\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 animations.kt\ngg/essential/elementa/dsl/AnimationsKt\n*L\n1#1,223:1\n10#2,3:224\n10#2,3:227\n10#2,3:230\n10#2,3:233\n10#2,3:236\n10#2,3:240\n1#3:239\n10#4,3:243\n10#4,5:246\n13#4,2:251\n10#4,3:253\n10#4,5:256\n13#4,2:261\n*S KotlinDebug\n*F\n+ 1 ItemsTab.kt\nnet/mcskill/shop/client/screen/tab/items/ItemsTab\n*L\n38#1:224,3\n45#1:227,3\n54#1:230,3\n66#1:233,3\n73#1:236,3\n175#1:240,3\n91#1:243,3\n93#1:246,5\n91#1:251,2\n100#1:253,3\n102#1:256,5\n100#1:261,2\n*E\n"})
public final class ItemsTab extends TabContainer implements Updatable<Object> {

    @NotNull
    private final String name = UNIQUE_NAME;

    /* JADX INFO: renamed from: buttonTab$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty buttonTab;

    /* JADX INFO: renamed from: _categorySection$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _categorySection;

    /* JADX INFO: renamed from: _sortSection$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _sortSection;

    /* JADX INFO: renamed from: _contentView$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _contentView;

    /* JADX INFO: renamed from: _verticalScrollBar$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _verticalScrollBar;
    private boolean hasKitCategory;

    @NotNull
    public static final String UNIQUE_NAME = "Предметы";
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ItemsTab.class, "buttonTab", "getButtonTab()Lnet/mcskill/shop/client/screen/component/LabelButton;", 0)), Reflection.property1(new PropertyReference1Impl(ItemsTab.class, "_categorySection", "get_categorySection()Lnet/mcskill/shop/client/screen/section/CategorySection;", 0)), Reflection.property1(new PropertyReference1Impl(ItemsTab.class, "_sortSection", "get_sortSection()Lnet/mcskill/shop/client/screen/section/SortSection;", 0)), Reflection.property1(new PropertyReference1Impl(ItemsTab.class, "_contentView", "get_contentView()Lgg/essential/elementa/components/ScrollComponent;", 0)), Reflection.property1(new PropertyReference1Impl(ItemsTab.class, "_verticalScrollBar", "get_verticalScrollBar()Lnet/mcskill/shop/client/screen/component/ScrollBar;", 0))};

    public ItemsTab() {
        UIComponent $this$constrain$iv = new LabelButton("§l" + getName(), 24, 8.0f, 26.0f, 0.0f, LabelAlign.CENTER_Y, null, false, 80, null);
        UIConstraints $this$buttonTab_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$buttonTab_delegate_u24lambda_u240.setX(new SiblingConstraint(17.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$buttonTab_delegate_u24lambda_u240.setWidth(new ChildBasedSizeConstraint(1.0f, false, 2, (DefaultConstructorMarker) null));
        $this$buttonTab_delegate_u24lambda_u240.setHeight(new FillConstraint(false));
        $this$buttonTab_delegate_u24lambda_u240.setColor(UtilitiesKt.toConstraint(new Color(1.0f, 1.0f, 1.0f, 0.0f)));
        this.buttonTab = ComponentsKt.provideDelegate($this$constrain$iv, this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new CategorySection(MSShopClient.INSTANCE.getEmeraldsPriority$MSShop() ? CurrencyType.EMERALD : CurrencyType.RUBLE);
        UIConstraints $this$_categorySection_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_categorySection_delegate_u24lambda_u241.setX(UtilitiesKt.getDp((Number) 101));
        $this$_categorySection_delegate_u24lambda_u241.setY(UtilitiesKt.getDp((Number) 36));
        $this$_categorySection_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 336));
        $this$_categorySection_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 632));
        $this$_categorySection_delegate_u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getSidebar()));
        this._categorySection = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = new SortSection(10.0f);
        UIConstraints $this$_sortSection_delegate_u24lambda_u242 = $this$constrain$iv3.getConstraints();
        $this$_sortSection_delegate_u24lambda_u242.setX(UtilitiesKt.getDp((Number) 479));
        $this$_sortSection_delegate_u24lambda_u242.setY(UtilitiesKt.getDp((Number) 36));
        $this$_sortSection_delegate_u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 840));
        $this$_sortSection_delegate_u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 48));
        $this$_sortSection_delegate_u24lambda_u242.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getSidebar()));
        this._sortSection = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, (UIComponent) this), this, $$delegatedProperties[2]);
        UIComponent $this$constrain$iv4 = new ScrollComponent("Список предметов пуст", 30.0f, 0.0f, (Color) null, false, false, false, false, 25.0f, 0.0f, (UIComponent) null, 1788, (DefaultConstructorMarker) null);
        UIConstraints $this$_contentView_delegate_u24lambda_u243 = $this$constrain$iv4.getConstraints();
        $this$_contentView_delegate_u24lambda_u243.setX(ConstraintsKt.boundTo(new DynamicPixelConstraint(0.0f, false, false, 6, (DefaultConstructorMarker) null), get_sortSection()));
        $this$_contentView_delegate_u24lambda_u243.setY(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 8, true, true), get_sortSection()));
        $this$_contentView_delegate_u24lambda_u243.setWidth(ConstraintsKt.plus(ConstraintsKt.boundTo(new FillConstraint(false), get_sortSection()), UtilitiesKt.getDp((Number) 27)));
        $this$_contentView_delegate_u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 577));
        this._contentView = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, (UIComponent) this), this, $$delegatedProperties[3]);
        UIComponent $this$constrain$iv5 = new ScrollBar(4.0f, false, 2, null);
        UIConstraints $this$_verticalScrollBar_delegate_u24lambda_u244 = $this$constrain$iv5.getConstraints();
        $this$_verticalScrollBar_delegate_u24lambda_u244.setX(ConstraintsKt.boundTo(new DynamicPixelConstraint(28.0f, true, true), get_sortSection()));
        $this$_verticalScrollBar_delegate_u24lambda_u244.setY(UtilitiesKt.getDp((Number) 36));
        $this$_verticalScrollBar_delegate_u24lambda_u244.setWidth(UtilitiesKt.getDp((Number) 16));
        $this$_verticalScrollBar_delegate_u24lambda_u244.setHeight(UtilitiesKt.getDp((Number) 633));
        $this$_verticalScrollBar_delegate_u24lambda_u244.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getSidebar()));
        this._verticalScrollBar = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv5, (UIComponent) this), this, $$delegatedProperties[4]);
        get_verticalScrollBar().attachTo(get_contentView());
        mo90getButtonTab().onMouseClick((v1, v2) -> {
            return _init_$lambda$5(r1, v1, v2);
        }).onMouseEnter((v1) -> {
            return _init_$lambda$8(r1, v1);
        }).onMouseLeave((v1) -> {
            return _init_$lambda$11(r1, v1);
        });
        get_categorySection().getCurrencyState().onSetValue((v1) -> {
            return _init_$lambda$12(r1, v1);
        });
        get_categorySection().getSearch().onUpdateTextInput((v1) -> {
            return _init_$lambda$14(r1, v1);
        });
        get_sortSection().getSortSelect().onSelection((v1, v2, v3) -> {
            return _init_$lambda$15(r1, v1, v2, v3);
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

    private final CategorySection get_categorySection() {
        return (CategorySection) this._categorySection.getValue(this, $$delegatedProperties[1]);
    }

    private final SortSection get_sortSection() {
        return (SortSection) this._sortSection.getValue(this, $$delegatedProperties[2]);
    }

    private final ScrollComponent get_contentView() {
        return (ScrollComponent) this._contentView.getValue(this, $$delegatedProperties[3]);
    }

    private final ScrollBar get_verticalScrollBar() {
        return (ScrollBar) this._verticalScrollBar.getValue(this, $$delegatedProperties[4]);
    }

    private static final Unit _init_$lambda$5(ItemsTab this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        if (!this$0.isCurrent()) {
            this$0.select();
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$8(ItemsTab this$0, UIComponent $this$onMouseEnter) {
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

    private static final Unit _init_$lambda$11(ItemsTab this$0, UIComponent $this$onMouseLeave) {
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

    private static final Unit _init_$lambda$12(ItemsTab this$0, CurrencyType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.filterContent();
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$14(ItemsTab this$0, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this$0.get_contentView().filterChildren((v2) -> {
            return lambda$14$lambda$13(r1, r2, v2);
        });
        return Unit.INSTANCE;
    }

    private static final boolean lambda$14$lambda$13(String $text, ItemsTab this$0, UIComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        ItemEntry itemEntry = component instanceof ItemEntry ? (ItemEntry) component : null;
        if (itemEntry == null) {
            return true;
        }
        ItemEntry itemEntry2 = itemEntry;
        return StringsKt.contains(itemEntry2.getName(), $text, true) && this$0.get_categorySection().selectedCategories(itemEntry2.getItem()) && this$0.hasPrice(itemEntry2.getItem(), this$0.get_categorySection().getCurrency());
    }

    private static final Unit _init_$lambda$15(ItemsTab this$0, UIComponent $this$onSelection, int index, String str) {
        Intrinsics.checkNotNullParameter($this$onSelection, "$this$onSelection");
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        this$0.sortElements(index);
        return Unit.INSTANCE;
    }

    @Override // net.mcskill.shop.client.screen.component.Updatable
    public void clear() {
        get_contentView().clearChildren();
    }

    @Override // net.mcskill.shop.client.screen.component.Updatable
    public void add(@NotNull Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof CategoryData)) {
            if (data instanceof ItemData) {
                ComponentsKt.childOf(new ItemEntry((ItemData) data, get_categorySection().getCurrencyState()), get_contentView());
                return;
            }
            return;
        }
        categoryOf((CategoryData) data);
    }

    @Override // net.mcskill.shop.client.screen.component.Updatable
    public void addAll(@NotNull List<? extends Object> data) {
        Object obj;
        Intrinsics.checkNotNullParameter(data, "data");
        Iterator it = CollectionsKt.filterIsInstance(data, ItemData.class).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            Object next = it.next();
            ItemData it2 = (ItemData) next;
            if (Intrinsics.areEqual(it2.getType(), "kit")) {
                obj = next;
                break;
            }
        }
        ItemData hasKit = (ItemData) obj;
        if (hasKit != null && !this.hasKitCategory) {
            categoryOf(new CategoryData(9999, true, "Наборы", -1));
            ScrollComponent.sortChildren$default(get_categorySection().getCategoriesView(), false, ItemsTab::addAll$lambda$17, 1, (Object) null);
            this.hasKitCategory = true;
        }
        super.addAll(data);
        get_contentView().filterChildren((v1) -> {
            return addAll$lambda$18(r1, v1);
        });
    }

    private static final int addAll$lambda$17(UIComponent child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return ((CategoryComponent) child).getCategory().getSort();
    }

    private static final boolean addAll$lambda$18(ItemsTab this$0, UIComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        ItemEntry itemEntry = (ItemEntry) component;
        return this$0.hasPrice(itemEntry.getItem(), this$0.get_categorySection().getCurrency());
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

    private final UIComponent categoryOf(CategoryData data) {
        CategoryComponent categoryComponent = (UIComponent) new CategoryComponent(data);
        UIConstraints $this$categoryOf_u24lambda_u2419 = categoryComponent.getConstraints();
        $this$categoryOf_u24lambda_u2419.setY(new SiblingConstraint(3.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$categoryOf_u24lambda_u2419.setWidth(UtilitiesKt.getPercent((Number) 100));
        $this$categoryOf_u24lambda_u2419.setHeight(UtilitiesKt.getDp((Number) 40));
        $this$categoryOf_u24lambda_u2419.setColor(UtilitiesKt.toConstraint(new Color(1.0f, 1.0f, 1.0f, 0.1f)));
        return ComponentsKt.childOf(categoryComponent.onMouseClick((v1, v2) -> {
            return categoryOf$lambda$20(r1, v1, v2);
        }), get_categorySection().getCategoriesView());
    }

    private static final Unit categoryOf$lambda$20(ItemsTab this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.filterContent();
        this$0.sortElements(((Number) this$0.get_sortSection().getSortSelect().getSelectedIndex().get()).intValue());
        return Unit.INSTANCE;
    }

    private final boolean hasPrice(ItemData $this$hasPrice, CurrencyType currency) {
        if (currency != CurrencyType.RUBLE || $this$hasPrice.getPriceRub() <= 0.0d) {
            return currency == CurrencyType.EMERALD && $this$hasPrice.getPriceEm() > 0.0d;
        }
        return true;
    }

    private final void filterContent() {
        get_contentView().filterChildren((v1) -> {
            return filterContent$lambda$21(r1, v1);
        });
    }

    private static final boolean filterContent$lambda$21(ItemsTab this$0, UIComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        String searchText = this$0.get_categorySection().getSearch().getText();
        ItemEntry itemEntry = (ItemEntry) component;
        boolean containsInSearch = searchText.length() > 0 ? StringsKt.contains(itemEntry.getName(), searchText, true) : true;
        return containsInSearch && this$0.get_categorySection().selectedCategories(itemEntry.getItem()) && this$0.hasPrice(itemEntry.getItem(), this$0.get_categorySection().getCurrency());
    }

    private final void sortElements(int index) {
        get_contentView().sortChildren((v2, v3) -> {
            return sortElements$lambda$22(r1, r2, v2, v3);
        });
    }

    private static final int sortElements$lambda$22(ItemsTab this$0, int $index, UIComponent first, UIComponent second) {
        Intrinsics.checkNotNull(first, "null cannot be cast to non-null type net.mcskill.shop.client.screen.tab.items.ItemEntry");
        Intrinsics.checkNotNull(second, "null cannot be cast to non-null type net.mcskill.shop.client.screen.tab.items.ItemEntry");
        return this$0.sortComponents($index, (ItemEntry) first, (ItemEntry) second);
    }

    private final int sortComponents(int id, ItemEntry first, ItemEntry second) {
        switch (id) {
            case 0:
                return Intrinsics.compare(first.getItem().getSort(), second.getItem().getSort());
            case 1:
                return first.getItem().getName().compareTo(second.getItem().getName());
            case 2:
                if (get_categorySection().getCurrency() == CurrencyType.RUBLE) {
                    return Double.compare(first.getItem().getPriceRub(), second.getItem().getPriceRub());
                }
                return Double.compare(first.getItem().getPriceEm(), second.getItem().getPriceEm());
            case 3:
                if (get_categorySection().getCurrency() == CurrencyType.RUBLE) {
                    return Double.compare(second.getItem().getPriceRub(), first.getItem().getPriceRub());
                }
                return Double.compare(second.getItem().getPriceEm(), first.getItem().getPriceEm());
            default:
                return -1;
        }
    }
}
