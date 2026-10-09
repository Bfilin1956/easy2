package mctech.processing;

import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.blockentities.l;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechSounds;
import mctech.init.MCTechTiles;
import mctech.m.b.S;
import mctech.m.b.T;
import mctech.m.c.m;
import mctech.m.g.y;
import mctech.u.G;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.registries.DeferredHolder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/processing/d.class */
public class d extends l<RecipeInput, G> {
    public static final int e = 2;
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 0;

    @NetworkInfo(fieldName = "autoSortingEnabled")
    @GuiField(fieldName = "autoSortingEnabled")
    private boolean i;
    private boolean j;

    public d(BlockPos blockPos, BlockState blockState) {
        this(blockPos, blockState, mctech.h.a.c.w.get(blockState.getOptionalValue(MachineTier.PROPERTY).orElse(MachineTier.T2)));
    }

    public d(BlockPos blockPos, BlockState blockState, mctech.h.a.c.n nVar) {
        super((BlockEntityType) MCTechTiles.MACERATOR.get(), blockPos, blockState, nVar.d, nVar.e, nVar.c, nVar.b);
    }

    @Override // mctech.blockentities.k
    public DeferredHolder<SoundEvent, SoundEvent> getWorkingSound() {
        return MCTechSounds.MACERATOR;
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkClientEventListener
    public void onClientDataReceived(Player player, int i, int i2) {
        super.onClientDataReceived(player, i, i2);
        if (i == 0) {
            this.i = !this.i;
            if (this.i && !this.j) {
                this.j = true;
            }
            updateNetworkFields(this);
        }
    }

    public boolean d() {
        return this.i;
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        if (this.i) {
            this.j = true;
        }
        super.setStackInSlot(i, itemStack);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // mctech.blockentities.l
    protected void b() {
        mctech.h.a.c.n nVar = mctech.h.a.c.w.get(machineTier());
        for (int i = 0; i < nVar.a; i++) {
            this.b.add((ProcessingBlock<I, R, l<I, R>>) new ProcessingBlock(this, i));
        }
    }

    @Override // mctech.blockentities.l
    protected void c() {
        mctech.h.a.c.n nVar = mctech.h.a.c.w.get(machineTier());
        this.inventoryManager.a().a(machineTier().isAtLeast(MachineTier.T3) ? 4 : 0);
        for (int i = 0; i < nVar.a; i++) {
            this.inventoryManager.a(y.f((i * 2) + 0).a(new m(this)));
            this.inventoryManager.a(y.d((i * 2) + 1));
        }
        if (machineTier().isAtLeast(MachineTier.T3)) {
            this.inventoryManager.a(this);
        }
        this.inventoryManager.i();
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new T(this, player, i);
    }

    @Override // mctech.blockentities.l, mctech.api.tiles.IRecipeMachine
    public RecipeType<G> getRecipeType() {
        return (RecipeType) MCTechRecipes.MACERATOR.get();
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public float getProgressPerTick() {
        return this.upgradeHandler.a();
    }
}
