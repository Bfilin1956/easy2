package mctech.m.b;

import mctech.MCTech;
import mctech.components.C0116j;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/x.class */
public class C0164x extends P<mctech.m.f.b> {
    public C0164x(mctech.m.f.b bVar, Player player, int i, int i2) {
        super(bVar, player, i, i2);
        addHiddenPlayerInventory(player.getInventory());
        addComponent(new C0116j(bVar));
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        super.onGuiLoaded(bVar);
        bVar.d(70, 43);
        bVar.c(1);
        bVar.c(2);
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return MCTech.loc("textures/gui/container/gui_electric_reader.png");
    }

    @Override // mctech.m.b.P, mctech.components.ContainerComponent, mctech.m.b.S
    public int getInventorySize() {
        return 0;
    }
}
