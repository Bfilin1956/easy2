package mctech.m.b;

import mctech.MCTech;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0097j;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/av.class */
public class av extends AbstractC0115i<mctech.blockentities.c.V> {
    public av(mctech.blockentities.c.V v, Player player, int i) {
        super(v, player, i);
        addSlot(mctech.m.g.g.a((mctech.m.a.g) v, 0, 54, 60, false));
        addSlot(new mctech.m.g.g(v, 1, 38, 24, new mctech.m.c.m(v)));
        addSlot(new mctech.m.g.g(v, 2, 70, 24, new mctech.m.c.m(v)));
        addSlot(new mctech.m.g.B(v, 3, 130, 42));
        addPlayerInventoryAt(player.getInventory(), 22, 98);
        addComponent(new C0097j(this, 3, 20, () -> {
            return v.machineTier().ordinal();
        }).c(false));
        addComponent(new mctech.components.b.i(new mctech.utils.math.geometry.b(55, 43, 14, 14), v, new Vec2i(14, 181), true));
        addComponent(new mctech.components.b.o(new mctech.utils.math.geometry.b(94, 42, 22, 15), v, new Vec2i(30, 182), false).a(true).c(() -> {
            return true;
        }).d(() -> {
            EmiMachineRegistry.displayRecipes("alloy_smelter");
            return true;
        }));
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return MCTech.loc("textures/gui/container/t1/gui_alloy_smelter_t1.png");
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(190);
        bVar.f(180);
    }
}
