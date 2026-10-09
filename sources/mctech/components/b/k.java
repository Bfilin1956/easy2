package mctech.components.b;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Set;
import mctech.MCTech;
import mctech.api.tiles.IMachineInfo;
import mctech.components.ContainerComponent;
import mctech.components.a.C;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/k.class */
public class k extends mctech.m.d.a.a implements mctech.m.d.b.a {
    public static final ResourceLocation a = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/components/info_combine.png");
    protected Vec2i b;
    protected Vec2i c;
    private boolean d;
    private ContainerComponent<?> e;
    private boolean f;
    private boolean g;

    public k(ContainerComponent<?> containerComponent, Vec2i vec2i, Vec2i vec2i2, boolean z, boolean z2) {
        super(new mctech.utils.math.geometry.b((-118) + vec2i.getX(), vec2i.getY(), containerComponent.getInfoGuiSize().getX(), containerComponent.getInfoGuiSize().getY()));
        this.e = containerComponent;
        a_(false);
        this.b = vec2i;
        this.c = vec2i2;
        this.f = z;
        this.g = z2;
    }

    public k(ContainerComponent<?> containerComponent, Vec2i vec2i, Vec2i vec2i2) {
        this(containerComponent, vec2i, vec2i2, true, true);
    }

    public ResourceLocation a() {
        if (this.e != null && this.e.getInfoTexture() != null) {
            return this.e.getInfoTexture();
        }
        return a;
    }

    @Override // mctech.m.d.a.a
    public boolean a(int i, int i2) {
        return true;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND_PRE);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        int x = 5 + this.c.getX();
        int y = 16 + this.c.getY();
        ResourceLocation atlasTexture = null;
        Vec2i filterButtonTextureOffset = Vec2i.ZERO;
        if (this.e != null) {
            filterButtonTextureOffset = this.e.getFilterButtonTextureOffset();
            atlasTexture = this.e.getAtlasTexture();
        }
        bVar.addRenderableWidget(new C(bVar.getGuiLeft() + x, bVar.getGuiTop() + y, 10, 10, e("I"), button -> {
            a(!w());
        }, atlasTexture, filterButtonTextureOffset).a("gui.mctech.info.button"));
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        this.q.c(a());
        this.q.b(guiGraphics, (this.q.getGuiLeft() - this.e.getInfoGuiSize().getX()) + this.b.getX(), this.q.getGuiTop() + this.b.getY() + 6.0f, 0.0f, 0.0f, this.e.getInfoGuiSize().getX(), this.e.getInfoGuiSize().getY());
    }

    @Override // mctech.m.d.a.a
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        Object holder = this.e.getHolder();
        if (holder instanceof IMachineInfo) {
            IMachineInfo iMachineInfo = (IMachineInfo) holder;
            PoseStack poseStackPose = guiGraphics.pose();
            poseStackPose.pushPose();
            poseStackPose.scale(0.5f, 0.5f, 1.0f);
            int x = this.e.getInfoGuiSize().getX();
            int y = this.e.getInfoGuiSize().getY();
            MutableComponent mutableComponentLiteral = this.g ? Component.literal("Максимальный вход: " + iMachineInfo.getMaxInput() + " EU/t") : Component.literal("Максимальный выход: " + iMachineInfo.getMaxEnergyOutput() + " EU/t");
            poseStackPose.translate((this.b.getX() * 2) - x, (this.b.getY() * 2) + y, 0.0f);
            this.q.a(guiGraphics, (Component) mutableComponentLiteral, 0, 0, -1);
            if (this.f) {
                poseStackPose.translate(0.0f, 30.0f, 0.0f);
                this.q.a(guiGraphics, (Component) Component.literal("Стоимость операции: " + iMachineInfo.getEnergyPerTick() + " EU/t"), 0, 0, -1);
            }
            poseStackPose.popPose();
            poseStackPose.pushPose();
            poseStackPose.scale(0.5f, 0.5f, 1.0f);
            poseStackPose.translate(((this.b.getX() * 2) - (x * 2)) + 45, (this.b.getY() * 2) + y, 0.0f);
            mctech.m.d.b bVar = this.q;
            long storedLongEU = iMachineInfo.getStoredLongEU();
            iMachineInfo.getMaxLongEU();
            bVar.a(guiGraphics, (Component) Component.literal("Буфер: " + storedLongEU + "/" + bVar), 0, 0, -1);
            if (this.f) {
                poseStackPose.translate(0.0f, 30.0f, 0.0f);
                this.q.a(guiGraphics, (Component) Component.literal("Время операции: " + iMachineInfo.getOperationTime() + " t"), 0, 0, -1);
            }
            poseStackPose.popPose();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void a(boolean z) {
        if (!this.d) {
            this.q.b();
        }
        a_(z);
    }

    @Override // mctech.m.d.b.a
    @OnlyIn(Dist.CLIENT)
    public void c(mctech.m.d.b bVar) {
        a_(false);
    }
}
