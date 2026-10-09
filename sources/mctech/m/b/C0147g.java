package mctech.m.b;

import mctech.MCTech;
import mctech.components.C0118l;
import mctech.components.C0119m;
import mctech.components.ContainerComponent;
import mctech.components.a.C0101n;
import mctech.utils.C0203e;
import mctech.utils.C0206h;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/g.class */
public class C0147g extends ContainerComponent<mctech.blockentities.b.a> {
    public static final ResourceLocation a = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/container/gui_solar_panel.png");
    public static final mctech.utils.math.geometry.b b = new mctech.utils.math.geometry.b(16, 38, 48, 16);
    public static final Vec2i c = new Vec2i(203, 164);
    public static final Vec2i d = new Vec2i(203, 190);
    public static final mctech.utils.math.geometry.b e = new mctech.utils.math.geometry.b(18, 11, 44, 18);
    public static final Vec2i f = new Vec2i(206, 116);

    public C0147g(mctech.blockentities.b.a aVar, Player player, int i) {
        super(aVar, player, i);
        for (int i2 = 0; i2 < aVar.i; i2++) {
            addSlot(new C0203e(aVar, i2, 80 + (i2 * 24), 67, C0206h.a));
            addComponent(new mctech.components.K(new mctech.utils.math.geometry.b(79 + (24 * i2), 66, 17, 17), i2, aVar));
        }
        addComponent(new C0119m(new mctech.utils.math.geometry.b(78, 22, 115, 10), aVar));
        addSlot(C0206h.a(aVar, aVar.i, 33, 64));
        addComponent(new mctech.components.L(aVar, b, c, d));
        addComponent(new C0118l(aVar));
        addComponent(new mctech.components.b.c(e, aVar, f, false));
        addPlayerInventoryWithOffset(player.getInventory(), 14, 18);
        addComponent(new mctech.components.P(aVar));
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return a;
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(204);
        bVar.f(184);
    }

    @Override // mctech.components.ContainerComponent
    public void addComponent(mctech.m.d.a.a aVar) {
        if (aVar instanceof mctech.components.b.g) {
            super.addComponent(new mctech.components.b.g(this, new Vec2i(-11, 12), new Vec2i(-15, -7)));
        } else {
            super.addComponent(aVar);
        }
    }

    @Override // mctech.components.ContainerComponent
    public Slot addSlot(Slot slot) {
        return super.addSlot(slot);
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getAtlasTexture() {
        return C0101n.a.a();
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterButtonTextureOffset() {
        return new Vec2i(20, 0);
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
