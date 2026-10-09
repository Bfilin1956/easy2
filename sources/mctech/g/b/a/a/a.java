package mctech.g.b.a.a;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/a.class */
public class a {
    @SafeVarargs
    public static <T extends BlockEntity> T a(RegistryFriendlyByteBuf registryFriendlyByteBuf, Level level, BlockEntityType<? extends T>... blockEntityTypeArr) {
        if (registryFriendlyByteBuf == null) {
            throw new IllegalArgumentException("Null packet buffer when opening menu!");
        }
        BlockPos blockPos = registryFriendlyByteBuf.readBlockPos();
        if (!level.isLoaded(blockPos)) {
            throw new IllegalStateException("Unable to open menu for block at " + String.valueOf(blockPos) + " as it is not loaded on the client!");
        }
        T t = (T) level.getBlockEntity(blockPos);
        if (t == null) {
            throw new IllegalStateException("Unable to find block entity at " + String.valueOf(blockPos) + " on the client!");
        }
        for (BlockEntityType<? extends T> blockEntityType : blockEntityTypeArr) {
            if (t.getType() == blockEntityType) {
                return t;
            }
        }
        throw new IllegalStateException("Block entity at " + String.valueOf(blockPos) + " is the wrong type on the client!");
    }
}
