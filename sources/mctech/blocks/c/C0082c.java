package mctech.blocks.c;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

/* JADX INFO: renamed from: mctech.blocks.c.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/c.class */
public class C0082c extends mctech.blocks.b {
    public static final MapCodec<C0082c> c = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(propertiesCodec()).apply(instance, C0082c::new);
    });
    public static final BlockBehaviour.Properties d = BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(5.0f, 25.0f).requiresCorrectToolForDrops();

    public C0082c() {
        this(d);
    }

    public C0082c(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override // mctech.blocks.b
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return c;
    }
}
