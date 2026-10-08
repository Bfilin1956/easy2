package net.mcskill.shop.client.screen.component.input;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.constraints.MasterConstraint;
import gg.essential.elementa.constraints.SuperConstraint;
import gg.essential.elementa.constraints.WidthConstraint;
import gg.essential.elementa.constraints.XConstraint;
import gg.essential.elementa.dsl.BasicConstraintsKt;
import gg.essential.elementa.dsl.ConstraintsKt;
import gg.essential.elementa.dsl.UtilitiesKt;
import gg.essential.elementa.font.FontProvider;
import gg.essential.universal.UMatrixStack;
import java.awt.Color;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextInput.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/input/TextInput.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BY\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0003J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0013J\b\u0010$\u001a\u00020\u0003H\u0016J\u0006\u0010%\u001a\u00020\u0003J\u0006\u0010&\u001a\u00020'J\u0016\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030)2\u0006\u0010*\u001a\u00020\u0003H\u0014J\u0014\u0010+\u001a\u00020'2\n\u0010,\u001a\u00060-R\u00020\u0001H\u0014J\u001c\u0010.\u001a\u00060-R\u00020\u00012\u0006\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u001cH\u0014J\b\u00101\u001a\u00020'H\u0014J\u0010\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\u0003H\u0014J\u001e\u00104\u001a\b\u0012\u0004\u0012\u00020\u00030)2\u0006\u0010*\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u001cH\u0014J\b\u00106\u001a\u00020'H\u0014J\u0010\u00107\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u001cX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lnet/mcskill/shop/client/screen/component/input/TextInput;", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput;", "placeholder", "", "selectionBackgroundColor", "Ljava/awt/Color;", "selectionForegroundColor", "allowInactiveSelection", "", "inactiveSelectionBackgroundColor", "inactiveSelectionForegroundColor", "cursorColor", "maxLength", "", "<init>", "(Ljava/lang/String;Ljava/awt/Color;Ljava/awt/Color;ZLjava/awt/Color;Ljava/awt/Color;Ljava/awt/Color;I)V", "getMaxLength", "()I", "minWidth", "Lgg/essential/elementa/constraints/WidthConstraint;", "getMinWidth", "()Lgg/essential/elementa/constraints/WidthConstraint;", "setMinWidth", "(Lgg/essential/elementa/constraints/WidthConstraint;)V", "maxWidth", "getMaxWidth", "setMaxWidth", "placeholderWidth", "", "getPlaceholderWidth", "()F", "validator", "Lkotlin/text/Regex;", "setValidator", "regex", "constraint", "getText", "getTextForRender", "setCursorPos", "", "textToLines", "", "text", "scrollIntoView", "pos", "Lnet/mcskill/shop/client/screen/component/input/AbstractTextInput$LinePosition;", "screenPosToVisualPos", "x", "y", "recalculateDimensions", "commitTextAddition", "newText", "splitTextForWrapping", "maxLineWidth", "onEnterPressed", "draw", "matrixStack", "Lgg/essential/universal/UMatrixStack;", "MSShop"})
public final class TextInput extends AbstractTextInput {
    private final int maxLength;

    @Nullable
    private WidthConstraint minWidth;

    @Nullable
    private WidthConstraint maxWidth;
    private final float placeholderWidth;

    @Nullable
    private Regex validator;

