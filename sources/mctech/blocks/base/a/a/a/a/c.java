package mctech.blocks.base.a.a.a.a;

import java.util.Objects;
import java.util.function.BooleanSupplier;
import mctech.api.tiles.readers.IWorkProvider;
import mctech.blockentities.q;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/a/a/c.class */
public class c extends mctech.blocks.base.a.a.a {
    BooleanSupplier f;
    int g;
    int h;

    public c(String str, Component component, BooleanSupplier booleanSupplier, int i, int i2) {
        super(str, component);
        this.f = booleanSupplier;
        this.g = Mth.clamp(i, 0, 15);
        this.h = Mth.clamp(i2, 0, 15);
    }

    public static c a(String str, Component component, IWorkProvider iWorkProvider) {
        Objects.requireNonNull(iWorkProvider);
        Objects.requireNonNull(iWorkProvider);
        return new c(str, component, iWorkProvider::isWorking, 0, 15);
    }

    public static c a(String str, Component component, q qVar) {
        Objects.requireNonNull(qVar);
        Objects.requireNonNull(qVar);
        return new c(str, component, qVar::isActive, 0, 15);
    }

    @Override // mctech.blocks.base.a.a.a
    protected int d() {
        return this.f.getAsBoolean() ? this.h : this.g;
    }
}
