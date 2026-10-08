package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.UICircle;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.font.FontProvider;
import gg.essential.elementa.markdown.MarkdownComponent;
import gg.essential.elementa.markdown.MarkdownConfig;
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
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.core.client.screen.constraint.SizeRadiusConstraint;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TreeGraphGroup.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/RootNode.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lnet/mcskill/shop/client/screen/component/RootNode;", "Lgg/essential/elementa/components/UIRoundedRectangle;", "name", "", "<init>", "(Ljava/lang/String;)V", "circle", "Lgg/essential/elementa/components/UICircle;", "getCircle", "()Lgg/essential/elementa/components/UICircle;", "circle$delegate", "Lkotlin/properties/ReadWriteProperty;", "title", "Lgg/essential/elementa/markdown/MarkdownComponent;", "getTitle", "()Lgg/essential/elementa/markdown/MarkdownComponent;", "title$delegate", "MSShop"})
@SourceDebugExtension({"SMAP\nTreeGraphGroup.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TreeGraphGroup.kt\nnet/mcskill/shop/client/screen/component/RootNode\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,111:1\n10#2,3:112\n10#2,3:115\n*S KotlinDebug\n*F\n+ 1 TreeGraphGroup.kt\nnet/mcskill/shop/client/screen/component/RootNode\n*L\n67#1:112,3\n74#1:115,3\n*E\n"})
public final class RootNode extends UIRoundedRectangle {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(RootNode.class, "circle", "getCircle()Lgg/essential/elementa/components/UICircle;", 0)), Reflection.property1(new PropertyReference1Impl(RootNode.class, "title", "getTitle()Lgg/essential/elementa/markdown/MarkdownComponent;", 0))};

    /* JADX INFO: renamed from: circle$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty circle;

    /* JADX INFO: renamed from: title$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RootNode(@NotNull String name) {
        super(4.0f, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(name, "name");
        UIComponent $this$constrain$iv = new UICircle(0.0f, (Color) null, 0, 7, (DefaultConstructorMarker) null);
        UIConstraints $this$circle_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$circle_delegate_u24lambda_u240.setX(ConstraintsKt.plus(new SizeRadiusConstraint((SizeRadiusConstraint.Type) null, 1, (DefaultConstructorMarker) null), UtilitiesKt.getDp((Number) 12)));
        $this$circle_delegate_u24lambda_u240.setY(new CenterConstraint());
        $this$circle_delegate_u24lambda_u240.setRadius(UtilitiesKt.getDp((Number) 8));
        $this$circle_delegate_u24lambda_u240.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this.circle = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new MarkdownComponent(name, (MarkdownConfig) null, 0.0f, (FontProvider) null, 14, (DefaultConstructorMarker) null);
        UIConstraints $this$title_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$title_delegate_u24lambda_u241.setX(UtilitiesKt.getDp((Number) 40));
        $this$title_delegate_u24lambda_u241.setY(new CenterConstraint());
        $this$title_delegate_u24lambda_u241.setWidth(ConstraintsKt.minus(new FillConstraint(false), UtilitiesKt.getDp((Number) 8)));
        $this$title_delegate_u24lambda_u241.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$title_delegate_u24lambda_u241.setTextScale(UtilitiesKt.getDp((Number) 18));
        this.title = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
    }

    @NotNull
    public final UICircle getCircle() {
        return (UICircle) this.circle.getValue(this, $$delegatedProperties[0]);
    }

    private final MarkdownComponent getTitle() {
        return (MarkdownComponent) this.title.getValue(this, $$delegatedProperties[1]);
    }
}
