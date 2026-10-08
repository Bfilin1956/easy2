package net.mcskill.shop.client.screen.modal.group;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.ScrollComponent;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.components.WrappedText;
import gg.essential.elementa.components.image.ImageView;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.constraints.HeightConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.constraints.WidthConstraint;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.font.FontProvider;
import gg.essential.elementa.markdown.MarkdownComponent;
import gg.essential.elementa.markdown.MarkdownConfig;
import gg.essential.elementa.state.ExtensionsKt;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import net.mcskill.core.client.MSCoreClient;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.mcskill.shop.client.data.Description;
import net.mcskill.shop.client.data.SectionDescription;
import net.mcskill.shop.client.screen.ShopScreen;
import net.mcskill.shop.client.screen.component.ChildNode;
import net.mcskill.shop.client.screen.component.ScrollBar;
import net.mcskill.shop.client.screen.component.TreeGraphGroup;
import net.mcskill.shop.client.screen.modal.Modal;
import net.mcskill.shop.client.screen.modal.cases.component.DustInfoBlock;
import net.mcskill.shop.common.response.shop.GroupData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseGroupModal.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/group/BaseGroupModal.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010*\u001a\u00020+2\u0006\u0010\u0004\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010,J\u0014\u0010-\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u001b\u0010\b\u001a\u00020\t8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\t8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0014\u0010\u000bR\u001b\u0010\u0016\u001a\u00020\u00178DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\r\u001a\u0004\b'\u0010(¨\u0006."}, d2 = {"Lnet/mcskill/shop/client/screen/modal/group/BaseGroupModal;", "Lnet/mcskill/shop/client/screen/modal/Modal;", "title", "", "group", "Lnet/mcskill/shop/common/response/shop/GroupData;", "<init>", "(Ljava/lang/String;Lnet/mcskill/shop/common/response/shop/GroupData;)V", "_serverTitle", "Lgg/essential/elementa/components/WrappedText;", "get_serverTitle", "()Lgg/essential/elementa/components/WrappedText;", "_serverTitle$delegate", "Lkotlin/properties/ReadWriteProperty;", "_logo", "Lgg/essential/elementa/components/image/ImageView;", "get_logo", "()Lgg/essential/elementa/components/image/ImageView;", "_logo$delegate", "_groupNameLabel", "get_groupNameLabel", "_groupNameLabel$delegate", "_divider", "Lgg/essential/elementa/components/UIRoundedRectangle;", "get_divider", "()Lgg/essential/elementa/components/UIRoundedRectangle;", "_divider$delegate", "_capabilityLabel", "Lgg/essential/elementa/components/LabelComponent;", "get_capabilityLabel", "()Lgg/essential/elementa/components/LabelComponent;", "_capabilityLabel$delegate", "_verticalScrollBar", "Lnet/mcskill/shop/client/screen/component/ScrollBar;", "get_verticalScrollBar", "()Lnet/mcskill/shop/client/screen/component/ScrollBar;", "_verticalScrollBar$delegate", "_scrollView", "Lgg/essential/elementa/components/ScrollComponent;", "get_scrollView", "()Lgg/essential/elementa/components/ScrollComponent;", "_scrollView$delegate", "parseDescriptionFuture", "", "(Lnet/mcskill/shop/common/response/shop/GroupData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parsePrefix", "MSShop"})
@SourceDebugExtension({"SMAP\nBaseGroupModal.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseGroupModal.kt\nnet/mcskill/shop/client/screen/modal/group/BaseGroupModal\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,151:1\n10#2,3:152\n10#2,3:155\n10#2,3:158\n10#2,3:161\n10#2,3:164\n10#2,3:167\n10#2,3:170\n10#2,3:173\n10#2,3:176\n10#2,3:179\n10#2,3:182\n1#3:185\n*S KotlinDebug\n*F\n+ 1 BaseGroupModal.kt\nnet/mcskill/shop/client/screen/modal/group/BaseGroupModal\n*L\n33#1:152,3\n41#1:155,3\n48#1:158,3\n56#1:161,3\n64#1:164,3\n71#1:167,3\n82#1:170,3\n105#1:173,3\n114#1:176,3\n122#1:179,3\n130#1:182,3\n*E\n"})
public abstract class BaseGroupModal extends Modal {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(BaseGroupModal.class, "_serverTitle", "get_serverTitle()Lgg/essential/elementa/components/WrappedText;", 0)), Reflection.property1(new PropertyReference1Impl(BaseGroupModal.class, "_logo", "get_logo()Lgg/essential/elementa/components/image/ImageView;", 0)), Reflection.property1(new PropertyReference1Impl(BaseGroupModal.class, "_groupNameLabel", "get_groupNameLabel()Lgg/essential/elementa/components/WrappedText;", 0)), Reflection.property1(new PropertyReference1Impl(BaseGroupModal.class, "_divider", "get_divider()Lgg/essential/elementa/components/UIRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(BaseGroupModal.class, "_capabilityLabel", "get_capabilityLabel()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(BaseGroupModal.class, "_verticalScrollBar", "get_verticalScrollBar()Lnet/mcskill/shop/client/screen/component/ScrollBar;", 0)), Reflection.property1(new PropertyReference1Impl(BaseGroupModal.class, "_scrollView", "get_scrollView()Lgg/essential/elementa/components/ScrollComponent;", 0))};

    /* JADX INFO: renamed from: _serverTitle$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _serverTitle;

    /* JADX INFO: renamed from: _logo$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _logo;

    /* JADX INFO: renamed from: _groupNameLabel$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _groupNameLabel;

    /* JADX INFO: renamed from: _divider$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _divider;

    /* JADX INFO: renamed from: _capabilityLabel$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _capabilityLabel;

    /* JADX INFO: renamed from: _verticalScrollBar$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _verticalScrollBar;

    /* JADX INFO: renamed from: _scrollView$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty _scrollView;

    /* JADX INFO: renamed from: net.mcskill.shop.client.screen.modal.group.BaseGroupModal$parseDescriptionFuture$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseGroupModal.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/group/BaseGroupModal$parseDescriptionFuture$1.class */
    @Metadata(mv = {2, 0, 0}, k = 3, xi = 48)
    @DebugMetadata(f = "BaseGroupModal.kt", l = {99}, i = {0}, s = {"L$0"}, n = {"this"}, m = "parseDescriptionFuture", c = "net.mcskill.shop.client.screen.modal.group.BaseGroupModal")
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        /* synthetic */ Object result;
        int label;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object $result) {
            this.result = $result;
            this.label |= Integer.MIN_VALUE;
            return BaseGroupModal.this.parseDescriptionFuture(null, (Continuation) this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseGroupModal(@NotNull String title, @NotNull GroupData group) {
        super(title, 883.0f, 586.0f);
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(group, "group");
        UIComponent $this$constrain$iv = new WrappedText("§l" + MSCoreClient.Companion.getCurrentServer().getTitle(), false, (Color) null, true, false, 0.0f, (String) null, 118, (DefaultConstructorMarker) null);
        UIConstraints $this$_serverTitle_delegate_u24lambda_u240 = $this$constrain$iv.getConstraints();
        $this$_serverTitle_delegate_u24lambda_u240.setX(UtilitiesKt.getDp((Number) 20));
        $this$_serverTitle_delegate_u24lambda_u240.setY(UtilitiesKt.getDp((Number) 95));
        $this$_serverTitle_delegate_u24lambda_u240.setWidth(UtilitiesKt.getDp((Number) 300));
        $this$_serverTitle_delegate_u24lambda_u240.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_serverTitle_delegate_u24lambda_u240.setTextScale(UtilitiesKt.getDp((Number) 24));
        this._serverTitle = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv, getContent()), this, $$delegatedProperties[0]);
        Object[] objArr = {group.getPexName()};
        String str = String.format(ShopScreen.GROUP_IMG_DIR, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        UIComponent $this$constrain$iv2 = new ImageView(str, 1.0f, 1.0f, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, (WidthConstraint) null, (HeightConstraint) null, DustInfoBlock.DELIMITER, (DefaultConstructorMarker) null);
        UIConstraints $this$_logo_delegate_u24lambda_u241 = $this$constrain$iv2.getConstraints();
        $this$_logo_delegate_u24lambda_u241.setX(UtilitiesKt.getDp((Number) 88));
        $this$_logo_delegate_u24lambda_u241.setY(new SiblingConstraint(8.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_logo_delegate_u24lambda_u241.setWidth(UtilitiesKt.getDp((Number) 164));
        $this$_logo_delegate_u24lambda_u241.setHeight(UtilitiesKt.getDp((Number) 164));
        this._logo = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, getContent()), this, $$delegatedProperties[1]);
        UIComponent $this$constrain$iv3 = new WrappedText(group.getPrettyName(), false, (Color) null, true, false, 0.0f, (String) null, 118, (DefaultConstructorMarker) null);
        UIConstraints $this$_groupNameLabel_delegate_u24lambda_u242 = $this$constrain$iv3.getConstraints();
        $this$_groupNameLabel_delegate_u24lambda_u242.setX(ConstraintsKt.boundTo(new CenterConstraint(), get_logo()));
        $this$_groupNameLabel_delegate_u24lambda_u242.setY(new SiblingConstraint(20.0f, false, false, 6, (DefaultConstructorMarker) null));
        $this$_groupNameLabel_delegate_u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 300));
        $this$_groupNameLabel_delegate_u24lambda_u242.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_groupNameLabel_delegate_u24lambda_u242.setTextScale(UtilitiesKt.getDp((Number) 24));
        this._groupNameLabel = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, getContent()), this, $$delegatedProperties[2]);
        UIComponent $this$constrain$iv4 = new UIRoundedRectangle(5.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$_divider_delegate_u24lambda_u243 = $this$constrain$iv4.getConstraints();
        $this$_divider_delegate_u24lambda_u243.setX(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp(Double.valueOf(102.5d))));
        $this$_divider_delegate_u24lambda_u243.setY(ConstraintsKt.plus(new CenterConstraint(), UtilitiesKt.getDp(Double.valueOf(31.5d))));
        $this$_divider_delegate_u24lambda_u243.setWidth(UtilitiesKt.getDp((Number) 4));
        $this$_divider_delegate_u24lambda_u243.setHeight(UtilitiesKt.getDp((Number) 459));
        $this$_divider_delegate_u24lambda_u243.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA1()));
        this._divider = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, getContent()), this, $$delegatedProperties[3]);
        UIComponent $this$constrain$iv5 = new LabelComponent("§lВозможности привилегии", false, (Color) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$_capabilityLabel_delegate_u24lambda_u244 = $this$constrain$iv5.getConstraints();
        $this$_capabilityLabel_delegate_u24lambda_u244.setX(ConstraintsKt.plus(new CenterConstraint(), UtilitiesKt.getDp((Number) 176)));
        $this$_capabilityLabel_delegate_u24lambda_u244.setY(UtilitiesKt.getDp((Number) 95));
        $this$_capabilityLabel_delegate_u24lambda_u244.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$_capabilityLabel_delegate_u24lambda_u244.setTextScale(UtilitiesKt.getDp((Number) 24));
        this._capabilityLabel = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv5, getContent()), this, $$delegatedProperties[4]);
        UIComponent $this$constrain$iv6 = new ScrollBar(4.0f, false, 2, null);
        UIConstraints $this$_verticalScrollBar_delegate_u24lambda_u245 = $this$constrain$iv6.getConstraints();
        $this$_verticalScrollBar_delegate_u24lambda_u245.setX(UtilitiesKt.dp$default((Number) 14, true, false, 2, (Object) null));
        $this$_verticalScrollBar_delegate_u24lambda_u245.setY(UtilitiesKt.getDp((Number) 144));
        $this$_verticalScrollBar_delegate_u24lambda_u245.setWidth(UtilitiesKt.getDp((Number) 16));
        $this$_verticalScrollBar_delegate_u24lambda_u245.setHeight(UtilitiesKt.getDp((Number) 411));
        $this$_verticalScrollBar_delegate_u24lambda_u245.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA1()));
        this._verticalScrollBar = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv6, getContent()), this, $$delegatedProperties[5]);
        UIComponent $this$constrain$iv7 = new ScrollComponent("Загрузка описания...", 25.0f, 0.0f, (Color) null, false, false, false, false, 25.0f, 0.0f, (UIComponent) null, 1788, (DefaultConstructorMarker) null);
        UIConstraints $this$_scrollView_delegate_u24lambda_u246 = $this$constrain$iv7.getConstraints();
        $this$_scrollView_delegate_u24lambda_u246.setX(ConstraintsKt.boundTo(UtilitiesKt.getDp((Number) 20), get_divider()));
        $this$_scrollView_delegate_u24lambda_u246.setY(UtilitiesKt.getDp((Number) 144));
        $this$_scrollView_delegate_u24lambda_u246.setWidth(ConstraintsKt.minus(UtilitiesKt.getDp((Number) 492), UtilitiesKt.getPixel(Float.valueOf(get_verticalScrollBar().getWidth()))));
        $this$_scrollView_delegate_u24lambda_u246.setHeight(UtilitiesKt.getDp((Number) 411));
        this._scrollView = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv7, getContent()), this, $$delegatedProperties[6]);
        get_verticalScrollBar().attachTo(get_scrollView());
        BuildersKt.runBlocking$default((CoroutineContext) null, new AnonymousClass1(group, null), 1, (Object) null);
    }

    @NotNull
    protected final WrappedText get_serverTitle() {
        return (WrappedText) this._serverTitle.getValue(this, $$delegatedProperties[0]);
    }

    @NotNull
    protected final ImageView get_logo() {
        return (ImageView) this._logo.getValue(this, $$delegatedProperties[1]);
    }

    @NotNull
    protected final WrappedText get_groupNameLabel() {
        return (WrappedText) this._groupNameLabel.getValue(this, $$delegatedProperties[2]);
    }

    @NotNull
    protected final UIRoundedRectangle get_divider() {
        return (UIRoundedRectangle) this._divider.getValue(this, $$delegatedProperties[3]);
    }

    @NotNull
    protected final LabelComponent get_capabilityLabel() {
        return (LabelComponent) this._capabilityLabel.getValue(this, $$delegatedProperties[4]);
    }

    @NotNull
    protected final ScrollBar get_verticalScrollBar() {
        return (ScrollBar) this._verticalScrollBar.getValue(this, $$delegatedProperties[5]);
    }

    @NotNull
    protected final ScrollComponent get_scrollView() {
        return (ScrollComponent) this._scrollView.getValue(this, $$delegatedProperties[6]);
    }

    /* JADX INFO: renamed from: net.mcskill.shop.client.screen.modal.group.BaseGroupModal$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseGroupModal.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/modal/group/BaseGroupModal$1.class */
    @Metadata(mv = {2, 0, 0}, k = 3, xi = 48, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"})
    @DebugMetadata(f = "BaseGroupModal.kt", l = {93}, i = {}, s = {}, n = {}, m = "invokeSuspend", c = "net.mcskill.shop.client.screen.modal.group.BaseGroupModal$1")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GroupData $group;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GroupData $group, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$group = $group;
        }

        public final Continuation<Unit> create(Object value, Continuation<?> continuation) {
            return BaseGroupModal.this.new AnonymousClass1(this.$group, continuation);
        }

        public final Object invoke(CoroutineScope p1, Continuation<? super Unit> continuation) {
            return create(p1, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (BaseGroupModal.this.parseDescriptionFuture(this.$group, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0029  */
    public final Object parseDescriptionFuture(GroupData group, Continuation<? super Unit> continuation) {
        C00001 c00001;
        Object objWithContext;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = new C00001(continuation);
            }
        } else {
            c00001 = new C00001(continuation);
        }
        Object $result = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00001.L$0 = this;
                c00001.label = 1;
                objWithContext = BuildersKt.withContext(Dispatchers.getDefault(), new BaseGroupModal$parseDescriptionFuture$sections$1(this, group, null), c00001);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                this = (BaseGroupModal) c00001.L$0;
                ResultKt.throwOnFailure($result);
                objWithContext = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List<SectionDescription> sections = (List) objWithContext;
        for (SectionDescription element : sections) {
            UIComponent $this$constrain$iv = new TreeGraphGroup(element.getTitle());
            UIConstraints $this$parseDescriptionFuture_u24lambda_u247 = $this$constrain$iv.getConstraints();
            $this$parseDescriptionFuture_u24lambda_u247.setY(new SiblingConstraint(12.0f, false, false, 6, (DefaultConstructorMarker) null));
            $this$parseDescriptionFuture_u24lambda_u247.setWidth(new FillConstraint(false));
            $this$parseDescriptionFuture_u24lambda_u247.setHeight(new ChildBasedSizeConstraint(1.0f, false, 2, (DefaultConstructorMarker) null));
            TreeGraphGroup section = (TreeGraphGroup) ComponentsKt.childOf($this$constrain$iv, this.get_scrollView());
            for (Description description : element.getData()) {
                if (description.getTitle().length() == 0) {
                    if (!(description.getDescription().length() == 0)) {
                    }
                }
                UIComponent childNode = new ChildNode();
                UIComponent $this$constrain$iv2 = (UIComponent) new MarkdownComponent(description.getTitle() + description.getDescription(), (MarkdownConfig) null, 0.0f, (FontProvider) null, 14, (DefaultConstructorMarker) null);
                UIConstraints $this$parseDescriptionFuture_u24lambda_u249_u24lambda_u248 = $this$constrain$iv2.getConstraints();
                $this$parseDescriptionFuture_u24lambda_u249_u24lambda_u248.setY(new SiblingConstraint(11.0f, false, false, 6, (DefaultConstructorMarker) null));
                $this$parseDescriptionFuture_u24lambda_u249_u24lambda_u248.setWidth(new FillConstraint(false));
                $this$parseDescriptionFuture_u24lambda_u249_u24lambda_u248.setHeight(UtilitiesKt.getDp(Boxing.boxInt(500)));
                $this$parseDescriptionFuture_u24lambda_u249_u24lambda_u248.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
                $this$parseDescriptionFuture_u24lambda_u249_u24lambda_u248.setTextScale(UtilitiesKt.getDp(Boxing.boxInt(18)));
                childNode.appendContent($this$constrain$iv2);
                UIComponent $this$constrain$iv3 = childNode;
                UIConstraints $this$parseDescriptionFuture_u24lambda_u2410 = $this$constrain$iv3.getConstraints();
                $this$parseDescriptionFuture_u24lambda_u2410.setY(new SiblingConstraint(4.0f, false, false, 6, (DefaultConstructorMarker) null));
                section.appendNode((ChildNode) $this$constrain$iv3);
                if (!description.getImages().isEmpty()) {
                    for (String image : description.getImages()) {
                        if (!(image.length() == 0) && StringsKt.contains$default(image, "http", false, 2, (Object) null)) {
                            UIComponent $this$constrain$iv4 = (UIComponent) new MarkdownComponent("![](" + image + ")", (MarkdownConfig) null, 0.0f, (FontProvider) null, 14, (DefaultConstructorMarker) null);
                            UIConstraints $this$parseDescriptionFuture_u24lambda_u2411 = $this$constrain$iv4.getConstraints();
                            $this$parseDescriptionFuture_u24lambda_u2411.setY(new SiblingConstraint(11.0f, false, false, 6, (DefaultConstructorMarker) null));
                            $this$parseDescriptionFuture_u24lambda_u2411.setWidth(new FillConstraint(false));
                            $this$parseDescriptionFuture_u24lambda_u2411.setHeight(UtilitiesKt.getDp(Boxing.boxInt(150)));
                            childNode.appendContent($this$constrain$iv4);
                        }
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String parsePrefix(String $this$parsePrefix, GroupData group) {
        String string;
        if (!StringsKt.contains$default($this$parsePrefix, "%prefix%", false, 2, (Object) null)) {
            return $this$parsePrefix;
        }
        String color = group.getColor();
        String color2 = color.length() == 0 ? "" : color;
        String str = $this$parsePrefix;
        String str2 = "%prefix%";
        String str3 = color2;
        String pexName = group.getPexName();
        if (pexName.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char cCharAt = pexName.charAt(0);
            str = str;
            str2 = "%prefix%";
            str3 = str3;
            StringBuilder sbAppend = sb.append((Object) (Character.isLowerCase(cCharAt) ? CharsKt.titlecase(cCharAt) : String.valueOf(cCharAt)));
            String strSubstring = pexName.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            string = sbAppend.append(strSubstring).toString();
        } else {
            string = pexName;
        }
        return StringsKt.replace$default(str, str2, str3 + "[" + string + "]&r", false, 4, (Object) null);
    }
}
