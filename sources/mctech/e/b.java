package mctech.e;

import javax.annotation.Nonnull;
import mctech.init.MCTechDataComponent;
import mctech.items.f;
import mctech.items.g;
import mctech.modules.h;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/e/b.class */
public class b extends mctech.items.base.b {
    private final f d;
    private final g e;

    public b(@Nonnull ItemStack itemStack, @Nonnull f fVar) {
        super(itemStack, fVar);
        this.d = fVar;
        this.e = new g(itemStack, MCTechDataComponent.AE2_CELLS.get(), ((f.a) h.a().a(fVar)).b());
    }

    @Override // mctech.items.base.b
    @Nonnull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public f e() {
        return this.d;
    }

    public g b() {
        return this.e;
    }
}
