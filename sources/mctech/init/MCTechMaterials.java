package mctech.init;

import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import mctech.MCTech;
import mctech.utils.a.b;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechMaterials.class */
public final class MCTechMaterials {
    private static final DeferredRegister<ArmorMaterial> MATERIAL = DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, MCTech.MODID);
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> SINGULAR_ARMOR = register("quantum", () -> {
        return new ArmorMaterial(Map.of(ArmorItem.Type.BOOTS, 999, ArmorItem.Type.LEGGINGS, 999, ArmorItem.Type.CHESTPLATE, 999, ArmorItem.Type.HELMET, 999, ArmorItem.Type.BODY, 999), 10, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> {
            return Ingredient.EMPTY;
        }, List.of(new ArmorMaterial.Layer(MCTech.loc("quantum"), "", true), new ArmorMaterial.Layer(MCTech.loc("quantum"), "_overlay", false)), 2.0f, 0.0f);
    });
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> BRONZE_ARMOR = register("bronze", () -> {
        return new ArmorMaterial((Map) Util.make(new EnumMap(ArmorItem.Type.class), enumMap -> {
            enumMap.put(ArmorItem.Type.BOOTS, 3);
            enumMap.put(ArmorItem.Type.LEGGINGS, 6);
            enumMap.put(ArmorItem.Type.CHESTPLATE, 8);
            enumMap.put(ArmorItem.Type.HELMET, 3);
            enumMap.put(ArmorItem.Type.BODY, 11);
        }), 9, SoundEvents.ARMOR_EQUIP_IRON, () -> {
            return Ingredient.of(new ItemLike[]{MCTechItems.INGOT_BRONZE});
        }, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "bronze"), "", true), new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "bronze"), "_overlay", false)), 0.0f, 0.0f);
    });
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> COMPOSITE_ARMOR = register("composite", () -> {
        return new ArmorMaterial((Map) Util.make(new EnumMap(ArmorItem.Type.class), enumMap -> {
            enumMap.put(ArmorItem.Type.BOOTS, 4);
            enumMap.put(ArmorItem.Type.LEGGINGS, 7);
            enumMap.put(ArmorItem.Type.CHESTPLATE, 9);
            enumMap.put(ArmorItem.Type.HELMET, 4);
            enumMap.put(ArmorItem.Type.BODY, 12);
        }), 12, SoundEvents.ARMOR_EQUIP_IRON, () -> {
            return Ingredient.of(new ItemLike[]{MCTechItems.INGOT_ADVANCED_ALLOY});
        }, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "composite"), "", true), new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "composite"), "_overlay", false)), 3.0f, 0.2f);
    });
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> HAZMAT_ARMOR = register("hazmat", () -> {
        return new ArmorMaterial((Map) Util.make(new EnumMap(ArmorItem.Type.class), enumMap -> {
            enumMap.put(ArmorItem.Type.BOOTS, 3);
            enumMap.put(ArmorItem.Type.LEGGINGS, 6);
            enumMap.put(ArmorItem.Type.CHESTPLATE, 8);
            enumMap.put(ArmorItem.Type.HELMET, 3);
            enumMap.put(ArmorItem.Type.BODY, 11);
        }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> {
            return Ingredient.of(new ItemLike[]{MCTechItems.RUBBER});
        }, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "hazmat"), "", true), new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "hazmat"), "_overlay", false)), 2.0f, 0.0f);
    });
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ELECTRIC_ARMOR = register("electric", () -> {
        return new ArmorMaterial((Map) Util.make(new EnumMap(ArmorItem.Type.class), enumMap -> {
            enumMap.put(ArmorItem.Type.BOOTS, 3);
            enumMap.put(ArmorItem.Type.LEGGINGS, 6);
            enumMap.put(ArmorItem.Type.CHESTPLATE, 8);
            enumMap.put(ArmorItem.Type.HELMET, 3);
            enumMap.put(ArmorItem.Type.BODY, 11);
        }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> {
            return Ingredient.EMPTY;
        }, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "electric"), "", true), new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "electric"), "_overlay", false)), 2.0f, 0.0f);
    });
    public static final Holder<ArmorMaterial> ADVANCED_ARMOR = MATERIAL.register("advanced_armor", () -> {
        return new ArmorMaterial((Map) Util.make(new EnumMap(ArmorItem.Type.class), enumMap -> {
            enumMap.put(ArmorItem.Type.BOOTS, 3);
            enumMap.put(ArmorItem.Type.LEGGINGS, 6);
            enumMap.put(ArmorItem.Type.CHESTPLATE, 8);
            enumMap.put(ArmorItem.Type.HELMET, 3);
            enumMap.put(ArmorItem.Type.BODY, 11);
        }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> {
            return Ingredient.EMPTY;
        }, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "advanced_armor"))), 0.0f, 2.0f);
    });
    public static final List<WoodType> ALL_TYPES = ObjectLists.synchronize(b.i());
    public static final WoodType SIGN_RUBBER_WOOD = create("mctech:rubberwood_sign");
    public static final WoodType SIGN_COPPER = create("mctech:copper_sign");
    public static final WoodType SIGN_ALUMINIUM = create("mctech:aluminium_sign");
    public static final WoodType SIGN_TIN = create("mctech:tin_sign");
    public static final WoodType SIGN_SILVER = create("mctech:silver_sign");
    public static final WoodType SIGN_BRONZE = create("mctech:bronze_sign");
    public static final WoodType SIGN_REFINED_IRON = create("mctech:refined_iron_sign");

    public static void register(IEventBus iEventBus) {
        MATERIAL.register(iEventBus);
    }

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> register(String str, Supplier<ArmorMaterial> supplier) {
        return MATERIAL.register(str, supplier);
    }

    public static WoodType create(String str) {
        return null;
    }
}
