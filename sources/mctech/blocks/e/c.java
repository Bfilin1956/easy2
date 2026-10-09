package mctech.blocks.e;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/e/c.class */
public class c extends mctech.blocks.base.d {
    public c(float f, float f2, boolean z) {
        super(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(z ? MapColor.DEEPSLATE : MapColor.STONE).strength(f, f2).requiresCorrectToolForDrops());
    }

    @Override // mctech.blocks.base.a
    public mctech.items.base.g createItem() {
        return new mctech.items.base.g(this);
    }
}
