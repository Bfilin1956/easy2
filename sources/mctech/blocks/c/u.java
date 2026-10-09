package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.api.blocks.IBlockDropProvider;
import mctech.blocks.base.blocks.BaseFacingBlock;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/u.class */
public class u extends BaseFacingBlock<mctech.blockentities.q> {
    public static final MapCodec<u> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(IBlockDropProvider.CODEC.fieldOf("drop").forGetter((v0) -> {
            return v0.getDropProvider();
        })).apply(instance, u::new);
    });

    public u(IBlockDropProvider iBlockDropProvider) {
        super(mctech.blocks.b.b);
        setDropProvider(iBlockDropProvider);
    }

    public u(IBlockDropProvider iBlockDropProvider, BlockBehaviour.Properties properties) {
        super(properties);
        setDropProvider(iBlockDropProvider);
    }

    protected MapCodec<? extends BaseEntityBlock> codec() {
        return a;
    }
}
