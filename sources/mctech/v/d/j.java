package mctech.v.d;

import com.mojang.blaze3d.vertex.PoseStack;
import mctech.MCTech;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/d/j.class */
public final class j extends GeoItemRenderer<mctech.items.e.h> {
    private final i a;
    private static final GeoModel<mctech.items.e.h> b = new GeoModel<mctech.items.e.h>() { // from class: mctech.v.d.j.1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResourceLocation getModelResource(mctech.items.e.h hVar) {
            return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "geo/item/" + BuiltInRegistries.ITEM.getKey(hVar).getPath() + ".geo.json");
        }

        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResourceLocation getTextureResource(mctech.items.e.h hVar) {
            return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/item/" + BuiltInRegistries.ITEM.getKey(hVar).getPath() + ".png");
        }

        @Nullable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public ResourceLocation getAnimationResource(mctech.items.e.h hVar) {
            return null;
        }
    };

    public j() {
        super(b);
        this.a = new i();
    }

    public void renderByItem(ItemStack itemStack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i2) {
        super.renderByItem(itemStack, itemDisplayContext, poseStack, multiBufferSource, i, i2);
        if (itemStack != null) {
            ItemStack itemStackA = mctech.e.c.a(itemStack);
            Item item = itemStackA.getItem();
            if (item instanceof mctech.items.e.d) {
                this.a.a(itemStack, itemStackA, (mctech.items.e.d) item, itemDisplayContext, poseStack, multiBufferSource, i, i2);
            }
        }
    }
}
