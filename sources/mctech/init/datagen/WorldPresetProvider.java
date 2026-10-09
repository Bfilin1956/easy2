package mctech.init.datagen;

import java.util.concurrent.CompletableFuture;
import mctech.MCTech;
import mctech.init.MCTechDebugWorld;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.presets.WorldPreset;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/datagen/WorldPresetProvider.class */
public class WorldPresetProvider extends TagsProvider<WorldPreset> {
    public static final TagKey<WorldPreset> NORMAL = TagKey.create(Registries.WORLD_PRESET, ResourceLocation.withDefaultNamespace("normal"));

    public WorldPresetProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, Registries.WORLD_PRESET, completableFuture, MCTech.MODID, existingFileHelper);
    }

    protected void addTags(HolderLookup.Provider provider) {
        tag(NORMAL).addOptional(MCTechDebugWorld.DEBUG_WORLD.location());
    }
}
