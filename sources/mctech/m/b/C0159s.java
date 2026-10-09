package mctech.m.b;

import mctech.MCTech;
import mctech.components.C0117k;
import mctech.components.ContainerComponent;
import mctech.components.a.C0094g;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/s.class */
public class C0159s extends ContainerComponent<mctech.blockentities.f> {
    public static final EquipmentSlot[] a = {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
    public static final ResourceLocation b = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/components/info_energy_storage.png");
    public static final Vec2i c = new Vec2i(143, 67);
    public static final Vec2i d = new Vec2i(154, 56);

    public C0159s(mctech.blockentities.f fVar, Player player, int i) {
        super(fVar, player, i);
        this.addedPreviewer = true;
        addSlot(mctech.m.g.g.c(fVar, fVar.a, 0, 57, 72));
        addSlot(mctech.m.g.g.d(fVar, fVar.a, 1, 165, 72));
        addPlayerInventoryWithOffset(player.getInventory(), 31, 24);
        addComponent(new C0117k(fVar));
        addComponent(new C0094g(26, 25, 185, fVar, () -> {
            return fVar.b();
        }));
        addComponent(new mctech.components.b.k(this, new Vec2i(238, -24), new Vec2i(-4, 5), false, false));
        addComponent(new mctech.components.b.g(this, new Vec2i(0, 25), new Vec2i(-4, 18)));
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        super.onGuiLoaded(bVar);
        bVar.c(1);
        bVar.c(2);
        bVar.e(238, 190);
    }

    @Override // mctech.components.ContainerComponent
    public void addComponent(mctech.m.d.a.a aVar) {
        if ((aVar instanceof mctech.components.b.l) || (aVar instanceof mctech.components.b.d)) {
            return;
        }
        super.addComponent(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((mctech.blockentities.f) getHolder()).machineTier());
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getInfoTexture() {
        return b;
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

    @Override // mctech.components.ContainerComponent
    public Vec2i getInfoGuiSize() {
        return new Vec2i(238, 31);
    }
}
