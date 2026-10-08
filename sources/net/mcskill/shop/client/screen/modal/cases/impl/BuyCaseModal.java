package net.mcskill.shop.client.screen.modal.cases.impl;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.constraints.YConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.State;
import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.shop.client.screen.States;
import net.mcskill.shop.client.screen.component.LabelIcon;
import net.mcskill.shop.client.screen.component.NumberCounter;
import net.mcskill.shop.client.screen.modal.cases.BaseCaseModal;
import net.mcskill.shop.common.network.ChannelHandler;
import net.mcskill.shop.common.network.packet.buy.RequestBuyCasePacket;
import net.mcskill.shop.common.response.Discount;
import net.mcskill.shop.common.response.TypeData;
import net.mcskill.shop.common.response.shop.CaseData;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BuyCaseModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/cases/impl/BuyCaseModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'H\u0002J\u001a\u0010(\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010)0)0\u0007*\u00020+H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0016\u0010\rR\u001b\u0010\u0018\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u0019\u0010\rR\u001b\u0010\u001b\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001c\u0010\rR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b \u0010!¨\u0006-"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/cases/impl/BuyCaseModal;", "Lnet/mcskill/shop/client/screen/modal/cases/BaseCaseModal;", "case", "Lnet/mcskill/shop/common/response/shop/CaseData;", "<init>", "(Lnet/mcskill/shop/common/response/shop/CaseData;)V", "_priceState", "Lgg/essential/elementa/state/BasicState;", "", "_discountState", "_countLabel", "Lgg/essential/elementa/components/LabelComponent;", "get_countLabel", "()Lgg/essential/elementa/components/LabelComponent;", "_countLabel$delegate", "Lkotlin/properties/ReadWriteProperty;", "_counter", "Lnet/mcskill/shop/client/screen/component/NumberCounter;", "get_counter", "()Lnet/mcskill/shop/client/screen/component/NumberCounter;", "_counter$delegate", "_discountLabel", "get_discountLabel", "_discountLabel$delegate", "_discount", "get_discount", "_discount$delegate", "_totalPriceLabel", "get_totalPriceLabel", "_totalPriceLabel$delegate", "_totalPrice", "Lnet/mcskill/shop/client/screen/component/LabelIcon;", "get_totalPrice", "()Lnet/mcskill/shop/client/screen/component/LabelIcon;", "_totalPrice$delegate", "afterInitialization", "", "calculatePrice", "count", "", "getIcon", "Lnet/minecraft/resources/ResourceLocation;", "kotlin.jvm.PlatformType", "Lnet/mcskill/shop/common/response/TypeData;", "Companion", "MSShop"})
@SourceDebugExtension({"SMAP\nBuyCaseModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuyCaseModal.kt\nnet/mcskill/shop/client/screen/modal/cases/impl/BuyCaseModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,113:1\n10#2,3:114\n10#2,3:117\n10#2,3:120\n10#2,3:123\n10#2,3:126\n10#2,3:129\n*S KotlinDebug\n*F\n+ 1 BuyCaseModal.kt\nnet/mcskill/shop/client/screen/modal/cases/impl/BuyCaseModal\n*L\n43#1:114,3\n50#1:117,3\n59#1:120,3\n66#1:123,3\n72#1:126,3\n79#1:129,3\n*E\n"})
public final class BuyCaseModal extends BaseCaseModal {

    @NotNull
    private final BasicState<String> _priceState;

    @NotNull
    private final BasicState<String> _discountState;

