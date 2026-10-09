package mctech.m.b;

import java.util.function.Supplier;
import mctech.components.ContainerComponent;
import mctech.components.a.C0094g;
import mctech.components.a.C0097j;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/n.class */
public class C0154n extends ContainerComponent<mctech.blockentities.c> {
    public static final Vec2i a = new Vec2i(0, -11);

    public C0154n(mctech.blockentities.c cVar, Player player, int i) {
        super(cVar, player, i);
        this.addedPreviewer = true;
        addSlot(mctech.m.g.g.d(cVar, cVar.d, 0, 33, 60));
        addSlot(new mctech.m.g.z(cVar, 1, 107, 60));
        addSlot(new mctech.m.g.d(cVar, 2, 134, 60));
        addSlot(new mctech.m.g.d(cVar, 3, 161, 60));
        addPlayerInventoryWithOffset(player.getInventory(), 17, 11);
        addComponent(new C0097j(this, -11, 10, () -> {
            return cVar.c;
        }));
        addComponent(new C0094g(28, 27, 151, cVar, () -> {
            return cVar.c;
        }));
    }

    @Override // mctech.components.ContainerComponent
    public void addComponent(mctech.m.d.a.a aVar) {
        if (aVar instanceof mctech.components.b.d) {
            return;
        }
        super.addComponent(aVar);
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(210, 177);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, MachineTier.values()[((mctech.blockentities.c) getHolder()).c], (Supplier<String>) () -> {
            return "charge_plate";
        });
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getPreviewButtonOffset() {
        return a;
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterGuiSize() {
        return new Vec2i(133, 132);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterScrollOffset() {
        return new Vec2i(-13, -2);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterItemsOffset() {
        return new Vec2i(3, -2);
    }
}
