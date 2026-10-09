package mctech.m.b;

import mctech.components.C0108b;
import mctech.components.ContainerComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/a.class */
public class C0127a extends ContainerComponent<mctech.blockentities.g.b> {
    public C0127a(mctech.blockentities.g.b bVar, Player player, int i) {
        super(bVar, player, i);
        addPlayerInventoryWithOffset(player.getInventory(), 17, 20);
        addComponent(new C0108b(bVar, mctech.m.a.a(this, bVar instanceof mctech.blockentities.g.c ? 9 : 6)));
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(210, 186);
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, getHolder() instanceof mctech.blockentities.g.c ? 9 : 6);
    }
}
