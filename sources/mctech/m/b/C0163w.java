package mctech.m.b;

import java.util.EnumSet;
import java.util.Objects;
import mctech.api.tiles.ICustomContainer;
import mctech.blockentities.BasicMachineTileEntity;
import mctech.blockentities.c.C0064k;
import mctech.components.ContainerComponent;
import mctech.components.a.C0089b;
import mctech.components.a.C0097j;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.mcskill.msregistry.slotcreator.SlotLayoutManager;
import net.mcskill.msregistry.slotcreator.api.Gravity;
import net.mcskill.msregistry.slotcreator.api.Orientation;
import net.mcskill.msregistry.slotcreator.layout.GridSlotLayout;
import net.mcskill.msregistry.slotcreator.layout.LinearSlotLayout;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.PacketDistributor;

/* JADX INFO: renamed from: mctech.m.b.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/w.class */
public class C0163w extends ContainerComponent<BasicMachineTileEntity> implements ICustomContainer {
    private final C0064k g;
    public Vec2i a;
    public mctech.utils.math.geometry.b b;
    public Vec2i c;
    public mctech.utils.math.geometry.b d;
    public Vec2i e;
    public mctech.utils.math.geometry.b f;

    public C0163w(C0064k c0064k, Player player, int i) {
        super(c0064k, player, i);
        this.g = c0064k;
        this.addedPreviewer = true;
        this.d = new mctech.utils.math.geometry.b(58, 107, 86, 3);
        this.c = new Vec2i(13, 215);
        this.b = new mctech.utils.math.geometry.b(50, 105, 5, 7);
        this.a = new Vec2i(230, 14);
        this.f = new mctech.utils.math.geometry.b(91, 50, 18, 14);
        this.e = new Vec2i(mctech.g.c.a.d.e, 14);
        addComponent(new mctech.components.b.c(this.b, c0064k, this.a, true));
        addComponent(new mctech.components.b.c(this.d, c0064k, this.c, false));
        addComponent(new mctech.components.b.o(this.f, c0064k, this.e, false));
        addComponent(new mctech.components.a.u(c0064k, 3, 17, () -> {
            return 6;
        }).a(EnumSet.allOf(mctech.components.a.u.a.class)));
        addComponent(new mctech.components.a.H(c0064k, 3, 28, () -> {
            return 6;
        }));
        addComponent(new C0097j(this, 3, 39, () -> {
            return 6;
        }));
        Objects.requireNonNull(c0064k);
        addComponent(new C0089b(3, 57, c0064k::a).a(c0089b -> {
            PacketDistributor.sendToServer(new mctech.q.d.a.a.C0034a(c0064k.getBlockPos(), 150, 0), new CustomPacketPayload[0]);
        }));
        addComponent(new mctech.components.b.e(c0064k, this.f));
        SlotLayoutManager slotLayoutManager = new SlotLayoutManager(this, 0);
        slotLayoutManager.add(new GridSlotLayout(23, 27, 3, 3, 9, 7, 7), (i2, i3, i4) -> {
            return new mctech.m.g.g(c0064k, i2, i3, i4, new mctech.m.c.m(c0064k));
        });
        slotLayoutManager.add(new GridSlotLayout(117, 27, 3, 3, 9, 7, 7), (i5, i6, i7) -> {
            return new mctech.m.g.B(c0064k, i5, i6, i7);
        });
        slotLayoutManager.add(new LinearSlotLayout(192, 20, 4, 10, 0, 7, Gravity.CENTER, Orientation.VERTICAL), (i8, i9, i10) -> {
            return new mctech.r.a.e(c0064k, i8, i9, i10);
        });
        addPlayerInventoryAt(player.getInventory(), 21, 128);
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, MachineTier.T6);
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
        bVar.e(208);
        bVar.f(210);
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
