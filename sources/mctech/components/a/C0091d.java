package mctech.components.a;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import mctech.init.MCTechLang;
import mctech.m.b.C0128aa;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.InventoryMenu;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.IFluidTank;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: mctech.components.a.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/d.class */
public class C0091d<FH extends IFluidTank> extends mctech.m.d.a.a implements mctech.a.b.c.a<FluidStack> {
    private final FH a;
    private final int b;
    private final InterfaceC0102o c;
    private final C0101n d;
    private Component e;

    @Nullable
    private Supplier<Vec2i> f;
    private boolean g;

    public C0091d(mctech.utils.math.geometry.b bVar, int i, FH fh, InterfaceC0102o interfaceC0102o) {
        this(bVar.a(), bVar.b(), i, fh, interfaceC0102o);
        a(() -> {
            return new Vec2i(bVar.d(), bVar.c());
        });
    }

    public C0091d(mctech.utils.math.geometry.b bVar, FH fh, InterfaceC0102o interfaceC0102o) {
        this(bVar.a(), bVar.b(), fh, interfaceC0102o);
        a(() -> {
            return new Vec2i(bVar.d(), bVar.c());
        });
    }

    public C0091d(int i, int i2, FH fh, InterfaceC0102o interfaceC0102o) {
        this(i, i2, -1, fh, interfaceC0102o);
    }

    public C0091d(int i, int i2, FH fh, InterfaceC0102o interfaceC0102o, C0101n c0101n) {
        this(i, i2, -1, fh, interfaceC0102o, c0101n);
    }

    public C0091d(int i, int i2, int i3, FH fh, InterfaceC0102o interfaceC0102o) {
        this(i, i2, i3, fh, interfaceC0102o, C0101n.a);
    }

    public C0091d(int i, int i2, int i3, FH fh, InterfaceC0102o interfaceC0102o, C0101n c0101n) {
        super(new mctech.utils.math.geometry.b(i, i2, C0101n.l.getX(), C0101n.l.getY()));
        this.d = c0101n;
        this.b = i3;
        this.c = interfaceC0102o;
        this.a = fh;
        this.e = f("gui.mctech.tank.simple");
    }

    @Override // mctech.a.b.c.a
    public boolean l() {
        return true;
    }

    public C0091d<FH> a(Component component) {
        this.e = component;
        return this;
    }

    public C0091d<FH> a(Supplier<Vec2i> supplier) {
        this.f = supplier;
        this.o = new mctech.utils.math.geometry.b(this.o.a(), this.o.b(), supplier.get().getX(), supplier.get().getY());
        return this;
    }

