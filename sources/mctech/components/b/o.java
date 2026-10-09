package mctech.components.b;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import mctech.api.tiles.readers.IProgressMachine;
import mctech.integration.emi.plugin.core.EMICompat;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/o.class */
public class o extends mctech.m.d.a.a {
    private final IProgressMachine a;
    private ResourceLocation b;
    private final Vec2i c;
    private int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private int h;
    private Supplier<Integer> i;
    private Supplier<Float> j;
    private Supplier<Float> k;
    private Supplier<String> l;
    private Supplier<Boolean> m;
    private Supplier<Boolean> n;

    public o(mctech.utils.math.geometry.b bVar, IProgressMachine iProgressMachine, Vec2i vec2i) {
        this(bVar, iProgressMachine, vec2i, false, false);
    }

    public o(mctech.utils.math.geometry.b bVar, IProgressMachine iProgressMachine, Vec2i vec2i, boolean z) {
        this(bVar, iProgressMachine, vec2i, z, false);
    }

    public o(mctech.utils.math.geometry.b bVar, IProgressMachine iProgressMachine, Vec2i vec2i, boolean z, boolean z2) {
        super(bVar);
        this.a = iProgressMachine;
        this.b = null;
        this.c = vec2i;
        this.e = z;
        this.f = z2;
        this.d = 0;
        this.g = true;
        this.i = () -> {
            return 0;
        };
        this.h = 0;
    }

    public o(int i, int i2, int i3, int i4, IProgressMachine iProgressMachine, int i5, int i6) {
        this(new mctech.utils.math.geometry.b(i, i2, i3, i4), iProgressMachine, new Vec2i(i5, i6));
    }

    public o(int i, int i2, int i3, int i4, IProgressMachine iProgressMachine, int i5, int i6, boolean z) {
        this(new mctech.utils.math.geometry.b(i, i2, i3, i4), iProgressMachine, new Vec2i(i5, i6), z);
    }

    public o(int i, int i2, int i3, int i4, IProgressMachine iProgressMachine, int i5, int i6, boolean z, boolean z2) {
        this(new mctech.utils.math.geometry.b(i, i2, i3, i4), iProgressMachine, new Vec2i(i5, i6), z, z2);
    }

    public o a(boolean z) {
        this.g = z;
        return this;
    }

    public o b(boolean z) {
        this.e = z;
        return this;
    }

    public o c(boolean z) {
        this.f = z;
        return this;
    }

    public o a(ResourceLocation resourceLocation) {
        this.b = resourceLocation;
        return this;
    }

    public o a(int i) {
        this.d = i;
        return this;
    }

    public o a(@NotNull Supplier<Integer> supplier) {
        this.i = supplier;
        return this;
    }

    public o a(@NotNull Supplier<Float> supplier, @NotNull Supplier<Float> supplier2) {
        this.j = supplier;
        this.k = supplier2;
        return this;
    }

    public o b(@NotNull Supplier<String> supplier) {
        this.l = supplier;
        return this;
    }

    public o c(@NotNull Supplier<Boolean> supplier) {
        this.m = supplier;
        return this;
    }

    public o d(@NotNull Supplier<Boolean> supplier) {
        this.n = supplier;
        return this;
    }

    public o c(int i) {
        this.h = i;
        return this;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, float f) {
        if (this.b != null) {
            this.q.c(this.b);
        }
        float fFloatValue = this.j != null ? this.j.get().floatValue() : this.a.getProgressSlot(this.d);
        if (fFloatValue >= 0.0f) {
            mctech.utils.math.geometry.b bVarV = v();
            int iD = bVarV.d();
            int iC = bVarV.c();
            float fMin = (this.e ? iC : iD) * Math.min(1.0f, fFloatValue / (this.k != null ? this.k.get().floatValue() : this.a.getMaxProgressSlot(this.d)));
            if (fMin <= 0.0f) {
                return;
            }
            PoseStack poseStackPose = guiGraphics.pose();
            poseStackPose.pushPose();
            float guiLeft = this.q.getGuiLeft() + bVarV.a() + (iD / 2.0f);
            float guiTop = this.q.getGuiTop() + bVarV.b() + (iC / 2.0f);
            if (this.h != 0) {
                poseStackPose.translate(guiLeft, guiTop, 0.0f);
                poseStackPose.mulPose(new Matrix4f().rotationZ((float) Math.toRadians(this.h)));
                poseStackPose.translate(-guiLeft, -guiTop, 0.0f);
            }
            if (this.e) {
                if (this.f) {
                    this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a(), this.q.getGuiTop() + bVarV.b(), this.c.getX(), this.c.getY(), iD, fMin);
                } else {
                    this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a(), this.q.getGuiTop() + bVarV.b() + (iC - fMin), this.c.getX(), this.c.getY() + (iC - fMin), iD, fMin);
                }
            } else if (this.f) {
                this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a() + (iD - fMin), this.q.getGuiTop() + bVarV.b(), this.c.getX() + (iD - fMin), this.c.getY(), fMin, iC);
            } else {
                this.q.b(guiGraphics, this.q.getGuiLeft() + bVarV.a(), this.q.getGuiTop() + bVarV.b(), this.c.getX(), this.c.getY(), fMin, iC);
            }
            poseStackPose.popPose();
        }
        if (this.b != null) {
            this.q.c();
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (a(i, i2) && this.q.getSlotUnderMouse() == null) {
            if (y()) {
                String str = this.l != null ? this.l.get() : "gui.mctech.progress";
                Object[] objArr = new Object[2];
                objArr[0] = mctech.utils.c.c.c.format(this.j != null ? this.j.get().floatValue() : this.a.getProgressSlot(this.d));
                objArr[1] = mctech.utils.c.c.c.format(this.k != null ? this.k.get().floatValue() : this.a.getMaxProgressSlot(this.d));
                consumer.accept(c(str, objArr));
            }
            BlockEntity blockEntity = this.a;
            if (blockEntity instanceof BlockEntity) {
                BlockEntity blockEntity2 = blockEntity;
                if (this.g) {
                    if (EMICompat.isRegistered(blockEntity2) || (this.m != null && this.m.get().booleanValue())) {
                        consumer.accept(Component.literal("Отобразить рецепты"));
                    }
                }
            }
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean a(int i, int i2, int i3) {
        BlockEntity blockEntity = this.a;
        if (blockEntity instanceof BlockEntity) {
            BlockEntity blockEntity2 = blockEntity;
            if (this.q.getSlotUnderMouse() == null && this.g && (EMICompat.isRegistered(blockEntity2) || (this.m != null && this.m.get().booleanValue()))) {
                return this.n != null ? this.n.get().booleanValue() : EMICompat.openRecipeCategory(blockEntity2, this.i.get().intValue());
            }
        }
        return super.a(i, i2, i3);
    }
}
