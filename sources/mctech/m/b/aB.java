package mctech.m.b;

import mctech.components.ContainerComponent;
import mctech.components.a.C0097j;
import mctech.components.a.C0100m;
import mctech.components.a.C0101n;
import mctech.components.a.InterfaceC0102o;
import mctech.integration.emi.plugin.base.EmiMachineRegistry;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/aB.class */
public class aB extends ContainerComponent<mctech.blockentities.c.ab> {
    public aB(mctech.blockentities.c.ab abVar, Player player, int i) {
        super(abVar, player, i);
        addSlot(mctech.m.g.g.a(abVar, 0, abVar.getFuelSlotPosition().getX(), abVar.getFuelSlotPosition().getY(), abVar.allowsLavaFuel()));
        addSlot(new mctech.m.g.g(abVar, 1, 91, 40, itemStack -> {
            return abVar.getRecipeFor(itemStack).isPresent();
        }));
        addSlot(new mctech.m.g.B(abVar, 2, 135, 40));
        addPlayerInventoryAt(player.getInventory(), 42, 107);
        getComponents().clear();
        InterfaceC0102o interfaceC0102o = () -> {
            return 0;
        };
        addComponent(new C0097j(this, interfaceC0102o));
        addComponent(new mctech.components.a.H(abVar, interfaceC0102o).d("gui.mctech.inventory.button"));
        addComponent(new mctech.components.a.u(abVar, interfaceC0102o).a(mctech.components.a.u.b));
        addComponent(new C0100m(abVar.getFuelActivityPosition().getX(), abVar.getFuelActivityPosition().getY(), abVar));
        addComponent(new mctech.components.b.o(abVar.getProgressPosition(), abVar, abVar.getProgressOffset(), false).a(C0101n.b.a()).c(() -> {
            return true;
        }).d(() -> {
            EmiMachineRegistry.displayRecipes("macerator");
            return true;
        }).a(true));
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, MachineTier.T1);
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(mctech.utils.c.h.i);
        bVar.f(222);
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
        return new Vec2i(198, 51);
    }
}
