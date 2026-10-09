package mctech.blockentities.c;

import mctech.MCTech;
import mctech.init.MCTechTiles;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.blockentities.c.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/z.class */
public class C0079z extends mctech.blockentities.t {
    private final mctech.m.e.j<C0079z> f;

    public C0079z(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.ITEM_DESTROYER.get(), blockPos, blockState);
    }

    public C0079z(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 2);
        this.f = new mctech.m.e.j<>(this);
        this.f.a(mctech.m.g.y.f(0, 1, 2, 3, 4, 5, 6, 7).a(mctech.m.c.r.d));
        this.f.i();
        addGuiFields(this);
        addNetworkFields(this);
    }

    @NotNull
    public BlockEntityType<?> getType() {
        return (BlockEntityType) MCTechTiles.ITEM_DESTROYER.get();
    }

    @Override // mctech.blockentities.t
    public void a() {
        this.c = this.f.g();
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return 0;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new mctech.m.b.Q(this, player, i);
    }

    public ResourceLocation d() {
        return MCTech.loc("textures/gui/container/gui_item_destroyer.png");
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.NONE;
    }

    @Override // mctech.blockentities.q
    public boolean isActive() {
        return true;
    }
}
