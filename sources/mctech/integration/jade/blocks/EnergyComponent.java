package mctech.integration.jade.blocks;

import mctech.integration.jade.core.BlockComponent;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.ITooltip;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/jade/blocks/EnergyComponent.class */
public class EnergyComponent extends BlockComponent {
    public static final EnergyComponent INSTANCE = new EnergyComponent();

    @Override // mctech.integration.jade.core.BlockComponent
    public boolean requireEUReader() {
        return true;
    }

    @Override // mctech.integration.jade.core.BlockComponent
    public void append(ITooltip iTooltip, BlockAccessor blockAccessor, CompoundTag compoundTag) {
        tooltipGroup(iTooltip, Component.literal("Энергия").withStyle(ChatFormatting.RED), 1145508884, (iTooltip2, compoundTag2) -> {
            String str;
            if (compoundTag2.contains("energy_input_tier")) {
                iTooltip2.add(text(Component.literal(String.format("Входной тир: T%s", Integer.valueOf(compoundTag2.getInt("energy_input_tier"))))));
            }
            if (compoundTag2.contains("energy_input")) {
                iTooltip2.add(text(Component.literal(String.format("Макс. вход: %s EU", Integer.valueOf(compoundTag2.getInt("energy_input"))))));
            }
            if (compoundTag2.contains("energy_output_tier")) {
                iTooltip2.add(text(Component.literal(String.format("Выходной тир: T%s", Integer.valueOf(compoundTag2.getInt("energy_output_tier"))))));
            }
            if (compoundTag2.contains("energy_output")) {
                iTooltip2.add(text(Component.literal(String.format("Макс. выход: %s EU", Integer.valueOf(compoundTag2.getInt("energy_output"))))));
            }
            if (compoundTag2.contains("energy_multiplier")) {
                iTooltip2.add(text(Component.literal(String.format("Множитель размножения: %sX", Integer.valueOf(compoundTag2.getInt("energy_multiplier"))))));
            }
            if (compoundTag2.contains("energy_output_passive")) {
                iTooltip2.add(text(Component.literal(String.format("Пассивная энергия: %s EU/t", Float.valueOf(compoundTag2.getFloat("energy_output_passive"))))));
            }
            if (compoundTag2.contains("energy_packets")) {
                iTooltip2.add(text(Component.literal(String.format("Выходные пакеты: %s", Integer.valueOf(compoundTag2.getInt("energy_packets"))))));
            }
            if (compoundTag2.contains("energy_transfer_limit")) {
                iTooltip2.add(text(Component.literal(String.format("Индуктивность: %s EU", Integer.valueOf(compoundTag2.getInt("energy_transfer_limit"))))));
            }
            if (compoundTag2.contains("energy_transfer_radius")) {
                iTooltip2.add(text(Component.literal(String.format("Радиус индуктивности: %s блок(ов)", Integer.valueOf(compoundTag2.getInt("energy_transfer_radius"))))));
            }
            if (compoundTag2.contains("energyElectrolyzerCanPower") && compoundTag2.contains("energyElectrolyzerShouldDrain")) {
                boolean z = compoundTag2.getBoolean("energyElectrolyzerCanPower");
                boolean z2 = compoundTag2.getBoolean("energyElectrolyzerShouldDrain");
                if (z) {
                    str = z2 ? "transfer" : "discharging";
                } else {
                    str = z2 ? "charging" : "nothing";
                }
                iTooltip2.add(text(Component.translatable("mctech.probe.electrolyzer." + str + ".name")));
            }
            if (compoundTag2.contains("energy_eta")) {
                iTooltip2.add(text(Component.literal("Зарядится через ").append(Component.literal(compoundTag2.getString("energy_eta")))));
            }
            if (compoundTag2.contains("energy_stored") && compoundTag2.contains("energy_capacity")) {
                energyStorage(iTooltip2, compoundTag2.getInt("energy_stored"), compoundTag2.getInt("energy_capacity"), compoundTag2.contains("energy_unit") ? compoundTag2.getString("energy_unit") : "EU");
            }
        }, compoundTag, !compoundTag.isEmpty());
    }

    public int getDefaultPriority() {
        return -10000;
    }

    public ResourceLocation getUid() {
        return makeId(this);
    }
}
