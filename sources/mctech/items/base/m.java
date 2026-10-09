package mctech.items.base;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/m.class */
public class m extends Item {
    private b a;
    private Object b;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/m$b.class */
    public enum b {
        STORAGE,
        DAY,
        NIGHT,
        TRANSFORMATOR,
        ISNIGHT,
        UNIVERSAL_GEN,
        AE_CONVERTER
    }

    private m(a aVar) {
        super(new Item.Properties());
        this.a = aVar.a;
        this.b = aVar.b;
    }

    public int getMaxStackSize(ItemStack itemStack) {
        return 1;
    }

    public b a() {
        return this.a;
    }

    public void a(mctech.blockentities.b.a aVar) {
        switch (this.a) {
            case STORAGE:
                aVar.b(((Integer) this.b).intValue());
                break;
            case DAY:
                aVar.a(((Float) this.b).floatValue());
                break;
            case NIGHT:
                aVar.b(((Float) this.b).floatValue());
                break;
            case TRANSFORMATOR:
                aVar.p();
                break;
            case UNIVERSAL_GEN:
                aVar.a(((Float) this.b).floatValue());
                aVar.b(((Float) this.b).floatValue());
                break;
            case AE_CONVERTER:
                aVar.o();
                break;
        }
    }

    public static a a(b bVar) {
        return new a(bVar);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/m$a.class */
    public static class a {
        private final b a;
        private Object b;

        private a(b bVar) {
            this.a = bVar;
        }

        public a a(Object obj) {
            this.b = obj;
            return this;
        }

        public m a() {
            return new m(this);
        }
    }
}
