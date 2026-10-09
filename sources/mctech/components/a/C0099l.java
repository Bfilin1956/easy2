package mctech.components.a;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.api.network.tile.INetworkFluidTankFillListener;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.IFluidTank;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: mctech.components.a.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/l.class */
public class C0099l<TE extends BlockEntity, FH extends IFluidTank> extends mctech.m.d.a.a {
    private static final Component b = Component.translatable("gui.mctech.tank.no_fluid");
    private static final Component c = Component.translatable("gui.mctech.tank.clear_tank");
    public static final InterfaceC0102o a = () -> {
        return 7;
    };

    @Nullable
    private final TE d;

    @Nullable
    private final FH e;
    private final int f;
    private final InterfaceC0102o g;
    private final C0101n h;
    private Component i;

    @Nullable
    private Supplier<Vec2i> j;
    private Supplier<Boolean> k;
    private C0092e l;
    private boolean m;
    private Runnable n;
    private boolean s;
    private boolean t;
    private boolean u;

    public C0099l(TE te, mctech.utils.math.geometry.b bVar, int i, FH fh, InterfaceC0102o interfaceC0102o) {
        this(te, bVar.a(), bVar.b(), i, fh, interfaceC0102o);
        a(() -> {
            return new Vec2i(bVar.d(), bVar.c());
        });
    }

    public C0099l(mctech.utils.math.geometry.b bVar, FH fh, InterfaceC0102o interfaceC0102o) {
        this(bVar.a(), bVar.b(), fh, interfaceC0102o);
        a(() -> {
            return new Vec2i(bVar.d(), bVar.c());
        });
    }

    public C0099l(int i, int i2, FH fh, InterfaceC0102o interfaceC0102o) {
        this(null, i, i2, -1, fh, interfaceC0102o);
    }

    public C0099l(int i, int i2, FH fh, InterfaceC0102o interfaceC0102o, C0101n c0101n) {
        this(null, i, i2, -1, fh, interfaceC0102o, c0101n);
    }

    public C0099l(TE te, int i, int i2, int i3, FH fh, InterfaceC0102o interfaceC0102o) {
        this(te, i, i2, i3, fh, interfaceC0102o, C0101n.a);
    }

    public C0099l(@Nullable TE te, int i, int i2, int i3, FH fh, InterfaceC0102o interfaceC0102o, C0101n c0101n) {
        super(new mctech.utils.math.geometry.b(i, i2, C0101n.l.getX(), C0101n.l.getY()));
        this.k = () -> {
            return true;
        };
        this.h = c0101n;
        this.d = te;
        this.f = i3;
        this.g = interfaceC0102o;
        this.e = fh;
        this.i = f("gui.mctech.tank.simple");
    }

    public C0099l<TE, FH> a(Component component) {
        this.i = component;
        return this;
    }

    public C0099l<TE, FH> a(Supplier<Vec2i> supplier) {
        this.j = supplier;
        this.o = new mctech.utils.math.geometry.b(this.o.a(), this.o.b(), supplier.get().getX(), supplier.get().getY());
        return this;
    }

    public C0099l<TE, FH> b(Supplier<Boolean> supplier) {
        this.k = supplier;
        return this;
    }

    public C0099l<TE, FH> a() {
        return a(() -> {
            if (this.d != null && this.e.getFluidAmount() > 0) {
                PacketDistributor.sendToServer(new mctech.q.d.a.a.a(this.d.getBlockPos(), Math.max(this.f, 0)), new CustomPacketPayload[0]);
            } else {
                MCTech.LOGGER.warn("Cannot erase fluid, please provide tile holder in constructor");
            }
        });
    }

    public C0099l<TE, FH> a(Runnable runnable) {
        this.m = true;
        this.n = runnable;
        return this;
    }

    public C0099l<TE, FH> a(boolean z) {
        this.s = z;
        return this;
    }

    public C0099l<TE, FH> b(boolean z) {
        this.t = z;
        return this;
    }

    public C0099l<TE, FH> c(boolean z) {
        this.u = z;
        return this;
    }

    public int b() {
        return this.f;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
        set.add(mctech.m.d.a.a.EnumC0027a.KEY_INPUT);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        super.a(bVar);
        if (this.m && this.n != null) {
            this.l = (C0092e) new C0092e((this.o.a() + this.o.d()) - 7, (this.o.b() + this.o.c()) - 7, this.g).c(false).b(c).a(m -> {
                this.n.run();
            });
            this.l.d(bVar);
        }
    }

    @Override // mctech.m.d.a.a
    public boolean a(int i, int i2) {
        return this.l != null ? this.o.b(3, 3).a(i, i2) : super.a(i, i2);
    }

