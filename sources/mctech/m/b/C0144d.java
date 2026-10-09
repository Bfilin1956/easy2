package mctech.m.b;

import java.util.EnumSet;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import mctech.MCTech;
import mctech.blockentities.c.C0055b;
import mctech.components.AbstractC0115i;
import mctech.components.a.C0089b;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
import mctech.components.a.C0101n;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.PacketDistributor;

/* JADX INFO: renamed from: mctech.m.b.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/d.class */
public class C0144d extends AbstractC0115i<C0055b> {
    public static final ResourceLocation a = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/components/info_combine.png");
    public Vec2i b;
    public mctech.utils.math.geometry.b c;
    public Vec2i d;
    public mctech.utils.math.geometry.b e;
    public Vec2i f;
    public mctech.utils.math.geometry.b g;
    public mctech.utils.math.geometry.b h;
    private final int[] i;

    public C0144d(C0055b c0055b, Player player, int i) {
        super(c0055b, player, i);
        this.i = new int[2];
        this.addedPreviewer = true;
        if (c0055b instanceof C0055b) {
            mctech.r.a.c cVarA = c0055b.a();
            mctech.r.a.d dVarE = c0055b.e();
            this.i[0] = c0055b.b()[0] + dVarE.k()[0];
            this.i[1] = c0055b.b()[1] + dVarE.k()[1];
            int[] iArr = {c0055b.f()[0] + dVarE.l()[0], c0055b.f()[1] + dVarE.l()[1]};
            int[] iArr2 = {81, 18};
            int[] iArr3 = {dVarE.h()[0], dVarE.h()[1]};
            int[] iArr4 = {dVarE.i()[0], dVarE.i()[1]};
            int[] iArr5 = {dVarE.e()[0], dVarE.e()[1]};
            int[] iArr6 = {dVarE.f()[0] + cVarA.n()[0], dVarE.f()[1] + cVarA.n()[1]};
            int[] iArr7 = {dVarE.j()[0], dVarE.j()[1]};
            if (cVarA == mctech.r.a.c.SINGULAR) {
                iArr3[0] = iArr3[0] - 11;
                iArr2 = new int[]{148, 18};
            }
            if (cVarA == mctech.r.a.c.QUANT && dVarE != mctech.r.a.d.ORE_MACERATOR) {
                iArr[1] = iArr[1] - 1;
            }
            if (cVarA == mctech.r.a.c.SINGULAR && (dVarE == mctech.r.a.d.ORE_COMBINE || dVarE == mctech.r.a.d.INGOT_FOUNDRY)) {
                iArr[1] = iArr[1] + 1;
            }
            if (cVarA == mctech.r.a.c.SINGULAR && dVarE == mctech.r.a.d.INGOT_FOUNDRY) {
                int[] iArr8 = this.i;
                iArr8[1] = iArr8[1] - 24;
            }
            if (dVarE == mctech.r.a.d.CONCENTRATOR) {
                if (cVarA == mctech.r.a.c.SINGULAR) {
                    this.i[1] = this.i[1] - 10;
                    iArr[1] = iArr[1] - 5;
                    iArr6[1] = iArr6[1] - 2;
                    iArr7[1] = iArr7[1] - 4;
                } else {
                    iArr2 = new int[]{80, 18};
                }
            } else if (dVarE == mctech.r.a.d.HYDRAULIC_WASHER) {
                iArr2 = new int[]{18, 60};
                if (cVarA == mctech.r.a.c.SINGULAR) {
                    iArr2 = new int[]{80, 18};
                    iArr3[0] = 27;
                    iArr3[1] = 92;
                    iArr4[0] = 142;
                    iArr4[1] = 92;
                    iArr[1] = iArr[1] + 20;
                    iArr7[1] = iArr7[1] + 20;
                    int[] iArr9 = this.i;
                    iArr9[1] = iArr9[1] - 20;
                } else if (cVarA == mctech.r.a.c.QUANT) {
                    iArr3[0] = 22;
                    iArr3[1] = 27;
                    iArr4[0] = 164;
                    iArr4[1] = 27;
                } else {
                    int[] iArr10 = this.i;
                    iArr10[1] = iArr10[1] - 3;
                    iArr3[0] = 44;
                    iArr3[1] = 27;
                    iArr4[0] = 142;
                    iArr4[1] = 27;
                }
            }
            this.g = new mctech.utils.math.geometry.b(cVarA.m()[0], cVarA.m()[1], 16, 19);
            this.h = new mctech.utils.math.geometry.b(cVarA.m()[0], cVarA.m()[1], 16 + ((c0055b.getSlots() != 9 ? 24 : 23) * (c0055b.getSlots() - 1)), 19);
            this.f = new Vec2i(239, 236);
            this.e = new mctech.utils.math.geometry.b(cVarA.k()[0] + iArr7[0], cVarA.k()[1] + iArr7[1], cVarA.j(), 3);
            this.d = new Vec2i((231 - cVarA.j()) + 1, 252);
            this.c = new mctech.utils.math.geometry.b(cVarA.l()[0] + iArr7[0], cVarA.l()[1] + iArr7[1], 5, 7);
            this.b = new Vec2i(233, 248);
            if (dVarE == mctech.r.a.d.INGOT_FOUNDRY) {
                this.d = new Vec2i((221 - cVarA.j()) + 1, 252);
                this.b = new Vec2i(229, 248);
                this.g = new mctech.utils.math.geometry.b(cVarA.m()[0] - 1, cVarA.m()[1], 20, 12);
                this.h = new mctech.utils.math.geometry.b(cVarA.m()[0] - 1, cVarA.m()[1], 20 + ((c0055b.getSlots() != 9 ? 24 : 23) * (c0055b.getSlots() - 1)), 12);
                this.f = new Vec2i(236, 243);
            }
            if (dVarE == mctech.r.a.d.CHEMICAL_PURIFICATING || dVarE == mctech.r.a.d.CONCENTRATOR) {
                this.g = new mctech.utils.math.geometry.b(cVarA.m()[0], cVarA.m()[1] + 22, 20, 19);
                this.h = new mctech.utils.math.geometry.b(cVarA.m()[0], cVarA.m()[1] + 22, 20 + ((c0055b.getSlots() != 9 ? 24 : 23) * (c0055b.getSlots() - 1)), 19);
            }
            AtomicInteger atomicInteger = new AtomicInteger();
            c0055b.c().forEach((iArr11, num) -> {
                for (int i2 = 0; i2 < num.intValue(); i2++) {
                    addSlot(new mctech.m.g.g(c0055b, atomicInteger.getAndIncrement(), iArr11[0] + iArr5[0] + (i2 * cVarA.f()), iArr11[1] + iArr5[1], new mctech.m.c.a.g(c0055b)));
                }
            });
            for (int i2 = 0; i2 < c0055b.d(); i2++) {
                for (int i3 = 0; i3 < cVarA.o(); i3++) {
                    addSlot(new mctech.m.g.B(c0055b, atomicInteger.getAndIncrement(), iArr6[0] + (i3 * cVarA.f()), iArr6[1] + (i2 * 24)));
                }
            }
            for (int i4 = 0; i4 < c0055b.upgradeSlots; i4++) {
                addSlot(new mctech.r.a.e(c0055b, atomicInteger.getAndIncrement(), cVarA.i()[0], cVarA.i()[1] + (i4 * 17)));
            }
            addPlayerInventoryWithOffset(player.getInventory(), iArr[0], iArr[1]);
            if ((c0055b.getSlots() == 9 && dVarE == mctech.r.a.d.ORE_COMBINE) || dVarE == mctech.r.a.d.HYDRAULIC_WASHER) {
                addComponent(new mctech.components.b.m(new mctech.utils.math.geometry.b(cVarA.m()[0] + 1, cVarA.m()[1], 194, 17), c0055b, new Vec2i(14 * cVarA.b().tierIndex(), 179), c0055b.getSlots() != 9 ? 24 : 23, true, C0101n.a.a()));
            } else {
                addComponent(new mctech.components.b.m(this.h, c0055b, this.f, c0055b.getSlots() != 9 ? 24 : 23, true));
            }
            addComponent(new mctech.components.b.c(this.c, c0055b, this.b, true));
            addComponent(new mctech.components.b.c(this.e, c0055b, this.d, false));
            addComponent(new mctech.components.a.u(c0055b, 3, 17, () -> {
                return cVarA.ordinal() + 4;
            }).a(EnumSet.allOf(mctech.components.a.u.a.class)));
            addComponent(new mctech.components.a.H(c0055b, 3, 28, () -> {
                return cVarA.ordinal() + 4;
            }));
            addComponent(new C0097j(this, 3, 39, () -> {
                return cVarA.ordinal() + 4;
            }));
            mctech.utils.s sorter = c0055b.getSorter();
            Objects.requireNonNull(sorter);
            addComponent(new C0089b(3, 57, sorter::a).a(c0089b -> {
                PacketDistributor.sendToServer(new mctech.q.d.a.a.C0034a(c0055b.getBlockPos(), 150, 0), new CustomPacketPayload[0]);
            }));
            addComponent(new mctech.components.b.e(c0055b, this.h));
            int[] iArr12 = iArr2;
            if (dVarE.g() > 0) {
                addComponent(new C0099l(c0055b, iArr3[0] - 1, iArr3[1] - 1, 0, c0055b.d, cVarA.b()).a(() -> {
                    return new Vec2i(iArr12[0], iArr12[1]);
                }).a());
            }
            if (dVarE.g() > 1) {
                addComponent(new C0099l(c0055b, iArr4[0] - 1, iArr4[1] - 1, 1, c0055b.e, cVarA.b()).a(true).a().a(() -> {
                    return new Vec2i(iArr12[0], iArr12[1]);
                }));
            }
        }
    }

    @Override // mctech.components.AbstractC0115i, mctech.components.ContainerComponent
    public Vec2i getInfoGuiSize() {
        return new Vec2i(189, 47);
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getInfoTexture() {
        return a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        MachineTier machineTierA = ((C0055b) getHolder()).a.a();
        return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, String.format("textures/gui/container/t%s/gui_%s_t%s.png", machineTierA.asIntegerString(), ((C0055b) getHolder()).e().c(), machineTierA.asIntegerString()));
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(this.i[0]);
        bVar.f(this.i[1]);
    }
}