    public /* synthetic */ TextInput(String str, Color color, Color color2, boolean z, Color color3, Color color4, Color color5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? Color.WHITE : color, (i2 & 4) != 0 ? new Color(64, 139, 229) : color2, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? new Color(176, 176, 176) : color3, (i2 & 32) != 0 ? Color.WHITE : color4, (i2 & 64) != 0 ? Color.WHITE : color5, (i2 & 128) != 0 ? -1 : i);
    }

    public final int getMaxLength() {
        return this.maxLength;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextInput(@NotNull String placeholder, @NotNull Color selectionBackgroundColor, @NotNull Color selectionForegroundColor, boolean allowInactiveSelection, @NotNull Color inactiveSelectionBackgroundColor, @NotNull Color inactiveSelectionForegroundColor, @NotNull Color cursorColor, int maxLength) {
        super(placeholder, false, selectionBackgroundColor, selectionForegroundColor, allowInactiveSelection, inactiveSelectionBackgroundColor, inactiveSelectionForegroundColor, cursorColor);
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(selectionBackgroundColor, "selectionBackgroundColor");
        Intrinsics.checkNotNullParameter(selectionForegroundColor, "selectionForegroundColor");
        Intrinsics.checkNotNullParameter(inactiveSelectionBackgroundColor, "inactiveSelectionBackgroundColor");
        Intrinsics.checkNotNullParameter(inactiveSelectionForegroundColor, "inactiveSelectionForegroundColor");
        Intrinsics.checkNotNullParameter(cursorColor, "cursorColor");
        this.maxLength = maxLength;
        this.placeholderWidth = UtilitiesKt.fontWidth$default(placeholder, 0.0f, getFontProvider(), 1, (Object) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextInput(@NotNull String placeholder, @NotNull Color selectionBackgroundColor, @NotNull Color selectionForegroundColor, boolean allowInactiveSelection, @NotNull Color inactiveSelectionBackgroundColor, @NotNull Color inactiveSelectionForegroundColor, @NotNull Color cursorColor) {
        this(placeholder, selectionBackgroundColor, selectionForegroundColor, allowInactiveSelection, inactiveSelectionBackgroundColor, inactiveSelectionForegroundColor, cursorColor, 0, 128, null);
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(selectionBackgroundColor, "selectionBackgroundColor");
        Intrinsics.checkNotNullParameter(selectionForegroundColor, "selectionForegroundColor");
        Intrinsics.checkNotNullParameter(inactiveSelectionBackgroundColor, "inactiveSelectionBackgroundColor");
        Intrinsics.checkNotNullParameter(inactiveSelectionForegroundColor, "inactiveSelectionForegroundColor");
        Intrinsics.checkNotNullParameter(cursorColor, "cursorColor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextInput(@NotNull String placeholder, @NotNull Color selectionBackgroundColor, @NotNull Color selectionForegroundColor, boolean allowInactiveSelection, @NotNull Color inactiveSelectionBackgroundColor, @NotNull Color inactiveSelectionForegroundColor) {
        this(placeholder, selectionBackgroundColor, selectionForegroundColor, allowInactiveSelection, inactiveSelectionBackgroundColor, inactiveSelectionForegroundColor, null, 0, 192, null);
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(selectionBackgroundColor, "selectionBackgroundColor");
        Intrinsics.checkNotNullParameter(selectionForegroundColor, "selectionForegroundColor");
        Intrinsics.checkNotNullParameter(inactiveSelectionBackgroundColor, "inactiveSelectionBackgroundColor");
        Intrinsics.checkNotNullParameter(inactiveSelectionForegroundColor, "inactiveSelectionForegroundColor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextInput(@NotNull String placeholder, @NotNull Color selectionBackgroundColor, @NotNull Color selectionForegroundColor, boolean allowInactiveSelection, @NotNull Color inactiveSelectionBackgroundColor) {
        this(placeholder, selectionBackgroundColor, selectionForegroundColor, allowInactiveSelection, inactiveSelectionBackgroundColor, null, null, 0, 224, null);
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(selectionBackgroundColor, "selectionBackgroundColor");
        Intrinsics.checkNotNullParameter(selectionForegroundColor, "selectionForegroundColor");
        Intrinsics.checkNotNullParameter(inactiveSelectionBackgroundColor, "inactiveSelectionBackgroundColor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextInput(@NotNull String placeholder, @NotNull Color selectionBackgroundColor, @NotNull Color selectionForegroundColor, boolean allowInactiveSelection) {
        this(placeholder, selectionBackgroundColor, selectionForegroundColor, allowInactiveSelection, null, null, null, 0, 240, null);
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(selectionBackgroundColor, "selectionBackgroundColor");
        Intrinsics.checkNotNullParameter(selectionForegroundColor, "selectionForegroundColor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextInput(@NotNull String placeholder, @NotNull Color selectionBackgroundColor, @NotNull Color selectionForegroundColor) {
        this(placeholder, selectionBackgroundColor, selectionForegroundColor, false, null, null, null, 0, 248, null);
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(selectionBackgroundColor, "selectionBackgroundColor");
        Intrinsics.checkNotNullParameter(selectionForegroundColor, "selectionForegroundColor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextInput(@NotNull String placeholder, @NotNull Color selectionBackgroundColor) {
        this(placeholder, selectionBackgroundColor, null, false, null, null, null, 0, 252, null);
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(selectionBackgroundColor, "selectionBackgroundColor");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TextInput(@NotNull String placeholder) {
        this(placeholder, null, null, false, null, null, null, 0, 254, null);
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
    }

    @JvmOverloads
    public TextInput() {
        this(null, null, null, false, null, null, null, 0, 255, null);
    }

    @Nullable
    protected final WidthConstraint getMinWidth() {
        return this.minWidth;
    }

    protected final void setMinWidth(@Nullable WidthConstraint widthConstraint) {
        this.minWidth = widthConstraint;
    }

    @Nullable
    protected final WidthConstraint getMaxWidth() {
        return this.maxWidth;
    }

    protected final void setMaxWidth(@Nullable WidthConstraint widthConstraint) {
        this.maxWidth = widthConstraint;
    }

    protected final float getPlaceholderWidth() {
        return this.placeholderWidth;
    }

    @NotNull
    public final TextInput setValidator(@NotNull String regex) {
        Intrinsics.checkNotNullParameter(regex, "regex");
        TextInput $this$setValidator_u24lambda_u240 = this;
        $this$setValidator_u24lambda_u240.validator = new Regex(regex);
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: setMinWidth, reason: collision with other method in class */
    public final TextInput m44setMinWidth(@NotNull WidthConstraint constraint) {
        Intrinsics.checkNotNullParameter(constraint, "constraint");
        TextInput $this$setMinWidth_u24lambda_u241 = this;
        $this$setMinWidth_u24lambda_u241.minWidth = constraint;
        return this;
    }

    @NotNull
    /* JADX INFO: renamed from: setMaxWidth, reason: collision with other method in class */
    public final TextInput m45setMaxWidth(@NotNull WidthConstraint constraint) {
        Intrinsics.checkNotNullParameter(constraint, "constraint");
        TextInput $this$setMaxWidth_u24lambda_u242 = this;
        $this$setMaxWidth_u24lambda_u242.maxWidth = constraint;
        return this;
    }

    @Override // net.mcskill.shop.client.screen.component.input.AbstractTextInput
    @NotNull
    public String getText() {
        return ((AbstractTextInput.TextualLine) CollectionsKt.first(getTextualLines())).getText();
    }

    @NotNull
    public final String getTextForRender() {
        return getText();
    }

    public final void setCursorPos() {
        MasterConstraint pixel;
        UIComponent.unhide$default(getCursorComponent(), false, 1, (Object) null);
        float cursorPosX = ((Number) getCursor().toScreenPos().component1()).floatValue();
        if (cursorPosX > 0.0f && getCursor().isAtLineEnd()) {
            pixel = ConstraintsKt.minus(UtilitiesKt.getPixel(Float.valueOf(cursorPosX)), UtilitiesKt.getDp((Number) 1));
        } else {
            pixel = UtilitiesKt.getPixel(Float.valueOf(cursorPosX));
        }
        MasterConstraint posX = pixel;
        getCursorComponent().setX((XConstraint) posX);
    }

    @Override // net.mcskill.shop.client.screen.component.input.AbstractTextInput
    @NotNull
    protected List<String> textToLines(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return CollectionsKt.listOf(StringsKt.replace$default(text, '\n', ' ', false, 4, (Object) null));
    }

    @Override // net.mcskill.shop.client.screen.component.input.AbstractTextInput
    protected void scrollIntoView(@NotNull AbstractTextInput.LinePosition pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        int column = pos.getColumn();
        String lineText = getTextForRender();
        if (column < 0 || column > lineText.length()) {
            return;
        }
        String strSubstring = lineText.substring(0, column);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        float widthBeforePosition = UtilitiesKt.fontWidth(strSubstring, getTextScale(), getFontProvider());
        if (UtilitiesKt.fontWidth(getTextForRender(), getTextScale(), getFontProvider()) < getWidth()) {
            setHorizontalScrollingOffset(0.0f);
        } else if (getHorizontalScrollingOffset() > widthBeforePosition) {
            setHorizontalScrollingOffset(widthBeforePosition);
        } else if (widthBeforePosition - getHorizontalScrollingOffset() > getWidth()) {
            setHorizontalScrollingOffset(widthBeforePosition - getWidth());
        }
    }

    @Override // net.mcskill.shop.client.screen.component.input.AbstractTextInput
    @NotNull
    protected AbstractTextInput.LinePosition screenPosToVisualPos(float x, float y) {
        float targetXPos = x + getHorizontalScrollingOffset();
        float currentX = 0.0f;
        String line = getTextForRender();
        int length = line.length();
        for (int i = 0; i < length; i++) {
            float charWidth = UtilitiesKt.width$default(line.charAt(i), getTextScale(), (FontProvider) null, 2, (Object) null);
            if (currentX + (charWidth / 2) >= targetXPos) {
                return new AbstractTextInput.LinePosition(0, i, true);
            }
            currentX += charWidth;
        }
        return new AbstractTextInput.LinePosition(0, line.length(), true);
    }

    @Override // net.mcskill.shop.client.screen.component.input.AbstractTextInput
    protected void recalculateDimensions() {
        float fFontWidth;
        if (this.minWidth != null && this.maxWidth != null) {
            if (!hasText() && !getActive()) {
                fFontWidth = this.placeholderWidth;
            } else {
                fFontWidth = UtilitiesKt.fontWidth(getTextForRender(), getTextScale(), getFontProvider()) + 1;
            }
            float width = fFontWidth;
            SuperConstraint superConstraintPixels$default = UtilitiesKt.pixels$default(Float.valueOf(width), false, false, 3, (Object) null);
            SuperConstraint superConstraint = this.minWidth;
            Intrinsics.checkNotNull(superConstraint);
            SuperConstraint superConstraint2 = this.maxWidth;
            Intrinsics.checkNotNull(superConstraint2);
            setWidth((WidthConstraint) ConstraintsKt.coerceIn(superConstraintPixels$default, superConstraint, superConstraint2));
        }
    }

    @Override // net.mcskill.shop.client.screen.component.input.AbstractTextInput
    protected void commitTextAddition(@NotNull String newText) {
        Intrinsics.checkNotNullParameter(newText, "newText");
        if (this.maxLength != -1 && newText.length() > this.maxLength) {
            return;
        }
        if (this.validator != null) {
            Regex regex = this.validator;
            Intrinsics.checkNotNull(regex);
            if (!regex.matches(newText)) {
                return;
            }
        }
        super.commitTextAddition(newText);
    }

    @Override // net.mcskill.shop.client.screen.component.input.AbstractTextInput
    @NotNull
    protected List<String> splitTextForWrapping(@NotNull String text, float maxLineWidth) {
        Intrinsics.checkNotNullParameter(text, "text");
        return CollectionsKt.listOf(text);
    }

    @Override // net.mcskill.shop.client.screen.component.input.AbstractTextInput
    protected void onEnterPressed() {
        getActivateAction().invoke(getText());
    }

    @Override // net.mcskill.shop.client.screen.component.input.AbstractTextInput
    public void draw(@NotNull UMatrixStack matrixStack) {
        Intrinsics.checkNotNullParameter(matrixStack, "matrixStack");
        beforeDrawCompat(matrixStack);
        if (!getActive() && !hasText()) {
            float textHeight = (getHeight() - UtilitiesKt.fontHeight(getPlaceholder(), getTextScale(), getFontProvider())) / 2;
            FontProvider.drawString$default(getFontProvider(), matrixStack, getPlaceholder(), getColor(), getLeft(), getTop() + textHeight, 10.0f, getTextScale(), getShadow(), (Color) null, 256, (Object) null);
            super.draw(matrixStack);
            return;
        }
        String lineText = getTextForRender();
        if (hasSelection()) {
            float currentX = getLeft();
            getCursorComponent().hide(true);
            if (!selectionStart().isAtLineStart()) {
                String preSelectionText = lineText.substring(0, selectionStart().getColumn());
                Intrinsics.checkNotNullExpressionValue(preSelectionText, "substring(...)");
                drawUnselectedTextCompat(matrixStack, preSelectionText, currentX, 0);
                currentX += UtilitiesKt.fontWidth(preSelectionText, getTextScale(), getFontProvider());
            }
            String selectedText = lineText.substring(selectionStart().getColumn(), selectionEnd().getColumn());
            Intrinsics.checkNotNullExpressionValue(selectedText, "substring(...)");
            float selectedTextWidth = UtilitiesKt.fontWidth(selectedText, getTextScale(), getFontProvider());
            drawSelectedTextCompat(matrixStack, selectedText, currentX, currentX + selectedTextWidth, 0);
            float currentX2 = currentX + selectedTextWidth;
            if (!selectionEnd().isAtLineEnd()) {
                String strSubstring = lineText.substring(selectionEnd().getColumn());
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                drawUnselectedTextCompat(matrixStack, strSubstring, currentX2, 0);
            }
        } else {
            if (getActive()) {
                getCursorComponent().setY(BasicConstraintsKt.basicYConstraint((v1) -> {
                    return draw$lambda$3(r1, v1);
                }));
                setCursorPos();
            }
            drawUnselectedTextCompat(matrixStack, lineText, getLeft(), 0);
        }
        super.draw(matrixStack);
    }

    private static final float draw$lambda$3(TextInput this$0, UIComponent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.getTop();
    }
}
