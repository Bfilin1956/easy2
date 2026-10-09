package mctech.m.c;

import mctech.api.items.IAutoEatable;
import mctech.api.items.IFuelableItem;
import mctech.api.items.ITagBlock;
import mctech.api.items.ITagItem;
import mctech.api.items.IWindmillBlade;
import mctech.api.items.ItemRegistries;
import mctech.api.items.electric.IElectricEnchantable;
import mctech.api.items.readers.IEUReader;
import mctech.api.items.readers.IThermometer;
import mctech.init.MCTechTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/r.class */
public class r {
    static g a;
    static g[] b = null;
    public static final g c = itemStack -> {
        return false;
    };
    public static final g d = itemStack -> {
        return true;
    };
    public static final g e = itemStack -> {
        return !itemStack.isEmpty();
    };
    public static final g f = itemStack -> {
        return (itemStack.isEmpty() || (itemStack.getItem() instanceof ITagItem)) ? false : true;
    };
    public static final g g = itemStack -> {
        return ItemRegistries.isBoxable(itemStack) || itemStack.is(MCTechTags.TOOLBOX);
    };
    public static final g h = itemStack -> {
        return Block.byItem(itemStack.getItem()) != Blocks.AIR;
    };
    public static final g i = itemStack -> {
        return Block.byItem(itemStack.getItem()) != Blocks.AIR || (itemStack.getItem() instanceof ITagBlock);
    };
    public static final g j = itemStack -> {
        return itemStack.getItem() == Items.BOOK || itemStack.getItem() == Items.ENCHANTED_BOOK;
    };
    public static final g k = itemStack -> {
        return itemStack.getItem() == Items.BOOK || itemStack.getItem() == Items.ENCHANTED_BOOK || itemStack.getItem().isEnchantable(itemStack) || (itemStack.getItem() instanceof IElectricEnchantable);
    };
    public static final g l = itemStack -> {
        IAutoEatable item = itemStack.getItem();
        return (item instanceof IAutoEatable) && item.canAutoEat(itemStack);
    };
    public static final g m = itemStack -> {
        return false;
    };
    public static final g n = itemStack -> {
        return itemStack.getItem() instanceof mctech.items.base.a.a;
    };
    public static final g o = itemStack -> {
        return (itemStack.getItem() instanceof IFuelableItem) && itemStack.getItem().hasFuel(itemStack);
    };
    public static final g p = IEUReader::isEUReaderImpl;
    public static final g q = IThermometer::isThermometerImpl;
    public static final g r = itemStack -> {
        return itemStack.getItem() instanceof IWindmillBlade;
    };
    public static final g s = itemStack -> {
        return false;
    };
    public static final g t = itemStack -> {
        return false;
    };

    public static g a() {
        if (a == null) {
            a = new b(mctech.m.c.a.c.d, new q(Items.REDSTONE));
        }
        return a;
    }

    public static g a(DyeColor dyeColor) {
        if (b == null) {
            b = new g[16];
            for (DyeColor dyeColor2 : DyeColor.values()) {
                b[dyeColor2.getId()] = new t(ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", "dyes/" + dyeColor2.getName())));
            }
        }
        return b[dyeColor.getId()];
    }

    public static DyeColor a(DyeColor dyeColor, boolean z) {
        if (dyeColor != null) {
            if (z && dyeColor == DyeColor.BLACK) {
                return null;
            }
            return DyeColor.byId(dyeColor.getId() + 1);
        }
        if (!z) {
            throw new IllegalStateException("Null Color is not allowed");
        }
        return DyeColor.WHITE;
    }

    public static DyeColor b(DyeColor dyeColor, boolean z) {
        if (dyeColor != null) {
            if (dyeColor != DyeColor.WHITE) {
                return DyeColor.byId(dyeColor.getId() - 1);
            }
            if (z) {
                return null;
            }
            return DyeColor.BLACK;
        }
        if (!z) {
            throw new IllegalStateException("Null Color is not allowed");
        }
        return DyeColor.BLACK;
    }

    public static ItemStack b(DyeColor dyeColor) {
        return ItemStack.EMPTY;
    }
}
