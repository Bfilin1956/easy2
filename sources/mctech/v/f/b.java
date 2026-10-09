package mctech.v.f;

import javax.annotation.Nullable;
import mctech.MCTech;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoAnimatable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/v/f/b.class */
public interface b extends GeoAnimatable {
    public static final ResourceLocation q = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "animations/block.animation.json");

    ResourceLocation c();

    ResourceLocation a(@Nullable BlockState blockState);

    default ResourceLocation s_() {
        return q;
    }

    @Nullable
    default BlockState getBlockState() {
        return null;
    }

    default boolean K_() {
        return false;
    }

    default int i() {
        return 0;
    }
}
