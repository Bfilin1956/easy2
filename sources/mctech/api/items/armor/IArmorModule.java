package mctech.api.items.armor;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/armor/IArmorModule.class */
public interface IArmorModule {

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/armor/IArmorModule$IArmorCapability.class */
    public interface IArmorCapability {
    }

    ModuleType getType(ItemStack itemStack);

    boolean canInstallInArmor(ItemStack itemStack, ItemStack itemStack2, EquipmentSlot equipmentSlot);

    void onInstall(ItemStack itemStack, ItemStack itemStack2, IArmorModuleHolder iArmorModuleHolder);

    void onUninstall(ItemStack itemStack, ItemStack itemStack2, IArmorModuleHolder iArmorModuleHolder);

    void transferToArmor(ItemStack itemStack, ItemStack itemStack2, ItemStack itemStack3);

    void onTick(ItemStack itemStack, ItemStack itemStack2, Level level, Player player);

    void onEquipped(ItemStack itemStack, ItemStack itemStack2, Player player);

    void onUnequipped(ItemStack itemStack, ItemStack itemStack2, Player player);

    void provideCapabilities(ItemStack itemStack, ItemStack itemStack2);

    boolean handlePacket(Player player, ItemStack itemStack, ItemStack itemStack2, String str, INetworkDataBuffer iNetworkDataBuffer, Dist dist);

    default void handleToolTip(ItemStack itemStack, Consumer<MutableComponent> consumer) {
        consumer.accept(Component.translatable("misc.mctech.module.slot_type", new Object[]{getType(itemStack).getName()}));
        MutableComponent mutableComponentLiteral = Component.literal("[");
        Component componentTranslatable = null;
        boolean z = true;
        for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
            if (equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR && canInstallInArmor(itemStack, itemStack, equipmentSlot)) {
                if (componentTranslatable != null) {
                    if (!z) {
                        mutableComponentLiteral.append(", ");
                    }
                    mutableComponentLiteral.append(componentTranslatable);
                    z = false;
                }
                componentTranslatable = Component.translatable("misc.mctech.module.valid_armor." + equipmentSlot.getName());
            }
        }
        if (componentTranslatable != null) {
            if (!z) {
                mutableComponentLiteral.append(", ");
            }
            consumer.accept(Component.translatable("misc.mctech.module.valid_armor", new Object[]{mutableComponentLiteral.append(componentTranslatable).append("]")}));
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/armor/IArmorModule$IArmorModuleHolder.class */
    public interface IArmorModuleHolder {
        public static final String DISABLE_MODULES = "no_modules";

        List<ItemStack> getInstalledModules(ItemStack itemStack);

        Object2IntMap<ModuleType> getModuleLimits(ItemStack itemStack);

        void addAddModifier(ItemStack itemStack, ArmorMod armorMod, int i);

        void addMulModifier(ItemStack itemStack, ArmorMod armorMod, float f);

        void removeAddModifier(ItemStack itemStack, ArmorMod armorMod, int i);

        void removeMulModifier(ItemStack itemStack, ArmorMod armorMod, float f);

        void onEquipmentStateChanged(ItemStack itemStack, boolean z, Player player);

        default boolean isValidModularArmor(ItemStack itemStack) {
            if (!(itemStack.getItem() instanceof IArmorModuleHolder)) {
                return false;
            }
            CompoundTag compoundTag = null;
            return 0 == 0 || !compoundTag.getBoolean(DISABLE_MODULES);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/armor/IArmorModule$ArmorMod.class */
    public static class ArmorMod {
        public static final ArmorMod ENERGY_STORAGE = new ArmorMod("storage_add", "storage_mul");
        public static final ArmorMod ENERGY_TIER = new ArmorMod("tier");
        public static final ArmorMod ENERGY_TRANSFER = new ArmorMod("transfer_add", "transfer_mul");
        public static final ArmorMod ENERGY_PROVIDER = new ArmorMod("provider");
        public static final ArmorMod NO_LAVA_DAMAGE = new ArmorMod("lava");
        public static final ArmorMod ENERGY_SHIELD = new ArmorMod("shield");
        public static final ArmorMod ENERGY_SHIELD_ALWAYS = new ArmorMod("shield_always");
        public static final ArmorMod EU_READER = new ArmorMod("eu_reader");
        public static final ArmorMod THERMOMETER = new ArmorMod("thermo");
        public static final ArmorMod HAZMAT_PROTECTION = new ArmorMod("hazmat");
        public static final ArmorMod HUD_ENERGY = new ArmorMod("armor_hud");
        public static final ArmorMod GOLDEN = new ArmorMod("golden");
        String add_mod;
        String mul_mod;

        public ArmorMod(String str) {
            this(str, null);
        }

        public ArmorMod(String str, String str2) {
            this.add_mod = str;
            this.mul_mod = str2;
        }

        public String getAdd() {
            return this.add_mod;
        }

        public String getMul() {
            return this.mul_mod;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/items/armor/IArmorModule$ModuleType.class */
    public static final class ModuleType implements Comparable<ModuleType> {
        private static final Map<String, ModuleType> TYPES = Object2ObjectMaps.synchronize(new Object2ObjectOpenHashMap());
        private static final AtomicInteger IDS = new AtomicInteger(1);
        public static final ModuleType BATTERY = getOrCreateType("battery", "misc.mctech.module.battery");
        public static final ModuleType HUD = getOrCreateType("hud", "misc.mctech.module.hud");
        public static final ModuleType ANY = getOrCreateType("any", "misc.mctech.module.any");
        public static final ModuleType GENERIC = getOrCreateType("generic", "misc.mctech.module.generic");
        public static final ModuleType CHARGER = getOrCreateType("charge", "misc.mctech.module.charger");
        public static final ModuleType STORAGE = getOrCreateType("storage", "misc.mctech.module.storage");
        public static final ModuleType BACK_SLOT = getOrCreateType("back_slot", "misc.mctech.module.back_slot");
        public static final ModuleType MOVEMENT = getOrCreateType("movement", "misc.mctech.module.movement");
        int index = IDS.getAndIncrement();
        String id;
        String name;

        ModuleType(String str, String str2) {
            this.id = str;
            this.name = str2;
        }

        public Component getName() {
            return Component.translatable(this.name);
        }

        public String getId() {
            return this.id;
        }

        public static ModuleType getType(String str) {
            return TYPES.get(str);
        }

        public static synchronized ModuleType getOrCreateType(String str, String str2) {
            ModuleType moduleType = TYPES.get(str);
            if (moduleType == null) {
                moduleType = new ModuleType(str, str2);
                TYPES.put(str, moduleType);
            }
            return moduleType;
        }

        public static List<ModuleType> getAllTypes() {
            return new ObjectArrayList(TYPES.values());
        }

        @Override // java.lang.Comparable
        public int compareTo(ModuleType moduleType) {
            return Integer.compareUnsigned(this.index, moduleType.index);
        }
    }
}
