package mctech.api.tiles;

import mctech.MCTech;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/ICustomContainer.class */
public interface ICustomContainer {
    default ResourceLocation getFilterTexture() {
        return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/components/filter_helper.png");
    }

    default Vec2i getFilterGuiSize() {
        return new Vec2i(122, 132);
    }

    default Vec2i getFilterScrollOffset() {
        return new Vec2i(-2, -2);
    }

    default Vec2i getFilterItemsOffset() {
        return new Vec2i(3, -2);
    }

    default Vec2i getFilterButtonCords() {
        return new Vec2i(3, 17);
    }
}
