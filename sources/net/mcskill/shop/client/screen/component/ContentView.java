package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.ScrollComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.state.ExtensionsKt;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSPalette;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContentView.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/ContentView.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lnet/mcskill/shop/client/screen/component/ContentView;", "Lgg/essential/elementa/components/UIContainer;", "<init>", "()V", "verticalScrollBar", "Lnet/mcskill/shop/client/screen/component/ScrollBar;", "getVerticalScrollBar", "()Lnet/mcskill/shop/client/screen/component/ScrollBar;", "verticalScrollBar$delegate", "Lkotlin/properties/ReadWriteProperty;", "scrollView", "Lgg/essential/elementa/components/ScrollComponent;", "getScrollView", "()Lgg/essential/elementa/components/ScrollComponent;", "scrollView$delegate", "fillEntryView", "", "entry", "Lnet/mcskill/shop/client/screen/component/EntryComponent;", "MSShop"})
@SourceDebugExtension({"SMAP\nContentView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContentView.kt\nnet/mcskill/shop/client/screen/component/ContentView\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,33:1\n10#2,3:34\n10#2,3:37\n*S KotlinDebug\n*F\n+ 1 ContentView.kt\nnet/mcskill/shop/client/screen/component/ContentView\n*L\n11#1:34,3\n21#1:37,3\n*E\n"})
public final class ContentView extends UIContainer {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ContentView.class, "verticalScrollBar", "getVerticalScrollBar()Lnet/mcskill/shop/client/screen/component/ScrollBar;", 0)), Reflection.property1(new PropertyReference1Impl(ContentView.class, "scrollView", "getScrollView()Lgg/essential/elementa/components/ScrollComponent;", 0))};

    /* JADX INFO: renamed from: verticalScrollBar$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty verticalScrollBar;

    /* JADX INFO: renamed from: scrollView$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty scrollView;

    public ContentView() {
        UIComponent $this$constrain$iv = new ScrollBar(4.0f, false, 2, null);
        UIConstraints $this$verticalScrollBar_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$verticalScrollBar_delegate_u24lambda_u240.setX(UtilitiesKt.pixel$default((Number) 0, true, false, 2, (Object) null));
        $this$verticalScrollBar_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp((Number) 16));
        $this$verticalScrollBar_delegate_u24lambda_u240.setHeight(new FillConstraint(false));
        $this$verticalScrollBar_delegate_u24lambda_u240.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA1()));
        this.verticalScrollBar = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new ScrollComponent("Список пуст", 25.0f, 0.0f, (Color) null, false, false, false, false, 25.0f, 0.0f, (UIComponent) null, 1788, (DefaultConstructorMarker) null);
        UIConstraints $this$scrollView_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$scrollView_delegate_u24lambda_u241.setWidth(ConstraintsKt.minus(new FillConstraint(false), UtilitiesKt.getPixel(Float.valueOf(getVerticalScrollBar().getWidth()))));
        $this$scrollView_delegate_u24lambda_u241.setHeight(new FillConstraint(false));
        this.scrollView = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
        getVerticalScrollBar().attachTo(getScrollView());
    }

    private final ScrollBar getVerticalScrollBar() {
        return (ScrollBar) this.verticalScrollBar.getValue(this, $$delegatedProperties[0]);
    }

    @NotNull
    public final ScrollComponent getScrollView() {
        return (ScrollComponent) this.scrollView.getValue(this, $$delegatedProperties[1]);
    }

    public final void fillEntryView(@NotNull EntryComponent entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        ComponentsKt.childOf((UIComponent) entry, getScrollView());
    }
}
