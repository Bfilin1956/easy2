package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
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
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/LabelButton.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lnet/mcskill/shop/client/screen/component/LabelButton;", "Lnet/mcskill/shop/client/screen/component/BaseButton;", "text", "", "fontScale", "", "radius", "", "paddingX", "paddingY", "align", "Lnet/mcskill/shop/client/screen/component/LabelAlign;", "fontColor", "Ljava/awt/Color;", "shadow", "", "<init>", "(Ljava/lang/String;IFFFLnet/mcskill/shop/client/screen/component/LabelAlign;Ljava/awt/Color;Z)V", "label", "Lgg/essential/elementa/components/LabelComponent;", "getLabel", "()Lgg/essential/elementa/components/LabelComponent;", "label$delegate", "Lkotlin/properties/ReadWriteProperty;", "MSShop"})
@SourceDebugExtension({"SMAP\nButton.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Button.kt\nnet/mcskill/shop/client/screen/component/LabelButton\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,134:1\n10#2,3:135\n*S KotlinDebug\n*F\n+ 1 Button.kt\nnet/mcskill/shop/client/screen/component/LabelButton\n*L\n50#1:135,3\n*E\n"})
public final class LabelButton extends BaseButton {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(LabelButton.class, "label", "getLabel()Lgg/essential/elementa/components/LabelComponent;", 0))};

    /* JADX INFO: renamed from: label$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty label;

    public /* synthetic */ LabelButton(String str, int i, float f, float f2, float f3, LabelAlign labelAlign, Color color, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? 4.0f : f, (i2 & 8) != 0 ? 0.0f : f2, (i2 & 16) != 0 ? 0.0f : f3, (i2 & 32) != 0 ? LabelAlign.CENTER : labelAlign, (i2 & 64) != 0 ? Color.WHITE : color, (i2 & 128) != 0 ? true : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabelButton(@NotNull String text, int fontScale, float radius, float paddingX, float paddingY, @NotNull LabelAlign align, @NotNull Color fontColor, boolean shadow) {
        super(radius, shadow, null);
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(fontColor, "fontColor");
        UIComponent $this$constrain$iv = new LabelComponent(text, false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$label_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$label_delegate_u24lambda_u240.setX(align.mo23posX(paddingX));
        $this$label_delegate_u24lambda_u240.setY(align.mo24posY(paddingY));
        $this$label_delegate_u24lambda_u240.setTextScale(UtilitiesKt.getDp(Integer.valueOf(fontScale)));
        $this$label_delegate_u24lambda_u240.setColor(UtilitiesKt.toConstraint(fontColor));
        $this$label_delegate_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        this.label = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
    }

    @NotNull
    public final LabelComponent getLabel() {
        return (LabelComponent) this.label.getValue(this, $$delegatedProperties[0]);
    }
}
