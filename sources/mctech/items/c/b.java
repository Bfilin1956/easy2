package mctech.items.c;

import mctech.init.MCTechDataComponent;
import mctech.items.base.i;
import mctech.items.base.o;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/c/b.class */
public class b extends i {
    public b() {
        super(new o());
    }

    @NotNull
    public Component getName(@NotNull ItemStack itemStack) {
        ResourceLocation resourceLocation;
        EntityType entityType;
        MutableComponent mutableComponentCopy = Component.translatable(getDescriptionId(itemStack)).copy();
        if (itemStack.has((DataComponentType) MCTechDataComponent.ENTITY_TYPE.get()) && (resourceLocation = (ResourceLocation) itemStack.get((DataComponentType) MCTechDataComponent.ENTITY_TYPE.get())) != null && (entityType = (EntityType) BuiltInRegistries.ENTITY_TYPE.getOptional(resourceLocation).orElse(null)) != null) {
            mutableComponentCopy.append(": ").append(Component.translatable(entityType.getDescriptionId()));
        }
        return mutableComponentCopy;
    }
}
