package mctech.blocks;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mctech.blockentities.q;
import mctech.blocks.base.blocks.BaseActivityBlock;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/b.class */
public class b extends BaseActivityBlock<q> {
    public static final MapCodec<b> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(propertiesCodec()).apply(instance, b::new);
    });
    public static final BlockBehaviour.Properties b = BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(5.0f, 25.0f).requiresCorrectToolForDrops();

    public b() {
        this(b);
    }

    public b(BlockBehaviour.Properties properties) {
        super(properties);
    }

    protected MapCodec<? extends BaseEntityBlock> codec() {
        return a;
    }
}
