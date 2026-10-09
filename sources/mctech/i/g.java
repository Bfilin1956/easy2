package mctech.i;

import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/i/g.class */
public interface g {
    @Nullable
    c g();

    @NotNull
    MachineTier machineTier();

    float e();

    float f();

    @NotNull
    default Fluid N_() {
        c cVarG = g();
        if (cVarG == null) {
            throw new NullPointerException("Did you forgot to override getFluid() while passing NULL as fluidType?");
        }
        return cVarG.a();
    }

    @NotNull
    default TagKey<Fluid> h() {
        c cVarG = g();
        if (cVarG == null) {
            throw new NullPointerException("Did you forgot to override fluidTag() while passing NULL as fluidType?");
        }
        return cVarG.b();
    }
}
