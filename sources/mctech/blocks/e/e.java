package mctech.blocks.e;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/e/e.class */
public class e extends mctech.blocks.base.d {
    public e(a aVar) {
        super(a(aVar));
    }

    private static BlockBehaviour.Properties a(a aVar) {
        return BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(aVar.d, aVar.e).requiresCorrectToolForDrops();
    }

    @Override // mctech.blocks.base.a
    public mctech.items.base.g createItem() {
        return new mctech.items.base.g(this);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/e/e$a.class */
    public static class a {
        public static final a a = new a(5.0f, 6.0f);
        public static final a b = new a(4.0f, 6.0f);
        public static final a c = new a(5.0f, 6.0f);
        float d;
        float e;

        public a(float f, float f2) {
            this.d = f;
            this.e = f2;
        }
    }
}
