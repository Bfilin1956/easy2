package net.mcskill.shop.client.screen.modal.cases.roulette;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.Window;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.constraints.XConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.ExtensionsKt;
import java.awt.Color;
import java.util.Collection;
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
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.shop.client.screen.component.ConfettiBox;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.modal.Modal;
import net.mcskill.shop.common.response.shop.CaseItemData;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RewardCaseModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/cases/roulette/RewardCaseModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001b\u0010\u001c¨\u0006'"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/cases/roulette/RewardCaseModal;", "Lnet/mcskill/shop/client/screen/modal/Modal;", "items", "", "Lnet/mcskill/shop/common/response/shop/CaseItemData;", "<init>", "(Ljava/util/List;)V", "rewardsContainer", "Lgg/essential/elementa/components/UIContainer;", "getRewardsContainer", "()Lgg/essential/elementa/components/UIContainer;", "rewardsContainer$delegate", "Lkotlin/properties/ReadWriteProperty;", "_labelText", "", "_continueButton", "Lgg/essential/elementa/UIComponent;", "get_continueButton", "()Lgg/essential/elementa/UIComponent;", "_continueButton$delegate", "_rewardTitle", "Lgg/essential/elementa/components/LabelComponent;", "get_rewardTitle", "()Lgg/essential/elementa/components/LabelComponent;", "_rewardTitle$delegate", "_confetti", "Lnet/mcskill/shop/client/screen/component/ConfettiBox;", "get_confetti", "()Lnet/mcskill/shop/client/screen/component/ConfettiBox;", "_confetti$delegate", "afterInitialization", "", "close", "createRewards", "createRewardCard", "item", "index", "", "Companion", "MSShop"})
@SourceDebugExtension({"SMAP\nRewardCaseModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RewardCaseModal.kt\nnet/mcskill/shop/client/screen/modal/cases/roulette/RewardCaseModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,102:1\n10#2,3:103\n10#2,3:112\n10#2,3:115\n10#2,3:118\n10#2,3:124\n10#2,3:133\n1755#3,3:106\n1755#3,3:109\n1755#3,3:121\n1755#3,3:127\n1872#3,3:130\n*S KotlinDebug\n*F\n+ 1 RewardCaseModal.kt\nnet/mcskill/shop/client/screen/modal/cases/roulette/RewardCaseModal\n*L\n33#1:103,3\n47#1:112,3\n57#1:115,3\n64#1:118,3\n75#1:124,3\n97#1:133,3\n41#1:106,3\n42#1:109,3\n74#1:121,3\n85#1:127,3\n91#1:130,3\n*E\n"})
public final class RewardCaseModal extends Modal {

    @NotNull
    private final List<CaseItemData> items;

