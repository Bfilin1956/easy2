package mctech.i;

import java.util.Locale;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/i/i.class */
public enum i implements StringRepresentable {
    FLUID_GENERATOR,
    COBBLESTONE_GENERATOR,
    PLASMA_GENERATOR,
    FLUID_TANK,
    ASSEMBLY_STATION,
    ORE_MACERATOR,
    ATOMIC_SMELTER,
    MOLECULAR_CONVERTER,
    MATRIX_CONVERTER,
    QUANTUM_GENERATOR,
    QUANTUM_WORKBENCH,
    TRANSFORMATION_ASSEMBLER;

    public static final EnumProperty<i> m = EnumProperty.create("machine_type", i.class);

    @NotNull
    public String getSerializedName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
