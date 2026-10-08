package net.mcskill.shop.client.screen.modal;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.WindowScreen;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.components.image.ImageComponent;
import gg.essential.elementa.constraints.AspectConstraint;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.constraints.animation.AnimatingConstraints;
import gg.essential.elementa.constraints.animation.Animations;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.RoundOutlineEffect;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.state.State;
import gg.essential.universal.UScreen;
import java.awt.Color;
import java.util.Collections;
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
import net.mcskill.core.client.screen.component.MSRoundedRectangle;
import net.mcskill.shop.client.screen.States;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Modal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/Modal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000 !2\u00020\u0001:\u0002!\"B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tB!\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\rJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001f\u0010\u0019\u001a\u00060\u001aR\u00020\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001c¨\u0006#"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/Modal;", "Lgg/essential/elementa/components/UIContainer;", "title", "", "contentWidth", "Lgg/essential/elementa/state/State;", "", "contentHeight", "<init>", "(Ljava/lang/String;Lgg/essential/elementa/state/State;Lgg/essential/elementa/state/State;)V", "name", "width", "height", "(Ljava/lang/String;FF)V", "getContentWidth", "()Lgg/essential/elementa/state/State;", "getContentHeight", "_backgroundColor", "Ljava/awt/Color;", "background", "Lgg/essential/elementa/UIComponent;", "getBackground", "()Lgg/essential/elementa/UIComponent;", "background$delegate", "Lkotlin/properties/ReadWriteProperty;", "content", "Lnet/mcskill/shop/client/screen/modal/Modal$ContentBackground;", "getContent", "()Lnet/mcskill/shop/client/screen/modal/Modal$ContentBackground;", "content$delegate", "afterInitialization", "", "close", "Companion", "ContentBackground", "MSShop"})
@SourceDebugExtension({"SMAP\nModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Modal.kt\nnet/mcskill/shop/client/screen/modal/Modal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 animations.kt\ngg/essential/elementa/dsl/AnimationsKt\n*L\n1#1,107:1\n10#2,3:108\n10#2,3:111\n10#2,3:114\n10#3,5:117\n*S KotlinDebug\n*F\n+ 1 Modal.kt\nnet/mcskill/shop/client/screen/modal/Modal\n*L\n48#1:108,3\n57#1:111,3\n64#1:114,3\n74#1:117,5\n*E\n"})
public abstract class Modal extends UIContainer {

    @NotNull
    private final State<Float> contentWidth;

    @NotNull
    private final State<Float> contentHeight;

    @NotNull
    private final Color _backgroundColor;

