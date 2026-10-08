package net.mcskill.shop.client.screen.component.input;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.UIConstraints;
import gg.essential.elementa.components.UIBlock;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.constraints.CenterConstraint;
import gg.essential.elementa.constraints.HeightConstraint;
import gg.essential.elementa.constraints.animation.AnimatingConstraints;
import gg.essential.elementa.constraints.animation.Animations;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.effects.Effect;
import gg.essential.elementa.effects.ScissorEffect;
import gg.essential.elementa.events.UIClickEvent;
import gg.essential.elementa.events.UIScrollEvent;
import gg.essential.elementa.font.FontProvider;
import gg.essential.elementa.impl.Platform;
import gg.essential.elementa.utils.TextKt;
import gg.essential.universal.UDesktop;
import gg.essential.universal.UKeyboard;
import gg.essential.universal.UMatrixStack;
import java.awt.Color;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty0;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AbstractTextInput.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/input/AbstractTextInput.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b \n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\b&\u0018\u00002\u00020\u0001:\u0014µ\u0001¶\u0001·\u0001¸\u0001¹\u0001º\u0001»\u0001¼\u0001½\u0001¾\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010v\u001a\u00020-2\u0006\u0010w\u001a\u00020xH\u0016J\b\u0010y\u001a\u00020\u0003H&J\u000e\u0010z\u001a\u00020-2\u0006\u0010,\u001a\u00020\u0003J\u0014\u0010{\u001a\u00020-2\n\u0010|\u001a\u00060]R\u00020\u0000H$J\u001c\u0010}\u001a\u00060]R\u00020\u00002\u0006\u0010~\u001a\u00020\"2\u0006\u0010\u007f\u001a\u00020\"H$J\t\u0010\u0080\u0001\u001a\u00020-H$J\u0018\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030\u0082\u00012\u0006\u0010,\u001a\u00020\u0003H$J\t\u0010\u0083\u0001\u001a\u00020-H$J\u000f\u0010 \u001a\u00020\u00002\u0007\u0010\u0084\u0001\u001a\u00020\u0005J\u0007\u0010\u0084\u0001\u001a\u00020\u0005J+\u0010\u0085\u0001\u001a\u00020\u00002\"\u0010\u0086\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-0)J+\u0010\u0087\u0001\u001a\u00020\u00002\"\u0010\u0086\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-0)J\u0016\u0010\u0088\u0001\u001a\u00020-2\u000b\u0010\u0089\u0001\u001a\u00060dR\u00020\u0000H\u0014J\u0012\u0010\u008a\u0001\u001a\u00020-2\u0007\u0010\u008b\u0001\u001a\u00020\u0003H\u0014J\u001f\u0010\u008c\u0001\u001a\u00020-2\u0007\u0010\u008b\u0001\u001a\u00020\u00032\u000b\u0010\u008d\u0001\u001a\u00060]R\u00020\u0000H\u0004J\u0012\u0010\u008e\u0001\u001a\u00020-2\u0007\u0010\u008f\u0001\u001a\u00020VH\u0014J\t\u0010\u0090\u0001\u001a\u00020-H\u0014J!\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020\u00030\u0082\u00012\u0006\u0010,\u001a\u00020\u00032\u0007\u0010\u0092\u0001\u001a\u00020\"H\u0014J,\u0010\u0093\u0001\u001a\u00020-2\u000b\u0010\u0094\u0001\u001a\u00060]R\u00020\u00002\u000b\u0010\u0095\u0001\u001a\u00060]R\u00020\u00002\u0007\u0010\u0096\u0001\u001a\u00020\u0005H\u0004J#\u0010\u0097\u0001\u001a\u00020-2\u000b\u0010\u0094\u0001\u001a\u00060]R\u00020\u00002\u000b\u0010\u0095\u0001\u001a\u00060]R\u00020\u0000H\u0002J\u0016\u0010\u0098\u0001\u001a\u00020-2\u000b\u0010\u0099\u0001\u001a\u00060]R\u00020\u0000H\u0002J#\u0010\u009a\u0001\u001a\u00020\u00032\u000b\u0010\u0094\u0001\u001a\u00060]R\u00020\u00002\u000b\u0010\u0095\u0001\u001a\u00060]R\u00020\u0000H\u0014J\t\u0010\u009b\u0001\u001a\u00020-H\u0014J\t\u0010\u009c\u0001\u001a\u00020\u0005H\u0014J\r\u0010\u009d\u0001\u001a\u00060]R\u00020\u0000H\u0014J\r\u0010\u009e\u0001\u001a\u00060]R\u00020\u0000H\u0014J\u001d\u0010\u009f\u0001\u001a\u0016\u0012\b\u0012\u00060]R\u00020\u0000\u0012\b\u0012\u00060]R\u00020\u00000\\H\u0014J\t\u0010 \u0001\u001a\u00020-H\u0014J\t\u0010¡\u0001\u001a\u00020-H\u0014J\u001e\u0010¢\u0001\u001a\u0005\u0018\u00010£\u00012\n\u0010|\u001a\u00060]R\u00020\u0000H\u0014¢\u0006\u0003\u0010¤\u0001J\u001e\u0010¥\u0001\u001a\u0005\u0018\u00010£\u00012\n\u0010|\u001a\u00060]R\u00020\u0000H\u0014¢\u0006\u0003\u0010¤\u0001J\u0013\u0010¦\u0001\u001a\u00020\u00052\b\u0010§\u0001\u001a\u00030£\u0001H\u0014J#\u0010¨\u0001\u001a\u00060]R\u00020\u00002\n\u0010|\u001a\u00060]R\u00020\u00002\b\u0010©\u0001\u001a\u00030ª\u0001H\u0014J\t\u0010«\u0001\u001a\u00020-H\u0014J\t\u0010¬\u0001\u001a\u00020\u0005H\u0014J#\u0010\u00ad\u0001\u001a\u00020-2\u0006\u0010,\u001a\u00020\u00032\u0007\u0010®\u0001\u001a\u00020\"2\u0007\u0010¯\u0001\u001a\u00020VH\u0015J+\u0010°\u0001\u001a\u00020-2\u0006\u0010w\u001a\u00020x2\u0006\u0010,\u001a\u00020\u00032\u0007\u0010®\u0001\u001a\u00020\"2\u0007\u0010¯\u0001\u001a\u00020VH\u0004J+\u0010\u00ad\u0001\u001a\u00020-2\u0006\u0010w\u001a\u00020x2\u0006\u0010,\u001a\u00020\u00032\u0007\u0010®\u0001\u001a\u00020\"2\u0007\u0010¯\u0001\u001a\u00020VH\u0014J,\u0010±\u0001\u001a\u00020-2\u0006\u0010,\u001a\u00020\u00032\u0007\u0010®\u0001\u001a\u00020\"2\u0007\u0010²\u0001\u001a\u00020\"2\u0007\u0010¯\u0001\u001a\u00020VH\u0015J4\u0010³\u0001\u001a\u00020-2\u0006\u0010w\u001a\u00020x2\u0006\u0010,\u001a\u00020\u00032\u0007\u0010®\u0001\u001a\u00020\"2\u0007\u0010²\u0001\u001a\u00020\"2\u0007\u0010¯\u0001\u001a\u00020VH\u0004J4\u0010±\u0001\u001a\u00020-2\u0006\u0010w\u001a\u00020x2\u0006\u0010,\u001a\u00020\u00032\u0007\u0010®\u0001\u001a\u00020\"2\u0007\u0010²\u0001\u001a\u00020\"2\u0007\u0010¯\u0001\u001a\u00020VH\u0014J\t\u0010´\u0001\u001a\u00020-H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\b\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0014\u0010\t\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0014\u0010\n\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0014\u0010\u000b\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0014\u0010\f\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u001a\u0010\u001e\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R$\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R5\u0010(\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-0)X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R5\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0004\u0012\u00020-0)X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001e\u00105\u001a\f\u0012\b\u0012\u000607R\u00020\u000006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001e\u0010:\u001a\f\u0012\b\u0012\u00060;R\u00020\u000006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u00109R\u001a\u0010=\u001a\u00020\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010%\"\u0004\b?\u0010'R\u001a\u0010@\u001a\u00020\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010%\"\u0004\bB\u0010'R\u001a\u0010C\u001a\u00020\"X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010%\"\u0004\bE\u0010'R\u001a\u0010F\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0014\"\u0004\bH\u0010\u0016R\u001a\u0010I\u001a\u00020JX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020PX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020VX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR.\u0010[\u001a\u0016\u0012\b\u0012\u00060]R\u00020\u0000\u0012\b\u0012\u00060]R\u00020\u00000\\X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001e\u0010b\u001a\f\u0012\b\u0012\u00060dR\u00020\u00000cX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u001e\u0010g\u001a\f\u0012\b\u0012\u00060dR\u00020\u00000cX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010fR\u001a\u0010i\u001a\u00020\u0001X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR,\u0010n\u001a\u00060]R\u00020\u00002\n\u0010!\u001a\u00060]R\u00020\u0000@DX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR,\u0010s\u001a\u00060]R\u00020\u00002\n\u0010!\u001a\u00060]R\u00020\u0000@DX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010p\"\u0004\bu\u0010r¨\u0006¿\u0001"}, d2 = {"Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;", "Lgg/essential/elementa/UIComponent;", "placeholder", "", "shadow", "", "selectionBackgroundColor", "Ljava/awt/Color;", "selectionForegroundColor", "allowInactiveSelection", "inactiveSelectionBackgroundColor", "inactiveSelectionForegroundColor", "cursorColor", "<init>", "(Ljava/lang/String;ZLjava/awt/Color;Ljava/awt/Color;ZLjava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;)V", "getPlaceholder", "()Ljava/lang/String;", "setPlaceholder", "(Ljava/lang/String;)V", "getShadow", "()Z", "setShadow", "(Z)V", "getSelectionBackgroundColor", "()Ljava/awt/Color;", "getSelectionForegroundColor", "getAllowInactiveSelection", "getInactiveSelectionBackgroundColor", "getInactiveSelectionForegroundColor", "getCursorColor", "active", "getActive", "setActive", "value", "", "lineHeight", "getLineHeight", "()F", "setLineHeight", "(F)V", "updateAction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", "", "getUpdateAction", "()Lkotlin/jvm/functions/Function1;", "setUpdateAction", "(Lkotlin/jvm/functions/Function1;)V", "activateAction", "getActivateAction", "setActivateAction", "textualLines", "", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$TextualLine;", "getTextualLines", "()Ljava/util/List;", "visualLines", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$VisualLine;", "getVisualLines", "verticalScrollingOffset", "getVerticalScrollingOffset", "setVerticalScrollingOffset", "targetVerticalScrollingOffset", "getTargetVerticalScrollingOffset", "setTargetVerticalScrollingOffset", "horizontalScrollingOffset", "getHorizontalScrollingOffset", "setHorizontalScrollingOffset", "cursorNeedsRefocus", "getCursorNeedsRefocus", "setCursorNeedsRefocus", "lastSelectionMoveTimestamp", "", "getLastSelectionMoveTimestamp", "()J", "setLastSelectionMoveTimestamp", "(J)V", "selectionMode", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$SelectionMode;", "getSelectionMode", "()Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$SelectionMode;", "setSelectionMode", "(Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$SelectionMode;)V", "initiallySelectedLine", "", "getInitiallySelectedLine", "()I", "setInitiallySelectedLine", "(I)V", "initiallySelectedWord", "Lkotlin/Pair;", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$LinePosition;", "getInitiallySelectedWord", "()Lkotlin/Pair;", "setInitiallySelectedWord", "(Lkotlin/Pair;)V", "undoStack", "Ljava/util/ArrayDeque;", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$TextOperation;", "getUndoStack", "()Ljava/util/ArrayDeque;", "redoStack", "getRedoStack", "cursorComponent", "getCursorComponent", "()Lgg/essential/elementa/UIComponent;", "setCursorComponent", "(Lgg/essential/elementa/UIComponent;)V", "cursor", "getCursor", "()Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$LinePosition;", "setCursor", "(Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$LinePosition;)V", "otherSelectionEnd", "getOtherSelectionEnd", "setOtherSelectionEnd", "draw", "matrixStack", "Lgg/essential/universal/UMatrixStack;", "getText", "setText", "scrollIntoView", "pos", "screenPosToVisualPos", "x", "y", "recalculateDimensions", "textToLines", "", "onEnterPressed", "isActive", "onUpdate", "listener", "onActivate", "commitTextOperation", "operation", "commitTextAddition", "newText", "addText", "position", "recalculateVisualLinesFor", "textualLineIndex", "recalculateAllVisualLines", "splitTextForWrapping", "maxLineWidth", "commitTextRemoval", "startPos", "endPos", "selectAfterUndo", "removeText", "setCursorPosition", "newPosition", "getTextBetween", "selectAll", "hasSelection", "selectionStart", "selectionEnd", "getSelection", "deleteSelection", "copySelection", "charBefore", "", "(Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$LinePosition;)Ljava/lang/Character;", "charAfter", "isBreakingCharacter", "ch", "getNearestWordBoundary", "direction", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$Direction;", "animateCursor", "hasText", "drawUnselectedText", "left", "row", "drawUnselectedTextCompat", "drawSelectedText", "right", "drawSelectedTextCompat", "animationFrame", "SelectionMode", "Direction", "LinePosition", "Line", "TextualLine", "VisualLine", "TextOperation", "AddTextOperation", "RemoveTextOperation", "ReplaceTextOperation", "MSShop"})
@SourceDebugExtension({"SMAP\nAbstractTextInput.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractTextInput.kt\nnet/mcskill/shop/client/screen/component/input/AbstractTextInput\n+ 2 components.kt\ngg/essential/elementa/dsl/ComponentsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 animations.kt\ngg/essential/elementa/dsl/AnimationsKt\n*L\n1#1,987:1\n10#2,3:988\n1557#3:991\n1628#3,3:992\n1557#3:995\n1628#3,3:996\n1557#3:999\n1628#3,3:1000\n1#4:1003\n10#5,5:1004\n10#5,5:1009\n10#5,5:1014\n*S KotlinDebug\n*F\n+ 1 AbstractTextInput.kt\nnet/mcskill/shop/client/screen/component/input/AbstractTextInput\n*L\n55#1:988,3\n445#1:991\n445#1:992,3\n474#1:995\n474#1:996,3\n484#1:999\n484#1:1000,3\n680#1:1004,5\n348#1:1009,5\n684#1:1014,5\n*E\n"})
public abstract class AbstractTextInput extends UIComponent {