    /* JADX INFO: renamed from: rewardsContainer$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty rewardsContainer;

    @NotNull
    private final String _labelText;

    /* JADX INFO: renamed from: _continueButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _continueButton;

    /* JADX INFO: renamed from: _rewardTitle$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _rewardTitle;

    /* JADX INFO: renamed from: _confetti$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _confetti;
    private static final int CARD_WIDTH = 100;
    private static final int CARD_SPACING = 8;
    private static final int BASE_WIDTH = 524;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(RewardCaseModal.class, "rewardsContainer", "getRewardsContainer()Lgg/essential/elementa/components/UIContainer;", 0)), Reflection.property1(new PropertyReference1Impl(RewardCaseModal.class, "_continueButton", "get_continueButton()Lgg/essential/elementa/UIComponent;", 0)), Reflection.property1(new PropertyReference1Impl(RewardCaseModal.class, "_rewardTitle", "get_rewardTitle()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(RewardCaseModal.class, "_confetti", "get_confetti()Lnet/mcskill/shop/client/screen/component/ConfettiBox;", 0))};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardCaseModal(@NotNull List<CaseItemData> list) {
        boolean z;
        boolean z2;
        String str;
        super("Поздравляем!", INSTANCE.calculateModalWidth(list.size()), 304.0f);
        Intrinsics.checkNotNullParameter(list, "items");
        this.items = list;
        UIComponent $this$constrain$iv = new UIContainer();
        UIConstraints $this$rewardsContainer_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$rewardsContainer_delegate_u24lambda_u240.setX(new CenterConstraint());
        $this$rewardsContainer_delegate_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 117));
        $this$rewardsContainer_delegate_u24lambda_u240.setWidth(new ChildBasedSizeConstraint(8.0f, false, 2, (DefaultConstructorMarker) null));
        $this$rewardsContainer_delegate_u24lambda_u240.setHeight(UtilitiesKt.getDp((Number) 108));
        this.rewardsContainer = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, getContent()), this, $$delegatedProperties[0]);
        Iterable $this$any$iv = this.items;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator it = $this$any$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    CaseItemData it2 = (CaseItemData) element$iv;
                    if (it2.getGuarantType() == 2) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        } else {
            z = false;
        }
        boolean z3 = z;
        RewardCaseModal rewardCaseModal = this;
        if (z3) {
            str = "&lВы получили гарантированный &6супер-приз:";
        } else {
            Iterable $this$any$iv2 = this.items;
            if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                Iterator it3 = $this$any$iv2.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        Object element$iv2 = it3.next();
                        CaseItemData it4 = (CaseItemData) element$iv2;
                        if (it4.getGuarantType() == 1) {
                            z2 = true;
                            break;
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                }
            } else {
                z2 = false;
            }
            boolean z4 = z2;
            rewardCaseModal = rewardCaseModal;
            if (z4) {
                str = "&lВы получили гарантированный &3приз:";
            } else {
                str = this.items.size() > 1 ? "&lВы получили несколько призов:" : "&lВы получили:";
            }
        }
        rewardCaseModal._labelText = str;
        LabelButton labelButton = (UIComponent) new LabelButton("Продолжить", 18, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$_continueButton_delegate_u24lambda_u243 = labelButton.getConstraints();
        $this$_continueButton_delegate_u24lambda_u243.setX(new CenterConstraint());
        $this$_continueButton_delegate_u24lambda_u243.setY(UtilitiesKt.dp$default((Number) 32, true, false, 2, (Object) null));
        $this$_continueButton_delegate_u24lambda_u243.setWidth(UtilitiesKt.getDp((Number) 208));
        $this$_continueButton_delegate_u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 31));
        $this$_continueButton_delegate_u24lambda_u243.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this._continueButton = ComponentsKt.provideDelegate(ComponentsKt.childOf(labelButton.onMouseClick((v1, v2) -> {
            return _continueButton_delegate$lambda$4(r2, v1, v2);
        }), getContent()), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv2 = new LabelComponent(this._labelText, false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_rewardTitle_delegate_u24lambda_u245 = $this$constrain$iv2.getConstraints();
        $this$_rewardTitle_delegate_u24lambda_u245.setX(new CenterConstraint());
        $this$_rewardTitle_delegate_u24lambda_u245.setY(UtilitiesKt.getDp((Number) 91));
        $this$_rewardTitle_delegate_u24lambda_u245.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_rewardTitle_delegate_u24lambda_u245.setTextScale(UtilitiesKt.getDp((Number) 18));
        this._rewardTitle = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, getContent()), this, $$delegatedProperties[2]);
        UIComponent $this$constrain$iv3 = new ConfettiBox(0, 1, null);
        UIConstraints $this$_confetti_delegate_u24lambda_u246 = $this$constrain$iv3.getConstraints();
        $this$_confetti_delegate_u24lambda_u246.setWidth(UtilitiesKt.getDp(Float.valueOf(1420.0f)));
        this._confetti = ComponentsKt.provideDelegate($this$constrain$iv3, this, $$delegatedProperties[3]);
        createRewards();
    }

    /* JADX INFO: compiled from: RewardCaseModal.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/cases/roulette/RewardCaseModal$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/cases/roulette/RewardCaseModal$Companion;", "", "<init>", "()V", "CARD_WIDTH", "", "CARD_SPACING", "BASE_WIDTH", "calculateModalWidth", "", "rewardCount", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float calculateModalWidth(int rewardCount) {
            return RewardCaseModal.BASE_WIDTH + ((rewardCount - 1) * 108);
        }
    }

    private final UIContainer getRewardsContainer() {
        return (UIContainer) this.rewardsContainer.getValue(this, $$delegatedProperties[0]);
    }

    private final UIComponent get_continueButton() {
        return (UIComponent) this._continueButton.getValue(this, $$delegatedProperties[1]);
    }

    private static final Unit _continueButton_delegate$lambda$4(RewardCaseModal this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.close();
        return Unit.INSTANCE;
    }

    private final LabelComponent get_rewardTitle() {
        return (LabelComponent) this._rewardTitle.getValue(this, $$delegatedProperties[2]);
    }

    private final ConfettiBox get_confetti() {
        return (ConfettiBox) this._confetti.getValue(this, $$delegatedProperties[3]);
    }

    @Override // net.mcskill.shop.client.screen.modal.Modal
    public void afterInitialization() {
        boolean z;
        super.afterInitialization();
        Iterable $this$any$iv = this.items;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator it = $this$any$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    CaseItemData it2 = (CaseItemData) element$iv;
                    if (it2.getGuarantType() > 0) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        } else {
            z = false;
        }
        if (z) {
            UIComponent $this$constrain$iv = get_confetti();
            UIConstraints $this$afterInitialization_u24lambda_u248 = $this$constrain$iv.getConstraints();
            $this$afterInitialization_u24lambda_u248.setX(new CenterConstraint());
            $this$afterInitialization_u24lambda_u248.setY(UtilitiesKt.getDp((Number) (-100)));
            ComponentsKt.childOf($this$constrain$iv, (UIComponent) this);
            Window.Companion.of((UIComponent) this).addFloatingComponent(get_confetti());
        }
    }

    @Override // net.mcskill.shop.client.screen.modal.Modal
    public void close() {
        boolean z;
        super.close();
        Iterable $this$any$iv = this.items;
        if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
            Iterator it = $this$any$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    CaseItemData it2 = (CaseItemData) element$iv;
                    if (it2.getGuarantType() > 0) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        } else {
            z = false;
        }
        if (z) {
            Window.Companion.of((UIComponent) this).removeFloatingComponent(get_confetti());
        }
    }

    private final void createRewards() {
        Iterable $this$forEachIndexed$iv = this.items;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index = index$iv;
            index$iv++;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CaseItemData item = (CaseItemData) item$iv;
            createRewardCard(item, index);
        }
    }

    private final void createRewardCard(CaseItemData item, int index) {
        UIComponent $this$constrain$iv = new RewardCard(item, false, 2, null);
        UIConstraints $this$createRewardCard_u24lambda_u2411 = $this$constrain$iv.getConstraints();
        $this$createRewardCard_u24lambda_u2411.setX(index == 0 ? (XConstraint) UtilitiesKt.pixels$default((Number) 0, false, false, 3, (Object) null) : new SiblingConstraint(8.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$createRewardCard_u24lambda_u2411.setY(UtilitiesKt.pixels$default((Number) 0, false, false, 3, (Object) null));
        ComponentsKt.childOf($this$constrain$iv, getRewardsContainer());
    }
}
