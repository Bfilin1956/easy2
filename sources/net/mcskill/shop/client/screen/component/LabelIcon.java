package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.image.ImageComponent;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedMaxSizeConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.state.State;
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
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LabelIcon.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/LabelIcon.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\t\u0010\nB#\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u000eR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\r\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lnet/mcskill/shop/client/screen/component/LabelIcon;", "Lgg/essential/elementa/components/UIContainer;", "textState", "Lgg/essential/elementa/state/State;", "", "iconPathState", "Lnet/minecraft/resources/ResourceLocation;", "textColorState", "Ljava/awt/Color;", "<init>", "(Lgg/essential/elementa/state/State;Lgg/essential/elementa/state/State;Lgg/essential/elementa/state/State;)V", "text", "iconPath", "textColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/awt/Color;)V", "value", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getIconPath", "()Lnet/minecraft/resources/ResourceLocation;", "setIconPath", "(Lnet/minecraft/resources/ResourceLocation;)V", "getTextColor", "()Ljava/awt/Color;", "setTextColor", "(Ljava/awt/Color;)V", "label", "Lgg/essential/elementa/components/LabelComponent;", "getLabel", "()Lgg/essential/elementa/components/LabelComponent;", "label$delegate", "Lkotlin/properties/ReadWriteProperty;", "icon", "Lgg/essential/elementa/components/image/ImageComponent;", "getIcon", "()Lgg/essential/elementa/components/image/ImageComponent;", "icon$delegate", "MSShop"})
@SourceDebugExtension({"SMAP\nLabelIcon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LabelIcon.kt\nnet/mcskill/shop/client/screen/component/LabelIcon\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,57:1\n10#2,3:58\n10#2,3:61\n10#2,3:64\n*S KotlinDebug\n*F\n+ 1 LabelIcon.kt\nnet/mcskill/shop/client/screen/component/LabelIcon\n*L\n38#1:58,3\n44#1:61,3\n52#1:64,3\n*E\n"})
public final class LabelIcon extends UIContainer {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(LabelIcon.class, "label", "getLabel()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(LabelIcon.class, "icon", "getIcon()Lgg/essential/elementa/components/image/ImageComponent;", 0))};

    @NotNull
    private final State<String> textState;

    @NotNull
    private final State<ResourceLocation> iconPathState;

    @NotNull
    private final State<Color> textColorState;

    /* JADX INFO: renamed from: label$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty label;

    /* JADX INFO: renamed from: icon$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty icon;

    public /* synthetic */ LabelIcon(State state, State state2, State state3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((State<String>) state, (State<ResourceLocation>) state2, (State<Color>) ((i & 4) != 0 ? (State) new BasicState(Color.WHITE) : state3));
    }

    public LabelIcon(@NotNull State<String> state, @NotNull State<ResourceLocation> state2, @NotNull State<Color> state3) {
        Intrinsics.checkNotNullParameter(state, "textState");
        Intrinsics.checkNotNullParameter(state2, "iconPathState");
        Intrinsics.checkNotNullParameter(state3, "textColorState");
        this.textState = state;
        this.iconPathState = state2;
        this.textColorState = state3;
        UIComponent $this$constrain$iv = new LabelComponent(this.textState, (State) null, (State) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$label_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$label_delegate_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$label_delegate_u24lambda_u240.setTextScale(UtilitiesKt.getDp((Number) 20));
        $this$label_delegate_u24lambda_u240.setColor(ExtensionsKt.toConstraint(this.textColorState));
        this.label = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new ImageComponent(this.iconPathState, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$icon_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$icon_delegate_u24lambda_u241.setX(new SiblingConstraint(4.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$icon_delegate_u24lambda_u241.setY(ConstraintsKt.boundTo(new CenterConstraint(), getLabel()));
        $this$icon_delegate_u24lambda_u241.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
        $this$icon_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 20));
        this.icon = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
        UIConstraints $this$_init__u24lambda_u242 = ((UIComponent) this).getConstraints();
        $this$_init__u24lambda_u242.setWidth(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null));
        $this$_init__u24lambda_u242.setHeight(new ChildBasedMaxSizeConstraint());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LabelIcon(@NotNull String text, @NotNull String iconPath, @NotNull Color textColor) {
        this((State<String>) new BasicState(text), (State<ResourceLocation>) new BasicState(ResourceLocation.parse(iconPath)), (State<Color>) new BasicState(textColor));
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(iconPath, "iconPath");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
    }

    public /* synthetic */ LabelIcon(String str, String str2, Color color, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? Color.WHITE : color);
    }

    @NotNull
    public final String getText() {
        return (String) this.textState.get();
    }

    public final void setText(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.textState.set(value);
    }

    @NotNull
    public final ResourceLocation getIconPath() {
        return (ResourceLocation) this.iconPathState.get();
    }

    public final void setIconPath(@NotNull ResourceLocation value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.iconPathState.set(value);
    }

    @NotNull
    public final Color getTextColor() {
        return (Color) this.textColorState.get();
    }

    public final void setTextColor(@NotNull Color value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.textColorState.set(value);
    }

    private final LabelComponent getLabel() {
        return (LabelComponent) this.label.getValue(this, $$delegatedProperties[0]);
    }

    private final ImageComponent getIcon() {
        return (ImageComponent) this.icon.getValue(this, $$delegatedProperties[1]);
    }
}
