package mctech.g.e;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.inventory.InventoryMenu;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/e/f.class */
public class f {
    public static TextureAtlasSprite a() {
        return (TextureAtlasSprite) Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(MissingTextureAtlasSprite.getLocation());
    }
}