    @OnlyIn(Dist.CLIENT)
    private void a(GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        if (!this.k.get().booleanValue()) {
            return;
        }
        int i12 = i8 <= 18 ? 3 : 4;
        int i13 = i2 + (i8 / 2);
        guiGraphics.blit(this.h.a(), i + i10, i13, i5 - (i10 * 2), 1, i3 + i10, i4 + 30, i5 - (i10 * 2), 1, this.h.b(), this.h.c());
        int iMax = Math.max(i12, Math.min(15, i8 / 10));
        int i14 = i2 + (i8 < 18 ? iMax : 0);
        int i15 = (i2 + i8) - (i8 < 18 ? iMax : 0);
        for (int i16 = 1; i16 <= 10 / 2; i16++) {
            int i17 = i13 - (i16 * iMax);
            int i18 = i13 + (i16 * iMax);
            if (i17 > i14) {
                guiGraphics.blit(this.h.a(), i + i10, i17, i5 - (i10 * 2), 1, i3 + i10, i4 + 24, i5 - (i10 * 2), 1, this.h.b(), this.h.c());
            }
            if (i18 < i15) {
                guiGraphics.blit(this.h.a(), i + i10, i18, i5 - (i10 * 2), 1, i3 + i10, i4 + 24, i5 - (i10 * 2), 1, this.h.b(), this.h.c());
            }
        }
        if (i7 > i8 * 2) {
            guiGraphics.blit(this.h.a(), ((i + i7) - i10) - (i5 - (i10 * 2)), i13, i5 - (i10 * 2), 1, i3 + i10, i4 + 30, i5 - (i10 * 2), 1, this.h.b(), this.h.c());
            for (int i19 = 1; i19 <= 10 / 2; i19++) {
                int i20 = i13 - (i19 * iMax);
                int i21 = i13 + (i19 * iMax);
                if (i20 > i14) {
                    guiGraphics.blit(this.h.a(), ((i + i7) - i10) - 7, i20, 7, 1, i3 + i10, i4 + 24, 7, 1, this.h.b(), this.h.c());
                }
                if (i21 < i15) {
                    guiGraphics.blit(this.h.a(), ((i + i7) - i10) - 7, i21, 7, 1, i3 + i10, i4 + 24, 7, 1, this.h.b(), this.h.c());
                }
            }
        }
        guiGraphics.blit(this.h.a(), i, i2, i9, i9, i3, i4, i9, i9, this.h.b(), this.h.c());
        guiGraphics.blit(this.h.a(), i + i9, i2, i7 - (i9 * 2), i11, i3 + i9, i4, i5 - (i9 * 2), i11, this.h.b(), this.h.c());
        guiGraphics.blit(this.h.a(), (i + i7) - i9, i2, i9, i9, (i3 + i5) - i9, i4, i9, i9, this.h.b(), this.h.c());
        guiGraphics.blit(this.h.a(), (i + i7) - i10, i2 + i9, i10, i8 - (i9 * 2), (i3 + i5) - i10, i4 + i9, i10, i11, this.h.b(), this.h.c());
        guiGraphics.blit(this.h.a(), (i + i7) - i9, (i2 + i8) - i9, i9, i9, (i3 + i5) - i9, (i4 + i6) - i9, i9, i9, this.h.b(), this.h.c());
        guiGraphics.blit(this.h.a(), i + i9, (i2 + i8) - i11, i7 - (i9 * 2), i11, i3 + i9, (i4 + i6) - i11, i5 - (i9 * 2), i11, this.h.b(), this.h.c());
        guiGraphics.blit(this.h.a(), i, i2 + i9, i10, i8 - (i9 * 2), i3, i4 + i9, i10, i11, this.h.b(), this.h.c());
        guiGraphics.blit(this.h.a(), i, (i2 + i8) - i9, i9, i9, i3, (i4 + i6) - i9, i9, i9, this.h.b(), this.h.c());
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.k.get().booleanValue() && this.e != null) {
            if (this.e.getFluidAmount() != 0) {
                a(guiGraphics, this.q.getGuiLeft() + this.o.a() + 1, this.q.getGuiTop() + this.o.b() + 1, (this.j != null ? this.j.get().getX() : this.o.d()) - 2, (this.j != null ? this.j.get().getY() : this.o.c()) - 2, (this.e.getFluidAmount() / this.e.getCapacity()) * ((this.j != null ? this.j.get().getY() : this.o.c()) - 2.0f), this.e.getFluid());
            }
            this.q.c(this.h.a());
            Vec2i vec2i = new Vec2i(C0101n.a.n.getX() + (C0101n.l.getX() * this.g.tierIndex()), C0101n.a.n.getY());
            Vec2i vec2i2 = new Vec2i(this.q.getGuiLeft() + this.o.a(), this.q.getGuiTop() + this.o.b());
            if (!this.t) {
                a(guiGraphics, vec2i2.getX(), vec2i2.getY(), vec2i.getX(), vec2i.getY(), C0101n.l.getX(), C0101n.l.getY(), this.j == null ? this.o.d() : this.j.get().getX(), this.j == null ? this.o.c() : this.j.get().getY(), 3, 1, 1);
            }
            this.q.c();
            if (this.l != null) {
                this.l.a(guiGraphics, i, i2, f);
            }
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (!this.k.get().booleanValue()) {
            return;
        }
        if (this.l != null) {
            this.l.a(guiGraphics, i, i2, consumer);
        }
        if (a(i, i2) && this.e != null) {
            if (this.e.getFluidAmount() <= 0) {
                if (this.u) {
                    consumer.accept(this.i);
                }
                consumer.accept(b);
                consumer.accept(c("gui.mctech.tank.capacity.clear", mctech.utils.c.c.c.format(this.e.getFluidAmount()), mctech.utils.c.c.c.format(this.e.getCapacity())));
                return;
            }
            consumer.accept(this.i);
            FluidStack fluid = this.e.getFluid();
            consumer.accept(c("gui.mctech.tank.fluid.clear", fluid.getHoverName(), mctech.utils.c.c.c.format(fluid.getAmount())));
            consumer.accept(c("gui.mctech.tank.capacity.clear", mctech.utils.c.c.c.format(this.e.getFluidAmount()), mctech.utils.c.c.c.format(this.e.getCapacity())));
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5, FluidStack fluidStack) {
        if (this.k.get().booleanValue() && !fluidStack.isEmpty()) {
            Function textureAtlas = this.q.getMinecraft().getTextureAtlas(InventoryMenu.BLOCK_ATLAS);
            IClientFluidTypeExtensions iClientFluidTypeExtensionsOf = IClientFluidTypeExtensions.of(fluidStack.getFluid());
            TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite) textureAtlas.apply(iClientFluidTypeExtensionsOf.getStillTexture(fluidStack));
            if (textureAtlasSprite != textureAtlas.apply(MissingTextureAtlasSprite.getLocation())) {
                this.q.c(InventoryMenu.BLOCK_ATLAS);
                RenderSystem.enableBlend();
                mctech.m.d.b.a(guiGraphics, f, f2 + (f4 - f5), 0.0f, textureAtlasSprite, iClientFluidTypeExtensionsOf.getTintColor(fluidStack), 16.0f, 16.0f, f3, f5);
                this.q.c();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x008d  */
    /* JADX WARN: Code duplicated, block: B:23:0x0094  */
    /* JADX WARN: Code duplicated, block: B:24:0x00b5  */
    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean a(int i, int i2, int i3) {
        if (!this.k.get().booleanValue()) {
            return false;
        }
        if (!this.s) {
            INetworkFluidTankFillListener iNetworkFluidTankFillListener = this.d;
            if (iNetworkFluidTankFillListener instanceof INetworkFluidTankFillListener) {
                INetworkFluidTankFillListener iNetworkFluidTankFillListener2 = iNetworkFluidTankFillListener;
                if (this.f != -1 && !((mctech.m.b.S) this.q.getMenu()).getCarried().isEmpty()) {
                    if (iNetworkFluidTankFillListener2.getFluidHandler(this.f) != null) {
                        if (a(i, i2)) {
                            PacketDistributor.sendToServer(new mctech.q.d.a.a.b(this.d.getBlockPos(), this.f, Screen.hasShiftDown()), new CustomPacketPayload[0]);
                            return false;
                        }
                    } else {
                        MCTech.LOGGER.warn("Trying to fill NULL tank, skipping");
                    }
                } else if (this.d != null) {
                    MCTech.LOGGER.warn(String.format("Tile %s must implement @INetworkFluidTankFillListener to support filling tank by click", this.d.getClass().getSimpleName()));
                } else {
                    MCTech.LOGGER.warn("You must specify tile to add support of filling tank");
                }
            } else if (this.d != null) {
                MCTech.LOGGER.warn(String.format("Tile %s must implement @INetworkFluidTankFillListener to support filling tank by click", this.d.getClass().getSimpleName()));
            } else {
                MCTech.LOGGER.warn("You must specify tile to add support of filling tank");
            }
        }
        if (this.l != null) {
            this.l.a(i, i2, i3);
        }
        return super.a(i, i2, i3);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean d(int i, int i2, int i3) {
        if (this.l != null) {
            this.l.d(i, i2, i3);
        }
        return super.d(i, i2, i3);
    }
}
