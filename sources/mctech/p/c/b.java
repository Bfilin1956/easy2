package mctech.p.c;

import dev.emi.emi.api.widget.Bounds;
import dev.emi.emi.api.widget.Widget;
import dev.emi.emi.screen.WidgetGroup;
import mctech.integration.emi.plugin.base.IEmiWidgetEventListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/c/b.class */
public class b extends Widget implements IEmiWidgetEventListener {
    protected static final float a = 3.5f;
    private static final float b = 0.5f;
    private static final float c = 0.1f;
    private static final float d = 2.0f;
    private static final float e = 20.0f;
    private final d f;
    private float j;
    private float k;
    private final float p;
    private final Bounds q;
    private final Vector3f g = new Vector3f();
    private float h = e;
    private float i = 30.0f;
    private boolean l = false;
    private int m = 0;
    private int n = 0;
    private int o = -1;

    public b(int i, int i2, int i3, int i4, @NotNull mctech.p.a.d dVar) {
        this.q = new Bounds(i, i2, i3, i4);
        f fVar = new f();
        dVar.a(cVar -> {
            fVar.a(new BlockPos(cVar.b(), cVar.c(), cVar.d()), cVar.g().get().defaultBlockState());
        });
        Vector3f vector3fB = fVar.b();
        float fMax = Math.max(Math.max(vector3fB.x, vector3fB.y), vector3fB.z);
        this.p = ((a * ((float) Math.sqrt(fMax))) * ((float) (1.0d + Math.log10(fMax)))) / 1.5f;
        this.j = this.p;
        this.k = this.p;
        this.f = new d(fVar);
        this.f.b();
        b();
    }

    public Bounds getBounds() {
        return this.q;
    }

    public void render(GuiGraphics guiGraphics, int i, int i2, float f) {
    }

    @Override // mctech.integration.emi.plugin.base.IEmiWidgetEventListener
    public void render(GuiGraphics guiGraphics, int i, int i2, float f, WidgetGroup widgetGroup) {
        if (Math.abs(this.j - this.k) > 0.01f) {
            this.j += (this.k - this.j) * c;
        } else {
            this.j = this.k;
        }
        guiGraphics.drawString(Minecraft.getInstance().font, String.format("Mx:%s, My:%s", Integer.valueOf(i), Integer.valueOf(i2)), 0, 0, -65536);
        guiGraphics.drawString(Minecraft.getInstance().font, String.format("AMX:%s, AMY:%s", Integer.valueOf(i - this.q.x()), Integer.valueOf(i2 - this.q.y())), 0, -9, -256);
        b();
        this.f.a(this.q.contains(i, i2));
        this.f.a(guiGraphics, widgetGroup.x() + this.q.x(), widgetGroup.y() + this.q.y(), this.q.width(), this.q.height(), i - this.q.x(), i2 - this.q.y());
        BlockHitResult blockHitResultG = this.f.g();
        if (blockHitResultG != null && blockHitResultG.getType() != HitResult.Type.MISS) {
            guiGraphics.drawString(Minecraft.getInstance().font, String.format("%s", blockHitResultG.getBlockPos().toShortString()), 0, -18, -256);
        }
    }

    @Override // mctech.integration.emi.plugin.base.IEmiWidgetEventListener
    public boolean mouseClicked(double d2, double d3, int i, Bounds bounds) {
        if (this.q.contains((int) d2, (int) d3)) {
            this.l = true;
            this.m = (int) d2;
            this.n = (int) d3;
            this.o = i;
            return true;
        }
        return false;
    }

    @Override // mctech.integration.emi.plugin.base.IEmiWidgetEventListener
    public void mouseMoved(double d2, double d3, Bounds bounds) {
    }

    @Override // mctech.integration.emi.plugin.base.IEmiWidgetEventListener
    public boolean mouseReleased(double d2, double d3, int i, Bounds bounds) {
        if (this.l && i == this.o) {
            this.l = false;
            this.o = -1;
            return true;
        }
        return false;
    }

    @Override // mctech.integration.emi.plugin.base.IEmiWidgetEventListener
    public boolean mouseDragged(double d2, double d3, int i, double d4, double d5, Bounds bounds) {
        if (this.l && i == this.o) {
            int i2 = (int) d2;
            int i3 = (int) d3;
            int i4 = i2 - this.m;
            int i5 = i3 - this.n;
            if (i == 0) {
                this.h += i4 * b;
                this.i += i5 * b;
                this.i = Math.max(-89.9f, Math.min(89.9f, this.i));
                b();
            }
            this.m = i2;
            this.n = i3;
            return true;
        }
        return false;
    }

    @Override // mctech.integration.emi.plugin.base.IEmiWidgetEventListener
    public boolean mouseScrolled(double d2, double d3, double d4, double d5, Bounds bounds) {
        if (this.q.contains((int) d2, (int) d3)) {
            this.k = (float) Math.max(2.0d, Math.min(20.0d, ((double) this.k) - (d5 * 0.10000000149011612d)));
            return true;
        }
        return false;
    }

    private void b() {
        Vector3f vector3fB = this.f.f.b();
        Vector3f vector3fC = this.f.f.c();
        this.g.set(vector3fC.x + (vector3fB.x / d), vector3fC.y + (vector3fB.y / d), vector3fC.z + (vector3fB.z / d));
        this.f.a(this.g, this.j, Math.toRadians(this.i), Math.toRadians(this.h));
    }

    public void a() {
        this.h = e;
        this.i = 30.0f;
        this.k = this.p;
        this.j = this.p;
        b();
    }
}
