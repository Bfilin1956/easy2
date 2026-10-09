package mctech.m.b;

import mctech.components.AbstractC0115i;
import mctech.components.a.C0097j;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/ay.class */
public class ay extends AbstractC0115i<mctech.blockentities.c.Y> implements mctech.o.f {
    public ay(mctech.blockentities.c.Y y, Player player, int i) {
        super(y, player, i);
        player.level();
        addSlot(mctech.m.g.g.a(y, 0, 56 + 14, 53 + 7, y.allowsLavaFuel()));
        addSlot(new mctech.m.g.g(y, 1, 56 + 14, 17 + 7, new mctech.m.c.m(y)));
        addSlot(new mctech.m.g.B(y, 2, 116 + 14, 35 + 7));
        addPlayerInventoryWithOffset(player.getInventory(), 14, 14);
        getComponents().clear();
        addComponent(new mctech.components.b.i(new mctech.utils.math.geometry.b(70, 42, 14, 14), y, new Vec2i(14, 181), true));
        addComponent(new mctech.components.b.o(new mctech.utils.math.geometry.b(93, 41, 24, 17), y, new Vec2i(29, 181), false).a(true).c(() -> {
            return true;
        }).d(() -> {
            EmiMachineRegistry.displayRecipes("compressor");
            return true;
        }));
        addComponent(new mctech.components.a.H(y, 3, 39, b().e()).d("gui.mctech.inventory.button"));
        addComponent(new C0097j(this, 3, 20, b().e()).d("gui.mctech.filter.button").c(false));
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(@NotNull mctech.m.d.b bVar) {
        bVar.e(190, 180);
        bVar.c(3);
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, MachineTier.T1);
    }

    @Override // mctech.o.f
    @NotNull
    public mctech.i.a b() {
        return mctech.i.a.COMPOSITE;
    }
}
