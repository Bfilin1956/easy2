package net.mcskill.shop.client.screen.section;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.ScrollComponent;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.components.image.ImageComponent;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.RoundOutlineEffect;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.state.State;
import gg.essential.elementa.utils.ResourcesKt;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import net.mcskill.shop.client.screen.component.ScrollBar;
import net.mcskill.shop.client.screen.component.input.SearchInput;
import net.mcskill.shop.client.screen.tab.items.CategoryComponent;
import net.mcskill.shop.common.CurrencyType;
import net.mcskill.shop.common.response.shop.ItemData;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CategorySection.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/section/CategorySection.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u00106\u001a\u0002072\u0006\u00108\u001a\u000209R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0005R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b\"\u0010\u001aR\u001b\u0010$\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0017\u001a\u0004\b%\u0010\u001fR\u001b\u0010'\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0017\u001a\u0004\b)\u0010*R\u001b\u0010,\u001a\u00020-8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\u0017\u001a\u0004\b.\u0010/R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0017\u001a\u0004\b3\u00104¨\u0006:"}, d2 = {"Lnet/mcskill/shop/client/screen/section/CategorySection;", "Lgg/essential/elementa/components/UIRoundedRectangle;", "currencyType", "Lnet/mcskill/shop/common/CurrencyType;", "<init>", "(Lnet/mcskill/shop/common/CurrencyType;)V", "_outlineSkillCoins", "Lgg/essential/elementa/effects/RoundOutlineEffect;", "_outlineEmeralds", "currencyState", "Lgg/essential/elementa/state/State;", "getCurrencyState", "()Lgg/essential/elementa/state/State;", "value", "currency", "getCurrency", "()Lnet/mcskill/shop/common/CurrencyType;", "setCurrency", "search", "Lnet/mcskill/shop/client/screen/component/input/SearchInput;", "getSearch", "()Lnet/mcskill/shop/client/screen/component/input/SearchInput;", "search$delegate", "Lkotlin/properties/ReadWriteProperty;", "_skillCoinsBlock", "get_skillCoinsBlock", "()Lgg/essential/elementa/components/UIRoundedRectangle;", "_skillCoinsBlock$delegate", "_skillCoinIcon", "Lgg/essential/elementa/components/image/ImageComponent;", "get_skillCoinIcon", "()Lgg/essential/elementa/components/image/ImageComponent;", "_skillCoinIcon$delegate", "_emeraldsBlock", "get_emeraldsBlock", "_emeraldsBlock$delegate", "_emeraldIcon", "get_emeraldIcon", "_emeraldIcon$delegate", "_categoryTitle", "Lgg/essential/elementa/components/LabelComponent;", "get_categoryTitle", "()Lgg/essential/elementa/components/LabelComponent;", "_categoryTitle$delegate", "categoriesView", "Lgg/essential/elementa/components/ScrollComponent;", "getCategoriesView", "()Lgg/essential/elementa/components/ScrollComponent;", "categoriesView$delegate", "_verticalScrollBar", "Lnet/mcskill/shop/client/screen/component/ScrollBar;", "get_verticalScrollBar", "()Lnet/mcskill/shop/client/screen/component/ScrollBar;", "_verticalScrollBar$delegate", "selectedCategories", "", "item", "Lnet/mcskill/shop/common/response/shop/ItemData;", "MSShop"})
@SourceDebugExtension({"SMAP\nCategorySection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CategorySection.kt\nnet/mcskill/shop/client/screen/section/CategorySection\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 UIComponent.kt\ngg/essential/elementa/UIComponent\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,135:1\n10#2,3:136\n10#2,3:139\n10#2,3:142\n10#2,3:145\n10#2,3:148\n10#2,3:151\n10#2,3:154\n10#2,3:157\n263#3:160\n774#4:161\n865#4,2:162\n1755#4,3:164\n*S KotlinDebug\n*F\n+ 1 CategorySection.kt\nnet/mcskill/shop/client/screen/section/CategorySection\n*L\n34#1:136,3\n41#1:139,3\n49#1:142,3\n56#1:145,3\n64#1:148,3\n71#1:151,3\n81#1:154,3\n90#1:157,3\n128#1:160\n129#1:161\n129#1:162,2\n133#1:164,3\n*E\n"})
public final class CategorySection extends UIRoundedRectangle {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CategorySection.class, "search", "getSearch()Lnet/mcskill/shop/client/screen/component/input/SearchInput;", 0)), Reflection.property1(new PropertyReference1Impl(CategorySection.class, "_skillCoinsBlock", "get_skillCoinsBlock()Lgg/essential/elementa/components/UIRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(CategorySection.class, "_skillCoinIcon", "get_skillCoinIcon()Lgg/essential/elementa/components/image/ImageComponent;", 0)), Reflection.property1(new PropertyReference1Impl(CategorySection.class, "_emeraldsBlock", "get_emeraldsBlock()Lgg/essential/elementa/components/UIRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(CategorySection.class, "_emeraldIcon", "get_emeraldIcon()Lgg/essential/elementa/components/image/ImageComponent;", 0)), Reflection.property1(new PropertyReference1Impl(CategorySection.class, "_categoryTitle", "get_categoryTitle()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(CategorySection.class, "categoriesView", "getCategoriesView()Lgg/essential/elementa/components/ScrollComponent;", 0)), Reflection.property1(new PropertyReference1Impl(CategorySection.class, "_verticalScrollBar", "get_verticalScrollBar()Lnet/mcskill/shop/client/screen/component/ScrollBar;", 0))};

    @NotNull
    private final RoundOutlineEffect _outlineSkillCoins;

    @NotNull
    private final RoundOutlineEffect _outlineEmeralds;

    @NotNull
    private final State<CurrencyType> currencyState;

    /* JADX INFO: renamed from: search$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty search;

    /* JADX INFO: renamed from: _skillCoinsBlock$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _skillCoinsBlock;

    /* JADX INFO: renamed from: _skillCoinIcon$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _skillCoinIcon;

    /* JADX INFO: renamed from: _emeraldsBlock$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _emeraldsBlock;

    /* JADX INFO: renamed from: _emeraldIcon$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _emeraldIcon;

    /* JADX INFO: renamed from: _categoryTitle$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _categoryTitle;

    /* JADX INFO: renamed from: categoriesView$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty categoriesView;

    /* JADX INFO: renamed from: _verticalScrollBar$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _verticalScrollBar;

    public CategorySection() {
        this(null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategorySection(@NotNull CurrencyType currencyType) {
        super(10.0f, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(currencyType, "currencyType");
        this._outlineSkillCoins = new RoundOutlineEffect((Color) MSPalette.INSTANCE.getOrange().get(), 4.0f, 1.5f, 0.7f, false, 16, (DefaultConstructorMarker) null);
        this._outlineEmeralds = new RoundOutlineEffect((Color) MSPalette.INSTANCE.getWhiteA4().get(), 4.0f, 1.5f, 0.7f, false, 16, (DefaultConstructorMarker) null);
        this.currencyState = new BasicState<>(CurrencyType.RUBLE);
        UIComponent $this$constrain$iv = new SearchInput("Поиск");
        UIConstraints $this$search_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$search_delegate_u24lambda_u240.setX(UtilitiesKt.getDp((Number) 13));
        $this$search_delegate_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 15));
        $this$search_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp((Number) 208));
        $this$search_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 44));
        this.search = ComponentsKt.provideDelegate(ComponentsKt.childOf(ComponentsKt.effect($this$constrain$iv, new RoundOutlineEffect((Color) MSPalette.INSTANCE.getWhiteA4().get(), 4.0f, 1.5f, 0.7f, false, 16, (DefaultConstructorMarker) null)), (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new UIRoundedRectangle(4.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$_skillCoinsBlock_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_skillCoinsBlock_delegate_u24lambda_u241.setX(UtilitiesKt.getDp((Number) 227));
        $this$_skillCoinsBlock_delegate_u24lambda_u241.setY(UtilitiesKt.getDp((Number) 15));
        $this$_skillCoinsBlock_delegate_u24lambda_u241.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$_skillCoinsBlock_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 44));
        $this$_skillCoinsBlock_delegate_u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getSidebar()));
        this._skillCoinsBlock = ComponentsKt.provideDelegate(ComponentsKt.childOf(ComponentsKt.effect($this$constrain$iv2, this._outlineSkillCoins), (UIComponent) this), this, $$delegatedProperties[1]);
        ResourceLocation resourceLocationAsResource$default = ResourcesKt.asResource$default("textures/ruble_32x32.png", (String) null, 1, (Object) null);
        Intrinsics.checkNotNullExpressionValue(resourceLocationAsResource$default, "asResource$default(...)");
        UIComponent $this$constrain$iv3 = new ImageComponent(resourceLocationAsResource$default, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_skillCoinIcon_delegate_u24lambda_u242 = $this$constrain$iv3.getConstraints();
        $this$_skillCoinIcon_delegate_u24lambda_u242.setX(new CenterConstraint());
        $this$_skillCoinIcon_delegate_u24lambda_u242.setY(new CenterConstraint());
        $this$_skillCoinIcon_delegate_u24lambda_u242.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$_skillCoinIcon_delegate_u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 32));
        this._skillCoinIcon = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, get_skillCoinsBlock()), this, $$delegatedProperties[2]);
        UIComponent $this$constrain$iv4 = new UIRoundedRectangle(4.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$_emeraldsBlock_delegate_u24lambda_u243 = $this$constrain$iv4.getConstraints();
        $this$_emeraldsBlock_delegate_u24lambda_u243.setX(UtilitiesKt.getDp((Number) 277));
        $this$_emeraldsBlock_delegate_u24lambda_u243.setY(UtilitiesKt.getDp((Number) 15));
        $this$_emeraldsBlock_delegate_u24lambda_u243.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$_emeraldsBlock_delegate_u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 44));
        $this$_emeraldsBlock_delegate_u24lambda_u243.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getSidebar()));
        this._emeraldsBlock = ComponentsKt.provideDelegate(ComponentsKt.childOf(ComponentsKt.effect($this$constrain$iv4, this._outlineEmeralds), (UIComponent) this), this, $$delegatedProperties[3]);
        ResourceLocation resourceLocationAsResource$default2 = ResourcesKt.asResource$default("textures/emerald_32x32.png", (String) null, 1, (Object) null);
        Intrinsics.checkNotNullExpressionValue(resourceLocationAsResource$default2, "asResource$default(...)");
        UIComponent $this$constrain$iv5 = new ImageComponent(resourceLocationAsResource$default2, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_emeraldIcon_delegate_u24lambda_u244 = $this$constrain$iv5.getConstraints();
        $this$_emeraldIcon_delegate_u24lambda_u244.setX(new CenterConstraint());
        $this$_emeraldIcon_delegate_u24lambda_u244.setY(new CenterConstraint());
        $this$_emeraldIcon_delegate_u24lambda_u244.setWidth(new FillConstraint(false, 1, (DefaultConstructorMarker) null));
        $this$_emeraldIcon_delegate_u24lambda_u244.setHeight(new FillConstraint(false, 1, (DefaultConstructorMarker) null));
        this._emeraldIcon = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv5, get_emeraldsBlock()), this, $$delegatedProperties[4]);
        UIComponent $this$constrain$iv6 = new LabelComponent("§lВыберите категорию", false, (Color) null, 4, (DefaultConstructorMarker) null);
        UIConstraints $this$_categoryTitle_delegate_u24lambda_u245 = $this$constrain$iv6.getConstraints();
        $this$_categoryTitle_delegate_u24lambda_u245.setX(UtilitiesKt.getDp((Number) 13));
        $this$_categoryTitle_delegate_u24lambda_u245.setY(UtilitiesKt.getDp((Number) 76));
        $this$_categoryTitle_delegate_u24lambda_u245.setTextScale(UtilitiesKt.getDp((Number) 24));
        $this$_categoryTitle_delegate_u24lambda_u245.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        this._categoryTitle = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv6, (UIComponent) this), this, $$delegatedProperties[5]);
        UIComponent $this$constrain$iv7 = new ScrollComponent("Категории не найдены", 22.0f, 0.0f, (Color) null, false, false, false, false, 25.0f, 0.0f, (UIComponent) null, 1788, (DefaultConstructorMarker) null);
        UIConstraints $this$categoriesView_delegate_u24lambda_u246 = $this$constrain$iv7.getConstraints();
        $this$categoriesView_delegate_u24lambda_u246.setX(UtilitiesKt.getDp((Number) 12));
        $this$categoriesView_delegate_u24lambda_u246.setY(UtilitiesKt.getDp((Number) 107));
        $this$categoriesView_delegate_u24lambda_u246.setWidth(ConstraintsKt.minus(new FillConstraint(false), UtilitiesKt.getDp((Number) 44)));
        $this$categoriesView_delegate_u24lambda_u246.setHeight(UtilitiesKt.getPercent((Number) 80));
        $this$categoriesView_delegate_u24lambda_u246.setTextScale(UtilitiesKt.getDp((Number) 28));
        $this$categoriesView_delegate_u24lambda_u246.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        this.categoriesView = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv7, (UIComponent) this), this, $$delegatedProperties[6]);
        UIComponent $this$constrain$iv8 = new ScrollBar(4.0f, false, 2, null);
        UIConstraints $this$_verticalScrollBar_delegate_u24lambda_u247 = $this$constrain$iv8.getConstraints();
        $this$_verticalScrollBar_delegate_u24lambda_u247.setX(UtilitiesKt.getPercent(Double.valueOf(91.08d)));
        ConstraintsKt.boundTo($this$_verticalScrollBar_delegate_u24lambda_u247.getY(), getCategoriesView());
        $this$_verticalScrollBar_delegate_u24lambda_u247.setWidth(UtilitiesKt.getDp((Number) 16));
        $this$_verticalScrollBar_delegate_u24lambda_u247.setHeight(ConstraintsKt.boundTo(UtilitiesKt.getPercent((Number) 100), getCategoriesView()));
        $this$_verticalScrollBar_delegate_u24lambda_u247.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getSidebar()));
        this._verticalScrollBar = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv8, (UIComponent) this), this, $$delegatedProperties[7]);
        setCurrency(currencyType);
        if (getCurrency() == CurrencyType.RUBLE) {
            this._outlineEmeralds.setColor(MSPalette.INSTANCE.getWhiteA4());
            this._outlineSkillCoins.setColor(MSPalette.INSTANCE.getOrange());
        } else {
            this._outlineSkillCoins.setColor(MSPalette.INSTANCE.getWhiteA4());
            this._outlineEmeralds.setColor(MSPalette.INSTANCE.getOrange());
        }
        get_verticalScrollBar().attachTo(getCategoriesView());
        get_skillCoinsBlock().onMouseClick((v1, v2) -> {
            return _init_$lambda$8(r1, v1, v2);
        });
        get_emeraldsBlock().onMouseClick((v1, v2) -> {
            return _init_$lambda$9(r1, v1, v2);
        });
    }

    public /* synthetic */ CategorySection(CurrencyType currencyType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CurrencyType.RUBLE : currencyType);
    }

    @NotNull
    public final State<CurrencyType> getCurrencyState() {
        return this.currencyState;
    }

    @NotNull
    public final CurrencyType getCurrency() {
        return (CurrencyType) this.currencyState.get();
    }

    public final void setCurrency(@NotNull CurrencyType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.currencyState.set(value);
    }

    @NotNull
    public final SearchInput getSearch() {
        return (SearchInput) this.search.getValue(this, $$delegatedProperties[0]);
    }

    private final UIRoundedRectangle get_skillCoinsBlock() {
        return (UIRoundedRectangle) this._skillCoinsBlock.getValue(this, $$delegatedProperties[1]);
    }

    private final ImageComponent get_skillCoinIcon() {
        return (ImageComponent) this._skillCoinIcon.getValue(this, $$delegatedProperties[2]);
    }

    private final UIRoundedRectangle get_emeraldsBlock() {
        return (UIRoundedRectangle) this._emeraldsBlock.getValue(this, $$delegatedProperties[3]);
    }

    private final ImageComponent get_emeraldIcon() {
        return (ImageComponent) this._emeraldIcon.getValue(this, $$delegatedProperties[4]);
    }

    private final LabelComponent get_categoryTitle() {
        return (LabelComponent) this._categoryTitle.getValue(this, $$delegatedProperties[5]);
    }

    @NotNull
    public final ScrollComponent getCategoriesView() {
        return (ScrollComponent) this.categoriesView.getValue(this, $$delegatedProperties[6]);
    }

    private final ScrollBar get_verticalScrollBar() {
        return (ScrollBar) this._verticalScrollBar.getValue(this, $$delegatedProperties[7]);
    }

    private static final Unit _init_$lambda$8(CategorySection this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.getCurrency() != CurrencyType.RUBLE) {
            this$0.setCurrency(CurrencyType.RUBLE);
            this$0._outlineEmeralds.setColor(MSPalette.INSTANCE.getWhiteA4());
            this$0._outlineSkillCoins.setColor(MSPalette.INSTANCE.getOrange());
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$9(CategorySection this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.getCurrency() != CurrencyType.EMERALD) {
            this$0.setCurrency(CurrencyType.EMERALD);
            this$0._outlineSkillCoins.setColor(MSPalette.INSTANCE.getWhiteA4());
            this$0._outlineEmeralds.setColor(MSPalette.INSTANCE.getOrange());
        }
        return Unit.INSTANCE;
    }

    public final boolean selectedCategories(@NotNull ItemData item) {
        Intrinsics.checkNotNullParameter(item, "item");
        UIComponent this_$iv = getCategoriesView();
        Iterable $this$filter$iv = this_$iv.childrenOfType(CategoryComponent.class);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            CategoryComponent p0 = (CategoryComponent) element$iv$iv;
            if (p0.getSelected()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List categories = (List) destination$iv$iv;
        if (categories.isEmpty()) {
            return true;
        }
        List $this$any$iv = categories;
        if (($this$any$iv instanceof Collection) && $this$any$iv.isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            CategoryComponent it = (CategoryComponent) element$iv;
            if (it.getCategory().getId() == (Intrinsics.areEqual(item.getType(), "kit") ? 9999 : item.getCatId())) {
                return true;
            }
        }
        return false;
    }
}
