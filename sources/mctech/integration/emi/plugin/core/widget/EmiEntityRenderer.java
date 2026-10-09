package mctech.integration.emi.plugin.core.widget;

import com.mojang.blaze3d.Blaze3D;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import dev.emi.emi.api.widget.Bounds;
import dev.emi.emi.api.widget.Widget;
import java.util.HashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/widget/EmiEntityRenderer.class */
@OnlyIn(Dist.CLIENT)
public class EmiEntityRenderer extends Widget {
    private static final HashMap<EntityType<? extends LivingEntity>, LivingEntity> entityCache = new HashMap<>();
    private final EntityType<? extends LivingEntity> entityType;
    private final int width;
    private final int height;
    private final int x;
    private final int y;

    public EmiEntityRenderer(EntityType<? extends LivingEntity> entityType, int i, int i2, int i3, int i4) {
        this.entityType = entityType;
        this.width = i;
        this.height = i2;
        this.x = i3;
        this.y = i4;
    }

    public Bounds getBounds() {
        return new Bounds(this.x, this.y, this.width, this.height);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void render(GuiGraphics guiGraphics, int i, int i2, float f) {
        PoseStack poseStackPose = guiGraphics.pose();
        poseStackPose.pushPose();
        guiGraphics.fill(this.x, this.y, this.x + this.width, this.y + this.height, -9145228);
        LivingEntity entity = getEntity(this.entityType);
        if (entity != null) {
            poseStackPose.translate(this.x + (this.width / 2.0f), this.y + (this.height / 2.0f) + (entity.getBbHeight() * 16.0f), 100.0f);
            poseStackPose.scale(30.0f, -30.0f, 30.0f);
            poseStackPose.mulPose(Axis.YP.rotation((float) Math.sin(Blaze3D.getTime())));
            poseStackPose.mulPose(Axis.XP.rotation((float) Math.toRadians(5.0d)));
            Minecraft.getInstance().getEntityRenderDispatcher().render(entity, 0.0d, 0.0d, 0.0d, 0.0f, f, poseStackPose, guiGraphics.bufferSource(), 15728880);
        }
        poseStackPose.popPose();
    }

    @Nullable
    private LivingEntity getEntity(EntityType<? extends LivingEntity> entityType) {
        if (entityCache.containsKey(entityType)) {
            return entityCache.get(entityType);
        }
        ClientLevel clientLevel = Minecraft.getInstance().level;
        if (clientLevel == null) {
            return null;
        }
        LivingEntity livingEntityCreate = entityType.create(clientLevel);
        if (livingEntityCreate != null) {
            entityCache.put(entityType, livingEntityCreate);
        }
        return livingEntityCreate;
    }
}
