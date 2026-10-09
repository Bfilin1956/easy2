package mctech.v.b;

import mctech.MCTech;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.TextureAtlasHolder;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/b/a.class */
public class a extends TextureAtlasHolder {
    public static final ResourceLocation a = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/atlas/rotor_blades.png");

    public a(TextureManager textureManager) {
        super(textureManager, a, ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "rotor_blades"));
    }

    public TextureAtlasSprite getSprite(ResourceLocation resourceLocation) {
        return super.getSprite(resourceLocation);
    }
}
