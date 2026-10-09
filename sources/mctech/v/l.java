package mctech.v;

import java.util.Objects;
import net.minecraft.Util;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/l.class */
public class l {
    public static void a(AbstractContainerScreen<?> abstractContainerScreen, GuiGraphics guiGraphics, Font font, Component component, int i, int i2, int... iArr) {
        c(guiGraphics, font, component, abstractContainerScreen.getGuiLeft(), abstractContainerScreen.getGuiTop(), i, i2, iArr);
    }

    public static void a(GuiGraphics guiGraphics, Font font, Component component, int i, int i2, int i3, int i4, int... iArr) {
        c(guiGraphics, font, component, i, i2, i3 - font.width(component), i4, iArr);
    }

    public static void b(GuiGraphics guiGraphics, Font font, Component component, int i, int i2, int i3, int i4, int... iArr) {
        c(guiGraphics, font, component, i, i2, i3 - (font.width(component) / 2), i4, iArr);
    }

    public static void c(GuiGraphics guiGraphics, Font font, Component component, int i, int i2, int i3, int i4, int... iArr) {
        if (iArr == null || iArr.length == 0 || iArr.length > 9) {
            guiGraphics.drawString(font, component, i3, i4, -1, false);
            return;
        }
        int iWidth = font.width(component);
        int[] iArr2 = new int[iArr.length];
        Objects.requireNonNull(font);
        float length = 9.0f / iArr.length;
        int i5 = 0;
        for (int i6 = 0; i6 < iArr.length - 1; i6++) {
            iArr2[i6] = Math.round(length);
            i5 += iArr2[i6];
        }
        int length2 = iArr.length - 1;
        Objects.requireNonNull(font);
        iArr2[length2] = 9 - i5;
        int i7 = i4;
        guiGraphics.pose().pushPose();
        for (int i8 = 0; i8 < iArr.length; i8++) {
            if (iArr2[i8] > 0) {
                try {
                    guiGraphics.enableScissor(i + i3, i2 + i7, i + i3 + iWidth, i2 + i7 + iArr2[i8]);
                    guiGraphics.drawString(font, component, i3, i4, iArr[i8], false);
                    guiGraphics.disableScissor();
                    i7 += iArr2[i8];
                } catch (Throwable th) {
                    guiGraphics.disableScissor();
                    throw th;
                }
            }
        }
        guiGraphics.pose().popPose();
    }

    public static void a(GuiGraphics guiGraphics, Font font, Component component, int i, int i2, int i3, int i4, int i5, int... iArr) {
        if (iArr == null || iArr.length == 0 || iArr.length > 9) {
            guiGraphics.drawString(font, component, i3, i4, -1, false);
            return;
        }
        int iWidth = font.width(component);
        if (iWidth <= i5) {
            c(guiGraphics, font, component, i, i2, i3, i4, iArr);
            return;
        }
        int[] iArr2 = new int[iArr.length];
        Objects.requireNonNull(font);
        float length = 9.0f / iArr.length;
        int i6 = 0;
        for (int i7 = 0; i7 < iArr.length - 1; i7++) {
            iArr2[i7] = Math.round(length);
            i6 += iArr2[i7];
        }
        int length2 = iArr.length - 1;
        Objects.requireNonNull(font);
        iArr2[length2] = 9 - i6;
        int iRound = (int) Math.round(((Math.sin((Util.getMillis() / 1000.0d) * 0.5d) + 1.0d) / 2.0d) * ((double) (Math.abs(iWidth - i5) + 20)));
        int i8 = i + i3;
        int i9 = i + i3 + i5;
        int i10 = i4;
        guiGraphics.pose().pushPose();
        for (int i11 = 0; i11 < iArr.length; i11++) {
            if (iArr2[i11] > 0) {
                try {
                    guiGraphics.enableScissor(i8, i2 + i10, i9, i2 + i10 + iArr2[i11]);
                    guiGraphics.drawString(font, component, i3 - iRound, i4, iArr[i11], false);
                    guiGraphics.disableScissor();
                    i10 += iArr2[i11];
                } catch (Throwable th) {
                    guiGraphics.disableScissor();
                    throw th;
                }
            }
        }
        guiGraphics.pose().popPose();
    }

    public static void a(AbstractContainerScreen<?> abstractContainerScreen, GuiGraphics guiGraphics, Font font, Component component, int i, int i2, int i3, int... iArr) {
        a(guiGraphics, font, component, abstractContainerScreen.getGuiLeft(), abstractContainerScreen.getGuiTop(), i, i2, i3, iArr);
    }

    public static void b(GuiGraphics guiGraphics, Font font, Component component, int i, int i2, int i3, int i4, int i5, int... iArr) {
        a(guiGraphics, font, component, i, i2, i3 - font.width(component), i4, i5, iArr);
    }

    public static void c(GuiGraphics guiGraphics, Font font, Component component, int i, int i2, int i3, int i4, int i5, int... iArr) {
        a(guiGraphics, font, component, i, i2, i3 - (font.width(component) / 2), i4, i5, iArr);
    }
}
