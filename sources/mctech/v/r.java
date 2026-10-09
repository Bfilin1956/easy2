package mctech.v;

import it.unimi.dsi.fastutil.objects.Object2ObjectSortedMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import mctech.MCTech;
import net.minecraft.ResourceLocationException;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/r.class */
@OnlyIn(Dist.CLIENT)
public class r {
    public static final r a = new r();
    Map<ResourceLocation, Map<String, TextureAtlasSprite>> b = mctech.utils.a.b.e();
    List<Material> c = mctech.utils.a.b.i();

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/r$a.class */
    public interface a {
        ResourceLocation a();

        Map<String, TextureAtlasSprite> a(TextureAtlas textureAtlas);

        void a(Consumer<ResourceLocation> consumer);
    }

    public void a(Material material) {
        this.c.add(material);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: net.minecraft.ResourceLocationException */
    public static Map<String, TextureAtlasSprite> a(ResourceLocation resourceLocation) throws ResourceLocationException {
        Map<String, TextureAtlasSprite> map = a.b.get(resourceLocation);
        if (map == null) {
            throw new ResourceLocationException(resourceLocation.toString() + " is not registered as a texture location");
        }
        return map;
    }

    public static Map<String, TextureAtlasSprite> a(String str, String str2) {
        return a(ResourceLocation.fromNamespaceAndPath(str, str2));
    }

    public static Map<String, TextureAtlasSprite> b(String str, String str2) {
        return a(ResourceLocation.fromNamespaceAndPath(str, "item/" + str2));
    }

    public static Map<String, TextureAtlasSprite> c(String str, String str2) {
        return a(ResourceLocation.fromNamespaceAndPath(str, "block/" + str2));
    }

    public static Map<String, TextureAtlasSprite> a(String str) {
        return a(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, str));
    }

    public static Map<String, TextureAtlasSprite> b(String str) {
        return a(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "block/" + str));
    }

    public static Map<String, TextureAtlasSprite> c(String str) {
        return a(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "item/" + str));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/r$b.class */
    public static class b implements a {
        String a;
        String b;
        String c;
        Map<String, ResourceLocation> d;

        public b(String str, String str2, String str3, Map<String, ResourceLocation> map) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = map;
        }

        @Override // mctech.v.r.a
        public ResourceLocation a() {
            return ResourceLocation.fromNamespaceAndPath(this.a, this.b + "/" + this.c);
        }

        @Override // mctech.v.r.a
        public Map<String, TextureAtlasSprite> a(TextureAtlas textureAtlas) {
            Object2ObjectSortedMap object2ObjectSortedMapF = mctech.utils.a.b.f();
            for (Map.Entry<String, ResourceLocation> entry : this.d.entrySet()) {
                object2ObjectSortedMapF.put(entry.getKey(), textureAtlas.getSprite(entry.getValue()));
            }
            return object2ObjectSortedMapF;
        }

        @Override // mctech.v.r.a
        public void a(Consumer<ResourceLocation> consumer) {
            this.d.values().forEach(consumer);
        }
    }
}
