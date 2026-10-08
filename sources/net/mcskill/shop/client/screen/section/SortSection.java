package net.mcskill.shop.client.screen.section;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.state.ExtensionsKt;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.shop.client.screen.component.Select;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SortSection.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/section/SortSection.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lnet/mcskill/shop/client/screen/section/SortSection;", "Lgg/essential/elementa/components/UIRoundedRectangle;", "radius", "", "<init>", "(F)V", "_sortTitle", "Lgg/essential/elementa/components/LabelComponent;", "get_sortTitle", "()Lgg/essential/elementa/components/LabelComponent;", "_sortTitle$delegate", "Lkotlin/properties/ReadWriteProperty;", "sortSelect", "Lnet/mcskill/shop/client/screen/component/Select;", "getSortSelect", "()Lnet/mcskill/shop/client/screen/component/Select;", "sortSelect$delegate", "MSShop"})
@SourceDebugExtension({"SMAP\nSortSection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SortSection.kt\nnet/mcskill/shop/client/screen/section/SortSection\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,31:1\n10#2,3:32\n10#2,3:35\n*S KotlinDebug\n*F\n+ 1 SortSection.kt\nnet/mcskill/shop/client/screen/section/SortSection\n*L\n17#1:32,3\n24#1:35,3\n*E\n"})
public final class SortSection extends UIRoundedRectangle {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SortSection.class, "_sortTitle", "get_sortTitle()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(SortSection.class, "sortSelect", "getSortSelect()Lnet/mcskill/shop/client/screen/component/Select;", 0))};

    /* JADX INFO: renamed from: _sortTitle$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _sortTitle;

    /* JADX INFO: renamed from: sortSelect$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty sortSelect;

    public SortSection(float radius) {
        super(radius, false, 2, (DefaultConstructorMarker) null);
        UIComponent $this$constrain$iv = new LabelComponent("§lСортировать:", false, (Color) null, 4, (DefaultConstructorMarker) null);
        UIConstraints $this$_sortTitle_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_sortTitle_delegate_u24lambda_u240.setX(UtilitiesKt.getDp((Number) 20));
        $this$_sortTitle_delegate_u24lambda_u240.setY(new CenterConstraint());
        $this$_sortTitle_delegate_u24lambda_u240.setTextScale(UtilitiesKt.getDp((Number) 24));
        $this$_sortTitle_delegate_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        this._sortTitle = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new Select(0, CollectionsKt.listOf(new String[]{"По умолчанию", "По названию", "По возрастанию", "По убыванию"}), 0, 0.0f, null, 28, null);
        UIConstraints $this$sortSelect_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$sortSelect_delegate_u24lambda_u241.setX(new SiblingConstraint(10.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$sortSelect_delegate_u24lambda_u241.setY(new CenterConstraint());
        $this$sortSelect_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 195));
        $this$sortSelect_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 32));
        $this$sortSelect_delegate_u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA4()));
        this.sortSelect = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
    }

    private final LabelComponent get_sortTitle() {
        return (LabelComponent) this._sortTitle.getValue(this, $$delegatedProperties[0]);
    }

    @NotNull
    public final Select getSortSelect() {
        return (Select) this.sortSelect.getValue(this, $$delegatedProperties[1]);
    }
}
