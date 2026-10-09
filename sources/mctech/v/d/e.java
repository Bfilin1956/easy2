package mctech.v.d;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import java.util.Map;
import mctech.init.MCTechDataComponent;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.neoforge.client.IItemDecorator;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/d/e.class */
public final class e implements IItemDecorator {
    public static final e a = new e();
    private static final float b = 0.35f;
    private static final int c = 200;
    private static final int d = 16;
    private final Map<ResourceLocation, ItemStack> e = new HashMap();
    private final Map<ResourceLocation, Boolean> f = new HashMap();

    private e() {
    }

    public boolean render(GuiGraphics guiGraphics, Font font, ItemStack itemStack, int i, int i2) {
        ResourceLocation resourceLocation;
        if (!itemStack.has((DataComponentType) MCTechDataComponent.ENTITY_TYPE.get()) || (resourceLocation = (ResourceLocation) itemStack.get((DataComponentType) MCTechDataComponent.ENTITY_TYPE.get())) == null || ((EntityType) BuiltInRegistries.ENTITY_TYPE.getOptional(resourceLocation).orElse(null)) == null) {
            return false;
        }
        ItemStack itemStackComputeIfAbsent = this.e.computeIfAbsent(resourceLocation, this::a);
        if (itemStackComputeIfAbsent.isEmpty()) {
            return false;
        }
        int i3 = (i2 + 8) - 2;
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(0.0f, 0.0f, 200.0f);
        int i4 = (i2 + 8) - 3;
        guiGraphics.fill(i + 1, i4, (i + 16) - 1, i4 + 8, -2138285252);
        guiGraphics.fill(i + 2, i4 + 1, (i + 16) - 1, i4 + 8, -2139993300);
        guiGraphics.fill(i + 2, i4 + (8 - 1), (i + 16) - 1, i4 + 8, -2142950885);
        guiGraphics.fill((i + 16) - 2, i4, (i + 16) - 1, i4 + 8, -2142950885);
        guiGraphics.pose().popPose();
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate((i + 8) - 2, (i2 + 8) - 2, 200.0f);
        guiGraphics.pose().scale(b, b, b);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 0.5f);
        guiGraphics.renderItem(itemStackComputeIfAbsent, 0, 0);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        guiGraphics.pose().popPose();
        return true;
    }

    private ItemStack a(ResourceLocation resourceLocation) {
        EntityType entityType = (EntityType) BuiltInRegistries.ENTITY_TYPE.getOptional(resourceLocation).orElse(null);
        if (entityType == null) {
            return ItemStack.EMPTY;
        }
        Item itemA = a((EntityType<?>) entityType);
        if (itemA != null) {
            return new ItemStack(itemA);
        }
        SpawnEggItem spawnEggItemById = SpawnEggItem.byId(entityType);
        if (spawnEggItemById != null) {
            return new ItemStack(spawnEggItemById);
        }
        return new ItemStack(Items.BARRIER);
    }

    @Nullable
    private static Item a(EntityType<?> entityType) {
        switch (BuiltInRegistries.ENTITY_TYPE.getKey(entityType).toString()) {
            case "minecraft:zombie":
                return Items.ZOMBIE_HEAD;
            case "minecraft:skeleton":
                return Items.SKELETON_SKULL;
            case "minecraft:wither_skeleton":
                return Items.WITHER_SKELETON_SKULL;
            case "minecraft:creeper":
                return Items.CREEPER_HEAD;
            case "minecraft:ender_dragon":
                return Items.DRAGON_HEAD;
            case "minecraft:piglin":
                return Items.PIGLIN_HEAD;
            case "minecraft:player":
                return Items.PLAYER_HEAD;
            default:
                return null;
        }
    }

    public void a() {
        this.e.clear();
    }
}
