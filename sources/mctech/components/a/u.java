package mctech.components.a;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.api.energy.tile.IMultiEnergySource;
import mctech.api.tiles.IMachineInfo;
import mctech.api.tiles.readers.IEUProducer;
import mctech.api.tiles.readers.IEUStorage;
import mctech.api.tiles.readers.IFuelStorage;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/u.class */
public class u<TE> extends M<u<TE>> {
    public static final EnumSet<a> a = EnumSet.of(a.ENERGY_STORAGE, a.ENERGY_INPUT, a.OPERATION_TIME, a.OPERATION_COST);
    public static final EnumSet<a> b = EnumSet.of(a.FUEL_STORAGE, a.OPERATION_TIME, a.OPERATION_COST);
    public static final EnumSet<a> c = EnumSet.of(a.ENERGY_STORAGE, a.ENERGY_OUTPUT);
    private final TE d;
    private final C0101n e;
    private boolean f;
    private EnumSet<a> g;
    private Supplier<Vec2i> h;
    private Supplier<Integer> i;
    private List<Supplier<Component>> j;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/u$a.class */
    public enum a {
        ENERGY_INPUT,
        ENERGY_OUTPUT,
        ENERGY_STORAGE,
        OPERATION_TIME,
        OPERATION_COST,
        HEAT_LEVEL,
        HEAT_EXPLOSION,
        HEAT_DAMAGE,
        FUEL_STORAGE,
        GENERATOR_INFO
    }

    public u(TE te, @NotNull InterfaceC0102o interfaceC0102o) {
        this(te, 1, 18, interfaceC0102o);
    }