    @NotNull
    private String placeholder;
    private boolean shadow;

    @NotNull
    private final Color selectionBackgroundColor;

    @NotNull
    private final Color selectionForegroundColor;
    private final boolean allowInactiveSelection;

    @NotNull
    private final Color inactiveSelectionBackgroundColor;

    @NotNull
    private final Color inactiveSelectionForegroundColor;

    @NotNull
    private final Color cursorColor;
    private boolean active;
    private float lineHeight;

    @NotNull
    private Function1<? super String, Unit> updateAction;

    @NotNull
    private Function1<? super String, Unit> activateAction;

    @NotNull
    private final List<TextualLine> textualLines;

    @NotNull
    private final List<VisualLine> visualLines;
    private float verticalScrollingOffset;
    private float targetVerticalScrollingOffset;
    private float horizontalScrollingOffset;
    private boolean cursorNeedsRefocus;
    private long lastSelectionMoveTimestamp;

    @NotNull
    private SelectionMode selectionMode;
    private int initiallySelectedLine;

    @NotNull
    private Pair<LinePosition, LinePosition> initiallySelectedWord;

    @NotNull
    private final ArrayDeque<TextOperation> undoStack;

    @NotNull
    private final ArrayDeque<TextOperation> redoStack;

    @NotNull
    private UIComponent cursorComponent;

    @NotNull
    private LinePosition cursor;

    @NotNull
    private LinePosition otherSelectionEnd;

