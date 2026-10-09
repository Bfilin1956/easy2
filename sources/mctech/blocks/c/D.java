package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.blocks.base.blocks.BaseFacingBlock;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/D.class */
public class D extends BaseFacingBlock<mctech.blockentities.b.g> {
    public static final MapCodec<D> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(propertiesCodec()).apply(instance, D::new);
    });

    public D() {
        this(mctech.blocks.b.b);
    }

    public D(BlockBehaviour.Properties properties) {
        super(properties);
    }

    protected MapCodec<? extends BaseEntityBlock> codec() {
        return a;
    }
}