    public u(TE te, int i, int i2, @NotNull InterfaceC0102o interfaceC0102o) {
        this(te, new C0101n(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/filter_atlas.png"), mctech.utils.c.h.i, mctech.utils.c.h.i), i, i2, interfaceC0102o);
    }

    public u(TE te, C0101n c0101n, @NotNull InterfaceC0102o interfaceC0102o) {
        this(te, c0101n, 1, 18, interfaceC0102o);
    }

    public u(TE te, C0101n c0101n, int i, int i2, @NotNull InterfaceC0102o interfaceC0102o) {
        super(i, i2, C0101n.a.b, C0101n.a.c, interfaceC0102o);
        this.d = te;
        this.e = c0101n;
        this.g = EnumSet.noneOf(a.class);
        this.h = () -> {
            return Vec2i.ZERO;
        };
        this.i = null;
        this.j = new ArrayList();
        a((R.d) m -> {
            this.f = !this.f;
        });
    }

    public u<TE> a(EnumSet<a> enumSet) {
        this.g = enumSet;
        return this;
    }

    public u<TE> a(Supplier<Integer> supplier) {
        this.i = supplier;
        return this;
    }

    public u<TE> b(Supplier<Vec2i> supplier) {
        this.h = supplier;
        return this;
    }

    public u<TE> c(Supplier<Component> supplier) {
        this.j.add(supplier);
        return this;
    }

    @Override // mctech.components.a.R, mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        super.a(set);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND_PRE);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.KEY_INPUT);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean b_(int i) {
        if (this.f && i == 256) {
            this.f = false;
        }
        return super.b_(i);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void b(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (!this.f) {
            return;
        }
        guiGraphics.pose().pushPose();
        this.q.c(this.e.a());
        int iA = a(6);
        int iIntValue = this.i == null ? 176 : this.i.get().intValue();
        new mctech.m.d.a.c(new mctech.utils.math.geometry.b((((this.q.width / 2) - (iIntValue / 2)) - (this.o.d() / 2)) + this.h.get().getX(), (this.q.getGuiTop() - iA) + this.h.get().getY(), iIntValue, iA + 16), new mctech.m.d.a.c.a(4, new Vec2i(69, 0)), this.e).a(guiGraphics);
        this.q.c();
        guiGraphics.pose().popPose();
    }

    @Override // mctech.components.a.R, mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        super.a(guiGraphics, i, i2, f);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        if (!this.f) {
            return;
        }
        int iA = a(6);
        int iIntValue = this.i == null ? 176 : this.i.get().intValue();
        int y = (-iA) + 4 + this.h.get().getY();
        int xSize = ((this.q.getXSize() / 2) - (iIntValue / 2)) + 4 + this.h.get().getX();
        if (!f()) {
            a(guiGraphics, (Component) Component.literal("Дополнительной информации нет"), xSize, y + (6 / 2), 6);
            return;
        }
        for (a aVar : this.g) {
            if (aVar == a.ENERGY_INPUT) {
                TE te = this.d;
                if (te instanceof IMachineInfo) {
                    IMachineInfo iMachineInfo = (IMachineInfo) te;
                    if (iMachineInfo.getMaxInput() > 0) {
                        int i3 = y + 6;
                        y = i3;
                        a(guiGraphics, (Component) Component.literal("Максимальный вход: " + iMachineInfo.getMaxInput() + " EU/t"), xSize, i3, 6);
                    }
                }
            }
            if (aVar == a.ENERGY_OUTPUT) {
                TE te2 = this.d;
                if (te2 instanceof IMachineInfo) {
                    IMachineInfo iMachineInfo2 = (IMachineInfo) te2;
                    if (iMachineInfo2.getMaxEnergyOutput() > 0) {
                        int i4 = y + 6;
                        y = i4;
                        a(guiGraphics, (Component) Component.literal("Максимальный выход: " + iMachineInfo2.getMaxEnergyOutput() + " EU/t"), xSize, i4, 6);
                    }
                }
            }
            if (aVar == a.ENERGY_STORAGE) {
                TE te3 = this.d;
                if (te3 instanceof IMachineInfo) {
                    IMachineInfo iMachineInfo3 = (IMachineInfo) te3;
                    if (iMachineInfo3.getStoredLongEU() > 0 && iMachineInfo3.getMaxLongEU() > 0) {
                        long storedLongEU = iMachineInfo3.getStoredLongEU();
                        iMachineInfo3.getMaxLongEU();
                        int i5 = y + 6;
                        y = i5;
                        a(guiGraphics, (Component) Component.literal("Буфер: " + storedLongEU + "/" + this), xSize, i5, 6);
                    }
                }
            }
            if (aVar == a.OPERATION_TIME) {
                TE te4 = this.d;
                if (te4 instanceof IMachineInfo) {
                    IMachineInfo iMachineInfo4 = (IMachineInfo) te4;
                    if (iMachineInfo4.getOperationTime() > 0) {
                        int i6 = y + 6;
                        y = i6;
                        a(guiGraphics, (Component) Component.literal("Время операции: " + iMachineInfo4.getOperationTime() + " t"), xSize, i6, 6);
                    }
                }
            }
            if (aVar == a.OPERATION_COST) {
                TE te5 = this.d;
                if (te5 instanceof IMachineInfo) {
                    IMachineInfo iMachineInfo5 = (IMachineInfo) te5;
                    if (iMachineInfo5.getEnergyPerTick() > 0) {
                        int i7 = y + 6;
                        y = i7;
                        a(guiGraphics, (Component) Component.literal("Стоимость операции: " + iMachineInfo5.getEnergyPerTick() + " EU"), xSize, i7, 6);
                    }
                }
            }
            if (aVar == a.HEAT_LEVEL) {
                TE te6 = this.d;
                if (te6 instanceof mctech.blockentities.h) {
                    mctech.blockentities.h hVar = (mctech.blockentities.h) te6;
                    int i8 = y + 6;
                    y = i8;
                    a(guiGraphics, (Component) Component.literal("Нагрев: " + hVar.heatLevel() + "/" + hVar.maxHeatLevel() + " тепла"), xSize, i8, 6);
                    if (hVar.f()) {
                        int i9 = y + 6;
                        y = i9;
                        a(guiGraphics, (Component) Component.literal("Критический уровень нагрева: " + hVar.overheatLevel() + " тепла"), xSize, i9, 6);
                    }
                }
            }
            if (aVar == a.HEAT_EXPLOSION) {
                TE te7 = this.d;
                if (te7 instanceof mctech.blockentities.h) {
                    mctech.blockentities.h hVar2 = (mctech.blockentities.h) te7;
                    if (hVar2.g()) {
                        int i10 = y + 6;
                        y = i10;
                        a(guiGraphics, (Component) Component.literal("Уровень нагрева при взрыве: " + hVar2.explosionLevel() + " тепла"), xSize, i10, 6);
                    }
                }
            }
            if (aVar == a.FUEL_STORAGE) {
                TE te8 = this.d;
                if (te8 instanceof IFuelStorage) {
                    IFuelStorage iFuelStorage = (IFuelStorage) te8;
                    int i11 = y + 6;
                    y = i11;
                    a(guiGraphics, (Component) Component.literal(String.format("Уровень топлива: %s/%s (%s%%)", Integer.valueOf(iFuelStorage.getFuel()), Integer.valueOf(iFuelStorage.getMaxFuel()), Integer.valueOf((int) ((iFuelStorage.getFuel() / iFuelStorage.getMaxFuel()) * 100.0f)))), xSize, i11, 6);
                }
            }
            if (aVar == a.GENERATOR_INFO) {
                TE te9 = this.d;
                if (te9 instanceof IEUStorage) {
                    IEUStorage iEUStorage = (IEUStorage) te9;
                    TE te10 = this.d;
                    if (te10 instanceof IEUProducer) {
                        IEUProducer iEUProducer = (IEUProducer) te10;
                        if (iEUStorage.getStoredEU() > 0 && iEUStorage.getMaxEU() > 0) {
                            int i12 = y + 6;
                            y = i12;
                            a(guiGraphics, (Component) Component.literal("Буфер: " + iEUStorage.getStoredEU() + "/" + iEUStorage.getMaxEU()), xSize, i12, 6);
                        }
                        if (iEUProducer.getEUProduction() > 0.0f) {
                            int i13 = y + 6;
                            y = i13;
                            a(guiGraphics, (Component) Component.literal("Генерация: " + iEUProducer.getEUProduction() + " EU/t"), xSize, i13, 6);
                        }
                        TE te11 = this.d;
                        if (te11 instanceof IMultiEnergySource) {
                            int i14 = y + 6;
                            y = i14;
                            a(guiGraphics, (Component) Component.literal("Выходные пакеты: " + ((IMultiEnergySource) te11).getPacketCount()), xSize, i14, 6);
                        }
                    }
                }
            }
        }
        for (Supplier<Component> supplier : this.j) {
            if (supplier.get() != null) {
                int i15 = y + 6;
                y = i15;
                a(guiGraphics, supplier.get(), xSize, i15, 6);
            }
        }
    }

