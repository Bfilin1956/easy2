package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.components.WrappedText;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.state.BasicState;
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
import net.mcskill.shop.client.MSShopClient;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EntryComponent.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/EntryComponent.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lnet/mcskill/shop/client/screen/component/EntryComponent;", "Lgg/essential/elementa/components/UIRoundedRectangle;", "name", "", "textPosY", "", "radius", "", "maxTitleWidth", "fontScale", "<init>", "(Ljava/lang/String;IFII)V", "getName", "()Ljava/lang/String;", "title", "Lgg/essential/elementa/components/WrappedText;", "getTitle", "()Lgg/essential/elementa/components/WrappedText;", "title$delegate", "Lkotlin/properties/ReadWriteProperty;", "fetchColorBy", "Lgg/essential/elementa/state/BasicState;", "Ljava/awt/Color;", "discount", "MSShop"})
@SourceDebugExtension({"SMAP\nEntryComponent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntryComponent.kt\nnet/mcskill/shop/client/screen/component/EntryComponent\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,47:1\n10#2,3:48\n10#2,3:51\n*S KotlinDebug\n*F\n+ 1 EntryComponent.kt\nnet/mcskill/shop/client/screen/component/EntryComponent\n*L\n22#1:48,3\n31#1:51,3\n*E\n"})
public abstract class EntryComponent extends UIRoundedRectangle {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(EntryComponent.class, "title", "getTitle()Lgg/essential/elementa/components/WrappedText;", 0))};

    @NotNull
    private final String name;

    /* JADX INFO: renamed from: title$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty title;

    public /* synthetic */ EntryComponent(String str, int i, float f, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i4 & 2) != 0 ? 14 : i, (i4 & 4) != 0 ? 10.0f : f, (i4 & 8) != 0 ? 260 : i2, (i4 & 16) != 0 ? 20 : i3);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntryComponent(@NotNull String name, int textPosY, float radius, int maxTitleWidth, int fontScale) {
        super(radius, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        UIComponent $this$constrain$iv = new WrappedText(this.name, false, (Color) null, true, false, 0.0f, (String) null, 118, (DefaultConstructorMarker) null);
        UIConstraints $this$title_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$title_delegate_u24lambda_u240.setX(new CenterConstraint());
        $this$title_delegate_u24lambda_u240.setY(UtilitiesKt.getDp(Integer.valueOf(textPosY)));
        $this$title_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp(Integer.valueOf(maxTitleWidth)));
        $this$title_delegate_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$title_delegate_u24lambda_u240.setTextScale(UtilitiesKt.getDp(Integer.valueOf(fontScale)));
        this.title = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        UIConstraints $this$_init__u24lambda_u241 = ((UIComponent) this).getConstraints();
        $this$_init__u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getSidebar()));
    }

    @NotNull
    public final WrappedText getTitle() {
        return (WrappedText) this.title.getValue(this, $$delegatedProperties[0]);
    }

    @NotNull
    public final BasicState<Color> fetchColorBy(int discount) {
        if (MSShopClient.INSTANCE.getEnableDiscountColors$MSShop()) {
            boolean z = 10 <= discount && discount < 20;
            if (z) {
                return MSPalette.INSTANCE.getPink();
            }
            boolean z2 = 20 <= discount && discount < 40;
            if (z2) {
                return MSPalette.INSTANCE.getGold();
            }
            boolean z3 = 40 <= discount && discount < 50;
            if (z3) {
                return MSPalette.INSTANCE.getGreen();
            }
            boolean z4 = 50 <= discount && discount < 100;
            return z4 ? MSPalette.INSTANCE.getPurple() : MSPalette.INSTANCE.getBlue();
        }
        return MSPalette.INSTANCE.getBlue();
    }
}
