package mctech.m.b;

import java.util.EnumSet;
import mctech.blockentities.BasicMachineTileEntity;
import mctech.components.ContainerComponent;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0097j;
import mctech.components.a.C0101n;
import mctech.components.a.InterfaceC0102o;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/k.class */
public class C0151k extends ContainerComponent<BasicMachineTileEntity> {
    public static final Vec2i a = new Vec2i(176, 0);
    public static final mctech.utils.math.geometry.b b = new mctech.utils.math.geometry.b(56, 36, 14, 14);
    public static final Vec2i c = new Vec2i(176, 14);
    public static final mctech.utils.math.geometry.b d = new mctech.utils.math.geometry.b(79, 34, 24, 16);
    public static final mctech.utils.math.geometry.b e = new mctech.utils.math.geometry.b(0, 0, 16, 16);

    public C0151k(BasicMachineTileEntity basicMachineTileEntity, Player player, int i) {
        super(basicMachineTileEntity, player, i);
        addSlot(new mctech.m.g.g(basicMachineTileEntity, 1, 92, 40, itemStack -> {
            ItemStack itemStackCopy = itemStack.copy();
            itemStackCopy.setCount(itemStackCopy.getMaxStackSize());
            return basicMachineTileEntity.getRecipeFor(itemStackCopy).isPresent();
        }));
        addSlot(new mctech.m.g.B(basicMachineTileEntity, 2, 136, 40));
        for (int i2 = 0; i2 < 4; i2++) {
            addSlot(new mctech.m.g.z(basicMachineTileEntity, 3 + i2, 234, 19 + (i2 * 19)));
        }
        addPlayerInventoryAt(player.getInventory(), 42, 110);
        getComponents().clear();
        InterfaceC0102o interfaceC0102o = () -> {
            return 2;
        };
        addComponent(new C0093f(85, 78, basicMachineTileEntity, interfaceC0102o));
        addComponent(new C0095h(119, 86, basicMachineTileEntity, interfaceC0102o));
        addComponent(new C0097j(this, interfaceC0102o));
        addComponent(new mctech.components.a.H(basicMachineTileEntity, interfaceC0102o).d("gui.mctech.inventory.button"));
        addComponent(new mctech.components.a.u(basicMachineTileEntity, interfaceC0102o).a(EnumSet.of(mctech.components.a.u.a.ENERGY_STORAGE, mctech.components.a.u.a.ENERGY_INPUT, mctech.components.a.u.a.OPERATION_TIME, mctech.components.a.u.a.OPERATION_COST)));
        addComponent(new mctech.components.b.o(basicMachineTileEntity.getProgressPosition(), basicMachineTileEntity, basicMachineTileEntity.getProgressOffset(), false).a(C0101n.b.a()).a(true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((BasicMachineTileEntity) getHolder()).machineTier());
    }

    @Override // mctech.m.b.S
    protected boolean moveItemStackTo(ItemStack itemStack, int i, int i2, boolean z) {
        if (getHolder() instanceof mctech.blockentities.c.R) {
            return moveItemStackToPriorizeUpgradeSlots(itemStack, i, i2, z);
        }
        return super.moveItemStackTo(itemStack, i, i2, z);
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
