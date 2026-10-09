package mctech.m.b;

import java.util.function.Supplier;
import mctech.components.C0113g;
import mctech.components.ContainerComponent;
import mctech.components.a.C0094g;
import mctech.components.a.C0097j;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/o.class */
public class C0155o extends ContainerComponent<mctech.blockentities.d> {
    public C0155o(mctech.blockentities.d dVar, Player player, int i) {
        super(dVar, player, i);
        this.addedPreviewer = true;
        for (int i2 = 0; i2 < dVar.inventorySize; i2++) {
            addSlot(new mctech.m.g.g(dVar, i2, 33 + ((i2 % 8) * 21) + (i2 % 8 >= 4 ? 1 : 0), 92 + ((i2 / 8) * 21), dVar.a(i2)));
        }
        addPlayerInventoryWithOffset(player.getInventory(), 27, 82);
        for (int i3 = dVar.inventorySize; i3 < 24; i3++) {
            addComponent(new mctech.components.a.y(31 + ((i3 % 8) * 21) + (i3 % 8 >= 4 ? 1 : 0), 90 + ((i3 / 8) * 21)));
        }
        addComponent(new C0113g(dVar));
        addComponent(new C0097j(this, 0, 10, () -> {
            return dVar.e;
        }));
        addComponent(new C0094g(31, 64, 136, dVar, () -> {
            return dVar.e;
        }));
    }

    @Override // mctech.components.ContainerComponent
    public void addComponent(mctech.m.d.a.a aVar) {
        if ((aVar instanceof mctech.components.b.d) || (aVar instanceof mctech.components.b.g) || (aVar instanceof mctech.components.b.l)) {
            return;
        }
        super.addComponent(aVar);
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(aI.f, 248);
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, MachineTier.values()[((mctech.blockentities.d) this.gui).e], (Supplier<String>) () -> {
            return "charge_station";
        });
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterGuiSize() {
        return new Vec2i(122, 132);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterScrollOffset() {
        return new Vec2i(-2, -2);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterItemsOffset() {
        return new Vec2i(3, -2);
    }
}
