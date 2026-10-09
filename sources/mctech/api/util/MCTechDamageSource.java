package mctech.api.util;

import mctech.MCTech;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/util/MCTechDamageSource.class */
public final class MCTechDamageSource {
    public static final ResourceKey<DamageType> ELECTRICITY = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "electricity"));
    public static final ResourceKey<DamageType> NUKE = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "nuke"));
    public static final ResourceKey<DamageType> RADIATION = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "radiation"));

    public static DamageSource newRadiationDamage(Level level) {
        return new DamageSource(level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(RADIATION));
    }

    public static DamageSource newNukeDamage(Level level) {
        return new DamageSource(level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(NUKE));
    }

    public static DamageSource newShockDamage(Level level) {
        return new DamageSource(level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(ELECTRICITY));
    }

    public static DamageSource newShockDamage(Entity entity) {
        return new DamageSource(entity.level().registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).getOrThrow(ELECTRICITY));
    }
}
