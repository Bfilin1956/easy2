package mctech.g.a.j;

import mctech.g.a.c.c;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/j/c.class */
public abstract class c<U extends mctech.g.a.c.c> {
    private static final int e = 15;
    private static final int f = 24;
    protected static final int a = 16;
    protected static final int b = 18;
    protected static final int c = 162;
    protected static final int d = 100;

    protected abstract void b(b bVar, int i, int i2, a<U> aVar);

    @ApiStatus.Internal
    public void a(b bVar, int i, int i2, a<U> aVar) {
        b(bVar, i + e, i2 + f, aVar);
    }

    @ApiStatus.Internal
    public void a(a<U> aVar, GuiGraphics guiGraphics, Font font, int i, int i2, int i3, int i4) {
        a(aVar, guiGraphics, e, f, font, i, i2, i3, i4);
    }

    protected void a(a<U> aVar, GuiGraphics guiGraphics, int i, int i2, Font font, int i3, int i4, int i5, int i6) {
    }
}
