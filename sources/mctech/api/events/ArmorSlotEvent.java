package mctech.api.events;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import mctech.api.items.armor.IArmorModule;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.Event;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/events/ArmorSlotEvent.class */
public class ArmorSlotEvent extends Event {
    Item item;
    String id;
    EquipmentSlot slot;
    Object2IntMap<IArmorModule.ModuleType> slots;

    public ArmorSlotEvent(Item item, String str, EquipmentSlot equipmentSlot, Object2IntMap<IArmorModule.ModuleType> object2IntMap) {
        this.item = item;
        this.id = str;
        this.slot = equipmentSlot;
        this.slots = object2IntMap;
    }

    public Item getItem() {
        return this.item;
    }

    public String getId() {
        return this.id;
    }

    public EquipmentSlot getEquipmentSlot() {
        return this.slot;
    }

    public Object2IntMap<IArmorModule.ModuleType> getSlots() {
        return this.slots;
    }

    public void addSlots(IArmorModule.ModuleType moduleType, int i) {
        this.slots.computeInt(moduleType, (moduleType2, num) -> {
            return Integer.valueOf(Math.min(9, (num == null ? 0 : num.intValue()) + i));
        });
    }
}
