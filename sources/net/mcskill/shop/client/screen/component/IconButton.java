package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.image.ImageComponent;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.utils.ResourcesKt;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/IconButton.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lnet/mcskill/shop/client/screen/component/IconButton;", "Lnet/mcskill/shop/client/screen/component/BaseButton;", "path", "", "radius", "", "paddingX", "paddingY", "align", "Lnet/mcskill/shop/client/screen/component/LabelAlign;", "imageColor", "Ljava/awt/Color;", "imageWidth", "imageHeight", "shadow", "", "<init>", "(Ljava/lang/String;FFFLnet/mcskill/shop/client/screen/component/LabelAlign;Ljava/awt/Color;FFZ)V", "image", "Lgg/essential/elementa/components/image/ImageComponent;", "getImage", "()Lgg/essential/elementa/components/image/ImageComponent;", "image$delegate", "Lkotlin/properties/ReadWriteProperty;", "MSShop"})
@SourceDebugExtension({"SMAP\nButton.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Button.kt\nnet/mcskill/shop/client/screen/component/IconButton\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,134:1\n10#2,3:135\n*S KotlinDebug\n*F\n+ 1 Button.kt\nnet/mcskill/shop/client/screen/component/IconButton\n*L\n70#1:135,3\n*E\n"})
public final class IconButton extends BaseButton {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(IconButton.class, "image", "getImage()Lgg/essential/elementa/components/image/ImageComponent;", 0))};

    /* JADX INFO: renamed from: image$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty image;

    public /* synthetic */ IconButton(String str, float f, float f2, float f3, LabelAlign labelAlign, Color color, float f4, float f5, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 4.0f : f, (i & 4) != 0 ? 0.0f : f2, (i & 8) != 0 ? 0.0f : f3, (i & 16) != 0 ? LabelAlign.CENTER : labelAlign, (i & 32) != 0 ? Color.WHITE : color, (i & 64) != 0 ? 26.22f : f4, (i & 128) != 0 ? 26.63f : f5, (i & 256) != 0 ? true : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconButton(@NotNull String path, float radius, float paddingX, float paddingY, @NotNull LabelAlign align, @NotNull Color imageColor, float imageWidth, float imageHeight, boolean shadow) {
        super(radius, shadow, null);
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(align, "align");
        Intrinsics.checkNotNullParameter(imageColor, "imageColor");
        ResourceLocation resourceLocationAsResource$default = ResourcesKt.asResource$default(path, (String) null, 1, (Object) null);
        Intrinsics.checkNotNullExpressionValue(resourceLocationAsResource$default, "asResource$default(...)");
        UIComponent $this$constrain$iv = new ImageComponent(resourceLocationAsResource$default, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$image_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$image_delegate_u24lambda_u240.setX(align.mo23posX(paddingX));
        $this$image_delegate_u24lambda_u240.setY(align.mo24posY(paddingY));
        $this$image_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp(Float.valueOf(imageWidth)));
        $this$image_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp(Float.valueOf(imageHeight)));
        $this$image_delegate_u24lambda_u240.setColor(UtilitiesKt.toConstraint(imageColor));
        this.image = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
    }

    @NotNull
    public final ImageComponent getImage() {
        return (ImageComponent) this.image.getValue(this, $$delegatedProperties[0]);
    }
}
