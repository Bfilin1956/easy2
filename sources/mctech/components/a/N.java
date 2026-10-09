package mctech.components.a;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import mctech.api.tiles.readers.IProgressMachine;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/N.class */
public class N extends mctech.m.d.a.a {
    private final C0101n a;
    private final InterfaceC0102o b;
    private final Supplier<Integer> c;
    private final Supplier<Integer> d;
    private float e;

    public N(int i, int i2, IProgressMachine iProgressMachine, InterfaceC0102o interfaceC0102o) {
        this(i, i2, () -> {
            return Integer.valueOf((int) iProgressMachine.getProgress());
        }, () -> {
            return Integer.valueOf((int) iProgressMachine.getMaxProgress());
        }, interfaceC0102o);
    }

    public N(int i, int i2, Supplier<Integer> supplier, Supplier<Integer> supplier2, InterfaceC0102o interfaceC0102o) {
        this(i, i2, supplier, supplier2, interfaceC0102o, C0101n.a);
    }

    public N(int i, int i2, Supplier<Integer> supplier, Supplier<Integer> supplier2, InterfaceC0102o interfaceC0102o, C0101n c0101n) {
        super(new mctech.utils.math.geometry.b(i, i2, C0101n.q.getX(), C0101n.q.getY()));
        this.a = c0101n;
        this.b = interfaceC0102o;
        this.c = supplier;
        this.d = supplier2;
        this.e = 0.0f;
    }

    public N a(float f) {
        this.e = f;
        return this;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
    }

    @OnlyIn(Dist.CLIENT)
    private boolean a() {
        return this.c.get().intValue() <= 0;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (a()) {
            return;
        }
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(this.q.getGuiLeft() + this.o.a() + (this.o.d() / 2), this.q.getGuiTop() + this.o.b() + (this.o.c() / 2), 0.0f);
        poseStackPose.mulPose(new Matrix4f().rotationZ((float) Math.toRadians(this.e)));
        poseStackPose.translate(-(this.q.getGuiLeft() + this.o.a() + (this.o.d() / 2)), -(this.q.getGuiTop() + this.o.b() + (this.o.c() / 2)), 0.0f);
        this.q.c(this.a.a());
        this.q.b(guiGraphics, this.q.getGuiLeft() + this.o.a(), this.q.getGuiTop() + this.o.b(), C0101n.a.s.getX() + (C0101n.q.getX() * this.b.tierIndex()), C0101n.a.s.getY(), this.o.d(), this.o.c() * Mth.clamp(this.c.get().intValue() / this.d.get().intValue(), 0.0f, 1.0f));
        this.q.c();
        poseStackPose.popPose();
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (a(i, i2) && y() && this.q.getSlotUnderMouse() == null) {
            consumer.accept(c("gui.mctech.progress", mctech.utils.c.c.c.format(this.c.get()), mctech.utils.c.c.c.format(this.d.get())));
        }
    }
}
