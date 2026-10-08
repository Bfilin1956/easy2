package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.ItemStackComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.WrappedText;
import gg.essential.elementa.components.image.ImageView;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.HeightConstraint;
import gg.essential.elementa.constraints.WidthConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
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
import kotlin.text.StringsKt;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.core.client.screen.component.MSRoundedRectangle;
import net.mcskill.shop.client.screen.component.Item;
import net.mcskill.shop.client.screen.modal.cases.component.DustInfoBlock;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContentEntry.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/ItemContentEntry.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lnet/mcskill/shop/client/screen/component/ItemContentEntry;", "T", "Lnet/mcskill/shop/client/screen/component/Item;", "Lnet/mcskill/shop/client/screen/component/ContentEntry;", "data", "<init>", "(Lnet/mcskill/shop/client/screen/component/Item;)V", "dataView", "Lnet/mcskill/core/client/screen/component/MSRoundedRectangle;", "getDataView", "()Lnet/mcskill/core/client/screen/component/MSRoundedRectangle;", "dataView$delegate", "Lkotlin/properties/ReadWriteProperty;", "name", "Lgg/essential/elementa/components/WrappedText;", "getName", "()Lgg/essential/elementa/components/WrappedText;", "name$delegate", "titleBox", "Lgg/essential/elementa/components/UIContainer;", "getTitleBox", "()Lgg/essential/elementa/components/UIContainer;", "titleBox$delegate", "attachViewableElement", "Lgg/essential/elementa/UIComponent;", "registryName", "", "image", "MSShop"})
@SourceDebugExtension({"SMAP\nContentEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContentEntry.kt\nnet/mcskill/shop/client/screen/component/ItemContentEntry\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,138:1\n10#2,3:139\n10#2,3:142\n10#2,3:145\n10#2,3:148\n*S KotlinDebug\n*F\n+ 1 ContentEntry.kt\nnet/mcskill/shop/client/screen/component/ItemContentEntry\n*L\n58#1:139,3\n67#1:142,3\n76#1:145,3\n84#1:148,3\n*E\n"})
public final class ItemContentEntry<T extends Item> extends ContentEntry {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ItemContentEntry.class, "dataView", "getDataView()Lnet/mcskill/core/client/screen/component/MSRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(ItemContentEntry.class, "name", "getName()Lgg/essential/elementa/components/WrappedText;", 0)), Reflection.property1(new PropertyReference1Impl(ItemContentEntry.class, "titleBox", "getTitleBox()Lgg/essential/elementa/components/UIContainer;", 0))};

    /* JADX INFO: renamed from: dataView$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty dataView;

    /* JADX INFO: renamed from: name$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty name;

    /* JADX INFO: renamed from: titleBox$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty titleBox;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemContentEntry(@NotNull T t) {
        super(t.getName(), 0.0f, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(t, "data");
        UIComponent $this$constrain$iv = new MSRoundedRectangle(false, false, 3, (DefaultConstructorMarker) null);
        UIConstraints $this$dataView_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$dataView_delegate_u24lambda_u240.setX(new CenterConstraint());
        $this$dataView_delegate_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 3));
        $this$dataView_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp((Number) 146));
        $this$dataView_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 110));
        $this$dataView_delegate_u24lambda_u240.setRadius(UtilitiesKt.getDp((Number) 9));
        $this$dataView_delegate_u24lambda_u240.setColor(UtilitiesKt.toConstraint(new Color(17, 15, 18)));
        this.dataView = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new WrappedText(getTitleState(), (State) null, (State) null, true, false, 0.0f, (String) null, 118, (DefaultConstructorMarker) null);
        UIConstraints $this$name_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$name_delegate_u24lambda_u241.setX(new CenterConstraint());
        $this$name_delegate_u24lambda_u241.setY(UtilitiesKt.getDp((Number) 3));
        $this$name_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 146));
        $this$name_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 110));
        $this$name_delegate_u24lambda_u241.setRadius(UtilitiesKt.getDp((Number) 9));
        $this$name_delegate_u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getBackgroundModal()));
        this.name = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, this), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = new UIContainer();
        UIConstraints $this$titleBox_delegate_u24lambda_u242 = $this$constrain$iv3.getConstraints();
        $this$titleBox_delegate_u24lambda_u242.setX(new CenterConstraint());
        $this$titleBox_delegate_u24lambda_u242.setY(UtilitiesKt.dp((Number) 6, true, true));
        $this$titleBox_delegate_u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 146));
        $this$titleBox_delegate_u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 40));
        this.titleBox = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, getDataView()), this, $$delegatedProperties[2]);
        UIComponent $this$constrain$iv4 = attachViewableElement(t.getRegistryName(), t.getReplaceImage());
        UIConstraints $this$_init__u24lambda_u243 = $this$constrain$iv4.getConstraints();
        $this$_init__u24lambda_u243.setX(new CenterConstraint());
        $this$_init__u24lambda_u243.setY(new CenterConstraint());
        $this$_init__u24lambda_u243.setWidth(UtilitiesKt.getDp((Number) 86));
        $this$_init__u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 86));
        ComponentsKt.childOf($this$constrain$iv4, getDataView());
    }

    @NotNull
    public final MSRoundedRectangle getDataView() {
        return (MSRoundedRectangle) this.dataView.getValue(this, $$delegatedProperties[0]);
    }

    @NotNull
    public final WrappedText getName() {
        return (WrappedText) this.name.getValue(this, $$delegatedProperties[1]);
    }

    @NotNull
    public final UIContainer getTitleBox() {
        return (UIContainer) this.titleBox.getValue(this, $$delegatedProperties[2]);
    }

    private final UIComponent attachViewableElement(String registryName, String image) {
        if (StringsKt.contains$default(registryName, "parse_error", false, 2, (Object) null)) {
            return new ImageView(image, 1.0f, 1.0f, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, (WidthConstraint) null, (HeightConstraint) null, DustInfoBlock.DELIMITER, (DefaultConstructorMarker) null);
        }
        return ItemStackComponent.Companion.of$default(ItemStackComponent.Companion, registryName, 0, 0, (String) null, 14, (Object) null);
    }
}