    /* JADX INFO: renamed from: background$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty background;

    /* JADX INFO: renamed from: content$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty content;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Modal.class, "background", "getBackground()Lgg/essential/elementa/UIComponent;", 0)), Reflection.property1(new PropertyReference1Impl(Modal.class, "content", "getContent()Lnet/mcskill/shop/client/screen/modal/Modal$ContentBackground;", 0))};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public final State<Float> getContentWidth() {
        return this.contentWidth;
    }

    @NotNull
    public final State<Float> getContentHeight() {
        return this.contentHeight;
    }

    /* JADX INFO: compiled from: Modal.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/Modal$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006 \u0007*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0005¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u0004\u0018\u00010\u0006¨\u0006\n"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/Modal$Companion;", "", "<init>", "()V", "all", "", "Lnet/mcskill/shop/client/screen/modal/Modal;", "kotlin.jvm.PlatformType", "()Ljava/util/List;", "last", "MSShop"})
    @SourceDebugExtension({"SMAP\nModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Modal.kt\nnet/mcskill/shop/client/screen/modal/Modal$Companion\n+ 2 UIComponent.kt\ngg/essential/elementa/UIComponent\n*L\n1#1,107:1\n263#2:108\n*S KotlinDebug\n*F\n+ 1 Modal.kt\nnet/mcskill/shop/client/screen/modal/Modal$Companion\n*L\n33#1:108\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        public final List<Modal> all() {
            UIComponent window;
            WindowScreen currentScreen = UScreen.Companion.getCurrentScreen();
            WindowScreen windowScreen = currentScreen instanceof WindowScreen ? currentScreen : null;
            if (windowScreen != null && (window = windowScreen.getWindow()) != null) {
                UIComponent this_$iv = window;
                List<Modal> listChildrenOfType = this_$iv.childrenOfType(Modal.class);
                if (listChildrenOfType != null) {
                    return listChildrenOfType;
                }
            }
            return Collections.emptyList();
        }

        @Nullable
        public final Modal last() {
            List<Modal> listAll = all();
            if (listAll.isEmpty()) {
                return null;
            }
            Intrinsics.checkNotNull(listAll);
            return (Modal) CollectionsKt.last(listAll);
        }
    }

    public Modal(@NotNull String title, @NotNull State<Float> state, @NotNull State<Float> state2) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(state, "contentWidth");
        Intrinsics.checkNotNullParameter(state2, "contentHeight");
        this.contentWidth = state;
        this.contentHeight = state2;
        this._backgroundColor = new Color(0, 0, 0, 150);
        MSRoundedRectangle mSRoundedRectangle = (UIComponent) new MSRoundedRectangle(false, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$background_delegate_u24lambda_u240 = mSRoundedRectangle.getConstraints();
        $this$background_delegate_u24lambda_u240.setWidth(new FillConstraint(false));
        $this$background_delegate_u24lambda_u240.setHeight(new FillConstraint(false));
        $this$background_delegate_u24lambda_u240.setRadius(UtilitiesKt.getDp((Number) 22));
        $this$background_delegate_u24lambda_u240.setColor(UtilitiesKt.toConstraint(new Color(0, 0, 0, 0)));
        this.background = ComponentsKt.provideDelegate(ComponentsKt.childOf(mSRoundedRectangle.onMouseClick((v1, v2) -> {
            return background_delegate$lambda$1(r2, v1, v2);
        }), (UIComponent) this), this, $$delegatedProperties[0]);
        UIComponent $this$constrain$iv = new ContentBackground(this, title, 16.0f);
        UIConstraints $this$content_delegate_u24lambda_u242 = $this$constrain$iv.getConstraints();
        $this$content_delegate_u24lambda_u242.setWidth(ExtensionsKt.dp$default(this.contentWidth, false, false, 3, (Object) null));
        $this$content_delegate_u24lambda_u242.setHeight(ExtensionsKt.dp$default(this.contentHeight, false, false, 3, (Object) null));
        $this$content_delegate_u24lambda_u242.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getBackgroundModal()));
        this.content = ComponentsKt.provideDelegate(ComponentsKt.childOf(ComponentsKt.effect($this$constrain$iv, new RoundOutlineEffect(new Color(139, 139, 139, 102), 13.0f, 2.5f, 1.0f, false, 16, (DefaultConstructorMarker) null)), (UIComponent) this), this, $$delegatedProperties[1]);
        UIConstraints $this$_init__u24lambda_u243 = ((UIComponent) this).getConstraints();
        $this$_init__u24lambda_u243.setX(new CenterConstraint());
        $this$_init__u24lambda_u243.setY(ConstraintsKt.plus(new CenterConstraint(), UtilitiesKt.getDp((Number) 50)));
        $this$_init__u24lambda_u243.setWidth(UtilitiesKt.getDp(Float.valueOf(1420.0f)));
        $this$_init__u24lambda_u243.setHeight(UtilitiesKt.getDp(Float.valueOf(699.0f)));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Modal(@NotNull String name, float width, float height) {
        this(name, (State<Float>) new BasicState(Float.valueOf(width)), (State<Float>) new BasicState(Float.valueOf(height)));
        Intrinsics.checkNotNullParameter(name, "name");
    }

    @NotNull
    public final UIComponent getBackground() {
        return (UIComponent) this.background.getValue(this, $$delegatedProperties[0]);
    }

    private static final Unit background_delegate$lambda$1(Modal this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.close();
        return Unit.INSTANCE;
    }

    @NotNull
    public final ContentBackground getContent() {
        return (ContentBackground) this.content.getValue(this, $$delegatedProperties[1]);
    }

    public void afterInitialization() {
        super.afterInitialization();
        UIComponent $this$animate$iv = getBackground();
        AnimatingConstraints anim$iv = $this$animate$iv.makeAnimation();
        AnimatingConstraints.setColorAnimation$default(anim$iv, Animations.OUT_EXP, 0.5f, UtilitiesKt.toConstraint(this._backgroundColor), 0.0f, 8, (Object) null);
        $this$animate$iv.animateTo(anim$iv);
    }

    public void close() {
        hide(true);
    }

    /* JADX INFO: compiled from: Modal.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/Modal$ContentBackground.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lnet/mcskill/shop/client/screen/modal/Modal$ContentBackground;", "Lgg/essential/elementa/components/UIRoundedRectangle;", "name", "", "radius", "", "<init>", "(Lnet/mcskill/shop/client/screen/modal/Modal;Ljava/lang/String;F)V", "title", "Lgg/essential/elementa/components/LabelComponent;", "getTitle", "()Lgg/essential/elementa/components/LabelComponent;", "title$delegate", "Lkotlin/properties/ReadWriteProperty;", "close", "Lgg/essential/elementa/UIComponent;", "getClose", "()Lgg/essential/elementa/UIComponent;", "close$delegate", "MSShop"})
    @SourceDebugExtension({"SMAP\nModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Modal.kt\nnet/mcskill/shop/client/screen/modal/Modal$ContentBackground\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n*L\n1#1,107:1\n10#2,3:108\n10#2,3:111\n10#2,3:114\n*S KotlinDebug\n*F\n+ 1 Modal.kt\nnet/mcskill/shop/client/screen/modal/Modal$ContentBackground\n*L\n84#1:108,3\n91#1:111,3\n101#1:114,3\n*E\n"})
    public final class ContentBackground extends UIRoundedRectangle {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ContentBackground.class, "title", "getTitle()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(ContentBackground.class, "close", "getClose()Lgg/essential/elementa/UIComponent;", 0))};

        /* JADX INFO: renamed from: title$delegate, reason: from kotlin metadata */
        @NotNull
        private final ReadWriteProperty title;

