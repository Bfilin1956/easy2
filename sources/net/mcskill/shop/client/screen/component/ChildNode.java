package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.components.image.ImageComponent;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.utils.ResourcesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSPalette;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TreeGraphGroup.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/ChildNode.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lnet/mcskill/shop/client/screen/component/ChildNode;", "Lgg/essential/elementa/components/UIRoundedRectangle;", "<init>", "()V", "arrow", "Lgg/essential/elementa/components/image/ImageComponent;", "getArrow", "()Lgg/essential/elementa/components/image/ImageComponent;", "arrow$delegate", "Lkotlin/properties/ReadWriteProperty;", "content", "Lgg/essential/elementa/components/UIContainer;", "getContent", "()Lgg/essential/elementa/components/UIContainer;", "content$delegate", "appendContent", "", "component", "Lgg/essential/elementa/UIComponent;", "MSShop"})
@SourceDebugExtension({"SMAP\nTreeGraphGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TreeGraphGroup.kt\nnet/mcskill/shop/client/screen/component/ChildNode\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,111:1\n10#2,3:112\n10#2,3:115\n10#2,3:118\n*S KotlinDebug\n*F\n+ 1 TreeGraphGroup.kt\nnet/mcskill/shop/client/screen/component/ChildNode\n*L\n84#1:112,3\n91#1:115,3\n99#1:118,3\n*E\n"})
public final class ChildNode extends UIRoundedRectangle {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ChildNode.class, "arrow", "getArrow()Lgg/essential/elementa/components/image/ImageComponent;", 0)), Reflection.property1(new PropertyReference1Impl(ChildNode.class, "content", "getContent()Lgg/essential/elementa/components/UIContainer;", 0))};

    /* JADX INFO: renamed from: arrow$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty arrow;

    /* JADX INFO: renamed from: content$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty content;

    public ChildNode() {
        super(4.0f, false, 2, (DefaultConstructorMarker) null);
        ResourceLocation resourceLocationAsResource$default = ResourcesKt.asResource$default("textures/branch_arrow.png", (String) null, 1, (Object) null);
        Intrinsics.checkNotNullExpressionValue(resourceLocationAsResource$default, "asResource$default(...)");
        UIComponent $this$constrain$iv = new ImageComponent(resourceLocationAsResource$default, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$arrow_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$arrow_delegate_u24lambda_u240.setX(UtilitiesKt.getDp((Number) 12));
        $this$arrow_delegate_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 12));
        $this$arrow_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp(Double.valueOf(7.83d)));
        $this$arrow_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp(Double.valueOf(14.03d)));
        this.arrow = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new UIContainer();
        UIConstraints $this$content_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$content_delegate_u24lambda_u241.setX(UtilitiesKt.getDp((Number) 32));
        $this$content_delegate_u24lambda_u241.setY(UtilitiesKt.getDp((Number) 12));
        $this$content_delegate_u24lambda_u241.setWidth(ConstraintsKt.minus(new FillConstraint(false), UtilitiesKt.getDp((Number) 12)));
        $this$content_delegate_u24lambda_u241.setHeight(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null));
        this.content = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
        UIConstraints $this$_init__u24lambda_u242 = ((UIComponent) this).getConstraints();
        $this$_init__u24lambda_u242.setX(UtilitiesKt.getDp((Number) 32));
        $this$_init__u24lambda_u242.setY(UtilitiesKt.dp((Number) 4, true, true));
        $this$_init__u24lambda_u242.setWidth(new FillConstraint(false));
        $this$_init__u24lambda_u242.setHeight(ConstraintsKt.plus(ConstraintsKt.boundTo(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null), getContent()), UtilitiesKt.getDp((Number) 24)));
        $this$_init__u24lambda_u242.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA1()));
    }

    @NotNull
    public final ImageComponent getArrow() {
        return (ImageComponent) this.arrow.getValue(this, $$delegatedProperties[0]);
    }

    private final UIContainer getContent() {
        return (UIContainer) this.content.getValue(this, $$delegatedProperties[1]);
    }

    public final void appendContent(@NotNull UIComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        ComponentsKt.childOf(component, getContent());
    }
}