    /* JADX INFO: compiled from: AbstractTextInput.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/input/AbstractTextInput$WhenMappings.class */
    @Metadata(mv = {2, 0, 0}, k = 3, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SelectionMode.values().length];
            try {
                iArr[SelectionMode.Character.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SelectionMode.Line.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SelectionMode.Word.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[SelectionMode.None.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public abstract String getText();

    protected abstract void scrollIntoView(@NotNull LinePosition pos);

    @NotNull
    protected abstract LinePosition screenPosToVisualPos(float x, float y);

    protected abstract void recalculateDimensions();

    @NotNull
    protected abstract List<String> textToLines(@NotNull String text);

    protected abstract void onEnterPressed();

    @NotNull
    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final void setPlaceholder(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.placeholder = str;
    }

    public final boolean getShadow() {
        return this.shadow;
    }

    public final void setShadow(boolean z) {
        this.shadow = z;
    }

    @NotNull
    protected final Color getSelectionBackgroundColor() {
        return this.selectionBackgroundColor;
    }

    @NotNull
    protected final Color getSelectionForegroundColor() {
        return this.selectionForegroundColor;
    }

    protected final boolean getAllowInactiveSelection() {
        return this.allowInactiveSelection;
    }

    @NotNull
    protected final Color getInactiveSelectionBackgroundColor() {
        return this.inactiveSelectionBackgroundColor;
    }

    @NotNull
    protected final Color getInactiveSelectionForegroundColor() {
        return this.inactiveSelectionForegroundColor;
    }

    @NotNull
    protected final Color getCursorColor() {
        return this.cursorColor;
    }

    public AbstractTextInput(@NotNull String placeholder, boolean shadow, @NotNull Color selectionBackgroundColor, @NotNull Color selectionForegroundColor, boolean allowInactiveSelection, @NotNull Color inactiveSelectionBackgroundColor, @NotNull Color inactiveSelectionForegroundColor, @NotNull Color cursorColor) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(selectionBackgroundColor, "selectionBackgroundColor");
        Intrinsics.checkNotNullParameter(selectionForegroundColor, "selectionForegroundColor");
        Intrinsics.checkNotNullParameter(inactiveSelectionBackgroundColor, "inactiveSelectionBackgroundColor");
        Intrinsics.checkNotNullParameter(inactiveSelectionForegroundColor, "inactiveSelectionForegroundColor");
        Intrinsics.checkNotNullParameter(cursorColor, "cursorColor");
        this.placeholder = placeholder;
        this.shadow = shadow;
        this.selectionBackgroundColor = selectionBackgroundColor;
        this.selectionForegroundColor = selectionForegroundColor;
        this.allowInactiveSelection = allowInactiveSelection;
        this.inactiveSelectionBackgroundColor = inactiveSelectionBackgroundColor;
        this.inactiveSelectionForegroundColor = inactiveSelectionForegroundColor;
        this.cursorColor = cursorColor;
        this.lineHeight = 9.0f;
        this.updateAction = AbstractTextInput::updateAction$lambda$0;
        this.activateAction = AbstractTextInput::activateAction$lambda$1;
        this.textualLines = CollectionsKt.mutableListOf(new TextualLine[]{new TextualLine(this, "", new IntRange(0, 0))});
        this.visualLines = CollectionsKt.mutableListOf(new VisualLine[]{new VisualLine(this, "", 0)});
        this.lastSelectionMoveTimestamp = System.currentTimeMillis();
        this.selectionMode = SelectionMode.None;
        this.initiallySelectedLine = -1;
        this.initiallySelectedWord = TuplesKt.to(new LinePosition(0, 0, true), new LinePosition(0, 0, true));
        this.undoStack = new ArrayDeque<>();
        this.redoStack = new ArrayDeque<>();
        UIComponent $this$constrain$iv = new UIRoundedRectangle(4.0f, false, 2, (DefaultConstructorMarker) null);
        UIConstraints $this$cursorComponent_u24lambda_u242 = $this$constrain$iv.getConstraints();
        $this$cursorComponent_u24lambda_u242.setY(ConstraintsKt.minus(new CenterConstraint(), UtilitiesKt.getDp(Float.valueOf(0.5f))));
        $this$cursorComponent_u24lambda_u242.setWidth(UtilitiesKt.getDp((Number) 2));
        $this$cursorComponent_u24lambda_u242.setHeight(UtilitiesKt.getDp(Float.valueOf(this.lineHeight)));
        $this$cursorComponent_u24lambda_u242.setColor(UtilitiesKt.toConstraint(new Color(255, 255, 255, 0)));
        this.cursorComponent = ComponentsKt.childOf($this$constrain$iv, this);
        this.cursor = new LinePosition(0, 0, true);
        this.otherSelectionEnd = new LinePosition(0, 0, true);
        setHeight((HeightConstraint) UtilitiesKt.pixels$default(Float.valueOf(this.lineHeight), false, false, 3, (Object) null));
        onKeyType((v1, v2, v3) -> {
            return _init_$lambda$4(r1, v1, v2, v3);
        });
        onMouseScroll((v1, v2) -> {
            return _init_$lambda$5(r1, v1, v2);
        });
        onMouseClick((v1, v2) -> {
            return _init_$lambda$6(r1, v1, v2);
        });
        onMouseDrag((v1, v2, v3, v4) -> {
            return _init_$lambda$7(r1, v1, v2, v3, v4);
        });
        onMouseRelease((v1) -> {
            return _init_$lambda$8(r1, v1);
        });
        onFocus((v1) -> {
            return _init_$lambda$9(r1, v1);
        });
        onFocusLost((v1) -> {
            return _init_$lambda$10(r1, v1);
        });
        this.cursorComponent.animateAfterUnhide((v1) -> {
            return _init_$lambda$14(r1, v1);
        });
        enableEffect((Effect) new ScissorEffect((UIComponent) null, false, 3, (DefaultConstructorMarker) null));
    }

    protected final boolean getActive() {
        return this.active;
    }

    protected final void setActive(boolean z) {
        this.active = z;
    }

    public final float getLineHeight() {
        return this.lineHeight;
    }

    public final void setLineHeight(float value) {
        this.cursorComponent.setHeight(UtilitiesKt.pixels$default(Float.valueOf(value), false, false, 3, (Object) null));
        setHeight((HeightConstraint) UtilitiesKt.pixels$default(Float.valueOf(value), false, false, 3, (Object) null));
        this.lineHeight = value;
    }

    @NotNull
    protected final Function1<String, Unit> getUpdateAction() {
        return this.updateAction;
    }

    protected final void setUpdateAction(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.updateAction = function1;
    }

    private static final Unit updateAction$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    @NotNull
    protected final Function1<String, Unit> getActivateAction() {
        return this.activateAction;
    }

    protected final void setActivateAction(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.activateAction = function1;
    }

    private static final Unit activateAction$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    @NotNull
    protected final List<TextualLine> getTextualLines() {
        return this.textualLines;
    }

    @NotNull
    protected final List<VisualLine> getVisualLines() {
        return this.visualLines;
    }

    protected final float getVerticalScrollingOffset() {
        return this.verticalScrollingOffset;
    }

    protected final void setVerticalScrollingOffset(float f) {
        this.verticalScrollingOffset = f;
    }

    protected final float getTargetVerticalScrollingOffset() {
        return this.targetVerticalScrollingOffset;
    }

    protected final void setTargetVerticalScrollingOffset(float f) {
        this.targetVerticalScrollingOffset = f;
    }

    protected final float getHorizontalScrollingOffset() {
        return this.horizontalScrollingOffset;
    }

    protected final void setHorizontalScrollingOffset(float f) {
        this.horizontalScrollingOffset = f;
    }

    protected final boolean getCursorNeedsRefocus() {
        return this.cursorNeedsRefocus;
    }

    protected final void setCursorNeedsRefocus(boolean z) {
        this.cursorNeedsRefocus = z;
    }

    protected final long getLastSelectionMoveTimestamp() {
        return this.lastSelectionMoveTimestamp;
    }

    protected final void setLastSelectionMoveTimestamp(long j) {
        this.lastSelectionMoveTimestamp = j;
    }

    @NotNull
    protected final SelectionMode getSelectionMode() {
        return this.selectionMode;
    }

    protected final void setSelectionMode(@NotNull SelectionMode selectionMode) {
        Intrinsics.checkNotNullParameter(selectionMode, "<set-?>");
        this.selectionMode = selectionMode;
    }

    protected final int getInitiallySelectedLine() {
        return this.initiallySelectedLine;
    }

    protected final void setInitiallySelectedLine(int i) {
        this.initiallySelectedLine = i;
    }

    @NotNull
    protected final Pair<LinePosition, LinePosition> getInitiallySelectedWord() {
        return this.initiallySelectedWord;
    }

    protected final void setInitiallySelectedWord(@NotNull Pair<LinePosition, LinePosition> pair) {
        Intrinsics.checkNotNullParameter(pair, "<set-?>");
        this.initiallySelectedWord = pair;
    }

    @NotNull
    protected final ArrayDeque<TextOperation> getUndoStack() {
        return this.undoStack;
    }

    @NotNull
    protected final ArrayDeque<TextOperation> getRedoStack() {
        return this.redoStack;
    }

    @NotNull
    protected final UIComponent getCursorComponent() {
        return this.cursorComponent;
    }

    protected final void setCursorComponent(@NotNull UIComponent uIComponent) {
        Intrinsics.checkNotNullParameter(uIComponent, "<set-?>");
        this.cursorComponent = uIComponent;
    }

    @NotNull
    protected final LinePosition getCursor() {
        return this.cursor;
    }

    protected final void setCursor(@NotNull LinePosition value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.cursor = value.toVisualPos();
    }

    @NotNull
    protected final LinePosition getOtherSelectionEnd() {
        return this.otherSelectionEnd;
    }

    protected final void setOtherSelectionEnd(@NotNull LinePosition value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.otherSelectionEnd = value.toVisualPos();
    }

    /* JADX INFO: compiled from: AbstractTextInput.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/input/AbstractTextInput$SelectionMode.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$SelectionMode;", "", "<init>", "(Ljava/lang/String;I)V", "None", "Character", "Word", "Line", "MSShop"})
    public enum SelectionMode {
        None,
        Character,
        Word,
        Line;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        @NotNull
        public static EnumEntries<SelectionMode> getEntries() {
            return $ENTRIES;
        }
    }

    private static final Unit _init_$lambda$4(AbstractTextInput this$0, UIComponent $this$onKeyType, char typedChar, int keyCode) {
        LinePosition textualPos;
        LinePosition textualPos2;
        LinePosition linePositionScreenPosToVisualPos;
        LinePosition linePositionScreenPosToVisualPos2;
        LinePosition linePositionOffsetColumn;
        LinePosition linePositionOffsetColumn2;
        Intrinsics.checkNotNullParameter($this$onKeyType, "$this$onKeyType");
        if (!this$0.active) {
            return Unit.INSTANCE;
        }
        if (keyCode == UKeyboard.KEY_ESCAPE) {
            $this$onKeyType.releaseWindowFocus();
        } else if (UKeyboard.isKeyComboCtrlA(keyCode)) {
            this$0.selectAll();
        } else if (UKeyboard.isKeyComboCtrlC(keyCode) && this$0.hasSelection()) {
            this$0.copySelection();
        } else if (UKeyboard.isKeyComboCtrlX(keyCode) && this$0.hasSelection()) {
            this$0.copySelection();
            this$0.deleteSelection();
        } else if (UKeyboard.isKeyComboCtrlV(keyCode)) {
            this$0.commitTextAddition(UDesktop.getClipboardString());
        } else if (UKeyboard.isKeyComboCtrlZ(keyCode)) {
            if (this$0.undoStack.isEmpty()) {
                return Unit.INSTANCE;
            }
            TextOperation operationToUndo = this$0.undoStack.pop();
            operationToUndo.undo();
            this$0.redoStack.push(operationToUndo);
        } else if (UKeyboard.isKeyComboCtrlShiftZ(keyCode) || UKeyboard.isKeyComboCtrlY(keyCode)) {
            if (this$0.redoStack.isEmpty()) {
                return Unit.INSTANCE;
            }
            TextOperation operationToRedo = this$0.redoStack.pop();
            operationToRedo.redo();
            this$0.undoStack.push(operationToRedo);
        } else if (Platform.Companion.getPlatform().isAllowedInChat(typedChar)) {
            this$0.commitTextAddition(String.valueOf(typedChar));
        } else if (keyCode == UKeyboard.KEY_LEFT) {
            boolean holdingShift = UKeyboard.isShiftKeyDown();
            boolean holdingCtrl = UKeyboard.isCtrlKeyDown();
            if (holdingCtrl) {
                linePositionOffsetColumn2 = this$0.getNearestWordBoundary(this$0.cursor, Direction.Left);
            } else {
                linePositionOffsetColumn2 = (!this$0.hasSelection() || holdingShift) ? this$0.cursor.offsetColumn(-1) : this$0.selectionStart();
            }
            LinePosition newCursorPosition = linePositionOffsetColumn2;
            if (!holdingShift) {
                this$0.setCursorPosition(newCursorPosition);
                return Unit.INSTANCE;
            }
            this$0.setCursor(newCursorPosition);
            this$0.cursorNeedsRefocus = true;
        } else if (keyCode == UKeyboard.KEY_RIGHT) {
            boolean holdingShift2 = UKeyboard.isShiftKeyDown();
            boolean holdingCtrl2 = UKeyboard.isCtrlKeyDown();
            if (holdingCtrl2) {
                linePositionOffsetColumn = this$0.getNearestWordBoundary(this$0.cursor, Direction.Right);
            } else {
                linePositionOffsetColumn = (!this$0.hasSelection() || holdingShift2) ? this$0.cursor.offsetColumn(1) : this$0.selectionEnd();
            }
            LinePosition newCursorPosition2 = linePositionOffsetColumn;
            if (!holdingShift2) {
                this$0.setCursorPosition(newCursorPosition2);
                return Unit.INSTANCE;
            }
            this$0.setCursor(newCursorPosition2);
            this$0.cursorNeedsRefocus = true;
        } else if (keyCode == UKeyboard.KEY_UP) {
            if (this$0.cursor.getLine() == 0) {
                linePositionScreenPosToVisualPos2 = this$0.new LinePosition(0, 0, true);
            } else {
                Pair<Float, Float> screenPos = this$0.cursor.toScreenPos();
                float currX = ((Number) screenPos.component1()).floatValue();
                float currY = ((Number) screenPos.component2()).floatValue();
                linePositionScreenPosToVisualPos2 = this$0.screenPosToVisualPos(currX, currY - this$0.lineHeight);
            }
            LinePosition newVisualPos = linePositionScreenPosToVisualPos2;
            if (UKeyboard.isShiftKeyDown()) {
                this$0.setCursor(newVisualPos);
                this$0.cursorNeedsRefocus = true;
            } else {
                this$0.setCursorPosition(newVisualPos);
            }
        } else if (keyCode == UKeyboard.KEY_DOWN) {
            if (this$0.cursor.getLine() == CollectionsKt.getLastIndex(this$0.visualLines)) {
                linePositionScreenPosToVisualPos = this$0.new LinePosition(CollectionsKt.getLastIndex(this$0.visualLines), ((VisualLine) CollectionsKt.last(this$0.visualLines)).getLength(), true);
            } else {
                Pair<Float, Float> screenPos2 = this$0.cursor.toScreenPos();
                float currX2 = ((Number) screenPos2.component1()).floatValue();
                float currY2 = ((Number) screenPos2.component2()).floatValue();
                linePositionScreenPosToVisualPos = this$0.screenPosToVisualPos(currX2, currY2 + this$0.lineHeight);
            }
            LinePosition newVisualPos2 = linePositionScreenPosToVisualPos;
            if (UKeyboard.isShiftKeyDown()) {
                this$0.setCursor(newVisualPos2);
                this$0.cursorNeedsRefocus = true;
            } else {
                this$0.setCursorPosition(newVisualPos2);
            }
        } else if (keyCode == UKeyboard.KEY_BACKSPACE) {
            if (this$0.hasSelection()) {
                this$0.deleteSelection();
            } else if (!this$0.cursor.isAtAbsoluteStart()) {
                if (UKeyboard.isCtrlKeyDown()) {
                    textualPos2 = this$0.getNearestWordBoundary(this$0.cursor, Direction.Left);
                } else {
                    textualPos2 = this$0.cursor.offsetColumn(-1).toTextualPos();
                }
                LinePosition startPos = textualPos2;
                LinePosition endPos = this$0.cursor.toTextualPos();
                this$0.commitTextRemoval(startPos, endPos, false);
            }
        } else if (keyCode == UKeyboard.KEY_DELETE) {
            if (this$0.hasSelection()) {
                this$0.deleteSelection();
            } else if (!this$0.cursor.isAtAbsoluteEnd()) {
                LinePosition startPos2 = this$0.cursor.toTextualPos();
                if (UKeyboard.isCtrlKeyDown()) {
                    textualPos = this$0.getNearestWordBoundary(this$0.cursor, Direction.Right);
                } else {
                    textualPos = this$0.cursor.offsetColumn(1).toTextualPos();
                }
                LinePosition endPos2 = textualPos;
                this$0.commitTextRemoval(startPos2, endPos2, false);
            }
        } else if (keyCode == UKeyboard.KEY_HOME) {
            if (UKeyboard.isShiftKeyDown()) {
                this$0.setCursor(this$0.cursor.withColumn(0));
                this$0.cursorNeedsRefocus = true;
            } else {
                this$0.setCursorPosition(this$0.cursor.withColumn(0));
            }
        } else if (keyCode == UKeyboard.KEY_END) {
            LinePosition it = this$0.cursor.withColumn(this$0.visualLines.get(this$0.cursor.getLine()).getLength());
            if (UKeyboard.isShiftKeyDown()) {
                this$0.setCursor(it);
                this$0.cursorNeedsRefocus = true;
            } else {
                this$0.setCursorPosition(it);
            }
        } else if (keyCode == UKeyboard.KEY_ENTER) {
            this$0.onEnterPressed();
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$5(AbstractTextInput this$0, UIComponent $this$onMouseScroll, UIScrollEvent it) {
        Intrinsics.checkNotNullParameter($this$onMouseScroll, "$this$onMouseScroll");
        Intrinsics.checkNotNullParameter(it, "it");
        float heightDifference = $this$onMouseScroll.getHeight() - (this$0.visualLines.size() * this$0.lineHeight);
        if (heightDifference > 0.0f) {
            return Unit.INSTANCE;
        }
        this$0.targetVerticalScrollingOffset = RangesKt.coerceIn(this$0.targetVerticalScrollingOffset + (((float) it.getDelta()) * this$0.lineHeight), heightDifference, 0.0f);
        it.stopPropagation();
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$6(AbstractTextInput this$0, UIComponent $this$onMouseClick, UIClickEvent event) {
        Intrinsics.checkNotNullParameter($this$onMouseClick, "$this$onMouseClick");
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this$0.active || event.getMouseButton() != 0) {
            return Unit.INSTANCE;
        }
        LinePosition clickedVisualPos = this$0.screenPosToVisualPos(event.getRelativeX(), event.getRelativeY());
        int clickCount = event.getClickCount() % 3;
        if (clickCount == 0 && clickedVisualPos.getLine() != this$0.cursor.getLine()) {
            clickCount = 1;
        } else if (clickCount == 2 && !Intrinsics.areEqual(this$0.cursor, clickedVisualPos)) {
            clickCount = 1;
        }
        switch (clickCount) {
            case 0:
                this$0.selectionMode = SelectionMode.Line;
                this$0.setOtherSelectionEnd(clickedVisualPos.withColumn(this$0.visualLines.get(this$0.cursor.getLine()).getLength()));
                this$0.initiallySelectedLine = this$0.cursor.getLine();
                break;
            case 1:
                this$0.selectionMode = SelectionMode.Character;
                this$0.setCursorPosition(clickedVisualPos);
                break;
            case 2:
                this$0.selectionMode = SelectionMode.Word;
                this$0.setCursor(this$0.getNearestWordBoundary(clickedVisualPos, Direction.Left));
                this$0.cursorNeedsRefocus = true;
                this$0.setOtherSelectionEnd(this$0.getNearestWordBoundary(clickedVisualPos, Direction.Right));
                this$0.initiallySelectedWord = TuplesKt.to(this$0.cursor, this$0.otherSelectionEnd);
                break;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private static final Unit _init_$lambda$7(AbstractTextInput this$0, UIComponent $this$onMouseDrag, float mouseX, float mouseY, int mouseButton) throws NoWhenBranchMatchedException {
        Intrinsics.checkNotNullParameter($this$onMouseDrag, "$this$onMouseDrag");
        if (mouseButton != 0 || this$0.selectionMode == SelectionMode.None) {
            return Unit.INSTANCE;
        }
        LinePosition draggedVisualPos = this$0.screenPosToVisualPos(mouseX, mouseY);
        switch (WhenMappings.$EnumSwitchMapping$0[this$0.selectionMode.ordinal()]) {
            case 1:
                this$0.setOtherSelectionEnd(draggedVisualPos);
                break;
            case 2:
                if (this$0.initiallySelectedLine < draggedVisualPos.getLine()) {
                    this$0.setCursor(this$0.new LinePosition(this$0.initiallySelectedLine, 0, true));
                    this$0.setOtherSelectionEnd(draggedVisualPos.withColumn(this$0.visualLines.get(draggedVisualPos.getLine()).getLength()));
                } else {
                    this$0.setCursor(draggedVisualPos.withColumn(0));
                    this$0.setOtherSelectionEnd(this$0.new LinePosition(this$0.initiallySelectedLine, this$0.visualLines.get(this$0.initiallySelectedLine).getLength(), true));
                }
                break;
            case 3:
                if (draggedVisualPos.compareTo((LinePosition) this$0.initiallySelectedWord.getFirst()) < 0) {
                    this$0.setCursor(this$0.getNearestWordBoundary(draggedVisualPos, Direction.Left));
                    this$0.setOtherSelectionEnd((LinePosition) this$0.initiallySelectedWord.getSecond());
                } else if (draggedVisualPos.compareTo((LinePosition) this$0.initiallySelectedWord.getSecond()) > 0) {
                    this$0.setCursor((LinePosition) this$0.initiallySelectedWord.getFirst());
                    this$0.setOtherSelectionEnd(this$0.getNearestWordBoundary(draggedVisualPos, Direction.Right));
                } else {
                    this$0.setCursor((LinePosition) this$0.initiallySelectedWord.getFirst());
                    this$0.setOtherSelectionEnd((LinePosition) this$0.initiallySelectedWord.getSecond());
                }
                break;
            case 4:
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        long currentTime = System.currentTimeMillis();
        if (currentTime - this$0.lastSelectionMoveTimestamp > 50) {
            if (mouseY <= 0.0f) {
                this$0.targetVerticalScrollingOffset = RangesKt.coerceAtMost(this$0.targetVerticalScrollingOffset + (this$0.lineHeight * $this$onMouseDrag.getTextScale()), 0.0f);
                this$0.lastSelectionMoveTimestamp = currentTime;
            } else if (mouseY >= $this$onMouseDrag.getHeight()) {
                float heightDifference = $this$onMouseDrag.getHeight() - ((this$0.visualLines.size() * this$0.lineHeight) * $this$onMouseDrag.getTextScale());
                this$0.targetVerticalScrollingOffset = RangesKt.coerceIn(this$0.targetVerticalScrollingOffset - (this$0.lineHeight * $this$onMouseDrag.getTextScale()), 0.0f, heightDifference);
                this$0.lastSelectionMoveTimestamp = currentTime;
            } else if (mouseX <= 0.0f) {
                this$0.scrollIntoView(draggedVisualPos.offsetColumn(-1));
                this$0.lastSelectionMoveTimestamp = currentTime;
            } else if (mouseX >= $this$onMouseDrag.getWidth()) {
                this$0.scrollIntoView(draggedVisualPos.offsetColumn(1));
                this$0.lastSelectionMoveTimestamp = currentTime;
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$8(AbstractTextInput this$0, UIComponent $this$onMouseRelease) {
        Intrinsics.checkNotNullParameter($this$onMouseRelease, "$this$onMouseRelease");
        this$0.selectionMode = SelectionMode.None;
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$9(AbstractTextInput this$0, UIComponent $this$onFocus) {
        Intrinsics.checkNotNullParameter($this$onFocus, "$this$onFocus");
        this$0.m38setActive(true);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$10(AbstractTextInput this$0, UIComponent $this$onFocusLost) {
        Intrinsics.checkNotNullParameter($this$onFocusLost, "$this$onFocusLost");
        this$0.m38setActive(false);
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$14(AbstractTextInput this$0, AnimatingConstraints $this$animateAfterUnhide) {
        Intrinsics.checkNotNullParameter($this$animateAfterUnhide, "$this$animateAfterUnhide");
        AnimatingConstraints.setColorAnimation$default($this$animateAfterUnhide, Animations.OUT_CIRCULAR, 0.5f, UtilitiesKt.toConstraint(this$0.cursorColor), 0.0f, 8, (Object) null);
        $this$animateAfterUnhide.onComplete(() -> {
            return lambda$14$lambda$13(r1);
        });
        return Unit.INSTANCE;
    }

    private static final Unit lambda$14$lambda$13(AbstractTextInput this$0) {
        if (!this$0.active) {
            return Unit.INSTANCE;
        }
        UIComponent $this$animate$iv = this$0.cursorComponent;
        AnimatingConstraints anim$iv = $this$animate$iv.makeAnimation();
        AnimatingConstraints.setColorAnimation$default(anim$iv, Animations.IN_CIRCULAR, 0.5f, UtilitiesKt.toConstraint(new Color(255, 255, 255, 0)), 0.0f, 8, (Object) null);
        anim$iv.onComplete(() -> {
            return lambda$14$lambda$13$lambda$12$lambda$11(r1);
        });
        $this$animate$iv.animateTo(anim$iv);
        return Unit.INSTANCE;
    }

    private static final Unit lambda$14$lambda$13$lambda$12$lambda$11(AbstractTextInput this$0) {
        if (this$0.active) {
            this$0.animateCursor();
        }
        return Unit.INSTANCE;
    }

    public void draw(@NotNull UMatrixStack matrixStack) {
        Intrinsics.checkNotNullParameter(matrixStack, "matrixStack");
        this.cursorComponent.setHeight(UtilitiesKt.pixels$default(Float.valueOf(this.lineHeight * getTextScale()), false, false, 3, (Object) null));
        super.draw(matrixStack);
    }

    public final void setText(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        LinePosition absoluteStart = new LinePosition(0, 0, true);
        ReplaceTextOperation replaceTextOperation = new ReplaceTextOperation(this, new AddTextOperation(this, text, absoluteStart), new RemoveTextOperation(this, absoluteStart, new LinePosition(CollectionsKt.getLastIndex(this.visualLines), ((VisualLine) CollectionsKt.last(this.visualLines)).getLength(), true), true));
        commitTextOperation(replaceTextOperation);
    }

    @NotNull
    /* JADX INFO: renamed from: setActive, reason: collision with other method in class */
    public final AbstractTextInput m38setActive(boolean isActive) {
        AbstractTextInput $this$setActive_u24lambda_u2415 = this;
        $this$setActive_u24lambda_u2415.active = isActive;
        if (isActive) {
            UIComponent.unhide$default($this$setActive_u24lambda_u2415.cursorComponent, false, 1, (Object) null);
            $this$setActive_u24lambda_u2415.animateCursor();
        } else {
            $this$setActive_u24lambda_u2415.cursorComponent.setColor(UtilitiesKt.toConstraint(new Color(255, 255, 255, 0)));
            if ($this$setActive_u24lambda_u2415.hasText() && (!$this$setActive_u24lambda_u2415.allowInactiveSelection || !$this$setActive_u24lambda_u2415.hasSelection())) {
                $this$setActive_u24lambda_u2415.setCursorPosition($this$setActive_u24lambda_u2415.new LinePosition(CollectionsKt.getLastIndex($this$setActive_u24lambda_u2415.visualLines), ((VisualLine) CollectionsKt.last($this$setActive_u24lambda_u2415.visualLines)).getLength(), true));
            }
        }
        return this;
    }

    public final boolean isActive() {
        return this.active;
    }

    @NotNull
    public final AbstractTextInput onUpdate(@NotNull Function1<? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        AbstractTextInput $this$onUpdate_u24lambda_u2416 = this;
        $this$onUpdate_u24lambda_u2416.updateAction = listener;
        return this;
    }

    @NotNull
    public final AbstractTextInput onActivate(@NotNull Function1<? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        AbstractTextInput $this$onActivate_u24lambda_u2417 = this;
        $this$onActivate_u24lambda_u2417.activateAction = listener;
        return this;
    }

    protected void commitTextOperation(@NotNull TextOperation operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        operation.redo();
        this.undoStack.push(operation);
        this.redoStack.clear();
    }

    protected void commitTextAddition(@NotNull String newText) {
        Intrinsics.checkNotNullParameter(newText, "newText");
        AddTextOperation addTextOperation = new AddTextOperation(this, newText, this.cursor);
        if (hasSelection()) {
            RemoveTextOperation removeTextOperation = new RemoveTextOperation(this, selectionStart(), selectionEnd(), true);
            ReplaceTextOperation replaceTextOperation = new ReplaceTextOperation(this, addTextOperation, removeTextOperation);
            commitTextOperation(replaceTextOperation);
            return;
        }
        commitTextOperation(addTextOperation);
    }

    protected final void addText(@NotNull String newText, @NotNull LinePosition position) {
        Intrinsics.checkNotNullParameter(newText, "newText");
        Intrinsics.checkNotNullParameter(position, "position");
        LinePosition textPos = position.toTextualPos();
        TextualLine textualLine = this.textualLines.get(textPos.getLine());
        List<String> listTextToLines = textToLines(newText);
        if (listTextToLines.isEmpty()) {
            return;
        }
        if (listTextToLines.size() == 1) {
            textualLine.addTextAt((String) CollectionsKt.first(listTextToLines), textPos.getColumn());
        } else {
            Iterable $this$map$iv = CollectionsKt.drop(listTextToLines, 1);
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String p0 = (String) item$iv$iv;
                destination$iv$iv.add(new TextualLine(this, p0, null, 2, null));
            }
            List newTextualLines = (List) destination$iv$iv;
            if (textPos.getColumn() < textualLine.getText().length()) {
                String textAfterInsertion = textualLine.getText().substring(textPos.getColumn());
                Intrinsics.checkNotNullExpressionValue(textAfterInsertion, "substring(...)");
                String strSubstring = textualLine.getText().substring(0, textPos.getColumn());
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                textualLine.setText(strSubstring + CollectionsKt.first(listTextToLines));
                TextualLine textualLine2 = (TextualLine) CollectionsKt.last(newTextualLines);
                textualLine2.setText(textualLine2.getText() + textAfterInsertion);
            } else {
                textualLine.addTextAt((String) CollectionsKt.first(listTextToLines), textPos.getColumn());
            }
            this.textualLines.addAll(textPos.getLine() + 1, newTextualLines);
        }
        recalculateAllVisualLines();
        setCursorPosition(textPos.offsetColumn(newText.length()).toVisualPos());
        this.updateAction.invoke(getText());
    }

    protected void recalculateVisualLinesFor(int textualLineIndex) {
        TextualLine textualLine = this.textualLines.get(textualLineIndex);
        int firstVisualIndex = textualLine.getVisualIndices().getFirst();
        int iCount = CollectionsKt.count(textualLine.getVisualIndices());
        for (int i = 0; i < iCount; i++) {
            if (firstVisualIndex < this.visualLines.size()) {
                this.visualLines.remove(firstVisualIndex);
            }
        }
        List<String> listSplitTextForWrapping = splitTextForWrapping(textualLine.getText(), getWidth());
        List<VisualLine> list = this.visualLines;
        List<String> $this$map$iv = listSplitTextForWrapping;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(new VisualLine(this, it, textualLineIndex));
        }
        list.addAll(firstVisualIndex, (List) destination$iv$iv);
        textualLine.setVisualIndices(RangesKt.until(firstVisualIndex, firstVisualIndex + listSplitTextForWrapping.size()));
    }