    private int a(int i) {
        int i2 = 16;
        for (a aVar : this.g) {
            if (aVar == a.ENERGY_INPUT) {
                TE te = this.d;
                if ((te instanceof IMachineInfo) && ((IMachineInfo) te).getMaxInput() > 0) {
                    i2 += i;
                }
            }
            if (aVar == a.ENERGY_OUTPUT) {
                TE te2 = this.d;
                if ((te2 instanceof IMachineInfo) && ((IMachineInfo) te2).getMaxEnergyOutput() > 0) {
                    i2 += i;
                }
            }
            if (aVar == a.ENERGY_STORAGE) {
                TE te3 = this.d;
                if (te3 instanceof IMachineInfo) {
                    IMachineInfo iMachineInfo = (IMachineInfo) te3;
                    if (iMachineInfo.getStoredLongEU() > 0 && iMachineInfo.getMaxLongEU() > 0) {
                        i2 += i;
                    }
                }
            }
            if (aVar == a.OPERATION_TIME) {
                TE te4 = this.d;
                if ((te4 instanceof IMachineInfo) && ((IMachineInfo) te4).getOperationTime() > 0) {
                    i2 += i;
                }
            }
            if (aVar == a.OPERATION_COST) {
                TE te5 = this.d;
                if ((te5 instanceof IMachineInfo) && ((IMachineInfo) te5).getEnergyPerTick() > 0) {
                    i2 += i;
                }
            }
            if (aVar == a.HEAT_LEVEL) {
                TE te6 = this.d;
                if (te6 instanceof mctech.blockentities.h) {
                    i2 += i;
                    if (((mctech.blockentities.h) te6).f()) {
                        i2 += i;
                    }
                }
            }
            if (aVar == a.HEAT_EXPLOSION) {
                TE te7 = this.d;
                if ((te7 instanceof mctech.blockentities.h) && ((mctech.blockentities.h) te7).g()) {
                    i2 += i;
                }
            }
            if (aVar == a.FUEL_STORAGE) {
                TE te8 = this.d;
                if (te8 instanceof IFuelStorage) {
                    i2 += i;
                }
            }
            if (aVar == a.GENERATOR_INFO) {
                TE te9 = this.d;
                if (te9 instanceof IEUStorage) {
                    IEUStorage iEUStorage = (IEUStorage) te9;
                    TE te10 = this.d;
                    if (te10 instanceof IEUProducer) {
                        IEUProducer iEUProducer = (IEUProducer) te10;
                        if (iEUStorage.getStoredEU() > 0 && iEUStorage.getMaxEU() > 0) {
                            i2 += i;
                        }
                        if (iEUProducer.getEUProduction() > 0.0f) {
                            i2 += i;
                        }
                        TE te11 = this.d;
                        if (te11 instanceof IMultiEnergySource) {
                            i2 += i;
                        }
                    }
                }
            }
        }
        Iterator<Supplier<Component>> it = this.j.iterator();
        while (it.hasNext()) {
            if (it.next().get() != null) {
                i2 += i;
            }
        }
        return i2;
    }

    private boolean f() {
        return (!this.g.isEmpty() && ((this.d instanceof IMachineInfo) || (this.d instanceof mctech.blockentities.h) || this.g.contains(a.GENERATOR_INFO))) || !this.j.isEmpty();
    }

    private void a(GuiGraphics guiGraphics, Component component, int i, int i2, int i3) {
        a(guiGraphics, component, i, i2, i3 / 10.0f);
    }

    private void a(GuiGraphics guiGraphics, Component component, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        poseStackPose.translate(i, i2, 1.0f);
        poseStackPose.scale(f, f, 1.0f);
        this.q.a(guiGraphics, component, 0, 0, -1);
        poseStackPose.popPose();
    }

    public boolean b() {
        return this.f;
    }

    public void a(boolean z) {
        this.f = z;
    }
}
