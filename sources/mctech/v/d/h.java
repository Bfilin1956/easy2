package mctech.v.d;

import javax.annotation.Nonnull;
import mctech.MCTech;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderArmEvent;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/d/h.class */
@EventBusSubscriber(value = {Dist.CLIENT}, modid = MCTech.MODID)
public class h {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void a(@Nonnull RenderArmEvent renderArmEvent) {
        Entity player = renderArmEvent.getPlayer();
        ItemStack itemBySlot = player.getItemBySlot(EquipmentSlot.CHEST);
        mctech.items.e.b item = itemBySlot.getItem();
        if (item instanceof mctech.items.e.b) {
            mctech.items.e.b bVar = item;
            PlayerRenderer renderer = Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(player);
            if (renderer instanceof PlayerRenderer) {
                HumanoidModel humanoidModel = (PlayerModel) renderer.getModel();
                boolean z = ((PlayerModel) humanoidModel).young;
                ((PlayerModel) humanoidModel).attackTime = 0.0f;
                ((PlayerModel) humanoidModel).crouching = false;
                ((PlayerModel) humanoidModel).swimAmount = 0.0f;
                ((PlayerModel) humanoidModel).young = false;
                humanoidModel.setupAnim(player, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
                if (renderArmEvent.getArm() == HumanoidArm.RIGHT) {
                    ((PlayerModel) humanoidModel).rightArm.xRot = 0.0f;
                } else {
                    ((PlayerModel) humanoidModel).leftArm.xRot = 0.0f;
                }
                EquipmentSlot equipmentSlot = renderArmEvent.getArm() == HumanoidArm.RIGHT ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
                b geoArmorRenderer = GeoRenderProvider.of(bVar).getGeoArmorRenderer(player, itemBySlot, equipmentSlot, humanoidModel);
                geoArmorRenderer.getGeoModel().getBone("armorHip").ifPresent(geoBone -> {
                    geoBone.setHidden(true);
                });
                geoArmorRenderer.prepForRender(player, itemBySlot, equipmentSlot, humanoidModel);
                Minecraft.getInstance().renderBuffers().bufferSource();
                ((PlayerModel) humanoidModel).young = z;
            }
        }
    }
}