    protected void recalculateAllVisualLines() {
        this.visualLines.clear();
        int i = 0;
        for (TextualLine textualLine : this.textualLines) {
            int index = i;
            i++;
            List<String> listSplitTextForWrapping = splitTextForWrapping(textualLine.getText(), getWidth());
            textualLine.setVisualIndices(new IntRange(this.visualLines.size(), this.visualLines.size() + listSplitTextForWrapping.size()));
            List<VisualLine> list = this.visualLines;
            List<String> $this$map$iv = listSplitTextForWrapping;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv.add(new VisualLine(this, it, index));
            }
            list.addAll((List) destination$iv$iv);
        }
    }

    @NotNull
    protected List<String> splitTextForWrapping(@NotNull String text, float maxLineWidth) {
        Intrinsics.checkNotNullParameter(text, "text");
        return TextKt.getStringSplitToWidth$default(text, maxLineWidth, getTextScale(), false, false, (FontProvider) null, 40, (Object) null);
    }

    protected final void commitTextRemoval(@NotNull LinePosition startPos, @NotNull LinePosition endPos, boolean selectAfterUndo) {
        Intrinsics.checkNotNullParameter(startPos, "startPos");
        Intrinsics.checkNotNullParameter(endPos, "endPos");
        RemoveTextOperation removeTextOperation = new RemoveTextOperation(this, startPos, endPos, selectAfterUndo);
        commitTextOperation(removeTextOperation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeText(LinePosition startPos, LinePosition endPos) {
        LinePosition textualStartPos = startPos.toTextualPos();
        LinePosition textualEndPos = endPos.toTextualPos();
        TextualLine startTextualLine = this.textualLines.get(textualStartPos.getLine());
        TextualLine endTextualLine = this.textualLines.get(textualEndPos.getLine());
        String strSubstring = startTextualLine.getText().substring(0, textualStartPos.getColumn());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = endTextualLine.getText().substring(textualEndPos.getColumn());
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        startTextualLine.setText(strSubstring + strSubstring2);
        int firstItemToDelete = textualStartPos.getLine() + 1;
        int line = (textualEndPos.getLine() - firstItemToDelete) + 1;
        for (int i = 0; i < line; i++) {
            this.textualLines.remove(firstItemToDelete);
        }
        recalculateAllVisualLines();
        float heightDifference = getHeight() - (this.visualLines.size() * this.lineHeight);
        if (this.verticalScrollingOffset < heightDifference) {
            this.targetVerticalScrollingOffset = RangesKt.coerceAtMost(heightDifference, 0.0f);
        }
        this.updateAction.invoke(getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCursorPosition(LinePosition newPosition) {
        LinePosition $this$setCursorPosition_u24lambda_u2423 = newPosition.toVisualPos();
        setCursor($this$setCursorPosition_u24lambda_u2423);
        setOtherSelectionEnd($this$setCursorPosition_u24lambda_u2423);
        this.cursorNeedsRefocus = true;
    }

    @NotNull
    protected String getTextBetween(@NotNull LinePosition startPos, @NotNull LinePosition endPos) {
        Intrinsics.checkNotNullParameter(startPos, "startPos");
        Intrinsics.checkNotNullParameter(endPos, "endPos");
        LinePosition textStart = startPos.toTextualPos();
        LinePosition textEnd = endPos.toTextualPos();
        if (textStart.getLine() == textEnd.getLine()) {
            String strSubstring = this.textualLines.get(textStart.getLine()).getText().substring(textStart.getColumn(), textEnd.getColumn());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            return strSubstring;
        }
        List lines = new ArrayList();
        String strSubstring2 = this.textualLines.get(textStart.getLine()).getText().substring(textStart.getColumn());
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        lines.add(strSubstring2);
        int line = textEnd.getLine();
        for (int i = textStart.getLine() + 1; i < line; i++) {
            lines.add(this.textualLines.get(i).getText());
        }
        String strSubstring3 = this.textualLines.get(textEnd.getLine()).getText().substring(0, textEnd.getColumn());
        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
        lines.add(strSubstring3);
        return CollectionsKt.joinToString$default(lines, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    protected void selectAll() {
        setCursor(new LinePosition(0, 0, true));
        setOtherSelectionEnd(new LinePosition(this.visualLines.size() - 1, ((VisualLine) CollectionsKt.last(this.visualLines)).getLength(), true));
    }

    protected boolean hasSelection() {
        return !Intrinsics.areEqual(this.cursor, this.otherSelectionEnd);
    }

    @NotNull
    protected LinePosition selectionStart() {
        return (LinePosition) ComparisonsKt.minOf(this.cursor, this.otherSelectionEnd);
    }

    @NotNull
    protected LinePosition selectionEnd() {
        return (LinePosition) ComparisonsKt.maxOf(this.cursor, this.otherSelectionEnd);
    }

    @NotNull
    protected Pair<LinePosition, LinePosition> getSelection() {
        return TuplesKt.to(selectionStart(), selectionEnd());
    }

    protected void deleteSelection() {
        if (!hasSelection()) {
            return;
        }
        commitTextRemoval(selectionStart(), selectionEnd(), true);
    }

    protected void copySelection() {
        Pair<LinePosition, LinePosition> selection = getSelection();
        LinePosition visualSelectionStart = (LinePosition) selection.component1();
        LinePosition visualSelectionEnd = (LinePosition) selection.component2();
        if (Intrinsics.areEqual(visualSelectionStart, visualSelectionEnd)) {
            return;
        }
        UDesktop.setClipboardString(getTextBetween(visualSelectionStart, visualSelectionEnd));
    }

    @Nullable
    protected Character charBefore(@NotNull LinePosition pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        LinePosition it = pos.toTextualPos();
        if (it.isAtAbsoluteStart()) {
            return null;
        }
        if (it.isAtLineStart()) {
            return '\n';
        }
        return Character.valueOf(this.textualLines.get(it.getLine()).getText().charAt(it.getColumn() - 1));
    }

    @Nullable
    protected Character charAfter(@NotNull LinePosition pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        LinePosition it = pos.toTextualPos();
        if (it.isAtAbsoluteEnd()) {
            return null;
        }
        if (it.isAtLineEnd()) {
            return '\n';
        }
        return Character.valueOf(this.textualLines.get(it.getLine()).getText().charAt(it.getColumn()));
    }

    /* JADX INFO: compiled from: AbstractTextInput.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/input/AbstractTextInput$Direction.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$Direction;", "", "<init>", "(Ljava/lang/String;I)V", "Left", "Right", "MSShop"})
    public enum Direction {
        Left,
        Right;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        @NotNull
        public static EnumEntries<Direction> getEntries() {
            return $ENTRIES;
        }
    }

    protected boolean isBreakingCharacter(char ch) {
        return (Character.isLetterOrDigit(ch) || ch == '_') ? false : true;
    }

    @NotNull
    protected LinePosition getNearestWordBoundary(@NotNull final LinePosition pos, @NotNull Direction direction) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(pos, "pos");
        Intrinsics.checkNotNullParameter(direction, "direction");
        KProperty0 atEndOfDirection = direction == Direction.Left ? (KProperty0) new PropertyReference0Impl(pos) { // from class: net.mcskill.shop.client.screen.component.input.AbstractTextInput$getNearestWordBoundary$atEndOfDirection$1
            public Object get() {
                return Boolean.valueOf(((AbstractTextInput.LinePosition) this.receiver).isAtAbsoluteStart());
            }
        } : new PropertyReference0Impl(pos) { // from class: net.mcskill.shop.client.screen.component.input.AbstractTextInput$getNearestWordBoundary$atEndOfDirection$2
            public Object get() {
                return Boolean.valueOf(((AbstractTextInput.LinePosition) this.receiver).isAtAbsoluteEnd());
            }
        };
        if (((Boolean) atEndOfDirection.invoke()).booleanValue()) {
            return pos;
        }
        LinePosition textualPos = pos.toTextualPos();
        int columnOffset = direction == Direction.Left ? -1 : 1;
        KFunction nextChar = direction == Direction.Left ? new AbstractTextInput$getNearestWordBoundary$nextChar$1(this) : new AbstractTextInput$getNearestWordBoundary$nextChar$2(this);
        if (direction == Direction.Left && textualPos.isAtLineStart()) {
            TextualLine previousLine = this.textualLines.get(textualPos.getLine() - 1);
            return new LinePosition(textualPos.getLine() - 1, previousLine.getLength(), false);
        }
        if (direction == Direction.Right && textualPos.isAtLineEnd()) {
            return new LinePosition(textualPos.getLine() + 1, 0, false);
        }
        Character ch = (Character) ((Function1) nextChar).invoke(textualPos);
        while (!((Boolean) atEndOfDirection.invoke()).booleanValue()) {
            Character ch2 = ch;
            if (ch2 != null) {
                char p0 = ch2.charValue();
                z2 = isBreakingCharacter(p0);
            } else {
                z2 = false;
            }
            if (!z2) {
                break;
            }
            textualPos = textualPos.offsetColumn(columnOffset);
            ch = (Character) ((Function1) nextChar).invoke(textualPos);
            if (ch != null && ch.charValue() == '\n') {
                return textualPos;
            }
        }
        while (!((Boolean) atEndOfDirection.invoke()).booleanValue()) {
            Character ch3 = ch;
            if (ch3 != null) {
                char p1 = ch3.charValue();
                z = !isBreakingCharacter(p1);
            } else {
                z = false;
            }
            if (!z) {
                break;
            }
            textualPos = textualPos.offsetColumn(columnOffset);
            ch = (Character) ((Function1) nextChar).invoke(textualPos);
            if (ch != null && ch.charValue() == '\n') {
                return textualPos;
            }
        }
        LinePosition visualPos = textualPos.toVisualPos();
        if (direction == Direction.Left && visualPos.isAtLineEnd() && !visualPos.isInLastLine()) {
            textualPos = new LinePosition(visualPos.getLine() + 1, 0, true);
        } else if (direction == Direction.Right && visualPos.isAtLineStart() && !visualPos.isInFirstLine()) {
            textualPos = new LinePosition(visualPos.getLine() - 1, this.visualLines.get(visualPos.getLine() - 1).getText().length(), true);
        }
        return textualPos;
    }

    protected void animateCursor() {
        if (this.active) {
            UIComponent $this$animate$iv = this.cursorComponent;
            AnimatingConstraints anim$iv = $this$animate$iv.makeAnimation();
            AnimatingConstraints.setColorAnimation$default(anim$iv, Animations.OUT_CIRCULAR, 0.5f, UtilitiesKt.toConstraint(this.cursorColor), 0.0f, 8, (Object) null);
            anim$iv.onComplete(() -> {
                return animateCursor$lambda$30$lambda$29(r1);
            });
            $this$animate$iv.animateTo(anim$iv);
        }
    }

    private static final Unit animateCursor$lambda$30$lambda$29(AbstractTextInput this$0) {
        if (!this$0.active) {
            return Unit.INSTANCE;
        }
        UIComponent $this$animate$iv = this$0.cursorComponent;
        AnimatingConstraints anim$iv = $this$animate$iv.makeAnimation();
        AnimatingConstraints.setColorAnimation$default(anim$iv, Animations.IN_CIRCULAR, 0.5f, UtilitiesKt.toConstraint(new Color(255, 255, 255, 0)), 0.0f, 8, (Object) null);
        anim$iv.onComplete(() -> {
            return animateCursor$lambda$30$lambda$29$lambda$28$lambda$27(r1);
        });
        $this$animate$iv.animateTo(anim$iv);
        return Unit.INSTANCE;
    }

    private static final Unit animateCursor$lambda$30$lambda$29$lambda$28$lambda$27(AbstractTextInput this$0) {
        if (this$0.active) {
            this$0.animateCursor();
        }
        return Unit.INSTANCE;
    }

    protected boolean hasText() {
        if (this.textualLines.size() <= 1) {
            if (!(this.textualLines.get(0).getText().length() > 0)) {
                return false;
            }
        }
        return true;
    }

    @Deprecated(message = "For 1.17 this method requires you pass a UMatrixStack as the first argument.\n\nIf you are currently extending this method, you should instead extend the method with the added argument.\nNote however for this to be non-breaking, your parent class needs to transition before you do.\n\nIf you are calling this method and you cannot guarantee that your target class has been fully updated (such as when\ncalling an open method on an open class), you should instead call the method with the \"Compat\" suffix, which will\ncall both methods, the new and the deprecated one.\nIf you are sure that your target class has been updated (such as when calling the super method), you should\n(for super calls you must!) instead just call the method with the original name and added argument.", replaceWith = @ReplaceWith(expression = "drawUnselectedText(matrixStack, text, left, row)", imports = {}))
    protected void drawUnselectedText(@NotNull String text, float left, int row) {
        Intrinsics.checkNotNullParameter(text, "text");
        drawUnselectedText(UMatrixStack.Compat.INSTANCE.get(), text, left, row);
    }

    protected final void drawUnselectedTextCompat(@NotNull UMatrixStack matrixStack, @NotNull String text, float left, int row) {
        Intrinsics.checkNotNullParameter(matrixStack, "matrixStack");
        Intrinsics.checkNotNullParameter(text, "text");
        UMatrixStack.Compat.INSTANCE.runLegacyMethod(matrixStack, () -> {
            return drawUnselectedTextCompat$lambda$31(r2, r3, r4, r5);
        });
    }

    private static final Unit drawUnselectedTextCompat$lambda$31(AbstractTextInput this$0, String $text, float $left, int $row) {
        this$0.drawUnselectedText($text, $left, $row);
        return Unit.INSTANCE;
    }

    protected void drawUnselectedText(@NotNull UMatrixStack matrixStack, @NotNull String text, float left, int row) {
        Intrinsics.checkNotNullParameter(matrixStack, "matrixStack");
        Intrinsics.checkNotNullParameter(text, "text");
        float textHeight = (getHeight() - UtilitiesKt.fontHeight(text, getTextScale(), getFontProvider())) / 2;
        FontProvider.drawString$default(getFontProvider(), matrixStack, text, getColor(), left - this.horizontalScrollingOffset, getTop() + (textHeight * (row + 1)) + this.verticalScrollingOffset, 10.0f, getTextScale(), false, (Color) null, 256, (Object) null);
    }

    @Deprecated(message = "For 1.17 this method requires you pass a UMatrixStack as the first argument.\n\nIf you are currently extending this method, you should instead extend the method with the added argument.\nNote however for this to be non-breaking, your parent class needs to transition before you do.\n\nIf you are calling this method and you cannot guarantee that your target class has been fully updated (such as when\ncalling an open method on an open class), you should instead call the method with the \"Compat\" suffix, which will\ncall both methods, the new and the deprecated one.\nIf you are sure that your target class has been updated (such as when calling the super method), you should\n(for super calls you must!) instead just call the method with the original name and added argument.", replaceWith = @ReplaceWith(expression = "drawSelectedText(matrixStack, text, left, right, row)", imports = {}))
    protected void drawSelectedText(@NotNull String text, float left, float right, int row) {
        Intrinsics.checkNotNullParameter(text, "text");
        drawSelectedText(UMatrixStack.Compat.INSTANCE.get(), text, left, right, row);
    }

    protected final void drawSelectedTextCompat(@NotNull UMatrixStack matrixStack, @NotNull String text, float left, float right, int row) {
        Intrinsics.checkNotNullParameter(matrixStack, "matrixStack");
        Intrinsics.checkNotNullParameter(text, "text");
        UMatrixStack.Compat.INSTANCE.runLegacyMethod(matrixStack, () -> {
            return drawSelectedTextCompat$lambda$32(r2, r3, r4, r5, r6);
        });
    }

    private static final Unit drawSelectedTextCompat$lambda$32(AbstractTextInput this$0, String $text, float $left, float $right, int $row) {
        this$0.drawSelectedText($text, $left, $right, $row);
        return Unit.INSTANCE;
    }

    protected void drawSelectedText(@NotNull UMatrixStack matrixStack, @NotNull String text, float left, float right, int row) {
        Intrinsics.checkNotNullParameter(matrixStack, "matrixStack");
        Intrinsics.checkNotNullParameter(text, "text");
        UIBlock.Companion.drawBlock(matrixStack, this.active ? this.selectionBackgroundColor : this.inactiveSelectionBackgroundColor, ((double) left) - ((double) this.horizontalScrollingOffset), ((double) getTop()) + ((double) (this.lineHeight * row * getTextScale())) + ((double) this.verticalScrollingOffset), ((double) right) - ((double) this.horizontalScrollingOffset), ((double) getTop()) + ((double) (this.lineHeight * (row + 1) * getTextScale())) + ((double) this.verticalScrollingOffset));
        if (text.length() > 0) {
            float textHeight = (getHeight() - UtilitiesKt.fontHeight(text, getTextScale(), getFontProvider())) / 2;
            FontProvider.drawString$default(getFontProvider(), matrixStack, text, this.active ? this.selectionForegroundColor : this.inactiveSelectionForegroundColor, left - this.horizontalScrollingOffset, getTop() + (textHeight * (row + 1)) + this.verticalScrollingOffset, 10.0f, getTextScale(), false, (Color) null, 256, (Object) null);
        }
    }

    public void animationFrame() {
        super.animationFrame();
        float diff = (this.targetVerticalScrollingOffset - this.verticalScrollingOffset) * 0.1f;
        if (Math.abs(diff) < 0.25f) {
            this.verticalScrollingOffset = this.targetVerticalScrollingOffset;
        }
        this.verticalScrollingOffset += diff;
        recalculateDimensions();
        if (this.cursorNeedsRefocus) {
            scrollIntoView(this.cursor);
            this.cursorNeedsRefocus = false;
        }
    }

    /* JADX INFO: compiled from: AbstractTextInput.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/input/AbstractTextInput$LinePosition.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0084\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0000R\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0017\u001a\u00060\u0000R\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0004J!\u0010\u0019\u001a\u00060\u0000R\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\n\u0010\u001a\u001a\u00060\u0000R\u00020\u0002H\u0082\u0010J\u0018\u0010\u001b\u001a\u00060\u0000R\u00020\u00022\n\u0010\u001a\u001a\u00060\u0000R\u00020\u0002H\u0002J\u0018\u0010\u001c\u001a\u00060\u0000R\u00020\u00022\n\u0010\u001a\u001a\u00060\u0000R\u00020\u0002H\u0002J!\u0010\u001d\u001a\u00060\u0000R\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\n\u0010\u001a\u001a\u00060\u0000R\u00020\u0002H\u0082\u0010J\u0018\u0010\u001e\u001a\u00060\u0000R\u00020\u00022\n\u0010\u001a\u001a\u00060\u0000R\u00020\u0002H\u0002J\u0018\u0010\u001f\u001a\u00060\u0000R\u00020\u00022\n\u0010\u001a\u001a\u00060\u0000R\u00020\u0002H\u0002J\u0012\u0010 \u001a\u00060\u0000R\u00020\u00022\u0006\u0010!\u001a\u00020\u0004J\n\u0010\"\u001a\u00060\u0000R\u00020\u0002J\n\u0010#\u001a\u00060\u0000R\u00020\u0002J\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0%J\u0015\u0010'\u001a\u00020\u00042\n\u0010(\u001a\u00060\u0000R\u00020\u0002H\u0096\u0002J\u0013\u0010)\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010*H\u0096\u0002J\b\u0010+\u001a\u00020\u0004H\u0016J\b\u0010,\u001a\u00020-H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u000f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0011\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0013\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0018\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0016R\u00020\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$LinePosition;", "", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;", "line", "", "column", "isVisual", "", "<init>", "(Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;IIZ)V", "getLine", "()I", "getColumn", "()Z", "isAtLineStart", "isAtLineEnd", "isInFirstLine", "isInLastLine", "isAtAbsoluteStart", "isAtAbsoluteEnd", "lines", "", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$Line;", "offsetColumn", "amount", "offsetColumnNegative", "pos", "complexOffsetColumnNegative", "simpleOffsetColumnNegative", "offsetColumnPositive", "complexOffsetColumnPositive", "simpleOffsetColumnPositive", "withColumn", "newColumn", "toTextualPos", "toVisualPos", "toScreenPos", "Lkotlin/Pair;", "", "compareTo", "other", "equals", "", "hashCode", "toString", "", "MSShop"})
    protected final class LinePosition implements Comparable<LinePosition> {
        private final int line;
        private final int column;
        private final boolean isVisual;

        @NotNull
        private final List<Line> lines;

        public LinePosition(int line, int column, boolean isVisual) {
            this.line = line;
            this.column = column;
            this.isVisual = isVisual;
            this.lines = this.isVisual ? AbstractTextInput.this.getVisualLines() : AbstractTextInput.this.getTextualLines();
        }

        public final int getLine() {
            return this.line;
        }

        public final int getColumn() {
            return this.column;
        }

        public final boolean isVisual() {
            return this.isVisual;
        }

        public final boolean isAtLineStart() {
            return this.column == 0;
        }

        public final boolean isAtLineEnd() {
            return this.column == this.lines.get(this.line).getLength();
        }

        public final boolean isInFirstLine() {
            return this.line == 0;
        }

        public final boolean isInLastLine() {
            return this.line == CollectionsKt.getLastIndex(this.lines);
        }

        public final boolean isAtAbsoluteStart() {
            return isInFirstLine() && isAtLineStart();
        }

        public final boolean isAtAbsoluteEnd() {
            return isInLastLine() && isAtLineEnd();
        }

        @NotNull
        public final LinePosition offsetColumn(int amount) {
            if (amount > 0) {
                return offsetColumnPositive(amount, this);
            }
            return amount < 0 ? offsetColumnNegative(-amount, this) : this;
        }

        private final LinePosition offsetColumnNegative(int amount, LinePosition pos) {
            LinePosition linePosition = this;
            while (amount != 0 && !pos.isAtAbsoluteStart()) {
                LinePosition linePositionComplexOffsetColumnNegative = linePosition.complexOffsetColumnNegative(pos);
                linePosition = linePosition;
                amount--;
                pos = linePositionComplexOffsetColumnNegative;
            }
            return pos;
        }

        private final LinePosition complexOffsetColumnNegative(LinePosition pos) {
            if (!pos.isVisual) {
                return simpleOffsetColumnNegative(pos);
            }
            if (!pos.isAtLineStart()) {
                return simpleOffsetColumnNegative(pos);
            }
            VisualLine currentLine = AbstractTextInput.this.getVisualLines().get(pos.line);
            VisualLine previousLine = AbstractTextInput.this.getVisualLines().get(pos.line - 1);
            if (currentLine.getTextIndex() != previousLine.getTextIndex()) {
                return simpleOffsetColumnNegative(pos);
            }
            if (StringsKt.last(previousLine.getText()) != ' ') {
                return simpleOffsetColumnNegative(pos);
            }
            return AbstractTextInput.this.new LinePosition(pos.line - 1, previousLine.getLength() - 1, true);
        }

        private final LinePosition simpleOffsetColumnNegative(LinePosition pos) {
            if (pos.column == 0) {
                return AbstractTextInput.this.new LinePosition(pos.line - 1, pos.lines.get(pos.line - 1).getLength(), pos.isVisual);
            }
            return pos.withColumn(pos.column - 1);
        }

        private final LinePosition offsetColumnPositive(int amount, LinePosition pos) {
            LinePosition linePosition = this;
            while (amount != 0 && !pos.isAtAbsoluteEnd()) {
                LinePosition linePositionComplexOffsetColumnPositive = linePosition.complexOffsetColumnPositive(pos);
                linePosition = linePosition;
                amount--;
                pos = linePositionComplexOffsetColumnPositive;
            }
            return pos;
        }

        private final LinePosition complexOffsetColumnPositive(LinePosition pos) {
            if (!pos.isVisual) {
                return simpleOffsetColumnPositive(pos);
            }
            VisualLine currentLine = AbstractTextInput.this.getVisualLines().get(pos.line);
            if (pos.column < currentLine.getLength() - 1) {
                return simpleOffsetColumnPositive(pos);
            }
            if (pos.line == CollectionsKt.getLastIndex(AbstractTextInput.this.getVisualLines())) {
                return AbstractTextInput.this.new LinePosition(pos.line, currentLine.getLength(), true);
            }
            if (pos.column == currentLine.getLength() - 1 && StringsKt.last(currentLine.getText()) != ' ') {
                return simpleOffsetColumnPositive(pos);
            }
            VisualLine nextLine = AbstractTextInput.this.getVisualLines().get(pos.line + 1);
            if (currentLine.getTextIndex() == nextLine.getTextIndex()) {
                return AbstractTextInput.this.new LinePosition(pos.line + 1, 0, true);
            }
            return simpleOffsetColumnPositive(pos);
        }

        private final LinePosition simpleOffsetColumnPositive(LinePosition pos) {
            if (pos.column >= pos.lines.get(pos.line).getLength()) {
                if (pos.line == CollectionsKt.getLastIndex(pos.lines)) {
                    return AbstractTextInput.this.new LinePosition(CollectionsKt.getLastIndex(pos.lines), ((Line) CollectionsKt.last(pos.lines)).getLength(), pos.isVisual);
                }
                return AbstractTextInput.this.new LinePosition(pos.line + 1, 0, pos.isVisual);
            }
            return pos.withColumn(pos.column + 1);
        }

        @NotNull
        public final LinePosition withColumn(int newColumn) {
            return AbstractTextInput.this.new LinePosition(this.line, newColumn, this.isVisual);
        }

        @NotNull
        public final LinePosition toTextualPos() {
            if (!this.isVisual) {
                return this;
            }
            VisualLine visualLine = AbstractTextInput.this.getVisualLines().get(this.line);
            TextualLine textualLine = AbstractTextInput.this.getTextualLines().get(visualLine.getTextIndex());
            int totalVisualLength = 0;
            int i = this.line;
            for (int i2 = textualLine.getVisualIndices().getFirst(); i2 < i; i2++) {
                totalVisualLength += AbstractTextInput.this.getVisualLines().get(i2).getLength();
            }
            return AbstractTextInput.this.new LinePosition(visualLine.getTextIndex(), totalVisualLength + this.column, false);
        }

        @NotNull
        public final LinePosition toVisualPos() {
            if (this.isVisual) {
                return this;
            }
            TextualLine textualLine = AbstractTextInput.this.getTextualLines().get(this.line);
            int lengthRemaining = this.column;
            IntRange visualIndices = textualLine.getVisualIndices();
            int visualLineIndex = visualIndices.getFirst();
            int last = visualIndices.getLast();
            if (visualLineIndex <= last) {
                while (true) {
                    VisualLine visualLine = AbstractTextInput.this.getVisualLines().get(visualLineIndex);
                    if (visualLine.getLength() >= lengthRemaining) {
                        return AbstractTextInput.this.new LinePosition(visualLineIndex, lengthRemaining, true);
                    }
                    lengthRemaining -= visualLine.getLength();
                    if (visualLineIndex != last) {
                        visualLineIndex++;
                    }
                }
            }
            return AbstractTextInput.this.new LinePosition(0, 0, true);
        }

        @NotNull
        public final Pair<Float, Float> toScreenPos() {
            LinePosition visualPos = toVisualPos();
            String strSubstring = AbstractTextInput.this.getVisualLines().get(visualPos.line).getText().substring(0, visualPos.column);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            float x = UtilitiesKt.fontWidth(strSubstring, AbstractTextInput.this.getTextScale(), AbstractTextInput.this.getFontProvider()) - AbstractTextInput.this.getHorizontalScrollingOffset();
            float y = (AbstractTextInput.this.getLineHeight() * visualPos.line * AbstractTextInput.this.getTextScale()) + AbstractTextInput.this.getVerticalScrollingOffset();
            return TuplesKt.to(Float.valueOf(x), Float.valueOf(y));
        }

        @Override // java.lang.Comparable
        public int compareTo(@NotNull LinePosition other) {
            Intrinsics.checkNotNullParameter(other, "other");
            LinePosition thisVisual = toVisualPos();
            LinePosition otherVisual = other.toVisualPos();
            if (thisVisual.line < otherVisual.line) {
                return -1;
            }
            if (thisVisual.line > otherVisual.line) {
                return 1;
            }
            if (thisVisual.column < otherVisual.column) {
                return -1;
            }
            return thisVisual.column > otherVisual.column ? 1 : 0;
        }

        public boolean equals(@Nullable Object other) {
            return (other instanceof LinePosition) && this.line == ((LinePosition) other).line && this.column == ((LinePosition) other).column && this.isVisual == ((LinePosition) other).isVisual;
        }

        public int hashCode() {
            int result = this.line;
            return (31 * ((31 * result) + this.column)) + Boolean.hashCode(this.isVisual);
        }

        @NotNull
        public String toString() {
            return "LinePosition(line=" + this.line + ", column=" + this.column + ", isVisual=" + this.isVisual + ")";
        }
    }

    /* JADX INFO: compiled from: AbstractTextInput.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/input/AbstractTextInput$Line.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0094\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$Line;", "", "text", "", "<init>", "(Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "length", "", "getLength", "()I", "MSShop"})
    protected class Line {

        @NotNull
        private String text;
        final /* synthetic */ AbstractTextInput this$0;

        public Line(@NotNull AbstractTextInput this$0, String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.this$0 = this$0;
            this.text = text;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        public final void setText(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }

        public final int getLength() {
            return this.text.length();
        }
    }

    /* JADX INFO: compiled from: AbstractTextInput.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/input/AbstractTextInput$TextualLine.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0084\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0004H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$TextualLine;", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$Line;", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;", "text", "", "visualIndices", "Lkotlin/ranges/IntRange;", "<init>", "(Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "getVisualIndices", "()Lkotlin/ranges/IntRange;", "setVisualIndices", "(Lkotlin/ranges/IntRange;)V", "addTextAt", "", "newText", "column", "", "toString", "MSShop"})
    protected final class TextualLine extends Line {

        @NotNull
        private IntRange visualIndices;
        final /* synthetic */ AbstractTextInput this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TextualLine(@NotNull AbstractTextInput this$0, @NotNull String text, IntRange visualIndices) {
            super(this$0, text);
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(visualIndices, "visualIndices");
            this.this$0 = this$0;
            this.visualIndices = visualIndices;
        }

        public /* synthetic */ TextualLine(AbstractTextInput abstractTextInput, String str, IntRange intRange, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(abstractTextInput, str, (i & 2) != 0 ? new IntRange(0, 0) : intRange);
        }

        @NotNull
        public final IntRange getVisualIndices() {
            return this.visualIndices;
        }

        public final void setVisualIndices(@NotNull IntRange intRange) {
            Intrinsics.checkNotNullParameter(intRange, "<set-?>");
            this.visualIndices = intRange;
        }

        public final void addTextAt(@NotNull String newText, int column) {
            Intrinsics.checkNotNullParameter(newText, "newText");
            if (column >= getText().length()) {
                setText(getText() + newText);
                return;
            }
            String strSubstring = getText().substring(0, column);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String strSubstring2 = getText().substring(column);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            setText(strSubstring + newText + strSubstring2);
        }

        @NotNull
        public String toString() {
            return "TextualLine(text=" + getText() + ", visualIndices=" + this.visualIndices + ")";
        }
    }

    /* JADX INFO: compiled from: AbstractTextInput.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/input/AbstractTextInput$VisualLine.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0084\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$VisualLine;", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$Line;", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;", "text", "", "textIndex", "", "<init>", "(Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;Ljava/lang/String;I)V", "getTextIndex", "()I", "toString", "MSShop"})
    protected final class VisualLine extends Line {
        private final int textIndex;
        final /* synthetic */ AbstractTextInput this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VisualLine(@NotNull AbstractTextInput this$0, String text, int textIndex) {
            super(this$0, text);
            Intrinsics.checkNotNullParameter(text, "text");
            this.this$0 = this$0;
            this.textIndex = textIndex;
        }

        public final int getTextIndex() {
            return this.textIndex;
        }

        @NotNull
        public String toString() {
            return "VisualLine(text=" + getText() + ", textIndex=" + this.textIndex + ")";
        }
    }

    /* JADX INFO: compiled from: AbstractTextInput.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/input/AbstractTextInput$TextOperation.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b¤\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$TextOperation;", "", "<init>", "(Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;)V", "redo", "", "undo", "MSShop"})
    protected abstract class TextOperation {
        public abstract void redo();

        public abstract void undo();

        public TextOperation() {
        }
    }

    /* JADX INFO: compiled from: AbstractTextInput.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/input/AbstractTextInput$AddTextOperation.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0084\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u00060\u0006R\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$AddTextOperation;", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$TextOperation;", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;", "newText", "", "startPos", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$LinePosition;", "<init>", "(Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;Ljava/lang/String;Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$LinePosition;)V", "redo", "", "undo", "MSShop"})
    protected final class AddTextOperation extends TextOperation {

        @NotNull
        private final String newText;

        @NotNull
        private final LinePosition startPos;
        final /* synthetic */ AbstractTextInput this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddTextOperation(@NotNull AbstractTextInput this$0, @NotNull String newText, LinePosition startPos) {
            super();
            Intrinsics.checkNotNullParameter(newText, "newText");
            Intrinsics.checkNotNullParameter(startPos, "startPos");
            this.this$0 = this$0;
            this.newText = newText;
            this.startPos = startPos;
        }

        @Override // net.mcskill.shop.client.screen.component.input.AbstractTextInput.TextOperation
        public void redo() {
            this.this$0.addText(this.newText, this.startPos);
        }

        @Override // net.mcskill.shop.client.screen.component.input.AbstractTextInput.TextOperation
        public void undo() {
            this.this$0.removeText(this.startPos, this.startPos.offsetColumn(this.newText.length()));
            this.this$0.setCursorPosition(this.startPos.toVisualPos());
        }
    }

    /* JADX INFO: compiled from: AbstractTextInput.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/input/AbstractTextInput$RemoveTextOperation.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0084\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B'\u0012\n\u0010\u0003\u001a\u00060\u0004R\u00020\u0002\u0012\n\u0010\u0005\u001a\u00060\u0004R\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00060\u0004R\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$RemoveTextOperation;", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$TextOperation;", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;", "startPos", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$LinePosition;", "endPos", "selectAfterUndo", "", "<init>", "(Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$LinePosition;Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$LinePosition;Z)V", "text", "", "getText", "()Ljava/lang/String;", "redo", "", "undo", "MSShop"})
    protected final class RemoveTextOperation extends TextOperation {

        @NotNull
        private final LinePosition startPos;

        @NotNull
        private final LinePosition endPos;
        private final boolean selectAfterUndo;

        @NotNull
        private final String text;
        final /* synthetic */ AbstractTextInput this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoveTextOperation(@NotNull AbstractTextInput this$0, @NotNull LinePosition startPos, LinePosition endPos, boolean selectAfterUndo) {
            super();
            Intrinsics.checkNotNullParameter(startPos, "startPos");
            Intrinsics.checkNotNullParameter(endPos, "endPos");
            this.this$0 = this$0;
            this.startPos = startPos;
            this.endPos = endPos;
            this.selectAfterUndo = selectAfterUndo;
            this.text = this.this$0.getTextBetween(this.startPos, this.endPos);
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        @Override // net.mcskill.shop.client.screen.component.input.AbstractTextInput.TextOperation
        public void redo() {
            LinePosition textualStartPos = this.startPos.toTextualPos();
            this.this$0.removeText(textualStartPos, this.endPos);
            this.this$0.setCursorPosition(textualStartPos);
        }

        @Override // net.mcskill.shop.client.screen.component.input.AbstractTextInput.TextOperation
        public void undo() {
            this.this$0.addText(this.text, this.startPos);
            if (this.selectAfterUndo) {
                this.this$0.setCursor(this.startPos);
                this.this$0.setOtherSelectionEnd(this.endPos);
                this.this$0.setCursorNeedsRefocus(true);
            }
        }
    }

    /* JADX INFO: compiled from: AbstractTextInput.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/input/AbstractTextInput$ReplaceTextOperation.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0084\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001f\u0012\n\u0010\u0003\u001a\u00060\u0004R\u00020\u0002\u0012\n\u0010\u0005\u001a\u00060\u0006R\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$ReplaceTextOperation;", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$TextOperation;", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;", "addTextOperation", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$AddTextOperation;", "removeTextOperation", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$RemoveTextOperation;", "<init>", "(Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$AddTextOperation;Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$RemoveTextOperation;)V", "redo", "", "undo", "MSShop"})
    protected final class ReplaceTextOperation extends TextOperation {

        @NotNull
        private final AddTextOperation addTextOperation;

        @NotNull
        private final RemoveTextOperation removeTextOperation;
        final /* synthetic */ AbstractTextInput this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReplaceTextOperation(@NotNull AbstractTextInput this$0, @NotNull AddTextOperation addTextOperation, RemoveTextOperation removeTextOperation) {
            super();
            Intrinsics.checkNotNullParameter(addTextOperation, "addTextOperation");
            Intrinsics.checkNotNullParameter(removeTextOperation, "removeTextOperation");
            this.this$0 = this$0;
            this.addTextOperation = addTextOperation;
            this.removeTextOperation = removeTextOperation;
        }

        @Override // net.mcskill.shop.client.screen.component.input.AbstractTextInput.TextOperation
        public void redo() {
            this.removeTextOperation.redo();
            this.addTextOperation.redo();
        }

        @Override // net.mcskill.shop.client.screen.component.input.AbstractTextInput.TextOperation
        public void undo() {
            this.addTextOperation.undo();
            this.removeTextOperation.undo();
        }
    }
}