        /* JADX INFO: renamed from: close$delegate, reason: from kotlin metadata */
        @NotNull
        private final ReadWriteProperty close;
        final /* synthetic */ Modal this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContentBackground(@NotNull Modal this$0, String name, float radius) {
            super(radius, false, 2, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(name, "name");
            this.this$0 = this$0;
            UIComponent $this$constrain$iv = new LabelComponent("§l" + name, false, (Color) null, 6, (DefaultConstructorMarker) null);
            UIConstraints $this$title_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
            $this$title_delegate_u24lambda_u240.setX(new CenterConstraint());
            $this$title_delegate_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 32));
            $this$title_delegate_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
            $this$title_delegate_u24lambda_u240.setTextScale(UtilitiesKt.getDp((Number) 36));
            this.title = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, (UIComponent) this), this, $$delegatedProperties[0]);
            ImageComponent imageComponent = (UIComponent) new ImageComponent(States.INSTANCE.getCloseIcon(), (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
            UIConstraints $this$close_delegate_u24lambda_u241 = imageComponent.getConstraints();
            $this$close_delegate_u24lambda_u241.setX(UtilitiesKt.dp$default(Double.valueOf(27.2d), true, false, 2, (Object) null));
            $this$close_delegate_u24lambda_u241.setY(UtilitiesKt.getDp(Double.valueOf(23.21d)));
            $this$close_delegate_u24lambda_u241.setWidth(new AspectConstraint(0.0f, 1, (DefaultConstructorMarker) null));
            $this$close_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp(Double.valueOf(17.58d)));
            Modal modal = this.this$0;
            this.close = ComponentsKt.provideDelegate(ComponentsKt.childOf(imageComponent.onMouseClick((v1, v2) -> {
                return close_delegate$lambda$2(r2, v1, v2);
            }), (UIComponent) this), this, $$delegatedProperties[1]);
            UIConstraints $this$_init__u24lambda_u243 = ((UIComponent) this).getConstraints();
            $this$_init__u24lambda_u243.setX(new CenterConstraint());
            $this$_init__u24lambda_u243.setY(new CenterConstraint());
        }

        @NotNull
        public final LabelComponent getTitle() {
            return (LabelComponent) this.title.getValue(this, $$delegatedProperties[0]);
        }

        @NotNull
        public final UIComponent getClose() {
            return (UIComponent) this.close.getValue(this, $$delegatedProperties[1]);
        }

        private static final Unit close_delegate$lambda$2(Modal this$0, UIComponent $this$onMouseClick, UIClickEvent it) {
            Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
            Intrinsics.checkNotNullParameter(it, "it");
            this$0.close();
            return Unit.INSTANCE;
        }
    }
}
