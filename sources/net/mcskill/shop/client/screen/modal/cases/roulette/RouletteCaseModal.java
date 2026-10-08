package net.mcskill.shop.client.screen.modal.cases.roulette;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.Window;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.constraints.YConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.ExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.random.Random;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.shop.client.screen.component.LabelButton;
import net.mcskill.shop.client.screen.component.Roulette;
import net.mcskill.shop.client.screen.modal.Modal;
import net.mcskill.shop.client.screen.modal.cases.BaseCaseModal;
import net.mcskill.shop.client.screen.modal.cases.component.GuarantInfoBlock;
import net.mcskill.shop.client.screen.modal.cases.impl.PreviewCaseModal;
import net.mcskill.shop.client.screen.notification.Notifications;
import net.mcskill.shop.common.network.ChannelHandler;
import net.mcskill.shop.common.network.packet.RequestShopDataPacket;
import net.mcskill.shop.common.network.packet.take.RequestRewardPacket;
import net.mcskill.shop.common.response.shop.CaseItemData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RouletteCaseModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/cases/roulette/RouletteCaseModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 72\u00020\u0001:\u00017BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010'\u001a\u00020(H\u0002J \u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\tH\u0002J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00062\b\b\u0002\u00100\u001a\u00020\u001fH\u0002J\b\u00101\u001a\u00020(H\u0002J\b\u00102\u001a\u00020(H\u0002J\b\u00103\u001a\u00020(H\u0016J(\u00104\u001a\u00020(2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J\b\u00105\u001a\u00020&H\u0002J\b\u00106\u001a\u00020&H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001c0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/cases/roulette/RouletteCaseModal;", "Lnet/mcskill/shop/client/screen/modal/Modal;", "caseModal", "Lnet/mcskill/shop/client/screen/modal/cases/BaseCaseModal;", "caseContent", "", "Lnet/mcskill/shop/common/response/shop/CaseItemData;", "rewardList", "guarantFirstProgress", "", "guarantFirstMax", "guarantSecondProgress", "guarantSecondMax", "<init>", "(Lnet/mcskill/shop/client/screen/modal/cases/BaseCaseModal;Ljava/util/List;Ljava/util/List;IIII)V", "roulettesContainer", "Lgg/essential/elementa/components/UIContainer;", "getRoulettesContainer", "()Lgg/essential/elementa/components/UIContainer;", "roulettesContainer$delegate", "Lkotlin/properties/ReadWriteProperty;", "_boostButton", "Lgg/essential/elementa/UIComponent;", "get_boostButton", "()Lgg/essential/elementa/UIComponent;", "_boostButton$delegate", "rouletteRow", "", "Lnet/mcskill/shop/client/screen/component/Roulette;", "completedRoulettes", "allCompleted", "", "rouletteCompletionTracker", "", "expectedRewards", "", "windowSizeAtStart", "", "", "createRoulettes", "", "setupRoulette", "roulette", "expectedReward", "rouletteIndex", "createRewardCard", "Lnet/mcskill/shop/client/screen/modal/cases/roulette/RewardCard;", "item", "reward", "onRouletteComplete", "openRewardModal", "afterInitialization", "updateGuarantInfo", "getWindowWidth", "getWindowHeight", "Companion", "MSShop"})
@SourceDebugExtension({"SMAP\nRouletteCaseModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RouletteCaseModal.kt\nnet/mcskill/shop/client/screen/modal/cases/roulette/RouletteCaseModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 UIComponent.kt\ngg/essential/elementa/UIComponent\n*L\n1#1,178:1\n10#2,3:179\n10#2,3:182\n10#2,3:187\n1872#3,2:185\n1874#3:190\n1872#3,3:191\n808#3,11:194\n1872#3,3:206\n263#4:205\n*S KotlinDebug\n*F\n+ 1 RouletteCaseModal.kt\nnet/mcskill/shop/client/screen/modal/cases/roulette/RouletteCaseModal\n*L\n47#1:179,3\n54#1:182,3\n84#1:187,3\n83#1:185,2\n83#1:190\n149#1:191,3\n160#1:194,11\n61#1:206,3\n163#1:205\n*E\n"})
public final class RouletteCaseModal extends Modal {

