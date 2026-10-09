package mctech.items.g.a;

import java.util.Arrays;
import mctech.MCTech;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/a/d.class */
public enum d implements StringRepresentable {
    NIGHT_VISION("night_vision"),
    AUTO_FEED("auto_feed"),
    XRAY("xray"),
    XRAY_VISION("xray_vision"),
    FLIGHT("flight"),
    FLY_BOOST("fly_boost"),
    SPRINT("sprint"),
    WALK_CHARGE("walk_charge"),
    FALL_PROTECTION("fall_protection"),
    DAMAGE_ABSORB("damage_absorb"),
    THORNS("thorns"),
    JUMP_BOOST("jump_boost"),
    MOVEMENT_SPEED("movement_speed"),
    HEALTH_BOOST("health_boost"),
    REGENERATION("regeneration"),
    KNOCKBACK_RESISTANCE("knockback_resistance"),
    WATER_BREATHING("water_breathing"),
    HEAT_SAVING("heat_saving");

    public static final d[] s;
    private final String t;

    static {
        d[] dVarArrValues;
        if (MCTech.isFrozen()) {
            dVarArrValues = values();
        } else {
            dVarArrValues = (d[]) Arrays.stream(values()).filter(dVar -> {
                return dVar != HEAT_SAVING;
            }).toArray(i -> {
                return new d[i];
            });
        }
        s = dVarArrValues;
    }

    d(String str) {
        this.t = str;
    }

    @NotNull
    public String getSerializedName() {
        return this.t;
    }
}
