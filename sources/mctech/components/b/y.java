package mctech.components.b;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.StringSplitter;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.font.TextFieldHelper;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.apache.commons.lang3.mutable.MutableInt;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/y.class */
public class y extends mctech.m.d.a.a {

    @OnlyIn(Dist.CLIENT)
    TextFieldHelper a;
    Supplier<String> b;
    Consumer<String> c;
    Predicate<String> d;
    int e;
    long f;
    int g;
    b h;
    boolean i;
    int j;
    int k;
    boolean l;
    boolean m;

    public y(mctech.utils.math.geometry.b bVar, Supplier<String> supplier, Consumer<String> consumer, Predicate<String> predicate) {
        super(bVar);
        this.e = 0;
        this.f = 0L;
        this.g = -1;
        this.h = new b();
        this.i = false;
        this.j = 0;
        this.k = 0;
        this.l = false;
        this.m = true;
        this.b = supplier;
        this.c = consumer;
        this.d = predicate;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_TICK);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_CLOSE);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.KEY_INPUT);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
    }

    @Override // mctech.m.d.a.a
    public boolean a(int i, int i2) {
        return super.a(i, i2) || (this.l && this.m);
    }

    public int a() {
        return this.j;
    }

    public int b() {
        b bVarJ = j();
        return bVarJ.i.length + ((bVarJ.e && bVarJ.c.getX() == 0) ? 1 : 0);
    }

    public int d() {
        return this.e;
    }

    public y a(int i) {
        this.j = Mth.clamp(i, 0, Math.min(Math.max(0, (j().i.length - this.e) + 1), i));
        return this;
    }

    public y b(boolean z) {
        this.l = z;
        return this;
    }

    public y c(boolean z) {
        this.m = true;
        return this;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        Minecraft minecraft = bVar.getMinecraft();
        this.a = new TextFieldHelper(this::i, this::a, TextFieldHelper.createClipboardGetter(minecraft), TextFieldHelper.createClipboardSetter(minecraft), this.d);
        this.i = true;
        float fC = v().c();
        Objects.requireNonNull(bVar.j());
        this.e = Mth.floor(fC / 9.0f);
        bVar.a(true);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void b(mctech.m.d.b bVar) {
        this.k++;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void X_() {
        this.q.a(false);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        c[] cVarArr = j().i;
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        int i3 = -this.j;
        Objects.requireNonNull(this.q.j());
        poseStackPose.translate(0.0d, i3 * 9, 0.0d);
        for (int i4 = 0; i4 < this.e && i4 + this.j < cVarArr.length; i4++) {
            c cVar = cVarArr[i4 + this.j];
            this.q.a(guiGraphics, cVar.d, cVar.e, cVar.f, mctech.utils.math.a.f);
        }
        if (this.l) {
            int length = this.h.j.length;
            if (length > 0) {
                int iAbs = Math.abs(Math.min(Math.min(this.h.f, this.h.g) - this.j, 0));
                int iAbs2 = Math.abs(Math.max(Math.max(this.h.f, this.h.g) - (this.j + this.e), 0));
                if ((length - iAbs) - iAbs2 > 0) {
                    a(guiGraphics, this.h.j, iAbs, length - iAbs2);
                }
            }
            if (this.h.f >= this.j && this.h.f - this.e <= this.j) {
                a(guiGraphics, this.h.d, this.h.e);
            }
        }
        poseStackPose.popPose();
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean b_(int i) {
        if (!this.l) {
            return false;
        }
        if (i == 69) {
            return true;
        }
        if (c(i)) {
            this.i = true;
            return true;
        }
        return super.b_(i);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean a(char c2, int i) {
        if (c2 != 167 && c2 >= ' ' && c2 != 127) {
            this.a.insertText(Character.toString(c2));
            this.i = true;
            return true;
        }
        return super.a(c2, i);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean a(int i, int i2, int i3) {
        if (!super.a(i, i2) && this.l && this.m) {
            this.l = false;
            return false;
        }
        this.l = true;
        if (i3 == 0) {
            long millis = Util.getMillis();
            int iA = j().a(this.q.j(), a(new Vec2i(i, i2)));
            if (iA >= 0) {
                if (iA == this.g && millis - this.f < 250) {
                    if (!this.a.isSelecting()) {
                        this.a.setSelectionRange(StringSplitter.getWordPosition(i(), -1, iA, false), StringSplitter.getWordPosition(i(), 1, iA, false));
                    } else {
                        this.a.selectAll();
                    }
                } else {
                    this.a.setCursorPos(iA, Screen.hasShiftDown());
                }
                this.i = true;
            }
            this.g = iA;
            this.f = millis;
            return true;
        }
        return true;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean c(int i, int i2, int i3) {
        if (i3 == 0) {
            this.a.setCursorPos(j().a(this.q.j(), a(new Vec2i(i, i2))), true);
            this.i = true;
            return true;
        }
        return true;
    }

    @OnlyIn(Dist.CLIENT)
    private boolean c(int i) {
        if (Screen.isSelectAll(i)) {
            this.a.selectAll();
            return true;
        }
        if (Screen.isCopy(i)) {
            this.a.copy();
            return true;
        }
        if (Screen.isPaste(i)) {
            this.a.insertText(TextFieldHelper.getClipboardContents(Minecraft.getInstance()).replaceAll("\t", "   "));
            return true;
        }
        if (Screen.isCut(i)) {
            this.a.cut();
            return true;
        }
        switch (i) {
            case 257:
            case 335:
                this.a.insertText("\n");
                return true;
            case 258:
                this.a.insertText("   ");
                return true;
            case 259:
                this.a.removeCharsFromCursor(-1);
                return true;
            case 261:
                this.a.removeCharsFromCursor(1);
                return true;
            case 262:
                this.a.moveByChars(1, Screen.hasShiftDown());
                return true;
            case 263:
                this.a.moveByChars(-1, Screen.hasShiftDown());
                return true;
            case 264:
                f();
                return true;
            case 265:
                e();
                return true;
            case 268:
                g();
                return true;
            case 269:
                h();
                return true;
            default:
                return false;
        }
    }

    private void e() {
        d(-1);
    }

    private void f() {
        d(1);
    }

    private void d(int i) {
        this.a.setCursorPos(j().a(this.a.getCursorPos(), i), Screen.hasShiftDown());
    }

    private void g() {
        this.a.setCursorPos(j().a(this.a.getCursorPos()), Screen.hasShiftDown());
    }

    private void h() {
        this.a.setCursorPos(j().b(this.a.getCursorPos()), Screen.hasShiftDown());
    }

    private String i() {
        return this.b.get();
    }

    private void a(String str) {
        this.c.accept(str);
    }

    private b j() {
        if (this.i) {
            this.i = false;
            k();
        }
        return this.h;
    }

    private void k() {
        Vec2i vec2i;
        String strI = i();
        if (strI.isEmpty()) {
            this.h.a();
            return;
        }
        int cursorPos = this.a.getCursorPos();
        int selectionPos = this.a.getSelectionPos();
        IntArrayList intArrayList = new IntArrayList();
        ObjectList objectListI = mctech.utils.a.b.i();
        MutableInt mutableInt = new MutableInt();
        MutableBoolean mutableBoolean = new MutableBoolean();
        StringSplitter splitter = this.q.j().getSplitter();
        splitter.splitLines(strI, v().d() - 5, Style.EMPTY, true, (style, i, i2) -> {
            String strSubstring = strI.substring(i, i2);
            mutableBoolean.setValue(strSubstring.endsWith("\n"));
            intArrayList.add(i);
            String strStripEnd = StringUtils.stripEnd(strSubstring, " \n");
            int andIncrement = mutableInt.getAndIncrement();
            Objects.requireNonNull(this.q.j());
            objectListI.add(new c(style, strStripEnd, b(new Vec2i(0, andIncrement * 9))));
        });
        int[] intArray = intArrayList.toIntArray();
        boolean z = cursorPos == strI.length();
        if (z && mutableBoolean.isTrue()) {
            vec2i = new Vec2i(0, objectListI.size() * 9);
        } else {
            int iA = a(intArray, cursorPos);
            vec2i = new Vec2i(this.q.j().width(strI.substring(intArray[iA], cursorPos)), iA * 9);
        }
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        if (cursorPos != selectionPos) {
            int iMin = Math.min(cursorPos, selectionPos);
            int iMax = Math.max(cursorPos, selectionPos);
            int iA2 = a(intArray, iMin);
            int iA3 = a(intArray, iMax);
            if (iA2 == iA3) {
                arrayListNewArrayList.add(a(strI, splitter, iMin, iMax, iA2 * 9, intArray[iA2]));
            } else {
                arrayListNewArrayList.add(a(strI, splitter, iMin, iA2 + 1 > intArray.length ? strI.length() : intArray[iA2 + 1], iA2 * 9, intArray[iA2]));
                for (int i3 = iA2 + 1; i3 < iA3; i3++) {
                    arrayListNewArrayList.add(new a(b(new Vec2i(0, i3 * 9)), b(new Vec2i((int) splitter.stringWidth(strI.substring(intArray[i3], intArray[i3 + 1])), (i3 * 9) + 9))));
                }
                arrayListNewArrayList.add(a(strI, splitter, intArray[iA3], iMax, iA3 * 9, intArray[iA3]));
            }
        }
        this.h.a(strI, vec2i, a(intArray, cursorPos), a(intArray, selectionPos), z, intArray, (c[]) objectListI.toArray(new c[objectListI.size()]), (a[]) arrayListNewArrayList.toArray(new a[arrayListNewArrayList.size()]));
        int iA4 = a(intArray, cursorPos);
        if (iA4 == objectListI.size() - 1 && z && mutableBoolean.isTrue()) {
            iA4++;
        }
        if (iA4 < this.j) {
            this.j = Math.max(0, iA4);
        } else if ((iA4 > 6 && iA4 - 6 > this.j) || z) {
            this.j = Math.max(0, iA4 - 6);
        }
    }

    private void a(GuiGraphics guiGraphics, Vec2i vec2i, boolean z) {
        if ((this.k / 6) % 2 == 0) {
            if (!z) {
                guiGraphics.fill(vec2i.getX(), vec2i.getY() - 1, vec2i.getX() + 1, vec2i.getY() + 9, mctech.utils.math.a.f);
            } else {
                this.q.a(guiGraphics, (Component) Component.literal("_"), vec2i.getX(), vec2i.getY(), 0);
            }
        }
    }

    private void a(GuiGraphics guiGraphics, a[] aVarArr, int i, int i2) {
    }

    @OnlyIn(Dist.CLIENT)
    private Vec2i a(Vec2i vec2i) {
        vec2i.set(vec2i.getX() - (v().a() + 1), vec2i.getY() - (v().b() + 1));
        return vec2i;
    }

    @OnlyIn(Dist.CLIENT)
    private Vec2i b(Vec2i vec2i) {
        vec2i.set(vec2i.getX() + v().a() + 1, vec2i.getY() + v().b() + 1);
        return vec2i;
    }

    @OnlyIn(Dist.CLIENT)
    private a a(String str, StringSplitter stringSplitter, int i, int i2, int i3, int i4) {
        return new a(b(new Vec2i((int) stringSplitter.stringWidth(str.substring(i4, i)), i3)), b(new Vec2i((int) stringSplitter.stringWidth(str.substring(i4, i2)), i3 + 9)));
    }

    @OnlyIn(Dist.CLIENT)
    private a a(Vec2i vec2i, Vec2i vec2i2) {
        return new a(b(vec2i), b(vec2i2));
    }

    private int a(int[] iArr, int i) {
        int iBinarySearch = Arrays.binarySearch(iArr, i);
        return iBinarySearch < 0 ? -(iBinarySearch + 2) : iBinarySearch;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/y$c.class */
    public static class c {
        private static final c a = new c(Style.EMPTY, "", new Vec2i(0, 0));
        private final Style b;
        private final String c;
        private final Component d;
        private final int e;
        private final int f;

        public c(Style style, String str, Vec2i vec2i) {
            this.b = style;
            this.c = str;
            this.e = vec2i.getX();
            this.f = vec2i.getY();
            this.d = Component.literal(str).setStyle(style);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/y$b.class */
    class b {
        private String b = "";
        private Vec2i c = new Vec2i();
        private Vec2i d = new Vec2i();
        private boolean e = true;
        private int f = 0;
        private int g = 0;
        private int[] h = new int[1];
        private c[] i = {c.a};
        private a[] j = new a[0];

        b() {
        }

        public void a(String str, Vec2i vec2i, int i, int i2, boolean z, int[] iArr, c[] cVarArr, a[] aVarArr) {
            this.b = str;
            this.c.set(vec2i);
            this.d.set(vec2i);
            y.this.b(this.d);
            this.f = i;
            this.g = i2;
            this.e = z;
            this.h = iArr;
            this.i = cVarArr;
            this.j = aVarArr;
        }

        public void a() {
            this.b = "";
            this.c.set(0, 0);
            this.d.set(0, 0);
            y.this.b(this.d);
            this.f = 0;
            this.g = 0;
            this.e = true;
            this.h = new int[1];
            this.i = new c[]{c.a};
            this.j = new a[0];
        }

        public int a(Font font, Vec2i vec2i) {
            int y = vec2i.getY();
            Objects.requireNonNull(font);
            int i = (y / 9) + y.this.j;
            if (i < 0) {
                return 0;
            }
            if (i >= this.i.length) {
                return this.b.length();
            }
            return this.h[i] + font.getSplitter().plainIndexAtWidth(this.i[i].c, vec2i.getX(), this.i[i].b);
        }

        public int a(int i, int i2) {
            int iA = y.this.a(this.h, i);
            int i3 = iA + i2;
            if (0 <= i3 && i3 < this.h.length) {
                return this.h[i3] + Math.min(i - this.h[iA], this.i[i3].c.length());
            }
            return i;
        }

        public int a(int i) {
            return this.h[y.this.a(this.h, i)];
        }

        public int b(int i) {
            int iA = y.this.a(this.h, i);
            return this.h[iA] + this.i[iA].c.length();
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/y$a.class */
    public static class a {
        int a;
        int b;
        int c;
        int d;

        public a(Vec2i vec2i, Vec2i vec2i2) {
            this.a = vec2i.getX();
            this.b = vec2i.getY();
            this.c = vec2i2.getX() - this.a;
            this.d = vec2i2.getY() - this.b;
        }
    }
}
