package mctech.components;

import mctech.MCTech;
import mctech.m.a.d;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

/* JADX INFO: renamed from: mctech.components.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/i.class */
public abstract class AbstractC0115i<T extends mctech.m.a.d> extends ContainerComponent<T> {
    public AbstractC0115i(T t, Player player, int i) {
        super(t, player, i);
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getFilterTexture() {
        return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/components/filter_helper.png");
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterGuiSize() {
        return new Vec2i(122, 132);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterScrollOffset() {
        return new Vec2i(-2, -2);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterItemsOffset() {
        return new Vec2i(3, -2);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getInfoGuiSize() {
        return new Vec2i(198, 51);
    }
}
