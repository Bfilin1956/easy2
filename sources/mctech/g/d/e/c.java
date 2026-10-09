package mctech.g.d.e;

import java.util.Optional;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/e/c.class */
public class c {
    public static String a(ResourceLocation resourceLocation) {
        EntityType entityType = (EntityType) BuiltInRegistries.ENTITY_TYPE.get(resourceLocation);
        if (entityType == null) {
            return "error";
        }
        return entityType.getDescriptionId();
    }

    public static Optional<ResourceLocation> a(Entity entity) {
        return Optional.of(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()));
    }
}
