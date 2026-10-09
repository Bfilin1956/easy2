package mctech.m.b;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import mctech.MCTech;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0089b;
import mctech.components.a.C0097j;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.PacketDistributor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/Z.class */
public class Z extends AbstractC0115i<mctech.blockentities.c.F> {

    /* JADX INFO: renamed from: mctech.m.b.Z$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/Z$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[MachineTier.values().length];

        static {
            try {
                a[MachineTier.T5.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[MachineTier.T6.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[MachineTier.T7.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public Z(mctech.blockentities.c.F f, Player player, int i) {
        int i2;
        int i3;
        super(f, player, i);
        switch (AnonymousClass1.a[f.machineTier().ordinal()]) {
            case 1:
                i2 = 69;
                break;
            case 2:
                i2 = 45;
                break;
            default:
                i2 = 24;
                break;
        }
        int i4 = i2;
        mctech.utils.math.geometry.b bVar = new mctech.utils.math.geometry.b(i4, 46, 40 * f.a(), 19);
        for (int i5 = 0; i5 < f.a(); i5++) {
            int i6 = i5 * 3;
            addSlot(new mctech.m.g.g(f, i6, i4, 26, new mctech.m.c.a.g(f)));
            addSlot(mctech.m.g.g.d(f, i6 + 1, i4, 69));
            addSlot(mctech.m.g.g.d(f, i6 + 2, i4, 93));
            i4 += f.machineTier() == MachineTier.T7 ? 23 : 24;
        }
        List<Integer> listB = f.f.b(mctech.m.e.k.c);
        for (int i7 = 0; i7 < listB.size(); i7++) {
            addSlot(new mctech.r.a.e(f, listB.get(i7).intValue(), f.machineTier() == MachineTier.T7 ? 238 : 192, 20 + (i7 * 17)));
        }
        Inventory inventory = player.getInventory();
        switch (AnonymousClass1.a[f.machineTier().ordinal()]) {
            case 1:
            case 2:
                i3 = 21;
                break;
            case 3:
                i3 = 44;
                break;
            default:
                i3 = 0;
                break;
        }
        addPlayerInventoryAt(inventory, i3, 137);
        getComponents().clear();
        addComponent(new mctech.components.b.m(new mctech.utils.math.geometry.b(69, 46, 16, 19), f, new Vec2i(239, 236), f.machineTier() == MachineTier.T7 ? 23 : 24, true));
        if (f.machineTier() == MachineTier.T7) {
            addComponent(new mctech.components.b.c(new mctech.utils.math.geometry.b(44, 114, 5, 7), f, new Vec2i(233, 248), true));
            addComponent(new mctech.components.b.c(new mctech.utils.math.geometry.b(52, 116, 151, 3), f, new Vec2i(81, 252), false));
        } else {
            addComponent(new mctech.components.b.c(new mctech.utils.math.geometry.b(101, 121, 5, 7), f, new Vec2i(233, 248), true));
            addComponent(new mctech.components.b.c(new mctech.utils.math.geometry.b(58, 116, 86, 3), f, new Vec2i(146, 252), false));
        }
        addComponent(new mctech.components.a.u(f, 3, 17, f).a(EnumSet.allOf(mctech.components.a.u.a.class)));
        addComponent(new mctech.components.a.H(f, 3, 28, f));
        addComponent(new C0097j(this, 3, 39, f));
        mctech.utils.s sorter = f.getSorter();
        Objects.requireNonNull(sorter);
        addComponent(new C0089b(3, 57, sorter::a).a(c0089b -> {
            PacketDistributor.sendToServer(new mctech.q.d.a.a.C0034a(f.getBlockPos(), 150, 0), new CustomPacketPayload[0]);
        }));
        addComponent(new mctech.components.b.e(f, bVar));
    }

    @Override // mctech.components.AbstractC0115i, mctech.components.ContainerComponent
    public Vec2i getInfoGuiSize() {
        return new Vec2i(189, 47);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("textures/gui/container/t%s/gui_ore_macerator_t%s.png", ((mctech.blockentities.c.F) getHolder()).machineTier().asIntegerString(), ((mctech.blockentities.c.F) getHolder()).machineTier().asIntegerString()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(((mctech.blockentities.c.F) getHolder()).machineTier() == MachineTier.T7 ? 254 : 208);
        bVar.f(aI.f);
    }
}
