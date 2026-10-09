package mctech.k;

import mctech.init.MCTechDataComponent;
import mctech.init.MCTechItems;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/k/b.class */
public final class b {
    private b() {
    }

    public static ItemStack a(EntityType<?> entityType) {
        ItemStack itemStack = new ItemStack((ItemLike) MCTechItems.GENETIC_MATERIAL.get());
        itemStack.set((DataComponentType) MCTechDataComponent.ENTITY_TYPE.get(), BuiltInRegistries.ENTITY_TYPE.getKey(entityType));
        return itemStack;
    }

    public static ItemStack a(ResourceLocation resourceLocation, float f) {
        return a(resourceLocation, f, 0.0f, 1);
    }

    public static ItemStack a(ResourceLocation resourceLocation, float f, float f2, int i) {
        ItemStack itemStack = new ItemStack((ItemLike) MCTechItems.DNA_SAMPLE.get());
        itemStack.set((DataComponentType) MCTechDataComponent.ENTITY_TYPE.get(), resourceLocation);
        itemStack.set((DataComponentType) MCTechDataComponent.BASE_CHANCE.get(), Float.valueOf(a(f)));
        itemStack.set((DataComponentType) MCTechDataComponent.BONUS_CHANCE.get(), Float.valueOf(b(f2)));
        itemStack.set((DataComponentType) MCTechDataComponent.LUCK_LEVEL.get(), Integer.valueOf(b(i)));
        return itemStack;
    }

    public static ItemStack a(ResourceLocation resourceLocation, RandomSource randomSource) {
        return a(resourceLocation, randomSource.nextIntBetweenInclusive(a.h(), a.i()), 0.0f, 1);
    }

    public static ItemStack a(ItemStack itemStack, float f, float f2, int i) {
        ResourceLocation resourceLocationA = a(itemStack);
        if (resourceLocationA == null) {
            return ItemStack.EMPTY;
        }
        return a(resourceLocationA, f, f2, i);
    }

    @Nullable
    public static ResourceLocation a(ItemStack itemStack) {
        return (ResourceLocation) itemStack.get((DataComponentType) MCTechDataComponent.ENTITY_TYPE.get());
    }

    public static boolean b(ItemStack itemStack) {
        return itemStack.has((DataComponentType) MCTechDataComponent.BASE_CHANCE.get()) || itemStack.has((DataComponentType) MCTechDataComponent.BONUS_CHANCE.get()) || itemStack.has((DataComponentType) MCTechDataComponent.LUCK_LEVEL.get());
    }

    public static float c(ItemStack itemStack) {
        Float f = (Float) itemStack.get((DataComponentType) MCTechDataComponent.BASE_CHANCE.get());
        if (f == null) {
            return 0.0f;
        }
        return a(f.floatValue());
    }

    public static float d(ItemStack itemStack) {
        Float f = (Float) itemStack.get((DataComponentType) MCTechDataComponent.BONUS_CHANCE.get());
        if (f == null) {
            return 0.0f;
        }
        return b(f.floatValue());
    }

    public static int e(ItemStack itemStack) {
        Integer num = (Integer) itemStack.get((DataComponentType) MCTechDataComponent.LUCK_LEVEL.get());
        if (num == null) {
            return 1;
        }
        return b(num.intValue());
    }

    public static float f(ItemStack itemStack) {
        return Math.min(c(itemStack) + d(itemStack), 100.0f);
    }

    public static float a(int i) {
        float fB = (b(i) + a.v()) / 100.0f;
        return (a.u() * fB * fB) + a.w();
    }

    public static int a(int i, int i2) {
        if (i <= 0) {
            return 0;
        }
        return Math.max(1, (int) (i * a(i2)));
    }

    public static boolean g(ItemStack itemStack) {
        return d(itemStack) >= a.o() && e(itemStack) >= a.p();
    }

    public static float a(float f) {
        return Mth.clamp(f, a.h(), a.i());
    }

    public static float b(float f) {
        return Mth.clamp(f, 0.0f, a.o());
    }

    public static int b(int i) {
        return Mth.clamp(i, 1, a.p());
    }
}
