package mctech.i;

import java.util.Locale;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/i/c.class */
public enum c implements StringRepresentable {
    WATER("water"),
    LAVA("lava");

    public final String c;
    public static final EnumProperty<c> d = EnumProperty.create("fluid_type", c.class);

    c(String str) {
        this.c = str;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public Fluid a() throws MatchException {
        switch (this) {
            case WATER:
                return Fluids.WATER;
            case LAVA:
                return Fluids.LAVA;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public TagKey<Fluid> b() throws MatchException {
        switch (this) {
            case WATER:
                return FluidTags.WATER;
            case LAVA:
                return FluidTags.LAVA;
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public String c() throws MatchException {
        switch (this) {
            case WATER:
                return "water";
            case LAVA:
                return "lava";
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public String d() throws MatchException {
        switch (this) {
            case WATER:
                return "воды";
            case LAVA:
                return "лавы";
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    @NotNull
    public String getSerializedName() {
        return name().toLowerCase(Locale.ROOT);
    }
}
