package net.mcskill.shop.client.screen.tab.items;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UICircle;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.animation.AnimatingConstraints;
import gg.essential.elementa.constraints.animation.AnimationStrategy;
import gg.essential.elementa.constraints.animation.Animations;
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
import net.mcskill.shop.client.screen.component.RadioGroup;
import net.mcskill.shop.common.response.shop.CategoryData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CategoryComponent.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/tab/items/CategoryComponent.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lnet/mcskill/shop/client/screen/tab/items/CategoryComponent;", "Lgg/essential/elementa/components/UIRoundedRectangle;", "Lnet/mcskill/shop/client/screen/component/RadioGroup;", "category", "Lnet/mcskill/shop/common/response/shop/CategoryData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/CategoryData;)V", "getCategory", "()Lnet/mcskill/shop/common/response/shop/CategoryData;", "value", "", "selected", "getSelected", "()Z", "_circle", "Lgg/essential/elementa/components/UICircle;", "get_circle", "()Lgg/essential/elementa/components/UICircle;", "_circle$delegate", "Lkotlin/properties/ReadWriteProperty;", "_categoryName", "Lgg/essential/elementa/components/LabelComponent;", "get_categoryName", "()Lgg/essential/elementa/components/LabelComponent;", "_categoryName$delegate", "select", "", "deselect", "MSShop"})
@SourceDebugExtension({"SMAP\nCategoryComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CategoryComponent.kt\nnet/mcskill/shop/client/screen/tab/items/CategoryComponent\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 animations.kt\ngg/essential/elementa/dsl/AnimationsKt\n*L\n1#1,68:1\n10#2,3:69\n10#2,3:72\n10#3,5:75\n10#3,5:80\n10#3,5:85\n10#3,5:90\n*S KotlinDebug\n*F\n+ 1 CategoryComponent.kt\nnet/mcskill/shop/client/screen/tab/items/CategoryComponent\n*L\n20#1:69,3\n26#1:72,3\n38#1:75,5\n41#1:80,5\n47#1:85,5\n50#1:90,5\n*E\n"})
public final class CategoryComponent extends UIRoundedRectangle implements RadioGroup {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CategoryComponent.class, "_circle", "get_circle()Lgg/essential/elementa/components/UICircle;", 0)), Reflection.property1(new PropertyReference1Impl(CategoryComponent.class, "_categoryName", "get_categoryName()Lgg/essential/elementa/components/LabelComponent;", 0))};

    @NotNull
    private final CategoryData category;
    private boolean selected;

    /* JADX INFO: renamed from: _circle$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _circle;

    /* JADX INFO: renamed from: _categoryName$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _categoryName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryComponent(@NotNull CategoryData category) {
        super(4.0f, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(category, "category");
        this.category = category;
        UIComponent $this$constrain$iv = new UICircle(0.0f, (Color) MSPalette.INSTANCE.getWhiteA4().get(), 0, 5, (DefaultConstructorMarker) null);
        UIConstraints $this$_circle_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_circle_delegate_u24lambda_u240.setX(UtilitiesKt.getPercent((Number) 6));
        $this$_circle_delegate_u24lambda_u240.setY(UtilitiesKt.getPercent((Number) 50));
        $this$_circle_delegate_u24lambda_u240.setRadius(UtilitiesKt.getPercent(Double.valueOf(5.71d)));
        this._circle = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new LabelComponent(this.category.getName(), false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_categoryName_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_categoryName_delegate_u24lambda_u241.setX(UtilitiesKt.getDp((Number) 40));
        $this$_categoryName_delegate_u24lambda_u241.setY(new CenterConstraint());
        $this$_categoryName_delegate_u24lambda_u241.setTextScale(UtilitiesKt.getDp((Number) 20));
        $this$_categoryName_delegate_u24lambda_u241.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        this._categoryName = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
        onMouseClick((v1, v2) -> {
            return _init_$lambda$2(r1, v1, v2);
        }).onMouseEnter((v1) -> {
            return _init_$lambda$5(r1, v1);
        }).onMouseLeave((v1) -> {
            return _init_$lambda$8(r1, v1);
        });
    }

    @NotNull
    public final CategoryData getCategory() {
        return this.category;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    private final UICircle get_circle() {
        return (UICircle) this._circle.getValue(this, $$delegatedProperties[0]);
    }

    private final LabelComponent get_categoryName() {
        return (LabelComponent) this._categoryName.getValue(this, $$delegatedProperties[1]);
    }

    private static final Unit _init_$lambda$2(CategoryComponent this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        if (this$0.selected) {
            this$0.deselect();
        } else {
            this$0.select();
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$5(CategoryComponent this$0, UIComponent $this$onMouseEnter) {
        Intrinsics.checkNotNullParameter($this$onMouseEnter, "$this$onMouseEnter");
        if (!this$0.selected) {
            UIComponent $this$animate$iv = this$0.get_circle();
            AnimatingConstraints anim$iv = $this$animate$iv.makeAnimation();
            AnimatingConstraints.setColorAnimation$default(anim$iv, Animations.OUT_EXP, 0.5f, ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()), 0.0f, 8, (Object) null);
            $this$animate$iv.animateTo(anim$iv);
            UIComponent $this$animate$iv2 = this$0.get_categoryName();
            AnimatingConstraints anim$iv2 = $this$animate$iv2.makeAnimation();
            AnimatingConstraints.setColorAnimation$default(anim$iv2, Animations.OUT_EXP, 0.5f, ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()), 0.0f, 8, (Object) null);
            $this$animate$iv2.animateTo(anim$iv2);
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$8(CategoryComponent this$0, UIComponent $this$onMouseLeave) {
        Intrinsics.checkNotNullParameter($this$onMouseLeave, "$this$onMouseLeave");
        if (!this$0.selected) {
            UIComponent $this$animate$iv = this$0.get_circle();
            AnimatingConstraints anim$iv = $this$animate$iv.makeAnimation();
            AnimatingConstraints.setColorAnimation$default(anim$iv, Animations.OUT_EXP, 0.5f, ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA4()), 0.0f, 8, (Object) null);
            $this$animate$iv.animateTo(anim$iv);
            UIComponent $this$animate$iv2 = this$0.get_categoryName();
            AnimatingConstraints anim$iv2 = $this$animate$iv2.makeAnimation();
            AnimationStrategy animationStrategy = Animations.OUT_EXP;
            Color color = Color.WHITE;
            Intrinsics.checkNotNullExpressionValue(color, "WHITE");
            AnimatingConstraints.setColorAnimation$default(anim$iv2, animationStrategy, 0.5f, UtilitiesKt.toConstraint(color), 0.0f, 8, (Object) null);
            $this$animate$iv2.animateTo(anim$iv2);
        }
        return Unit.INSTANCE;
    }

    @Override // net.mcskill.shop.client.screen.component.RadioGroup
    public void select() {
        this.selected = true;
        get_circle().setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        get_categoryName().setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
    }

    @Override // net.mcskill.shop.client.screen.component.RadioGroup
    public void deselect() {
        this.selected = false;
        get_circle().setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA4()));
        LabelComponent labelComponent = get_categoryName();
        Color color = Color.WHITE;
        Intrinsics.checkNotNullExpressionValue(color, "WHITE");
        labelComponent.setColor(UtilitiesKt.toConstraint(color));
    }
}
