package net.mcskill.shop.client.screen.section;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.image.ImageComponent;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.utils.ResourcesKt;
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
import net.mcskill.core.client.util.UtilsKt;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LogoSection.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/section/LogoSection.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lnet/mcskill/shop/client/screen/section/LogoSection;", "Lgg/essential/elementa/components/UIContainer;", "image", "", "text", "link", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "_image", "Lgg/essential/elementa/components/image/ImageComponent;", "get_image", "()Lgg/essential/elementa/components/image/ImageComponent;", "_image$delegate", "Lkotlin/properties/ReadWriteProperty;", "_title", "Lgg/essential/elementa/components/LabelComponent;", "get_title", "()Lgg/essential/elementa/components/LabelComponent;", "_title$delegate", "MSShop"})
@SourceDebugExtension({"SMAP\nLogoSection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LogoSection.kt\nnet/mcskill/shop/client/screen/section/LogoSection\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,35:1\n10#2,3:36\n10#2,3:39\n*S KotlinDebug\n*F\n+ 1 LogoSection.kt\nnet/mcskill/shop/client/screen/section/LogoSection\n*L\n16#1:36,3\n21#1:39,3\n*E\n"})
public final class LogoSection extends UIContainer {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(LogoSection.class, "_image", "get_image()Lgg/essential/elementa/components/image/ImageComponent;", 0)), Reflection.property1(new PropertyReference1Impl(LogoSection.class, "_title", "get_title()Lgg/essential/elementa/components/LabelComponent;", 0))};

    /* JADX INFO: renamed from: _image$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _image;

    /* JADX INFO: renamed from: _title$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _title;

    public LogoSection(@NotNull String image, @NotNull String text, @Nullable String link) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(text, "text");
        ResourceLocation resourceLocationAsResource$default = ResourcesKt.asResource$default(image, (String) null, 1, (Object) null);
        Intrinsics.checkNotNullExpressionValue(resourceLocationAsResource$default, "asResource$default(...)");
        UIComponent $this$constrain$iv = new ImageComponent(resourceLocationAsResource$default, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_image_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_image_delegate_u24lambda_u240.setWidth(ConstraintsKt.plus(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null), UtilitiesKt.getPixel((Number) 4)));
        $this$_image_delegate_u24lambda_u240.setHeight(new FillConstraint(false));
        this._image = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new LabelComponent(text, false, (Color) null, 4, (DefaultConstructorMarker) null);
        UIConstraints $this$_title_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_title_delegate_u24lambda_u241.setX(new SiblingConstraint(0.0f, false, false, 7, (DefaultConstructorMarker) null));
        $this$_title_delegate_u24lambda_u241.setY(new CenterConstraint());
        $this$_title_delegate_u24lambda_u241.setTextScale(UtilitiesKt.getDp((Number) 32));
        $this$_title_delegate_u24lambda_u241.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        this._title = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
        String str = link;
        if (str == null || str.length() == 0) {
            return;
        }
        onMouseClick((v1, v2) -> {
            return _init_$lambda$2(r1, v1, v2);
        });
    }

    public /* synthetic */ LogoSection(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3);
    }

    private final ImageComponent get_image() {
        return (ImageComponent) this._image.getValue(this, $$delegatedProperties[0]);
    }

    private final LabelComponent get_title() {
        return (LabelComponent) this._title.getValue(this, $$delegatedProperties[1]);
    }

    private static final Unit _init_$lambda$2(String $link, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        UtilsKt.openAsUrl($link);
        return Unit.INSTANCE;
    }
}
