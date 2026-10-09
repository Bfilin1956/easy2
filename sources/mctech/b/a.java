package mctech.b;

import mctech.MCTech;
import mctech.init.MCTechSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/b/a.class */
public class a extends SoundDefinitionsProvider {
    public a(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, MCTech.MODID, existingFileHelper);
    }

    public void registerSounds() {
        MCTechSounds.REGISTRY.getEntries().forEach(this::a);
    }

    private <SE extends SoundEvent> void a(DeferredHolder<SoundEvent, SE> deferredHolder) {
        add((SoundEvent) deferredHolder.get(), definition().with(sound(a(((SoundEvent) deferredHolder.get()).getLocation())).volume(1.0f).pitch(1.0f)));
    }

    private ResourceLocation a(ResourceLocation resourceLocation) {
        return MCTech.loc(resourceLocation.getPath().replace("sounds/", "").replace(".ogg", ""));
    }

    @NotNull
    public String getName() {
        return super.getName() + ": MCTech";
    }
}
