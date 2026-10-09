package mctech.components.b;

import java.util.Objects;
import java.util.Set;
import java.util.function.BooleanSupplier;
import mctech.api.tiles.readers.IWorkProvider;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/h.class */
public class h extends mctech.m.d.a.a {
    BooleanSupplier a;
    Vec2i b;

    public h(mctech.utils.math.geometry.b bVar, BooleanSupplier booleanSupplier, Vec2i vec2i) {
        super(bVar);
        this.a = booleanSupplier;
        this.b = vec2i;
    }

    public static h a(mctech.utils.math.geometry.b bVar, mctech.blockentities.q qVar, Vec2i vec2i) {
        Objects.requireNonNull(qVar);
        Objects.requireNonNull(qVar);
        return new h(bVar, qVar::isActive, vec2i);
    }

    public static h a(mctech.utils.math.geometry.b bVar, IWorkProvider iWorkProvider, Vec2i vec2i) {
        Objects.requireNonNull(iWorkProvider);
        Objects.requireNonNull(iWorkProvider);
        return new h(bVar, iWorkProvider::isWorking, vec2i);
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
    }

    @Override // mctech.m.d.a.a
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.a.getAsBoolean()) {
            this.q.b(guiGraphics, this.o.a() + this.q.getGuiLeft(), this.o.b() + this.q.getGuiTop(), this.b.getX(), this.b.getY(), this.o.d(), this.o.c());
        }
    }
}
