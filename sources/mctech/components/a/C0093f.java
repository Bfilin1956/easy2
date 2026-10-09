package mctech.components.a;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;
import mctech.api.tiles.readers.IEUStorage;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.components.a.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/f.class */
public class C0093f extends O {
    private final IEUStorage a;

    /* JADX WARN: Illegal instructions before constructor call */
    public C0093f(int i, int i2, IEUStorage iEUStorage, InterfaceC0102o interfaceC0102o) {
        Objects.requireNonNull(iEUStorage);
        Supplier supplier = iEUStorage::getStoredEU;
        Objects.requireNonNull(iEUStorage);
        super(i, i2, supplier, iEUStorage::getMaxEU, interfaceC0102o);
        this.a = iEUStorage;
    }

    @Override // mctech.components.a.O, mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (a(i, i2) && y()) {
            consumer.accept(c("gui.mctech.charge", mctech.utils.c.c.c.format(this.a.getStoredEU()), mctech.utils.c.c.c.format(this.a.getMaxEU())));
        }
    }
}
