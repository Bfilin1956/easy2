package mctech.components.b;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Set;
import mctech.MCTech;
import mctech.components.a.C;
import mctech.components.a.C0101n;
import mctech.components.a.K;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/l.class */
public class l extends mctech.m.d.a.a implements mctech.m.d.b.a {
    public static final ResourceLocation a = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/components/inventory_helper.png");
    private static final Vec2i[] b = {new Vec2i(53, 34), new Vec2i(53, 68), new Vec2i(36, 51), new Vec2i(53, 51), new Vec2i(70, 51), new Vec2i(36, 68)};
    private Vec2i c;
    private Vec2i d;
    private final mctech.m.e.e e;
    private boolean f;
    private mctech.components.w<?> g;

    public l(mctech.m.e.e eVar, Vec2i vec2i, Vec2i vec2i2, mctech.components.w<?> wVar) {
        super(new mctech.utils.math.geometry.b((-100) + vec2i.getX(), vec2i.getY(), 100, 113));
        this.e = eVar;
        this.c = vec2i;
        this.d = vec2i2;
        this.g = wVar;
        a_(false);
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_TICK);
    }

    public Vec2i a() {
        return this.c;
    }

    public l b() {
        this.f = true;
        return this;
    }

    @Override // mctech.m.d.a.a
    public boolean a(int i, int i2) {
        return true;
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        int guiLeft = bVar.getGuiLeft();
        int guiTop = bVar.getGuiTop();
        bVar.a(120, new K((guiLeft + this.c.getX()) - 34, guiTop + this.c.getY() + 136, 12, 12, C0101n.a.a(), new mctech.utils.math.geometry.b(208, 122, mctech.utils.c.h.i, mctech.utils.c.h.i), button -> {
            MCTech.NETWORKING.sendClientTileEvent((BlockEntity) this.e, 32773, 0);
        }).a((Component) Component.translatable("gui.mctech.tile.settings.extraction")));
        bVar.a(121, new K((guiLeft + this.c.getX()) - 20, guiTop + this.c.getY() + 136, 12, 12, C0101n.a.a(), new mctech.utils.math.geometry.b(219, 122, mctech.utils.c.h.i, mctech.utils.c.h.i), button2 -> {
            MCTech.NETWORKING.sendClientTileEvent((BlockEntity) this.e, 32773, 1);
        }).a((Component) Component.translatable("gui.mctech.tile.settings.reset")));
        bVar.a(122, new K((guiLeft + this.c.getX()) - 48, guiTop + this.c.getY() + 136, 12, 12, C0101n.a.a(), new mctech.utils.math.geometry.b(197, 122, mctech.utils.c.h.i, mctech.utils.c.h.i), button3 -> {
            this.g.a();
        }).a((Component) Component.literal("Вкл/выкл рендер соседних блоков")));
        if (this.f) {
            bVar.a(1100, new C(guiLeft + 5 + this.d.getX(), guiTop + 5 + this.d.getY(), 10, 10, e("I"), new a(this, bVar), null, Vec2i.EMPTY).a("gui.mctech.inventory.button"));
        } else {
            bVar.a(1100, new C(guiLeft + 5 + this.d.getX(), guiTop + 5 + this.d.getY(), 10, 10, e("I"), new a(this, bVar)).a("gui.mctech.inventory.button"));
        }
        b(bVar);
    }

    @Override // mctech.m.d.b.a
    @OnlyIn(Dist.CLIENT)
    public void c(mctech.m.d.b bVar) {
        a_(false);
        b(bVar);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void b(mctech.m.d.b bVar) {
        K kG = bVar.g(120);
        if (kG instanceof K) {
            K k = kG;
            k.active = w();
            k.visible = w();
            k.a(new mctech.utils.math.geometry.b(208, this.e.getInventoryHandler().t() ? 111 : 122, mctech.utils.c.h.i, mctech.utils.c.h.i));
        }
        K kG2 = bVar.g(121);
        if (kG2 instanceof K) {
            K k2 = kG2;
            k2.active = w();
            k2.visible = w();
        }
        K kG3 = bVar.g(122);
        if (kG3 instanceof K) {
            K k3 = kG3;
            k3.active = w();
            k3.visible = w();
            k3.a(new mctech.utils.math.geometry.b(197, this.g.b() ? 111 : 122, mctech.utils.c.h.i, mctech.utils.c.h.i));
        }
        this.g.a_(w());
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (!w()) {
            return;
        }
        this.q.c(a);
        this.q.b(guiGraphics, (this.q.getGuiLeft() - 122) + this.c.getX(), this.q.getGuiTop() + this.c.getY(), 0.0f, 0.0f, 122.0f, 156.0f);
        this.q.c(C0101n.a.a());
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        if (!w()) {
            return;
        }
        this.q.b(guiGraphics, (Component) Component.translatable("gui.mctech.tile.settings.machine"), this.c.getX() - 60, this.c.getY() + 8, -1);
        PoseStack poseStackPose = guiGraphics.pose();
        int x = this.c.getX() - 60;
        int y = this.c.getY() + 23;
        poseStackPose.pushPose();
        poseStackPose.translate(x, y, 0.0f);
        poseStackPose.scale(0.75f, 0.75f, 1.0f);
        poseStackPose.translate(-x, -y, 0.0f);
        this.q.b(guiGraphics, (Component) (this.e.getInventoryHandler().t() ? Component.translatable("gui.mctech.tile.settings.extraction.enabled") : Component.translatable("gui.mctech.tile.settings.extraction.disabled")), x, y, -1);
        poseStackPose.popPose();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/l$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a implements Button.OnPress {
        l a;
        mctech.m.d.b b;

        public a(l lVar, mctech.m.d.b bVar) {
            this.a = lVar;
            this.b = bVar;
        }

        @OnlyIn(Dist.CLIENT)
        public void onPress(Button button) {
            boolean z = !this.a.w();
            this.b.b();
            this.a.a_(z);
            this.a.b(this.b);
        }
    }
}
