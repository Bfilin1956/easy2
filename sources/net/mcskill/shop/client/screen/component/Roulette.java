package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedMaxSizeConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.constraints.PositionConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.constraints.animation.AnimatingConstraints;
import gg.essential.elementa.constraints.animation.Animations;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.ScissorEffect;
import gg.essential.elementa.state.ExtensionsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.random.Random;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.shop.client.screen.modal.cases.roulette.RewardCard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Roulette.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/Roulette.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010 \u001a\u00020\u0017J\u001f\u0010!\u001a\u00020\u00172\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u0018J\u0006\u0010#\u001a\u00020\u0017J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u001aR\u001b\u0010\u0004\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R%\u0010\u0014\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u00180\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Lnet/mcskill/shop/client/screen/component/Roulette;", "Lgg/essential/elementa/components/UIContainer;", "<init>", "()V", "movableContainer", "getMovableContainer", "()Lgg/essential/elementa/components/UIContainer;", "movableContainer$delegate", "Lkotlin/properties/ReadWriteProperty;", "divider", "Lgg/essential/elementa/components/UIRoundedRectangle;", "getDivider", "()Lgg/essential/elementa/components/UIRoundedRectangle;", "divider$delegate", "endPos", "Lgg/essential/elementa/constraints/PositionConstraint;", "animationStartTime", "", "animationDuration", "", "completeListener", "", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "elements", "Lnet/mcskill/shop/client/screen/modal/cases/roulette/RewardCard;", "value", "", "completed", "getCompleted", "()Z", "startSpin", "onComplete", "block", "endSpin", "addElement", "element", "Companion", "MSShop"})
@SourceDebugExtension({"SMAP\nRoulette.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Roulette.kt\nnet/mcskill/shop/client/screen/component/Roulette\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 animations.kt\ngg/essential/elementa/dsl/AnimationsKt\n*L\n1#1,94:1\n10#2,3:95\n10#2,3:98\n10#2,3:110\n295#3,2:101\n1863#3,2:108\n1863#3,2:113\n10#4,5:103\n*S KotlinDebug\n*F\n+ 1 Roulette.kt\nnet/mcskill/shop/client/screen/component/Roulette\n*L\n29#1:95,3\n36#1:98,3\n89#1:110,3\n59#1:101,2\n82#1:108,2\n69#1:113,2\n65#1:103,5\n*E\n"})
public final class Roulette extends UIContainer {

