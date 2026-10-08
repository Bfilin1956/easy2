package net.mcskill.shop.client.screen.modal.group;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.Window;
import gg.essential.elementa.components.WrappedText;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.RoundOutlineEffect;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.ExtensionsKt;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.MSCoreClient;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.core.client.util.UtilsKt;
import net.mcskill.shop.client.screen.component.IconButton;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.component.NewPriceGroup;
import net.mcskill.shop.client.screen.component.Select;
import net.mcskill.shop.client.screen.tab.groups.GroupEntry;
import net.mcskill.shop.common.network.ChannelHandler;
import net.mcskill.shop.common.network.packet.buy.RequestBuyGroupPacket;
import net.mcskill.shop.common.response.shop.GroupData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BuyGroupModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/group/BuyGroupModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\u000b\u001a\u00020\f*\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0014X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u0084\u0002²\u0006\n\u0010\u001a\u001a\u00020\u001bX\u008a\u0084\u0002"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/group/BuyGroupModal;", "Lnet/mcskill/shop/client/screen/modal/group/BaseGroupModal;", "group", "Lnet/mcskill/shop/common/response/shop/GroupData;", "isExtend", "", "<init>", "(Lnet/mcskill/shop/common/response/shop/GroupData;Z)V", "getGroup", "()Lnet/mcskill/shop/common/response/shop/GroupData;", "()Z", "initAvailable", "", "availablePrice", "Lnet/mcskill/shop/client/screen/tab/groups/GroupEntry$PriceData;", "findTime", "", "price", "MSShop", "extPeriod", "Lgg/essential/elementa/components/LabelComponent;", "periodSelect", "Lnet/mcskill/shop/client/screen/component/Select;", "totalPrice", "priceGroup", "Lnet/mcskill/shop/client/screen/component/NewPriceGroup;", "buyButton", "Lgg/essential/elementa/UIComponent;"})
@SourceDebugExtension({"SMAP\nBuyGroupModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuyGroupModal.kt\nnet/mcskill/shop/client/screen/modal/group/BuyGroupModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,175:1\n10#2,3:176\n10#2,3:186\n10#2,3:193\n10#2,3:196\n10#2,3:199\n10#2,3:202\n10#2,3:205\n360#3,7:179\n1557#3:189\n1628#3,3:190\n1971#3,14:211\n3829#4:208\n4344#4,2:209\n*S KotlinDebug\n*F\n+ 1 BuyGroupModal.kt\nnet/mcskill/shop/client/screen/modal/group/BuyGroupModal\n*L\n34#1:176,3\n63#1:186,3\n74#1:193,3\n81#1:196,3\n89#1:199,3\n96#1:202,3\n112#1:205,3\n58#1:179,7\n72#1:189\n72#1:190,3\n165#1:211,14\n165#1:208\n165#1:209,2\n*E\n"})
public final class BuyGroupModal extends BaseGroupModal {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(BuyGroupModal.class, "extPeriod", "<v#0>", 0)), Reflection.property0(new PropertyReference0Impl(BuyGroupModal.class, "periodSelect", "<v#1>", 0)), Reflection.property0(new PropertyReference0Impl(BuyGroupModal.class, "totalPrice", "<v#2>", 0)), Reflection.property0(new PropertyReference0Impl(BuyGroupModal.class, "priceGroup", "<v#3>", 0)), Reflection.property0(new PropertyReference0Impl(BuyGroupModal.class, "buyButton", "<v#4>", 0))};

    @NotNull
    private final GroupData group;
    private final boolean isExtend;

    public /* synthetic */ BuyGroupModal(GroupData groupData, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(groupData, (i & 2) != 0 ? false : z);
    }

    @NotNull
    public final GroupData getGroup() {
        return this.group;
    }

    public final boolean isExtend() {
        return this.isExtend;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuyGroupModal(@NotNull GroupData group, boolean isExtend) {
        super(isExtend ? "Продление привилегии" : "Покупка привилегии", group);
        Intrinsics.checkNotNullParameter(group, "group");
        this.group = group;
        this.isExtend = isExtend;
        initAvailable(this.group);
    }

    private final void initAvailable(GroupData $this$initAvailable) {
        int i;
        if ($this$initAvailable.getPriceMonth() <= 0 && $this$initAvailable.getPriceYear() <= 0 && $this$initAvailable.getPricePerm() <= 0 && $this$initAvailable.getPriceEmMonth() <= 0) {
            UIComponent $this$constrain$iv = new WrappedText("§l" + $this$initAvailable.getShortStory(), false, (Color) null, false, false, 0.0f, (String) null, 126, (DefaultConstructorMarker) null);
            UIConstraints $this$initAvailable_u24lambda_u240 = $this$constrain$iv.getConstraints();
            $this$initAvailable_u24lambda_u240.setX(UtilitiesKt.getDp((Number) 70));
            $this$initAvailable_u24lambda_u240.setY(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 25, true, true), get_groupNameLabel()));
            $this$initAvailable_u24lambda_u240.setWidth(UtilitiesKt.getDp((Number) 230));
            $this$initAvailable_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
            $this$initAvailable_u24lambda_u240.setTextScale(UtilitiesKt.getDp((Number) 18));
            ComponentsKt.childOf($this$constrain$iv, getContent());
            return;
        }
        GroupEntry.PriceData priceData = availablePrice();
        List periodList = new ArrayList();
        if ($this$initAvailable.getSellMonth() || $this$initAvailable.getSellEmMonth()) {
            periodList.add(TuplesKt.to("На месяц", Integer.valueOf($this$initAvailable.getPriceMonth() > 0 ? $this$initAvailable.getPriceMonth() : $this$initAvailable.getPriceEmMonth())));
        }
        if ($this$initAvailable.getSellYear()) {
            periodList.add(TuplesKt.to("На год", Integer.valueOf($this$initAvailable.getPriceYear())));
        }
        if ($this$initAvailable.getSellPerm()) {
            periodList.add(TuplesKt.to("Навсегда", Integer.valueOf($this$initAvailable.getPricePerm())));
        }
        int index$iv = 0;
        Iterator it = periodList.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                Pair it2 = (Pair) item$iv;
                if (((Number) it2.getSecond()).intValue() == priceData.getValue()) {
                    i = index$iv;
                    break;
                }
                index$iv++;
            } else {
                i = -1;
                break;
            }
        }
        int validIndex = i;
        String periodTitle = this.isExtend ? "§lСрок продления:" : "§lСрок покупки:";
        UIComponent $this$constrain$iv2 = new LabelComponent(periodTitle, false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$initAvailable_u24lambda_u242 = $this$constrain$iv2.getConstraints();
        $this$initAvailable_u24lambda_u242.setX(UtilitiesKt.getDp((Number) 70));
        $this$initAvailable_u24lambda_u242.setY(ConstraintsKt.boundTo(UtilitiesKt.dp(Float.valueOf(21.0f), true, true), get_groupNameLabel()));
        $this$initAvailable_u24lambda_u242.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$initAvailable_u24lambda_u242.setTextScale(UtilitiesKt.getDp((Number) 18));
        ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, getContent()), (Object) null, $$delegatedProperties[0]);
        List $this$map$iv = periodList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Pair it3 = (Pair) item$iv$iv;
            destination$iv$iv.add((String) it3.getFirst());
        }
        UIComponent $this$constrain$iv3 = new Select(validIndex, (List) destination$iv$iv, 0, 0.0f, (Color) MSPalette.INSTANCE.getBackgroundModal().get(), 12, null);
        UIConstraints $this$initAvailable_u24lambda_u245 = $this$constrain$iv3.getConstraints();
        $this$initAvailable_u24lambda_u245.setX(UtilitiesKt.getDp((Number) 70));
        $this$initAvailable_u24lambda_u245.setY(new SiblingConstraint(7.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$initAvailable_u24lambda_u245.setWidth(UtilitiesKt.getDp((Number) 201));
        $this$initAvailable_u24lambda_u245.setHeight(UtilitiesKt.getDp((Number) 32));
        ReadWriteProperty periodSelect$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, getContent()), (Object) null, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv4 = new LabelComponent("§lИтого:", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$initAvailable_u24lambda_u247 = $this$constrain$iv4.getConstraints();
        $this$initAvailable_u24lambda_u247.setX(UtilitiesKt.getDp((Number) 70));
        $this$initAvailable_u24lambda_u247.setY(new SiblingConstraint(20.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$initAvailable_u24lambda_u247.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$initAvailable_u24lambda_u247.setTextScale(UtilitiesKt.getDp((Number) 20));
        ReadWriteProperty totalPrice$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, getContent()), (Object) null, $$delegatedProperties[2]);
        String currency = ($this$initAvailable.getPriceMonth() > 0 || $this$initAvailable.getPriceYear() > 0 || $this$initAvailable.getPricePerm() > 0) ? "ruble" : "emerald";
        UIComponent $this$constrain$iv5 = new NewPriceGroup(priceData, currency);
        UIConstraints $this$initAvailable_u24lambda_u249 = $this$constrain$iv5.getConstraints();
        $this$initAvailable_u24lambda_u249.setX(UtilitiesKt.dp((Number) 10, true, true));
        ReadWriteProperty priceGroup$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv5, initAvailable$lambda$8(totalPrice$delegate)), (Object) null, $$delegatedProperties[3]);
        Ref.IntRef time = new Ref.IntRef();
        time.element = findTime($this$initAvailable, initAvailable$lambda$10(priceGroup$delegate).getPrice());
        String payTitle = this.isExtend ? "Продлить" : "Купить";
        LabelButton labelButton = (UIComponent) new LabelButton(payTitle, 24, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$initAvailable_u24lambda_u2411 = labelButton.getConstraints();
        $this$initAvailable_u24lambda_u2411.setX(UtilitiesKt.getDp((Number) 70));
        $this$initAvailable_u24lambda_u2411.setY(UtilitiesKt.dp$default((Number) 32, true, false, 2, (Object) null));
        $this$initAvailable_u24lambda_u2411.setWidth(UtilitiesKt.getDp((Number) 193));
        $this$initAvailable_u24lambda_u2411.setHeight(UtilitiesKt.getDp((Number) 48));
        $this$initAvailable_u24lambda_u2411.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        ReadWriteProperty buyButton$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf(labelButton.onMouseClick((v3, v4) -> {
            return initAvailable$lambda$12(r1, r2, r3, v3, v4);
        }), getContent()), (Object) null, $$delegatedProperties[4]);
        if ($this$initAvailable.getPriceEmMonth() <= 0) {
            IconButton iconButton = (UIComponent) new IconButton("textures/gift.png", 0.0f, 0.0f, 0.0f, null, null, 0.0f, 0.0f, false, 510, null);
            UIConstraints $this$initAvailable_u24lambda_u2414 = iconButton.getConstraints();
            $this$initAvailable_u24lambda_u2414.setX(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 8, true, true), initAvailable$lambda$13(buyButton$delegate)));
            $this$initAvailable_u24lambda_u2414.setY(UtilitiesKt.dp$default((Number) 32, true, false, 2, (Object) null));
            $this$initAvailable_u24lambda_u2414.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
            $this$initAvailable_u24lambda_u2414.setHeight(UtilitiesKt.getDp((Number) 48));
            $this$initAvailable_u24lambda_u2414.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getBlue()));
            ComponentsKt.childOf(iconButton.onMouseClick((v2, v3) -> {
                return initAvailable$lambda$15(r1, r2, v2, v3);
            }), getContent());
        }
        initAvailable$lambda$6(periodSelect$delegate).onSelection((v3, v4, v5) -> {
            return initAvailable$lambda$16(r1, r2, r3, v3, v4, v5);
        });
        ComponentsKt.effect(initAvailable$lambda$6(periodSelect$delegate).getExpandedBlock(), new RoundOutlineEffect((Color) MSPalette.INSTANCE.getWhiteA4().get(), 4.0f, 1.0f, 0.7f, false, 16, (DefaultConstructorMarker) null));
        onMouseClick((v1, v2) -> {
            return initAvailable$lambda$17(r1, v1, v2);
        });
    }

    private static final LabelComponent initAvailable$lambda$3(ReadWriteProperty<Object, LabelComponent> readWriteProperty) {
        return (LabelComponent) readWriteProperty.getValue((Object) null, $$delegatedProperties[0]);
    }

    private static final Select initAvailable$lambda$6(ReadWriteProperty<Object, Select> readWriteProperty) {
        return (Select) readWriteProperty.getValue((Object) null, $$delegatedProperties[1]);
    }

    private static final LabelComponent initAvailable$lambda$8(ReadWriteProperty<Object, LabelComponent> readWriteProperty) {
        return (LabelComponent) readWriteProperty.getValue((Object) null, $$delegatedProperties[2]);
    }

    private static final NewPriceGroup initAvailable$lambda$10(ReadWriteProperty<Object, NewPriceGroup> readWriteProperty) {
        return (NewPriceGroup) readWriteProperty.getValue((Object) null, $$delegatedProperties[3]);
    }

    private static final UIComponent initAvailable$lambda$13(ReadWriteProperty<Object, UIComponent> readWriteProperty) {
        return (UIComponent) readWriteProperty.getValue((Object) null, $$delegatedProperties[4]);
    }

    private static final Unit initAvailable$lambda$12(BuyGroupModal this$0, GroupData $this_initAvailable, Ref.IntRef $time, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.close();
        if ($this_initAvailable.getPriceEmMonth() > 0) {
            UtilsKt.openAsUrl("https://mcskill.net/bestshop?server=" + MSCoreClient.Companion.getCurrentServer().getId() + "&tab=4");
        } else {
            ChannelHandler.INSTANCE.sendToServer(new RequestBuyGroupPacket($this_initAvailable.getGroupId(), $time.element, null, 4, null));
        }
        return Unit.INSTANCE;
    }

    private static final Unit initAvailable$lambda$15(GroupData $this_initAvailable, Ref.IntRef $time, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ComponentsKt.childOf(new GiftGroupModal($this_initAvailable, $time.element, false, 4, null), Window.Companion.of($this$onMouseClick));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static final Unit initAvailable$lambda$16(GroupData $this_initAvailable, Ref.IntRef $time, ReadWriteProperty $priceGroup$delegate, UIComponent $this$onSelection, int i, String options) {
        Intrinsics.checkNotNullParameter($this$onSelection, "$this$onSelection");
        Intrinsics.checkNotNullParameter(options, "options");
        switch (options.hashCode()) {
            case 871257564:
                if (options.equals("Навсегда")) {
                    initAvailable$lambda$10($priceGroup$delegate).setPrice($this_initAvailable.getPricePerm());
                    initAvailable$lambda$10($priceGroup$delegate).setDiscount($this_initAvailable.getDiscountPerm());
                    initAvailable$lambda$10($priceGroup$delegate).setPriceWithDisc($this_initAvailable.getPricePermDiscount());
                    $time.element = 0;
                    initAvailable$lambda$10($priceGroup$delegate).updatePosition();
                }
                break;
            case 1073760572:
                if (options.equals("На год")) {
                    initAvailable$lambda$10($priceGroup$delegate).setPrice($this_initAvailable.getPriceYear());
                    initAvailable$lambda$10($priceGroup$delegate).setDiscount($this_initAvailable.getDiscountYear());
                    initAvailable$lambda$10($priceGroup$delegate).setPriceWithDisc($this_initAvailable.getPriceYearDiscount());
                    $time.element = 365;
                    initAvailable$lambda$10($priceGroup$delegate).updatePosition();
                }
                break;
            case 1099850002:
                if (options.equals("На месяц")) {
                    initAvailable$lambda$10($priceGroup$delegate).setPrice($this_initAvailable.getPriceMonth() > 0 ? $this_initAvailable.getPriceMonth() : $this_initAvailable.getPriceEmMonth());
                    initAvailable$lambda$10($priceGroup$delegate).setDiscount($this_initAvailable.getDiscountMonth());
                    initAvailable$lambda$10($priceGroup$delegate).setPriceWithDisc($this_initAvailable.getPriceMonthDiscount());
                    $time.element = 31;
                    initAvailable$lambda$10($priceGroup$delegate).updatePosition();
                }
                break;
        }
        return Unit.INSTANCE;
    }

    private static final Unit initAvailable$lambda$17(ReadWriteProperty $periodSelect$delegate, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        initAvailable$lambda$6($periodSelect$delegate).collapse(true);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r18v2 */
    private final GroupEntry.PriceData availablePrice() {
        Object obj;
        GroupEntry.PriceData[] priceDataArr = {new GroupEntry.PriceData(this.group.getPriceEmMonth(), 0, 0, this.group.getSellEmMonth()), new GroupEntry.PriceData(this.group.getPriceMonth(), this.group.getDiscountMonth(), this.group.getPriceMonthDiscount(), this.group.getSellMonth()), new GroupEntry.PriceData(this.group.getPriceYear(), this.group.getDiscountYear(), this.group.getPriceYearDiscount(), this.group.getSellYear()), new GroupEntry.PriceData(this.group.getPricePerm(), this.group.getDiscountPerm(), this.group.getPricePermDiscount(), this.group.getSellPerm())};
        ArrayList arrayList = new ArrayList();
        for (GroupEntry.PriceData priceData : priceDataArr) {
            if (priceData.isActive()) {
                arrayList.add(priceData);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                boolean z = ((GroupEntry.PriceData) next).getPriceDiscount() > 0;
                do {
                    Object next2 = it.next();
                    ?? r18 = ((GroupEntry.PriceData) next2).getPriceDiscount() > 0;
                    if ((z ? 1 : 0) < r18) {
                        next = next2;
                        z = r18 == true ? 1 : 0;
                    }
                } while (it.hasNext());
                obj = next;
            } else {
                obj = next;
            }
        } else {
            obj = null;
        }
        GroupEntry.PriceData priceData2 = (GroupEntry.PriceData) obj;
        return priceData2 == null ? GroupEntry.PriceData.INSTANCE.getEMPTY() : priceData2;
    }

    private final int findTime(GroupData $this$findTime, int price) {
        if ($this$findTime.getPriceEmMonth() == price || $this$findTime.getPriceMonth() == price) {
            return 31;
        }
        if ($this$findTime.getPriceYear() == price) {
            return 365;
        }
        return $this$findTime.getPricePerm() == price ? 0 : -1;
    }
}