    @Nullable
    private final BaseCaseModal caseModal;

    @NotNull
    private final List<CaseItemData> caseContent;

    @NotNull
    private final List<CaseItemData> rewardList;
    private final int guarantFirstProgress;
    private final int guarantFirstMax;
    private final int guarantSecondProgress;
    private final int guarantSecondMax;

    /* JADX INFO: renamed from: roulettesContainer$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty roulettesContainer;

    /* JADX INFO: renamed from: _boostButton$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _boostButton;

    @NotNull
    private final List<Roulette> rouletteRow;
    private int completedRoulettes;
    private boolean allCompleted;

    @NotNull
    private final Set<Roulette> rouletteCompletionTracker;

    @NotNull
    private final Map<Roulette, CaseItemData> expectedRewards;

    @NotNull
    private final Map<String, Float> windowSizeAtStart;
    private static final int REWARD_POSITION = 30;
    private static final int ROULETTE_WIDTH = 644;
    private static final int ROULETTE_HEIGHT = 110;
    private static final int ROULETTE_SPACING = 8;

    @NotNull
    private static final Logger LOGGER;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(RouletteCaseModal.class, "roulettesContainer", "getRoulettesContainer()Lgg/essential/elementa/components/UIContainer;", 0)), Reflection.property1(new PropertyReference1Impl(RouletteCaseModal.class, "_boostButton", "get_boostButton()Lgg/essential/elementa/UIComponent;", 0))};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouletteCaseModal(@Nullable BaseCaseModal caseModal, @NotNull List<CaseItemData> list, @NotNull List<CaseItemData> list2, int guarantFirstProgress, int guarantFirstMax, int guarantSecondProgress, int guarantSecondMax) {
        super("Открытие кейса", 880.0f, INSTANCE.calculateModalHeight(list2.size()));
        Intrinsics.checkNotNullParameter(list, "caseContent");
        Intrinsics.checkNotNullParameter(list2, "rewardList");
        this.caseModal = caseModal;
        this.caseContent = list;
        this.rewardList = list2;
        this.guarantFirstProgress = guarantFirstProgress;
        this.guarantFirstMax = guarantFirstMax;
        this.guarantSecondProgress = guarantSecondProgress;
        this.guarantSecondMax = guarantSecondMax;
        UIComponent $this$constrain$iv = new UIContainer();
        UIConstraints $this$roulettesContainer_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$roulettesContainer_delegate_u24lambda_u240.setX(new CenterConstraint());
        $this$roulettesContainer_delegate_u24lambda_u240.setY(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp((Number) 3)));
        $this$roulettesContainer_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp(Integer.valueOf(ROULETTE_WIDTH)));
        $this$roulettesContainer_delegate_u24lambda_u240.setHeight(new ChildBasedSizeConstraint(8.0f, false, 2, (DefaultConstructorMarker) null));
        this.roulettesContainer = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, getContent()), this, $$delegatedProperties[0]);
        LabelButton labelButton = (UIComponent) new LabelButton("Ускорить", 18, 0.0f, 0.0f, 0.0f, null, null, false, 252, null);
        UIConstraints $this$_boostButton_delegate_u24lambda_u241 = labelButton.getConstraints();
        $this$_boostButton_delegate_u24lambda_u241.setX(new CenterConstraint());
        $this$_boostButton_delegate_u24lambda_u241.setY(ConstraintsKt.boundTo(UtilitiesKt.dp((Number) 2, true, true), getRoulettesContainer()));
        $this$_boostButton_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 208));
        $this$_boostButton_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 43));
        $this$_boostButton_delegate_u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this._boostButton = ComponentsKt.provideDelegate(ComponentsKt.childOf(labelButton.onMouseClick((v1, v2) -> {
            return _boostButton_delegate$lambda$3(r2, v1, v2);
        }), getContent()), this, $$delegatedProperties[1]);
        this.rouletteRow = new ArrayList();
        this.rouletteCompletionTracker = new LinkedHashSet();
        this.expectedRewards = new LinkedHashMap();
        this.windowSizeAtStart = new LinkedHashMap();
        Notifications.INSTANCE.clear();
        createRoulettes();
        getContent().getClose().onMouseClick(RouletteCaseModal::_init_$lambda$4);
    }

    /* JADX INFO: compiled from: RouletteCaseModal.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/cases/roulette/RouletteCaseModal$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/cases/roulette/RouletteCaseModal$Companion;", "", "<init>", "()V", "REWARD_POSITION", "", "ROULETTE_WIDTH", "ROULETTE_HEIGHT", "ROULETTE_SPACING", "LOGGER", "Lorg/apache/logging/log4j/Logger;", "calculateModalHeight", "", "rewardCount", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float calculateModalHeight(int rewardCount) {
            return 398.0f + ((rewardCount - 1) * 118.0f);
        }
    }

    private final UIContainer getRoulettesContainer() {
        return (UIContainer) this.roulettesContainer.getValue(this, $$delegatedProperties[0]);
    }

    static {
        Logger logger = LogManager.getLogger("RouletteCaseModal");
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(...)");
        LOGGER = logger;
    }

    private final UIComponent get_boostButton() {
        return (UIComponent) this._boostButton.getValue(this, $$delegatedProperties[1]);
    }

    private static final Unit _boostButton_delegate$lambda$3(RouletteCaseModal this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        Iterable $this$forEachIndexed$iv = this$0.rouletteRow;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int i = index$iv;
            index$iv++;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Roulette roulette = (Roulette) item$iv;
            roulette.endSpin();
        }
        this$0.onRouletteComplete();
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$4(UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        ChannelHandler.INSTANCE.sendToServer(RequestRewardPacket.INSTANCE);
        return Unit.INSTANCE;
    }

    private final void createRoulettes() {
        Iterable $this$forEachIndexed$iv = this.rewardList;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index = index$iv;
            index$iv++;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CaseItemData expectedReward = (CaseItemData) item$iv;
            UIComponent $this$constrain$iv = new Roulette();
            UIConstraints $this$createRoulettes_u24lambda_u246_u24lambda_u245 = $this$constrain$iv.getConstraints();
            $this$createRoulettes_u24lambda_u246_u24lambda_u245.setX(UtilitiesKt.pixels$default((Number) 0, false, false, 3, (Object) null));
            $this$createRoulettes_u24lambda_u246_u24lambda_u245.setY((YConstraint) (index == 0 ? UtilitiesKt.pixels$default((Number) 0, false, false, 3, (Object) null) : new SiblingConstraint(8.0f, false, false, 6, (DefaultConstructorMarker) null)));
            $this$createRoulettes_u24lambda_u246_u24lambda_u245.setWidth(UtilitiesKt.getDp(Integer.valueOf(ROULETTE_WIDTH)));
            $this$createRoulettes_u24lambda_u246_u24lambda_u245.setHeight(UtilitiesKt.getDp(Integer.valueOf(ROULETTE_HEIGHT)));
            Roulette roulette = (Roulette) ComponentsKt.childOf($this$constrain$iv, getRoulettesContainer());
            this.expectedRewards.put(roulette, expectedReward);
            setupRoulette(roulette, expectedReward, index);
            this.rouletteRow.add(roulette);
        }
    }

    private final void setupRoulette(Roulette roulette, CaseItemData expectedReward, int rouletteIndex) {
        CaseItemData caseItemData;
        List items = new ArrayList();
        for (int i = 0; i < 60; i++) {
            int index = i;
            if (index == REWARD_POSITION) {
                caseItemData = expectedReward;
            } else {
                CaseItemData randomItem = (CaseItemData) CollectionsKt.random(this.caseContent, Random.Default);
                caseItemData = randomItem;
            }
            CaseItemData item = caseItemData;
            items.add(item);
            roulette.addElement(createRewardCard(item, index == REWARD_POSITION));
        }
        roulette.onComplete((v2) -> {
            return setupRoulette$lambda$8(r1, r2, v2);
        });
    }

    private static final Unit setupRoulette$lambda$8(RouletteCaseModal this$0, Roulette $roulette, Roulette $this$onComplete) {
        Intrinsics.checkNotNullParameter($this$onComplete, "$this$onComplete");
        if (!this$0.rouletteCompletionTracker.contains($roulette)) {
            this$0.rouletteCompletionTracker.add($roulette);
            this$0.onRouletteComplete();
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ RewardCard createRewardCard$default(RouletteCaseModal rouletteCaseModal, CaseItemData caseItemData, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return rouletteCaseModal.createRewardCard(caseItemData, z);
    }

    private final RewardCard createRewardCard(CaseItemData item, boolean reward) {
        return new RewardCard(item, reward);
    }

    private final void onRouletteComplete() {
        this.completedRoulettes++;
        if (this.completedRoulettes >= this.rewardList.size() && !this.allCompleted) {
            this.allCompleted = true;
            ChannelHandler.INSTANCE.sendToServer(RequestShopDataPacket.INSTANCE);
            BaseCaseModal baseCaseModal = this.caseModal;
            if (baseCaseModal != null) {
                LabelButton actionButton = baseCaseModal.getActionButton();
                if (actionButton != null) {
                    actionButton.setEnabled(true);
                }
            }
            if (this.caseModal instanceof PreviewCaseModal) {
                ((PreviewCaseModal) this.caseModal).getActionButtonX5().setEnabled(true);
            }
            openRewardModal();
        }
    }

    private final void openRewardModal() {
        close();
        updateGuarantInfo(this.guarantFirstProgress, this.guarantFirstMax, this.guarantSecondProgress, this.guarantSecondMax);
        ChannelHandler.INSTANCE.sendToServer(RequestRewardPacket.INSTANCE);
        ComponentsKt.childOf(new RewardCaseModal(this.rewardList), Window.Companion.of((UIComponent) this));
    }

    @Override // net.mcskill.shop.client.screen.modal.Modal
    public void afterInitialization() {
        super.afterInitialization();
        this.windowSizeAtStart.put("width", Float.valueOf(getWindowWidth()));
        this.windowSizeAtStart.put("height", Float.valueOf(getWindowHeight()));
        Iterable $this$forEachIndexed$iv = this.rouletteRow;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int i = index$iv;
            index$iv++;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Roulette roulette = (Roulette) item$iv;
            roulette.startSpin();
        }
    }

    private final void updateGuarantInfo(int guarantFirstProgress, int guarantFirstMax, int guarantSecondProgress, int guarantSecondMax) {
        UIComponent content;
        GuarantInfoBlock $this$updateGuarantInfo_u24lambda_u2410;
        Iterable $this$filterIsInstance$iv = Window.Companion.of((UIComponent) this).getChildren();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof BaseCaseModal) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        BaseCaseModal baseCaseModal = (BaseCaseModal) CollectionsKt.firstOrNull((List) destination$iv$iv);
        if (baseCaseModal == null || (content = baseCaseModal.getContent()) == null) {
            return;
        }
        UIComponent this_$iv = content;
        List listChildrenOfType = this_$iv.childrenOfType(GuarantInfoBlock.class);
        if (listChildrenOfType == null || ($this$updateGuarantInfo_u24lambda_u2410 = (GuarantInfoBlock) CollectionsKt.firstOrNull(listChildrenOfType)) == null) {
            return;
        }
        $this$updateGuarantInfo_u24lambda_u2410.updateFirstGuarantProgress(guarantFirstProgress, guarantFirstMax);
        $this$updateGuarantInfo_u24lambda_u2410.updateSecondGuarantProgress(guarantSecondProgress, guarantSecondMax);
    }

    private final float getWindowWidth() {
        return Window.Companion.of((UIComponent) this).getWidth();
    }

    private final float getWindowHeight() {
        return Window.Companion.of((UIComponent) this).getHeight();
    }
}
