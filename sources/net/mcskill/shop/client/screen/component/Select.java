package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.LabelComponent;
import gg.essential.elementa.components.ScrollComponent;
import gg.essential.elementa.components.UIBlock;
import gg.essential.elementa.components.UIContainer;
import gg.essential.elementa.components.UIImage;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.components.image.ImageComponent;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.ChildBasedSizeConstraint;
import gg.essential.elementa.constraints.CopyConstraintFloat;
import gg.essential.elementa.constraints.FillConstraint;
import gg.essential.elementa.constraints.HeightConstraint;
import gg.essential.elementa.constraints.SiblingConstraint;
import gg.essential.elementa.constraints.animation.AnimatingConstraints;
import gg.essential.elementa.constraints.animation.Animations;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.RoundOutlineEffect;
import gg.essential.elementa.effects.ScissorEffect;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.font.FontProvider;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.ExtensionsKt;
import gg.essential.elementa.state.ReadOnlyState;
import gg.essential.elementa.state.State;
import gg.essential.elementa.state.StateKt;
import gg.essential.elementa.utils.ResourcesKt;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.mcskill.core.client.screen.MSFonts;
import net.mcskill.core.client.screen.MSPalette;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Select.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/Select.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010P\u001a\u00020\tH\u0002J\u000e\u0010R\u001a\u00020\u001e2\u0006\u0010S\u001a\u00020\u0003J\u0010\u0010T\u001a\u00020\u001e2\b\b\u0002\u0010U\u001a\u00020\u0015J\u0010\u0010V\u001a\u00020\u001e2\b\b\u0002\u0010U\u001a\u00020\u0015JI\u0010W\u001a\u00020\u00002A\u0010X\u001a=\u0012\u0004\u0012\u00020\u0019\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u001e0\u0018¢\u0006\u0002\b\u001fJ\u0018\u0010Y\u001a\u00020\u001e2\u0006\u0010U\u001a\u00020\u00152\u0006\u0010Z\u001a\u00020[H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000RR\u0010\u0016\u001aC\u0012?\u0012=\u0012\u0004\u0012\u00020\u0019\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0018¢\u0006\u0002\b\u001f0\u0017¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001b\u0010*\u001a\u00020+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010/\u001a\u0004\b3\u00104R\u001b\u00106\u001a\u0002078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b:\u0010/\u001a\u0004\b8\u00109R\u001b\u0010;\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010/\u001a\u0004\b<\u0010=R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010/\u001a\u0004\bA\u0010BR\u001b\u0010D\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010/\u001a\u0004\bE\u0010=R\u001b\u0010G\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010/\u001a\u0004\bH\u0010IR\u001b\u0010K\u001a\u00020L8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010/\u001a\u0004\bM\u0010NR\u000e\u0010Q\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\\²\u0006\n\u0010]\u001a\u00020\u0019X\u008a\u0084\u0002²\u0006\n\u0010\u001d\u001a\u000202X\u008a\u0084\u0002"}, d2 = {"Lnet/mcskill/shop/client/screen/component/Select;", "Lgg/essential/elementa/components/UIContainer;", "initialId", "", "options", "", "", "maxDisplay", "radius", "", "expandColor", "Ljava/awt/Color;", "<init>", "(ILjava/util/List;IFLjava/awt/Color;)V", "getInitialId", "()I", "getOptions", "()Ljava/util/List;", "getMaxDisplay", "writableExpandedState", "Lgg/essential/elementa/state/State;", "", "selectionListener", "", "Lkotlin/Function3;", "Lgg/essential/elementa/UIComponent;", "Lkotlin/ParameterName;", "name", "selectedId", "text", "", "Lkotlin/ExtensionFunctionType;", "getSelectionListener", "selectedIndex", "getSelectedIndex", "()Lgg/essential/elementa/state/State;", "selectedText", "getSelectedText", "expandedState", "Lgg/essential/elementa/state/ReadOnlyState;", "getExpandedState", "()Lgg/essential/elementa/state/ReadOnlyState;", "expandedBlock", "Lgg/essential/elementa/components/UIRoundedRectangle;", "getExpandedBlock", "()Lgg/essential/elementa/components/UIRoundedRectangle;", "expandedBlock$delegate", "Lkotlin/properties/ReadWriteProperty;", "selectAreaHovered", "currentSelectionText", "Lgg/essential/elementa/components/LabelComponent;", "getCurrentSelectionText", "()Lgg/essential/elementa/components/LabelComponent;", "currentSelectionText$delegate", "downArrow", "Lgg/essential/elementa/components/image/ImageComponent;", "getDownArrow", "()Lgg/essential/elementa/components/image/ImageComponent;", "downArrow$delegate", "scrollerContainer", "getScrollerContainer", "()Lgg/essential/elementa/components/UIContainer;", "scrollerContainer$delegate", "scroller", "Lgg/essential/elementa/components/ScrollComponent;", "getScroller", "()Lgg/essential/elementa/components/ScrollComponent;", "scroller$delegate", "expandedContent", "getExpandedContent", "expandedContent$delegate", "scrollbarContainer", "getScrollbarContainer", "()Lgg/essential/elementa/UIComponent;", "scrollbarContainer$delegate", "scrollbar", "Lgg/essential/elementa/components/UIBlock;", "getScrollbar", "()Lgg/essential/elementa/components/UIBlock;", "scrollbar$delegate", "getMaxItemWidth", "scrollable", "select", "index", "expand", "instantly", "collapse", "onSelection", "method", "applyExpandedBlockHeight", "heightConstraint", "Lgg/essential/elementa/constraints/HeightConstraint;", "MSShop", "optionContainer"})
@SourceDebugExtension({"SMAP\nSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Select.kt\nnet/mcskill/shop/client/screen/component/Select\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 animations.kt\ngg/essential/elementa/dsl/AnimationsKt\n*L\n1#1,208:1\n10#2,3:209\n10#2,3:212\n10#2,3:215\n10#2,3:218\n10#2,3:221\n10#2,3:224\n10#2,3:227\n10#2,3:230\n10#2,3:233\n10#2,3:237\n10#2,3:240\n1863#3:236\n1864#3:243\n10#4,5:244\n*S KotlinDebug\n*F\n+ 1 Select.kt\nnet/mcskill/shop/client/screen/component/Select\n*L\n38#1:209,3\n46#1:212,3\n54#1:215,3\n61#1:218,3\n67#1:221,3\n72#1:224,3\n77#1:227,3\n88#1:230,3\n101#1:233,3\n128#1:237,3\n140#1:240,3\n127#1:236\n127#1:243\n203#1:244,5\n*E\n"})
public final class Select extends UIContainer {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Select.class, "expandedBlock", "getExpandedBlock()Lgg/essential/elementa/components/UIRoundedRectangle;", 0)), Reflection.property1(new PropertyReference1Impl(Select.class, "currentSelectionText", "getCurrentSelectionText()Lgg/essential/elementa/components/LabelComponent;", 0)), Reflection.property1(new PropertyReference1Impl(Select.class, "downArrow", "getDownArrow()Lgg/essential/elementa/components/image/ImageComponent;", 0)), Reflection.property1(new PropertyReference1Impl(Select.class, "scrollerContainer", "getScrollerContainer()Lgg/essential/elementa/components/UIContainer;", 0)), Reflection.property1(new PropertyReference1Impl(Select.class, "scroller", "getScroller()Lgg/essential/elementa/components/ScrollComponent;", 0)), Reflection.property1(new PropertyReference1Impl(Select.class, "expandedContent", "getExpandedContent()Lgg/essential/elementa/components/UIContainer;", 0)), Reflection.property1(new PropertyReference1Impl(Select.class, "scrollbarContainer", "getScrollbarContainer()Lgg/essential/elementa/UIComponent;", 0)), Reflection.property1(new PropertyReference1Impl(Select.class, "scrollbar", "getScrollbar()Lgg/essential/elementa/components/UIBlock;", 0)), Reflection.property0(new PropertyReference0Impl(Select.class, "optionContainer", "<v#0>", 0)), Reflection.property0(new PropertyReference0Impl(Select.class, "text", "<v#1>", 0))};
    private final int initialId;

    @NotNull
    private final List<String> options;
    private final int maxDisplay;

    @NotNull
    private final State<Boolean> writableExpandedState;

    @NotNull
    private final List<Function3<UIComponent, Integer, String, Unit>> selectionListener;

    @NotNull
    private final State<Integer> selectedIndex;

    @NotNull
    private final State<String> selectedText;

    @NotNull
    private final ReadOnlyState<Boolean> expandedState;

    /* JADX INFO: renamed from: expandedBlock$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty expandedBlock;

    @NotNull
    private final State<Boolean> selectAreaHovered;

    /* JADX INFO: renamed from: currentSelectionText$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty currentSelectionText;

    /* JADX INFO: renamed from: downArrow$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty downArrow;

    /* JADX INFO: renamed from: scrollerContainer$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty scrollerContainer;

    /* JADX INFO: renamed from: scroller$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty scroller;

    /* JADX INFO: renamed from: expandedContent$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty expandedContent;

    /* JADX INFO: renamed from: scrollbarContainer$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty scrollbarContainer;

    /* JADX INFO: renamed from: scrollbar$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty scrollbar;
    private final boolean scrollable;

    public /* synthetic */ Select(int i, List list, int i2, float f, Color color, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, (i3 & 4) != 0 ? 6 : i2, (i3 & 8) != 0 ? 4.0f : f, (i3 & 16) != 0 ? new Color(17, 15, 18, 200) : color);
    }

    public final int getInitialId() {
        return this.initialId;
    }

    @NotNull
    public final List<String> getOptions() {
        return this.options;
    }

    public final int getMaxDisplay() {
        return this.maxDisplay;
    }

    public Select(int initialId, @NotNull List<String> list, int maxDisplay, float radius, @NotNull Color expandColor) {
        State<String> state;
        Intrinsics.checkNotNullParameter(list, "options");
        Intrinsics.checkNotNullParameter(expandColor, "expandColor");
        this.initialId = initialId;
        this.options = list;
        this.maxDisplay = maxDisplay;
        this.writableExpandedState = new BasicState<>(false);
        this.selectionListener = new ArrayList();
        this.selectedIndex = new BasicState<>(Integer.valueOf(this.initialId));
        try {
            state = (State) this.selectedIndex.map((v1) -> {
                return selectedText$lambda$0(r2, v1);
            });
        } catch (Throwable th) {
            state = StateKt.state("< пусто >");
        }
        this.selectedText = state;
        this.expandedState = new ReadOnlyState<>(this.writableExpandedState);
        UIComponent $this$constrain$iv = new UIRoundedRectangle(radius, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$expandedBlock_delegate_u24lambda_u241 = $this$constrain$iv.getConstraints();
        $this$expandedBlock_delegate_u24lambda_u241.setWidth(UtilitiesKt.getPercent((Number) 100));
        $this$expandedBlock_delegate_u24lambda_u241.setHeight(new FillConstraint(false));
        $this$expandedBlock_delegate_u24lambda_u241.setColor(UtilitiesKt.toConstraint(expandColor));
        this.expandedBlock = ComponentsKt.provideDelegate(ComponentsKt.effect(ComponentsKt.childOf(StateKt.bindFloating($this$constrain$iv, this.writableExpandedState), (UIComponent) this), new ScissorEffect((UIComponent) null, false, 3, (DefaultConstructorMarker) null)), this, $$delegatedProperties[0]);
        this.selectAreaHovered = StateKt.hoveredState$default(getExpandedBlock(), false, false, 3, (Object) null);
        UIComponent $this$constrain$iv2 = new LabelComponent((String) null, false, (Color) null, 5, (DefaultConstructorMarker) null).bindText(this.selectedText);
        UIConstraints $this$currentSelectionText_delegate_u24lambda_u242 = $this$constrain$iv2.getConstraints();
        $this$currentSelectionText_delegate_u24lambda_u242.setX(UtilitiesKt.getDp((Number) 12));
        $this$currentSelectionText_delegate_u24lambda_u242.setY(ConstraintsKt.boundTo(new CenterConstraint(), (UIComponent) this));
        $this$currentSelectionText_delegate_u24lambda_u242.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA4()));
        $this$currentSelectionText_delegate_u24lambda_u242.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
        $this$currentSelectionText_delegate_u24lambda_u242.setTextScale(UtilitiesKt.getDp((Number) 18));
        this.currentSelectionText = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv2, getExpandedBlock()), this, $$delegatedProperties[1]);
        ResourceLocation resourceLocationAsResource$default = ResourcesKt.asResource$default("textures/arrow.png", (String) null, 1, (Object) null);
        Intrinsics.checkNotNullExpressionValue(resourceLocationAsResource$default, "asResource$default(...)");
        UIComponent $this$constrain$iv3 = new ImageComponent(resourceLocationAsResource$default, (UIImage.TextureScalingMode) null, (UIImage.TextureScalingMode) null, 6, (DefaultConstructorMarker) null);
        UIConstraints $this$downArrow_delegate_u24lambda_u243 = $this$constrain$iv3.getConstraints();
        $this$downArrow_delegate_u24lambda_u243.setX(UtilitiesKt.dp$default((Number) 12, true, false, 2, (Object) null));
        $this$downArrow_delegate_u24lambda_u243.setY(ConstraintsKt.boundTo(new CenterConstraint(), (UIComponent) this));
        $this$downArrow_delegate_u24lambda_u243.setWidth(UtilitiesKt.getDp(Double.valueOf(14.29d)));
        $this$downArrow_delegate_u24lambda_u243.setHeight(UtilitiesKt.getDp(Double.valueOf(7.83d)));
        this.downArrow = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv3, getExpandedBlock()), this, $$delegatedProperties[2]);
        UIComponent $this$constrain$iv4 = new UIContainer();
        UIConstraints $this$scrollerContainer_delegate_u24lambda_u244 = $this$constrain$iv4.getConstraints();
        $this$scrollerContainer_delegate_u24lambda_u244.setY(UtilitiesKt.getDp((Number) 32));
        $this$scrollerContainer_delegate_u24lambda_u244.setWidth(new FillConstraint(false));
        $this$scrollerContainer_delegate_u24lambda_u244.setHeight(new FillConstraint(false));
        this.scrollerContainer = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv4, getExpandedBlock()), this, $$delegatedProperties[3]);
        UIComponent $this$constrain$iv5 = new ScrollComponent((String) null, 0.0f, 0.0f, (Color) null, false, false, false, false, 0.0f, 0.0f, (UIComponent) null, 2047, (DefaultConstructorMarker) null);
        UIConstraints $this$scroller_delegate_u24lambda_u245 = $this$constrain$iv5.getConstraints();
        $this$scroller_delegate_u24lambda_u245.setWidth(new FillConstraint(false));
        $this$scroller_delegate_u24lambda_u245.setHeight(new FillConstraint(false));
        this.scroller = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv5, getScrollerContainer()), this, $$delegatedProperties[4]);
        UIComponent $this$constrain$iv6 = new UIContainer();
        UIConstraints $this$expandedContent_delegate_u24lambda_u246 = $this$constrain$iv6.getConstraints();
        $this$expandedContent_delegate_u24lambda_u246.setWidth(new FillConstraint(false));
        $this$expandedContent_delegate_u24lambda_u246.setHeight(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null));
        this.expandedContent = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv6, getScroller()), this, $$delegatedProperties[5]);
        UIContainer uIContainer = (UIComponent) new UIContainer();
        UIConstraints $this$scrollbarContainer_delegate_u24lambda_u247 = uIContainer.getConstraints();
        $this$scrollbarContainer_delegate_u24lambda_u247.setX(UtilitiesKt.pixels$default((Number) 0, true, false, 2, (Object) null));
        $this$scrollbarContainer_delegate_u24lambda_u247.setY(new CenterConstraint());
        $this$scrollbarContainer_delegate_u24lambda_u247.setWidth(UtilitiesKt.getDp((Number) 2));
        $this$scrollbarContainer_delegate_u24lambda_u247.setHeight(UtilitiesKt.getPercent((Number) 100));
        this.scrollbarContainer = ComponentsKt.provideDelegate(ComponentsKt.childOf(uIContainer.onMouseClick(Select::scrollbarContainer_delegate$lambda$8), getScrollerContainer()), this, $$delegatedProperties[6]);
        UIComponent $this$constrain$iv7 = new UIBlock(MSPalette.INSTANCE.getOrange());
        UIConstraints $this$scrollbar_delegate_u24lambda_u249 = $this$constrain$iv7.getConstraints();
        $this$scrollbar_delegate_u24lambda_u249.setWidth(UtilitiesKt.getPercent((Number) 100));
        this.scrollbar = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv7, getScrollbarContainer()), this, $$delegatedProperties[7]);
        this.scrollable = this.options.size() > this.maxDisplay;
        UIConstraints $this$_init__u24lambda_u2411 = ((UIComponent) this).getConstraints();
        $this$_init__u24lambda_u2411.setWidth(UtilitiesKt.getPixels(Float.valueOf(getMaxItemWidth() + 25)));
        $this$_init__u24lambda_u2411.setHeight(new ChildBasedSizeConstraint(0.0f, false, 3, (DefaultConstructorMarker) null));
        ComponentsKt.effect(getExpandedBlock(), new RoundOutlineEffect(new Color(17, 15, 18, 220), 6.0f, 2.0f, 1.0f, false, 16, (DefaultConstructorMarker) null));
        getCurrentSelectionText().setColor(ExtensionsKt.toConstraint(StateKt.or(this.selectAreaHovered, this.expandedState).map((v0) -> {
            return _init_$lambda$12(v0);
        })));
        getDownArrow().setColor(ExtensionsKt.toConstraint(StateKt.or(this.selectAreaHovered, this.expandedState).map((v0) -> {
            return _init_$lambda$13(v0);
        })));
        if (this.scrollable) {
            getScroller().setVerticalScrollBarComponent(getScrollbar(), false);
        }
        Iterable $this$forEach$iv = CollectionsKt.withIndex(this.options);
        for (Object element$iv : $this$forEach$iv) {
            IndexedValue indexedValue = (IndexedValue) element$iv;
            int index = indexedValue.component1();
            String value = (String) indexedValue.component2();
            UIContainer uIContainer2 = (UIComponent) new UIContainer();
            UIConstraints $this$lambda_u2420_u24lambda_u2414 = uIContainer2.getConstraints();
            $this$lambda_u2420_u24lambda_u2414.setY(new SiblingConstraint(0.0f, false, false, 7, (DefaultConstructorMarker) null));
            $this$lambda_u2420_u24lambda_u2414.setWidth(UtilitiesKt.getPercent((Number) 100));
            $this$lambda_u2420_u24lambda_u2414.setHeight(UtilitiesKt.getDp((Number) 32));
            ReadWriteProperty optionContainer$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf(uIContainer2.onMouseClick((v2, v3) -> {
                return lambda$20$lambda$15(r1, r2, v2, v3);
            }), getExpandedContent()), (Object) null, $$delegatedProperties[8]);
            State hovered = StateKt.hoveredState$default(lambda$20$lambda$16(optionContainer$delegate), false, false, 3, (Object) null);
            UIComponent $this$constrain$iv8 = new LabelComponent(value, false, (Color) null, 4, (DefaultConstructorMarker) null);
            UIConstraints $this$lambda_u2420_u24lambda_u2417 = $this$constrain$iv8.getConstraints();
            $this$lambda_u2420_u24lambda_u2417.setX(UtilitiesKt.getDp((Number) 12));
            $this$lambda_u2420_u24lambda_u2417.setY(new CenterConstraint());
            $this$lambda_u2420_u24lambda_u2417.setColor(ExtensionsKt.toConstraint(MSPalette.INSTANCE.getWhiteA4()));
            $this$lambda_u2420_u24lambda_u2417.setFontProvider(MSFonts.getFS_ELLIOT_PRO());
            $this$lambda_u2420_u24lambda_u2417.setTextScale(UtilitiesKt.getDp((Number) 18));
            ReadWriteProperty text$delegate = ComponentsKt.provideDelegate(ComponentsKt.childOf($this$constrain$iv8, lambda$20$lambda$16(optionContainer$delegate)), (Object) null, $$delegatedProperties[9]);
            lambda$20$lambda$18(text$delegate).setColor(ExtensionsKt.toConstraint(hovered.map((v0) -> {
                return lambda$20$lambda$19(v0);
            })));
        }
        getExpandedBlock().onMouseClick((v1, v2) -> {
            return _init_$lambda$21(r1, v1, v2);
        });
    }

    @NotNull
    public final List<Function3<UIComponent, Integer, String, Unit>> getSelectionListener() {
        return this.selectionListener;
    }

    @NotNull
    public final State<Integer> getSelectedIndex() {
        return this.selectedIndex;
    }

    @NotNull
    public final State<String> getSelectedText() {
        return this.selectedText;
    }

    private static final String selectedText$lambda$0(Select this$0, int it) {
        return this$0.options.get(it);
    }

    @NotNull
    public final ReadOnlyState<Boolean> getExpandedState() {
        return this.expandedState;
    }

    @NotNull
    public final UIRoundedRectangle getExpandedBlock() {
        return (UIRoundedRectangle) this.expandedBlock.getValue(this, $$delegatedProperties[0]);
    }

    private final LabelComponent getCurrentSelectionText() {
        return (LabelComponent) this.currentSelectionText.getValue(this, $$delegatedProperties[1]);
    }

    private final ImageComponent getDownArrow() {
        return (ImageComponent) this.downArrow.getValue(this, $$delegatedProperties[2]);
    }

    private final UIContainer getScrollerContainer() {
        return (UIContainer) this.scrollerContainer.getValue(this, $$delegatedProperties[3]);
    }

    private final ScrollComponent getScroller() {
        return (ScrollComponent) this.scroller.getValue(this, $$delegatedProperties[4]);
    }

    private final UIContainer getExpandedContent() {
        return (UIContainer) this.expandedContent.getValue(this, $$delegatedProperties[5]);
    }

    private final UIComponent getScrollbarContainer() {
        return (UIComponent) this.scrollbarContainer.getValue(this, $$delegatedProperties[6]);
    }

    private static final Unit scrollbarContainer_delegate$lambda$8(UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getMouseButton() == 0) {
            it.stopPropagation();
        }
        return Unit.INSTANCE;
    }

    private final UIBlock getScrollbar() {
        return (UIBlock) this.scrollbar.getValue(this, $$delegatedProperties[7]);
    }

    private final float getMaxItemWidth() {
        Iterator<T> it = this.options.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        String it2 = (String) it.next();
        float fWidth$default = UtilitiesKt.width$default(it2, 0.0f, (FontProvider) null, 3, (Object) null);
        while (true) {
            float f = fWidth$default;
            if (!it.hasNext()) {
                return f;
            }
            String it3 = (String) it.next();
            fWidth$default = Math.max(f, UtilitiesKt.width$default(it3, 0.0f, (FontProvider) null, 3, (Object) null));
        }
    }

    private static final Color _init_$lambda$12(boolean it) {
        if (it) {
            return (Color) MSPalette.INSTANCE.getOrange().get();
        }
        return (Color) MSPalette.INSTANCE.getWhiteA4().get();
    }

    private static final Color _init_$lambda$13(boolean it) {
        if (it) {
            return (Color) MSPalette.INSTANCE.getOrange().get();
        }
        return (Color) MSPalette.INSTANCE.getWhiteA4().get();
    }

    private static final UIComponent lambda$20$lambda$16(ReadWriteProperty<Object, UIComponent> readWriteProperty) {
        return (UIComponent) readWriteProperty.getValue((Object) null, $$delegatedProperties[8]);
    }

    private static final Unit lambda$20$lambda$15(Select this$0, int $index, UIComponent $this$onMouseClick, UIClickEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getMouseButton() == 0) {
            it.stopPropagation();
            this$0.select($index);
        }
        return Unit.INSTANCE;
    }

    private static final LabelComponent lambda$20$lambda$18(ReadWriteProperty<Object, LabelComponent> readWriteProperty) {
        return (LabelComponent) readWriteProperty.getValue((Object) null, $$delegatedProperties[9]);
    }

    private static final Color lambda$20$lambda$19(boolean it) {
        if (it) {
            return (Color) MSPalette.INSTANCE.getOrange().get();
        }
        return (Color) MSPalette.INSTANCE.getWhiteA4().get();
    }

    private static final Unit _init_$lambda$21(Select this$0, UIComponent $this$onMouseClick, UIClickEvent event) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getMouseButton() == 0) {
            event.stopPropagation();
            if (((Boolean) this$0.writableExpandedState.get()).booleanValue()) {
                collapse$default(this$0, false, 1, null);
            } else {
                expand$default(this$0, false, 1, null);
            }
        }
        return Unit.INSTANCE;
    }

    public final void select(int index) {
        boolean z = 0 <= index && index < this.options.size();
        if (z) {
            this.selectedIndex.set(Integer.valueOf(index));
            Iterator<Function3<UIComponent, Integer, String, Unit>> it = this.selectionListener.iterator();
            while (it.hasNext()) {
                it.next().invoke(this, Integer.valueOf(index), this.options.get(index));
            }
            collapse$default(this, false, 1, null);
        }
    }

    public static /* synthetic */ void expand$default(Select select, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        select.expand(z);
    }

    public final void expand(boolean instantly) {
        this.writableExpandedState.set(true);
        applyExpandedBlockHeight(instantly, (HeightConstraint) ConstraintsKt.plus(ConstraintsKt.plus(ConstraintsKt.boundTo(new CopyConstraintFloat(false, 1, (DefaultConstructorMarker) null), (UIComponent) this), UtilitiesKt.getDp(Integer.valueOf(RangesKt.coerceAtMost(this.options.size(), this.maxDisplay) * 32))), UtilitiesKt.getDp((Number) 6)));
    }

    public static /* synthetic */ void collapse$default(Select select, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        select.collapse(z);
    }

    public final void collapse(boolean instantly) {
        this.writableExpandedState.set(false);
        applyExpandedBlockHeight(instantly, (HeightConstraint) new FillConstraint(false));
    }

    @NotNull
    public final Select onSelection(@NotNull Function3<? super UIComponent, ? super Integer, ? super String, Unit> method) {
        Intrinsics.checkNotNullParameter(method, "method");
        Select $this$onSelection_u24lambda_u2422 = this;
        $this$onSelection_u24lambda_u2422.selectionListener.add(method);
        return this;
    }

    private final void applyExpandedBlockHeight(boolean instantly, HeightConstraint heightConstraint) {
        if (instantly) {
            getExpandedBlock().setHeight(heightConstraint);
            return;
        }
        UIComponent $this$animate$iv = getExpandedBlock();
        AnimatingConstraints anim$iv = $this$animate$iv.makeAnimation();
        AnimatingConstraints.setHeightAnimation$default(anim$iv, Animations.OUT_EXP, 0.25f, heightConstraint, 0.0f, 8, (Object) null);
        $this$animate$iv.animateTo(anim$iv);
    }
}
