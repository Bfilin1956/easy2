package mctech.blocks.e;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/e/d.class */
public class d extends mctech.blocks.base.d {
    public d(float f, float f2) {
        super(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(f, f2).requiresCorrectToolForDrops());
    }

    @Override // mctech.blocks.base.a
    public mctech.items.base.g createItem() {
        return new mctech.items.base.g(this);
    }
}
