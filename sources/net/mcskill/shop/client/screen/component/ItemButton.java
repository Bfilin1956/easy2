package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.ItemStackComponent;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/ItemButton.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lnet/mcskill/shop/client/screen/component/ItemButton;", "Lnet/mcskill/shop/client/screen/component/BaseButton;", "registryName", "", "amount", "", "meta", "nbt", "itemWidth", "", "itemHeight", "radius", "", "shadow", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/Number;Ljava/lang/Number;FZ)V", "item", "Lgg/essential/elementa/components/ItemStackComponent;", "getItem", "()Lgg/essential/elementa/components/ItemStackComponent;", "item$delegate", "Lkotlin/properties/ReadWriteProperty;", "MSShop"})
@SourceDebugExtension({"SMAP\nButton.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Button.kt\nnet/mcskill/shop/client/screen/component/ItemButton\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,134:1\n10#2,3:135\n*S KotlinDebug\n*F\n+ 1 Button.kt\nnet/mcskill/shop/client/screen/component/ItemButton\n*L\n32#1:135,3\n*E\n"})
public final class ItemButton extends BaseButton {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ItemButton.class, "item", "getItem()Lgg/essential/elementa/components/ItemStackComponent;", 0))};

    /* JADX INFO: renamed from: item$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty item;

    public /* synthetic */ ItemButton(String str, int i, int i2, String str2, Number number, Number number2, float f, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 1 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? (Number) 28 : number, (i3 & 32) != 0 ? (Number) 28 : number2, (i3 & 64) != 0 ? 4.0f : f, (i3 & 128) != 0 ? true : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemButton(@NotNull String registryName, int amount, int meta, @NotNull String nbt, @NotNull Number itemWidth, @NotNull Number itemHeight, float radius, boolean shadow) {
        super(radius, shadow, null);
        Intrinsics.checkNotNullParameter(registryName, "registryName");
        Intrinsics.checkNotNullParameter(nbt, "nbt");
        Intrinsics.checkNotNullParameter(itemWidth, "itemWidth");
        Intrinsics.checkNotNullParameter(itemHeight, "itemHeight");
        UIComponent $this$constrain$iv = ItemStackComponent.Companion.of(registryName, amount, meta, nbt);
        UIConstraints $this$item_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$item_delegate_u24lambda_u240.setX(new CenterConstraint());
        $this$item_delegate_u24lambda_u240.setY(new CenterConstraint());
        $this$item_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp(itemWidth));
        $this$item_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp(itemHeight));
        this.item = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
    }

    @NotNull
    public final ItemStackComponent getItem() {
        return (ItemStackComponent) this.item.getValue(this, $$delegatedProperties[0]);
    }
}
