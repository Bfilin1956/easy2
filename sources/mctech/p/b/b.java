package mctech.p.b;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mctech.p.a.h;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.MustBeInvokedByOverriders;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/b/b.class */
public class b extends BlockEntity {
    private BlockPos a;
    private ResourceLocation b;
    private Vec3i c;
    private boolean d;
    private List<h> e;
    private ItemStack f;

    public b(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.a = BlockPos.ZERO;
        this.c = Vec3i.ZERO;
        this.e = new ArrayList();
        this.f = ItemStack.EMPTY;
    }

    public b a(ResourceLocation resourceLocation) {
        this.b = resourceLocation;
        setChanged();
        return this;
    }

    public b a(@NotNull BlockPos blockPos) {
        this.a = blockPos;
        setChanged();
        return this;
    }

    public b a(@NotNull Vec3i vec3i) {
        this.c = vec3i;
        setChanged();
        return this;
    }

    public b a(boolean z) {
        this.d = z;
        setChanged();
        return this;
    }

    public b a(@NotNull List<h> list) {
        this.e = list;
        setChanged();
        return this;
    }

    public b a(@NotNull ItemStack itemStack) {
        this.f = itemStack.copyWithCount(1);
        setChanged();
        return this;
    }

    @Nullable
    public BlockPos e() {
        if (this.a == null || this.a.equals(BlockPos.ZERO)) {
            return null;
        }
        return this.a;
    }

    @Nullable
    public ResourceLocation f() {
        return this.b;
    }

    @Nullable
    public Vec3i g() {
        if (this.c == null || this.c.equals(Vec3i.ZERO)) {
            return null;
        }
        return this.c;
    }

    public List<h> h() {
        return this.e;
    }

    public boolean i() {
        return this.d;
    }

    public boolean j() {
        return this.worldPosition.equals(this.a);
    }

    public ItemStack k() {
        return this.f;
    }

    public final void a(@NotNull BlockPos blockPos, boolean z) {
    }

    @NotNull
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        CompoundTag updateTag = super.getUpdateTag(provider);
        updateTag.putLong("masterPosition", this.a.asLong());
        updateTag.putBoolean("isConstructed", this.d);
        Optional.ofNullable(g()).ifPresent(vec3i -> {
            updateTag.putIntArray("structureSize", new int[]{vec3i.getX(), vec3i.getY(), vec3i.getZ()});
        });
        return updateTag;
    }

    public void handleUpdateTag(@NotNull CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.handleUpdateTag(compoundTag, provider);
        this.a = BlockPos.ZERO;
        if (compoundTag.contains("masterPosition")) {
            this.a = BlockPos.of(compoundTag.getLong("masterPosition"));
        }
        if (compoundTag.contains("isConstructed") && j()) {
            this.d = compoundTag.getBoolean("isConstructed");
        }
        if (compoundTag.contains("structureSize")) {
            int[] intArray = compoundTag.getIntArray("structureSize");
            this.c = new Vec3i(intArray[0], intArray[1], intArray[2]);
        }
    }

    @MustBeInvokedByOverriders
    protected void saveAdditional(@NotNull CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.saveAdditional(compoundTag, provider);
        if (j()) {
            Optional.ofNullable(e()).ifPresent(blockPos -> {
                compoundTag.putLong("masterPosition", blockPos.asLong());
            });
            Optional.ofNullable(f()).ifPresent(resourceLocation -> {
                compoundTag.putString("structureDefinition", resourceLocation.toString());
            });
            Optional.ofNullable(g()).ifPresent(vec3i -> {
                compoundTag.putIntArray("structureSize", new int[]{vec3i.getX(), vec3i.getY(), vec3i.getZ()});
            });
            ListTag listTag = new ListTag();
            h().forEach(hVar -> {
                listTag.add(hVar.serializeNBT(provider));
            });
            compoundTag.put("unconstructedBlocks", listTag);
            compoundTag.putBoolean("isConstructed", this.d);
            if (!k().isEmpty()) {
                compoundTag.put("activationStack", k().save(provider));
                return;
            }
            return;
        }
        Optional.ofNullable(e()).ifPresent(blockPos2 -> {
            compoundTag.putLong("masterPosition", blockPos2.asLong());
        });
    }

    @MustBeInvokedByOverriders
    protected void loadAdditional(@NotNull CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        this.a = BlockPos.ZERO;
        this.b = null;
        this.c = Vec3i.ZERO;
        this.d = false;
        this.e = new ArrayList();
        if (compoundTag.contains("masterPosition")) {
            this.a = BlockPos.of(compoundTag.getLong("masterPosition"));
        }
        if (compoundTag.contains("structureDefinition")) {
            this.b = ResourceLocation.tryParse(compoundTag.getString("structureDefinition"));
        }
        if (compoundTag.contains("structureSize")) {
            int[] intArray = compoundTag.getIntArray("structureSize");
            this.c = new Vec3i(intArray[0], intArray[1], intArray[2]);
        }
        if (compoundTag.contains("isConstructed")) {
            this.d = compoundTag.getBoolean("isConstructed");
        }
        if (compoundTag.contains("unconstructedBlocks")) {
            compoundTag.getList("unconstructedBlocks", 10).stream().map(tag -> {
                return (CompoundTag) tag;
            }).forEach(compoundTag2 -> {
                this.e.add(new h(provider, compoundTag2));
            });
        }
        if (compoundTag.contains("activationStack")) {
            this.f = (ItemStack) ItemStack.parse(provider, compoundTag.getCompound("activationStack")).orElse(ItemStack.EMPTY);
        }
    }

    @MustBeInvokedByOverriders
    public void onLoad() {
        super.onLoad();
        if (this.level == null || !this.e.isEmpty()) {
        }
    }
}
