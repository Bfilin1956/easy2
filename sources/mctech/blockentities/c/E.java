package mctech.blockentities.c;

import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/E.class */
public class E extends mctech.p.b.a.f implements IMachineTier, GeoBlockEntity {
    private final AnimatableInstanceCache y;

    @NetworkInfo(fieldName = "consumedEnergy")
    @GuiField(fieldName = "consumedEnergy")
    private double z;

    @NetworkInfo(fieldName = "requiredEnergy")
    @GuiField(fieldName = "requiredEnergy")
    private double A;

    @NetworkInfo(fieldName = "producingStack")
    private ResourceLocation B;

    public E(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.MOLECULAR_CONVERTER.get(), blockPos, blockState);
    }

    public E(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 2, 0, mctech.h.a.c.z.b, 0, mctech.h.a.c.z.a, mctech.h.a.c.z.c);
        this.y = GeckoLibUtil.createInstanceCache(this);
        this.B = BuiltInRegistries.ITEM.getKey(Blocks.AIR.asItem());
        this.k = new mctech.m.e.j(this).a(mctech.m.g.y.f(0).a(new mctech.m.c.o(this))).a(mctech.m.g.y.d(1));
        this.k.i();
        addNetworkFields(this);
        addGuiFields(this);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.y;
    }

    @Override // mctech.p.b.a.d
    public DeferredHolder<SoundEvent, SoundEvent> a() {
        return null;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return MCTechRecipes.type(mctech.i.i.MOLECULAR_CONVERTER.getSerializedName());
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new mctech.m.b.X(this, player, i);
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T8;
    }

    public double b() {
        return this.z;
    }

    public double c() {
        return this.A;
    }

    public ItemStack d() {
        if (BuiltInRegistries.ITEM.containsKey(this.B)) {
            return new ItemStack((ItemLike) BuiltInRegistries.ITEM.get(this.B));
        }
        return ItemStack.EMPTY;
    }

    @Override // mctech.p.b.a.f, mctech.api.tiles.readers.IProgressMachine
    public float getProgress() {
        return (float) ((this.z / this.A) * 100.0d);
    }

    @Override // mctech.p.b.a.f, mctech.api.tiles.readers.IProgressMachine
    public float getMaxProgress() {
        return 100.0f;
    }

    @Override // mctech.p.b.b
    @NotNull
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        CompoundTag updateTag = super.getUpdateTag(provider);
        updateTag.putDouble("consumedEnergy", this.z);
        updateTag.putDouble("requiredEnergy", this.A);
        return updateTag;
    }

    @Override // mctech.p.b.a.c, mctech.p.b.b
    public void handleUpdateTag(@NotNull CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.handleUpdateTag(compoundTag, provider);
        this.z = compoundTag.getDouble("consumedEnergy");
        this.A = compoundTag.getDouble("requiredEnergy");
    }
}
