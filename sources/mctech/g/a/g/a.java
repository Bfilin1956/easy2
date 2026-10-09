package mctech.g.a.g;

import java.util.List;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/g/a.class */
public interface a {
    default List<BakedQuad> a(Holder<mctech.g.a.a<?, ?>> holder, @Nullable CompoundTag compoundTag, @Nullable Direction direction, Direction direction2, RandomSource randomSource, @Nullable RenderType renderType) {
        return List.of();
    }

    default ResourceLocation a(Holder<mctech.g.a.a<?, ?>> holder, @Nullable CompoundTag compoundTag) {
        return ((mctech.g.a.a) holder.value()).a();
    }

    default List<ModelResourceLocation> a() {
        return List.of();
    }
}
