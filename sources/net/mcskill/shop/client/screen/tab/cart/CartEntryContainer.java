package net.mcskill.shop.client.screen.tab.cart;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.ScrollComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.constraints.RelativeConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.dsl.BasicConstraintsKt;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import java.awt.Color;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.shop.client.screen.component.Updatable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CartEntryContainer.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/tab/cart/CartEntryContainer.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B3\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0015\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lnet/mcskill/shop/client/screen/tab/cart/CartEntryContainer;", "T", "Lgg/essential/elementa/components/UIContainer;", "Lnet/mcskill/shop/client/screen/component/Updatable;", "sortOrder", "", "name", "", "attachedParent", "Lgg/essential/elementa/components/ScrollComponent;", "block", "Lkotlin/Function1;", "Lgg/essential/elementa/UIComponent;", "<init>", "(ILjava/lang/String;Lgg/essential/elementa/components/ScrollComponent;Lkotlin/jvm/functions/Function1;)V", "getSortOrder", "()I", "getAttachedParent", "()Lgg/essential/elementa/components/ScrollComponent;", "_title", "Lgg/essential/elementa/components/LabelComponent;", "get_title", "()Lgg/essential/elementa/components/LabelComponent;", "_title$delegate", "Lkotlin/properties/ReadWriteProperty;", "_content", "get_content", "()Lgg/essential/elementa/components/UIContainer;", "_content$delegate", "clear", "", "add", "data", "(Ljava/lang/Object;)V", "MSShop"})
@SourceDebugExtension({"SMAP\nCartEntryContainer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CartEntryContainer.kt\nnet/mcskill/shop/client/screen/tab/cart/CartEntryContainer\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,62:1\n10#2,3:63\n10#2,3:66\n10#2,3:69\n1#3:72\n*S KotlinDebug\n*F\n+ 1 CartEntryContainer.kt\nnet/mcskill/shop/client/screen/tab/cart/CartEntryContainer\n*L\n20#1:63,3\n25#1:66,3\n38#1:69,3\n*E\n"})
public final class CartEntryContainer<T> extends UIContainer implements Updatable<T> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CartEntryContainer.class, "_title", "get_title()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(CartEntryContainer.class, "_content", "get_content()Lgg/essential/elementa/components/UIContainer;", 0))};
    private final int sortOrder;

    @NotNull
    private final ScrollComponent attachedParent;

    @NotNull
    private final Function1<T, UIComponent> block;

    /* JADX INFO: renamed from: _title$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _title;

    /* JADX INFO: renamed from: _content$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _content;

    public final int getSortOrder() {
        return this.sortOrder;
    }

    @NotNull
    public final ScrollComponent getAttachedParent() {
        return this.attachedParent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CartEntryContainer(int sortOrder, @NotNull String name, @NotNull ScrollComponent attachedParent, @NotNull Function1<? super T, ? extends UIComponent> function1) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(attachedParent, "attachedParent");
        Intrinsics.checkNotNullParameter(function1, "block");
        this.sortOrder = sortOrder;
        this.attachedParent = attachedParent;
        this.block = function1;
        UIComponent $this$constrain$iv = new LabelComponent("§l" + name, false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_title_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_title_delegate_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_title_delegate_u24lambda_u240.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._title = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new UIContainer();
        UIConstraints $this$_content_delegate_u24lambda_u245 = $this$constrain$iv2.getConstraints();
        $this$_content_delegate_u24lambda_u245.setY(new SiblingConstraint(7.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_content_delegate_u24lambda_u245.setWidth(new RelativeConstraint(1.0f));
        $this$_content_delegate_u24lambda_u245.setHeight(BasicConstraintsKt.basicHeightConstraint(CartEntryContainer::_content_delegate$lambda$5$lambda$4));
        this._content = ComponentsKt.provideDelegate($this$constrain$iv2, this, $$delegatedProperties[1]);
        UIConstraints $this$_init__u24lambda_u246 = ((UIComponent) this).getConstraints();
        $this$_init__u24lambda_u246.setY(new SiblingConstraint(20.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u246.setWidth(new FillConstraint(false));
        $this$_init__u24lambda_u246.setHeight(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null));
        addChild(get_content());
    }

    private final LabelComponent get_title() {
        return (LabelComponent) this._title.getValue(this, $$delegatedProperties[0]);
    }

    private final UIContainer get_content() {
        return (UIContainer) this._content.getValue(this, $$delegatedProperties[1]);
    }

    private static final float _content_delegate$lambda$5$lambda$4(UIComponent it) {
        float f;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getChildren().isEmpty()) {
            return 0.0f;
        }
        Iterable children = it.getChildren();
        Iterator<T> it2 = children.iterator();
        if (!it2.hasNext()) {
            throw new NoSuchElementException();
        }
        UIComponent child = (UIComponent) it2.next();
        float bottom = child.getBottom();
        while (true) {
            f = bottom;
            if (!it2.hasNext()) {
                break;
            }
            UIComponent child2 = (UIComponent) it2.next();
            bottom = Math.max(f, child2.getBottom());
        }
        Iterator<T> it3 = children.iterator();
        if (!it3.hasNext()) {
            throw new NoSuchElementException();
        }
        UIComponent child3 = (UIComponent) it3.next();
        float top = child3.getTop();
        while (true) {
            float f2 = top;
            if (!it3.hasNext()) {
                return (f - f2) + 1;
            }
            UIComponent child4 = (UIComponent) it3.next();
            top = Math.min(f2, child4.getTop());
        }
    }

    @Override // net.mcskill.shop.client.screen.component.Updatable
    public void clear() {
        if (getHasParent()) {
            this.attachedParent.removeChild((UIComponent) this);
        }
        get_content().clearChildren();
    }

    @Override // net.mcskill.shop.client.screen.component.Updatable
    public void add(T data) {
        if (!this.attachedParent.containsChild((UIComponent) this)) {
            this.attachedParent.addChild((UIComponent) this);
            ScrollComponent.sortChildren$default(this.attachedParent, false, CartEntryContainer::add$lambda$7, 1, (Object) null);
        }
        ComponentsKt.childOf((UIComponent) this.block.invoke(data), get_content());
    }

    private static final int add$lambda$7(UIComponent comp) {
        Intrinsics.checkNotNullParameter(comp, "comp");
        CartEntryContainer cartEntryContainer = comp instanceof CartEntryContainer ? (CartEntryContainer) comp : null;
        if (cartEntryContainer != null) {
            return cartEntryContainer.sortOrder;
        }
        return -1;
    }
}
