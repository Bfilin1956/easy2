package mctech.m.b;

import mctech.blockentities.StoneBasicMachineTileEntity;
import mctech.components.ContainerComponent;
import mctech.components.a.C0097j;
import mctech.components.a.C0100m;
import mctech.components.a.C0101n;
import mctech.components.a.InterfaceC0102o;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/l.class */
public class C0152l extends ContainerComponent<StoneBasicMachineTileEntity> {
    public static final Vec2i a = new Vec2i(176, 0);
    public static final mctech.utils.math.geometry.b b = new mctech.utils.math.geometry.b(56, 36, 14, 14);
    public static final Vec2i c = new Vec2i(176, 14);
    public static final mctech.utils.math.geometry.b d = new mctech.utils.math.geometry.b(79, 34, 24, 16);

    public C0152l(StoneBasicMachineTileEntity stoneBasicMachineTileEntity, Player player, int i) {
        super(stoneBasicMachineTileEntity, player, i);
        addSlot(mctech.m.g.g.a(stoneBasicMachineTileEntity, 0, stoneBasicMachineTileEntity.getFuelSlotPosition().getX(), stoneBasicMachineTileEntity.getFuelSlotPosition().getY(), stoneBasicMachineTileEntity.allowsLavaFuel()));
        addSlot(new mctech.m.g.g(stoneBasicMachineTileEntity, 1, 91, 40, itemStack -> {
            return stoneBasicMachineTileEntity.getRecipeFor(itemStack).isPresent();
        }));
        addSlot(new mctech.m.g.B(stoneBasicMachineTileEntity, 2, 135, 40));
        addPlayerInventoryAt(player.getInventory(), 42, 107);
        getComponents().clear();
        InterfaceC0102o interfaceC0102o = () -> {
            return 0;
        };
        addComponent(new C0097j(this, interfaceC0102o));
        addComponent(new mctech.components.a.H(stoneBasicMachineTileEntity, interfaceC0102o).d("gui.mctech.inventory.button"));
        addComponent(new mctech.components.a.u(stoneBasicMachineTileEntity, interfaceC0102o).a(mctech.components.a.u.b));
        addComponent(new C0100m(stoneBasicMachineTileEntity.getFuelActivityPosition().getX(), stoneBasicMachineTileEntity.getFuelActivityPosition().getY(), stoneBasicMachineTileEntity));
        addComponent(new mctech.components.b.o(stoneBasicMachineTileEntity.getProgressPosition(), stoneBasicMachineTileEntity, stoneBasicMachineTileEntity.getProgressOffset(), false).a(C0101n.b.a()).a(true));
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