    /* JADX INFO: renamed from: _countLabel$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _countLabel;

    /* JADX INFO: renamed from: _counter$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _counter;

    /* JADX INFO: renamed from: _discountLabel$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _discountLabel;

    /* JADX INFO: renamed from: _discount$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _discount;

    /* JADX INFO: renamed from: _totalPriceLabel$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _totalPriceLabel;

    /* JADX INFO: renamed from: _totalPrice$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _totalPrice;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(BuyCaseModal.class, "_countLabel", "get_countLabel()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(BuyCaseModal.class, "_counter", "get_counter()Lnet/mcskill/shop/client/screen/component/NumberCounter;", 0)), Reflection.property1(new PropertyReference1Impl(BuyCaseModal.class, "_discountLabel", "get_discountLabel()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(BuyCaseModal.class, "_discount", "get_discount()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(BuyCaseModal.class, "_totalPriceLabel", "get_totalPriceLabel()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(BuyCaseModal.class, "_totalPrice", "get_totalPrice()Lnet/mcskill/shop/client/screen/component/LabelIcon;", 0))};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final List<Discount> discounts = CollectionsKt.listOf(new Discount[]{new Discount(100, 0.3d), new Discount(50, 0.25d), new Discount(30, 0.2d), new Discount(20, 0.15d), new Discount(10, 0.1d), new Discount(5, 0.05d)});

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuyCaseModal(@NotNull CaseData caseData) {
        super(caseData, "Покупка кейса", 883.0f, 638.0f, false, 16, null);
        Intrinsics.checkNotNullParameter(caseData, "case");
        this._priceState = new BasicState<>(String.valueOf(caseData.getPrice()));
        this._discountState = new BasicState<>("");
        UIComponent $this$constrain$iv = new LabelComponent("§lКоличество:", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_countLabel_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_countLabel_delegate_u24lambda_u240.setX(UtilitiesKt.getDp((Number) 70));
        $this$_countLabel_delegate_u24lambda_u240.setY(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 16, true, true), getName()));
        $this$_countLabel_delegate_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_countLabel_delegate_u24lambda_u240.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._countLabel = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, getContent()), this, $$delegatedProperties[0]);
        NumberCounter numberCounter = (UIComponent) new NumberCounter(1, 0, 0, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_counter_delegate_u24lambda_u241 = numberCounter.getConstraints();
        $this$_counter_delegate_u24lambda_u241.setX(UtilitiesKt.getDp((Number) 70));
        $this$_counter_delegate_u24lambda_u241.setY(new SiblingConstraint(8.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_counter_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 201));
        $this$_counter_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 32));
        this._counter = ComponentsKt.provideDelegate(ComponentsKt.childOf(numberCounter.onChange((v1, v2) -> {
            return _counter_delegate$lambda$2(r2, v1, v2);
        }), getContent()), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv2 = new LabelComponent("§lСкидка:", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_discountLabel_delegate_u24lambda_u243 = $this$constrain$iv2.getConstraints();
        $this$_discountLabel_delegate_u24lambda_u243.setX(UtilitiesKt.getDp((Number) 70));
        $this$_discountLabel_delegate_u24lambda_u243.setY(new SiblingConstraint(16.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_discountLabel_delegate_u24lambda_u243.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_discountLabel_delegate_u24lambda_u243.setTextScale(UtilitiesKt.getDp((Number) 20));
        this._discountLabel = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, getContent()), this, $$delegatedProperties[2]);
        UIComponent $this$constrain$iv3 = new LabelComponent(this._discountState, (State) null, (State) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_discount_delegate_u24lambda_u244 = $this$constrain$iv3.getConstraints();
        $this$_discount_delegate_u24lambda_u244.setX(UtilitiesKt.dp((Number) 6, true, true));
        $this$_discount_delegate_u24lambda_u244.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_discount_delegate_u24lambda_u244.setTextScale(UtilitiesKt.getDp((Number) 20));
        this._discount = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, get_discountLabel()), this, $$delegatedProperties[3]);
        UIComponent $this$constrain$iv4 = new LabelComponent("§lИтого к оплате:", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_totalPriceLabel_delegate_u24lambda_u245 = $this$constrain$iv4.getConstraints();
        $this$_totalPriceLabel_delegate_u24lambda_u245.setX(UtilitiesKt.getDp((Number) 70));
        $this$_totalPriceLabel_delegate_u24lambda_u245.setY(new SiblingConstraint(16.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_totalPriceLabel_delegate_u24lambda_u245.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_totalPriceLabel_delegate_u24lambda_u245.setTextScale(UtilitiesKt.getDp((Number) 20));
        this._totalPriceLabel = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, getContent()), this, $$delegatedProperties[4]);
        UIComponent $this$constrain$iv5 = new LabelIcon(this._priceState, getIcon(caseData.getType()), (State) null, 4, (DefaultConstructorMarker) null);
        UIConstraints $this$_totalPrice_delegate_u24lambda_u246 = $this$constrain$iv5.getConstraints();
        $this$_totalPrice_delegate_u24lambda_u246.setX(UtilitiesKt.dp((Number) 6, true, true));
        this._totalPrice = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv5, get_totalPriceLabel()), this, $$delegatedProperties[5]);
        getActionButton().setY((YConstraint) ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 24, true, true), get_totalPrice()));
        getActionButton().onMouseClick((v2, v3) -> {
            return _init_$lambda$7(r1, r2, v2, v3);
        });
        getName().setWidth(UtilitiesKt.getDp((Number) 280));
    }

    /* JADX INFO: compiled from: BuyCaseModal.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/cases/impl/BuyCaseModal$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/cases/impl/BuyCaseModal$Companion;", "", "<init>", "()V", "discounts", "", "Lnet/mcskill/shop/common/response/Discount;", "discountOf", "", "amount", "", "MSShop"})
    @SourceDebugExtension({"SMAP\nBuyCaseModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuyCaseModal.kt\nnet/mcskill/shop/client/screen/modal/cases/impl/BuyCaseModal$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,113:1\n295#2,2:114\n*S KotlinDebug\n*F\n+ 1 BuyCaseModal.kt\nnet/mcskill/shop/client/screen/modal/cases/impl/BuyCaseModal$Companion\n*L\n38#1:114,2\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final double discountOf(int amount) {
            Object obj;
            Iterable $this$firstOrNull$iv = BuyCaseModal.discounts;
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    Discount it2 = (Discount) element$iv;
                    if (amount >= it2.getMinOrderAmount()) {
                        obj = element$iv;
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            Discount discount = (Discount) obj;
            if (discount == null) {
                return 0.0d;
            }
            return discount.getPercentage();
        }
    }

    private final LabelComponent get_countLabel() {
        return (LabelComponent) this._countLabel.getValue(this, $$delegatedProperties[0]);
    }

    private final NumberCounter get_counter() {
        return (NumberCounter) this._counter.getValue(this, $$delegatedProperties[1]);
    }

    private static final Unit _counter_delegate$lambda$2(BuyCaseModal this$0, UIComponent $this$onChange, int value) {
        Intrinsics.checkNotNullParameter($this$onChange, "$this$onChange");
        this$0.calculatePrice(value);
        return Unit.INSTANCE;
    }

    private final LabelComponent get_discountLabel() {
        return (LabelComponent) this._discountLabel.getValue(this, $$delegatedProperties[2]);
    }

    private final LabelComponent get_discount() {
        return (LabelComponent) this._discount.getValue(this, $$delegatedProperties[3]);
    }

    private final LabelComponent get_totalPriceLabel() {
        return (LabelComponent) this._totalPriceLabel.getValue(this, $$delegatedProperties[4]);
    }

    private final LabelIcon get_totalPrice() {
        return (LabelIcon) this._totalPrice.getValue(this, $$delegatedProperties[5]);
    }

    private static final Unit _init_$lambda$7(CaseData $case, BuyCaseModal this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ChannelHandler.INSTANCE.sendToServer(new RequestBuyCasePacket($case.getId(), this$0.get_counter().getValue()));
        return Unit.INSTANCE;
    }

    @Override // net.mcskill.shop.client.screen.modal.Modal
    public void afterInitialization() {
        super.afterInitialization();
        get_discountLabel().hide(true);
    }

    private final void calculatePrice(int count) {
        double discountPercent = INSTANCE.discountOf(count);
        if (discountPercent > 0.0d) {
            get_discount().setText(MathKt.roundToInt(discountPercent * ((double) 100)) + "%");
            UIComponent.unhide$default(get_discountLabel(), false, 1, (Object) null);
        } else {
            UIComponent.hide$default(get_discountLabel(), false, 1, (Object) null);
        }
        int total = getCase().getPrice() * count;
        double discount = ((double) total) * discountPercent;
        this._priceState.set(String.valueOf(MathKt.roundToInt(Math.floor(((double) total) - discount))));
    }

    private final BasicState<ResourceLocation> getIcon(TypeData $this$getIcon) {
        return Intrinsics.areEqual($this$getIcon.getName(), "money") ? States.INSTANCE.getRubleIcon() : States.INSTANCE.getEmeraldIcon();
    }
}
