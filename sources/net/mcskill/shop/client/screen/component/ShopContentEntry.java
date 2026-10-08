package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.RoundOutlineEffect;
import gg.essential.elementa.effects.StencilEffect;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.State;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContentEntry.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/ShopContentEntry.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0002R\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR$\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f²\u0006\n\u0010 \u001a\u00020!X\u008a\u0084\u0002"}, d2 = {"Lnet/mcskill/shop/client/screen/component/ShopContentEntry;", "T", "Lnet/mcskill/shop/client/screen/component/ContentEntry;", "Lnet/mcskill/shop/client/screen/component/DiscountableEntry;", "", "data", "<init>", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "borderColorState", "Lgg/essential/elementa/state/State;", "Ljava/awt/Color;", "getBorderColorState", "()Lgg/essential/elementa/state/State;", "strokeWidthState", "", "getStrokeWidthState", "smoothRadius", "getSmoothRadius", "discountState", "getDiscountState", "value", "discount", "getDiscount", "()Ljava/lang/Integer;", "setDiscount", "(I)V", "attachDiscountEffect", "", "MSShop", "discountPlate", "Lnet/mcskill/shop/client/screen/component/TriangleBlock;"})
@SourceDebugExtension({"SMAP\nContentEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContentEntry.kt\nnet/mcskill/shop/client/screen/component/ShopContentEntry\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,138:1\n10#2,3:139\n10#2,3:142\n*S KotlinDebug\n*F\n+ 1 ContentEntry.kt\nnet/mcskill/shop/client/screen/component/ShopContentEntry\n*L\n42#1:139,3\n48#1:142,3\n*E\n"})
public final class ShopContentEntry<T> extends ContentEntry implements DiscountableEntry<Integer> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(ShopContentEntry.class, "discountPlate", "<v#0>", 0))};
    private final T data;

    @NotNull
    private final State<Color> borderColorState;

    @NotNull
    private final State<Float> strokeWidthState;

    @NotNull
    private final State<Float> smoothRadius;

    @NotNull
    private final State<Integer> discountState;

    public ShopContentEntry(T t) {
        super("Hello, World", 0.0f, 2, (DefaultConstructorMarker) null);
        this.data = t;
        this.borderColorState = new BasicState<>(MSPalette.INSTANCE.getBlue().get());
        this.strokeWidthState = new BasicState<>(Float.valueOf(1.0f));
        this.smoothRadius = new BasicState<>(Float.valueOf(0.7f));
        this.discountState = new BasicState<>(0);
        attachDiscountEffect();
    }

    public final T getData() {
        return this.data;
    }

    @Override // net.mcskill.shop.client.screen.component.DiscountableEntry
    public /* bridge */ /* synthetic */ void setDiscount(Number number) {
        setDiscount(number.intValue());
    }

    @NotNull
    public final State<Color> getBorderColorState() {
        return this.borderColorState;
    }

    @NotNull
    public final State<Float> getStrokeWidthState() {
        return this.strokeWidthState;
    }

    @NotNull
    public final State<Float> getSmoothRadius() {
        return this.smoothRadius;
    }

    @Override // net.mcskill.shop.client.screen.component.DiscountableEntry
    @NotNull
    public State<Integer> getDiscountState() {
        return this.discountState;
    }

    @Override // net.mcskill.shop.client.screen.component.DiscountableEntry
    @NotNull
    public Integer getDiscount() {
        return (Integer) getDiscountState().get();
    }

    public void setDiscount(int value) {
        getDiscountState().set(Integer.valueOf(value));
    }

    private final void attachDiscountEffect() {
        if (getDiscount().intValue() <= 0) {
            return;
        }
        ComponentsKt.effect(this, new RoundOutlineEffect(this.borderColorState, getRadiusState(), this.strokeWidthState, this.smoothRadius, false, 16, (DefaultConstructorMarker) null));
        ComponentsKt.effect(this, new StencilEffect());
        UIComponent $this$constrain$iv = new TriangleBlock((State<Color>) MSPalette.INSTANCE.getBlue());
        UIConstraints $this$attachDiscountEffect_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$attachDiscountEffect_u24lambda_u240.setX(UtilitiesKt.dp$default((Number) 2, true, false, 2, (Object) null));
        $this$attachDiscountEffect_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 2));
        $this$attachDiscountEffect_u24lambda_u240.setWidth(UtilitiesKt.getDp((Number) 63));
        $this$attachDiscountEffect_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 63));
        ReadWriteProperty discountPlate$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, this), (Object) null, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new LabelComponent("§l-" + getDiscount() + "%", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$attachDiscountEffect_u24lambda_u242 = $this$constrain$iv2.getConstraints();
        $this$attachDiscountEffect_u24lambda_u242.setX(UtilitiesKt.dp$default((Number) 5, true, false, 2, (Object) null));
        $this$attachDiscountEffect_u24lambda_u242.setY(UtilitiesKt.getDp((Number) 16));
        $this$attachDiscountEffect_u24lambda_u242.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$attachDiscountEffect_u24lambda_u242.setTextScale(UtilitiesKt.getDp((Number) 14));
        ComponentsKt.childOf($this$constrain$iv2, attachDiscountEffect$lambda$1(discountPlate$delegate));
    }

    private static final TriangleBlock attachDiscountEffect$lambda$1(ReadWriteProperty<Object, TriangleBlock> readWriteProperty) {
        return (TriangleBlock) readWriteProperty.getValue((Object) null, $$delegatedProperties[0]);
    }
}