    public C0091d<FH> a(boolean z) {
        this.g = z;
        return this;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.m.d.a.a
    public boolean a(int i, int i2, int i3) {
        if (!a(i, i2)) {
            return super.a(i, i2, i3);
        }
        mctech.m.d.b bVar = this.q;
        if (bVar instanceof mctech.m.d.a) {
            for (mctech.m.d.a.a aVar : ((mctech.m.d.a) bVar).a()) {
                if (aVar instanceof E) {
                    E e = (E) aVar;
                    if (i3 == 2) {
                        e.a((mctech.a.b.c.a<?>) this);
                        return true;
                    }
                    if (i3 != 1) {
                        return true;
                    }
                    AbstractContainerMenu menu = this.q.getMenu();
                    if (menu instanceof C0128aa) {
                        PacketDistributor.sendToServer(new mctech.q.d.e(((mctech.blockentities.c.G) ((C0128aa) menu).getHolder()).getPosition(), a(), 0, false), new CustomPacketPayload[0]);
                        e.h();
                        return true;
                    }
                    return true;
                }
            }
        }
        return super.a(i, i2, i3);
    }

    @OnlyIn(Dist.CLIENT)
    private void a(GuiGraphics guiGraphics, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int i12 = i8 <= 18 ? 3 : 4;
        int i13 = i2 + (i8 / 2);
        guiGraphics.blit(this.d.a(), i + i10, i13, i5 - (i10 * 2), 1, i3 + i10, i4 + 30, i5 - (i10 * 2), 1, this.d.b(), this.d.c());
        int iMax = Math.max(i12, Math.min(15, i8 / 10));
        int i14 = i2 + (i8 < 18 ? iMax : 0);
        int i15 = (i2 + i8) - (i8 < 18 ? iMax : 0);
        for (int i16 = 1; i16 <= 10 / 2; i16++) {
            int i17 = i13 - (i16 * iMax);
            int i18 = i13 + (i16 * iMax);
            if (i17 > i14) {
                guiGraphics.blit(this.d.a(), i + i10, i17, i5 - (i10 * 2), 1, i3 + i10, i4 + 24, i5 - (i10 * 2), 1, this.d.b(), this.d.c());
            }
            if (i18 < i15) {
                guiGraphics.blit(this.d.a(), i + i10, i18, i5 - (i10 * 2), 1, i3 + i10, i4 + 24, i5 - (i10 * 2), 1, this.d.b(), this.d.c());
            }
        }
        if (i7 > i8 * 2) {
            guiGraphics.blit(this.d.a(), ((i + i7) - i10) - (i5 - (i10 * 2)), i13, i5 - (i10 * 2), 1, i3 + i10, i4 + 30, i5 - (i10 * 2), 1, this.d.b(), this.d.c());
            for (int i19 = 1; i19 <= 10 / 2; i19++) {
                int i20 = i13 - (i19 * iMax);
                int i21 = i13 + (i19 * iMax);
                if (i20 > i14) {
                    guiGraphics.blit(this.d.a(), ((i + i7) - i10) - 7, i20, 7, 1, i3 + i10, i4 + 24, 7, 1, this.d.b(), this.d.c());
                }
                if (i21 < i15) {
                    guiGraphics.blit(this.d.a(), ((i + i7) - i10) - 7, i21, 7, 1, i3 + i10, i4 + 24, 7, 1, this.d.b(), this.d.c());
                }
            }
        }
        guiGraphics.blit(this.d.a(), i, i2, i9, i9, i3, i4, i9, i9, this.d.b(), this.d.c());
        guiGraphics.blit(this.d.a(), i + i9, i2, i7 - (i9 * 2), i11, i3 + i9, i4, i5 - (i9 * 2), i11, this.d.b(), this.d.c());
        guiGraphics.blit(this.d.a(), (i + i7) - i9, i2, i9, i9, (i3 + i5) - i9, i4, i9, i9, this.d.b(), this.d.c());
        guiGraphics.blit(this.d.a(), (i + i7) - i10, i2 + i9, i10, i8 - (i9 * 2), (i3 + i5) - i10, i4 + i9, i10, i11, this.d.b(), this.d.c());
        guiGraphics.blit(this.d.a(), (i + i7) - i9, (i2 + i8) - i9, i9, i9, (i3 + i5) - i9, (i4 + i6) - i9, i9, i9, this.d.b(), this.d.c());
        guiGraphics.blit(this.d.a(), i + i9, (i2 + i8) - i11, i7 - (i9 * 2), i11, i3 + i9, (i4 + i6) - i11, i5 - (i9 * 2), i11, this.d.b(), this.d.c());
        guiGraphics.blit(this.d.a(), i, i2 + i9, i10, i8 - (i9 * 2), i3, i4 + i9, i10, i11, this.d.b(), this.d.c());
        guiGraphics.blit(this.d.a(), i, (i2 + i8) - i9, i9, i9, i3, (i4 + i6) - i9, i9, i9, this.d.b(), this.d.c());
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.a != null) {
            if (this.a.getFluidAmount() != 0) {
                a(guiGraphics, this.q.getGuiLeft() + this.o.a() + 1, this.q.getGuiTop() + this.o.b() + 1, (this.f != null ? this.f.get().getX() : this.o.d()) - 2, (this.f != null ? this.f.get().getY() : this.o.c()) - 2, (this.a.getFluidAmount() / this.a.getCapacity()) * ((this.f != null ? this.f.get().getY() : this.o.c()) - 2.0f), this.a.getFluid());
            }
            this.q.c(this.d.a());
            PoseStack poseStackPose = guiGraphics.pose();
            poseStackPose.pushPose();
            poseStackPose.translate(0.0f, 0.0f, 2.0f);
            Vec2i vec2i = new Vec2i(C0101n.a.n.getX() + (C0101n.l.getX() * this.c.tierIndex()), C0101n.a.n.getY());
            Vec2i vec2i2 = new Vec2i(this.q.getGuiLeft() + this.o.a(), this.q.getGuiTop() + this.o.b());
            if (!this.g) {
                a(guiGraphics, vec2i2.getX(), vec2i2.getY(), vec2i.getX(), vec2i.getY(), C0101n.l.getX(), C0101n.l.getY(), this.f == null ? this.o.d() : this.f.get().getX(), this.f == null ? this.o.c() : this.f.get().getY(), 3, 1, 1);
            }
            this.q.c();
            poseStackPose.popPose();
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (a(i, i2) && this.a != null) {
            if (this.a.getFluidAmount() <= 0) {
                consumer.accept(MCTechLang.QUANTITY_PLACE_FLUID);
                return;
            }
            consumer.accept(this.e);
            FluidStack fluid = this.a.getFluid();
            consumer.accept(c("gui.mctech.tank.fluid.clear", fluid.getHoverName(), mctech.utils.c.c.c.format(fluid.getAmount())));
            consumer.accept(c("gui.mctech.tank.capacity.clear", mctech.utils.c.c.c.format(this.a.getFluidAmount()), mctech.utils.c.c.c.format(this.a.getCapacity())));
            consumer.accept(MCTechLang.QUANTITY_RIGHT_CLICK_TIP);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, float f, float f2, float f3, float f4, float f5, FluidStack fluidStack) {
        if (!fluidStack.isEmpty()) {
            Function textureAtlas = this.q.getMinecraft().getTextureAtlas(InventoryMenu.BLOCK_ATLAS);
            IClientFluidTypeExtensions iClientFluidTypeExtensionsOf = IClientFluidTypeExtensions.of(fluidStack.getFluid());
            TextureAtlasSprite textureAtlasSprite = (TextureAtlasSprite) textureAtlas.apply(iClientFluidTypeExtensionsOf.getStillTexture(fluidStack));
            if (textureAtlasSprite != textureAtlas.apply(MissingTextureAtlasSprite.getLocation())) {
                this.q.c(InventoryMenu.BLOCK_ATLAS);
                RenderSystem.enableBlend();
                mctech.m.d.b.a(guiGraphics, f, f2 + (f4 - f5), 1.0f, textureAtlasSprite, iClientFluidTypeExtensionsOf.getTintColor(fluidStack), 16.0f, 16.0f, f3, f5);
                this.q.c();
            }
        }
    }

    @Override // mctech.a.b.c.a
    public int a() {
        return this.b;
    }

    @Override // mctech.a.b.c.a
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public FluidStack b() {
        return this.a == null ? FluidStack.EMPTY : this.a.getFluid();
    }

    @Override // mctech.a.b.c.a
    public int c() {
        return v().a() - 2;
    }

    @Override // mctech.a.b.c.a
    public int d() {
        return v().b() - 2;
    }

    @Override // mctech.a.b.c.a
    public int e() {
        return v().d() + 4;
    }

    @Override // mctech.a.b.c.a
    public int f() {
        return v().c() + 4;
    }

    @Override // mctech.a.b.c.a
    public void a(int i) {
    }

    @Override // mctech.a.b.c.a
    public int g() {
        if (this.a == null) {
            return 0;
        }
        return this.a.getFluidAmount();
    }

    @Override // mctech.a.b.c.a
    public int h() {
        if (this.a == null) {
            return 0;
        }
        return this.a.getCapacity();
    }

    @Override // mctech.a.b.c.a
    public int i() {
        return 1;
    }

    @Override // mctech.a.b.c.a
    public boolean j() {
        return true;
    }

    @Override // mctech.a.b.c.a
    public String k() {
        return "mB";
    }
}
