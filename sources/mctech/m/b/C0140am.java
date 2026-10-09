package mctech.m.b;

import java.util.List;
import mctech.MCTech;
import mctech.components.ContainerComponent;
import mctech.components.a.C0099l;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.am, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/am.class */
public class C0140am extends ContainerComponent<mctech.blockentities.b.g> implements mctech.o.g {
    public static final ResourceLocation a = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/container/t4/gui_reactor_planner.png");
    public static final int[][] b = {new int[]{4, 5, 6}, new int[]{4, 5, 6, 7}, new int[]{3, 4, 5, 6, 7}, new int[]{3, 4, 5, 6, 7, 8}, new int[]{2, 3, 4, 5, 6, 7, 8}, new int[]{2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
    private List<mctech.components.a.y> c;

    public C0140am(mctech.blockentities.b.g gVar, Player player, int i) {
        super(gVar, player, i);
        this.c = mctech.utils.a.b.i();
        this.addedPreviewer = true;
        for (int i2 = 0; i2 < 11; i2++) {
            for (int i3 = 0; i3 < 6; i3++) {
                mctech.components.a.y yVar = new mctech.components.a.y(40 + (i2 * 18), 45 + ((i3 % 6) * 18));
                this.c.add(yVar);
                addComponent(yVar);
            }
        }
        for (int i4 = 0; i4 < 66; i4++) {
            addSlot(new mctech.m.g.f(gVar.b, i4, 42 + ((i4 % 11) * 18), 47 + ((i4 / 11) * 18)));
        }
        addPlayerInventoryAt(player.getInventory(), 60, 170);
        addComponent(new mctech.components.E(gVar, this));
        addComponent(new mctech.components.F(gVar, this));
        addComponent(new C0099l(19, 89, gVar.f, () -> {
            return 4;
        }));
        c();
    }

    public void c() {
        for (int i = 0; i < 11; i++) {
            for (int i2 = 0; i2 < 6; i2++) {
                this.c.get((i * 6) + i2).a_(true);
            }
        }
        for (int i3 : b[((mctech.blockentities.b.g) this.gui).a]) {
            for (int i4 = 0; i4 < 6; i4++) {
                this.c.get((i3 * 6) + i4).a_(false);
            }
        }
    }

    @Override // mctech.components.ContainerComponent, mctech.m.b.S
    public int getInventorySize() {
        return 66;
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
        bVar.e(270);
        bVar.f(mctech.utils.c.h.i);
    }

    @Override // mctech.o.g
    public int a() {
        return mctech.q.c.c;
    }

    @Override // mctech.o.g
    public int b() {
        return mctech.utils.c.h.i;
    }
}
