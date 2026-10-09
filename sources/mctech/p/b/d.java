package mctech.p.b;

import mctech.blockentities.i;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/b/d.class */
public class d extends i {
    private BlockPos a;

    public d(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.a = BlockPos.ZERO;
    }

    public void a(@NotNull BlockPos blockPos) {
        this.a = blockPos;
        setChanged();
    }

    @Nullable
    public BlockPos a() {
        if (this.a == null || this.a.equals(BlockPos.ZERO)) {
            return null;
        }
        return this.a;
    }

    public boolean b() {
        return a() != null;
    }

    @NotNull
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        CompoundTag updateTag = super.getUpdateTag(provider);
        if (b()) {
            updateTag.putLong("masterPosition", this.a.asLong());
        }
        return updateTag;
    }

    @Override // mctech.blockentities.i
    public void handleUpdateTag(@NotNull CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.handleUpdateTag(compoundTag, provider);
        if (compoundTag.contains("masterPosition")) {
            this.a = BlockPos.of(compoundTag.getLong("masterPosition"));
        } else {
            this.a = BlockPos.ZERO;
        }
    }
}