    /* JADX INFO: renamed from: movableContainer$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty movableContainer;

    /* JADX INFO: renamed from: divider$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty divider;

    @Nullable
    private PositionConstraint endPos;
    private long animationStartTime;
    private float animationDuration;

    @NotNull
    private final List<Function1<Roulette, Unit>> completeListener;

    @NotNull
    private final List<RewardCard> elements;
    private boolean completed;

    @NotNull
    private static final Logger LOGGER;
    private static final int ITEM_WIDTH = 100;
    private static final int ITEM_HEIGHT = 110;
    private static final int ITEM_SPACING = 12;
    private static final int TOTAL_ELEMENTS = 60;
    private static final int VISIBLE_ELEMENTS = 5;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Roulette.class, "movableContainer", "getMovableContainer()Lgg/essential/elementa/components/UIContainer;", 0)), Reflection.property1(new PropertyReference1Impl(Roulette.class, "divider", "getDivider()Lgg/essential/elementa/components/UIRoundedRectangle;", 0))};

    public Roulette() {
        UIComponent $this$constrain$iv = new UIContainer();
        UIConstraints $this$movableContainer_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$movableContainer_delegate_u24lambda_u240.setX(new CenterConstraint());
        $this$movableContainer_delegate_u24lambda_u240.setY(new CenterConstraint());
        $this$movableContainer_delegate_u24lambda_u240.setWidth(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null));
        $this$movableContainer_delegate_u24lambda_u240.setHeight(new ChildBasedMaxSizeConstraint());
        this.movableContainer = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv2 = new UIRoundedRectangle(5.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$divider_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$divider_delegate_u24lambda_u241.setX(new CenterConstraint());
        $this$divider_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 4));
        $this$divider_delegate_u24lambda_u241.setHeight(new FillConstraint(false));
        $this$divider_delegate_u24lambda_u241.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getOrange()));
        this.divider = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, (UIComponent) this), this, $$delegatedProperties[1]);
        this.completeListener = new ArrayList();
        this.elements = new ArrayList();
        ComponentsKt.effect((UIComponent) this, new ScissorEffect((UIComponent) null, false, 3, (DefaultConstructorMarker) null));
    }

    private final UIContainer getMovableContainer() {
        return (UIContainer) this.movableContainer.getValue(this, $$delegatedProperties[0]);
    }

    static {
        Logger logger = LogManager.getLogger("Roulette");
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(...)");
        LOGGER = logger;
    }

    private final UIRoundedRectangle getDivider() {
        return (UIRoundedRectangle) this.divider.getValue(this, $$delegatedProperties[1]);
    }

    public final boolean getCompleted() {
        return this.completed;
    }

    public final void startSpin() {
        Object obj;
        this.completed = false;
        Iterable $this$firstOrNull$iv = this.elements;
        for (Object element$iv : $this$firstOrNull$iv) {
            RewardCard it = (RewardCard) element$iv;
            if (it.getReward()) {
                obj = element$iv;
                RewardCard reward = (RewardCard) obj;
                Random.Default r0 = Random.Default;
                Intrinsics.checkNotNull(reward);
                float randomOffset = (float) r0.nextDouble(6.0d, reward.getWidth() - ITEM_SPACING);
                getMovableContainer().setX(UtilitiesKt.getDp((Number) 0));
                this.animationDuration = 5.8f;
                UIComponent $this$animate$iv = getMovableContainer();
                AnimatingConstraints anim$iv = $this$animate$iv.makeAnimation();
                AnimatingConstraints.setXAnimation$default(anim$iv, Animations.OUT_CUBIC, this.animationDuration, ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getPixels(Float.valueOf(randomOffset))), 0.0f, 8, (Object) null);
                anim$iv.onComplete(() -> {
                    return startSpin$lambda$5$lambda$4(r1);
                });
                $this$animate$iv.animateTo(anim$iv);
            }
        }
        obj = null;
        RewardCard reward2 = (RewardCard) obj;
        Random.Default r1 = Random.Default;
        Intrinsics.checkNotNull(reward2);
        float randomOffset2 = (float) r1.nextDouble(6.0d, reward2.getWidth() - ITEM_SPACING);
        getMovableContainer().setX(UtilitiesKt.getDp((Number) 0));
        this.animationDuration = 5.8f;
        UIComponent $this$animate$iv2 = getMovableContainer();
        AnimatingConstraints anim$iv2 = $this$animate$iv2.makeAnimation();
        AnimatingConstraints.setXAnimation$default(anim$iv2, Animations.OUT_CUBIC, this.animationDuration, ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getPixels(Float.valueOf(randomOffset2))), 0.0f, 8, (Object) null);
        anim$iv2.onComplete(() -> {
            return startSpin$lambda$5$lambda$4(r1);
        });
        $this$animate$iv2.animateTo(anim$iv2);
    }

    private static final Unit startSpin$lambda$5$lambda$4(Roulette this$0) {
        this$0.completed = true;
        Iterable $this$forEach$iv = this$0.completeListener;
        for (Object element$iv : $this$forEach$iv) {
            Function1 listener = (Function1) element$iv;
            listener.invoke(this$0);
        }
        return Unit.INSTANCE;
    }

    public final void onComplete(@NotNull Function1<? super Roulette, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.completeListener.add(block);
    }

    public final void endSpin() {
        this.completed = true;
        Iterable $this$forEach$iv = this.completeListener;
        for (Object element$iv : $this$forEach$iv) {
            Function1 listener = (Function1) element$iv;
            listener.invoke(this);
        }
    }

    @NotNull
    public final Roulette addElement(@NotNull RewardCard element) {
        Intrinsics.checkNotNullParameter(element, "element");
        Roulette $this$addElement_u24lambda_u248 = this;
        $this$addElement_u24lambda_u248.elements.add(element);
        UIComponent $this$constrain$iv = (UIComponent) element;
        UIConstraints $this$addElement_u24lambda_u248_u24lambda_u247 = $this$constrain$iv.getConstraints();
        $this$addElement_u24lambda_u248_u24lambda_u247.setX(new SiblingConstraint(12.0f, false, true, 2, (DefaultConstructorMarker) null));
        $this$addElement_u24lambda_u248_u24lambda_u247.setY(new CenterConstraint());
        ComponentsKt.childOf($this$constrain$iv, $this$addElement_u24lambda_u248.getMovableContainer());
        return this;
    }
}
