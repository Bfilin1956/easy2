package mctech.api.items;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/IDrinkableFluid.class */
public abstract class IDrinkableFluid {
    public static final Map<ResourceLocation, IDrinkableFluid> REGISTRY = new Object2ObjectOpenHashMap();
    ResourceLocation id;

    public abstract boolean drink(ItemStack itemStack, Level level, Player player);

    public IDrinkableFluid(ResourceLocation resourceLocation) {
        this.id = resourceLocation;
        if (REGISTRY.put(resourceLocation, this) != null) {
            throw new IllegalStateException("Duplicated Drinkable Fluids are not allowed");
        }
    }

    public boolean hasSpecialName() {
        return false;
    }

    public Component getSpecialName(ItemStack itemStack) {
        return null;
    }

    public List<ItemStack> generateSubStates(ItemStack itemStack, boolean z) {
        return Collections.singletonList(itemStack);
    }

    public int getTextureIndex(ItemStack itemStack) {
        return 0;
    }

    public final ResourceLocation getID() {
        return this.id;
    }

    public final int hashCode() {
        return this.id.hashCode();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof IDrinkableFluid) && ((IDrinkableFluid) obj).getID().equals(getID());
    }
}
