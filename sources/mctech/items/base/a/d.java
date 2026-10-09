package mctech.items.base.a;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/a/d.class */
public interface d {
    BlockPos a(ItemStack itemStack);

    int b(ItemStack itemStack);

    boolean c(ItemStack itemStack);

    int d(ItemStack itemStack);

    static d a(int i, BlockPos blockPos, int i2) {
        return new a(i, blockPos, i2);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/a/d$a.class */
    public static class a implements d {
        int a;
        boolean b = false;
        BlockPos c;
        int d;

        public a(int i, BlockPos blockPos, int i2) {
            this.a = i;
            this.c = blockPos;
            this.d = i2;
        }

        @Override // mctech.items.base.a.d
        public BlockPos a(ItemStack itemStack) {
            return this.c;
        }

        @Override // mctech.items.base.a.d
        public int b(ItemStack itemStack) {
            return this.d;
        }

        @Override // mctech.items.base.a.d
        public boolean c(ItemStack itemStack) {
            if (this.b) {
                return true;
            }
            this.b = true;
            return false;
        }

        @Override // mctech.items.base.a.d
        public int d(ItemStack itemStack) {
            return this.a;
        }
    }
}
