package mctech.m.b;

import mctech.blockentities.c.C0059f;
import mctech.components.ContainerComponent;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0097j;
import mctech.components.a.C0101n;
import mctech.components.a.InterfaceC0102o;
import mctech.init.MCTechItems;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/m.class */
public class C0153m extends ContainerComponent<C0059f> {
    public static final mctech.utils.math.geometry.b a = new mctech.utils.math.geometry.b(74, 35, 34, 16);
    public static final Vec2i b = new Vec2i(176, 14);
    public static final mctech.utils.math.geometry.b c = new mctech.utils.math.geometry.b(31, 27, 14, 14);
    public static final Vec2i d = new Vec2i(176, 0);

    public C0153m(C0059f c0059f, Player player, int i) {
        super(c0059f, player, i);
        addSlot(new mctech.m.g.g(c0059f, 1, 87, 67, itemStack -> {
            return itemStack.is(MCTechItems.TIN_CAN) || c0059f.a(itemStack, 1);
        }));
        addSlot(new mctech.m.g.g(c0059f, 2, 87, 29, itemStack2 -> {
            return c0059f.c(itemStack2) > 0 || c0059f.a(itemStack2, 0);
        }));
        addSlot(mctech.m.g.g.d(c0059f, 3, 137, 36));
        addSlot(mctech.m.g.g.d(c0059f, 4, 137, 64));
        for (int i2 = 0; i2 < 4; i2++) {
            addSlot(new mctech.m.g.z(c0059f, 5 + i2, 234, 19 + (i2 * 19)));
        }
        addPlayerInventoryAt(player.getInventory(), 42, 125);
        getComponents().clear();
        InterfaceC0102o interfaceC0102o = () -> {
            return 2;
        };
        addComponent(new C0093f(85, 93, c0059f, interfaceC0102o));
        addComponent(new C0095h(119, 101, c0059f, interfaceC0102o));
        addComponent(new C0097j(this, interfaceC0102o));
        addComponent(new mctech.components.a.H(c0059f, interfaceC0102o).d("gui.mctech.inventory.button"));
        addComponent(new mctech.components.a.u(c0059f, interfaceC0102o).a(mctech.components.a.u.a));
        addComponent(new mctech.components.b.o(93, 49, 35, 14, c0059f, 0, 94, false).a(C0101n.b.a()).a(true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, ((C0059f) getHolder()).machineTier());
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
