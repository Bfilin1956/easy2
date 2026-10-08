package net.mcskill.shop.client.screen.tab.groups;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.Window;
import gg.essential.elementa.components.image.ImageView;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedMaxSizeConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.CramSiblingConstraint;
import gg.essential.elementa.constraints.HeightConstraint;
import gg.essential.elementa.constraints.WidthConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.RoundOutlineEffect;
import gg.essential.elementa.effects.StencilEffect;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.state.State;
import java.awt.Color;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.core.common.util.TimeUtil;
import net.mcskill.shop.client.screen.ShopScreen;
import net.mcskill.shop.client.screen.component.EntryComponent;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.component.NewPriceGroup;
import net.mcskill.shop.client.screen.component.TriangleBlock;
import net.mcskill.shop.client.screen.modal.cases.component.DustInfoBlock;
import net.mcskill.shop.client.screen.modal.group.BuyGroupModal;
import net.mcskill.shop.client.screen.modal.group.InfoGroupModal;
import net.mcskill.shop.common.response.shop.GroupData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GroupEntry.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/tab/groups/GroupEntry.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0017\u001a\u00020\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019²\u0006\n\u0010\u001a\u001a\u00020\u001bX\u008a\u0084\u0002"}, d2 = {"Lnet/mcskill/shop/client/screen/tab/groups/GroupEntry;", "Lnet/mcskill/shop/client/screen/component/EntryComponent;", "group", "Lnet/mcskill/shop/common/response/shop/GroupData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/GroupData;)V", "getGroup", "()Lnet/mcskill/shop/common/response/shop/GroupData;", "_prices", "", "Lnet/mcskill/shop/client/screen/tab/groups/GroupEntry$PriceData;", "[Lnet/mcskill/shop/client/screen/tab/groups/GroupEntry$PriceData;", "_logo", "Lgg/essential/elementa/components/image/ImageView;", "get_logo", "()Lgg/essential/elementa/components/image/ImageView;", "_logo$delegate", "Lkotlin/properties/ReadWriteProperty;", "_buyButton", "Lnet/mcskill/shop/client/screen/component/LabelButton;", "get_buyButton", "()Lnet/mcskill/shop/client/screen/component/LabelButton;", "_buyButton$delegate", "availablePrice", "PriceData", "MSShop", "discountPlate", "Lnet/mcskill/shop/client/screen/component/TriangleBlock;"})
@SourceDebugExtension({"SMAP\nGroupEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GroupEntry.kt\nnet/mcskill/shop/client/screen/tab/groups/GroupEntry\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,141:1\n10#2,3:142\n10#2,3:145\n10#2,3:148\n10#2,3:151\n10#2,3:154\n10#2,3:157\n10#2,3:160\n3829#3:163\n4344#3,2:164\n1971#4,14:166\n*S KotlinDebug\n*F\n+ 1 GroupEntry.kt\nnet/mcskill/shop/client/screen/tab/groups/GroupEntry\n*L\n35#1:142,3\n42#1:145,3\n51#1:148,3\n62#1:151,3\n71#1:154,3\n109#1:157,3\n115#1:160,3\n125#1:163\n125#1:164,2\n125#1:166,14\n*E\n"})
public final class GroupEntry extends EntryComponent {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(GroupEntry.class, "_logo", "get_logo()Lgg/essential/elementa/components/image/ImageView;", 0)), Reflection.property1(new PropertyReference1Impl(GroupEntry.class, "_buyButton", "get_buyButton()Lnet/mcskill/shop/client/screen/component/LabelButton;", 0)), Reflection.property0(new PropertyReference0Impl(GroupEntry.class, "discountPlate", "<v#0>", 0))};

    @NotNull
    private final GroupData group;

    @NotNull
    private final PriceData[] _prices;

    /* JADX INFO: renamed from: _logo$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _logo;

    /* JADX INFO: renamed from: _buyButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _buyButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupEntry(@NotNull GroupData group) {
        super(group.getPrettyName(), 0, 0.0f, 180, 18, 6, null);
        Intrinsics.checkNotNullParameter(group, "group");
        this.group = group;
        this._prices = new PriceData[]{new PriceData(this.group.getPriceEmMonth(), 0, 0, this.group.getSellEmMonth()), new PriceData(this.group.getPriceMonth(), this.group.getDiscountMonth(), this.group.getPriceMonthDiscount(), this.group.getSellMonth()), new PriceData(this.group.getPriceYear(), this.group.getDiscountYear(), this.group.getPriceYearDiscount(), this.group.getSellYear()), new PriceData(this.group.getPricePerm(), this.group.getDiscountPerm(), this.group.getPricePermDiscount(), this.group.getSellPerm())};
        Object[] objArr = {this.group.getPexName()};
        String str = String.format(ShopScreen.GROUP_IMG_DIR, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        UIComponent $this$constrain$iv = new ImageView(str, 1.0f, 1.0f, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, (WidthConstraint) null, (HeightConstraint) null, DustInfoBlock.DELIMITER, (DefaultConstructorMarker) null);
        UIConstraints $this$_logo_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_logo_delegate_u24lambda_u240.setX(new CenterConstraint());
        $this$_logo_delegate_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 50));
        $this$_logo_delegate_u24lambda_u240.setWidth(UtilitiesKt.getPercent((Number) 96));
        $this$_logo_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 196));
        this._logo = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new LabelButton("Подробнее", 18, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$_buyButton_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_buyButton_delegate_u24lambda_u241.setX(new CenterConstraint());
        $this$_buyButton_delegate_u24lambda_u241.setY(UtilitiesKt.getDp((Number) 276));
        $this$_buyButton_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 164));
        $this$_buyButton_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 31));
        $this$_buyButton_delegate_u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this._buyButton = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
        UIConstraints $this$_init__u24lambda_u242 = ((UIComponent) this).getConstraints();
        $this$_init__u24lambda_u242.setX(new CramSiblingConstraint(19.0f));
        $this$_init__u24lambda_u242.setY(new CramSiblingConstraint(19.0f));
        $this$_init__u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 228));
        $this$_init__u24lambda_u242.setHeight(UtilitiesKt.getDp((Number) 326));
        PriceData available = availablePrice();
        if (available.getValue() > 0 && !this.group.getPurchase().getStatus()) {
            boolean availableRubPrice = this.group.getPriceMonth() > 0 || this.group.getPriceYear() > 0 || this.group.getPricePerm() > 0;
            String currency = availableRubPrice ? "ruble" : "emerald";
            UIComponent $this$constrain$iv3 = new NewPriceGroup(available, currency);
            UIConstraints $this$_init__u24lambda_u243 = $this$constrain$iv3.getConstraints();
            $this$_init__u24lambda_u243.setX(new CenterConstraint());
            $this$_init__u24lambda_u243.setY(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 6, true, true), get_logo()));
            $this$_init__u24lambda_u243.setWidth(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null));
            $this$_init__u24lambda_u243.setHeight(new ChildBasedMaxSizeConstraint());
            ComponentsKt.childOf($this$constrain$iv3, (UIComponent) this);
        }
        if (this.group.getPurchase().getStatus()) {
            UIComponent $this$constrain$iv4 = new LabelComponent((String) null, false, (Color) null, 7, (DefaultConstructorMarker) null);
            UIConstraints $this$_init__u24lambda_u244 = $this$constrain$iv4.getConstraints();
            $this$_init__u24lambda_u244.setX(new CenterConstraint());
            $this$_init__u24lambda_u244.setY(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 8, true, true), get_logo()));
            $this$_init__u24lambda_u244.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
            $this$_init__u24lambda_u244.setTextScale(UtilitiesKt.getDp((Number) 16));
            $this$_init__u24lambda_u244.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA5()));
            LabelComponent info = ComponentsKt.childOf($this$constrain$iv4, (UIComponent) this);
            if (this.group.getPurchase().getExpiry().getEpochSecond() == 0) {
                info.setText("§lНавсегда");
                get_buyButton().getLabel().setText("Подробнее");
                get_buyButton().onMouseClick((v1, v2) -> {
                    return _init_$lambda$5(r1, v1, v2);
                });
            } else {
                info.setText("§lДо " + this.group.getPurchase().getExpiry().atZone(ZoneId.systemDefault()).format(TimeUtil.INSTANCE.getDateTimeFormatter()));
                info.setColor((Color) MSPalette.INSTANCE.getOrange().get());
                get_buyButton().getLabel().setText("Продлить");
                get_buyButton().onMouseClick((v1, v2) -> {
                    return _init_$lambda$6(r1, v1, v2);
                });
            }
            get_buyButton().setColor((Color) MSPalette.INSTANCE.getBlue().get());
        } else {
            get_buyButton().onMouseClick((v1, v2) -> {
                return _init_$lambda$7(r1, v1, v2);
            });
        }
        Integer numMaxOrNull = ArraysKt.maxOrNull(new int[]{this.group.getDiscountMonth(), this.group.getDiscountYear(), this.group.getDiscountPerm()});
        int maxPercent = numMaxOrNull != null ? numMaxOrNull.intValue() : 0;
        if (maxPercent > 0) {
            State stateFetchColorBy = fetchColorBy(maxPercent);
            ComponentsKt.effect((UIComponent) this, new RoundOutlineEffect((Color) stateFetchColorBy.get(), 6.0f, 1.5f, 0.7f, false, 16, (DefaultConstructorMarker) null));
            ComponentsKt.effect((UIComponent) this, new StencilEffect());
            UIComponent $this$constrain$iv5 = new TriangleBlock((State<Color>) stateFetchColorBy);
            UIConstraints $this$_init__u24lambda_u248 = $this$constrain$iv5.getConstraints();
            $this$_init__u24lambda_u248.setX(UtilitiesKt.dp$default((Number) 2, true, false, 2, (Object) null));
            $this$_init__u24lambda_u248.setY(UtilitiesKt.getDp((Number) 2));
            $this$_init__u24lambda_u248.setWidth(UtilitiesKt.getDp((Number) 63));
            $this$_init__u24lambda_u248.setHeight(UtilitiesKt.getDp((Number) 63));
            ReadWriteProperty discountPlate$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv5, (UIComponent) this), (Object) null, $$delegatedProperties[2]);
            UIComponent $this$constrain$iv6 = new LabelComponent("§l-" + maxPercent + "%", false, (Color) null, 6, (DefaultConstructorMarker) null);
            UIConstraints $this$_init__u24lambda_u2410 = $this$constrain$iv6.getConstraints();
            $this$_init__u24lambda_u2410.setX(UtilitiesKt.dp$default((Number) 5, true, false, 2, (Object) null));
            $this$_init__u24lambda_u2410.setY(UtilitiesKt.getDp((Number) 16));
            $this$_init__u24lambda_u2410.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
            $this$_init__u24lambda_u2410.setTextScale(UtilitiesKt.getDp((Number) 14));
            ComponentsKt.childOf($this$constrain$iv6, _init_$lambda$9(discountPlate$delegate));
        }
    }

    @NotNull
    public final GroupData getGroup() {
        return this.group;
    }

    private final ImageView get_logo() {
        return (ImageView) this._logo.getValue(this, $$delegatedProperties[0]);
    }

    private final LabelButton get_buyButton() {
        return (LabelButton) this._buyButton.getValue(this, $$delegatedProperties[1]);
    }

    private static final Unit _init_$lambda$5(GroupEntry this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ComponentsKt.childOf(new InfoGroupModal(this$0.group), Window.Companion.of($this$onMouseClick));
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$6(GroupEntry this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ComponentsKt.childOf(new BuyGroupModal(this$0.group, true), Window.Companion.of($this$onMouseClick));
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$7(GroupEntry this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ComponentsKt.childOf(new BuyGroupModal(this$0.group, false, 2, null), Window.Companion.of($this$onMouseClick));
        return Unit.INSTANCE;
    }

    private static final TriangleBlock _init_$lambda$9(ReadWriteProperty<Object, TriangleBlock> readWriteProperty) {
        return (TriangleBlock) readWriteProperty.getValue((Object) null, $$delegatedProperties[2]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r8v6 */
    private final PriceData availablePrice() {
        Object obj;
        PriceData[] priceDataArr = this._prices;
        ArrayList arrayList = new ArrayList();
        for (PriceData priceData : priceDataArr) {
            if (priceData.isActive()) {
                arrayList.add(priceData);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                boolean z = ((PriceData) next).getPriceDiscount() > 0;
                do {
                    Object next2 = it.next();
                    ?? r10 = ((PriceData) next2).getPriceDiscount() > 0;
                    if ((z ? 1 : 0) < r10) {
                        next = next2;
                        z = r10 == true ? 1 : 0;
                    }
                } while (it.hasNext());
                obj = next;
            } else {
                obj = next;
            }
        } else {
            obj = null;
        }
        PriceData priceData2 = (PriceData) obj;
        return priceData2 == null ? PriceData.INSTANCE.getEMPTY() : priceData2;
    }

    /* JADX INFO: compiled from: GroupEntry.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/tab/groups/GroupEntry$PriceData.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013¨\u0006\""}, d2 = {"Lnet/mcskill/shop/client/screen/tab/groups/GroupEntry$PriceData;", "", "value", "", "discount", "priceDiscount", "enabled", "", "<init>", "(IIIZ)V", "getValue", "()I", "setValue", "(I)V", "getDiscount", "setDiscount", "getPriceDiscount", "setPriceDiscount", "getEnabled", "()Z", "setEnabled", "(Z)V", "isActive", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "MSShop"})
    public static final /* data */ class PriceData {
        private int value;
        private int discount;
        private int priceDiscount;
        private boolean enabled;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private static final PriceData EMPTY = new PriceData(0, 0, 0, false);

        public final int component1() {
            return this.value;
        }

        public final int component2() {
            return this.discount;
        }

        public final int component3() {
            return this.priceDiscount;
        }

        public final boolean component4() {
            return this.enabled;
        }

        @NotNull
        public final PriceData copy(int value, int discount, int priceDiscount, boolean enabled) {
            return new PriceData(value, discount, priceDiscount, enabled);
        }

        public static /* synthetic */ PriceData copy$default(PriceData priceData, int i, int i2, int i3, boolean z, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = priceData.value;
            }
            if ((i4 & 2) != 0) {
                i2 = priceData.discount;
            }
            if ((i4 & 4) != 0) {
                i3 = priceData.priceDiscount;
            }
            if ((i4 & 8) != 0) {
                z = priceData.enabled;
            }
            return priceData.copy(i, i2, i3, z);
        }

        @NotNull
        public String toString() {
            return "PriceData(value=" + this.value + ", discount=" + this.discount + ", priceDiscount=" + this.priceDiscount + ", enabled=" + this.enabled + ")";
        }

        public int hashCode() {
            int result = Integer.hashCode(this.value);
            return (((((result * 31) + Integer.hashCode(this.discount)) * 31) + Integer.hashCode(this.priceDiscount)) * 31) + Boolean.hashCode(this.enabled);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PriceData)) {
                return false;
            }
            PriceData priceData = (PriceData) other;
            return this.value == priceData.value && this.discount == priceData.discount && this.priceDiscount == priceData.priceDiscount && this.enabled == priceData.enabled;
        }

        public PriceData(int value, int discount, int priceDiscount, boolean enabled) {
            this.value = value;
            this.discount = discount;
            this.priceDiscount = priceDiscount;
            this.enabled = enabled;
        }

        public final int getValue() {
            return this.value;
        }

        public final void setValue(int i) {
            this.value = i;
        }

        public final int getDiscount() {
            return this.discount;
        }

        public final void setDiscount(int i) {
            this.discount = i;
        }

        public final int getPriceDiscount() {
            return this.priceDiscount;
        }

        public final void setPriceDiscount(int i) {
            this.priceDiscount = i;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final void setEnabled(boolean z) {
            this.enabled = z;
        }

        public final boolean isActive() {
            return this.value > 0 && this.enabled;
        }

        /* JADX INFO: compiled from: GroupEntry.kt */
        /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/tab/groups/GroupEntry$PriceData$Companion.class */
        @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lnet/mcskill/shop/client/screen/tab/groups/GroupEntry$PriceData$Companion;", "", "<init>", "()V", "EMPTY", "Lnet/mcskill/shop/client/screen/tab/groups/GroupEntry$PriceData;", "getEMPTY", "()Lnet/mcskill/shop/client/screen/tab/groups/GroupEntry$PriceData;", "MSShop"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            private Companion() {
            }

            @NotNull
            public final PriceData getEMPTY() {
                return PriceData.EMPTY;
            }
        }
    }
}
