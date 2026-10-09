package mctech.m.b;

import java.util.EnumSet;
import mctech.api.tiles.ICustomContainer;
import mctech.blockentities.BasicMachineTileEntity;
import mctech.blockentities.c.C0075v;
import mctech.components.ContainerComponent;
import mctech.components.a.C0097j;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/M.class */
public class M extends ContainerComponent<BasicMachineTileEntity> implements ICustomContainer {
    private final C0075v g;
    public Vec2i a;
    public mctech.utils.math.geometry.b b;
    public Vec2i c;
    public mctech.utils.math.geometry.b d;
    public Vec2i e;
    public mctech.utils.math.geometry.b f;

    public M(C0075v c0075v, Player player, int i) {
        super(c0075v, player, i);
        this.g = c0075v;
        this.addedPreviewer = true;
        this.d = new mctech.utils.math.geometry.b(86, 79, 72, 5);
        this.c = new Vec2i(0, 251);
        this.b = new mctech.utils.math.geometry.b(50, 105, 5, 7);
        this.a = new Vec2i(230, 14);
        this.f = new mctech.utils.math.geometry.b(89, 41, 17, 14);
        this.e = new Vec2i(0, 237);
        addComponent(new mctech.components.b.c(this.d, c0075v, this.c, false));
        addComponent(new mctech.components.b.o(this.f, c0075v, this.e, false).a(false));
        addComponent(new mctech.components.a.u(c0075v, 0, 17, () -> {
            return 2;
        }).a(EnumSet.allOf(mctech.components.a.u.a.class)));
        addComponent(new mctech.components.a.H(c0075v, 0, 28, () -> {
            return 2;
        }));
        addComponent(new C0097j(this, 0, 39, () -> {
            return 2;
        }));
        addComponent(new mctech.components.b.e(c0075v, this.f));
        int i2 = 0 + 1;
        addSlot(new mctech.m.g.g(this, c0075v, 0, 68, 40, null) { // from class: mctech.m.b.M.1
            @Override // mctech.m.g.g
            public boolean mayPlace(ItemStack itemStack) {
                return C0075v.a.contains(itemStack.getItem());
            }
        });
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = i2;
            i2++;
            addSlot(new mctech.m.g.B(c0075v, i4, 110 + (i3 * 25), 40));
        }
        for (int i5 = 0; i5 < 4; i5++) {
            int i6 = i2;
            i2++;
            addSlot(new mctech.r.a.e(this, c0075v, i6, 236, 21 + (i5 * 19)) { // from class: mctech.m.b.M.2
                @Override // mctech.r.a.e, mctech.m.a.j
                public int o() {
                    return 12;
                }
            });
        }
        addPlayerInventoryWithOffset(player.getInventory(), 34, 26);
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, MachineTier.T3);
    }

    @Override // mctech.components.ContainerComponent, mctech.m.b.S
    public int getInventorySize() {
        return super.getInventorySize();
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(252);
        bVar.f(192);
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

    @Override // mctech.api.tiles.ICustomContainer
    public Vec2i getFilterButtonCords() {
        return new Vec2i(3, 39);
    }
}
